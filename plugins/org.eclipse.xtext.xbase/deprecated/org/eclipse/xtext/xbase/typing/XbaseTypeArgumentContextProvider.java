/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import java.util.Set;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
@SuppressWarnings("deprecation")
public class XbaseTypeArgumentContextProvider extends TypeArgumentContextProvider {

	@Inject
	private Closures closures;
	
	@Inject
	private SynonymTypesProvider synonymTypeProvider;
	
	@Inject
	private XbaseTypeConformanceComputer conformanceComputer;
	
	@Override
	protected void resolveAgainstActualType(JvmTypeReference declaredType, JvmTypeReference actualType,
			Multimap<JvmTypeParameter, ResolveInfo> result, boolean allowWildcardResolutions, int hint) {
		JvmTypeReference declaredClosureType = closures.getCompatibleFunctionType(declaredType, false, false);
		JvmTypeReference actualClosureType = closures.getCompatibleFunctionType(actualType, true, false);
		if (declaredClosureType == null || actualClosureType == null) {
			super.resolveAgainstActualType(declaredType, actualType, result, allowWildcardResolutions, hint);
			Set<JvmTypeReference> actualSynonyms = synonymTypeProvider.getSynonymTypes(actualType, true);
			for(JvmTypeReference synonym: actualSynonyms) {
				super.resolveAgainstActualType(declaredType, synonym, result, allowWildcardResolutions, hint);
			}
		} else {
			super.resolveAgainstActualType(declaredClosureType, actualClosureType, result, allowWildcardResolutions, hint);
		}
	}
	
	@Override
	protected TypeConformanceComputer getConformanceComputer() {
		return conformanceComputer;
	}
	
}
