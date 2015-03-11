/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package observables

@Observable
class ObservableBean {
	String firstName
	String lastName
}

class ObservableExample {
	def static void main(String[] args) {
		// 1. create observable bean 
		new ObservableBean => [
			
			// 2. add an observer 
			addPropertyChangeListener [
				println('''property «propertyName» changed from «oldValue» to «newValue»''')
			]
			
			// 3. invoke some setters
			firstName = "Max"
			lastName = "Mustermann"
			
			firstName = "John"
			lastName = "Doe"
		]
	}
}

