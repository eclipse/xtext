/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.validation;

import static org.eclipse.xtend.core.validation.IssueCodes.*;
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.validation.JvmGenericTypeValidator;

/**
 * A specialization of {@link JvmGenericTypeValidator} to deal with specific features of Xtend.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 * @author Sebastian Zarnekow - Author of the original Java code in XtendValidator extracted here.
 */
public class XtendJvmGenericTypeValidator extends JvmGenericTypeValidator {

	@Override
	protected void doCheckFunctionOverrides(IResolvedOperation operation, Set<EObject> flaggedOperations) {
		super.doCheckFunctionOverrides(operation, flaggedOperations);
		EObject sourceElement = findPrimarySourceElement(operation);
		if (sourceElement != null) {
			List<IResolvedOperation> allInherited = operation.getOverriddenAndImplementedMethods();
			if (allInherited.isEmpty()) {
				if (sourceElement instanceof XtendFunction && flaggedOperations.add(sourceElement)) {
					XtendFunction function = (XtendFunction) sourceElement;
					if (function.isOverride()) {
						error("The method "+ operation.getSimpleSignature() +" of type "+getDeclaratorName(operation.getDeclaration())+" must override a superclass method.", 
								function, XTEND_MEMBER__MODIFIERS, function.getModifiers().indexOf("override"), OBSOLETE_OVERRIDE);
					} else {
						for (XAnnotation anno : function.getAnnotations()) {
							if (anno != null && anno.getAnnotationType() != null && Override.class.getName().equals(anno.getAnnotationType().getIdentifier())) {
								error("Superfluous @Override annotation", anno, null, OBSOLETE_ANNOTATION_OVERRIDE);
							}
						}
					}
				}
			}
		}
	}

	@Override
	protected void doCheckFunctionOverrides(EObject sourceElement, IResolvedOperation resolved,
			List<IResolvedOperation> allInherited) {
		super.doCheckFunctionOverrides(sourceElement, resolved, allInherited);
		boolean overrideProblems = false;
		for(IResolvedOperation inherited: allInherited) {
			if (inherited.getOverrideCheckResult().hasProblems()) {
				overrideProblems = true;
				break;
			}
		}
		if (sourceElement instanceof XtendFunction) {
			XtendFunction function = (XtendFunction) sourceElement;
			if (!overrideProblems && !function.isOverride() && !function.isStatic()) {
				error("The method " + resolved.getSimpleSignature() + " of type " + getDeclaratorName(resolved) +
						" must use override keyword since it actually overrides a supertype method.", function,
						XTEND_FUNCTION__NAME, MISSING_OVERRIDE);
			} 
			if (!overrideProblems && function.isOverride() && function.isStatic()) {
				for(IResolvedOperation inherited: allInherited) {
					error("The method " + resolved.getSimpleSignature() + " of type " + getDeclaratorName(resolved) + 
							" shadows the method " + resolved.getSimpleSignature() + " of type " + getDeclaratorName(inherited) + 
							", but does not override it.", function, XTEND_FUNCTION__NAME, function.getModifiers().indexOf("override"), OBSOLETE_OVERRIDE);
				}
			}
			if (function.isOverride()) {
				for (XAnnotation anno : function.getAnnotations()) {
					if (anno != null && anno.getAnnotationType() != null && Override.class.getName().equals(anno.getAnnotationType().getIdentifier())) {
						warning("Superfluous @Override annotation", anno, null, OBSOLETE_ANNOTATION_OVERRIDE);
					}
				}
			}
		}
	}
}
