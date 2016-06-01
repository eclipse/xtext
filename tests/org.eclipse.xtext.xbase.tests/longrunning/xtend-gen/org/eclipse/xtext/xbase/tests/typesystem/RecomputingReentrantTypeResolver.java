/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.tests.typesystem.RecordingRootResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IApplicableCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IClosureCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.internal.ITypeLiteralLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.internal.ImplicitFirstArgument;
import org.eclipse.xtext.xbase.typesystem.internal.ImplicitReceiver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeInsteadOfConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class RecomputingReentrantTypeResolver extends PublicReentrantTypeResolver {
  @Inject
  @Extension
  private ReflectExtensions _reflectExtensions;
  
  private final Joiner.MapJoiner mapJoiner = Joiner.on("\n").withKeyValueSeparator("=");
  
  @Override
  public RootResolvedTypes createResolvedTypes(final CancelIndicator monitor) {
    return new RecordingRootResolvedTypes(this, CancelIndicator.NullImpl);
  }
  
  @Override
  public IResolvedTypes resolve(final CancelIndicator monitor) {
    IResolvedTypes _resolve = super.resolve(monitor);
    final RecordingRootResolvedTypes firstResult = ((RecordingRootResolvedTypes) _resolve);
    final Map<XExpression, IApplicableCandidate> firstRun = firstResult.getResolvedProxies();
    IResolvedTypes _resolve_1 = super.resolve(monitor);
    final RecordingRootResolvedTypes result = ((RecordingRootResolvedTypes) _resolve_1);
    final Map<XExpression, IApplicableCandidate> secondRun = result.getResolvedProxies();
    StringConcatenation _builder = new StringConcatenation();
    String _join = this.mapJoiner.join(firstRun);
    _builder.append(_join, "");
    _builder.newLineIfNotEmpty();
    _builder.append(" \t");
    _builder.newLine();
    _builder.append(" \t");
    _builder.append("vs");
    _builder.newLine();
    _builder.append(" \t");
    _builder.newLine();
    String _join_1 = this.mapJoiner.join(secondRun);
    _builder.append(_join_1, "");
    _builder.newLineIfNotEmpty();
    int _size = firstRun.size();
    int _size_1 = secondRun.size();
    Assert.assertEquals(_builder.toString(), _size, _size_1);
    final Joiner setJoiner = Joiner.on("\n");
    StringConcatenation _builder_1 = new StringConcatenation();
    Set<XExpression> _keySet = firstRun.keySet();
    String _join_2 = setJoiner.join(_keySet);
    _builder_1.append(_join_2, "");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append(" \t");
    _builder_1.newLine();
    _builder_1.append(" \t");
    _builder_1.append("vs");
    _builder_1.newLine();
    _builder_1.append(" \t");
    _builder_1.newLine();
    Set<XExpression> _keySet_1 = secondRun.keySet();
    String _join_3 = setJoiner.join(_keySet_1);
    _builder_1.append(_join_3, "");
    _builder_1.newLineIfNotEmpty();
    Set<XExpression> _keySet_2 = firstRun.keySet();
    Set<XExpression> _keySet_3 = secondRun.keySet();
    Assert.assertEquals(_builder_1.toString(), _keySet_2, _keySet_3);
    final BiConsumer<XExpression, IApplicableCandidate> _function = (XExpression expression, IApplicableCandidate firstLinkingData) -> {
      final IApplicableCandidate secondLinkingData = secondRun.get(expression);
      this.assertEqualLinkingData(firstLinkingData, secondLinkingData);
      boolean _isRefinedType = firstResult.isRefinedType(expression);
      boolean _isRefinedType_1 = result.isRefinedType(expression);
      Assert.assertEquals(Boolean.valueOf(_isRefinedType), Boolean.valueOf(_isRefinedType_1));
    };
    firstRun.forEach(_function);
    return result;
  }
  
  protected void _assertEqualLinkingData(final IApplicableCandidate left, final IApplicableCandidate right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left, "");
    _builder.append(" vs ");
    _builder.append(right, "");
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final IClosureCandidate left, final IClosureCandidate right) {
    List<JvmFormalParameter> _parameters = left.getParameters();
    int _size = _parameters.size();
    List<JvmFormalParameter> _parameters_1 = right.getParameters();
    int _size_1 = _parameters_1.size();
    Assert.assertEquals("type", _size, _size_1);
    List<JvmFormalParameter> _parameters_2 = left.getParameters();
    final Procedure2<JvmFormalParameter, Integer> _function = (JvmFormalParameter leftParam, Integer idx) -> {
      List<JvmFormalParameter> _parameters_3 = right.getParameters();
      final JvmFormalParameter rightParam = _parameters_3.get((idx).intValue());
      String _name = leftParam.getName();
      String _name_1 = rightParam.getName();
      Assert.assertEquals(_name, _name_1);
      EStructuralFeature _eContainingFeature = leftParam.eContainingFeature();
      boolean _notEquals = (!Objects.equal(_eContainingFeature, XbasePackage.Literals.XCLOSURE__DECLARED_FORMAL_PARAMETERS));
      if (_notEquals) {
        JvmTypeReference _parameterType = leftParam.getParameterType();
        String _identifier = _parameterType.getIdentifier();
        JvmTypeReference _parameterType_1 = rightParam.getParameterType();
        String _identifier_1 = _parameterType_1.getIdentifier();
        Assert.assertEquals(_identifier, _identifier_1);
      }
    };
    IterableExtensions.<JvmFormalParameter>forEach(_parameters_2, _function);
  }
  
  protected void _assertEqualLinkingData(final ITypeLiteralLinkingCandidate left, final ITypeLiteralLinkingCandidate right) {
    JvmType _type = left.getType();
    JvmType _type_1 = right.getType();
    Assert.assertEquals("type", _type, _type_1);
    XAbstractFeatureCall _featureCall = left.getFeatureCall();
    XAbstractFeatureCall _featureCall_1 = right.getFeatureCall();
    Assert.assertEquals("featureCall", _featureCall, _featureCall_1);
    this.doAssertEqualLinkingData(left, right);
    boolean _isStatic = left.isStatic();
    boolean _isStatic_1 = right.isStatic();
    Assert.assertEquals("isStatic", Boolean.valueOf(_isStatic), Boolean.valueOf(_isStatic_1));
    boolean _isTypeLiteral = left.isTypeLiteral();
    boolean _isTypeLiteral_1 = right.isTypeLiteral();
    Assert.assertEquals("isTypeLiteral", Boolean.valueOf(_isTypeLiteral), Boolean.valueOf(_isTypeLiteral_1));
    boolean _isExtension = left.isExtension();
    boolean _isExtension_1 = right.isExtension();
    Assert.assertEquals("isExtension", Boolean.valueOf(_isExtension), Boolean.valueOf(_isExtension_1));
  }
  
  protected void _assertEqualLinkingData(final ITypeLiteralLinkingCandidate left, final ILinkingCandidate right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left, "");
    _builder.append(" vs ");
    _builder.append(right, "");
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final ILinkingCandidate left, final ITypeLiteralLinkingCandidate right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left, "");
    _builder.append(" vs ");
    _builder.append(right, "");
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final IConstructorLinkingCandidate left, final IConstructorLinkingCandidate right) {
    JvmConstructor _constructor = left.getConstructor();
    JvmConstructor _constructor_1 = right.getConstructor();
    Assert.assertEquals("constructor", _constructor, _constructor_1);
    XConstructorCall _constructorCall = left.getConstructorCall();
    XConstructorCall _constructorCall_1 = right.getConstructorCall();
    Assert.assertEquals("constructorCall", _constructorCall, _constructorCall_1);
    this.doAssertEqualLinkingData(left, right);
  }
  
  protected void _assertEqualLinkingData(final TypeInsteadOfConstructorLinkingCandidate left, final IConstructorLinkingCandidate right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left, "");
    _builder.append(" vs ");
    _builder.append(right, "");
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final IConstructorLinkingCandidate left, final TypeInsteadOfConstructorLinkingCandidate right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left, "");
    _builder.append(" vs ");
    _builder.append(right, "");
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final TypeInsteadOfConstructorLinkingCandidate left, final TypeInsteadOfConstructorLinkingCandidate right) {
    try {
      JvmIdentifiableElement _feature = left.getFeature();
      JvmIdentifiableElement _feature_1 = right.getFeature();
      Assert.assertEquals("feature", _feature, _feature_1);
      XConstructorCall _constructorCall = left.getConstructorCall();
      XConstructorCall _constructorCall_1 = right.getConstructorCall();
      Assert.assertEquals("constructorCall", _constructorCall, _constructorCall_1);
      List<LightweightTypeReference> _typeArguments = left.getTypeArguments();
      List<LightweightTypeReference> _typeArguments_1 = right.getTypeArguments();
      this.assertEqualReferences("typeArguments", _typeArguments, _typeArguments_1);
      List<LightweightTypeReference> _invokeAndCast = this.<List<LightweightTypeReference>>invokeAndCast(left, "getSyntacticTypeArguments");
      List<LightweightTypeReference> _invokeAndCast_1 = this.<List<LightweightTypeReference>>invokeAndCast(right, "getSyntacticTypeArguments");
      this.assertEqualReferences("syntacticTypeArguments", _invokeAndCast, _invokeAndCast_1);
      Object _invoke = this._reflectExtensions.invoke(left, "getArguments");
      Object _invoke_1 = this._reflectExtensions.invoke(right, "getArguments");
      Assert.assertEquals("arguments", _invoke, _invoke_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _assertEqualLinkingData(final ImplicitReceiver left, final IFeatureLinkingCandidate right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left, "");
    _builder.append(" vs ");
    _builder.append(right, "");
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final IFeatureLinkingCandidate left, final ImplicitReceiver right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left, "");
    _builder.append(" vs ");
    _builder.append(right, "");
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final ImplicitReceiver left, final ImplicitReceiver right) {
    JvmIdentifiableElement _feature = left.getFeature();
    JvmIdentifiableElement _feature_1 = right.getFeature();
    Assert.assertEquals("feature", _feature, _feature_1);
    XAbstractFeatureCall _featureCall = left.getFeatureCall();
    XAbstractFeatureCall _featureCall_1 = right.getFeatureCall();
    Assert.assertEquals("featureCall", _featureCall, _featureCall_1);
    List<LightweightTypeReference> _typeArguments = left.getTypeArguments();
    List<LightweightTypeReference> _typeArguments_1 = right.getTypeArguments();
    this.assertEqualReferences("typeArguments", _typeArguments, _typeArguments_1);
  }
  
  protected void _assertEqualLinkingData(final ImplicitFirstArgument left, final ImplicitFirstArgument right) {
    JvmIdentifiableElement _feature = left.getFeature();
    JvmIdentifiableElement _feature_1 = right.getFeature();
    Assert.assertEquals("feature", _feature, _feature_1);
    XAbstractFeatureCall _featureCall = left.getFeatureCall();
    XAbstractFeatureCall _featureCall_1 = right.getFeatureCall();
    Assert.assertEquals("featureCall", _featureCall, _featureCall_1);
    List<LightweightTypeReference> _typeArguments = left.getTypeArguments();
    List<LightweightTypeReference> _typeArguments_1 = right.getTypeArguments();
    this.assertEqualReferences("typeArguments", _typeArguments, _typeArguments_1);
  }
  
  protected void _assertEqualLinkingData(final IFeatureLinkingCandidate left, final IFeatureLinkingCandidate right) {
    try {
      JvmIdentifiableElement _feature = left.getFeature();
      JvmIdentifiableElement _feature_1 = right.getFeature();
      Assert.assertEquals("feature", _feature, _feature_1);
      XAbstractFeatureCall _featureCall = left.getFeatureCall();
      XAbstractFeatureCall _featureCall_1 = right.getFeatureCall();
      Assert.assertEquals("featureCall", _featureCall, _featureCall_1);
      this.doAssertEqualLinkingData(left, right);
      Object _invoke = this._reflectExtensions.invoke(left, "getReceiver");
      Object _invoke_1 = this._reflectExtensions.invoke(right, "getReceiver");
      Assert.assertEquals("receiver", _invoke, _invoke_1);
      LightweightTypeReference _invokeAndCast = this.<LightweightTypeReference>invokeAndCast(left, "getReceiverType");
      LightweightTypeReference _invokeAndCast_1 = this.<LightweightTypeReference>invokeAndCast(left, "getReceiverType");
      this.assertEqualTypes("receiverType", _invokeAndCast, _invokeAndCast_1);
      Object _invoke_2 = this._reflectExtensions.invoke(left, "getImplicitReceiver");
      Object _invoke_3 = this._reflectExtensions.invoke(right, "getImplicitReceiver");
      Assert.assertEquals("implicitReceiver", _invoke_2, _invoke_3);
      LightweightTypeReference _invokeAndCast_2 = this.<LightweightTypeReference>invokeAndCast(left, "getImplicitReceiverType");
      LightweightTypeReference _invokeAndCast_3 = this.<LightweightTypeReference>invokeAndCast(left, "getImplicitReceiverType");
      this.assertEqualTypes("implicitReceiverType", _invokeAndCast_2, _invokeAndCast_3);
      Object _invoke_4 = this._reflectExtensions.invoke(left, "getImplicitFirstArgument");
      Object _invoke_5 = this._reflectExtensions.invoke(right, "getImplicitFirstArgument");
      Assert.assertEquals("implicitFirstArgument", _invoke_4, _invoke_5);
      LightweightTypeReference _invokeAndCast_4 = this.<LightweightTypeReference>invokeAndCast(left, "getImplicitFirstArgumentType");
      LightweightTypeReference _invokeAndCast_5 = this.<LightweightTypeReference>invokeAndCast(left, "getImplicitFirstArgumentType");
      this.assertEqualTypes("implicitFirstArgumentType", _invokeAndCast_4, _invokeAndCast_5);
      Object _invoke_6 = this._reflectExtensions.invoke(left, "getSyntacticReceiver");
      Object _invoke_7 = this._reflectExtensions.invoke(right, "getSyntacticReceiver");
      Assert.assertEquals("syntacticReceiver", _invoke_6, _invoke_7);
      LightweightTypeReference _invokeAndCast_6 = this.<LightweightTypeReference>invokeAndCast(left, "getSyntacticReceiverType");
      LightweightTypeReference _invokeAndCast_7 = this.<LightweightTypeReference>invokeAndCast(left, "getSyntacticReceiverType");
      this.assertEqualTypes("syntacticReceiverType", _invokeAndCast_6, _invokeAndCast_7);
      boolean _isStatic = left.isStatic();
      boolean _isStatic_1 = right.isStatic();
      Assert.assertEquals("isStatic", Boolean.valueOf(_isStatic), Boolean.valueOf(_isStatic_1));
      boolean _isTypeLiteral = left.isTypeLiteral();
      boolean _isTypeLiteral_1 = right.isTypeLiteral();
      Assert.assertEquals("isTypeLiteral", Boolean.valueOf(_isTypeLiteral), Boolean.valueOf(_isTypeLiteral_1));
      Object _invoke_8 = this._reflectExtensions.invoke(left, "getSyntacticReceiver");
      Object _invoke_9 = this._reflectExtensions.invoke(right, "getSyntacticReceiver");
      Assert.assertEquals("syntacticReceiver", _invoke_8, _invoke_9);
      boolean _isExtension = left.isExtension();
      boolean _isExtension_1 = right.isExtension();
      Assert.assertEquals("isExtension", Boolean.valueOf(_isExtension), Boolean.valueOf(_isExtension_1));
      Object _invoke_10 = this._reflectExtensions.invoke(left, "getSyntacticArguments");
      Object _invoke_11 = this._reflectExtensions.invoke(right, "getSyntacticArguments");
      Assert.assertEquals("syntacticArguments", _invoke_10, _invoke_11);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void doAssertEqualLinkingData(final ILinkingCandidate left, final ILinkingCandidate right) {
    try {
      List<LightweightTypeReference> _typeArguments = left.getTypeArguments();
      List<LightweightTypeReference> _typeArguments_1 = right.getTypeArguments();
      this.assertEqualReferences("typeArguments", _typeArguments, _typeArguments_1);
      List<LightweightTypeReference> _invokeAndCast = this.<List<LightweightTypeReference>>invokeAndCast(left, "getSyntacticTypeArguments");
      List<LightweightTypeReference> _invokeAndCast_1 = this.<List<LightweightTypeReference>>invokeAndCast(right, "getSyntacticTypeArguments");
      this.assertEqualReferences("syntacticTypeArguments", _invokeAndCast, _invokeAndCast_1);
      Object _invoke = this._reflectExtensions.invoke(left, "getArguments");
      Object _invoke_1 = this._reflectExtensions.invoke(right, "getArguments");
      Assert.assertEquals("arguments", _invoke, _invoke_1);
      Object _invoke_2 = this._reflectExtensions.invoke(left, "getDeclaredTypeParameters");
      Object _invoke_3 = this._reflectExtensions.invoke(right, "getDeclaredTypeParameters");
      Assert.assertEquals("declaredTypeParameters", _invoke_2, _invoke_3);
      Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _invokeAndCast_2 = this.<Map<JvmTypeParameter, LightweightMergedBoundTypeArgument>>invokeAndCast(left, "getTypeParameterMapping");
      Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _invokeAndCast_3 = this.<Map<JvmTypeParameter, LightweightMergedBoundTypeArgument>>invokeAndCast(right, "getTypeParameterMapping");
      this.assertEqualMapping("typeParameterMapping", _invokeAndCast_2, _invokeAndCast_3);
      Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _invokeAndCast_4 = this.<Map<JvmTypeParameter, LightweightMergedBoundTypeArgument>>invokeAndCast(left, "getDeclaratorParameterMapping");
      Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _invokeAndCast_5 = this.<Map<JvmTypeParameter, LightweightMergedBoundTypeArgument>>invokeAndCast(right, "getDeclaratorParameterMapping");
      this.assertEqualMapping("declaratorParameterMapping", _invokeAndCast_4, _invokeAndCast_5);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertEqualTypes(final String message, final LightweightTypeReference left, final LightweightTypeReference right) {
    String _string = null;
    if (left!=null) {
      _string=left.toString();
    }
    String _string_1 = null;
    if (right!=null) {
      _string_1=right.toString();
    }
    Assert.assertEquals(message, _string, _string_1);
  }
  
  public void assertEqualReferences(final String message, final List<LightweightTypeReference> left, final List<LightweightTypeReference> right) {
    final Function1<LightweightTypeReference, String> _function = (LightweightTypeReference it) -> {
      return it.toString();
    };
    List<String> _map = ListExtensions.<LightweightTypeReference, String>map(left, _function);
    final Function1<LightweightTypeReference, String> _function_1 = (LightweightTypeReference it) -> {
      return it.toString();
    };
    List<String> _map_1 = ListExtensions.<LightweightTypeReference, String>map(right, _function_1);
    Assert.assertEquals(message, _map, _map_1);
  }
  
  public void assertEqualMapping(final String message, final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> left, final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(message, "");
    _builder.append(":");
    _builder.newLineIfNotEmpty();
    String _join = this.mapJoiner.join(left);
    _builder.append(_join, "");
    _builder.newLineIfNotEmpty();
    _builder.append(" \t");
    _builder.newLine();
    _builder.append(" \t");
    _builder.append("vs");
    _builder.newLine();
    _builder.append(" \t");
    _builder.newLine();
    String _join_1 = this.mapJoiner.join(right);
    _builder.append(_join_1, "");
    _builder.newLineIfNotEmpty();
    int _size = left.size();
    int _size_1 = right.size();
    Assert.assertEquals(_builder.toString(), _size, _size_1);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(message, "");
    _builder_1.append(":");
    _builder_1.newLineIfNotEmpty();
    String _join_2 = this.mapJoiner.join(left);
    _builder_1.append(_join_2, "");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append(" \t");
    _builder_1.newLine();
    _builder_1.append(" \t");
    _builder_1.append("vs");
    _builder_1.newLine();
    _builder_1.append(" \t");
    _builder_1.newLine();
    String _join_3 = this.mapJoiner.join(right);
    _builder_1.append(_join_3, "");
    _builder_1.newLineIfNotEmpty();
    Set<JvmTypeParameter> _keySet = left.keySet();
    Set<JvmTypeParameter> _keySet_1 = right.keySet();
    Assert.assertEquals(_builder_1.toString(), ((Object) _keySet), _keySet_1);
    final BiConsumer<JvmTypeParameter, LightweightMergedBoundTypeArgument> _function = (JvmTypeParameter typeParam, LightweightMergedBoundTypeArgument leftData) -> {
      final LightweightMergedBoundTypeArgument rightData = right.get(typeParam);
      VarianceInfo _variance = leftData.getVariance();
      VarianceInfo _variance_1 = rightData.getVariance();
      Assert.assertEquals(_variance, _variance_1);
      LightweightTypeReference _typeReference = leftData.getTypeReference();
      String _simpleName = _typeReference.getSimpleName();
      LightweightTypeReference _typeReference_1 = rightData.getTypeReference();
      String _simpleName_1 = _typeReference_1.getSimpleName();
      Assert.assertEquals(_simpleName, _simpleName_1);
    };
    left.forEach(_function);
  }
  
  public <T extends Object> T invokeAndCast(final ILinkingCandidate receiver, final String getter) {
    try {
      Object _invoke = this._reflectExtensions.invoke(receiver, getter);
      return ((T) _invoke);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertEqualLinkingData(final IApplicableCandidate left, final IApplicableCandidate right) {
    if (left instanceof ImplicitFirstArgument
         && right instanceof ImplicitFirstArgument) {
      _assertEqualLinkingData((ImplicitFirstArgument)left, (ImplicitFirstArgument)right);
      return;
    } else if (left instanceof ImplicitReceiver
         && right instanceof ImplicitReceiver) {
      _assertEqualLinkingData((ImplicitReceiver)left, (ImplicitReceiver)right);
      return;
    } else if (left instanceof ImplicitReceiver
         && right instanceof IFeatureLinkingCandidate) {
      _assertEqualLinkingData((ImplicitReceiver)left, (IFeatureLinkingCandidate)right);
      return;
    } else if (left instanceof ITypeLiteralLinkingCandidate
         && right instanceof ITypeLiteralLinkingCandidate) {
      _assertEqualLinkingData((ITypeLiteralLinkingCandidate)left, (ITypeLiteralLinkingCandidate)right);
      return;
    } else if (left instanceof TypeInsteadOfConstructorLinkingCandidate
         && right instanceof TypeInsteadOfConstructorLinkingCandidate) {
      _assertEqualLinkingData((TypeInsteadOfConstructorLinkingCandidate)left, (TypeInsteadOfConstructorLinkingCandidate)right);
      return;
    } else if (left instanceof TypeInsteadOfConstructorLinkingCandidate
         && right instanceof IConstructorLinkingCandidate) {
      _assertEqualLinkingData((TypeInsteadOfConstructorLinkingCandidate)left, (IConstructorLinkingCandidate)right);
      return;
    } else if (left instanceof ITypeLiteralLinkingCandidate
         && right instanceof ILinkingCandidate) {
      _assertEqualLinkingData((ITypeLiteralLinkingCandidate)left, (ILinkingCandidate)right);
      return;
    } else if (left instanceof IFeatureLinkingCandidate
         && right instanceof ImplicitReceiver) {
      _assertEqualLinkingData((IFeatureLinkingCandidate)left, (ImplicitReceiver)right);
      return;
    } else if (left instanceof IConstructorLinkingCandidate
         && right instanceof TypeInsteadOfConstructorLinkingCandidate) {
      _assertEqualLinkingData((IConstructorLinkingCandidate)left, (TypeInsteadOfConstructorLinkingCandidate)right);
      return;
    } else if (left instanceof IConstructorLinkingCandidate
         && right instanceof IConstructorLinkingCandidate) {
      _assertEqualLinkingData((IConstructorLinkingCandidate)left, (IConstructorLinkingCandidate)right);
      return;
    } else if (left instanceof IFeatureLinkingCandidate
         && right instanceof IFeatureLinkingCandidate) {
      _assertEqualLinkingData((IFeatureLinkingCandidate)left, (IFeatureLinkingCandidate)right);
      return;
    } else if (left instanceof ILinkingCandidate
         && right instanceof ITypeLiteralLinkingCandidate) {
      _assertEqualLinkingData((ILinkingCandidate)left, (ITypeLiteralLinkingCandidate)right);
      return;
    } else if (left instanceof IClosureCandidate
         && right instanceof IClosureCandidate) {
      _assertEqualLinkingData((IClosureCandidate)left, (IClosureCandidate)right);
      return;
    } else if (left != null
         && right != null) {
      _assertEqualLinkingData(left, right);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right).toString());
    }
  }
}
