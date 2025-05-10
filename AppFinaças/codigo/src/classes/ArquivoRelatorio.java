package classes;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoRelatorio {
    private static File arquivoExtrato;
    private static FileWriter editor;

    public ArquivoRelatorio() throws IOException {
        arquivoExtrato = new File("arquivosRegistrados\\extrato.txt");
        editor = new FileWriter(arquivoExtrato);
        if (arquivoExtrato.createNewFile()){
            System.out.println("Arquivo criado");
        }
    }

    public void registrarExtratoNoArquivo(Extrato extrato) throws IOException{
        for (int count = 0; count < extrato.getMovimentacoes().size(); count++) {
            editor.write((count + 1) + "- " + extrato.getMovimentacoes().get(count).getDescricao() + " = " + extrato.getMovimentacoes().get(count).getValor() + "\n");
        }
        editor.write("Saldo = " + extrato.getSaldo());
        editor.close();
    }
}
