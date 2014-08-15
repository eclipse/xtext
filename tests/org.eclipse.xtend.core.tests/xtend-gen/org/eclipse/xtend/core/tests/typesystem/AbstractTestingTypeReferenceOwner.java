/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.InnerFunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.InnerTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.After;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractTestingTypeReferenceOwner extends AbstractXtendTestCase implements ITypeReferenceOwner {
  @Inject
  private CommonTypeComputationServices services;
  
  private ResourceSet contextResourceSet;
  
  @Delegate
  private ITypeReferenceOwner owner;
  
  @After
  public void tearDown() {
    this.contextResourceSet = null;
  }
  
  protected XtendFunction function(final String string) throws Exception {
    final XtendFunction result = super.function(string);
    Resource _eResource = result.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    this.contextResourceSet = _resourceSet;
    StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, this.contextResourceSet);
    this.owner = _standardTypeReferenceOwner;
    return result;
  }
  
  public boolean isResolved(final Object handle) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
  
  public void acceptHint(final Object handle, final LightweightBoundTypeArgument boundTypeArgument) {
    this.owner.acceptHint(handle, boundTypeArgument);
  }
  
  public List<LightweightBoundTypeArgument> getAllHints(final Object handle) {
    return this.owner.getAllHints(handle);
  }
  
  public ResourceSet getContextResourceSet() {
    return this.owner.getContextResourceSet();
  }
  
  public List<JvmTypeParameter> getDeclaredTypeParameters() {
    return this.owner.getDeclaredTypeParameters();
  }
  
  public CommonTypeComputationServices getServices() {
    return this.owner.getServices();
  }
  
  public AnyTypeReference newAnyTypeReference() {
    return this.owner.newAnyTypeReference();
  }
  
  public ArrayTypeReference newArrayTypeReference(final LightweightTypeReference componentTypeReference) {
    return this.owner.newArrayTypeReference(componentTypeReference);
  }
  
  public CompoundTypeReference newCompoundTypeReference(final boolean synonym) {
    return this.owner.newCompoundTypeReference(synonym);
  }
  
  public FunctionTypeReference newFunctionTypeReference(final JvmType type) {
    return this.owner.newFunctionTypeReference(type);
  }
  
  public InnerFunctionTypeReference newFunctionTypeReference(final LightweightTypeReference outer, final JvmType type) {
    return this.owner.newFunctionTypeReference(outer, type);
  }
  
  public ParameterizedTypeReference newParameterizedTypeReference(final JvmType type) {
    return this.owner.newParameterizedTypeReference(type);
  }
  
  public InnerTypeReference newParameterizedTypeReference(final LightweightTypeReference outer, final JvmType type) {
    return this.owner.newParameterizedTypeReference(outer, type);
  }
  
  public UnknownTypeReference newUnknownTypeReference() {
    return this.owner.newUnknownTypeReference();
  }
  
  public UnknownTypeReference newUnknownTypeReference(final String name) {
    return this.owner.newUnknownTypeReference(name);
  }
  
  public WildcardTypeReference newWildcardTypeReference() {
    return this.owner.newWildcardTypeReference();
  }
  
  public LightweightTypeReference toLightweightTypeReference(final JvmType type) {
    return this.owner.toLightweightTypeReference(type);
  }
  
  public LightweightTypeReference toLightweightTypeReference(final JvmTypeReference type) {
    return this.owner.toLightweightTypeReference(type);
  }
  
  public LightweightTypeReference toPlainTypeReference(final JvmType type) {
    return this.owner.toPlainTypeReference(type);
  }
  
  public LightweightTypeReference toPlainTypeReference(final JvmTypeReference type) {
    return this.owner.toPlainTypeReference(type);
  }
}
