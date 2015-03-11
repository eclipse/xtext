/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package nested;

/**
 * @author svenefftinge - Initial contribution and API
 */
public class NestedTypes {
	public static class array {
		public final static int CONSTANT = 42;
	}
	
	public static boolean isInterface() {
		return true;
	}
	
	public static class primitive {
	}
	public static int getPrimitive() {
		return 1;
	}
	
	public static class annotation {
	}
	public static int annotation = 1;
}
