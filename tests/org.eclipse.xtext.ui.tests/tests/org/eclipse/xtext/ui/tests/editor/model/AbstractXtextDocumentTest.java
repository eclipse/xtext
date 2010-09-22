/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model;

import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.XtextAntlrTokenFileProvider;
import org.eclipse.xtext.ui.editor.model.DocumentPartitioner;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.PartitionTokenScanner;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.inject.Provider;

import junit.framework.TestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractXtextDocumentTest extends TestCase {

	public AbstractXtextDocumentTest() {
		super();
	}

	public AbstractXtextDocumentTest(String name) {
		super(name);
	}

	public XtextDocument getDocument(String s) {
		TerminalsTokenTypeToPartitionMapper mapper = new TerminalsTokenTypeToPartitionMapper() {{
			setTokenDefProvider(new AntlrTokenDefProvider() {
				{
					setAntlrTokenFileProvider(new XtextAntlrTokenFileProvider());
				}
			});
		}};
		PartitionTokenScanner scanner = new PartitionTokenScanner();
		scanner.setMapper(mapper);
		DocumentPartitioner partitioner = new DocumentPartitioner(scanner, mapper);
		XtextDocument document = new XtextDocument();
		DocumentTokenSource tokenSource = new DocumentTokenSource();
		tokenSource.setLexer(new Provider<Lexer>() {
			public Lexer get() {
				return new org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer();
			}
		});
		document.setTokenSource(tokenSource);
		document.setDocumentPartitioner(partitioner);
		partitioner.connect(document);
		document.set(s);
		return document;
	}

}