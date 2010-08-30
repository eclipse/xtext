/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.editor.PresentationDamager;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PresentationDamagerTest extends AbstractDamagerRepairerTest {

	@Override
	protected IPresentationDamager createRegionDamager() {
		return new PresentationDamager();
	}

	@Override
	protected Document createDocument(String before) throws Exception {
		DocumentTokenSource source = new DocumentTokenSource();
		source.setLexer(new Provider<Lexer>() {
			public Lexer get() {
				return new org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer();
			}
		});
		XtextDocument document = new XtextDocument();
		document.setTokenSource(source);
		document.set(before);
		return document;
	}

}
