/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend;

import java.util.List;

import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.expression.ExecutionContext;

import com.google.inject.Inject;

/**
 * Super class for Xtend based services. Registers Xtext services as global
 * variables in the execution context, making them accessible from within Xtend.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractXtendService {

	protected ExecutionContext ctx;

	@Inject
	public void setExecutionContext(ExecutionContext ctx) {
		this.ctx = ctx;
	}

	protected ExecutionContext createExecutionContext() {
		return ctx;
	}

	/**
	 * Returns the fully qualified name of the xtend file containing the
	 * extensions to be called.
	 * 
	 * @return
	 */
	protected abstract String getMasterXtendFileName();

	@SuppressWarnings("unchecked")
	protected <T> T invokeExtension(String extensionName, List<?> parameterValues)
			throws AbstractXtendExecutionException {
		ExecutionContext executionContext = createExecutionContext();
		XtendFacade facade = XtendFacade.create(executionContext, getMasterXtendFileName());
		if (!facade.hasExtension(extensionName, parameterValues)) {
			throw new NoSuchExtensionException(extensionName, parameterValues);
		}
		Object resultObject = facade.call(extensionName, parameterValues);
		try {
			return (T) resultObject;
		} catch (ClassCastException e) {
			throw new IllegalReturnTypeException(extensionName, parameterValues, e);
		}
	}

	public String toXtendFQName(String fqName) {
		return fqName.replaceAll("\\.", "::");
	}
}
