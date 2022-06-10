package mn.gateway.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class UrlUtils {

  private UrlUtils() {}

  public String getURLWithContextPath(final HttpServletRequest request) {
    final StringBuilder url =
        new StringBuilder()
            .append(request.getScheme())
            .append("://")
            .append(request.getServerName());
    if (request.getServerPort() != 80) {
      url.append(":").append(request.getServerPort());
    }
    url.append(request.getContextPath());
    return url.toString();
  }

  public String getPrivacyUrl(final HttpServletRequest request) {
    return this.getURLWithContextPath(request) + "/content/privacy";
  }

  public String getTermsUrl(final HttpServletRequest request) {
    return this.getURLWithContextPath(request) + "/content/terms";
  }
}
