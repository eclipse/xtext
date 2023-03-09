/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.contentassist;

import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.ui.document.DocumentSourceAppender;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;

import com.google.inject.Inject;

/**
 * An {@link org.eclipse.xtext.xbase.compiler.IAppendable} to insert text into an Xtend document. Takes imports and
 * existing variable names into account.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReplacingAppendable extends DocumentSourceAppender {

	public static class Factory extends DocumentSourceAppender.Factory<ReplacingAppendable> {

		@Inject
		private ReplaceConverter replaceConverter;
		
		@Override
		protected ReplacingAppendable newInstance(IXtextDocument document, RewritableImportSection importSection, WhitespaceHelper whitespaceHelper,
				String indentString, String lineSeparator, int baseIndentationLevel, boolean isJava) {
			return new ReplacingAppendable(document, importSection, whitespaceHelper, indentString, lineSeparator, baseIndentationLevel, isJava, replaceConverter);
		}
	}

	private ReplaceConverter replaceConverter;
	
	protected ReplacingAppendable(IXtextDocument document, RewritableImportSection importSection, WhitespaceHelper whitespaceHelper,
			String indentString, String lineSeparator, int baseIndentationLevel, boolean isJava, ReplaceConverter replaceConverter) {
		super(document, importSection, whitespaceHelper, indentString, lineSeparator, baseIndentationLevel, isJava);
		this.replaceConverter = replaceConverter;
	}
	
	public int commitChanges() throws BadLocationException {
		ReplaceRegion change = getChange();
		return commitChanges(change);
	}
	
	public int commitChanges(int offset, int length) throws BadLocationException {
		ReplaceRegion change = getChange(offset, length);
		return commitChanges(change);
	}

	protected int commitChanges(ReplaceRegion change) throws BadLocationException {
		getDocument().replace(change.getOffset(), change.getLength(), change.getText());
		return insertNewImports();
	}
	
	public int insertNewImports() throws BadLocationException {
		List<ReplaceRegion> importChanges = getImportSection().rewrite();
		int lengthDelta = 0;
		if(!importChanges.isEmpty()) {
			for(ReplaceRegion change: importChanges) {
				lengthDelta = lengthDelta - change.getLength() + change.getText().length(); 
			}
			replaceConverter.convertToTextEdit(importChanges).apply(getDocument());
		}
		return lengthDelta;
	}

}
