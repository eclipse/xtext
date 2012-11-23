package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class JvmIdentifiableMetaData extends AdapterImpl {
  private boolean _synthetic;
  
  public boolean isSynthetic() {
    return this._synthetic;
  }
  
  public void setSynthetic(final boolean synthetic) {
    this._synthetic = synthetic;
  }
  
  public boolean isAdapterForType(final Object type) {
    boolean _equals = ObjectExtensions.operator_equals(
      JvmIdentifiableMetaData.class, type);
    return _equals;
  }
}
