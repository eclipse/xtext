/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
@Singleton
public class XbaseTypeConformanceComputer extends TypeConformanceComputer {
	
	@Inject 
	private FunctionConversion functionConversion;
	
	@Inject
	private SynonymTypesProvider synonymTypeProvider;

	@Override
	public boolean isConformant(JvmTypeReference left, JvmTypeReference right, boolean ignoreGenerics) {
		if (super.isConformant(left, right, ignoreGenerics)) 
			return true;
		if (functionConversion.isFunction(left) || functionConversion.isFunction(right)) {
			if (functionConversion.isConformant(left, right, ignoreGenerics)) {
				return true;
			}
		}
		Iterable<JvmTypeReference> synonymTypes = synonymTypeProvider.getSynonymTypes(right);
		for (JvmTypeReference synonymType : synonymTypes) {
			if (super.isConformant(left, synonymType, ignoreGenerics))
				return true;
		}
		return false;
	}

}
