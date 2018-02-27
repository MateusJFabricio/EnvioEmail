import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MainEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainEmail main = new MainEmail();
		try {
			Properties prop = main.getProp();
			String login = prop.getProperty("prop.server.login").trim();
			
			String senha = prop.getProperty("prop.server.password").trim();
			
			System.out.println(login);
			System.out.println(senha);
			main.sendEmail(login, senha);
		} catch (EmailException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendEmail(String login, String senha) throws EmailException{
		SimpleEmail email = new SimpleEmail();
		// Utilize o hostname do seu provedor de email
		
		System.out.println("alterando hostname...");
		email.setHostName("smtp.gmail.com");
		//Quando a porta utilizada não é a padrão 
		
		email.setSmtpPort(465);
		//Adicione os destinatarios
		
		email.addTo("fabriciomateus05@gmail.com");
		
		//Configure o seu email do qual enviará
		email.setFrom("aulapraemail@gmail.com", "Mateus Fabricio");
		
		//Adicione um assunto
		
		email.setSubject("Mensagem de testes do Mateus Fabricio");
		
		//Adicione a mensagem de email
		email.setMsg("Teste programa Java");
		
		//Para autenticar no servidor é necessário abaixo
		System.out.println("autenticando....");
		email.setSSL(true);
		
		email.setAuthentication(login, senha);
		
		email.send();
		
		System.out.println("Email enviado!");
	}
	
	public Properties getProp() throws IOException{
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./Properties/dados.properties");
		props.load(file);
		return props;
	}
}
