/*******************************************************************************
 * Copyright (c) 2009, 2017 Michael Clay and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.validation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.source.IAnnotationModel;
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

	private IAnnotationModel annotationModel;

	/**
	 * @deprecated use {@link MarkerIssueProcessor#MarkerIssueProcessor(IResource, IAnnotationModel, MarkerCreator, MarkerTypeProvider)}
	 *             instead.
	 */
	@Deprecated
	public MarkerIssueProcessor(IResource resource, MarkerCreator markerCreator) {
		this(resource, markerCreator, new MarkerTypeProvider());
	}

	/**
	 * @deprecated use {@link MarkerIssueProcessor#MarkerIssueProcessor(IResource, IAnnotationModel, MarkerCreator, MarkerTypeProvider)}
	 *             instead.
	 */
	@Deprecated
	public MarkerIssueProcessor(IResource resource, MarkerCreator markerCreator, MarkerTypeProvider markerTypeProvider) {
		super();
		this.resource = resource;
		this.markerCreator = markerCreator;
		this.markerTypeProvider = markerTypeProvider;
	}

	/**
	 * @since 2.14
	 */
	public MarkerIssueProcessor(IResource resource, IAnnotationModel annotationModel, MarkerCreator markerCreator,
			MarkerTypeProvider markerTypeProvider) {
		super();
		this.resource = resource;
		this.annotationModel = annotationModel;
		this.markerCreator = markerCreator;
		this.markerTypeProvider = markerTypeProvider;
	}

	@Override
	public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
		try {
			new AddMarkersOperation(resource, issues,
					ImmutableSet.of(MarkerTypes.FAST_VALIDATION, MarkerTypes.NORMAL_VALIDATION, MarkerTypes.EXPENSIVE_VALIDATION), true, // delete existing markers 
					annotationModel, markerCreator, markerTypeProvider).run(monitor);
		} catch (InvocationTargetException e) {
			log.error("Could not create marker.", e);
		} catch (InterruptedException e) {
			// cancelled by user; ok
		}
	}
}
