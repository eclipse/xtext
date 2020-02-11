/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis.impl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.INFAState;
import org.eclipse.xtext.grammaranalysis.INFATransition;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AbstractNFATransition<S extends INFAState<S, T>, T extends INFATransition<S, T>> implements
		INFATransition<S, T> {

	final protected AbstractElement loopCenter;

	final protected boolean ruleCall;

	final protected S source;

	final protected S target;

	public AbstractNFATransition(S source, S target, boolean ruleCall, AbstractElement loopCenter) {
		super();
		this.source = source;
		this.target = target;
		this.ruleCall = ruleCall;
		this.loopCenter = loopCenter;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractNFATransition) {
			AbstractNFATransition a = (AbstractNFATransition) obj;
			return a.source == source && a.target == target;
		}
		return false;
	}

	@Override
	public AbstractElement getLoopCenter() {
		return loopCenter;
	}

	@Override
	public int getPrecedence() {
		INFAState<S, T> s = source;
		int i = s.getOutgoing().indexOf(this);
		return i > -1 ? i : s.getOutgoingAfterReturn().indexOf(this);
	}

	@Override
	public S getSource() {
		return source;
	}

	@Override
	public S getTarget() {
		return target;
	}

	@Override
	public int hashCode() {
		return source.hashCode() + target.hashCode();
	}

	@Override
	public boolean isRuleCall() {
		return ruleCall;
	}

	@Override
	public String toString() {
		return source + " -> " + target;
	}

}