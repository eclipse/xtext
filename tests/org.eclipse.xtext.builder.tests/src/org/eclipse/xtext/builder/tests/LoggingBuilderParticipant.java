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
import org.eclipse.xtext.builder.IXtextBuilderParticipant;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class LoggingBuilderParticipant implements IXtextBuilderParticipant {

	private int invocationCount = 0;
	private IBuildContext context;
	private boolean logging = false;

	public void build(IXtextBuilderParticipant.IBuildContext context, IProgressMonitor monitor)
			throws CoreException {
		if (logging) {
			invocationCount++;	
			this.context = context;
		}
	}
	
	public void reset() {
		invocationCount = 0;
		context = null;
	}
	
	public void startLogging() {
		logging = true;
	}
	
	public void stopLogging() {
		reset();
		logging = false;
	}
	
	public int getInvocationCount() {
		return invocationCount;
	}

	public void build(BuildContext context, IProgressMonitor monitor) throws CoreException {
		this.context = context;
	}

	public IBuildContext getContext() {
		return context;
	}

}
