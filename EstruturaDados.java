interface Estrutura {
    void adicionar(int valor);
    void remover(int valor);
    void exibir();
}


class EstruturaArray implements Estrutura {
    private int[] array;
    private int tamanho;
    private int capacidade;

    public EstruturaArray(int capacidade) {
        this.capacidade = capacidade;
        this.array = new int[capacidade];
        this.tamanho = 0;
    }

    @Override
    public void adicionar(int valor) {
        if (tamanho < capacidade) {
            array[tamanho++] = valor;
        } else {
            System.out.println("Array está cheio!");
        }
    }

    @Override
    public void remover(int valor) {
        int indice = -1;
        for (int i = 0; i < tamanho; i++) {
            if (array[i] == valor) {
                indice = i;
                break;
            }
        }
        if (indice != -1) {
            for (int i = indice; i < tamanho - 1; i++) {
                array[i] = array[i + 1];
            }
            tamanho--;
        } else {
            System.out.println("Valor não encontrado no array.");
        }
    }

    @Override
    public void exibir() {
        System.out.print("Array: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}


class EstruturaListaLigada implements Estrutura {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    @Override
    public void adicionar(int valor) {
        Node novoNo = new Node(valor);
        if (head == null) {
            head = novoNo;
        } else {
            Node atual = head;
            while (atual.next != null) {
                atual = atual.next;
            }
            atual.next = novoNo;
        }
    }

    @Override
    public void remover(int valor) {
        if (head == null) {
            System.out.println("Lista vazia!");
            return;
        }

        if (head.data == valor) {
            head = head.next;
            return;
        }

        Node atual = head;
        while (atual.next != null && atual.next.data != valor) {
            atual = atual.next;
        }

        if (atual.next != null) {
            atual.next = atual.next.next;
        } else {
            System.out.println("Valor não encontrado na lista.");
        }
    }

    @Override
    public void exibir() {
        System.out.print("Lista Encadeada: ");
        Node atual = head;
        while (atual != null) {
            System.out.print(atual.data + " ");
            atual = atual.next;
        }
        System.out.println();
    }
}


class GerenciadorEstruturas {
    private Estrutura estrutura;

    public void setEstrategia(Estrutura estrutura) {
        this.estrutura = estrutura;
    }

    public void adicionar(int valor) {
        if (estrutura != null) {
            estrutura.adicionar(valor);
        } else {
            System.out.println("Nenhuma estrutura selecionada!");
        }
    }

    public void remover(int valor) {
        if (estrutura != null) {
            estrutura.remover(valor);
        } else {
            System.out.println("Nenhuma estrutura selecionada!");
        }
    }

    public void exibir() {
        if (estrutura != null) {
            estrutura.exibir();
        } else {
            System.out.println("Nenhuma estrutura selecionada!");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        GerenciadorEstruturas gerenciador = new GerenciadorEstruturas();

     
        System.out.println("Usando Array:");
        EstruturaArray array = new EstruturaArray(5);
        gerenciador.setEstrategia(array);
        gerenciador.adicionar(10);
        gerenciador.adicionar(20);
        gerenciador.adicionar(30);
        gerenciador.exibir();
        gerenciador.remover(20);
        gerenciador.exibir();

        System.out.println("\nUsando Lista Encadeada:");
        EstruturaListaLigada lista = new EstruturaListaLigada();
        gerenciador.setEstrategia(lista);
        gerenciador.adicionar(100);
        gerenciador.adicionar(200);
        gerenciador.adicionar(300);
        gerenciador.exibir();
        gerenciador.remover(200);
        gerenciador.exibir();
    }
}

/* Encapsulamento
As classes EstruturaArray e EstruturaListaLigada encapsulam seus detalhes internos.
O acesso aos dados se dá por meio de métodos públicos (adicionar(), remover(), exibir()).

Herança e Interface
Criamos a interface Estrutura para garantir que ambas as classes (EstruturaArray e EstruturaListaLigada) sigam um mesmo conjunto de métodos.

Polimorfismo
A classe GerenciadorEstruturas aceita qualquer estrutura que implemente a interface Estrutura, permitindo alternar entre array e lista ligada dinamicamente.
 */

 /*Nicole Cândido
  202310828
  */