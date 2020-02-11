/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test
import org.junit.Ignore

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class Bug412894Test extends AbstractXbaseTestCase{
	
	@Test
	@Ignore("StackOverflowError")
	def void test() {
		'''{
			val list = newArrayList
			list.forEach [
				switch it {
					String: list.add(it)
				}
			]
		}'''.expression(true)
	}
}