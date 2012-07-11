package org.eclipse.xtend.core.formatting;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.core.formatting.Anchors;
import org.eclipse.xtend.core.formatting.Line;
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
  
  private Line _line;
  
  public Line getLine() {
    return this._line;
  }
  
  public void setLine(final Line line) {
    this._line = line;
  }
  
  private final List<TextReplacement> _replacements;
  
  public List<TextReplacement> getReplacements() {
    return this._replacements;
  }
  
  private final Anchors _anchors;
  
  public Anchors getAnchors() {
    return this._anchors;
  }
  
  public RenderState(final int offset, final int indentation, final Line line, final Anchors anchors) {
    this._offset = offset;
    this._indentation = indentation;
    this._line = line;
    ArrayList<TextReplacement> _newArrayList = CollectionLiterals.<TextReplacement>newArrayList();
    this._replacements = _newArrayList;
    this._anchors = anchors;
  }
  
  public RenderState(final RenderState other) {
    this._offset = other._offset;
    this._indentation = other._indentation;
    Line _line = new Line(other._line);
    this._line = _line;
    List<TextReplacement> _list = IterableExtensions.<TextReplacement>toList(other._replacements);
    this._replacements = _list;
    Anchors _anchors = new Anchors(other._anchors);
    this._anchors = _anchors;
  }
}
