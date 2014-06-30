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

	public ICompositeNode getParent() {
		return null;
	}

	public boolean hasSiblings() {
		return false;
	}

	public boolean hasPreviousSibling() {
		return false;
	}

	public boolean hasNextSibling() {
		return false;
	}

	public INode getPreviousSibling() {
		return null;
	}

	public INode getNextSibling() {
		return null;
	}

	public ICompositeNode getRootNode() {
		return null;
	}

	public Iterable<ILeafNode> getLeafNodes() {
		return emptyList();
	}

	public int getTotalOffset() {
		return OFFSET;
	}

	public int getOffset() {
		return OFFSET;
	}

	public int getTotalLength() {
		return LENGTH;
	}

	public int getLength() {
		return LENGTH;
	}

	public int getTotalEndOffset() {
		return LENGTH;
	}

	public int getEndOffset() {
		return LENGTH;
	}

	public int getTotalStartLine() {
		return LINE;
	}

	public int getStartLine() {
		return LINE;
	}

	public int getTotalEndLine() {
		return LINE;
	}

	public int getEndLine() {
		return LINE;
	}

	public String getText() {
		return text;
	}

	public EObject getGrammarElement() {
		return grammarElement;
	}

	public EObject getSemanticElement() {
		return semanticElement;
	}

	public boolean hasDirectSemanticElement() {
		return true;
	}

	public SyntaxErrorMessage getSyntaxErrorMessage() {
		return null;
	}

	public BidiTreeIterable<INode> getAsTreeIterable() {
		return this;
	}
	
	public BidiTreeIterator<INode> iterator() {
		return new NodeTreeIterator(this);
	}
	
	public BidiTreeIterable<INode> reverse() {
		return new ReversedBidiTreeIterable<INode>(this);
	}

	public ITextRegion getTextRegion() {
		return new TextRegion(OFFSET, LENGTH);
	}

	public ITextRegion getTotalTextRegion() {
		return new TextRegion(OFFSET, LENGTH);
	}

	public ITextRegionWithLineInformation getTextRegionWithLineInformation() {
		return new TextRegionWithLineInformation(OFFSET, LENGTH, LINE, LINE);
	}

	public ITextRegionWithLineInformation getTotalTextRegionWithLineInformation() {
		return new TextRegionWithLineInformation(OFFSET, LENGTH, LINE, LINE);
	}

	public boolean isHidden() {
		return false;
	}

}
