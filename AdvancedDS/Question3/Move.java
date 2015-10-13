package Question3_1;

/**
 * The com.caseyscarborough.puzzle.Move class handles the moving of the pieces on
 * the puzzle board. Each method is static, and it has a
 * private constructor to prevent instantiation of the class.
 *
 * @author kajal vaishnav
 */
public class Move 
{
  /**
   * Returns a new state with the blank space swapped
   * with the tile above it.
   * @param state The state being operated on.
   * @return null if the state is invalid, the new state if valid.
   */
  public static State up(State state, int n) 
  {
    if (state.blankIndex > n-1)
    {
    	return new State(state, state.blankIndex - n,n);
    }
    
    return null;
  }

  /**
   * Returns a new state with the blank space swapped
   * with the tile below it.
   * @param state The state being operated on.
   * @return null if the state is invalid, the new state if valid.
   */
  public static State down(State state, int n) 
  {
    if (state.blankIndex < (n*(n-1)))
    {
    	return new State(state, state.blankIndex + n,n);
    }
    
    return null;
  }

  /**
   * Returns a new state with the blank space swapped
   * with the tile to the left of it.
   * @param state The state being operated on.
   * @return null if the state is invalid, the new state if valid.
   */
  public static State left(State state,int n) 
  {
    if (state.blankIndex % n > 0)
    {
    	return new State(state, state.blankIndex - 1,n);
    }
    
    return null;
  }

  /**
   * Returns a new state with the blank space swapped
   * with the tile to the right of it.
   * @param state The state being operated on.
   * @return null if the state is invalid, the new state if valid.
   */
  public static State right(State state,int n) 
  {
    if (state.blankIndex % n < n-1)
    {
    	return new State(state, state.blankIndex + 1,n);
    }
    
    return null;
  }
}