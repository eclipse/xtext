/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.annotations.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.xtext.nodemodel.INode;
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
public class LinkingDiagnosticTypeAwareMessageProducer extends LinkingDiagnosticMessageProvider {
  /**
   * A user data entry that indicates a broken feature link which could also be
   * a type literal, e.g. 'String::CASE_INSENSITIVE'.
   */
  public final static String TYPE_LITERAL = "key:TypeLiteral";
  
  public final static String FEATURE_CALL = "key:FeatureCall";
  
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
        INode _node = e.getNode();
        _xtrycatchfinallyexpression = _node.getText();
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
      _builder.append(linkText, "");
      _builder.append(" cannot be resolved to a type.");
      return new DiagnosticMessage(_builder.toString(), Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, 
        LinkingDiagnosticTypeAwareMessageProducer.TYPE_LITERAL);
    }
    if ((contextObject instanceof XAbstractFeatureCall)) {
      boolean _isOperation = ((XAbstractFeatureCall)contextObject).isOperation();
      boolean _not = (!_isOperation);
      if (_not) {
        return this.handleUnresolvedFeatureCall(context, ((XAbstractFeatureCall)contextObject), linkText);
      }
    }
    EReference _reference = context.getReference();
    EClass referenceType = _reference.getEReferenceType();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(linkText, "");
    _builder_1.append(" cannot be resolved");
    EReference _reference_1 = context.getReference();
    String _typeName = this.getTypeName(referenceType, _reference_1);
    _builder_1.append(_typeName, "");
    _builder_1.append(".");
    final String msg = _builder_1.toString();
    return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, linkText);
  }
  
  private DiagnosticMessage handleUnresolvedFeatureCall(final ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context, final XAbstractFeatureCall featureCall, final String linkText) {
    LightweightTypeReference recieverType = null;
    String args = "";
    if ((context instanceof TypeAwareLinkingDiagnosticContext)) {
      final IResolvedTypes types = ((TypeAwareLinkingDiagnosticContext)context).getResolvedTypes();
      XExpression _syntacticReceiver = this._featureLinkHelper.getSyntacticReceiver(featureCall);
      boolean _tripleNotEquals = (_syntacticReceiver != null);
      if (_tripleNotEquals) {
        XExpression _syntacticReceiver_1 = this._featureLinkHelper.getSyntacticReceiver(featureCall);
        LightweightTypeReference _actualType = types.getActualType(_syntacticReceiver_1);
        recieverType = _actualType;
      }
      List<XExpression> _syntacticArguments = this._featureLinkHelper.getSyntacticArguments(featureCall);
      final Function1<XExpression, LightweightTypeReference> _function = new Function1<XExpression, LightweightTypeReference>() {
        @Override
        public LightweightTypeReference apply(final XExpression it) {
          return types.getActualType(it);
        }
      };
      List<LightweightTypeReference> _map = ListExtensions.<XExpression, LightweightTypeReference>map(_syntacticArguments, _function);
      final Function1<LightweightTypeReference, CharSequence> _function_1 = new Function1<LightweightTypeReference, CharSequence>() {
        @Override
        public CharSequence apply(final LightweightTypeReference it) {
          String _xifexpression = null;
          boolean _or = false;
          if ((it == null)) {
            _or = true;
          } else {
            boolean _isAny = it.isAny();
            _or = _isAny;
          }
          if (_or) {
            _xifexpression = "Object";
          } else {
            _xifexpression = it.getHumanReadableName();
          }
          return _xifexpression;
        }
      };
      String _join = IterableExtensions.<LightweightTypeReference>join(_map, ", ", _function_1);
      args = _join;
    }
    boolean _isExplicitOperationCallOrBuilderSyntax = featureCall.isExplicitOperationCallOrBuilderSyntax();
    final boolean orField = (!_isExplicitOperationCallOrBuilderSyntax);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The method ");
    {
      if (orField) {
        _builder.append("or field ");
        _builder.append(linkText, "");
      } else {
        _builder.append(linkText, "");
        _builder.append("(");
        _builder.append(args, "");
        _builder.append(")");
      }
    }
    _builder.append(" is undefined");
    String msg = _builder.toString();
    boolean _notEquals = (!Objects.equal(recieverType, null));
    if (_notEquals) {
      String _msg = msg;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(" ");
      _builder_1.append("for the type ");
      String _humanReadableName = recieverType.getHumanReadableName();
      _builder_1.append(_humanReadableName, " ");
      msg = (_msg + _builder_1);
    }
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    if (!(featureCall instanceof XFeatureCall)) {
      _and_2 = false;
    } else {
      int _length = linkText.length();
      boolean _greaterThan = (_length > 0);
      _and_2 = _greaterThan;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      char _charAt = linkText.charAt(0);
      boolean _isUpperCase = Character.isUpperCase(_charAt);
      _and_1 = _isUpperCase;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _isPotentialTypeLiteral = this.typeLiteralHelper.isPotentialTypeLiteral(featureCall, null);
      _and = _isPotentialTypeLiteral;
    }
    if (_and) {
      return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, linkText, LinkingDiagnosticTypeAwareMessageProducer.TYPE_LITERAL);
    }
    return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, linkText, LinkingDiagnosticTypeAwareMessageProducer.FEATURE_CALL);
  }
  
  protected boolean isStaticMemberCallTarget(final EObject contextObject) {
    boolean _and = false;
    if (!(contextObject instanceof XFeatureCall)) {
      _and = false;
    } else {
      EStructuralFeature _eContainingFeature = contextObject.eContainingFeature();
      boolean _tripleEquals = (_eContainingFeature == 
        XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET);
      _and = _tripleEquals;
    }
    boolean candidate = _and;
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
