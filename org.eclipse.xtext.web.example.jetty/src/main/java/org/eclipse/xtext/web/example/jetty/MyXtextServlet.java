/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import org.eclipse.xtext.util.DisposableRegistry;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.ResourceBaseProviderImpl;
import org.eclipse.xtext.web.servlet.XtextServlet;

@WebServlet(name = "Xtext Services", urlPatterns = "/xtext-service/*")
public class MyXtextServlet extends XtextServlet {

	private static final long serialVersionUID = 7755930570117246031L;
	DisposableRegistry disposableRegistry;

	@Override
	public void init() throws ServletException {
		super.init();
		IResourceBaseProvider resourceBaseProvider = new ResourceBaseProviderImpl("./test-files");
		new StatemachineWebSetup(resourceBaseProvider).createInjectorAndDoEMFRegistration();
		new EntitiesWebSetup(resourceBaseProvider).createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public void destroy() {
		if (disposableRegistry != null) {
			disposableRegistry.dispose();
			disposableRegistry = null;
		}
		super.destroy();
	}

}
