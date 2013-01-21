package org.eclipse.xtext.xbase.tests.linking;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.tests.linking.JvmModelBasedLinkingTest;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseWithLogicalContainerInjectorProvider;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseWithLogicalContainerInjectorProvider.class)
@SuppressWarnings("all")
public class JvmModelBasedLinkingTest2 extends JvmModelBasedLinkingTest {
}
