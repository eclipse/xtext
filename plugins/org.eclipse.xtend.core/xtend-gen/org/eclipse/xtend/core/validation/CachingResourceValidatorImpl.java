package org.eclipse.xtend.core.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class CachingResourceValidatorImpl extends ResourceValidatorImpl {
  @Inject
  private OnChangeEvictingCache cache;
  
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
  
  protected void validate(final Resource resource, final CheckMode mode, final CancelIndicator monitor, final IAcceptor<Issue> acceptor) {
    boolean _isCanceled = monitor.isCanceled();
    if (_isCanceled) {
      return;
    }
    EList<EObject> _contents = resource.getContents();
    final EObject head = IterableExtensions.<EObject>head(_contents);
    boolean _notEquals = (!Objects.equal(head, null));
    if (_notEquals) {
      this.validate(resource, head, mode, monitor, acceptor);
    }
  }
}
