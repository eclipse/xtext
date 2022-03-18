/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.converter.Bug362902ValueConverters;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class Bug362902RuntimeModule extends org.eclipse.xtext.linking.AbstractBug362902RuntimeModule {

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return Bug362902ValueConverters.class;
	}
	
	
}

