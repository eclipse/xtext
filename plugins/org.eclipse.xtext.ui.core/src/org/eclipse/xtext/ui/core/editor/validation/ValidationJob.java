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
 * @author Sven Efftinge
 */
public abstract class ValidationJob extends Job {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(ValidationJob.class);

	private final IXtextResourceChecker xtextResourceChecker;

	private final IStateAccess<XtextResource> xtextDocument;

	public ValidationJob(IXtextResourceChecker xtextResourceChecker, IStateAccess<XtextResource> xtextDocument) {
		super("Xtext validation");
		this.xtextDocument = xtextDocument;
		this.xtextResourceChecker = xtextResourceChecker;
	}

	@Override
	protected IStatus run(final IProgressMonitor monitor) {
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		List<Map<String, Object>> issues = createIssues(monitor);
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		processIssues(issues, monitor);
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		return Status.OK_STATUS;
	}


	protected abstract void processIssues(List<Map<String, Object>> issues, IProgressMonitor monitor);
	

	public List<Map<String, Object>> createIssues(final IProgressMonitor monitor) {
		final List<Map<String, Object>> issues = xtextDocument
				.readOnly(new IUnitOfWork<List<Map<String, Object>>, XtextResource>() {
					public List<Map<String, Object>> exec(XtextResource resource) throws Exception {
						return xtextResourceChecker.check(resource, getValidationContext(), monitor);
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

	protected Map<Object, Object> getValidationContext() {
		return Collections.<Object, Object> singletonMap(CheckMode.KEY, CheckMode.FAST_ONLY);
	}

}