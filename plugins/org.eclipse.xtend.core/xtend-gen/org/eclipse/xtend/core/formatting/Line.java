package org.eclipse.xtend.core.formatting;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.core.formatting.TextReplacement;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Line {
  private final int _offset;
  
  public int getOffset() {
    return this._offset;
  }
  
  private int _column;
  
  public int getColumn() {
    return this._column;
  }
  
  public void setColumn(final int column) {
    this._column = column;
  }
  
  private final List<TextReplacement> _replacements;
  
  public List<TextReplacement> getReplacements() {
    return this._replacements;
  }
  
  public Line(final int offset, final int column) {
    this._offset = offset;
    this._column = column;
    ArrayList<TextReplacement> _newArrayList = CollectionLiterals.<TextReplacement>newArrayList();
    this._replacements = _newArrayList;
  }
  
  public Line(final Line line) {
    this._offset = line._offset;
    this._column = line._column;
    List<TextReplacement> _list = IterableExtensions.<TextReplacement>toList(line._replacements);
    this._replacements = _list;
  }
}
