/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RecoveryState {

	private int[] decisions;
	
	private int level;
	
	public RecoveryState() {
		this.decisions = new int[100]; // expect reasonable depth of decision tree
		this.level = 0;
	}
	
	RecoveryState(int[] decisions, int level) {
		this.decisions = decisions.clone();
		this.level = level;
	}
	
	public void announceNextPath() {
		decisions[level]++;
	}
	
	public void announceNextStep() {
		decisions[level]++;
	}
	
	public void announceNextLevel() {
		level++;
		decisions[level] = 0;
	}
	
	public void announceLevelFinished() {
		level--;
	}
	
	public void replay(INonTerminalConsumer consumer) {
		// TODO: implement me
	}
	
	public RecoveryState copy() {
		return new RecoveryState(decisions, level);
	}
	
}
