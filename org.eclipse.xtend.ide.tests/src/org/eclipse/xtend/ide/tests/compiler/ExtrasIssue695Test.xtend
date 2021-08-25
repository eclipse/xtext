/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.compiler

import com.google.inject.Inject
import org.apache.log4j.Level
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.testing.logging.LoggingTester
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageWritable
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*

/**
 * @author cdietrich - Initial contribution and API
 */
class ExtrasIssue695Test extends AbstractXtendUITestCase {
		
	@Inject 
	WorkbenchTestHelper workbenchTestHelper;
	
	@Before @After def void cleanUp() {
		workbenchTestHelper.tearDown
	}
	
	@Test def void testBatchLinkableResourceStorageWritableNoOrphansWithDataAA() {
		val loggings = LoggingTester.captureLogging(Level.ERROR, BatchLinkableResourceStorageWritable) [
			workbenchTestHelper.createFile('somePackage/MyClass.xtend', '''
				package somePackage
				
				@Data
				class MyClass {
					String name
				}
			''')
			waitForBuild()
		]
		
		loggings.assertNoLogEntries
	}
}