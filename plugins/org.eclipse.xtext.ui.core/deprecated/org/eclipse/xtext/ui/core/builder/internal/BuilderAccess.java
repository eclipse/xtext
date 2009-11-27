/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.internal;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.xtext.ui.core.builder.IBuilderAccess;

public class BuilderAccess implements IBuilderAccess {
	private IncrementalProjectBuilder delegate;
	
	public BuilderAccess(IncrementalProjectBuilder delegate) {
		this.delegate = delegate;
	}

	public IResourceDelta getDelta(IProject project) {
		return delegate.getDelta(project);
	}

	public IProject getProject() {
		return delegate.getProject();
	}

	public boolean hasBeenBuilt(IProject project) {
		return delegate.hasBeenBuilt(project);
	}

	public boolean isInterrupted() {
		return delegate.isInterrupted();
	}

	public void needRebuild() {
		delegate.needRebuild();
	}

}