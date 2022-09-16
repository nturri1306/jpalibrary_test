package it.csa.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import it.csa.jpalibrary.MyFactoryBean;
import it.csa.jpalibrary.User;





@ComponentScan({"it.csa.jpalibrary"})

@SpringBootApplication()
public class Demo2Application implements CommandLineRunner {
	

    private static MyFactoryBean myService ;

    

    public  Demo2Application(MyFactoryBean myFactoryBean) {

   	 LOG.info("inizio init");
   	 
    	
    	myService = myFactoryBean;
    	
    
   	 LOG.info("fine init");

    }
	
    private static Logger LOG = LoggerFactory
    	      .getLogger(Demo2Application.class);
    

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	
	
	 public void run(String... args) {
		 
		 LOG.info("inizio run");
		 
		 User user = new User();
			
			user.setId(1);
			user.setName("nicola");
			user.setEmail("nturri1306@gmail.com");
			
			myService.GetUserRepository().save(user);
		 
	     
			 LOG.info("utenti: "+  myService.GetUserRepository().findAll().size());
		 
		 
		 LOG.info("fine run");
		 
	     
	    }
	

}
