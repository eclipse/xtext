package org.eclipse.xtend.macro.lang;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.macro.lang.MacroInjectorProvider;
import org.eclipse.xtend.macro.lang.MacroTestExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = MacroInjectorProvider.class)
@SuppressWarnings("all")
public class ValidationTest {
  @Inject
  private CompilationTestHelper _compilationTestHelper;
  
  @Inject
  private MacroTestExtensions _macroTestExtensions;
  
  @Test
  public void testValidationError() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@MyAnnotation class Foo {}");
      _builder.newLine();
      Pair<String,CharSequence> _xtend = this._macroTestExtensions.xtend(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@MyAnnotation for class {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("foo // compile error");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String,CharSequence> _macro = this._macroTestExtensions.macro(_builder_1);
      final ResourceSet resourceSet = this._compilationTestHelper.resourceSet(_xtend, _macro);
      EcoreUtil.resolveAll(resourceSet);
      EList<Resource> _resources = resourceSet.getResources();
      final Function1<Resource,Boolean> _function = new Function1<Resource,Boolean>() {
          public Boolean apply(final Resource it) {
            URI _uRI = it.getURI();
            String _fileExtension = _uRI.fileExtension();
            boolean _equals = Objects.equal(_fileExtension, "xtend");
            return Boolean.valueOf(_equals);
          }
        };
      Resource _findFirst = IterableExtensions.<Resource>findFirst(_resources, _function);
      EList<Diagnostic> _errors = _findFirst.getErrors();
      Diagnostic _head = IterableExtensions.<Diagnostic>head(_errors);
      String _message = _head.getMessage();
      boolean _contains = _message.contains("macro");
      Assert.assertTrue(_contains);
      EList<Resource> _resources_1 = resourceSet.getResources();
      final Function1<Resource,Boolean> _function_1 = new Function1<Resource,Boolean>() {
          public Boolean apply(final Resource it) {
            URI _uRI = it.getURI();
            String _fileExtension = _uRI.fileExtension();
            boolean _equals = Objects.equal(_fileExtension, "macro");
            return Boolean.valueOf(_equals);
          }
        };
      Resource _findFirst_1 = IterableExtensions.<Resource>findFirst(_resources_1, _function_1);
      EList<Diagnostic> _errors_1 = _findFirst_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertFalse(_isEmpty);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testValidationError_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@MyAnnotation class Foo {}");
      _builder.newLine();
      Pair<String,CharSequence> _xtend = this._macroTestExtensions.xtend(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@MyAnnotation for class {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("process {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("throw new NullPointerException(\"name : \"+elements.head.name)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String,CharSequence> _macro = this._macroTestExtensions.macro(_builder_1);
      final ResourceSet resourceSet = this._compilationTestHelper.resourceSet(_xtend, _macro);
      EcoreUtil.resolveAll(resourceSet);
      EList<Resource> _resources = resourceSet.getResources();
      final Function1<Resource,Boolean> _function = new Function1<Resource,Boolean>() {
          public Boolean apply(final Resource it) {
            URI _uRI = it.getURI();
            String _fileExtension = _uRI.fileExtension();
            boolean _equals = Objects.equal(_fileExtension, "xtend");
            return Boolean.valueOf(_equals);
          }
        };
      Resource _findFirst = IterableExtensions.<Resource>findFirst(_resources, _function);
      EList<Diagnostic> _errors = _findFirst.getErrors();
      Diagnostic _head = IterableExtensions.<Diagnostic>head(_errors);
      final String message = _head.getMessage();
      boolean _contains = message.contains("name : Foo");
      Assert.assertTrue(_contains);
      boolean _contains_1 = message.contains("throw new NullPointerException");
      Assert.assertTrue(_contains_1);
      EList<Resource> _resources_1 = resourceSet.getResources();
      final Function1<Resource,Boolean> _function_1 = new Function1<Resource,Boolean>() {
          public Boolean apply(final Resource it) {
            URI _uRI = it.getURI();
            String _fileExtension = _uRI.fileExtension();
            boolean _equals = Objects.equal(_fileExtension, "macro");
            return Boolean.valueOf(_equals);
          }
        };
      Resource _findFirst_1 = IterableExtensions.<Resource>findFirst(_resources_1, _function_1);
      EList<Diagnostic> _errors_1 = _findFirst_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_isEmpty);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testValidationError_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@MyAnnotation class Foo {}");
      _builder.newLine();
      Pair<String,CharSequence> _xtend = this._macroTestExtensions.xtend(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@MyAnnotation for method {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("process {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String,CharSequence> _macro = this._macroTestExtensions.macro(_builder_1);
      final ResourceSet resourceSet = this._compilationTestHelper.resourceSet(_xtend, _macro);
      EcoreUtil.resolveAll(resourceSet);
      EList<Resource> _resources = resourceSet.getResources();
      final Function1<Resource,Boolean> _function = new Function1<Resource,Boolean>() {
          public Boolean apply(final Resource it) {
            URI _uRI = it.getURI();
            String _fileExtension = _uRI.fileExtension();
            boolean _equals = Objects.equal(_fileExtension, "xtend");
            return Boolean.valueOf(_equals);
          }
        };
      Resource _findFirst = IterableExtensions.<Resource>findFirst(_resources, _function);
      EList<Diagnostic> _errors = _findFirst.getErrors();
      Diagnostic _head = IterableExtensions.<Diagnostic>head(_errors);
      final String message = _head.getMessage();
      boolean _contains = message.contains("MyAnnotation");
      Assert.assertTrue(_contains);
      boolean _contains_1 = message.contains("method");
      Assert.assertTrue(_contains_1);
      EList<Resource> _resources_1 = resourceSet.getResources();
      final Function1<Resource,Boolean> _function_1 = new Function1<Resource,Boolean>() {
          public Boolean apply(final Resource it) {
            URI _uRI = it.getURI();
            String _fileExtension = _uRI.fileExtension();
            boolean _equals = Objects.equal(_fileExtension, "macro");
            return Boolean.valueOf(_equals);
          }
        };
      Resource _findFirst_1 = IterableExtensions.<Resource>findFirst(_resources_1, _function_1);
      EList<Diagnostic> _errors_1 = _findFirst_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_isEmpty);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
