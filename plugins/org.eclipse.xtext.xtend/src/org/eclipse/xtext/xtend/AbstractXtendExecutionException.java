/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend;

import java.util.List;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractXtendExecutionException extends RuntimeException {

	private static final long serialVersionUID = -222589135594914255L;

	private String extensionName;

	private List<?> params;
	
	protected AbstractXtendExecutionException(String message, String extensionName, List<?> params) {
		super(message);
		this.extensionName = extensionName;
		this.params = params;
	}

	protected AbstractXtendExecutionException(String message, String extensionName, List<?> params, Throwable causedBy) {
		super(message, causedBy);
		this.extensionName = extensionName;
		this.params = params;
	}

	@Override
	public String getMessage() {
		return super.getMessage() + " " + getExtensionSignature();
	}

	protected String getExtensionSignature() {
		StringBuffer b = new StringBuffer(extensionName);
		b.append("(");
		boolean isFirst = true;
		for (Object param : params) {
			if (!isFirst)
				b.append(",");
			isFirst = false;
			b.append(param.getClass().getName());
		}
		b.append(")");
		return b.toString();
	}

	public String getExtensionName() {
		return extensionName;
	}

	public List<?> getParams() {
		return params;
	}
}
