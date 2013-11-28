package org.eclipse.xtend.core.tests.macro.declaration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.TypeLookupImpl;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.services.ProblemSupport;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ProblemSupportTests extends AbstractXtendTestCase {
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;
  
  @Test
  public void testErrorOnSource() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String foo = \'foo\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      public void apply(final CompilationUnitImpl it) {
        ProblemSupport _problemSupport = it.getProblemSupport();
        Iterable<? extends TypeDeclaration> _sourceTypeDeclarations = it.getSourceTypeDeclarations();
        TypeDeclaration _head = IterableExtensions.head(_sourceTypeDeclarations);
        _problemSupport.addError(_head, "error on source");
        XtendFile _xtendFile = it.getXtendFile();
        Resource _eResource = _xtendFile.eResource();
        EList<Resource.Diagnostic> _errors = _eResource.getErrors();
        Resource.Diagnostic _head_1 = IterableExtensions.<Resource.Diagnostic>head(_errors);
        String _message = _head_1.getMessage();
        Assert.assertEquals("error on source", _message);
        XtendFile _xtendFile_1 = it.getXtendFile();
        EList<XtendTypeDeclaration> _xtendTypes = _xtendFile_1.getXtendTypes();
        XtendTypeDeclaration _head_2 = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
        XtendFile _xtendFile_2 = it.getXtendFile();
        Resource _eResource_1 = _xtendFile_2.eResource();
        EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
        Resource.Diagnostic _head_3 = IterableExtensions.<Resource.Diagnostic>head(_errors_1);
        EObject _problematicObject = ((EObjectDiagnosticImpl) _head_3).getProblematicObject();
        Assert.assertEquals(_head_2, _problematicObject);
      }
    };
    this.asCompilationUnit(_validFile, _function);
  }
  
  @Test
  public void testErrorOnDerivedElement() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String foo = \'foo\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      public void apply(final CompilationUnitImpl it) {
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        final MutableClassDeclaration derived = _typeLookup.findClass("MyClass");
        ProblemSupport _problemSupport = it.getProblemSupport();
        _problemSupport.addError(derived, "error on derived element");
        XtendFile _xtendFile = it.getXtendFile();
        Resource _eResource = _xtendFile.eResource();
        EList<Resource.Diagnostic> _errors = _eResource.getErrors();
        Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(_errors);
        String _message = _head.getMessage();
        Assert.assertEquals("error on derived element", _message);
        XtendFile _xtendFile_1 = it.getXtendFile();
        EList<XtendTypeDeclaration> _xtendTypes = _xtendFile_1.getXtendTypes();
        XtendTypeDeclaration _head_1 = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
        XtendFile _xtendFile_2 = it.getXtendFile();
        Resource _eResource_1 = _xtendFile_2.eResource();
        EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
        Resource.Diagnostic _head_2 = IterableExtensions.<Resource.Diagnostic>head(_errors_1);
        EObject _problematicObject = ((EObjectDiagnosticImpl) _head_2).getProblematicObject();
        Assert.assertEquals(_head_1, _problematicObject);
      }
    };
    this.asCompilationUnit(_validFile, _function);
  }
  
  public XtendFile validFile(final CharSequence code) {
    try {
      String _string = code.toString();
      XtendFile _file = this.file(_string, true);
      return _file;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void asCompilationUnit(final XtendFile file, final Procedure1<? super CompilationUnitImpl> block) {
    final CompilationUnitImpl compilationUnit = this.compilationUnitProvider.get();
    compilationUnit.setXtendFile(file);
    block.apply(compilationUnit);
  }
}
