/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard;

public enum Outlet {
	ROOT,
	MAIN_JAVA,
	TEST_JAVA,
	MAIN_RESOURCES,
	TEST_RESOURCES,
	MAIN_SRC_GEN,
	TEST_SRC_GEN,
	MAIN_XTEND_GEN,
	TEST_XTEND_GEN,
	WEBAPP,
	META_INF;
	
	public static Outlet[] generateOutlets() {
		return new Outlet[] { MAIN_SRC_GEN, TEST_SRC_GEN, MAIN_XTEND_GEN, TEST_XTEND_GEN };
	}

	public static Outlet[] testOutlets() {
		return new Outlet[] { TEST_JAVA, TEST_RESOURCES, TEST_SRC_GEN, TEST_XTEND_GEN};
	}
	
}
