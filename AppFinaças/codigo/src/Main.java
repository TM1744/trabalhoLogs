import classes.ArquivoRelatorio;
import classes.Extrato;
import classes.Movimentacao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {
        controle();
    }

    public static void controle() {
        try {
            Logger logger = Logger.getLogger(Main.class.getName());
            LogManager.getLogManager().reset();
            FileHandler fileHandler = new FileHandler("arquivosLogs\\logs.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            ArquivoRelatorio arquivoRelatorio = new ArquivoRelatorio();
            Extrato extrato = new Extrato();
            Scanner scanner = new Scanner(System.in);
            String menu =
                    """
                            ------------------- Menu ----------------------
                            0 - Sair do sistema                           \s
                            1 - Adicionar Movimentação                    \s
                            2 - Retirar Movimentação                      \s
                            3 - Ver Extrato                               \s
                            4 - Imprimir/Alterar Extrato                  \s
                            5 - Resetar Registro                          \s
                            -----------------------------------------------
                            """;

            int seletor = 1;

            while (seletor != 0) {
                System.out.println(menu);
                try {
                    seletor = scanner.nextInt();
                    switch (seletor) {
                        case 0:
                            logger.info("Encerramento");
                            System.out.println("Saindo do programa...");
                            break;
                        case 1:
                            System.out.println("Informe nome:");
                            String d = scanner.next();
                            System.out.println("Informe valor:");
                            float v = scanner.nextFloat();
                            logger.info("Movimentação-Nome|" + d + "-Valor|" + v + "-Adicionado");
                            extrato.adicionarMovimentacao(new Movimentacao(d, v));
                            extrato.atualizarSaldo();
                            break;

                        case 2:
                            System.out.println("As seguintes movimentações foram feitas: ");
                            extrato.apresentarMovimentacao();
                            System.out.println("Selecione o número correspondente à movimentação para retirá-la:\n");
                            int index = (scanner.nextInt() - 1);
                            Movimentacao movimentacao = new Movimentacao(extrato.getMovimentacao(index));
                            logger.info("Movimentação-Nome|" + movimentacao.getDescricao() + "-Valor|" + movimentacao.getValor() + "-Retirada");
                            extrato.retirarMovimentacao(index);
                            extrato.atualizarSaldo();
                            break;

                        case 3:
                            logger.info("Extrato-Solicitado");
                            System.out.println("Movimentação:");
                            extrato.apresentarMovimentacao();
                            System.out.println("Saldo = " + extrato.getSaldo());
                            break;

                        case 4:
                            arquivoRelatorio.registrarExtratoNoArquivo(extrato);
                            logger.info("ArquivoExtrato-Registrado");
                            break;

                        case 5:
                            for (int i = extrato.getMovimentacoes().size() - 1; i >= 0; i--) {
                                extrato.retirarMovimentacao(i);
                            }
                            extrato.atualizarSaldo();
                            logger.info("ArquivoExtrato-Resetado");
                            break;

                        default:
                            logger.warning("SeleçãoOperação-ValorInválido");
                            System.out.println("Valor informado não corresponde às opções...");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor informado não corresponde ao que é pedido...");
                    scanner.nextLine();
                }
            }
        }catch (IOException e){
            System.err.println("Erro ao criar arquivo");
        }
    }
}
