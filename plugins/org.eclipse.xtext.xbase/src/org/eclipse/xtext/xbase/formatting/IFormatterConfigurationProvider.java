/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.configuration.IConfigurationValues;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public interface IFormatterConfigurationProvider {

	IConfigurationValues getFormatterConfiguration(Resource resource);

}
