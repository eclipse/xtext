package org.eclipse.xtext.xtend2.ui.tests.hover;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.text.java.hover.JavadocBrowserInformationControlInput;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.common.types.xtext.ui.JdtHoverProvider.JavadocHoverWrapper;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.ui.hover.XtendDispatchingEObjectTextHover;
import org.eclipse.xtext.xtend2.ui.hover.XtendInformationControlInput;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendUnsugaredHoverTest extends AbstractXtend2UITestCase {
  @Inject
  private WorkbenchTestHelper testHelper;
  
  @Inject
  private IXtend2JvmAssociations _iXtend2JvmAssociations;
  
  @Inject
  private IJavaElementFinder javaElementFinder;
  
  private static String FILEEXTENSION = ".xtend";
  
  private static String FILEPATH = new Function0<String>() {
    public String apply() {
      String _operator_plus = StringExtensions.operator_plus("testpackage/Foo", XtendUnsugaredHoverTest.FILEEXTENSION);
      return _operator_plus;
    }
  }.apply();
  
  @Before
  public void createExtensionClass() throws Exception {
      String _operator_plus = StringExtensions.operator_plus("testpackage/Extension", XtendUnsugaredHoverTest.FILEEXTENSION);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("class Extension {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(Integer p1, Integer p2)");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def barCharSequence(Integer p1, CharSequence c)");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(List<String list, Integer a)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      String _string = _builder.toString();
      this.testHelper.createFile(_operator_plus, _string);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package testpackage;");
      _builder_1.newLine();
      _builder_1.append("public class ExtensionJava {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void bar(Integer p1, Integer p2){");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      String _string_1 = _builder_1.toString();
      this.testHelper.createFile("testpackage/ExtensionJava.java", _string_1);
  }
  
  @After
  public void cleanup() {
    try {
      this.testHelper.tearDown();
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnsuagaredVersionForXtendFunction() throws Exception {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension Extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(Integer it){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("bar(42)\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      IFile _createFile = this.testHelper.createFile(XtendUnsugaredHoverTest.FILEPATH, _string);
      XtextEditor _openEditor = this.testHelper.openEditor(_createFile);
      final XtextEditor editor = _openEditor;
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _computeAstAndInvokeHover = this.computeAstAndInvokeHover(editor, 0, 0);
      final Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> triple = _computeAstAndInvokeHover;
      XAbstractFeatureCall _first = triple.getFirst();
      JvmIdentifiableElement _feature = _first.getFeature();
      XtendFunction _xtendFunction = this._iXtend2JvmAssociations.getXtendFunction(((JvmOperation) _feature));
      URI _uRI = EcoreUtil.getURI(_xtendFunction);
      XtendInformationControlInput _second = triple.getSecond();
      EObject _element = _second.getElement();
      URI _uRI_1 = EcoreUtil.getURI(_element);
      Assert.assertEquals(_uRI, _uRI_1);
      XtendInformationControlInput _second_1 = triple.getSecond();
      String _unsugaredExpression = _second_1.getUnsugaredExpression();
      Assert.assertEquals("_extension.bar(it, 42)", _unsugaredExpression);
  }
  
  @Test
  public void testUnsuagaredVersionForXtendFunction_2() throws Exception {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension Extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(Integer it){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("bar(it, 42)\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      IFile _createFile = this.testHelper.createFile(XtendUnsugaredHoverTest.FILEPATH, _string);
      XtextEditor _openEditor = this.testHelper.openEditor(_createFile);
      final XtextEditor editor = _openEditor;
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _computeAstAndInvokeHover = this.computeAstAndInvokeHover(editor, 0, 0);
      final Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> triple = _computeAstAndInvokeHover;
      XAbstractFeatureCall _first = triple.getFirst();
      JvmIdentifiableElement _feature = _first.getFeature();
      XtendFunction _xtendFunction = this._iXtend2JvmAssociations.getXtendFunction(((JvmOperation) _feature));
      URI _uRI = EcoreUtil.getURI(_xtendFunction);
      XtendInformationControlInput _second = triple.getSecond();
      EObject _element = _second.getElement();
      URI _uRI_1 = EcoreUtil.getURI(_element);
      Assert.assertEquals(_uRI, _uRI_1);
      XtendInformationControlInput _second_1 = triple.getSecond();
      String _unsugaredExpression = _second_1.getUnsugaredExpression();
      Assert.assertEquals("_extension.bar(it, 42)", _unsugaredExpression);
  }
  
  @Test
  public void testUnsuagaredVersionForXtendFunction_3() throws Exception {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension Extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(Integer it){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val a = 42");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("bar(it, 42 + a)\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      IFile _createFile = this.testHelper.createFile(XtendUnsugaredHoverTest.FILEPATH, _string);
      XtextEditor _openEditor = this.testHelper.openEditor(_createFile);
      final XtextEditor editor = _openEditor;
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _computeAstAndInvokeHover = this.computeAstAndInvokeHover(editor, 1, 0);
      final Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> triple = _computeAstAndInvokeHover;
      XAbstractFeatureCall _first = triple.getFirst();
      JvmIdentifiableElement _feature = _first.getFeature();
      XtendFunction _xtendFunction = this._iXtend2JvmAssociations.getXtendFunction(((JvmOperation) _feature));
      URI _uRI = EcoreUtil.getURI(_xtendFunction);
      XtendInformationControlInput _second = triple.getSecond();
      EObject _element = _second.getElement();
      URI _uRI_1 = EcoreUtil.getURI(_element);
      Assert.assertEquals(_uRI, _uRI_1);
      XtendInformationControlInput _second_1 = triple.getSecond();
      String _unsugaredExpression = _second_1.getUnsugaredExpression();
      Assert.assertEquals("_extension.bar(it, 42 + a)", _unsugaredExpression);
  }
  
  @Test
  public void testUnsuagaredVersionForXtendFunction_4() throws Exception {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension Extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(Integer it){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("bar(it, 40 + 2)\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      IFile _createFile = this.testHelper.createFile(XtendUnsugaredHoverTest.FILEPATH, _string);
      XtextEditor _openEditor = this.testHelper.openEditor(_createFile);
      final XtextEditor editor = _openEditor;
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _computeAstAndInvokeHover = this.computeAstAndInvokeHover(editor, 0, 0);
      final Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> triple = _computeAstAndInvokeHover;
      XAbstractFeatureCall _first = triple.getFirst();
      JvmIdentifiableElement _feature = _first.getFeature();
      XtendFunction _xtendFunction = this._iXtend2JvmAssociations.getXtendFunction(((JvmOperation) _feature));
      URI _uRI = EcoreUtil.getURI(_xtendFunction);
      XtendInformationControlInput _second = triple.getSecond();
      EObject _element = _second.getElement();
      URI _uRI_1 = EcoreUtil.getURI(_element);
      Assert.assertEquals(_uRI, _uRI_1);
      XtendInformationControlInput _second_1 = triple.getSecond();
      String _unsugaredExpression = _second_1.getUnsugaredExpression();
      Assert.assertEquals("_extension.bar(it, 40 + 2)", _unsugaredExpression);
  }
  
  @Test
  public void testUnsuagaredVersionForXtendFunction_5() throws Exception {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("import java.util.ArrayList");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension Extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(Integer it){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new ArrayList<String>().bar(42)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      IFile _createFile = this.testHelper.createFile(XtendUnsugaredHoverTest.FILEPATH, _string);
      XtextEditor _openEditor = this.testHelper.openEditor(_createFile);
      final XtextEditor editor = _openEditor;
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _computeAstAndInvokeHover = this.computeAstAndInvokeHover(editor, 0, 25);
      final Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> triple = _computeAstAndInvokeHover;
      XAbstractFeatureCall _first = triple.getFirst();
      JvmIdentifiableElement _feature = _first.getFeature();
      XtendFunction _xtendFunction = this._iXtend2JvmAssociations.getXtendFunction(((JvmOperation) _feature));
      URI _uRI = EcoreUtil.getURI(_xtendFunction);
      XtendInformationControlInput _second = triple.getSecond();
      EObject _element = _second.getElement();
      URI _uRI_1 = EcoreUtil.getURI(_element);
      Assert.assertEquals(_uRI, _uRI_1);
      XtendInformationControlInput _second_1 = triple.getSecond();
      String _unsugaredExpression = _second_1.getUnsugaredExpression();
      Assert.assertEquals("_extension.bar(new ArrayList<String>(), 42)", _unsugaredExpression);
  }
  
  @Test
  public void testUnsuagaredVersionForXtendFunction_6() throws Exception {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("import java.util.ArrayList");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension Extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(Integer it){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("bar(new ArrayList<String>(), 42)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      IFile _createFile = this.testHelper.createFile(XtendUnsugaredHoverTest.FILEPATH, _string);
      XtextEditor _openEditor = this.testHelper.openEditor(_createFile);
      final XtextEditor editor = _openEditor;
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _computeAstAndInvokeHover = this.computeAstAndInvokeHover(editor, 0, 0);
      final Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> triple = _computeAstAndInvokeHover;
      XAbstractFeatureCall _first = triple.getFirst();
      JvmIdentifiableElement _feature = _first.getFeature();
      XtendFunction _xtendFunction = this._iXtend2JvmAssociations.getXtendFunction(((JvmOperation) _feature));
      URI _uRI = EcoreUtil.getURI(_xtendFunction);
      XtendInformationControlInput _second = triple.getSecond();
      EObject _element = _second.getElement();
      URI _uRI_1 = EcoreUtil.getURI(_element);
      Assert.assertEquals(_uRI, _uRI_1);
      XtendInformationControlInput _second_1 = triple.getSecond();
      String _unsugaredExpression = _second_1.getUnsugaredExpression();
      Assert.assertEquals("_extension.bar(new ArrayList<String>(), 42)", _unsugaredExpression);
  }
  
  @Test
  public void testUnsuagaredVersionForXtendFunction_7() throws Exception {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("import java.util.ArrayList");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension Extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(Integer it){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("barCharSequence(42, ");
      _builder.append("\'\'\'", "		");
      _builder.append("   Test   Test");
      _builder.newLineIfNotEmpty();
      _builder.append("Test");
      _builder.append("\'\'\'", "");
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      IFile _createFile = this.testHelper.createFile(XtendUnsugaredHoverTest.FILEPATH, _string);
      XtextEditor _openEditor = this.testHelper.openEditor(_createFile);
      final XtextEditor editor = _openEditor;
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _computeAstAndInvokeHover = this.computeAstAndInvokeHover(editor, 0, 0);
      final Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> triple = _computeAstAndInvokeHover;
      XAbstractFeatureCall _first = triple.getFirst();
      JvmIdentifiableElement _feature = _first.getFeature();
      XtendFunction _xtendFunction = this._iXtend2JvmAssociations.getXtendFunction(((JvmOperation) _feature));
      URI _uRI = EcoreUtil.getURI(_xtendFunction);
      XtendInformationControlInput _second = triple.getSecond();
      EObject _element = _second.getElement();
      URI _uRI_1 = EcoreUtil.getURI(_element);
      Assert.assertEquals(_uRI, _uRI_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("_extension.barCharSequence(42, ");
      _builder_1.append("\'\'\'", "");
      _builder_1.append("   Test   Test");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("Test");
      _builder_1.append("\'\'\'", "");
      _builder_1.append(")");
      String _string_1 = _builder_1.toString();
      XtendInformationControlInput _second_1 = triple.getSecond();
      String _unsugaredExpression = _second_1.getUnsugaredExpression();
      Assert.assertEquals(_string_1, _unsugaredExpression);
  }
  
  @Test
  public void testUnsuagaredVersionForXtendFunction_8() throws Exception {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("import java.util.ArrayList");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension Extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(Integer it){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("it.bar(42)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      IFile _createFile = this.testHelper.createFile(XtendUnsugaredHoverTest.FILEPATH, _string);
      XtextEditor _openEditor = this.testHelper.openEditor(_createFile);
      final XtextEditor editor = _openEditor;
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _computeAstAndInvokeHover = this.computeAstAndInvokeHover(editor, 0, 4);
      final Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> triple = _computeAstAndInvokeHover;
      XAbstractFeatureCall _first = triple.getFirst();
      JvmIdentifiableElement _feature = _first.getFeature();
      XtendFunction _xtendFunction = this._iXtend2JvmAssociations.getXtendFunction(((JvmOperation) _feature));
      URI _uRI = EcoreUtil.getURI(_xtendFunction);
      XtendInformationControlInput _second = triple.getSecond();
      EObject _element = _second.getElement();
      URI _uRI_1 = EcoreUtil.getURI(_element);
      Assert.assertEquals(_uRI, _uRI_1);
      XtendInformationControlInput _second_1 = triple.getSecond();
      String _unsugaredExpression = _second_1.getUnsugaredExpression();
      Assert.assertEquals("_extension.bar(it, 42)", _unsugaredExpression);
  }
  
  @Test
  public void testUnsuagaredVersionForXtendFunction_9() throws Exception {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("import java.util.ArrayList");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension Extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(String it){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("substring(0)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      IFile _createFile = this.testHelper.createFile(XtendUnsugaredHoverTest.FILEPATH, _string);
      XtextEditor _openEditor = this.testHelper.openEditor(_createFile);
      final XtextEditor editor = _openEditor;
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _computeAstAndInvokeHover = this.computeAstAndInvokeHover(editor, 0, 0);
      final Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> triple = _computeAstAndInvokeHover;
      XAbstractFeatureCall _first = triple.getFirst();
      JvmIdentifiableElement _feature = _first.getFeature();
      URI _uRI = EcoreUtil.getURI(_feature);
      XtendInformationControlInput _second = triple.getSecond();
      EObject _element = _second.getElement();
      URI _uRI_1 = EcoreUtil.getURI(_element);
      Assert.assertEquals(_uRI, _uRI_1);
      XtendInformationControlInput _second_1 = triple.getSecond();
      String _unsugaredExpression = _second_1.getUnsugaredExpression();
      Assert.assertEquals("it.substring(0)", _unsugaredExpression);
  }
  
  @Test
  public void testUnsuagaredVersionForXtendFunction_10() throws Exception {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("import java.util.ArrayList");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension Extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val it = \"42\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("substring(0)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      IFile _createFile = this.testHelper.createFile(XtendUnsugaredHoverTest.FILEPATH, _string);
      XtextEditor _openEditor = this.testHelper.openEditor(_createFile);
      final XtextEditor editor = _openEditor;
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _computeAstAndInvokeHover = this.computeAstAndInvokeHover(editor, 1, 0);
      final Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> triple = _computeAstAndInvokeHover;
      XAbstractFeatureCall _first = triple.getFirst();
      JvmIdentifiableElement _feature = _first.getFeature();
      URI _uRI = EcoreUtil.getURI(_feature);
      XtendInformationControlInput _second = triple.getSecond();
      EObject _element = _second.getElement();
      URI _uRI_1 = EcoreUtil.getURI(_element);
      Assert.assertEquals(_uRI, _uRI_1);
      XtendInformationControlInput _second_1 = triple.getSecond();
      String _unsugaredExpression = _second_1.getUnsugaredExpression();
      Assert.assertEquals("it.substring(0)", _unsugaredExpression);
  }
  
  @Test
  public void testUnsuagaredVersionForXtendFunction_11() throws Exception {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("import java.util.ArrayList");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension Extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new ArrayList<String>().head");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      IFile _createFile = this.testHelper.createFile(XtendUnsugaredHoverTest.FILEPATH, _string);
      XtextEditor _openEditor = this.testHelper.openEditor(_createFile);
      final XtextEditor editor = _openEditor;
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _computeAstAndInvokeHover = this.computeAstAndInvokeHover(editor, 0, 27);
      final Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> triple = _computeAstAndInvokeHover;
      XAbstractFeatureCall _first = triple.getFirst();
      JvmIdentifiableElement _feature = _first.getFeature();
      URI _uRI = EcoreUtil.getURI(_feature);
      XtendInformationControlInput _second = triple.getSecond();
      EObject _element = _second.getElement();
      URI _uRI_1 = EcoreUtil.getURI(_element);
      Assert.assertEquals(_uRI, _uRI_1);
      XtendInformationControlInput _second_1 = triple.getSecond();
      String _unsugaredExpression = _second_1.getUnsugaredExpression();
      Assert.assertEquals("IterableExtensions::head(new ArrayList<String>())", _unsugaredExpression);
  }
  
  @Test
  public void testUnsuagaredVersionForJavaWiothJavaDoc() throws Exception {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension ExtensionJava");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(Integer it){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("bar(it, 40 + 2)\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      IFile _createFile = this.testHelper.createFile(XtendUnsugaredHoverTest.FILEPATH, _string);
      XtextEditor _openEditor = this.testHelper.openEditor(_createFile);
      final XtextEditor editor = _openEditor;
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _computeAstAndInvokeHover = this.computeAstAndInvokeHover(editor, 0, 0);
      final Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> triple = _computeAstAndInvokeHover;
      XAbstractFeatureCall _first = triple.getFirst();
      JvmIdentifiableElement _feature = _first.getFeature();
      IJavaElement _findElementFor = this.javaElementFinder.findElementFor(_feature);
      final IJavaElement javaElement = _findElementFor;
      XtendInformationControlInput _second = triple.getSecond();
      IJavaElement _inputElement = _second.getInputElement();
      Assert.assertEquals(javaElement, _inputElement);
      JavadocHoverWrapper _javadocHoverWrapper = new JavadocHoverWrapper();
      final JavadocHoverWrapper javaDocHoverWrapper = _javadocHoverWrapper;
      javaDocHoverWrapper.setJavaElement(javaElement);
      IRegion _third = triple.getThird();
      Object _hoverInfo2 = javaDocHoverWrapper.getHoverInfo2(null, _third);
      final JavadocBrowserInformationControlInput javaDocHoverInput = ((JavadocBrowserInformationControlInput) _hoverInfo2);
      XtendInformationControlInput _second_1 = triple.getSecond();
      String _html = _second_1.getHtml();
      String _html_1 = javaDocHoverInput.getHtml();
      Assert.assertEquals(_html, _html_1);
      XAbstractFeatureCall _first_1 = triple.getFirst();
      JvmIdentifiableElement _feature_1 = _first_1.getFeature();
      URI _uRI = EcoreUtil.getURI(((JvmOperation) _feature_1));
      XtendInformationControlInput _second_2 = triple.getSecond();
      EObject _element = _second_2.getElement();
      URI _uRI_1 = EcoreUtil.getURI(_element);
      Assert.assertEquals(_uRI, _uRI_1);
      XtendInformationControlInput _second_3 = triple.getSecond();
      String _unsugaredExpression = _second_3.getUnsugaredExpression();
      Assert.assertEquals("_extensionJava.bar(it, 40 + 2)", _unsugaredExpression);
  }
  
  public Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> computeAstAndInvokeHover(final XtextEditor editor, final int indexOfExpressionToHover, final int addOffset) {
      IResourcesSetupUtil.waitForAutoBuild();
      Resource _loadResource = this.loadResource();
      final Resource resource = _loadResource;
      EList<EObject> _contents = resource.getContents();
      EObject _get = _contents.get(0);
      final XtendFile xtendFile = ((XtendFile) _get);
      XtendClass _xtendClass = xtendFile.getXtendClass();
      EList<XtendMember> _members = _xtendClass.getMembers();
      XtendMember _get_1 = _members.get(1);
      XExpression _expression = ((XtendFunction) _get_1).getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_2 = _expressions.get(indexOfExpressionToHover);
      final XAbstractFeatureCall featureCall = ((XAbstractFeatureCall) _get_2);
      IEObjectHover _get_3 = this.<IEObjectHover>get(org.eclipse.xtext.ui.editor.hover.IEObjectHover.class);
      final XtendDispatchingEObjectTextHover hover = ((XtendDispatchingEObjectTextHover) _get_3);
      ISourceViewer _internalSourceViewer = editor.getInternalSourceViewer();
      ICompositeNode _node = NodeModelUtils.getNode(featureCall);
      int _offset = _node.getOffset();
      int _operator_plus = IntegerExtensions.operator_plus(_offset, addOffset);
      IRegion _hoverRegion = hover.getHoverRegion(_internalSourceViewer, _operator_plus);
      final IRegion region = _hoverRegion;
      ISourceViewer _internalSourceViewer_1 = editor.getInternalSourceViewer();
      Object _hoverInfo2 = hover.getHoverInfo2(_internalSourceViewer_1, region);
      Triple<XAbstractFeatureCall,XtendInformationControlInput,IRegion> _create = Tuples.<XAbstractFeatureCall, XtendInformationControlInput, IRegion>create(featureCall, ((XtendInformationControlInput) _hoverInfo2), region);
      return _create;
  }
  
  public IProject getProject() {
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    IWorkspaceRoot _root = _workspace.getRoot();
    IProject _project = _root.getProject(WorkbenchTestHelper.TESTPROJECT_NAME);
    return _project;
  }
  
  public Resource loadResource() {
    try {
      {
        String _operator_plus = StringExtensions.operator_plus("platform:/resource/", WorkbenchTestHelper.TESTPROJECT_NAME);
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "/src/");
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, XtendUnsugaredHoverTest.FILEPATH);
        URI _createURI = URI.createURI(_operator_plus_2);
        final URI uri = _createURI;
        Injector _injector = this.getInjector();
        IResourceSetProvider _instance = _injector.<IResourceSetProvider>getInstance(org.eclipse.xtext.ui.resource.IResourceSetProvider.class);
        IProject _project = this.getProject();
        ResourceSet _get = _instance.get(_project);
        Resource _createResource = _get.createResource(uri);
        Resource resource = _createResource;
        resource.load(null);
        return resource;
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
