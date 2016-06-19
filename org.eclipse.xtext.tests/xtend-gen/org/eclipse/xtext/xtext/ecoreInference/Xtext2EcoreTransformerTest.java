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
    int _size = metamodels.size();
    Assert.assertEquals(1, _size);
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
    String _name = feature.getName();
    Assert.assertEquals(featureName, _name);
    EClassifier _eType = feature.getEType();
    Assert.assertNotNull(_eType);
    EClassifier _eType_1 = feature.getEType();
    String _name_1 = _eType_1.getName();
    Assert.assertEquals(featureTypeName, _name_1);
    return feature;
  }
  
  private EAttribute assertAttributeConfiguration(final EClass eClass, final int attributeIndex, final String featureName, final String featureTypeName, final int lowerBound, final int upperBound) {
    final EAttribute feature = this.assertAttributeConfiguration(eClass, attributeIndex, featureName, featureTypeName);
    int _lowerBound = feature.getLowerBound();
    Assert.assertEquals(lowerBound, _lowerBound);
    int _upperBound = feature.getUpperBound();
    Assert.assertEquals(upperBound, _upperBound);
    return feature;
  }
  
  private EReference assertReferenceConfiguration(final EClass eClass, final int referenceIndex, final String featureName, final String featureTypeName, final boolean isContainment, final int lowerBound, final int upperBound) {
    EList<EReference> _eReferences = eClass.getEReferences();
    final EReference reference = _eReferences.get(referenceIndex);
    String _name = reference.getName();
    Assert.assertEquals(featureName, _name);
    EClassifier _eType = reference.getEType();
    Assert.assertNotNull(_eType);
    EClassifier _eType_1 = reference.getEType();
    String _name_1 = _eType_1.getName();
    Assert.assertEquals(featureTypeName, _name_1);
    boolean _isContainment = reference.isContainment();
    Assert.assertEquals(Boolean.valueOf(isContainment), Boolean.valueOf(_isContainment));
    int _lowerBound = reference.getLowerBound();
    Assert.assertEquals(lowerBound, _lowerBound);
    int _upperBound = reference.getUpperBound();
    Assert.assertEquals(upperBound, _upperBound);
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
    EStructuralFeature _feature = this.<EStructuralFeature>feature(array, "componentType");
    EClassifier _eType = _feature.getEType();
    String _name = _eType.getName();
    Assert.assertEquals("JvmComponentType", _name);
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
    EStructuralFeature _feature = this.<EStructuralFeature>feature(array, "componentType");
    EClassifier _eType = _feature.getEType();
    String _name = _eType.getName();
    Assert.assertEquals("JvmComponentType", _name);
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
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(_errors);
    String _message = _head.getMessage();
    boolean _contains = _message.contains("JvmTypeReference");
    Assert.assertTrue(_contains);
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
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(_errors);
    String _message = _head.getMessage();
    boolean _contains = _message.contains("JvmTypeReference");
    Assert.assertTrue(_contains);
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
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(_errors);
    String _message = _head.getMessage();
    boolean _contains = _message.contains(
      "cardinality");
    Assert.assertTrue(_contains);
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
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(_errors);
    String _message = _head.getMessage();
    boolean _contains = _message.contains("containment");
    Assert.assertTrue(_contains);
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
    Class<? extends Xtext2EcoreTransformerTest> _class = this.getClass();
    resourceSet.setClasspathURIContext(_class);
    URIConverter _uRIConverter = resourceSet.getURIConverter();
    Map<URI, URI> _uRIMap = _uRIConverter.getURIMap();
    URI _createURI = URI.createURI(
      "platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore");
    URI _createURI_1 = URI.createURI(
      "platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore");
    _uRIMap.put(_createURI, _createURI_1);
    URI _createURI_2 = URI.createURI("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore");
    Resource _resource = resourceSet.getResource(_createURI_2, true);
    EList<EObject> _contents = _resource.getContents();
    boolean _isEmpty = _contents.isEmpty();
    Assert.assertFalse(_isEmpty);
    URI _createURI_3 = URI.createURI(
      "platform:/plugin/org.eclipse.xtext.tests/src/org/eclipse/xtext/metamodelreferencing/tests/EcorePerNsURI.ecore");
    Resource _resource_1 = resourceSet.getResource(_createURI_3, 
      true);
    EList<EObject> _contents_1 = _resource_1.getContents();
    boolean _isEmpty_1 = _contents_1.isEmpty();
    Assert.assertFalse(_isEmpty_1);
    URI _createURI_4 = URI.createURI(
      "platform:/plugin/org.eclipse.xtext.tests/src/org/eclipse/xtext/metamodelreferencing/tests/EcorePerPlatformResource.ecore");
    Resource _resource_2 = resourceSet.getResource(_createURI_4, 
      true);
    EList<EObject> _contents_2 = _resource_2.getContents();
    boolean _isEmpty_2 = _contents_2.isEmpty();
    Assert.assertFalse(_isEmpty_2);
    URI _createURI_5 = URI.createURI(
      "platform:/plugin/org.eclipse.xtext.tests/src/org/eclipse/xtext/metamodelreferencing/tests/EcorePerPlatformPlugin.ecore");
    Resource _resource_3 = resourceSet.getResource(_createURI_5, 
      true);
    EList<EObject> _contents_3 = _resource_3.getContents();
    boolean _isEmpty_3 = _contents_3.isEmpty();
    Assert.assertFalse(_isEmpty_3);
    URI _createURI_6 = URI.createURI(
      "classpath:/org/eclipse/xtext/metamodelreferencing/tests/EcoreReferenceTestLanguage.xtext");
    Resource _resource_4 = resourceSet.getResource(_createURI_6, 
      true);
    final XtextResource resource = ((XtextResource) _resource_4);
    Joiner _on = Joiner.on("\n");
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _join = _on.join(_errors);
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    boolean _isEmpty_4 = _errors_1.isEmpty();
    Assert.assertTrue(_join, _isEmpty_4);
  }
}
