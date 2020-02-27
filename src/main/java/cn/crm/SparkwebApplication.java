package cn.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "cn.crm.mapper")
public class SparkwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparkwebApplication.class, args);
	}
}
