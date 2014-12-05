//CALINA CRISTIAN 323CA
package Spells;

import Heroes.heroes;

public class Backstab extends spells{

	private int critical_hit;
	boolean wood;
	
	public Backstab(char land_type) {
		super(land_type);
		this.wood = false;
		this.damage = 200;
		this.critical_hit = 0;
	}
	
	public void level_up(){
		this.damage += 20;
	}
	/**
	 * If the terrain is Wood-type and it's the first round , I raise
	 * the counter and I set the damage to be 1.5x bigger.
	 * 
	 * If it's not a wood type and it's the first round , I raise the counter
	 * and I set the damage to be 1.5x bigger.
	 * 
	 * Else I raise the counter and aply the normal damage
	 * 
	 * Altfel cresc counterul si aplic damage-ul normal
	 * @param h
	 */
	public void cast(heroes h) {
		if (h.get_land_type() == 'W') {
			this.wood = true;
			this.land_modifier = 1.15;
		}
		
		switch (h.get_hero_type()){
			case 'R':
				this.hero_modifier += 0.2;
				break;
			case 'K':
				this.hero_modifier -= 0.1;
				break;
			case 'P':
				this.hero_modifier += 0.25;
				break;
			case 'W':
				this.hero_modifier += 0.25;
				break;
		}
		
		if (( this.critical_hit == 0) && (this.wood == true)){
			
			h.set_my_damage( Math.round(1.5 * this.damage) * this.land_modifier);
			this.critical_hit++;
			h.get_damage((int) Math.round(Math.round(Math.round((1.5 * this.damage) * 
					this.land_modifier) * this.hero_modifier)));
		}
		
		else if ((this.critical_hit == 2) && (this.wood == false)){
			
			h.set_my_damage( Math.round(1.5 * this.damage) * this.land_modifier);
			h.get_damage((int) Math.round(Math.round(Math.round((1.5 * this.damage) * 
					this.land_modifier) * this.hero_modifier)));
			this.critical_hit = 0;
		}
		
		else {
			
			this.critical_hit++;
			h.set_my_damage(Math.round(this.damage * this.land_modifier));
			h.get_damage((int) Math.round(Math.round(this.damage * this.land_modifier) *
					this.hero_modifier));
		}
		
		this.hero_modifier = 1;
		this.land_modifier = 1;
	}
}
