package org.eclipse.xtend.ide.tests;

import com.google.inject.Injector;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.IRegistryConfigurator;

@SuppressWarnings("all")
public class XtendIDEInjectorProvider implements IInjectorProvider, IRegistryConfigurator {
  protected GlobalRegistries.GlobalStateMemento stateAfterInjectorCreation;
  
  @Override
  public Injector getInjector() {
    final Injector result = XtendActivator.getInstance().getInjector(XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND);
    if ((this.stateAfterInjectorCreation == null)) {
      this.stateAfterInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
    }
    return result;
  }
  
  @Override
  public void restoreRegistry() {
    this.stateAfterInjectorCreation.restoreGlobalState();
  }
  
  @Override
  public void setupRegistry() {
    if ((this.stateAfterInjectorCreation == null)) {
      this.getInjector();
    } else {
      this.stateAfterInjectorCreation.restoreGlobalState();
    }
  }
}
