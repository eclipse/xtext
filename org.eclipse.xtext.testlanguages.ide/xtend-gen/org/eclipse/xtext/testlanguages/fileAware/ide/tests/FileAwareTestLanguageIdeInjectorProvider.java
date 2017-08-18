package org.eclipse.xtext.testlanguages.fileAware.ide.tests;

import com.google.inject.Injector;
import org.eclipse.xtext.testlanguages.fileAware.ide.FileAwareTestLanguageIdeSetup;
import org.eclipse.xtext.testlanguages.fileAware.tests.FileAwareTestLanguageInjectorProvider;

@SuppressWarnings("all")
public class FileAwareTestLanguageIdeInjectorProvider extends FileAwareTestLanguageInjectorProvider {
  @Override
  public Injector internalCreateInjector() {
    return new FileAwareTestLanguageIdeSetup().createInjectorAndDoEMFRegistration();
  }
}
