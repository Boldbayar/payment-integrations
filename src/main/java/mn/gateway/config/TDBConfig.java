package mn.gateway.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mn.gateway.config.props.tdb.TDBKeystoreProperties;

@Slf4j
@Configuration
public class TDBConfig {

  private final TDBKeystoreProperties tdbKeystoreProperties;

  public TDBConfig(final TDBKeystoreProperties tdbKeystoreProperties) {
    this.tdbKeystoreProperties = tdbKeystoreProperties;
  }

  @Bean("tdb-rest")
  public RestTemplate getRestTemplate()
      throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException,
          UnrecoverableKeyException, KeyManagementException {

    final var clientStore = KeyStore.getInstance(this.tdbKeystoreProperties.getType());

    final var keyStorePassword = this.tdbKeystoreProperties.getPassword();
    final var classLoader = TDBConfig.class.getClassLoader();
    final var inputStream =
        classLoader.getResourceAsStream(this.tdbKeystoreProperties.getFileName());
    clientStore.load(inputStream, keyStorePassword.toCharArray());

    TDBConfig.log.info("[TDB Rest Bean] : Preparing ssl connection ...");

    final var sslContextBuilder = new SSLContextBuilder();
    sslContextBuilder.loadKeyMaterial(clientStore, keyStorePassword.toCharArray());
    sslContextBuilder.loadTrustMaterial(new TrustSelfSignedStrategy());

    final var sslConnectionSocketFactory =
        new SSLConnectionSocketFactory(sslContextBuilder.build(), NoopHostnameVerifier.INSTANCE);

    final var httpClient =
        HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();

    final var requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    requestFactory.setConnectTimeout(1200000);
    requestFactory.setReadTimeout(1200000);

    final var restTemplate = new RestTemplate(requestFactory);

    final List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
    restTemplate.setMessageConverters(messageConverters);

    TDBConfig.log.info("[TDB Rest Bean] : Calling service ...");

    return restTemplate;
  }
}
