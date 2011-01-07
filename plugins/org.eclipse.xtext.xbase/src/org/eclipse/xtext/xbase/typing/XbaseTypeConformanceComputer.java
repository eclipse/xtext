/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.DefaultJvmTypeConformanceComputer;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeArgumentContext.Provider;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class XbaseTypeConformanceComputer extends DefaultJvmTypeConformanceComputer {

	@Inject
	public XbaseTypeConformanceComputer(SuperTypeCollector superTypeCollector, Provider typeArgumentContextProvider,
			TypesFactory factory) {
		super(superTypeCollector, typeArgumentContextProvider, factory);
	}

	@Override
	protected Boolean _isConformant(JvmTypeReference left, JvmTypeReference right) {
		String rightTypeName = right.getType().getCanonicalName();
		if(rightTypeName.equals("java.lang.Void") || rightTypeName.equals("java.lang.void")) 
			return true;
		return super._isConformant(left, right);
	}

}
