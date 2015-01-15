package org.eclipse.xtend.core.formatting2;

import java.util.List;
import org.eclipse.xtend.core.formatting2.Chunk;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Line {
  private final int offset;
  
  private final boolean leadingSemanticNewLine;
  
  private final int newLineCharCount;
  
  private final List<Chunk> chunks = CollectionLiterals.<Chunk>newArrayList();
  
  private String content;
  
  private int indentLength;
  
  @Override
  public String toString() {
    String _xifexpression = null;
    if (this.leadingSemanticNewLine) {
      _xifexpression = "SN";
    } else {
      _xifexpression = "";
    }
    String _plus = (_xifexpression + "\n");
    String _join = IterableExtensions.join(this.chunks);
    String _plus_1 = (_plus + _join);
    return (_plus_1 + this.content);
  }
  
  public Line(final int offset, final boolean leadingSemanticNewLine, final int newLineCharCount) {
    super();
    this.offset = offset;
    this.leadingSemanticNewLine = leadingSemanticNewLine;
    this.newLineCharCount = newLineCharCount;
  }
  
  @Pure
  public int getOffset() {
    return this.offset;
  }
  
  @Pure
  public boolean isLeadingSemanticNewLine() {
    return this.leadingSemanticNewLine;
  }
  
  @Pure
  public int getNewLineCharCount() {
    return this.newLineCharCount;
  }
  
  @Pure
  public List<Chunk> getChunks() {
    return this.chunks;
  }
  
  @Pure
  public String getContent() {
    return this.content;
  }
  
  public void setContent(final String content) {
    this.content = content;
  }
  
  @Pure
  public int getIndentLength() {
    return this.indentLength;
  }
  
  public void setIndentLength(final int indentLength) {
    this.indentLength = indentLength;
  }
}
