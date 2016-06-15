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
public class DelegatingBuilderParticipant implements IXtextBuilderParticipant {

	private IXtextBuilderParticipant delegate;

	@Override
	public void build(IXtextBuilderParticipant.IBuildContext context, IProgressMonitor monitor) throws CoreException {
		if (delegate != null)
			delegate.build(context, monitor);
	}

	public void setDelegate(IXtextBuilderParticipant delegate) {
		this.delegate = delegate;
	}

	public IXtextBuilderParticipant getDelegate() {
		return delegate;
	}

}
