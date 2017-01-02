package org.eclipse.xtend.ide.tests;

import com.google.inject.Injector;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

@SuppressWarnings("all")
public class XtendIDEInjectorProvider implements IInjectorProvider {
  @Override
  public Injector getInjector() {
    return XtendActivator.getInstance().getInjector(XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND);
  }
}
