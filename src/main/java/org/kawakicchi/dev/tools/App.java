package org.kawakicchi.dev.tools;

import org.apache.velocity.app.VelocityEngine;
import org.kawakicchi.dev.tools.EntityCreator.EntityCreator;
import org.kawakicchi.dev.tools.sample.entity.ColumnEntity;
import org.kawakicchi.dev.tools.sample.entity.TableEntity;
import org.kawakicchi.dev.tools.sample.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args)) {
			App app = ctx.getBean(App.class);
			app.exec();
		}
	}

	@Autowired
	private DatabaseService service;

	@Autowired
	private VelocityEngine velocityEngine;

	public void exec() {
		TableEntity table = service.getTable("public", "tm_account");

		System.out.println(table.getName());
		System.out.println(table.getComment());
		for (ColumnEntity column : table.getColumns()) {
			System.out.println(column.getName());
			System.out.println(column.getComment());
		}

		EntityCreator creator = new EntityCreator(velocityEngine);

		// String value = creator.generateEntity(table);
		String value = creator.generateDoma(table);

		System.out.println(value);
	}
}
