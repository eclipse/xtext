/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.junit.Test

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class TypeResolutionCancelTest extends AbstractXbaseTestCase {

	@Inject IBatchTypeResolver resolver
	
	@Test def void testCancelTypeResolution() {
		val exp = expression('true')
		try {
			resolver.resolveTypes(exp, [|true])	
			fail('Type resolution should have been canceled')
		} catch (OperationCanceledException e) {
			// good
		}
	}
	
	@Test def void testRunTypeResolution() {
		val exp = expression('true')
		try {
			resolver.resolveTypes(exp, [|false])	
		} catch (OperationCanceledException e) {
			fail('Type resolution should not have been canceled')
		}
	}
	
}