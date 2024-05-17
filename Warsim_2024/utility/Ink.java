package utility;
import warrior.*;
import weapon.*;
import armour.*;

/*
 * Class for all of our in games prints
 */
public class Ink {
  
  public Ink() {
    // do nothing
  } // constructor

  // colour palette thingy to give ink access to ANSI codes
  String ANSI_BOLD = "\u001B[1m";
  String ANSI_RESET = "\u001B[0m"; // resets colours to terminal's default       
  String ANSI_RED = "\u001B[31m";
  String ANSI_GREEN = "\u001B[32m";
  String ANSI_BLUE = "\u001B[34m";
  String ANSI_YELLOW = "\u001B[33m";

  public void welcome() {
    System.out.print(ANSI_YELLOW);
    System.out.printf("""
      __        __             _             ____   ___ ____  _  _   
      \\ \\      / /_ _ _ __ ___(_)_ __ ___   |___ \\ / _ \\___ \\| || |  
       \\ \\ /\\ / / _` | '__/ __| | '_ ` _ \\    __) | | | |__) | || |_ 
        \\ V  V / (_| | |  \\__ \\ | | | | | |  / __/| |_| / __/|__   _|
         \\_/\\_/ \\__,_|_|  |___/_|_| |_| |_| |_____|\\___/_____|  |_|  
         \n\n
        """);
        System.out.print(ANSI_RESET);
  } // welcome()
  // I was going to change the font too... but you worked too hard on those backslashes and I didn't have the heart to delete it.

  public void printWarriorMenu() {
    System.out.print(ANSI_BLUE);
    System.out.printf("""
      ░█░█░█▀█░█▀▄░█▀▄░▀█▀░█▀█░█▀▄░░░▀█▀░█░█░█▀█░█▀▀
      ░█▄█░█▀█░█▀▄░█▀▄░░█░░█░█░█▀▄░░░░█░░░█░░█▀▀░█▀▀
      ░▀░▀░▀░▀░▀░▀░▀░▀░▀▀▀░▀▀▀░▀░▀░░░░▀░░░▀░░▀░░░▀▀▀\n
   """);
    System.out.println(ANSI_BOLD + "Choose your warrior:\n"
      + ANSI_RESET + "   Human (PRESS 1)\n   Elf (PRESS 2)\n   Orc (PRESS 3)\n");
  } // warriorMenu()

  public void printWeaponMenu() {
    System.out.print(ANSI_RED);
    System.out.printf("""
      ░█░█░█▀▀░█▀█░█▀█░█▀█░█▀█░░░▀█▀░█░█░█▀█░█▀▀
      ░█▄█░█▀▀░█▀█░█▀▀░█░█░█░█░░░░█░░░█░░█▀▀░█▀▀
      ░▀░▀░▀▀▀░▀░▀░▀░░░▀▀▀░▀░▀░░░░▀░░░▀░░▀░░░▀▀▀\n
        """);

    // updated menu to add new weapon types: Rusty Trusty Spoon and Cannon!
    System.out.println(ANSI_BOLD + "Pick your Weapon:\n"
    + ANSI_RESET + "   Trusty Rusty Spoon (PRESS 1)\n   Dagger (PRESS 2)\n   Sword (PRESS 3)\n   Axe (PRESS 4)\n   Cannon (PRESS 5)");
  } // weaponMenu()

  public void printArmourMenu() {
    System.out.print(ANSI_GREEN);
    System.out.printf("""
      ░█▀█░█▀▄░█▄█░█▀█░█░█░█▀▄░░░▀█▀░█░█░█▀█░█▀▀
      ░█▀█░█▀▄░█░█░█░█░█░█░█▀▄░░░░█░░░█░░█▀▀░█▀▀
      ░▀░▀░▀░▀░▀░▀░▀▀▀░▀▀▀░▀░▀░░░░▀░░░▀░░▀░░░▀▀▀\n
        """);
    
    // updated menu to add new armour types
    System.out.println(ANSI_BOLD + "Pick your Armour:\n" 
    + ANSI_RESET + "   Potato Sack (PRESS 1)\n   Leather (PRESS 2)\n   Chainmail (PRESS 3)\n   Platemail (PRESS 4)\n   Adamantium (PRESS 5)");
  } // armourMenu()

  public void printAttackMenu() {
    System.out.print(ANSI_GREEN);
    System.out.printf("""
      ░█▀█░▀█▀░▀█▀░█▀█░█▀▀░█░█░█
      ░█▀█░░█░░░█░░█▀█░█░░░█▀▄░▀
      ░▀░▀░░▀░░░▀░░▀░▀░▀▀▀░▀░▀░▀\n
        """);
    System.out.println(ANSI_BOLD + "Attack Type?:\n" + ANSI_RESET + "   Normal (PRESS 1)\n   Heavy (PRESS 2)");
  } // attackMenu

  public void enemyAttack(){
  System.out.print(ANSI_RED);
  System.out.printf("""
    ░█▀▀░█▀█░█▀▀░█▄█░█░█░░░█▀█░▀█▀░▀█▀░█▀█░█▀▀░█░█░█
    ░█▀▀░█░█░█▀▀░█░█░░█░░░░█▀█░░█░░░█░░█▀█░█░░░█▀▄░▀
    ░▀▀▀░▀░▀░▀▀▀░▀░▀░░▀░░░░▀░▀░░▀░░░▀░░▀░▀░▀▀▀░▀░▀░▀\n
      """);
  System.out.print(ANSI_RESET);
}

  public void printStats(Warrior player, Warrior enemy, Weapon pWeapon, Weapon eWeapon, Armour pArmour, Armour eArmour) {
    System.out.print(ANSI_YELLOW);
    System.out.println("\n****************************************************");
    
    System.out.printf("* %-33s%-33s\n",
      "Player: " + player.getWarriorType(), "Enemy: " + enemy.getWarriorType());
    
    System.out.printf("* Health: %-25dHealth: %-25d\n", player.getHealth(), 
      enemy.getHealth());
    
    System.out.printf("* Strength: %-23dStrength: %-23d\n", 
      player.getStrength(), enemy.getDexterity());
    
    System.out.printf("* Dexterity: %-22dDexterity: %-22d\n", 
      player.getDexterity(), enemy.getDexterity());
    
    System.out.printf("* Weapon: %-25sWeapon: %-25s\n", pWeapon.getWeaponType(), 
      eWeapon.getWeaponType()); 
      
    System.out.printf("* Armour: %-25sArmour: %-25s\n", pArmour.getArmourType(),
    eArmour.getArmourType()); 
      
    System.out.println("****************************************************\n");
    System.out.print(ANSI_RESET);
  }

  public void printGameOver(String winner) {
    System.out.print(ANSI_RED);
    System.out.printf("""
      ▄████  ▄▄▄       ███▄ ▄███▓▓█████     ▒█████   ██▒   █▓▓█████  ██▀███  
      ██▒ ▀█▒▒████▄    ▓██▒▀█▀ ██▒▓█   ▀    ▒██▒  ██▒▓██░   █▒▓█   ▀ ▓██ ▒ ██▒
     ▒██░▄▄▄░▒██  ▀█▄  ▓██    ▓██░▒███      ▒██░  ██▒ ▓██  █▒░▒███   ▓██ ░▄█ ▒
     ░▓█  ██▓░██▄▄▄▄██ ▒██    ▒██ ▒▓█  ▄    ▒██   ██░  ▒██ █░░▒▓█  ▄ ▒██▀▀█▄  
     ░▒▓███▀▒ ▓█   ▓██▒▒██▒   ░██▒░▒████▒   ░ ████▓▒░   ▒▀█░  ░▒████▒░██▓ ▒██▒
      ░▒   ▒  ▒▒   ▓▒█░░ ▒░   ░  ░░░ ▒░ ░   ░ ▒░▒░▒░    ░ ▐░  ░░ ▒░ ░░ ▒▓ ░▒▓░
       ░   ░   ▒   ▒▒ ░░  ░      ░ ░ ░  ░     ░ ▒ ▒░    ░ ░░   ░ ░  ░  ░▒ ░ ▒░
     ░ ░   ░   ░   ▒   ░      ░      ░      ░ ░ ░ ▒       ░░     ░     ░░   ░ 
           ░       ░  ░       ░      ░  ░       ░ ░        ░     ░  ░   ░     
                                                          ░                   \n\n %s  
        """, winner + " wins!" + ANSI_RESET);
  } // printGameOver()

} // class
