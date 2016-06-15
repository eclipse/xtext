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

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * deletes the closing terminals if the opening terminals of a certain partitions are to be removed.
 * 
 */
public class PartitionDeletionEditStrategy extends AbstractEditStrategy {
	
	public static class Factory {
		
		@Inject
		private MembersInjector<PartitionDeletionEditStrategy> injector;
		
		public PartitionDeletionEditStrategy newInstance(String left, String right) {
			PartitionDeletionEditStrategy result = new PartitionDeletionEditStrategy(left,right);
			injector.injectMembers(result);
			return result;
		}
	}

	private String left;
	private String right;

	public PartitionDeletionEditStrategy(String left, String right) {
		this.left = left;
		this.right = right;
	}
	
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


}