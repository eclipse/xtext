/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class Bar {

	public static final int STATIC_FINAL_WITH_CONSTANT_INITIALIZATION = 1;

	public static int NOT_FINAL_STATIC_WITH_CONSTANT_INITIALIZATION = 2;

	public static final int STATIC_FINAL_WITH_NOT_CONSTANT_INITIALIZATION = bar();

	public static final int STATIC_FINAL_WITHOUT_INITIALIZATION;

	static {
		STATIC_FINAL_WITHOUT_INITIALIZATION = 3;
	}

	private static int bar() {
		return 4;
	}

}
