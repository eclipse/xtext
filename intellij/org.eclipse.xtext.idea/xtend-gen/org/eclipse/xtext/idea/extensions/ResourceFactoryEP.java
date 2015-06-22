/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.extensions;

import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.util.xmlb.annotations.Attribute;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.extensions.AbstractExecutableExtensionPoint;
import org.eclipse.xtext.idea.extensions.ResourceFactoryDescriptor;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceFactoryEP extends AbstractExecutableExtensionPoint {
  public final static ExtensionPointName<ResourceFactoryEP> EP_NAME = ExtensionPointName.<ResourceFactoryEP>create(
    "org.eclipse.xtext.idea.resourceFactory");
  
  @Attribute("type")
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String type;
  
  public ResourceFactoryDescriptor createDescriptor() {
    return new ResourceFactoryDescriptor(this);
  }
  
  @Pure
  public String getType() {
    return this.type;
  }
}
