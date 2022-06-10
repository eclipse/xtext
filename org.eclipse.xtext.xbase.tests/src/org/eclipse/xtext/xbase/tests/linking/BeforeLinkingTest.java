/**
 * Copyright (c) 2013, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.linking;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BeforeLinkingTest extends AbstractXbaseTestCase {
	@Inject
	private ParseHelper<XExpression> parseHelper;

	@Inject
	private ReflectExtensions reflectExtensions;

	@Test
	public void testImplicitLambdaParameter() throws Exception {
		XBlockExpression block = (XBlockExpression) parseHelper.parse("{ val Comparable<String> c = [ length ] c.toString } ");
		BatchLinkableResource resource = (BatchLinkableResource) block.eResource();
		resource.resolveLazyCrossReferences(null);
		XVariableDeclaration assignment = (XVariableDeclaration) Iterables.getFirst(block.getExpressions(), null);
		Assert.assertNotNull(assignment);
		XClosure lambda = (XClosure) assignment.getRight();
		JvmFormalParameter implicitParameter = Iterables.getFirst(lambda.getImplicitFormalParameters(), null);
		Assert.assertNotNull(lambda);
		Assert.assertEquals("String", implicitParameter.getParameterType().getSimpleName());
		resource.update(0, 0, "");
		Assert.assertNull(implicitParameter.eResource());
	}

	@Test
	public void testImplicitReceiver() throws Exception {
		XBlockExpression block = (XBlockExpression) parseHelper.parse("{ val it = \'\' toString }");
		BatchLinkableResource resource = (BatchLinkableResource) block.eResource();
		XFeatureCall toString = (XFeatureCall) Iterables.getLast(block.getExpressions(), null);
		Assert.assertNotNull(toString);
		XFeatureCall implicitReceiver = (XFeatureCall) toString.getImplicitReceiver();
		Assert.assertEquals("it", implicitReceiver.getFeature().getSimpleName());
		resource.update(0, 0, "");
		Assert.assertNull(reflectExtensions.get(toString, "implicitReceiver"));
		Assert.assertNotNull(toString.getImplicitReceiver());
	}

	@Test
	public void testImplicitFirstArgument() throws Exception {
		XBlockExpression block = (XBlockExpression) parseHelper.parse("{ val it = newArrayList unmodifiableView }");
		BatchLinkableResource resource = (BatchLinkableResource) block.eResource();
		XFeatureCall unmodifiableView = (XFeatureCall) Iterables.getLast(block.getExpressions(), null);
		Assert.assertNotNull(unmodifiableView);
		XFeatureCall implicitFirstArgument = (XFeatureCall) unmodifiableView.getImplicitFirstArgument();
		Assert.assertEquals("it", implicitFirstArgument.getFeature().getSimpleName());
		resource.update(0, 0, "");
		Assert.assertNull(reflectExtensions.get(unmodifiableView, "implicitFirstArgument"));
		Assert.assertNotNull(unmodifiableView.getImplicitFirstArgument());
	}
}
