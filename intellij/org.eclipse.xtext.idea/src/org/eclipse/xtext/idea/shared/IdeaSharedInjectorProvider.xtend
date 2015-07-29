/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.shared

import com.google.inject.Guice
import com.google.inject.Injector

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class IdeaSharedInjectorProvider {
	
	static Injector injector
	 
	synchronized static def Injector getInjector() {
		injector ?: (injector = Guice.createInjector(new IdeaSharedModule))
	}
	
	def static void injectMembers(Object o) {
		getInjector.injectMembers(o)
	}
}