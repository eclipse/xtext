/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package compound;

import org.eclipse.xtext.xbase.lib.Inline;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class IntCompoundExtensions {

	@Inline(value = "$1 += $2", mutableArguments = { 0 })
	public static int operator_add(int a, int b) {
		return 0;
	}

	@Inline(value = "$1 *= $2", mutableArguments = { 0 })
	public static int operator_multiplyAssign(int a, int b) {
		return 0;
	}

}
