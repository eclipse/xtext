/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.MultiLineTerminalsEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.SingleLineTerminalsStrategy;
import org.eclipse.xtext.ui.editor.model.DocumentUtil;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextAutoEditStrategy extends DefaultAutoEditStrategyProvider {

	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.accept(singleLineTerminals.newInstance(":", ";"),IDocument.DEFAULT_CONTENT_TYPE);
		MultiLineTerminalsEditStrategy configure = multiLineTerminals.newInstance(":", null, ";");
		
		// the following is a cheap but working hack, which replaces any double colons '::' by whitespace '  ' temporarily.
		configure.setDocumentUtil(new DocumentUtil() {
			@Override
			public IRegion searchBackwardsInSamePartition(String toFind, IDocument document, int endOffset)
					throws BadLocationException {
				return super.searchBackwardsInSamePartition(toFind, hackDoc(document), endOffset);
			}
			private IDocument hackDoc(IDocument document) {
				return new Document(document.get().replace("::", "  "));
			}
			@Override
			public IRegion searchInSamePartition(String toFind, IDocument document, int startOffset)
					throws BadLocationException {
				return super.searchInSamePartition(toFind, hackDoc(document), startOffset);
			}
		});
		acceptor.accept(configure,IDocument.DEFAULT_CONTENT_TYPE);
	}
	
	@Override
	protected void configureParenthesis(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("(", ")", new SingleLineTerminalsStrategy.StrategyPredicate(){

			public boolean isInsertClosingBracket(IDocument doc, int offset) throws Exception {
				char c = doc.getChar(offset);
				return Character.isWhitespace(c) || c==';';
			}
			
		}), IDocument.DEFAULT_CONTENT_TYPE);
	}
}
