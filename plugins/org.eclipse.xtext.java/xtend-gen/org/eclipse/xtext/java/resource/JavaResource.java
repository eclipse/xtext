package org.eclipse.xtext.java.resource;

import com.google.common.base.Objects;
import com.google.common.io.CharStreams;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.IJavaSchemeUriResolver;
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.java.resource.JavaDerivedStateComputer;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class JavaResource extends ResourceImpl implements IJavaSchemeUriResolver {
  public static class Factory implements Resource.Factory {
    @Inject
    private Provider<JavaResource> resourceProvider;
    
    @Override
    public Resource createResource(final URI uri) {
      JavaResource _get = this.resourceProvider.get();
      final Procedure1<JavaResource> _function = new Procedure1<JavaResource>() {
        @Override
        public void apply(final JavaResource it) {
          it.setURI(uri);
        }
      };
      return ObjectExtensions.<JavaResource>operator_doubleArrow(_get, _function);
    }
  }
  
  @Inject
  private IEncodingProvider encodingProvider;
  
  @Inject
  private CompilerPhases compilerPhases;
  
  @Inject
  private JavaDerivedStateComputer derivedStateComputer;
  
  private CompilationUnit compilationUnit;
  
  @Override
  protected void doLoad(final InputStream inputStream, final Map<?, ?> options) throws IOException {
    URI _uRI = this.getURI();
    final String encoding = this.encodingProvider.getEncoding(_uRI);
    InputStreamReader _inputStreamReader = new InputStreamReader(inputStream, encoding);
    final String contentsAsString = CharStreams.toString(_inputStreamReader);
    char[] _charArray = contentsAsString.toCharArray();
    URI _uRI_1 = this.getURI();
    String _lastSegment = _uRI_1.lastSegment();
    CompilationUnit _compilationUnit = new CompilationUnit(_charArray, _lastSegment, encoding);
    this.compilationUnit = _compilationUnit;
  }
  
  protected CompilationUnit getCompilationUnit() {
    return this.compilationUnit;
  }
  
  private boolean isInitialized = false;
  
  private boolean isFullyInitialized = false;
  
  private boolean isInitializing = false;
  
  @Override
  public EList<EObject> getContents() {
    if (this.isInitializing) {
      return super.getContents();
    }
    try {
      this.isInitializing = true;
      final boolean isIndexing = this.compilerPhases.isIndexing(this);
      if (((!isIndexing) && (!this.isFullyInitialized))) {
        this.derivedStateComputer.discardDerivedState(this);
        this.derivedStateComputer.installFull(this);
        this.isFullyInitialized = true;
        this.isInitialized = true;
      } else {
        boolean _and = false;
        if (!isIndexing) {
          _and = false;
        } else {
          _and = (!this.isInitialized);
        }
        if (_and) {
          this.derivedStateComputer.installStubs(this);
          this.isFullyInitialized = false;
          this.isInitialized = true;
        }
      }
    } finally {
      this.isInitializing = false;
    }
    return super.getContents();
  }
  
  @Override
  public EObject resolveJavaObjectURIProxy(final InternalEObject proxy, final JvmTypeReference sender) {
    final IndexedJvmTypeAccess access = this.getIndexJvmTypeAccess();
    boolean _notEquals = (!Objects.equal(access, null));
    if (_notEquals) {
      URI _eProxyURI = proxy.eProxyURI();
      ResourceSet _resourceSet = this.getResourceSet();
      final EObject result = access.getIndexedJvmType(_eProxyURI, _resourceSet);
      boolean _notEquals_1 = (!Objects.equal(result, null));
      if (_notEquals_1) {
        return result;
      }
    }
    return EcoreUtil.resolve(proxy, sender);
  }
  
  private IndexedJvmTypeAccess _access;
  
  public IndexedJvmTypeAccess getIndexJvmTypeAccess() {
    try {
      boolean _equals = Objects.equal(this._access, null);
      if (_equals) {
        Resource.Factory.Registry _resourceFactoryRegistry = this.resourceSet.getResourceFactoryRegistry();
        Map<String, Object> _protocolToFactoryMap = _resourceFactoryRegistry.getProtocolToFactoryMap();
        final Object provider = _protocolToFactoryMap.get(URIHelperConstants.PROTOCOL);
        Field _declaredField = AbstractJvmTypeProvider.class.getDeclaredField("indexedJvmTypeAccess");
        final Procedure1<Field> _function = new Procedure1<Field>() {
          @Override
          public void apply(final Field it) {
            it.setAccessible(true);
          }
        };
        final Field field = ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function);
        Object _get = field.get(provider);
        this._access = ((IndexedJvmTypeAccess) _get);
      }
      return this._access;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
