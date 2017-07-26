package br.com.produto.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration//faz configurações automaticas ao criar beans com padroes de testes
@EntityScan(basePackages = {"br.com.produto.models"})//procura pacote de entidades
@EnableJpaRepositories(basePackages = {"br.com.produto.repositories"})//permite a configuração automatica do Spring Data JPA
@EnableTransactionManagement//Permite gerenciamento de transações impulsionadas por anotações da Spring
public class RepositoryConfiguration {
	
}
