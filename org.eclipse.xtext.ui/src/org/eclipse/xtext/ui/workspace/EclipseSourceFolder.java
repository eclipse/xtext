/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
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
		return URI.createPlatformResourceURI("/" + project.getName() + "/" + name + "/", true);
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		return prime * result + ((name == null) ? 0 : name.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EclipseSourceFolder other = (EclipseSourceFolder) obj;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "project " + project + " name " + name;
	}

	public IProject getProject() {
		return project;
	}
}