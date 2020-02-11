/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.Map;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeParameterSubstitutorTest;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class LightweightTypeParameterSubstitutorTest extends AbstractTypeParameterSubstitutorTest {
  @Inject
  private CommonTypeComputationServices services;
  
  @Override
  public String resolve(final JvmTypeReference declaration, final JvmTypeReference reference) {
    JvmType _type = declaration.getType();
    @Extension
    final StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(this.services, _type);
    final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(owner.toLightweightTypeReference(declaration));
    return new StandardTypeParameterSubstitutor(mapping, owner).substitute(owner.toLightweightTypeReference(reference)).toString();
  }
}
