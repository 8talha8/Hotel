package hotelrooms;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication
public class HotelRoomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRoomsApplication.class, args);
	}
	
	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }

	 private static final String MONGO_DB_URL = "localhost";
	    private static final String MONGO_DB_NAME = "RoomDb";
	    @Bean
	    public MongoTemplate mongoTemplate() throws IOException {
	        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
	        mongo.setBindIp(MONGO_DB_URL);
	        MongoClient mongoClient = mongo.getObject();
	        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
	        return mongoTemplate;
	    }


}
