package org.eclipse.xtend.core.tests.performance;

import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.performance.PerformanceTest;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = NewTypeSystemRuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class PerformanceTestNewTypeSystem extends PerformanceTest {
}
