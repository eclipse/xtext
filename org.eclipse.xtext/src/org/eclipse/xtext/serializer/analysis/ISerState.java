/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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