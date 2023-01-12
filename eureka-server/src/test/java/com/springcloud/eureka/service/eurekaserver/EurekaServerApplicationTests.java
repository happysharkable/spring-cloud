package com.springcloud.eureka.service.eurekaserver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
class EurekaServerApplicationTests {

	@Test
	void testOk() {
		Assert.isTrue(true, "ok");
	}
	
	@Test
	void testOk2() {
		Assert.isTrue(true, "ok");
	}
	
	@Test
	void testFail() {
		Assert.isTrue(false, "ok");
	}

}
