package RPG2018;

public class enemyStats {

	// Stats for battle
		public String name;
		public String eClass;
		public int hp; // Health points (100-200)
		public int maxhp;
		public int atk; // Attack (physical attack) (1-30)
		public int def; // Defense (physical defense) (1-30)
		public int spatk; // Special Attack (non-physical attack) (1-30)
		public int spdef; // Special Defense (non-physical defense) (1-30)
		public int spd; // Speed (1-30)
		public int acc; // Accuracy (Hidden stat) (1)
		public int eva; // Evasion (Hidden stat) (0)
		public int[] moveID; // list of known move's ID. Max of 4
		
		// Constructors
		public enemyStats (int e) { // Creates character that has base minimum stats
			
			//Constant Hidden stats
			acc = 1;
			eva = 0;
			
			if (e == 1) {
				name = "Flesh-eating Ghoul";
				eClass = "Undead";
				
				hp = 100;
				maxhp = 100;
				atk = 15;
				def = 30;
				spatk = 15;
				spdef = 30;
				spd = 15;
			
				moveID = new int[] {13,14,15,16};
				
			}if (e == 2) {
				name = "Swine Prince";
				eClass = "Beast";
				
				hp = 150;
				maxhp = 150;
				atk = 30;
				def = 40;
				spatk = 20;
				spdef = 40;
				spd = 10;
			
				moveID = new int[] {17,18,19,20};
				
			}if (e == 3) {
				name = "Necromancer";
				eClass = "Undead";
				
				hp = 150;
				maxhp = 150;
				atk = 30;
				def = 50;
				spatk = 50;
				spdef = 50;
				spd = 20;
			
				moveID = new int[] {21,22,23,24};
				
			}if (e == 4) {
				name = "Shuffling Horror";
				eClass = "Eldritch";
				
				hp = 300;
				maxhp = 300;
				atk = 70;
				def = 40;
				spatk = 70;
				spdef = 40;
				spd = 30;
			
				moveID = new int[] {25,26,27,28};
				
			}if (e == 5) {
				name = "True-Ancestor";
				eClass = "Cosmic";
				
				hp = 500;
				maxhp = 500;
				atk = 50;
				def = 50;
				spatk = 50;
				spdef = 50;
				spd = 50;
			
				moveID = new int[] {29,30,31,32};
				
			}
		}
		
		public enemyStats(enemyStats another) { // Creates temporary stats for battle to account for buffs and debuffs
			this.hp = another.hp;
			this.atk = another.atk;
			this.def = another.def;
			this.spatk = another.spatk;
			this.spdef = another.spdef;
			this.spd = another.spd;
			this.acc = another.acc;
			this.eva = another.eva;
		}
		
		public void printSheet() {
			System.out.println(name + ":");
			System.out.println("Type - " + eClass);
			System.out.println("HP - " + hp);
			System.out.println("Attack - " + atk);
			System.out.println("Defense - " + def);
			System.out.println("Special Attack - " + spatk);
			System.out.println("Special Defense - " + spdef);
			System.out.println("Speed - " + spd);
		}
}
