/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticOperators {

	public static String operator_minus(String a) {
        return a;
    }
    
	public static String operator_minus(String a, String b) {
        return a + b;
    }
    
	public static String setAssign(String s, String s2) {
    	return s + s2;
    }
	
}
