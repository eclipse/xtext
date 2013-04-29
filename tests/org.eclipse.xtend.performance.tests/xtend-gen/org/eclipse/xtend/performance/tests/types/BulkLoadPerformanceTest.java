/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.performance.tests.types;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.performance.tests.PerformanceTestProjectSetup;
import org.eclipse.xtend.performance.tests.types.OldJdtTypeProvider;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProvider;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedTypes;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class BulkLoadPerformanceTest extends AbstractXtendUITestCase {
  @Rule
  public final static StopwatchRule rule = new Function0<StopwatchRule>() {
    public StopwatchRule apply() {
      StopwatchRule _stopwatchRule = new StopwatchRule(true);
      return _stopwatchRule;
    }
  }.apply();
  
  @Inject
  @Extension
  protected ReflectExtensions _reflectExtensions;
  
  @BeforeClass
  public static void createTestProject() {
    try {
      PerformanceTestProjectSetup.setUp(false);
      IResourcesSetupUtil.waitForAutoBuild();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @AfterClass
  public static void deleteTestProject() {
    try {
      PerformanceTestProjectSetup.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected List<Class<? extends Object>> getTypesToLoad() {
    try {
      final List<Class<?>> result = CollectionLiterals.<Class<? extends Object>>newArrayList();
      ImplicitlyImportedTypes _implicitlyImportedTypes = new ImplicitlyImportedTypes();
      Object _invoke = this._reflectExtensions.invoke(_implicitlyImportedTypes, "getExtensionClasses");
      Iterables.<Class<? extends Object>>addAll(result, ((List<Class<?>>) _invoke));
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSequentialLoad() throws Exception {
    ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
    final ResourceSetImpl resourceSet = _resourceSetImpl;
    OldJdtTypeProvider _oldJdtTypeProvider = new OldJdtTypeProvider(PerformanceTestProjectSetup.testProject, resourceSet);
    @Extension
    final OldJdtTypeProvider typeProvider = _oldJdtTypeProvider;
    List<Class<? extends Object>> _typesToLoad = this.getTypesToLoad();
    final Function1<Class<? extends Object>,String> _function = new Function1<Class<? extends Object>,String>() {
        public String apply(final Class<? extends Object> it) {
          String _name = it.getName();
          return _name;
        }
      };
    List<String> _map = ListExtensions.<Class<? extends Object>, String>map(_typesToLoad, _function);
    final Procedure1<String> _function_1 = new Procedure1<String>() {
        public void apply(final String it) {
          JvmType _findTypeByName = typeProvider.findTypeByName(it);
          Assert.assertNotNull(_findTypeByName);
        }
      };
    IterableExtensions.<String>forEach(_map, _function_1);
  }
  
  @Ignore("Implementation is obsolete but kept here as a reference")
  @Test
  public void testSequentialLoad300Times() throws Exception {
    IntegerRange _upTo = new IntegerRange(1, 300);
    for (final Integer i : _upTo) {
      this.testSequentialLoad();
    }
  }
  
  @Ignore("Implementation is obsolete but kept here as a reference")
  @Test
  public void testSequentialLoad300TimesAgain() throws Exception {
    this.testSequentialLoad300Times();
  }
  
  @Test
  public void testBulkLoad() throws Exception {
    ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
    final ResourceSetImpl resourceSet = _resourceSetImpl;
    OldJdtTypeProvider _oldJdtTypeProvider = new OldJdtTypeProvider(PerformanceTestProjectSetup.testProject, resourceSet);
    final OldJdtTypeProvider typeProvider = _oldJdtTypeProvider;
    List<Class<? extends Object>> _typesToLoad = this.getTypesToLoad();
    final Function1<Class<? extends Object>,String> _function = new Function1<Class<? extends Object>,String>() {
        public String apply(final Class<? extends Object> it) {
          String _name = it.getName();
          return _name;
        }
      };
    List<String> _map = ListExtensions.<Class<? extends Object>, String>map(_typesToLoad, _function);
    typeProvider.findTypesByName(_map);
  }
  
  @Ignore("Implementation is obsolete but kept here as a reference")
  @Test
  public void testBulkLoad300Times() throws Exception {
    IntegerRange _upTo = new IntegerRange(1, 300);
    for (final Integer i : _upTo) {
      this.testBulkLoad();
    }
  }
  
  @Ignore("Implementation is obsolete but kept here as a reference")
  @Test
  public void testBulkLoad300TimesAgain() throws Exception {
    this.testBulkLoad300Times();
  }
  
  @Test
  public void testSequentialLoadNewImpl() throws Exception {
    ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
    final ResourceSetImpl resourceSet = _resourceSetImpl;
    JdtTypeProvider _jdtTypeProvider = new JdtTypeProvider(PerformanceTestProjectSetup.testProject, resourceSet);
    @Extension
    final JdtTypeProvider typeProvider = _jdtTypeProvider;
    List<Class<? extends Object>> _typesToLoad = this.getTypesToLoad();
    final Function1<Class<? extends Object>,String> _function = new Function1<Class<? extends Object>,String>() {
        public String apply(final Class<? extends Object> it) {
          String _name = it.getName();
          return _name;
        }
      };
    List<String> _map = ListExtensions.<Class<? extends Object>, String>map(_typesToLoad, _function);
    final Procedure1<String> _function_1 = new Procedure1<String>() {
        public void apply(final String it) {
          JvmType _findTypeByName = typeProvider.findTypeByName(it);
          Assert.assertNotNull(_findTypeByName);
        }
      };
    IterableExtensions.<String>forEach(_map, _function_1);
  }
  
  @Test
  public void testSequentialLoadNewImpl300Times() throws Exception {
    IntegerRange _upTo = new IntegerRange(1, 300);
    for (final Integer i : _upTo) {
      this.testSequentialLoadNewImpl();
    }
  }
  
  @Test
  public void testSequentialLoadNewImpl300TimesAgain() throws Exception {
    this.testSequentialLoadNewImpl300Times();
  }
  
  @Test
  public void testBulkLoadNewImpl() throws Exception {
    ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
    final ResourceSetImpl resourceSet = _resourceSetImpl;
    JdtTypeProvider _jdtTypeProvider = new JdtTypeProvider(PerformanceTestProjectSetup.testProject, resourceSet);
    final JdtTypeProvider typeProvider = _jdtTypeProvider;
    List<Class<? extends Object>> _typesToLoad = this.getTypesToLoad();
    final Function1<Class<? extends Object>,String> _function = new Function1<Class<? extends Object>,String>() {
        public String apply(final Class<? extends Object> it) {
          String _name = it.getName();
          return _name;
        }
      };
    List<String> _map = ListExtensions.<Class<? extends Object>, String>map(_typesToLoad, _function);
    typeProvider.findTypesByName(_map);
  }
  
  @Test
  public void testBulkLoadNewImpl300Times() throws Exception {
    IntegerRange _upTo = new IntegerRange(1, 300);
    for (final Integer i : _upTo) {
      this.testBulkLoadNewImpl();
    }
  }
  
  @Test
  public void testBulkLoadNewImpl300TimesAgain() throws Exception {
    this.testBulkLoadNewImpl300Times();
  }
  
  @Ignore("Implementation is obsolete but kept here as a reference")
  @Test
  public void testSequentialLoad300TimesOnceMore() throws Exception {
    this.testSequentialLoad300Times();
  }
  
  @Ignore("Implementation is obsolete but kept here as a reference")
  @Test
  public void testBulkLoad300TimesOnceMore() throws Exception {
    this.testBulkLoad300Times();
  }
  
  @Test
  public void testSequentialLoadNewImpl300TimesOnceMore() throws Exception {
    this.testSequentialLoadNewImpl300Times();
  }
  
  @Test
  public void testBulkLoadNewImpl300TimesOnceMore() throws Exception {
    this.testBulkLoadNewImpl300Times();
  }
  
  @Ignore("Implementation is obsolete but kept here as a reference")
  @Test
  public void testSequentialLoadAgain() throws Exception {
    this.testSequentialLoad();
  }
  
  @Ignore("Implementation is obsolete but kept here as a reference")
  @Test
  public void testBulkLoadAgain() throws Exception {
    this.testBulkLoad();
  }
  
  @Test
  public void testSequentialLoadNewImplAgain() throws Exception {
    this.testSequentialLoadNewImpl();
  }
  
  @Test
  public void testBulkLoadNewImplAgain() throws Exception {
    this.testBulkLoadNewImpl();
  }
  
  @Test
  public void testDummy() throws Exception {
    Assert.assertTrue(true);
  }
}
