/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RecoveryStatePerformanceTest extends TestCase {

	private static int ITEMS = 75;
	
	private static int LOOPS = 10000;

	private static int COPY_LOOPS = LOOPS * 5;
	
	private static int STEPS = 5;
	
	private ArrayList<Integer> stack;
	private RecoveryState recoveryState;
	
	protected void setUp() {
		recoveryState = new RecoveryState();
		stack = new ArrayList<Integer>();
	}
	
	public void testStack() {
		for (int l = 0; l < LOOPS; l++) {
			for (int i = 0; i < ITEMS; i++) {
				stack.add(-1);
				for (int s = 0; s < STEPS; s++) {
					stack.set(i, stack.get(i) + 1);
				}
			}
			for (int i = ITEMS - 1; i >= 0; i--) {
				for (int s = 0; s < STEPS; s++) {
					stack.set(i, stack.get(i) + 1);
				}
				stack.remove(stack.size() - 1);
			}
		}
	}
	
	public void testCopyStack() {
		for (int i = 0; i < ITEMS; i++) {
			stack.add(-1);
		}
		for (int l = 0; l < COPY_LOOPS; l++) {
			ArrayList<Integer> newStack = new ArrayList<Integer>(stack);
			for (int i = 0; i < ITEMS; i++) {
				newStack.add(-1);
				for (int s = 0; s < STEPS; s++) {
					newStack.set(i, newStack.get(i) + 1);
				}
			}
		}
	}
	
	public void testRecoveryState() {
		for (int l = 0; l < LOOPS; l++) {
			for (int i = 0; i < ITEMS; i++) {
				recoveryState.announceNextLevel();
				for (int s = 0; s < STEPS; s++) {
					recoveryState.announceNextPath();
				}
			}
			for (int i = 0; i < ITEMS; i++) {
				for (int s = 0; s < STEPS; s++) {
					recoveryState.announceNextStep();
				}
				recoveryState.announceLevelFinished();
			}
		}
	}
	
	public void testCopyRecoveryState() {
		for (int i = 0; i < ITEMS; i++) {
			recoveryState.announceNextLevel();
		}
		for (int l = 0; l < COPY_LOOPS; l++) {
			RecoveryState copy = recoveryState.copy();
			for (int i = 0; i < ITEMS; i++) {
				copy.announceNextLevel();
				for (int s = 0; s < STEPS; s++) {
					copy.announceNextPath();
				}
			}
		}
	}
}
