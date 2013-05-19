package org.sic.contract;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:/testContext.xml"})
public class ContractBaseTest extends AbstractJUnit4SpringContextTests{

	@BeforeClass
	public static void init(){
		ApplicationContext context = new ClassPathXmlApplicationContext("/testContext.xml");
		JdbcTemplate  jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		Resource resource = context.getResource("dbinit.sql");
		InputStream input;
		try {
			input = resource.getInputStream();
			String sqlString = IOUtils.toString(input);
			for(String sql: sqlString.split(";")){
				jdbcTemplate.execute(sql);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
