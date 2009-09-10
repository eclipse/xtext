/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.concurrent.IStateAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.CheckMode;

import com.google.inject.Inject;

public class DefaultValidationJobFactory implements ValidationJob.Factory {

	@Inject
	private IXtextResourceChecker xtextResourceChecker;

	public ValidationJob create(IStateAccess<XtextResource> xtextDocument, IFile iFile, CheckMode checkMode, boolean deleteOldMarkers) {
		return new ValidationJob(xtextResourceChecker, xtextDocument, iFile, checkMode, deleteOldMarkers);
	}

	public void setXtextResourceChecker(IXtextResourceChecker xtextResourceChecker) {
		this.xtextResourceChecker = xtextResourceChecker;
	}

	public IXtextResourceChecker getXtextResourceChecker() {
		return xtextResourceChecker;
	}

}
