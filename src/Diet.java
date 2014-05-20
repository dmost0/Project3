
/**
 *  Class Diet represents a diet.
 *
 */
public class Diet {
	
	// declare fields
	float meat, vegetablesFruit, drinks, other, targetCalorieAmount;
	
	/**
	 * Default constructor for class Diet; all fields assigned the value of 0.
	 * 
	 */
	public Diet()
	{
		// Set default instance variables to 0
		targetCalorieAmount = meat =  vegetablesFruit =  drinks = other = 0;
	}
	
	/**
	 * Set the values for Diet fields with this constructor
	 * @param m Value to set as the meat field
	 * @param v Value to set as the vegetablesFruit field
	 * @param d Value to set as the drinks field
	 * @param o Value to set as the other field
	 * @param t Value to set as the targetCalorieAmount field
	 * 
	 */
	public Diet(float m, float v, float d, float o, float t)
	{
		// assign parameter values to instance variables
		meat = m;
		vegetablesFruit = v;
		drinks = d;
		other = o;
		targetCalorieAmount = t;
	}

	/**
	 * get the meat field value
	 * @return Calories obtained from meat
	 */
	public float getMeat() {
		return meat;
	}

	/**
	 * Set the meat field value
	 * @param meat Calories obtained from meat
	 */
	public void setMeat(float meat) {
		this.meat = meat;
	}

	/**
	 * get the vegetablesFruit field value
	 * @return Calories obtained from vegetables and fruit
	 */
	public float getVegetablesFruit() {
		return vegetablesFruit;
	}

	/**
	 * Set the vegetablesFruit field value
	 * @param vegetablesFruit Calories obtained from vegetables and fruit
	 */
	public void setVegetablesFruit(float vegetablesFruit) {
		this.vegetablesFruit = vegetablesFruit;
	}

	/**
	 * get the drinks field value
	 * @return Calories obtained from drinks
	 */
	public float getDrinks() {
		return drinks;
	}

	/**
	 * Set the drinks field value
	 * @param drinks Calories obtained from drinks
	 */
	public void setDrinks(float drinks) {
		this.drinks = drinks;
	}

	/**
	 * get the other field value
	 * @return Calories obtained from other
	 */
	public float getOther() {
		return other;
	}

	/**
	 * Set the other field value
	 * @param other Calories obtained from other
	 */
	public void setOther(float other) {
		this.other = other;
	}
	
	/**
	 * get the targetCalorieAmount field value
	 * @return Calorie target amount
	 */
	public float getTargetCalorieAmount() {
		return targetCalorieAmount;
	}

	/**
	 * Set the targetCalorieAmount field value
	 * @param targetCalorieAmount the amount of calories targeted by the user
	 */
	public void setTargetCalorieAmount(float targetCalorieAmount) {
		this.targetCalorieAmount = targetCalorieAmount;
	}
	
	/**
	 * Get the amount of calories consumed
	 * @return calories consumed
	 */
	public float getCaloriesConsumed()
	{
		return meat + vegetablesFruit + drinks + other;
	}
	
	/**
	 * Calculates whether user has hit the target calorie amount or not.
	 * @return -1 if below target, 0 if exactly at target, 1 if above target.
	 */
	public float getOnTarget()
	{
		// User is below target value
		if(getCaloriesConsumed() < getTargetCalorieAmount())
			return -1;
		// User is at the target value
		else if (getCaloriesConsumed() == getTargetCalorieAmount())
			return 0;
		// User is above target value
		else{
			return 1;
		}
			
	}
}
