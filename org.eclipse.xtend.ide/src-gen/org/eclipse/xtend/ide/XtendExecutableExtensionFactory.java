/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide;

import com.google.inject.Injector;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class XtendExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return XtendActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return XtendActivator.getInstance().getInjector(XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND);
	}
	
}
