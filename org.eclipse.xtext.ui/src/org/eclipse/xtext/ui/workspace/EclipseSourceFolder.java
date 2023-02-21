/**
 * Copyright (c) 2013, 2020, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.workspace;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.workspace.ISourceFolder;

import com.google.common.base.Objects;

public class EclipseSourceFolder implements ISourceFolder {

	private final IProject project;

	private final String name;

	public EclipseSourceFolder(IProject project, String name) {
		this.project = project;
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public URI getPath() {
		final URI result = URI.createPlatformResourceURI("/" + project.getName() + "/" + name, true);
		if (result.hasTrailingPathSeparator()) {
			return result;
		} else {
			return result.appendSegment("");
		}
	}

	@Override
	public int hashCode() {
		return this.getPath().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EclipseSourceFolder) {
			URI path1 = this.getPath();
			URI path2 = ((EclipseSourceFolder) obj).getPath();
			return Objects.equal(path1, path2);
		}
		return false;
	}

	@Override
	public String toString() {
		return "project " + project + " name " + name + " (" + getPath() + ")";
	}

	public IProject getProject() {
		return project;
	}
}