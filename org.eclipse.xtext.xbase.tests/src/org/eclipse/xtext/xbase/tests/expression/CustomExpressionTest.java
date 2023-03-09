/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.expression;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

/**
 * @author Sebastian Benz - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class CustomExpressionTest extends AbstractXbaseTestCase {

	@Test public void testBinaryExpressionsShouldReturnArgumentsInInternalEList() throws Exception {
		assertResolvingCrossReferencesThrowsNoException("1 == 1");
	}
	
	@Test public void testAssignmentShouldReturnArgumentsInInternalEList() throws Exception {
		assertResolvingCrossReferencesThrowsNoException("{var x = 'literal' x = 'newValue'}");
	} 

	@Test public void testFeatureCallShouldReturnArgumentsInInternalEList() throws Exception {
		assertResolvingCrossReferencesThrowsNoException("'literal'.toUpperCase()");
	}
	
	@Test public void testMemberFeatureCallShouldReturnArgumentsInInternalEList() throws Exception {
		assertResolvingCrossReferencesThrowsNoException("'literal'.toUpperCase()");
	}
	
	@Test public void testNullValuesShouldBeIgnored() throws Exception {
		//unary operations are not implemented yet
		String input = "!";
		XUnaryOperation expression = (XUnaryOperation) incompleteExpression(input);
		assertTrue(expression.getExplicitArguments().isEmpty()); // throws exception if null value is added to result list
	}

	private XExpression incompleteExpression(String input) throws IOException {
		Resource resource = newResource(input);
		return (XExpression) resource.getContents().get(0);
	}
	
	private void assertResolvingCrossReferencesThrowsNoException(String input) throws Exception {
		XExpression expression = expression(input);
		// throws CCE otherwise
		((LazyLinkingResource) expression.eResource()).resolveLazyCrossReferences(CancelIndicator.NullImpl);
	}
}
