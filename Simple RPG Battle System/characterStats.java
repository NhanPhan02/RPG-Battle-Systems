package RPG2018;

public class characterStats {

	// Stats for battle
	public String name;
	public String cClass;
	public int hp; // Health points 
	public int maxhp; // Max stats for readability
	public int atk; // Attack (physical attack) (1-30)
	public int maxatk;
	public int def; // Defense (physical defense) (1-30)
	public int maxdef; 
	public int spatk; // Special Attack (non-physical attack) (1-30)
	public int maxspatk;
	public int spdef; // Special Defense (non-physical defense) (1-30)
	public int maxspdef;
	public int spd; // Speed (1-30)
	public int maxspd;
	public int acc; // Accuracy (Hidden stat) (1)
	public int eva; // Evasion (Hidden stat) (0)
	public int[] moveID; // list of known move's ID. Max of 4

	
	// Constructors
	public characterStats (String n,int c) { // Creates character that has base minimum stats
		name = n;
		
		// Hidden stats
		acc = 1;
		eva = 0;
		
		if (c == 1) {
			cClass = "Crusader";
			moveID = new int[] {1,2,3,4};
			maxhp = 100;
			hp = 100;
			atk = 10;
			maxatk = 10;
			def = 10;
			maxdef = 10;
			spatk = 10;
			maxspatk = 10;
			spdef = 10;
			maxspdef = 10;
			spd = 10;
			maxspd = 10;
		}else if (c == 2) {
			cClass = "Highwayman";
			moveID = new int[] {5,6,7,8};
			maxhp = 80;
			hp = 80;
			atk = 15;
			maxatk = 15;
			def = 7;
			maxdef = 7;
			spatk = 15;
			maxspatk = 15;
			spdef = 7;
			maxspdef = 7;
			spd = 15;
			maxspd = 15;
		}else {
			cClass = "Abomination";
			moveID = new int[] {9,10,11,12};
			maxhp = 150;
			hp = 150;
			atk = 7;
			maxatk = 7;
			def = 7;
			maxdef = 7;
			spatk = 7;
			maxspatk = 7;
			spdef = 7;
			maxspdef = 7;
			spd = 7;
			maxspd = 7;
		}
		
	}
	
	public characterStats(characterStats another) { // Creates temporary stats for battle to account for stat changes
		this.hp = another.hp;
		this.atk = another.atk;
		this.def = another.def;
		this.spatk = another.spatk;
		this.spdef = another.spdef;
		this.spd = another.spd;
		this.acc = another.acc;
		this.eva = another.eva;
	}

	public void allocateStats(int sP,int statBoost) {
		if (sP == 1) {
			this.hp += statBoost;
			this.maxhp += statBoost;
		}else if (sP == 2) {
			this.atk += statBoost;
			this.maxatk += statBoost;
		}else if (sP == 3) {
			this.def += statBoost;
			this.maxdef += statBoost;
		}else if (sP == 4) {
			this.spatk += statBoost;
			this.maxspatk += statBoost;
		}else if (sP == 5) {
			this.spdef += statBoost;
			this.maxspdef += statBoost;
		}else if (sP == 6) {
			this.spd += statBoost;
			this.maxspd += statBoost;
		}
	}
	
	public void printSheet() { // max stats besides health are not the maximum value, just the base.
		System.out.println(name + ":");
		System.out.println("Class - " + cClass);
		System.out.println("HP - " + hp + "/" + maxhp);
		System.out.println("Attack - " + atk + "/" + maxatk);
		System.out.println("Defense - " + def + "/" + maxdef);
		System.out.println("Special Attack - " + spatk + "/" + maxspatk);
		System.out.println("Special Defense - " + spdef + "/" + maxspdef);
		System.out.println("Speed - " + spd + "/" + maxspd);
		System.out.println("");
	}
	
}
	
	

