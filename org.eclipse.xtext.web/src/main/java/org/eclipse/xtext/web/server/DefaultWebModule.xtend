/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server

import org.eclipse.xtext.service.AbstractGenericModule
import org.eclipse.xtext.web.server.generator.DefaultContentTypeProvider
import org.eclipse.xtext.web.server.generator.IContentTypeProvider

/**
 * Default Guice bindings for the web integration of Xtext.
 */
class DefaultWebModule extends AbstractGenericModule {
	
	def Class<? extends IContentTypeProvider> bindIContentTypeProvider() {
		DefaultContentTypeProvider
	}
	
}
