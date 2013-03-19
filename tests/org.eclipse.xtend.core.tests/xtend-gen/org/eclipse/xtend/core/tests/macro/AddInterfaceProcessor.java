package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;

@SuppressWarnings("all")
public class AddInterfaceProcessor extends AbstractClassProcessor {
  public void doRegisterGlobals(final ClassDeclaration annotatedClass, final RegisterGlobalsContext context) {
    context.registerInterface("de.test.Test");
  }
}
