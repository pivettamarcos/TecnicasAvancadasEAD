package controle;

import visao.JanelaPrincipal;

public class App {
	// m�todo principal da aplica��o
	public static void main(String[] args) {
		JanelaPrincipal janela = new JanelaPrincipal();
		Controlador controle = new Controlador(janela);
		janela.setVisible(true);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null); // centraliza��o na janela no centro da tela
	}
}

