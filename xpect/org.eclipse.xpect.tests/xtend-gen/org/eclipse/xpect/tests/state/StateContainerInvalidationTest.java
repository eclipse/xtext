package org.eclipse.xpect.tests.state;

import java.util.ArrayList;
import org.eclipse.xpect.state.Configuration;
import org.eclipse.xpect.state.Managed;
import org.eclipse.xpect.state.StateContainer;
import org.eclipse.xpect.tests.TestUtil;
import org.eclipse.xpect.tests.state.LoggingTestData;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.junit.Test;

@SuppressWarnings("all")
public class StateContainerInvalidationTest {
  @Test
  public void testInvalidate() {
    final LoggingTestData.EventLogger actual = new LoggingTestData.EventLogger();
    final ArrayList<String> expected = CollectionLiterals.<String>newArrayList();
    final IAcceptor<Configuration> _function = new IAcceptor<Configuration>() {
      @Override
      public void accept(final Configuration it) {
        LoggingTestData.LoggingManaged _loggingManaged = new LoggingTestData.LoggingManaged(actual, "Foo");
        it.<String>addDefaultValue(String.class, _loggingManaged);
      }
    };
    final StateContainer container = new StateContainer(_function);
    TestUtil.assertEquals(expected, actual);
    Managed<String> _get = container.<String>get(String.class);
    String _get_1 = _get.get();
    TestUtil.assertEquals("Foo", _get_1);
    expected.add("LoggingTestData$LoggingManaged.get() -> Foo");
    TestUtil.assertEquals(expected, actual);
    Managed<String> _get_2 = container.<String>get(String.class);
    _get_2.invalidate();
    expected.add("LoggingTestData$LoggingManaged.invalidate() -> Foo");
    TestUtil.assertEquals(expected, actual);
  }
  
  @Test
  public void testInvalidate2() {
    final LoggingTestData.EventLogger actual = new LoggingTestData.EventLogger();
    final ArrayList<String> expected = CollectionLiterals.<String>newArrayList();
    final IAcceptor<Configuration> _function = new IAcceptor<Configuration>() {
      @Override
      public void accept(final Configuration it) {
        it.<LoggingTestData.EventLogger>addDefaultValue(actual);
        it.addFactory(LoggingTestData.StaticValueLoggingProvider.class);
        it.addFactory(LoggingTestData.DerivedProvider.class);
      }
    };
    final StateContainer container = new StateContainer(_function);
    TestUtil.assertEquals(expected, actual);
    Managed<String> _get = container.<String>get(String.class, LoggingTestData.AnnDerived1.class);
    String _get_1 = _get.get();
    TestUtil.assertEquals("derivedDefaultValue", _get_1);
    expected.add("LoggingTestData$StaticValueLoggingProvider.<init>() -> instantiate");
    expected.add("LoggingTestData$StaticValueLoggingProvider.getDefaultValue() -> DefaultValue");
    expected.add("LoggingTestData$StaticValueLoggingProvider.getAnnotatedValue() -> AnnotatedValue");
    expected.add("LoggingTestData$DerivedProvider.getDerived1() -> derivedDefaultValue");
    TestUtil.assertEquals(expected, actual);
    Managed<String> _get_2 = container.<String>get(String.class);
    _get_2.invalidate();
    expected.add("LoggingTestData$StaticValueLoggingProvider.invalidateDefaultValue(DefaultValue)");
    expected.add("LoggingTestData$DerivedProvider.invalidatesDerived1(derivedDefaultValue)");
    TestUtil.assertEquals(expected, actual);
  }
}
