package ex1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class FactorialView extends JFrame {
    private static JFrame frame;
    private static JTextField inputField;
    private static JTextArea resultArea;
    private static JButton calculateButton;
    private static JLabel resultLabel;
    private FactorialController controller;
    String erro;

    public FactorialView() {
        controller = new FactorialController();
        configuraJanela();
        configuraEntrada();
        configuraSaida();
        configuraBotao();
        configuraRotulo();
    }

    public void configuraJanela(){
        frame = new JFrame("Calculadora de Fatorial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);
    
        // Torna a janela visível
        frame.setVisible(true);
    }

    public void configuraEntrada(){
        inputField = new JTextField();
        inputField.setBounds(50, 30, 200, 30);
        frame.add(inputField);
    }
    
    public void configuraSaida() {
    	resultArea = new JTextArea(5, 30);
    	resultArea.setLineWrap(true);
    	resultArea.setWrapStyleWord(true);
    	resultArea.setEditable(false);
    }

    public void configuraBotao(){
        calculateButton = new JButton("Calcular Fatorial");
        calculateButton.setBounds(50, 70, 200, 30);
        frame.add(calculateButton);

        // Adiciona ação ao botão
        calculateButton.addActionListener(new BotaoEscuta());
    }

    public void configuraRotulo(){
        resultLabel = new JLabel("Resultado:");
        resultLabel.setBounds(50, 110, 200, 30);
        frame.add(resultLabel);
    }
    
    public JFrame getFrame() {
    	return this.frame;
    }
    
    public JTextArea getResultArea() {
    	return this.resultArea;
    }
    
    public JTextField getTextField() {
    	return this.inputField;
    }

    public JButton getButton() {
    	return this.calculateButton;
    }
    
    public JLabel getLabel() {
    	return this.resultLabel;
    }

    public String getError() {
    	return this.erro;
    }
    private class BotaoEscuta implements ActionListener{
        public BotaoEscuta() {
        }

        private int readNum() {
    	    String inputText = inputField.getText();
            int n = Integer.parseInt(inputText);
    	    return n;
        }
     
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
            	int number = readNum();
                BigInteger result = controller.calculateFactorial(number);
                resultLabel.setText("Resultado: " + result.toString());
            }
            catch (NumberFormatException ex) {
            	erro = "Por favor, insira um número inteiro válido.";
                JOptionPane.showMessageDialog(FactorialView.this, 
                		erro, "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }
            catch (IllegalArgumentException ex) {
            	erro = "Erro de Entrada";
                JOptionPane.showMessageDialog(FactorialView.this, ex.getMessage(), 
                		"Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FactorialView().setVisible(true);
            }
        });
    
    }
}