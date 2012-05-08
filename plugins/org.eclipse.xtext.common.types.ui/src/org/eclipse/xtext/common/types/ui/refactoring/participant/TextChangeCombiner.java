/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring.participant;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.refactoring.CompilationUnitChange;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.DocumentChange;
import org.eclipse.ltk.core.refactoring.TextChange;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.text.edits.TextEditVisitor;
import org.eclipse.xtext.ui.refactoring.impl.DisplayChangeWrapper;

/**
 * Restructures a given source change such that all changes to the same resource are united.
 * 
 * This is necessary in order to resolve conflicts between changes to the same resource from multiple refactoring
 * processors / participants within the same refactoring.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TextChangeCombiner {

	private static final Logger LOG = Logger.getLogger(TextChangeCombiner.class);

	public Change combineChanges(Change masterChange) {
		if (!(masterChange instanceof CompositeChange))
			return masterChange;
		Map<Object, MultiTextEdit> resource2edits = newLinkedHashMap();
		List<Change> otherChanges = newArrayList();
		visitCompositeChange((CompositeChange) masterChange, resource2edits, otherChanges);
		CompositeChange compositeChange = new CompositeChange(masterChange.getName());
		for (Map.Entry<Object, MultiTextEdit> resource2edit : resource2edits.entrySet()) {
			Object key = resource2edit.getKey();
			TextChange combinedTextChange = createChange(key);
			if (combinedTextChange != null) {
				combinedTextChange.setEdit(resource2edit.getValue());
				compositeChange.add(combinedTextChange);
			}
		}
		for(Change otherChange: otherChanges) 
			compositeChange.add(otherChange);
		if(compositeChange.getChildren().length == 0)
			return null;
		return compositeChange;
	}

	private void visitCompositeChange(CompositeChange sourceChange, Map<Object, MultiTextEdit> resource2edits,
			List<Change> otherChanges) {
		for (Change sourceSubChange : sourceChange.getChildren()) {
			visitChange(sourceSubChange, resource2edits, otherChanges);
		}
	}

	protected void visitChange(Change sourceChange, Map<Object, MultiTextEdit> resource2edits, List<Change> otherChanges) {
		if (sourceChange instanceof DisplayChangeWrapper)
			visitChange(((DisplayChangeWrapper) sourceChange).getDelegate(), resource2edits, otherChanges);
		else if (sourceChange instanceof CompositeChange) {
			visitCompositeChange((CompositeChange) sourceChange, resource2edits, otherChanges);
		} else if (sourceChange instanceof TextChange) {
			Object key = getKey((TextChange) sourceChange);
			if (key != null) {
				MultiTextEdit multiTextEdit = resource2edits.get(key);
				if (multiTextEdit == null) {
					multiTextEdit = new MultiTextEdit();
					resource2edits.put(key, multiTextEdit);
				}
				TextEdit edit = ((TextChange) sourceChange).getEdit().copy();
				if (edit instanceof MultiTextEdit) {
					for (TextEdit textEdit : ((MultiTextEdit) edit).getChildren()) {
						addIfNotDuplicate(multiTextEdit, textEdit);
					}
				} else {
					addIfNotDuplicate(multiTextEdit, edit);
				}
			}
		} else {
			CompositeChange parent = (CompositeChange) sourceChange.getParent();
			parent.remove(sourceChange);
			otherChanges.add(sourceChange);
		}
	}

	protected void addIfNotDuplicate(MultiTextEdit multiTextEdit, final TextEdit editToBeAdded) {
		final boolean[] overlaps = new boolean[] { false };
		TextEditVisitor textEditVisitor = new TextEditVisitor() {
			@Override
			public boolean visitNode(TextEdit edit) {
				overlaps[0] |= !(edit instanceof MultiTextEdit) && edit.covers(editToBeAdded);
				return super.visitNode(edit);
			}
		};
		multiTextEdit.accept(textEditVisitor);
		if (!overlaps[0])
			multiTextEdit.addChild(editToBeAdded.copy());
	}

	protected Object getKey(TextChange change) {
		if (change instanceof CompilationUnitChange)
			return ((CompilationUnitChange) change).getCompilationUnit();
		else if (change instanceof TextFileChange)
			return ((TextFileChange) change).getFile();
		else if (change instanceof DocumentChange) {
			try {
				return ((DocumentChange) change).getCurrentDocument(new NullProgressMonitor());
			} catch (CoreException e) {
				LOG.error("Error getting document for change.", e);
			}
		} else
			LOG.error("Unhandled TextChange type: " + change.getClass().getName());
		return null;
	}

	protected TextChange createChange(Object key) {
		if (key instanceof ICompilationUnit)
			return new CompilationUnitChange("Combined CompilationUnitChange", (ICompilationUnit) key);
		else if (key instanceof IFile)
			return new TextFileChange("Combined TextFileChange", (IFile) key);
		else if (key instanceof IDocument)
			return new DocumentChange("Combined DocumentChange", (IDocument) key);
		else
			LOG.error("Error creating change for " + key.getClass().getName());
		return null;
	}
}
