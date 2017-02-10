/*******************************************************************************
 * Copyright (c) 2010-2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.common

import com.google.inject.Guice
import org.eclipse.xtend.core.XtendRuntimeModule
import org.eclipse.xtend.core.XtendStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 * 
 * @since 2.12
 */
class XtendIdeSetup extends XtendStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new XtendRuntimeModule, new XtendIdeModule))
	}
	
}
