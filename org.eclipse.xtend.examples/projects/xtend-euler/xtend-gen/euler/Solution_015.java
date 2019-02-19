/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sebastian Zarnekow
 * See https://github.com/szarnekow/xtend-euler
 */
package euler;

import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;

/**
 * Starting in the top left corner of a 2×2 grid, there are 6 routes (without backtracking) to the bottom right corner.
 * How many routes are there through a 20×20 grid?
 * 
 * @see http://projecteuler.net/problem=15
 */
@SuppressWarnings("all")
public class Solution_015 {
  public static void main(final String[] args) {
    InputOutput.<Long>println(new Solution_015(20).solve());
  }
  
  private List<Long> solutions;
  
  private int internalGridSize;
  
  private int numberOfNodes;
  
  public Solution_015(final int gridSize) {
    this.internalGridSize = (gridSize + 1);
    this.numberOfNodes = (this.internalGridSize * this.internalGridSize);
    this.solutions = CollectionLiterals.<Long>newArrayList();
    final Consumer<Integer> _function = (Integer it) -> {
      this.solutions.add(Long.valueOf((-1L)));
    };
    new IntegerRange(0, (this.numberOfNodes - 2)).forEach(_function);
    this.solutions.add(Long.valueOf(1L));
  }
  
  public Long solve() {
    return this.solve(0);
  }
  
  public Long solve(final int position) {
    boolean _isValid = this.isValid(position);
    if (_isValid) {
      Long _xifexpression = null;
      boolean _done = this.done(position);
      if (_done) {
        _xifexpression = this.solutions.get(position);
      } else {
        long _xblockexpression = (long) 0;
        {
          Long _solve = this.solve(this.moveRight(position));
          Long _solve_1 = this.solve(this.moveDown(position));
          long result = ((_solve).longValue() + (_solve_1).longValue());
          this.solutions.set(position, Long.valueOf(result));
          _xblockexpression = result;
        }
        _xifexpression = Long.valueOf(_xblockexpression);
      }
      return _xifexpression;
    }
    return Long.valueOf(0L);
  }
  
  public int moveDown(final int atIndex) {
    return (atIndex + this.internalGridSize);
  }
  
  public int moveRight(final int atIndex) {
    int _xblockexpression = (int) 0;
    {
      if ((((atIndex + 1) % this.internalGridSize) == 0)) {
        return (-1);
      }
      _xblockexpression = (atIndex + 1);
    }
    return _xblockexpression;
  }
  
  public boolean isValid(final int index) {
    return ((index >= 0) && (index < this.numberOfNodes));
  }
  
  public boolean done(final int index) {
    Long _get = this.solutions.get(index);
    return ((_get).longValue() != (-1));
  }
}
