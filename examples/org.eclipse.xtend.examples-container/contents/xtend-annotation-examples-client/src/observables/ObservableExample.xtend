/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package observables

import java.beans.PropertyChangeListener

class ObservableExample {
	def static void main(String[] args) {
		
		// 1. create observable bean 
		val bean = new ObservableBean()
		
		
		// 2. create and install listener
		val PropertyChangeListener observer = [
			println('''property «propertyName» changed from «oldValue» to «newValue»''')
		]
		bean.addPropertyChangeListener(observer)
		
		
		// 3. do some changes
		bean.setFirstName("Max")
		bean.setLastName("Mustermann")
		
		bean.setFirstName("John")
		bean.setLastName("Doe")
	}
}
