/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.builder.impl.javasupport.JavaChangeQueueFiller;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;

/**
 * A resource description delta is considered to be "unconfirmed" when it originated from resource change event (
 * {@link JavaChangeQueueFiller} and it is unclear if the Java classes structure (fields, method signatures) have
 * actually changed. {@link QueuedBuildData#tryConfirmAllChanges(IProject)} can then confirm the changes.
 * 
 * This extra effort of "confirming" changes is done to avoid that non-structural changes (e.g. add a statement inside a
 * method body) cause referencing Xtext files to be rebuild.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class UnconfirmedResourceDescriptionDelta extends DefaultResourceDescriptionDelta {

	private final IProject project;

	private int buildNumber = -1;

	public int getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(int buildNumber) {
		this.buildNumber = buildNumber;
	}

	public UnconfirmedResourceDescriptionDelta(IProject project, IResourceDescription old, IResourceDescription _new) {
		super(old, _new);
		this.project = project;
	}

	public IProject getProject() {
		return project;
	}

}
