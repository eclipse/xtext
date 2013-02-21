/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.validation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IReadAccess;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.ImmutableMap;

/**
 * @author Dennis Hübner - Initial contribution and API
 * @author Sven Efftinge
 * @author Michael Clay
 */
public class ValidationJob extends Job {
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(ValidationJob.class);
	public static final Object XTEXT_VALIDATION_FAMILY = new Object();
	protected static final Map<?, ?> DEFAULT_VALIDATION_CONTEXT = ImmutableMap.of(CheckMode.KEY, CheckMode.FAST_ONLY);
	private final IResourceValidator resourceValidator;
	private final IReadAccess<XtextResource> xtextDocument;
	private final IValidationIssueProcessor validationIssueProcessor;
	private final CheckMode checkMode;

	public ValidationJob(IResourceValidator xtextResourceChecker, IReadAccess<XtextResource> xtextDocument,
			IValidationIssueProcessor validationIssueProcessor,CheckMode checkMode) {
		super(Messages.ValidationJob_0);
		this.xtextDocument = xtextDocument;
		this.resourceValidator = xtextResourceChecker;
		this.validationIssueProcessor = validationIssueProcessor;
		this.checkMode = checkMode;
	}
	
	
	@Override
	public boolean belongsTo(Object family) {
		return family == XTEXT_VALIDATION_FAMILY;
	}
	
	@Override
	protected IStatus run(final IProgressMonitor monitor) {
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		List<Issue> issues = createIssues(monitor);
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		this.validationIssueProcessor.processIssues(issues, monitor);
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		return Status.OK_STATUS;
	}

	public List<Issue> createIssues(final IProgressMonitor monitor) {
		final List<Issue> issues = xtextDocument
				.readOnly(new IUnitOfWork<List<Issue>, XtextResource>() {
					public List<Issue> exec(XtextResource resource) throws Exception {
						if (resource == null || resource.isValidationDisabled())
							return Collections.emptyList();
						return resourceValidator.validate(resource, getCheckMode(), new CancelIndicator() {
							public boolean isCanceled() {
								return monitor.isCanceled();
							}
						});
					}
				});
		return issues;
	}

	protected IResourceValidator getResourceValidator() {
		return resourceValidator;
	}

	protected IReadAccess<XtextResource> getXtextDocument() {
		return xtextDocument;
	}
	
	public CheckMode getCheckMode() {
		return checkMode;
	}

}