/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.xpect.services.XpectValueConverter;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectRuntimeModule extends AbstractXpectRuntimeModule {

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return XpectValueConverter.class;
	}

}
