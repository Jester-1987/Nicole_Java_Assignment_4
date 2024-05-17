/* Starting file used is the one I originally handed in for Assignment 2 so there is no save game ability in this version.
 * I will most likely add that in the future as a personal project or as a part of my future capstone projects. */
import warrior.*;
import weapon.*;
import armour.*;
import weather.*;
import utility.*;

import java.util.Scanner;
import java.util.Random;

public class Warsim {
  // Objects
  public static Scanner input = new Scanner(System.in);
  public static Random randNum = new Random();
  public static Ink ink = new Ink();
  public static Weather weather;
  
  public static Warrior player; // player
  public static Weapon pWeapon; // player weapon
  public static Armour pArmour; // player armour

  public static Warrior enemy; // enemy
  public static Weapon eWeapon; // enemy weapon
  public static Armour eArmour; // enemy armour

  // Game Vars
  public static boolean gameOver = false;
  public static boolean playerTurn = true; // player starts
  public static String who = "Player";
  public static String winner = "";
  public static int choice = 0;
  public static int attackType = 0;
  public static int damage = 0;
  
  //================>>
  // main method
  public static void main(String[] args) {

    // Prints welcome message w/ASCII art ;)
    ink.welcome();

    // set a random weather for battle
    int weatherType = randNum.nextInt(3) + 1; // three different types of weather: Sunny, Fog, SnowStorm
    createWeather(weatherType);

    //=====================>>
    // Player Creation
    // Warrior
    ink.printWarriorMenu();
    choice = input.nextInt();
    createWarrior(who, choice);
    
    // Weapon
    ink.printWeaponMenu();
    choice = input.nextInt();
    createWeapon(who, choice);
    
    // Armour
    ink.printArmourMenu();
    choice = input.nextInt();
    createArmour(who, choice);

    // player is all setup
    // switch 'who' to Enemy
    who = "Enemy";

    //=====================>>
    // Enemy Creation
    // Warrior
    choice = randNum.nextInt(3) + 1;
    createWarrior(who, choice);

    // Weapon
    choice = randNum.nextInt(3) + 1; 
    createWeapon(who, choice);

    // Armour
    choice = randNum.nextInt(3) + 1; 
    createArmour(who, choice);

    

    //==================>>
    // Main Game Loop
    // PLAYER'S TURN
    while(!gameOver) {
      if(playerTurn) {
        // player code
        ink.printStats(player, enemy, pWeapon, eWeapon, pArmour, eArmour); // moved to inside game loop to show stat updates as the game progresses
        System.out.println("Your Turn!"); // print statement stating player's turn 
        ink.printAttackMenu();
        attackType = input.nextInt();
        damage = pWeapon.strike(attackType, 
          player.getDexterity(),
          player.getStrength());

        // take the damage and pass it into the enemy's armour
        // to reduce the damage
        if(damage > 0) { // if there is damage at all
          damage = eArmour.getFinalDamage(damage);
          
          // assign the damage amount to the enemy
          enemy.takeDamage(damage);

          // check to see if the enemy is dead!
          if(enemy.getHealth() <= 0) { // enemy is dead!
            winner = "Player";
            gameOver = !gameOver;
          }
        }
        else { // missed!
          System.out.println("Missed no damage!");
        }
      }
      // ENEMY'S TURN
      else {  
          ink.enemyAttack(); // displays high-definition graphics!       
          damage = eWeapon.strike(attackType, 
            enemy.getDexterity(),
            enemy.getStrength());
  
          // take the damage and pass it into the player's armour
          // to reduce the damage
          if(damage > 0) { // if there is damage at all
            damage = pArmour.getFinalDamage(damage);
            
            // assign the damage amount to the enemy
            player.takeDamage(damage);
  
            // check to see if the player is dead!
            if(player.getHealth() <= 0) { // player is dead!
              winner = "Enemy";
              gameOver = !gameOver;
            }
          }
          else { // missed!
            System.out.println("Missed no damage!");
          }
        }
        playerTurn = !playerTurn; // toggles turn each iteration
    }
    ink.printGameOver(winner);
    ink.printStats(player, enemy, pWeapon, eWeapon, pArmour, eArmour);

  } // main()

  //========================>>
  // Helper Methods
  public static void createWarrior(String who, int choice) {
    if(who.equals("Player")) { // player warrior creation
      switch (choice) {
        case 1: // Human
          player = new Human();
          player.setWarriorType("Human");
          break;
        case 2: // Elf
          player = new Elf();
          player.setWarriorType("Elf");
          break;
        case 3: // Orc
          player = new Orc();
          player.setWarriorType("Orc");
          break;
        default:
          System.out.println("Oops!");
          break;
      } // switch
    }
    else { // enemy warrior creation
      switch (choice) {
        case 1: // Human
          enemy = new Human();
          enemy.setWarriorType("Human");
          break;
        case 2: // Elf
          enemy = new Elf();
          enemy.setWarriorType("Elf");
          break;
        case 3: // Orc
          enemy = new Orc();
          enemy.setWarriorType("Orc");
          break;
        default:
          System.out.println("Oops!");
          break;
      } // switch
    }
  } // createWarrior()

  public static void createWeapon(String who, int choice) {
    switch (choice) {
      // first new weapon type. Placed here as it's the weakest
      case 1: 
      if(who.equals("Player")) {
        pWeapon = new RustySpoon();
        pWeapon.setWeaponType("Trusty Rusty Spoon");
      }
      else {
        eWeapon = new RustySpoon();
        eWeapon.setWeaponType("Trusty Rusty Spoon");
      }
      break;
      case 2: // Dagger
        if(who.equals("Player")) {
          pWeapon = new Dagger();
          pWeapon.setWeaponType("Dagger");
        }
        else {
          eWeapon = new Dagger();
          eWeapon.setWeaponType("Dagger");
        }
        break;
      case 3: // Sword
        if(who.equals("Player")) {
          pWeapon = new Sword();
          pWeapon.setWeaponType("Sword");
        }
        else {
          eWeapon = new Sword();
          eWeapon.setWeaponType("Sword");
        }
        break;
      case 4: // Axe
        if(who.equals("Player")) {
          pWeapon = new Axe();
          pWeapon.setWeaponType("Axe");
        }
        else {
          eWeapon = new Axe();
          eWeapon.setWeaponType("Axe");
        }
        break;
        // second new weapon type. Placed here as it's the most powerful! 
        case 5: // Cannon
        if(who.equals("Player")) {
          pWeapon = new Cannon();
          pWeapon.setWeaponType("Cannon");
        }
        else {
          eWeapon = new Cannon();
          eWeapon.setWeaponType("Cannon");
        }
        break;
      default:
        System.out.println("Oops!");
        break;
    } // switch
  } // createWeapon()

  public static void createArmour(String who, int choice) {
    switch (choice) {
      // first new armour type. Placed here as it's the weakest
      case 1: // Potato Sack
      if(who.equals("Player")) {
        pArmour = new PotatoSack();
        pArmour.setArmourType("PotatoSack");
      }
      else {
        eArmour = new PotatoSack();
        eArmour.setArmourType("PotatoSack");
      }
      break;
      case 2: // Leather
        if(who.equals("Player")) {
          pArmour = new Leather();
          pArmour.setArmourType("Leather");
        }
        else {
          eArmour = new Leather();
          eArmour.setArmourType("Leather");
        }
        break;
      case 3: // Chainmail
        if(who.equals("Player")) {
          pArmour = new Chainmail();
          pArmour.setArmourType("Chainmail");
        }
        else {
          eArmour = new Chainmail();
          eArmour.setArmourType("Chainmail");
        }
        break;
      case 4: // Platemail
        if(who.equals("Player")) {
          pArmour = new Platemail();
          pArmour.setArmourType("Platemail");
        }
        else {
          eArmour = new Platemail();
          eArmour.setArmourType("Platmail");
        }
        break;
      // second new armour type. Placed here as it's the strongest 
      case 5: // Adamantium
        if(who.equals("Player")) {
          pArmour = new Adamantium();
          pArmour.setArmourType("Adamantium");
        }
        else {
          eArmour = new Adamantium();
          eArmour.setArmourType("Adamantium");
        }
        break;
      default:
        System.out.println("Oops!");
        break;
    } // switch
  } // createArmour()

  // Creating Weather
  public static void createWeather(int weatherType) {
    switch (weatherType) {
      case 1: // Sunny
      weather = new Sunny();
      break;
      case 2: // Fog
      weather = new Fog();
      break;
      case 3: // SnowStorm
      weather = new SnowStorm();
      break;
    default:
      System.out.println("Are you in a vaccuum? In SPAAAAAAAAAACE!");
    } // switch
  } // createWeather()

} // class