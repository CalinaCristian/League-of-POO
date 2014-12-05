//CALINA CRISTIAN 323CA
package Heroes;

import Spells.Execute;
import Spells.Slam;

public class Knight extends heroes {
	
	private Execute execute;
	private Slam slam;
	
	public Knight(int rows, int col, char hero_type, char land_type) {
		super(rows,col , hero_type, land_type);
		this.HP = 900;
		this.HP_damaged = HP;
		this.execute = new Execute (land_type);
		this.slam = new Slam (land_type);
	}
	
	/**
	 * Raise the HP , reset it to the maximum value and level up the spells.
	 */
	public void level_up(){
		super.level_up();
		if (this.previous_level != this.level){
		this.HP += 80 * (this.level - this.previous_level);
		this.HP_damaged = this.HP;
		this.execute.level_up();
		this.slam.level_up();
		}
	}
	
	/**
	 * Attack with the two spells and the enemy takes the damage.
	 * @param h
	 */
	public void attack(heroes h){
		this.execute.cast(h);
		this.slam.cast(h);
		h.get_hit();
	}
}
