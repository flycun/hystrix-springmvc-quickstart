package com.imusic.hystrix.quickstart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class HelloWorldCommand {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldCommand.class);

	@HystrixCommand(fallbackMethod = "fallback")
	public String sayHello(String name) {
		/* simulate performing network call to retrieve order */
		try {
			Thread.sleep((int) (Math.random() * 10) + 40);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		/* fail rarely ... but allow failure */
		if ("test".equals(name) || Math.random() > 0.95) {
			throw new RuntimeException("random failure loading information over network");
		}

		return "Hi " + name;
	}

	public String fallback(String name) {
		logger.info("sayHello fallback {}", name);
		return "Hello " + name + "!";
	}
}
