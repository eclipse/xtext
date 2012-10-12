/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.formatting.IFormatterConfigurationProvider;
import org.eclipse.xtend.core.formatting.XtendFormatterConfig;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class RuntimeFormatterConfigurationProvider implements IFormatterConfigurationProvider {

	public XtendFormatterConfig getFormatterConfiguration(Resource resource) {
		return new XtendFormatterConfig();
	}

}
