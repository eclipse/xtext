package org.eclipse.xtext.idea.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtext.idea.lang.CreateElementType;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;

@SuppressWarnings("all")
public class CompositeMarker {
  private final int lookAhead;
  
  private final IElementType elementType;
  
  private final PsiBuilder.Marker marker;
  
  public CompositeMarker(final PsiBuilder.Marker marker, final int lookAhead, final IElementType elementType) {
    this.marker = marker;
    this.lookAhead = lookAhead;
    this.elementType = elementType;
  }
  
  public CompositeMarker precede(final IElementType elementType) {
    PsiBuilder.Marker _precede = this.marker.precede();
    return new CompositeMarker(_precede, this.lookAhead, elementType);
  }
  
  public void done() {
    CreateElementType _withUserData = this.withUserData(this.elementType);
    this.marker.done(_withUserData);
  }
  
  protected CreateElementType withUserData(final IElementType elementType) {
    final CreateElementType.CreateCallback _function = new CreateElementType.CreateCallback() {
      @Override
      public void onCreate(final ASTNode it) {
        it.<Integer>putUserData(IASTNodeAwareNodeModelBuilder.LOOK_AHEAD_KEY, Integer.valueOf(CompositeMarker.this.lookAhead));
      }
    };
    return new CreateElementType(elementType, _function);
  }
}
