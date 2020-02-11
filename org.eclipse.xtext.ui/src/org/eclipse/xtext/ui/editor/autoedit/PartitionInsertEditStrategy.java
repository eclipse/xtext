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
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * inserts also the closing terminal if the opening terminal is about to be added.
 * 
 */
public class PartitionInsertEditStrategy extends AbstractEditStrategy {

	public static class Factory {
		
		@Inject
		private MembersInjector<PartitionInsertEditStrategy> injector;
		
		public PartitionInsertEditStrategy newInstance(String left, String right) {
			PartitionInsertEditStrategy result = new PartitionInsertEditStrategy(left,right);
			injector.injectMembers(result);
			return result;
		}
	}
	
	private String left;
	private String right;

	public PartitionInsertEditStrategy(String left, String right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		if (left.length() >= command.text.length() && command.text.length() > 0 && left.endsWith(command.text)) {
			ITypedRegion partition = document.getPartition(command.offset);
			if (command.offset != 0 && partition.getLength() == 0 && document.getLength() != 0) {
				ITypedRegion precedingPartition = document.getPartition(command.offset - 1);
				partition = precedingPartition;
			}
			if (partition.getOffset() + partition.getLength() >= command.offset + right.length()) {
				if (!left.equals(right) && right.equals(document.get(command.offset, right.length())))
					return;
			}
			if (isIdentifierPart(document, command.offset + command.length))
				return;
			if (left.length() > 1) {
				int minDocumentLength = left.length() - command.text.length();
				if (minDocumentLength > document.getLength()) {
					return;
				}
				if (command.offset - minDocumentLength < 0)
					return;
				String existingLeftPart = document.get(command.offset - minDocumentLength, minDocumentLength);
				if (!left.equals(existingLeftPart + command.text))
					return;
			}
			if (left.equals(right)) {
				String partitionContent = document.get(partition.getOffset(), partition.getLength());
				if (count(left, partitionContent) % 2 != 0)
					return;
				IRegion currentLine = document.getLineInformationOfOffset(command.offset);
				if (partition.getOffset() == command.offset && 
						partition.getOffset() + partition.getLength() > currentLine.getOffset() + currentLine.getLength()) {
					String trailingLine = document.get(command.offset, currentLine.getLength() - (command.offset - currentLine.getOffset()));
					if (count(left, trailingLine) % 2 != 0)
						return;
				}
			}
			command.caretOffset = command.offset + command.text.length();
			command.shiftsCaret = false;
			command.text += right;
		}
	}

}
