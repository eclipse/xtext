/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.legacy;

import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class LegacyTypeArgumentContextProvider extends TypeArgumentContextProvider {

	@Override
	public ITypeArgumentContext getTypeArgumentContext(Request request) {
		return new NullTypeArgumentContext(request);
	}
	
}
