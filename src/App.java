import javax.swing.JOptionPane;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        JOptionPane.showMessageDialog(null,
                "             ⚡ Bem-vindo ao Quiz Random. ⚡\n\n" + 
                "O jogo se baseia em você advinhar os números    \n" 
               +"    certos que serão gerados aleatoriamente.\n\n" + 
                "Será gerado um código aleatório de 4 dígitos.\n\n" +
                "Você terá 5 tentativas para tentar acertar o codigo.             \n\n" + 
                "Quando você acertar os números aparecerá\n" +
                "                            este emoji(👍).\n\n" + 
                "Quando você errar os números aparecerá\n"+ 
                "                            este emoji(👎).\n\n" + 
                "                  🔥 Boa sorte no game. 🔥\n\n" + 
                "   🔥 Que a sorte esteja ao seu lado sempre! 🔥\n",
                "BEM-VINDO AO QUIZ RANDOM", JOptionPane.INFORMATION_MESSAGE);

                //--------------------------------------------------------------------------------------------------------------------------------------------------//

            int[] respostaUsuario, numeroAleatorio = blocoGerador();
            int tentativas = 0;
            String [] emojiCerto = {"", "", "", ""};

            do {
                tentativas++;
                respostaUsuario = usuarioArray();
                
                if (Arrays.equals(numeroAleatorio, respostaUsuario)){ //SE CASO A RESPOSTA DO USUÁRIO ESTIVER TOTALMENTE CERTA!
                    JOptionPane.showMessageDialog(null, "   🔥 VOCÊ ACERTOU A SENHA! 🔥\n 🔥 PARABÉNS VOCÊ É UM GÊNIO 🔥", "🔥 VOCÊ É O MELHOR! 🔥", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                else if (tentativas == 5){
                    JOptionPane.showMessageDialog(null, "VOCÊ EXCEDEU O LIMITE DE TENTATIVAS\n     TENTE NOVAMENTE MAIS TARDE", "NÚMERO DE TENTATIVAS EXCEDIDO!", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                else{ //CASO A RESPOSTA DO USUÁRIO ESTIVER ERRADA!
                    for (int i = 0; i < numeroAleatorio.length; i++) {
                        if (numeroAleatorio[i] == respostaUsuario[i]){
                            emojiCerto[i] = "👍";
                        } else {
                            emojiCerto[i] = "👎";
                        }
                    }
                    JOptionPane.showMessageDialog(null,"   Codigo digitado : "+respostaUsuario[0]+respostaUsuario[1]+respostaUsuario[2]+respostaUsuario[3]+"\n"+
                            "                 " +respostaUsuario[0]+ "  está  " +emojiCerto[0]+ "\n"+
                            "                 " +respostaUsuario[1]+ "  está  " +emojiCerto[1]+ "\n"+
                            "                 " +respostaUsuario[2]+ "  está  " +emojiCerto[2]+ "\n"+
                            "                 " +respostaUsuario[3]+ "  está  " +emojiCerto[3]+ "\n",
                            "QUIZ RANDOM",1);
                }
            } while (!Arrays.equals(respostaUsuario, numeroAleatorio) || tentativas < 6);
    }

    // ----------------------------------------------------------BlOCO GERADOR DE NÚMEROS ALEATÓRIO---------------------------------------------------//
    public static int[] blocoGerador() {
        int codAlet;
        int[] senhaCerta;
        String codAlet2;

        do {
            codAlet = (int) Math.round(Math.random() * 9999);
        } while (codAlet < 999);

        codAlet2 = Integer.toString(codAlet);
        senhaCerta = new int[codAlet2.length()];

        for (int i = 0; i < senhaCerta.length; i++) {
            senhaCerta[i] = codAlet % 10;
            codAlet = (codAlet - senhaCerta[i]) / 10;
        }
        for (int i = 0; i < senhaCerta.length; i++) {
            System.out.println(senhaCerta[i]);
        }
        return senhaCerta;
    }

    // ----------------------------------------------------------BlOCO TRANSFORMADOR DA RESPOSTA DO USUÁRIO EM ARRAY---------------------------------------------------//

    public static int[] usuarioArray() {
        int numUsuario;
        int[] numUsuarioCerto;  
        String usuarioString;

        usuarioString = JOptionPane.showInputDialog(null, "                 Digite a senha: ", "                     🔥 TENTE ACERTAR A SENHA 🔥", JOptionPane.INFORMATION_MESSAGE);  
        numUsuario = Integer.parseInt(usuarioString);
        numUsuarioCerto = new int[usuarioString.length()];
        for (int i = numUsuarioCerto.length-1; i >= 0; i--) {
            numUsuarioCerto[i] = numUsuario % 10;
            numUsuario = (numUsuario - numUsuarioCerto[i]) / 10;
        }
        return numUsuarioCerto;
    }
}
