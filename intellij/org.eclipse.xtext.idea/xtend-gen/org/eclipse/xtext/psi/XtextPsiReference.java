package org.eclipse.xtext.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.MultiRangeReference;

@SuppressWarnings("all")
public interface XtextPsiReference extends MultiRangeReference {
  public abstract TextRange getRangeToHighlightInElement();
}
