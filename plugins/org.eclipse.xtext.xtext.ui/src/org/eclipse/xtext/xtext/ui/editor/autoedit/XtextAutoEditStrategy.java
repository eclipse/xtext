/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.SingleLineTerminalsStrategy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextAutoEditStrategy extends DefaultAutoEditStrategyProvider {

	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.accept(singleLineTerminals.get().configure(":", ";"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(multiLineTerminals.get().configure(":", null, ";"),IDocument.DEFAULT_CONTENT_TYPE);
	}
	
	@Override
	protected void configureParenthesis(IEditStrategyAcceptor acceptor) {
		acceptor.accept(new SingleLineTerminalsStrategy(){
			@Override
			protected boolean isIdentifierPart(IDocument doc, int offset) throws BadLocationException {
				if (doc.getLength()>offset+1) {
					return !Character.isWhitespace(doc.getChar(offset));
				}
				return super.isIdentifierPart(doc, offset);
			}
			
		}.configure("(", ")"), IDocument.DEFAULT_CONTENT_TYPE);
	}
}
