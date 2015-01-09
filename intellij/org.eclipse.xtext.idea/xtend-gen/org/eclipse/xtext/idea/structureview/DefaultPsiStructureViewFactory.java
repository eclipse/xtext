package org.eclipse.xtext.idea.structureview;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.psi.PsiFile;
import org.eclipse.xtext.idea.structureview.XtextFileAwareStructureViewBuilder;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DefaultPsiStructureViewFactory implements PsiStructureViewFactory {
  @Inject
  private Provider<XtextFileAwareStructureViewBuilder> structureViewBuilderProvider;
  
  public StructureViewBuilder getStructureViewBuilder(final PsiFile psiFile) {
    XtextFileAwareStructureViewBuilder _xifexpression = null;
    if ((psiFile instanceof BaseXtextFile)) {
      XtextFileAwareStructureViewBuilder _get = this.structureViewBuilderProvider.get();
      final Procedure1<XtextFileAwareStructureViewBuilder> _function = new Procedure1<XtextFileAwareStructureViewBuilder>() {
        public void apply(final XtextFileAwareStructureViewBuilder it) {
          it.setXtextFile(((BaseXtextFile)psiFile));
        }
      };
      _xifexpression = ObjectExtensions.<XtextFileAwareStructureViewBuilder>operator_doubleArrow(_get, _function);
    }
    return _xifexpression;
  }
}
