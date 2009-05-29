package org.eclipse.xtext.ui.core.editor.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.ui.core.editor.IXtextResourceChecker;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.validation.CheckMode;

import com.google.inject.Inject;

public class DefaultValidationJobFactory implements ValidationJob.Factory {

	private IXtextResourceChecker xtextResourceChecker;

	@Inject
	public DefaultValidationJobFactory(IXtextResourceChecker xtextResourceChecker) {
		this.xtextResourceChecker = xtextResourceChecker;
	}

	public ValidationJob create(XtextEditor xtextEditor, CheckMode checkMode) {
		return new ValidationJob(xtextResourceChecker, xtextEditor, checkMode);
	}

	public ValidationJob create(XtextEditor xtextEditor, CheckMode checkMode, boolean deleteOldMarkers) {
		return new ValidationJob(xtextResourceChecker, xtextEditor, checkMode, deleteOldMarkers);
	}

	public ValidationJob create(IXtextDocument xtextDocument, IFile iFile, CheckMode checkMode, boolean deleteOldMarkers) {
		return new ValidationJob(xtextResourceChecker, xtextDocument, iFile, checkMode, deleteOldMarkers);
	}

}
