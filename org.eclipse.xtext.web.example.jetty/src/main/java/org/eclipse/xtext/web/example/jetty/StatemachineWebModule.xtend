/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty

import com.google.inject.Binder
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.web.example.jetty.resource.StatemachineContentTypeProvider
import org.eclipse.xtext.web.example.jetty.resource.StatemachineResourceSetProvider
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider
import org.eclipse.xtext.web.server.persistence.FileResourceHandler
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler

/**
 * Use this class to register additional components to be used within the web application.
 */
@FinalFieldsConstructor
class StatemachineWebModule extends AbstractStatemachineWebModule {
	
	val IResourceBaseProvider resourceBaseProvider
	
	override bindIContentTypeProvider() {
		return StatemachineContentTypeProvider
	}
	
	def Class<? extends IWebResourceSetProvider> bindIWebResourceSetProvider() {
		return StatemachineResourceSetProvider
	}

	def void configureResourceBaseProvider(Binder binder) {
		if (resourceBaseProvider !== null) binder.bind(IResourceBaseProvider).toInstance(resourceBaseProvider)
	}

	def Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
		return FileResourceHandler
	}
	
}
