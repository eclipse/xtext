/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import org.apache.log4j.Level
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.logging.LoggingTester
import org.eclipse.xtext.testing.util.ResourceHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.resource.BatchLinkableResource
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class Bug464760Test {
	
	@Inject ResourceHelper resourceHelper
	
	@Test def void testBug464760() {
		val resource = resourceHelper.resource('''
			class Foo {
				def void myMethod() {
					"foo".myExtension
				}
				def void myExtension(/*will be deleted programmatically*/Object notype) {
				}
			}
		''') as XtextResource
		
		// remove the parameter type
		val xtendFile = resource.parseResult.rootASTElement as XtendFile
		(xtendFile.xtendTypes.head.members.get(1) as XtendFunction).parameters.head.parameterType = null
		val loggings = LoggingTester.captureLogging(Level.ERROR, BatchLinkableResource) [
			EcoreUtil.resolveAll(resource)
		]
		
		loggings.assertNoLogEntries
	}
}