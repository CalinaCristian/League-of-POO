//CALINA CRISTIAN 323CA
package Spells;

import Heroes.heroes;

public class Deflect extends spells {

	private double procent;
	
	public Deflect(char land_type) {
		super(land_type);
		this.procent = 0.35;
	}
	
	public void level_up(){
		if (this.procent < 0.7){
			this.procent +=0.02;
		}
	}
	/**
	 * I aply the formula to calculate the deflect. The object heroes me helps to keep
	 * the basic damage taken by the wizard.
	 * 
	 * @param h
	 * @param me
	 */
	public void cast(heroes h, heroes me) {
		
		if (h.get_land_type() == 'D') {
			this.land_modifier = 1.1;
		}
		
		switch (h.get_hero_type()){
			case 'R':
				this.hero_modifier += 0.2;
				break;
			case 'K':
				this.hero_modifier += 0.4;
				break;
			case 'P':
				this.hero_modifier += 0.3;
				break;
			case 'W':
				this.hero_modifier = 0;
				break;
		}
		
		this.buffed_damage = (int) Math.round(this.procent * this.hero_modifier * this.land_modifier
				* me.get_my_damage());
		
		h.get_damage(this.buffed_damage);
		
		this.hero_modifier = 1;
		this.land_modifier = 1;
	}
}
