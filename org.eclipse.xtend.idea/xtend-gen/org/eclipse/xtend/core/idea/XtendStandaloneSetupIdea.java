package org.eclipse.xtend.core.idea;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.eclipse.xtend.core.XtendRuntimeModule;
import org.eclipse.xtend.core.XtendStandaloneSetupGenerated;
import org.eclipse.xtend.core.idea.XtendIdeaModule;
import org.eclipse.xtext.util.Modules2;

@SuppressWarnings("all")
public class XtendStandaloneSetupIdea extends XtendStandaloneSetupGenerated {
  @Override
  public Injector createInjector() {
    Module runtimeModule = new XtendRuntimeModule();
    Module ideaModule = new XtendIdeaModule();
    Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
    return Guice.createInjector(mergedModule);
  }
}
