/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author koehnlein - Initial contribution and API
 */
public class TextEditAcceptor {

	private Multimap<IRefactoringDocument, TextEdit> doc2edits = HashMultimap.create();

	public void accept(IRefactoringDocument document, TextEdit textEdit) {
		doc2edits.put(document, textEdit);
	}

	public Change getCompositeChange(String name) {
		CompositeChange compositeChange = new CompositeChange(name);
		for (IRefactoringDocument document : doc2edits.keySet()) {
			Change textChange = createChange(name, document);
			compositeChange.add(textChange);
		}
		return new DisplayChangeWrapper(compositeChange);
	}

	protected Change createChange(String name, IRefactoringDocument document) {
		MultiTextEdit multiEdit = new MultiTextEdit();
		for (TextEdit edit : doc2edits.get(document)) {
			multiEdit.addChild(edit);
		}
		Change change = document.createChange(name, multiEdit);
		return change;
	}

}
