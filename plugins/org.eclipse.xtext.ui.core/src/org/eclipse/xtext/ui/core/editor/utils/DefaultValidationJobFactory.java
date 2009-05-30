package org.eclipse.xtext.ui.core.editor.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.concurrent.IStateAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.IXtextResourceChecker;
import org.eclipse.xtext.validation.CheckMode;

import com.google.inject.Inject;

public class DefaultValidationJobFactory implements ValidationJob.Factory {

	private IXtextResourceChecker xtextResourceChecker;

	@Inject
	public DefaultValidationJobFactory(IXtextResourceChecker xtextResourceChecker) {
		this.xtextResourceChecker = xtextResourceChecker;
	}

	public ValidationJob create(IStateAccess<XtextResource> xtextDocument, IFile iFile, CheckMode checkMode, boolean deleteOldMarkers) {
		return new ValidationJob(xtextResourceChecker, xtextDocument, iFile, checkMode, deleteOldMarkers);
	}

}
