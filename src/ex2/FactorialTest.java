package ex2;

import org.junit.jupiter.api.Test;

import ex1.*;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.*;

import javax.swing.SwingUtilities;

/*
 * O teste é semi-automatizado. Como optamos pela exição de um Pop-Up para as mensagens de erro,
 * é necessário que ele seja fechado para prosseguimento dos testes.
 */

public class FactorialTest {
	
	static JLabel result;
	static JTextField input;
	static FactorialView view; 
	static JButton button;
	
	@BeforeEach 
	public void setUp() {
    	view = new FactorialView();
        input = view.getTextField();
        button = view.getButton();
    	result = view.getLabel();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 view.setVisible(true);
            }
        });
	}
	
    @Test
    public void TestFac5() throws InterruptedException{
    	input.setText("5");
    	button.doClick();
    	Thread.sleep(1000);
        assertEquals("Resultado: 120", result.getText());
    }
    
    @Test
    public void TestFacNeg() throws InterruptedException{
    	input.setText("-2");
    	button.doClick();
		Thread.sleep(1000);
        assertEquals("Erro de Entrada", view.getError());
    }
    
    @Test
    public void TestFacInvalido() throws InterruptedException{
    	input.setText("abc");
    	button.doClick();
		Thread.sleep(1000);
        assertEquals("Por favor, insira um número inteiro válido.", view.getError());
    }
    
    @Test
    public void TestFac0() throws InterruptedException{
    	input.setText("0");
    	button.doClick();
		Thread.sleep(1000);
        assertEquals("Resultado: 1", result.getText());
    }
        
}