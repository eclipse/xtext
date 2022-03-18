/*******************************************************************************
 * Copyright (c) 2016, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.lib.annotations

import org.junit.Test
import org.junit.Assert
import org.eclipse.xtend2.lib.StringConcatenation

class DataTest {
	
	@Test def void testData() {
		Assert.assertEquals(toUnix('''
			MyDataClass [
			  arg = "foo"
			  foo = false
			]'''), new MyDataClass("foo").toString)
	}
	
	@Data static class MyDataClass {
		String arg
		boolean foo = false
	} 

	def static String toUnix(String s) {
		var StringConcatenation result = new StringConcatenation("\n")
		result.append(s)
		return result.toString()
	}
}