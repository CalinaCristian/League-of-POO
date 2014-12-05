//CALINA CRISTIAN 323CA
package Heroes;

import Spells.Deflect;
import Spells.Drain;

public class Wizard extends heroes{

	private Drain drain;
	private Deflect deflect;
	
	public Wizard(int rows, int col, char hero_type, char land_type) {
		super(rows, col, hero_type, land_type);
		this.HP = 400;
		this.HP_damaged = HP;
		this.deflect = new Deflect (land_type);
		this.drain = new Drain (land_type);
	}

	public void level_up(){
		super.level_up();
		if (this.previous_level != this.level){
		this.HP += 30 * (this.level - this.previous_level);
		this.HP_damaged = this.HP;
		this.drain.level_up();
		this.deflect.level_up();
		}
	}
	
	public void attack(heroes h){
		this.drain.cast(h);
		this.deflect.cast(h,this);
		h.get_hit();
	}
}
