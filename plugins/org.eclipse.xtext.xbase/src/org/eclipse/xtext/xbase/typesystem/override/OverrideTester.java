/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;

/**
 * 
 * The implemented algorithm pretty much mirrors the one from
 * class <code>org.eclipse.jdt.internal.corext.util.MethodOverrideTester</code>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OverrideTester {

	public IOverrideCheckResult isSubsignature(IResolvedOperation overriding, JvmOperation overridden, boolean checkInheritance, boolean checkVisibility) {
		JvmOperation declaration = overriding.getDeclaration();
		if (declaration == overridden) {
			return new StandardOverrideCheckResult(overriding, overridden, OverrideCheckDetails.CURRENT);
		}
		if (overridden.getDeclaringType() == declaration.getDeclaringType()) {
			return new StandardOverrideCheckResult(overriding, overridden, OverrideCheckDetails.SAME_DECLARATOR);
		}
		if (checkInheritance) {
			ParameterizedTypeReference currentDeclarator = new ParameterizedTypeReference(overriding.getContextType().getOwner(), declaration.getDeclaringType());
			if (!currentDeclarator.isSubtypeOf(overridden.getDeclaringType())) {
				return new StandardOverrideCheckResult(overriding, overridden, OverrideCheckDetails.NO_INHERITANCE);	
			}
		}
		if (!Strings.equal(overridden.getSimpleName(), declaration.getSimpleName()) || overridden.getParameters().size() != declaration.getParameters().size()) {
			return new StandardOverrideCheckResult(overriding, overridden, OverrideCheckDetails.NAME_OR_ARITY_MISMATCH);
		}
		// TODO implement 'real' super type check
		
		// so far we use a dummy impl and assume that
		// everything is ok and we simply compute whether this is a redefinition, an override or an implementation
		OverrideCheckDetails result = OverrideCheckDetails.IMPLEMENTATION;
		if (declaration.isAbstract()) {
			if (overridden.isAbstract()) {
				result = OverrideCheckDetails.REPEATED;
			} else {
				result = OverrideCheckDetails.REDECLARATION;
			}
		} else {
			if (!overridden.isAbstract()) {
				result = OverrideCheckDetails.OVERRIDE;
			}
		}
		return new StandardOverrideCheckResult(overriding, overridden, result);		
	}
	
}
