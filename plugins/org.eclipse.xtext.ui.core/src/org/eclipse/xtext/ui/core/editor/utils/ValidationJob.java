/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.utils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.editor.XtextResourceChecker;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.validator.CheckMode;

/**
 *
 * @author Dennis Hübner - Initial contribution and API
 *
 */
public final class ValidationJob extends Job {
	private static final Logger log = Logger.getLogger(ValidationJob.class);

	private final CheckMode checkMode;
	private final IXtextDocument xtextDocument;
	private final IFile iFile;

	/**
	 * Constructs a ValidationJob with a specified {@link CheckMode}
	 *
	 * @param xtextEditor
	 * @param checkMode
	 */
	public ValidationJob(XtextEditor xtextEditor, CheckMode checkMode) {
		this(xtextEditor.getDocument(), (IFile) (IFile.class.isInstance(xtextEditor.getResource()) ?
				xtextEditor.getResource() : null), checkMode);
	}

	/**
	 * Constructs a ValidationJob with a specified {@link CheckMode}
	 *
	 * @param xtextDocument
	 * @param iFile
	 * @param checkMode
	 */
	public ValidationJob(IXtextDocument xtextDocument, IFile iFile, CheckMode checkMode) {
		super("Xtext validation");

		this.xtextDocument = xtextDocument;
		this.iFile = iFile;
		this.checkMode = checkMode;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		log.debug("Starting Xtext Validation with CheckMode: " + checkMode);
		if (iFile == null) { // file may be null, if it was opend from an IStorageEditorInput
			log.debug("Aborting Xtext Validation with CheckMode: " + checkMode + " because file does not exist.");
			return Status.OK_STATUS;
		}
		final List<Map<String, Object>> issues = xtextDocument.readOnly(new UnitOfWork<List<Map<String, Object>>>() {
			public List<Map<String, Object>> exec(XtextResource resource) throws Exception {
				return XtextResourceChecker.check(resource, Collections.singletonMap(CheckMode.KEY, checkMode));
			}
		});
		XtextResourceChecker.addMarkers(iFile, issues, false, monitor);
		return Status.OK_STATUS;
	}
}