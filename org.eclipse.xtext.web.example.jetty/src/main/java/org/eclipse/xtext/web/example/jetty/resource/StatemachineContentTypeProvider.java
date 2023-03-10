/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty.resource;

import org.eclipse.xtext.web.server.generator.DefaultContentTypeProvider;
import org.eclipse.xtext.web.server.generator.GeneratorService;

public class StatemachineContentTypeProvider extends DefaultContentTypeProvider {
	
	@Override
	public String getContentType(String fileName) {
		if (GeneratorService.DEFAULT_ARTIFACT.equals(fileName))
			return "text/html";
		return super.getContentType(fileName);
	}
	
}