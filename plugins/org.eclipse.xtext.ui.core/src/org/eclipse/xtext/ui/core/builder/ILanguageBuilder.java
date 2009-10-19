/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * The Xtext builder is composed of {@link ILanguageBuilder}.
 * The main purpose of this delegation is to introduce a post build hook.
 * 
 * Xtext resources depending on the index for cross-referencing need a proper state of the index when resolviong cross links.
 * Typically such language implment the {@link #build(IBuilderAccess, int, IProgressMonitor)} hook in order to clean and update the index
 * and implment {@link #postBuild(IBuilderAccess, int, IProgressMonitor)} to do the validation and add information about References to the index.
 * 
 * Languages which don't rely on the index can implment everything in {@link #build(IBuilderAccess, int, IProgressMonitor)}
 */
public interface ILanguageBuilder {
	
	/**
	 * @param builder - provides access to the helper functions of the {@link org.eclipse.core.resources.IncrementalProjectBuilder}
	 */
	void initialize(IBuilderAccess builderAccess);

	/**
	 * called on {@link org.eclipse.core.resources.IncrementalProjectBuilder#build(Integer, java.util.Map, IProgressMonitor)}
	 * 
	 * @return the list of projects for which this builder would like deltas the
	 * next time it is run or <code>null</code> if none
	 * 
	 * @param kind - the kind of build (see constants in {@link org.eclipse.core.resources.IncrementalProjectBuilder})
	 * @param monitor - a monitor used to provide information on the process
	 */
	IProject[] build(int kind, IProgressMonitor monitor) throws CoreException;

	/**
	 * called on {@link org.eclipse.core.resources.IncrementalProjectBuilder#build(Integer, java.util.Map, IProgressMonitor)}
	 * after {@link #build(IBuilderAccess, int, IProgressMonitor)} has been called for all registered {@link ILanguageBuilder}s
	 * 
	 * @param kind - the kind of build (see constants in {@link org.eclipse.core.resources.IncrementalProjectBuilder})
	 * @param monitor - a monitor used to provide information on the process
	 */
	void postBuild(int kind,  IProgressMonitor monitor) throws CoreException;
	
	/**
	 * {@link org.eclipse.core.resources.IncrementalProjectBuilder#clean()}
	 */
	void clean(IProgressMonitor monitor) throws CoreException;
}
