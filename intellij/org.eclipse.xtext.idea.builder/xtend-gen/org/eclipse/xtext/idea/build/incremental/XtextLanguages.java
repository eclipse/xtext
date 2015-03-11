package org.eclipse.xtext.idea.build.incremental;

import com.google.inject.Injector;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jetbrains.jps.service.JpsServiceManager;

@SuppressWarnings("all")
public class XtextLanguages {
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
      final HashMap<String, LanguageAccess> result = CollectionLiterals.<String, LanguageAccess>newHashMap();
      JpsServiceManager _instance = JpsServiceManager.getInstance();
      Iterable<ISetup> _extensions = _instance.<ISetup>getExtensions(ISetup.class);
      for (final ISetup setup : _extensions) {
        {
          final Injector injector = setup.createInjectorAndDoEMFRegistration();
          final LanguageAccess languageAccess = XtextLanguages.createXtendLanguageAccess(injector);
          FileExtensionProvider _instance_1 = injector.<FileExtensionProvider>getInstance(FileExtensionProvider.class);
          Set<String> _fileExtensions = _instance_1.getFileExtensions();
          for (final String fileExtension : _fileExtensions) {
            result.put(fileExtension, languageAccess);
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static LanguageAccess createXtendLanguageAccess(final Injector injector) {
    final IOutputConfigurationProvider outputConfigurationProvider = injector.<IOutputConfigurationProvider>getInstance(IOutputConfigurationProvider.class);
    final IResourceServiceProvider resourceServiceProvider = injector.<IResourceServiceProvider>getInstance(IResourceServiceProvider.class);
    Set<OutputConfiguration> _outputConfigurations = outputConfigurationProvider.getOutputConfigurations();
    Set<OutputConfiguration> _set = IterableExtensions.<OutputConfiguration>toSet(_outputConfigurations);
    return new LanguageAccess(_set, resourceServiceProvider, true);
  }
}
