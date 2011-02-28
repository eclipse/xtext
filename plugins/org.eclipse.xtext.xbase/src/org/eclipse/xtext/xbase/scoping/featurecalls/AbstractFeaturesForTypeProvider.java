/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractFeaturesForTypeProvider implements IFeaturesForTypeProvider {

	@Inject
	private XbaseTypeConformanceComputer typeConformanceComputer;

	@Inject
	private TypeReferences typeReferences;

	/**
	 * Whether both {@link JvmTypeReference}s point to the same rawtyp or the second points to a type parameter where
	 * the its upperBound is the same or a supertype of the first argument's raw type.
	 */
	protected boolean isSameTypeOrAssignableToUpperBound(JvmTypeReference first, JvmTypeReference second) {
		if (second.getType() == first.getType()) {
			return true;
		}
		if (second.getType() instanceof JvmTypeParameter) {
			boolean upperBoundSeen = false;
			for (JvmTypeConstraint constraint : ((JvmTypeParameter) second.getType()).getConstraints()) {
				if (constraint instanceof JvmUpperBound) {
					upperBoundSeen = true;
					if (typeConformanceComputer.isConformant(constraint.getTypeReference(), first, true))
						return true;
				}
			}
			if (!upperBoundSeen) {
				if (typeReferences.is(first, Object.class)) {
					return true;
				}
			}
		}
		return false;
	}
}
