/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAState;

public class TreeConstState extends AbstractNFAState<TreeConstState, TreeConstTransition> {

	public TreeConstState(AbstractElement element,
			NFABuilder<TreeConstState, TreeConstTransition> builder) {
		super(element, builder);
	}

	@Override
	public List<TreeConstTransition> getFollowers() {
		return super.getFollowers();
	}
	
	@Override
	public List<TreeConstTransition> getParentFollowers() {
		return super.getParentFollowers();
	}
	
}
