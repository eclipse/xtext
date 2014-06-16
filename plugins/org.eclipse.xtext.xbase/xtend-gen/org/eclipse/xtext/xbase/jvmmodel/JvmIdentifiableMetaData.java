package org.eclipse.xtext.xbase.jvmmodel;

import com.google.common.base.Objects;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtend.lib.Property;

@SuppressWarnings("all")
public class JvmIdentifiableMetaData extends AdapterImpl {
  @Property
  private boolean _synthetic;
  
  public boolean isAdapterForType(final Object type) {
    return Objects.equal(JvmIdentifiableMetaData.class, type);
  }
  
  public boolean isSynthetic() {
    return this._synthetic;
  }
  
  public void setSynthetic(final boolean synthetic) {
    this._synthetic = synthetic;
  }
}
