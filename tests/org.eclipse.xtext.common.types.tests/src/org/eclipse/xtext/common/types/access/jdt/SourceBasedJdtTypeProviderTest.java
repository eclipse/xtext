/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.AbstractTypeProviderTest;
import org.eclipse.xtext.common.types.util.jdt.JavaElementFinder;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SourceBasedJdtTypeProviderTest extends AbstractTypeProviderTest {

	private ResourceSet resourceSet;
	private JdtTypeProvider typeProvider;
	private MockJavaProjectProvider projectProvider;
	private JavaElementFinder elementFinder;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet = new ResourceSetImpl();
		projectProvider = new MockJavaProjectProvider();
		projectProvider.setUseSource(true);
		typeProvider = new JdtTypeProvider(projectProvider.getJavaProject(resourceSet), resourceSet);
		elementFinder = new JavaElementFinder();
		elementFinder.setProjectProvider(projectProvider);
	}
	
	@Override
	protected void tearDown() throws Exception {
		resourceSet = null;
		typeProvider = null;
		super.tearDown();
	}
	
	@Override
	protected IJvmTypeProvider getTypeProvider() {
		return typeProvider;
	}
	
	@Override
	protected String getCollectionParamName() {
		return "c";
	}
	
	@Override
	protected JvmOperation getMethodFromParameterizedMethods(String method) {
		JvmOperation result = super.getMethodFromParameterizedMethods(method);
		if (result != null) {
			IJavaElement found = elementFinder.findElementFor(result);
			assertEquals(IJavaElement.METHOD, found.getElementType());
			assertEquals(result.getSimpleName(), found.getElementName());
			IMethod foundMethod = (IMethod) found;
			assertEquals(result.getParameters().size(), foundMethod.getNumberOfParameters());
		}
		return result;
	}
	
	@Override
	protected JvmOperation getMethodFromType(EObject context, Class<?> type, String method) {
		JvmOperation result = super.getMethodFromType(context, type, method);
		if (result != null) {
			IJavaElement found = elementFinder.findElementFor(result);
			assertEquals(IJavaElement.METHOD, found.getElementType());
			assertEquals(result.getSimpleName(), found.getElementName());
			IMethod foundMethod = (IMethod) found;
			assertEquals(result.getParameters().size(), foundMethod.getNumberOfParameters());
		}		
		return result;
	}
	
	@Override
	protected JvmConstructor getConstructorFromType(EObject context, Class<?> type, String constructor) {
		JvmConstructor result = super.getConstructorFromType(context, type, constructor);
		if (result != null) {
			IJavaElement found = elementFinder.findElementFor(result);
			assertEquals(IJavaElement.METHOD, found.getElementType());
			assertEquals(result.getSimpleName(), found.getElementName());
			IMethod foundMethod = (IMethod) found;
			assertEquals(result.getParameters().size(), foundMethod.getNumberOfParameters());
		}
		return result;
	}
	
	@Override
	protected void checkDefaultAnnotationValuesAnnotatedExternalClass(JvmAnnotationReference annotationReference) {
		// SKIP (see https://bugs.eclipse.org/bugs/show_bug.cgi?id=334863)
		// TODO fix as soon as source types expose annotation defaults reliably
	}
	
}
