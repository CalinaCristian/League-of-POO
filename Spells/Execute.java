//CALINA CRISTIAN 323CA
package Spells;

import Heroes.heroes;

public class Execute extends spells{
	
	private double limit;
	
	public Execute(char land_type) {
		super(land_type);
		this.damage = 200;
		this.limit = 0.2;
	}

	public void level_up(){
		this.damage += 30;
		if (this.limit < 0.4){
			this.limit += 0.01;
		}
	}
	/**
	 * If the enemys HP is under the limit I kill him
	 * instantly . Else I aply the damage with the
	 * hero/terrain modifiers.
	 * 
	 * @param h
	 */
	public void cast(heroes h) {
		if (h.get_land_type() == 'L') {
			this.land_modifier = 1.15;
		}
		switch (h.get_hero_type()){
			case 'R':
				this.hero_modifier += 0.15;
				break;
			case 'K':
				this.hero_modifier += 0;
				break;
			case 'P':
				this.hero_modifier += 0.1;
				break;
			case 'W':
				this.hero_modifier -= 0.2;
				break;
		}	
		if (h.get_HP() < limit * h.get_maxHP()){
			h.instant_kill();
		}
		else {
			this.buffed_damage = (int) Math.round((Math.round(this.damage * this.land_modifier) * this.hero_modifier));
			h.get_damage(this.buffed_damage);
		}
		h.set_my_damage(Math.round(this.damage * this.land_modifier));
		
		this.hero_modifier = 1;
		this.land_modifier = 1;
	}

}
