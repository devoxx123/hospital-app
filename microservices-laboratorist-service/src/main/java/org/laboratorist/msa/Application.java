
package org.laboratorist.msa;

import org.laboratorist.msa.service.LaboratoristServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableDiscoveryClient
@SpringBootApplication
//@ComponentScan(basePackages = {"org.laboratorist.msa.service"})
//@EnableJpaRepositories("org.laboratorist.msa.repository")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	    @Bean
	    public LaboratoristServiceImpl laboratoristService() {
	        return new LaboratoristServiceImpl ();
	    }
}
