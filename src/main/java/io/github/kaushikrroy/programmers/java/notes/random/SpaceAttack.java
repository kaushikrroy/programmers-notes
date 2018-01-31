package io.github.kaushikrroy.programmers.java.notes.random;

/**
 * <p>This was a 3 hours coding round in which we had to code 1 problem having 50 test cases. Only those students were
 * selected for the next round who passed all the test cases. Here is the question:
 * <br>You’ll be given a grid as below:
 * <br>
 * <br>                           0 1 0 2 0
 * <br>                           0 2 2 2 1
 * <br>                           0 2 1 1 1
 * <br>                           1 0 1 0 0
 * <br>                           0 0 1 2 2
 * <br>                           1 1 0 0 1
 * <br>                           x x S x x
 * <br>In the grid above,
 * <br>1: This cell has a coin.
 * <br>2: This cell has an enemy.
 * <br>0: It contains nothing.
 * <br>The highlighted(yellow) zone is the control zone. S is a spaceship that we need to control so that we can get maximum coins.
 * <br>Now, S’s initial position will be at the center and we can only move it right or left by one cell or do not move.
 * <br>At each time, the non-highlighted part of the grid will move down by one unit.
 * <br>We can also use a bomb but only once. If we use that, all the enemies in the 5×5 region above the control zone will be killed.
 * <br>If we use a bomb at the very beginning, the grid will look like this:
 * <br>
 * <br>                           0 1 0 2 0
 * <br>                           0 0 0 0 1
 * <br>                           0 0 1 1 1
 * <br>                           1 0 1 0 0
 * <br>                           0 0 1 0 0
 * <br>                           1 1 0 0 1
 * <br>                           x x S x x
 * <br>As soon as, the spaceship encounters an enemy or the entire grid has come down, the game ends.
 * <br>For example,
 * <br>At the very first instance, if we want to collect a coin we should move left( coins=1). This is because when the grid
 * comes down by 1 unit we have a coin on the second position and by moving left we can collect that coin. Next, we should
 * move right to collect another coin( coins=2).
 * <br>After this, remain at the same position( coins=4).
 * <br>This is the current situation after collecting 4 coins.
 * <br>
 * <br>0 1 0 2 0                0 1 0 0 0
 * <br>0 2 2 2 1 --&gt;after using 0 0 0 0 1
 * <br>x x S x x --&gt;bomb        x x S x x
 * <br>Now, we can use the bomb to get out of this situation. After this, we can collect at most 1 coin. So maximum coins=5.</p>
 */
public class SpaceAttack {
}
