
public class Arthur extends character{

	public Arthur() {
		super();
		name = " Arthur  ";
		
		HP = 50000;
		ATK = 10000;
		oATK = 10000;
		NPGAIN = 1.0;
		oNPGAIN = 1.0;
		STARGEN = 0.3;
		oSTARGEN = 0.3;
		hitCount[0]=1; // Buster cards
		hitCount[1]=2; // Arts cards
		hitCount[2]=3; // Quick cards
		
		npBoost = 1;
		npMultiplier = 2;
		
		//Skills
		sName1 = "    KotRT     ";
		sName2 = "   Charisma   ";
		sName3 = "   Instinct   ";
		
		//Cards
		for (int i = 0; i < 6; i++) {
			deck.add("B");
		}
		for (int i = 0; i < 7; i++) {
			deck.add("A");
		}
		for (int i = 0; i < 2; i++) {
			deck.add("Q");
		}
		
		numOfMinions = 3;
		minionHP = 10000;
		minionATK = 500;
		minionoATK = 500;
		
		minion3Name = " Gawain ";
		minion3HP = minionHP;
		minion2Name = "Lancelot";
		minion2HP = minionHP;
		minion1Name = "Galahad ";
		minion1HP = minionHP+1500;
	}
	
	public String toString(){
		return "Hero:" + "\n" + "Arthur - " + this.HP + "HP" + "\n" + "\n"+
				"Minions:" + "\n" + 
				minion3Name + " - " + this.minion3HP + "HP" + "\n" + 
				minion1Name + " - " + this.minion1HP + "HP" + "\n" + 
				minion2Name + " - " + this.minion2HP + "HP" + "\n";
	}
	public Boolean useNP() {
		if (this.npGauge >= 100) {
			this.npGauge = 0;
			System.out.println("Noble-Phantasm is fully charged");
			pause();
			System.out.println("Arthur's blade glows with a blinding light.");
			pause();
			System.out.println("The blade is slowly brought upwards...");
			pause();
			System.out.println("And swung with all his might");
			pause();
			System.out.println("The enemy forces are envelopped in light as Arthur calls the blade's name:");
			pause();
			System.out.println("\"Excalibur!\"");
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
		}else { // This skill is no longer cumulative, its a single turn NP buff
			System.out.println("Activate - Knights of the Round Table (Rank EX)");
			System.out.println("Excalibur's power has been unsealed");
			System.out.println("100% Noble-Phantasm Attack Up (1 turn)");
			System.out.println("(5 turn cooldown)");
			this.npBoost = 2;
			this.sCoolDown1 = 5;
			this.sActive1 = 1;
		}
	}
	public void skillEnd1() {
		System.out.println("Expired - Knights of the Round Table (Rank EX)");
		System.out.println("Excalibur's power is sealed");
		this.npBoost = 1;
	}
	
	public void useSkill2(){ // Buff
		if (this.sCoolDown2 > 0) {
			cantDoThat();
		}else {
		System.out.println("Activate - Charisma (Rank B)");
		System.out.println("18% Party Attack Up (3 turns)");
		System.out.println("(5 turn cooldown)");
		this.ATK += this.oATK*0.18;
		this.minionATK += this.minionoATK*0.18;
		this.sCoolDown2 = 5;
		this.sActive2 = 3;
		}
	}
	public void skillEnd2() { // End buff
		System.out.println("Expired - Charisma (Rank B)");
		this.ATK -= this.oATK*0.18;
		this.minionATK -= this.minionoATK*0.18;
	}
	
	public void useSkill3() { // Single turn benefit
		if (this.sCoolDown3 > 0) {
			cantDoThat();
		}else {
			this.critChance += 10;
			System.out.println("Activate - Instinct (Rank A)");
			System.out.println("Gain 8% critical chance");
			System.out.println("          |");
			System.out.println("          V");
			System.out.println("Critical chance: " + this.critChance + "%");
			System.out.println("(6 turn cooldown)");
			this.sCoolDown3 = 6;
			this.sActive3 = 7;
		}
	}
	public void skillEnd3() { // Has nothing to end
		
	}
	public void cantDoThat() {
		super.cantDoThat();
	}
	public void pause() {
		super.pause();
	}
}

