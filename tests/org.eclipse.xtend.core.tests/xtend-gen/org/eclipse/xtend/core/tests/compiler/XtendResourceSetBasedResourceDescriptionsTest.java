package org.eclipse.xtend.core.tests.compiler;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.resource.XbaseResource;
import org.junit.Assert;
import org.junit.Test;

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
      Pair<String,CharSequence> _mappedTo = Pair.<String, CharSequence>of("foo/ClassA.xtend", _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package bar class ClassB { public foo.ClassA myField }");
      Pair<String,CharSequence> _mappedTo_1 = Pair.<String, CharSequence>of("bar/ClassB.xtend", _builder_1);
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
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnloadedBidirectionalRef() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo class ClassA extends bar.ClassB {}");
      Pair<String,CharSequence> _mappedTo = Pair.<String, CharSequence>of("foo/ClassA.xtend", _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package bar class ClassB { public foo.ClassA myField }");
      Pair<String,CharSequence> _mappedTo_1 = Pair.<String, CharSequence>of("bar/ClassB.xtend", _builder_1);
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
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnloadedInstallDerivedStateThrowsException() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo class ClassA extends bar.ClassB {}");
      Pair<String,CharSequence> _mappedTo = Pair.<String, CharSequence>of("foo/ClassA.xtend", _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package bar class ClassB { public foo.ClassA myField }");
      Pair<String,CharSequence> _mappedTo_1 = Pair.<String, CharSequence>of("bar/ClassB.xtend", _builder_1);
      final ResourceSet resourceSet = this.compiler.unLoadedResourceSet(_mappedTo, _mappedTo_1);
      final List<? extends Resource> resources = resourceSet.getResources();
      ArrayList<Resource> _arrayList = new ArrayList<Resource>(resources);
      for (final Resource res : _arrayList) {
        {
          boolean _isLoaded = res.isLoaded();
          Assert.assertFalse(_isLoaded);
          try {
            ((XbaseResource) res).installDerivedState(true);
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
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
