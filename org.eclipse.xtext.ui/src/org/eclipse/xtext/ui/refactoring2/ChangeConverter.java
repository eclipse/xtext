/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.refactoring2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.TextChange;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.ltk.core.refactoring.resource.MoveResourceChange;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.ITextDocumentChange;
import org.eclipse.xtext.ui.refactoring.impl.EditorDocumentChange;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;
import org.eclipse.xtext.util.Exceptions;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.internal.Nullable;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * Converts {@link IEmfResourceChange}s to LTK {@link Change}s.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public class ChangeConverter implements IAcceptor<IEmfResourceChange> {

	public static class Factory {

		@Inject
		private ResourceURIConverter resourceURIConverter;

		@Inject(optional = true)
		@Nullable
		private IWorkbench workbench;

		public ChangeConverter create(String name, Predicate<Change> changeFilter, RefactoringIssueAcceptor issues) {
			return new ChangeConverter(name, changeFilter, issues, resourceURIConverter, workbench);
		}
	}

	private static final Logger LOG = Logger.getLogger(ChangeConverter.class);

	private final CompositeChange currentChange;

	private final RefactoringIssueAcceptor issues;

	private final Predicate<Change> changeFilter;

	private final ResourceURIConverter resourceUriConverter;

	private final IWorkbench workbench;

	protected ChangeConverter(String name, Predicate<Change> changeFilter, RefactoringIssueAcceptor issues,
			ResourceURIConverter uriConverter, IWorkbench workbench) {
		currentChange = new CompositeChange(name);
		this.issues = issues;
		this.changeFilter = changeFilter;
		this.resourceUriConverter = uriConverter;
		this.workbench = workbench;
	}

	@Override
	public void accept(IEmfResourceChange emfResourceChange) {
		doConvert(emfResourceChange);
	}

	public Change getChange() {
		if (currentChange.getChildren().length == 0) {
			return null;
		} else {
			return currentChange;
		}
	}

	protected void doConvert(IEmfResourceChange change) {
		handleReplacements(change);
		handleUriChange(change);
		if (affectsPersistedFiles()) {
			saveEditorsAfterApply();
		}
	}

	protected void handleReplacements(IEmfResourceChange change) {
		if (change instanceof ITextDocumentChange) {
			_handleReplacements((ITextDocumentChange) change);
		} else if (change != null) {
			_handleReplacements(change);
		} else {
			throw new IllegalArgumentException("Unhandled parameter types: " + Arrays.asList(change).toString());
		}
	}

	protected void _handleReplacements(IEmfResourceChange change) {
		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			try {
				IFile file = resourceUriConverter.toFile(change.getOldURI());
				if (!canWrite(file)) {
					issues.add(RefactoringIssueAcceptor.Severity.ERROR, "Affected file '" + file.getFullPath() + "' is read-only");
					return;
				}
				checkDerived(file);
				change.getResource().save(outputStream, null);
				byte[] newContent = outputStream.toByteArray();
				String lastSegment = change.getOldURI().lastSegment();
				ReplaceFileContentChange ltkChange = new ReplaceFileContentChange(lastSegment, file, newContent);
				addChange(ltkChange);
			} catch (IOException e) {
				Exceptions.throwUncheckedException(e);
			}
		} catch (IOException e) {
			LOG.error("Error closing stream", e);
		}
	}

	protected void _handleReplacements(ITextDocumentChange change) {
		if (!change.getReplacements().isEmpty()) {
			IFile file = resourceUriConverter.toFile(change.getOldURI());
			if (!canWrite(file)) {
				issues.add(RefactoringIssueAcceptor.Severity.FATAL, "Affected file '" + file.getFullPath() + "' is read-only");
			}
			checkDerived(file);
			List<ReplaceEdit> textEdits = change.getReplacements().stream().map(replacement -> {
				return new ReplaceEdit(replacement.getOffset(), replacement.getLength(), replacement.getReplacementText());
			}).collect(Collectors.toList());

			MultiTextEdit textEdit = new MultiTextEdit();
			textEdit.addChildren(textEdits.toArray(new TextEdit[textEdits.size()]));
			ITextEditor openEditor = findOpenEditor(file);
			final TextChange ltkChange;
			if (openEditor == null) {
				TextFileChange textFileChange = new TextFileChange(change.getOldURI().lastSegment(), file);
				textFileChange.setSaveMode(TextFileChange.FORCE_SAVE);
				ltkChange = textFileChange;
			} else {
				ltkChange = new EditorDocumentChange(currentChange.getName(), openEditor, false);
			}
			ltkChange.setEdit(textEdit);
			ltkChange.setTextType(change.getOldURI().fileExtension());
			addChange(ltkChange);
		}
	}

	protected void handleUriChange(IEmfResourceChange change) {
		if (!Objects.equals(change.getNewURI(), change.getOldURI())) {
			if (Objects.equals(change.getNewURI().lastSegment(), change.getOldURI().lastSegment())) {
				IFile oldFile = resourceUriConverter.toFile(change.getOldURI());
				if (!canWrite(oldFile)) {
					issues.add(RefactoringIssueAcceptor.Severity.FATAL, "Cannot move read-only file '" + oldFile.getFullPath() + "'");
				}
				checkDerived(oldFile);
				IFile newFile = resourceUriConverter.toFile(change.getNewURI());
				IContainer newContainer = newFile.getParent();
				MoveResourceChange ltkChange = new MoveResourceChange(oldFile, newContainer);
				addChange(ltkChange);
			} else {
				if (Objects.equals(change.getNewURI().trimSegments(1), change.getOldURI().trimSegments(1))) {
					RenameResourceChange ltkChange = new RenameResourceChange(resourceUriConverter.toFile(change.getOldURI()).getFullPath(),
							change.getNewURI().lastSegment());
					addChange(ltkChange);
				}
			}
		}
	}

	protected void addChange(Change change) {
		if (changeFilter == null || changeFilter.apply(change)) {
			currentChange.add(change);
		}
	}

	protected boolean canWrite(IFile file) {
		return file.getWorkspace().validateEdit(new IFile[] { file }, IWorkspace.VALIDATE_PROMPT).isOK();
	}

	protected void checkDerived(IFile file) {
		if (file.isDerived()) {
			issues.add(RefactoringIssueAcceptor.Severity.WARNING, "Affected file '" + file.getFullPath() + "' is derived");
		}
	}

	protected ITextEditor findOpenEditor(IFile file) {
		if (workbench == null) {
			return null;
		}

		return new DisplayRunnableWithResult<ITextEditor>() {

			@Override
			protected ITextEditor run() throws Exception {
				FileEditorInput editorInput = new FileEditorInput(file);
				IEditorPart editorPart = workbench.getActiveWorkbenchWindow().getActivePage().findEditor(editorInput);
				if (editorPart instanceof ITextEditor) {
					return (ITextEditor) editorPart;
				}
				return null;
			}
		}.syncExec();
	}

	protected boolean affectsPersistedFiles() {
		return Arrays.asList(currentChange.getChildren()) //
				.stream() //
				.anyMatch(change -> !(change instanceof EditorDocumentChange));
	}

	protected void saveEditorsAfterApply() {
		for (Change change : currentChange.getChildren()) {
			if (change instanceof EditorDocumentChange) {
				((EditorDocumentChange) change).setDoSave(true);
			}
		}
	}

}
