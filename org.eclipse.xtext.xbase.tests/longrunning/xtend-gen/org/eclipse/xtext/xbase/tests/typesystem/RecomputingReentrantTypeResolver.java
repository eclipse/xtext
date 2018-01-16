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
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.util.CancelIndicator;
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
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    _builder.append(" \t");
    _builder.newLine();
    _builder.append(" \t");
    _builder.append("vs");
    _builder.newLine();
    _builder.append(" \t");
    _builder.newLine();
    String _join_1 = this.mapJoiner.join(secondRun);
    _builder.append(_join_1);
    _builder.newLineIfNotEmpty();
    Assert.assertEquals(_builder.toString(), firstRun.size(), secondRun.size());
    final Joiner setJoiner = Joiner.on("\n");
    StringConcatenation _builder_1 = new StringConcatenation();
    String _join_2 = setJoiner.join(firstRun.keySet());
    _builder_1.append(_join_2);
    _builder_1.newLineIfNotEmpty();
    _builder_1.append(" \t");
    _builder_1.newLine();
    _builder_1.append(" \t");
    _builder_1.append("vs");
    _builder_1.newLine();
    _builder_1.append(" \t");
    _builder_1.newLine();
    String _join_3 = setJoiner.join(secondRun.keySet());
    _builder_1.append(_join_3);
    _builder_1.newLineIfNotEmpty();
    Assert.assertEquals(_builder_1.toString(), firstRun.keySet(), secondRun.keySet());
    final BiConsumer<XExpression, IApplicableCandidate> _function = (XExpression expression, IApplicableCandidate firstLinkingData) -> {
      final IApplicableCandidate secondLinkingData = secondRun.get(expression);
      this.assertEqualLinkingData(firstLinkingData, secondLinkingData);
      Assert.assertEquals(Boolean.valueOf(firstResult.isRefinedType(expression)), Boolean.valueOf(result.isRefinedType(expression)));
    };
    firstRun.forEach(_function);
    return result;
  }
  
  protected void _assertEqualLinkingData(final IApplicableCandidate left, final IApplicableCandidate right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left);
    _builder.append(" vs ");
    _builder.append(right);
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final IClosureCandidate left, final IClosureCandidate right) {
    Assert.assertEquals("type", left.getParameters().size(), right.getParameters().size());
    final Procedure2<JvmFormalParameter, Integer> _function = (JvmFormalParameter leftParam, Integer idx) -> {
      final JvmFormalParameter rightParam = right.getParameters().get((idx).intValue());
      Assert.assertEquals(leftParam.getName(), rightParam.getName());
      EStructuralFeature _eContainingFeature = leftParam.eContainingFeature();
      boolean _notEquals = (!Objects.equal(_eContainingFeature, XbasePackage.Literals.XCLOSURE__DECLARED_FORMAL_PARAMETERS));
      if (_notEquals) {
        Assert.assertEquals(leftParam.getParameterType().getIdentifier(), rightParam.getParameterType().getIdentifier());
      }
    };
    IterableExtensions.<JvmFormalParameter>forEach(left.getParameters(), _function);
  }
  
  protected void _assertEqualLinkingData(final ITypeLiteralLinkingCandidate left, final ITypeLiteralLinkingCandidate right) {
    Assert.assertEquals("type", left.getType(), right.getType());
    Assert.assertEquals("featureCall", left.getFeatureCall(), right.getFeatureCall());
    this.doAssertEqualLinkingData(left, right);
    Assert.assertEquals("isStatic", Boolean.valueOf(left.isStatic()), Boolean.valueOf(right.isStatic()));
    Assert.assertEquals("isTypeLiteral", Boolean.valueOf(left.isTypeLiteral()), Boolean.valueOf(right.isTypeLiteral()));
    Assert.assertEquals("isExtension", Boolean.valueOf(left.isExtension()), Boolean.valueOf(right.isExtension()));
  }
  
  protected void _assertEqualLinkingData(final ITypeLiteralLinkingCandidate left, final ILinkingCandidate right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left);
    _builder.append(" vs ");
    _builder.append(right);
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final ILinkingCandidate left, final ITypeLiteralLinkingCandidate right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left);
    _builder.append(" vs ");
    _builder.append(right);
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final IConstructorLinkingCandidate left, final IConstructorLinkingCandidate right) {
    Assert.assertEquals("constructor", left.getConstructor(), right.getConstructor());
    Assert.assertEquals("constructorCall", left.getConstructorCall(), right.getConstructorCall());
    this.doAssertEqualLinkingData(left, right);
  }
  
  protected void _assertEqualLinkingData(final TypeInsteadOfConstructorLinkingCandidate left, final IConstructorLinkingCandidate right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left);
    _builder.append(" vs ");
    _builder.append(right);
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final IConstructorLinkingCandidate left, final TypeInsteadOfConstructorLinkingCandidate right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left);
    _builder.append(" vs ");
    _builder.append(right);
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final TypeInsteadOfConstructorLinkingCandidate left, final TypeInsteadOfConstructorLinkingCandidate right) {
    try {
      Assert.assertEquals("feature", left.getFeature(), right.getFeature());
      Assert.assertEquals("constructorCall", left.getConstructorCall(), right.getConstructorCall());
      this.assertEqualReferences("typeArguments", left.getTypeArguments(), right.getTypeArguments());
      this.assertEqualReferences("syntacticTypeArguments", this.<List<LightweightTypeReference>>invokeAndCast(left, "getSyntacticTypeArguments"), this.<List<LightweightTypeReference>>invokeAndCast(right, "getSyntacticTypeArguments"));
      Assert.assertEquals("arguments", this._reflectExtensions.invoke(left, "getArguments"), this._reflectExtensions.invoke(right, "getArguments"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _assertEqualLinkingData(final ImplicitReceiver left, final IFeatureLinkingCandidate right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left);
    _builder.append(" vs ");
    _builder.append(right);
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final IFeatureLinkingCandidate left, final ImplicitReceiver right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(left);
    _builder.append(" vs ");
    _builder.append(right);
    Assert.fail(_builder.toString());
  }
  
  protected void _assertEqualLinkingData(final ImplicitReceiver left, final ImplicitReceiver right) {
    Assert.assertEquals("feature", left.getFeature(), right.getFeature());
    Assert.assertEquals("featureCall", left.getFeatureCall(), right.getFeatureCall());
    this.assertEqualReferences("typeArguments", left.getTypeArguments(), right.getTypeArguments());
  }
  
  protected void _assertEqualLinkingData(final ImplicitFirstArgument left, final ImplicitFirstArgument right) {
    Assert.assertEquals("feature", left.getFeature(), right.getFeature());
    Assert.assertEquals("featureCall", left.getFeatureCall(), right.getFeatureCall());
    this.assertEqualReferences("typeArguments", left.getTypeArguments(), right.getTypeArguments());
  }
  
  protected void _assertEqualLinkingData(final IFeatureLinkingCandidate left, final IFeatureLinkingCandidate right) {
    try {
      Assert.assertEquals("feature", left.getFeature(), right.getFeature());
      Assert.assertEquals("featureCall", left.getFeatureCall(), right.getFeatureCall());
      this.doAssertEqualLinkingData(left, right);
      Assert.assertEquals("receiver", this._reflectExtensions.invoke(left, "getReceiver"), this._reflectExtensions.invoke(right, "getReceiver"));
      this.assertEqualTypes("receiverType", this.<LightweightTypeReference>invokeAndCast(left, "getReceiverType"), this.<LightweightTypeReference>invokeAndCast(left, "getReceiverType"));
      Assert.assertEquals("implicitReceiver", this._reflectExtensions.invoke(left, "getImplicitReceiver"), this._reflectExtensions.invoke(right, "getImplicitReceiver"));
      this.assertEqualTypes("implicitReceiverType", this.<LightweightTypeReference>invokeAndCast(left, "getImplicitReceiverType"), this.<LightweightTypeReference>invokeAndCast(left, "getImplicitReceiverType"));
      Assert.assertEquals("implicitFirstArgument", this._reflectExtensions.invoke(left, "getImplicitFirstArgument"), this._reflectExtensions.invoke(right, "getImplicitFirstArgument"));
      this.assertEqualTypes("implicitFirstArgumentType", this.<LightweightTypeReference>invokeAndCast(left, "getImplicitFirstArgumentType"), this.<LightweightTypeReference>invokeAndCast(left, "getImplicitFirstArgumentType"));
      Assert.assertEquals("syntacticReceiver", this._reflectExtensions.invoke(left, "getSyntacticReceiver"), this._reflectExtensions.invoke(right, "getSyntacticReceiver"));
      this.assertEqualTypes("syntacticReceiverType", this.<LightweightTypeReference>invokeAndCast(left, "getSyntacticReceiverType"), this.<LightweightTypeReference>invokeAndCast(left, "getSyntacticReceiverType"));
      Assert.assertEquals("isStatic", Boolean.valueOf(left.isStatic()), Boolean.valueOf(right.isStatic()));
      Assert.assertEquals("isTypeLiteral", Boolean.valueOf(left.isTypeLiteral()), Boolean.valueOf(right.isTypeLiteral()));
      Assert.assertEquals("syntacticReceiver", this._reflectExtensions.invoke(left, "getSyntacticReceiver"), this._reflectExtensions.invoke(right, "getSyntacticReceiver"));
      Assert.assertEquals("isExtension", Boolean.valueOf(left.isExtension()), Boolean.valueOf(right.isExtension()));
      Assert.assertEquals("syntacticArguments", this._reflectExtensions.invoke(left, "getSyntacticArguments"), this._reflectExtensions.invoke(right, "getSyntacticArguments"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void doAssertEqualLinkingData(final ILinkingCandidate left, final ILinkingCandidate right) {
    try {
      this.assertEqualReferences("typeArguments", left.getTypeArguments(), right.getTypeArguments());
      this.assertEqualReferences("syntacticTypeArguments", this.<List<LightweightTypeReference>>invokeAndCast(left, "getSyntacticTypeArguments"), this.<List<LightweightTypeReference>>invokeAndCast(right, "getSyntacticTypeArguments"));
      Assert.assertEquals("arguments", this._reflectExtensions.invoke(left, "getArguments"), this._reflectExtensions.invoke(right, "getArguments"));
      Assert.assertEquals("declaredTypeParameters", this._reflectExtensions.invoke(left, "getDeclaredTypeParameters"), this._reflectExtensions.invoke(right, "getDeclaredTypeParameters"));
      this.assertEqualMapping("typeParameterMapping", this.<Map<JvmTypeParameter, LightweightMergedBoundTypeArgument>>invokeAndCast(left, "getTypeParameterMapping"), this.<Map<JvmTypeParameter, LightweightMergedBoundTypeArgument>>invokeAndCast(right, "getTypeParameterMapping"));
      this.assertEqualMapping("declaratorParameterMapping", this.<Map<JvmTypeParameter, LightweightMergedBoundTypeArgument>>invokeAndCast(left, "getDeclaratorParameterMapping"), this.<Map<JvmTypeParameter, LightweightMergedBoundTypeArgument>>invokeAndCast(right, "getDeclaratorParameterMapping"));
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
    final Function1<LightweightTypeReference, String> _function_1 = (LightweightTypeReference it) -> {
      return it.toString();
    };
    Assert.assertEquals(message, ListExtensions.<LightweightTypeReference, String>map(left, _function), ListExtensions.<LightweightTypeReference, String>map(right, _function_1));
  }
  
  public void assertEqualMapping(final String message, final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> left, final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> right) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(message);
    _builder.append(":");
    _builder.newLineIfNotEmpty();
    String _join = this.mapJoiner.join(left);
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    _builder.append(" \t");
    _builder.newLine();
    _builder.append(" \t");
    _builder.append("vs");
    _builder.newLine();
    _builder.append(" \t");
    _builder.newLine();
    String _join_1 = this.mapJoiner.join(right);
    _builder.append(_join_1);
    _builder.newLineIfNotEmpty();
    Assert.assertEquals(_builder.toString(), left.size(), right.size());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(message);
    _builder_1.append(":");
    _builder_1.newLineIfNotEmpty();
    String _join_2 = this.mapJoiner.join(left);
    _builder_1.append(_join_2);
    _builder_1.newLineIfNotEmpty();
    _builder_1.append(" \t");
    _builder_1.newLine();
    _builder_1.append(" \t");
    _builder_1.append("vs");
    _builder_1.newLine();
    _builder_1.append(" \t");
    _builder_1.newLine();
    String _join_3 = this.mapJoiner.join(right);
    _builder_1.append(_join_3);
    _builder_1.newLineIfNotEmpty();
    Set<JvmTypeParameter> _keySet = left.keySet();
    Assert.assertEquals(_builder_1.toString(), ((Object) _keySet), right.keySet());
    final BiConsumer<JvmTypeParameter, LightweightMergedBoundTypeArgument> _function = (JvmTypeParameter typeParam, LightweightMergedBoundTypeArgument leftData) -> {
      final LightweightMergedBoundTypeArgument rightData = right.get(typeParam);
      Assert.assertEquals(leftData.getVariance(), rightData.getVariance());
      Assert.assertEquals(leftData.getTypeReference().getSimpleName(), rightData.getTypeReference().getSimpleName());
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
