//CALINA CRISTIAN 323CA
package Heroes;

public class heroes {

	protected int rows,col;
	protected char hero_type,land_type;
	protected int XP, level, XP_level_up, HP, HP_damaged, paralyzed, no_of_rounds, total_damage, DOT, previous_level;
	protected double base_damage;
	
	/**
	 * The constructor for the heroes class.
	 * @param rows
	 * @param col
	 * @param hero_type
	 * @param land_type
	 */
	public heroes(int rows, int col, char hero_type, char land_type){
		this.XP = 0;
		this.DOT = 0;
		this.total_damage = 0;
		this.base_damage = 0;
		this.paralyzed = 0;
		this.level = 0;
		this.XP_level_up = 250;
		this.rows = rows;
		this.col = col;
		this.hero_type = hero_type;
		this.land_type = land_type;
		this.no_of_rounds = 0;
	}
	
	/**
	 * I check if the hero leveled up.
	 * The variable previous_level helps
	 * for raising the HP in the extended
	 * classes.
	 * 
	 */
	public void level_up(){
		this.previous_level = this.level;
		if (this.XP >= this.XP_level_up){
			while (this.XP_level_up <= this.XP){
				this.level++;
				this.XP_level_up += 50;
			}
		}
	}
	
	/**
	 * Adds xp to the winner.
	 * @param h
	 */
	public void add_xp_winner(heroes h){
		this.XP = this.XP + Math.max(0, 200 - (h.level - this.level) * 40);
	}
	
	/**
	 * I remove the total damage from the current HP and I 
	 * reset it.
	 */
	public void get_hit(){
		this.HP_damaged -= this.total_damage;
		this.total_damage = 0;
	}
	
	/**
	 * 
	 * Set the number of rounds and the damage for the DOT.
	 * @param no_of_rounds
	 * @param damage
	 */
	public void extened_damage(int no_of_rounds, int damage){
		this.no_of_rounds = no_of_rounds;
		this.DOT = damage;
	}
	
	/**
	 * Aply the DOT and reduce the number of rounds in which
	 * it still applyes
	 */
	public void get_DOT(){
		if (this.no_of_rounds != 0){
			this.HP_damaged -= this.DOT;
			this.no_of_rounds --;
		}
	}
	
	/**
	 * Verify if the hero is dead or if he is outside
	 * the terrain.
	 * @return
	 */
	public boolean is_dead(){
		return ((this.HP_damaged <= 0) || ((this.rows == -1) && (this.col == -1)));
	}
	
	/**
	 * Check the colision between two heroes.
	 * @param h
	 * @return
	 */
	public boolean colide(heroes h){
		return ((h.rows == this.rows) && (h.col == this.col));
	}
	
	/**
	 * Sum the damage recieved from every spell
	 * in order to obtain a total damage.
	 * 
	 * @param total_damage
	 */
	public void get_damage(int total_damage){
		this.total_damage += total_damage;
	}
	
	/**
	 * For the deflect spell , sum the total basic damage of the enemy.
	 * @param damage
	 */
	public void set_my_damage(double damage){
		this.base_damage += damage;
	}
	
	/**
	 * Return the total basic damage of the enemy and reset it to 0.
	 * @return
	 */
	public double  get_my_damage(){
		double aux = this.base_damage;
		this.base_damage = 0;
		return aux;
	}
	
	/**
	 * Kill the hero instantly (for Execute spell)
	 */
	public void instant_kill(){
		this.HP_damaged = 0; 
	}
	
	/**
	 * Set the number of rounds for which the hero is paralysed.
	 * @param i
	 */
	public void paralyze_him(int i){
		this.paralyzed = i;
	}
	
	/**
	 * Return the number of rounds in which the hero is paralysed.
	 * @return
	 */
	public int is_paralyzed(){
		if (this.paralyzed > 0){
			this.paralyzed --;
			return paralyzed+1;
		}
		else return 0;
	}
	
	public void moveUp(){
		if (this.rows == 0){
			this.rows = -1;
			this.col = -1;
		}
		this.rows--;
	}
	
	public void moveDown(int max){
		if (this.rows == max-1){
			this.rows = -1;
			this.col = -1;
		}
		this.rows++;
	}
	
	public void moveLeft(){
		if (this.col == 0){
			this.rows = -1;
			this.col = -1;
		}
		this.col--;
	}
	
	public void moveRight(int max){
		if (this.col == max-1){
			this.rows = -1;
			this.col = -1;
		}
		this.col++;
	}
	
	public char get_hero_type(){
		return this.hero_type;
	}
	
	public char get_land_type(){
		return this.land_type;
	}
	
	public int get_HP(){
		return this.HP_damaged;
	}
	
	public int get_maxHP(){
		return this.HP;
	}
	
	public int get_XP(){
		return this.XP;
	}
	
	public int get_level(){
		return this.level;
	}
	
	public int get_rows(){
		return this.rows;
	}
	
	public int get_col(){
		return this.col;
	}
	
}
