import java.util.List;

public class ExportacaoServico {

    public void exportarTudo(List<Exportavel> itens) {
        System.out.println("Exportando dados do sistema:");

        int contador = 0;
        for (Exportavel item : itens) {
            contador++;
            System.out.print(contador + ") ");
            item.exportarDados();
        }

        System.out.println("total exportado: " + contador);
    }
}
