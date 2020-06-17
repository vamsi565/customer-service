package com.vamsi.dev.work.notification;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vami.dev.work.dto.CustomerDTO;

@Service("asyncNotificationService")
public class AsyncNotificationService {
	
    private static ExecutorService threadPool = Executors.newCachedThreadPool();
    
    @Autowired
    @Qualifier("mailSender")
    private JavaMailSender mailSender;

	@Async
	public void sendNotification(CustomerDTO customerDTO){
		threadPool.execute(new Runnable() {
			public void run() {
				MimeMessagePreparator preparator = new MimeMessagePreparator() {
					public void prepare(MimeMessage mimeMessage) throws Exception {

						MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
						message.setTo(customerDTO.getMail());
						message.setFrom("sample@gmail.com", "Sample");
						message.setText("customer created", true);
						message.setSubject("creation");
					}
				};
				try {
					mailSender.send(preparator);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	
}
