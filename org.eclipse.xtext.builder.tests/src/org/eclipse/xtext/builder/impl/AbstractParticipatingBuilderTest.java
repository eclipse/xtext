/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.tests.DelegatingBuilderParticipant;
import org.junit.After;
import org.junit.Before;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Knut Wannheden
 */
public abstract class AbstractParticipatingBuilderTest extends AbstractBuilderTest implements IXtextBuilderParticipant {

	@Inject
	private IXtextBuilderParticipant participant;
	
	private volatile boolean logging = false;
	protected volatile int invocationCount = 0;
	private volatile IBuildContext context;
	
	@Before
	public void configureBuilderParticipant() throws Exception {
		((DelegatingBuilderParticipant) participant).setDelegate(this);
	}
	
	@After
	public void resetBuilderParticipant() throws Exception {
		((DelegatingBuilderParticipant) participant).setDelegate(null);
		participant = null;
		reset();
	}
	
	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		if (logging) {
			invocationCount++;
			this.context = context;
		}
	}
	
	public int getInvocationCount() {
		return invocationCount;
	}
	
	public IBuildContext getContext() {
		return context;
	}
	
	public void startLogging() {
		logging = true;
	}
	
	public void stopLogging() {
		reset();
		logging = false;
	}
	
	public boolean isLogging() {
		return logging;
	}
	
	public void reset() {
		invocationCount = 0;
		context = null;
	}

}
