/*******************************************************************************
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.smoke

import org.eclipse.xtend.lib.annotations.Accessors

class Case_1 {
	@Accessors
	int id

	def testFunction1() {
		42
	}
	
	def testFunction2() {
		42
	} 
		
	def Integer testFunction3() {
		42
	} 
		
}