/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.xtext.grammaranalysis.impl.AbstractNFATransition;
import org.eclipse.xtext.parsetree.reconstr.impl.TreeConstState.Status;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TreeConstTransition extends
		AbstractNFATransition<TreeConstState, TreeConstTransition> {

	protected int precedence = -1;

	protected Status status = Status.UNKNOWN;

	public TreeConstTransition(TreeConstState source, TreeConstState target,
			boolean ruleCall) {
		super(source, target, ruleCall);
	}
	
	@Override
	public int getPrecedence() {
		if (getStatus() != Status.ENABLED)
			return -1;
		if (precedence < 0) {
			int i = 0;
			for (TreeConstTransition t : source.getFollowers())
				if (t.getStatus() == Status.ENABLED)
					t.precedence = i++;
			i = 0;
			for (TreeConstTransition t : source.getParentFollowers())
				if (t.getStatus() == Status.ENABLED)
					t.precedence = i++;
		}
		return precedence;
	}

	public Status getStatus() {
		if (status == Status.UNKNOWN) {
			getTarget().getStatus();
			if (status == Status.UNKNOWN)
				status = getTarget().getStatus();
		}
		return status;
	}

	@Override
	public TreeConstState getTarget() {
		return super.getTarget();
	}

	public boolean isDisabled() {
		return getStatus() != Status.ENABLED;
	}

	protected void setStatus(Status s) {
		status = s;
	}

}
