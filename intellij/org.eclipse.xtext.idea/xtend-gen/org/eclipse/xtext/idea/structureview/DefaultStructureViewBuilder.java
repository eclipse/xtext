package org.eclipse.xtext.idea.structureview;

import com.google.inject.Inject;
import com.intellij.ide.structureView.StructureView;
import org.eclipse.xtext.idea.structureview.AbstractStructureViewBuilder;
import org.eclipse.xtext.idea.structureview.IStructureViewTreeElementProvider;
import org.eclipse.xtext.idea.structureview.XtextFileTreeModel;

@SuppressWarnings("all")
public class DefaultStructureViewBuilder extends AbstractStructureViewBuilder {
  @Inject
  private IStructureViewTreeElementProvider structureViewTreeElementProvider;
  
  @Override
  public IStructureViewTreeElementProvider createStructureViewTreeElementProvider() {
    return this.structureViewTreeElementProvider;
  }
  
  @Override
  public void configureStructureViewTreeElementProvider(final IStructureViewTreeElementProvider structureViewTreeElementProvider, final XtextFileTreeModel model, final StructureView view) {
  }
}
