package org.eclipse.xtext.java.resource;

import com.google.common.base.Objects;
import com.google.common.io.CharStreams;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.IJavaSchemeUriResolver;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.java.resource.JavaDerivedStateComputer;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class JavaResource extends ResourceImpl implements IJavaSchemeUriResolver, ISynchronizable<JavaResource> {
  public static class Factory implements Resource.Factory {
    @Inject
    private Provider<JavaResource> resourceProvider;
    
    @Override
    public Resource createResource(final URI uri) {
      JavaResource _get = this.resourceProvider.get();
      final Procedure1<JavaResource> _function = (JavaResource it) -> {
        it.setURI(uri);
      };
      return ObjectExtensions.<JavaResource>operator_doubleArrow(_get, _function);
    }
  }
  
  public final static String OPTION_ENCODING = (JavaResource.class.getName() + ".DEFAULT_ENCODING");
  
  @Inject
  private IEncodingProvider encodingProvider;
  
  @Inject
  private JavaDerivedStateComputer derivedStateComputer;
  
  private CompilationUnit compilationUnit;
  
  @Override
  protected void doLoad(final InputStream inputStream, final Map<?, ?> options) throws IOException {
    URI _uRI = this.getURI();
    final String encoding = this.getEncoding(_uRI, options);
    InputStreamReader _inputStreamReader = new InputStreamReader(inputStream, encoding);
    final String contentsAsString = CharStreams.toString(_inputStreamReader);
    char[] _charArray = contentsAsString.toCharArray();
    URI _uRI_1 = this.getURI();
    String _lastSegment = _uRI_1.lastSegment();
    CompilationUnit _compilationUnit = new CompilationUnit(_charArray, _lastSegment, encoding);
    this.compilationUnit = _compilationUnit;
  }
  
  protected String getEncoding(final URI uri, final Map<?, ?> options) {
    boolean _notEquals = (!Objects.equal(options, null));
    if (_notEquals) {
      final Object encodingOption = options.get(JavaResource.OPTION_ENCODING);
      if ((encodingOption instanceof String)) {
        return ((String)encodingOption);
      }
    }
    return this.encodingProvider.getEncoding(uri);
  }
  
  protected CompilationUnit getCompilationUnit() {
    return this.compilationUnit;
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private boolean initialized = false;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private boolean initializing = false;
  
  @Override
  public EList<EObject> getContents() {
    EList<EObject> _xsynchronizedexpression = null;
    synchronized (this.getLock()) {
      EList<EObject> _xblockexpression = null;
      {
        if ((((this.isLoaded && (!this.isLoading)) && (!this.initializing)) && (!this.initialized))) {
          try {
            this.eSetDeliver(false);
            this.installFull();
          } finally {
            this.eSetDeliver(true);
          }
        }
        _xblockexpression = super.getContents();
      }
      _xsynchronizedexpression = _xblockexpression;
    }
    return _xsynchronizedexpression;
  }
  
  public void installStubs() {
    final Procedure0 _function = () -> {
      this.derivedStateComputer.installStubs(this);
      this.initialized = true;
    };
    this.initializing(_function);
  }
  
  public void installFull() {
    final Procedure0 _function = () -> {
      this.derivedStateComputer.installFull(this);
      this.initialized = true;
    };
    this.initializing(_function);
  }
  
  private void initializing(final Procedure0 init) {
    try {
      this.initializing = true;
      init.apply();
    } finally {
      this.initializing = false;
    }
  }
  
  public void discardDerivedState() {
    final Procedure0 _function = () -> {
      this.derivedStateComputer.discardDerivedState(this);
      this.initialized = false;
    };
    this.initializing(_function);
  }
  
  @Override
  public EObject resolveJavaObjectURIProxy(final InternalEObject proxy, final JvmTypeReference sender) {
    final IndexedJvmTypeAccess access = this.getIndexJvmTypeAccess();
    boolean _notEquals = (!Objects.equal(access, null));
    if (_notEquals) {
      try {
        URI _eProxyURI = proxy.eProxyURI();
        ResourceSet _resourceSet = this.getResourceSet();
        final EObject result = access.getIndexedJvmType(_eProxyURI, _resourceSet);
        boolean _notEquals_1 = (!Objects.equal(result, null));
        if (_notEquals_1) {
          return result;
        }
      } catch (final Throwable _t) {
        if (_t instanceof IndexedJvmTypeAccess.UnknownNestedTypeException) {
          final IndexedJvmTypeAccess.UnknownNestedTypeException e = (IndexedJvmTypeAccess.UnknownNestedTypeException)_t;
          return proxy;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return EcoreUtil.resolve(proxy, sender);
  }
  
  private IndexedJvmTypeAccess _access;
  
  public IndexedJvmTypeAccess getIndexJvmTypeAccess() {
    boolean _equals = Objects.equal(this._access, null);
    if (_equals) {
      Resource.Factory.Registry _resourceFactoryRegistry = this.resourceSet.getResourceFactoryRegistry();
      Map<String, Object> _protocolToFactoryMap = _resourceFactoryRegistry.getProtocolToFactoryMap();
      final Object provider = _protocolToFactoryMap.get(URIHelperConstants.PROTOCOL);
      if ((provider instanceof AbstractJvmTypeProvider)) {
        IndexedJvmTypeAccess _indexedJvmTypeAccess = ((AbstractJvmTypeProvider)provider).getIndexedJvmTypeAccess();
        this._access = _indexedJvmTypeAccess;
      }
    }
    return this._access;
  }
  
  /**
   * Returns the lock of the owning {@link ResourceSet}, if it exposes such a lock.
   * Otherwise this resource itself is used as the lock context.
   */
  @Override
  public Object getLock() {
    ResourceSet resourceSet = this.getResourceSet();
    if ((resourceSet instanceof ISynchronizable<?>)) {
      return ((ISynchronizable<?>) resourceSet).getLock();
    }
    return this;
  }
  
  @Override
  public <Result extends Object> Result execute(final IUnitOfWork<Result, ? super JavaResource> unit) throws Exception {
    synchronized (this.getLock()) {
      return unit.exec(this);
    }
  }
  
  private final IFragmentProvider.Fallback fallback = new IFragmentProvider.Fallback() {
    @Override
    public EObject getEObject(final String fragment) {
      return JavaResource.super.getEObjectByID(fragment);
    }
    
    @Override
    public String getFragment(final EObject obj) {
      return JavaResource.super.getURIFragment(obj);
    }
  };
  
  private final AbstractClassMirror m = new AbstractClassMirror() {
    @Override
    protected String getTypeName() {
      throw new UnsupportedOperationException("TODO: auto-generated method stub");
    }
    
    @Override
    protected String getTypeName(final JvmType type) {
      return type.getIdentifier();
    }
    
    @Override
    public void initialize(final TypeResource typeResource) {
      throw new UnsupportedOperationException("TODO: auto-generated method stub");
    }
    
    @Override
    public boolean isSealed() {
      throw new UnsupportedOperationException("TODO: auto-generated method stub");
    }
  };
  
  @Override
  protected EObject getEObjectByID(final String id) {
    return this.m.getEObject(this, id, this.fallback);
  }
  
  @Override
  public String getURIFragment(final EObject eObject) {
    return this.m.getFragment(eObject, this.fallback);
  }
  
  @Pure
  public boolean isInitialized() {
    return this.initialized;
  }
  
  @Pure
  public boolean isInitializing() {
    return this.initializing;
  }
}
