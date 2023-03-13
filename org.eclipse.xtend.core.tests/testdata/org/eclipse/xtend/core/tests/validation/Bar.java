/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
