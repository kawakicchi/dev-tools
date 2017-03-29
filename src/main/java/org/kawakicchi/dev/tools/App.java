package org.kawakicchi.dev.tools;

import org.apache.velocity.app.VelocityEngine;
import org.kawakicchi.dev.tools.EntityCreator.EntityCreator;
import org.kawakicchi.dev.tools.sample.dao.SampleDao;
import org.kawakicchi.dev.tools.sample.dao.TmSample;
import org.kawakicchi.dev.tools.sample.entity.ColumnEntity;
import org.kawakicchi.dev.tools.sample.entity.TableEntity;
import org.kawakicchi.dev.tools.sample.service.DatabaseService;
import org.seasar.doma.jdbc.Result;
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

	@Autowired
	private SampleDao sampleDao;

	public void exec() {

		TmSample sample = new TmSample(99, "aaa");

		Result<TmSample> result = sampleDao.insert(sample);

		System.out.println(result.getEntity().getSeq());
		System.out.println(result.getEntity().getName());
	}

	public void exec2() {
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
