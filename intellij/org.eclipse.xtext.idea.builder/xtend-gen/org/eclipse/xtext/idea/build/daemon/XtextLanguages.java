/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import com.google.inject.Injector;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jetbrains.jps.service.JpsServiceManager;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextLanguages {
  private final static Logger LOG = Logger.getLogger(XtextLanguages.class);
  
  private static Map<String, LanguageAccess> languageAccesses;
  
  public static Map<String, LanguageAccess> getLanguageAccesses() {
    Map<String, LanguageAccess> _elvis = null;
    if (XtextLanguages.languageAccesses != null) {
      _elvis = XtextLanguages.languageAccesses;
    } else {
      Map<String, LanguageAccess> _createLanguageAccesses = XtextLanguages.createLanguageAccesses();
      _elvis = (XtextLanguages.languageAccesses = _createLanguageAccesses);
    }
    return _elvis;
  }
  
  public static Map<String, LanguageAccess> createLanguageAccesses() {
    HashMap<String, LanguageAccess> _xblockexpression = null;
    {
      XtextLanguages.LOG.info("Initializing Xtext languages...");
      final HashMap<String, LanguageAccess> result = CollectionLiterals.<String, LanguageAccess>newHashMap();
      JpsServiceManager _instance = JpsServiceManager.getInstance();
      Iterable<ISetup> _extensions = _instance.<ISetup>getExtensions(ISetup.class);
      for (final ISetup setup : _extensions) {
        {
          final Injector injector = setup.createInjectorAndDoEMFRegistration();
          final LanguageAccess languageAccess = XtextLanguages.createLanguageAccess(injector);
          FileExtensionProvider _instance_1 = injector.<FileExtensionProvider>getInstance(FileExtensionProvider.class);
          Set<String> _fileExtensions = _instance_1.getFileExtensions();
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
  
  public static LanguageAccess createLanguageAccess(final Injector injector) {
    final IOutputConfigurationProvider outputConfigurationProvider = injector.<IOutputConfigurationProvider>getInstance(IOutputConfigurationProvider.class);
    final IResourceServiceProvider resourceServiceProvider = injector.<IResourceServiceProvider>getInstance(IResourceServiceProvider.class);
    Set<OutputConfiguration> _outputConfigurations = outputConfigurationProvider.getOutputConfigurations();
    Set<OutputConfiguration> _set = IterableExtensions.<OutputConfiguration>toSet(_outputConfigurations);
    return new LanguageAccess(_set, resourceServiceProvider, 
      true);
  }
}
