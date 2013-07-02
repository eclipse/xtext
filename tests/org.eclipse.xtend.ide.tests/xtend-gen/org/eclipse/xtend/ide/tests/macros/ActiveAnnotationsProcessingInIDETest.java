package org.eclipse.xtend.ide.tests.macros;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.fsaccess.IOUtils;
import org.eclipse.xtend.core.tests.macro.AbstractReusableActiveAnnotationTests;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtend.lib.macro.services.FileHandle;
import org.eclipse.xtend.lib.macro.services.FolderHandle;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XtendIDEInjectorProvider.class)
@SuppressWarnings("all")
public class ActiveAnnotationsProcessingInIDETest extends AbstractReusableActiveAnnotationTests {
  @Inject
  @Extension
  private IEObjectHoverDocumentationProvider documentationProvider;
  
  @Test
  public void testSimpleModification() {
    super.testSimpleModification();
  }
  
  @Test
  public void testDocumetationProvider() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package annotation");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.Active");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.TransformationContext");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.TransformationParticipant");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Active(ChangeDocProcessor)");
    _builder.newLine();
    _builder.append("annotation ChangeDoc {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ChangeDocProcessor implements RegisterGlobalsParticipant<MemberDeclaration>, TransformationParticipant<MutableMemberDeclaration> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override doRegisterGlobals(List<? extends MemberDeclaration> annotatedSourceElements, RegisterGlobalsContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//do nothing");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override doTransform(List<? extends MutableMemberDeclaration> annotatedTargetElements,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("extension TransformationContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (it : annotatedTargetElements) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("docComment = \"Hello World!\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String,String> _mappedTo = Pair.<String, String>of("annotation/ChangeDoc.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package usercode");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import annotation.ChangeDoc");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/** ");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*\t Comment");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("@ChangeDoc");
    _builder_1.newLine();
    _builder_1.append("class UserClass {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/** ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("* Comment");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@ChangeDoc");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("private Object object");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/** ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("* Comment");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("private Object object2");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/** ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("* Comment");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@ChangeDoc");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("new() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this(new Object, new Object)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/** ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("* Comment");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("new(Object object, Object object2) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.object = object");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.object2 = object2");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/** ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("* Comment");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@ChangeDoc");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def op() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/** ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("* Comment");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def op2() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("usercode/UserCode.xtend", _builder_1.toString());
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
        public void apply(final CompilationUnitImpl it) {
          XtendFile _xtendFile = it.getXtendFile();
          EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
          Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
          final XtendClass xtendClass = IterableExtensions.<XtendClass>head(_filter);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("@<a href=\"eclipse-xtext-doc:platform:/resource/macroProject/src/annotation/ChangeDoc.xtend%23/1\">ChangeDoc</a><br>Hello World!");
          String _string = _builder.toString();
          String _documentation = ActiveAnnotationsProcessingInIDETest.this.documentationProvider.getDocumentation(xtendClass);
          Assert.assertEquals(_string, _documentation);
          EList<XtendMember> _members = xtendClass.getMembers();
          Iterable<XtendField> _filter_1 = Iterables.<XtendField>filter(_members, XtendField.class);
          final Function1<XtendField,Boolean> _function = new Function1<XtendField,Boolean>() {
              public Boolean apply(final XtendField it) {
                String _name = it.getName();
                boolean _equals = _name.equals("object");
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<XtendField> _filter_2 = IterableExtensions.<XtendField>filter(_filter_1, _function);
          final XtendField objectField = IterableExtensions.<XtendField>head(_filter_2);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("@<a href=\"eclipse-xtext-doc:platform:/resource/macroProject/src/annotation/ChangeDoc.xtend%23/1\">ChangeDoc</a><br>Hello World!");
          String _string_1 = _builder_1.toString();
          String _documentation_1 = ActiveAnnotationsProcessingInIDETest.this.documentationProvider.getDocumentation(objectField);
          Assert.assertEquals(_string_1, _documentation_1);
          EList<XtendMember> _members_1 = xtendClass.getMembers();
          Iterable<XtendField> _filter_3 = Iterables.<XtendField>filter(_members_1, XtendField.class);
          final Function1<XtendField,Boolean> _function_1 = new Function1<XtendField,Boolean>() {
              public Boolean apply(final XtendField it) {
                String _name = it.getName();
                boolean _equals = _name.equals("object2");
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<XtendField> _filter_4 = IterableExtensions.<XtendField>filter(_filter_3, _function_1);
          final XtendField objectField2 = IterableExtensions.<XtendField>head(_filter_4);
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("Comment");
          String _string_2 = _builder_2.toString();
          String _documentation_2 = ActiveAnnotationsProcessingInIDETest.this.documentationProvider.getDocumentation(objectField2);
          Assert.assertEquals(_string_2, _documentation_2);
          EList<XtendMember> _members_2 = xtendClass.getMembers();
          Iterable<XtendConstructor> _filter_5 = Iterables.<XtendConstructor>filter(_members_2, XtendConstructor.class);
          final Function1<XtendConstructor,Boolean> _function_2 = new Function1<XtendConstructor,Boolean>() {
              public Boolean apply(final XtendConstructor it) {
                EList<XtendParameter> _parameters = it.getParameters();
                boolean _isEmpty = _parameters.isEmpty();
                return Boolean.valueOf(_isEmpty);
              }
            };
          Iterable<XtendConstructor> _filter_6 = IterableExtensions.<XtendConstructor>filter(_filter_5, _function_2);
          final XtendConstructor constructor = IterableExtensions.<XtendConstructor>head(_filter_6);
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("@<a href=\"eclipse-xtext-doc:platform:/resource/macroProject/src/annotation/ChangeDoc.xtend%23/1\">ChangeDoc</a><br>Hello World!");
          String _string_3 = _builder_3.toString();
          String _documentation_3 = ActiveAnnotationsProcessingInIDETest.this.documentationProvider.getDocumentation(constructor);
          Assert.assertEquals(_string_3, _documentation_3);
          EList<XtendMember> _members_3 = xtendClass.getMembers();
          Iterable<XtendConstructor> _filter_7 = Iterables.<XtendConstructor>filter(_members_3, XtendConstructor.class);
          final Function1<XtendConstructor,Boolean> _function_3 = new Function1<XtendConstructor,Boolean>() {
              public Boolean apply(final XtendConstructor it) {
                EList<XtendParameter> _parameters = it.getParameters();
                int _size = _parameters.size();
                boolean _equals = (_size == 2);
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<XtendConstructor> _filter_8 = IterableExtensions.<XtendConstructor>filter(_filter_7, _function_3);
          final XtendConstructor constructor2 = IterableExtensions.<XtendConstructor>head(_filter_8);
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("Comment<dl><dt>Parameters:</dt><dd><b>object</b> </dd><dd><b>object2</b> </dd></dl>");
          String _string_4 = _builder_4.toString();
          String _documentation_4 = ActiveAnnotationsProcessingInIDETest.this.documentationProvider.getDocumentation(constructor2);
          Assert.assertEquals(_string_4, _documentation_4);
          EList<XtendMember> _members_4 = xtendClass.getMembers();
          Iterable<XtendFunction> _filter_9 = Iterables.<XtendFunction>filter(_members_4, XtendFunction.class);
          final Function1<XtendFunction,Boolean> _function_4 = new Function1<XtendFunction,Boolean>() {
              public Boolean apply(final XtendFunction it) {
                String _name = it.getName();
                boolean _equals = _name.equals("op");
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<XtendFunction> _filter_10 = IterableExtensions.<XtendFunction>filter(_filter_9, _function_4);
          final XtendFunction opFunction = IterableExtensions.<XtendFunction>head(_filter_10);
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append("@<a href=\"eclipse-xtext-doc:platform:/resource/macroProject/src/annotation/ChangeDoc.xtend%23/1\">ChangeDoc</a><br>Hello World!");
          String _string_5 = _builder_5.toString();
          String _documentation_5 = ActiveAnnotationsProcessingInIDETest.this.documentationProvider.getDocumentation(opFunction);
          Assert.assertEquals(_string_5, _documentation_5);
          EList<XtendMember> _members_5 = xtendClass.getMembers();
          Iterable<XtendFunction> _filter_11 = Iterables.<XtendFunction>filter(_members_5, XtendFunction.class);
          final Function1<XtendFunction,Boolean> _function_5 = new Function1<XtendFunction,Boolean>() {
              public Boolean apply(final XtendFunction it) {
                String _name = it.getName();
                boolean _equals = _name.equals("op2");
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<XtendFunction> _filter_12 = IterableExtensions.<XtendFunction>filter(_filter_11, _function_5);
          final XtendFunction op2Function = IterableExtensions.<XtendFunction>head(_filter_12);
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append("Comment");
          String _string_6 = _builder_6.toString();
          String _documentation_6 = ActiveAnnotationsProcessingInIDETest.this.documentationProvider.getDocumentation(op2Function);
          Assert.assertEquals(_string_6, _documentation_6);
        }
      };
    this.assertProcessing(_mappedTo, _mappedTo_1, _function);
  }
  
  @Test
  public void testFileSystemAccess() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package myusercode");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@myannotation.MyAnnotation");
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String userCodeContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package myannotation");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.lib.macro.Active");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.lib.macro.TransformationContext");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Active(typeof(MyAnnotationProcessor))");
    _builder_1.newLine();
    _builder_1.append("annotation MyAnnotation{ }");
    _builder_1.newLine();
    _builder_1.append("class MyAnnotationProcessor extends AbstractClassProcessor {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String,String> _mappedTo = Pair.<String, String>of("myannotation/MyAnnotation.xtend", _builder_1.toString());
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("myusercode/UserCode.xtend", userCodeContent);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
        public void apply(final CompilationUnitImpl it) {
          FolderHandle _sourceFolder = it.getSourceFolder();
          Assert.assertNotNull(_sourceFolder);
          FolderHandle _sourceFolder_1 = it.getSourceFolder();
          boolean _exists = _sourceFolder_1.exists();
          Assert.assertTrue(_exists);
          FolderHandle _sourceFolder_2 = it.getSourceFolder();
          String _name = _sourceFolder_2.getName();
          Assert.assertEquals("src", _name);
          FolderHandle _sourceFolder_3 = it.getSourceFolder();
          String _path = _sourceFolder_3.getPath();
          boolean _endsWith = _path.endsWith("/userProject/src");
          Assert.assertTrue(_endsWith);
          FolderHandle _targetFolder = it.getTargetFolder();
          Assert.assertNotNull(_targetFolder);
          FolderHandle _targetFolder_1 = it.getTargetFolder();
          boolean _exists_1 = _targetFolder_1.exists();
          Assert.assertTrue(_exists_1);
          FolderHandle _targetFolder_2 = it.getTargetFolder();
          String _name_1 = _targetFolder_2.getName();
          Assert.assertEquals("xtend-gen", _name_1);
          FolderHandle _targetFolder_3 = it.getTargetFolder();
          String _path_1 = _targetFolder_3.getPath();
          boolean _endsWith_1 = _path_1.endsWith("/userProject/xtend-gen");
          Assert.assertTrue(_endsWith_1);
          FolderHandle _rootFolder = it.getRootFolder();
          Assert.assertNotNull(_rootFolder);
          FolderHandle _rootFolder_1 = it.getRootFolder();
          boolean _exists_2 = _rootFolder_1.exists();
          Assert.assertTrue(_exists_2);
          FolderHandle _rootFolder_2 = it.getRootFolder();
          String _name_2 = _rootFolder_2.getName();
          Assert.assertEquals("userProject", _name_2);
          FolderHandle _rootFolder_3 = it.getRootFolder();
          String _path_2 = _rootFolder_3.getPath();
          boolean _endsWith_2 = _path_2.endsWith("/userProject");
          Assert.assertTrue(_endsWith_2);
          FolderHandle _sourceFolder_4 = it.getSourceFolder();
          final FolderHandle myusercodeFolder = _sourceFolder_4.getFolder("myusercode");
          Assert.assertNotNull(myusercodeFolder);
          boolean _exists_3 = myusercodeFolder.exists();
          Assert.assertTrue(_exists_3);
          String _name_3 = myusercodeFolder.getName();
          Assert.assertEquals("myusercode", _name_3);
          String _path_3 = myusercodeFolder.getPath();
          boolean _endsWith_3 = _path_3.endsWith("/userProject/src/myusercode");
          Assert.assertTrue(_endsWith_3);
          try {
            FolderHandle _sourceFolder_5 = it.getSourceFolder();
            _sourceFolder_5.getFolder("myusercode/UserCode.xtend");
            Assert.fail();
          } catch (final Throwable _t) {
            if (_t instanceof IllegalStateException) {
              final IllegalStateException e = (IllegalStateException)_t;
              String _message = e.getMessage();
              boolean _contains = _message.contains("/userProject/src/myusercode/UserCode.xtend");
              Assert.assertTrue(_contains);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          FolderHandle _sourceFolder_6 = it.getSourceFolder();
          final FileHandle userCodeFile = _sourceFolder_6.getFile("myusercode/UserCode.xtend");
          Assert.assertNotNull(userCodeFile);
          boolean _exists_4 = userCodeFile.exists();
          Assert.assertTrue(_exists_4);
          String _name_4 = userCodeFile.getName();
          Assert.assertEquals("UserCode.xtend", _name_4);
          String _path_4 = userCodeFile.getPath();
          boolean _endsWith_4 = _path_4.endsWith("/userProject/src/myusercode/UserCode.xtend");
          Assert.assertTrue(_endsWith_4);
          try {
            FolderHandle _sourceFolder_7 = it.getSourceFolder();
            _sourceFolder_7.getFile("myusercode");
            Assert.fail();
          } catch (final Throwable _t_1) {
            if (_t_1 instanceof IllegalStateException) {
              final IllegalStateException e_1 = (IllegalStateException)_t_1;
              String _message_1 = e_1.getMessage();
              boolean _contains_1 = _message_1.contains("/userProject/src/myusercode");
              Assert.assertTrue(_contains_1);
            } else {
              throw Exceptions.sneakyThrow(_t_1);
            }
          }
          String _contents = userCodeFile.getContents();
          Assert.assertEquals(userCodeContent, _contents);
          final Procedure1<InputStream> _function = new Procedure1<InputStream>() {
              public void apply(final InputStream it) {
                String _asString = IOUtils.asString(it);
                Assert.assertEquals(userCodeContent, _asString);
              }
            };
          userCodeFile.read(_function);
          FolderHandle _sourceFolder_8 = it.getSourceFolder();
          final FileHandle userCodeCss = _sourceFolder_8.getFile("myusercode/UserCode.css");
          Assert.assertNotNull(userCodeCss);
          boolean _exists_5 = userCodeCss.exists();
          Assert.assertFalse(_exists_5);
          String _name_5 = userCodeCss.getName();
          Assert.assertEquals("UserCode.css", _name_5);
          String _path_5 = userCodeCss.getPath();
          boolean _endsWith_5 = _path_5.endsWith("/userProject/src/myusercode/UserCode.css");
          Assert.assertTrue(_endsWith_5);
          final String helloWorldCssClassDeclaration = ".helloWorldCssClass {}";
          final Function1<FileHandle,CharSequence> _function_1 = new Function1<FileHandle,CharSequence>() {
              public CharSequence apply(final FileHandle it) {
                return ((CharSequence) helloWorldCssClassDeclaration);
              }
            };
          userCodeCss.writeContents(_function_1);
          FolderHandle _sourceFolder_9 = it.getSourceFolder();
          final FileHandle userCodeCss2 = _sourceFolder_9.getFile("myusercode/UserCode.css");
          Assert.assertNotNull(userCodeCss2);
          boolean _exists_6 = userCodeCss2.exists();
          Assert.assertTrue(_exists_6);
          String _contents_1 = userCodeCss2.getContents();
          Assert.assertEquals(helloWorldCssClassDeclaration, _contents_1);
          FolderHandle _sourceFolder_10 = it.getSourceFolder();
          final FileHandle userCode2Css = _sourceFolder_10.getFile("com/itemis/myusercode/UserCode2.css");
          Assert.assertNotNull(userCode2Css);
          boolean _exists_7 = userCode2Css.exists();
          Assert.assertFalse(_exists_7);
          String _name_6 = userCode2Css.getName();
          Assert.assertEquals("UserCode2.css", _name_6);
          String _path_6 = userCode2Css.getPath();
          boolean _endsWith_6 = _path_6.endsWith("/userProject/src/com/itemis/myusercode/UserCode2.css");
          Assert.assertTrue(_endsWith_6);
          final Procedure1<OutputStream> _function_2 = new Procedure1<OutputStream>() {
              public void apply(final OutputStream it) {
                final Function0<BufferedWriter> _function = new Function0<BufferedWriter>() {
                    public BufferedWriter apply() {
                      OutputStreamWriter _writer = IOUtils.getWriter(it);
                      BufferedWriter _buffered = IOUtils.getBuffered(_writer);
                      return _buffered;
                    }
                  };
                final Procedure1<BufferedWriter> _function_1 = new Procedure1<BufferedWriter>() {
                    public void apply(final BufferedWriter it) {
                      try {
                        it.write(helloWorldCssClassDeclaration);
                      } catch (Throwable _e) {
                        throw Exceptions.sneakyThrow(_e);
                      }
                    }
                  };
                IOUtils.<BufferedWriter>tryWith(_function, _function_1);
              }
            };
          userCode2Css.write(_function_2);
          FolderHandle _sourceFolder_11 = it.getSourceFolder();
          final FileHandle userCode2Css2 = _sourceFolder_11.getFile("com/itemis/myusercode/UserCode2.css");
          Assert.assertNotNull(userCode2Css2);
          boolean _exists_8 = userCode2Css2.exists();
          Assert.assertTrue(_exists_8);
          String _contents_2 = userCode2Css2.getContents();
          Assert.assertEquals(helloWorldCssClassDeclaration, _contents_2);
        }
      };
    this.assertProcessing(_mappedTo, _mappedTo_1, _function);
  }
  
  @Inject
  private XtextResourceSetProvider resourceSetProvider;
  
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;
  
  @Rule
  public StopwatchRule stopwatch = new Function0<StopwatchRule>() {
    public StopwatchRule apply() {
      StopwatchRule _stopwatchRule = new StopwatchRule(true);
      return _stopwatchRule;
    }
  }.apply();
  
  @After
  public void tearDown() throws Exception {
    this.macroProject = null;
    this.userProject = null;
    this.sourceFile = null;
    IResourcesSetupUtil.cleanWorkspace();
  }
  
  private IJavaProject macroProject;
  
  private IJavaProject userProject;
  
  private IFile sourceFile;
  
  public void assertProcessing(final Pair<String,String> macroFile, final Pair<String,String> clientFile, final Procedure1<? super CompilationUnitImpl> expectations) {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("macroProject");
      IJavaProject _create = JavaCore.create(_createPluginProject);
      this.macroProject = _create;
      String _key = macroFile.getKey();
      String _value = macroFile.getValue();
      String _string = _value.toString();
      this.newSource(this.macroProject, _key, _string);
      String _key_1 = macroFile.getKey();
      final int lidx = _key_1.lastIndexOf("/");
      int _minus = (-1);
      boolean _notEquals = (lidx != _minus);
      if (_notEquals) {
        String _key_2 = macroFile.getKey();
        String _substring = _key_2.substring(0, lidx);
        final String packageName = _substring.replace("/", ".");
        this.addExportedPackage(this.macroProject, packageName);
      }
      IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit4", "macroProject");
      IJavaProject _create_1 = JavaCore.create(_createPluginProject_1);
      this.userProject = _create_1;
      String _key_3 = clientFile.getKey();
      String _value_1 = clientFile.getValue();
      String _string_1 = _value_1.toString();
      IFile _newSource = this.newSource(this.userProject, _key_3, _string_1);
      this.sourceFile = _newSource;
      IResourcesSetupUtil.waitForAutoBuild();
      IProject _project = this.userProject.getProject();
      final ResourceSet resourceSet = this.resourceSetProvider.get(_project);
      IPath _fullPath = this.sourceFile.getFullPath();
      String _string_2 = _fullPath.toString();
      URI _createPlatformResourceURI = URI.createPlatformResourceURI(_string_2, true);
      final Resource resource = resourceSet.getResource(_createPlatformResourceURI, true);
      final CompilationUnitImpl unit = this.compilationUnitProvider.get();
      EList<EObject> _contents = resource.getContents();
      Iterable<XtendFile> _filter = Iterables.<XtendFile>filter(_contents, XtendFile.class);
      XtendFile _head = IterableExtensions.<XtendFile>head(_filter);
      unit.setXtendFile(_head);
      expectations.apply(unit);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IFile newSource(final IJavaProject it, final String fileName, final String contents) {
    try {
      IProject _project = it.getProject();
      String _plus = ("src/" + fileName);
      final IFile result = _project.getFile(_plus);
      IContainer parent = result.getParent();
      boolean _exists = parent.exists();
      boolean _not = (!_exists);
      boolean _while = _not;
      while (_while) {
        ((IFolder) parent).create(true, false, null);
        boolean _exists_1 = parent.exists();
        boolean _not_1 = (!_exists_1);
        _while = _not_1;
      }
      StringInputStream _stringInputStream = new StringInputStream(contents);
      result.create(_stringInputStream, true, null);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void addExportedPackage(final IJavaProject pluginProject, final String... exportedPackages) {
    try {
      IProject _project = pluginProject.getProject();
      final IFile manifestFile = _project.getFile("META-INF/MANIFEST.MF");
      InputStream _contents = manifestFile.getContents();
      Manifest _manifest = new Manifest(_contents);
      final Manifest manifest = _manifest;
      final Attributes attrs = manifest.getMainAttributes();
      boolean _containsKey = attrs.containsKey("Export-Package");
      if (_containsKey) {
        Object _get = attrs.get("Export-Package");
        String _plus = (_get + ",");
        String _join = IterableExtensions.join(((Iterable<? extends Object>)Conversions.doWrapArray(exportedPackages)), ",");
        String _plus_1 = (_plus + _join);
        attrs.putValue("Export-Package", _plus_1);
      } else {
        String _join_1 = IterableExtensions.join(((Iterable<? extends Object>)Conversions.doWrapArray(exportedPackages)), ",");
        attrs.putValue("Export-Package", _join_1);
      }
      ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
      final ByteArrayOutputStream out = _byteArrayOutputStream;
      manifest.write(out);
      byte[] _byteArray = out.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ByteArrayInputStream in = _byteArrayInputStream;
      BufferedInputStream _bufferedInputStream = new BufferedInputStream(in);
      manifestFile.setContents(_bufferedInputStream, true, true, null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
