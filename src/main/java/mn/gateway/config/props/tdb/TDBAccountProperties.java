package mn.gateway.config.props.tdb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "tdb.account")
public class TDBAccountProperties {

	private String currency;
	private String journal;
	private boolean testingEnvironment;
}
