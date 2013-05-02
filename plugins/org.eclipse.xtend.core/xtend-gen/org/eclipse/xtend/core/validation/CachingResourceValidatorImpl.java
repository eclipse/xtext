package org.eclipse.xtend.core.validation;

import com.google.inject.Provider;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;

@SuppressWarnings("all")
public class CachingResourceValidatorImpl extends ResourceValidatorImpl {
  @Inject
  private OnChangeEvictingCache cache;
  
  public List<Issue> validate(final Resource resource, final CheckMode mode, final CancelIndicator mon) {
    try {
      final Provider<List<Issue>> _function = new Provider<List<Issue>>() {
          public List<Issue> get() {
            List<Issue> _validate = CachingResourceValidatorImpl.super.validate(resource, mode, mon);
            return _validate;
          }
        };
      return this.cache.<List<Issue>>get(resource, resource, _function);
    } finally {
      boolean _isCanceled = mon.isCanceled();
      if (_isCanceled) {
        this.cache.clear(resource);
      }
    }
  }
}
