/*******************************************************************************
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.smoke

import com.google.inject.Inject
import java.util.ArrayList

import static java.util.Arrays.*

import static extension java.util.Collections.*

class Case_5 {

	@Inject
	ArrayList<?> myList
//	ArrayList as list
	
	@Inject extension
	String s

	def boolean something(int i) {
	  if (i.indexOf() == 0) {
//	    return list.contains(i)
	    return myList.contains(i)
	  } 
	  asList(i)
	  i.singletonList()
	  false
	}
	

}