/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XCasePartImplCustom extends XCasePartImpl {
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(getClass().getName());
		result.append('@');
		result.append(Integer.toHexString(hashCode()));

		if (eIsProxy()) {
			result.append(" (eProxyURI: ");
			result.append(eProxyURI());
			result.append(')');
		}

		return result.toString();
	}
	
}
