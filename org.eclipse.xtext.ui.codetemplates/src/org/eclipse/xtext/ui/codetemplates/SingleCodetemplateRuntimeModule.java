/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
 package org.eclipse.xtext.ui.codetemplates;

import org.eclipse.xtext.conversion.impl.STRINGValueConverter;
import org.eclipse.xtext.parser.antlr.IPartialParsingHelper;
import org.eclipse.xtext.ui.codetemplates.conversion.SingleQuotedStringConverter;
import org.eclipse.xtext.ui.codetemplates.parser.CodetemplatesPartialParsingHelper;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class SingleCodetemplateRuntimeModule extends org.eclipse.xtext.ui.codetemplates.AbstractSingleCodetemplateRuntimeModule {

	public Class<? extends STRINGValueConverter> bindSTRINGValueConverter() {
		return SingleQuotedStringConverter.class;
	}
	
	@Override
	public Class<? extends IPartialParsingHelper> bindIPartialParserHelper() {
		return CodetemplatesPartialParsingHelper.class;
	}
	
}
