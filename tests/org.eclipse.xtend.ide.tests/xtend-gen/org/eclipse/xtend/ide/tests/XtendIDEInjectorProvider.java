package org.eclipse.xtend.ide.tests;

import com.google.inject.Injector;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtext.junit4.IInjectorProvider;

@SuppressWarnings("all")
public class XtendIDEInjectorProvider implements IInjectorProvider {
  public Injector getInjector() {
    XtendActivator _instance = XtendActivator.getInstance();
    Injector _injector = _instance.getInjector(XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND);
    return _injector;
  }
}
