/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.6
 */
public class QualifiedNameInStaticImportValueConverter extends QualifiedNameValueConverter {
	
	@Override
	public String toString(String value) {
		String string = super.toString(value);
		return string + getStringNamespaceDelimiter();
	}

}