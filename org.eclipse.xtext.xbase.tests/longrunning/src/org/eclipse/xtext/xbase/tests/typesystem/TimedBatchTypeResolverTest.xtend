/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.tests.StopwatchRule
import org.eclipse.xtext.tests.Timed
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.Timeout
import java.util.concurrent.TimeUnit

/**
 * @author Sebastian Zarnekow
 */
@Ignore
class TimedBatchTypeResolverTest extends AbstractBatchTypeResolverTest {
	
	@Rule
	public val rule = new StopwatchRule(false)
	
	@Inject
	TimedBatchTypeResolver typeResolver;
	
	override getTypeResolver() {
		typeResolver
	}
	
	@Test
	@Timed
	override testFeatureCall_15_n() throws Exception {
		super.testFeatureCall_15_n()
	}
	
	@Test
	@Timed
	override testFeatureCall_15_n_1() throws Exception {
		super.testFeatureCall_15_n_1()
	}
	
	@Test
	@Timed
	override testFeatureCall_15_n_2() throws Exception {
		super.testFeatureCall_15_n_2()
	}
	
}


/**
 * @author Sebastian Zarnekow
 */
@Ignore
class TypeResolverPerformanceTest extends BatchTypeResolverTest {
	
	@Rule
	public val timeout = new Timeout(100, TimeUnit.MILLISECONDS) // TODO improve - aim at something like 100
	
	override LightweightTypeReference resolvesTo(String expression, String type) {
		val xExpression = expression(expression.replace('$$', 'org::eclipse::xtext::xbase::lib::'), false /* true */);
		val resolvedTypes = getTypeResolver.resolveTypes(xExpression)
		val lightweight = resolvedTypes.getActualType(xExpression)
		assertEquals(type, lightweight.simpleName);
		return lightweight
	}
	
}