/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring2

import com.google.common.base.Predicate
import com.google.inject.Inject
import java.io.ByteArrayOutputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IWorkspace
import org.eclipse.ltk.core.refactoring.Change
import org.eclipse.ltk.core.refactoring.CompositeChange
import org.eclipse.ltk.core.refactoring.TextFileChange
import org.eclipse.ltk.core.refactoring.resource.MoveResourceChange
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange
import org.eclipse.text.edits.MultiTextEdit
import org.eclipse.text.edits.ReplaceEdit
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.ui.texteditor.ITextEditor
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity
import org.eclipse.xtext.ide.serializer.IEmfResourceChange
import org.eclipse.xtext.ide.serializer.ITextDocumentChange
import org.eclipse.xtext.ui.refactoring.impl.EditorDocumentChange
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult
import org.eclipse.xtext.util.IAcceptor

import static org.eclipse.xtext.ui.refactoring2.TryWithResource.*

/**
 * Converts {@link IEmfResourceChange}s to LTK {@link Change}s.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class ChangeConverter implements IAcceptor<IEmfResourceChange> {
	
	static class Factory {
		@Inject ResourceURIConverter resourceURIConverter
		@Inject(optional=true) IWorkbench workbench
		
		def create(String name, Predicate<Change> changeFilter, RefactoringIssueAcceptor issues) {
			new ChangeConverter(name, changeFilter, issues, resourceURIConverter, workbench)
		}
	}

	CompositeChange currentChange 
	RefactoringIssueAcceptor issues
	Predicate<Change> changeFilter
	
	extension ResourceURIConverter resourceUriConverter
	IWorkbench workbench
	
	protected new(String name, Predicate<Change> changeFilter, RefactoringIssueAcceptor issues, ResourceURIConverter uriConverter, IWorkbench workbench) {
		currentChange = new CompositeChange(name)
		this.issues = issues
		this.changeFilter = changeFilter
		this.resourceUriConverter = uriConverter
		this.workbench = workbench
	}

	
	override accept(IEmfResourceChange emfResourceChange) {
		doConvert(emfResourceChange)
	}
	
	def Change getChange() {
		if (currentChange.children.length === 0)
			return null
		else
			return currentChange
	}

	protected def void doConvert(IEmfResourceChange change) {
		handleReplacements(change)
		handleUriChange(change)
		if(affectsPersistedFiles()) {
			saveEditorsAfterApply()
		}
	}
	
	protected def dispatch void handleReplacements(IEmfResourceChange change) {
		val outputStream = new ByteArrayOutputStream
		tryWith(outputStream) [
			val file = change.resource.URI.toFile
			if (!file.canWrite) 
				issues.add(Severity.ERROR, '''Affected file '«file.fullPath»' is read-only''')
			file.checkDerived
			change.resource.save(outputStream, null)
			val newContent = outputStream.toByteArray
			val ltkChange = new ReplaceFileContentChange(change.oldURI.lastSegment, file, newContent) 
			addChange(ltkChange)
		]
	}
	
	protected def dispatch void handleReplacements(ITextDocumentChange change) {
		if(change.replacements.size > 0) {
			val file = change.oldURI.toFile
			if (!file.canWrite) 
				issues.add(Severity.FATAL, '''Affected file '«file.fullPath»' is read-only''')
			file.checkDerived
			val textEdits = change.replacements.map[ replacement |
				new ReplaceEdit(replacement.offset, replacement.length, replacement.replacementText)
			]
			val textEdit = new MultiTextEdit()
			textEdit.addChildren(textEdits)
			val openEditor = file.findOpenEditor
			val ltkChange = if(openEditor === null) 
					new TextFileChange(change.oldURI.lastSegment, file) => [
						saveMode = TextFileChange.FORCE_SAVE
					]
				else 
					new EditorDocumentChange(currentChange.name, openEditor, false)
			ltkChange.edit = textEdit
			ltkChange.textType = change.oldURI.fileExtension
			addChange(ltkChange)
		}
	}
	
	protected def void handleUriChange(IEmfResourceChange change) {
		if(change.newURI != change.oldURI) {
			if(change.newURI.lastSegment == change.oldURI.lastSegment) { 
				val oldFile = change.oldURI.toFile
				if (!oldFile.canWrite) 
					issues.add(Severity.FATAL, '''Cannot move read-only file '«oldFile.fullPath»'«»''')
				oldFile.checkDerived
				val newFile = change.newURI.toFile
				val newContainer = newFile.parent
				val ltkChange = new MoveResourceChange(oldFile, newContainer)
				addChange(ltkChange)
			} else if(change.newURI.trimSegments(1) == change.oldURI.trimSegments(1)) {
				val ltkChange = new RenameResourceChange(change.oldURI.toFile.fullPath, change.newURI.lastSegment)
				addChange(ltkChange)
			} 
		}
	}
	
	protected def void addChange(Change change) {
		if(changeFilter === null || changeFilter.apply(change))
			currentChange.add(change)
	}
	
	protected def boolean canWrite(IFile file) {
		return file.workspace.validateEdit(#[file], IWorkspace.VALIDATE_PROMPT).isOK
	}
	
	protected def checkDerived(IFile file) {
		if (file.derived) {
			issues.add(Severity.WARNING, '''Affected file '«file.fullPath»' is derived''')
		}
	}
	
	protected def ITextEditor findOpenEditor(IFile file) {
		new DisplayRunnableWithResult<ITextEditor>() {
			override protected run() throws Exception {
				val editorInput = new FileEditorInput(file)
				return workbench	
					.activeWorkbenchWindow
					.activePage
					.editorReferences
					.map[ getEditor(false) ]
					.filter(ITextEditor)
					.findFirst[ it.editorInput == editorInput ]
			}
		}.syncExec()
	}
	
	protected def boolean affectsPersistedFiles() {
		currentChange.children.exists[!(it instanceof EditorDocumentChange)]
	}

	protected def void saveEditorsAfterApply() {
		for (change : currentChange.children.filter(EditorDocumentChange)) {
			change.doSave = true
		}
	}
}
