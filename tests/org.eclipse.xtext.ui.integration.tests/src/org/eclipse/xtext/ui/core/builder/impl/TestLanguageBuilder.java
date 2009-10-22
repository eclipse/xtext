/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.impl;

import static junit.framework.Assert.*;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ui.core.builder.IBuilderAccess;
import org.eclipse.xtext.ui.integration.foo.Stuff;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TestLanguageBuilder extends JavaProjectLanguageBuilder {
	
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public void initialize(IBuilderAccess builderAccess) {
		super.initialize(builderAccess);
	}
	
	@Override
	public IProject[] build(ISharedState sharedState, int kind, IProgressMonitor monitor) throws CoreException {
		IProject[] build = super.build(sharedState, kind, monitor);
		return build;
	}
	
	@Override
	protected void internalPostBuild(ISharedState sharedState, IProgressMonitor monitor) {
		super.internalPostBuild(sharedState, monitor);
		for (Map.Entry<IStorage,Resource>  entry: state.getUpdated().entrySet()) {
			if (entry.getKey() instanceof IFile) {
				try {
					IFile iFile = (IFile)entry.getKey();
					if (!iFile.exists())
						System.out.println("Ups");
					if (iFile.exists() && iFile.findMarkers(EValidator.MARKER, true, 1).length==0) {
						TreeIterator<EObject> iterator = entry.getValue().getAllContents();
						while (iterator.hasNext()) {
							EObject type = iterator.next();
							if (type instanceof Stuff) {
								Stuff refs = ((Stuff) type).getRefs();
								if (refs!=null)
									assertFalse(((InternalEObject)refs).eIsProxy());
							}
						}
					}
				} catch (CoreException e) {
					throw new WrappedException(e);
				}
			}
		}
	}
	
}
