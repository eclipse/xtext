/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.concurrent.IStateAccess;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.CheckMode;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
public class ValidationJob extends Job {

	private static final Logger log = Logger.getLogger(ValidationJob.class);

	private final CheckMode checkMode;
	
	private final IFile iFile;

	private final boolean deleteOldMarkers;

	private final IXtextResourceChecker xtextResourceChecker;

	private final IStateAccess<XtextResource> xtextDocument;
	
	/**
	 * Constructs a ValidationJob with a specified {@link CheckMode}
	 * 
	 */
	public ValidationJob(IXtextResourceChecker xtextResourceChecker,IStateAccess<XtextResource> xtextDocument, IFile iFile, CheckMode checkMode, boolean deleteOldMarkers) {
		super("Xtext validation");

		this.xtextDocument = xtextDocument;
		this.iFile = iFile;
		this.checkMode = checkMode;
		this.deleteOldMarkers = deleteOldMarkers;
		this.xtextResourceChecker = xtextResourceChecker;
	}

	@Override
	protected IStatus run(final IProgressMonitor monitor) {
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		log.debug("Starting Xtext Validation with CheckMode: " + checkMode);
		if (iFile == null) { // file may be null, if it was opened from an
			// IStorageEditorInput
			log.debug("Aborting Xtext Validation with CheckMode: " + checkMode + " because file does not exist.");
			return Status.OK_STATUS;
		}
		List<Map<String,Object>> issues = createIssues(monitor);
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		MarkerUtil.addMarkers(iFile, issues, checkMode, deleteOldMarkers, monitor);
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		return Status.OK_STATUS;
	}

	public List<Map<String,Object>> createIssues(final IProgressMonitor monitor) {
		final List<Map<String, Object>> issues = xtextDocument.readOnly(
				new IUnitOfWork<List<Map<String, Object>>, XtextResource>() {
					public List<Map<String, Object>> exec(XtextResource resource) throws Exception {
						return xtextResourceChecker.check(resource, getValidationContext(),	monitor);
					}
				});
		return issues;
	}

	protected IXtextResourceChecker getXtextResourceChecker() {
		return xtextResourceChecker;
	}

	protected IStateAccess<XtextResource> getXtextDocument() {
		return xtextDocument;
	}

	protected CheckMode getCheckMode() {
		return checkMode;
	}

	protected IFile getFile() {
		return iFile;
	}

	protected boolean isDeleteOldMarkers() {
		return deleteOldMarkers;
	}

	protected Map<Object, Object> getValidationContext() {
		return Collections.<Object, Object>singletonMap(CheckMode.KEY, checkMode);
	}

	public static interface Factory {
		ValidationJob create(IStateAccess<XtextResource> xtextDocument, IFile iFile, CheckMode checkMode, boolean deleteOldMarkers);
	}
}