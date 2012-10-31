/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeParameterSubstitutorTest;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseNewTypeSystemInjectorProvider.class)
@SuppressWarnings("all")
public class LightweightTypeParameterSubstitutorTest extends AbstractTypeParameterSubstitutorTest implements ITypeReferenceOwner {
  @Inject
  private CommonTypeComputationServices services;
  
  private OwnedConverter _ownedConverter = new Function0<OwnedConverter>() {
    public OwnedConverter apply() {
      OwnedConverter _ownedConverter = new OwnedConverter(LightweightTypeParameterSubstitutorTest.this);
      return _ownedConverter;
    }
  }.apply();
  
  public String resolve(final JvmTypeReference declaration, final JvmTypeReference reference) {
    DeclaratorTypeArgumentCollector _declaratorTypeArgumentCollector = new DeclaratorTypeArgumentCollector();
    LightweightTypeReference _lightweightReference = this._ownedConverter.toLightweightReference(declaration);
    final Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> mapping = _declaratorTypeArgumentCollector.getTypeParameterMapping(_lightweightReference);
    StandardTypeParameterSubstitutor _standardTypeParameterSubstitutor = new StandardTypeParameterSubstitutor(mapping, this);
    LightweightTypeReference _lightweightReference_1 = this._ownedConverter.toLightweightReference(reference);
    LightweightTypeReference _substitute = _standardTypeParameterSubstitutor.substitute(_lightweightReference_1);
    return _substitute.toString();
  }
  
  public CommonTypeComputationServices getServices() {
    return this.services;
  }
  
  public void acceptHint(final Object reference, final LightweightBoundTypeArgument boundTypeArgument) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Should not be invoked");
    throw _unsupportedOperationException;
  }
  
  public List<LightweightBoundTypeArgument> getAllHints(final Object reference) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Should not be invoked");
    throw _unsupportedOperationException;
  }
  
  public ResourceSet getContextResourceSet() {
    return this.getContextResourceSet();
  }
  
  public boolean isResolved(final Object handle) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Should not be invoked");
    throw _unsupportedOperationException;
  }
}
