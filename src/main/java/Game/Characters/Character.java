package Game.Characters;

/**
 * A class to represent characters in the game.
 */
public class Character {
    private int[] healthBars;
    private int attackValue;
    private int defenseValue;
    private String characterName;
    public boolean isAlive;
    public int currentHealthIndex = 0;

    /**
     * Construct a Character object.
     *
     * @param health an array to represent the character's health bar.
     * @param attack attack value of the character.
     * @param defense defense value of the character.
     * @param Name the name of the character.
     */
    public Character(int[] health, int attack, int defense, String Name) {
        healthBars = health;
        attackValue = attack;
        defenseValue = defense;
        characterName = Name;
        isAlive = true;
    }

    /**
     * Return the character's name.
     *
     * @return a string showing the character's name.
     */
    public String getCharacterName() {
        return characterName;
    }

    /**
     * Return the character's health bar.
     *
     * @return integer array representing the character's health.
     */
    public int[] getHealthBars() {
        return healthBars;
    }

    /**
     * Return the character's attack value.
     *
     * @return an integer representing the character's attack value.
     */
    public int getAttackValue() {
        return attackValue;
    }

    /**
     * Return the character's defense value.
     *
     * @return an integer representing the character's defense value.
     */
    public int getDefenseValue() {
        return defenseValue;
    }

    /**
     * Return the character's current status.
     * @return a boolean to indicate if the character is still alive.
     */
    public boolean getCurrentStatus() {
        return isAlive;
    }

    /**
     * Performs an attack on the defender.
     *
     * @param defender character being attacked in the attack event.
     */
    public void attack(Character defender) {
        int damage = calculateDamage(defender);
        defender.takeDamage(damage);
        System.out.println(this.characterName + " attacks " + defender.getCharacterName() +
                " for " + damage + " damage.");

    }

    /**
     * Returns the calculated amount of damage dealt to the defender
     * based on the attacker's attack value and the defender's defense value.
     *
     * @param defender character being attacked in this attack event.
     * @return an integer representing the damage value imposed on defender.
     */
    public int calculateDamage(Character defender){
        double damageReduction = (double) 100 / (100 + defender.defenseValue);
        int damageTaken = (int) (this.attackValue * damageReduction);
        return damageTaken;

    }

    /**
     * Apply damage to the character by updating its health bar.
     * Case 1: character is considered not alive if all the health bars are depleted.
     * Case 2: if the current health bar is depleted, update the next available health bar.
     *
     * @param damage an integer representing the damage value.
     */
    public void takeDamage(int damage) {

        int remainingDamage = damage;
        while (remainingDamage > 0) {

            /* Case 1 */
            if (currentHealthIndex >= healthBars.length) {
                isAlive = false;
                break;
            }
            /* Case 2 */
            if (healthBars[currentHealthIndex] - remainingDamage <= 0) {
                remainingDamage -= healthBars[currentHealthIndex];
                healthBars[currentHealthIndex] = 0;
                currentHealthIndex++;
            }
            else {
                healthBars[currentHealthIndex] -= remainingDamage;
                break;
            }
        }
    }

}
