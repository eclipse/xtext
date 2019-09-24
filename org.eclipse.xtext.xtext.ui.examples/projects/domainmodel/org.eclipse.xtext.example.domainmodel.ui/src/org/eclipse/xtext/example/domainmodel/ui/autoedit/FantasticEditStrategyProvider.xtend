/*******************************************************************************
 * Copyright (c) 2010, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.autoedit

import org.eclipse.jface.text.BadLocationException
import org.eclipse.jface.text.DocumentCommand
import org.eclipse.jface.text.IAutoEditStrategy
import org.eclipse.jface.text.IDocument
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider

/** 
 * @author Sven Efftinge - Initial contribution and API
 * @author miklossy - Convert the class from Java to Xtend
 */
class FantasticEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	private static final class Surprise implements IAutoEditStrategy {

		String contents

		override customizeDocumentCommand(IDocument document, DocumentCommand command) {
			try {
				if (command.text.equals("t") && document.get(command.offset - 4, 4).equals("Xtex")) {
					contents = document.get 
					document.set(text)
					command.text = "" 
					command.offset = text.lastIndexOf("M") + 1
				} else {
					if (contents !== null) {
						document.set(contents) 
						contents = null 
					}
				}
			} catch (BadLocationException e) {
			}
		}

		private def String getText() '''
			«""»



						MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM  MMMMMMMMM
						MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM      MMMMMMMM
						MMMMMM   MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM     MMMMMMMM
						MMMM       MMMMMMMMMMMMMMMMMMMMMMMMMMMMM    MMMMMMMM
						MMM          MMMMMMMMMMMMMMMMMMMMMMMMMMMM   MMMMMMMM
						M              MMMMMMMMMMMMMMMMMMMMMMMMM   MMMMMMMMM
						MM                MMMMMMMMMMMMMMMMMMMMM   MMMMMMMMMM
						MMMM                 MMMMMMMMMMMMMMMM   MMMMMMMMMMMM
						MMMMMM                   MMMMMMMMM     MMMMMMMMMMMMM
						MMMMMMMM                             MMMMMMMMMMMMMMM
						MMMMMMMMMM                        MMMMMMMMMMMMMMMMMM
						MMMMMMMMMMMMMM                MMMMMMMMMMMMMMMMMMMMMM
						MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
						MMMMMMMMMMMMMMMMMMMM            MMMMMMMMMMMMMMMMMMMM
						MMMMMMMMMMMMMMMMM                     MMMMMMMMMMMMMM
						MMMMMMMMMMMMMM                           MMMMMMMMMMM
						MMMMMMMMMMMM       MMM                      MMMMMMMM
						MMMMMMMMMM    MMMMMMMMMMMMMMM                 MMMMMM
						MMMMMMMMM   MMMMMMMMMMMMMMMMMMMM                MMMM
						MMMMMMMM  MMMMMMMMMMMMMMMMMMMMMMMMM               MM
						MMMMMMM   MMMMMMMMMMMMMMMMMMMMMMMMMMM            MMM
						MMMMMM    MMMMMMMMMMMMMMMMMMMMMMMMMMMMM        MMMMM
						MMMMMM      MMMMMMMMMMMMMMMMMMMMMMMMMMMMM    MMMMMMM
						MMMMMM      MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM  MMMMMMMM
						MMMMMMM    MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
						MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
			'''
	}

	override protected void configure(IEditStrategyAcceptor acceptor) {
		super.configure(acceptor) 
		acceptor.accept(new Surprise(), IDocument.DEFAULT_CONTENT_TYPE)
	}
}