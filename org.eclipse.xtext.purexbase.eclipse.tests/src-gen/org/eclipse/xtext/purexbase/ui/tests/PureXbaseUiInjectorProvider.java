/*******************************************************************************
 * Copyright (c) 2011, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.ui.tests;

import com.google.inject.Injector;
import org.eclipse.xtext.purexbase.ui.internal.PurexbaseActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class PureXbaseUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return PurexbaseActivator.getInstance().getInjector("org.eclipse.xtext.purexbase.PureXbase");
	}

}
