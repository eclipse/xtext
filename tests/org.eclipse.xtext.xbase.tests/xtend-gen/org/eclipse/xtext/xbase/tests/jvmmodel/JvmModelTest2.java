package org.eclipse.xtext.xbase.tests.jvmmodel;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest.SimpleJvmModelTestInjectorProvider2;
import org.eclipse.xtext.xbase.tests.jvmmodel.JvmModelTest;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = SimpleJvmModelTestInjectorProvider2.class)
@SuppressWarnings("all")
public class JvmModelTest2 extends JvmModelTest {
}
