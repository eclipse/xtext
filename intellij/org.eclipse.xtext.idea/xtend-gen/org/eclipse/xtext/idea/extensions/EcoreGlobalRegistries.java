/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.extensions;

import com.google.common.base.Objects;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.extensions.Extensions;
import java.util.Map;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.idea.extensions.EPackageEP;
import org.eclipse.xtext.idea.extensions.ResourceFactoryDescriptor;
import org.eclipse.xtext.idea.extensions.ResourceFactoryEP;
import org.eclipse.xtext.idea.extensions.ResourceServiceProviderDescriptor;
import org.eclipse.xtext.idea.extensions.ResourceServiceProviderEP;
import org.eclipse.xtext.resource.IResourceServiceProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class EcoreGlobalRegistries {
  public EcoreGlobalRegistries() {
    final EPackage.Registry packageRegistry = EPackage.Registry.INSTANCE;
    EPackageEP[] _extensions = Extensions.<EPackageEP>getExtensions(EPackageEP.EP_NAME);
    for (final EPackageEP it : _extensions) {
      String _nsURI = it.getNsURI();
      EPackageEP _createDescriptor = it.createDescriptor();
      packageRegistry.put(_nsURI, _createDescriptor);
    }
    final Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    ResourceFactoryEP[] _extensions_1 = Extensions.<ResourceFactoryEP>getExtensions(ResourceFactoryEP.EP_NAME);
    for (final ResourceFactoryEP it_1 : _extensions_1) {
      String _type = it_1.getType();
      ResourceFactoryDescriptor _createDescriptor_1 = it_1.createDescriptor();
      extensionToFactoryMap.put(_type, _createDescriptor_1);
    }
    final IResourceServiceProvider.Registry registry = IResourceServiceProvider.Registry.INSTANCE;
    ResourceServiceProviderEP[] _extensions_2 = Extensions.<ResourceServiceProviderEP>getExtensions(ResourceServiceProviderEP.EP_NAME);
    for (final ResourceServiceProviderEP it_2 : _extensions_2) {
      {
        String _uriExtension = it_2.getUriExtension();
        boolean _notEquals = (!Objects.equal(_uriExtension, null));
        if (_notEquals) {
          Map<String, Object> _extensionToFactoryMap = registry.getExtensionToFactoryMap();
          String _uriExtension_1 = it_2.getUriExtension();
          ResourceServiceProviderDescriptor _createDescriptor_2 = it_2.createDescriptor();
          _extensionToFactoryMap.put(_uriExtension_1, _createDescriptor_2);
        }
        String _protocolName = it_2.getProtocolName();
        boolean _notEquals_1 = (!Objects.equal(_protocolName, null));
        if (_notEquals_1) {
          Map<String, Object> _protocolToFactoryMap = registry.getProtocolToFactoryMap();
          String _protocolName_1 = it_2.getProtocolName();
          ResourceServiceProviderDescriptor _createDescriptor_3 = it_2.createDescriptor();
          _protocolToFactoryMap.put(_protocolName_1, _createDescriptor_3);
        }
        String _contentTypeIdentifier = it_2.getContentTypeIdentifier();
        boolean _notEquals_2 = (!Objects.equal(_contentTypeIdentifier, null));
        if (_notEquals_2) {
          Map<String, Object> _contentTypeToFactoryMap = registry.getContentTypeToFactoryMap();
          String _contentTypeIdentifier_1 = it_2.getContentTypeIdentifier();
          ResourceServiceProviderDescriptor _createDescriptor_4 = it_2.createDescriptor();
          _contentTypeToFactoryMap.put(_contentTypeIdentifier_1, _createDescriptor_4);
        }
      }
    }
  }
  
  public static EcoreGlobalRegistries ensureInitialized() {
    Application _application = ApplicationManager.getApplication();
    return _application.<EcoreGlobalRegistries>getComponent(EcoreGlobalRegistries.class);
  }
}
