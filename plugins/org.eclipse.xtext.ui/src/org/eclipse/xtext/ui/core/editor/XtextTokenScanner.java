/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseError;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.core.editor.utils.StringInputStream;
import org.eclipse.xtext.ui.core.internal.CoreLog;
import org.eclipse.xtext.ui.core.service.ISyntaxColorer;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextTokenScanner implements ITokenScanner {

	private ISyntaxColorer syntaxColorer;
	private LeafNode currentNode = null;
	private Iterator<LeafNode> nodeIterator;
	private IParser parser;
	private final ILanguageDescriptor languageDescriptor;

	public XtextTokenScanner(ILanguageDescriptor languageDescriptor, IPreferenceStore preferenceStore) {
		Assert.isLegal(languageDescriptor != null);
		this.languageDescriptor = languageDescriptor;
		this.syntaxColorer = ServiceRegistry.getService(languageDescriptor, ISyntaxColorer.class);
		parser = ServiceRegistry.getService(languageDescriptor, IParser.class);
	}

	public int getTokenLength() {
		if (currentNode != null) {
			return currentNode.length();
		}
		else {
			return -1;
		}
	}

	public int getTokenOffset() {
		if (currentNode != null) {
			return currentNode.offset();
		}
		else {
			return -1;
		}
	}

	public IToken nextToken() {
		IToken token = Token.EOF;
		if (nodeIterator != null && nodeIterator.hasNext()) {
			Object node = nodeIterator.next();
			if (node instanceof LeafNode) {
				currentNode = (LeafNode) node;
				token = Token.UNDEFINED;
				// if (ITokenTypes.WHITESPACE.equals(currentNode.tokenType())) {
				// retVal = Token.WHITESPACE;
				// }
				if (syntaxColorer != null) {
					TextAttribute textAttribute = syntaxColorer.color(currentNode);
					if (textAttribute != null) {
						token = new Token(textAttribute);
					}
				}
			}
			else {
				CoreLog.logError(EditorMessages.getFormattedString(
						"XtextTokenScanner.WrongNodeType", node, LeafNode.class.getName()), //$NON-NLS-1$ 
						new IllegalArgumentException());
			}
		}
		return token;
	}

	// TODO remove custom implementation when default one works properly
	private IParseErrorHandler parseErrorHandler = new IParseErrorHandler() {

		public void handleParserError(IParseError error) {
			parseErrors.add(error);
		}
	};
	List<IParseError> parseErrors = new ArrayList<IParseError>();

	public void setRange(IDocument document, int offset, int length) {
		Assert.isLegal(document != null);
		nodeIterator = null;
		// TODO partial parse
		System.out.print("Token Scanner: Parsing...");
		long start = System.currentTimeMillis();

		// TODO: dependency injection for default element factory in parser
		IElementFactory elementFactory = ServiceRegistry.getService(languageDescriptor, IElementFactory.class);
		IParseResult parseResult;
		try {
			//TODO delegate encoding to an antlrparser
			parseResult = parser.parse(new StringInputStream(document.get()), elementFactory, parseErrorHandler);
			CompositeNode rootNode = parseResult.getRootNode();

			System.out.println("...took " + (System.currentTimeMillis() - start) + "ms.");
			if (rootNode != null) {
				nodeIterator = rootNode.getLeafNodes().iterator();
			}
		}
		catch (UnsupportedEncodingException e) {
			CoreLog.logError(e);
		}
	}

}
