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
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.core.jvmmodel.DispatchHelper;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.validation.JvmGenericTypeValidator;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * A specialization of {@link JvmGenericTypeValidator} to deal with specific features of Xtend.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 * @author Sebastian Zarnekow - Author of the original Java code in XtendValidator extracted here.
 */
public class XtendJvmGenericTypeValidator extends JvmGenericTypeValidator {
	@Inject
	private DispatchHelper dispatchHelper;

	@Override
	protected void checkMemberNamesAreUnique(JvmGenericType genericType) {
		super.checkMemberNamesAreUnique(genericType);
		var primarySourceElement = getPrimarySourceElement(genericType);
		if (primarySourceElement instanceof XtendTypeDeclaration) {
			XtendTypeDeclaration xtendType = (XtendTypeDeclaration) primarySourceElement;
			final Multimap<JvmType, XtendField> type2extension = HashMultimap.create();
			for (XtendMember member : xtendType.getMembers()) {
				if (member instanceof XtendField) {
					XtendField field = (XtendField) member;
					if (isEmpty(field.getName())) {
						if (field.isExtension()) {
							JvmTypeReference typeReference = field.getType();
							if (typeReference != null) {
								JvmType type = typeReference.getType();
								if (type != null)
									type2extension.put(type, field);
							}
						}
					}
				}
			}
			for(JvmType type: type2extension.keySet()) {
				Collection<XtendField> fields = type2extension.get(type);
				if(fields.size() >1) {
					for(XtendField field: fields)
						error("Duplicate extension with same type", field, XTEND_FIELD__TYPE, DUPLICATE_FIELD);
				}
			}
		}
	}

	@Override
	protected void checkFunctionOverrides(IResolvedOperation operation, Set<EObject> flaggedOperations) {
		super.checkFunctionOverrides(operation, flaggedOperations);
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
	protected void checkFunctionOverrides(EObject sourceElement, IResolvedOperation resolved,
			List<IResolvedOperation> allInherited) {
		super.checkFunctionOverrides(sourceElement, resolved, allInherited);
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

	@Override
	protected EStructuralFeature returnTypeFeature(EObject member, IResolvedOperation resolved) {
		var returnTypeFeature = super.returnTypeFeature(member, resolved);
		if (returnTypeFeature == null && member instanceof XtendField) // e.g., for an active annotation like @Accessors
			return XTEND_FIELD__TYPE;
		return returnTypeFeature;
	}

	/**
	 * Dispatcher {@link JvmOperation}s must not be checked by the {@link JvmGenericTypeValidator}.
	 */
	@Override
	protected boolean shouldBeValidated(JvmIdentifiableElement element) {
		if (element instanceof JvmOperation) {
			JvmOperation op = (JvmOperation) element;
			if (dispatchHelper.isDispatcherFunction(op))
				return false;
		}
		return super.shouldBeValidated(element);
	}
}
