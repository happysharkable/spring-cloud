package com.springcloud.products.springcloudproducts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
class SpringCloudProductsApplicationTests {

	@Test
	void testOk() {
		Assert.isTrue(true, "ok");
	}

	@Test
	void testOk2() {
		Assert.isTrue(true, "ok");
	}

}
