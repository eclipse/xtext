/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.DefaultJvmTypeConformanceComputer;
import org.eclipse.xtext.xbase.functions.FunctionConversion;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class XbaseTypeConformanceComputer extends DefaultJvmTypeConformanceComputer {
	
	@Inject 
	private FunctionConversion functionConversion;
	
	@Inject
	private TypesService typesService;

	@Override
	public boolean isConformant(JvmTypeReference left, JvmTypeReference right) {
		if (typesService.isVoid(right))
			return true;
		if (functionConversion.isFunction(left) || functionConversion.isFunction(right))
			return functionConversion.isConformant(left, right);
		if (right!=null && right.getType() instanceof JvmArrayType) {
			JvmArrayType array = (JvmArrayType) right.getType();
			if (isIterable(left.getType())) {
				JvmTypeReference newLeft = ((JvmParameterizedTypeReference)left).getArguments().get(0);
				return isConformant(newLeft, array.getComponentType());
			}
			return false;
		}
		return super.isConformant(left, right);
	}

	protected boolean isIterable(JvmType type) {
		return type.getCanonicalName().equals(Iterable.class.getName());
	}
	
}
