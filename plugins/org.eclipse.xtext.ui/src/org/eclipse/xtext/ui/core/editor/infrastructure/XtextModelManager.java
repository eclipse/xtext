/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.infrastructure;

import java.util.Vector;

import org.apache.tools.ant.filters.StringInputStream;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.parser.IParseError;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.ui.core.language.LanguageDescriptor;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextModelManager {
	// TODO remove custom impl when default one works properly
	private final class ParseErrorHandlerImpl implements IParseErrorHandler {

		public void handleParserError(IParseError error) {
			getErrors().add(error);
		}
	}

	private Vector<IParseError> errors = new Vector<IParseError>();
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

	public Vector<IParseError> getErrors() {
		return errors;
	}

}
