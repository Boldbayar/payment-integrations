package mn.gateway.config.props.tdb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "keystore")
public class TDBKeystoreProperties {

  private String type;
  private String fileName;
  private String password;
}
