/**
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.AnnotationProcessor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.IssueSeverities;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;
import org.eclipse.xtext.xbase.annotations.validation.DerivedStateAwareResourceValidator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.typesystem.computation.DiagnosticOnFirstKeyword;

@SuppressWarnings("all")
public class CachingResourceValidatorImpl extends DerivedStateAwareResourceValidator {
  @Inject
  private OnChangeEvictingCache cache;

  @Inject
  private AnnotationProcessor annotationProcessor;

  @Inject
  private IssueSeveritiesProvider issueSeveritiesProvider;

  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;

  @Inject
  @Extension
  private JvmTypeExtensions _jvmTypeExtensions;

  @Inject
  private OperationCanceledManager operationCanceledManager;

  @Override
  public List<Issue> validate(final Resource resource, final CheckMode mode, final CancelIndicator mon) throws OperationCanceledError {
    final Provider<List<Issue>> _function = () -> {
      this.operationCanceledManager.checkCanceled(mon);
      return super.validate(resource, mode, mon);
    };
    return this.cache.<List<Issue>>get(mode, resource, _function);
  }

  @Override
  protected void collectResourceDiagnostics(final Resource resource, final CancelIndicator monitor, final IAcceptor<Issue> acceptor) {
    this.runActiveAnnotationValidation(resource, monitor);
    this.addWarningsForOrphanedJvmElements(resource, monitor, acceptor);
    super.collectResourceDiagnostics(resource, monitor, acceptor);
  }

  private void runActiveAnnotationValidation(final Resource resource, final CancelIndicator monitor) {
    final ActiveAnnotationContexts contexts = ActiveAnnotationContexts.find(resource);
    if ((contexts == null)) {
      return;
    }
    try {
      contexts.before(ActiveAnnotationContexts.AnnotationCallback.VALIDATION);
      Collection<ActiveAnnotationContext> _values = contexts.getContexts().values();
      for (final ActiveAnnotationContext ctx : _values) {
        {
          this.operationCanceledManager.checkCanceled(monitor);
          try {
            this.annotationProcessor.validationPhase(ctx, monitor);
          } catch (final Throwable _t) {
            if (_t instanceof Throwable) {
              final Throwable t = (Throwable)_t;
              this.operationCanceledManager.propagateAsErrorIfCancelException(t);
              ctx.handleProcessingError(resource, t);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
    } finally {
      contexts.after(ActiveAnnotationContexts.AnnotationCallback.VALIDATION);
    }
  }

  private void addWarningsForOrphanedJvmElements(final Resource resource, final CancelIndicator monitor, final IAcceptor<Issue> acceptor) {
    final IssueSeverities issueSeverities = this.issueSeveritiesProvider.getIssueSeverities(resource);
    final Severity severity = issueSeverities.getSeverity(IssueCodes.ORPHAN_ELEMENT);
    boolean _equals = Objects.equal(severity, Severity.IGNORE);
    if (_equals) {
      return;
    }
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(IterableExtensions.<EObject>tail(resource.getContents()), JvmDeclaredType.class);
    for (final JvmDeclaredType jvmType : _filter) {
      final Function1<JvmMember, Boolean> _function = (JvmMember it) -> {
        boolean _isSynthetic = this._jvmTypeExtensions.isSynthetic(it);
        return Boolean.valueOf((!_isSynthetic));
      };
      Iterable<JvmMember> _iterable = IteratorExtensions.<JvmMember>toIterable(IteratorExtensions.<JvmMember>filter(Iterators.<JvmMember>filter(jvmType.eAllContents(), JvmMember.class), _function));
      for (final JvmMember jvmMember : _iterable) {
        {
          this.operationCanceledManager.checkCanceled(monitor);
          final EObject sourceElement = this._iJvmModelAssociations.getPrimarySourceElement(jvmMember);
          if ((sourceElement == null)) {
            this.addWarningForOrphanedJvmElement(resource, jvmMember, severity, acceptor);
          }
        }
      }
    }
  }

  private void addWarningForOrphanedJvmElement(final Resource resource, final JvmMember jvmElement, final Severity severity, final IAcceptor<Issue> acceptor) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The generated ");
    String _uiString = this.getUiString(jvmElement);
    _builder.append(_uiString);
    _builder.append(" is not associated with a source element. The producing active annotation should use \'setPrimarySourceElement\'.");
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    this.issueFromXtextResourceDiagnostic(new DiagnosticOnFirstKeyword(severity, 
      IssueCodes.ORPHAN_ELEMENT, _builder.toString(), _head, 
      null), severity, acceptor);
  }

  private String getUiString(final JvmMember member) {
    String _xblockexpression = null;
    {
      final StringBuilder uiString = new StringBuilder();
      String _switchResult = null;
      boolean _matched = false;
      if (member instanceof JvmConstructor) {
        _matched=true;
        _switchResult = "constructor";
      }
      if (!_matched) {
        if (member instanceof JvmField) {
          _matched=true;
          _switchResult = "field";
        }
      }
      if (!_matched) {
        if (member instanceof JvmOperation) {
          _matched=true;
          _switchResult = "method";
        }
      }
      if (!_matched) {
        if (member instanceof JvmDeclaredType) {
          _matched=true;
          _switchResult = "type";
        }
      }
      final String type = _switchResult;
      uiString.append(type).append(" \'").append(member.getQualifiedName('.'));
      if ((member instanceof JvmExecutable)) {
        final Function1<JvmFormalParameter, CharSequence> _function = (JvmFormalParameter it) -> {
          return it.getParameterType().getSimpleName();
        };
        final String parameterTypes = IterableExtensions.<JvmFormalParameter>join(((JvmExecutable)member).getParameters(), ", ", _function);
        uiString.append("(").append(parameterTypes).append(")");
      }
      uiString.append("\'");
      _xblockexpression = uiString.toString();
    }
    return _xblockexpression;
  }
}
