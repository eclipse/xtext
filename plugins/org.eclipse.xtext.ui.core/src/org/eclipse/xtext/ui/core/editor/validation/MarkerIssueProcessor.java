/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.ui.core.builder.impl.AddMarkersOperation;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public class MarkerIssueProcessor implements IValidationIssueProcessor {
	private final IResource resource;

	public MarkerIssueProcessor(IResource resource) {
		super();
		this.resource = resource;
	}

	public void processIssues(List<Map<String, Object>> issues, IProgressMonitor monitor) {
		AddMarkersOperation.run(this.resource, issues, true, monitor);
	}
}
