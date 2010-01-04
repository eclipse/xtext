/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example.handler;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.core.util.JdtClasspathUriResolver;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Execution handler used to generate an ecore model file based on an existing ecore dsl file.
 *
 * @author Michael Clay - Initial contribution and API
 *
 */
public class GenerateEcoreHandler extends AbstractHandler {
	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile ecoreDslFile = getEcoreDslFileName(event);
		EPackage ePackage  = loadRootEPackage(ecoreDslFile);
		createAndSaveNewEcoreResource(ecoreDslFile, ePackage);
		try {
			ecoreDslFile.getParent().refreshLocal(1, new NullProgressMonitor()); }
		catch (CoreException e) {
			throw new ExecutionException("Error while refreshing resource hierarcy of '"+ecoreDslFile+"'",e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private IFile getEcoreDslFileName(ExecutionEvent event) {
		EvaluationContext applicationContext = (EvaluationContext) event.getApplicationContext();
		List fileList = (List) applicationContext.getDefaultVariable();
		return (IFile) fileList.get(0);
	}

	private EPackage loadRootEPackage(IFile ecoreDslFile) {
		XtextResourceSet xtextResourceSet = resourceSetProvider.get();
		xtextResourceSet.setClasspathUriResolver(new JdtClasspathUriResolver());
		xtextResourceSet.setClasspathURIContext(JavaCore.create(ecoreDslFile.getProject()));
		Resource ecoreResource = xtextResourceSet.getResource(URI.createFileURI(ecoreDslFile.getLocation().toFile()
				.getAbsolutePath()), true);
		EObject ecoreDsl = ecoreResource.getContents().get(0);
		EList<EReference> references = ecoreDsl.eClass().getEReferences();
		EPackage ePackage = (EPackage) ecoreDsl.eGet(references.get(1));
		return ePackage;
	}

	private void createAndSaveNewEcoreResource(IFile ecoreDslFile, EPackage ePackage) throws ExecutionException {
		Resource ecoreModelResource = newEcoreResource(ecoreDslFile);
		ecoreModelResource.getContents().add(ePackage);
		try {
			ecoreModelResource.save(null);
		}
		catch (IOException e) {
			throw new ExecutionException("Error while saving resource '"+ecoreModelResource+"'",e);
		}
	}

	private Resource newEcoreResource(IFile ecoreDslFile) {
		ResourceSet resourceSet = new ResourceSetImpl();
		String fileNameWithExtension = ecoreDslFile.getName();
		URI fileURI = URI.createFileURI(new java.io.File(ecoreDslFile.getParent().getLocation().toFile(),
				fileNameWithExtension.substring(0, fileNameWithExtension.indexOf(".")) + ".ecore").getAbsolutePath());
		Resource ecoreModelResource = resourceSet.createResource(fileURI, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		return ecoreModelResource;
	}

}
