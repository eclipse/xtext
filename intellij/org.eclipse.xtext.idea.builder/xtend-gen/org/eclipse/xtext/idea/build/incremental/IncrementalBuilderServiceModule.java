package org.eclipse.xtext.idea.build.incremental;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import org.eclipse.xtext.idea.build.XtextIdeaRefreshComponent;
import org.eclipse.xtext.idea.build.incremental.XtextIncrementalBuilder;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;

@SuppressWarnings("all")
public class IncrementalBuilderServiceModule extends AbstractModule {
  @Override
  protected void configure() {
    AnnotatedBindingBuilder<ModuleLevelBuilder> _bind = this.<ModuleLevelBuilder>bind(ModuleLevelBuilder.class);
    ScopedBindingBuilder _to = _bind.to(XtextIncrementalBuilder.class);
    _to.in(Scopes.SINGLETON);
    AnnotatedBindingBuilder<XtextIdeaRefreshComponent> _bind_1 = this.<XtextIdeaRefreshComponent>bind(XtextIdeaRefreshComponent.class);
    _bind_1.in(Scopes.SINGLETON);
  }
}
