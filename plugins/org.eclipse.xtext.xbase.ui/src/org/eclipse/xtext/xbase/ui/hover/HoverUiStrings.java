/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.validation.UIStrings;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class HoverUiStrings extends UIStrings {

	@Override
	public String typeParameters(Iterable<? extends JvmTypeParameter> typeParams) {
		if (!isEmpty(typeParams)) {
			StringBuilder result = new StringBuilder("<");
			boolean needsSeparator = false;
			OUTER: for (JvmTypeParameter typeParam : typeParams) {
				if (needsSeparator)
					result.append(", ");
				needsSeparator = true;
				if(typeParam != null) {
					result.append(typeParam.getSimpleName());
					List<JvmTypeConstraint> constraints = typeParam.getConstraints();
					if (!constraints.isEmpty()) {
						if (constraints.size() == 1) {
							JvmType singleConstraint = constraints.get(0).getTypeReference().getType();
							if (Object.class.getName().equals(singleConstraint.getIdentifier())) {
								continue OUTER;
							}
						}
						result.append(" extends ");
						for(int i = 0; i < constraints.size(); i++) {
							if (i != 0) {
								result.append(" & ");
							}
							result.append(constraints.get(i).getTypeReference().getSimpleName());
						}
					}
				} else 
					result.append("[null]");
			}
			return result.append(">").toString();
		}
		return "";
	}
	
	protected String formalParametersToString(Iterable<? extends JvmFormalParameter> elements, boolean isVarArgs) {
		StringBuilder buffer = new StringBuilder();
		boolean needsSeparator = false;
		Iterator<? extends JvmFormalParameter> iterator = elements.iterator();
		while (iterator.hasNext()) {
			JvmFormalParameter parameter = iterator.next();
			if (needsSeparator)
				buffer.append(", ");
			needsSeparator = true;
			JvmTypeReference typeRef = parameter.getParameterType();
			if(typeRef != null) {
				if (typeRef instanceof JvmAnyTypeReference)
					buffer.append("Object");
				else {
					if (isVarArgs && !iterator.hasNext()) {
						if (typeRef instanceof JvmGenericArrayTypeReference) {
							buffer.append(((JvmGenericArrayTypeReference) typeRef).getComponentType().getSimpleName());
						} else {
							buffer.append(typeRef.getSimpleName());
						}
						buffer.append("...");
					} else {
						buffer.append(typeRef.getSimpleName());
					}
				}
			} else 
				buffer.append("[null]");
			buffer.append(" " + parameter.getName());
		}
		return buffer.toString();
	}
	
	@Override
	protected String parameterTypes(Iterable<JvmFormalParameter> parameters, boolean isVarArgs) {
		return formalParametersToString(parameters, isVarArgs);
	}
}
