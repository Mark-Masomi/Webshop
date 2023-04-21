package com.example.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*add the following to your MySql workbench, and you are set to go.
------------------------------------------------------------------
create database Webshop;
CREATE USER 'webshop'@'localhost' identified with mysql_native_password BY '****';
GRANT ALL ON *.* TO 'webshop'@'localhost' with grant option;
------------------------------------------------------------------
*/
@SpringBootApplication
public class WebshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class, args);
    }

}
