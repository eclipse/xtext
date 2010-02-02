/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractEditStrategy implements IAutoEditStrategy{
	
	public int count(String toFind, StringBuilder textToSearch) throws BadLocationException {
		int count = 0;
		int index = -toFind.length();
		while (true) {
			int newIndex = textToSearch.substring(index + toFind.length()).indexOf(toFind);
			if (newIndex == -1) {
				return count;
			} else {
				int absoluteIndex = index + newIndex;
				count++;
				index = absoluteIndex + toFind.length();
			}
		}
	}
	
	protected StringBuilder getTextToScan(IDocument document) {
		return new StringBuilder(document.get());
	}
}
