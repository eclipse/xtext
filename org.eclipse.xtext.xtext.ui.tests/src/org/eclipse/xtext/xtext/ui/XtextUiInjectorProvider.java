/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui;

import org.eclipse.xtext.testing.IInjectorProvider;

import com.google.inject.Injector;

/**
 * @author miklossy - Initial contribution and API
 */
public class XtextUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return Activator.getDefault().getInjector("org.eclipse.xtext.Xtext");
	}
}
