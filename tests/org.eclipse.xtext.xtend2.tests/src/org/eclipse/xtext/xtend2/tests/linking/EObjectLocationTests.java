/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EObjectLocationTests extends AbstractXtend2TestCase {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Inject 
	private IXtend2JvmAssociations xtend2jvmAssociations;
	
	public void testResolveElement() throws Exception {
		String model = "class Foo extends Object { Foo foo() { hashCode(); this }}";
		XtendFile file = file(model);
		XtextResource resource = (XtextResource) file.eResource();
		EObject fooDeclaration = eObjectAtOffsetHelper.resolveElementAt(resource, model.indexOf("Foo"));
		assertTrue(fooDeclaration instanceof XtendClass);
		assertEquals(file.getXtendClass(), fooDeclaration);
		EObject fooReference = eObjectAtOffsetHelper.resolveElementAt(resource, model.lastIndexOf("Foo"));
		assertTrue(fooReference instanceof XtendClass);
		assertEquals(file.getXtendClass(), fooReference);
		EObject hashCodeReference = eObjectAtOffsetHelper.resolveElementAt(resource, model.indexOf("hashCode"));
		assertTrue(hashCodeReference instanceof JvmOperation);
	}
	
	public void testResolveCrossReference() throws Exception {
		String model = "class Foo extends Object { Foo foo() { hashCode(); this }}";
		XtendFile file = file(model);
		XtextResource resource = (XtextResource) file.eResource();
		EObject fooReference = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, model.lastIndexOf("Foo"));
		assertTrue(fooReference instanceof XtendClass);
		assertEquals(file.getXtendClass(), fooReference);
		EObject hashCodeReference = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, model.indexOf("hashCode"));
		assertTrue(hashCodeReference instanceof JvmOperation);
	}
	
	public void testFullLocationInFile() throws Exception {
		String model = "class Foo extends Object { Foo foo() {this }}";
		XtendClass clazz = clazz(model);
		JvmGenericType inferredType = xtend2jvmAssociations.getInferredType(clazz);
		assertEquals(locationInFileProvider.getFullTextRegion(clazz), locationInFileProvider.getFullTextRegion(inferredType));
		JvmConstructor inferredConstructor = xtend2jvmAssociations.getInferredConstructor(clazz);
		assertEquals(locationInFileProvider.getFullTextRegion(clazz), locationInFileProvider.getFullTextRegion(inferredConstructor));
		XtendFunction xtendFunction = (XtendFunction) clazz.getMembers().get(0);
		JvmOperation inferredOperation = xtend2jvmAssociations.getDirectlyInferredOperation(xtendFunction);
		assertEquals(locationInFileProvider.getFullTextRegion(xtendFunction), locationInFileProvider.getFullTextRegion(inferredOperation));
	}

	public void testSignificantLocationInFile() throws Exception {
		String model = "class Foo extends Object { Foo foo() {this} }";
		XtendClass clazz = clazz(model);
		JvmGenericType inferredType = xtend2jvmAssociations.getInferredType(clazz);
		assertEquals(locationInFileProvider.getSignificantTextRegion(clazz), locationInFileProvider.getSignificantTextRegion(inferredType));
		JvmConstructor inferredConstructor = xtend2jvmAssociations.getInferredConstructor(clazz);
		assertEquals(locationInFileProvider.getSignificantTextRegion(clazz), locationInFileProvider.getSignificantTextRegion(inferredConstructor));
		XtendFunction xtendFunction = (XtendFunction) clazz.getMembers().get(0);
		JvmOperation inferredOperation = xtend2jvmAssociations.getDirectlyInferredOperation(xtendFunction);
		assertEquals(locationInFileProvider.getSignificantTextRegion(xtendFunction), locationInFileProvider.getSignificantTextRegion(inferredOperation));
	}
}
