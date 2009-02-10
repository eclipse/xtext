/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import java.util.Iterator;

import org.eclipse.xtext.parser.packrat.consumers.RecoveryState;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class RecoveryStateTest extends TestCase {
	
	private RecoveryState recoveryState;

	protected void setUp() {
		recoveryState = createRecoveryState();
	}
	
	protected abstract RecoveryState createRecoveryState();

	public void testSimple_01() {
		recoveryState.announceNextLevel();
		assertEquals(1, recoveryState.size());
		recoveryState.announceLevelFinished();
		assertEquals(0, recoveryState.size());
		// no exception
		recoveryState.assertLevelIsReset();
	}
	
	public void testSimple_02() {
		for (int i = 0; i < 100; i++) {
			recoveryState.announceNextLevel();
			assertEquals(-1, recoveryState.getCurrentValue());
		}
		assertEquals(100, recoveryState.size());
		for (int i = 0; i < 100; i++) {
			assertEquals(-1, recoveryState.getCurrentValue());
			recoveryState.announceLevelFinished();
		}
		assertEquals(0, recoveryState.size());
		// no exception
		recoveryState.assertLevelIsReset();
	}
	
	public void testAnnounceNextLevel() {
		recoveryState.announceNextLevel();
		assertEquals(-1, recoveryState.getCurrentValue());
		recoveryState.announceNextLevel();
		assertEquals(-1, recoveryState.getCurrentValue());
	}

	public void testAnnounceNextStep() {
		recoveryState.announceNextLevel();
		recoveryState.announceNextStep();
		assertEquals(0, recoveryState.getCurrentValue());
		recoveryState.announceNextStep();
		assertEquals(1, recoveryState.getCurrentValue());
	}
	
	public void testAnnounceNextPath() {
		recoveryState.announceNextLevel();
		recoveryState.announceNextPath();
		assertEquals(0, recoveryState.getCurrentValue());
		recoveryState.announceNextPath();
		assertEquals(1, recoveryState.getCurrentValue());
	}

	public void testAnnounceLevelFinished() {
		recoveryState.announceNextLevel();
		recoveryState.setCurrentValue(5);
		recoveryState.announceNextLevel();
		recoveryState.announceLevelFinished();
		assertEquals(5, recoveryState.getCurrentValue());
	}
	
	public void testOrder() {
		for (int i = 0; i < 100; i++) {
			recoveryState.announceNextLevel();
			recoveryState.setCurrentValue(i);
		}
		Iterator<Integer> iter = recoveryState.iterator();
		int i = 0;
		while(iter.hasNext()) {
			int val = iter.next();
			assertEquals(i, val);
			i++;
		}
		assertEquals(100, i);
	}
	
	public void testCopyAndOrder() {
		for (int i = 0; i < 100; i++) {
			recoveryState.announceNextLevel();
			recoveryState.setCurrentValue(i);
		}
		RecoveryState copy = recoveryState.copy();
		Iterator<Integer> iter = copy.iterator();
		int i = 0;
		while(iter.hasNext()) {
			int val = iter.next();
			assertEquals(i, val);
			i++;
		}
		assertEquals(100, i);
	}
	
	public void testCopyEmpty() {
		RecoveryState copy = recoveryState.copy();
		assertEquals(0, copy.size());
	}
	
	public void testException_01() {
		try {
			recoveryState.announceNextPath();
			fail("IndexOutOfBoundsException expected");
		} catch( IndexOutOfBoundsException e) {
			// nothing to do
		}
	}
	
	public void testException_02() {
		try {
			recoveryState.announceNextStep();
			fail("IndexOutOfBoundsException expected");
		} catch( IndexOutOfBoundsException e) {
			// nothing to do
		}
	}
	
	public static class Simple extends RecoveryStateTest {
		@Override
		protected RecoveryState createRecoveryState() {
			return new RecoveryState();
		}
	}
	
	public static class CopyEmpty extends RecoveryStateTest {
		@Override
		protected RecoveryState createRecoveryState() {
			return new RecoveryState().copy();
		}
	}
	
	public static class CopyFilled extends RecoveryStateTest {
		@Override
		protected RecoveryState createRecoveryState() {
			RecoveryState result = new RecoveryState();
			for (int i = 0; i < 100; i++) {
				result.announceNextLevel();
			}
			for (int i = 0; i < 100; i++) {
				result.announceLevelFinished();
			}
			return result.copy();
		}
	}
	
	public static class CopyFilledWithOne extends RecoveryStateTest {
		@Override
		protected RecoveryState createRecoveryState() {
			RecoveryState result = new RecoveryState();
			result.announceNextLevel();
			result.announceLevelFinished();
			return result.copy();
		}
	}

}
