/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.After;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractTestingTypeReferenceOwner extends AbstractXtendTestCase {
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private CommonTypeComputationServices services;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  private ResourceSet contextResourceSet;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  private ITypeReferenceOwner owner;
  
  @After
  public void tearDown() {
    this.contextResourceSet = null;
  }
  
  public LightweightTypeReference toLightweightTypeReference(final JvmTypeReference reference) {
    return this.owner.toLightweightTypeReference(reference);
  }
  
  @Override
  protected XtendFunction function(final String string) throws Exception {
    final XtendFunction result = super.function(string);
    Resource _eResource = result.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    this.contextResourceSet = _resourceSet;
    StandardTypeReferenceOwner _createOwner = this.createOwner();
    this.owner = _createOwner;
    return result;
  }
  
  protected StandardTypeReferenceOwner createOwner() {
    return new StandardTypeReferenceOwner(this.services, this.contextResourceSet);
  }
  
  @Pure
  protected CommonTypeComputationServices getServices() {
    return this.services;
  }
  
  @Pure
  protected ResourceSet getContextResourceSet() {
    return this.contextResourceSet;
  }
  
  @Pure
  protected ITypeReferenceOwner getOwner() {
    return this.owner;
  }
}
