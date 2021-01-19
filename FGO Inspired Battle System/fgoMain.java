import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class fgoMain {
	public static void main (String[] args) {
		
		// Explaination of the rules
		System.out.println("Each player picks a hero, the objective is to get the other player down to  0 HP");
		System.out.println("On the left side of the board is Player 1, on the right is Player 2");
		System.out.println("");
		System.out.println("Attacking:");
		System.out.println("You attack by picking 3 cards in a row");
		System.out.println("Each card type has varying effects and the first card in the order affects the remaining cards in the chain");
		System.out.println("Buster cards deal the most damage, as well as increase overall damage when in front of the chain");
		System.out.println("Arts cards deal medium damage but charge your ultimate, or Noble-Phantasm, the quickest. Putting it in front increases the charge rate of the entire chain.");
		System.out.println("Quick cards deal the least damage but generates critical chance. The pattern is obvious at this point.");
		System.out.println("Additionally, the later the card is in the chain, the more effective it is");
		System.out.println("");
		System.out.println("Critical hits:");
		System.out.println("Critical chance is generated throughout the battle just by attacking or with skills");
		System.out.println("Once generated, critical chance stays there forever and never goes down");
		System.out.println("The longer the game, the higher the critical chance");
		System.out.println("");
		System.out.println("Skills:");
		System.out.println("Skills are activated before attacking and provides buffs to your character");
		System.out.println("These can range from a temporary attack boost, to a permanent rise in your critical chance");
		System.out.println("They have cooldowns so use them wisely.");
		System.out.println("");
		System.out.println("Noble-Phantasms/Ultimates");
		System.out.println("Noble-Phantasms are the ultimates of this game");
		System.out.println("They are powerful AOE attacks that can decimate your opponent's field (More types were planned, but cut for time)");
		System.out.println("Noble-Phantasms activate automatically at the end of your once they are fully charged");
		System.out.println("Certain buffs only work on Noble-Phantasms, try to time it's activation with these buffs");
		System.out.println("");
		System.out.println("Minions:");
		System.out.println("Minions deal chip damage to the enemy hero at the end of your turn");
		System.out.println("This damage can rack up over time, you can choose to kill them or not, it's up to you.");
		System.out.println("Once a minion is slain, it won't disappear from the board, you can still attack it. This won't do anything however.");
		System.out.println("\n\n\n\n\n\nIf you want to learn the rules scroll up, otherwise pick your character (More coming never)");
		System.out.println("Player 1 Pick:");
		System.out.println("1) Arthur Pendragon");
		System.out.println("   Health: Medium");
		System.out.println("   Attack: Medium");
		System.out.println("   Early Game: Good");
		System.out.println("   Mid Game: Decent");
		System.out.println("   Late Game: Bad");
		System.out.println("");
		System.out.println("2) Gilgamesh");
		System.out.println("   Health: High");
		System.out.println("   Attack: Low");
		System.out.println("   Early Game: Decent");
		System.out.println("   Mid Game: Decent");
		System.out.println("   Late Game: Good");
		
		Scanner input = new Scanner (System.in);
		Random rand = new Random();
		
		character p1 = new Arthur(); // Without these 2, the program gets fussy
		character p2 = new Gilgamesh();
		
		if (choice(input,2) == 1) { // Player 1 pick
			p1 = new Arthur();
		}else  {
			p1 = new Gilgamesh();
		}
		
		System.out.println("Player 2 Pick (Same choices as Player 1):");
		if (choice(input,2) == 1) { // Player 2 pick
			p2 = new Arthur();
		}else  {
			p2 = new Gilgamesh();
		}
		
		int turnCount = 1;
		int[] cardPick = new int[3];
		int targetPick;
		
		while (p1.HP > 0 && p2.HP > 0) {
		
			displayBoard(p1,p2);
			
			// Player 1 turn
			p1.attackDisplay(turnCount);
			p1.pickSkills();
			
			Boolean skillMenu = true;
			while (skillMenu) { // pick skills to use
				int skillChoice = choice(input,4);
				if (skillChoice == 4) {
					skillMenu = !skillMenu;
				}else if (skillChoice == 1) {
					p1.useSkill1();
				}else if (skillChoice == 2) {
					p1.useSkill2();
				}else if (skillChoice == 3) {
					p1.useSkill3();
				}
			}
			
			System.out.println("Choose target");
			targetPick = choice(input,p2.numOfMinions+1);
			
			p1.pickCards(); // Display card draw
			
			Boolean cardMenu = true;
			while (cardMenu) { // pick cards to attack
				System.out.println("Pick first card");
				cardPick[0] = choice(input, 5);
				System.out.println("Pick second card");
				cardPick[1] = choice(input, 5);
				System.out.println("Pick final card");
				cardPick[2] = choice(input, 5);
				if (cardPick[0] != cardPick[1] && cardPick[0] != cardPick[2] && cardPick[1] != cardPick[2]) { //If all cardpicks are different
					cardMenu = false;
				}else {
					System.out.println("You picked 1 card more than once");
				}
			}
			
			attackCalc (p1, p2, cardPick, targetPick, p1, p2, rand);
			
			minionsAttack(p1,p2);
			
			if (p1.useNP()) {
				useAOENP(p1, p2, p1.npMultiplier, p1.npBoost);
			}
			
			if (p2.HP <= 0) { // If P2's HP is 0 or below, break it
				break;
			}
			
			// Stuff to do after turn ends
			turnCount++;
			if (p1.sCoolDown1 > 0) { // Counts skill cooldown
				p1.sActive1--;
				p1.sCoolDown1--;
				if (p1.sActive1 == 0) { // When skill effect runs out
					p1.skillEnd1(); // do this
				}
			}
			if (p1.sCoolDown2 > 0) {
				p1.sActive2--;
				p1.sCoolDown2--;
				if (p1.sActive2 == 0) {
					p1.skillEnd2();			
				}
			}
			if (p1.sCoolDown3 > 0) {
				p1.sActive3--;
				p1.sCoolDown3--;
				if (p1.sActive3 == 0) {
					p1.skillEnd3();			
				}
			}
			
			// Copy above bit here
			
			displayBoard(p1,p2);
			
			// Player 2 turn
			p2.attackDisplay(turnCount);
			p2.pickSkills();
			
			skillMenu = true;
			while (skillMenu) { // pick skills to use
				int skillChoice = choice(input,4);
				if (skillChoice == 4) {
					skillMenu = !skillMenu;
				}else if (skillChoice == 1) {
					p2.useSkill1();
				}else if (skillChoice == 2) {
					p2.useSkill2();
				}else if (skillChoice == 3) {
					p2.useSkill3();
				}
			}
			
			System.out.println("Choose target");
			targetPick = choice(input,p1.numOfMinions+1);
			
			p2.pickCards(); // Display card draw
			
			cardMenu = true;
			while (cardMenu) { // pick cards to attack
				System.out.println("Pick first card");
				cardPick[0] = choice(input, 5);
				System.out.println("Pick second card");
				cardPick[1] = choice(input, 5);
				System.out.println("Pick final card");
				cardPick[2] = choice(input, 5);
				if (cardPick[0] != cardPick[1] && cardPick[0] != cardPick[2] && cardPick[1] != cardPick[2]) { //If all cardpicks are different
					cardMenu = false;
				}else {
					System.out.println("You picked 1 card more than once");
				}
			}
			
			attackCalc (p2, p1, cardPick, targetPick, p1, p2, rand);
			
			minionsAttack(p2,p1);
			
			if (p2.useNP()) {
				useAOENP(p2, p1, p2.npMultiplier, p2.npBoost);
			}
			
			if (p1.HP <= 0) {
				break;
			}
			
			// Stuff to do after player 2 turn ends
			turnCount++;
			if (p2.sCoolDown1 > 0) {
				p2.sActive1--;
				p2.sCoolDown1--;
				if (p2.sActive1 == 0) {
					p2.skillEnd1();			
				}
			}
			if (p2.sCoolDown2 > 0) {
				p2.sActive2--;
				p2.sCoolDown2--;
				if (p2.sActive2 == 0) {
					p2.skillEnd2();			
				}
			}
			if (p2.sCoolDown3 > 0) {
				p2.sActive3--;
				p2.sCoolDown3--;
				if (p2.sActive3 == 0) {
					p2.skillEnd3();			
				}
			}
			
		}
		
		displayBoard(p1,p2);
		
		if (p1.HP > p2.HP) {
			System.out.println("Player 1 - " + p1.name + ", has won!");
		}else if (p2.HP > p1.HP) {
			System.out.println("Player 2 - " + p2.name + ", has won!");
		}
		
	}
	
	public static void useAOENP(character attacker, character defender,double npMultiplier,double npBoost) {
		double npDamage = (attacker.ATK * npMultiplier * npBoost)/8;
		int finalNPDamage = (int) npDamage;
		
		System.out.println("It deals " + finalNPDamage + " damage to each enemy!");
		
		defender.HP -= finalNPDamage;
		defender.minion1HP -= finalNPDamage;
		defender.minion2HP -= finalNPDamage;
		defender.minion3HP -= finalNPDamage;
		
		pause();
	}
	public static void minionsAttack(character attacker, character defender) {
		if (attacker.minion1HP > 0) {
			defender.HP -= attacker.minionATK;
			System.out.println(attacker.minion1Name + " deals " + attacker.minionATK + " damage to enemy " + defender.name);
			pause();
		}
		if (attacker.minion2HP > 0) {
			defender.HP -= attacker.minionATK;
			System.out.println(attacker.minion2Name + " deals " + attacker.minionATK + " damage to enemy " + defender.name);
			pause();
		}
		if (attacker.minion3HP > 0) {
			defender.HP -= attacker.minionATK;
			System.out.println(attacker.minion3Name + " deals " + attacker.minionATK + " damage to enemy " + defender.name);
			pause();
		}
	}
	
	public static void pause() {
		try {
			Thread.sleep(1750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int choice(Scanner input,int cNum) { // Function for choices, modified to work with any amount of answers. Dummy proof.
			
			int pSelect = input.nextInt();
			while (pSelect > cNum || pSelect <= 0) { // If number isn't one of the choices, repeat
				pSelect = input.nextInt();
			}
		return pSelect;
	}
	
	public static void displayBoard (character p1,character p2) { // Displays the board with characters, minions and their healths
		
		// To make sure the character count doesn't change to keep the formatting, this is spread throughout the code
		String p1HP = Integer.toString(p1.HP);
		while (p1HP.length() < 5) {
			p1HP = " " + p1HP;	
			}
		String p2HP = Integer.toString(p2.HP);
		while (p2HP.length() < 5) {
			p2HP = " " + p2HP;	
			}
		
		//String p1m1HP = Integer.toString(p1.minion1HP);
		//String p1m2HP = Integer.toString(p1.minion2HP);
		//String p1m3HP = Integer.toString(p1.minion3HP);
		//String p2m1HP = Integer.toString(p2.minion1HP);
		//String p2m2HP = Integer.toString(p2.minion2HP);
		//String p2m3HP = Integer.toString(p2.minion3HP);
		
		System.out.println("");
		// Top row of minions
		if (p1.numOfMinions >= 2 && p2.numOfMinions >= 2) { // If both have 2 or more minions
			
			String p1m2HP = Integer.toString(p1.minion2HP);
			while (p1m2HP.length() < 5) {
				p1m2HP = " " + p1m2HP;	
				}
			String p2m2HP = Integer.toString(p2.minion2HP);
			while (p2m2HP.length() < 5) {
				p2m2HP = " " + p2m2HP;	
				}
			
			System.out.println("                3|" + p1.minion2Name + "|          |" + p2.minion2Name + "|3");
			System.out.println("                 | " + p1m2HP + "HP |        | " + p2m2HP + "HP |");
			
		}else if (p1.numOfMinions >= 2 && p2.numOfMinions < 2) { // If player 1 has 2 or more but player 2 has less
			
			String p1m2HP = Integer.toString(p1.minion2HP);
			while (p1m2HP.length() < 5) {
				p1m2HP = " " + p1m2HP;	
				}
			
			System.out.println("                3|" + p1.minion2Name + "|");
			System.out.println("                 | " + p1m2HP + "HP |");
			
		}else if (p1.numOfMinions < 2 && p2.numOfMinions >= 2){ // If player 1 has less than 2 but player 2 has 2 or more
		
			String p2m2HP = Integer.toString(p2.minion2HP);
			while (p2m2HP.length() < 5) {
				p2m2HP = " " + p2m2HP;	
				}
			
			System.out.println("                                     |" + p2.minion2Name + "|3");
			System.out.println("                                    | " + p2m2HP + "HP |");
			
		}else { // If neither have 2 or more minions
			System.out.println("\n");
		}
		
		// Middle row
		
		System.out.println("  |---------|                                      |---------|");
		if (p1.numOfMinions >= 1 && p2.numOfMinions >= 1) { // If both have at least 1 minion
			
			String p1m1HP = Integer.toString(p1.minion1HP);
			while (p1m1HP.length() < 5) {
				p1m1HP = " " + p1m1HP;	
				}
			String p2m1HP = Integer.toString(p2.minion1HP);
			while (p2m1HP.length() < 5) {
				p2m1HP = " " + p2m1HP;	
				}
			
			System.out.println(" 1|" + p1.name + "|  2|" + p1.minion1Name + "|            |" + p2.minion1Name + "|2  |" + p2.name + "|1");
			System.out.println("  | " + p1HP + "HP |   | " + p1m1HP + "HP |    VS    | " + p2m1HP + "HP |   | " + p2HP + "HP |");
			
		}else if (p1.numOfMinions >= 1 && p2.numOfMinions < 1){ // If only player 1 has at least 1 minion
			
			String p1m1HP = Integer.toString(p1.minion1HP);
			while (p1m1HP.length() < 5) {
				p1m1HP = " " + p1m1HP;	
				}
			
			System.out.println(" 1|" + p1.name + "|  2|" + p1.minion1Name + "|                         |" + p2.name + "|1");
			System.out.println("  | " + p1HP + "HP |   | " + p1m1HP + "HP |    VS                  | " + p2HP + "HP |");
		}else if (p1.numOfMinions < 1 && p2.numOfMinions >= 1) { // If only player 2 has at least 1 minion
			
			String p2m1HP = Integer.toString(p2.minion1HP);
			while (p2m1HP.length() < 5) {
				p2m1HP = " " + p2m1HP;	
				}
			
			System.out.println(" 1|" + p1.name + "|                         |" + p2.minion1Name + "|2  |" + p2.name + "|1");
			System.out.println("  | " + p1HP + "HP |                  VS    | " + p2m1HP + "HP |   | " + p2HP + "HP |");
		}else {
			System.out.println("\n");
		}
		System.out.println("  |---------|                                      |---------|");
		
		// Bottom minion row
		
		if (p1.numOfMinions >= 3 && p2.numOfMinions >= 3) { // If both have 3 or more minions
			
			String p1m3HP = Integer.toString(p1.minion3HP);
			while (p1m3HP.length() < 5) {
				p1m3HP = " " + p1m3HP;	
				}
			String p2m3HP = Integer.toString(p2.minion3HP);
			while (p2m3HP.length() < 5) {
				p2m3HP = " " + p2m3HP;	
				}
			
			System.out.println("                4|" + p1.minion3Name + "|          |" + p2.minion3Name + "|4");
			System.out.println("                 | " + p1m3HP + "HP |        | " + p2m3HP + "HP |");
			
		}else if (p1.numOfMinions >= 3 && p2.numOfMinions < 3) { // If player 1 has 3 but player 2 has less
			
			String p1m3HP = Integer.toString(p1.minion3HP);
			while (p1m3HP.length() < 5) {
				p1m3HP = " " + p1m3HP;	
				}
			
			System.out.println("                4|" + p1.minion3Name + "|");
			System.out.println("                 | " + p1m3HP + "HP |");
			
		}else if (p1.numOfMinions < 3 && p2.numOfMinions >= 3){ // If player 1 has less than 3 but player 2 has 3
		
			String p2m3HP = Integer.toString(p2.minion3HP);
			while (p2m3HP.length() < 5) {
				p2m3HP = " " + p2m3HP;	
				}
			
			System.out.println("                                     |" + p2.minion3Name + "|4");
			System.out.println("                                    | " + p2m3HP + "HP |");
			
		}else { // If neither have 2 or more minions
			System.out.println("\n");
		}
		System.out.println("");
	}
	
	public static void attackCalc (character attacker, character defender,int[] cardPick, int targetPick, character p1, character p2, Random rand) { // Player 1 attacks		
		String[] attack = new String[3]; // Cards used to attack
		// Damage variables
		double[] cardModifier = new double[3]; // damage modifier for card types
		double cardDamage; // Each turn, 3 cards, 3 attacks, to be used in calculations
		int finalCardDamage; // Final damage
		// Critical variables
		double[] critCardModifier = new double[3]; // critical generation modifier for card types
		double stars; // Amount of stars
		int finalStars; // Amount of stars in integers
		// NP gain variables
		double[] npGainModifier = new double[3];
		double npGainAmount;
		int finalNPGainAmount;
		
		int hitCount = 0;
		
		for (int i = 0; i < 3; i++) {
			attack[i] = attacker.tempDeck[cardPick[i]-1];
			if (attack[i] == "Buster") { // Deals lots of damage, generates no gauge, generates decent stars.
				cardModifier[i] = 1.5;
				npGainModifier[i] = 0;
				critCardModifier[i] = 0.4;
				hitCount = attacker.hitCount[0];
			}else if (attack[i] == " Arts ") { // Deals medium damage, generates lots of gauge, doesn't generate stars
				cardModifier[i] = 1.0;
				npGainModifier[i] = 3.0;
				critCardModifier[i] = 0;
				hitCount = attacker.hitCount[1];
			}else if (attack[i] == "Quick ") { // Deals least damage, generates decent gauge, generates lots of stars
				cardModifier[i] = 0.8;
				npGainModifier[i] = 1.0;
				critCardModifier[i] = 0.8;
				hitCount = attacker.hitCount[2];
			}
			
			// Starting card effect, Buster increases damage, Arts increases NP gain, quick increases crit generation
			if (attack[0] == "Buster") {
				cardModifier[i] += 0.5;
			}else if (attack[0] == " Arts ") {
				npGainModifier[i] = npGainModifier[i]*2;
			}else if (attack[0] == "Quick ") {
				critCardModifier[i] += 0.2;
			}
			
			// Effects of attack
			// Damage
			cardDamage = (attacker.ATK * (cardModifier[i] + (cardModifier[i]*0.2*i)))/10; 
			// NP Gain
			npGainAmount = attacker.NPGAIN * (npGainModifier[i] + (npGainModifier[i]*0.5*i)) * hitCount;
			// Crit generating
			stars = attacker.STARGEN * (critCardModifier[i] + (critCardModifier[i] + (0.5*i))) * hitCount;
			
			
			// Critical hit calculation
			if (rand.nextInt(101) <= attacker.critChance) {
				System.out.println("Critical Hit!");
				cardDamage = cardDamage*2;
				npGainAmount = npGainAmount*2;
				stars = stars*2;
			}
			
			// Making the numbers nice
			finalCardDamage = (int) cardDamage;
			finalNPGainAmount = (int) npGainAmount;
			finalStars = (int) stars;
			
			System.out.println("\n" + (i+1) + "." + attack[i] + " card:");
			System.out.println(finalCardDamage + " Damage dealt" + "\n" + finalNPGainAmount + "% NP gained" + "\n" + finalStars + "% Crit-chance generated"); // implement NP gain and critical
			
			if (targetPick == 1) { // Deals damage to chosen target
				defender.HP -= finalCardDamage;
			}else if (targetPick ==2){
				defender.minion1HP -= finalCardDamage;
			}else if (targetPick ==3){
				defender.minion2HP -= finalCardDamage;
			}else if (targetPick ==4){
				defender.minion3HP -= finalCardDamage;
			}
			attacker.npGauge += finalNPGainAmount; // Adding NP gained
			attacker.critChance += finalStars; // Adding stars to critchance
			
			try { // Pause code
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			displayBoard(p1,p2);
			
			try {
				Thread.sleep(2250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
}

/*
displayBoard should do something look like this:
Need to make a string for HP to be displayed because when HP goes down, there won't be the same amount of characters



                3|  Jerry |          |Lancelot|3
                 |  2500HP |        |  2500HP |
  |---------|                                      |---------|
 1|Gilgamesh|  2| Enkidu |            |Galahad |2  | Arthur  |1
  | 15000HP |   | 10000HP |    VS    |  4000HP |   | 15000HP |
  |---------|                                      |---------|
                                     | Gawain |4
                                    |  2500HP |

Damage formula: [ATK * (Card modifier) * (Card order modifier) * (Crit or not)]/10
NP formula: NPGainrate * (Card modifier) * (Card order modifier) * Hitcount


 */
