/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
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
