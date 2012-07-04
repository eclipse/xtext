package org.eclipse.xtend.core.formatting;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class FormatterState {
  private final List<ILeafNode> _lastHiddens = new Function0<List<ILeafNode>>() {
    public List<ILeafNode> apply() {
      ArrayList<ILeafNode> _newArrayList = CollectionLiterals.<ILeafNode>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public List<ILeafNode> getLastHiddens() {
    return this._lastHiddens;
  }
  
  private int _wrap;
  
  public int getWrap() {
    return this._wrap;
  }
  
  public void setWrap(final int wrap) {
    this._wrap = wrap;
  }
  
  private int _indentation = 0;
  
  public int getIndentation() {
    return this._indentation;
  }
  
  public void setIndentation(final int indentation) {
    this._indentation = indentation;
  }
  
  private String _space = "";
  
  public String getSpace() {
    return this._space;
  }
  
  public void setSpace(final String space) {
    this._space = space;
  }
}
