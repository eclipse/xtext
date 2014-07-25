package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.formatting2.AbstractTextReplacer;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;

@SuppressWarnings("all")
public class ArrayBracketsFormattingReplacer extends AbstractTextReplacer {
  protected ArrayBracketsFormattingReplacer(final IFormattableDocument document, final ISemanticRegion region) {
    super(document, region.getOffset(), region.getLength());
  }
  
  public ITextReplacerContext createReplacements(final ITextReplacerContext it) {
    final String t = this.getText();
    for (int i = 0; (i < t.length()); i++) {
      char _charAt = t.charAt(i);
      boolean _isWhitespace = Character.isWhitespace(_charAt);
      if (_isWhitespace) {
        int _offset = this.getOffset();
        int _plus = (_offset + i);
        it.replaceText(_plus, 1, "");
      }
    }
    return it;
  }
}
