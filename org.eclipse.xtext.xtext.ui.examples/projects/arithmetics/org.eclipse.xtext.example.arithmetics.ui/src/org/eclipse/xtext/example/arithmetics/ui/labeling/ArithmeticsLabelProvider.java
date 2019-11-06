/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.example.arithmetics.arithmetics.Definition;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.inject.Inject;

/**
 * Provides labels for EObjects.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
public class ArithmeticsLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public ArithmeticsLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	public String text(org.eclipse.xtext.example.arithmetics.arithmetics.Module ele) {
		return ele.getName();
	}

	public String text(Definition ele) {
		return ele.getName() + IterableExtensions.join(ele.getArgs(), "(", ",", ")", (p) -> p.getName());
	}

	public String image(org.eclipse.xtext.example.arithmetics.arithmetics.Module ele) {
		return "home_nav.gif";
	}
}
