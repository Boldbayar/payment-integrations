package mn.gateway.config.misc;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "server.servlet.session.cookie")
@Configuration("cookieProperties")
@Getter
@Setter
public class CookieConfiguration {

  private String comment;
  private String domain;
  private String name;
  private String path;

  private boolean httpOnly;
  private boolean secure;
  private Duration maxAge;
}
