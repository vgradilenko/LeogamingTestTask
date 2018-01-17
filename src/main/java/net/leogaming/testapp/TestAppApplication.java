package net.leogaming.testapp;

import net.leogaming.testapp.utils.PreparedEntitys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class TestAppApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TestAppApplication.class, args);

		PreparedEntitys entitys = new PreparedEntitys();

		entitys.getService().verify(327, entitys.getPreparedVerifyEntity());

		entitys.getService().payment(327, Collections.singletonList(entitys.getPreparedPaymentEntity()));

		entitys.getService().status(327, Collections.singletonList(entitys.getStatusEntity()));

	}
}
