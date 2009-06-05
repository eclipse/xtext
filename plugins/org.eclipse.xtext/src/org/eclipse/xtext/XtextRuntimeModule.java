/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.formatter.IFormatter;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xtext.XtextFormattingTokenSerializer;
import org.eclipse.xtext.xtext.XtextLinkingService;
import org.eclipse.xtext.xtext.XtextScopeProvider;
import org.eclipse.xtext.xtext.XtextTransientValueService;
import org.eclipse.xtext.xtext.XtextValidator;
import org.eclipse.xtext.xtext.XtextValueConverters;
import org.eclipse.xtext.xtext.ecoreInference.DefaultXtext2EcorePostProcessor;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;

import com.google.inject.Binder;

/**
 * used to register components to be used at runtime.
 */
public class XtextRuntimeModule extends AbstractXtextRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(XtextValidator.class).asEagerSingleton();
	}

	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return XtextLinkingService.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return XtextScopeProvider.class;
	}

	@Override
	public Class<? extends ILinker> bindILinker() {
		return org.eclipse.xtext.xtext.XtextLinker.class;
	}

	@Override
	public Class<? extends ITransientValueService> bindITransientValueService() {
		return XtextTransientValueService.class;
	}

	@Override
	public Class<? extends IFormatter> bindIFormatter() {
		return XtextFormattingTokenSerializer.class;
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return XtextValueConverters.class;
	}

	public Class<? extends IXtext2EcorePostProcessor> bindIXtext2EcorePostProcessor() {
		return DefaultXtext2EcorePostProcessor.class;
	}
}
