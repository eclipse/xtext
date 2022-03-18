/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xtext.XtextLinker;
import org.eclipse.xtext.xtext.XtextLinkingService;
import org.eclipse.xtext.xtext.XtextScopeProvider;
import org.eclipse.xtext.xtext.XtextTransientValueService;

/**
 * used to register components to be used within the IDE.
 */
public class XtextTerminalsTestLanguageRuntimeModule extends AbstractXtextTerminalsTestLanguageRuntimeModule {

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return TerminalRuleTestLanguageConverters.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.service.DefaultRuntimeModule#bindIScopeProvider()
	 */
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return XtextScopeProvider.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.service.DefaultRuntimeModule#bindILinker()
	 */
	@Override
	public Class<? extends ILinker> bindILinker() {
		return XtextLinker.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.service.DefaultRuntimeModule#bindILinkingService()
	 */
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return XtextLinkingService.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parser.terminalrules.AbstractXtextTerminalsTestLanguageRuntimeModule#bindITransientValueService()
	 */
	@Override
	public Class<? extends ITransientValueService> bindITransientValueService() {
		return XtextTransientValueService.class;
	}
	
}
