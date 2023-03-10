/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.ui.editor.autoedit.AbstractTerminalsEditStrategy;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TerminalsEditStrategyTest extends Assert {
	
	static class TerminalsStrategy extends AbstractTerminalsEditStrategy {

		public TerminalsStrategy(String leftTerminal, String rightTerminal) {
			super(leftTerminal, rightTerminal);
			debug = true;
		}

		@Override
		protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
				throws BadLocationException {
		}
		@Override
		public IRegion findStartTerminal(IDocument document, int offset) throws BadLocationException {
			return super.findStartTerminal(document, offset);
		}
		@Override
		public IRegion findStopTerminal(IDocument document, int offset) throws BadLocationException {
			return super.findStopTerminal(document, offset);
		}
	}
	
	@Test public void testFindStartTerminal() throws Exception {
		TerminalsStrategy strategy = new TerminalsStrategy("(", ")");
		assertNull(strategy.findStartTerminal(new Document("(()())"),6));
		assertEquals(0,strategy.findStartTerminal(new Document("(()())"),5).getOffset());
	}

	@Test public void testFindStopTerminal() throws Exception {
		TerminalsStrategy strategy = new TerminalsStrategy("(", ")");
		assertNull(strategy.findStopTerminal(new Document("(()())"),0));
		assertEquals(5,strategy.findStopTerminal(new Document("(()())"),1).getOffset());
	}
}
