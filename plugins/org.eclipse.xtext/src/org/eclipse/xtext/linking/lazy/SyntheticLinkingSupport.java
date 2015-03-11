/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import static java.util.Collections.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.util.NodeTreeIterator;
import org.eclipse.xtext.nodemodel.util.ReversedBidiTreeIterable;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.TextRegionWithLineInformation;

import com.google.inject.Inject;

/**
 * Provides services to install proxies without node model.
 * 
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.7
 */
public class SyntheticLinkingSupport {
	
	@Inject
	private LazyLinker lazyLinker;
	
	public void createAndSetProxy(EObject obj, EReference eRef, String crossRefString) {
		lazyLinker.createAndSetProxy(obj, new SyntheticLinkingLeafNode(obj, crossRefString), eRef);
	}

}

class SyntheticLinkingLeafNode implements ILeafNode, BidiTreeIterable<INode> {

	private final static int OFFSET = 0;
	private final static int LENGTH = 1;
	private final static int LINE = -1;

	private final String text;
	private final EObject grammarElement;
	private final EObject semanticElement;

	public SyntheticLinkingLeafNode(EObject semanticElement, String text) {
		this.text = text;
		this.semanticElement = semanticElement;
		this.grammarElement = XtextFactory.eINSTANCE.createKeyword();
	}

	@Override
	public ICompositeNode getParent() {
		return null;
	}

	@Override
	public boolean hasSiblings() {
		return false;
	}

	@Override
	public boolean hasPreviousSibling() {
		return false;
	}

	@Override
	public boolean hasNextSibling() {
		return false;
	}

	@Override
	public INode getPreviousSibling() {
		return null;
	}

	@Override
	public INode getNextSibling() {
		return null;
	}

	@Override
	public ICompositeNode getRootNode() {
		return null;
	}

	@Override
	public Iterable<ILeafNode> getLeafNodes() {
		return emptyList();
	}

	@Override
	public int getTotalOffset() {
		return OFFSET;
	}

	@Override
	public int getOffset() {
		return OFFSET;
	}

	@Override
	public int getTotalLength() {
		return LENGTH;
	}

	@Override
	public int getLength() {
		return LENGTH;
	}

	@Override
	public int getTotalEndOffset() {
		return LENGTH;
	}

	@Override
	public int getEndOffset() {
		return LENGTH;
	}

	@Override
	public int getTotalStartLine() {
		return LINE;
	}

	@Override
	public int getStartLine() {
		return LINE;
	}

	@Override
	public int getTotalEndLine() {
		return LINE;
	}

	@Override
	public int getEndLine() {
		return LINE;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public EObject getGrammarElement() {
		return grammarElement;
	}

	@Override
	public EObject getSemanticElement() {
		return semanticElement;
	}

	@Override
	public boolean hasDirectSemanticElement() {
		return true;
	}

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage() {
		return null;
	}

	@Override
	public BidiTreeIterable<INode> getAsTreeIterable() {
		return this;
	}
	
	@Override
	public BidiTreeIterator<INode> iterator() {
		return new NodeTreeIterator(this);
	}
	
	@Override
	public BidiTreeIterable<INode> reverse() {
		return new ReversedBidiTreeIterable<INode>(this);
	}

	@Override
	public ITextRegion getTextRegion() {
		return new TextRegion(OFFSET, LENGTH);
	}

	@Override
	public ITextRegion getTotalTextRegion() {
		return new TextRegion(OFFSET, LENGTH);
	}

	@Override
	public ITextRegionWithLineInformation getTextRegionWithLineInformation() {
		return new TextRegionWithLineInformation(OFFSET, LENGTH, LINE, LINE);
	}

	@Override
	public ITextRegionWithLineInformation getTotalTextRegionWithLineInformation() {
		return new TextRegionWithLineInformation(OFFSET, LENGTH, LINE, LINE);
	}

	@Override
	public boolean isHidden() {
		return false;
	}

}
