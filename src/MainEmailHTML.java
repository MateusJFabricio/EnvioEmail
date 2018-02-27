import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

public class MainEmailHTML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainEmailHTML main = new MainEmailHTML();
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
		HtmlEmail email = new HtmlEmail();
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
		
		
		
		email.setHtmlMsg("\n" + 
				"<html>\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" + 
				"<head>\n" + 
				"    <title>Pudim</title>\n" + 
				"    <link rel=\"stylesheet\" href=\"estilo.css\">\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<div>\n" + 
				"    <div class=\"container\">\n" + 
				"        <div class=\"image\">\n" + 
				"            <img src=\"pudim.jpg\" alt=\"\">\n" + 
				"        </div>\n" + 
				"        <div class=\"email\">\n" + 
				"            <a href=\"mailto:pudim@pudim.com.br\">pudim@pudim.com.br</a>\n" + 
				"        </div>\n" + 
				"    </div>\n" + 
				"</div>\n" + 
				"<script>\n" + 
				"    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" + 
				"                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" + 
				"            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" + 
				"    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" + 
				"\n" + 
				"    ga('create', 'UA-28861757-1', 'auto');\n" + 
				"    ga('send', 'pageview');\n" + 
				"\n" + 
				"</script>\n" + 
				"</body>\n" + 
				"</html>\n" + 
				"");
		
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
