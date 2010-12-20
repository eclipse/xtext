/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;

/**
 * Aggregates {@link TextEdit}s and/or {@link Change}s into a {@link CompositeChange}.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class UpdateAcceptor {

	private Multimap<IRefactoringDocument, ReplaceRegion> document2textReplacements = HashMultimap.create();
	private Multimap<IRefactoringDocument, Change> document2change = HashMultimap.create();
	
	public void accept(IRefactoringDocument document, ReplaceRegion replaceRegion) {
		if(document2change.containsKey(document))
			throw new IllegalStateException("Cannot accept changes and text edits for the same document.");
		document2textReplacements.put(document, replaceRegion);
	}

	public void accept(IRefactoringDocument document, Change change) {
		if(document2textReplacements.containsKey(document))
			throw new IllegalStateException("Cannot accept changes and text edits for the same document.");
		document2change.put(document, change);
	}

	public Change createChange(String name) {
		CompositeChange compositeChange = new CompositeChange(name);
		for(IRefactoringDocument document: document2textReplacements.keySet()) {
			Iterable<ReplaceRegion> textReplacements = document2textReplacements.get(document);
			MultiTextEdit multiEdit = new MultiTextEdit();
			for (ReplaceRegion textReplacement : textReplacements) {
				ReplaceEdit replaceEdit = new ReplaceEdit(textReplacement.getOffset(), textReplacement.getLength(), textReplacement.getText());
				multiEdit.addChild(replaceEdit);
			}
			Change change = document.createChange(name, multiEdit);
			compositeChange.add(change);
		}
		for(IRefactoringDocument document: document2change.keySet()) {
			Iterable<Change> documentChanges = document2change.get(document);
			CompositeChange documentCompositeChange = new CompositeChange(name);
			documentCompositeChange.addAll(Iterables.toArray(documentChanges, Change.class));
			compositeChange.add(documentCompositeChange);
		}
		return compositeChange;
	}
	
}
