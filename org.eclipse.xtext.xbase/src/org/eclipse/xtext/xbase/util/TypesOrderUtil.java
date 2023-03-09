/*******************************************************************************
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.util;

import static org.eclipse.xtext.xbase.typesystem.conformance.RawTypeConformanceComputer.*;

import java.util.Collection;

import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

/**
 * Small utility class that allows to check whether a given type was already handled in a chain
 * of instanceof checks, e.g to validate catch-clauses or switch expressions.
 * 
 * @author Anton Kosyakov - Initial contribution and API
 */
public class TypesOrderUtil {

	@Inject
	private CommonTypeComputationServices services;

	public boolean isHandled(LightweightTypeReference actualTypeReference, Collection<LightweightTypeReference> collection) {
		for (LightweightTypeReference previousTypeReference : collection) {
			if (isHandled(actualTypeReference, previousTypeReference)) {
				return true;
			}
		}
		return false;
	}

	public boolean isHandled(LightweightTypeReference actualTypeReference, LightweightTypeReference previousTypeReference) {
		TypeConformanceComputer typeConformanceComputer = services.getTypeConformanceComputer();
		int conformant = typeConformanceComputer.isConformant(previousTypeReference, actualTypeReference,
			ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_RAW_TYPE_CONVERSION);
		return (conformant & SUCCESS) != 0;
	}

}
