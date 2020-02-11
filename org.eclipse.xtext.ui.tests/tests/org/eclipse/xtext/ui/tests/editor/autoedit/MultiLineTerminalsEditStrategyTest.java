/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.autoedit;

import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.xtext.ui.editor.autoedit.MultiLineTerminalsEditStrategy;
import org.eclipse.xtext.ui.tests.editor.model.AbstractXtextDocumentTest;
import org.junit.Test;

/**
 * @author Hendrik Buender - Initial contribution and API
 */
public class MultiLineTerminalsEditStrategyTest extends AbstractXtextDocumentTest {

	/**
	 * 	See bug 403812
	 * 	Closing terminal is already included, so that the command must not contain a new closing brace
	 */
	@Test public void testFindStopTerminal() throws Exception {
		MultiLineTerminalsEditStrategy strategy = new MultiLineTerminalsEditStrategy("{", "\t","}",true);
		DocumentCommand command= DocumentCommandTest.getDocumentCommandTest(17);
		strategy.customizeDocumentCommand(getDocument("Hello {\n  Thomas{\n   Birthday\n  }//\n}!"),command);
		assertEquals("",command.text.trim());
	}
	
	/**
	 * See bug 403812
	 * Closing terminal is not available, so that the command has to contain a new closing brace
	 */
	@Test public void testFindStopTerminal_2() throws Exception {
		MultiLineTerminalsEditStrategy strategy = new MultiLineTerminalsEditStrategy("{", "\t","}",true);
		DocumentCommand command= DocumentCommandTest.getDocumentCommandTest(17);
		strategy.customizeDocumentCommand(getDocument("Hello {\n  Thomas{\n   Birthday\n  //\n}!"),command);
		assertEquals("}",command.text.trim());
	}
	
	/**
	 * See bug 403812
	 * If all partitions after the inner closing brace are of type __sl_comment there should be
	 * a new closing brace as well.
	 */
	@Test public void testFindStopTerminal_3() throws Exception {
		MultiLineTerminalsEditStrategy strategy = new MultiLineTerminalsEditStrategy("{", "\t","}",true);
		DocumentCommand command= DocumentCommandTest.getDocumentCommandTest(17);
		strategy.customizeDocumentCommand(getDocument("Hello {\n  Thomas{\n   Birthday\n }//}!"),command);
		assertEquals("}",command.text.trim());
	}

	static class DocumentCommandTest extends DocumentCommand {

		public DocumentCommandTest() {
			super();
		}
		
		public static DocumentCommand getDocumentCommandTest(int offset){
			DocumentCommand command = new DocumentCommandTest();
			command.caretOffset=-1;
			command.doit=true;
			command.length=0;
			command.offset=offset;
			command.text="\r\n  ";
			command.shiftsCaret=true;
			return command;
		}
	}
}
