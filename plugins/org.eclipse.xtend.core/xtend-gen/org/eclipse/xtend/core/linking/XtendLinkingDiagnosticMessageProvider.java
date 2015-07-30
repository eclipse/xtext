/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.linking;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.validation.UnresolvedAnnotationTypeAwareMessageProducer;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeAwareLinkingDiagnosticContext;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.util.FeatureCallAsTypeLiteralHelper;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendLinkingDiagnosticMessageProvider extends UnresolvedAnnotationTypeAwareMessageProducer {
  /**
   * A user data entry that indicates a broken feature link which could also be
   * a type literal, e.g. 'String::CASE_INSENSITIVE'.
   */
  public final static String TYPE_LITERAL = "key:TypeLiteral";
  
  @Inject
  private FeatureCallAsTypeLiteralHelper typeLiteralHelper;
  
  @Override
  public DiagnosticMessage getUnresolvedProxyMessage(final ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context) {
    boolean _isPropertyOfUnresolvedAnnotation = this.isPropertyOfUnresolvedAnnotation(context);
    if (_isPropertyOfUnresolvedAnnotation) {
      return null;
    }
    String linkText = "";
    try {
      String _linkText = context.getLinkText();
      linkText = _linkText;
    } catch (final Throwable _t) {
      if (_t instanceof IllegalNodeException) {
        final IllegalNodeException e = (IllegalNodeException)_t;
        INode _node = e.getNode();
        String _text = _node.getText();
        linkText = _text;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
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
        XtendLinkingDiagnosticMessageProvider.TYPE_LITERAL);
    }
    if ((contextObject instanceof XAbstractFeatureCall)) {
      boolean _isOperation = ((XAbstractFeatureCall)contextObject).isOperation();
      boolean _not = (!_isOperation);
      if (_not) {
        XtendTypeDeclaration xtendType = EcoreUtil2.<XtendTypeDeclaration>getContainerOfType(contextObject, XtendTypeDeclaration.class);
        if ((xtendType != null)) {
          String _name = xtendType.getName();
          return this.handleUnresolvedFeatureCall(context, ((XAbstractFeatureCall)contextObject), linkText, _name);
        }
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
  
  private DiagnosticMessage handleUnresolvedFeatureCall(final ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context, final XAbstractFeatureCall featureCall, final String linkText, final String xtendType) {
    String recieverType = xtendType;
    EList<XExpression> explicitArguments = featureCall.getExplicitArguments();
    boolean _or = false;
    int _size = explicitArguments.size();
    boolean _tripleEquals = (_size == 0);
    if (_tripleEquals) {
      _or = true;
    } else {
      _or = (featureCall instanceof XAssignment);
    }
    final boolean orField = _or;
    String args = "";
    if ((context instanceof TypeAwareLinkingDiagnosticContext)) {
      final IResolvedTypes types = ((TypeAwareLinkingDiagnosticContext)context).getResolvedTypes();
      XExpression _actualReceiver = featureCall.getActualReceiver();
      boolean _tripleNotEquals = (_actualReceiver != null);
      if (_tripleNotEquals) {
        XExpression _actualReceiver_1 = featureCall.getActualReceiver();
        LightweightTypeReference type = types.getActualType(_actualReceiver_1);
        if ((type != null)) {
          String _humanReadableName = type.getHumanReadableName();
          recieverType = _humanReadableName;
        }
      }
      EList<XExpression> _actualArguments = featureCall.getActualArguments();
      final Function1<XExpression, LightweightTypeReference> _function = new Function1<XExpression, LightweightTypeReference>() {
        @Override
        public LightweightTypeReference apply(final XExpression it) {
          return types.getActualType(it);
        }
      };
      List<LightweightTypeReference> _map = ListExtensions.<XExpression, LightweightTypeReference>map(_actualArguments, _function);
      final Function1<LightweightTypeReference, CharSequence> _function_1 = new Function1<LightweightTypeReference, CharSequence>() {
        @Override
        public CharSequence apply(final LightweightTypeReference it) {
          String _xifexpression = null;
          boolean _notEquals = (!Objects.equal(it, null));
          if (_notEquals) {
            _xifexpression = it.getHumanReadableName();
          } else {
            _xifexpression = "Object";
          }
          return _xifexpression;
        }
      };
      final String arguments = IterableExtensions.<LightweightTypeReference>join(_map, ", ", _function_1);
      boolean _isEmpty = arguments.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        _builder.append(arguments, "");
        _builder.append(")");
        args = _builder.toString();
      }
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("The method");
    String _xifexpression = null;
    if (orField) {
      _xifexpression = " or field";
    }
    _builder_1.append(_xifexpression, "");
    _builder_1.append(" ");
    _builder_1.append((linkText + args), "");
    _builder_1.append(" is undefined for the type ");
    _builder_1.append(recieverType, "");
    final String msg = _builder_1.toString();
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
      return new DiagnosticMessage(msg, Severity.ERROR, IssueCodes.FEATURECALL_LINKING_DIAGNOSTIC, linkText, XtendLinkingDiagnosticMessageProvider.TYPE_LITERAL);
    }
    return new DiagnosticMessage(msg, Severity.ERROR, IssueCodes.FEATURECALL_LINKING_DIAGNOSTIC, linkText);
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
