/**
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import com.google.common.collect.Iterables;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.AnnotationProcessor;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.util.TemporaryFolder;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.ProjectConfigAdapter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class ActiveAnnotationsRuntimeTest extends AbstractReusableActiveAnnotationTests {
  @Rule
  @Inject
  public TemporaryFolder temporaryFolder;

  @Inject
  private CompilationTestHelper compiler;

  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;

  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;

  @Inject
  private ValidationTestHelper validator;

  private final String macroProject = "macroProject";

  private final String clientProject = "userProject";

  private File workspaceRoot;

  @Before
  public void setUp() {
    this.compiler.setJavaCompilerClassPath(ActiveAnnotationsRuntimeTest.class.getClassLoader());
    this.configureFreshWorkspace();
  }

  protected void configureFreshWorkspace() {
    this.workspaceRoot = this.createFreshTempDir();
  }

  protected File createFreshTempDir() {
    try {
      return this.temporaryFolder.newFolder();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected URI copyToDisk(final String projectName, final Pair<String, String> fileRepresentation) {
    try {
      String _key = fileRepresentation.getKey();
      String _plus = ((projectName + "/src/") + _key);
      final File file = new File(this.workspaceRoot, _plus);
      file.getParentFile().mkdirs();
      Files.asCharSink(file, Charset.defaultCharset()).write(fileRepresentation.getValue());
      return URI.createFileURI(file.getPath());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Override
  public void assertProcessing(final Pair<String, String> macroFile, final Pair<String, String> clientFile, final Procedure1<? super CompilationUnitImpl> expectations) {
    try {
      final XtextResourceSet resourceSet = this.compileMacroResourceSet(macroFile, clientFile);
      final Resource singleResource = IterableExtensions.<Resource>head(resourceSet.getResources());
      singleResource.load(CollectionLiterals.<Object, Object>emptyMap());
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        it.getGeneratedCode();
        final CompilationUnitImpl unit = this.compilationUnitProvider.get();
        final XtendFile xtendFile = IterableExtensions.<XtendFile>head(Iterables.<XtendFile>filter(singleResource.getContents(), XtendFile.class));
        unit.setXtendFile(xtendFile);
        expectations.apply(unit);
      };
      this.compiler.compile(resourceSet, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void assertIssues(final Pair<String, String> macroFile, final Pair<String, String> clientFile, final Procedure1<? super List<Issue>> expectations) {
    try {
      final XtextResourceSet resourceSet = this.compileMacroResourceSet(macroFile, clientFile);
      Resource _head = IterableExtensions.<Resource>head(resourceSet.getResources());
      final XtextResource singleResource = ((XtextResource) _head);
      boolean _isLoaded = singleResource.isLoaded();
      boolean _not = (!_isLoaded);
      if (_not) {
        singleResource.load(resourceSet.getLoadOptions());
      }
      final IResourceValidator validator = singleResource.getResourceServiceProvider().getResourceValidator();
      expectations.apply(validator.validate(singleResource, CheckMode.ALL, CancelIndicator.NullImpl));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public XtextResourceSet compileMacroResourceSet(final Pair<String, String> macroFile, final Pair<String, String> clientFile) {
    final URI macroURI = this.copyToDisk(this.macroProject, macroFile);
    final URI clientURI = this.copyToDisk(this.clientProject, clientFile);
    File _file = new File(this.workspaceRoot, this.macroProject);
    FileProjectConfig _fileProjectConfig = new FileProjectConfig(_file);
    final Procedure1<FileProjectConfig> _function = (FileProjectConfig it) -> {
      it.addSourceFolder("src");
    };
    final FileProjectConfig macroProjectConfig = ObjectExtensions.<FileProjectConfig>operator_doubleArrow(_fileProjectConfig, _function);
    File _file_1 = new File(this.workspaceRoot, this.clientProject);
    FileProjectConfig _fileProjectConfig_1 = new FileProjectConfig(_file_1);
    final Procedure1<FileProjectConfig> _function_1 = (FileProjectConfig it) -> {
      it.addSourceFolder("src");
    };
    final FileProjectConfig clientProjectConfig = ObjectExtensions.<FileProjectConfig>operator_doubleArrow(_fileProjectConfig_1, _function_1);
    final XtextResourceSet macroResourceSet = this.resourceSetProvider.get();
    ProjectConfigAdapter.install(macroResourceSet, macroProjectConfig);
    macroResourceSet.setClasspathURIContext(this.getClass().getClassLoader());
    macroResourceSet.createResource(macroURI);
    final XtextResourceSet resourceSet = this.resourceSetProvider.get();
    ProjectConfigAdapter.install(resourceSet, clientProjectConfig);
    resourceSet.createResource(clientURI);
    final IAcceptor<CompilationTestHelper.Result> _function_2 = (CompilationTestHelper.Result result) -> {
      ClassLoader _classLoader = this.getClass().getClassLoader();
      final DelegatingClassloader classLoader = new DelegatingClassloader(_classLoader, result);
      resourceSet.setClasspathURIContext(classLoader);
      this.compiler.setJavaCompilerClassPath(classLoader);
    };
    this.compiler.compile(macroResourceSet, _function_2);
    return resourceSet;
  }

  @Test
  @Override
  public void testSimpleModification() {
    super.testSimpleModification();
  }

  @Test
  public void testBug403563() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package myannotation");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.Active");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.TransformationContext");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Active(ThrowExceptionAnnotationProcessor)");
    _builder.newLine();
    _builder.append("annotation ThrowExceptionAnnotation{ }");
    _builder.newLine();
    _builder.append("class ThrowExceptionAnnotationProcessor extends AbstractClassProcessor {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new IllegalStateException");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("myannotation/ThrowExceptionAnnotationProcessor.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package myusercode");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@myannotation.ThrowExceptionAnnotation class MyClass {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("myusercode/UserCode.xtend", _builder_1.toString());
    final Procedure1<List<Issue>> _function = (List<Issue> it) -> {
      Assert.assertEquals(1, it.size());
      final Issue error = IterableExtensions.<Issue>head(it);
      Assert.assertNotNull(error);
      Assert.assertEquals(IssueCodes.PROCESSING_ERROR, error.getCode());
      Assert.assertTrue(error.getMessage().contains(IllegalStateException.class.getName()));
      Assert.assertFalse(error.getMessage().contains(AnnotationProcessor.class.getName()));
    };
    this.assertIssues(_mappedTo, _mappedTo_1, _function);
  }

  @Test
  public void testDetectOrphanedElements() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package myannotation");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.Active");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.TransformationContext");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Active(EvilProcessor)");
    _builder.newLine();
    _builder.append("annotation EvilAnnotation {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class EvilProcessor extends AbstractClassProcessor {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override doRegisterGlobals(List<? extends ClassDeclaration> classes, extension RegisterGlobalsContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("classes.forEach[");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("registerClass(qualifiedName+\'.Inner\')");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override doTransform(List<? extends MutableClassDeclaration> classes, extension TransformationContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("classes.forEach[");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("addField(\"foo\")[");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("type = object");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("markAsRead");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("addMethod(\"foo\")[");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("returnType = object");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("body = [\"return null;\"]");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("addParameter(\"x\", Integer.newTypeReference)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("myannotation/EvilAnnotation.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package myusercode");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import myannotation.EvilAnnotation");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@EvilAnnotation");
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("myusercode/UserCode.xtend", _builder_1.toString());
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      this.validator.assertIssue(it.getXtendFile(), XtendPackage.Literals.XTEND_FILE, IssueCodes.ORPHAN_ELEMENT, Severity.WARNING, 
        "The generated field \'myusercode.Foo.foo\' is not associated with a source element.");
      this.validator.assertIssue(it.getXtendFile(), XtendPackage.Literals.XTEND_FILE, IssueCodes.ORPHAN_ELEMENT, Severity.WARNING, 
        "The generated method \'myusercode.Foo.foo(Integer)\' is not associated with a source element.");
      this.validator.assertIssue(it.getXtendFile(), XtendPackage.Literals.XTEND_FILE, IssueCodes.ORPHAN_ELEMENT, Severity.WARNING, 
        "The generated type \'myusercode.Foo.Inner\' is not associated with a source element.");
    };
    this.assertProcessing(_mappedTo, _mappedTo_1, _function);
  }

  @Test
  public void testDetectOrphanedElements2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package myannotation");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.Active");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.TransformationContext");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Active(EvilProcessor)");
    _builder.newLine();
    _builder.append("annotation EvilAnnotation {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class EvilProcessor extends AbstractClassProcessor {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override doRegisterGlobals(ClassDeclaration clazz, extension RegisterGlobalsContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("registerClass(clazz.qualifiedName+\'.Inner\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("findClass(clazz.qualifiedName+\'.Inner\').primarySourceElement = clazz");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("myannotation/EvilAnnotation.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package myusercode");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import myannotation.EvilAnnotation");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@EvilAnnotation");
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Comparable<String> p = new Comparable<String>() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("override compareTo(String other) { 42 }");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("myusercode/UserCode.xtend", _builder_1.toString());
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      this.validator.assertNoWarnings(it.getXtendFile(), XtendPackage.Literals.XTEND_FILE, IssueCodes.ORPHAN_ELEMENT);
    };
    this.assertProcessing(_mappedTo, _mappedTo_1, _function);
  }

  @Test
  public void testGeneratedInferredInterfaceIsNotValidated_issue_3045() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package extract");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.lang.annotation.ElementType");
    _builder.newLine();
    _builder.append("import java.lang.annotation.Target");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.Active");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.RegisterGlobalsContext");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.TransformationContext");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.Visibility");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Extracts an interface for all locally declared public methods.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Target(ElementType.TYPE)");
    _builder.newLine();
    _builder.append("@Active(ExtractProcessor)");
    _builder.newLine();
    _builder.append("annotation Extract {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ExtractProcessor extends AbstractClassProcessor {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override doRegisterGlobals(ClassDeclaration annotatedClass, RegisterGlobalsContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("context.registerInterface(annotatedClass.interfaceName)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getInterfaceName(ClassDeclaration annotatedClass) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("annotatedClass.qualifiedName+\"Interface\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val interfaceType = findInterface(annotatedClass.interfaceName)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("interfaceType.primarySourceElement = annotatedClass");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// add the interface to the list of implemented interfaces");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("annotatedClass.implementedInterfaces = annotatedClass.implementedInterfaces + #[interfaceType.newTypeReference]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// add the public methods to the interface");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (method : annotatedClass.declaredMethods) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (method.visibility == Visibility.PUBLIC) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("interfaceType.addMethod(method.simpleName) [");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("docComment = method.docComment");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("returnType = method.returnType");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("for (p : method.parameters) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("addParameter(p.simpleName, p.type)");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("exceptions = method.exceptions");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("primarySourceElement = method");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("extract/Extract.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package extract");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Extract");
    _builder_1.newLine();
    _builder_1.append("class ExtractExample {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("\t ");
    _builder_1.append("* This method is extracted to an interface");
    _builder_1.newLine();
    _builder_1.append("\t ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("override void myPublicMethod() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("\t ");
    _builder_1.append("* This method is not extracted");
    _builder_1.newLine();
    _builder_1.append("\t ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected def void myPrivateMethod() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("extract/ExtractExample.xtend", _builder_1.toString());
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      this.validator.assertNoErrors(it.getXtendFile());
    };
    this.assertProcessing(_mappedTo, _mappedTo_1, _function);
  }
}
