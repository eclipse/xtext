package org.eclipse.xtext.idea.tests;

import org.eclipse.xtend.lib.macro.Active;
import org.eclipse.xtext.idea.tests.TestDecoratorProcessor;

@Active(TestDecoratorProcessor.class)
public @interface TestDecorator {
}
