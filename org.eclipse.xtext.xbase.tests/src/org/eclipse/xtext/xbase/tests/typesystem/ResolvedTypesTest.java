/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Collections;

import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResolvedTypesTest extends AbstractXbaseTestCase {
	@Inject
	private PublicReentrantTypeResolver resolver;

	private TypesFactory typesFactory = TypesFactory.eINSTANCE;

	private XbaseFactory xbaseFactory = XbaseFactory.eINSTANCE;

	private PublicResolvedTypes testMe;

	@Before
	public void initResolvedTypes() throws Exception {
		XExpression expression = expression("null");
		resolver.initializeFrom(expression);
		testMe = new PublicResolvedTypes(resolver);
	}

	@Test
	public void testDiagnostics() {
		Assert.assertEquals(Collections.emptyList(), testMe.getQueuedDiagnostics());
	}

	@Test
	public void testActualTypeArguments() {
		Assert.assertTrue(testMe.getActualTypeArguments(null).isEmpty());
	}

	@Test
	public void testCreateAndGetUnboundTypeParameter() {
		UnboundTypeReference unbound = testMe.createUnboundTypeReference(xbaseFactory.createXFeatureCall(),
				typesFactory.createJvmTypeParameter());
		Assert.assertSame(unbound, testMe.getUnboundTypeReference(unbound.getHandle()));
	}

	@Test(expected = IllegalStateException.class)
	public void testTryGetUnknownUnboundTypeParameter() {
		testMe.getUnboundTypeReference("unknown handle");
	}

	public PublicReentrantTypeResolver getResolver() {
		return resolver;
	}

	public void setResolver(PublicReentrantTypeResolver resolver) {
		this.resolver = resolver;
	}

	public PublicResolvedTypes getTestMe() {
		return testMe;
	}

	public void setTestMe(PublicResolvedTypes testMe) {
		this.testMe = testMe;
	}
}
