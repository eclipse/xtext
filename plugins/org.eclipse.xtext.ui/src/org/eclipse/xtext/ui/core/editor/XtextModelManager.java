/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.Vector;

import org.apache.tools.ant.filters.StringInputStream;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.core.internal.CoreLog;
import org.eclipse.xtext.ui.core.language.LanguageDescriptor;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextModelManager {

	private final class ParseErrorHandlerImpl implements IParseErrorHandler {
		public void handleParserError(LeafNode node, String message, Object context) {
			if (node == null)
				CoreLog.logWarning("Parameter 'node' is null in handleParseError methode");
			getErrors().add(new ParseError(node, message, context));
		}
	}

	public final class ParseError {
		private LeafNode node;
		private String message;
		private Object context;

		public ParseError(LeafNode node, String message, Object context) {
			super();
			this.node = node;
			this.message = message;
			this.context = context;
		}

		public LeafNode getNode() {
			return node;
		}

		public String getMessage() {
			return message;
		}

		public Object getContext() {
			return context;
		}

		public String getText() {
			return node.getText();
		}

		public int length() {
			return node.length();
		}

		public int line() {
			return node.line();
		}

		public int offset() {
			return node.offset();
		}

	}

	private Vector<ParseError> errors = new Vector<ParseError>();
	private final LanguageDescriptor languageDescriptor;
	private AbstractNode rootNode;

	public XtextModelManager(LanguageDescriptor languageDescriptor) {
		this.languageDescriptor = languageDescriptor;
	}

	public AbstractNode getCurrentRootNode() {
		return rootNode;
	}

	public boolean hasErrors() {
		return !getErrors().isEmpty();
	}

	public void parseTree(String content) {
		rootNode = null;
		getErrors().clear();
		ILanguageFacade languageFacade = languageDescriptor.getLanguageFacade();
		IParseResult object = languageFacade.getParser().parse(new StringInputStream(content),
				languageFacade.getElementFactory(), new ParseErrorHandlerImpl());
		if (object != null) {
			rootNode = object.getRootNode();
		}
	}

	public LanguageDescriptor getLanguageDescriptor() {
		return languageDescriptor;
	}

	public Vector<ParseError> getErrors() {
		return errors;
	}

}
