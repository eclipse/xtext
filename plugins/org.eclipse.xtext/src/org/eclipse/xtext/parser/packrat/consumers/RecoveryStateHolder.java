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
public class RecoveryStateHolder {

	private RecoveryState state;
	
	public void setState(RecoveryState state) {
		this.state = state;
	}

	public RecoveryState getState() {
		return state;
	}
	
	public void announceNextPath() {
		state.announceNextPath();
	}
	
	public void announceNextStep() {
		state.announceNextStep();
	}
	
	public void announceNextLevel() {
		state.announceNextLevel();
	}
	
	public void announceLevelFinished() {
		state.announceLevelFinished();
	}
}
