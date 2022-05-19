package cibele.teste;

public class Principal {
	public static void main(String[] args) {

		Banheiro banheiro = new Banheiro();

		// Passando a tarefa e o nome do Thread
		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Jo�o");
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
		//outros threads
		Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Maria");
		Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Ana");

		convidado1.start();
		convidado2.start();
		convidado3.start();
		convidado4.start();
	}
}