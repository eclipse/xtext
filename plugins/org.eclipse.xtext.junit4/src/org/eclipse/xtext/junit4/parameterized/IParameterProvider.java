/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.parameterized;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(XpectParameterProvider.class)
public interface IParameterProvider {

	public interface IParameterAcceptor {
		void acceptImportURI(URI uri);

		void acceptTest(String title, String method, Object[] params, String expectation, boolean ignore);

		void acceptTestClass(Class<?> clazz);
	}

	void collectParameters(XtextResource resource, IParameterAcceptor acceptor);

}
