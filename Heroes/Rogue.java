//CALINA CRISTIAN 323CA
package Heroes;

import Spells.Backstab;
import Spells.Paralysis;

public class Rogue extends heroes {

	private Backstab backstab;
	private Paralysis paralysis;
	
	public Rogue(int rows, int col, char hero_type, char land_type) {
		super(rows, col, hero_type, land_type);
		this.HP = 600;
		this.HP_damaged = HP;
		this.backstab = new Backstab (land_type);
		this.paralysis = new Paralysis (land_type);
	}
	
	public void level_up(){
		super.level_up();
		if (this.previous_level != this.level){
		this.HP += 40 * (this.level - this.previous_level);
		this.HP_damaged = this.HP;
		this.backstab.level_up();
		this.paralysis.level_up();
		}
	}
	
	public void attack(heroes h){
		this.backstab.cast(h);
		this.paralysis.cast(h);
		h.get_hit();
	}

}
