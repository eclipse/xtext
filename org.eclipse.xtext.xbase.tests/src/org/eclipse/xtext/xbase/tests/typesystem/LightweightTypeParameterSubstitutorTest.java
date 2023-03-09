/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow
 */
public class LightweightTypeParameterSubstitutorTest extends AbstractTypeParameterSubstitutorTest {
	@Inject
	private CommonTypeComputationServices services;

	@Override
	public String resolve(JvmTypeReference declaration, JvmTypeReference reference) {
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, declaration.getType());
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = new DeclaratorTypeArgumentCollector()
				.getTypeParameterMapping(owner.toLightweightTypeReference(declaration));
		return new StandardTypeParameterSubstitutor(mapping, owner).substitute(owner.toLightweightTypeReference(reference)).toString();
	}
}
