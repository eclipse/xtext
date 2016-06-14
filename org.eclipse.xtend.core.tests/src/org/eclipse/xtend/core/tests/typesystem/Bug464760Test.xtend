/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import org.apache.log4j.Level
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.logging.LoggingTester
import org.eclipse.xtext.junit4.util.ResourceHelper
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