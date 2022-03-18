/*******************************************************************************
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.smoke

class Case_2 {

	def aOrB(String a, String b) {
		if (a.isNullOrEmpty()) 
			b
		else
			a 
	}
	
	def returnInIf(char c) {
		if ('x'!=c) return 'xx' else return 'yy'
	}

}