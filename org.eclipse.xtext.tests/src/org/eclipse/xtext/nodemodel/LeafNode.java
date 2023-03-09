/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;

public class LeafNode extends org.eclipse.xtext.nodemodel.impl.LeafNodeWithSyntaxError {
	
	@Override
	protected void basicSetTotalLength(int length) {
		super.basicSetTotalLength(length);
	}
	
	@Override
	protected void basicSetTotalOffset(int offset) {
		super.basicSetTotalOffset(offset);
	}
	
	@Override
	protected AbstractNode basicGetNextSibling() {
		return super.basicGetNextSibling();
	}
	
	@Override
	protected AbstractNode basicGetPreviousSibling() {
		return super.basicGetPreviousSibling();
	}

	@Override
	protected CompositeNode basicGetParent() {
		return super.basicGetParent();
	}

	@Override
	protected void basicSetParent(CompositeNode parent) {
		super.basicSetParent(parent);
	}

	@Override
	protected Object basicGetGrammarElement() {
		return super.basicGetGrammarElement();
	}

	@Override
	public void basicSetGrammarElement(Object grammarElementOrArray) {
		super.basicSetGrammarElement(grammarElementOrArray);
	}

	@Override
	protected void basicSetPreviousSibling(AbstractNode prev) {
		super.basicSetPreviousSibling(prev);
	}

	@Override
	protected void basicSetNextSibling(AbstractNode next) {
		super.basicSetNextSibling(next);
	}

	@Override
	protected boolean basicHasPreviousSibling() {
		return super.basicHasPreviousSibling();
	}

	@Override
	protected boolean basicHasNextSibling() {
		return super.basicHasNextSibling();
	}

	@Override
	protected void basicSetSyntaxErrorMessage(SyntaxErrorMessage syntaxErrorMessage) {
		super.basicSetSyntaxErrorMessage(syntaxErrorMessage);
	}
	
}