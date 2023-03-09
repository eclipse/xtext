/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.conversion;

import com.google.inject.Singleton;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@Singleton
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
