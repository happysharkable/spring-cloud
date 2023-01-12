package com.springcloud.orders.springcloudorders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
class SpringCloudOrdersApplicationTests {

	@Test
	void testOk() {
		Assert.isTrue(true, "ok");
	}

}
