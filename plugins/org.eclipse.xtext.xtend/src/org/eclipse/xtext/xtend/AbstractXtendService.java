/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend;

import java.util.List;

import com.google.inject.Inject;

/**
 * Super class for Xtend based services. Registers Xtext services as global
 * variables in the execution context, making them accessible from within Xtend.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public abstract class AbstractXtendService {

	private XtendServiceHelper helper;

	@Inject
	public void setHelper(XtendServiceHelper helper) {
		this.helper = helper;
		helper.setMasterXtendFileName(getMasterXtendFileName());
	}
	
	protected abstract String getMasterXtendFileName();

	public XtendServiceHelper getHelper() {
		return helper;
	}
	
	protected <T> T invokeExtension(final String extensionName, final List<?> parameterValues)
		throws AbstractXtendExecutionException {
		return helper.invokeExtension(extensionName, parameterValues);
	}
}
