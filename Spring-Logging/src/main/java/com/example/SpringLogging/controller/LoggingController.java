/**
 * 
 */
package com.example.SpringLogging.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GUR56750
 *
 */
@RestController
public class LoggingController {

	private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

	@GetMapping("/")
	public List<Integer> hello() {
		logger.debug("LoggingController : hello() start");
		List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
		logger.debug("Hello from Logback {}", data);
		logger.debug("LoggingController : hello() end");
		return data;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/hi/{id}")
	public String index(@PathVariable("id") int id) {
		logger.debug("LoggingController : index() start");
		logger.trace("A TRACE Message");
		logger.debug("A DEBUG Message");
		logger.info("An INFO Message");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");
		logger.debug("LoggingController : index() end");
		return "Howdy! Check out the Logs to see the output..." + id;
	}

}
