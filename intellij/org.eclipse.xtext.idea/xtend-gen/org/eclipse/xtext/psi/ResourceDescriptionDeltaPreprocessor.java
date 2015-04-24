package org.eclipse.xtext.psi;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.intellij.openapi.project.Project;
import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.impl.PsiTreeChangePreprocessor;
import java.util.List;
import org.eclipse.xtext.idea.resource.ProjectAwareResourceDescriptions;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.psi.PsiTreeChangeToDeltaConverter;
import org.eclipse.xtext.psi.ResourceDescriptionEventSource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class ResourceDescriptionDeltaPreprocessor implements PsiTreeChangePreprocessor {
  @Inject
  @Extension
  private PsiTreeChangeToDeltaConverter _psiTreeChangeToDeltaConverter;
  
  private final IResourceDescription.Event.Source source;
  
  private final Project project;
  
  private final IResourceDescriptions resourceDescriptions;
  
  public ResourceDescriptionDeltaPreprocessor(final Project project) {
    Injector _injector = IdeaSharedInjectorProvider.getInjector();
    _injector.injectMembers(this);
    this.project = project;
    IResourceDescription.Event.Source _instance = ResourceDescriptionEventSource.getInstance(project);
    this.source = _instance;
    IResourceDescriptions _instance_1 = ProjectAwareResourceDescriptions.getInstance(project);
    this.resourceDescriptions = _instance_1;
  }
  
  @Override
  public void treeChanged(final PsiTreeChangeEventImpl event) {
    final List<IResourceDescription.Delta> deltas = this._psiTreeChangeToDeltaConverter.convert(event);
    boolean _isEmpty = deltas.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final ResourceDescriptionChangeEvent changeEvent = new ResourceDescriptionChangeEvent(deltas);
      this.source.notifyListeners(changeEvent);
    }
  }
}
