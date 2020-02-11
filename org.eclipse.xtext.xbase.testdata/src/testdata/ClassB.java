/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

public class ClassB implements InterfaceA, InterfaceB {

	@Override
	public String getUpperCaseClassName() {
		return getClassName().toUpperCase();
	}

	@Override
	public String getClassName() {
		return getClass().getSimpleName();
	}

}
