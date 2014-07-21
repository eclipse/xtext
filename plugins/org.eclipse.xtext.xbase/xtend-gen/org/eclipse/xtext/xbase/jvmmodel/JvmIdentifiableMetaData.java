package org.eclipse.xtext.xbase.jvmmodel;

import com.google.common.base.Objects;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class JvmIdentifiableMetaData extends AdapterImpl {
  @Accessors
  private boolean synthetic;
  
  public boolean isAdapterForType(final Object type) {
    return Objects.equal(JvmIdentifiableMetaData.class, type);
  }
  
  @Pure
  public boolean isSynthetic() {
    return this.synthetic;
  }
  
  public void setSynthetic(final boolean synthetic) {
    this.synthetic = synthetic;
  }
}
