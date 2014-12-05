//CALINA CRISTIAN 323CA
package Spells;

import Heroes.heroes;

public class Paralysis extends spells{
	
	private int overtime_rounds;
	
	public Paralysis(char land_type) {
		super(land_type);
		this.damage = 40;
		overtime_rounds = 3;
	}
	
	public void level_up(){
		this.damage += 10;
	}

	/**
	 * I send the damage considering the modifiers and
	 * also the number of rounds for paralysis and
	 * number of rounds for damage over time
	 * @param h
	 */
	public void cast(heroes h) {
		
		if (h.get_land_type() == 'W') {
			this.land_modifier = 1.15;
			overtime_rounds = 6;
		}
		switch (h.get_hero_type()){
			case 'R':
				this.hero_modifier -= 0.1;
				break;
			case 'K':
				this.hero_modifier -= 0.2;
				break;
			case 'P':
				this.hero_modifier += 0.2;
				break;
			case 'W':
				this.hero_modifier += 0.25;
				break;
		}
		
		h.set_my_damage(Math.round(this.damage * this.land_modifier));
		
		this.buffed_damage = (int) Math.round((Math.round(this.damage 
				* this.land_modifier) * this.hero_modifier));
		
		h.get_damage(this.buffed_damage);
		h.extened_damage(this.overtime_rounds,this.buffed_damage);
		h.paralyze_him(this.overtime_rounds);
		
		this.hero_modifier = 1;
		this.land_modifier = 1;
	}

}
