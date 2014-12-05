//CALINA CRISTIAN 323CA
package Spells;

import Heroes.heroes;

public class Slam extends spells{

	public Slam(char land_type) {
		super(land_type);
		this.damage = 100;
	}
	
	public void level_up(){
		this.damage += 40;
	}
	
	/**
	 * 
	 * Aply the damage with modifiers included and paralyze for a round
	 * @param h
	 */
	public void cast(heroes h) {
		
		if (h.get_land_type() == 'L') {
			this.land_modifier = 1.15;
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
		
		h.set_my_damage(Math.round(this.damage * this.land_modifier));
		this.buffed_damage = (int) Math.round((Math.round(this.damage * 
				this.land_modifier) * this.hero_modifier));
		h.get_damage(this.buffed_damage);
		h.paralyze_him(1);
		
		this.hero_modifier = 1;
		this.land_modifier = 1;
	}
}
