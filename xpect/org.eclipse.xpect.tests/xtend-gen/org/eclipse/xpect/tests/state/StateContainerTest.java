package org.eclipse.xpect.tests.state;

import org.eclipse.xpect.state.Configuration;
import org.eclipse.xpect.state.Managed;
import org.eclipse.xpect.state.ManagedImpl;
import org.eclipse.xpect.state.StateContainer;
import org.eclipse.xpect.tests.state.TestData;
import org.eclipse.xtext.util.IAcceptor;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class StateContainerTest {
  @Test
  public void testPrimaryValue() {
    final IAcceptor<Configuration> _function = new IAcceptor<Configuration>() {
      @Override
      public void accept(final Configuration it) {
        it.<String>addDefaultValue("Foo");
      }
    };
    final StateContainer cnt = new StateContainer(_function);
    Managed<String> _get = cnt.<String>get(String.class);
    String _get_1 = _get.get();
    Assert.assertEquals("Foo", _get_1);
  }
  
  @Test
  public void testPrimaryValueAnn() {
    final IAcceptor<Configuration> _function = new IAcceptor<Configuration>() {
      @Override
      public void accept(final Configuration it) {
        it.<String>addValue(TestData.Ann.class, "Foo");
      }
    };
    final StateContainer cnt = new StateContainer(_function);
    Managed<String> _get = cnt.<String>get(String.class, TestData.Ann.class);
    String _get_1 = _get.get();
    Assert.assertEquals("Foo", _get_1);
  }
  
  @Test
  public void testPrimaryManaged() {
    final IAcceptor<Configuration> _function = new IAcceptor<Configuration>() {
      @Override
      public void accept(final Configuration it) {
        ManagedImpl<String> _managedImpl = new ManagedImpl<String>("Foo");
        it.<String>addDefaultValue(String.class, _managedImpl);
      }
    };
    final StateContainer cnt = new StateContainer(_function);
    Managed<String> _get = cnt.<String>get(String.class);
    String _get_1 = _get.get();
    Assert.assertEquals("Foo", _get_1);
  }
  
  @Test
  public void testPrimaryManagedAnn() {
    final IAcceptor<Configuration> _function = new IAcceptor<Configuration>() {
      @Override
      public void accept(final Configuration it) {
        ManagedImpl<String> _managedImpl = new ManagedImpl<String>("Foo");
        it.<String>addValue(TestData.Ann.class, String.class, _managedImpl);
      }
    };
    final StateContainer cnt = new StateContainer(_function);
    Managed<String> _get = cnt.<String>get(String.class, TestData.Ann.class);
    String _get_1 = _get.get();
    Assert.assertEquals("Foo", _get_1);
  }
  
  @Test
  public void testDerivedValue() {
    final IAcceptor<Configuration> _function = new IAcceptor<Configuration>() {
      @Override
      public void accept(final Configuration it) {
        it.addFactory(TestData.StaticValueProvider.class);
      }
    };
    final StateContainer cnt = new StateContainer(_function);
    Managed<String> _get = cnt.<String>get(String.class);
    String _get_1 = _get.get();
    Assert.assertEquals("DefaultValue", _get_1);
    Managed<String> _get_2 = cnt.<String>get(String.class, TestData.Ann.class);
    String _get_3 = _get_2.get();
    Assert.assertEquals("AnnotatedValue", _get_3);
  }
  
  @Test
  public void testDerivedManaged() {
    final IAcceptor<Configuration> _function = new IAcceptor<Configuration>() {
      @Override
      public void accept(final Configuration it) {
        it.addFactory(TestData.StaticManagedProvider.class);
      }
    };
    final StateContainer cnt = new StateContainer(_function);
    Managed<String> _get = cnt.<String>get(String.class);
    String _get_1 = _get.get();
    Assert.assertEquals("DefaultManaged", _get_1);
    Managed<String> _get_2 = cnt.<String>get(String.class, TestData.Ann.class);
    String _get_3 = _get_2.get();
    Assert.assertEquals("AnnotatedManaged", _get_3);
  }
}
