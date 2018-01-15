/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty

import javax.servlet.annotation.WebServlet
import org.eclipse.xtext.util.DisposableRegistry
import org.eclipse.xtext.web.server.persistence.ResourceBaseProviderImpl
import org.eclipse.xtext.web.servlet.XtextServlet

@WebServlet(name = "Xtext Services", urlPatterns = "/xtext-service/*")
class MyXtextServlet extends XtextServlet {
	
	DisposableRegistry disposableRegistry

	override init() {
		super.init()
		val resourceBaseProvider = new ResourceBaseProviderImpl('./test-files')
		new StatemachineWebSetup(resourceBaseProvider).createInjectorAndDoEMFRegistration
		new EntitiesWebSetup(resourceBaseProvider).createInjectorAndDoEMFRegistration
	}
	
	override destroy() {
		if (disposableRegistry !== null) {
			disposableRegistry.dispose()
			disposableRegistry = null
		}
		super.destroy()
	}

}
