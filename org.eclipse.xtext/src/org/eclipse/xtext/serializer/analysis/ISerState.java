/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.List;

import org.eclipse.xtext.AbstractElement;

public interface ISerState {
	public enum SerStateType {
		ELEMENT, POP, PUSH, START, STOP;
	}

	//	ISerState getOpposite();

	List<? extends ISerState> getFollowers();

	List<? extends ISerState> getPrecedents();

	AbstractElement getGrammarElement();

	SerStateType getType();
}