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

public class TreeConstTransition extends
		AbstractNFATransition<TreeConstState, TreeConstTransition> {

	public TreeConstTransition(TreeConstState source, TreeConstState target, boolean ruleCall) {
		super(source, target, ruleCall);
	}
	
	@Override
	public TreeConstState getTarget() {
		return super.getTarget();
	}
	
}
