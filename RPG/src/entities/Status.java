package entities;

import java.util.Random;

import itens.Equipamentos;

public class Status {
	Random rand = new Random();
	public int vida = 20;
	public int dano = rand.nextInt(3);
	public Equipamentos maodireita;
	public Equipamentos maoesquerda;
	
}
