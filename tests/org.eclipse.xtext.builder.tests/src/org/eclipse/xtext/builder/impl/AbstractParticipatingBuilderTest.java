/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.tests.Activator;
import org.eclipse.xtext.builder.tests.DelegatingBuilderParticipant;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Knut Wannheden
 */
public abstract class AbstractParticipatingBuilderTest extends AbstractBuilderTest implements IXtextBuilderParticipant {

	private DelegatingBuilderParticipant participant;
	
	private boolean logging = false;
	protected int invocationCount = 0;
	private IBuildContext context;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		IXtextBuilderParticipant instance = Activator.getInstance()
				.getInjector("org.eclipse.xtext.builder.tests.BuilderTestLanguage")
				.getInstance(IXtextBuilderParticipant.class);
		participant = (DelegatingBuilderParticipant) instance;
		participant.setDelegate(this);
	}
	
	@Override
	public void tearDown() throws Exception {
		participant.setDelegate(null);
		participant = null;
		reset();
		super.tearDown();
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
