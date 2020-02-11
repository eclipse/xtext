/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.imports

import org.eclipse.xtext.xbase.ui.imports.ImportsUtil
import org.junit.Test

import static org.eclipse.xtext.util.Tuples.*
import static org.junit.Assert.*

/**
 * @author dhuebner - Initial contribution and API
 */
class ImportsUtilTest {

	@Test def void testQnameSplitting() {
		val ImportUtilExtension util = new ImportUtilExtension
		assertEquals(create("java.util.Collections", "*"), util.splitInTypeAndMember("java.util.Collections.*"))
		assertEquals(create("java.util.Collections", "sort"), util.splitInTypeAndMember("java.util.Collections.sort"))
		assertEquals(create("java.util.Collections", "sort"), util.splitInTypeAndMember("java.util.Collections.sort()"))
		assertEquals(create("java.util.Collections", "sort"),
			util.splitInTypeAndMember("java.util.Collections.sort(Object)"))
		assertEquals(create("java.util.Collections", ""), util.splitInTypeAndMember("java.util.Collections.("))
		assertEquals(create("java.util.Collections", ""), util.splitInTypeAndMember("java.util.Collections."))
		assertEquals(create("java.util", "Collections"), util.splitInTypeAndMember("java.util.Collections"))
	}

	static class ImportUtilExtension extends ImportsUtil {

		override protected splitInTypeAndMember(String featuresQName) {
			super.splitInTypeAndMember(featuresQName)
		}

	}
}