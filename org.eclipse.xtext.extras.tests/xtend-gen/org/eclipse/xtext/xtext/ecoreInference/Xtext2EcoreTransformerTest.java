/**
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.ecoreInference;

import com.google.common.base.Joiner;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScopeProvider;
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
  
  private EPackage getEPackageFromGrammar(final String xtextGrammar, final int expectedErrors) throws Exception {
    final List<EPackage> metamodels = this.getEPackagesFromGrammar(xtextGrammar, expectedErrors);
    Assert.assertEquals(1, metamodels.size());
    final EPackage result = IterableExtensions.<EPackage>head(metamodels);
    Assert.assertNotNull(result);
    return result;
  }
  
  private EPackage getEPackageFromGrammar(final String xtextGrammar) throws Exception {
    return this.getEPackageFromGrammar(xtextGrammar, 0);
  }
  
  @Override
  public XtextResource doGetResource(final InputStream in, final URI uri) throws Exception {
    XtextResourceSet rs = this.<XtextResourceSet>get(XtextResourceSet.class);
    URIConverter _uRIConverter = rs.getURIConverter();
    Map<URI, URI> _uRIMap = _uRIConverter.getURIMap();
    URI _createPlatformPluginURI = URI.createPlatformPluginURI("org.eclipse.xtext/", false);
    URI _createURI = URI.createURI("classpath:/");
    _uRIMap.put(_createPlatformPluginURI, _createURI);
    URIConverter _uRIConverter_1 = rs.getURIConverter();
    Map<URI, URI> _uRIMap_1 = _uRIConverter_1.getURIMap();
    URI _createPlatformPluginURI_1 = URI.createPlatformPluginURI("org.eclipse.xtext.xbase/", false);
    URI _createURI_1 = URI.createURI("classpath:/");
    _uRIMap_1.put(_createPlatformPluginURI_1, _createURI_1);
    URIConverter _uRIConverter_2 = rs.getURIConverter();
    Map<URI, URI> _uRIMap_2 = _uRIConverter_2.getURIMap();
    URI _createPlatformPluginURI_2 = URI.createPlatformPluginURI("org.eclipse.xtext.common.types/", false);
    URI _createURI_2 = URI.createURI("classpath:/");
    _uRIMap_2.put(_createPlatformPluginURI_2, _createURI_2);
    URIConverter _uRIConverter_3 = rs.getURIConverter();
    Map<URI, URI> _uRIMap_3 = _uRIConverter_3.getURIMap();
    URI _createPlatformPluginURI_3 = URI.createPlatformPluginURI("org.eclipse.emf.ecore/", false);
    URI _createURI_3 = URI.createURI("classpath:/");
    _uRIMap_3.put(_createPlatformPluginURI_3, _createURI_3);
    URIConverter _uRIConverter_4 = rs.getURIConverter();
    Map<URI, URI> _uRIMap_4 = _uRIConverter_4.getURIMap();
    URI _createPlatformResourceURI = URI.createPlatformResourceURI("org.eclipse.xtext.xbase/", false);
    URI _createURI_4 = URI.createURI("classpath:/");
    _uRIMap_4.put(_createPlatformResourceURI, _createURI_4);
    URIConverter _uRIConverter_5 = rs.getURIConverter();
    Map<URI, URI> _uRIMap_5 = _uRIConverter_5.getURIMap();
    URI _createPlatformResourceURI_1 = URI.createPlatformResourceURI("org.eclipse.emf.ecore/", false);
    URI _createURI_5 = URI.createURI("classpath:/");
    _uRIMap_5.put(_createPlatformResourceURI_1, _createURI_5);
    URIConverter _uRIConverter_6 = rs.getURIConverter();
    Map<URI, URI> _uRIMap_6 = _uRIConverter_6.getURIMap();
    URI _createPlatformResourceURI_2 = URI.createPlatformResourceURI("org.eclipse.xtext.common.types/", false);
    URI _createURI_6 = URI.createURI("classpath:/");
    _uRIMap_6.put(_createPlatformResourceURI_2, _createURI_6);
    Class<? extends Xtext2EcoreTransformerTest> _class = this.getClass();
    rs.setClasspathURIContext(_class);
    IResourceFactory _resourceFactory = this.getResourceFactory();
    Resource _createResource = _resourceFactory.createResource(uri);
    final XtextResource resource = ((XtextResource) _createResource);
    EList<Resource> _resources = rs.getResources();
    _resources.add(resource);
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
    IScopeProvider _scopeProvider = ((XtextLinker) _linker).getScopeProvider();
    linker.setScopeProvider(_scopeProvider);
    ILinker _linker_1 = resource.getLinker();
    ILinkingService _linkingService = ((Linker) _linker_1).getLinkingService();
    linker.setLinkingService(_linkingService);
    ILinker _linker_2 = resource.getLinker();
    LinkingHelper _linkingHelper = ((Linker) _linker_2).getLinkingHelper();
    linker.setLinkingHelper(_linkingHelper);
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
  
  private List<EPackage> getEPackagesFromGrammar(final String xtextGrammar, final int expectedErrors) throws Exception {
    this.errorAcceptorMock.replay();
    EObject _modelAndExpect = this.getModelAndExpect(xtextGrammar, expectedErrors);
    final Grammar grammar = ((Grammar) _modelAndExpect);
    this.errorAcceptorMock.verify();
    final List<EPackage> metamodels = Xtext2EcoreTransformer.doGetGeneratedPackages(grammar);
    Assert.assertNotNull(metamodels);
    return metamodels;
  }
  
  private EAttribute assertAttributeConfiguration(final EClass eClass, final int attributeIndex, final String featureName, final String featureTypeName) {
    EList<EAttribute> _eAttributes = eClass.getEAttributes();
    final EAttribute feature = _eAttributes.get(attributeIndex);
    Assert.assertEquals(featureName, feature.getName());
    Assert.assertNotNull(feature.getEType());
    Assert.assertEquals(featureTypeName, feature.getEType().getName());
    return feature;
  }
  
  private EAttribute assertAttributeConfiguration(final EClass eClass, final int attributeIndex, final String featureName, final String featureTypeName, final int lowerBound, final int upperBound) {
    final EAttribute feature = this.assertAttributeConfiguration(eClass, attributeIndex, featureName, featureTypeName);
    Assert.assertEquals(lowerBound, feature.getLowerBound());
    Assert.assertEquals(upperBound, feature.getUpperBound());
    return feature;
  }
  
  private EReference assertReferenceConfiguration(final EClass eClass, final int referenceIndex, final String featureName, final String featureTypeName, final boolean isContainment, final int lowerBound, final int upperBound) {
    EList<EReference> _eReferences = eClass.getEReferences();
    final EReference reference = _eReferences.get(referenceIndex);
    Assert.assertEquals(featureName, reference.getName());
    Assert.assertNotNull(reference.getEType());
    Assert.assertEquals(featureTypeName, reference.getEType().getName());
    Assert.assertEquals(Boolean.valueOf(isContainment), Boolean.valueOf(reference.isContainment()));
    Assert.assertEquals(lowerBound, reference.getLowerBound());
    Assert.assertEquals(upperBound, reference.getUpperBound());
    return reference;
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
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final Grammar grammar = ((Grammar) _head);
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _head_1 = IterableExtensions.<AbstractRule>head(_rules);
    TypeRef _type = _head_1.getType();
    EClassifier _classifier = _type.getClassifier();
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
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final Grammar grammar = ((Grammar) _head);
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _head_1 = IterableExtensions.<AbstractRule>head(_rules);
    TypeRef _type = _head_1.getType();
    EClassifier _classifier = _type.getClassifier();
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
    URIConverter _uRIConverter = resourceSet.getURIConverter();
    Map<URI, URI> _uRIMap = _uRIConverter.getURIMap();
    URI _createPlatformPluginURI = URI.createPlatformPluginURI("org.eclipse.xtext/", false);
    URI _createURI = URI.createURI("classpath:/");
    _uRIMap.put(_createPlatformPluginURI, _createURI);
    URIConverter _uRIConverter_1 = resourceSet.getURIConverter();
    Map<URI, URI> _uRIMap_1 = _uRIConverter_1.getURIMap();
    URI _createPlatformPluginURI_1 = URI.createPlatformPluginURI("org.eclipse.xtext.xbase/", false);
    URI _createURI_1 = URI.createURI("classpath:/");
    _uRIMap_1.put(_createPlatformPluginURI_1, _createURI_1);
    URIConverter _uRIConverter_2 = resourceSet.getURIConverter();
    Map<URI, URI> _uRIMap_2 = _uRIConverter_2.getURIMap();
    URI _createPlatformPluginURI_2 = URI.createPlatformPluginURI("org.eclipse.xtext.common.types/", false);
    URI _createURI_2 = URI.createURI("classpath:/");
    _uRIMap_2.put(_createPlatformPluginURI_2, _createURI_2);
    URIConverter _uRIConverter_3 = resourceSet.getURIConverter();
    Map<URI, URI> _uRIMap_3 = _uRIConverter_3.getURIMap();
    URI _createPlatformPluginURI_3 = URI.createPlatformPluginURI("org.eclipse.emf.ecore/", false);
    URI _createURI_3 = URI.createURI("classpath:/");
    _uRIMap_3.put(_createPlatformPluginURI_3, _createURI_3);
    URIConverter _uRIConverter_4 = resourceSet.getURIConverter();
    Map<URI, URI> _uRIMap_4 = _uRIConverter_4.getURIMap();
    URI _createPlatformPluginURI_4 = URI.createPlatformPluginURI("org.eclipse.xtext.tests/src/", false);
    URI _createURI_4 = URI.createURI("classpath:/");
    _uRIMap_4.put(_createPlatformPluginURI_4, _createURI_4);
    URIConverter _uRIConverter_5 = resourceSet.getURIConverter();
    Map<URI, URI> _uRIMap_5 = _uRIConverter_5.getURIMap();
    URI _createPlatformResourceURI = URI.createPlatformResourceURI("org.eclipse.xtext.xbase/", false);
    URI _createURI_5 = URI.createURI("classpath:/");
    _uRIMap_5.put(_createPlatformResourceURI, _createURI_5);
    URIConverter _uRIConverter_6 = resourceSet.getURIConverter();
    Map<URI, URI> _uRIMap_6 = _uRIConverter_6.getURIMap();
    URI _createPlatformResourceURI_1 = URI.createPlatformResourceURI("org.eclipse.emf.ecore/", false);
    URI _createURI_6 = URI.createURI("classpath:/");
    _uRIMap_6.put(_createPlatformResourceURI_1, _createURI_6);
    URIConverter _uRIConverter_7 = resourceSet.getURIConverter();
    Map<URI, URI> _uRIMap_7 = _uRIConverter_7.getURIMap();
    URI _createPlatformResourceURI_2 = URI.createPlatformResourceURI("org.eclipse.xtext.common.types/", false);
    URI _createURI_7 = URI.createURI("classpath:/");
    _uRIMap_7.put(_createPlatformResourceURI_2, _createURI_7);
    URIConverter _uRIConverter_8 = resourceSet.getURIConverter();
    Map<URI, URI> _uRIMap_8 = _uRIConverter_8.getURIMap();
    URI _createPlatformResourceURI_3 = URI.createPlatformResourceURI("org.eclipse.xtext.tests/src/", false);
    URI _createURI_8 = URI.createURI("classpath:/");
    _uRIMap_8.put(_createPlatformResourceURI_3, _createURI_8);
    Class<? extends Xtext2EcoreTransformerTest> _class = this.getClass();
    resourceSet.setClasspathURIContext(_class);
    URIConverter _uRIConverter_9 = resourceSet.getURIConverter();
    Map<URI, URI> _uRIMap_9 = _uRIConverter_9.getURIMap();
    URI _createURI_9 = URI.createURI(
      "platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore");
    URI _createURI_10 = URI.createURI(
      "platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore");
    _uRIMap_9.put(_createURI_9, _createURI_10);
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
    URI _createURI_11 = URI.createURI(
      "classpath:/org/eclipse/xtext/metamodelreferencing/tests/EcoreReferenceTestLanguage.xtext");
    Resource _resource = resourceSet.getResource(_createURI_11, 
      true);
    final XtextResource resource = ((XtextResource) _resource);
    Assert.assertTrue(Joiner.on("\n").join(resource.getErrors()), resource.getErrors().isEmpty());
  }
}
