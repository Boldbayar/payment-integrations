package mn.gateway.config.misc;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableAsync
public class AsyncConfiguration {

	@Bean
	public Executor wishExpireExecutor() {

		log.debug("Creating Async Wish Task Executor");

		final var executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("ExtraThread-");
		executor.initialize();
		return executor;
	}

	@Bean
	public Executor paymentExecutor() {

		log.debug("Creating Async Task Executor");

		final var executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("PaymentThread-");
		executor.initialize();
		return executor;
	}

	@Bean("videoSnipperExecutor")
	public Executor videoSnipperExecutor() {

		log.debug("Creating Async Task Executor");

		final var executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(1000);
		executor.setThreadNamePrefix("VideoThread-");
		executor.initialize();
		executor.setWaitForTasksToCompleteOnShutdown(true);
		return executor;
	}

	@Bean("firebaseExecutor")
	public Executor firebaseExecutor() {

		log.debug("Creating Firebase Async Task Executor");

		final var executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(1000);
		executor.setThreadNamePrefix("Firebase Notification Thread-");
		executor.initialize();
		executor.setWaitForTasksToCompleteOnShutdown(true);
		return executor;
	}

	@Bean(name = "specificTaskExecutor")
	public TaskExecutor specificTaskExecutor() {

		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.initialize();
		return executor;
	}
}
