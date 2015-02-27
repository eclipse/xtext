package org.eclipse.xtext.idea.lang;

import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.impl.source.tree.PsiErrorElementImpl;
import com.intellij.psi.tree.IElementType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class GrammarAwarePsiErrorElement extends PsiErrorElementImpl implements PsiErrorElement {
  @Accessors
  private IElementType elementType;
  
  public GrammarAwarePsiErrorElement(final IElementType elementType) {
    super(elementType.toString());
    this.elementType = elementType;
  }
  
  public EObject getGrammarElement() {
    EObject _xifexpression = null;
    if ((this.elementType instanceof IGrammarAwareElementType)) {
      _xifexpression = ((IGrammarAwareElementType)this.elementType).getGrammarElement();
    }
    return _xifexpression;
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    Class<? extends GrammarAwarePsiErrorElement> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append(":");
    String _errorDescription = this.getErrorDescription();
    _builder.append(_errorDescription, "");
    return _builder.toString();
  }
  
  @Pure
  public IElementType getElementType() {
    return this.elementType;
  }
  
  public void setElementType(final IElementType elementType) {
    this.elementType = elementType;
  }
}
