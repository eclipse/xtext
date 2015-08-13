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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.tests.TestErrorAcceptor;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.XtextLinker;
import org.eclipse.xtext.xtext.ecoreInference.EClassifierInfo;
import org.eclipse.xtext.xtext.ecoreInference.EClassifierInfos;
import org.eclipse.xtext.xtext.ecoreInference.ErrorAcceptor;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;
import org.eclipse.xtext.xtext.ecoreInference.TransformationDiagnostic;
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
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
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
  public void testEscapeChar_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("^MyRule: name=^ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    final EList<EClassifier> classifiers = ePackage.getEClassifiers();
    int _size = classifiers.size();
    Assert.assertEquals(1, _size);
    final EClassifier myRuleType = IterableExtensions.<EClassifier>head(classifiers);
    String _name = myRuleType.getName();
    Assert.assertEquals("MyRule", _name);
  }
  
  @Test
  public void testEscapeChar_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("^RootRule: ^Sub1 | ^Sub2;");
    _builder.newLine();
    _builder.append("^Sub1: {^Sub1} \'sub1\';");
    _builder.newLine();
    _builder.append("^Sub2: {^Sub2} \'sub2\';");
    _builder.newLine();
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    final EList<EClassifier> classifiers = ePackage.getEClassifiers();
    int _size = classifiers.size();
    Assert.assertEquals(3, _size);
    EClassifier _get = classifiers.get(0);
    String _name = _get.getName();
    Assert.assertEquals("RootRule", _name);
    EClassifier _get_1 = classifiers.get(1);
    String _name_1 = _get_1.getName();
    Assert.assertEquals("Sub1", _name_1);
    EClassifier _get_2 = classifiers.get(2);
    String _name_2 = _get_2.getName();
    Assert.assertEquals("Sub2", _name_2);
  }
  
  @Test
  public void testParserRuleFragment_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("MyRule: IntFeature;");
    _builder.newLine();
    _builder.append("fragment IntFeature*: myFeature=INT;");
    _builder.newLine();
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    final EList<EClassifier> classifiers = ePackage.getEClassifiers();
    int _size = classifiers.size();
    Assert.assertEquals(1, _size);
    final EClassifier myRuleType = IterableExtensions.<EClassifier>head(classifiers);
    String _name = myRuleType.getName();
    Assert.assertEquals("MyRule", _name);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(myRuleType, "myFeature");
    EClassifier _eType = _feature.getEType();
    String _name_1 = _eType.getName();
    Assert.assertEquals("EInt", _name_1);
  }
  
  @Test
  public void testParserRuleFragment_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("MyRule: IntFeatureHolder;");
    _builder.newLine();
    _builder.append("fragment IntFeatureHolder: myFeature=INT;");
    _builder.newLine();
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    final EList<EClassifier> classifiers = ePackage.getEClassifiers();
    int _size = classifiers.size();
    Assert.assertEquals(2, _size);
    final EClassifier myRuleType = IterableExtensions.<EClassifier>head(classifiers);
    String _name = myRuleType.getName();
    Assert.assertEquals("MyRule", _name);
    List<? extends EStructuralFeature> _features = this.features(myRuleType);
    boolean _isEmpty = _features.isEmpty();
    Assert.assertTrue(_isEmpty);
    final EClassifier intFeatureHolder = IterableExtensions.<EClassifier>last(classifiers);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(intFeatureHolder, "myFeature");
    EClassifier _eType = _feature.getEType();
    String _name_1 = _eType.getName();
    Assert.assertEquals("EInt", _name_1);
    List<EClass> _superTypes = this.superTypes(myRuleType);
    boolean _contains = _superTypes.contains(intFeatureHolder);
    Assert.assertTrue(_contains);
  }
  
  @Test
  public void testParserRuleFragment_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("MyRule: IntFeatureHolder;");
    _builder.newLine();
    _builder.append("fragment IntFeatureHolder: myFeature=INT NameFeatureHolder;");
    _builder.newLine();
    _builder.append("fragment NameFeatureHolder: name=STRING;");
    _builder.newLine();
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    final EList<EClassifier> classifiers = ePackage.getEClassifiers();
    int _size = classifiers.size();
    Assert.assertEquals(3, _size);
    final EClassifier myRuleType = IterableExtensions.<EClassifier>head(classifiers);
    String _name = myRuleType.getName();
    Assert.assertEquals("MyRule", _name);
    List<? extends EStructuralFeature> _features = this.features(myRuleType);
    boolean _isEmpty = _features.isEmpty();
    Assert.assertTrue(_isEmpty);
    final EClassifier intFeatureHolder = classifiers.get(1);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(intFeatureHolder, "myFeature");
    EClassifier _eType = _feature.getEType();
    String _name_1 = _eType.getName();
    Assert.assertEquals("EInt", _name_1);
    List<EClass> _superTypes = this.superTypes(myRuleType);
    boolean _contains = _superTypes.contains(intFeatureHolder);
    Assert.assertTrue(_contains);
    final EClassifier nameFeatureHolder = IterableExtensions.<EClassifier>last(classifiers);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(nameFeatureHolder, "name");
    EClassifier _eType_1 = _feature_1.getEType();
    String _name_2 = _eType_1.getName();
    Assert.assertEquals("EString", _name_2);
    List<EClass> _superTypes_1 = this.superTypes(intFeatureHolder);
    boolean _contains_1 = _superTypes_1.contains(nameFeatureHolder);
    Assert.assertTrue(_contains_1);
  }
  
  @Test
  public void testParserRuleFragment_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("MyRule: Documentable IntFeatureHolder;");
    _builder.newLine();
    _builder.append("fragment IntFeatureHolder: Documentable myFeature=INT NameFeatureHolder;");
    _builder.newLine();
    _builder.append("fragment NameFeatureHolder: Documentable name=STRING;");
    _builder.newLine();
    _builder.append("fragment Documentable*: doc=STRING;");
    _builder.newLine();
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    final EList<EClassifier> classifiers = ePackage.getEClassifiers();
    int _size = classifiers.size();
    Assert.assertEquals(3, _size);
    final EClassifier myRuleType = IterableExtensions.<EClassifier>head(classifiers);
    String _name = myRuleType.getName();
    Assert.assertEquals("MyRule", _name);
    List<? extends EStructuralFeature> _features = this.features(myRuleType);
    boolean _isEmpty = _features.isEmpty();
    Assert.assertTrue(_isEmpty);
    final EClassifier intFeatureHolder = classifiers.get(1);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(intFeatureHolder, "myFeature");
    EClassifier _eType = _feature.getEType();
    String _name_1 = _eType.getName();
    Assert.assertEquals("EInt", _name_1);
    List<? extends EStructuralFeature> _features_1 = this.features(intFeatureHolder);
    int _size_1 = _features_1.size();
    Assert.assertEquals(1, _size_1);
    final EClassifier nameFeatureHolder = IterableExtensions.<EClassifier>last(classifiers);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(nameFeatureHolder, "name");
    EClassifier _eType_1 = _feature_1.getEType();
    String _name_2 = _eType_1.getName();
    Assert.assertEquals("EString", _name_2);
    List<? extends EStructuralFeature> _features_2 = this.features(nameFeatureHolder);
    int _size_2 = _features_2.size();
    Assert.assertEquals(2, _size_2);
  }
  
  @Test
  public void testParserRuleFragment_05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Middle: Top;");
    _builder.newLine();
    _builder.append("fragment Top: name=ID ({Bottom.prev=current} Top)?;");
    _builder.newLine();
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    final EList<EClassifier> classifiers = ePackage.getEClassifiers();
    int _size = classifiers.size();
    Assert.assertEquals(3, _size);
    final EClassifier middleType = IterableExtensions.<EClassifier>head(classifiers);
    String _name = middleType.getName();
    Assert.assertEquals("Middle", _name);
    List<? extends EStructuralFeature> _features = this.features(middleType);
    boolean _isEmpty = _features.isEmpty();
    Assert.assertTrue(_isEmpty);
    final EClassifier topType = classifiers.get(1);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(topType, "name");
    EClassifier _eType = _feature.getEType();
    String _name_1 = _eType.getName();
    Assert.assertEquals("EString", _name_1);
    List<EClass> _superTypes = this.superTypes(middleType);
    boolean _contains = _superTypes.contains(topType);
    Assert.assertTrue(_contains);
    final EClassifier bottomType = IterableExtensions.<EClassifier>last(classifiers);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(bottomType, "prev");
    EClassifier _eType_1 = _feature_1.getEType();
    String _name_2 = _eType_1.getName();
    Assert.assertEquals("Top", _name_2);
    List<EClass> _superTypes_1 = this.superTypes(bottomType);
    boolean _contains_1 = _superTypes_1.contains(middleType);
    Assert.assertTrue(_contains_1);
  }
  
  @Test
  public void testParserRuleFragment_06() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Middle1: Top;");
    _builder.newLine();
    _builder.append("Middle2: Top;");
    _builder.newLine();
    _builder.append("fragment Top: name=ID ({Bottom.prev=current} Top)?;");
    _builder.newLine();
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    final EList<EClassifier> classifiers = ePackage.getEClassifiers();
    int _size = classifiers.size();
    Assert.assertEquals(4, _size);
    final EClassifier middleType1 = IterableExtensions.<EClassifier>head(classifiers);
    String _name = middleType1.getName();
    Assert.assertEquals("Middle1", _name);
    List<? extends EStructuralFeature> _features = this.features(middleType1);
    boolean _isEmpty = _features.isEmpty();
    Assert.assertTrue(_isEmpty);
    final EClassifier middleType2 = classifiers.get(1);
    String _name_1 = middleType2.getName();
    Assert.assertEquals("Middle2", _name_1);
    List<? extends EStructuralFeature> _features_1 = this.features(middleType2);
    boolean _isEmpty_1 = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    final EClassifier topType = classifiers.get(2);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(topType, "name");
    EClassifier _eType = _feature.getEType();
    String _name_2 = _eType.getName();
    Assert.assertEquals("EString", _name_2);
    List<EClass> _superTypes = this.superTypes(middleType1);
    boolean _contains = _superTypes.contains(topType);
    Assert.assertTrue(_contains);
    List<EClass> _superTypes_1 = this.superTypes(middleType2);
    boolean _contains_1 = _superTypes_1.contains(topType);
    Assert.assertTrue(_contains_1);
    final EClassifier bottomType = IterableExtensions.<EClassifier>last(classifiers);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(bottomType, "prev");
    EClassifier _eType_1 = _feature_1.getEType();
    String _name_3 = _eType_1.getName();
    Assert.assertEquals("Top", _name_3);
    List<EClass> _superTypes_2 = this.superTypes(bottomType);
    boolean _contains_2 = _superTypes_2.contains(middleType1);
    Assert.assertTrue(_contains_2);
    List<EClass> _superTypes_3 = this.superTypes(bottomType);
    boolean _contains_3 = _superTypes_3.contains(middleType2);
    Assert.assertTrue(_contains_3);
  }
  
  @Test
  public void testParserRuleFragment_07() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Middle1: Top;");
    _builder.newLine();
    _builder.append("Middle2: Top;");
    _builder.newLine();
    _builder.append("fragment Top: name=ID ({Bottom.prev=current} name=ID)*;");
    _builder.newLine();
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    final EList<EClassifier> classifiers = ePackage.getEClassifiers();
    int _size = classifiers.size();
    Assert.assertEquals(4, _size);
    final EClassifier middleType1 = IterableExtensions.<EClassifier>head(classifiers);
    String _name = middleType1.getName();
    Assert.assertEquals("Middle1", _name);
    List<? extends EStructuralFeature> _features = this.features(middleType1);
    boolean _isEmpty = _features.isEmpty();
    Assert.assertTrue(_isEmpty);
    final EClassifier middleType2 = classifiers.get(1);
    String _name_1 = middleType2.getName();
    Assert.assertEquals("Middle2", _name_1);
    List<? extends EStructuralFeature> _features_1 = this.features(middleType2);
    boolean _isEmpty_1 = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    final EClassifier topType = classifiers.get(2);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(topType, "name");
    EClassifier _eType = _feature.getEType();
    String _name_2 = _eType.getName();
    Assert.assertEquals("EString", _name_2);
    List<EClass> _superTypes = this.superTypes(middleType1);
    boolean _contains = _superTypes.contains(topType);
    Assert.assertTrue(_contains);
    List<EClass> _superTypes_1 = this.superTypes(middleType2);
    boolean _contains_1 = _superTypes_1.contains(topType);
    Assert.assertTrue(_contains_1);
    final EClassifier bottomType = IterableExtensions.<EClassifier>last(classifiers);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(bottomType, "prev");
    EClassifier _eType_1 = _feature_1.getEType();
    String _name_3 = _eType_1.getName();
    Assert.assertEquals("Top", _name_3);
    List<EClass> _superTypes_2 = this.superTypes(bottomType);
    boolean _contains_2 = _superTypes_2.contains(middleType1);
    Assert.assertTrue(_contains_2);
    List<EClass> _superTypes_3 = this.superTypes(bottomType);
    boolean _contains_3 = _superTypes_3.contains(middleType2);
    Assert.assertTrue(_contains_3);
  }
  
  @Test
  public void testTypesOfImplicitSuperGrammar() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("MyRule: myFeature=INT;");
    _builder.newLine();
    final String xtextGrammar = _builder.toString();
    EObject _model = this.getModel(xtextGrammar);
    final Grammar grammar = ((Grammar) _model);
    final Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(grammar);
    transformer.removeGeneratedPackages();
    transformer.transform();
    EList<AbstractRule> _rules = grammar.getRules();
    final AbstractRule rule = IterableExtensions.<AbstractRule>head(_rules);
    TypeRef type = rule.getType();
    Assert.assertNotNull(type);
    EClassifierInfos _eClassifierInfos = transformer.getEClassifierInfos();
    EClassifierInfo _info = _eClassifierInfos.getInfo(type);
    Assert.assertNotNull(_info);
    List<AbstractMetamodelDeclaration> _allMetamodelDeclarations = GrammarUtil.allMetamodelDeclarations(grammar);
    AbstractMetamodelDeclaration _get = _allMetamodelDeclarations.get(1);
    final ReferencedMetamodel referenced = ((ReferencedMetamodel) _get);
    Assert.assertNotNull(referenced);
    String _alias = referenced.getAlias();
    Assert.assertEquals("ecore", _alias);
    EClassifierInfos _eClassifierInfos_1 = transformer.getEClassifierInfos();
    EClassifierInfo _info_1 = _eClassifierInfos_1.getInfo(referenced, "EString");
    Assert.assertNull(_info_1);
    EClassifierInfos _eClassifierInfos_2 = transformer.getEClassifierInfos();
    EClassifierInfo _info_2 = _eClassifierInfos_2.getInfo(referenced, "EInt");
    Assert.assertNull(_info_2);
    EClassifierInfos _eClassifierInfos_3 = transformer.getEClassifierInfos();
    List<EClassifierInfos> _parents = _eClassifierInfos_3.getParents();
    EClassifierInfos parentInfos = IterableExtensions.<EClassifierInfos>head(_parents);
    EClassifierInfo _info_3 = parentInfos.getInfo(referenced, "EString");
    Assert.assertNotNull(_info_3);
    EClassifierInfo _info_4 = parentInfos.getInfo(referenced, "EInt");
    Assert.assertNotNull(_info_4);
  }
  
  protected <T extends EClassifier> T type(final EPackage pack, final String name) {
    EClassifier _eClassifier = pack.getEClassifier(name);
    return ((T) _eClassifier);
  }
  
  protected <T extends EStructuralFeature> T feature(final EClassifier clazz, final String name) {
    if ((clazz instanceof EClass)) {
      EStructuralFeature _eStructuralFeature = ((EClass)clazz).getEStructuralFeature(name);
      return ((T) _eStructuralFeature);
    }
    return null;
  }
  
  protected List<EClass> superTypes(final EClassifier clazz) {
    if ((clazz instanceof EClass)) {
      return ((EClass)clazz).getESuperTypes();
    }
    return CollectionLiterals.<EClass>emptyList();
  }
  
  protected List<? extends EStructuralFeature> features(final EClassifier clazz) {
    if ((clazz instanceof EClass)) {
      return ((EClass)clazz).getEStructuralFeatures();
    }
    return CollectionLiterals.<EStructuralFeature>emptyList();
  }
  
  @Test
  public void testRuleWithoutExplicitReturnType() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("MyRule: myFeature=INT;");
    _builder.newLine();
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    final EList<EClassifier> classifiers = ePackage.getEClassifiers();
    int _size = classifiers.size();
    Assert.assertEquals(1, _size);
    final EClassifier myRuleType = IterableExtensions.<EClassifier>head(classifiers);
    String _name = myRuleType.getName();
    Assert.assertEquals("MyRule", _name);
    List<? extends EStructuralFeature> _features = this.features(myRuleType);
    EStructuralFeature _head = IterableExtensions.head(_features);
    String _name_1 = _head.getName();
    Assert.assertEquals("myFeature", _name_1);
  }
  
  @Test
  public void testRulesWithExplicitReturnType() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("RuleA returns TypeA: featureA=INT;");
    _builder.newLine();
    _builder.append("RuleB returns TypeB: featureB= INT;");
    _builder.newLine();
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(2, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    Assert.assertNotNull(_type);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    Assert.assertNotNull(_type_1);
  }
  
  @Test
  public void testSimpleHierarchy() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: RuleB; RuleB: featureB= INT;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(2, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    EList<EClass> _eSuperTypes = ruleA.getESuperTypes();
    boolean _isEmpty = _eSuperTypes.isEmpty();
    Assert.assertTrue(_isEmpty);
    EList<EClass> _eSuperTypes_1 = ruleB.getESuperTypes();
    int _size_1 = _eSuperTypes_1.size();
    Assert.assertEquals(1, _size_1);
    EList<EClass> _eSuperTypes_2 = ruleB.getESuperTypes();
    EClass superClass = IterableExtensions.<EClass>head(_eSuperTypes_2);
    Assert.assertEquals(ruleA, superClass);
  }
  
  @Test
  public void testDiamondHierarchy() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' Model: name=ID value=SubNamed1 otherValue=SubNamed2 thirdValue=SubNamed3;Named: SubNamed1 | SubNamed2 | SubNamed3;SubNamed1: ConcreteNamed1 | ConcreteNamed2;SubNamed2: ConcreteNamed2 | ConcreteNamed3;SubNamed3: ConcreteNamed1 | ConcreteNamed3;ConcreteNamed1: name=ID bar=ID foo=ID a=ID;ConcreteNamed2: name=ID bar=ID zonk=ID b=ID;ConcreteNamed3: name=ID foo=ID zonk=ID c=ID;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(8, _size);
    final EClassifier classifier = this.<EClassifier>type(ePackage, "Named");
    Assert.assertNotNull(classifier);
    EClass named = ((EClass) classifier);
    EStructuralFeature feature = this.<EStructuralFeature>feature(named, "name");
    Assert.assertNotNull("name", feature);
    List<? extends EStructuralFeature> _features = this.features(named);
    int _size_1 = _features.size();
    Assert.assertEquals("named", 1, _size_1);
    EClassifier _type = this.<EClassifier>type(ePackage, "SubNamed1");
    EClass subNamed1 = ((EClass) _type);
    Assert.assertNotNull("subNamed1", subNamed1);
    EList<EClass> _eSuperTypes = subNamed1.getESuperTypes();
    int _size_2 = _eSuperTypes.size();
    Assert.assertEquals(1, _size_2);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(subNamed1, "bar");
    Assert.assertNotNull("bar", _feature);
    List<? extends EStructuralFeature> _features_1 = this.features(subNamed1);
    int _size_3 = _features_1.size();
    Assert.assertEquals("subNamed1", 1, _size_3);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "SubNamed2");
    EClass subNamed2 = ((EClass) _type_1);
    Assert.assertNotNull("subNamed2", subNamed2);
    EList<EClass> _eSuperTypes_1 = subNamed2.getESuperTypes();
    int _size_4 = _eSuperTypes_1.size();
    Assert.assertEquals(1, _size_4);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(subNamed2, "zonk");
    Assert.assertNotNull("bar", _feature_1);
    List<? extends EStructuralFeature> _features_2 = this.features(subNamed2);
    int _size_5 = _features_2.size();
    Assert.assertEquals("subNamed2", 1, _size_5);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "SubNamed3");
    EClass subNamed3 = ((EClass) _type_2);
    Assert.assertNotNull("subNamed3", subNamed3);
    EList<EClass> _eSuperTypes_2 = subNamed3.getESuperTypes();
    int _size_6 = _eSuperTypes_2.size();
    Assert.assertEquals(1, _size_6);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(subNamed3, "foo");
    Assert.assertNotNull("bar", _feature_2);
    List<? extends EStructuralFeature> _features_3 = this.features(subNamed3);
    int _size_7 = _features_3.size();
    Assert.assertEquals("subNamed3", 1, _size_7);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "ConcreteNamed1");
    EClass concreteNamed1 = ((EClass) _type_3);
    Assert.assertNotNull("concreteNamed1", concreteNamed1);
    EList<EClass> _eSuperTypes_3 = concreteNamed1.getESuperTypes();
    int _size_8 = _eSuperTypes_3.size();
    Assert.assertEquals("concreteNamed1", 2, _size_8);
    EList<EClass> _eSuperTypes_4 = concreteNamed1.getESuperTypes();
    boolean _contains = _eSuperTypes_4.contains(subNamed1);
    Assert.assertTrue(_contains);
    EList<EClass> _eSuperTypes_5 = concreteNamed1.getESuperTypes();
    boolean _contains_1 = _eSuperTypes_5.contains(subNamed3);
    Assert.assertTrue(_contains_1);
    EStructuralFeature _feature_3 = this.<EStructuralFeature>feature(concreteNamed1, "a");
    Assert.assertNotNull("a", _feature_3);
    List<? extends EStructuralFeature> _features_4 = this.features(concreteNamed1);
    int _size_9 = _features_4.size();
    Assert.assertEquals("concreteNamed1", 1, _size_9);
    EClassifier _type_4 = this.<EClassifier>type(ePackage, "ConcreteNamed2");
    EClass concreteNamed2 = ((EClass) _type_4);
    Assert.assertNotNull("concreteNamed2", concreteNamed2);
    EList<EClass> _eSuperTypes_6 = concreteNamed2.getESuperTypes();
    int _size_10 = _eSuperTypes_6.size();
    Assert.assertEquals("concreteNamed2", 2, _size_10);
    EList<EClass> _eSuperTypes_7 = concreteNamed2.getESuperTypes();
    boolean _contains_2 = _eSuperTypes_7.contains(subNamed1);
    Assert.assertTrue(_contains_2);
    EList<EClass> _eSuperTypes_8 = concreteNamed2.getESuperTypes();
    boolean _contains_3 = _eSuperTypes_8.contains(subNamed2);
    Assert.assertTrue(_contains_3);
    EStructuralFeature _feature_4 = this.<EStructuralFeature>feature(concreteNamed2, "b");
    Assert.assertNotNull("b", _feature_4);
    List<? extends EStructuralFeature> _features_5 = this.features(concreteNamed2);
    int _size_11 = _features_5.size();
    Assert.assertEquals("concreteNamed2", 1, _size_11);
    EClassifier _type_5 = this.<EClassifier>type(ePackage, "ConcreteNamed3");
    EClass concreteNamed3 = ((EClass) _type_5);
    Assert.assertNotNull("concreteNamed3", concreteNamed3);
    EList<EClass> _eSuperTypes_9 = concreteNamed3.getESuperTypes();
    int _size_12 = _eSuperTypes_9.size();
    Assert.assertEquals("concreteNamed3", 2, _size_12);
    EList<EClass> _eSuperTypes_10 = concreteNamed3.getESuperTypes();
    boolean _contains_4 = _eSuperTypes_10.contains(subNamed2);
    Assert.assertTrue(_contains_4);
    EList<EClass> _eSuperTypes_11 = concreteNamed3.getESuperTypes();
    boolean _contains_5 = _eSuperTypes_11.contains(subNamed3);
    Assert.assertTrue(_contains_5);
    EStructuralFeature _feature_5 = this.<EStructuralFeature>feature(concreteNamed3, "c");
    Assert.assertNotNull("c", _feature_5);
    List<? extends EStructuralFeature> _features_6 = this.features(concreteNamed3);
    int _size_13 = _features_6.size();
    Assert.assertEquals("concreteNamed3", 1, _size_13);
  }
  
  @Test
  public void testSingleFeatures() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: featureA=INT;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size = _eAttributes.size();
    Assert.assertEquals(1, _size);
    this.assertAttributeConfiguration(ruleA, 0, "featureA", 
      "EInt");
  }
  
  @Test
  public void testCommonTerminalsFeatureTypes() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: featureA=ID featureB=INT featureC=STRING;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size = _eAttributes.size();
    Assert.assertEquals(3, _size);
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
    this.assertAttributeConfiguration(ruleA, 1, "featureB", "EInt");
    this.assertAttributeConfiguration(ruleA, 2, "featureC", 
      "EString");
  }
  
  @Test
  public void testCardinalityOfFeatures() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: featureA?=ID featureB=INT featureC+=STRING;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size = _eAttributes.size();
    Assert.assertEquals(3, _size);
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
    this.assertAttributeConfiguration(ruleA, 1, "featureB", "EInt", 0, 1);
    this.assertAttributeConfiguration(ruleA, 2, "featureC", "EString", 0, 
      (-1));
  }
  
  @Test
  public void testOptionalAssignmentsInGroup() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: (featureA?=\'abstract\' featureB+=INT)?;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(1, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_1 = _eAttributes.size();
    Assert.assertEquals(2, _size_1);
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
    this.assertAttributeConfiguration(ruleA, 1, "featureB", "EInt", 0, 
      (-1));
  }
  
  @Test
  public void testFeaturesAndInheritanceOptionalRuleCall() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: RuleB? featureA=INT; RuleB: featureB=STRING;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(2, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_1 = _eAttributes.size();
    Assert.assertEquals(1, _size_1);
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EInt");
    EList<EAttribute> _eAttributes_1 = ruleB.getEAttributes();
    int _size_2 = _eAttributes_1.size();
    Assert.assertEquals(1, _size_2);
    this.assertAttributeConfiguration(ruleB, 0, "featureB", 
      "EString");
  }
  
  @Test
  public void testFeaturesAndInheritanceMandatoryRuleCall() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: RuleB featureA=INT; RuleB: featureB=STRING;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(2, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_1 = _eAttributes.size();
    Assert.assertEquals(0, _size_1);
    EList<EAttribute> _eAttributes_1 = ruleB.getEAttributes();
    int _size_2 = _eAttributes_1.size();
    Assert.assertEquals(2, _size_2);
    this.assertAttributeConfiguration(ruleB, 0, "featureA", "EInt");
    this.assertAttributeConfiguration(ruleB, 1, "featureB", 
      "EString");
  }
  
  @Test
  public void testFeaturesAndInheritanceOfMandatoryAlternativeRuleCalls() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: (RuleB|RuleC featureC1=ID) featureA=ID; RuleB: featureB=ID; RuleC: featureC2=ID;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(3, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_2);
    Assert.assertNotNull(ruleC);
    EList<EClass> _eSuperTypes = ruleA.getESuperTypes();
    boolean _isEmpty = _eSuperTypes.isEmpty();
    Assert.assertTrue(_isEmpty);
    EList<EClass> _eSuperTypes_1 = ruleB.getESuperTypes();
    int _size_1 = _eSuperTypes_1.size();
    Assert.assertEquals(1, _size_1);
    EList<EClass> _eSuperTypes_2 = ruleB.getESuperTypes();
    EClass _head = IterableExtensions.<EClass>head(_eSuperTypes_2);
    Assert.assertEquals(ruleA, _head);
    EList<EClass> _eSuperTypes_3 = ruleC.getESuperTypes();
    int _size_2 = _eSuperTypes_3.size();
    Assert.assertEquals(1, _size_2);
    EList<EClass> _eSuperTypes_4 = ruleC.getESuperTypes();
    EClass _head_1 = IterableExtensions.<EClass>head(_eSuperTypes_4);
    Assert.assertEquals(ruleA, _head_1);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_3 = _eAttributes.size();
    Assert.assertEquals(1, _size_3);
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
    EList<EAttribute> _eAttributes_1 = ruleB.getEAttributes();
    int _size_4 = _eAttributes_1.size();
    Assert.assertEquals(1, _size_4);
    this.assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
    EList<EAttribute> _eAttributes_2 = ruleC.getEAttributes();
    int _size_5 = _eAttributes_2.size();
    Assert.assertEquals(2, _size_5);
    this.assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
    this.assertAttributeConfiguration(ruleC, 1, "featureC2", 
      "EString");
  }
  
  @Test
  public void testFeaturesAndInheritanceOfOptionalOptionalRuleCalls() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: (RuleB|RuleC featureC1=ID)? featureA=ID; RuleB: featureB=ID; RuleC: featureC2=ID;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(3, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_2);
    Assert.assertNotNull(ruleC);
    EList<EClass> _eSuperTypes = ruleA.getESuperTypes();
    boolean _isEmpty = _eSuperTypes.isEmpty();
    Assert.assertTrue(_isEmpty);
    EList<EClass> _eSuperTypes_1 = ruleB.getESuperTypes();
    int _size_1 = _eSuperTypes_1.size();
    Assert.assertEquals(1, _size_1);
    EList<EClass> _eSuperTypes_2 = ruleB.getESuperTypes();
    EClass _head = IterableExtensions.<EClass>head(_eSuperTypes_2);
    Assert.assertEquals(ruleA, _head);
    EList<EClass> _eSuperTypes_3 = ruleC.getESuperTypes();
    int _size_2 = _eSuperTypes_3.size();
    Assert.assertEquals(1, _size_2);
    EList<EClass> _eSuperTypes_4 = ruleC.getESuperTypes();
    EClass _head_1 = IterableExtensions.<EClass>head(_eSuperTypes_4);
    Assert.assertEquals(ruleA, _head_1);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_3 = _eAttributes.size();
    Assert.assertEquals(1, _size_3);
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
    EList<EAttribute> _eAttributes_1 = ruleB.getEAttributes();
    int _size_4 = _eAttributes_1.size();
    Assert.assertEquals(1, _size_4);
    this.assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
    EList<EAttribute> _eAttributes_2 = ruleC.getEAttributes();
    int _size_5 = _eAttributes_2.size();
    Assert.assertEquals(2, _size_5);
    this.assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
    this.assertAttributeConfiguration(ruleC, 1, "featureC2", 
      "EString");
  }
  
  @Test
  public void testFeaturesAndInheritanceOfNestedRuleCalls() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + 
      " RuleA: ((RuleB|RuleC featureC1=ID) featureBC=ID | (RuleC|RuleD featureD1=ID) featureCD=ID) featureA=ID;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB: featureB2=ID;");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " RuleC: featureC2=ID;");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " RuleD: featureD2=ID;");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_2);
    Assert.assertNotNull(ruleC);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "RuleD");
    EClass ruleD = ((EClass) _type_3);
    Assert.assertNotNull(ruleD);
    EList<EClass> _eSuperTypes = ruleA.getESuperTypes();
    boolean _isEmpty = _eSuperTypes.isEmpty();
    Assert.assertTrue(_isEmpty);
    EList<EClass> _eSuperTypes_1 = ruleB.getESuperTypes();
    int _size_1 = _eSuperTypes_1.size();
    Assert.assertEquals(1, _size_1);
    EList<EClass> _eSuperTypes_2 = ruleB.getESuperTypes();
    EClass _head = IterableExtensions.<EClass>head(_eSuperTypes_2);
    Assert.assertEquals(ruleA, _head);
    EList<EClass> _eSuperTypes_3 = ruleC.getESuperTypes();
    int _size_2 = _eSuperTypes_3.size();
    Assert.assertEquals(1, _size_2);
    EList<EClass> _eSuperTypes_4 = ruleC.getESuperTypes();
    EClass _head_1 = IterableExtensions.<EClass>head(_eSuperTypes_4);
    Assert.assertEquals(ruleA, _head_1);
    EList<EClass> _eSuperTypes_5 = ruleD.getESuperTypes();
    int _size_3 = _eSuperTypes_5.size();
    Assert.assertEquals(1, _size_3);
    EList<EClass> _eSuperTypes_6 = ruleD.getESuperTypes();
    EClass _head_2 = IterableExtensions.<EClass>head(_eSuperTypes_6);
    Assert.assertEquals(ruleA, _head_2);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_4 = _eAttributes.size();
    Assert.assertEquals(1, _size_4);
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
    EList<EAttribute> _eAttributes_1 = ruleB.getEAttributes();
    int _size_5 = _eAttributes_1.size();
    Assert.assertEquals(2, _size_5);
    this.assertAttributeConfiguration(ruleB, 0, "featureBC", "EString");
    this.assertAttributeConfiguration(ruleB, 1, "featureB2", "EString");
    EList<EAttribute> _eAttributes_2 = ruleC.getEAttributes();
    int _size_6 = _eAttributes_2.size();
    Assert.assertEquals(4, _size_6);
    this.assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
    this.assertAttributeConfiguration(ruleC, 1, "featureBC", "EString");
    this.assertAttributeConfiguration(ruleC, 2, "featureCD", "EString");
    this.assertAttributeConfiguration(ruleC, 3, "featureC2", "EString");
    EList<EAttribute> _eAttributes_3 = ruleD.getEAttributes();
    int _size_7 = _eAttributes_3.size();
    Assert.assertEquals(3, _size_7);
    this.assertAttributeConfiguration(ruleD, 0, "featureD1", "EString");
    this.assertAttributeConfiguration(ruleD, 1, "featureCD", "EString");
    this.assertAttributeConfiguration(ruleD, 2, "featureD2", 
      "EString");
  }
  
  @Test
  public void testFeaturesAndInheritanceOfNestedRuleCalls_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + 
      " RuleA: ((RuleB|RuleC featureC1=ID)? featureABC=ID | (RuleC|RuleD featureD1=ID) featureCD=ID) featureA=ID;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB: featureB2=ID;");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " RuleC: featureC2=ID;");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " RuleD: featureD2=ID;");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_2);
    Assert.assertNotNull(ruleC);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "RuleD");
    EClass ruleD = ((EClass) _type_3);
    Assert.assertNotNull(ruleD);
    EList<EClass> _eSuperTypes = ruleA.getESuperTypes();
    boolean _isEmpty = _eSuperTypes.isEmpty();
    Assert.assertTrue(_isEmpty);
    EList<EClass> _eSuperTypes_1 = ruleB.getESuperTypes();
    int _size_1 = _eSuperTypes_1.size();
    Assert.assertEquals(1, _size_1);
    EList<EClass> _eSuperTypes_2 = ruleB.getESuperTypes();
    EClass _head = IterableExtensions.<EClass>head(_eSuperTypes_2);
    Assert.assertEquals(ruleA, _head);
    EList<EClass> _eSuperTypes_3 = ruleC.getESuperTypes();
    int _size_2 = _eSuperTypes_3.size();
    Assert.assertEquals(1, _size_2);
    EList<EClass> _eSuperTypes_4 = ruleC.getESuperTypes();
    EClass _head_1 = IterableExtensions.<EClass>head(_eSuperTypes_4);
    Assert.assertEquals(ruleA, _head_1);
    EList<EClass> _eSuperTypes_5 = ruleD.getESuperTypes();
    int _size_3 = _eSuperTypes_5.size();
    Assert.assertEquals(1, _size_3);
    EList<EClass> _eSuperTypes_6 = ruleD.getESuperTypes();
    EClass _head_2 = IterableExtensions.<EClass>head(_eSuperTypes_6);
    Assert.assertEquals(ruleA, _head_2);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_4 = _eAttributes.size();
    Assert.assertEquals(2, _size_4);
    this.assertAttributeConfiguration(ruleA, 0, "featureABC", "EString");
    this.assertAttributeConfiguration(ruleA, 1, "featureA", "EString");
    EList<EAttribute> _eAttributes_1 = ruleB.getEAttributes();
    int _size_5 = _eAttributes_1.size();
    Assert.assertEquals(1, _size_5);
    this.assertAttributeConfiguration(ruleB, 0, "featureB2", "EString");
    EList<EAttribute> _eAttributes_2 = ruleC.getEAttributes();
    int _size_6 = _eAttributes_2.size();
    Assert.assertEquals(3, _size_6);
    this.assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
    this.assertAttributeConfiguration(ruleC, 1, "featureCD", "EString");
    this.assertAttributeConfiguration(ruleC, 2, "featureC2", "EString");
    EList<EAttribute> _eAttributes_3 = ruleD.getEAttributes();
    int _size_7 = _eAttributes_3.size();
    Assert.assertEquals(3, _size_7);
    this.assertAttributeConfiguration(ruleD, 0, "featureD1", "EString");
    this.assertAttributeConfiguration(ruleD, 1, "featureCD", "EString");
    this.assertAttributeConfiguration(ruleD, 2, "featureD2", 
      "EString");
  }
  
  @Test
  public void testFeaturesAndInheritanceOfActions01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: ({Add.a=current} \'+\'|{Sub.a=current} \'-\') featureAS=ID;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(3, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "Add");
    EClass add = ((EClass) _type_1);
    Assert.assertNotNull(add);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "Sub");
    EClass sub = ((EClass) _type_2);
    Assert.assertNotNull(sub);
    EList<EClass> _eSuperTypes = ruleA.getESuperTypes();
    boolean _isEmpty = _eSuperTypes.isEmpty();
    Assert.assertTrue(_isEmpty);
    EList<EClass> _eSuperTypes_1 = add.getESuperTypes();
    int _size_1 = _eSuperTypes_1.size();
    Assert.assertEquals(1, _size_1);
    EList<EClass> _eSuperTypes_2 = add.getESuperTypes();
    EClass _head = IterableExtensions.<EClass>head(_eSuperTypes_2);
    Assert.assertEquals(ruleA, _head);
    EList<EClass> _eSuperTypes_3 = sub.getESuperTypes();
    int _size_2 = _eSuperTypes_3.size();
    Assert.assertEquals(1, _size_2);
    EList<EClass> _eSuperTypes_4 = sub.getESuperTypes();
    EClass _head_1 = IterableExtensions.<EClass>head(_eSuperTypes_4);
    Assert.assertEquals(ruleA, _head_1);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_3 = _eAttributes.size();
    Assert.assertEquals(1, _size_3);
    this.assertAttributeConfiguration(ruleA, 0, "featureAS", "EString");
    EList<EReference> _eReferences = ruleA.getEReferences();
    int _size_4 = _eReferences.size();
    Assert.assertEquals(1, _size_4);
    this.assertReferenceConfiguration(ruleA, 0, "a", "RuleA", true, 0, 1);
    EList<EAttribute> _eAttributes_1 = add.getEAttributes();
    int _size_5 = _eAttributes_1.size();
    Assert.assertEquals(0, _size_5);
    EList<EReference> _eReferences_1 = add.getEReferences();
    int _size_6 = _eReferences_1.size();
    Assert.assertEquals(0, _size_6);
    EList<EAttribute> _eAttributes_2 = sub.getEAttributes();
    int _size_7 = _eAttributes_2.size();
    Assert.assertEquals(0, _size_7);
    EList<EReference> _eReferences_2 = sub.getEReferences();
    int _size_8 = _eReferences_2.size();
    Assert.assertEquals(0, _size_8);
  }
  
  @Test
  public void testFeaturesAndInheritanceOfActions02() throws Exception {
    String grammar = "";
    String _grammar = grammar;
    grammar = (_grammar + "grammar org.eclipse.xtext.testlanguages.ActionTestLanguage with org.eclipse.xtext.common.Terminals ");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + "generate ActionLang");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " \'http://www.eclipse.org/2008/tmf/xtext/ActionLang\'");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + "");
    String _grammar_4 = grammar;
    grammar = (_grammar_4 + " Model:");
    String _grammar_5 = grammar;
    grammar = (_grammar_5 + " (children+=Element)*;");
    String _grammar_6 = grammar;
    grammar = (_grammar_6 + "");
    String _grammar_7 = grammar;
    grammar = (_grammar_7 + " Element returns Type:");
    String _grammar_8 = grammar;
    grammar = (_grammar_8 + " Item ( { Item.items+=current } items+=Item );");
    String _grammar_9 = grammar;
    grammar = (_grammar_9 + "");
    String _grammar_10 = grammar;
    grammar = (_grammar_10 + " Item returns Type:");
    String _grammar_11 = grammar;
    grammar = (_grammar_11 + " { Thing.content=current } name=ID;");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "Model");
    EClass model = ((EClass) _type);
    Assert.assertNotNull(model);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "Type");
    EClass type = ((EClass) _type_1);
    Assert.assertNotNull(type);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "Item");
    EClass item = ((EClass) _type_2);
    Assert.assertNotNull(item);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "Thing");
    EClass thing = ((EClass) _type_3);
    Assert.assertNotNull(thing);
    EList<EClass> _eSuperTypes = model.getESuperTypes();
    int _size_1 = _eSuperTypes.size();
    Assert.assertEquals(0, _size_1);
    EList<EClass> _eSuperTypes_1 = type.getESuperTypes();
    int _size_2 = _eSuperTypes_1.size();
    Assert.assertEquals(0, _size_2);
    EList<EClass> _eSuperTypes_2 = item.getESuperTypes();
    int _size_3 = _eSuperTypes_2.size();
    Assert.assertEquals(1, _size_3);
    EList<EClass> _eSuperTypes_3 = item.getESuperTypes();
    EClass _head = IterableExtensions.<EClass>head(_eSuperTypes_3);
    Assert.assertSame(type, _head);
    EList<EClass> _eSuperTypes_4 = thing.getESuperTypes();
    int _size_4 = _eSuperTypes_4.size();
    Assert.assertEquals(1, _size_4);
    EList<EClass> _eSuperTypes_5 = thing.getESuperTypes();
    EClass _get = _eSuperTypes_5.get(
      0);
    Assert.assertSame(type, _get);
  }
  
  @Test
  public void testAssignedRuleCall() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("RuleA: callA1=RuleB callA2+=RuleB simpleFeature=ID;");
    _builder.newLine();
    _builder.append("RuleB: featureB=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(2, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_1 = _eAttributes.size();
    Assert.assertEquals(1, _size_1);
    this.assertAttributeConfiguration(ruleA, 0, "simpleFeature", "EString");
    EList<EReference> _eReferences = ruleA.getEReferences();
    int _size_2 = _eReferences.size();
    Assert.assertEquals(2, _size_2);
    this.assertReferenceConfiguration(ruleA, 0, "callA1", "RuleB", true, 0, 1);
    this.assertReferenceConfiguration(ruleA, 1, "callA2", "RuleB", true, 0, (-1));
    EList<EAttribute> _eAttributes_1 = ruleB.getEAttributes();
    int _size_3 = _eAttributes_1.size();
    Assert.assertEquals(1, _size_3);
    this.assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
  }
  
  @Test
  public void testAssignedCrossReference() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: refA1=[TypeB] refA2+=[TypeB|RuleB] simpleFeature=ID; RuleB returns TypeB: featureB=ID;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(2, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_1 = _eAttributes.size();
    Assert.assertEquals(1, _size_1);
    this.assertAttributeConfiguration(ruleA, 0, "simpleFeature", "EString");
    EList<EReference> _eReferences = ruleA.getEReferences();
    int _size_2 = _eReferences.size();
    Assert.assertEquals(2, _size_2);
    this.assertReferenceConfiguration(ruleA, 0, "refA1", "TypeB", false, 0, 
      1);
    this.assertReferenceConfiguration(ruleA, 1, "refA2", "TypeB", false, 0, 
      (-1));
    EList<EAttribute> _eAttributes_1 = typeB.getEAttributes();
    int _size_3 = _eAttributes_1.size();
    Assert.assertEquals(1, _size_3);
    this.assertAttributeConfiguration(typeB, 0, "featureB", 
      "EString");
  }
  
  @Test
  public void testAssignedParenthesizedElement() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + 
      " RuleA: featureA1?=(RuleB) refA1=(RuleB) refA2=(RuleB|RuleC) refA3+=(RuleB|RuleC|RuleD) refA4=(RuleB|RuleD) featureA2+=(\'a\'|\'b\');");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeB: RuleC? featureB=ID;");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " RuleC: featureC=ID;");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " RuleD returns TypeB: featureD=ID;");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(3, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EList<EClass> _eSuperTypes = ruleA.getESuperTypes();
    int _size_1 = _eSuperTypes.size();
    Assert.assertEquals(0, _size_1);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    EList<EClass> _eSuperTypes_1 = typeB.getESuperTypes();
    int _size_2 = _eSuperTypes_1.size();
    Assert.assertEquals(0, _size_2);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_2);
    Assert.assertNotNull(ruleC);
    EList<EClass> _eSuperTypes_2 = ruleC.getESuperTypes();
    int _size_3 = _eSuperTypes_2.size();
    Assert.assertEquals(1, _size_3);
    EList<EClass> _eSuperTypes_3 = ruleC.getESuperTypes();
    EClass _head = IterableExtensions.<EClass>head(_eSuperTypes_3);
    Assert.assertEquals(typeB, _head);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_4 = _eAttributes.size();
    Assert.assertEquals(2, _size_4);
    this.assertAttributeConfiguration(ruleA, 0, "featureA1", "EBoolean");
    this.assertAttributeConfiguration(ruleA, 1, "featureA2", "EString", 0, 
      (-1));
    EList<EReference> _eReferences = ruleA.getEReferences();
    int _size_5 = _eReferences.size();
    Assert.assertEquals(4, _size_5);
    this.assertReferenceConfiguration(ruleA, 0, "refA1", "TypeB", true, 0, 1);
    this.assertReferenceConfiguration(ruleA, 1, "refA2", "TypeB", true, 0, 1);
    this.assertReferenceConfiguration(ruleA, 2, "refA3", "TypeB", true, 0, 
      (-1));
    this.assertReferenceConfiguration(ruleA, 3, "refA4", "TypeB", true, 0, 
      1);
  }
  
  @Test
  public void testAssignedKeyword() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: featureA?=(\'+\'|\'-\') featureB=(\'*\'|\'/\');");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(1, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_1 = _eAttributes.size();
    Assert.assertEquals(2, _size_1);
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
    this.assertAttributeConfiguration(ruleA, 1, "featureB", "EString", 0, 
      1);
  }
  
  @Test
  public void testImportWithoutAlias() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' import \'http://www.eclipse.org/emf/2002/Ecore\' RuleA: feature=ID;");
    final String grammar = _builder.toString();
    this.getEPackageFromGrammar(grammar);
  }
  
  @Test
  public void testGenerateTwoModels() throws Exception {
    String grammar = "";
    String _grammar = grammar;
    grammar = (_grammar + " grammar test with org.eclipse.xtext.common.Terminals");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " generate t1 \'http://t1\'");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " generate t2 \'http://t2\' as t2");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " RuleA: featureA=ID;");
    String _grammar_4 = grammar;
    grammar = (_grammar_4 + " RuleB returns t2::TypeB: featureB=ID;");
    List<EPackage> ePackages = this.getEPackagesFromGrammar(grammar, 0);
    int _size = ePackages.size();
    Assert.assertEquals(2, _size);
    EPackage t1 = IterableExtensions.<EPackage>head(ePackages);
    String _name = t1.getName();
    Assert.assertEquals("t1", _name);
    EList<EClassifier> _eClassifiers = t1.getEClassifiers();
    int _size_1 = _eClassifiers.size();
    Assert.assertEquals(1, _size_1);
    final EClassifier ruleA = this.<EClassifier>type(t1, "RuleA");
    Assert.assertNotNull(ruleA);
    EPackage t2 = ePackages.get(1);
    EList<EClassifier> _eClassifiers_1 = t2.getEClassifiers();
    int _size_2 = _eClassifiers_1.size();
    Assert.assertEquals(1, _size_2);
    String _name_1 = t2.getName();
    Assert.assertEquals("t2", _name_1);
    final EClassifier typeB = this.<EClassifier>type(t2, "TypeB");
    Assert.assertNotNull(typeB);
  }
  
  @Test
  public void testUseSameModelAlias() throws Exception {
    String grammar = "";
    String _grammar = grammar;
    grammar = (_grammar + " grammar test with org.eclipse.xtext.common.Terminals");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " generate t1 \'http://t1\' as target");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " generate t2 \'http://t2\' as target");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " RuleA: featureA=ID;");
    String _grammar_4 = grammar;
    grammar = (_grammar_4 + " RuleB returns target::TypeB: featureB=ID;");
    this.errorAcceptorMock.acceptError(TransformationErrorCode.AliasForMetamodelAlreadyExists, 
      TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
    this.errorAcceptorMock.acceptError(TransformationErrorCode.UnknownMetaModelAlias, TestErrorAcceptor.ANY_STRING, 
      TestErrorAcceptor.ANY_EOBJECT);
    this.errorAcceptorMock.acceptError(TransformationErrorCode.UnknownMetaModelAlias, TestErrorAcceptor.ANY_STRING, 
      TestErrorAcceptor.ANY_EOBJECT);
    List<EPackage> ePackages = this.getEPackagesFromGrammar(grammar, 5);
    int _size = ePackages.size();
    Assert.assertEquals(0, _size);
  }
  
  @Test
  public void testModifyingSealedModel() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore RuleA returns ecore::SomeNewTypeA: feature=ID;");
    final String grammar = _builder.toString();
    this.errorAcceptorMock.acceptError(TransformationErrorCode.CannotCreateTypeInSealedMetamodel, 
      TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
    EPackage result = this.getEPackageFromGrammar(grammar, 2);
    EList<EClassifier> _eClassifiers = result.getEClassifiers();
    boolean _isEmpty = _eClassifiers.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testImportingUnknownModel() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' import \'unknown-scheme://www.unknownModel\' as unknownModel RuleA: feature=ID;");
    final String grammar = _builder.toString();
    this.getEPackageFromGrammar(grammar, 
      1);
  }
  
  @Test
  public void testMoreThanOneRuleCall() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: RuleB RuleC; RuleB: featureB=ID; RuleC: featureC=ID;");
    final String grammar = _builder.toString();
    this.errorAcceptorMock.acceptError(
      TransformationErrorCode.MoreThanOneTypeChangeInOneRule, 
      TestErrorAcceptor.ANY_STRING, 
      TestErrorAcceptor.ANY_EOBJECT);
    this.getEPackageFromGrammar(grammar, 
      1);
  }
  
  @Test
  public void testRuleCallAndAction() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: RuleB {TypeC.B = current}; RuleB: featureB=ID;");
    final String grammar = _builder.toString();
    this.getEPackageFromGrammar(grammar);
  }
  
  @Test
  public void testRuleCallActionAndRuleCall() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: RuleB {TypeC.B = current} RuleB; RuleB: featureB=ID;");
    final String grammar = _builder.toString();
    this.errorAcceptorMock.acceptError(
      TransformationErrorCode.MoreThanOneTypeChangeInOneRule, 
      TestErrorAcceptor.ANY_STRING, 
      TestErrorAcceptor.ANY_EOBJECT);
    this.getEPackageFromGrammar(grammar, 
      1);
  }
  
  @Test
  public void testAddingFeatureTwice() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA returns TypeA: featureA=ID; RuleB returns TypeA: featureA=STRING;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(1, _size);
    EClassifier _eClassifier = ePackage.getEClassifier("TypeA");
    EClass typeA = ((EClass) _eClassifier);
    Assert.assertNotNull(typeA);
    EList<EAttribute> _eAttributes = typeA.getEAttributes();
    int _size_1 = _eAttributes.size();
    Assert.assertEquals(1, _size_1);
    this.assertAttributeConfiguration(typeA, 0, 
      "featureA", 
      "EString");
  }
  
  @Test
  public void testAddingDifferentFeaturesWithSameName01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    _builder.append(" RuleA returns TypeA: featureA=ID; RuleB returns TypeA: featureA=INT;");
    final String grammar = _builder.toString();
    this.errorAcceptorMock.acceptError(TransformationErrorCode.NoCompatibleFeatureTypeAvailable, 
      TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
    EPackage ePackage = this.getEPackageFromGrammar(grammar, 1);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(1, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EList<EAttribute> _eAttributes = typeA.getEAttributes();
    int _size_1 = _eAttributes.size();
    Assert.assertEquals(1, _size_1);
    this.assertAttributeConfiguration(typeA, 0, "featureA", 
      "EString");
  }
  
  @Test
  public void testAddingDifferentFeaturesWithSameName02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: featureA=RuleD;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeA: featureA=RuleC;");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " RuleC: RuleD;");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " RuleD: featureD=ID;");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(3, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_1);
    Assert.assertNotNull(ruleC);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleD");
    EClass ruleD = ((EClass) _type_2);
    Assert.assertNotNull(ruleD);
    EList<EReference> _eReferences = typeA.getEReferences();
    int _size_1 = _eReferences.size();
    Assert.assertEquals(1, _size_1);
    this.assertReferenceConfiguration(typeA, 0, "featureA", "RuleC", true, 0, 
      1);
  }
  
  @Test
  public void testAddingDifferentFeaturesWithSameName03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: featureA1=ID featureA2=RuleD featureA3=RuleC;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeA: featureA2=RuleC featureA4=INT;");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " RuleC: featureC=INT;");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " RuleD: featureD=ID;");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(3, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_1);
    Assert.assertNotNull(ruleC);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleD");
    EClass ruleD = ((EClass) _type_2);
    Assert.assertNotNull(ruleD);
    EList<EAttribute> _eAllAttributes = typeA.getEAllAttributes();
    int _size_1 = _eAllAttributes.size();
    Assert.assertEquals(2, _size_1);
    this.assertAttributeConfiguration(typeA, 0, "featureA1", "EString");
    this.assertAttributeConfiguration(typeA, 1, "featureA4", "EInt");
    EList<EReference> _eReferences = typeA.getEReferences();
    int _size_2 = _eReferences.size();
    Assert.assertEquals(2, _size_2);
    this.assertReferenceConfiguration(typeA, 0, "featureA2", "EObject", true, 0, 1);
    this.assertReferenceConfiguration(typeA, 1, "featureA3", "RuleC", true, 0, 1);
  }
  
  @Test
  public void testUplift01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA: (RuleB|RuleC) featureA=ID;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB: featureB=INT;");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " RuleC: (featureA=ID)?;");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(3, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_2);
    Assert.assertNotNull(ruleC);
    EList<EAttribute> _eAttributes = ruleA.getEAttributes();
    int _size_1 = _eAttributes.size();
    Assert.assertEquals(1, _size_1);
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
    EList<EAttribute> _eAttributes_1 = ruleB.getEAttributes();
    int _size_2 = _eAttributes_1.size();
    Assert.assertEquals(1, _size_2);
    this.assertAttributeConfiguration(ruleB, 0, "featureB", "EInt");
    EList<EAttribute> _eAttributes_2 = ruleC.getEAttributes();
    int _size_3 = _eAttributes_2.size();
    Assert.assertEquals(0, _size_3);
  }
  
  @Test
  public void testCallOfUndeclaredRule() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA: CallOfUndeclaredRule featureA=ID;");
    this.errorAcceptorMock.acceptError(TransformationErrorCode.NoSuchRuleAvailable, TestErrorAcceptor.ANY_STRING, 
      TestErrorAcceptor.ANY_EOBJECT);
    EPackage ePackage = this.getEPackageFromGrammar(grammar, 1);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(1, _size);
    EList<EClassifier> _eClassifiers_1 = ePackage.getEClassifiers();
    EClassifier _head = IterableExtensions.<EClassifier>head(_eClassifiers_1);
    String _name = _head.getName();
    Assert.assertEquals("RuleA", _name);
  }
  
  @Test
  public void testExpressionLikeLangauge() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("Ex :\tAtom  ({ChainExpression.left+=current} operator=(\'+\'|\'-\'|\'*\'|\'/\') right=Atom )*;Atom returns Ex :   Number |  \'(\' Ex \')\';Number : value=INT;");
    grammar = (_grammar + _builder_1);
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EClassifier _type = this.<EClassifier>type(ePackage, "Ex");
    EClass classifier = ((EClass) _type);
    List<? extends EStructuralFeature> _features = this.features(classifier);
    int _size = _features.size();
    Assert.assertEquals(0, _size);
  }
  
  @Test
  public void testClassNameEString() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + "Start returns EString: id=ID;");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EClassifier _type = this.<EClassifier>type(ePackage, "EString");
    EClass classifier = ((EClass) _type);
    String _name = classifier.getName();
    Assert.assertEquals("EString", _name);
    EStructuralFeature feature = this.<EStructuralFeature>feature(classifier, "id");
    Assert.assertNotNull(feature);
    EClassifier _eType = feature.getEType();
    String _name_1 = _eType.getName();
    Assert.assertEquals("EString", _name_1);
    EClassifier _eType_1 = feature.getEType();
    boolean _equals = _eType_1.equals(classifier);
    Assert.assertFalse(_equals);
    EClassifier _eType_2 = feature.getEType();
    Assert.assertEquals(EcorePackage.Literals.ESTRING, _eType_2);
  }
  
  @Test
  public void testNoException_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore generate test \'http://test\'");
    _builder.newLine();
    _builder.append("CompositeModel: (model+=Model)+;");
    _builder.newLine();
    _builder.append("Model: id=NestedModelId (\':\' value=Fraction)? (\'#\' vector=Vector)? (\'+\' dots=Dots)? \';\'");
    _builder.newLine();
    _builder.append("ModelId returns ecore::EString: ID \'.\' ID;");
    _builder.newLine();
    _builder.append("NestedModelId : ModelId \'.\' ModelId;");
    _builder.newLine();
    _builder.append("Fraction returns EBigDecimal: INT (\'/\' INT)?;");
    _builder.newLine();
    _builder.append("Vector : \'(\' INT I");
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 10);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    for (final Resource.Diagnostic d : _errors) {
      Assert.assertFalse((d instanceof ExceptionDiagnostic));
    }
  }
  
  @Test
  public void testNoException_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Model: (children+=Element)*;");
    _builder.newLine();
    _builder.append("Element returns Type: Item ( { Item.items+=current } items+=Item );");
    _builder.newLine();
    _builder.append("Item returns Type:\t{ T");
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    for (final Resource.Diagnostic d : _errors) {
      Assert.assertFalse((d instanceof ExceptionDiagnostic));
    }
  }
  
  @Test
  public void testNoException_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore generate test \'http://test\'");
    _builder.newLine();
    _builder.append("CompositeModel: (type+=EClassifier)+;");
    _builder.newLine();
    _builder.append("EClassifier returns ecore::EClassifier: EDataType | EClass;");
    _builder.newLine();
    _builder.append("EClass returns ecore::EClass: \'class\' name=ID;");
    _builder.newLine();
    _builder.append("EDataType returns ecore::EDataType: \'dt\' name=ID;");
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    boolean _isEmpty = _errors.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testBug_266440() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore  generate bugreport \'http://bugreport/266440\'");
    _builder.newLine();
    _builder.append("CompositeModel: (type+=EClassifier)+;");
    _builder.newLine();
    _builder.append("EClassifier: EDataType | EClass;");
    _builder.newLine();
    _builder.append("EClass: \'class\' name=ID;");
    _builder.newLine();
    _builder.append("EDataType: \'dt\' name=ID;");
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    boolean _isEmpty = _errors.isEmpty();
    Assert.assertTrue(_isEmpty);
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final Grammar parsedGrammar = ((Grammar) _head);
    EList<AbstractRule> _rules = parsedGrammar.getRules();
    for (final AbstractRule rule : _rules) {
      {
        TypeRef _type = rule.getType();
        final EClassifier classifier = _type.getClassifier();
        EPackage pack = classifier.getEPackage();
        String _name = pack.getName();
        Assert.assertEquals("bugreport", _name);
      }
    }
  }
  
  @Test
  public void testBug_266807() throws Exception {
    final XtextResourceSet rs = this.<XtextResourceSet>get(XtextResourceSet.class);
    Class<? extends Xtext2EcoreTransformerTest> _class = this.getClass();
    rs.setClasspathURIContext(_class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("classpath:/");
    Class<? extends Xtext2EcoreTransformerTest> _class_1 = this.getClass();
    Package _package = _class_1.getPackage();
    String _name = _package.getName();
    Character _valueOf = Character.valueOf('.');
    char _charValue = _valueOf.charValue();
    Character _valueOf_1 = Character.valueOf('/');
    char _charValue_1 = _valueOf_1.charValue();
    String _replace = _name.replace(_charValue, _charValue_1);
    _builder.append(_replace, "");
    _builder.append("/Test.xtext");
    URI _createURI = URI.createURI(_builder.toString());
    Resource _createResource = rs.createResource(_createURI, 
      ContentHandler.UNSPECIFIED_CONTENT_TYPE);
    final XtextResource resource = ((XtextResource) _createResource);
    resource.load(null);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    for (final Resource.Diagnostic d : _errors) {
      String _message = d.getMessage();
      Assert.fail(_message);
    }
  }
  
  @Test
  public void testBug_272566_1() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Model:");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("test=Test");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Test:");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\"keyword\" WS name=ID");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    boolean _isEmpty = _errors_1.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug_272566_2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Model:");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("test=Test");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Test:");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\"keyword\" FooBar name=ID");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    _builder.append("FooBar:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'zonk\' WS WS INT WS;");
    _builder.newLine();
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    boolean _isEmpty = _errors_1.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug_272566_3() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Model:");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("test=Test");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Test:");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\"keyword\" MyEnum name=ID");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    _builder.append("enum MyEnum:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("A | B;");
    _builder.newLine();
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    boolean _isEmpty = _errors_1.isEmpty();
    Assert.assertFalse(_string, _isEmpty);
    EList<Resource.Diagnostic> _errors_2 = resource.getErrors();
    for (final Resource.Diagnostic d : _errors_2) {
      Assert.assertFalse((d instanceof ExceptionDiagnostic));
    }
  }
  
  @Test
  public void testInheritFromEObject_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore  import \'classpath:/org/eclipse/xtext/xtext/ecoreInference/test.ecore\' as test  A returns ecore::EObject: B | C;  B returns test::Optional: \'b\' optionalString=STRING;  C returns test::Mandatory: \'c\' mandatoryString=STRING; ");
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    boolean _isEmpty = _errors.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testInheritFromEObject_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore  Object returns ecore::EObject: {ecore::EInt}; ");
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 1, _size);
  }
  
  @Test
  public void testInheritFromEObject_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore  Object returns ecore::EObject: {ecore::EAnnotation}; ");
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    boolean _isEmpty = _errors.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testPostProcessorHook() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore  generate test \'http://test\' MyRule: myFeature=INT;");
    final String xtextGrammar = _builder.toString();
    EObject _model = this.getModel(xtextGrammar);
    final Grammar grammar = ((Grammar) _model);
    final Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(grammar);
    EList<AbstractMetamodelDeclaration> _metamodelDeclarations = grammar.getMetamodelDeclarations();
    AbstractMetamodelDeclaration _get = _metamodelDeclarations.get(1);
    GeneratedMetamodel testMetamodel = ((GeneratedMetamodel) _get);
    final Xtext2EcoreTransformerTest.MockedXtext2EcorePostProcessor postProcessor = new Xtext2EcoreTransformerTest.MockedXtext2EcorePostProcessor(testMetamodel);
    transformer.setPostProcessor(postProcessor);
    transformer.transform();
    int _proccessMethCalled = postProcessor.proccessMethCalled();
    Assert.assertEquals("process mthde called once", 1, _proccessMethCalled);
  }
  
  @Test
  public void testBug_280413_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore");
    _builder.newLine();
    _builder.append("EClass returns ecore::EClass: name=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    boolean _isEmpty = _errors_1.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug_280413_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore");
    _builder.newLine();
    _builder.append("EClass returns ecore::EClass: name=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    boolean _isEmpty = _errors_1.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug_280413_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.Xtext");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/2008/Xtext\' as xtext");
    _builder.newLine();
    _builder.append("ParserRule returns xtext::ParserRule: name=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    boolean _isEmpty = _errors_1.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug_280413_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguage");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("import \'classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.ecore\' as mm");
    _builder.newLine();
    _builder.append("Atom returns mm::Atom: name=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 1, _size);
    EList<Resource.Diagnostic> _errors_2 = resource.getErrors();
    Resource.Diagnostic _get = _errors_2.get(
      0);
    TransformationDiagnostic diagnostic = ((TransformationDiagnostic) _get);
    int _indexOf = grammar.indexOf("mm::Atom");
    int _offset = diagnostic.getOffset();
    Assert.assertEquals(_indexOf, _offset);
    int _length = "mm::Atom".length();
    int _length_1 = diagnostic.getLength();
    Assert.assertEquals(_length, _length_1);
  }
  
  @Test
  public void testBug_280393() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar foo.Bar with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore");
    _builder.newLine();
    _builder.append("generate bar \"http://www.Bar.foo\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Foo returns ecore::EClass : ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Bar | eSuperTypes+=[ecore::EClass];");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Bar :");
    _builder.newLine();
    _builder.append(" \t");
    _builder.append("\'bar\' eSuperTypes+=[ecore::EAttribute];");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 1, _size);
  }
  
  @Test
  public void testBug_285140_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.sublang with org.eclipse.xtext.testlanguages.ActionTestLanguage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import \"http://www.eclipse.org/2008/tmf/xtext/ActionLang\" as actionLang");
    _builder.newLine();
    _builder.append("generate sub \"http://www.sublang.org\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Model returns actionLang::Model:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Child ({actionLang::Parent.left=current} right=Child)?;");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 0, _size);
  }
  
  @Test
  public void testBug_285140_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.sublang with org.eclipse.xtext.xtext.ecoreInference.Bug285140TestLanguage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import \"http://www.eclipse.org/2008/tmf/xtext/ActionLang\" as actionLang");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Model returns actionLang::Model:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Child ({actionLang::Parent.left=current} right=Child)?;");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 0, _size);
  }
  
  @Test
  public void testBug_285140_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.sublang with org.eclipse.xtext.xtext.ecoreInference.Bug285140TestLanguage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import \"http://www.eclipse.org/2008/tmf/xtext/ActionLang\" as actionLang");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Model returns actionLang::Child:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Child name=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 0, _size);
  }
  
  @Test
  public void testBug_285140_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.sublang with org.eclipse.xtext.xtext.ecoreInference.Bug285140TestLanguage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import \"http://www.eclipse.org/2008/tmf/xtext/ActionLang\" as actionLang");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Child returns actionLang::Child:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Child unknown=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 1, _size);
  }
  
  @Test
  public void testBug_286285_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar language with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate lang \"http://www.language.org\"");
    _builder.newLine();
    _builder.append("Model:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Class | ID;");
    _builder.newLine();
    _builder.append("Class: name = ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 0, _size);
  }
  
  @Test
  public void testBug_287550_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar language with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate myDsl \"http://example.xtext.org/MyDsl\"");
    _builder.newLine();
    _builder.append("Model: Left | Right;");
    _builder.newLine();
    _builder.append("Left: Delegate;");
    _builder.newLine();
    _builder.append("Right returns Model: Delegate \'=\';");
    _builder.newLine();
    _builder.append("Delegate returns Left: value=ID;");
    _builder.newLine();
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 0, _size);
  }
  
  @Test
  public void testBug_287698_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar language with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate myDsl \"http://example.xtext.org/MyDsl\"");
    _builder.newLine();
    _builder.append("Model returns Namespace: {Model} elements+=NamespaceElement;");
    _builder.newLine();
    _builder.append("NamespaceElement: Type | Namespace ;");
    _builder.newLine();
    _builder.append("Type: \'type\' name=ID \';\';");
    _builder.newLine();
    _builder.append("Namespace: \'namespace\' name=ID \'{\' elements+=Type \'}\';");
    _builder.newLine();
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 0, _size);
  }
  
  @Test
  public void testBug_287698_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar language with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate myDsl \"http://example.xtext.org/MyDsl\"");
    _builder.newLine();
    _builder.append("Model returns Namespace: {Model} elements+=(Namespace | Something); ");
    _builder.newLine();
    _builder.append("Root: Type | NamespaceElement;");
    _builder.newLine();
    _builder.append("Type: \'type\' name=ID \';\';");
    _builder.newLine();
    _builder.append("NamespaceElement: Namespace | Something;");
    _builder.newLine();
    _builder.append("Namespace: \'namespace\' name=ID \'{\' elements+=SubSomething \'}\';");
    _builder.newLine();
    _builder.append("Something: ReturnModel | SubSomething;");
    _builder.newLine();
    _builder.append("SubSomething: \'something\' name=ID \';\';");
    _builder.newLine();
    _builder.append("ReturnModel returns Model: name=ID;");
    _builder.newLine();
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 0, _size);
  }
  
  @Test
  public void testContainmentVsReference_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' EClass: name=ID eSuperTypes+=EClass;");
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 1, _size);
  }
  
  @Test
  public void testContainmentVsReference_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' EClass: name=ID eSuperTypes+=[EClass];");
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 0, _size);
  }
  
  @Test
  public void testContainmentVsReference_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' EReference: name=ID eType=[EClass];");
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 0, _size);
  }
  
  @Test
  public void testContainmentVsReference_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/emf/2002/Ecore\'");
    _builder.newLine();
    _builder.append("EReference: name=ID eType=EClass;");
    _builder.newLine();
    _builder.append("EClass: name=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 1, _size);
  }
  
  @Test
  public void testContainmentVsReference_05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' EReference: name=ID eContainingClass=[EClass];");
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 1, _size);
  }
  
  @Test
  public void testContainmentVsReference_06() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/emf/2002/Ecore\'");
    _builder.newLine();
    _builder.append("EReference: name=ID eContainingClass=EClass;");
    _builder.newLine();
    _builder.append("EClass: name=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 1, _size);
  }
  
  @Test
  public void testBug296496_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \"classpath:/org/eclipse/xtext/enumrules/enums.ecore\"");
    _builder.newLine();
    _builder.append("ExistingType:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("enumFeature=ExistingEnum stringFeature=ExistingEnum;");
    _builder.newLine();
    _builder.append("enum ExistingEnum:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SameName | OverriddenLiteral = \"overridden\" | DifferentName;");
    _builder.newLine();
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    Assert.assertEquals(_string, 1, _size);
  }
  
  @Test
  public void testBug296496_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \"classpath:/org/eclipse/xtext/enumrules/enums.ecore\"");
    _builder.newLine();
    _builder.append("generate myDsl \"http://example.xtext.org/MyDsl\"");
    _builder.newLine();
    _builder.append("CreatedType:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("enumFeature=ExistingEnum otherEnumFeature=ExistingEnum;");
    _builder.newLine();
    _builder.append("enum ExistingEnum:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SameName | OverriddenLiteral = \"overridden\" | DifferentName;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammarAsString, 0);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    boolean _isEmpty = _errors_1.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final Grammar grammar = ((Grammar) _head);
    EList<AbstractMetamodelDeclaration> _metamodelDeclarations = grammar.getMetamodelDeclarations();
    AbstractMetamodelDeclaration _get = _metamodelDeclarations.get(1);
    GeneratedMetamodel generatedMetamodel = ((GeneratedMetamodel) _get);
    String _name = generatedMetamodel.getName();
    Assert.assertEquals("myDsl", _name);
    EPackage _ePackage = generatedMetamodel.getEPackage();
    EClassifier _type = this.<EClassifier>type(_ePackage, "CreatedType");
    EClass createdType = ((EClass) _type);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(createdType, "enumFeature");
    EClassifier _eType = _feature.getEType();
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(createdType, "otherEnumFeature");
    EClassifier _eType_1 = _feature_1.getEType();
    Assert.assertEquals(_eType, _eType_1);
  }
  
  @Test
  public void testBug310122() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate myDsl \"http://example.xtext.org/MyDsl\"");
    _builder.newLine();
    _builder.append("Model: Sub1 | name=ID \'somekeyword\';");
    _builder.newLine();
    _builder.append("Sub1 returns Model: \'(\' Model \')\';");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammarAsString);
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final Grammar grammar = ((Grammar) _head);
    EList<AbstractMetamodelDeclaration> _metamodelDeclarations = grammar.getMetamodelDeclarations();
    AbstractMetamodelDeclaration _head_1 = IterableExtensions.<AbstractMetamodelDeclaration>head(_metamodelDeclarations);
    GeneratedMetamodel generatedMetamodel = ((GeneratedMetamodel) _head_1);
    String _name = generatedMetamodel.getName();
    Assert.assertEquals("myDsl", _name);
    EPackage _ePackage = generatedMetamodel.getEPackage();
    EList<EClassifier> _eClassifiers = _ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(1, _size);
    EPackage _ePackage_1 = generatedMetamodel.getEPackage();
    EClassifier _type = this.<EClassifier>type(_ePackage_1, "Model");
    EClass createdModel = ((EClass) _type);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(createdModel, "name");
    EClassifier _eType = _feature.getEType();
    Assert.assertEquals(EcorePackage.Literals.ESTRING, _eType);
    EList<AbstractRule> _rules = grammar.getRules();
    for (final AbstractRule rule : _rules) {
      TypeRef _type_1 = rule.getType();
      EClassifier _classifier = _type_1.getClassifier();
      Assert.assertEquals(createdModel, _classifier);
    }
  }
  
  @Test
  public void testOverrideTerminalFragment_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage");
    _builder.newLine();
    _builder.append("terminal fragment ESCAPED_CHAR: \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\\\');");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromString(grammarAsString);
  }
  
  @Test
  public void testOverrideTerminalFragment_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage");
    _builder.newLine();
    _builder.append("terminal ESCAPED_CHAR: \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\\\');");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromString(grammarAsString);
  }
  
  @Test
  public void testOverrideTerminalFragment_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage");
    _builder.newLine();
    _builder.append("ESCAPED_CHAR: \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\\\');");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromStringAndExpect(grammarAsString, 1);
  }
  
  @Test
  public void testOverrideTerminalFragment_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage");
    _builder.newLine();
    _builder.append("enum ESCAPED_CHAR: A | B;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromStringAndExpect(grammarAsString, 1);
  }
  
  @Test
  public void testOverrideTerminalRule_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage");
    _builder.newLine();
    _builder.append("terminal fragment ID: \'a\'..\'z\'+;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromStringAndExpect(grammarAsString, 1);
  }
  
  @Test
  public void testOverrideTerminalRule_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage");
    _builder.newLine();
    _builder.append("terminal ID: \'a\'..\'z\'+;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromString(grammarAsString);
  }
  
  @Test
  public void testOverrideTerminalRule_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage");
    _builder.newLine();
    _builder.append("ID: \'a\' | \'z\';");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromStringAndExpect(grammarAsString, 1);
  }
  
  @Test
  public void testOverrideTerminalRule_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage");
    _builder.newLine();
    _builder.append("enum ID: A | B;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromStringAndExpect(grammarAsString, 1);
  }
  
  @Test
  public void testOverrideDatatypeRule_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage");
    _builder.newLine();
    _builder.append("terminal fragment ModelId: \'a\'..\'z\'+;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromStringAndExpect(grammarAsString, 1);
  }
  
  @Test
  public void testOverrideDatatypeRule_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage");
    _builder.newLine();
    _builder.append("terminal ModelId: \'a\'..\'z\'+;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromString(grammarAsString);
  }
  
  @Test
  public void testOverrideDatatypeRule_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage");
    _builder.newLine();
    _builder.append("ModelId: \'a\' | \'z\';");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromString(grammarAsString);
  }
  
  @Test
  public void testOverrideDatatypeRule_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.xtext.ecoreInference.DataTypeRuleWithEnumResultTestLanguage");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/2009/tmf/xtext/EnumRulesTest\'");
    _builder.newLine();
    _builder.append("import \'classpath:/org/eclipse/xtext/enumrules/enums.ecore\'");
    _builder.newLine();
    _builder.append("enum ExistingEnumAsDT returns ExistingEnum: SameName;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromString(grammarAsString);
  }
  
  @Test
  public void testOverrideEnumRule_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage");
    _builder.newLine();
    _builder.append("import \'classpath:/org/eclipse/xtext/enumrules/enums.ecore\'");
    _builder.newLine();
    _builder.append("terminal fragment ExistingEnum: \'a\'..\'z\'+;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromStringAndExpect(grammarAsString, 1);
  }
  
  @Test
  public void testOverrideEnumRule_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage");
    _builder.newLine();
    _builder.append("import \'classpath:/org/eclipse/xtext/enumrules/enums.ecore\'");
    _builder.newLine();
    _builder.append("terminal ExistingEnum returns ExistingEnum: \'a\'..\'z\'+;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromString(grammarAsString);
  }
  
  @Test
  public void testOverrideEnumRule_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage");
    _builder.newLine();
    _builder.append("import \'classpath:/org/eclipse/xtext/enumrules/enums.ecore\'");
    _builder.newLine();
    _builder.append("ExistingEnum returns ExistingEnum: \'a\' | \'z\';");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromString(grammarAsString);
  }
  
  @Test
  public void testOverrideEnumRule_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage");
    _builder.newLine();
    _builder.append("import \'classpath:/org/eclipse/xtext/enumrules/enums.ecore\'");
    _builder.newLine();
    _builder.append("enum ExistingEnum: SameName;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    this.getResourceFromString(grammarAsString);
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
  public void testBug346685_a01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: RuleB ({TypeC.x=current} \'x\' | {TypeD.x=current} \'y\')? name+=STRING;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeB: {TypeB} \'ignore\';");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeA, "name");
    Assert.assertNotNull(_feature);
    List<? extends EStructuralFeature> _features = this.features(typeA);
    int _size_1 = _features.size();
    Assert.assertEquals(1, _size_1);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_1 = this.features(typeB);
    boolean _isEmpty = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeC, "x");
    Assert.assertNotNull(_feature_1);
    List<? extends EStructuralFeature> _features_2 = this.features(typeC);
    int _size_2 = _features_2.size();
    Assert.assertEquals(1, _size_2);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "x");
    Assert.assertNotNull(_feature_2);
    List<? extends EStructuralFeature> _features_3 = this.features(typeD);
    int _size_3 = _features_3.size();
    Assert.assertEquals(1, _size_3);
  }
  
  @Test
  public void testBug346685_a02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: RuleB ({TypeC.x=current} \'x\' | {TypeD.x=current} \'y\') name+=STRING;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeB: {TypeB} \'ignore\';");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    List<? extends EStructuralFeature> _features = this.features(typeA);
    boolean _isEmpty = _features.isEmpty();
    Assert.assertTrue(_isEmpty);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_1 = this.features(typeB);
    boolean _isEmpty_1 = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeC, "x");
    Assert.assertNotNull(_feature);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeC, "name");
    Assert.assertNotNull(_feature_1);
    List<? extends EStructuralFeature> _features_2 = this.features(typeC);
    int _size_1 = _features_2.size();
    Assert.assertEquals(2, _size_1);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "x");
    Assert.assertNotNull(_feature_2);
    EStructuralFeature _feature_3 = this.<EStructuralFeature>feature(typeD, "name");
    Assert.assertNotNull(_feature_3);
    List<? extends EStructuralFeature> _features_3 = this.features(typeD);
    int _size_2 = _features_3.size();
    Assert.assertEquals(2, _size_2);
  }
  
  @Test
  public void testBug346685_a03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: RuleB ({TypeC.x=current} \'x\' | {TypeD.x=current} \'y\')? name+=STRING;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeB: {TypeB} name+=ID;");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeA, "name");
    Assert.assertNotNull(_feature);
    List<? extends EStructuralFeature> _features = this.features(typeA);
    int _size_1 = _features.size();
    Assert.assertEquals(1, _size_1);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_1 = this.features(typeB);
    boolean _isEmpty = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeC, "x");
    Assert.assertNotNull(_feature_1);
    List<? extends EStructuralFeature> _features_2 = this.features(typeC);
    int _size_2 = _features_2.size();
    Assert.assertEquals(1, _size_2);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "x");
    Assert.assertNotNull(_feature_2);
    List<? extends EStructuralFeature> _features_3 = this.features(typeD);
    int _size_3 = _features_3.size();
    Assert.assertEquals(1, _size_3);
  }
  
  @Test
  public void testBug346685_a04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: RuleB ({TypeC.x=current} \'x\' | {TypeD.x=current} \'y\') name+=STRING;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeB: {TypeB} name+=ID;");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeA, "name");
    Assert.assertNotNull(_feature);
    List<? extends EStructuralFeature> _features = this.features(typeA);
    int _size_1 = _features.size();
    Assert.assertEquals(1, _size_1);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_1 = this.features(typeB);
    boolean _isEmpty = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeC, "x");
    Assert.assertNotNull(_feature_1);
    List<? extends EStructuralFeature> _features_2 = this.features(typeC);
    int _size_2 = _features_2.size();
    Assert.assertEquals(1, _size_2);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "x");
    Assert.assertNotNull(_feature_2);
    List<? extends EStructuralFeature> _features_3 = this.features(typeD);
    int _size_3 = _features_3.size();
    Assert.assertEquals(1, _size_3);
  }
  
  @Test
  public void testBug346685_a05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: RuleB? ({TypeC.x=current} \'x\' | {TypeD.x=current} \'y\')? name+=STRING;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeB: {TypeB} \'ignore\';");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeA, "name");
    Assert.assertNotNull(_feature);
    List<? extends EStructuralFeature> _features = this.features(typeA);
    int _size_1 = _features.size();
    Assert.assertEquals(1, _size_1);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_1 = this.features(typeB);
    boolean _isEmpty = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeC, "x");
    Assert.assertNotNull(_feature_1);
    List<? extends EStructuralFeature> _features_2 = this.features(typeC);
    int _size_2 = _features_2.size();
    Assert.assertEquals(1, _size_2);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "x");
    Assert.assertNotNull(_feature_2);
    List<? extends EStructuralFeature> _features_3 = this.features(typeD);
    int _size_3 = _features_3.size();
    Assert.assertEquals(1, _size_3);
  }
  
  @Test
  public void testBug346685_a06() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: RuleB? ({TypeC.x=current} \'x\' | {TypeD.x=current} \'y\') name+=STRING;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeB: {TypeB} \'ignore\';");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    List<? extends EStructuralFeature> _features = this.features(typeA);
    boolean _isEmpty = _features.isEmpty();
    Assert.assertTrue(_isEmpty);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_1 = this.features(typeB);
    boolean _isEmpty_1 = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeC, "x");
    Assert.assertNotNull(_feature);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeC, "name");
    Assert.assertNotNull(_feature_1);
    List<? extends EStructuralFeature> _features_2 = this.features(typeC);
    int _size_1 = _features_2.size();
    Assert.assertEquals(2, _size_1);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "x");
    Assert.assertNotNull(_feature_2);
    EStructuralFeature _feature_3 = this.<EStructuralFeature>feature(typeD, "name");
    Assert.assertNotNull(_feature_3);
    List<? extends EStructuralFeature> _features_3 = this.features(typeD);
    int _size_2 = _features_3.size();
    Assert.assertEquals(2, _size_2);
  }
  
  @Test
  public void testBug346685_a07() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: RuleB? ({TypeC.x=current} \'x\' | {TypeD.x=current} \'y\')? name+=STRING;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeB: {TypeB} name+=ID;");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeA, "name");
    Assert.assertNotNull(_feature);
    List<? extends EStructuralFeature> _features = this.features(typeA);
    int _size_1 = _features.size();
    Assert.assertEquals(1, _size_1);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_1 = this.features(typeB);
    boolean _isEmpty = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeC, "x");
    Assert.assertNotNull(_feature_1);
    List<? extends EStructuralFeature> _features_2 = this.features(typeC);
    int _size_2 = _features_2.size();
    Assert.assertEquals(1, _size_2);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "x");
    Assert.assertNotNull(_feature_2);
    List<? extends EStructuralFeature> _features_3 = this.features(typeD);
    int _size_3 = _features_3.size();
    Assert.assertEquals(1, _size_3);
  }
  
  @Test
  public void testBug346685_a08() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: RuleB? ({TypeC.x=current} \'x\' | {TypeD.x=current} \'y\') name+=STRING;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeB: {TypeB} name+=ID;");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeA, "name");
    Assert.assertNotNull(_feature);
    List<? extends EStructuralFeature> _features = this.features(typeA);
    int _size_1 = _features.size();
    Assert.assertEquals(1, _size_1);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_1 = this.features(typeB);
    boolean _isEmpty = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeC, "x");
    Assert.assertNotNull(_feature_1);
    List<? extends EStructuralFeature> _features_2 = this.features(typeC);
    int _size_2 = _features_2.size();
    Assert.assertEquals(1, _size_2);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "x");
    Assert.assertNotNull(_feature_2);
    List<? extends EStructuralFeature> _features_3 = this.features(typeD);
    int _size_3 = _features_3.size();
    Assert.assertEquals(1, _size_3);
  }
  
  @Test
  public void testBug346685_a09() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: RuleB ({TypeC.x=current} \'x\' | {TypeD.x=current} \'y\' | \'z\')? name+=STRING;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeB: {TypeB} \'ignore\';");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeA, "name");
    Assert.assertNotNull(_feature);
    List<? extends EStructuralFeature> _features = this.features(typeA);
    int _size_1 = _features.size();
    Assert.assertEquals(1, _size_1);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_1 = this.features(typeB);
    boolean _isEmpty = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeC, "x");
    Assert.assertNotNull(_feature_1);
    List<? extends EStructuralFeature> _features_2 = this.features(typeC);
    int _size_2 = _features_2.size();
    Assert.assertEquals(1, _size_2);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "x");
    Assert.assertNotNull(_feature_2);
    List<? extends EStructuralFeature> _features_3 = this.features(typeD);
    int _size_3 = _features_3.size();
    Assert.assertEquals(1, _size_3);
  }
  
  @Test
  public void testBug346685_a10() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: RuleB ({TypeC.x=current} \'x\' | {TypeD.x=current} \'y\' | \'z\') name+=STRING;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeB: {TypeB} \'ignore\';");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(4, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeA, "name");
    Assert.assertNotNull(_feature);
    List<? extends EStructuralFeature> _features = this.features(typeA);
    int _size_1 = _features.size();
    Assert.assertEquals(1, _size_1);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_1 = this.features(typeB);
    boolean _isEmpty = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeC, "x");
    Assert.assertNotNull(_feature_1);
    List<? extends EStructuralFeature> _features_2 = this.features(typeC);
    int _size_2 = _features_2.size();
    Assert.assertEquals(1, _size_2);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "x");
    Assert.assertNotNull(_feature_2);
    List<? extends EStructuralFeature> _features_3 = this.features(typeD);
    int _size_3 = _features_3.size();
    Assert.assertEquals(1, _size_3);
  }
  
  @Test
  public void testBug346685_b01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " Model: A ({D.a = current} b = B)? c=C? ;\n");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " A: {A} \'a\';\n");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " B: {B} \'c\';\n");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " C: {C} \'b\';\n");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(5, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "Model");
    EClass typeModel = ((EClass) _type);
    Assert.assertNotNull(typeModel);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeModel, "c");
    Assert.assertNotNull(_feature);
    List<? extends EStructuralFeature> _features = this.features(typeModel);
    int _size_1 = _features.size();
    Assert.assertEquals(1, _size_1);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "A");
    EClass typeA = ((EClass) _type_1);
    Assert.assertNotNull(typeA);
    List<? extends EStructuralFeature> _features_1 = this.features(typeA);
    boolean _isEmpty = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty);
    EList<EClass> _eSuperTypes = typeA.getESuperTypes();
    int _size_2 = _eSuperTypes.size();
    Assert.assertEquals(1, _size_2);
    EList<EClass> _eSuperTypes_1 = typeA.getESuperTypes();
    EClass _head = IterableExtensions.<EClass>head(_eSuperTypes_1);
    Assert.assertSame(typeModel, _head);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "B");
    EClass typeB = ((EClass) _type_2);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_2 = this.features(typeB);
    boolean _isEmpty_1 = _features_2.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "C");
    EClass typeC = ((EClass) _type_3);
    Assert.assertNotNull(typeC);
    List<? extends EStructuralFeature> _features_3 = this.features(typeC);
    boolean _isEmpty_2 = _features_3.isEmpty();
    Assert.assertTrue(_isEmpty_2);
    EClassifier _type_4 = this.<EClassifier>type(ePackage, "D");
    EClass typeD = ((EClass) _type_4);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeD, "a");
    Assert.assertNotNull(_feature_1);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "b");
    Assert.assertNotNull(_feature_2);
    List<? extends EStructuralFeature> _features_4 = this.features(typeD);
    int _size_3 = _features_4.size();
    Assert.assertEquals(2, _size_3);
  }
  
  @Test
  public void testBug346685_b02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " Model: A ({D.a = current} b = B) c=C? ;\n");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " A: {A} \'a\';\n");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " B: {B} \'c\';\n");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " C: {C} \'b\';\n");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(5, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "Model");
    EClass typeModel = ((EClass) _type);
    Assert.assertNotNull(typeModel);
    List<? extends EStructuralFeature> _features = this.features(typeModel);
    boolean _isEmpty = _features.isEmpty();
    Assert.assertTrue(_isEmpty);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "A");
    EClass typeA = ((EClass) _type_1);
    Assert.assertNotNull(typeA);
    List<? extends EStructuralFeature> _features_1 = this.features(typeA);
    boolean _isEmpty_1 = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    EList<EClass> _eSuperTypes = typeA.getESuperTypes();
    int _size_1 = _eSuperTypes.size();
    Assert.assertEquals(1, _size_1);
    EList<EClass> _eSuperTypes_1 = typeA.getESuperTypes();
    EClass _head = IterableExtensions.<EClass>head(_eSuperTypes_1);
    Assert.assertSame(typeModel, _head);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "B");
    EClass typeB = ((EClass) _type_2);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_2 = this.features(typeB);
    boolean _isEmpty_2 = _features_2.isEmpty();
    Assert.assertTrue(_isEmpty_2);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "C");
    EClass typeC = ((EClass) _type_3);
    Assert.assertNotNull(typeC);
    List<? extends EStructuralFeature> _features_3 = this.features(typeC);
    boolean _isEmpty_3 = _features_3.isEmpty();
    Assert.assertTrue(_isEmpty_3);
    EClassifier _type_4 = this.<EClassifier>type(ePackage, "D");
    EClass typeD = ((EClass) _type_4);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeD, "a");
    Assert.assertNotNull(_feature);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeD, "b");
    Assert.assertNotNull(_feature_1);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "c");
    Assert.assertNotNull(_feature_2);
    List<? extends EStructuralFeature> _features_4 = this.features(typeD);
    int _size_2 = _features_4.size();
    Assert.assertEquals(3, _size_2);
  }
  
  @Test
  public void testBug346685_b03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " Model: A? ({D.a = current} b = B)? c=C? ;\n");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " A: {A} \'a\';\n");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " B: {B} \'c\';\n");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " C: {C} \'b\';\n");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(5, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "Model");
    EClass typeModel = ((EClass) _type);
    Assert.assertNotNull(typeModel);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeModel, "c");
    Assert.assertNotNull(_feature);
    List<? extends EStructuralFeature> _features = this.features(typeModel);
    int _size_1 = _features.size();
    Assert.assertEquals(1, _size_1);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "A");
    EClass typeA = ((EClass) _type_1);
    Assert.assertNotNull(typeA);
    List<? extends EStructuralFeature> _features_1 = this.features(typeA);
    boolean _isEmpty = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty);
    EList<EClass> _eSuperTypes = typeA.getESuperTypes();
    int _size_2 = _eSuperTypes.size();
    Assert.assertEquals(1, _size_2);
    EList<EClass> _eSuperTypes_1 = typeA.getESuperTypes();
    EClass _head = IterableExtensions.<EClass>head(_eSuperTypes_1);
    Assert.assertSame(typeModel, _head);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "B");
    EClass typeB = ((EClass) _type_2);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_2 = this.features(typeB);
    boolean _isEmpty_1 = _features_2.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "C");
    EClass typeC = ((EClass) _type_3);
    Assert.assertNotNull(typeC);
    List<? extends EStructuralFeature> _features_3 = this.features(typeC);
    boolean _isEmpty_2 = _features_3.isEmpty();
    Assert.assertTrue(_isEmpty_2);
    EClassifier _type_4 = this.<EClassifier>type(ePackage, "D");
    EClass typeD = ((EClass) _type_4);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeD, "a");
    Assert.assertNotNull(_feature_1);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "b");
    Assert.assertNotNull(_feature_2);
    List<? extends EStructuralFeature> _features_4 = this.features(typeD);
    int _size_3 = _features_4.size();
    Assert.assertEquals(2, _size_3);
  }
  
  @Test
  public void testBug346685_b04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " Model: A? ({D.a = current} b = B) c=C? ;\n");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " A: {A} \'a\';\n");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " B: {B} \'c\';\n");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " C: {C} \'b\';\n");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    int _size = _eClassifiers.size();
    Assert.assertEquals(5, _size);
    EClassifier _type = this.<EClassifier>type(ePackage, "Model");
    EClass typeModel = ((EClass) _type);
    Assert.assertNotNull(typeModel);
    List<? extends EStructuralFeature> _features = this.features(typeModel);
    boolean _isEmpty = _features.isEmpty();
    Assert.assertTrue(_isEmpty);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "A");
    EClass typeA = ((EClass) _type_1);
    Assert.assertNotNull(typeA);
    List<? extends EStructuralFeature> _features_1 = this.features(typeA);
    boolean _isEmpty_1 = _features_1.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    EList<EClass> _eSuperTypes = typeA.getESuperTypes();
    int _size_1 = _eSuperTypes.size();
    Assert.assertEquals(1, _size_1);
    EList<EClass> _eSuperTypes_1 = typeA.getESuperTypes();
    EClass _head = IterableExtensions.<EClass>head(_eSuperTypes_1);
    Assert.assertSame(typeModel, _head);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "B");
    EClass typeB = ((EClass) _type_2);
    Assert.assertNotNull(typeB);
    List<? extends EStructuralFeature> _features_2 = this.features(typeB);
    boolean _isEmpty_2 = _features_2.isEmpty();
    Assert.assertTrue(_isEmpty_2);
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "C");
    EClass typeC = ((EClass) _type_3);
    Assert.assertNotNull(typeC);
    List<? extends EStructuralFeature> _features_3 = this.features(typeC);
    boolean _isEmpty_3 = _features_3.isEmpty();
    Assert.assertTrue(_isEmpty_3);
    EClassifier _type_4 = this.<EClassifier>type(ePackage, "D");
    EClass typeD = ((EClass) _type_4);
    Assert.assertNotNull(typeD);
    EStructuralFeature _feature = this.<EStructuralFeature>feature(typeD, "a");
    Assert.assertNotNull(_feature);
    EStructuralFeature _feature_1 = this.<EStructuralFeature>feature(typeD, "b");
    Assert.assertNotNull(_feature_1);
    EStructuralFeature _feature_2 = this.<EStructuralFeature>feature(typeD, "c");
    Assert.assertNotNull(_feature_2);
    List<? extends EStructuralFeature> _features_4 = this.features(typeD);
    int _size_2 = _features_4.size();
    Assert.assertEquals(3, _size_2);
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
  
  @Test
  public void testBug413171_01() throws Exception {
    String _readFileIntoString = this.readFileIntoString("org/eclipse/xtext/xtext/ecoreInference/Bug413171_01.xtext.txt");
    EObject _model = this.getModel(_readFileIntoString);
    final Grammar grammar = ((Grammar) _model);
    EList<AbstractRule> _rules = grammar.getRules();
    final AbstractRule parserRule = _rules.get(2);
    TypeRef _type = parserRule.getType();
    final EClassifier classifier = _type.getClassifier();
    String _name = parserRule.getName();
    Assert.assertTrue(_name, (classifier instanceof EDataType));
  }
  
  @Test
  public void testBug413171_02() throws Exception {
    String _readFileIntoString = this.readFileIntoString("org/eclipse/xtext/xtext/ecoreInference/Bug413171_02.xtext.txt");
    EObject _model = this.getModel(_readFileIntoString);
    final Grammar grammar = ((Grammar) _model);
    EList<AbstractRule> _rules = grammar.getRules();
    final AbstractRule parserRule = _rules.get(2);
    TypeRef _type = parserRule.getType();
    final EClassifier classifier = _type.getClassifier();
    String _name = parserRule.getName();
    Assert.assertTrue(_name, (classifier instanceof EDataType));
  }
  
  @Test
  public void testBug390326() throws Exception {
    String grammar = "grammar test with org.eclipse.xtext.common.Terminals";
    String _grammar = grammar;
    grammar = (_grammar + " generate test \'http://test\'");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " Model: A ({B.a = current} b = A)*;\n");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " A: value=ID;\n");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EClassifier _type = this.<EClassifier>type(ePackage, "B");
    EClass clazz = ((EClass) _type);
    EStructuralFeature feature = this.<EStructuralFeature>feature(clazz, "a");
    EClassifier _eType = feature.getEType();
    String _name = _eType.getName();
    Assert.assertEquals("Model", _name);
  }
  
  @Test
  public void testBug390326_02() throws Exception {
    String grammar = "grammar test with org.eclipse.xtext.common.Terminals";
    String _grammar = grammar;
    grammar = (_grammar + " generate test \'http://test\'");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " Model: A ({B.a = current} b = A {C.a=current} c = A)*;\n");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + " C returns A: value=\'c\';\n");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " A: value=\'a\';\n");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EClassifier _type = this.<EClassifier>type(ePackage, "B");
    EClass clazzB = ((EClass) _type);
    EStructuralFeature feature = this.<EStructuralFeature>feature(clazzB, "a");
    EClassifier _eType = feature.getEType();
    String _name = _eType.getName();
    Assert.assertEquals("Model", _name);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "C");
    EClass clazzC = ((EClass) _type_1);
    EStructuralFeature featureC_A = this.<EStructuralFeature>feature(clazzC, "a");
    EClassifier _eType_1 = featureC_A.getEType();
    String _name_1 = _eType_1.getName();
    Assert.assertEquals("B", _name_1);
  }
  
  @Test
  public void testBug390326_03() throws Exception {
    String grammar = "grammar test with org.eclipse.xtext.common.Terminals";
    String _grammar = grammar;
    grammar = (_grammar + " generate test \'http://test\'");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " Model: Value (({A.a = current} \'a\' )|\n");
    String _grammar_2 = grammar;
    grammar = (_grammar_2 + "               ({B.a = current} \'b\' ))*;\n");
    String _grammar_3 = grammar;
    grammar = (_grammar_3 + " Value: value=\'a\';\n");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    EClassifier _type = this.<EClassifier>type(ePackage, "A");
    EClass clazzA = ((EClass) _type);
    EStructuralFeature featureA_a = this.<EStructuralFeature>feature(clazzA, "a");
    EClassifier _eType = featureA_a.getEType();
    String _name = _eType.getName();
    Assert.assertEquals("Model", _name);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "B");
    EClass clazzB = ((EClass) _type_1);
    EStructuralFeature featureB_a = this.<EStructuralFeature>feature(clazzB, "a");
    EClassifier _eType_1 = featureB_a.getEType();
    String _name_1 = _eType_1.getName();
    Assert.assertEquals("Model", _name_1);
  }
}
