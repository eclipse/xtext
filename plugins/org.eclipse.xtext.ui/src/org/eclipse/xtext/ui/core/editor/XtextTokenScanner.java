/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.DataFormatException;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
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
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;
import org.eclipse.xtext.ui.core.editor.utils.TextStyleConstants;
import org.eclipse.xtext.ui.core.internal.Activator;
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
		this.parser = ServiceRegistry.getService(languageDescriptor, IParser.class);
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
				if (syntaxColorer != null) {
					TextAttribute textAttribute = createTextAttribute();
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

	private TextAttribute createTextAttribute() {
		TextStyle textStyle = syntaxColorer.color(currentNode);
		// we need difference to an default TextAttribute(null,null,0,null) in
		// DefaultDamagerRepair
		if (textStyle.getColor() == null) {
			textStyle.setColor(TextStyleConstants.DEFAULT_COLOR);
		}
		return new TextAttribute(colorFromString(textStyle.getColor()),
				colorFromString(textStyle.getBackgroundColor()), textStyle.getStyle(), fontFromString(textStyle
						.getFontName()));
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
		if (Activator.DEBUG_PARSING)
			System.out.print("Token Scanner: Parsing...");
		long start = System.currentTimeMillis();

		// TODO: dependency injection for default element factory in parser
		IElementFactory elementFactory = ServiceRegistry.getService(languageDescriptor, IElementFactory.class);
		IParseResult parseResult;
		try {
			// TODO delegate encoding to an antlrparser
			parseResult = parser.parse(new StringInputStream(document.get()), elementFactory, parseErrorHandler);
			CompositeNode rootNode = parseResult.getRootNode();
			if (Activator.DEBUG_PARSING)
				System.out.println("...took " + (System.currentTimeMillis() - start) + "ms.");
			if (rootNode != null) {
				nodeIterator = rootNode.getLeafNodes().iterator();
			}
		}
		catch (Exception e) {
			CoreLog.logError(e);
		}
	}

	// TODO move following methods to a separate utilclass

	private Font fontFromString(String fontName) {
		if (fontName != null && fontName.trim().length() > 0) {
			Font font = JFaceResources.getFont(fontName);
			return font;
		}
		return null;
	}

	private Color colorFromString(String rgbString) {
		if (rgbString != null && rgbString.trim().length() > 0) {
			Color col = JFaceResources.getColorRegistry().get(rgbString);
			try {
				if (col == null) {
					RGB rgb = StringConverter.asRGB(rgbString);
					JFaceResources.getColorRegistry().put(rgbString, rgb);
					col = JFaceResources.getColorRegistry().get(rgbString);
				}
			}
			catch (DataFormatException e) {
				CoreLog.logError("Corrupt color value: " + rgbString, e);
			}
			return col;
		}
		return null;
	}
}
