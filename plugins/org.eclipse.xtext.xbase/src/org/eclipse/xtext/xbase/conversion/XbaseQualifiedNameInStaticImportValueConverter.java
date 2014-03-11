/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.conversion;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class XbaseQualifiedNameInStaticImportValueConverter extends XbaseQualifiedNameValueConverter {
	
	@Override
	public String toString(String value) {
		String string = super.toString(value);
		return string + getStringNamespaceDelimiter();
	}
	
	@Override
	public String getStringNamespaceDelimiter() {
		return super.getStringNamespaceDelimiter();
	}

}
