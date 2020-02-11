/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.workspace;

import java.util.Set;

import org.eclipse.emf.common.util.URI;

/**
 * A project is both a container for source folders as well as a physical location that outputs can be generated to.
 *
 * In Eclipse, Maven and Gradle the concept is called a "Project". In IntelliJ it is called a "Module"
 */
public interface IProjectConfig {
	String getName();

	/**
	 * The (platform dependent) physical location of the project. The path will always end in a trailing separator. It
	 * will never be null.
	 */
	URI getPath();

	/** @return a set of all source folders */
	Set<? extends ISourceFolder> getSourceFolders();

	/**
	 * Finds the source folder that physically contains this member or null if none was found.
	 */
	ISourceFolder findSourceFolderContaining(URI member);

	/**
	 * @return the workspace config
	 */
	IWorkspaceConfig getWorkspaceConfig();

	/**
	 * During the build, projects are indexed, validated and compiled. The return of this method configures whether this
	 * project is validated and compiled or not.
	 * 
	 * @return true if this project is indexed only
	 * 
	 * @since 2.21
	 */
	default boolean isIndexOnly() {
		return false;
	}
}
