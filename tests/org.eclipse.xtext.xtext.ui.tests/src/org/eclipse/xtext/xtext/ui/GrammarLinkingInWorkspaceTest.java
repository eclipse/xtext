/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui;

import static org.junit.Assert.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.resource.XtextResourceFactory;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class GrammarLinkingInWorkspaceTest {
	
	@Test 
	public void testReferencedGrammarIsPlatformResourceURI() throws Exception {
		IJavaProject project = JavaProjectSetupUtil.createJavaProject("p1");
		IFile grammar1 = project.getProject().getFile("src/Grammar1.xtext");
		grammar1.create(new StringInputStream("grammar Grammar1 MyRule : 'foo';"), true, null);
		
		Injector injector = Activator.getDefault().getInjector(org.eclipse.xtext.xtext.ui.internal.Activator.ORG_ECLIPSE_XTEXT_XTEXT);
		XtextResourceSetProvider resourceSetProvider = injector.getInstance(XtextResourceSetProvider.class);
		ResourceSet resourceSet = resourceSetProvider.get(project.getProject());
		XtextResourceFactory resourceFactory = injector.getInstance(XtextResourceFactory.class);
		Resource resource = resourceFactory.createResource(URI.createURI("synthetic://MyGrammar.xtext"));
		resourceSet.getResources().add(resource);
		resource.load(new StringInputStream("grammar g2 with Grammar1 OtherRule : MyRule ;"), null);
		EcoreUtil.resolveAll(resource);
		assertEquals(2, resourceSet.getResources().size());
		assertTrue(resourceSet.getResources().get(1).getURI().isPlatformResource());
	}
}
