package org.eclipse.xtend.ide.tests.macros;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
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
import org.eclipse.xtend.core.tests.macro.AbstractReusableActiveAnnotationTests;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
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
  
  @Inject
  private IResourceValidator validator;
  
  @Test
  public void testDocumentationProvider() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package myannotation");
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
    Pair<String, String> _mappedTo = Pair.<String, String>of("myannotation/ChangeDoc.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package usercode");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import myannotation.ChangeDoc");
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
    _builder_1.append("private UserClass object");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("usercode/UserCode.xtend", _builder_1.toString());
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        XtendFile _xtendFile = it.getXtendFile();
        EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
        Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
        final XtendClass xtendClass = IterableExtensions.<XtendClass>head(_filter);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("@<a href=\"eclipse-xtext-doc:platform:/resource/macroProject/src/myannotation/ChangeDoc.xtend%23/1\">ChangeDoc</a><br>Comment");
        ActiveAnnotationsProcessingInIDETest.this.assertDocumentation(_builder, xtendClass);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("@<a href=\"eclipse-xtext-doc:platform:/resource/macroProject/src/myannotation/ChangeDoc.xtend%23/1\">ChangeDoc</a><br>Hello World!");
        EList<XtendMember> _members = xtendClass.getMembers();
        Iterable<XtendField> _filter_1 = Iterables.<XtendField>filter(_members, XtendField.class);
        final Function1<XtendField, Boolean> _function = new Function1<XtendField, Boolean>() {
          @Override
          public Boolean apply(final XtendField it) {
            String _name = it.getName();
            return Boolean.valueOf(_name.equals("object"));
          }
        };
        Iterable<XtendField> _filter_2 = IterableExtensions.<XtendField>filter(_filter_1, _function);
        XtendField _head = IterableExtensions.<XtendField>head(_filter_2);
        JvmTypeReference _type = _head.getType();
        JvmType _type_1 = _type.getType();
        ActiveAnnotationsProcessingInIDETest.this.assertDocumentation(_builder_1, _type_1);
      }
    };
    this.assertProcessing(_mappedTo, _mappedTo_1, _function);
  }
  
  public void assertDocumentation(final CharSequence charSequence, final EObject sourceElement) {
    String _string = charSequence.toString();
    String _documentation = this.documentationProvider.getDocumentation(sourceElement);
    Assert.assertEquals(_string, _documentation);
  }
  
  @Inject
  private XtextResourceSetProvider resourceSetProvider;
  
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;
  
  @Rule
  public StopwatchRule stopwatch = new StopwatchRule(true);
  
  private static IJavaProject macroProject;
  
  private static IJavaProject userProject;
  
  @BeforeClass
  public static void createProjects() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("macroProject");
      IJavaProject _create = JavaCore.create(_createPluginProject);
      ActiveAnnotationsProcessingInIDETest.macroProject = _create;
      IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib", 
        "org.eclipse.xtend.core.tests", 
        "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject");
      IJavaProject _create_1 = JavaCore.create(_createPluginProject_1);
      ActiveAnnotationsProcessingInIDETest.userProject = _create_1;
      IProject _project = ActiveAnnotationsProcessingInIDETest.macroProject.getProject();
      WorkbenchTestHelper.addExportedPackages(_project, "myannotation");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @AfterClass
  public static void deleteProjects() {
    try {
      IResourcesSetupUtil.cleanWorkspace();
      ActiveAnnotationsProcessingInIDETest.macroProject = null;
      ActiveAnnotationsProcessingInIDETest.userProject = null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void tearDown() throws Exception {
    this.clientFile.delete(true, null);
    this.macroFile.delete(true, null);
    boolean _notEquals = (!Objects.equal("myannotation", this.exportedPackage));
    if (_notEquals) {
      IProject _project = ActiveAnnotationsProcessingInIDETest.macroProject.getProject();
      boolean _removeExportedPackages = WorkbenchTestHelper.removeExportedPackages(_project, this.exportedPackage);
      if (_removeExportedPackages) {
        IResourcesSetupUtil.waitForBuild();
      }
    }
  }
  
  private IFile macroFile;
  
  private IFile clientFile;
  
  private String exportedPackage;
  
  @Override
  public void assertProcessing(final Pair<String, String> macroContent, final Pair<String, String> clientContent, final Procedure1<? super CompilationUnitImpl> expectations) {
    try {
      String _key = macroContent.getKey();
      String _value = macroContent.getValue();
      String _string = _value.toString();
      IFile _newSource = this.newSource(ActiveAnnotationsProcessingInIDETest.macroProject, _key, _string);
      this.macroFile = _newSource;
      String _key_1 = macroContent.getKey();
      final int lidx = _key_1.lastIndexOf("/");
      if ((lidx != (-1))) {
        String _key_2 = macroContent.getKey();
        String _substring = _key_2.substring(0, lidx);
        String _replace = _substring.replace("/", ".");
        this.exportedPackage = _replace;
        IProject _project = ActiveAnnotationsProcessingInIDETest.macroProject.getProject();
        boolean _addExportedPackages = WorkbenchTestHelper.addExportedPackages(_project, this.exportedPackage);
        if (_addExportedPackages) {
          IResourcesSetupUtil.reallyWaitForAutoBuild();
        }
      }
      String _key_3 = clientContent.getKey();
      String _value_1 = clientContent.getValue();
      String _string_1 = _value_1.toString();
      IFile _newSource_1 = this.newSource(ActiveAnnotationsProcessingInIDETest.userProject, _key_3, _string_1);
      this.clientFile = _newSource_1;
      IResourcesSetupUtil.waitForBuild();
      IProject _project_1 = ActiveAnnotationsProcessingInIDETest.userProject.getProject();
      final ResourceSet resourceSet = this.resourceSetProvider.get(_project_1);
      IPath _fullPath = this.clientFile.getFullPath();
      String _string_2 = _fullPath.toString();
      URI _createPlatformResourceURI = URI.createPlatformResourceURI(_string_2, true);
      final Resource resource = resourceSet.getResource(_createPlatformResourceURI, true);
      EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
      this.validator.validate(resource, CheckMode.FAST_ONLY, CancelIndicator.NullImpl);
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
      final IFile result = _project.getFile(("src/" + fileName));
      IContainer _parent = result.getParent();
      this.createIfNotExistent(_parent);
      StringInputStream _stringInputStream = new StringInputStream(contents);
      result.create(_stringInputStream, true, null);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void createIfNotExistent(final IContainer container) {
    try {
      boolean _exists = container.exists();
      boolean _not = (!_exists);
      if (_not) {
        IContainer _parent = container.getParent();
        this.createIfNotExistent(_parent);
        ((IFolder) container).create(true, false, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
