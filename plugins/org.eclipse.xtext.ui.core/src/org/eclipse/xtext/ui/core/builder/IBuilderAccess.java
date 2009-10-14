/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IBuilderAccess {

	/**
	 * {@link IncrementalProjectBuilder#getDelta(IProject)}
	 */
	IResourceDelta getDelta(IProject project);

	/**
	 * {@link IncrementalProjectBuilder#getProject()}
	 */
	IProject getProject();

	/**
	 * {@link IncrementalProjectBuilder#hasBeenBuilt(IProject)}
	 */
	boolean hasBeenBuilt(IProject project);

	/**
	 * {@link IncrementalProjectBuilder#isInterrupted()}
	 */
	boolean isInterrupted();

	/**
	 * {@link IncrementalProjectBuilder#needRebuild()}
	 */
	void needRebuild();
}
