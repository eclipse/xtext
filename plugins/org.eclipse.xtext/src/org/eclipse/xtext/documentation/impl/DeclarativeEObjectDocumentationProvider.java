/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.documentation.impl;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.util.Exceptions;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class DeclarativeEObjectDocumentationProvider implements IEObjectDocumentationProvider {

	private final PolymorphicDispatcher<String> dispatcher = 
		new PolymorphicDispatcher<String>("_documentation", 1, 1, Collections.singletonList(this), new ErrorHandler<String>() {
			public String handle(Object[] params, Throwable e) {
				return handleError(params, e);
			}
		});

	public String getDocumentation(EObject o) {
		String result = dispatcher.invoke(o);
		if (result == null)
			result = getDefaultDocumentation();
		return result;
	}

	protected String getDefaultDocumentation() {
		return null;
	}

	protected String _documentation(EObject element) {
		return null;
	}
	
	protected String handleError(Object[] params, Throwable e) {
		if (e instanceof NullPointerException) {
			return getDefaultDocumentation();
		}
		return Exceptions.throwUncheckedException(e);

	}

}
