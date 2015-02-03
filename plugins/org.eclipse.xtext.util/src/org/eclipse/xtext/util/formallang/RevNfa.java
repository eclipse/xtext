/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.List;

import org.eclipse.xtext.util.formallang.RevNfa.State;

/**
 * Base class for NFAs with revisions and shared immutable objects.
 * 
 * If one NFA is derived from another immutable NFA, it can reuse the unmodified objects of that immutable NFA. This
 * becomes possible because the {@link State} objects do NOT hold references to their NFA, and therefore, can belong to
 * more than one NFA at the time.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class RevNfa<T> implements Nfa<State<T>> {

	public static abstract class State<T> {

		abstract public int getFollowerCount();

		abstract protected int[] getFollowers();

		abstract public int getPrecederCount();

		abstract protected int[] getPreceeders();

		abstract public T getToken();

		abstract protected int getTokenId();
	}

	public int getFollowerCount(State<T> state) {
		return state.getPrecederCount();
	}

	@Override
	public abstract List<State<T>> getFollowers(State<T> state);

	public int getPrecederCount(State<T> state) {
		return state.getFollowerCount();
	}

	public abstract List<State<T>> getPreceders(State<T> state);

	public boolean isStart(State<T> state) {
		return state == getStart();
	}

	public boolean isStartOrStop(State<T> state) {
		return isStart(state) || isStop(state);
	}

	public boolean isStop(State<T> state) {
		return state == getStop();
	}

}
