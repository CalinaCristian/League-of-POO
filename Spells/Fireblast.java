//CALINA CRISTIAN 323CA
package Spells;

import Heroes.heroes;

public class Fireblast extends spells{

	public Fireblast(char land_type) {
		super(land_type);
		this.damage = 350;
	}

	public void level_up(){
		this.damage += 50;
	}
	
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
		h.get_damage(this.buffed_damage);
		
		this.hero_modifier = 1;
		this.land_modifier = 1;
	}
}
