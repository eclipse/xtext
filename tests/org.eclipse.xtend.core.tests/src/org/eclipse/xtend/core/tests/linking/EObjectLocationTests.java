/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EObjectLocationTests extends AbstractXtendTestCase {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject 
	private IXtendJvmAssociations xtendjvmAssociations;
	
	@Test public void testResolveElement() throws Exception {
		String model = "class Foo extends Object { def Foo foo() { hashCode(); this }}";
		XtendFile file = file(model);
		XtextResource resource = (XtextResource) file.eResource();
		EObject fooDeclaration = eObjectAtOffsetHelper.resolveElementAt(resource, model.indexOf("Foo"));
		assertTrue(fooDeclaration instanceof XtendClass);
		assertEquals(file.getXtendTypes().get(0), fooDeclaration);
		EObject fooReference = eObjectAtOffsetHelper.resolveElementAt(resource, model.lastIndexOf("Foo"));
		assertTrue(fooReference instanceof JvmGenericType);
		assertEquals(file.getXtendTypes().get(0), associations.getPrimarySourceElement(fooReference));
		EObject hashCodeReference = eObjectAtOffsetHelper.resolveElementAt(resource, model.indexOf("hashCode"));
		assertTrue(hashCodeReference instanceof JvmOperation);
	}
	
	@Test public void testResolveCrossReference() throws Exception {
		String model = "class Foo extends Object { def Foo foo() { hashCode(); this }}";
		XtendFile file = file(model);
		XtextResource resource = (XtextResource) file.eResource();
		EObject fooReference = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, model.lastIndexOf("Foo"));
		assertTrue(fooReference instanceof JvmGenericType);
		assertEquals(file.getXtendTypes().get(0), associations.getPrimarySourceElement(fooReference));
		EObject hashCodeReference = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, model.indexOf("hashCode"));
		assertTrue(hashCodeReference instanceof JvmOperation);
	}
	
	@Test public void testResolveAnonymousClassConstructorCall_0() throws Exception {
		String model = "class Foo { val bar = new Bar() {} } interface Bar {}";
		XtendFile file = file(model);
		XtextResource resource = (XtextResource) file.eResource();
		EObject bar = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, model.indexOf("Bar"));
		assertTrue(bar instanceof JvmGenericType);
		assertEquals("Bar", ((JvmGenericType) bar).getSimpleName());
	}
	
	@Test public void testResolveAnonymousClassConstructorCall_1() throws Exception {
		String model = "class Foo { val bar = new Bar() {} } class Bar {}";
		XtendFile file = file(model);
		XtextResource resource = (XtextResource) file.eResource();
		EObject constructor = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, model.indexOf("Bar"));
		assertTrue(constructor instanceof JvmConstructor);
		assertEquals("Bar", ((JvmConstructor) constructor).getDeclaringType().getSimpleName());
	}
	
	@Test public void testResolveAnonymousClassConstructorCall_2() throws Exception {
		String model = "class Foo { val bar = new Bar() {} } class Bar { new(String x) {} new() {} }";
		XtendFile file = file(model);
		XtextResource resource = (XtextResource) file.eResource();
		EObject constructor = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, model.indexOf("Bar"));
		assertTrue(constructor instanceof JvmConstructor);
		assertEquals("Bar", ((JvmConstructor) constructor).getDeclaringType().getSimpleName());
		assertEquals(0, ((JvmConstructor) constructor).getParameters().size());
	}
	
	@Test public void testResolveAnonymousClassConstructorCall_3() throws Exception {
		String model = "class Foo { val bar = new Bar('') {} } class Bar { new(String x) {} new() {} }";
		XtendFile file = file(model);
		XtextResource resource = (XtextResource) file.eResource();
		EObject constructor = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, model.indexOf("Bar"));
		assertTrue(constructor instanceof JvmConstructor);
		assertEquals("Bar", ((JvmConstructor) constructor).getDeclaringType().getSimpleName());
		assertEquals(1, ((JvmConstructor) constructor).getParameters().size());
	}
	
	@Test public void testResolveAnonymousClassConstructorCall_4() throws Exception {
		String model = "class Foo { val bar = new Bar('') {} } interface Bar {}";
		XtendFile file = file(model);
		XtextResource resource = (XtextResource) file.eResource();
		EObject bar = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, model.indexOf("Bar"));
		assertTrue(bar instanceof JvmGenericType);
		assertEquals("Bar", ((JvmGenericType) bar).getSimpleName());
	}
	
	@Test public void testResolveAnonymousClassConstructorCall_5() throws Exception {
		String model = "class Foo { val bar = new Bar() {} } class Bar { new(String x) {} }";
		XtendFile file = file(model);
		XtextResource resource = (XtextResource) file.eResource();
		EObject constructor = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, model.indexOf("Bar"));
		assertTrue(constructor instanceof JvmConstructor);
		assertEquals("Bar", ((JvmConstructor) constructor).getDeclaringType().getSimpleName());
		assertEquals(1, ((JvmConstructor) constructor).getParameters().size());
	}
	
	@Test public void testFullLocationInFile() throws Exception {
		String model = "class Foo extends Object { def Foo foo() {this }}";
		XtendClass clazz = clazz(model);
		JvmGenericType inferredType = xtendjvmAssociations.getInferredType(clazz);
		assertEquals(locationInFileProvider.getFullTextRegion(clazz), locationInFileProvider.getFullTextRegion(inferredType));
		JvmConstructor inferredConstructor = xtendjvmAssociations.getInferredConstructor(clazz);
		assertEquals(locationInFileProvider.getFullTextRegion(clazz), locationInFileProvider.getFullTextRegion(inferredConstructor));
		XtendFunction xtendFunction = (XtendFunction) clazz.getMembers().get(0);
		JvmOperation inferredOperation = xtendjvmAssociations.getDirectlyInferredOperation(xtendFunction);
		assertEquals(locationInFileProvider.getFullTextRegion(xtendFunction), locationInFileProvider.getFullTextRegion(inferredOperation));
	}

	@Test public void testSignificantLocationInFile() throws Exception {
		String model = "class Foo extends Object { def Foo foo() {this} }";
		XtendClass clazz = clazz(model);
		JvmGenericType inferredType = xtendjvmAssociations.getInferredType(clazz);
		assertEquals(locationInFileProvider.getSignificantTextRegion(clazz), locationInFileProvider.getSignificantTextRegion(inferredType));
		JvmConstructor inferredConstructor = xtendjvmAssociations.getInferredConstructor(clazz);
		assertEquals(locationInFileProvider.getSignificantTextRegion(clazz), locationInFileProvider.getSignificantTextRegion(inferredConstructor));
		XtendFunction xtendFunction = (XtendFunction) clazz.getMembers().get(0);
		JvmOperation inferredOperation = xtendjvmAssociations.getDirectlyInferredOperation(xtendFunction);
		assertEquals(locationInFileProvider.getSignificantTextRegion(xtendFunction), locationInFileProvider.getSignificantTextRegion(inferredOperation));
	}
}
