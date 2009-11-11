/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IStateAccess;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;

import com.google.common.collect.ImmutableMap;

/**
 * @author Dennis Hübner - Initial contribution and API
 * @author Sven Efftinge
 * @author Michael Clay
 */
public class ValidationJob extends Job {
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(ValidationJob.class);
	protected static final Map<?, ?> DEFAULT_VALIDATION_CONTEXT = ImmutableMap.of(CheckMode.KEY, CheckMode.FAST_ONLY);
	private final IXtextResourceChecker xtextResourceChecker;
	private final IStateAccess<XtextResource> xtextDocument;
	private final IValidationIssueProcessor validationIssueProcessor;
	private final Map<?, ?> validationContext;

	public ValidationJob(IXtextResourceChecker xtextResourceChecker, IStateAccess<XtextResource> xtextDocument,
			IValidationIssueProcessor validationIssueProcessor,Map<?, ?> validationContext) {
		super("Xtext validation");
		this.xtextDocument = xtextDocument;
		this.xtextResourceChecker = xtextResourceChecker;
		this.validationIssueProcessor = validationIssueProcessor;
		this.validationContext = validationContext;
	}
	
	public ValidationJob(IXtextResourceChecker xtextResourceChecker, IStateAccess<XtextResource> xtextDocument,
			IValidationIssueProcessor validationIssueProcessor) {
		this(xtextResourceChecker,xtextDocument,validationIssueProcessor,DEFAULT_VALIDATION_CONTEXT);
	}

	@Override
	protected IStatus run(final IProgressMonitor monitor) {
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		List<Map<String, Object>> issues = createIssues(monitor);
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		this.validationIssueProcessor.processIssues(issues, monitor);
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		return Status.OK_STATUS;
	}

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

	protected Map<?, ?> getValidationContext() {
		return validationContext;
	}
}