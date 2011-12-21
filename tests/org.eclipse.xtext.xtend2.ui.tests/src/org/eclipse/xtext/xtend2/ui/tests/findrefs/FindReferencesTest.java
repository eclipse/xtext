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

import java.util.Queue;

import junit.framework.Test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.SimpleLocalResourceAccess;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelReferenceQueryExecutor;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class FindReferencesTest extends AbstractXtend2UITestCase {

	public static Test suite() {
		return WorkbenchTestHelper.suite(FindReferencesTest.class);
	}

	@Inject
	private WorkbenchTestHelper testHelper;

	@Inject
	private IXtend2JvmAssociations associations;

	@Inject
	private Provider<CheckingReferenceQueryExecutor> executorProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}

	public void testFindReferencesToClass() throws Exception {
		XtendClass classFoo = testHelper.xtendFile("Foo", "class Foo {}").getXtendClass();
		XtendClass classBar = testHelper.xtendFile("Bar", "class Bar extends Foo {}").getXtendClass();
		waitForAutoBuild();
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(classBar.getSuperTypes().get(0), inferredTypeFoo, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		checkFindReferences(classFoo, "JVM References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	public void testFindReferencesThis() throws Exception {
		XtendClass classFoo = testHelper.xtendFile("Foo", "class Foo { def foo() {this} }").getXtendClass();
		waitForAutoBuild();
		JvmGenericType inferredType = associations.getInferredType(classFoo);
		XtendFunction functionFoo = (XtendFunction) classFoo.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(((XBlockExpression) functionFoo.getExpression()).getExpressions().get(0), inferredType,
				XABSTRACT_FEATURE_CALL__FEATURE);
		checkFindReferences(inferredType, "JVM References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	public void testFindReferencesToConstructor() throws Exception {
		XtendClass classFoo = testHelper.xtendFile("Foo", "class Foo {}").getXtendClass();
		XtendClass classBar = testHelper.xtendFile("Bar", "class Bar { def bar() {new Foo()} }").getXtendClass();
		waitForAutoBuild();
		JvmConstructor inferredConstructor = associations.getInferredConstructor(classFoo);
		XtendFunction functionBar = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(((XBlockExpression) functionBar.getExpression()).getExpressions().get(0),
				inferredConstructor, XCONSTRUCTOR_CALL__CONSTRUCTOR);
		checkFindReferences(classFoo, "JVM References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	public void testFindReferencesFromReturnType() throws Exception {
		XtendClass classFoo = testHelper.xtendFile("Foo", "class Foo {}").getXtendClass();
		XtendClass classBar = testHelper.xtendFile("Bar", "class Bar { def Foo bar() {null} }").getXtendClass();
		waitForAutoBuild();
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);
		XtendFunction functionBar = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(functionBar.getReturnType(), inferredTypeFoo, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		checkFindReferences(classFoo, "JVM References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	public void testFindReferencesFromParameter() throws Exception {
		XtendClass classFoo = testHelper.xtendFile("Foo", "class Foo {}").getXtendClass();
		XtendClass classBar = testHelper.xtendFile("Bar", "class Bar { def bar(Foo x) {null} }").getXtendClass();
		waitForAutoBuild();
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);
		XtendFunction functionBar = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(functionBar.getParameters().get(0).getParameterType(), inferredTypeFoo,
				JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		checkFindReferences(classFoo, "JVM References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	public void testFindReferencesToFunction() throws Exception {
		XtendClass classFoo = testHelper.xtendFile("Foo", "class Foo { def foo() {this} def bar() {foo()} }")
				.getXtendClass();
		XtendClass classBar = testHelper.xtendFile("Bar", "class Bar { def baz(Foo this) {foo()} }").getXtendClass();
		waitForAutoBuild();
		XtendFunction functionFoo = (XtendFunction) classFoo.getMembers().get(0);
		XtendFunction functionBar = (XtendFunction) classFoo.getMembers().get(1);
		JvmOperation inferredOperation = associations.getDirectlyInferredOperation(functionFoo);
		XtendFunction functionBaz = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(((XBlockExpression) functionBar.getExpression()).getExpressions().get(0),
				inferredOperation, XABSTRACT_FEATURE_CALL__FEATURE);
		mockAcceptor.expect(((XBlockExpression) functionBaz.getExpression()).getExpressions().get(0),
				inferredOperation, XABSTRACT_FEATURE_CALL__FEATURE);
		checkFindReferences(functionFoo, "JVM References to Foo.foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	protected void checkFindReferences(EObject target, String expectedLabel, final MockAcceptor mockAcceptor) {
		CheckingReferenceQueryExecutor executor = executorProvider.get();
		executor.init(target, expectedLabel, mockAcceptor);
		executor.execute();
		mockAcceptor.assertFinished();
	}

	public static class CheckingReferenceQueryExecutor extends JvmModelReferenceQueryExecutor {

		@Inject
		private IReferenceFinder referenceFinder;
		private Iterable<URI> targetURIs;
		private Predicate<IReferenceDescription> filter;
		private SimpleLocalResourceAccess localResourceAccess;
		private IAcceptor<IReferenceDescription> filteringAcceptor;

		@Override
		public void init(EObject target) {
		}

		public void init(EObject target, String expectedLabel, final IAcceptor<IReferenceDescription> acceptor) {
			targetURIs = getTargetURIs(target);
			filter = getFilter(target);
			assertEquals(expectedLabel, getLabel(target));
			this.filteringAcceptor = new IAcceptor<IReferenceDescription>() {
				public void accept(IReferenceDescription t) {
					if (filter.apply(t))
						acceptor.accept(t);
				}
			};
			localResourceAccess = new SimpleLocalResourceAccess(target.eResource().getResourceSet());
		}

		@Override
		public void execute() {
			referenceFinder.findAllReferences(targetURIs, localResourceAccess, filteringAcceptor, null);
		}
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
