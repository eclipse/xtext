/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.util.FeatureCallAsTypeLiteralHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseInjectorProvider.class)
public class FeatureCallAsTypeLiteralHelperTest extends Assert {

	@Inject
	private ParseHelper<XExpression> parseHelper;
	
	@Inject
	private FeatureCallAsTypeLiteralHelper helper;
	
	protected boolean isPotentialTypeLiteral(String expression) throws Exception {
		return helper.isPotentialTypeLiteral(parseHelper.parse(expression), IResolvedTypes.NULL);
	}
	
	protected List<String> getTypeNameSegmentsFromConcreteSyntax(String expression) throws Exception {
		return helper.getTypeNameSegmentsFromConcreteSyntax((XMemberFeatureCall) parseHelper.parse(expression));
	}
	
	protected void assertTypeNameSegmentsFromConcreteSyntax(String expression, String... segments) throws Exception {
		List<String> computedSegments = getTypeNameSegmentsFromConcreteSyntax(expression);
		if (computedSegments == null) {
			assertEquals(Arrays.asList(segments), Collections.emptyList());
		} else {
			assertEquals(Arrays.asList(segments), computedSegments);
		}
	}
	
	@Test
	public void testIsPotentialTypeLiteral_01() throws Exception {
		assertTrue(isPotentialTypeLiteral("String"));
		assertTrue(isPotentialTypeLiteral("java.lang.String"));
		assertTrue(isPotentialTypeLiteral("java::lang::String"));
		assertTrue(isPotentialTypeLiteral("(java::lang)::String"));
	}
	
	@Test
	public void testIsPotentialTypeLiteral_02() throws Exception {
		assertFalse(isPotentialTypeLiteral("null.toString"));
		assertFalse(isPotentialTypeLiteral("true.toString"));
		assertFalse(isPotentialTypeLiteral("java.lang::String"));
		assertFalse(isPotentialTypeLiteral("java::lang.String"));
	}
	
	@Test
	public void testGetTypeNameSegmentsFromConcreteSyntax_01() throws Exception {
		assertNull(getTypeNameSegmentsFromConcreteSyntax("(java.lang).String"));
		assertNull(getTypeNameSegmentsFromConcreteSyntax("java.lang::String"));
		assertNull(getTypeNameSegmentsFromConcreteSyntax("java::lang.String"));
	}
	
	@Test
	public void testGetTypeNameSegmentsFromConcreteSyntax_02() throws Exception {
		assertTypeNameSegmentsFromConcreteSyntax("java.lang.String", "java", "lang");
		assertTypeNameSegmentsFromConcreteSyntax("java::lang::String", "java", "lang");
		assertTypeNameSegmentsFromConcreteSyntax("^java::^lang::String", "java", "lang");
		assertTypeNameSegmentsFromConcreteSyntax("/* */ java  .   ^lang .  String  ", "java", "lang");
	}

}
