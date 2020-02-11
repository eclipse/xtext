/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.service.OperationCanceledError
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
		} catch (OperationCanceledError e) {
			// good
		}
	}
	
	@Test def void testRunTypeResolution() {
		val exp = expression('true')
		try {
			resolver.resolveTypes(exp, [|false])	
		} catch (OperationCanceledError e) {
			fail('Type resolution should not have been canceled')
		}
	}
	
}