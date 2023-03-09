/*******************************************************************************
 * Copyright (c) 2010 Ralf Ebert and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.indent;

import org.eclipse.xtext.parser.IParser;

import com.google.inject.Binder;

public class IndentationAwareTestLanguageRuntimeModule extends AbstractIndentationAwareTestLanguageRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
	}
	
	@Override
	public Class<? extends IParser> bindIParser() {
		return CustomizedIndentationAwareTestLanguageParser.class;
	}
}
