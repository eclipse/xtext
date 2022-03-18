/*******************************************************************************
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.smoke

import java.util.Map
import java.util.List

class Case_7 {

	def bug345449() {
		val result = <Map$Entry<String, List<String>>>newArrayList()
		result?.head
	}

	def Object bug345452() {
		var CharSequence x = null
		if(x instanceof Map$Entry<?, ?>)
			null
	}
}