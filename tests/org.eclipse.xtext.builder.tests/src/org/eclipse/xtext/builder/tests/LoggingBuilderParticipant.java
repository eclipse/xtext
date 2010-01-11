/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.tests;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.collect.ImmutableList;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class LoggingBuilderParticipant implements IXtextBuilderParticipant {

	private int invocationCount = 0;

	public void build(ResourceSet resourceSet, ImmutableList<Delta> deltas, IProgressMonitor monitor)
			throws CoreException {
		invocationCount++;	
	}
	
	public void reset() {
		invocationCount = 0;
	}
	
	public int getInvocationCount() {
		return invocationCount;
	}

}
