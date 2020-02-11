/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package compound;

import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.ReassignFirstArgument;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class IntCompoundExtensions {

	@ReassignFirstArgument
	@Inline(value = "$1 += $2")
	public static int operator_add(int a, int b) {
		return 0;
	}

	@ReassignFirstArgument
	@Inline(value = "$1 *= $2")
	public static int operator_multiplyAssign(int a, int b) {
		return 0;
	}
	
	@ReassignFirstArgument
	public static int operator_divideAssign(int a, int b) {
		return a / b;
	}
	
	public static int operator_modulo(int a, int b) {
		return a % b;
	}

}
