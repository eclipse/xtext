/*******************************************************************************
 * Copyright (c) 2020, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.Singleton;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class GH1462TestLanguageRuntimeModule extends AbstractGH1462TestLanguageRuntimeModule {
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return FallbackValueConverterService.class;
	}

	/**
	 * If the string is null, uses the text of the node.
	 */
	@Singleton
	public static class FallbackValueConverterService extends DefaultTerminalConverters {
		
		@Override
		public Object toValue(String string, String lexerRule, INode node) throws ValueConverterException {
			if (string == null) {
				string = node.getText().trim();
			}
			return super.toValue(string, lexerRule, node);
		}
		
	}
}
