/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.navigation;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;

import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.junit.ui.FindReferencesTestUtil;
import org.eclipse.xtext.xbase.junit.ui.FindReferencesTestUtil.MockAcceptor;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FindReferencesTest extends AbstractXbaseUITestCase {

	@Inject
	private FindReferencesTestUtil findReferencesTester;
	private IProject project;
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		project = createPluginProject("find.references.test");
		createFile("find.references.test/src/com/acme/OtherwiseUnused.java", "package com.acme; class OtherwiseUnused { public static void m() {} }");
		waitForBuild();
	}
	
	@Override
	@After
	public void tearDown() throws Exception {
		project.delete(true, null);
		super.tearDown();
	}
	
	@Override
	public XtextResource getResourceFor(InputStream stream) {
		try {
			XtextResourceSet set = get(XtextResourceSet.class);
			set.setClasspathURIContext(JavaCore.create(project));
			XtextResource result = (XtextResource) set.createResource(URI.createURI("Test." + fileExtension));
			result.load(stream, null);
			return result;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test public void testFindReferencesTypeLiteral() throws Exception {
		createFile("find.references.test/src/Test." + fileExtension, "com.acme.OtherwiseUnused::m()");
		waitForBuild();
		
		XtextResourceSet set = get(XtextResourceSet.class);
		set.setClasspathURIContext(JavaCore.create(project));
		Resource resource = set.getResource(URI.createPlatformResourceURI("find.references.test/src/Test." + fileExtension, true), true);

		// obtain reference to type
		XMemberFeatureCall expression = (XMemberFeatureCall) resource.getContents().get(0);
		JvmType lookup = (JvmType) ((XAbstractFeatureCall) expression.getMemberCallTarget()).getFeature();

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(expression.getMemberCallTarget(), lookup, XABSTRACT_FEATURE_CALL__FEATURE);
		findReferencesTester.checkFindReferences(lookup, "Java References to com.acme.OtherwiseUnused", mockAcceptor);
	}
	
	@Test public void testFindReferencesTypeLiteralTwice() throws Exception {
		createFile("find.references.test/src/Test." + fileExtension, "com.acme.OtherwiseUnused != com.acme.OtherwiseUnused");
		waitForBuild();
		
		XtextResourceSet set = get(XtextResourceSet.class);
		set.setClasspathURIContext(JavaCore.create(project));
		Resource resource = set.getResource(URI.createPlatformResourceURI("find.references.test/src/Test." + fileExtension, true), true);

		// obtain reference to type
		XBinaryOperation expression = (XBinaryOperation) resource.getContents().get(0);
		JvmType lookup = (JvmType) ((XAbstractFeatureCall) expression.getLeftOperand()).getFeature();

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(expression.getLeftOperand(), lookup, XABSTRACT_FEATURE_CALL__FEATURE);
		mockAcceptor.expect(expression.getRightOperand(), lookup, XABSTRACT_FEATURE_CALL__FEATURE);
		findReferencesTester.checkFindReferences(lookup, "Java References to com.acme.OtherwiseUnused", mockAcceptor);
	}
	
}
