/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.containers;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class JavaProjectsState extends AbstractJavaProjectsState {

	@Inject
	private WorkspaceProjectsStateHelper projectsHelper;
	
	@Inject
	private JavaProjectsStateHelper javaProjectsHelper;
	
	@Override
	protected Collection<URI> doInitContainedURIs(String containerHandle) {
		Collection<URI> result = javaProjectsHelper.initContainedURIs(containerHandle);
		if (!result.isEmpty())
			return result;
		return projectsHelper.initContainedURIs(containerHandle);
	}
	
	@Override
	protected String doInitHandle(URI uri) {
		String result = javaProjectsHelper.initHandle(uri);
		if (result != null)
			return result;
		return projectsHelper.initHandle(uri);
	}
	
	@Override
	protected List<String> doInitVisibleHandles(String handle) {
		List<String> result = javaProjectsHelper.initVisibleHandles(handle);
		if (!result.isEmpty())
			return result;
		return projectsHelper.initVisibleHandles(handle);
	}
	
	public JavaProjectsStateHelper getJavaProjectsHelper() {
		return javaProjectsHelper;
	}
	
	public void setJavaProjectsHelper(JavaProjectsStateHelper javaProjectsHelper) {
		this.javaProjectsHelper = javaProjectsHelper;
	}
	
	public WorkspaceProjectsStateHelper getProjectsHelper() {
		return projectsHelper;
	}
	
	public void setProjectsHelper(WorkspaceProjectsStateHelper projectsHelper) {
		this.projectsHelper = projectsHelper;
	}
	
}
