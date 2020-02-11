/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringPartitionDelimiterSkippingStrategy extends AbstractEditStrategy {

	private static final String partitionDelimiter = "'''";

	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		if (command.length == 0 && command.text.length() == 1) {
			ITypedRegion partition = document.getPartition(command.offset);
			String partitionContent = document.get(partition.getOffset(), partition.getLength());
			int relativeOffset = command.offset - partition.getOffset();
			if (relativeOffset < partition.getLength() - partitionDelimiter.length()) {
				if (relativeOffset == 0 || relativeOffset >= partitionDelimiter.length())
					return;
				if (!partitionContent.startsWith(partitionDelimiter))
					return;
				String text = command.text;
				if (partitionContent.substring(relativeOffset, relativeOffset + text.length()).equals(text)) {
					command.length = text.length();
				}
			} else {
				if (!partitionContent.endsWith(partitionDelimiter))
					return;
				String text = command.text;
				if (partitionContent.length() - relativeOffset < text.length()) {
					text = text.substring(0, partitionContent.length() - relativeOffset);
				}
				if (partitionContent.substring(relativeOffset, relativeOffset + text.length()).equals(text))
					command.length = text.length();
			}
		}
	}

}
