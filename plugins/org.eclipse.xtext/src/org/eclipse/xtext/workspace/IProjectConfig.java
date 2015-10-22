/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

	Set<? extends ISourceFolder> getSourceFolders();

	/**
	 * Finds the source folder that physically contains this member or null if none was found.
	 */
	ISourceFolder findSourceFolderContaining(URI member);
	
	/**
	 * @return the workspace config
	 */
	IWorkspaceConfig getWorkspaceConfig();
}
