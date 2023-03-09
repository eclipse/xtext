/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.xtext.common.types.xtext.ui.generator.ContentAssistTestLanguageGenerator;
import org.eclipse.xtext.generator.IGenerator;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ContentAssistTestLanguageRuntimeModule extends org.eclipse.xtext.common.types.xtext.ui.AbstractContentAssistTestLanguageRuntimeModule {

	public Class<? extends IGenerator> bindIGenerator() {
		return ContentAssistTestLanguageGenerator.class;
	}
}
