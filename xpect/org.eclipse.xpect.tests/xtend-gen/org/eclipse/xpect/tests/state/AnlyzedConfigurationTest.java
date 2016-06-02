package org.eclipse.xpect.tests.state;

import org.eclipse.xpect.state.Configuration;
import org.eclipse.xpect.state.ResolvedConfiguration;
import org.eclipse.xpect.tests.TestUtil;
import org.eclipse.xpect.tests.state.LoggingTestData;
import org.eclipse.xpect.tests.state.MultiConstructor;
import org.eclipse.xpect.tests.state.MyAnnotaion1;
import org.eclipse.xpect.tests.state.Singleton1;
import org.eclipse.xpect.tests.state.Singleton2;
import org.eclipse.xpect.tests.state.StateTestUtil;
import org.eclipse.xpect.tests.state.TestData;
import org.eclipse.xpect.tests.state.TypeParam;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class AnlyzedConfigurationTest {
  @Test
  public void testSimple() {
    final Procedure1<Configuration> _function = new Procedure1<Configuration>() {
      @Override
      public void apply(final Configuration it) {
        it.addFactory(Singleton1.class);
        it.addFactory(Singleton2.class);
        it.<String>addDefaultValue("MyString1");
        it.<String>addValue(MyAnnotaion1.class, "MyString2");
      }
    };
    final ResolvedConfiguration actual = StateTestUtil.newAnalyzedConfiguration(_function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Primary Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[@MyAnnotaion1 String Managed[MyString2]]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[StateContainer Managed[null]]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[String Managed[MyString1]]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Derived Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.Singleton1 {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[StringBuffer Singleton1.getBuffer()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.Singleton2 {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("in PrimaryValue[@MyAnnotaion1 String Managed[MyString2]]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[@Annotation StringBuffer Singleton2.getBuffer()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String expected = _builder.toString();
    TestUtil.assertEquals(expected, actual);
  }
  
  @Test
  public void testStaticValue() {
    final Procedure1<Configuration> _function = new Procedure1<Configuration>() {
      @Override
      public void apply(final Configuration it) {
        it.addFactory(TestData.StaticValueProvider.class);
      }
    };
    final ResolvedConfiguration actual = StateTestUtil.newAnalyzedConfiguration(_function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Primary Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[StateContainer Managed[null]]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Derived Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.TestData$StaticValueProvider {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[@Ann String StaticValueProvider.getAnnotatedValue()]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[String StaticValueProvider.getDefaultValue()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String expected = _builder.toString();
    TestUtil.assertEquals(expected, actual);
  }
  
  @Test
  public void testStaticManaged() {
    final Procedure1<Configuration> _function = new Procedure1<Configuration>() {
      @Override
      public void apply(final Configuration it) {
        it.addFactory(TestData.StaticManagedProvider.class);
      }
    };
    final ResolvedConfiguration actual = StateTestUtil.newAnalyzedConfiguration(_function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Primary Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[StateContainer Managed[null]]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Derived Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.TestData$StaticManagedProvider {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[@Ann String StaticManagedProvider.getAnnotatedManaged()]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[String StaticManagedProvider.getDefaultManaged()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String expected = _builder.toString();
    TestUtil.assertEquals(expected, actual);
  }
  
  @Test
  public void testLogginTestDataValue() {
    final Procedure1<Configuration> _function = new Procedure1<Configuration>() {
      @Override
      public void apply(final Configuration it) {
        LoggingTestData.EventLogger _eventLogger = new LoggingTestData.EventLogger();
        it.<LoggingTestData.EventLogger>addDefaultValue(_eventLogger);
        it.addFactory(LoggingTestData.StaticValueLoggingProvider.class);
        it.addFactory(LoggingTestData.DerivedProvider.class);
      }
    };
    final ResolvedConfiguration actual = StateTestUtil.newAnalyzedConfiguration(_function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Primary Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[EventLogger Managed[]]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[StateContainer Managed[null]]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Derived Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.LoggingTestData$StaticValueLoggingProvider {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("in PrimaryValue[EventLogger Managed[]]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[@Ann String StaticValueLoggingProvider.getAnnotatedValue()]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[String StaticValueLoggingProvider.getDefaultValue()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.LoggingTestData$DerivedProvider {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("in DerivedValue[@Ann String StaticValueLoggingProvider.getAnnotatedValue()]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("in DerivedValue[String StaticValueLoggingProvider.getDefaultValue()]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("in PrimaryValue[EventLogger Managed[]]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[@AnnDerived1 String DerivedProvider.getDerived1()]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[@AnnDerived2 String DerivedProvider.getDerived2()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String expected = _builder.toString();
    TestUtil.assertEquals(expected, actual);
  }
  
  @Test
  public void testLogginTestDataManaged() {
    final Procedure1<Configuration> _function = new Procedure1<Configuration>() {
      @Override
      public void apply(final Configuration it) {
        LoggingTestData.EventLogger _eventLogger = new LoggingTestData.EventLogger();
        it.<LoggingTestData.EventLogger>addDefaultValue(_eventLogger);
        it.addFactory(LoggingTestData.StaticManagedLoggingProvider.class);
        it.addFactory(LoggingTestData.DerivedProvider.class);
      }
    };
    final ResolvedConfiguration actual = StateTestUtil.newAnalyzedConfiguration(_function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Primary Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[EventLogger Managed[]]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[StateContainer Managed[null]]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Derived Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.LoggingTestData$StaticManagedLoggingProvider {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("in PrimaryValue[EventLogger Managed[]]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[@Ann String StaticManagedLoggingProvider.getAnnotatedManaged()]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[String StaticManagedLoggingProvider.getDefaultManaged()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.LoggingTestData$DerivedProvider {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("in DerivedValue[@Ann String StaticManagedLoggingProvider.getAnnotatedManaged()]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("in DerivedValue[String StaticManagedLoggingProvider.getDefaultManaged()]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("in PrimaryValue[EventLogger Managed[]]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[@AnnDerived1 String DerivedProvider.getDerived1()]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[@AnnDerived2 String DerivedProvider.getDerived2()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String expected = _builder.toString();
    TestUtil.assertEquals(expected, actual);
  }
  
  @Test
  public void multiConstructor1() {
    final Procedure1<Configuration> _function = new Procedure1<Configuration>() {
      @Override
      public void apply(final Configuration it) {
        it.addFactory(MultiConstructor.class);
      }
    };
    final ResolvedConfiguration actual = StateTestUtil.newAnalyzedConfiguration(_function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Primary Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[StateContainer Managed[null]]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Derived Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.MultiConstructor {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[Object MultiConstructor.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("UNRESOLVED org.xpect.tests.state.MultiConstructor {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[Object MultiConstructor.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("UNRESOLVED org.xpect.tests.state.MultiConstructor {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[Object MultiConstructor.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String expected = _builder.toString();
    TestUtil.assertEquals(expected, actual);
  }
  
  @Test
  public void multiConstructor2() {
    final Procedure1<Configuration> _function = new Procedure1<Configuration>() {
      @Override
      public void apply(final Configuration it) {
        it.addFactory(MultiConstructor.class);
      }
    };
    final ResolvedConfiguration base = StateTestUtil.newAnalyzedConfiguration(_function);
    final Procedure1<Configuration> _function_1 = new Procedure1<Configuration>() {
      @Override
      public void apply(final Configuration it) {
        it.<String>addDefaultValue(String.class, "myString");
      }
    };
    final ResolvedConfiguration actual = StateTestUtil.newAnalyzedConfiguration(base, _function_1);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Primary Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[StateContainer Managed[null]]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[String Managed[myString]]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Derived Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.MultiConstructor {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("in PrimaryValue[String Managed[myString]]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[Object MultiConstructor.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Primary Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[StateContainer Managed[null]]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Derived Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.MultiConstructor {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[Object MultiConstructor.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("UNRESOLVED org.xpect.tests.state.MultiConstructor {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[Object MultiConstructor.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("UNRESOLVED org.xpect.tests.state.MultiConstructor {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[Object MultiConstructor.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String expected = _builder.toString();
    TestUtil.assertEquals(expected, actual);
  }
  
  @Test
  public void multiConstructor3() {
    final Procedure1<Configuration> _function = new Procedure1<Configuration>() {
      @Override
      public void apply(final Configuration it) {
        it.addFactory(MultiConstructor.class);
      }
    };
    final ResolvedConfiguration base = StateTestUtil.newAnalyzedConfiguration(_function);
    final Procedure1<Configuration> _function_1 = new Procedure1<Configuration>() {
      @Override
      public void apply(final Configuration it) {
        it.<String>addDefaultValue(CharSequence.class, "mySequence");
      }
    };
    final ResolvedConfiguration actual = StateTestUtil.newAnalyzedConfiguration(base, _function_1);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Primary Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[CharSequence Managed[mySequence]]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[StateContainer Managed[null]]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Derived Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.MultiConstructor {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("in PrimaryValue[CharSequence Managed[mySequence]]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[Object MultiConstructor.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("UNRESOLVED org.xpect.tests.state.MultiConstructor {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[Object MultiConstructor.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Primary Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[StateContainer Managed[null]]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Derived Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.MultiConstructor {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[Object MultiConstructor.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("UNRESOLVED org.xpect.tests.state.MultiConstructor {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[Object MultiConstructor.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("UNRESOLVED org.xpect.tests.state.MultiConstructor {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[Object MultiConstructor.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String expected = _builder.toString();
    TestUtil.assertEquals(expected, actual);
  }
  
  @Test
  public void typeParam() {
    final Procedure1<Configuration> _function = new Procedure1<Configuration>() {
      @Override
      public void apply(final Configuration it) {
        it.<Class<String>>addDefaultValue(Class.class, String.class);
        it.addFactory(TypeParam.class);
      }
    };
    final ResolvedConfiguration actual = StateTestUtil.newAnalyzedConfiguration(_function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Primary Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[Class Managed[class java.lang.String]]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[StateContainer Managed[null]]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Derived Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.state.TypeParam {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("in PrimaryValue[Class Managed[class java.lang.String]]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[String TypeParam.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String expected = _builder.toString();
    TestUtil.assertEquals(expected, actual);
  }
  
  @Test
  public void typeParamUnresolved() {
    final Procedure1<Configuration> _function = new Procedure1<Configuration>() {
      @Override
      public void apply(final Configuration it) {
        it.addFactory(TypeParam.class);
      }
    };
    final ResolvedConfiguration actual = StateTestUtil.newAnalyzedConfiguration(_function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Primary Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PrimaryValue[StateContainer Managed[null]]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Derived Values {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("UNRESOLVED org.xpect.tests.state.TypeParam {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("out DerivedValue[(unresolved) TypeParam.get()]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String expected = _builder.toString();
    TestUtil.assertEquals(expected, actual);
  }
}
