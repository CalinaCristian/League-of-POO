//CALINA CRISTIAN 323CA//CALINA CRISTIAN 323CA
package Spells;

import Heroes.heroes;

public class Ignite extends spells{
	
	public Ignite(char land_type) {
		super(land_type);
		this.damage = 150;
		this.special_damage = 50;
	}
	
	public void level_up(){
		this.damage += 20;
		this.special_damage += 30;
	}
	
	/**
	 * I send the normal damage , number of rounds and
	 * overtime damage considering the modified terrain/hero.
	 * 
	 * @param h
	 */
	public void cast(heroes h) {
		
		if (h.get_land_type() == 'V') {
			this.land_modifier = 1.25;
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
		
		this.buffed_special_damage = (int) Math.round((Math.round(
				this.special_damage * this.land_modifier) * this.hero_modifier));
		
		h.get_damage(this.buffed_damage);
		h.extened_damage(2,this.buffed_special_damage);
		
		this.hero_modifier = 1;
		this.land_modifier = 1;
	}
}
