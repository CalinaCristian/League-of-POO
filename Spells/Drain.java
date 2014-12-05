//CALINA CRISTIAN 323CA
package Spells;

import Heroes.heroes;

public class Drain extends spells{

	private double procent;
	private double buffed_procent;
	
	public Drain(char land_type) {
		super(land_type);
		this.procent = 0.2;
	}
	
	public void level_up(){
		this.procent += 0.05;
	}
	/**
	 * I aply the formula for drain and send the damage to the enemy hero.
	 * 
	 * @param h
	 */
	public void cast(heroes h) {
		
		if (h.get_land_type() == 'D') {
			this.land_modifier = 1.1;
		}
		
		switch (h.get_hero_type()){
			case 'R':
				this.hero_modifier -= 0.2;
				break;
			case 'K':
				this.hero_modifier += 0.2;
				break;
			case 'P':
				this.hero_modifier -= 0.1;
				break;
			case 'W':
				this.hero_modifier += 0.05;
				break;
		}
		this.buffed_procent = this.procent * this.hero_modifier;
		this.buffed_damage = (int) Math.round( Math.round(this.land_modifier * 
				Math.min(0.3 * h.get_maxHP(),h.get_HP())) * this.buffed_procent);
		h.get_damage(this.buffed_damage);
		
		this.hero_modifier = 1;
		this.land_modifier = 1;
	}
}
