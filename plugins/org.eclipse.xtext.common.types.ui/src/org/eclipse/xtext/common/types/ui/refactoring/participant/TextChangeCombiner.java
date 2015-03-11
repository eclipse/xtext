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
import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.refactoring.CompilationUnitChange;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.TextChange;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.text.edits.TextEditVisitor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.refactoring.impl.DisplayChangeWrapper;
import org.eclipse.xtext.ui.refactoring.impl.EditorDocumentChange;

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
		Map<Object, TextChange> resource2textChange = newLinkedHashMap();
		List<Change> otherChanges = newArrayList();
		Set<IEditorPart> editorsToSave = newHashSet();
		visitCompositeChange((CompositeChange) masterChange, resource2textChange, otherChanges, editorsToSave);
		CompositeChange compositeChange = new FilteringCompositeChange(masterChange.getName());
		for (TextChange combinedTextChange : resource2textChange.values()) {
			if(((MultiTextEdit) combinedTextChange.getEdit()).getChildrenSize() >0) {
				if(combinedTextChange instanceof EditorDocumentChange) {
					((EditorDocumentChange) combinedTextChange).setDoSave(editorsToSave.contains(((EditorDocumentChange) combinedTextChange).getEditor()));
					compositeChange.add(combinedTextChange);
				}
				else
					compositeChange.add(DisplayChangeWrapper.wrap(combinedTextChange));
			}
		}
		for(Change otherChange: otherChanges) 
			compositeChange.add(DisplayChangeWrapper.wrap(otherChange));
		if(compositeChange.getChildren().length == 0)
			return null;
		return compositeChange;
	}

	protected void visitCompositeChange(CompositeChange sourceChange, Map<Object, TextChange> resource2textChange,
			List<Change> otherChanges, Set<IEditorPart> editorsToSave) {
		for (Change sourceSubChange : sourceChange.getChildren()) {
			visitChange(sourceSubChange, resource2textChange, otherChanges, editorsToSave);
		}
	}

	protected void visitChange(Change sourceChange, Map<Object, TextChange> resource2textChange, List<Change> otherChanges, Set<IEditorPart> editorsToSave) {
		if (sourceChange instanceof DisplayChangeWrapper.Wrapper) 
			visitChange(((DisplayChangeWrapper.Wrapper) sourceChange).getDelegate(), resource2textChange, otherChanges, editorsToSave);
		else if (sourceChange instanceof CompositeChange) {
			visitCompositeChange((CompositeChange) sourceChange, resource2textChange, otherChanges, editorsToSave);
		} else if (sourceChange instanceof TextChange) {
			if (sourceChange instanceof EditorDocumentChange) 
				editorsToSave.add(((EditorDocumentChange) sourceChange).getEditor());
			Object key = getKey((TextChange) sourceChange);
			if (key != null) {
				TextChange textChange = resource2textChange.get(key);
				if (textChange == null) {
					textChange = createTextChange(key, ((TextChange) sourceChange).getTextType());
					resource2textChange.put(key, textChange);
				}
				MultiTextEdit combinedEdits = (MultiTextEdit) textChange.getEdit();
				TextEdit newEdit = ((TextChange) sourceChange).getEdit().copy();
				if (newEdit instanceof MultiTextEdit) {
					for (TextEdit newTextEdit : ((MultiTextEdit) newEdit).getChildren()) {
						addIfNotDuplicate(combinedEdits, newTextEdit);
					}
				} else {
					addIfNotDuplicate(combinedEdits, newEdit);
				}
			}
		} else {
			CompositeChange parent = (CompositeChange) sourceChange.getParent();
			if(parent != null)
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
		else if (change instanceof EditorDocumentChange) {
			return ((EditorDocumentChange) change).getEditor();
		} else {
			LOG.error("Unhandled TextChange type: " + change.getClass().getName());
		}
		return null;
	}

	protected TextChange createTextChange(Object key, String textType) {
		TextChange change = null;
		if (key instanceof ICompilationUnit)
			change = new CompilationUnitChange("Combined CompilationUnitChange", (ICompilationUnit) key);
		else if (key instanceof IFile)
			change = new TextFileChange("Combined TextFileChange", (IFile) key);
		else if (key instanceof ITextEditor)
			change = new EditorDocumentChange("Combined DocumentChange", (ITextEditor) key, false);
		else
			LOG.error("Error creating change for " + key.getClass().getName());
		if(change != null) {
			MultiTextEdit edits = new MultiTextEdit();
			change.setEdit(edits);
			change.setTextType(textType);
		}
		return change;
	}
	
}
