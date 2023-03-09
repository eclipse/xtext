/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package instanceVsStatic;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class C {

	public static int OK = 1;
	
	public abstract boolean isOK();
	
	public static void toString(C c) {}
	
	public static void m1(C i, int j) {}
	public abstract void m1(int k);
	
	public static void m2(C i, int j, int k) {}
	public abstract void m2(int k);
	
}
