package org.eclipse.xtend.core.formatting;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.core.formatting.TextReplacement;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RenderState {
  private int _offset;
  
  public int getOffset() {
    return this._offset;
  }
  
  public void setOffset(final int offset) {
    this._offset = offset;
  }
  
  private int _indentation;
  
  public int getIndentation() {
    return this._indentation;
  }
  
  public void setIndentation(final int indentation) {
    this._indentation = indentation;
  }
  
  private final List<TextReplacement> _replacements;
  
  public List<TextReplacement> getReplacements() {
    return this._replacements;
  }
  
  public RenderState(final int offset, final int indentation) {
    this._offset = offset;
    this._indentation = indentation;
    ArrayList<TextReplacement> _newArrayList = CollectionLiterals.<TextReplacement>newArrayList();
    this._replacements = _newArrayList;
  }
  
  public RenderState(final RenderState other) {
    this._offset = other._offset;
    this._indentation = other._indentation;
    List<TextReplacement> _list = IterableExtensions.<TextReplacement>toList(other._replacements);
    this._replacements = _list;
  }
}
