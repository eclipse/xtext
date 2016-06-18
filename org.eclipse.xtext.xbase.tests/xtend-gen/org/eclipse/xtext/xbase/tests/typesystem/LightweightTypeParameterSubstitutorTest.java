/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
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
    DeclaratorTypeArgumentCollector _declaratorTypeArgumentCollector = new DeclaratorTypeArgumentCollector();
    LightweightTypeReference _lightweightTypeReference = owner.toLightweightTypeReference(declaration);
    final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = _declaratorTypeArgumentCollector.getTypeParameterMapping(_lightweightTypeReference);
    StandardTypeParameterSubstitutor _standardTypeParameterSubstitutor = new StandardTypeParameterSubstitutor(mapping, owner);
    LightweightTypeReference _lightweightTypeReference_1 = owner.toLightweightTypeReference(reference);
    LightweightTypeReference _substitute = _standardTypeParameterSubstitutor.substitute(_lightweightTypeReference_1);
    return _substitute.toString();
  }
}
