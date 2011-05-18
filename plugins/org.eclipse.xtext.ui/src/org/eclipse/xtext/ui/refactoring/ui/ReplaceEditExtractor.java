/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.DocumentChange;
import org.eclipse.ltk.core.refactoring.TextChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.ui.refactoring.impl.DisplayChangeWrapper;
import org.eclipse.xtext.util.IAcceptor;

/**
 * Extracts the {@link ReplaceEdit}s for a specific {@link IDocument} from a {@link Change}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReplaceEditExtractor {

	private static final Logger LOG = Logger.getLogger(ReplaceEditExtractor.class);

	public List<ReplaceEdit> getReplaceEditsForDocument(Change change, IDocument document) {
		final List<ReplaceEdit> replaceEdits = newArrayList();
		addTextEdits(change, document, new IAcceptor<TextEdit>() {
			public void accept(TextEdit edit) {
				if (edit instanceof ReplaceEdit)
					replaceEdits.add((ReplaceEdit) edit);
			}
		});
		return replaceEdits;
	}

	protected void addTextEdits(Change change, IDocument document, IAcceptor<TextEdit> textEdits) {
		try {
			if (change instanceof DocumentChange && document.equals(((DocumentChange) change).getCurrentDocument(null))) {
				addTextEdits((DocumentChange) change, textEdits);
			} else if (change instanceof CompositeChange) {
				for (Change child : ((CompositeChange) change).getChildren()) {
					addTextEdits(child, document, textEdits);
				}
			} else if (change instanceof DisplayChangeWrapper) {
				addTextEdits(((DisplayChangeWrapper) change).getDelegate(), document, textEdits);
			}
		} catch (CoreException e) {
			LOG.error("Error document changes", e);
		}
	}

	protected void addTextEdits(TextChange change, IAcceptor<TextEdit> textEdits) {
		TextEdit edit = change.getEdit();
		addTextEdits(edit, textEdits);
	}

	protected void addTextEdits(TextEdit edit, IAcceptor<TextEdit> textEdits) {
		if (edit instanceof MultiTextEdit) {
			for (TextEdit child : edit.getChildren()) {
				addTextEdits(child, textEdits);
			}
		}
		textEdits.accept(edit);
	}

}
