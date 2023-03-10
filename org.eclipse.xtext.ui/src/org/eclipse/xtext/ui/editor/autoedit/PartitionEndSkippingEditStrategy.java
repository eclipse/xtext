/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * skips inserting the closing terminal of a partition if it already exists.
 * 
 */
public class PartitionEndSkippingEditStrategy extends AbstractEditStrategy {

	private String end;

	public PartitionEndSkippingEditStrategy withRightDelimiter(String end) {
		this.end = end;
		return this;
	}
	
	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		if (command.length == 0 && command.text.length() > 0) {
			ITypedRegion partition = document.getPartition(command.offset);
			String part = document.get(partition.getOffset(), partition.getLength());
			if (end != null) {
				int relativeOffset = command.offset - partition.getOffset();
				if (relativeOffset < partition.getLength() - end.length())
					return;
				if (!part.endsWith(end))
					return;
				String text = command.text;
				if (part.length() - relativeOffset < text.length()) {
					text = text.substring(0, part.length() - relativeOffset);
				}
				if (part.substring(relativeOffset, relativeOffset + text.length()).equals(text))
					command.length = text.length();
			} else {
				if (part.substring(command.offset - partition.getOffset()).equals(command.text))
					command.length = command.text.length();
			}
		}
	}

}
