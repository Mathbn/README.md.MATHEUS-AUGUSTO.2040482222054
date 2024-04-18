import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Character {
    private String name;
    private int health;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.health = 100; // Inicializa a saúde do personagem
        this.inventory = new ArrayList<>();
    }

    public void hunt() {
        System.out.println(name + " está caçando...");
        // Lógica para caçar e adicionar itens ao inventário
        Item newItem = new Item("Carne");
        inventory.add(newItem);
        System.out.println(name + " obteve " + newItem.getName());
    }

    public void eat() {
        if (inventory.isEmpty()) {
            System.out.println("Não há itens para comer.");
        } else {
            Item item = inventory.get(0);
            System.out.println(name + " está comendo " + item.getName());
            inventory.remove(item);
        }
    }

    public void battle(Character opponent) {
        // Lógica para a batalha entre personagens
        // Aqui você pode implementar a lógica de dano, etc.
    }

    public boolean isAlive() {
        return health > 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar personagem
        System.out.print("Digite o nome do personagem: ");
        String playerName = scanner.nextLine();
        Character player = new Character(playerName);

        // Loop principal do jogo
        while (player.isAlive()) {
            System.out.println("\nO que você quer fazer?");
            System.out.println("1. Caçar");
            System.out.println("2. Comer");
            System.out.println("3. Batalhar");
            System.out.println("4. Sair");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    player.hunt();
                    break;
                case 2:
                    player.eat();
                    break;
                case 3:
                    // Lógica para batalha
                    break;
                case 4:
                    System.out.println("Saindo do jogo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha inválida.");
                    break;
            }
        }

        System.out.println("Game Over. " + player.getName() + " morreu.");
    }
}
