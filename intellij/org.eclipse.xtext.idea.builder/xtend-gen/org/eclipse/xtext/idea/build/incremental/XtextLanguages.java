package org.eclipse.xtext.idea.build.incremental;

import com.google.inject.Injector;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

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
    LanguageAccess _createXtendLanguageAccess = XtextLanguages.createXtendLanguageAccess();
    Pair<String, LanguageAccess> _mappedTo = Pair.<String, LanguageAccess>of("xtend", _createXtendLanguageAccess);
    return Collections.<String, LanguageAccess>unmodifiableMap(CollectionLiterals.<String, LanguageAccess>newHashMap(_mappedTo));
  }
  
  public static LanguageAccess createXtendLanguageAccess() {
    XtendStandaloneSetup _xtendStandaloneSetup = new XtendStandaloneSetup();
    final Injector injector = _xtendStandaloneSetup.createInjectorAndDoEMFRegistration();
    final IOutputConfigurationProvider outputConfigurationProvider = injector.<IOutputConfigurationProvider>getInstance(IOutputConfigurationProvider.class);
    final IResourceServiceProvider resourceServiceProvider = injector.<IResourceServiceProvider>getInstance(IResourceServiceProvider.class);
    Set<OutputConfiguration> _outputConfigurations = outputConfigurationProvider.getOutputConfigurations();
    Set<OutputConfiguration> _set = IterableExtensions.<OutputConfiguration>toSet(_outputConfigurations);
    return new LanguageAccess(_set, resourceServiceProvider, true);
  }
}
