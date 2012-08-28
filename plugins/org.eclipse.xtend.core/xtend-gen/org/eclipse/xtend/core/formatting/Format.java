package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.RendererConfiguration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Format {
  private final RendererConfiguration _cfg;
  
  public RendererConfiguration getCfg() {
    return this._cfg;
  }
  
  private final String _document;
  
  public String getDocument() {
    return this._document;
  }
  
  private List<FormattingData> _formattings;
  
  public List<FormattingData> getFormattings() {
    return this._formattings;
  }
  
  public void setFormattings(final List<FormattingData> formattings) {
    this._formattings = formattings;
  }
  
  public Format(final RendererConfiguration cfg, final String document) {
    this._cfg = cfg;
    this._document = document;
    ArrayList<FormattingData> _newArrayList = CollectionLiterals.<FormattingData>newArrayList();
    this._formattings = _newArrayList;
  }
  
  public Format(final Format fmt) {
    RendererConfiguration _cfg = fmt.getCfg();
    this._cfg = _cfg;
    String _document = fmt.getDocument();
    this._document = _document;
    ArrayList<FormattingData> _newArrayList = CollectionLiterals.<FormattingData>newArrayList();
    this._formattings = _newArrayList;
    List<FormattingData> _formattings = fmt.getFormattings();
    Iterables.<FormattingData>addAll(this._formattings, _formattings);
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
  
  public int getOffset() {
    int _xblockexpression = (int) 0;
    {
      List<FormattingData> _formattings = this.getFormattings();
      final Function2<FormattingData,FormattingData,FormattingData> _function = new Function2<FormattingData,FormattingData,FormattingData>() {
          public FormattingData apply(final FormattingData i, final FormattingData j) {
            FormattingData _xifexpression = null;
            int _offset = i.getOffset();
            int _offset_1 = j.getOffset();
            boolean _lessThan = (_offset < _offset_1);
            if (_lessThan) {
              _xifexpression = j;
            } else {
              _xifexpression = i;
            }
            return _xifexpression;
          }
        };
      final FormattingData last = IterableExtensions.<FormattingData>reduce(_formattings, _function);
      List<FormattingData> _formattings_1 = this.getFormattings();
      final Function2<Integer,FormattingData,Integer> _function_1 = new Function2<Integer,FormattingData,Integer>() {
          public Integer apply(final Integer i, final FormattingData j) {
            int _newLength = j.newLength();
            int _length = j.getLength();
            int _minus = (_newLength - _length);
            int _plus = ((i).intValue() + _minus);
            return Integer.valueOf(_plus);
          }
        };
      final Integer diff = IterableExtensions.<FormattingData, Integer>fold(_formattings_1, Integer.valueOf(0), _function_1);
      int _offset = last.getOffset();
      int _length = last.getLength();
      int _plus = (_offset + _length);
      int _plus_1 = (_plus + (diff).intValue());
      _xblockexpression = (_plus_1);
    }
    return _xblockexpression;
  }
}
