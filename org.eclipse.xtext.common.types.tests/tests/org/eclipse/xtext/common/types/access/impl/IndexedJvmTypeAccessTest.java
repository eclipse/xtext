/*******************************************************************************
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.eclipse.xtext.common.types.xtext.ui.tests.RefactoringTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests for {@link IndexedJvmTypeAccess} 
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RefactoringTestLanguageInjectorProvider.class)
public class IndexedJvmTypeAccessTest {

	@Inject
	private XtextResourceSet resourceSet;

	@Inject
	private IndexedJvmTypeAccess indexedJvmTypeAccess;

	@Inject
	private DeclaredTypeFactory declaredTypeFactory;

	@Test
	public void testGetIndexedJvmTypeByURI() throws ClassNotFoundException {
		ProjectDescription projectDescription = new ProjectDescription();
		projectDescription.setName("test-project");
		ChunkedResourceDescriptions index = new ChunkedResourceDescriptions(Collections.emptyMap(), resourceSet);
		ResourceDescriptionsData data = new ResourceDescriptionsData(new ArrayList<>());
		index.setContainer(projectDescription.getName(), data);
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, data);

		Resource resource = resourceSet.createResource(URI.createURI("test.typesRefactoring"));

		BinaryClass binaryClass = BinaryClass.forName("testdata.Outer", getClass().getClassLoader());
		JvmDeclaredType outerType = declaredTypeFactory.createType(binaryClass);
		resource.getContents().add(outerType);
		JvmDeclaredType innerType = findType(outerType, "Inner");
		JvmDeclaredType innerMostType = findType(outerType, "InnerMost");

		IResourceServiceProvider serviceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(resource.getURI());
		IResourceDescription description = serviceProvider.getResourceDescriptionManager().getResourceDescription(resource);
		data.addDescription(description.getURI(), description);

		URI javaObjectURI = EcoreUtil.getURI(getOperation(outerType, "getOuter").getReturnType().getType());
		EObject outerTypeFromIndex = indexedJvmTypeAccess.getIndexedJvmType(javaObjectURI , resourceSet);
		assertSame(outerType, outerTypeFromIndex);

		javaObjectURI = EcoreUtil.getURI(getOperation(outerType, "getInner").getReturnType().getType());
		EObject innerTypeFromIndex = indexedJvmTypeAccess.getIndexedJvmType(javaObjectURI , resourceSet);
		assertSame(innerType, innerTypeFromIndex);

		javaObjectURI = EcoreUtil.getURI(getOperation(outerType, "getInnerMost").getReturnType().getType());
		EObject innerMostTypeFromIndex = indexedJvmTypeAccess.getIndexedJvmType(javaObjectURI , resourceSet);
		assertSame(innerMostType, innerMostTypeFromIndex);
	}

	private JvmOperation getOperation(JvmDeclaredType type, String name) {
		for (JvmOperation op : type.getDeclaredOperations()) {
			if (name.equals(op.getSimpleName())) {
				return op;
			}
		}
		return null;
	}

	private JvmDeclaredType findType(JvmDeclaredType type, String name) {
		if (name.equals(type.getSimpleName())) {
			return type;
		}
		for (JvmDeclaredType m : type.getAllNestedTypes()) {
			JvmDeclaredType inner = findType(m, name);
			if (inner != null) {
				return inner;
			}
		}
		return null;
	}

}
