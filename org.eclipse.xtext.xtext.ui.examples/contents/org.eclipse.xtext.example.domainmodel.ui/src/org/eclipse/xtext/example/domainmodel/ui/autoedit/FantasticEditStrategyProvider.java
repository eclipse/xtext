/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class FantasticEditStrategyProvider extends DefaultAutoEditStrategyProvider {
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	private final class Surprise implements IAutoEditStrategy {
		
		private String contents;
		
		@Override
		public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
			try {
				if (command.text.equals("t") && document.get(command.offset-4, 4).equals("Xtex")) {
					contents = document.get();
					document.set(getText());
					command.text="";
				} else {
					if (contents!=null) {
						document.set(contents);
						contents = null;
					}
				}
			} catch (BadLocationException e) {
			}
		}
		private String getText() {
			return 
			"\n\n\n"+
            "\t\t\tMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM  MMMMMMMMM\n"+
            "\t\t\tMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM      MMMMMMMM\n"+
            "\t\t\tMMMMMM   MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM     MMMMMMMM\n"+
            "\t\t\tMMMM       MMMMMMMMMMMMMMMMMMMMMMMMMMMMM    MMMMMMMM\n"+
            "\t\t\tMMM          MMMMMMMMMMMMMMMMMMMMMMMMMMMM   MMMMMMMM\n"+
            "\t\t\tM              MMMMMMMMMMMMMMMMMMMMMMMMM   MMMMMMMMM\n"+
            "\t\t\tMM                MMMMMMMMMMMMMMMMMMMMM   MMMMMMMMMM\n"+
            "\t\t\tMMMM                 MMMMMMMMMMMMMMMM   MMMMMMMMMMMM\n"+
            "\t\t\tMMMMMM                   MMMMMMMMM     MMMMMMMMMMMMM\n"+
            "\t\t\tMMMMMMMM                             MMMMMMMMMMMMMMM\n"+
            "\t\t\tMMMMMMMMMM                        MMMMMMMMMMMMMMMMMM\n"+
            "\t\t\tMMMMMMMMMMMMMM                MMMMMMMMMMMMMMMMMMMMMM\n"+
            "\t\t\tMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"+
            "\t\t\tMMMMMMMMMMMMMMMMMMMM            MMMMMMMMMMMMMMMMMMMM\n"+
            "\t\t\tMMMMMMMMMMMMMMMMM                     MMMMMMMMMMMMMM\n"+
            "\t\t\tMMMMMMMMMMMMMM                           MMMMMMMMMMM\n"+
            "\t\t\tMMMMMMMMMMMM       MMM                      MMMMMMMM\n"+ 
            "\t\t\tMMMMMMMMMM    MMMMMMMMMMMMMMM                 MMMMMM\n"+  
            "\t\t\tMMMMMMMMM   MMMMMMMMMMMMMMMMMMMM                MMMM\n"+  
            "\t\t\tMMMMMMMM  MMMMMMMMMMMMMMMMMMMMMMMMM               MM\n"+  
            "\t\t\tMMMMMMM   MMMMMMMMMMMMMMMMMMMMMMMMMMM            MMM\n"+             
            "\t\t\tMMMMMM    MMMMMMMMMMMMMMMMMMMMMMMMMMMMM        MMMMM\n"+        
            "\t\t\tMMMMMM      MMMMMMMMMMMMMMMMMMMMMMMMMMMMM    MMMMMMM\n"+    
            "\t\t\tMMMMMM      MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM  MMMMMMMM\n"+
            "\t\t\tMMMMMMM    MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"+
            "\t\t\tMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n";
		}
	}

	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.accept(new Surprise(),IDocument.DEFAULT_CONTENT_TYPE);
	}

}
