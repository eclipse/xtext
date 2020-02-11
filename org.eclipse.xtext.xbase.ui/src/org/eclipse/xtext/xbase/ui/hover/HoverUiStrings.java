/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import static com.google.common.collect.Iterables.*;

import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
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
	
	@Override
	protected String parameterTypes(Iterable<JvmFormalParameter> parameters, boolean isVarArgs) {
		return parametersToString(parameters, isVarArgs, true);
	}
}
