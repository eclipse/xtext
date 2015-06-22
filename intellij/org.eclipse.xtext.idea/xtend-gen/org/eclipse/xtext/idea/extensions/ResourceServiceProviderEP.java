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
import org.eclipse.xtext.idea.extensions.ResourceServiceProviderDescriptor;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceServiceProviderEP extends AbstractExecutableExtensionPoint {
  public final static ExtensionPointName<ResourceServiceProviderEP> EP_NAME = ExtensionPointName.<ResourceServiceProviderEP>create(
    "org.eclipse.xtext.idea.resourceServiceProvider");
  
  @Attribute("uriExtension")
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String uriExtension;
  
  @Attribute("protocolName")
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String protocolName;
  
  @Attribute("contentTypeIdentifier")
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String contentTypeIdentifier;
  
  public ResourceServiceProviderDescriptor createDescriptor() {
    return new ResourceServiceProviderDescriptor(this);
  }
  
  @Pure
  public String getUriExtension() {
    return this.uriExtension;
  }
  
  @Pure
  public String getProtocolName() {
    return this.protocolName;
  }
  
  @Pure
  public String getContentTypeIdentifier() {
    return this.contentTypeIdentifier;
  }
}
