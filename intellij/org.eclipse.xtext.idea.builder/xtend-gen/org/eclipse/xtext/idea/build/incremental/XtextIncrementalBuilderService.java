package org.eclipse.xtext.idea.build.incremental;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.idea.build.incremental.IncrementalBuilderServiceModule;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.jetbrains.jps.incremental.BuilderService;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;

@SuppressWarnings("all")
public class XtextIncrementalBuilderService extends BuilderService {
  private static Injector INJECTOR = Guice.createInjector(new IncrementalBuilderServiceModule());
  
  @Inject
  private ModuleLevelBuilder moduleLevelBuilder;
  
  public XtextIncrementalBuilderService() {
    XtextIncrementalBuilderService.INJECTOR.injectMembers(this);
  }
  
  @Override
  public List<? extends ModuleLevelBuilder> createModuleLevelBuilders() {
    return Collections.<ModuleLevelBuilder>unmodifiableList(CollectionLiterals.<ModuleLevelBuilder>newArrayList(this.moduleLevelBuilder));
  }
}
