/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.workspace;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

public class JdtProjectConfig extends EclipseProjectConfig {

	public JdtProjectConfig(IProject project, EclipseProjectConfigProvider projectConfigProvider) {
		super(project, projectConfigProvider);
	}

	@Override
	public Set<? extends ISourceFolder> getSourceFolders() {
		IJavaProject javaProject = JavaCore.create(getProject());
		if (!javaProject.exists()) {
			return Collections.emptySet();
		}

		try {
			return Arrays.stream(javaProject.getRawClasspath())//
					.filter(entry -> entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) //
					.map(entry -> entry.getPath().removeFirstSegments(1).toString()) //
					.map(entryName -> new EclipseSourceFolder(getProject(), entryName)) //	
					.collect(Collectors.toSet());
		} catch (JavaModelException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (!super.equals(obj))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).addAllFields().toString();
	}
}
