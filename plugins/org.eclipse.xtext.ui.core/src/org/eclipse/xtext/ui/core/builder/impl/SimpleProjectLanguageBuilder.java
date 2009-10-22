/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.impl;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.UpdateCommand;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SimpleProjectLanguageBuilder extends AbstractLanguageBuilder {

	@Override
	public void internalClean(IProgressMonitor monitor) {
		index.executeUpdateCommand(new UpdateCommand<Void>() {
			public Void execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
				indexUpdater.deleteContainer(builder.getProject().getName());
				return null;
			}
		});
	}
	
	@Override
	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		buildRecursivly(builder.getProject());
	}
	
	@Override
	protected String getContainerName(IStorage resource) {
		return ((IResource) resource).getProject().getName();
	}
}
