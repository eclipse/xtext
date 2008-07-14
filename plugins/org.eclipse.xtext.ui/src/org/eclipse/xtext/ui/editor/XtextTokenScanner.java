/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Iterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeContentAdapter;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.editor.utils.TextStyleConstants;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.internal.CoreLog;
import org.eclipse.xtext.ui.service.ISyntaxColorer;
import org.eclipse.xtext.util.StringInputStream;

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
	private IParseResult lastParseResult;

	public XtextTokenScanner(ILanguageDescriptor languageDescriptor) {
		Assert.isLegal(languageDescriptor != null);
		this.languageDescriptor = languageDescriptor;
		this.syntaxColorer = ServiceRegistry.getService(languageDescriptor, ISyntaxColorer.class);
		this.parser = ServiceRegistry.getService(languageDescriptor, IParser.class);
	}

	public int getTokenLength() {
		return currentNode.getLength();
	}

	public int getTokenOffset() {
		return currentNode.getOffset();
	}

	public IToken nextToken() {
		IToken token = Token.EOF;
		if (nodeIterator != null && nodeIterator.hasNext()) {
			Object node = nodeIterator.next();
			if (node instanceof LeafNode) {
				currentNode = (LeafNode) node;
				token = Token.UNDEFINED;
				if (syntaxColorer != null) {
					TextAttribute textAttribute = createTextAttribute();
					if (textAttribute != null) {
						token = new Token(textAttribute);
					}
				}
			}
			else {
				CoreLog.logError(XtextUIMessages.getFormattedString(
						"XtextTokenScanner.WrongNodeType", node, LeafNode.class.getName()), //$NON-NLS-1$ 
						new IllegalArgumentException());
			}
		}
		return token;
	}

	private TextAttribute createTextAttribute() {
		TextStyle textStyle = syntaxColorer.color(currentNode);
		// we need difference to an default TextAttribute(null,null,0,null) in
		// DefaultDamagerRepair
		if (textStyle.getColor() == null) {
			textStyle.setColor(TextStyleConstants.DEFAULT_COLOR);
		}
		return new TextAttribute(EditorUtils.colorFromString(textStyle.getColor()), EditorUtils
				.colorFromString(textStyle.getBackgroundColor()), textStyle.getStyle(), EditorUtils
				.fontFromString(textStyle.getFontName()));
	}

	public void setRange(IDocument document, int offset, int length) {

		Assert.isLegal(document != null);
		nodeIterator = null;
		if (Activator.DEBUG_PARSING) {
			System.out.print("Token Scanner: Parsing Range [" + offset + "," + length + "]...");

		}
		long start = System.currentTimeMillis();

		// TODO: dependency injection for default element factory in parser
		IAstFactory elementFactory = ServiceRegistry.getService(languageDescriptor, IAstFactory.class);
		IParseResult parseResult;
		try {
			CompositeNode lastRootNode = null;
			if (lastParseResult == null) {
				parseResult = parser.parse(new StringInputStream(document.get()), elementFactory);
			}
			else {
				lastRootNode = lastParseResult.getRootNode();
				int documentGrowth = document.getLength() - lastRootNode.getLength();
				int originalLength = length - documentGrowth;
				String change = document.get().substring(offset, offset + length);
				if (Activator.DEBUG_PARSING)
					System.out.print(" Reparse segment '" + change.replaceAll("\n", "\\\\n") + "'" + " documentGrowth:"
							+ documentGrowth + " ");
				parseResult = parser.reparse(lastRootNode, offset, originalLength, change);

			}
			lastParseResult = parseResult;
			CompositeNode rootNode = parseResult.getRootNode();
			if (rootNode != null) {
				nodeIterator = rootNode.getLeafNodes().iterator();
				if (lastRootNode != rootNode) {
					rootNode.eAdapters().add(new NodeContentAdapter());
				}
				// TODO remove this check if BUG # is fixed and a test is
				// created
				int length2 = rootNode.getLength();
				if (length2 != document.getLength())
					throw new IllegalStateException("Document.length=" + document.getLength() + " rootNode.length="
							+ length2);
			}
			if (Activator.DEBUG_PARSING)
				System.out.println("...took " + (System.currentTimeMillis() - start) + "ms.");
		}
		catch (Exception e) {
			CoreLog.logError("Error during parse process in token scanner. "
					+ (e.getLocalizedMessage() != null ? e.getLocalizedMessage() : ""), e);
			e.printStackTrace();
			if (Activator.DEBUG_PARSING)
				System.err.println("fail!");
		}
	}
}
