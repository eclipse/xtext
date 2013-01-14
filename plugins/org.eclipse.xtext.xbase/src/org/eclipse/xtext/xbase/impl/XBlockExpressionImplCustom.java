/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

import com.google.common.base.Joiner;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XBlockExpressionImplCustom extends XBlockExpressionImpl {

	@Override
	public String toString() {
		if (expressions != null) {
			return String.format("{\n  %s\n}", Joiner.on("\n  ").join(expressions));
		}
		return "{}";
	}
	
}
