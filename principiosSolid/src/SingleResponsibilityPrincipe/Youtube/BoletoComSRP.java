package SingleResponsibilityPrincipe.Youtube;

// Video SOLID: SRP - Single Responsability Principle (Princípio da Responsabilidade Única)
// Andre Secco
public class BoletoComSRP {

    // Injetando a dependencia de envio de boleto via email.
    // Neste caso ainda está amarrado a unico metodo de envio podendo considerar um modulo de notificação
    private IEmail email;

    public BoletoComSRP(IEmail email){
        email = email;
    }

    public void gerar(){

        // Apos o boleto ser gerado, chama o metodo de envio do email
        // Sendo assim, a logica de saber enviar email foi delegada a uma classe propria
        email.enviar();
    }
}
