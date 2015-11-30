/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty.resource

import org.eclipse.xtext.web.server.generator.DefaultContentTypeProvider
import org.eclipse.xtext.web.server.generator.GeneratorService

class StatemachineContentTypeProvider extends DefaultContentTypeProvider {
	
	override getContentType(String fileName) {
		if (fileName == GeneratorService.DEFAULT_ARTIFACT)
			return 'text/html'
		super.getContentType(fileName)
	}
	
}