package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.formatting2.AbstractTextReplacer;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;

@SuppressWarnings("all")
public class ArrayBracketsFormattingReplacer extends AbstractTextReplacer {
  protected ArrayBracketsFormattingReplacer(final IFormattableDocument document, final ISemanticRegion region) {
    super(document, region);
  }
  
  public ITextReplacerContext createReplacements(final ITextReplacerContext it) {
    ITextSegment _region = this.getRegion();
    final String t = _region.getText();
    ITextSegment _region_1 = this.getRegion();
    final int offset = _region_1.getOffset();
    for (int i = 0; (i < t.length()); i++) {
      char _charAt = t.charAt(i);
      boolean _isWhitespace = Character.isWhitespace(_charAt);
      if (_isWhitespace) {
        it.replaceText((offset + i), 1, "");
      }
    }
    return it;
  }
}
