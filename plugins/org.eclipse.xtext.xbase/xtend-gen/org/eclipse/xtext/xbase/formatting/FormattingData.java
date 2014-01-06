package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public abstract class FormattingData {
  private final int _offset;
  
  public int getOffset() {
    return this._offset;
  }
  
  private final int _length;
  
  public int getLength() {
    return this._length;
  }
  
  private final int _increaseIndentationChange;
  
  public int getIncreaseIndentationChange() {
    return this._increaseIndentationChange;
  }
  
  private final int _decreaseIndentationChange;
  
  public int getDecreaseIndentationChange() {
    return this._decreaseIndentationChange;
  }
  
  private final Throwable _trace;
  
  public Throwable getTrace() {
    return this._trace;
  }
  
  public abstract boolean isEmpty();
  
  public int getIndentationChange() {
    int _increaseIndentationChange = this.getIncreaseIndentationChange();
    int _decreaseIndentationChange = this.getDecreaseIndentationChange();
    return (_increaseIndentationChange + _decreaseIndentationChange);
  }
  
  public FormattingData(final int offset, final int length, final int increaseIndentationChange, final int decreaseIndentationChange, final Throwable trace) {
    super();
    this._offset = offset;
    this._length = length;
    this._increaseIndentationChange = increaseIndentationChange;
    this._decreaseIndentationChange = decreaseIndentationChange;
    this._trace = trace;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + _offset;
    result = prime * result + _length;
    result = prime * result + _increaseIndentationChange;
    result = prime * result + _decreaseIndentationChange;
    result = prime * result + ((_trace== null) ? 0 : _trace.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    FormattingData other = (FormattingData) obj;
    if (other._offset != _offset)
      return false;
    if (other._length != _length)
      return false;
    if (other._increaseIndentationChange != _increaseIndentationChange)
      return false;
    if (other._decreaseIndentationChange != _decreaseIndentationChange)
      return false;
    if (_trace == null) {
      if (other._trace != null)
        return false;
    } else if (!_trace.equals(other._trace))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
