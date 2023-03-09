/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.xtext.conversion.IValueConverterService;

/**
 * used to register components to be used within the IDE.
 */
public class DatatypeRulesTestLanguageRuntimeModule extends AbstractDatatypeRulesTestLanguageRuntimeModule {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.service.DefaultRuntimeModule#getIValueConverterService()
	 */
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return DatatypeRulesTestLanguageValueConverters.class;
	}
}
