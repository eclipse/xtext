/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils.Implementation;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

import com.google.common.collect.ForwardingObject;

/**
 * @since 2.35
 */
public abstract class ForwardingNode extends ForwardingObject implements INode {

	@Override
	protected abstract INode delegate();

	public ICompositeNode getParent() {
		return delegate().getParent();
	}

	public boolean hasSiblings() {
		return delegate().hasSiblings();
	}

	public boolean hasPreviousSibling() {
		return delegate().hasPreviousSibling();
	}

	public boolean hasNextSibling() {
		return delegate().hasNextSibling();
	}

	public INode getPreviousSibling() {
		return delegate().getPreviousSibling();
	}

	public INode getNextSibling() {
		return delegate().getNextSibling();
	}

	public ICompositeNode getRootNode() {
		return delegate().getRootNode();
	}

	public Iterable<ILeafNode> getLeafNodes() {
		return delegate().getLeafNodes();
	}

	public int getTotalOffset() {
		return delegate().getTotalOffset();
	}

	public int getOffset() {
		return delegate().getOffset();
	}

	public int getTotalLength() {
		return delegate().getTotalLength();
	}

	public int getLength() {
		return delegate().getLength();
	}

	public int getTotalEndOffset() {
		return delegate().getTotalEndOffset();
	}

	public int getEndOffset() {
		return delegate().getEndOffset();
	}

	public int getTotalStartLine() {
		return delegate().getTotalStartLine();
	}

	public int getStartLine() {
		return delegate().getStartLine();
	}

	public int getTotalEndLine() {
		return delegate().getTotalEndLine();
	}

	public int getEndLine() {
		return delegate().getEndLine();
	}

	public String getText() {
		return delegate().getText();
	}

	public EObject getGrammarElement() {
		return delegate().getGrammarElement();
	}

	public EObject getSemanticElement() {
		return delegate().getSemanticElement();
	}

	public boolean hasDirectSemanticElement() {
		return delegate().hasDirectSemanticElement();
	}

	public SyntaxErrorMessage getSyntaxErrorMessage() {
		return delegate().getSyntaxErrorMessage();
	}

	public BidiTreeIterable<INode> getAsTreeIterable() {
		return delegate().getAsTreeIterable();
	}

	public ITextRegion getTextRegion() {
		return delegate().getTextRegion();
	}

	public ITextRegion getTotalTextRegion() {
		return delegate().getTotalTextRegion();
	}

	public ITextRegionWithLineInformation getTextRegionWithLineInformation() {
		return delegate().getTextRegionWithLineInformation();
	}

	public ITextRegionWithLineInformation getTotalTextRegionWithLineInformation() {
		return delegate().getTotalTextRegionWithLineInformation();
	}

	public Implementation utils() {
		return delegate().utils();
	}
	
}
