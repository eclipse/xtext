/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common;

import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.testlanguages.IReferenceGrammarTestLanguage;
import org.eclipse.xtext.ui.common.editor.outline.ILazyTreeProvider;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ServiceScopeTest extends AbstractUiTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		//withUi(ReferenceGrammarTestLanguageStandaloneSetup.class, ReferenceGrammarTestLanguageUiConfig.class);
	}

	public void testServiceRegistration() throws Exception {
		ILazyTreeProvider service = ServiceRegistry.getService(IReferenceGrammarTestLanguage.SCOPE, ILazyTreeProvider.class);
		assertNotNull(service);
	}
}
