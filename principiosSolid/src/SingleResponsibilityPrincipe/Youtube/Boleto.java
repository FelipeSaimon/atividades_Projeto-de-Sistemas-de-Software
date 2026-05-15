package SingleResponsibilityPrincipe.Youtube;


// Video SOLID: SRP - Single Responsability Principle (Princípio da Responsabilidade Única)
// Andre Secco
public class Boleto {
    /* ***************** Implememntação incorreta *************** */
    public void gerar(){
        //Logica
    }

    public void enviarEmail(){
    var email = new mailMessage("remetente@co.com", "destinatario@co.com");
    }
    /* ********************************************************** */
}
