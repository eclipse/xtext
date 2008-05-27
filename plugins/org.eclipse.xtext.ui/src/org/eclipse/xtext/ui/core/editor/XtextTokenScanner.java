/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.Iterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.parser.ITokenTypes;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.core.internal.CoreLog;
import org.eclipse.xtext.ui.core.language.LanguageServiceFactory;
import org.eclipse.xtext.ui.core.service.ISyntaxColorer;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextTokenScanner implements ITokenScanner {

	private ISyntaxColorer syntaxColorer;
	private LeafNode currentNode = null;
	private Iterator<LeafNode> nodeIterator;
	private final XtextModelManager modelmanager;

	public XtextTokenScanner(XtextModelManager modelmanager, IPreferenceStore preferenceStore) {
		this.modelmanager = modelmanager;
		Assert.isLegal(modelmanager != null);
		this.syntaxColorer = LanguageServiceFactory.getInstance()
				.getSyntaxColorer(modelmanager.getLanguageDescriptor());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.ITokenScanner#getTokenLength()
	 */
	public int getTokenLength() {
		return currentNode.length();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.ITokenScanner#getTokenOffset()
	 */
	public int getTokenOffset() {
		return currentNode.offset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.ITokenScanner#nextToken()
	 */
	public IToken nextToken() {
		IToken retVal = Token.EOF;
		if (nodeIterator != null && nodeIterator.hasNext()) {
			Object o = nodeIterator.next();
			if (o instanceof LeafNode) {
				retVal = Token.UNDEFINED;
				currentNode = (LeafNode) o;
				if (ITokenTypes.WHITESPACE.equals(currentNode.tokenType()))
					retVal = Token.WHITESPACE;
				TextAttribute tAttr;
				if (syntaxColorer != null) {
					tAttr = syntaxColorer.color(currentNode);
					if (tAttr != null)
						retVal = new Token(tAttr);
				}
			}
			if (retVal.equals(Token.EOF))
				CoreLog.logError("Wrong node type:" + o, new IllegalArgumentException());
		}
		return retVal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.rules.ITokenScanner#setRange(org.eclipse.jface
	 * .text.IDocument, int, int)
	 */
	public void setRange(IDocument document, int offset, int length) {
		Assert.isLegal(document != null);
		nodeIterator = null;
		// TODO partial parse
		modelmanager.parseTree(document);
		AbstractNode rootNode = modelmanager.getCurrentRootNode();
		if (rootNode != null)
			nodeIterator = rootNode.getLeafNodes().iterator();
	}

}
