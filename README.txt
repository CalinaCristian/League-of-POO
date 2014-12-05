CALINA CRISTIAN 323CA







In the approach of the homework I followed the following steps:


In the heroes class:



1. I declared the constructor whitch recievs the pozistion , hero type and terrain type.
2. I added a function whitch verifies if the hero gets a level up or not. (level_up())
3. I added a function whitch adds xp to the winner of a battle. (add_xp_winner(heroes h))
4. I added a function which hits the hero. (get_hit())

5. I added a function whitch recieves the number of rounds in which the damage over time applyes and the respective damage. (extended_damage(int no_of_rounds,int damage)
6. I added a function whitch applyes the damage over time. (get_DOT())
7. I added a function whitch verifies if the hero is dead. (is_dead())
8. I added a function whitch verifies if two heroes meet. (colide(heroes h)).
9. I added a function whitch returns the total damage from the two spells of the opponent. (get_damage(int total_damage))
10. I added a function whitch adds basic damage to the total basic damage of the hero. (set_my_damage(double damage())
11. I added a function whitch returns the basic damage * the land modifier fot the wizard deflect spell. (get_my_damage()).
12. I added a function whitch kills the hero instantly (for the spell execute). (instant_kill())
13. I added a function whitch paralyses the hero for a given number of rounds. (paralyze_him(int i))
14. I added a function whitch verifies if a hero is paralysed and decreases the number of rounds for which he has to be paralysed. (is_paralyzed())
15. I added the four functions of movement. (moveUp/moveDown/moveLeft/moveRight)
16. I added some functions whitch returns caracteristics of the hero.




In the extended classes Knight/Pyromancer/Rogue/Wizard:



1. I declared the constructor and added the HP and specific spells.

2. I added to the level up function the increasing of the HP and the reset of the curent hp to the maximum hp.
2.1 I also called the level up functions for the spells.




In the spells class:


1. I declared the constructor of the class and initialised the modifiers with the value "1" and memorised the terrain type.





In the extended classes of the spells class:




I. Backstab Class



1. I added to the constructor the damage and critical hit (coutner) and also a variable whitch retains true if the terrain is wood.
2. I added to the level up function the increasing of the damage.
3. In the cast function , I added the terrain/hero modifiers. 
3.1 If the terrain is wood and it's the first round , the hero gives critical hit and the counter raises.
3.2 If the terrain is not wood and it's the third round , the hero gives critical hit and the counter resets to 0.
3.3 If the terrain is not wood and it's neither the third round , the hero doesn't give critical hit and the counter raises.
4. I send the rounded base_damage * land_modifier to the enemy for having the basic attack in case he is a wizard.
5. I reset the modifiers to 1/1.







II. Deflect Class


1. I added to the constructor the deflect percentage.
2. I added to the level up function the raise of the percentage with the limit of 70%.
3. In the cast function I applyed the terrain/hero modifiers.
4. I applyed the modifiers and pectentage to the damage gotten in the current round by the hero.
5. I reset the modifiers to 1/1.






III. Drain Class


1. I added to the constructor the percentage of drain.
2. I added to the level up function the raise of the percentage.
3. In the cast function I applyed the modifiers.
4. I raised the percentage depending on the hero modifier.
5. I send the damage depending on the enemy current HP.
6. I reset the modifiers to 1/1.






IV. Execute Class

1. I added to the constructor the damage and the limit.
2. I added to the level up the increasing of the damage and the limit.
3. I added to the cast function the hero/terrain modifiers.
4. I checked if the instant kill condition verrifies.
5. If not , I give normal damage (with the modifiers).
6. I send the rounded base_damage * land_modifier to the enemy for having the basic attack in case he is a wizard.
7. I reset the modifiers to 1/1.



V. Fireblast Class


1. I added to the constructor the damage.
2. I added to the level up the increasing of the damage.
3. I added to the cast function the hero/terrain modifiers.
4. I applyed the damage with the modifiers.
5. I send the rounded base_damage * land_modifier to the enemy for having the basic attack in case he is a wizard.
6. I reset the modifiers to 1/1.



VI. Ignite Class


1. I added to the constructor the damage and the DOT (damage over time).
2. I added to the level up function the increasing of the damage and the DOT.
3. I added to the cast function the hero/terrain modifiers.
4. I send the rounded base_damage * land_modifier to the enemy for having the basic attack in case he is a wizard.
5. I apply the damage with the modifiers.
6. I send the DOT and the number of rounds in whitch it applyes.
7. I reset the modifiers to 1/1.






VII. Paralysis

 Class 


1. I added to the constructor the damage and the number of overtime rounds.
2. I added to the level up function the increasing of the damage.
3. I added to the cast function the hero/terrain modifiers.
4. I send the rounded base_damage * land_modifier to the enemy for having the basic attack in case he is a wizard.
5. I apply the damage with the modifiers.
6. I send the DOT and the number of rounds in whitch it applyes (6 if it's on a wood type and 3 otherwise).
7. I paralyse the oponent for the overtime rounds.
8. I reset the modifiers to 1/1.







VIII. Slam Class


1. I added to the constructor the damage.
2. I added to the level up function the increasing of the damage.
3. I added to the cast function the hero/terrain modifiers.
4. I send the rounded base_damage * land_modifier to the enemy for having the basic attack in case he is a wizard.
5. I paralyse the opponent for one round.
6. I reset the modifiers to 1/1.






IX. Main Class



The main class is described in detail in the javadoc. Every step is described there.