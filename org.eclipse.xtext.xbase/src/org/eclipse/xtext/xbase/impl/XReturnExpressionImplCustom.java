/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XReturnExpressionImplCustom extends XReturnExpressionImpl {

	@Override
	public String toString() {
		if (expression != null)
			return String.format("return %s;", expression);
		return "return;";
	}
	
}
