/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.legacy;

import java.util.EnumSet;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputationArgument;
import org.eclipse.xtext.common.types.util.TypeConformanceResult;
import org.eclipse.xtext.common.types.util.TypeConformanceResult.Kind;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */

@SuppressWarnings("deprecation")
public class LegacyTypeConformanceComputer extends XbaseTypeConformanceComputer {

	@Inject
	private CommonTypeComputationServices services;
	
	@Override
	public JvmTypeReference getCommonSuperType(List<JvmTypeReference> types) {
		Resource resource = null;
		for(JvmTypeReference type: types) {
			resource = getResource(type);
			if (resource != null) {
				break;
			}
		}
		if (resource == null)
			return super.getCommonSuperType(types);
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, resource);
		OwnedConverter converter = new OwnedConverter(owner);
		List<LightweightTypeReference> lightweightTypes = Lists.newArrayListWithCapacity(types.size());
		for(JvmTypeReference type: types) {
			lightweightTypes.add(converter.toLightweightReference(type));
		}
		LightweightTypeReference result = services.getTypeConformanceComputer().getCommonSuperType(lightweightTypes, owner);
		if (result == null) {
			return null;
		}
		return result.toTypeReference();
	}
	
	@Override
	public TypeConformanceResult isConformant(JvmTypeReference left, JvmTypeReference right, TypeConformanceComputationArgument flags) {
		Resource resource = getResource(left);
		if (resource == null) {
			resource = getResource(right);
		}
		if (resource == null)
			return super.isConformant(left, right, flags);
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, resource);
		OwnedConverter converter = new OwnedConverter(owner);
		LightweightTypeReference leftLightweight = converter.toLightweightReference(left);
		LightweightTypeReference rightLightweight = converter.toLightweightReference(right);
		org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceResult result = leftLightweight.internalIsAssignableFrom(rightLightweight, new org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument(
				flags.isRawType(), flags.isAsTypeArgument(), flags.isAllowPrimitiveConversion(), true, false, true));
		EnumSet<Kind> hints = EnumSet.noneOf(Kind.class);
		for(ConformanceHint hint: result.getConformanceHints()) {
			switch(hint) {
				case BOXING:
					hints.add(Kind.BOXING);
					break;
				case DEMAND_CONVERSION:
					hints.add(Kind.DEMAND_CONVERSION);
					break;
				case EXCEPTION:
					hints.add(Kind.EXCEPTION);
					break;
				case INCOMPATIBLE:
					hints.add(Kind.FAILED);
					break;
				case PRIMITIVE_WIDENING:
					hints.add(Kind.PRIMITIVE_WIDENING);
					break;
				case SUBTYPE:
					hints.add(Kind.SUBTYPE);
					break;
				case SUCCESS:
					hints.add(Kind.SUCCESS);
					break;
				case SYNONYM:
					hints.add(Kind.SYNONYM);
					break;
				case UNBOXING:
					hints.add(Kind.UNBOXING);
					break;
				default:
					break;
			}
		}
		return new TypeConformanceResult(hints, null);
	}
	
	protected Resource getResource(JvmTypeReference reference) {
		if (reference.eResource() != null)
			return reference.eResource();
		JvmType type = reference.getType();
		if (type != null && type.eResource() != null) {
			return type.eResource();
		}
		return null;
	}
	
}
