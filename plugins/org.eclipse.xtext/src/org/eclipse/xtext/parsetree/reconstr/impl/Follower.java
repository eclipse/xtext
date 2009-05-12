/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.xtext.AbstractElement;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class Follower {
	private AbstractElement follower;
	private boolean ruleCall;

	public Follower(AbstractElement follower, boolean ruleCall) {
		super();
		this.follower = follower;
		this.ruleCall = ruleCall;
	}

	public AbstractElement getFollower() {
		return follower;
	}

	public boolean isRuleCall() {
		return ruleCall;
	}

	public boolean isRuleEnd() {
		return follower == null;
	}
}