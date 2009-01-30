/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.xtend;

import java.util.List;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class NoSuchExtensionException extends Exception {

	private static final long serialVersionUID = 3318038998385424895L;

	private String extensionName;

	private List<?> params;

	public NoSuchExtensionException(String message, String extensionName, List<?> params) {
		super(message);
		this.extensionName = extensionName;
		this.params = params;
	}

	public NoSuchExtensionException(String extensionName, List<?> params) {
		super();
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
