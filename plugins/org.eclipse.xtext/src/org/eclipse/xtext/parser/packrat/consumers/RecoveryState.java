/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import java.util.Iterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RecoveryState implements IRecoveryState, Iterable<Integer> {

	public static final int CLUSTER_SIZE = 50;
	
	public static final int OUTER_GROWTH = 20;
	
	private int[] currentDecisions;
	
	private int[][] allDecisions;
	
	private int level;
	
	private int allLevel;
	
	public RecoveryState() {
		this.currentDecisions = new int[CLUSTER_SIZE]; // expect reasonable depth of decision tree
		this.level = -1;
		this.allLevel = -1;
		this.allDecisions = null;
	}
	
	protected RecoveryState(int[][] allDecisions, int[] decisions, int level, int allLevel) {
		this.level = level;
		this.allLevel = allLevel;
		if (allDecisions != null && allLevel >= CLUSTER_SIZE) {
			int newSize = allLevel / CLUSTER_SIZE;
			int timesGrown = newSize / OUTER_GROWTH + 1;
			this.allDecisions = new int[timesGrown * OUTER_GROWTH][];
			for (int i = 0; i <= allLevel / CLUSTER_SIZE; i++)
				this.allDecisions[i] = allDecisions[i].clone();
			this.currentDecisions = this.allDecisions[allLevel / CLUSTER_SIZE];
		} else 
			this.currentDecisions = decisions.clone();
	}
	
	public void announceNextPath() {
		currentDecisions[level]++;
	}
	
	public void announceNextStep() {
		currentDecisions[level]++;
	}
	
	public void announceNextLevel() {
		level++;
		allLevel++;
		if (level == CLUSTER_SIZE) {
			if (allDecisions == null) {
				allDecisions = new int[OUTER_GROWTH][];
				allDecisions[0] = currentDecisions;
			} else {
				if ((allLevel % (CLUSTER_SIZE * OUTER_GROWTH)) == 0) {
					int[][] prevAllDecisions = allDecisions;
					allDecisions = new int[OUTER_GROWTH + prevAllDecisions.length][];
					System.arraycopy(prevAllDecisions, 0, allDecisions, 0, prevAllDecisions.length);
				}
			}
			if (allDecisions[allLevel / CLUSTER_SIZE] == null) {
				allDecisions[allLevel / CLUSTER_SIZE] = new int[CLUSTER_SIZE];
				currentDecisions = allDecisions[allLevel / CLUSTER_SIZE];
			}
			level = 0;
		}
		currentDecisions[level] = -1;
	}
	
	public void announceLevelFinished() {
		level--;
		allLevel--;
		if (level == -1 && allLevel != -1) {
			level = CLUSTER_SIZE - 1;
			currentDecisions = allDecisions[allLevel / CLUSTER_SIZE];
		}
	}
	
	public void replay(INonTerminalConsumer consumer) {
		// TODO: implement me
	}
	
	public RecoveryState copy() {
		return new RecoveryState(allDecisions, currentDecisions, level, allLevel);
	}
	
	public void assertLevelIsReset() {
		if (allLevel != -1)
			throw new IllegalStateException("RecoveryState has not been reset properly: '" + level + "'");
	}

	// the next methods are for testing purpose only
	
	public void setCurrentValue(int value) {
		if (allLevel < 0)
			throw new IllegalStateException("cannot set current value if state is not yet initialized.");
		currentDecisions[level] = value;
	}
	
	public int getCurrentValue() {
		if (allLevel < 0)
			throw new IllegalStateException("cannot get value if state is not yet initialized.");
		return currentDecisions[level];
	}
	
	public int size() {
		return allLevel + 1;
	}
	
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int cursor = -1;

			public boolean hasNext() {
				return cursor < allLevel;
			}
			public Integer next() {
				if (allDecisions == null)
					return currentDecisions[++cursor];
				cursor++;
				return allDecisions[cursor / CLUSTER_SIZE][cursor % CLUSTER_SIZE];
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
}
