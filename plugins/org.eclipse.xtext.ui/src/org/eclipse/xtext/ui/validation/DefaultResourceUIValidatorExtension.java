/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.validation;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class DefaultResourceUIValidatorExtension implements IResourceUIValidatorExtension {
	private final static Logger log = Logger.getLogger(DefaultResourceUIValidatorExtension.class);

	@Inject
	private IResourceValidator resourceValidator;

	@Inject
	private MarkerCreator markerCreator;

	public void updateValidationMarkers(IFile file, Resource resource, CheckMode mode, IProgressMonitor monitor) {
		if (shouldProcess(file)) {
			addMarkers(file, resource, mode, monitor);
		}
	}

	public void deleteValidationMarkers(IFile file, CheckMode checkMode, IProgressMonitor monitor) {
		if (shouldProcess(file)) {
			try {
				deleteMarkers(file, checkMode, monitor);
			} catch (CoreException ex) {
				log.error(ex.getMessage(), ex);
			}
		}
	}

	protected boolean shouldProcess(IFile file) {
		return file.isAccessible() && file.getProject().isAccessible() && !file.getProject().isHidden();
	}

	protected void addMarkers(IFile file, Resource resource, CheckMode mode, IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 1);
		try {
			List<Issue> list = resourceValidator.validate(resource, mode, getCancelIndicator(subMonitor));
			if (subMonitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			subMonitor.worked(1);
			deleteMarkers(file, mode, subMonitor);
			createMarkers(file, list, subMonitor);
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
	}

	protected void createMarkers(IFile file, List<Issue> list, IProgressMonitor monitor) throws CoreException {
		for (Issue issue : list) {
			markerCreator.createMarker(issue, file, MarkerTypes.forCheckType(issue.getType()));
		}
	}

	protected void deleteMarkers(IFile file, CheckMode checkMode, IProgressMonitor monitor) throws CoreException {
		file.deleteMarkers(MarkerTypes.FAST_VALIDATION, true, IResource.DEPTH_ZERO);
		file.deleteMarkers(MarkerTypes.NORMAL_VALIDATION, true, IResource.DEPTH_ZERO);
	}

	protected CancelIndicator getCancelIndicator(final IProgressMonitor monitor) {
		return new CancelIndicator() {
			public boolean isCanceled() {
				return monitor.isCanceled();
			}
		};
	}
}
