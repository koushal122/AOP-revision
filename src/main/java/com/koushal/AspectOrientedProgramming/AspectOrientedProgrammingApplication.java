package com.koushal.AspectOrientedProgramming;

import com.koushal.AspectOrientedProgramming.BussinessLogic.BussinessLogicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AspectOrientedProgrammingApplication implements CommandLineRunner {
	private Logger log;
	private BussinessLogicService bussinessLogicService;
	AspectOrientedProgrammingApplication(BussinessLogicService bussinessLogicService){
		this.bussinessLogicService=bussinessLogicService;
		log= LoggerFactory.getLogger(getClass());
	}
	public static void main(String[] args) {
		SpringApplication.run(AspectOrientedProgrammingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Maximum value is -> "+bussinessLogicService.getMax());
	}
}
