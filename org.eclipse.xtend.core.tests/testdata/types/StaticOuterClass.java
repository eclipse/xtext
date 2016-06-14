/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package types;

/**
 * @author svenefftinge - Initial contribution and API
 */
public class StaticOuterClass {
	public static class StaticMiddleClass {
		public static class StaticInnerClass {
			public final static String CONSTANT = "CONSTANT";
		}
	}
}
