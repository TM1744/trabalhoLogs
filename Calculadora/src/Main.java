import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Logger logger = Logger.getLogger(Main.class.getName());
		try{
				LogManager.getLogManager().reset();
				FileHandler fileHandler = new FileHandler("Logs/log.log");
				fileHandler.setFormatter(new SimpleFormatter());
				logger.addHandler(fileHandler);
			} catch(IOException e) {
				logger.severe("Não foi possível configurar arquivo.log");
			}
		
		int escolha = 1;
		
		do {
			System.out.println(
					"O que deseja fazer?\n" +
					"1 - Fazer soma\n" + 
					"2 - Fazer subtração\n" +
					"3 - Fazer divisão\n" + 
					"4 - Fazer multiplicação\n" +
					"0 - Sair\n");
			escolha = scanner.nextInt();
			int a = 0;
			int b = 0;
			
			if (escolha >= 1 && escolha <= 4) {
				System.out.println("Informe o primeiro número:");
				int a = scanner.nextInt();

				System.out.println("Informe o segundo número:");
				int b = scanner.nextInt();

			switch(escolha) {
			case 1:
				a = 0;
				b = 0;
				System.out.println("Informe o primeiro número");
				a = scanner.nextInt();
				System.out.println("Informe o segundo número");
				b = scanner.nextInt();
				System.out.println("Seu resultado é: " + (a + b)+ "\n\n");
				logger.info("Soma realizada");
				break;
				
			case 2:
				a = 0;
				b = 0;
				System.out.println("Informe o primeiro número");
				a = scanner.nextInt();
				System.out.println("Informe o segundo número");
				b = scanner.nextInt();
				System.out.println("Seu resultado é: " + (a - b)+ "\n\n");
				logger.info("subtração realizada");
				break;
				
			case 3:
				a = 0;
				b = 0;
				System.out.println("Informe o primeiro número");
				a = scanner.nextInt();
				System.out.println("Informe o segundo número");
				b = scanner.nextInt();
				if(b == 0) {
					System.out.println("Não é possível dividir por zero");
					logger.severe("Divisão por zero");
				} else {
					System.out.println("Seu resultado é: " + (a / b)+ "\n\n");
					logger.info("Divisão realizada");
					break;
				}
			case 4:
				a = 0;
				b = 0;
				System.out.println("Informe o primeiro número");
				a = scanner.nextInt();
				System.out.println("Informe o segundo número");
				b = scanner.nextInt();
				System.out.println("Seu resultado é: " + (a * b)+ "\n\n");
				logger.info("Multiplicação realizada");
				break;
				
			case 0:
				System.out.println("Saindo...");
				break;
			}

		}
	}

}
