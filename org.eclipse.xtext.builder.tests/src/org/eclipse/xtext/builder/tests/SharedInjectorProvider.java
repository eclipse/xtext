/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.tests;

import org.eclipse.xtext.testing.IInjectorProvider;

import com.google.inject.Injector;

/**
 * An injector provider that allows to inject values from the Xtext shared
 * injector into unit tests (e.g. if the test does not depend on a specific language).
 * 
 * Use along with <code>@InjectWith</code>.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SharedInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return org.eclipse.xtext.ui.shared.internal.Activator.getDefault().getInjector();
	}

}
