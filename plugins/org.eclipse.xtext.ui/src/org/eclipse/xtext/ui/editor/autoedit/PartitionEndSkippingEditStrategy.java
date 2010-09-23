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
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * skips inserting the closing terminal of a partition if it already exists.
 * 
 */
public class PartitionEndSkippingEditStrategy extends AbstractEditStrategy {

	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		if (command.length == 0 && command.text.length() > 0) {
			ITypedRegion partition = document.getPartition(command.offset);
			String part = document.get(partition.getOffset(), partition.getLength());
			if (part.substring(command.offset - partition.getOffset()).equals(command.text))
				command.length = command.text.length();
		}
	}

}
