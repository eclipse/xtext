/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.findrefs;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.common.types.TypesPackage.Literals.*;
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;

import java.util.Queue;

import junit.framework.Test;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.ui.editor.findrefs.FindReferencesHandler;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.ResourceSetLocalContextProvider;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtend2.linking.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.ui.findrefs.Xtend2FindReferencesHandler;
import org.eclipse.xtext.xtend2.ui.findrefs.Xtend2FindReferencesHandler.QueryData;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FindReferencesTest extends AbstractXtend2UITestCase {

	public static Test suite() {
		return WorkbenchTestHelper.suite(FindReferencesTest.class);
	}

	@Inject
	private WorkbenchTestHelper testHelper;

	@Inject
	private FindReferencesHandler findReferencesHandler;

	@Inject
	private IReferenceFinder referenceFinder;

	@Inject
	private IXtend2JvmAssociations associations;

	@Inject
	private XtextResourceSet resourceSet;

	@Override
	protected void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}

	public void testBinding() {
		assertTrue(findReferencesHandler instanceof Xtend2FindReferencesHandler);
	}

	public void testClassQueryData() throws Exception {
		XtendFile fileFoo = loadFile("Foo", "class Foo { }");
		XtendClass classFoo = fileFoo.getXtendClass();
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);
		JvmConstructor inferredConstructor = associations.getInferredConstructor(classFoo);

		QueryData queryData = ((Xtend2FindReferencesHandler) findReferencesHandler).createQueryData(classFoo);
		assertEquals(2, queryData.getTargetElementURIs().size());
		assertEquals(queryData.getTargetElementURIs().get(0), EcoreUtil.getURI(inferredTypeFoo));
		assertEquals(queryData.getTargetElementURIs().get(1), EcoreUtil.getURI(inferredConstructor));
		assertEquals(queryData.getExcludedSourceURI(), EcoreUtil.getURI(classFoo));
	}

	public void testFunctionQueryData() throws Exception {
		XtendFile fileFoo = loadFile("Foo", "class Foo { foo() }");
		XtendFunction functionFoo = (XtendFunction) fileFoo.getXtendClass().getMembers().get(0);
		JvmOperation inferredOperation = associations.getDirectlyInferredOperation(functionFoo);

		QueryData queryData = ((Xtend2FindReferencesHandler) findReferencesHandler).createQueryData(functionFoo);
		assertEquals(1, queryData.getTargetElementURIs().size());
		assertEquals(queryData.getTargetElementURIs().get(0), EcoreUtil.getURI(inferredOperation));
		assertEquals(queryData.getExcludedSourceURI(), EcoreUtil.getURI(functionFoo));
	}

	public void testFindReferencesToClass() throws Exception {
		XtendClass classFoo = loadFile("Foo", "class Foo { Foo foo(Foo f) this }").getXtendClass();
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);
		JvmConstructor inferredConstructor = associations.getInferredConstructor(classFoo);
		XtendFunction functionFoo = (XtendFunction) classFoo.getMembers().get(0);
		XtendClass classBar = loadFile("Bar", "class Bar extends Foo { Foo newFoo(Foo foo) new Foo() }").getXtendClass();
		XtendFunction functionNewFoo = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(functionFoo.getReturnType(), inferredTypeFoo, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		mockAcceptor.expect(functionFoo.getParameters().get(0).getParameterType(), inferredTypeFoo,
				JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		mockAcceptor.expect(classBar.getSuperTypes().get(0), inferredTypeFoo, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		mockAcceptor.expect(functionNewFoo.getExpression(), inferredConstructor, XCONSTRUCTOR_CALL__CONSTRUCTOR);
		mockAcceptor.expect(functionNewFoo.getReturnType(), inferredTypeFoo, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		mockAcceptor.expect(functionNewFoo.getParameters().get(0).getParameterType(), inferredTypeFoo,
				JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		checkFindReferences(classFoo, mockAcceptor);
	}

	public void testFindReferencesToFunction() throws Exception {
		XtendClass classFoo = loadFile("Foo", "class Foo { foo() this bar() foo() }").getXtendClass();
		XtendFunction functionFoo = (XtendFunction) classFoo.getMembers().get(0);
		XtendFunction functionBar = (XtendFunction) classFoo.getMembers().get(1);
		JvmOperation inferredOperation = associations.getDirectlyInferredOperation(functionFoo);
		XtendClass classBar = loadFile("Bar", "class Bar { baz(Foo this) foo() }").getXtendClass();
		XtendFunction functionBaz = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(functionBar.getExpression(), inferredOperation, XABSTRACT_FEATURE_CALL__FEATURE);
		mockAcceptor.expect(functionBaz.getExpression(), inferredOperation, XABSTRACT_FEATURE_CALL__FEATURE);
		checkFindReferences(functionFoo, mockAcceptor);
	}

	protected void checkFindReferences(EObject target, final MockAcceptor mockAcceptor) {
		ResourceSetLocalContextProvider localContextProvider = new ResourceSetLocalContextProvider(resourceSet);
		QueryData queryData = ((Xtend2FindReferencesHandler) findReferencesHandler).createQueryData(target);
		referenceFinder.findAllReferences(queryData.getTargetElementURIs(), localContextProvider, mockAcceptor,
				((Xtend2FindReferencesHandler) findReferencesHandler).createFilter(queryData), null);
		mockAcceptor.assertFinished();
	}

	protected XtendFile loadFile(String fileName, String content) throws Exception {
		IFile file = testHelper.createFile(fileName, content);
		IResourcesSetupUtil.waitForAutoBuild();
		Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(file.getFullPath().toString(),
				true));
		resource.load(new StringInputStream(content), null);
		EObject rootElement = resource.getContents().get(0);
		assertTrue(rootElement instanceof XtendFile);
		return (XtendFile) rootElement;
	}

	public static class MockAcceptor implements IAcceptor<IReferenceDescription> {

		private Queue<IReferenceDescription> expectationQueue = newLinkedList();

		public void expect(EObject from, EObject to, EReference eReference) {
			expectationQueue.add(new DefaultReferenceDescription(from, to, eReference, 0, null));
		}

		public void assertFinished() {
			IReferenceDescription nextExpected = expectationQueue.poll();
			if(nextExpected != null)
				fail("Expected " + toString(nextExpected));
		}

		private String toString(IReferenceDescription rd) {
			return rd.getSourceEObjectUri() + " ---" + rd.getEReference().getName() + "---> "
					+ rd.getTargetEObjectUri();
		}

		public void accept(IReferenceDescription description) {
			IReferenceDescription nextExpected = expectationQueue.poll();
			assertNotNull(nextExpected);
			assertEquals(nextExpected.getSourceEObjectUri(), description.getSourceEObjectUri());
			assertEquals(nextExpected.getTargetEObjectUri(), description.getTargetEObjectUri());
			assertEquals(nextExpected.getEReference(), description.getEReference());
		}

	}

}
