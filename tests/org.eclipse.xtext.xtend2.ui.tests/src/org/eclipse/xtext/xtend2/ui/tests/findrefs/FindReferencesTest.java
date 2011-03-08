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
import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;

import java.util.Iterator;
import java.util.Queue;

import junit.framework.Test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.ui.editor.findrefs.FindReferenceQueryDataFactory;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder.IQueryData;
import org.eclipse.xtext.ui.editor.findrefs.SimpleLocalResourceAccess;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelReferenceFilter;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
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
	private FindReferenceQueryDataFactory queryDataFactory;

	@Inject
	private IReferenceFinder referenceFinder;

	@Inject
	private IXtend2JvmAssociations associations;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	private ResourceSet resourceSet;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet = resourceSetProvider.get(testHelper.getProject());
	}

	@Override
	protected void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}

	public void testClassQueryData() throws Exception {
		XtendFile fileFoo = testHelper.xtendFile("Foo", "class Foo { }");
		waitForAutoBuild();
		XtendClass classFoo = fileFoo.getXtendClass();
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);
		JvmConstructor inferredConstructor = associations.getInferredConstructor(classFoo);

		IQueryData queryData = createQueryData(classFoo);
		assertEquals(3, queryData.getTargetURIs().size());
		Iterator<URI> targetURIs = queryData.getTargetURIs().iterator();
		assertEquals(targetURIs.next(), EcoreUtil.getURI(classFoo));
		assertEquals(targetURIs.next(), EcoreUtil.getURI(inferredTypeFoo));
		assertEquals(targetURIs.next(), EcoreUtil.getURI(inferredConstructor));
		assertTrue(queryData.getResultFilter() instanceof JvmModelReferenceFilter);
		assertEquals(((JvmModelReferenceFilter) queryData.getResultFilter()).getExcludedSourceURI(),
				EcoreUtil.getURI(classFoo));
	}

	public void testFunctionQueryData() throws Exception {
		XtendFile fileFoo = testHelper.xtendFile("Foo", "class Foo { foo() {null} }");
		waitForAutoBuild();
		XtendFunction functionFoo = (XtendFunction) fileFoo.getXtendClass().getMembers().get(0);
		JvmOperation inferredOperation = associations.getDirectlyInferredOperation(functionFoo);

		IQueryData queryData = createQueryData(functionFoo);
		assertEquals(2, queryData.getTargetURIs().size());
		Iterator<URI> targetURIs = queryData.getTargetURIs().iterator();
		assertEquals(targetURIs.next(), EcoreUtil.getURI(functionFoo));
		assertEquals(targetURIs.next(), EcoreUtil.getURI(inferredOperation));
		assertTrue(queryData.getResultFilter() instanceof JvmModelReferenceFilter);
		assertEquals(((JvmModelReferenceFilter) queryData.getResultFilter()).getExcludedSourceURI(),
				EcoreUtil.getURI(functionFoo));
	}

	public void testFindReferencesToClass() throws Exception {
		XtendClass classFoo = testHelper.xtendFile("Foo", "class Foo {}").getXtendClass();
		XtendClass classBar = testHelper.xtendFile("Bar", "class Bar extends Foo {}").getXtendClass();
		waitForAutoBuild();
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(classBar.getSuperTypes().get(0), inferredTypeFoo, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		checkFindReferences(classFoo, mockAcceptor);
	}

	public void testFindReferencesThis() throws Exception {
		XtendClass classFoo = testHelper.xtendFile("Foo", "class Foo { foo() {this} }").getXtendClass();
		waitForAutoBuild();
		XtendFunction functionFoo = (XtendFunction) classFoo.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(((XBlockExpression)functionFoo.getExpression()).getExpressions().get(0), classFoo, XABSTRACT_FEATURE_CALL__FEATURE);
		checkFindReferences(classFoo, mockAcceptor);
	}

	public void testFindReferencesToConstructor() throws Exception {
		XtendClass classFoo = testHelper.xtendFile("Foo", "class Foo {}").getXtendClass();
		XtendClass classBar = testHelper.xtendFile("Bar", "class Bar { bar() {new Foo()} }").getXtendClass();
		waitForAutoBuild();
		JvmConstructor inferredConstructor = associations.getInferredConstructor(classFoo);
		XtendFunction functionBar = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(((XBlockExpression)functionBar.getExpression()).getExpressions().get(0), inferredConstructor, XCONSTRUCTOR_CALL__CONSTRUCTOR);
		checkFindReferences(classFoo, mockAcceptor);
	}

	public void testFindReferencesFromReturnType() throws Exception {
		XtendClass classFoo = testHelper.xtendFile("Foo", "class Foo {}").getXtendClass();
		XtendClass classBar = testHelper.xtendFile("Bar", "class Bar { Foo bar() {null} }").getXtendClass();
		waitForAutoBuild();
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);
		XtendFunction functionBar = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(functionBar.getReturnType(), inferredTypeFoo, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		checkFindReferences(classFoo, mockAcceptor);
	}

	public void testFindReferencesFromParameter() throws Exception {
		XtendClass classFoo = testHelper.xtendFile("Foo", "class Foo {}").getXtendClass();
		XtendClass classBar = testHelper.xtendFile("Bar", "class Bar { bar(Foo x) {null} }").getXtendClass();
		waitForAutoBuild();
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);
		XtendFunction functionBar = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(functionBar.getParameters().get(0).getParameterType(), inferredTypeFoo,
				JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		checkFindReferences(classFoo, mockAcceptor);
	}

	public void testFindReferencesToFunction() throws Exception {
		XtendClass classFoo = testHelper.xtendFile("Foo", "class Foo { foo() {this} bar() {foo()} }").getXtendClass();
		XtendClass classBar = testHelper.xtendFile("Bar", "class Bar { baz(Foo this) {foo()} }").getXtendClass();
		waitForAutoBuild();
		XtendFunction functionFoo = (XtendFunction) classFoo.getMembers().get(0);
		XtendFunction functionBar = (XtendFunction) classFoo.getMembers().get(1);
		JvmOperation inferredOperation = associations.getDirectlyInferredOperation(functionFoo);
		XtendFunction functionBaz = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(((XBlockExpression)functionBar.getExpression()).getExpressions().get(0), inferredOperation, XABSTRACT_FEATURE_CALL__FEATURE);
		mockAcceptor.expect(((XBlockExpression)functionBaz.getExpression()).getExpressions().get(0), inferredOperation, XABSTRACT_FEATURE_CALL__FEATURE);
		checkFindReferences(functionFoo, mockAcceptor);
	}

	protected void checkFindReferences(EObject target, final MockAcceptor mockAcceptor) {
		SimpleLocalResourceAccess localResourceAccess = new SimpleLocalResourceAccess(resourceSet);
		IQueryData queryData = createQueryData(target);
		referenceFinder.findAllReferences(queryData, localResourceAccess, mockAcceptor, null);
		mockAcceptor.assertFinished();
	}

	protected IQueryData createQueryData(EObject target) {
		return queryDataFactory.createQueryData(target, target.eResource().getURI());
	}

	public static class MockAcceptor implements IAcceptor<IReferenceDescription> {

		private Queue<IReferenceDescription> expectationQueue = newLinkedList();

		public void expect(EObject from, EObject to, EReference eReference) {
			expectationQueue.add(new DefaultReferenceDescription(from, to, eReference, 0, null));
		}

		public void assertFinished() {
			IReferenceDescription nextExpected = expectationQueue.poll();
			if (nextExpected != null)
				fail("Expected " + toString(nextExpected));
		}

		private String toString(IReferenceDescription rd) {
			return rd.getSourceEObjectUri() + " ---" + rd.getEReference().getName() + "---> "
					+ rd.getTargetEObjectUri();
		}

		private String toString(IReferenceDescription expected, IReferenceDescription actual) {
			return "Expected: \n" + toString(expected) + "\n but got:\n" + toString(actual) + "\n queueSize="
					+ expectationQueue.size() + "\n";
		}

		public void accept(IReferenceDescription description) {
			IReferenceDescription nextExpected = expectationQueue.poll();
			assertNotNull(nextExpected);
			assertEquals(toString(nextExpected, description), nextExpected.getSourceEObjectUri(),
					description.getSourceEObjectUri());
			assertEquals(toString(nextExpected, description), nextExpected.getTargetEObjectUri(),
					description.getTargetEObjectUri());
			assertEquals(toString(nextExpected, description), nextExpected.getEReference(), description.getEReference());
		}

	}

}
