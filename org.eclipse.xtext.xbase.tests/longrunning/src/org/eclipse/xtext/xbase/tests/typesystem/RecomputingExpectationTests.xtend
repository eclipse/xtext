/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Sebastian Zarnekow
 */
class RecomputingExpectationTest extends AbstractExpectationTest {
	@Inject ExpectationTestingTypeComputer typeComputer
	
	@Inject RecordingRecomputingReentrantTypeResolver resolver
	
	override getTypeComputer() {
		typeComputer
	}
	
	override getResolver() {
		resolver
	}
}

/**
 * @author Sebastian Zarnekow
 */
class RecordingRecomputingReentrantTypeResolver extends RecomputingReentrantTypeResolver {
	
	override createResolvedTypes(CancelIndicator monitor) {
		val recorder = typeComputer as ExpectationTestingTypeComputer
		val test = recorder.test
		test.clearData
		super.createResolvedTypes(monitor)
	}
	
}
