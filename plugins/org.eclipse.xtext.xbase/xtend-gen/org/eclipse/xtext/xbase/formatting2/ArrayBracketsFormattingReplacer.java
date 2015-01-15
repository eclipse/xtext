package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.xbase.lib.Pure;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class ArrayBracketsFormattingReplacer implements ITextReplacer {
  @Accessors
  private final ISemanticRegion region;
  
  @Override
  public ITextReplacerContext createReplacements(final ITextReplacerContext it) {
    final String t = this.region.getText();
    final int offset = this.region.getOffset();
    for (int i = 0; (i < t.length()); i++) {
      char _charAt = t.charAt(i);
      boolean _isWhitespace = Character.isWhitespace(_charAt);
      if (_isWhitespace) {
        it.replaceText((offset + i), 1, "");
      }
    }
    return it;
  }
  
  @Pure
  public ISemanticRegion getRegion() {
    return this.region;
  }
  
  public ArrayBracketsFormattingReplacer(final ISemanticRegion region) {
    super();
    this.region = region;
  }
}
