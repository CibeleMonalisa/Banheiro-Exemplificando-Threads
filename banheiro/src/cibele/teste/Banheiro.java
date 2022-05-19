package cibele.teste;

public class Banheiro {

	private boolean estaSujo = true;

	public void Numero1() {
		//currentThread me devolve o thread atual sendo executado e assim é possivel pegar o nome
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");

		//synchronizer diz que estas tarefas não podem ser executadas em paralelo (um thread depois o outro)
		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			
			while (this.estaSujo) { //novo, trocando if com while
	            espera(nome);
	        }
			
			System.out.println(nome + " fazendo coisa rapida");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.estaSujo = true;
			
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
			
			while (this.estaSujo) { //novo, trocando if com while
	            espera(nome);
	        }
			
			System.out.println(nome + " fazendo coisa demorada");

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.estaSujo = true;

			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mao");
			System.out.println(nome + " saindo do banheiro");
		}
	}
	
	public void limpa() {

	    String nome = Thread.currentThread().getName();
	    System.out.println(nome + " batendo na porta");

	    synchronized (this) {

	        System.out.println(nome + " entrando no banheiro");

	        if (!this.estaSujo) {
	            System.out.println(nome + ", não está sujo, vou sair");
	            return;
	        }

	        System.out.println(nome + " limpando o banheiro");
	        this.estaSujo = false;

	        try {
	            Thread.sleep(13000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        this.notifyAll();

	        System.out.println(nome + " saindo do banheiro");
	    }
	}

	private void espera(String nome) {

		System.out.println(nome + " O banheiro está sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
