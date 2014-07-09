package org.eclipse.xtend.core.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.AnnotationProcessor;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.annotations.validation.DerivedStateAwareResourceValidator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class CachingResourceValidatorImpl extends DerivedStateAwareResourceValidator {
  @Inject
  private OnChangeEvictingCache cache;
  
  @Inject
  private AnnotationProcessor annotationProcessor;
  
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
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    for (final Resource.Diagnostic error : _errors) {
      {
        boolean _isCanceled = monitor.isCanceled();
        if (_isCanceled) {
          return;
        }
        this.issueFromXtextResourceDiagnostic(error, Severity.ERROR, acceptor);
      }
    }
    EList<Resource.Diagnostic> _warnings = resource.getWarnings();
    for (final Resource.Diagnostic warning : _warnings) {
      {
        boolean _isCanceled = monitor.isCanceled();
        if (_isCanceled) {
          return;
        }
        this.issueFromXtextResourceDiagnostic(warning, Severity.WARNING, acceptor);
      }
    }
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
}
