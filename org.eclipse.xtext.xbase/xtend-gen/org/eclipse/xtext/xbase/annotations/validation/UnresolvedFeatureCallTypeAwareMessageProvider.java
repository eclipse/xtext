/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.annotations.validation;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.FeatureLinkHelper;
import org.eclipse.xtext.xbase.typesystem.internal.TypeAwareLinkingDiagnosticContext;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.util.FeatureCallAsTypeLiteralHelper;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class UnresolvedFeatureCallTypeAwareMessageProvider extends LinkingDiagnosticMessageProvider {
  /**
   * A user data entry that indicates a broken feature link which could also be
   * a type literal, e.g. 'String::CASE_INSENSITIVE'.
   */
  public static final String TYPE_LITERAL = "key:TypeLiteral";
  
  public static final String FEATURE_CALL = "key:FeatureCall";
  
  @Inject
  private FeatureCallAsTypeLiteralHelper typeLiteralHelper;
  
  @Inject
  @Extension
  private FeatureLinkHelper _featureLinkHelper;
  
  @Override
  public DiagnosticMessage getUnresolvedProxyMessage(final ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context) {
    String _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = context.getLinkText();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalNodeException) {
        final IllegalNodeException e = (IllegalNodeException)_t;
        _xtrycatchfinallyexpression = e.getNode().getText();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    String linkText = _xtrycatchfinallyexpression;
    if ((linkText == null)) {
      return null;
    }
    EObject contextObject = context.getContext();
    boolean _isStaticMemberCallTarget = this.isStaticMemberCallTarget(contextObject);
    if (_isStaticMemberCallTarget) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(linkText);
      _builder.append(" cannot be resolved to a type.");
      return new DiagnosticMessage(_builder.toString(), Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, 
        UnresolvedFeatureCallTypeAwareMessageProvider.TYPE_LITERAL);
    }
    if ((contextObject instanceof XAbstractFeatureCall)) {
      boolean _isOperation = ((XAbstractFeatureCall)contextObject).isOperation();
      boolean _not = (!_isOperation);
      if (_not) {
        return this.handleUnresolvedFeatureCall(context, ((XAbstractFeatureCall)contextObject), linkText);
      }
    }
    EClass referenceType = context.getReference().getEReferenceType();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(linkText);
    _builder_1.append(" cannot be resolved");
    String _typeName = this.getTypeName(referenceType, context.getReference());
    _builder_1.append(_typeName);
    _builder_1.append(".");
    final String msg = _builder_1.toString();
    return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, linkText);
  }
  
  private DiagnosticMessage handleUnresolvedFeatureCall(final ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context, final XAbstractFeatureCall featureCall, final String linkText) {
    LightweightTypeReference receiverType = null;
    String args = "";
    if ((context instanceof TypeAwareLinkingDiagnosticContext)) {
      final IResolvedTypes types = ((TypeAwareLinkingDiagnosticContext)context).getResolvedTypes();
      XExpression _syntacticReceiver = this._featureLinkHelper.getSyntacticReceiver(featureCall);
      boolean _tripleNotEquals = (_syntacticReceiver != null);
      if (_tripleNotEquals) {
        receiverType = types.getActualType(this._featureLinkHelper.getSyntacticReceiver(featureCall));
      }
      final Function1<XExpression, LightweightTypeReference> _function = (XExpression it) -> {
        return types.getActualType(it);
      };
      final Function1<LightweightTypeReference, CharSequence> _function_1 = (LightweightTypeReference it) -> {
        String _xifexpression = null;
        if (((it == null) || it.isAny())) {
          _xifexpression = "Object";
        } else {
          _xifexpression = it.getHumanReadableName();
        }
        return _xifexpression;
      };
      args = IterableExtensions.<LightweightTypeReference>join(ListExtensions.<XExpression, LightweightTypeReference>map(this._featureLinkHelper.getSyntacticArguments(featureCall), _function), ", ", _function_1);
    }
    boolean _isExplicitOperationCallOrBuilderSyntax = featureCall.isExplicitOperationCallOrBuilderSyntax();
    final boolean orField = (!_isExplicitOperationCallOrBuilderSyntax);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The method ");
    {
      if (orField) {
        _builder.append("or field ");
        _builder.append(linkText);
      } else {
        _builder.append(linkText);
        _builder.append("(");
        _builder.append(args);
        _builder.append(")");
      }
    }
    _builder.append(" is undefined");
    String msg = _builder.toString();
    if ((receiverType != null)) {
      String _msg = msg;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(" ");
      _builder_1.append("for the type ");
      String _humanReadableName = receiverType.getHumanReadableName();
      _builder_1.append(_humanReadableName, " ");
      msg = (_msg + _builder_1);
    }
    if (((((featureCall instanceof XFeatureCall) && (linkText.length() > 0)) && Character.isUpperCase(linkText.charAt(0))) && 
      this.typeLiteralHelper.isPotentialTypeLiteral(featureCall, null))) {
      return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, linkText, UnresolvedFeatureCallTypeAwareMessageProvider.TYPE_LITERAL);
    }
    return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, linkText, UnresolvedFeatureCallTypeAwareMessageProvider.FEATURE_CALL);
  }
  
  protected boolean isStaticMemberCallTarget(final EObject contextObject) {
    boolean candidate = ((contextObject instanceof XFeatureCall) && (contextObject.eContainingFeature() == 
      XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET));
    if (candidate) {
      EObject _eContainer = contextObject.eContainer();
      XMemberFeatureCall memberFeatureCall = ((XMemberFeatureCall) _eContainer);
      boolean _isExplicitStatic = memberFeatureCall.isExplicitStatic();
      if (_isExplicitStatic) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * @Nullable
   */
  protected String getTypeName(final EClass c, final EStructuralFeature referingFeature) {
    if ((referingFeature == XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE)) {
      return " to an annotation type";
    }
    if ((c == TypesPackage.Literals.JVM_ENUMERATION_TYPE)) {
      return " to an enum type";
    }
    boolean _isAssignableFrom = EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_TYPE, c);
    if (_isAssignableFrom) {
      return " to a type";
    }
    if ((c == TypesPackage.Literals.JVM_OPERATION)) {
      return " to an operation";
    }
    return "";
  }
}
