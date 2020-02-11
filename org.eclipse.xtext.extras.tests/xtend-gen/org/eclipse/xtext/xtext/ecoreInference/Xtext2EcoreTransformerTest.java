/**
 * Copyright (c) 2008, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.ecoreInference;

import com.google.common.base.Joiner;
import java.io.InputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.tests.TestErrorAcceptor;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.XtextLinker;
import org.eclipse.xtext.xtext.ecoreInference.ErrorAcceptor;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;
import org.eclipse.xtext.xtext.ecoreInference.TransformationErrorCode;
import org.eclipse.xtext.xtext.ecoreInference.Xtext2EcoreTransformer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Heiko Behrens
 * @see https://www.eclipse.org/Xtext/documentation/301_grammarlanguage.html#metamodel-inference
 */
@SuppressWarnings("all")
public class Xtext2EcoreTransformerTest extends AbstractXtextTests {
  /**
   * @author Dennis Hübner - Initial contribution and API
   */
  @FinalFieldsConstructor
  private static final class MockedXtext2EcorePostProcessor implements IXtext2EcorePostProcessor {
    private int called = 0;
    
    private final GeneratedMetamodel testMetamodel;
    
    @Override
    public void process(final GeneratedMetamodel metamodel) {
      boolean _equals = this.testMetamodel.equals(metamodel);
      if (_equals) {
        this.called++;
      }
    }
    
    public int proccessMethCalled() {
      return this.called;
    }
    
    public MockedXtext2EcorePostProcessor(final GeneratedMetamodel testMetamodel) {
      super();
      this.testMetamodel = testMetamodel;
    }
  }
  
  @FinalFieldsConstructor
  public static class MyErrorAcceptor implements ErrorAcceptor {
    private final ErrorAcceptor first;
    
    private final ErrorAcceptor second;
    
    @Override
    public void acceptError(final TransformationErrorCode errorCode, final String message, final EObject element) {
      this.first.acceptError(errorCode, message, element);
      this.second.acceptError(errorCode, message, element);
    }
    
    public MyErrorAcceptor(final ErrorAcceptor first, final ErrorAcceptor second) {
      super();
      this.first = first;
      this.second = second;
    }
  }
  
  private TestErrorAcceptor errorAcceptorMock;
  
  protected <T extends EStructuralFeature> T feature(final EClassifier clazz, final String name) {
    if ((clazz instanceof EClass)) {
      EStructuralFeature _eStructuralFeature = ((EClass)clazz).getEStructuralFeature(name);
      return ((T) _eStructuralFeature);
    }
    return null;
  }
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, TypesPackage.eINSTANCE);
    TestErrorAcceptor _testErrorAcceptor = new TestErrorAcceptor();
    this.errorAcceptorMock = _testErrorAcceptor;
    EcoreSupportStandaloneSetup.setup();
    this.with(XtextStandaloneSetup.class);
  }
  
  @Override
  public void tearDown() throws Exception {
    this.errorAcceptorMock = null;
    super.tearDown();
  }
  
  @Override
  public XtextResource doGetResource(final InputStream in, final URI uri) throws Exception {
    XtextResourceSet rs = this.<XtextResourceSet>get(XtextResourceSet.class);
    rs.getURIConverter().getURIMap().put(URI.createPlatformPluginURI("org.eclipse.xtext/", false), URI.createURI("classpath:/"));
    rs.getURIConverter().getURIMap().put(URI.createPlatformPluginURI("org.eclipse.xtext.xbase/", false), URI.createURI("classpath:/"));
    rs.getURIConverter().getURIMap().put(URI.createPlatformPluginURI("org.eclipse.xtext.common.types/", false), URI.createURI("classpath:/"));
    rs.getURIConverter().getURIMap().put(URI.createPlatformPluginURI("org.eclipse.emf.ecore/", false), URI.createURI("classpath:/"));
    rs.getURIConverter().getURIMap().put(URI.createPlatformResourceURI("org.eclipse.xtext.xbase/", false), URI.createURI("classpath:/"));
    rs.getURIConverter().getURIMap().put(URI.createPlatformResourceURI("org.eclipse.emf.ecore/", false), URI.createURI("classpath:/"));
    rs.getURIConverter().getURIMap().put(URI.createPlatformResourceURI("org.eclipse.xtext.common.types/", false), URI.createURI("classpath:/"));
    rs.setClasspathURIContext(this.getClass());
    Resource _createResource = this.getResourceFactory().createResource(uri);
    final XtextResource resource = ((XtextResource) _createResource);
    rs.getResources().add(resource);
    XtextLinker linker = new XtextLinker() {
      @Override
      protected Xtext2EcoreTransformer createTransformer(final Grammar grammar, final IDiagnosticConsumer consumer) {
        Xtext2EcoreTransformer result = super.createTransformer(grammar, consumer);
        ErrorAcceptor _errorAcceptor = result.getErrorAcceptor();
        Xtext2EcoreTransformerTest.MyErrorAcceptor _myErrorAcceptor = new Xtext2EcoreTransformerTest.MyErrorAcceptor(_errorAcceptor, Xtext2EcoreTransformerTest.this.errorAcceptorMock);
        result.setErrorAcceptor(_myErrorAcceptor);
        return result;
      }
    };
    ILinker _linker = resource.getLinker();
    linker.setScopeProvider(((XtextLinker) _linker).getScopeProvider());
    ILinker _linker_1 = resource.getLinker();
    linker.setLinkingService(((Linker) _linker_1).getLinkingService());
    ILinker _linker_2 = resource.getLinker();
    linker.setLinkingHelper(((Linker) _linker_2).getLinkingHelper());
    XtextLinker.PackageRemover _packageRemover = new XtextLinker.PackageRemover();
    linker.setPackageRemover(_packageRemover);
    LinkingDiagnosticMessageProvider _linkingDiagnosticMessageProvider = new LinkingDiagnosticMessageProvider();
    linker.setDiagnosticMessageProvider(_linkingDiagnosticMessageProvider);
    OnChangeEvictingCache _onChangeEvictingCache = new OnChangeEvictingCache();
    linker.setCache(_onChangeEvictingCache);
    resource.setLinker(linker);
    resource.load(in, null);
    return resource;
  }
  
  @Test
  public void testMultiInheritance_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/xtext/common/JavaVMTypes\' as types");
    _builder.newLine();
    _builder.append("generate myDsl \"http://example.xtext.org/MyDsl\" as mydsl");
    _builder.newLine();
    _builder.append("Array returns mydsl::Array: componentType=ComponentType componentType=DeclaredType;");
    _builder.newLine();
    _builder.append("DeclaredType returns types::JvmDeclaredType: members+=DeclaredType;");
    _builder.newLine();
    _builder.append("ComponentType returns types::JvmComponentType: \'ignore\';");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammarAsString);
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    final Grammar grammar = ((Grammar) _head);
    EClassifier _classifier = IterableExtensions.<AbstractRule>head(grammar.getRules()).getType().getClassifier();
    EClass array = ((EClass) _classifier);
    Assert.assertEquals("JvmComponentType", this.<EStructuralFeature>feature(array, "componentType").getEType().getName());
  }
  
  @Test
  public void testMultiInheritance_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/xtext/common/JavaVMTypes\' as types");
    _builder.newLine();
    _builder.append("generate myDsl \"http://example.xtext.org/MyDsl\" as mydsl");
    _builder.newLine();
    _builder.append("Array returns mydsl::Array: componentType=DeclaredType componentType=ComponentType;");
    _builder.newLine();
    _builder.append("DeclaredType returns types::JvmDeclaredType: members+=DeclaredType;");
    _builder.newLine();
    _builder.append("ComponentType returns types::JvmComponentType: \'ignore\';");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammarAsString);
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    final Grammar grammar = ((Grammar) _head);
    EClassifier _classifier = IterableExtensions.<AbstractRule>head(grammar.getRules()).getType().getClassifier();
    EClass array = ((EClass) _classifier);
    Assert.assertEquals("JvmComponentType", this.<EStructuralFeature>feature(array, "componentType").getEType().getName());
  }
  
  @Test
  public void testBug316610_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/xtext/common/JavaVMTypes\' as types");
    _builder.newLine();
    _builder.append("DeclaredType returns types::JvmDeclaredType: superTypes+=DeclaredType;");
    final String grammarAsString = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammarAsString, 1);
    Assert.assertTrue(IterableExtensions.<Resource.Diagnostic>head(resource.getErrors()).getMessage().contains("JvmTypeReference"));
  }
  
  @Test
  public void testBug316610_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/xtext/common/JavaVMTypes\' as types");
    _builder.newLine();
    _builder.append("Array returns types::JvmGenericArrayTypeReference: componentType=STRING;");
    final String grammarAsString = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammarAsString, 1);
    Assert.assertTrue(IterableExtensions.<Resource.Diagnostic>head(resource.getErrors()).getMessage().contains("JvmTypeReference"));
  }
  
  @Test
  public void testBug316610_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/xtext/common/JavaVMTypes\' as types");
    _builder.newLine();
    _builder.append("DeclaredType returns types::JvmDeclaredType: superTypes=[types::JvmTypeReference];");
    final String grammarAsString = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammarAsString, 1);
    Assert.assertTrue(
      IterableExtensions.<Resource.Diagnostic>head(resource.getErrors()).getMessage().contains(
        "cardinality"));
  }
  
  @Test
  public void testBug316610_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/xtext/common/JavaVMTypes\' as types");
    _builder.newLine();
    _builder.append("DeclaredType returns types::JvmDeclaredType: superTypes+=[types::JvmTypeReference];");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammarAsString, 1);
    Assert.assertTrue(IterableExtensions.<Resource.Diagnostic>head(resource.getErrors()).getMessage().contains("containment"));
  }
  
  @Test
  public void testBug346035_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \'platform:/resource/org.eclipse.xtext.xbase/model/Xbase.ecore\' as xbase");
    _builder.newLine();
    _builder.append("generate myDsl \'uri\'");
    _builder.newLine();
    _builder.append("Model: elements+=Element*;");
    _builder.newLine();
    _builder.append("Element returns xbase::XExpression : {Element} \'Hello\';");
    _builder.newLine();
    _builder.append("terminal ID : \'^\'?(\'a\'..\'z\'|\'A\'..\'Z\'|\'_\') (\'a\'..\'z\'|\'A\'..\'Z\'|\'_\'|\'0\'..\'9\')*;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromString(grammarAsString);
  }
  
  @Test
  public void testEcoreReference_01() throws Exception {
    final XtextResourceSet resourceSet = new XtextResourceSet();
    resourceSet.getURIConverter().getURIMap().put(URI.createPlatformPluginURI("org.eclipse.xtext/", false), URI.createURI("classpath:/"));
    resourceSet.getURIConverter().getURIMap().put(URI.createPlatformPluginURI("org.eclipse.xtext.xbase/", false), URI.createURI("classpath:/"));
    resourceSet.getURIConverter().getURIMap().put(URI.createPlatformPluginURI("org.eclipse.xtext.common.types/", false), URI.createURI("classpath:/"));
    resourceSet.getURIConverter().getURIMap().put(URI.createPlatformPluginURI("org.eclipse.emf.ecore/", false), URI.createURI("classpath:/"));
    resourceSet.getURIConverter().getURIMap().put(URI.createPlatformPluginURI("org.eclipse.xtext.tests/src/", false), URI.createURI("classpath:/"));
    resourceSet.getURIConverter().getURIMap().put(URI.createPlatformResourceURI("org.eclipse.xtext.xbase/", false), URI.createURI("classpath:/"));
    resourceSet.getURIConverter().getURIMap().put(URI.createPlatformResourceURI("org.eclipse.emf.ecore/", false), URI.createURI("classpath:/"));
    resourceSet.getURIConverter().getURIMap().put(URI.createPlatformResourceURI("org.eclipse.xtext.common.types/", false), URI.createURI("classpath:/"));
    resourceSet.getURIConverter().getURIMap().put(URI.createPlatformResourceURI("org.eclipse.xtext.tests/src/", false), URI.createURI("classpath:/"));
    resourceSet.setClasspathURIContext(this.getClass());
    resourceSet.getURIConverter().getURIMap().put(
      URI.createURI(
        "platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore"), URI.createURI(
      "platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore"));
    Assert.assertFalse(
      resourceSet.getResource(URI.createURI("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore"), true).getContents().isEmpty());
    Assert.assertFalse(
      resourceSet.getResource(
        URI.createURI(
          "platform:/plugin/org.eclipse.xtext.tests/src/org/eclipse/xtext/metamodelreferencing/tests/EcorePerNsURI.ecore"), 
        true).getContents().isEmpty());
    Assert.assertFalse(
      resourceSet.getResource(
        URI.createURI(
          "platform:/plugin/org.eclipse.xtext.tests/src/org/eclipse/xtext/metamodelreferencing/tests/EcorePerPlatformResource.ecore"), 
        true).getContents().isEmpty());
    Assert.assertFalse(
      resourceSet.getResource(
        URI.createURI(
          "platform:/plugin/org.eclipse.xtext.tests/src/org/eclipse/xtext/metamodelreferencing/tests/EcorePerPlatformPlugin.ecore"), 
        true).getContents().isEmpty());
    Resource _resource = resourceSet.getResource(
      URI.createURI(
        "classpath:/org/eclipse/xtext/metamodelreferencing/tests/EcoreReferenceTestLanguage.xtext"), 
      true);
    final XtextResource resource = ((XtextResource) _resource);
    Assert.assertTrue(Joiner.on("\n").join(resource.getErrors()), resource.getErrors().isEmpty());
  }
}
