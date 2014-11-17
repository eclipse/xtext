package org.eclipse.xtext.idea;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import org.eclipse.xtext.idea.containers.ResolveScopeBasedContainerManger;
import org.eclipse.xtext.idea.resource.impl.ProjectScopeBasedResourceDescriptions;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.psi.PsiModelAssociations;
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.service.SingletonBinding;

@SuppressWarnings("all")
public class DefaultIdeaModule extends AbstractGenericModule {
  public void configureIResourceDescriptions(final Binder binder) {
    AnnotatedBindingBuilder<IResourceDescriptions> _bind = binder.<IResourceDescriptions>bind(IResourceDescriptions.class);
    _bind.to(ProjectScopeBasedResourceDescriptions.class);
  }
  
  public Class<? extends IContainer.Manager> bindIContainer$Manager() {
    return ResolveScopeBasedContainerManger.class;
  }
  
  public Class<? extends IPsiModelAssociations> bindIPsiModelAssociations() {
    return PsiModelAssociations.class;
  }
  
  public Class<? extends IPsiModelAssociator> bindIPsiModelAssociator() {
    return PsiModelAssociations.class;
  }
  
  @SingletonBinding
  public Class<? extends ExportedObjectQualifiedNameIndex> bindExportedObjectQualifiedNameIndex() {
    return ExportedObjectQualifiedNameIndex.class;
  }
}
