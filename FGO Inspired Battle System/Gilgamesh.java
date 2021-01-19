
public class Gilgamesh extends character{

	public Gilgamesh() {
		super();
		name = "Gilgamesh";
		HP = 80000;
		ATK = 6000;
		oATK = 6000;
		NPGAIN = 0.3;
		oNPGAIN = 0.3;
		STARGEN = 0.3;
		oSTARGEN = 0.3;
		hitCount[0]=5; // Buster cards
		hitCount[1]=5; // Arts cards
		hitCount[2]=5; // Quick cards
		
		npBoost = 1;
		npMultiplier = 3;
		
		//Skills
		sName1 = "   Charisma   ";
		sName2 = " Golden Rule  ";
		sName3 = "     ToB      ";
		
		//Cards
		for (int i = 0; i < 6; i++) {
			deck.add("B");
		}
		for (int i = 0; i < 5; i++) {
			deck.add("A");
		}
		for (int i = 0; i < 4; i++) {
			deck.add("Q");
		}
		
		numOfMinions = 1;
		minionHP = 40000;
		minionATK = 1500;
		minionoATK = 1500;
		
		minion3HP = 0;
		minion2HP = 0;
		minion1Name = " Enkidu ";
		minion1HP = minionHP;
	}
	
	public Boolean useNP() {
		if (this.npGauge >= 100) {
			this.npGauge = 0;
			System.out.println("Noble-Phantasm is fully charged");
			pause();
			System.out.println("Gilgamesh pulls out a black and red object");
			pause();
			System.out.println("It's a segmented lance the size of an arming sword");
			pause();
			System.out.println("The segments start spinning opposite each other");
			pause();
			System.out.println("Space and time rips and tears as Gilgamesh laughs:");
			pause();
			System.out.println("\"Gaze upon me and Behold! Enuma Elish!\"");
			pause();
			
			return true;
		}
		else {
			return false;
		}
	}
	// Skills
	public void useSkill1() {
		if (this.sCoolDown1 > 0){
			cantDoThat();
		}else { 
			System.out.println("Activate - Charisma (Rank A+)");
			System.out.println("21% Party Attack Up (3 turns)");
			System.out.println("(5 turn cooldown)");
			this.ATK += this.oATK*0.21;
			this.minionATK += this.minionoATK*0.21;
			this.sCoolDown2 = 5;
			this.sActive2 = 3;
		}
	}
	public void skillEnd1() {
		System.out.println("Expired - Charisma (Rank A+)");
		this.ATK -= this.oATK*0.21;
		this.minionATK -= this.minionoATK*0.21;
	}
	
	public void useSkill2(){ // Buff
		if (this.sCoolDown2 > 0) {
			cantDoThat();
		}else {
		System.out.println("Activate - Golden Rule (Rank A+)");
		System.out.println("50% Noble-Phantasm Charge Rate (3 turns)");
		System.out.println("(6 turn cooldown)");
		this.NPGAIN += this.oNPGAIN*0.5;
		this.sCoolDown2 = 6;
		this.sActive2 = 3;
		}
	}
	public void skillEnd2() { // End buff
		System.out.println("Expired - Golden Rule (Rank A+)");
		this.NPGAIN -= this.oNPGAIN*0.5;
	}
	
	public void useSkill3() { // Single turn benefit and multi-turn benefit
		if (this.sCoolDown3 > 0) {
			cantDoThat();
		}else {
			this.critChance += 10;
			System.out.println("Activate - Treasury of Babylon (Rank EX)");
			System.out.println("Gain 30% Noble-Phantasm Charge");
			System.out.println("50% Increased Critical Gain Rate (3 turns)");
			System.out.println("(5 turn cooldown)");
			this.npGauge += 30;
			this.STARGEN += oSTARGEN*0.5;
			this.sCoolDown3 = 5;
			this.sActive3 = 3;
		}
	}
	public void skillEnd3() { 
		System.out.println("Expired - Treasury of Babylon (Rank EX)");
		this.STARGEN -= oSTARGEN*0.5;
	}
	public void cantDoThat() {
		super.cantDoThat();
	}
	public void pause() {
		super.pause();
	}
}

