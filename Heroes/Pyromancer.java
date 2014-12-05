package Heroes;

//CALINA CRISTIAN 323CA
import Spells.Fireblast;
import Spells.Ignite;

public class Pyromancer extends heroes {

	private Fireblast fireblast;
	private Ignite ignite;
	
	public Pyromancer(int rows, int col, char hero_type, char land_type) {
		super(rows, col, hero_type, land_type);
		this.HP = 500;
		this.HP_damaged = HP;
		this.fireblast = new Fireblast (land_type);
		this.ignite = new Ignite (land_type);
	}
	
	public void level_up(){
		super.level_up();
		if (this.previous_level != this.level){
		this.HP += 50* (this.level - this.previous_level);
		this.HP_damaged = this.HP;
		this.fireblast.level_up();
		this.ignite.level_up();
		}
	}
	
	public void attack(heroes h){
		this.fireblast.cast(h);
		this.ignite.cast(h);
		h.get_hit();
	}
}
