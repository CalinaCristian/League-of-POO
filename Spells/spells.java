//CALINA CRISTIAN 323CA
package Spells;

public class spells {
	
	protected int damage;
	protected int special_damage;
	protected double land_modifier , hero_modifier;
	protected char land_type;
	protected int buffed_damage , buffed_special_damage;
	
	public spells(char land_type){
		this.land_type = land_type;
		this.land_modifier = 1;
		this.hero_modifier = 1;
	}
}
