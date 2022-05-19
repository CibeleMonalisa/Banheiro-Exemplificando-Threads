package cibele.teste;

public class Banheiro {
	
	public void Numero1() {
		
//currentThread me devolve o thread atual sendo executado e assim é possivel pegar o nome
	    String nome = Thread.currentThread().getName();

	    System.out.println(nome + " batendo na porta");
		
//synchronizer diz que estas tarefas não podem ser executadas em paralelo (um thread depois o outro)
	    synchronized (this) {

	        System.out.println(nome + " entrando no banheiro");
	        System.out.println(nome + " fazendo coisa rapida");

	        try {
	            Thread.sleep(8000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println(nome + " dando descarga");
	        System.out.println(nome + " lavando a mao");
	        System.out.println(nome + " saindo do banheiro");
	    }
	}

	public void Numero2() {

	    String nome = Thread.currentThread().getName();

	    System.out.println(nome + " batendo na porta");

	    synchronized (this) {

	        System.out.println(nome + " entrando no banheiro");
	        System.out.println(nome + " fazendo coisa demorada");

	        try {
	            Thread.sleep(15000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println(nome + " dando descarga");
	        System.out.println(nome + " lavando a mao");
	        System.out.println(nome + " saindo do banheiro");
	    }
	}
}
