/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XTypeLiteralImplCustom extends XTypeLiteralImpl {

	@Override
	public String toString() {
		return String.format("typeof(%s%s)", String.valueOf(type), Strings.concat("", getArrayDimensions()));
	}
	
}
