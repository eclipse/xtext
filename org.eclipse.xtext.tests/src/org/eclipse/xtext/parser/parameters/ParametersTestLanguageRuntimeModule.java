/*******************************************************************************
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.parameters;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.KeywordAlternativeConverter;

import com.google.inject.Inject;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ParametersTestLanguageRuntimeModule extends org.eclipse.xtext.parser.parameters.AbstractParametersTestLanguageRuntimeModule {
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return Converters.class;
	}
	
	public static class Converters extends DefaultTerminalConverters {
		@Inject KeywordAlternativeConverter converter;
		
		@ValueConverter(rule="IdOrKeyword")
		public KeywordAlternativeConverter IdOrKeyword() {
			return converter;
		}
		
	}
}
