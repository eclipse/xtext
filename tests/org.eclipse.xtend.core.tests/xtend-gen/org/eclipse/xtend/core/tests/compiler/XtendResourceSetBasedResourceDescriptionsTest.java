/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendResourceSetBasedResourceDescriptionsTest extends AbstractXtendTestCase {
  @Inject
  private CompilationTestHelper compiler;
  
  @Inject
  private IResourceValidator validator;
  
  @Test
  public void testBidirectionalRef() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo class ClassA extends bar.ClassB {}");
      Pair<String, String> _mappedTo = Pair.<String, String>of("foo/ClassA.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package bar class ClassB { public foo.ClassA myField }");
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("bar/ClassB.xtend", _builder_1.toString());
      final ResourceSet resourceSet = this.compiler.resourceSet(_mappedTo, _mappedTo_1);
      final List<? extends Resource> resources = resourceSet.getResources();
      ArrayList<Resource> _arrayList = new ArrayList<Resource>(resources);
      for (final Resource res : _arrayList) {
        {
          final List<Issue> issues = this.validator.validate(res, CheckMode.ALL, CancelIndicator.NullImpl);
          String _string = issues.toString();
          boolean _isEmpty = issues.isEmpty();
          Assert.assertTrue(_string, _isEmpty);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnloadedBidirectionalRef() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo class ClassA extends bar.ClassB {}");
      Pair<String, String> _mappedTo = Pair.<String, String>of("foo/ClassA.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package bar class ClassB { public foo.ClassA myField }");
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("bar/ClassB.xtend", _builder_1.toString());
      final ResourceSet resourceSet = this.compiler.unLoadedResourceSet(_mappedTo, _mappedTo_1);
      final List<? extends Resource> resources = resourceSet.getResources();
      ArrayList<Resource> _arrayList = new ArrayList<Resource>(resources);
      for (final Resource res : _arrayList) {
        {
          final List<Issue> issues = this.validator.validate(res, CheckMode.ALL, CancelIndicator.NullImpl);
          String _string = issues.toString();
          boolean _isEmpty = issues.isEmpty();
          Assert.assertTrue(_string, _isEmpty);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnloadedInstallDerivedStateThrowsException() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo class ClassA extends bar.ClassB {}");
      Pair<String, String> _mappedTo = Pair.<String, String>of("foo/ClassA.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package bar class ClassB { public foo.ClassA myField }");
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("bar/ClassB.xtend", _builder_1.toString());
      final ResourceSet resourceSet = this.compiler.unLoadedResourceSet(_mappedTo, _mappedTo_1);
      final List<? extends Resource> resources = resourceSet.getResources();
      ArrayList<Resource> _arrayList = new ArrayList<Resource>(resources);
      for (final Resource res : _arrayList) {
        {
          boolean _isLoaded = res.isLoaded();
          Assert.assertFalse(_isLoaded);
          try {
            ((DerivedStateAwareResource) res).installDerivedState(true);
            Assert.fail("expected exception");
          } catch (final Throwable _t) {
            if (_t instanceof IllegalStateException) {
              final IllegalStateException e = (IllegalStateException)_t;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
