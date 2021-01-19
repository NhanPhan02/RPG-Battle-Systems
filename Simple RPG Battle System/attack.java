package RPG2018;

public class attack {
	String moveName; // Name of attack
	// Move effects
	double dmg; // Damage dealt (modifier of attack/special attack stat)
	int heal; // Healing done
	int atkc; // Change in character attack stat
	int atke; // Change in enemy attack stat
	int defc; // Change in character defense stat
	int defe; // Change in enemy defense stat
	int spatkc; // Change in character special attack stat
	int spatke; // Change in enemy special attack stat
	int spdefc; // Change in character special defense stat
	int spdefe; // Change in enemy special defense stat
	int spdc; // Change in character speed stat
	int spde; // Change in enemy speed stat
	double accc; // Change in character accuracy stat
	double acce; // Change in enemy accuracy stat
	double evac; // Change in character evasion stat
	double evae; // Change in enemy evasion stat
	
	double crit; // Crit chance
	
	double moveAcc; // Move accuracy 
	
	int type; // 0 for physical, 1 for special
	
	public attack(int moveID) { // Constructs current attack in use
		if (moveID == 1) { 
			moveName = "Smite"; 
			type = 0;
			dmg = 1.0;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = -2;
			spatkc = 1;
			spatke = 0;
			spdefc = 1;
			spdefe = -2;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;
			
			crit = 0.0;
			
			moveAcc = 0.85;

		}else if (moveID == 2){
			moveName = "Holy Lance"; 
			type = 1;
			dmg = 1.2;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = -2;
			spatke = 0;
			spdefc = 0;
			spdefe = -2;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;
			
			crit = 0.065;
			
			moveAcc = 0.85;

		}else if (moveID == 3) {
			moveName = "Disorienting Blow"; 
			type = 0;
			dmg = 0.75;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = -0.05;
			evac = 0.0;
			evae = -0.1;
			
			crit = 0.0;
			
			moveAcc = 0.75;
			
		}else if (moveID == 4) {
			moveName = "Bulwark of faith"; 
			type = 1;
			dmg = 0;
			heal = 40;
			atkc = 4;
			atke = 0;
			defc = 4;
			defe = 0;
			spatkc = 4;
			spatke = 0;
			spdefc = 4;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.1;
			acce = 0.0;
			evac = 0.1;
			evae = 0.0;
			
			crit = 0.065;
			
			moveAcc = 10.0;
		
		}else if (moveID == 5) {
			moveName = "Wicked Slice"; 
			type = 0;
			dmg = 1.15;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;
			
			crit = 0.1;
			
			moveAcc = 0.85;
			
		}else if (moveID == 6) {
			moveName = "Point-Blank Shot"; 
			type = 1;
			dmg = 1.5;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = -4;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = -4;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;
			
			crit = 0.5;
			
			moveAcc = 0.95;
			
		}else if (moveID == 7) {
			moveName = "Tracking Shot"; 
			type = 1;
			dmg = 0.2;
			heal = 0;
			atkc = 5;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 5;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.1;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;
			
			crit = 0.0;
			
			moveAcc = 0.95;
			
		}else if (moveID == 8) {
			moveName = "Open Vein"; 
			type = 0;
			dmg = 0.85;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = -5 ;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = -5;
			accc = 0.0;
			acce = -0.05;
			evac = 0.0;
			evae = 0.0;
			
			crit = 0.0;
			
			moveAcc = 0.95;
			
		}else if (moveID == 9) {
			moveName = "Monstrous Transformation"; 
			type = 0;
			dmg = 0.0;
			heal = -80;
			atkc = 30;
			atke = 0;
			defc = 20;
			defe = 0;
			spatkc = 20;
			spatke = 0;
			spdefc = 20;
			spdefe = 0;
			spdc = 30;
			spde = 0;
			accc = 0.05;
			acce = 0.0;
			evac = 0.05;
			evae = 0.0;
			
			crit = 0.0;
			
			moveAcc = 10;
			
		}else if (moveID == 10) {
			moveName = "Rake"; 
			type = 0;
			dmg = 1.3;
			heal = -10;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;
			
			crit = 0.15;
			
			moveAcc = 0.9;
			
		}else if (moveID == 11) {
			moveName = "Blind Rage"; 
			type = 0;
			dmg = 2;
			heal = -25;
			atkc = 5;
			atke = -3;
			defc = -2;
			defe = 0;
			spatkc = 0;
			spatke = -3;
			spdefc = -2;
			spdefe = 0;
			spdc = 5;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;
			
			crit = 0.0;
			
			moveAcc = 0.7;
			
		}else if (moveID == 12) {
			moveName = "Absolution"; 
			type = 1;
			dmg = 0;
			heal = 50;
			atkc = -3;
			atke = 0;
			defc = 3;
			defe = 0;
			spatkc = -3;
			spatke = 0;
			spdefc = 3;
			spdefe = 0;
			spdc = -15;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;
			
			crit = 0;
			
			moveAcc = 10;
			
		}else if (moveID == 13){ // Ghoul 1
			moveName = "Rend"; 
			type = 0;
			dmg = 0.9;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;
			
			crit = 0.16;
			
			moveAcc = 0.8875;
			       
		}else if (moveID == 14) { // Ghoul 1 again. Move 1 is the monsters preferred move. Doesnt have to make 4 attacks
			moveName = "Rend"; 
			type = 0;
			dmg = 0.9;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;

			crit = 0.16;
			
			moveAcc = 0.8875;
			          
		}else if (moveID == 15) { // Ghoul 2 
			moveName = "Skull Toss"; 
			type = 0;
			dmg = 0.8;
			heal = 0;
			atkc = 0;
			atke = -1;
			defc = 0;
			defe = -1;
			spatkc = 0;
			spatke = -1;
			spdefc = 0;
			spdefe = -1;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = -0.05;
			evac = 0.0;
			evae = -0.05;
			
			crit = 0.1;
			
			moveAcc = 0.8875;
			
		}else if (moveID == 16) { // Ghoul 3
			moveName = "Howl"; 
			type = 1;
			dmg = 0.4;
			heal = 0;
			atkc = 0;
			atke = -3;
			defc = 0;
			defe = -3;
			spatkc = 0;
			spatke = -3;
			spdefc = 0;
			spdefe = -3;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = -0.05;
			evac = 0.0;
			evae = -0.1;
			
			crit = 0.0;
	
			moveAcc = 1;

		}else if (moveID == 17) { 
			moveName = "Wild flailing"; 
			type = 0;
			dmg = 1.4;
			heal = -10;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = -0.1;
			evae = 0.0;

			crit = 0.12;
			
			moveAcc = 0.725;
			          
		}else if (moveID == 18) { 
			moveName = "Enraged Screeching"; 
			type = 1;
			dmg = 0.1;
			heal = 0;
			atkc = 0;
			atke = -4;
			defc = 0;
			defe = -4;
			spatkc = 0;
			spatke = -4;
			spdefc = 0;
			spdefe = -4;
			spdc = 0;
			spde = -4;
			accc = 0.0;
			acce = 0.0;
			evac = -0.1;
			evae = 0.0;

			crit = 0.0;
			
			moveAcc = 1;
			          
		}else if (moveID == 19) { 
			moveName = "Wild flailing"; 
			type = 0;
			dmg = 1.4;
			heal = -10;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = -0.1;
			evae = 0.0;

			crit = 0.12;
			
			moveAcc = 0.725;
			          
		}else if (moveID == 20) { 
			moveName = "Vomit"; 
			type = 1;
			dmg = 0.65;
			heal = 10;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = -5;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = -5;
			spdc = 0;
			spde = -20;
			accc = 0.0;
			acce = -0.1;
			evac = 0.0;
			evae = 0.0;

			crit = 0.12;
			
			moveAcc = 0.825;
			          
		}else if (moveID == 21) { 
			moveName = "Draining Touch"; 
			type = 1;
			dmg = 0.5;
			heal = 20;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;

			crit = 0.06;
			
			moveAcc = 1.025;
			          
		}else if (moveID == 22) { 
			moveName = "Bone mace"; 
			type = 0;
			dmg = 1.2;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;

			crit = 0.2;
			
			moveAcc = 0.875;
			          
		}else if (moveID == 23) { 
			moveName = "Undead armor"; 
			type = 0;
			dmg = 0;
			heal = 5;
			atkc = 0;
			atke = 0;
			defc = 10;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = -0.5;
			evae = 0.0;

			crit = 0.0;
			
			moveAcc = 10;
			          
		}else if (moveID == 24) { 
			moveName = "Drag down under"; 
			type = 1;
			dmg = 1.5;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;

			crit = 0.2;
			
			moveAcc = 0.95;
			          
		}else if (moveID == 25) { 
			moveName = "Lacerate"; 
			type = 1;
			dmg = 1.0;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = -5;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = -5;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;

			crit = 0.05;
			
			moveAcc = 1.1;
			          
		}else if (moveID == 26) { 
			moveName = "Echoing Disassembly"; 
			type = 1;
			dmg = 0.6;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.05;
			evae = 0.0;

			crit = 0.07;
			
			moveAcc = 1.2;
			          
		}else if (moveID == 27) { 
			moveName = "Undulations"; 
			type = 0;
			dmg = 1.5;
			heal = -10;
			atkc = 0;
			atke = 0;
			defc = -10;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;

			crit = 0.0;
			
			moveAcc = 2.0;
			          
		}else if (moveID == 28) { 
			moveName = "Abyssal Gaze"; 
			type = 1;
			dmg = 0.1;
			heal = 0;
			atkc = 0;
			atke = -7;
			defc = 0;
			defe = -5;
			spatkc = 0;
			spatke = -7;
			spdefc = 0;
			spdefe = -5;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;

			crit = 0.05;
			
			moveAcc = 0.85;
			          
		}else if (moveID == 29) { 
			moveName = "Ancestry of the Crimson Moon"; 
			type = 1;
			dmg = 0;
			heal = 0;
			atkc = 25;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 25;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;

			crit = 0.0;
			
			moveAcc = 10;
			          
		}else if (moveID == 30) { 
			moveName = "Divine Authority"; 
			type = 1;
			dmg = 0.1;
			heal = 10;
			atkc = 5;
			atke = -5;
			defc = 5;
			defe = -5;
			spatkc = 5;
			spatke = -5;
			spdefc = 5;
			spdefe = -5;
			spdc = 5;
			spde = -5;
			accc = 0.1;
			acce = 0.1;
			evac = -0.1;
			evae = -0.1;

			crit = 0.05;
			
			moveAcc = 1.2;
			          
		}else if (moveID == 31) { 
			moveName = "Erase"; 
			type = 1;
			dmg = 2;
			heal = 0;
			atkc = 0;
			atke = 0;
			defc = 0;
			defe = 0;
			spatkc = 0;
			spatke = 0;
			spdefc = 0;
			spdefe = 0;
			spdc = 0;
			spde = 0;
			accc = 0.0;
			acce = 0.0;
			evac = 0.0;
			evae = 0.0;

			crit = 0.0;
			
			moveAcc = 1.5;
			          
		}else if (moveID == 32) { 
			moveName = "Primal Outrage"; 
			type = 0;
			dmg = 0.8;
			heal = 0;
			atkc = 0;
			atke = -5;
			defc = 0;
			defe = -5;
			spatkc = 0;
			spatke = -5;
			spdefc = 0;
			spdefe = -5;
			spdc = 0;
			spde = -5;
			accc = 0.0;
			acce = -0.05;
			evac = 0.0;
			evae = -0.05;

			crit = 1.0;
			
			moveAcc = 0.85;
			          
		}
	}
	
}
