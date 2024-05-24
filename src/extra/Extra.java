package extra;


/*
 * De acordo com o a documentação, a velocidade de StringBuffer esta atrelada a sua mutabilidade,
 * o contrario acontece com a String, que é imutavel, então a cada concatenacao, é retornada uma 
 * nova String, enquanto a mutabilidade permite alterações no próprio espaco alocado para o Objeto.
 */

public class Extra {
    
	public static void main(String[] args) {
        
		int iteracoes = 10000;
        long start, end;
        
        start = System.currentTimeMillis();
        String str = "";
        
        for (int i = 0; i < iteracoes; i++) {
            str += "OlaMundo";
        }
        
        end = System.currentTimeMillis();
        System.out.println("Tempo para concatenacao de String: " + (end - start) + " ms");
        
        start = System.currentTimeMillis();
        
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iteracoes; i++) {
            stringBuffer.append("OlaMundo");
        }
        
        end = System.currentTimeMillis();
        System.out.println("Tempo para concatencao de StringBuffer: " + (end - start) + " ms");
    }
}

