/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PartitionDeletionEditStrategy extends AbstractEditStrategy {

	private String left;
	private String right;

	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		if (command.text.equals("") && command.length == 1) {
			if (command.offset + right.length() + left.length() > document.getLength())
				return;
			if (command.offset + command.length - left.length() < 0)
				return;
			if (command.length != left.length())
				return;
			String string = document.get(command.offset, left.length() + right.length());
			if (string.equals(left + right)) {
				command.length = left.length() + right.length();
			}
		}
	}

	public IAutoEditStrategy configure(String left, String right) {
		this.left = left;
		this.right = right;
		return this;
	}

}