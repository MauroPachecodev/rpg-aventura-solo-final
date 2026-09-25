import jogoaventura.JogoAventura;
import inimigo.*;
import item.*;
import missao.*;
import personagem.Personagem;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            jogar(scanner);
        } catch (Exception e) {
            System.out.println("Erro crítico no sistema: " + e.getMessage());
        }
    }

    private static void jogar(Scanner scanner) {
        Personagem heroi = new Personagem("Aventureiro");
        JogoAventura jogo = new JogoAventura();
        HashMap<String, Missao> missoes = jogo.getMissoes();

        heroi.adicionarItem(new Pocao("Poção de Cura", "POCAO", 20));
        
        System.out.println("--- Bem-vindo à Aventura! ---");
        
        boolean jogoRodando = true;
        while (jogoRodando) {
            if (heroi.mostrarVida() <= 0) {
                System.out.println("\n☠️ Você morreu! Game Over.");
                break;
            }

            boolean todasConcluidas = true;
            for (Missao m : missoes.values()) {
                if (m.getEstado() == EstadoMissao.PENDENTE) {
                    todasConcluidas = false;
                    break;
                }
            }

            if (todasConcluidas) {
                System.out.println("\n🏆 Parabéns! Você completou todas as missões e venceu a aventura!");
                break;
            }

            System.out.println("\n--- Menu ---");
            System.out.println("1. Ver Status");
            System.out.println("2. Atacar Inimigo da Missão");
            System.out.println("3. Usar Poção");
            System.out.println("4. Ver Missões");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");

            try {
                int escolha = scanner.nextInt();
                switch (escolha) {
                    case 1 -> heroi.mostrarStatus();
                    case 2 -> {
                        Missao missaoAtual = null;
                        for (Missao m : missoes.values()) {
                            if (m.getEstado() == EstadoMissao.PENDENTE) {
                                missaoAtual = m;
                                break;
                            }
                        }

                        if (missaoAtual != null) {
                            Inimigo alvo = missaoAtual.getAlvo();
                            System.out.println("Enfrentando " + alvo.mostrarNome() + "!");
                            
                            while (alvo.estaVivo() && heroi.mostrarVida() > 0) {
                                heroi.atacar(alvo);
                                if (!alvo.estaVivo()) break;

                                alvo.atacar(heroi);
                                System.out.println("Sua Vida: " + heroi.mostrarVida() + " | Vida do Inimigo: " + alvo.mostrarVida());
                                
                                System.out.print("Continuar atacando? (s/n): ");
                                String resp = scanner.next();
                                if (resp.equalsIgnoreCase("n")) break;
                            }
                            
                            if (!alvo.estaVivo()) {
                                System.out.println(alvo.mostrarNome() + " foi derrotado!");
                                missaoAtual.concluir(heroi);
                            }
                        } else {
                            System.out.println("Nenhuma missão pendente!");
                        }
                    }
                    case 3 -> {
                        try {
                            Item pocao = null;
                            for (Item i : heroi.getInventario().getItens()) {
                                if (i instanceof Pocao) {
                                    pocao = i;
                                    break;
                                }
                            }
                            if (pocao != null) {
                                heroi.usarItem(pocao);
                            } else {
                                throw new ItemNaoEncontradoException("Nenhuma poção encontrada no inventário!");
                            }
                        } catch (ItemNaoEncontradoException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }

                    case 4 -> {
                        for (Missao m : missoes.values()) {
                            System.out.println(m.mostrarTitulo() + " [" + m.getEstado() + "]");
                        }
                    }
                    case 5 -> jogoRodando = false;
                    default -> System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
                scanner.next();
            }
        }
        System.out.println("Fim de jogo.");
    }
}
