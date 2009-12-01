/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.ui.core.builder.impl.AddMarkersOperation;
import org.eclipse.xtext.validation.Issue;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public class MarkerIssueProcessor implements IValidationIssueProcessor {
	private final IResource resource;
	
	private Logger log = Logger.getLogger(getClass());

	public MarkerIssueProcessor(IResource resource) {
		super();
		this.resource = resource;
	}

	public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
		try {
			new AddMarkersOperation(resource, issues, EValidator.MARKER, true).run(monitor);
		} catch (InvocationTargetException e) {
			log.error("Could not create marker.", e);
		} catch (InterruptedException e) {
			log.error("Could not create marker.", e);
		}
	}
}
