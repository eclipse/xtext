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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.core.language.LanguageServiceFactory;
import org.eclipse.xtext.ui.core.service.ISyntaxColorer;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextTokenScanner implements ITokenScanner {

	private ISyntaxColorer syntaxColorer;
	private LeafNode lastNode = null;
	private Iterator<EObject> nodeIterator;
	private final XtextModelManager modelmanager;

	public XtextTokenScanner(XtextModelManager modelmanager) {
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
		if (lastNode != null)
			return lastNode.length();
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.ITokenScanner#getTokenOffset()
	 */
	public int getTokenOffset() {
		if (lastNode != null)
			return lastNode.offset();
		return -1;
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
				lastNode = (LeafNode) o;
				TextAttribute tAttr;
				if (syntaxColorer != null) {
					tAttr = syntaxColorer.color(lastNode);
					if (tAttr != null)
						retVal = new Token(tAttr);
				}
			}
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
		// TODO partial parse
		modelmanager.parseTree(document);
		AbstractNode currentAST = modelmanager.getCurrentAST();
		if (currentAST != null)
			nodeIterator = currentAST.eAllContents();
		else
			nodeIterator = null;
	}

}
