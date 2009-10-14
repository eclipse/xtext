/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.internal;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextBuilder extends IncrementalProjectBuilder {
	public static Logger log = Logger.getLogger(XtextBuilder.class);

	public static final String BUILDER_ID = "org.eclipse.xtext.ui.core.xtextBuilder";

	@Inject
	private CompositeLanguageBuilder compositeLanguageBuilder;

	@SuppressWarnings("unchecked")
	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		try {
			IProject[] projects = compositeLanguageBuilder.build(getBuilderAccess(), kind, monitor);
			compositeLanguageBuilder.postBuild(getBuilderAccess(), kind, monitor);
			return projects;
		}
		catch (RuntimeException e) {
			log.error(e.getMessage(), e);
			throw e;
		}
		catch (CoreException e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	
	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		super.clean(monitor);
		compositeLanguageBuilder.clean(getBuilderAccess(), monitor);
	}


	private BuilderAccess getBuilderAccess() {
		return new BuilderAccess(this);
	}

}
