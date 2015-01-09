package org.eclipse.xtext.idea.structureview;

import com.google.inject.ImplementedBy;
import com.intellij.ide.structureView.StructureViewBuilder;
import org.eclipse.xtext.idea.structureview.DefaultStructureViewBuilder;
import org.eclipse.xtext.psi.impl.BaseXtextFile;

@ImplementedBy(DefaultStructureViewBuilder.class)
@SuppressWarnings("all")
public interface XtextFileAwareStructureViewBuilder extends StructureViewBuilder {
  public abstract void setXtextFile(final BaseXtextFile file);
}
