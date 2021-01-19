package RPG2018;
import java.util.Scanner;


public class rpgMain {
	public static void main (String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		// Character creation
		// Forloop 15 times to allocate stat points. gets an extra 2 stat points for randomizing stats
		// Stats allocated, moves chosen by what class you are
		
		System.out.println("Name:");
		String name = input.next();
		
		System.out.println("Choose your class");
		System.out.println("(1) Crusader - A champion of the divine. Deals devastating strikes, both physical and magical.");
		System.out.println("(2) Highwayman - A lone bandit and thief. Honed skills with dirk and flintlock to devastating effect.");
		System.out.println("(3) Abomination - A machination of eldritch blood and man. Unspeakable power, at a terrible cost.");
		int classChoice = choice(input,3);
		
		System.out.println("Allocate your stats");
		characterStats cStats = new characterStats(name,classChoice);
		
		System.out.println("(1) Random - Recommended for beginners");
		System.out.println("(2) Point Buy");
		
		if (choice(input,2) == 2) {
			cStats.printSheet();
			System.out.println("");
			for (int i = 15; i > 0; i -= 1) { // Stat allocation
				System.out.println("Stat points remaining: " + i);
				System.out.println("");
				System.out.println("(1) Health Points");
				System.out.println("(2) Attack (physical attack)");
				System.out.println("(3) Defense (physical defense)");
				System.out.println("(4) Special Attack (non-physical attack)");
				System.out.println("(5) Special Defense (non-physical defense)");
				System.out.println("(6) Speed");
				
				cStats.allocateStats(choice(input,6),3);
				cStats.printSheet();
				
			}
		}else { // Randomize stats
			
			for (int i = 17; i > 0; i -= 1) {
				cStats.allocateStats((int)(Math.random()*((6-1)+1))+1,3);
			}
			cStats.printSheet();
		}
		System.out.println("");
		System.out.println("You stand before a long forgotten tomb.");
		System.out.println("Inside is said to contain unfathomable wealth and riches.");
		System.out.println("Perhaps, you were drawn in by the promise such rewards.");
		System.out.println("Or perhaps not, how should I know? I'm just a foolish narrator.");
		System.out.println("However, there are things... creatures which stand in your way.");
		System.out.println("Battle through the waves of enemies.");
		System.out.println("Only then will you reach the depths where the treasures lie");
		System.out.println("There, in the heart of the Darkest Dungeon.");
		System.out.println("");
		
		if (battle(input,cStats,new enemyStats(1))) {// First battle
			System.out.println("A trifling victory, but a victory nontheless");
			
			System.out.println("");
			System.out.println("Allocate your stats");
			System.out.println("(1) Random - Recommended for beginners");
			System.out.println("(2) Point Buy");
			if (choice(input,2) == 2) {
				cStats.printSheet();
				System.out.println("");
				for (int i = 5; i > 0; i -= 1) { // Stat allocation
					System.out.println("Stat points remaining: " + i);
					System.out.println("");
					System.out.println("(1) Health Points");
					System.out.println("(2) Attack (physical attack)");
					System.out.println("(3) Defense (physical defense)");
					System.out.println("(4) Special Attack (non-physical attack)");
					System.out.println("(5) Special Defense (non-physical defense)");
					System.out.println("(6) Speed");
					cStats.allocateStats(choice(input,6),3);
					cStats.printSheet();
					System.out.println("");
				}
			}else { // Randomize stats
				for (int i = 7; i > 0; i -= 1) {
					cStats.allocateStats((int)(Math.random()*((6-1)+1))+1,3);
				}
				cStats.printSheet();
				System.out.println("");
			}
			if (battle(input,cStats,new enemyStats(2))) {// Second battle
				System.out.println("An easy enough victory, however, before you is a devil who's walked these halls for centuries.");
				
				System.out.println("");
				System.out.println("Allocate your stats");
				System.out.println("(1) Random - Recommended for beginners");
				System.out.println("(2) Point Buy");
				if (choice(input,2) == 2) {
					cStats.printSheet();
					System.out.println("");
					for (int i = 5; i > 0; i -= 1) { // Stat allocation
						System.out.println("Stat points remaining: " + i);
						System.out.println("");
						System.out.println("(1) Health Points");
						System.out.println("(2) Attack (physical attack)");
						System.out.println("(3) Defense (physical defense)");
						System.out.println("(4) Special Attack (non-physical attack)");
						System.out.println("(5) Special Defense (non-physical defense)");
						System.out.println("(6) Speed");
						cStats.allocateStats(choice(input,6),5);
						cStats.printSheet();
						System.out.println("");
					}
				}else { // Randomize stats
					for (int i = 7; i > 0; i -= 1) {
						cStats.allocateStats((int)(Math.random()*((6-1)+1))+1,5);
					}
					cStats.printSheet();
					System.out.println("");
				}
				if (battle(input,cStats,new enemyStats(3))) {// Third battle
					System.out.println("These nightmarish creatures can be felled, they can be beaten!");
					System.out.println("");
					System.out.println("Allocate your stats");
					System.out.println("(1) Random - Recommended for beginners");
					System.out.println("(2) Point Buy");
					if (choice(input,2) == 2) {
						cStats.printSheet();
						System.out.println("");
						for (int i = 7; i > 0; i -= 1) { // Stat allocation
							System.out.println("Stat points remaining: " + i);
							System.out.println("");
							System.out.println("(1) Health Points");
							System.out.println("(2) Attack (physical attack)");
							System.out.println("(3) Defense (physical defense)");
							System.out.println("(4) Special Attack (non-physical attack)");
							System.out.println("(5) Special Defense (non-physical defense)");
							System.out.println("(6) Speed");
							cStats.allocateStats(choice(input,6),5);
							cStats.printSheet();
							System.out.println("");
						}
					}else { // Randomize stats
						for (int i = 10; i > 0; i -= 1) {
							cStats.allocateStats((int)(Math.random()*((6-1)+1))+1,3);
						}
						cStats.printSheet();
						System.out.println("");
					}
					if (battle(input,cStats,new enemyStats(4))) {// Fourth battle
						System.out.println("A battle won by a hands breadth.");
						System.out.println("");
						System.out.println("Allocate your stats");
						System.out.println("(1) Random - Recommended for beginners");
						System.out.println("(2) Point Buy");
						if (choice(input,2) == 2) {
							cStats.printSheet();
							System.out.println("");
							for (int i = 10; i > 0; i -= 1) { // Stat allocation
								System.out.println("Stat points remaining: " + i);
								System.out.println("");
								System.out.println("(1) Health Points");
								System.out.println("(2) Attack (physical attack)");
								System.out.println("(3) Defense (physical defense)");
								System.out.println("(4) Special Attack (non-physical attack)");
								System.out.println("(5) Special Defense (non-physical defense)");
								System.out.println("(6) Speed");
								cStats.allocateStats(choice(input,6),10);
								cStats.printSheet();
								System.out.println("");
							}
						}else { // Randomize stats
							for (int i = 10; i > 0; i -= 1) {
								cStats.allocateStats((int)(Math.random()*((6-1)+1))+1,10);
							}
							cStats.printSheet();
							System.out.println("");
						}
						System.out.println("You have reached it, the center of the Dungeon");
						System.out.println("The treasure is a lie");
						System.out.println("Before you stands the beating heart of all the worlds evils");
						System.out.println("At this point, there's really only 1 option");
						if (battle(input,cStats,new enemyStats(5))) {// Final battle
							System.out.println("With the final enemy slain, your job is finished.");
							System.out.println("After a long, harsh and grueling adventure, you are done.");
							System.out.println("There is nothing to fight anymore...");
							System.out.println("A world where heroes are unnecessary...");
							System.out.println("True world peace");
						}else {
							System.out.println("Another brave soul lost to the darkness...");
						}
					}else {
						System.out.println("Another brave soul lost to the darkness...");
					}
				}else {
					System.out.println("Another brave soul lost to the darkness...");
				}
			}else {
				System.out.println("Another brave soul lost to the darkness...");
			}
		}else {
			System.out.println("Another brave soul lost to the darkness...");
			
		}
		
	}
	
	public static int choice(Scanner input,int cNum) { // Function for choices, modified to work with any amount of answers. Dummy proof.
		
		int pSelect = input.nextInt();
		while (pSelect > cNum || pSelect <= 0) { // If number isn't one of the choices, repeat
			pSelect = input.nextInt();
		}
		return pSelect;
	}
	// Battle system
	public static boolean battle(Scanner input,characterStats cStats, enemyStats eStats) {
		boolean fight = true;
		
		System.out.println("");
		System.out.println("You encounter: " + eStats.name);
		System.out.println("");
	
		while (fight) {
			
			int battleChoice = battleMenu(input,cStats,eStats);
			if (battleChoice == 5) {
				cStats.printSheet();
			}else {
				if (cStats.spd >= eStats.spd) {
					playerAttacks(battleChoice, cStats,eStats);
					System.out.println("");
					enemyAttacks((int)(Math.random()*((4-1)+1))+1,cStats,eStats);
				}else {
					enemyAttacks((int)(Math.random()*((4-1)+1))+1,cStats,eStats);
					System.out.println("");
					playerAttacks(battleChoice, cStats,eStats);
				}
				
				if (eStats.hp <= 0 || cStats.hp <= 0) {
					fight = !fight;
				}
				
			}
		}
		cStats.hp = cStats.maxhp; // Returns stats to normal
		cStats.atk = cStats.maxatk;
		cStats.def = cStats.maxdef;
		cStats.spatk = cStats.maxspatk;
		cStats.spdef = cStats.maxspdef;
		cStats.spd = cStats.maxspd;
		cStats.acc = 1;
		cStats.eva = 0;
		System.out.println(eStats.name + " has been slain");
		if (eStats.hp <= 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int battleMenu(Scanner input,characterStats cStats, enemyStats eStats) {

			System.out.println(eStats.name + (" - ") + eStats.eClass);
			System.out.println(eStats.hp + "/" + eStats.maxhp);
			System.out.println("");
			System.out.println (cStats.name + (" - ") + cStats.cClass);
			System.out.println(cStats.hp + "/" + cStats.maxhp);
			System.out.println("Move list:");
			System.out.println("(1)" + new attack(cStats.moveID[0]).moveName);
			System.out.println("(2)" + new attack(cStats.moveID[1]).moveName);
			System.out.println("(3)" + new attack(cStats.moveID[2]).moveName);
			System.out.println("(4)" + new attack(cStats.moveID[3]).moveName);
			System.out.println("(5)Examine your character (doesn't use up a turn)");
			
			return choice(input,5);
			
	}
	
	public static void playerAttacks(int battleChoice, characterStats cStats, enemyStats eStats) {
		System.out.println(cStats.name + " used " + new attack(cStats.moveID[battleChoice-1]).moveName);
		
		characterStats oldCStats = new characterStats(cStats); // Temporary stats for the battle text function
		enemyStats oldEStats = new enemyStats(eStats); 
		
		attack currentMove = new attack(cStats.moveID[battleChoice-1]);
		
		// Does the move miss
		double accuracy = (currentMove.moveAcc*cStats.acc) - eStats.eva;
		double accuracyCheck = Math.random();
		if (accuracyCheck < accuracy ) {
			// Damage calculations
			double finalDamage = 0;
			if (currentMove.type == 0) { // If it's a physical attack
				finalDamage = (currentMove.dmg*cStats.atk) - (eStats.def*0.4);
			}else if (currentMove.type == 1) { // If it's a special attack
				finalDamage = (currentMove.dmg*cStats.spatk) - (eStats.spdef*0.4);
			}
			if (finalDamage < 0 ) {
				finalDamage = 0;
			}
			if (Math.random() < currentMove.crit) {
				finalDamage = finalDamage*1.5;
			}
			eStats.hp -= (int)finalDamage; // Turns final damage into an integer 
			
			// Other effects of the move
			cStats.hp += currentMove.heal; // Change in player health
			if (cStats.hp > cStats.maxhp) {
				cStats.hp = cStats.maxhp; // If the player overheals then it brings them back
			}
			cStats.atk += currentMove.atkc; // Change in player attack
			cStats.def += currentMove.defc; // Change in player defense
			cStats.spatk += currentMove.spatkc; // Change in player special attack
			cStats.spdef += currentMove.spdefc; // Change in player special defense
			cStats.spd += currentMove.spdc; // Change in player speed
			cStats.acc += currentMove.accc; // Change in player accuracy
			cStats.eva += currentMove.evac; // Change in player evasion
			
			eStats.atk += currentMove.atke; // Change in enemy attack
			eStats.def += currentMove.defe; // Change in enemy defense
			eStats.spatk += currentMove.spatke; // Change in enemy special attack
			eStats.spdef += currentMove.spdefe; // Change in enemy special defense
			eStats.spd += currentMove.spde; // Change in enemy speed
			eStats.acc += currentMove.acce; // Change in enemy accuracy
			eStats.eva += currentMove.evae; // Change in enemy evasion
			
		}else {
			System.out.println("You missed!");
		}
		
		if (eStats.hp < oldEStats.hp) { // if enemy's current hp is lower than the previous turn
			System.out.println(eStats.name + " took " + (oldEStats.hp-eStats.hp) + " damage");
		}else if (eStats.hp > oldEStats.hp) {
			System.out.println(eStats.name + " gained " + (eStats.hp-oldEStats.hp) + " health");
		}
		if (cStats.hp < oldCStats.hp) { // if your current hp is different from the previous turn
			System.out.println("You took " + (oldCStats.hp-cStats.hp) + " damage");
		}else if (cStats.hp > oldCStats.hp) {
			System.out.println("You gained " + (cStats.hp-oldCStats.hp) + " health");
		}
		
		battleText(cStats,eStats, oldCStats, oldEStats);
		
	}
	public static void enemyAttacks(int rand, characterStats cStats, enemyStats eStats) {
		System.out.println(eStats.name + " used " + new attack(eStats.moveID[rand-1]).moveName);
		
		characterStats oldCStats = new characterStats(cStats); // Temporary stats for the battle text function
		enemyStats oldEStats = new enemyStats(eStats); 
		
		attack currentMove = new attack(eStats.moveID[rand-1]);
		
		// Does the move miss
		double accuracy = (currentMove.moveAcc*eStats.acc) - cStats.eva;
		double accuracyCheck = Math.random();
		if (accuracyCheck < accuracy ) {
			// Damage calculations
			double finalDamage = 0;
			if (currentMove.type == 0) { // If it's a physical attack
				finalDamage = (currentMove.dmg*eStats.atk) - (cStats.def*0.4);
			}else if (currentMove.type == 1) { // If it's a special attack
				finalDamage = (currentMove.dmg*eStats.spatk) - (cStats.spdef*0.4);
			}
			if (finalDamage < 0 ) {
				finalDamage = 0;
			}
			if (Math.random() < currentMove.crit) {
				finalDamage = finalDamage*1.5;
			}
			cStats.hp -= (int)finalDamage; // Turns final damage into an integer 
			
			// Other effects of the move
			eStats.hp += currentMove.heal; // Change in enemy health
			if (eStats.hp > eStats.maxhp) {
				eStats.hp = eStats.maxhp; // If the enemy overheals then it brings them back
			}
			eStats.atk += currentMove.atkc; // Change in enemy attack
			eStats.def += currentMove.defc; // Change in enemy defense
			eStats.spatk += currentMove.spatkc; // Change in enemy special attack
			eStats.spdef += currentMove.spdefc; // Change in enemy special defense
			eStats.spd += currentMove.spdc; // Change in enemy speed
			eStats.acc += currentMove.accc; // Change in enemy accuracy
			eStats.eva += currentMove.evac; // Change in enemy evasion
			
			cStats.atk += currentMove.atke; // Change in player attack
			cStats.def += currentMove.defe; // Change in player defense
			cStats.spatk += currentMove.spatke; // Change in player special attack
			cStats.spdef += currentMove.spdefe; // Change in player special defense
			cStats.spd += currentMove.spde; // Change in player speed
			cStats.acc += currentMove.acce; // Change in player accuracy
			cStats.eva += currentMove.evae; // Change in player evasion
			
		}else {
			System.out.println(eStats.name + " missed!");
		}
		
		if (cStats.hp < oldCStats.hp) { // if your current hp is different from the previous turn
			System.out.println("You took " + (oldCStats.hp-cStats.hp) + " damage");
		}else if (cStats.hp > oldCStats.hp) {
			System.out.println("You gained " + (cStats.hp-oldCStats.hp) + " health");
		}
		
		if (eStats.hp < oldEStats.hp) { // if enemy's current hp is lower than the previous turn
			System.out.println(eStats.name + " took " + (oldEStats.hp-eStats.hp) + " damage");
		}else if (eStats.hp > oldEStats.hp) {
			System.out.println(eStats.name + " gained " + (eStats.hp-oldEStats.hp) + " health");
		}
		battleText(cStats,eStats, oldCStats, oldEStats);
	}
	
	public static void battleText(characterStats cStats, enemyStats eStats, characterStats oldCStats, enemyStats oldEStats) {
		// Change in player stats
		
		if (cStats.atk < oldCStats.atk) { // if your current attack is different previous turn
			System.out.println("Your attack has decreased");
		}else if (cStats.atk > oldCStats.atk) {
			System.out.println("Your attack has increased");
		}
		if (cStats.def < oldCStats.def) { // if your current defense is lower than the previous turn
			System.out.println("Your defense has decreased");
		}else if (cStats.def > oldCStats.def) {
			System.out.println("Your defence has increased");
		}
		if (cStats.spatk < oldCStats.spatk) { // if your current special attack is different previous turn
			System.out.println("Your special attack has decreased");
		}else if (cStats.spatk > oldCStats.spatk) { 
			System.out.println("Your special attack has increased");
		}
		if (cStats.spdef < oldCStats.spdef) { // if your current special defense is lower than the previous turn
			System.out.println("Your special defense has decreased");
		}else if (cStats.spdef > oldCStats.spdef) {
			System.out.println("Your special defence has increased");
		}
		if (cStats.spd < oldCStats.spd) { // if your current speed is lower than the previous turn
			System.out.println("Your speed has decreased");
		}else if (cStats.spd > oldCStats.spd) {
			System.out.println("Your speed has increased");
		}
		if (cStats.acc < oldCStats.acc) { // if your current accuracy is lower than the previous turn
			System.out.println("Your accuracy has decreased");
		}else if (cStats.acc > oldCStats.acc) {
			System.out.println("Your accuracy has increased");
		}
		if (cStats.eva < oldCStats.eva) { // if your current evasion is lower than the previous turn
			System.out.println("Your evasion has decreased");
		}else if (cStats.eva > oldCStats.eva) {
			System.out.println("Your evasion has increased");
		}
		
		System.out.println("");
		
		// Change in enemy stats
		
		if (eStats.atk < oldEStats.atk) { // if enemy's current attack is different previous turn
			System.out.println(eStats.name + "'s attack has decreased");
		}else if (eStats.atk > oldEStats.atk) {
			System.out.println(eStats.name + "'s attack has increased");
		}
		if (eStats.def < oldEStats.def) { // if enemy's current defense is lower than the previous turn
			System.out.println(eStats.name + "'s defense has decreased");
		}else if (eStats.def > oldEStats.def) {
			System.out.println(eStats.name + "'s defence has increased");
		}
		if (eStats.spatk < oldEStats.spatk) { // if enemy's current special attack is different previous turn
			System.out.println(eStats.name + "'s special attack has decreased");
		}else if (eStats.spatk > oldEStats.spatk) { 
			System.out.println(eStats.name + "'s special attack has increased");
		}
		if (eStats.spdef < oldEStats.spdef) { // if enemy's current special defense is lower than the previous turn
			System.out.println(eStats.name + "'s special defense has decreased");
		}else if (eStats.spdef > oldEStats.spdef) {
			System.out.println(eStats.name + "'s special defence has increased");
		}
		if (eStats.spd < oldEStats.spd) { // if enemy's current speed is lower than the previous turn
			System.out.println(eStats.name + "'s speed has decreased");
		}else if (eStats.spd > oldEStats.spd) {
			System.out.println(eStats.name + "'s speed has increased");
		}
		if (eStats.acc < oldEStats.acc) { // if enemy's current accuracy is lower than the previous turn
			System.out.println(eStats.name + "'s accuracy has decreased");
		}else if (eStats.acc > oldEStats.acc) {
			System.out.println(eStats.name + "'s accuracy has increased");
		}
		if (eStats.eva < oldEStats.eva) { // if enemy's current evasion is lower than the previous turn
			System.out.println(eStats.name + "'s evasion has decreased");
		}else if (eStats.eva > oldEStats.eva) {
			System.out.println(eStats.name + "'s evasion has increased");
		}
	}
}