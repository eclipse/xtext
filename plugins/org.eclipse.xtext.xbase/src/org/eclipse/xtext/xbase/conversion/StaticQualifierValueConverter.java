/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.conversion;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticQualifierValueConverter extends XbaseQualifiedNameValueConverter {

	@Deprecated
	@Override
	protected String getNamespaceDelimiter() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String getStringNamespaceDelimiter() {
		return "::";
	}
	
	@Override
	protected String getValueNamespaceDelimiter() {
		return ".";
	}

	@Override
	public String toString(String value) {
		return super.toString(value) + getStringNamespaceDelimiter();
	}
}
