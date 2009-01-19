/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import java.util.Set;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.xtext.XtextFormattingTokenSerializer;
import org.eclipse.xtext.xtext.XtextLinker;
import org.eclipse.xtext.xtext.XtextLinkingService;
import org.eclipse.xtext.xtext.XtextScopeProvider;
import org.eclipse.xtext.xtext.XtextTransientValueService;

/**
 * used to register components to be used at runtime.
 */
public class XtextRuntimeConfig extends AbstractXtextRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> inherited = scope(IXtext.SCOPE)
					.with(IScopeProvider.class, XtextScopeProvider.class)
					.with(ILinker.class, XtextLinker.class)
					.with(ILinkingService.class, XtextLinkingService.class)
					.with(ITransientValueService.class, XtextTransientValueService.class)
					.with(ITokenSerializer.class, XtextFormattingTokenSerializer.class)
					.registrations();
		inherited.addAll(super.registrations());
		return inherited;
	}
	
}
