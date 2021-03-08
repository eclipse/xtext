/**
 * Copyright (c) 2016, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.validation;

import java.util.List;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithResult;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
public class ReferencedInvalidTypeFinder extends TypeReferenceVisitorWithResult<LightweightTypeReference> {
	@Inject
	private CommonTypeComputationServices services;

	public LightweightTypeReference findReferencedInvalidType(JvmIdentifiableElement element) {
		return internalFindReferencedInvalidType(element);
	}

	protected LightweightTypeReference _internalFindReferencedInvalidType(JvmIdentifiableElement field) {
		return null;
	}

	protected LightweightTypeReference _internalFindReferencedInvalidType(Void field) {
		return null;
	}

	protected LightweightTypeReference _internalFindReferencedInvalidType(JvmField field) {
		LightweightTypeReference type = toLightweightTypeReference(field.getType());
		if (type.isPrimitiveVoid()) {
			return type;
		}
		return findUnknownType(type);
	}

	protected LightweightTypeReference _internalFindReferencedInvalidType(JvmOperation operation) {
		LightweightTypeReference unknownType = findUnknownType(operation.getReturnType());
		if (unknownType != null) {
			return unknownType;
		}
		return _internalFindReferencedInvalidType((JvmExecutable) operation);
	}

	protected LightweightTypeReference _internalFindReferencedInvalidType(JvmExecutable executable) {
		Iterable<JvmTypeReference> typeReferences = Iterables.transform(
				Iterables.concat(Lists.transform(executable.getTypeParameters(), JvmTypeParameter::getConstraints)),
				JvmTypeConstraint::getTypeReference);
		for (JvmTypeReference typeReference : typeReferences) {
			LightweightTypeReference unknownType = findUnknownType(typeReference);
			if (unknownType != null) {
				return unknownType;
			}
		}
		for (LightweightTypeReference parameterType : Lists.transform(executable.getParameters(),
				it -> toLightweightTypeReference(it.getParameterType()))) {
			if (parameterType.isPrimitiveVoid()) {
				return parameterType;
			}
			LightweightTypeReference unknownType = findUnknownType(parameterType);
			if (unknownType != null) {
				return unknownType;
			}
		}
		for (JvmTypeReference exception : executable.getExceptions()) {
			LightweightTypeReference unknownType = findUnknownType(exception);
			if (unknownType != null) {
				return unknownType;
			}
		}
		return null;
	}

	protected LightweightTypeReference findUnknownType(JvmTypeReference reference) {
		return findUnknownType(toLightweightTypeReference(reference));
	}

	protected LightweightTypeReference findUnknownType(LightweightTypeReference type) {
		return type.accept(this);
	}

	@Override
	protected LightweightTypeReference doVisitTypeReference(LightweightTypeReference reference) {
		if (reference.isUnknown()) {
			return reference;
		}
		return null;
	}

	@Override
	protected LightweightTypeReference doVisitArrayTypeReference(ArrayTypeReference reference) {
		return reference.getComponentType().accept(this);
	}

	@Override
	protected LightweightTypeReference doVisitWildcardTypeReference(WildcardTypeReference reference) {
		LightweightTypeReference unknownType = visit(reference.getUpperBounds());
		if (unknownType != null) {
			return unknownType;
		}
		LightweightTypeReference lowerBound = reference.getLowerBound();
		if (lowerBound != null) {
			return lowerBound.accept(this);
		}
		return null;
	}

	@Override
	protected LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
		return visit(reference.getTypeArguments());
	}

	@Override
	protected LightweightTypeReference doVisitCompoundTypeReference(CompoundTypeReference reference) {
		return visit(reference.getMultiTypeComponents());
	}

	protected LightweightTypeReference visit(List<LightweightTypeReference> references) {
		return Iterables
				.getFirst(IterableExtensions.filterNull(
						Lists.transform(references, it -> it.accept(this))), null);
	}

	protected LightweightTypeReference toLightweightTypeReference(JvmTypeReference typeRef) {
		return new StandardTypeReferenceOwner(services, typeRef).toLightweightTypeReference(typeRef);
	}

	protected LightweightTypeReference internalFindReferencedInvalidType(JvmIdentifiableElement operation) {
		if (operation instanceof JvmOperation) {
			return _internalFindReferencedInvalidType((JvmOperation) operation);
		} else if (operation instanceof JvmExecutable) {
			return _internalFindReferencedInvalidType((JvmExecutable) operation);
		} else if (operation instanceof JvmField) {
			return _internalFindReferencedInvalidType((JvmField) operation);
		} else if (operation != null) {
			return _internalFindReferencedInvalidType(operation);
		} else {
			return _internalFindReferencedInvalidType((Void) null);
		}
	}
}
