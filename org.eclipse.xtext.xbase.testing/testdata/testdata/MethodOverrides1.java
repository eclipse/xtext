/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("unused")
public class MethodOverrides1 {
	public String m1(String s) {
		return "m1(String)";
	}

	public String m1(CharSequence s) {
		return "m1(CharSequence)";
	}
	
	public void m2(String s, CharSequence s2) {}
	public void m2(CharSequence s, String s2) {}
}
