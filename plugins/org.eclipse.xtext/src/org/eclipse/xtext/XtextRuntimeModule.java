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
import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.xtext.XtextFormattingTokenSerializer;
import org.eclipse.xtext.xtext.XtextLinkingService;
import org.eclipse.xtext.xtext.XtextScopeProvider;
import org.eclipse.xtext.xtext.XtextTransientValueService;
import org.eclipse.xtext.xtext.XtextValueConverters;

import com.google.inject.Binder;

/**
 * used to register components to be used at runtime.
 */
public class XtextRuntimeModule extends AbstractXtextRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		
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
	public Class<? extends ITokenSerializer> bindITokenSerializer() {
		return XtextFormattingTokenSerializer.class;
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return XtextValueConverters.class;
	}

}
