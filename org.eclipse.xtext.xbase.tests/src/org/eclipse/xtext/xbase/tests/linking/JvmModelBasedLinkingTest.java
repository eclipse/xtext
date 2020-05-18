/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseWithLogicalContainerInjectorProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(XbaseWithLogicalContainerInjectorProvider.class)
public class JvmModelBasedLinkingTest extends AbstractXbaseTestCase {
	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	@Inject
	private TypeReferences refs;

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Test
	public void testLinkToParameter() throws Exception {
		XExpression expr = expression("x", false);
		Resource resource = expr.eResource();
		resource.eSetDeliver(false);
		resource.getContents().add(jvmTypesBuilder.toClass(expr, "Foo", cls -> {
			cls.getMembers().add(jvmTypesBuilder.toMethod(expr, "doStuff", stringType(expr), (JvmOperation o) -> {
				o.getParameters().add(jvmTypesBuilder.toParameter(expr, "x", stringType(expr)));
				jvmTypesBuilder.setBody(o, expr);
			}));
		}));
		validationTestHelper.assertNoErrors(expr);
	}

	@Test
	public void testLinkToParameter_1() throws Exception {
		XFeatureCall expr = (XFeatureCall) expression("x", false);
		Resource resource = expr.eResource();
		resource.eSetDeliver(false);
		resource.getContents().add(jvmTypesBuilder.toClass(expr, "Foo", cls -> {
			cls.getMembers().add(jvmTypesBuilder.toField(expr, "x", stringType(expr)));
			cls.getMembers().add(jvmTypesBuilder.toMethod(expr, "doStuff", stringType(expr), (JvmOperation o) -> {
				o.getParameters().add(jvmTypesBuilder.toParameter(expr, "x", stringType(expr)));
				jvmTypesBuilder.setBody(o, expr);
			}));
		}));
		validationTestHelper.assertNoErrors(expr);
		Assert.assertTrue(expr.getFeature() instanceof JvmFormalParameter);
	}

	@Test
	public void testLinkToField() throws Exception {
		XFeatureCall expr = (XFeatureCall) expression("x", false);
		Resource resource = expr.eResource();
		resource.eSetDeliver(false);
		resource.getContents().add(jvmTypesBuilder.toClass(expr, "Foo", cls -> {
			cls.getMembers().add(jvmTypesBuilder.toField(expr, "x", stringType(expr)));
			cls.getMembers().add(jvmTypesBuilder.toMethod(expr, "doStuff", stringType(expr), (JvmOperation o) -> {
				o.getParameters().add(jvmTypesBuilder.toParameter(expr, "y", stringType(expr)));
				jvmTypesBuilder.setBody(o, expr);
			}));
		}));
		validationTestHelper.assertNoErrors(expr);
		Assert.assertTrue(expr.getFeature() instanceof JvmField);
	}

	@Test
	public void testLinkToField_1() throws Exception {
		XFeatureCall expr = (XFeatureCall) expression("x", false);
		Resource resource = expr.eResource();
		resource.eSetDeliver(false);
		resource.getContents().add(jvmTypesBuilder.toClass(expr, "Foo", cls -> {
			cls.getMembers().add(jvmTypesBuilder.toField(expr, "x", stringType(expr)));
			cls.getMembers().add(jvmTypesBuilder.toMethod(expr, "getX", stringType(expr), (JvmOperation o) -> {
				jvmTypesBuilder.setBody(o, expr);
			}));
		}));
		validationTestHelper.assertNoErrors(expr);
		Assert.assertTrue(expr.getFeature() instanceof JvmField);
	}

	public JvmTypeReference stringType(EObject ctx) {
		return refs.getTypeForName(String.class, ctx);
	}
}
