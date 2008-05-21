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

import org.apache.tools.ant.filters.StringInputStream;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.LeafNode;
import org.eclipse.xtext.core.parsetree.NodeAdapter;
import org.eclipse.xtext.ui.core.internal.CoreLog;
import org.eclipse.xtext.ui.core.language.LanguageDescriptor;
import org.eclipse.xtext.ui.core.language.LanguageServiceFactory;
import org.eclipse.xtext.ui.core.service.ISyntaxColorer;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextTokenScanner implements ITokenScanner {

	private ISyntaxColorer syntaxColorer;
	private IParser parser;
	private LeafNode lastNode = null;
	private Iterator<EObject> nodeIterator;

	public XtextTokenScanner(LanguageDescriptor language) {
		this.syntaxColorer = LanguageServiceFactory.getInstance()
				.getSyntaxColorer(language);
		this.parser = language.getLanguageFacade().getParser();
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
		IToken retVal = null;
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
		} else {
			retVal = Token.EOF;
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
		String content;
		try {
			content = document.get(offset, length);

			Notifier object = (Notifier) parser.parse(new StringInputStream(
					content));
			NodeAdapter adapter = (NodeAdapter) object.eAdapters().get(0);
			AbstractNode node = adapter.getParserNode();
			nodeIterator = node.eAllContents();
		} catch (BadLocationException e) {
			CoreLog.logError(e);
		} catch (Exception pe) {
			CoreLog.logError("Error during scanning", pe);
		}
	}

}
