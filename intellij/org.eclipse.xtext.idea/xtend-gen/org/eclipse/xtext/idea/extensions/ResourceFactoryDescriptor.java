/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.extensions;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.extensions.AbstractExecutableExtensionPoint;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class ResourceFactoryDescriptor implements Resource.Factory.Descriptor {
  private final AbstractExecutableExtensionPoint extensionPoint;
  
  private Resource.Factory factory;
  
  @Override
  public Resource.Factory createFactory() {
    boolean _equals = Objects.equal(this.factory, null);
    if (_equals) {
      Object _createInstance = this.extensionPoint.createInstance();
      this.factory = ((Resource.Factory) _createInstance);
    }
    return this.factory;
  }
  
  public ResourceFactoryDescriptor(final AbstractExecutableExtensionPoint extensionPoint) {
    super();
    this.extensionPoint = extensionPoint;
  }
}
