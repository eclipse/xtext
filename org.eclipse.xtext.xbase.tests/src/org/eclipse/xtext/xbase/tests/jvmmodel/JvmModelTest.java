/**
 * Copyright (c) 2011, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.jvmmodel;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class JvmModelTest extends AbstractJvmModelTest {
	@Inject
	private ValidationTestHelper helper;

	@Inject
	private IResourceDescription.Manager manager;

	@Inject
	private ReflectExtensions reflectExtensions;

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Test
	public void testSimple() throws Exception {
		XExpression expression = expression("return s.toUpperCase", false);
		Assert.assertEquals(expression.eResource().getContents().toString(), 2, expression.eResource().getContents().size());
		helper.assertNoErrors(expression);
	}

	@Test
	public void testResourceDescriptionsAreCorrect() throws Exception {
		Resource resource = newResource("return s.toUpperCase");
		boolean initialized = reflectExtensions.<Boolean> get(resource, "fullyInitialized").booleanValue();
		Assert.assertFalse(initialized);
		IResourceDescription desc = manager.getResourceDescription(resource);
		List<Iterable<IEObjectDescription>> list = Lists.<Iterable<IEObjectDescription>> newArrayList(desc.getExportedObjects());
		Assert.assertEquals(1, list.size());
		Assert.assertFalse(reflectExtensions.<Boolean> get(resource, "fullyInitialized").booleanValue());
	}

	@Override
	protected Resource newResource(CharSequence input) throws IOException {
		XtextResourceSet resourceSet = resourceSetProvider.get();
		Resource resource = resourceSet.createResource(URI.createURI("Test.___xbase"));
		resource.load(new StringInputStream(input.toString()), null);
		return resource;
	}

	@Test
	public void testReturnTypeConformance() throws Exception {
		XExpression expression = expression("return");
		helper.assertError(expression, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN);
	}
}
