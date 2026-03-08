package principal;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import entities.Inimigos;
import entities.Status;
import itens.Equipamentos;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Bem-vindo ao Java Quest!");
		System.out.println("Digite o nome do seu Herói: ");
		String nome = sc.next();
		String inimigo = "Dragão de código";
		
		Status x;
		x = new Status();
		
		int heroi = x.vida;
		int dano_heroi = x.dano;

		Inimigos y = new Inimigos();
		
		int vida_dragao = y.vida;
		int dano_dragao = y.dano;
		
		System.out.println("---------------------------------");
		System.out.println("Herói: " + nome + " [HP: 20]");
		System.out.println("Inimigo: " + inimigo + " [HP: 20]");
		System.out.println("---------------------------------");
		
		System.out.println("Você irá começar com uma espada de prata (2 de dano) e uma escudo de pedra (1 de defesa)");
		
		int escolha1 = sc.nextInt();
		
		Equipamentos espada = new Equipamentos("Espada de Prata", 2, 0);
		Equipamentos escudo = new Equipamentos("Escudo de Pedra", 0, 1);
		
		
		if (escolha1 == 1) {
			x.maodireita = espada;
			System.out.println("Você escolheu espada !!");
		}
		else if (escolha1 == 2){
			x.maodireita = escudo;
			System.out.println("Você escolheu escudo !!");
		}
		
		System.out.println("1 - Atacar");
		System.out.println("2 - Curar");
		System.out.println("3 - Fugir");
		System.out.println("4 - Sair");
		System.out.println("Escolha uma opção: ");
		
		int escolha2 = sc.nextInt();
		
		while (escolha2 != 4) {
			if (escolha2 == 1) {
				int danoTurno = dano_heroi + x.maodireita.dano;
				vida_dragao -= danoTurno;
				System.out.printf("%s atacou com %s e causou %d de dano!!!%n", nome, x.maodireita.nome, danoTurno);
				
				if(vida_dragao > 0) {
					int danoDragaoTurno = dano_dragao - x.maoesquerda.defesa;
					if (danoDragaoTurno < 0) {
						danoDragaoTurno = 0;
					}
					heroi = heroi - danoDragaoTurno;
					System.out.printf("O %s contra-ataca e causa %d de dano!!!%n", inimigo, danoDragaoTurno);
				}
				else {
					System.out.printf("O %s caiu antes de contra-atacar!!%n", inimigo);
				}
			}
			else if (escolha2 == 2) {
				int chanceCura = rand.nextInt(2);
				if (chanceCura == 1) {
					int cura = 2;
					heroi = heroi + cura;
					System.out.printf("%s curou %d de vida.", nome, cura);
				}
				else {
					System.out.printf("Infelizmente %s não conseguiu se curar.", nome);
				}	
			}
			
			else if (escolha2 == 3) {
				int chanceDeFuga = rand.nextInt(2);
				if (chanceDeFuga == 1) {
					System.out.printf("%s conseguiu escapar com segurança.", nome);
					break;
				}
				else {
					System.out.printf("% não pode escapar agora.", nome);
				}
			}
			
			if (heroi <= 0) {
				System.out.println("Você perdeu!! Reinicie o jogo para recomeçar.");
				break;
			}
			else if (vida_dragao <= 0) {
				System.out.println("Você venceu!! Reinicie o jogo se quiser recomeçar.");
				break;
			}
			System.out.println("1 - Atacar");
			System.out.println("2 - Curar");
			System.out.println("3 - Fugir");
			System.out.println("4 - Sair");
			System.out.println("Escolha uma opção: ");
			
			escolha2 = sc.nextInt();
		}
		
		System.out.println("Muito obrigado por jogar.");
		System.out.println("E obrigado também para quem me deu a ideia.");
		sc.close();
	}
}
