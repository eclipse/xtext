package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.tests.compiler.JvmModelGeneratorTest;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseWithLogicalContainerInjectorProvider;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseWithLogicalContainerInjectorProvider.class)
@SuppressWarnings("all")
public class JvmModelGeneratorTest2 extends JvmModelGeneratorTest {
}
