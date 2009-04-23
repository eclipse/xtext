/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend;

import java.util.List;

import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.expression.ExecutionContext;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtendServiceHelper {

	@Inject
	private ExecutionContextAware ctx;
	
	private String masterXtendFileName;

	public ExecutionContextAware getExecutionContextAware() {
		return ctx;
	}
	
	public void setExecutionContextAware(ExecutionContextAware ctx) {
		this.ctx = ctx;
	}

	/**
	 * Returns the fully qualified name of the xtend file containing the
	 * extensions to be called.
	 * 
	 * @return
	 */
	public String getMasterXtendFileName() {
		return masterXtendFileName;
	}
	
	public void setMasterXtendFileName(String fileName) {
		this.masterXtendFileName = fileName;
	}
	

	@SuppressWarnings("unchecked")
	public <T> T invokeExtension(final String extensionName, final List<?> parameterValues)
			throws AbstractXtendExecutionException {
		return ctx.exec(new Function<ExecutionContext,T>(){

			public T apply(ExecutionContext ctx) {
				XtendFacade facade = XtendFacade.create(ctx, getMasterXtendFileName());
				if (!facade.hasExtension(extensionName, parameterValues)) {
					throw new NoSuchExtensionException(extensionName, parameterValues);
				}
				Object resultObject = facade.call(extensionName, parameterValues);
				try {
					return (T) resultObject;
				} catch (ClassCastException e) {
					throw new IllegalReturnTypeException(extensionName, parameterValues, e);
				}
			}});
	}

	public String toXtendFQName(String fqName) {
		return fqName.replaceAll("\\.", "::");
	}
	
}
