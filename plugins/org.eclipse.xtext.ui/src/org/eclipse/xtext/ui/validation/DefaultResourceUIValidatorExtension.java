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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.service.OperationCanceledError;
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
public class DefaultResourceUIValidatorExtension extends MarkerEraser implements IResourceUIValidatorExtension {
	private final static Logger log = Logger.getLogger(DefaultResourceUIValidatorExtension.class);

	@Inject
	private IResourceValidator resourceValidator;

	@Inject
	private MarkerCreator markerCreator;
	
	@Inject
	private MarkerTypeProvider markerTypeProvider;

	@Override
	public void updateValidationMarkers(IFile file, Resource resource, CheckMode mode, IProgressMonitor monitor) throws OperationCanceledException {
		if (shouldProcess(file)) {
			addMarkers(file, resource, mode, monitor);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteValidationMarkers(IFile file, CheckMode checkMode, IProgressMonitor monitor) {
		super.deleteValidationMarkers(file, checkMode, monitor);
	}

	protected void addMarkers(IFile file, Resource resource, CheckMode mode, IProgressMonitor monitor) throws OperationCanceledException {
		try {
			List<Issue> list = resourceValidator.validate(resource, mode, getCancelIndicator(monitor));
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			deleteMarkers(file, mode, monitor);
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			createMarkers(file, list, monitor);
		} catch (OperationCanceledError error) {
			throw error.getWrapped();
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
	}

	protected void createMarkers(IFile file, List<Issue> list, IProgressMonitor monitor) throws CoreException {
		for (Issue issue : list) {
			markerCreator.createMarker(issue, file, markerTypeProvider.getMarkerType(issue));
		}
	}

	protected CancelIndicator getCancelIndicator(final IProgressMonitor monitor) {
		return new CancelIndicator() {
			@Override
			public boolean isCanceled() {
				return monitor.isCanceled();
			}
		};
	}
}
