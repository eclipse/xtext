/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.tests;

import com.google.inject.Injector;
import org.eclipse.xtext.example.arithmetics.ui.internal.ArithmeticsActivator;
import org.eclipse.xtext.junit4.IInjectorProvider;

public class ArithmeticsUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return ArithmeticsActivator.getInstance().getInjector("org.eclipse.xtext.example.arithmetics.Arithmetics");
	}

}
