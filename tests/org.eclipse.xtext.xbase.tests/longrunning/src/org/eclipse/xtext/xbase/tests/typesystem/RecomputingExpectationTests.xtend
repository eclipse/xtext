/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
