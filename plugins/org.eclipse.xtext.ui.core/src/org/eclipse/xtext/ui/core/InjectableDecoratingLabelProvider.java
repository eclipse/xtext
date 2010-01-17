/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core;

import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class InjectableDecoratingLabelProvider implements Provider<DecoratingLabelProvider> {

	@Inject
	ILabelProvider labelProvider;

	@Inject(optional=true)
	ILabelDecorator labelDecorator;

	public DecoratingLabelProvider get() {
		return new DecoratingLabelProvider(labelProvider, labelDecorator);
	}
}
