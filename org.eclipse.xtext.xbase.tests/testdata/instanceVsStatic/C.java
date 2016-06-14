/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
