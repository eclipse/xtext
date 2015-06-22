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
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class EcoreGlobalRegistries {
  public EcoreGlobalRegistries() {
    final EPackage.Registry packageRegistry = EPackage.Registry.INSTANCE;
    EPackageEP[] _extensions = Extensions.<EPackageEP>getExtensions(EPackageEP.EP_NAME);
    final Procedure1<EPackageEP> _function = new Procedure1<EPackageEP>() {
      @Override
      public void apply(final EPackageEP it) {
        String _nsURI = it.getNsURI();
        EPackageEP _createDescriptor = it.createDescriptor();
        packageRegistry.put(_nsURI, _createDescriptor);
      }
    };
    IterableExtensions.<EPackageEP>forEach(((Iterable<EPackageEP>)Conversions.doWrapArray(_extensions)), _function);
    final Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    ResourceFactoryEP[] _extensions_1 = Extensions.<ResourceFactoryEP>getExtensions(ResourceFactoryEP.EP_NAME);
    final Procedure1<ResourceFactoryEP> _function_1 = new Procedure1<ResourceFactoryEP>() {
      @Override
      public void apply(final ResourceFactoryEP it) {
        String _type = it.getType();
        ResourceFactoryDescriptor _createDescriptor = it.createDescriptor();
        extensionToFactoryMap.put(_type, _createDescriptor);
      }
    };
    IterableExtensions.<ResourceFactoryEP>forEach(((Iterable<ResourceFactoryEP>)Conversions.doWrapArray(_extensions_1)), _function_1);
    final IResourceServiceProvider.Registry registry = IResourceServiceProvider.Registry.INSTANCE;
    ResourceServiceProviderEP[] _extensions_2 = Extensions.<ResourceServiceProviderEP>getExtensions(ResourceServiceProviderEP.EP_NAME);
    final Procedure1<ResourceServiceProviderEP> _function_2 = new Procedure1<ResourceServiceProviderEP>() {
      @Override
      public void apply(final ResourceServiceProviderEP it) {
        String _uriExtension = it.getUriExtension();
        boolean _notEquals = (!Objects.equal(_uriExtension, null));
        if (_notEquals) {
          Map<String, Object> _extensionToFactoryMap = registry.getExtensionToFactoryMap();
          String _uriExtension_1 = it.getUriExtension();
          ResourceServiceProviderDescriptor _createDescriptor = it.createDescriptor();
          _extensionToFactoryMap.put(_uriExtension_1, _createDescriptor);
        }
        String _protocolName = it.getProtocolName();
        boolean _notEquals_1 = (!Objects.equal(_protocolName, null));
        if (_notEquals_1) {
          Map<String, Object> _protocolToFactoryMap = registry.getProtocolToFactoryMap();
          String _protocolName_1 = it.getProtocolName();
          ResourceServiceProviderDescriptor _createDescriptor_1 = it.createDescriptor();
          _protocolToFactoryMap.put(_protocolName_1, _createDescriptor_1);
        }
        String _contentTypeIdentifier = it.getContentTypeIdentifier();
        boolean _notEquals_2 = (!Objects.equal(_contentTypeIdentifier, null));
        if (_notEquals_2) {
          Map<String, Object> _contentTypeToFactoryMap = registry.getContentTypeToFactoryMap();
          String _contentTypeIdentifier_1 = it.getContentTypeIdentifier();
          ResourceServiceProviderDescriptor _createDescriptor_2 = it.createDescriptor();
          _contentTypeToFactoryMap.put(_contentTypeIdentifier_1, _createDescriptor_2);
        }
      }
    };
    IterableExtensions.<ResourceServiceProviderEP>forEach(((Iterable<ResourceServiceProviderEP>)Conversions.doWrapArray(_extensions_2)), _function_2);
  }
  
  public static EcoreGlobalRegistries ensureInitialized() {
    Application _application = ApplicationManager.getApplication();
    return _application.<EcoreGlobalRegistries>getComponent(EcoreGlobalRegistries.class);
  }
}
