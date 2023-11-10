import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limite = entrada.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while(sair != 0)
        {
            System.out.println("Digite a descrição da compra: ");
            String descricao = entrada.next();

            System.out.println("Digite o valor da sua compra: ");
            double valor = entrada.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada)
            {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = entrada.nextInt();
            } else {
                System.out.println("Saldo insuficiente");
                sair = 0;
            }
        }

        System.out.println("************************************");
        System.out.println("COMPRAS REALIZADAS: \n");

        Collections.sort(cartao.getCompras());

        for (Compra c : cartao.getCompras())
        {
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }
        System.out.println("\n************************************");

        System.out.println("\nSaldo do cartão: " + cartao.getSaldo());
    }
}