import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class character {
	
	String name;
	// Self Stats
	int HP;
	int ATK;
	int oATK;
	double NPGAIN;
	double oNPGAIN;
	double STARGEN;
	double oSTARGEN;
	int[] hitCount = new int[3];
	ArrayList<String> deck = new ArrayList<String>();
	int critChance;
	double npBoost;
	double npMultiplier;
	
	// Card manipulation
	Random rand = new Random();
	String[] tempDeck = new String[5];// for each turn
	ArrayList<Integer> cardPickIndex = new ArrayList<Integer>();
	int cardPick;
	
	// Skill Stats
	String sName1; // Skill name
	int sActive1; // How long the skill is active
	int sCoolDown1; // Skill cooldown
	String sName2;
	int sActive2;
	int sCoolDown2;
	String sName3;
	int sActive3;
	int sCoolDown3;
	
	int npGauge;
	
	// Minion Stats
	int numOfMinions;
	
	String minion3Name;
	int minion3HP;
	String minion2Name;
	int minion2HP;
	String minion1Name;
	int minion1HP;
	int minionHP;
	int minionATK;
	int minionoATK;
	
	public character() {
		
		this.npGauge = 0;
		this.npBoost = 1;
		this.sCoolDown1 = 0;
		this.sCoolDown2 = 0;
		this.sCoolDown3 = 0;
		
		this.critChance = 0;
	}
	
	public abstract Boolean useNP();
	public abstract void useSkill1();
	public abstract void skillEnd1();
	public abstract void useSkill2();
	public abstract void skillEnd2();
	public abstract void useSkill3();
	public abstract void skillEnd3();
	
	public void pickSkills() {
		System.out.println("\n" + "Skills:");
		System.out.println("\n" + " 1|" + this.sName1 + "|  2|" + this.sName2 + "|  3|" + this.sName3 + "|                 4|Attack/Continue|");
	}
	
	public void pickCards() {
		for (int i = 0; i < 5; i++) {
			cardPick = rand.nextInt(15);
			while (cardPickIndex.contains(cardPick)) {
				cardPick = rand.nextInt(15);
			}
			cardPickIndex.add(cardPick); // Index of cards available on your turn
		}
		
		for (int i = 0; i < 5; i++) {
			tempDeck[i] = deck.get(cardPickIndex.get(i)); 
			
			if (tempDeck[i] == "B") { // Makes cards leggible. Upon reviewing code, I realize that I could've just had them be leggible from the start. I don't want to delete in case it breaks code.
				tempDeck[i] = "Buster";
			}else if (tempDeck[i] == "A") {
				tempDeck[i] = " Arts ";
			}else if (tempDeck[i] == "Q") {
				tempDeck[i] = "Quick ";
			}
		}
		System.out.println("\n" + "Attack:");
		System.out.println("\n" + "  |------|  |------|  |------|  |------|  |------|");
		System.out.println(" 1|"+tempDeck[0]+"| 2|"+tempDeck[1]+"| 3|"+tempDeck[2]+"| 4|"+tempDeck[3]+"| 5|"+tempDeck[4]+"|");
		System.out.println("  |------|  |------|  |------|  |------|  |------|");
		cardPickIndex.clear(); // clears for the next time round
	}
	
	public void attackDisplay(int t) {
		if (t%2 == 1) {
			System.out.println("Turn " + t + " - Player 1");
		}else {
			System.out.println("Turn " + t + " - Player 2");
		}
		
		System.out.println("\n" + "Critical chance: " + this.critChance + "%");
		
		// Show NP Stuff
		String[] npMeter = {" "," "," "," "," "," "," "," "," "," "};
		String finalNPMeter = "<";
		for (int i = 0; i < (this.npGauge/10); i++) {
			npMeter[i] = "~";
			if (npMeter[9] == "~") { // If it's at max already, break it
				break;
			}
		}
		for (int i = 0; i < 10; i++) {
			finalNPMeter += npMeter[i];
		}
		finalNPMeter += ">";
		
		System.out.println("Noble-Phantasm Gauge:");
		System.out.println(finalNPMeter);
		
	}
	
	public void cantDoThat() { // just a method saying you cant do that
		System.out.println("That skill is on cooldown");
	}
	
	public void pause() {
		try {
			Thread.sleep(1750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


/*
Skill display

1|    KotRT     |
1|   Charisma   |
1|   Instinct   |
1|     WoDS     |
1|Primieval Rune|
1| Gate of Skye |
1|   Charisma   |
1| Golden Rule  |
1|     ToB      |

 1|     TRT      |  2|   Charisma   |  3|   Instinct   |  4|Attack|

Attacking should display something like this:

  -------|  |------|  |------|  |------|  |------|
 1|Buster| 2| Arts | 3| Arts | 4|Quick | 5|Quick |
  |------|  |------|  |------|  |------|  |------|

*/