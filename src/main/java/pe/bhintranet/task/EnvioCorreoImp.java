package pe.bhintranet.task;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EnvioCorreoImp implements EnvioCorreo {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    @Scheduled(cron = "0 1 1 * * *")
    public void mailNotificacion() {
        try {

            MimeMessage mimeMessage = this.mailSender.createMimeMessage();

            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
// MRM.14.03.2017            
            message.setSubject("Email de Prueba");
            message.setFrom("mrodriguezgm01@gmail.com");
            message.setTo("moises.rodriguez@boldhouse.pe");

            message.setText("Mail de prueba.", true);

            System.out.println("Conectado para enviar...");
            this.mailSender.send(mimeMessage);
            
            System.out.println("correo enviado");
            
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }

    }
}
