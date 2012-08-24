package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Format {
  private final String _document;
  
  public String getDocument() {
    return this._document;
  }
  
  private int _offset;
  
  public int getOffset() {
    return this._offset;
  }
  
  public void setOffset(final int offset) {
    this._offset = offset;
  }
  
  private List<FormattingData> _formattings;
  
  public List<FormattingData> getFormattings() {
    return this._formattings;
  }
  
  public void setFormattings(final List<FormattingData> formattings) {
    this._formattings = formattings;
  }
  
  public Format(final String document) {
    this._offset = 0;
    this._document = document;
    ArrayList<FormattingData> _newArrayList = CollectionLiterals.<FormattingData>newArrayList();
    this._formattings = _newArrayList;
  }
  
  public Format(final Format fmt) {
    String _document = fmt.getDocument();
    this._document = _document;
    int _offset = fmt.getOffset();
    this._offset = _offset;
    List<FormattingData> _formattings = this.getFormattings();
    List<FormattingData> _list = IterableExtensions.<FormattingData>toList(_formattings);
    this._formattings = _list;
  }
  
  protected boolean add(final FormattingData data) {
    boolean _xifexpression = false;
    boolean _notEquals = (!Objects.equal(data, null));
    if (_notEquals) {
      List<FormattingData> _formattings = this.getFormattings();
      boolean _add = _formattings.add(data);
      _xifexpression = _add;
    }
    return _xifexpression;
  }
  
  public boolean operator_add(final FormattingData data) {
    boolean _add = this.add(data);
    return _add;
  }
}
