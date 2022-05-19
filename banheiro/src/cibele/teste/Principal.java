package cibele.teste;

public class Principal {

	public static void main(String[] args) {

		Banheiro banheiro = new Banheiro();

		// Passando a tarefa e o nome do Thread
		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Jo�o");
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
		Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Funcion�rio");
		limpeza.setDaemon(true); //faz com que a thread limpeza dependa de outras threads
		
		limpeza.start();
		convidado1.start();
		convidado2.start();
	}
}