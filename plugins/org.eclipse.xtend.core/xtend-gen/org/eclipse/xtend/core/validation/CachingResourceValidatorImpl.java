package org.eclipse.xtend.core.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.AnnotationProcessor;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.diagnostics.Severity;
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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
  
  public List<Issue> validate(final Resource resource, final CheckMode mode, final CancelIndicator mon) {
    try {
      final Provider<List<Issue>> _function = new Provider<List<Issue>>() {
        public List<Issue> get() {
          List<Issue> _xblockexpression = null;
          {
            final List<Issue> result = CachingResourceValidatorImpl.super.validate(resource, mode, mon);
            List<Issue> _xifexpression = null;
            boolean _and = false;
            boolean _notEquals = (!Objects.equal(mon, null));
            if (!_notEquals) {
              _and = false;
            } else {
              boolean _isCanceled = mon.isCanceled();
              _and = _isCanceled;
            }
            if (_and) {
              throw new OperationCanceledException();
            } else {
              _xifexpression = result;
            }
            _xblockexpression = _xifexpression;
          }
          return _xblockexpression;
        }
      };
      return this.cache.<List<Issue>>get(mode, resource, _function);
    } catch (final Throwable _t) {
      if (_t instanceof OperationCanceledException) {
        final OperationCanceledException exc = (OperationCanceledException)_t;
        return CollectionLiterals.<Issue>emptyList();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected void collectResourceDiagnostics(final Resource resource, final CancelIndicator monitor, final IAcceptor<Issue> acceptor) {
    this.runActiveAnnotationValidation(resource, monitor);
    this.addWarningsForOrphanedJvmElements(resource, monitor, acceptor);
    super.collectResourceDiagnostics(resource, monitor, acceptor);
  }
  
  private void runActiveAnnotationValidation(final Resource resource, final CancelIndicator monitor) {
    final ActiveAnnotationContexts contexts = ActiveAnnotationContexts.find(resource);
    boolean _tripleEquals = (contexts == null);
    if (_tripleEquals) {
      return;
    }
    try {
      contexts.before(ActiveAnnotationContexts.AnnotationCallback.VALIDATION);
      Map<JvmAnnotationType, ActiveAnnotationContext> _contexts = contexts.getContexts();
      Collection<ActiveAnnotationContext> _values = _contexts.values();
      for (final ActiveAnnotationContext ctx : _values) {
        {
          boolean _isCanceled = monitor.isCanceled();
          if (_isCanceled) {
            return;
          }
          try {
            this.annotationProcessor.validationPhase(ctx, monitor);
          } catch (final Throwable _t) {
            if (_t instanceof Throwable) {
              final Throwable t = (Throwable)_t;
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
    EList<EObject> _contents = resource.getContents();
    Iterable<EObject> _tail = IterableExtensions.<EObject>tail(_contents);
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_tail, JvmDeclaredType.class);
    for (final JvmDeclaredType jvmType : _filter) {
      TreeIterator<EObject> _eAllContents = jvmType.eAllContents();
      Iterator<JvmMember> _filter_1 = Iterators.<JvmMember>filter(_eAllContents, JvmMember.class);
      final Function1<JvmMember, Boolean> _function = new Function1<JvmMember, Boolean>() {
        public Boolean apply(final JvmMember it) {
          boolean _isSynthetic = CachingResourceValidatorImpl.this._jvmTypeExtensions.isSynthetic(it);
          return Boolean.valueOf((!_isSynthetic));
        }
      };
      Iterator<JvmMember> _filter_2 = IteratorExtensions.<JvmMember>filter(_filter_1, _function);
      Iterable<JvmMember> _iterable = IteratorExtensions.<JvmMember>toIterable(_filter_2);
      for (final JvmMember jvmMember : _iterable) {
        {
          boolean _isCanceled = monitor.isCanceled();
          if (_isCanceled) {
            return;
          }
          final EObject sourceElement = this._iJvmModelAssociations.getPrimarySourceElement(jvmMember);
          boolean _tripleEquals = (sourceElement == null);
          if (_tripleEquals) {
            this.addWarningForOrphanedJvmElement(resource, jvmMember, acceptor);
          }
        }
      }
    }
  }
  
  private void addWarningForOrphanedJvmElement(final Resource resource, final JvmMember jvmElement, final IAcceptor<Issue> acceptor) {
    final IssueSeverities issueSeverities = this.issueSeveritiesProvider.getIssueSeverities(resource);
    final Severity severity = issueSeverities.getSeverity(IssueCodes.ORPHAN_ELMENT);
    boolean _equals = Objects.equal(severity, Severity.IGNORE);
    if (_equals) {
      return;
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The generated ");
    String _uiString = this.getUiString(jvmElement);
    _builder.append(_uiString, "");
    _builder.append(" is not associated with a source element. The producing active annotation should use \'setPrimarySourceElement\'.");
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    DiagnosticOnFirstKeyword _diagnosticOnFirstKeyword = new DiagnosticOnFirstKeyword(severity, 
      IssueCodes.ORPHAN_ELMENT, _builder.toString(), _head, 
      null);
    this.issueFromXtextResourceDiagnostic(_diagnosticOnFirstKeyword, severity, acceptor);
  }
  
  private String getUiString(final JvmMember member) {
    String _xblockexpression = null;
    {
      final StringBuilder uiString = new StringBuilder();
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (member instanceof JvmConstructor) {
          _matched=true;
          _switchResult = "constructor";
        }
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
      StringBuilder _append = uiString.append(type);
      StringBuilder _append_1 = _append.append(" \'");
      String _qualifiedName = member.getQualifiedName('.');
      _append_1.append(_qualifiedName);
      if ((member instanceof JvmExecutable)) {
        EList<JvmFormalParameter> _parameters = ((JvmExecutable)member).getParameters();
        final Function1<JvmFormalParameter, String> _function = new Function1<JvmFormalParameter, String>() {
          public String apply(final JvmFormalParameter it) {
            JvmTypeReference _parameterType = it.getParameterType();
            return _parameterType.getSimpleName();
          }
        };
        final String parameterTypes = IterableExtensions.<JvmFormalParameter>join(_parameters, ", ", _function);
        StringBuilder _append_2 = uiString.append("(");
        StringBuilder _append_3 = _append_2.append(parameterTypes);
        _append_3.append(")");
      }
      uiString.append("\'");
      _xblockexpression = uiString.toString();
    }
    return _xblockexpression;
  }
}
