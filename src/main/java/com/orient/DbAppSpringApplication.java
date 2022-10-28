package com.orient;

import com.orient.dao.inter.UserDaoInter;
import com.orient.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DbAppSpringApplication {

	@Autowired
	private UserDaoInter userDao;

	public static void main(String[] args) {
		SpringApplication.run(DbAppSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(){
		CommandLineRunner clr=new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<User> list=userDao.getAll(null,null,null);
				System.out.println(list);
			}
		};
		return clr;
	}


}
