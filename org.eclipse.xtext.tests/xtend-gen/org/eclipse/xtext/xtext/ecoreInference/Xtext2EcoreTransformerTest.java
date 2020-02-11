/**
 * Copyright (c) 2008, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.ecoreInference;

import java.io.InputStream;
import java.util.List;
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
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.tests.TestErrorAcceptor;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.XtextLinker;
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
    final EAttribute feature = eClass.getEAttributes().get(attributeIndex);
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
    final EReference reference = eClass.getEReferences().get(referenceIndex);
    Assert.assertEquals(featureName, reference.getName());
    Assert.assertNotNull(reference.getEType());
    Assert.assertEquals(featureTypeName, reference.getEType().getName());
    Assert.assertEquals(Boolean.valueOf(isContainment), Boolean.valueOf(reference.isContainment()));
    Assert.assertEquals(lowerBound, reference.getLowerBound());
    Assert.assertEquals(upperBound, reference.getUpperBound());
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
    Assert.assertEquals(1, classifiers.size());
    final EClassifier myRuleType = IterableExtensions.<EClassifier>head(classifiers);
    Assert.assertEquals("MyRule", myRuleType.getName());
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
    Assert.assertEquals(3, classifiers.size());
    Assert.assertEquals("RootRule", classifiers.get(0).getName());
    Assert.assertEquals("Sub1", classifiers.get(1).getName());
    Assert.assertEquals("Sub2", classifiers.get(2).getName());
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
    Assert.assertEquals(1, classifiers.size());
    final EClassifier myRuleType = IterableExtensions.<EClassifier>head(classifiers);
    Assert.assertEquals("MyRule", myRuleType.getName());
    Assert.assertEquals("EInt", this.<EStructuralFeature>feature(myRuleType, "myFeature").getEType().getName());
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
    Assert.assertEquals(2, classifiers.size());
    final EClassifier myRuleType = IterableExtensions.<EClassifier>head(classifiers);
    Assert.assertEquals("MyRule", myRuleType.getName());
    Assert.assertTrue(this.features(myRuleType).isEmpty());
    final EClassifier intFeatureHolder = IterableExtensions.<EClassifier>last(classifiers);
    Assert.assertEquals("EInt", this.<EStructuralFeature>feature(intFeatureHolder, "myFeature").getEType().getName());
    Assert.assertTrue(this.superTypes(myRuleType).contains(intFeatureHolder));
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
    Assert.assertEquals(3, classifiers.size());
    final EClassifier myRuleType = IterableExtensions.<EClassifier>head(classifiers);
    Assert.assertEquals("MyRule", myRuleType.getName());
    Assert.assertTrue(this.features(myRuleType).isEmpty());
    final EClassifier intFeatureHolder = classifiers.get(1);
    Assert.assertEquals("EInt", this.<EStructuralFeature>feature(intFeatureHolder, "myFeature").getEType().getName());
    Assert.assertTrue(this.superTypes(myRuleType).contains(intFeatureHolder));
    final EClassifier nameFeatureHolder = IterableExtensions.<EClassifier>last(classifiers);
    Assert.assertEquals("EString", this.<EStructuralFeature>feature(nameFeatureHolder, "name").getEType().getName());
    Assert.assertTrue(this.superTypes(intFeatureHolder).contains(nameFeatureHolder));
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
    Assert.assertEquals(3, classifiers.size());
    final EClassifier myRuleType = IterableExtensions.<EClassifier>head(classifiers);
    Assert.assertEquals("MyRule", myRuleType.getName());
    Assert.assertTrue(this.features(myRuleType).isEmpty());
    final EClassifier intFeatureHolder = classifiers.get(1);
    Assert.assertEquals("EInt", this.<EStructuralFeature>feature(intFeatureHolder, "myFeature").getEType().getName());
    Assert.assertEquals(1, this.features(intFeatureHolder).size());
    final EClassifier nameFeatureHolder = IterableExtensions.<EClassifier>last(classifiers);
    Assert.assertEquals("EString", this.<EStructuralFeature>feature(nameFeatureHolder, "name").getEType().getName());
    Assert.assertEquals(2, this.features(nameFeatureHolder).size());
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
    Assert.assertEquals(3, classifiers.size());
    final EClassifier middleType = IterableExtensions.<EClassifier>head(classifiers);
    Assert.assertEquals("Middle", middleType.getName());
    Assert.assertTrue(this.features(middleType).isEmpty());
    final EClassifier topType = classifiers.get(1);
    Assert.assertEquals("EString", this.<EStructuralFeature>feature(topType, "name").getEType().getName());
    Assert.assertTrue(this.superTypes(middleType).contains(topType));
    final EClassifier bottomType = IterableExtensions.<EClassifier>last(classifiers);
    Assert.assertEquals("Top", this.<EStructuralFeature>feature(bottomType, "prev").getEType().getName());
    Assert.assertTrue(this.superTypes(bottomType).contains(middleType));
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
    Assert.assertEquals(4, classifiers.size());
    final EClassifier middleType1 = IterableExtensions.<EClassifier>head(classifiers);
    Assert.assertEquals("Middle1", middleType1.getName());
    Assert.assertTrue(this.features(middleType1).isEmpty());
    final EClassifier middleType2 = classifiers.get(1);
    Assert.assertEquals("Middle2", middleType2.getName());
    Assert.assertTrue(this.features(middleType2).isEmpty());
    final EClassifier topType = classifiers.get(2);
    Assert.assertEquals("EString", this.<EStructuralFeature>feature(topType, "name").getEType().getName());
    Assert.assertTrue(this.superTypes(middleType1).contains(topType));
    Assert.assertTrue(this.superTypes(middleType2).contains(topType));
    final EClassifier bottomType = IterableExtensions.<EClassifier>last(classifiers);
    Assert.assertEquals("Top", this.<EStructuralFeature>feature(bottomType, "prev").getEType().getName());
    Assert.assertTrue(this.superTypes(bottomType).contains(middleType1));
    Assert.assertTrue(this.superTypes(bottomType).contains(middleType2));
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
    Assert.assertEquals(4, classifiers.size());
    final EClassifier middleType1 = IterableExtensions.<EClassifier>head(classifiers);
    Assert.assertEquals("Middle1", middleType1.getName());
    Assert.assertTrue(this.features(middleType1).isEmpty());
    final EClassifier middleType2 = classifiers.get(1);
    Assert.assertEquals("Middle2", middleType2.getName());
    Assert.assertTrue(this.features(middleType2).isEmpty());
    final EClassifier topType = classifiers.get(2);
    Assert.assertEquals("EString", this.<EStructuralFeature>feature(topType, "name").getEType().getName());
    Assert.assertTrue(this.superTypes(middleType1).contains(topType));
    Assert.assertTrue(this.superTypes(middleType2).contains(topType));
    final EClassifier bottomType = IterableExtensions.<EClassifier>last(classifiers);
    Assert.assertEquals("Top", this.<EStructuralFeature>feature(bottomType, "prev").getEType().getName());
    Assert.assertTrue(this.superTypes(bottomType).contains(middleType1));
    Assert.assertTrue(this.superTypes(bottomType).contains(middleType2));
  }
  
  @Test
  public void testParserRuleFragment_08() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("RuleA: feature=Fragment;");
    _builder.newLine();
    _builder.append("fragment Fragment * Fragment: name=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    this.errorAcceptorMock.acceptError(TransformationErrorCode.InvalidFragmentCall, 
      TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
    EPackage result = this.getEPackageFromGrammar(grammar, 2);
    Assert.assertEquals(1, result.getEClassifiers().size());
  }
  
  @Test
  public void testParserRuleFragment_09() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("RuleA: feature=(Fragment|Fragment);");
    _builder.newLine();
    _builder.append("fragment Fragment returns Fragment: name=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    this.errorAcceptorMock.acceptError(TransformationErrorCode.InvalidFragmentCall, 
      TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
    EPackage result = this.getEPackageFromGrammar(grammar, 1);
    Assert.assertEquals(2, result.getEClassifiers().size());
  }
  
  @Test
  public void testParserRuleFragment_10() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("RuleA: feature+=Fragment;");
    _builder.newLine();
    _builder.append("fragment Fragment returns Fragment: name=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    this.errorAcceptorMock.acceptError(TransformationErrorCode.InvalidFragmentCall, 
      TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
    EPackage result = this.getEPackageFromGrammar(grammar, 1);
    Assert.assertEquals(2, result.getEClassifiers().size());
  }
  
  @Test
  public void testParserRuleFragment_11() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("RuleA: feature?=Fragment;");
    _builder.newLine();
    _builder.append("fragment Fragment returns Fragment: name=ID;");
    _builder.newLine();
    final String grammar = _builder.toString();
    this.errorAcceptorMock.acceptError(TransformationErrorCode.InvalidFragmentCall, 
      TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
    EPackage result = this.getEPackageFromGrammar(grammar, 1);
    Assert.assertEquals(2, result.getEClassifiers().size());
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
    final AbstractRule rule = IterableExtensions.<AbstractRule>head(grammar.getRules());
    TypeRef type = rule.getType();
    Assert.assertNotNull(type);
    Assert.assertNotNull(transformer.getEClassifierInfos().getInfo(type));
    AbstractMetamodelDeclaration _get = GrammarUtil.allMetamodelDeclarations(grammar).get(1);
    final ReferencedMetamodel referenced = ((ReferencedMetamodel) _get);
    Assert.assertNotNull(referenced);
    Assert.assertEquals("ecore", referenced.getAlias());
    Assert.assertNull(transformer.getEClassifierInfos().getInfo(referenced, "EString"));
    Assert.assertNull(transformer.getEClassifierInfos().getInfo(referenced, "EInt"));
    EClassifierInfos parentInfos = IterableExtensions.<EClassifierInfos>head(transformer.getEClassifierInfos().getParents());
    Assert.assertNotNull(parentInfos.getInfo(referenced, "EString"));
    Assert.assertNotNull(parentInfos.getInfo(referenced, "EInt"));
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
    Assert.assertEquals(1, classifiers.size());
    final EClassifier myRuleType = IterableExtensions.<EClassifier>head(classifiers);
    Assert.assertEquals("MyRule", myRuleType.getName());
    Assert.assertEquals("myFeature", IterableExtensions.head(this.features(myRuleType)).getName());
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
    Assert.assertEquals(2, ePackage.getEClassifiers().size());
    Assert.assertNotNull(this.<EClassifier>type(ePackage, "TypeA"));
    Assert.assertNotNull(this.<EClassifier>type(ePackage, "TypeB"));
  }
  
  @Test
  public void testSimpleHierarchy() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: RuleB; RuleB: featureB= INT;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    Assert.assertEquals(2, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    Assert.assertTrue(ruleA.getESuperTypes().isEmpty());
    Assert.assertEquals(1, ruleB.getESuperTypes().size());
    EClass superClass = IterableExtensions.<EClass>head(ruleB.getESuperTypes());
    Assert.assertEquals(ruleA, superClass);
  }
  
  @Test
  public void testDiamondHierarchy() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' Model: name=ID value=SubNamed1 otherValue=SubNamed2 thirdValue=SubNamed3;Named: SubNamed1 | SubNamed2 | SubNamed3;SubNamed1: ConcreteNamed1 | ConcreteNamed2;SubNamed2: ConcreteNamed2 | ConcreteNamed3;SubNamed3: ConcreteNamed1 | ConcreteNamed3;ConcreteNamed1: name=ID bar=ID foo=ID a=ID;ConcreteNamed2: name=ID bar=ID zonk=ID b=ID;ConcreteNamed3: name=ID foo=ID zonk=ID c=ID;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    Assert.assertEquals(8, ePackage.getEClassifiers().size());
    final EClassifier classifier = this.<EClassifier>type(ePackage, "Named");
    Assert.assertNotNull(classifier);
    EClass named = ((EClass) classifier);
    EStructuralFeature feature = this.<EStructuralFeature>feature(named, "name");
    Assert.assertNotNull("name", feature);
    Assert.assertEquals("named", 1, this.features(named).size());
    EClassifier _type = this.<EClassifier>type(ePackage, "SubNamed1");
    EClass subNamed1 = ((EClass) _type);
    Assert.assertNotNull("subNamed1", subNamed1);
    Assert.assertEquals(1, subNamed1.getESuperTypes().size());
    Assert.assertNotNull("bar", this.<EStructuralFeature>feature(subNamed1, "bar"));
    Assert.assertEquals("subNamed1", 1, this.features(subNamed1).size());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "SubNamed2");
    EClass subNamed2 = ((EClass) _type_1);
    Assert.assertNotNull("subNamed2", subNamed2);
    Assert.assertEquals(1, subNamed2.getESuperTypes().size());
    Assert.assertNotNull("bar", this.<EStructuralFeature>feature(subNamed2, "zonk"));
    Assert.assertEquals("subNamed2", 1, this.features(subNamed2).size());
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "SubNamed3");
    EClass subNamed3 = ((EClass) _type_2);
    Assert.assertNotNull("subNamed3", subNamed3);
    Assert.assertEquals(1, subNamed3.getESuperTypes().size());
    Assert.assertNotNull("bar", this.<EStructuralFeature>feature(subNamed3, "foo"));
    Assert.assertEquals("subNamed3", 1, this.features(subNamed3).size());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "ConcreteNamed1");
    EClass concreteNamed1 = ((EClass) _type_3);
    Assert.assertNotNull("concreteNamed1", concreteNamed1);
    Assert.assertEquals("concreteNamed1", 2, concreteNamed1.getESuperTypes().size());
    Assert.assertTrue(concreteNamed1.getESuperTypes().contains(subNamed1));
    Assert.assertTrue(concreteNamed1.getESuperTypes().contains(subNamed3));
    Assert.assertNotNull("a", this.<EStructuralFeature>feature(concreteNamed1, "a"));
    Assert.assertEquals("concreteNamed1", 1, this.features(concreteNamed1).size());
    EClassifier _type_4 = this.<EClassifier>type(ePackage, "ConcreteNamed2");
    EClass concreteNamed2 = ((EClass) _type_4);
    Assert.assertNotNull("concreteNamed2", concreteNamed2);
    Assert.assertEquals("concreteNamed2", 2, concreteNamed2.getESuperTypes().size());
    Assert.assertTrue(concreteNamed2.getESuperTypes().contains(subNamed1));
    Assert.assertTrue(concreteNamed2.getESuperTypes().contains(subNamed2));
    Assert.assertNotNull("b", this.<EStructuralFeature>feature(concreteNamed2, "b"));
    Assert.assertEquals("concreteNamed2", 1, this.features(concreteNamed2).size());
    EClassifier _type_5 = this.<EClassifier>type(ePackage, "ConcreteNamed3");
    EClass concreteNamed3 = ((EClass) _type_5);
    Assert.assertNotNull("concreteNamed3", concreteNamed3);
    Assert.assertEquals("concreteNamed3", 2, concreteNamed3.getESuperTypes().size());
    Assert.assertTrue(concreteNamed3.getESuperTypes().contains(subNamed2));
    Assert.assertTrue(concreteNamed3.getESuperTypes().contains(subNamed3));
    Assert.assertNotNull("c", this.<EStructuralFeature>feature(concreteNamed3, "c"));
    Assert.assertEquals("concreteNamed3", 1, this.features(concreteNamed3).size());
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
    Assert.assertEquals(1, ruleA.getEAttributes().size());
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
    Assert.assertEquals(3, ruleA.getEAttributes().size());
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
    Assert.assertEquals(3, ruleA.getEAttributes().size());
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
    Assert.assertEquals(1, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    Assert.assertEquals(2, ruleA.getEAttributes().size());
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
    Assert.assertEquals(2, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    Assert.assertEquals(1, ruleA.getEAttributes().size());
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EInt");
    Assert.assertEquals(1, ruleB.getEAttributes().size());
    this.assertAttributeConfiguration(ruleB, 0, "featureB", 
      "EString");
  }
  
  @Test
  public void testFeaturesAndInheritanceMandatoryRuleCall() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: RuleB featureA=INT; RuleB: featureB=STRING;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    Assert.assertEquals(2, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    Assert.assertEquals(0, ruleA.getEAttributes().size());
    Assert.assertEquals(2, ruleB.getEAttributes().size());
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
    Assert.assertEquals(3, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_2);
    Assert.assertNotNull(ruleC);
    Assert.assertTrue(ruleA.getESuperTypes().isEmpty());
    Assert.assertEquals(1, ruleB.getESuperTypes().size());
    Assert.assertEquals(ruleA, IterableExtensions.<EClass>head(ruleB.getESuperTypes()));
    Assert.assertEquals(1, ruleC.getESuperTypes().size());
    Assert.assertEquals(ruleA, IterableExtensions.<EClass>head(ruleC.getESuperTypes()));
    Assert.assertEquals(1, ruleA.getEAttributes().size());
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
    Assert.assertEquals(1, ruleB.getEAttributes().size());
    this.assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
    Assert.assertEquals(2, ruleC.getEAttributes().size());
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
    Assert.assertEquals(3, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_2);
    Assert.assertNotNull(ruleC);
    Assert.assertTrue(ruleA.getESuperTypes().isEmpty());
    Assert.assertEquals(1, ruleB.getESuperTypes().size());
    Assert.assertEquals(ruleA, IterableExtensions.<EClass>head(ruleB.getESuperTypes()));
    Assert.assertEquals(1, ruleC.getESuperTypes().size());
    Assert.assertEquals(ruleA, IterableExtensions.<EClass>head(ruleC.getESuperTypes()));
    Assert.assertEquals(1, ruleA.getEAttributes().size());
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
    Assert.assertEquals(1, ruleB.getEAttributes().size());
    this.assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
    Assert.assertEquals(2, ruleC.getEAttributes().size());
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
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
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
    Assert.assertTrue(ruleA.getESuperTypes().isEmpty());
    Assert.assertEquals(1, ruleB.getESuperTypes().size());
    Assert.assertEquals(ruleA, IterableExtensions.<EClass>head(ruleB.getESuperTypes()));
    Assert.assertEquals(1, ruleC.getESuperTypes().size());
    Assert.assertEquals(ruleA, IterableExtensions.<EClass>head(ruleC.getESuperTypes()));
    Assert.assertEquals(1, ruleD.getESuperTypes().size());
    Assert.assertEquals(ruleA, IterableExtensions.<EClass>head(ruleD.getESuperTypes()));
    Assert.assertEquals(1, ruleA.getEAttributes().size());
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
    Assert.assertEquals(2, ruleB.getEAttributes().size());
    this.assertAttributeConfiguration(ruleB, 0, "featureBC", "EString");
    this.assertAttributeConfiguration(ruleB, 1, "featureB2", "EString");
    Assert.assertEquals(4, ruleC.getEAttributes().size());
    this.assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
    this.assertAttributeConfiguration(ruleC, 1, "featureBC", "EString");
    this.assertAttributeConfiguration(ruleC, 2, "featureCD", "EString");
    this.assertAttributeConfiguration(ruleC, 3, "featureC2", "EString");
    Assert.assertEquals(3, ruleD.getEAttributes().size());
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
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
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
    Assert.assertTrue(ruleA.getESuperTypes().isEmpty());
    Assert.assertEquals(1, ruleB.getESuperTypes().size());
    Assert.assertEquals(ruleA, IterableExtensions.<EClass>head(ruleB.getESuperTypes()));
    Assert.assertEquals(1, ruleC.getESuperTypes().size());
    Assert.assertEquals(ruleA, IterableExtensions.<EClass>head(ruleC.getESuperTypes()));
    Assert.assertEquals(1, ruleD.getESuperTypes().size());
    Assert.assertEquals(ruleA, IterableExtensions.<EClass>head(ruleD.getESuperTypes()));
    Assert.assertEquals(2, ruleA.getEAttributes().size());
    this.assertAttributeConfiguration(ruleA, 0, "featureABC", "EString");
    this.assertAttributeConfiguration(ruleA, 1, "featureA", "EString");
    Assert.assertEquals(1, ruleB.getEAttributes().size());
    this.assertAttributeConfiguration(ruleB, 0, "featureB2", "EString");
    Assert.assertEquals(3, ruleC.getEAttributes().size());
    this.assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
    this.assertAttributeConfiguration(ruleC, 1, "featureCD", "EString");
    this.assertAttributeConfiguration(ruleC, 2, "featureC2", "EString");
    Assert.assertEquals(3, ruleD.getEAttributes().size());
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
    Assert.assertEquals(3, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "Add");
    EClass add = ((EClass) _type_1);
    Assert.assertNotNull(add);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "Sub");
    EClass sub = ((EClass) _type_2);
    Assert.assertNotNull(sub);
    Assert.assertTrue(ruleA.getESuperTypes().isEmpty());
    Assert.assertEquals(1, add.getESuperTypes().size());
    Assert.assertEquals(ruleA, IterableExtensions.<EClass>head(add.getESuperTypes()));
    Assert.assertEquals(1, sub.getESuperTypes().size());
    Assert.assertEquals(ruleA, IterableExtensions.<EClass>head(sub.getESuperTypes()));
    Assert.assertEquals(1, ruleA.getEAttributes().size());
    this.assertAttributeConfiguration(ruleA, 0, "featureAS", "EString");
    Assert.assertEquals(1, ruleA.getEReferences().size());
    this.assertReferenceConfiguration(ruleA, 0, "a", "RuleA", true, 0, 1);
    Assert.assertEquals(0, add.getEAttributes().size());
    Assert.assertEquals(0, add.getEReferences().size());
    Assert.assertEquals(0, sub.getEAttributes().size());
    Assert.assertEquals(0, sub.getEReferences().size());
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
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
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
    Assert.assertEquals(0, model.getESuperTypes().size());
    Assert.assertEquals(0, type.getESuperTypes().size());
    Assert.assertEquals(1, item.getESuperTypes().size());
    Assert.assertSame(type, IterableExtensions.<EClass>head(item.getESuperTypes()));
    Assert.assertEquals(1, thing.getESuperTypes().size());
    Assert.assertSame(type, thing.getESuperTypes().get(
      0));
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
    Assert.assertEquals(2, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    Assert.assertEquals(1, ruleA.getEAttributes().size());
    this.assertAttributeConfiguration(ruleA, 0, "simpleFeature", "EString");
    Assert.assertEquals(2, ruleA.getEReferences().size());
    this.assertReferenceConfiguration(ruleA, 0, "callA1", "RuleB", true, 0, 1);
    this.assertReferenceConfiguration(ruleA, 1, "callA2", "RuleB", true, 0, (-1));
    Assert.assertEquals(1, ruleB.getEAttributes().size());
    this.assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
  }
  
  @Test
  public void testAssignedCrossReference() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' RuleA: refA1=[TypeB] refA2+=[TypeB|RuleB] simpleFeature=ID; RuleB returns TypeB: featureB=ID;");
    final String grammar = _builder.toString();
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    Assert.assertEquals(2, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    Assert.assertEquals(1, ruleA.getEAttributes().size());
    this.assertAttributeConfiguration(ruleA, 0, "simpleFeature", "EString");
    Assert.assertEquals(2, ruleA.getEReferences().size());
    this.assertReferenceConfiguration(ruleA, 0, "refA1", "TypeB", false, 0, 
      1);
    this.assertReferenceConfiguration(ruleA, 1, "refA2", "TypeB", false, 0, 
      (-1));
    Assert.assertEquals(1, typeB.getEAttributes().size());
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
    Assert.assertEquals(3, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    Assert.assertEquals(0, ruleA.getESuperTypes().size());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    Assert.assertEquals(0, typeB.getESuperTypes().size());
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_2);
    Assert.assertNotNull(ruleC);
    Assert.assertEquals(1, ruleC.getESuperTypes().size());
    Assert.assertEquals(typeB, IterableExtensions.<EClass>head(ruleC.getESuperTypes()));
    Assert.assertEquals(2, ruleA.getEAttributes().size());
    this.assertAttributeConfiguration(ruleA, 0, "featureA1", "EBoolean");
    this.assertAttributeConfiguration(ruleA, 1, "featureA2", "EString", 0, 
      (-1));
    Assert.assertEquals(4, ruleA.getEReferences().size());
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
    Assert.assertEquals(1, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertEquals(2, ruleA.getEAttributes().size());
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
    Assert.assertEquals(2, ePackages.size());
    EPackage t1 = IterableExtensions.<EPackage>head(ePackages);
    Assert.assertEquals("t1", t1.getName());
    Assert.assertEquals(1, t1.getEClassifiers().size());
    final EClassifier ruleA = this.<EClassifier>type(t1, "RuleA");
    Assert.assertNotNull(ruleA);
    EPackage t2 = ePackages.get(1);
    Assert.assertEquals(1, t2.getEClassifiers().size());
    Assert.assertEquals("t2", t2.getName());
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
    Assert.assertEquals(0, ePackages.size());
  }
  
  @Test
  public void testModifyingSealedModel() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\' import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore RuleA returns ecore::SomeNewTypeA: feature=ID;");
    final String grammar = _builder.toString();
    this.errorAcceptorMock.acceptError(TransformationErrorCode.CannotCreateTypeInSealedMetamodel, 
      TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
    EPackage result = this.getEPackageFromGrammar(grammar, 2);
    Assert.assertTrue(result.getEClassifiers().isEmpty());
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
    Assert.assertEquals(1, 
      ePackage.getEClassifiers().size());
    EClassifier _eClassifier = ePackage.getEClassifier("TypeA");
    EClass typeA = ((EClass) _eClassifier);
    Assert.assertNotNull(typeA);
    Assert.assertEquals(1, typeA.getEAttributes().size());
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
    Assert.assertEquals(1, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    Assert.assertEquals(1, typeA.getEAttributes().size());
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
    Assert.assertEquals(3, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_1);
    Assert.assertNotNull(ruleC);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleD");
    EClass ruleD = ((EClass) _type_2);
    Assert.assertNotNull(ruleD);
    Assert.assertEquals(1, typeA.getEReferences().size());
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
    Assert.assertEquals(3, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_1);
    Assert.assertNotNull(ruleC);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleD");
    EClass ruleD = ((EClass) _type_2);
    Assert.assertNotNull(ruleD);
    Assert.assertEquals(2, typeA.getEAllAttributes().size());
    this.assertAttributeConfiguration(typeA, 0, "featureA1", "EString");
    this.assertAttributeConfiguration(typeA, 1, "featureA4", "EInt");
    Assert.assertEquals(2, typeA.getEReferences().size());
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
    Assert.assertEquals(3, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "RuleA");
    EClass ruleA = ((EClass) _type);
    Assert.assertNotNull(ruleA);
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "RuleB");
    EClass ruleB = ((EClass) _type_1);
    Assert.assertNotNull(ruleB);
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "RuleC");
    EClass ruleC = ((EClass) _type_2);
    Assert.assertNotNull(ruleC);
    Assert.assertEquals(1, ruleA.getEAttributes().size());
    this.assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
    Assert.assertEquals(1, ruleB.getEAttributes().size());
    this.assertAttributeConfiguration(ruleB, 0, "featureB", "EInt");
    Assert.assertEquals(0, ruleC.getEAttributes().size());
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
    Assert.assertEquals(1, ePackage.getEClassifiers().size());
    Assert.assertEquals("RuleA", IterableExtensions.<EClassifier>head(ePackage.getEClassifiers()).getName());
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
    Assert.assertEquals(0, this.features(classifier).size());
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
    Assert.assertEquals("EString", classifier.getName());
    EStructuralFeature feature = this.<EStructuralFeature>feature(classifier, "id");
    Assert.assertNotNull(feature);
    Assert.assertEquals("EString", feature.getEType().getName());
    Assert.assertFalse(feature.getEType().equals(classifier));
    Assert.assertEquals(EcorePackage.Literals.ESTRING, feature.getEType());
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
    Assert.assertTrue(resource.getErrors().isEmpty());
  }
  
  @Test
  public void testNoException_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Model: WildcardFragment;");
    _builder.newLine();
    _builder.append("fragment WildcardFragment*:;");
    _builder.newLine();
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    Assert.assertEquals("no viable alternative at input \';\'", IterableExtensions.<Resource.Diagnostic>head(resource.getErrors()).getMessage());
  }
  
  @Test
  public void testNoException_05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Model: WildcardFragment;");
    _builder.newLine();
    _builder.append("fragment WildcardFragment:;");
    _builder.newLine();
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    Assert.assertEquals("no viable alternative at input \';\'", IterableExtensions.<Resource.Diagnostic>head(resource.getErrors()).getMessage());
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
    Assert.assertTrue(resource.getErrors().isEmpty());
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    final Grammar parsedGrammar = ((Grammar) _head);
    EList<AbstractRule> _rules = parsedGrammar.getRules();
    for (final AbstractRule rule : _rules) {
      {
        final EClassifier classifier = rule.getType().getClassifier();
        EPackage pack = classifier.getEPackage();
        Assert.assertEquals("bugreport", pack.getName());
      }
    }
  }
  
  @Test
  public void testBug_266807() throws Exception {
    final XtextResourceSet rs = this.<XtextResourceSet>get(XtextResourceSet.class);
    rs.setClasspathURIContext(this.getClass());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("classpath:/");
    String _replace = this.getClass().getPackage().getName().replace(Character.valueOf('.').charValue(), Character.valueOf('/').charValue());
    _builder.append(_replace);
    _builder.append("/Test.xtext");
    Resource _createResource = rs.createResource(
      URI.createURI(_builder.toString()), 
      ContentHandler.UNSPECIFIED_CONTENT_TYPE);
    final XtextResource resource = ((XtextResource) _createResource);
    resource.load(null);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    for (final Resource.Diagnostic d : _errors) {
      Assert.fail(d.getMessage());
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
    Assert.assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
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
    Assert.assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
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
    Assert.assertFalse(resource.getErrors().toString(), resource.getErrors().isEmpty());
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    for (final Resource.Diagnostic d : _errors) {
      Assert.assertFalse((d instanceof ExceptionDiagnostic));
    }
  }
  
  @Test
  public void testInheritFromEObject_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore  import \'classpath:/org/eclipse/xtext/xtext/ecoreInference/test.ecore\' as test  A returns ecore::EObject: B | C;  B returns test::Optional: \'b\' optionalString=STRING;  C returns test::Mandatory: \'c\' mandatoryString=STRING; ");
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    Assert.assertTrue(resource.getErrors().isEmpty());
  }
  
  @Test
  public void testInheritFromEObject_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore  Object returns ecore::EObject: {ecore::EInt}; ");
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
  }
  
  @Test
  public void testInheritFromEObject_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore  Object returns ecore::EObject: {ecore::EAnnotation}; ");
    String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    Assert.assertTrue(resource.getErrors().isEmpty());
  }
  
  @Test
  public void testPostProcessorHook() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore  generate test \'http://test\' MyRule: myFeature=INT;");
    final String xtextGrammar = _builder.toString();
    EObject _model = this.getModel(xtextGrammar);
    final Grammar grammar = ((Grammar) _model);
    final Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(grammar);
    AbstractMetamodelDeclaration _get = grammar.getMetamodelDeclarations().get(1);
    GeneratedMetamodel testMetamodel = ((GeneratedMetamodel) _get);
    final Xtext2EcoreTransformerTest.MockedXtext2EcorePostProcessor postProcessor = new Xtext2EcoreTransformerTest.MockedXtext2EcorePostProcessor(testMetamodel);
    transformer.setPostProcessor(postProcessor);
    transformer.transform();
    Assert.assertEquals("process mthde called once", 1, postProcessor.proccessMethCalled());
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
    Assert.assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
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
    Assert.assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
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
    Assert.assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
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
    Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
    Resource.Diagnostic _get = resource.getErrors().get(
      0);
    TransformationDiagnostic diagnostic = ((TransformationDiagnostic) _get);
    Assert.assertEquals(grammar.indexOf("mm::Atom"), diagnostic.getOffset());
    Assert.assertEquals("mm::Atom".length(), diagnostic.getLength());
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
    Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
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
    Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
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
    Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
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
    Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
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
    Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
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
    Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
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
    Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
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
    Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
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
    Assert.assertEquals(resource.getErrors().toString(), 0, 
      resource.getErrors().size());
  }
  
  @Test
  public void testContainmentVsReference_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' EClass: name=ID eSuperTypes+=EClass;");
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    Assert.assertEquals(resource.getErrors().toString(), 1, 
      resource.getErrors().size());
  }
  
  @Test
  public void testContainmentVsReference_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' EClass: name=ID eSuperTypes+=[EClass];");
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    Assert.assertEquals(resource.getErrors().toString(), 0, 
      resource.getErrors().size());
  }
  
  @Test
  public void testContainmentVsReference_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' EReference: name=ID eType=[EClass];");
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammar);
    Assert.assertEquals(resource.getErrors().toString(), 0, 
      resource.getErrors().size());
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
    Assert.assertEquals(resource.getErrors().toString(), 1, 
      resource.getErrors().size());
  }
  
  @Test
  public void testContainmentVsReference_05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals import \'http://www.eclipse.org/emf/2002/Ecore\' EReference: name=ID eContainingClass=[EClass];");
    final String grammar = _builder.toString();
    final XtextResource resource = this.getResourceFromStringAndExpect(grammar, 1);
    Assert.assertEquals(resource.getErrors().toString(), 1, 
      resource.getErrors().size());
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
    Assert.assertEquals(resource.getErrors().toString(), 1, 
      resource.getErrors().size());
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
    Assert.assertEquals(resource.getErrors().toString(), 1, 
      resource.getErrors().size());
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
    Assert.assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    final Grammar grammar = ((Grammar) _head);
    AbstractMetamodelDeclaration _get = grammar.getMetamodelDeclarations().get(1);
    GeneratedMetamodel generatedMetamodel = ((GeneratedMetamodel) _get);
    Assert.assertEquals("myDsl", generatedMetamodel.getName());
    EClassifier _type = this.<EClassifier>type(generatedMetamodel.getEPackage(), "CreatedType");
    EClass createdType = ((EClass) _type);
    Assert.assertEquals(this.<EStructuralFeature>feature(createdType, "enumFeature").getEType(), 
      this.<EStructuralFeature>feature(createdType, "otherEnumFeature").getEType());
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
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    final Grammar grammar = ((Grammar) _head);
    AbstractMetamodelDeclaration _head_1 = IterableExtensions.<AbstractMetamodelDeclaration>head(grammar.getMetamodelDeclarations());
    GeneratedMetamodel generatedMetamodel = ((GeneratedMetamodel) _head_1);
    Assert.assertEquals("myDsl", generatedMetamodel.getName());
    Assert.assertEquals(1, generatedMetamodel.getEPackage().getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(generatedMetamodel.getEPackage(), "Model");
    EClass createdModel = ((EClass) _type);
    Assert.assertEquals(EcorePackage.Literals.ESTRING, this.<EStructuralFeature>feature(createdModel, "name").getEType());
    EList<AbstractRule> _rules = grammar.getRules();
    for (final AbstractRule rule : _rules) {
      Assert.assertEquals(createdModel, rule.getType().getClassifier());
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
  public void testBug346685_a01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals generate test \'http://test\'");
    String grammar = _builder.toString();
    String _grammar = grammar;
    grammar = (_grammar + " RuleA returns TypeA: RuleB ({TypeC.x=current} \'x\' | {TypeD.x=current} \'y\')? name+=STRING;");
    String _grammar_1 = grammar;
    grammar = (_grammar_1 + " RuleB returns TypeB: {TypeB} \'ignore\';");
    EPackage ePackage = this.getEPackageFromGrammar(grammar);
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeA, "name"));
    Assert.assertEquals(1, this.features(typeA).size());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeC, "x"));
    Assert.assertEquals(1, this.features(typeC).size());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "x"));
    Assert.assertEquals(1, 
      this.features(typeD).size());
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
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    Assert.assertTrue(this.features(typeA).isEmpty());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeC, "x"));
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeC, "name"));
    Assert.assertEquals(2, this.features(typeC).size());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "x"));
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "name"));
    Assert.assertEquals(2, this.features(typeD).size());
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
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeA, "name"));
    Assert.assertEquals(1, this.features(typeA).size());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeC, "x"));
    Assert.assertEquals(1, this.features(typeC).size());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "x"));
    Assert.assertEquals(1, this.features(typeD).size());
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
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeA, "name"));
    Assert.assertEquals(1, this.features(typeA).size());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeC, "x"));
    Assert.assertEquals(1, this.features(typeC).size());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "x"));
    Assert.assertEquals(1, this.features(typeD).size());
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
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeA, "name"));
    Assert.assertEquals(1, this.features(typeA).size());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeC, "x"));
    Assert.assertEquals(1, this.features(typeC).size());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "x"));
    Assert.assertEquals(1, this.features(typeD).size());
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
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    Assert.assertTrue(this.features(typeA).isEmpty());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeC, "x"));
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeC, "name"));
    Assert.assertEquals(2, this.features(typeC).size());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "x"));
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "name"));
    Assert.assertEquals(2, this.features(typeD).size());
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
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeA, "name"));
    Assert.assertEquals(1, this.features(typeA).size());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeC, "x"));
    Assert.assertEquals(1, this.features(typeC).size());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "x"));
    Assert.assertEquals(1, this.features(typeD).size());
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
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeA, "name"));
    Assert.assertEquals(1, this.features(typeA).size());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeC, "x"));
    Assert.assertEquals(1, this.features(typeC).size());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "x"));
    Assert.assertEquals(1, this.features(typeD).size());
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
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeA, "name"));
    Assert.assertEquals(1, this.features(typeA).size());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeC, "x"));
    Assert.assertEquals(1, this.features(typeC).size());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "x"));
    Assert.assertEquals(1, this.features(typeD).size());
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
    Assert.assertEquals(4, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "TypeA");
    EClass typeA = ((EClass) _type);
    Assert.assertNotNull(typeA);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeA, "name"));
    Assert.assertEquals(1, this.features(typeA).size());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "TypeB");
    EClass typeB = ((EClass) _type_1);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "TypeC");
    EClass typeC = ((EClass) _type_2);
    Assert.assertNotNull(typeC);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeC, "x"));
    Assert.assertEquals(1, this.features(typeC).size());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "TypeD");
    EClass typeD = ((EClass) _type_3);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "x"));
    Assert.assertEquals(1, this.features(typeD).size());
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
    Assert.assertEquals(5, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "Model");
    EClass typeModel = ((EClass) _type);
    Assert.assertNotNull(typeModel);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeModel, "c"));
    Assert.assertEquals(1, this.features(typeModel).size());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "A");
    EClass typeA = ((EClass) _type_1);
    Assert.assertNotNull(typeA);
    Assert.assertTrue(this.features(typeA).isEmpty());
    Assert.assertEquals(1, typeA.getESuperTypes().size());
    Assert.assertSame(typeModel, IterableExtensions.<EClass>head(typeA.getESuperTypes()));
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "B");
    EClass typeB = ((EClass) _type_2);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "C");
    EClass typeC = ((EClass) _type_3);
    Assert.assertNotNull(typeC);
    Assert.assertTrue(this.features(typeC).isEmpty());
    EClassifier _type_4 = this.<EClassifier>type(ePackage, "D");
    EClass typeD = ((EClass) _type_4);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "a"));
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "b"));
    Assert.assertEquals(2, this.features(typeD).size());
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
    Assert.assertEquals(5, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "Model");
    EClass typeModel = ((EClass) _type);
    Assert.assertNotNull(typeModel);
    Assert.assertTrue(this.features(typeModel).isEmpty());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "A");
    EClass typeA = ((EClass) _type_1);
    Assert.assertNotNull(typeA);
    Assert.assertTrue(this.features(typeA).isEmpty());
    Assert.assertEquals(1, typeA.getESuperTypes().size());
    Assert.assertSame(typeModel, IterableExtensions.<EClass>head(typeA.getESuperTypes()));
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "B");
    EClass typeB = ((EClass) _type_2);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "C");
    EClass typeC = ((EClass) _type_3);
    Assert.assertNotNull(typeC);
    Assert.assertTrue(this.features(typeC).isEmpty());
    EClassifier _type_4 = this.<EClassifier>type(ePackage, "D");
    EClass typeD = ((EClass) _type_4);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "a"));
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "b"));
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "c"));
    Assert.assertEquals(3, this.features(typeD).size());
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
    Assert.assertEquals(5, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "Model");
    EClass typeModel = ((EClass) _type);
    Assert.assertNotNull(typeModel);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeModel, "c"));
    Assert.assertEquals(1, this.features(typeModel).size());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "A");
    EClass typeA = ((EClass) _type_1);
    Assert.assertNotNull(typeA);
    Assert.assertTrue(this.features(typeA).isEmpty());
    Assert.assertEquals(1, typeA.getESuperTypes().size());
    Assert.assertSame(typeModel, IterableExtensions.<EClass>head(typeA.getESuperTypes()));
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "B");
    EClass typeB = ((EClass) _type_2);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "C");
    EClass typeC = ((EClass) _type_3);
    Assert.assertNotNull(typeC);
    Assert.assertTrue(this.features(typeC).isEmpty());
    EClassifier _type_4 = this.<EClassifier>type(ePackage, "D");
    EClass typeD = ((EClass) _type_4);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "a"));
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "b"));
    Assert.assertEquals(2, this.features(typeD).size());
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
    Assert.assertEquals(5, ePackage.getEClassifiers().size());
    EClassifier _type = this.<EClassifier>type(ePackage, "Model");
    EClass typeModel = ((EClass) _type);
    Assert.assertNotNull(typeModel);
    Assert.assertTrue(this.features(typeModel).isEmpty());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "A");
    EClass typeA = ((EClass) _type_1);
    Assert.assertNotNull(typeA);
    Assert.assertTrue(this.features(typeA).isEmpty());
    Assert.assertEquals(1, typeA.getESuperTypes().size());
    Assert.assertSame(typeModel, IterableExtensions.<EClass>head(typeA.getESuperTypes()));
    EClassifier _type_2 = this.<EClassifier>type(ePackage, "B");
    EClass typeB = ((EClass) _type_2);
    Assert.assertNotNull(typeB);
    Assert.assertTrue(this.features(typeB).isEmpty());
    EClassifier _type_3 = this.<EClassifier>type(ePackage, "C");
    EClass typeC = ((EClass) _type_3);
    Assert.assertNotNull(typeC);
    Assert.assertTrue(this.features(typeC).isEmpty());
    EClassifier _type_4 = this.<EClassifier>type(ePackage, "D");
    EClass typeD = ((EClass) _type_4);
    Assert.assertNotNull(typeD);
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "a"));
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "b"));
    Assert.assertNotNull(this.<EStructuralFeature>feature(typeD, "c"));
    Assert.assertEquals(3, this.features(typeD).size());
  }
  
  @Test
  public void testBug413171_01() throws Exception {
    EObject _model = this.getModel(this.readFileIntoString("org/eclipse/xtext/xtext/ecoreInference/Bug413171_01.xtext.txt"));
    final Grammar grammar = ((Grammar) _model);
    final AbstractRule parserRule = grammar.getRules().get(2);
    final EClassifier classifier = parserRule.getType().getClassifier();
    Assert.assertTrue(parserRule.getName(), (classifier instanceof EDataType));
  }
  
  @Test
  public void testBug413171_02() throws Exception {
    EObject _model = this.getModel(this.readFileIntoString("org/eclipse/xtext/xtext/ecoreInference/Bug413171_02.xtext.txt"));
    final Grammar grammar = ((Grammar) _model);
    final AbstractRule parserRule = grammar.getRules().get(2);
    final EClassifier classifier = parserRule.getType().getClassifier();
    Assert.assertTrue(parserRule.getName(), (classifier instanceof EDataType));
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
    Assert.assertEquals("Model", feature.getEType().getName());
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
    Assert.assertEquals("Model", feature.getEType().getName());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "C");
    EClass clazzC = ((EClass) _type_1);
    EStructuralFeature featureC_A = this.<EStructuralFeature>feature(clazzC, "a");
    Assert.assertEquals("B", featureC_A.getEType().getName());
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
    Assert.assertEquals("Model", featureA_a.getEType().getName());
    EClassifier _type_1 = this.<EClassifier>type(ePackage, "B");
    EClass clazzB = ((EClass) _type_1);
    EStructuralFeature featureB_a = this.<EStructuralFeature>feature(clazzB, "a");
    Assert.assertEquals("Model", featureB_a.getEType().getName());
  }
  
  @Test
  public void testIssue91() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("grammar test.Test");
      _builder.newLine();
      _builder.append("generate test \'http://test\'");
      _builder.newLine();
      _builder.append("Foo:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("bar = BAR");
      _builder.newLine();
      _builder.append(";");
      _builder.newLine();
      _builder.append("terminal BAR:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("\'bar\'");
      _builder.newLine();
      _builder.append(";");
      _builder.newLine();
      String grammar = _builder.toString();
      this.errorAcceptorMock.acceptError(TransformationErrorCode.NoSuchTypeAvailable, 
        "Cannot create datatype BAR. If this is supposed to return EString, make sure you have imported \'http://www.eclipse.org/emf/2002/Ecore\'", TestErrorAcceptor.ANY_EOBJECT);
      this.getEPackageFromGrammar(grammar, 1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
