package org.eclipse.xtext.java.resource;

import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.Pure;

@EmfAdaptable
@SuppressWarnings("all")
public class JavaConfig {
  public static class JavaConfigAdapter extends AdapterImpl {
    private JavaConfig element;
    
    public JavaConfigAdapter(final JavaConfig element) {
      this.element = element;
    }
    
    public JavaConfig get() {
      return this.element;
    }
    
    @Override
    public boolean isAdapterForType(final Object object) {
      return object == JavaConfig.class;
    }
  }
  
  @Accessors
  private JavaVersion javaSourceLevel;
  
  @Accessors
  private JavaVersion javaTargetLevel;
  
  public static JavaConfig findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof JavaConfig.JavaConfigAdapter) {
    		return ((JavaConfig.JavaConfigAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public static JavaConfig removeFromEmfObject(final Notifier emfObject) {
    List<Adapter> adapters = emfObject.eAdapters();
    for(int i = 0, max = adapters.size(); i < max; i++) {
    	Adapter adapter = adapters.get(i);
    	if (adapter instanceof JavaConfig.JavaConfigAdapter) {
    		emfObject.eAdapters().remove(i);
    		return ((JavaConfig.JavaConfigAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    JavaConfig result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for JavaConfig");
    JavaConfig.JavaConfigAdapter adapter = new JavaConfig.JavaConfigAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
  
  @Pure
  public JavaVersion getJavaSourceLevel() {
    return this.javaSourceLevel;
  }
  
  public void setJavaSourceLevel(final JavaVersion javaSourceLevel) {
    this.javaSourceLevel = javaSourceLevel;
  }
  
  @Pure
  public JavaVersion getJavaTargetLevel() {
    return this.javaTargetLevel;
  }
  
  public void setJavaTargetLevel(final JavaVersion javaTargetLevel) {
    this.javaTargetLevel = javaTargetLevel;
  }
}
