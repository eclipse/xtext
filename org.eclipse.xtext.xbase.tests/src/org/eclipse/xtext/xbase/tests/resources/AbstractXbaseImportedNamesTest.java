/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.FluentIterable;
import com.google.inject.Inject;

public abstract class AbstractXbaseImportedNamesTest extends AbstractXbaseTestCase {
	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;
	
	@Test
	public void testImportedNamesForConstructors() throws Exception {
		XExpression expression = expression("new java.util.ArrayList");
		assertImportedNames(expression);
	}

	@Test
	public void testImportedNamesForTypesInCasts() throws Exception {
		XExpression expression = expression("null as java.util.ArrayList");
		assertImportedNames(expression);
	}
	
	@Test
	public void testImportedNamesForTypesInVars() throws Exception {
		XExpression expression = expression("{ var java.util.ArrayList x = null }");
		assertImportedNames(expression);
	}
	
	protected void assertImportedNames(EObject model) {
		Resource resource = model.eResource();
		List<String> importedNames = importedNames(resource);
		
		List<String> expectation = new ArrayList<String>();
		addExpectatedImportedNames(resource, expectation);
		expectation.sort(Comparator.naturalOrder());
		Assert.assertEquals(expectation, importedNames);
	}

	protected List<String> importedNames(Resource resource) {
		IResourceDescription description = resourceDescriptionManager.getResourceDescription(resource);
		return FluentIterable.from(description.getImportedNames()).transform(Object::toString).toSortedList(Comparator.naturalOrder());
	}

	protected void addExpectatedImportedNames(Resource resource, List<String> expectation) {
		Collections.addAll(expectation, 
				"java.io.serializable",
				"java.lang.cloneable",
				"java.lang.iterable",
				"java.lang.java$util$arraylist",
				"java.lang.object",
				"java.util.abstractcollection",
				"java.util.abstractlist",
				"java.util.arraylist",
				"java.util.collection",
				"java.util.list",
				"java.util.randomaccess",
				"org.eclipse.xtext.xbase.lib.java$util$arraylist");
	}
	
}

