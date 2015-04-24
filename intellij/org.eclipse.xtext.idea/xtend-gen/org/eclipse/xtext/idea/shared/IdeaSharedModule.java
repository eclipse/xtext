package org.eclipse.xtext.idea.shared;

import com.google.inject.AbstractModule;
import com.google.inject.binder.AnnotatedBindingBuilder;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.PsiModelAssociations;
import org.eclipse.xtext.psi.PsiTreeChangeToDeltaConverter;
import org.eclipse.xtext.psi.PsiTreeChangeToDeltaConverterImpl;
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IResourceServiceProvider;

@SuppressWarnings("all")
public class IdeaSharedModule extends AbstractModule {
  @Override
  protected void configure() {
    this.<CompilerPhases>bind(CompilerPhases.class);
    AnnotatedBindingBuilder<IPsiModelAssociations> _bind = this.<IPsiModelAssociations>bind(IPsiModelAssociations.class);
    _bind.to(PsiModelAssociations.class);
    AnnotatedBindingBuilder<ExportedObjectQualifiedNameIndex> _bind_1 = this.<ExportedObjectQualifiedNameIndex>bind(ExportedObjectQualifiedNameIndex.class);
    _bind_1.asEagerSingleton();
    AnnotatedBindingBuilder<IResourceServiceProvider.Registry> _bind_2 = this.<IResourceServiceProvider.Registry>bind(IResourceServiceProvider.Registry.class);
    _bind_2.toInstance(IResourceServiceProvider.Registry.INSTANCE);
    AnnotatedBindingBuilder<PsiTreeChangeToDeltaConverter> _bind_3 = this.<PsiTreeChangeToDeltaConverter>bind(PsiTreeChangeToDeltaConverter.class);
    _bind_3.to(PsiTreeChangeToDeltaConverterImpl.class);
  }
}
