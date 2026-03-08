package entities;

import java.util.Random;

public class Inimigos {
	Random rand = new Random();
	public int vida = 20;
	public int dano = rand.nextInt(4);
}
