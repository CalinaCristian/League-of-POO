//CALINA CRISTIAN 323CA
package main;

import Heroes.*;

/**
 * In this method I followed the following steps:
 * 1. I opened the input and output files.
 * 2. I read the dimensions of the field and created the matrix for the terrain.
 * 3. I read the number of characters , the type and positions of them.
 * 4. I called the constructor of the characters depending on their type. 
 * 5. I read the number of rounds and saved the moves in a matrix.
 * 6. I begin the execution of the rounds.
 * 6.1 At every round , I aply for every character the damage over time.
 * 6.2 If he is not dead , I check if he is paralysed.
 * 6.2.1 If he is paralysed , I change the value of the matrix in '_'.
 * 6.2.2 If he is not paralysed , I move him depending on the given direction.
 * 6.3 If he is not dead , I begin the verification of the colision with other heroes.
 * 6.4 If he colides with another hero whom is not dead, he confronts him.
 * 6.5 If one of the heroes is a wizard , the first attacker has to be the other one, so:
 * 6.5.1 If the hero j is a wizard and the hero k is not , the first attacker will be hero k.
 * 6.5.2 If the hero k is a wizard and the hero j is not , the first attacker will be hero j.
 * 6.5.3 If both heroes are wizards , the order of attacking is irrelevant.
 * 6.5.4 If no one is a wizard , they attack each other.
 * 6.6 If the hero j has died , I assign the winning xp to the hero k.
 * 6.6.1 If the hero k has died, I assign the winning xp to the hero j.
 * 6.7 I display in the output file for every character the type,level,xp,hp and position.
 * 6.7.1 If he is dead , I display the type and the message "dead".
 * 
 * @author Cristian
 *
 */
public class Main {
	public static void main(String[] args) {
		
		FileIO f = new FileIO(args[0],true);
		FileIO g = new FileIO(args[1],false);
		
		String lines = f.readLine();
		int N,M,P,R;
		
		String c[]=lines.split(" ");
		N=Integer.parseInt(c[0]);
		M=Integer.parseInt(c[1]);

		char [][]land = new char[N][M];
		
		for (int i = 0 ; i < N ; i++){
			lines = f.readLine();
			for (int j = 0 ; j < M ; j++) {
				land[i][j] = lines.charAt(j);
			}
		}
		
		lines = f.readLine();
		P = Integer.parseInt(lines);
		
		char hero_type;
		int rows,col;
		
		heroes[] hero = new heroes [P];
		for (int i = 0 ; i < P ; i++) {
			lines = f.readLine();
			c = lines.split(" ");
			hero_type = lines.charAt(0);
			rows = Integer.parseInt(c[1]);
			col = Integer.parseInt(c[2]); 

			switch (hero_type){
			case 'W':
				hero[i] = new Wizard(rows, col,hero_type,land[rows][col]);
				break;
			case 'P':
				hero[i] = new Pyromancer(rows, col,hero_type,land[rows][col]);
				break;
			case 'R':
				hero[i] = new Rogue(rows, col,hero_type,land[rows][col]);
				break;
			case 'K':
				hero[i] = new Knight(rows, col,hero_type,land[rows][col]);
				break;
			}
		}
		
		lines = f.readLine();
		R = Integer.parseInt(lines);
		char [][] movement = new char[R][P];
		for (int i = 0 ; i < R ; i++){
			lines = f.readLine();
			for (int j = 0 ; j < P ; j ++) {
				movement[i][j] = lines.charAt(j);
			}
		}
		
		for (int i = 0 ; i < R ; i++){
			for (int j=0 ; j < P ; j++){

				 hero[j].get_DOT();

				if (!hero[j].is_dead()){

					if (hero[j].is_paralyzed() > 0){
						movement[i][j] = '_';
					}

					switch (movement[i][j]){
					case 'U':
						hero[j].moveUp();
						break;
					case 'D':
						hero[j].moveDown(N);
						break;
					case 'L':
						hero[j].moveLeft();
						break;
					case 'R':
						hero[j].moveRight(M);
						break;
					}
				}
			}

			for (int j = 0 ; j < P ; j++){
				if (!hero[j].is_dead()){

					for (int k = j+1 ; k < P ; k ++){
						if (!hero[k].is_dead()){

							if (hero[j].colide(hero[k])){
								

								if ((hero[j] instanceof Wizard) && 
										(!(hero[k] instanceof Wizard))){
									
									if (hero[k] instanceof Knight)
										((Knight)hero[k]).attack(hero[j]);
									
									else if (hero[k] instanceof Pyromancer)
										((Pyromancer)hero[k]).attack(hero[j]);
									
									else if (hero[k] instanceof Rogue)
										((Rogue)hero[k]).attack(hero[j]);
									
									((Wizard)hero[j]).attack(hero[k]);
									
								}
								
								
								else if ((hero[k] instanceof Wizard) && 
										(!(hero[j] instanceof Wizard))){
									
									if (hero[j] instanceof Knight)
										((Knight)hero[j]).attack(hero[k]);
									
									else if (hero[j] instanceof Pyromancer)
										((Pyromancer)hero[j]).attack(hero[k]);
									
									else if (hero[j] instanceof Rogue)
										((Rogue)hero[j]).attack(hero[k]);
									
									((Wizard)hero[k]).attack(hero[j]);
									
								}
								
								
								else if ((hero[k] instanceof Wizard) && 
										((hero[j] instanceof Wizard))){
									
									((Wizard)hero[k]).attack(hero[j]);
									((Wizard)hero[j]).attack(hero[k]);
									
								}
								
								
								else if ((hero[j] instanceof Knight) && (!(hero[k] instanceof Wizard))) 
									((Knight)hero[j]).attack(hero[k]); 
								
								else if ((hero[j] instanceof Pyromancer) && (!(hero[k] instanceof Wizard)))
									((Pyromancer)hero[j]).attack(hero[k]); 
								
								else if ((hero[j] instanceof Rogue) && (!(hero[k] instanceof Wizard)))
									((Rogue)hero[j]).attack(hero[k]); 
								
								
								
								if ((hero[k] instanceof Knight) && (!(hero[j] instanceof Wizard))) 
									((Knight)hero[k]).attack(hero[j]); 
								
								else if ((hero[k] instanceof Pyromancer) && (!(hero[j] instanceof Wizard))) 
									((Pyromancer)hero[k]).attack(hero[j]); 
								
								else if ((hero[k] instanceof Rogue) && (!(hero[j] instanceof Wizard))) 
									((Rogue)hero[k]).attack(hero[j]);
								
								
								
								if (hero[j].is_dead() && !hero[k].is_dead()){
									
									hero[k].add_xp_winner(hero[j]);
									
									if (hero[k] instanceof Knight)
										((Knight)hero[k]).level_up();
									
									else if (hero[k] instanceof Pyromancer)
										((Pyromancer)hero[k]).level_up();
									
									else if (hero[k] instanceof Rogue)
										((Rogue)hero[k]).level_up();
									
									else if (hero[k] instanceof Wizard)
										((Wizard)hero[k]).level_up();
									
								}
								else if (hero[k].is_dead() && !hero[j].is_dead()){
									
									hero[j].add_xp_winner(hero[k]);
									
									if (hero[j] instanceof Knight)
										((Knight)hero[j]).level_up();
									
									else if (hero[j] instanceof Pyromancer)
										((Pyromancer)hero[j]).level_up();
									
									else if (hero[j] instanceof Rogue)
										((Rogue)hero[j]).level_up();
									
									else if (hero[j] instanceof Wizard)
										((Wizard)hero[j]).level_up();
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0 ; i < P ; i++){
			String output = new String();
			output += hero[i].get_hero_type();
			if (hero[i].is_dead()){
				output += " dead";
			}
			else{
				output += " " + hero[i].get_level() + " " + hero[i].get_XP() + " " 
							+ hero[i].get_HP() + " " + hero[i].get_rows() + " " + hero[i].get_col();
			}
			g.writeLine(output);
		}
	}
}