/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.shared;

import com.google.common.collect.Iterables;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class XtextLanguages {
  private final static Logger LOG = Logger.getLogger(XtextLanguages.class);
  
  private Map<String, LanguageAccess> languageAccesses;
  
  public synchronized Map<String, LanguageAccess> getLanguageAccesses() {
    Map<String, LanguageAccess> _elvis = null;
    if (this.languageAccesses != null) {
      _elvis = this.languageAccesses;
    } else {
      Map<String, LanguageAccess> _createLanguageAccesses = this.createLanguageAccesses();
      _elvis = (this.languageAccesses = _createLanguageAccesses);
    }
    return _elvis;
  }
  
  private Map<String, LanguageAccess> createLanguageAccesses() {
    HashMap<String, LanguageAccess> _xblockexpression = null;
    {
      XtextLanguages.LOG.info("Initializing Xtext languages...");
      final HashMap<String, LanguageAccess> result = CollectionLiterals.<String, LanguageAccess>newHashMap();
      Map<String, Object> _extensionToFactoryMap = IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap();
      Collection<Object> _values = _extensionToFactoryMap.values();
      Iterable<IResourceServiceProvider> _filter = Iterables.<IResourceServiceProvider>filter(_values, IResourceServiceProvider.class);
      for (final IResourceServiceProvider rsp : _filter) {
        {
          final LanguageAccess languageAccess = this.createLanguageAccess(rsp);
          FileExtensionProvider _get = rsp.<FileExtensionProvider>get(FileExtensionProvider.class);
          Set<String> _fileExtensions = _get.getFileExtensions();
          for (final String fileExtension : _fileExtensions) {
            result.put(fileExtension, languageAccess);
          }
        }
      }
      XtextLanguages.LOG.info("...done.");
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  private LanguageAccess createLanguageAccess(final IResourceServiceProvider resourceServiceProvider) {
    final IOutputConfigurationProvider outputConfigurationProvider = resourceServiceProvider.<IOutputConfigurationProvider>get(IOutputConfigurationProvider.class);
    Set<OutputConfiguration> _outputConfigurations = outputConfigurationProvider.getOutputConfigurations();
    Set<OutputConfiguration> _set = IterableExtensions.<OutputConfiguration>toSet(_outputConfigurations);
    return new LanguageAccess(_set, resourceServiceProvider, 
      true);
  }
}
