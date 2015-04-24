package org.eclipse.xtext.idea.shared;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.idea.shared.IdeaSharedModule;

@SuppressWarnings("all")
public class IdeaSharedInjectorProvider {
  private final static IdeaSharedInjectorProvider INSTANCE = new IdeaSharedInjectorProvider();
  
  private final Injector injector;
  
  public static Injector getInjector() {
    return IdeaSharedInjectorProvider.INSTANCE.injector;
  }
  
  public IdeaSharedInjectorProvider() {
    IdeaSharedModule _ideaSharedModule = new IdeaSharedModule();
    Injector _createInjector = Guice.createInjector(_ideaSharedModule);
    this.injector = _createInjector;
  }
}
