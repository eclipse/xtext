/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.collect.ImmutableList;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IXtextBuilderParticipant {

	/**
	 * Allows clients to perform additional steps in the build process such as code generation.
	 * It is not expected that any object in the resource set will be modified by a builder participant.
	 */
	void build(ResourceSet resourceSet, ImmutableList<IResourceDescription.Delta> deltas, IProgressMonitor monitor) throws CoreException;
	
}
