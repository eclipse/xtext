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

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class MutableRevNfa<T> extends RevNfa<T> {

	public interface IdFunction<T> {
		int getId(T t);
	}

	private final IdFunction<T> idFunction;

	private final List<State<T>> states;

	private MutableRevNfa(T start, T stop, IdFunction<T> idFunction) {
		this.states = Lists.newArrayList(start, stop);
		this.idFunction = idFunction;

	}

	public void connect(State<T> preceding, State<T> following) {

	}

	public State<T> create(T token) {

	}

	public void disconnect(State<T> preceding, State<T> following) {

	}

	public void disconnectAll(State<T> state) {
	}

	public void disconnectFollowers(State<T> state) {
	}

	public void disconnectPreceders(State<T> state) {
	}

	public ImmutableRevNfa<T> freeze() {

	}

	public MutableRevNfa(ImmutableRevNfa<T> old) {
	}

	@Override
	public List<State<T>> getFollowers(State<T> state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<State<T>> getPreceders(State<T> state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State<T> getStart() {
		return null;
	}

	@Override
	public State<T> getStop() {
		return null;
	}

	public void remove(State<T> state) {

	}

	public State<T> replace(State<T> oldState, T newToken) {

	}

}
