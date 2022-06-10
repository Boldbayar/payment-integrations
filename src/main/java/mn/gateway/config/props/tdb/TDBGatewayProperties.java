package mn.gateway.config.props.tdb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "tdb.gateway")
public class TDBGatewayProperties {
	private String url;
}
