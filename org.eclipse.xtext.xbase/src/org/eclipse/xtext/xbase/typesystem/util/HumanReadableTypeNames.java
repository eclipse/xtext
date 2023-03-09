/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;

import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.InnerTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithParameter;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class HumanReadableTypeNames extends TypeReferenceVisitorWithParameter<StringBuilder> {

	@Override
	protected void doVisitTypeReference(LightweightTypeReference reference, StringBuilder param) {
		param.append(reference.getSimpleName());
	}
	
	@Override
	protected void doVisitAnyTypeReference(AnyTypeReference reference, StringBuilder param) {
		param.append("null");
	}
	
	@Override
	protected void doVisitArrayTypeReference(ArrayTypeReference reference, StringBuilder param) {
		reference.getComponentType().accept(this, param);
		param.append("[]");
	}
	
	@Override
	protected void doVisitCompoundTypeReference(CompoundTypeReference reference, StringBuilder param) {
		String delimiter;
		if (reference.isSynonym()) {
			delimiter = " | ";
		} else {
			delimiter = " & ";
		}
		List<LightweightTypeReference> components = reference.getMultiTypeComponents();
		for(int i = 0; i < components.size(); i++) {
			if (i != 0) {
				param.append(delimiter);
			}
			components.get(i).accept(this, param);
		}
	}
	
	@Override
	protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference, StringBuilder param) {
		param.append(reference.getType().getSimpleName());
		List<LightweightTypeReference> typeArguments = reference.getTypeArguments();
		if (!typeArguments.isEmpty()) {
			param.append("<");
			for(int i = 0; i < typeArguments.size(); i++) {
				if (i != 0) {
					param.append(", ");
				}
				typeArguments.get(i).accept(this, param);
			}
			param.append(">");
		}
	}
	
	@Override
	protected void doVisitInnerTypeReference(InnerTypeReference reference, StringBuilder param) {
		reference.getOuter().accept(this, param);
		param.append(".");
		doVisitParameterizedTypeReference(reference, param);
	}
	
	@Override
	protected void doVisitFunctionTypeReference(FunctionTypeReference reference, StringBuilder param) {
		param.append("(");
		List<LightweightTypeReference> parameterTypes = reference.getParameterTypes();
		for(int i = 0; i < parameterTypes.size(); i++) {
			if (i != 0) {
				param.append(", ");
			}
			parameterTypes.get(i).accept(this, param);
		}
		param.append(")=>");
		if (reference.getReturnType() != null) {
			reference.getReturnType().accept(this, param);
		} else {
			param.append("./.");
		}
	}
	
	@Override
	protected void doVisitUnboundTypeReference(UnboundTypeReference reference, StringBuilder param) {
		param.append("Object");
	}
	
	@Override
	protected void doVisitUnknownTypeReference(UnknownTypeReference reference, StringBuilder param) {
		param.append(reference.getSimpleName());
	}
	
	@Override
	protected void doVisitWildcardTypeReference(WildcardTypeReference reference, StringBuilder param) {
		param.append("?");
		if (reference.getLowerBound() != null) {
			param.append(" super ");
			reference.getLowerBound().accept(this, param);
		} else {
			List<LightweightTypeReference> upperBounds = reference.getUpperBounds();
			if (!upperBounds.isEmpty()) {
				if (upperBounds.size() == 1 && upperBounds.get(0).isType(Object.class)) {
					return;
				}
				param.append(" extends ");
				for(int i = 0; i < upperBounds.size(); i++) {
					if (i != 0) {
						param.append(" & ");
					}
					upperBounds.get(i).accept(this, param);
				}
			}
		}
	}
	
}
