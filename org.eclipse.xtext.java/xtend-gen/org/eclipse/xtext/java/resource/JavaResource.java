package org.eclipse.xtext.java.resource;

import com.google.common.base.Objects;
import com.google.common.io.CharStreams;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
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
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
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
  
  public static class JavaElementFragment {
    private URI uri;
    
    private int idx;
    
    public JavaElementFragment(final URI uri) {
      this.uri = uri;
      this.idx = this.getMethodPartOffset(uri.fragment());
    }
    
    /**
     * @return URI pointing to a type, which is the conatiner type in case of a fragment pointing to a method.
     */
    public URI getTypeURI() {
      if ((this.idx == (-1))) {
        return this.uri;
      } else {
        final String f = this.uri.fragment();
        return this.uri.appendFragment(f.substring(0, this.idx));
      }
    }
    
    public boolean isMethodFragment() {
      return (this.idx != (-1));
    }
    
    protected int getMethodPartOffset(final String string) {
      boolean _endsWith = string.endsWith("()");
      if (_endsWith) {
        return string.lastIndexOf(".");
      }
      return (-1);
    }
  }
  
  public static class JavaFragmentProvider extends AbstractClassMirror {
    @Override
    protected String getTypeName() {
      throw new UnsupportedOperationException("not supported");
    }
    
    @Override
    protected String getTypeName(final JvmType type) {
      return type.getQualifiedName('$');
    }
    
    @Override
    public void initialize(final TypeResource typeResource) {
      throw new UnsupportedOperationException("not supported");
    }
    
    @Override
    public boolean isSealed() {
      return true;
    }
  }
  
  public final static String OPTION_ENCODING = (JavaResource.class.getName() + ".DEFAULT_ENCODING");
  
  @Inject
  private IEncodingProvider encodingProvider;
  
  @Inject
  private JavaDerivedStateComputer derivedStateComputer;
  
  private CompilationUnit compilationUnit;
  
  private String contentsAsString;
  
  @Override
  protected void doLoad(final InputStream inputStream, final Map<?, ?> options) throws IOException {
    final String encoding = this.getEncoding(this.getURI(), options);
    InputStreamReader _inputStreamReader = new InputStreamReader(inputStream, encoding);
    final String contentsAsString = CharStreams.toString(_inputStreamReader);
    this.contentsAsString = contentsAsString;
    char[] _charArray = contentsAsString.toCharArray();
    String _lastSegment = this.getURI().lastSegment();
    CompilationUnit _compilationUnit = new CompilationUnit(_charArray, _lastSegment, encoding, null);
    this.compilationUnit = _compilationUnit;
  }
  
  protected String getEncoding(final URI uri, final Map<?, ?> options) {
    if ((options != null)) {
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
  
  @Override
  protected List<EObject> getUnloadingContents() {
    return super.getContents();
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
      this.compilationUnit = null;
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
  public EObject resolveJavaObjectURIProxy(final InternalEObject proxy, final EObject sender) {
    final URI proxyURI = proxy.eProxyURI();
    if (((proxyURI != null) && Objects.equal(URIHelperConstants.PROTOCOL, proxyURI.scheme()))) {
      boolean _equals = "Objects".equals(proxyURI.segment(0));
      if (_equals) {
        final IndexedJvmTypeAccess access = this.getIndexJvmTypeAccess();
        if ((access != null)) {
          try {
            URI _eProxyURI = proxy.eProxyURI();
            final JavaResource.JavaElementFragment frag = new JavaResource.JavaElementFragment(_eProxyURI);
            EObject result = access.getIndexedJvmType(frag.getTypeURI(), this.getResourceSet());
            if (((result instanceof JvmDeclaredType) && frag.isMethodFragment())) {
              JavaResource.JavaFragmentProvider _javaFragmentProvider = new JavaResource.JavaFragmentProvider();
              Resource _eResource = result.eResource();
              String _fragment = proxy.eProxyURI().fragment();
              result = _javaFragmentProvider.getEObject(_eResource, _fragment, new IFragmentProvider.Fallback() {
                @Override
                public EObject getEObject(final String fragment) {
                  return null;
                }
                
                @Override
                public String getFragment(final EObject obj) {
                  return null;
                }
              });
            }
            if ((result != null)) {
              return result;
            }
          } catch (final Throwable _t) {
            if (_t instanceof IndexedJvmTypeAccess.UnknownNestedTypeException) {
              return proxy;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
        return EcoreUtil.resolve(proxy, sender);
      }
    }
    return null;
  }
  
  private IndexedJvmTypeAccess _access;
  
  public IndexedJvmTypeAccess getIndexJvmTypeAccess() {
    if ((this._access == null)) {
      final Object provider = this.resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().get(URIHelperConstants.PROTOCOL);
      if ((provider instanceof AbstractJvmTypeProvider)) {
        this._access = ((AbstractJvmTypeProvider)provider).getIndexedJvmTypeAccess();
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
  
  public String getOriginalSource() {
    return this.contentsAsString;
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
