/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import com.google.common.collect.ForwardingObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * An abstract implementation of {@link IEObjectDescription} that delegates all
 * method invocations to another instance. Suitable to override and specialize
 * behavior.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public abstract class ForwardingEObjectDescription extends ForwardingObject implements IEObjectDescription {
  @Delegate
  private final IEObjectDescription delegate;
  
  @Override
  protected Object delegate() {
    return this.delegate;
  }
  
  @Override
  public String toString() {
    return (("ForwardingEObjectDescription[" + this.delegate) + "]");
  }
  
  public ForwardingEObjectDescription(final IEObjectDescription delegate) {
    super();
    this.delegate = delegate;
  }
  
  public EClass getEClass() {
    return this.delegate.getEClass();
  }
  
  public EObject getEObjectOrProxy() {
    return this.delegate.getEObjectOrProxy();
  }
  
  public URI getEObjectURI() {
    return this.delegate.getEObjectURI();
  }
  
  public QualifiedName getName() {
    return this.delegate.getName();
  }
  
  public QualifiedName getQualifiedName() {
    return this.delegate.getQualifiedName();
  }
  
  public String getUserData(final String key) {
    return this.delegate.getUserData(key);
  }
  
  public String[] getUserDataKeys() {
    return this.delegate.getUserDataKeys();
  }
}
