package com.example.projet_mysql;

import com.example.projet_mysql.Repository.UtilisateurRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UtilisateurRepository.class)
public class ProjetMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetMysqlApplication.class, args);
	}

}
