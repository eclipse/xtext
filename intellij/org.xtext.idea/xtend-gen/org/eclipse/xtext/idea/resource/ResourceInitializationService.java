package org.eclipse.xtext.idea.resource;

import com.google.inject.Singleton;
import com.intellij.openapi.util.Key;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;

@Singleton
@SuppressWarnings("all")
public class ResourceInitializationService {
  public final static Key<Boolean> ENSURE_INITIALIZED = Key.<Boolean>create("ENSURE_INITIALIZED");
  
  public Resource ensureFullyInitialized(final Resource resource) {
    try {
      Resource _xtrycatchfinallyexpression = null;
      try {
        Resource _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (resource instanceof DerivedStateAwareResource) {
            _matched=true;
            Resource _xifexpression = null;
            if ((resource instanceof ISynchronizable<?>)) {
              final IUnitOfWork<Resource, Object> _function = new IUnitOfWork<Resource, Object>() {
                public Resource exec(final Object it) throws Exception {
                  return ResourceInitializationService.this.doEnsureFullyInitialized(((DerivedStateAwareResource)resource));
                }
              };
              _xifexpression = ((ISynchronizable<?>)resource).<Resource>execute(_function);
            } else {
              _xifexpression = this.doEnsureFullyInitialized(((DerivedStateAwareResource)resource));
            }
            _switchResult = _xifexpression;
          }
        }
        if (!_matched) {
          _switchResult = resource;
        }
        _xtrycatchfinallyexpression = _switchResult;
      } catch (final Throwable _t) {
        if (_t instanceof OperationCanceledError) {
          final OperationCanceledError e = (OperationCanceledError)_t;
          throw e.getWrapped();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return _xtrycatchfinallyexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Resource doEnsureFullyInitialized(final DerivedStateAwareResource context) {
    DerivedStateAwareResource _xblockexpression = null;
    {
      final boolean deliver = context.eDeliver();
      try {
        context.eSetDeliver(false);
        context.installDerivedState(false);
      } finally {
        context.eSetDeliver(deliver);
      }
      _xblockexpression = context;
    }
    return _xblockexpression;
  }
}
