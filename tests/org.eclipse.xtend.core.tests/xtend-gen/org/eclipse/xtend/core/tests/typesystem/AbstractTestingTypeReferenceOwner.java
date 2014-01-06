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
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
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
  
  private OwnedConverter owner = new OwnedConverter(this);
  
  public LightweightTypeReference toLightweightReference(final JvmTypeReference reference) {
    return this.owner.toLightweightReference(reference);
  }
  
  @After
  public void tearDown() {
    this.contextResourceSet = null;
  }
  
  protected XtendFunction function(final String string) throws Exception {
    final XtendFunction result = super.function(string);
    Resource _eResource = result.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    this.contextResourceSet = _resourceSet;
    return result;
  }
  
  public void acceptHint(final Object handle, final LightweightBoundTypeArgument boundTypeArgument) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
  
  public List<LightweightBoundTypeArgument> getAllHints(final Object handle) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
  
  public List<JvmTypeParameter> getDeclaredTypeParameters() {
    return CollectionLiterals.<JvmTypeParameter>emptyList();
  }
  
  public ResourceSet getContextResourceSet() {
    return this.contextResourceSet;
  }
  
  public CommonTypeComputationServices getServices() {
    return this.services;
  }
  
  public boolean isResolved(final Object handle) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
}
