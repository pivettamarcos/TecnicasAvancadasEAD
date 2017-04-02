package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import visao.JanelaPrincipal;

// classe respons�vel pela implementa��o das a��es dos bot�es
public class Controlador implements ActionListener {
	private JanelaPrincipal jan;
	
	public Controlador(JanelaPrincipal j) {
		this.jan = j;
		adicionaListeners();
	}
	// registro dos listeners no objeto-fonte para o controle n�o ser feito na interface gr�fica
	public void adicionaListeners() {
		this.jan.getMntmSair().addActionListener(this);
		this.jan.getBtnSomar().addActionListener(this);
		this.jan.getBtnLimpar().addActionListener(this);
	}
	// c�lculo da soma, lembrando que as informa��es v�m de textFields, ou seja, precisam ser convertidas para inteiro
	public int calculaSoma() {
		int num1 = Integer.parseInt(jan.getTxtPrimeiroNum().getText());
		int num2 = Integer.parseInt(jan.getTxtSegundoNum().getText());
		int soma = num1 + num2;
		return soma;
	}
	
	// Implementa��o dos bot�es (Limpar, Somar e Sair)
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("Limpar")) {
			jan.limparCampos();
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Somar")) {
			try {
				int resultado = calculaSoma();
				jan.getTxtResultado().setText(String.valueOf(resultado));
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Digite dois n�meros inteiros para realizar a soma!");
				jan.limparCampos();
			}
			
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Sair")) {
			System.exit(0);
		}
	}
}
