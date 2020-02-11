/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmIdentifiableElementImplCustom extends JvmIdentifiableElementImpl {
	
	@Override
	public final String getQualifiedName() {
		return getQualifiedName('$');
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": ");
		if (eIsProxy()) {
			result.append(" (eProxyURI: ");
			result.append(eProxyURI());
			result.append(')');
		} else {
			try {
				result.append(getIdentifier());
			} catch (Exception e) {
				// Some types could not be resolved while computing the identifier
				result.append(getSimpleName());
			}
		}
		return result.toString();
	}
	
}
