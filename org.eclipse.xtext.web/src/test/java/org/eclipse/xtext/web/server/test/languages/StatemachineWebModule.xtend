/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test.languages

import com.google.inject.Binder
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.web.server.DefaultWebModule
import org.eclipse.xtext.web.server.persistence.FileResourceHandler
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler

@Accessors
class StatemachineWebModule extends DefaultWebModule {
	
	IResourceBaseProvider resourceBaseProvider
	
	def Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
		FileResourceHandler
	}
	
	def void configureResourceBaseProvider(Binder binder) {
		if (resourceBaseProvider !== null)
			binder.bind(IResourceBaseProvider).toInstance(resourceBaseProvider)
	}
	
}
