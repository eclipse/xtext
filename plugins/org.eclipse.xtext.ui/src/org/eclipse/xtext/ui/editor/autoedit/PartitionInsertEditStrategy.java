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
import org.eclipse.jface.text.ITypedRegion;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PartitionInsertEditStrategy extends AbstractEditStrategy {

	private String left;
	private String right;

	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		if (command.text.length() > 0 && left.endsWith(command.text)) {
			ITypedRegion partition = document.getPartition(command.offset);
			if (partition.getOffset() + partition.getLength() >= command.offset + right.length()) {
				if (right.equals(document.get(command.offset, right.length())))
					return;
			}
			if (isIdentifierPart(document, command.offset))
				return;
			command.caretOffset = command.offset + command.text.length();
			command.shiftsCaret = false;
			command.text += right;
		}
	}

	public IAutoEditStrategy configure(String left, String right) {
		this.left = left;
		this.right = right;
		return this;
	}
}
