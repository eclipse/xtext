/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
			val list = #[#[]]
			val map = #{ "a" -> #["b"]}
			list.forEach [
				val result = newLinkedList
				forEach [
					switch it {
						String: result.add(it)
					}
				] 
				map.put("a", result)
			]
		}'''.expression(true)
	}
}