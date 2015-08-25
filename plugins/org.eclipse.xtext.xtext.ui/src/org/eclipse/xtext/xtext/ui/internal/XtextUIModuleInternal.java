/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.XtextUiModule;

/**
 * This class is intended to be used in tests.<br>
 * 
 * Some tests in org.eclipse.xtext.xtext.ui.tests project needs to change {@link XtextUiModule}<br>
 * to customise the test setup.<br>
 * In those cases this class should be used. Never use XtextUiModule directly.
 * 
 * @author dhuebner - Initial contribution and API
 */
public class XtextUIModuleInternal extends XtextUiModule {

	public XtextUIModuleInternal(AbstractUIPlugin plugin) {
		super(plugin);
	}

}
