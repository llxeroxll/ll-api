package br.com.llapi.config;

import lombok.Getter;
import lombok.Setter;

//@ConfigurationProperties(ignoreUnknownFields = true)
@Getter
@Setter
public class Propriedades {

	public class DataSource{
		
        public String url;

        public String username;

        public String password;

	}
        @Getter
        @Setter
        public class Authentication{

             public String username;

             public String password;

             private String host;

             private String databaseName;

             private Boolean sqlAuthentication = true;
             
             private long socketTimeout;

             public Sql sql = new Sql();

        }
        
        @Getter
        @Setter
        public class Sql{

             public String driverClassName;

             public String username;

             public String password;

        }
        
        @Getter
        @Setter
        public class Emissores{

             public String adDriverClassName;

             public String sqlDriverClassName;

        }

	
	
}
