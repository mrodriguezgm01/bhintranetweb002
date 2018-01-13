package pe.bhintranet.task;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import javax.net.ssl.SSLSocketFactory;
        
@Configuration
public class SpringMailConfig {

    @Bean
    @Lazy
    public JavaMailSenderImpl mailSender() {
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        JavaMailSenderImpl javaMail = new JavaMailSenderImpl();
        javaMail.setPort(465);
        javaMail.setHost("smtp.gmail.com");
        javaMail.setUsername("mrodriguezgm01@gmail.com");
        javaMail.setPassword("eliane05$$$&");
        javaMail.setProtocol("smtps");

        Properties properties = new Properties();
        properties.setProperty("mail.smtps.auth", "true");
        properties.setProperty("mail.smtps.socketFactory.class", SSL_FACTORY);
        properties.setProperty("mail.smtps.socketFactory.fallback", "false");
        properties.setProperty("mail.smtps.auth", "true");                   
        properties.setProperty("mail.smtps.quitwait", "false");
        properties.setProperty("mail.smtps.starttls.enable", "true");         
        

        System.out.println("Conectado para enviar MOISES...");

        javaMail.setJavaMailProperties(properties);
        return javaMail;
    }
}
