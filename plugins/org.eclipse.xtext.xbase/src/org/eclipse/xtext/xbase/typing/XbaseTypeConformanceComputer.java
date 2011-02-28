/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;
import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class XbaseTypeConformanceComputer extends TypeConformanceComputer {
	
	@Inject 
	private FunctionConversion functionConversion;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private SynonymTypesProvider synonymTypeProvider;

	@Override
	public boolean isConformant(JvmTypeReference left, JvmTypeReference right, boolean ignoreGenerics) {
		if (left == null || typeReferences.is(left, Object.class))
			return true;
		if (right == null)
			return false;
		if (typeReferences.is(left, Void.class) && typeReferences.is(right, Void.TYPE))
			return true;
		if (typeReferences.is(right, Void.class))
			return true;
		if (functionConversion.isFunction(left) || functionConversion.isFunction(right))
			return functionConversion.isConformant(left, right, ignoreGenerics);
		final boolean conformant = super.isConformant(left, right, ignoreGenerics);
		if (conformant) 
			return true;
			
		Iterable<JvmTypeReference> synonymTypes = synonymTypeProvider.getSynonymTypes(right);
		for (JvmTypeReference synonymType : synonymTypes) {
			if (super.isConformant(left, synonymType, ignoreGenerics))
				return true;
		}
		return false;
	}

	@Override
	public JvmTypeReference getCommonSuperType(List<JvmTypeReference> types) {
		ArrayList<JvmTypeReference> list = newArrayList(filter(types, new Predicate<JvmTypeReference>() {
			public boolean apply(JvmTypeReference input) {
				return input!=null && input.getType()!=null && !input.getType().eIsProxy();
			}
		}));
		// filter out Void.TYPE
		JvmTypeReference voidType = null;
		for (JvmTypeReference jvmTypeReference : types) {
			if (isPrimitiveVoid(jvmTypeReference)) {
				voidType = jvmTypeReference;
				list.remove(jvmTypeReference);
			}
		}
		if (list.isEmpty()) {
			return voidType;
		}
		// filter out Void.class
		for (JvmTypeReference jvmTypeReference : types) {
			if (isWrapperVoid(jvmTypeReference)) {
				voidType = jvmTypeReference;
				list.remove(jvmTypeReference);
			}
		}
		if (list.isEmpty()) {
			return voidType;
		}
		return super.getCommonSuperType(list);
	}

	protected boolean isWrapperVoid(JvmTypeReference jvmTypeReference) {
		return jvmTypeReference!=null && Void.class.getName().equals(jvmTypeReference.getType().getIdentifier());
	}
}
