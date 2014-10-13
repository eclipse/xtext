package org.eclipse.xtext.idea.types.access;

import com.google.common.base.Objects;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.impl.JavaPsiFacadeEx;
import com.intellij.psi.impl.compiled.SignatureParsing;
import com.intellij.psi.search.GlobalSearchScope;
import java.text.StringCharacterIterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.AbstractRuntimeJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.idea.types.access.PsiBasedTypeFactory;
import org.eclipse.xtext.idea.types.access.PsiClassMirror;
import org.eclipse.xtext.idea.types.access.StubURIHelper;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class StubJvmTypeProvider extends AbstractRuntimeJvmTypeProvider {
  private final static String PRIMITIVES = URIHelperConstants.PRIMITIVES_URI.segment(0);
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final Project project;
  
  private final ITypeFactory<PsiClass, JvmDeclaredType> psiClassFactory;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  @Extension
  private final StubURIHelper uriHelper;
  
  protected StubJvmTypeProvider(final Project project, final ResourceSet resourceSet, final IndexedJvmTypeAccess indexedJvmTypeAccess, final TypeResourceServices services, final IPsiModelAssociator psiModelAssociator) {
    super(resourceSet, indexedJvmTypeAccess, services);
    this.project = project;
    StubURIHelper _createStubURIHelper = this.createStubURIHelper();
    this.uriHelper = _createStubURIHelper;
    PsiBasedTypeFactory _createPsiClassFactory = this.createPsiClassFactory(psiModelAssociator);
    this.psiClassFactory = _createPsiClassFactory;
  }
  
  public PsiBasedTypeFactory createPsiClassFactory(final IPsiModelAssociator psiModelAssociator) {
    return new PsiBasedTypeFactory(this.uriHelper, psiModelAssociator);
  }
  
  protected StubURIHelper createStubURIHelper() {
    return new StubURIHelper();
  }
  
  public JvmType findTypeByName(final String name) {
    return this.doFindTypeByName(name, false);
  }
  
  public JvmType findTypeByName(final String name, final boolean binaryNestedTypeDelimiter) {
    JvmType _xblockexpression = null;
    {
      JvmType result = this.doFindTypeByName(name, false);
      boolean _or = false;
      boolean _notEquals = (!Objects.equal(result, null));
      if (_notEquals) {
        _or = true;
      } else {
        boolean _isBinaryNestedTypeDelimiter = this.isBinaryNestedTypeDelimiter(name, binaryNestedTypeDelimiter);
        _or = _isBinaryNestedTypeDelimiter;
      }
      if (_or) {
        return result;
      }
      final AbstractJvmTypeProvider.ClassNameVariants nameVariants = new AbstractJvmTypeProvider.ClassNameVariants(name);
      while ((Objects.equal(result, null) && nameVariants.hasNext())) {
        {
          final String nextVariant = nameVariants.next();
          JvmType _doFindTypeByName = this.doFindTypeByName(nextVariant, true);
          result = _doFindTypeByName;
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public JvmType doFindTypeByName(final String name, final boolean traverseNestedTypes) {
    try {
      JvmType _xblockexpression = null;
      {
        ProgressIndicatorProvider.checkCanceled();
        final String normalizedName = this.normalize(name);
        final URI resourceURI = this.uriHelper.createResourceURI(normalizedName);
        final String fragment = this.uriHelper.getFragment(normalizedName);
        JvmType _switchResult = null;
        ResourceSet _resourceSet = this.getResourceSet();
        final ResourceSet resourceSet = _resourceSet;
        boolean _matched = false;
        if (!_matched) {
          if (resourceSet instanceof ISynchronizable) {
            _matched=true;
            final IUnitOfWork<JvmType, ResourceSet> _function = new IUnitOfWork<JvmType, ResourceSet>() {
              public JvmType exec(final ResourceSet it) throws Exception {
                return StubJvmTypeProvider.this.findType(resourceURI, fragment, traverseNestedTypes);
              }
            };
            _switchResult = ((ISynchronizable<ResourceSet>)resourceSet).<JvmType>execute(_function);
          }
        }
        if (!_matched) {
          _switchResult = this.findType(resourceURI, fragment, traverseNestedTypes);
        }
        _xblockexpression = _switchResult;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String normalize(final String name) {
    try {
      String _xifexpression = null;
      boolean _startsWith = name.startsWith("[");
      if (_startsWith) {
        StringCharacterIterator _stringCharacterIterator = new StringCharacterIterator(name);
        _xifexpression = SignatureParsing.parseTypeString(_stringCharacterIterator);
      } else {
        _xifexpression = name;
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public JvmType findType(final URI resourceURI, final String fragment, final boolean traverseNestedTypes) {
    JvmType _xblockexpression = null;
    {
      final IndexedJvmTypeAccess indexedJvmTypeAccess = this.getIndexedJvmTypeAccess();
      boolean _notEquals = (!Objects.equal(indexedJvmTypeAccess, null));
      if (_notEquals) {
        final URI proxyURI = resourceURI.appendFragment(fragment);
        ResourceSet _resourceSet = this.getResourceSet();
        final EObject candidate = indexedJvmTypeAccess.getIndexedJvmType(proxyURI, _resourceSet);
        if ((candidate instanceof JvmType)) {
          return ((JvmType)candidate);
        }
      }
      ProgressIndicatorProvider.checkCanceled();
      ResourceSet _resourceSet_1 = this.getResourceSet();
      final Resource resource = _resourceSet_1.getResource(resourceURI, true);
      _xblockexpression = this.findType(resource, fragment, traverseNestedTypes);
    }
    return _xblockexpression;
  }
  
  protected JvmType findType(final Resource resource, final String fragment, final boolean traverseNestedTypes) {
    EObject _eObject = resource.getEObject(fragment);
    final JvmType result = ((JvmType) _eObject);
    boolean _or = false;
    boolean _notEquals = (!Objects.equal(result, null));
    if (_notEquals) {
      _or = true;
    } else {
      _or = (!traverseNestedTypes);
    }
    if (_or) {
      return result;
    }
    EList<EObject> _contents = resource.getContents();
    final EObject rootType = IterableExtensions.<EObject>head(_contents);
    if ((rootType instanceof JvmDeclaredType)) {
      URI _uRI = resource.getURI();
      final String rootTypeName = _uRI.segment(1);
      int _length = rootTypeName.length();
      int _plus = (_length + 1);
      final String nestedTypeName = fragment.substring(_plus);
      final List<String> segments = Strings.split(nestedTypeName, "$");
      return this.findNestedType(((JvmDeclaredType)rootType), segments, 0);
    }
    return null;
  }
  
  protected IMirror createMirrorForFQN(final String name) {
    PsiClassMirror _xblockexpression = null;
    {
      GlobalSearchScope _switchResult = null;
      ResourceSet _resourceSet = this.getResourceSet();
      final ResourceSet it = _resourceSet;
      boolean _matched = false;
      if (!_matched) {
        if (it instanceof XtextResourceSet) {
          _matched=true;
          Object _classpathURIContext = ((XtextResourceSet)it).getClasspathURIContext();
          _switchResult = ((GlobalSearchScope) _classpathURIContext);
        }
      }
      if (!_matched) {
        _switchResult = GlobalSearchScope.allScope(this.project);
      }
      final GlobalSearchScope scope = _switchResult;
      JavaPsiFacadeEx _instanceEx = JavaPsiFacadeEx.getInstanceEx(this.project);
      final PsiClass psiClass = _instanceEx.findClass(name, scope);
      boolean _or = false;
      boolean _equals = Objects.equal(psiClass, null);
      if (_equals) {
        _or = true;
      } else {
        PsiClass _containingClass = psiClass.getContainingClass();
        boolean _notEquals = (!Objects.equal(_containingClass, null));
        _or = _notEquals;
      }
      if (_or) {
        return null;
      }
      _xblockexpression = new PsiClassMirror(psiClass, this.psiClassFactory);
    }
    return _xblockexpression;
  }
  
  @Pure
  public Project getProject() {
    return this.project;
  }
  
  @Pure
  public StubURIHelper getUriHelper() {
    return this.uriHelper;
  }
}
