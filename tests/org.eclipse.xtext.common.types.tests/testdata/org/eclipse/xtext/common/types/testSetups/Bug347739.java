/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

import java.util.Iterator;
import java.util.List;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug347739 {

	protected static class StackItem<T> {
		protected StackItem<T> parent;
		protected Iterator<T> parentIt;
		protected T value;

		public StackItem(Iterator<T> parentIt, T value) {
		}

		public StackItem(StackItem<T> parent, T value) {
		}

		public T peek() {
			return null;
		}

		public StackItem<T> pop() {
			return null;
		}

		public int size() {
			return 0;
		}

		@Override
		public String toString() {
			return "";
		}

		public StackItem<T> push(T value) {
			return null;
		}
	}

	protected static class TraceItem<STATE, STACKITEM> {
		protected TraceItem<STATE, STACKITEM> parent;
		protected StackItem<STACKITEM> stackitem;
		protected STATE state;

		public TraceItem(TraceItem<STATE, STACKITEM> parent, STATE state, StackItem<STACKITEM> stackitem) {
		}

		public List<STATE> asList() {
			return null;
		}

		@Override
		public String toString() {
			return "";
		}

		public int size() {
			return 0;
		}

	}

	public final static long UNREACHABLE = Long.MAX_VALUE;

	public static <STATE, TOKEN, STACKITEM> boolean canReach(Bug347739ThreeTypeParams<STATE, TOKEN, STACKITEM> pda, STATE state,
			Iterator<STACKITEM> stack, Bug347739OneTypeParam<STATE> matches, Bug347739OneTypeParam<STATE> canPass) {
		return true;
	}

	protected static <T> StackItem<T> createStack(Iterator<T> stack) {
		return null;
	}

	public static <STATE, TOKEN, STACKITEM> long distanceTo(Bug347739ThreeTypeParams<STATE, TOKEN, STACKITEM> pda,
			Iterable<STATE> starts, Iterator<STACKITEM> stack, Bug347739OneTypeParam<STATE> matches, Bug347739OneTypeParam<STATE> canPass) {
		return 0;
	}

	protected static <STATE, TOKEN, STACKITEM> TraceItem<STATE, STACKITEM> trace(
			Bug347739ThreeTypeParams<STATE, TOKEN, STACKITEM> pda, Iterable<STATE> starts, Iterator<STACKITEM> stack,
			Bug347739OneTypeParam<STATE> matches, Bug347739OneTypeParam<STATE> canPass) {
		return null;
	}

	protected static <STATE, TOKEN, STACKITEM> TraceItem<STATE, STACKITEM> traceToWithMaxPops(
			Bug347739ThreeTypeParams<STATE, TOKEN, STACKITEM> pda, Iterable<STATE> starts, Iterator<STACKITEM> stack,
			Bug347739OneTypeParam<STATE> matches, Bug347739OneTypeParam<STATE> canPass) {
		return null;
	}

	public static <STATE, TOKEN, STACKITEM> List<STATE> shortestPathTo(Bug347739ThreeTypeParams<STATE, TOKEN, STACKITEM> pda,
			Iterator<STACKITEM> stack, Bug347739OneTypeParam<STATE> matches, Bug347739OneTypeParam<STATE> canPass) {
		return null;
	}

	public static <STATE, TOKEN, STACKITEM> List<STATE> shortestPathTo(Bug347739ThreeTypeParams<STATE, TOKEN, STACKITEM> pda,
			Iterator<STACKITEM> stack, STATE match) {
		return null;
	}

	public static <STATE, TOKEN, STACKITEM> List<STATE> shortestPathTo(Bug347739ThreeTypeParams<STATE, TOKEN, STACKITEM> pda,
			Iterable<STATE> starts, Iterator<STACKITEM> stack, Bug347739OneTypeParam<STATE> matches, Bug347739OneTypeParam<STATE> canPass) {
		return null;
	}

	public static <STATE, TOKEN, STACKITEM> List<STATE> shortestStackemptPathTo(
			Bug347739ThreeTypeParams<STATE, TOKEN, STACKITEM> pda, Iterator<STACKITEM> stack, STATE matches) {
		return null;
	}

	public static <STATE, TOKEN, STACKITEM> List<STATE> shortestStackemptyingPathTo(
			Bug347739ThreeTypeParams<STATE, TOKEN, STACKITEM> pda, Iterable<STATE> starts, Iterator<STACKITEM> stack,
			Bug347739OneTypeParam<STATE> matches, Bug347739OneTypeParam<STATE> canPass) {
		return null;
	}

}
