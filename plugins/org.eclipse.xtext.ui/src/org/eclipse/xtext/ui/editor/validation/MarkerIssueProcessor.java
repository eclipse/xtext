/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.validation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.ImmutableSet;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public class MarkerIssueProcessor implements IValidationIssueProcessor {
	private final IResource resource;
	
	private Logger log = Logger.getLogger(getClass());

	private MarkerCreator markerCreator;

	private MarkerTypeProvider markerTypeProvider;

	/**
	 * @deprecated use {@link MarkerIssueProcessor#MarkerIssueProcessor(IResource, MarkerCreator, MarkerTypeProvider) instead.}
	 */
	@Deprecated
	public MarkerIssueProcessor(IResource resource, MarkerCreator markerCreator) {
		this(resource, markerCreator, new MarkerTypeProvider());
	}
	
	/**
	 * @since 2.3
	 */
	public MarkerIssueProcessor(IResource resource, MarkerCreator markerCreator, MarkerTypeProvider markerTypeProvider) {
		super();
		this.resource = resource;
		this.markerCreator = markerCreator;
		this.markerTypeProvider = markerTypeProvider;
	}

	public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
		try {
			new AddMarkersOperation(resource, issues, ImmutableSet.of(MarkerTypes.FAST_VALIDATION,
					MarkerTypes.NORMAL_VALIDATION, MarkerTypes.EXPENSIVE_VALIDATION), true, // delete existing markers 
					markerCreator, markerTypeProvider).run(monitor);
		} catch (InvocationTargetException e) {
			log.error("Could not create marker.", e);
		} catch (InterruptedException e) {
			log.error("Could not create marker.", e);
		}
	}
}
