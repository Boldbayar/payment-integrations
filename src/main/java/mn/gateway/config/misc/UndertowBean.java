package mn.gateway.config.misc;

import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import io.undertow.server.DefaultByteBufferPool;
import io.undertow.websockets.jsr.WebSocketDeploymentInfo;

@Component
public class UndertowBean
		implements
			WebServerFactoryCustomizer<UndertowServletWebServerFactory> {

	@Override
	public void customize(final UndertowServletWebServerFactory factory) {
		factory.addDeploymentInfoCustomizers(deploymentInfo -> {
			final var webSocketDeploymentInfo = new WebSocketDeploymentInfo();
			webSocketDeploymentInfo
					.setBuffers(new DefaultByteBufferPool(false, 1024));
			deploymentInfo.addServletContextAttribute(
					"io.undertow.websockets.jsr.WebSocketDeploymentInfo",
					webSocketDeploymentInfo);
		});
	}
}
