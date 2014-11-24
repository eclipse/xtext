package org.eclipse.xtext.idea.types.access;

import com.google.common.base.Objects;
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
import org.eclipse.xtext.idea.types.access.StubURIHelper;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class StubJvmTypeProvider extends AbstractRuntimeJvmTypeProvider {
  private final static String PRIMITIVES = URIHelperConstants.PRIMITIVES_URI.segment(0);
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final /* Project */Object project;
  
  private final /* ITypeFactory<PsiClass, JvmDeclaredType> */Object psiClassFactory;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  @Extension
  private final StubURIHelper uriHelper;
  
  protected StubJvmTypeProvider(final /* Project */Object project, final ResourceSet resourceSet, final IndexedJvmTypeAccess indexedJvmTypeAccess, final TypeResourceServices services, final IPsiModelAssociator psiModelAssociator) {
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field ProgressIndicatorProvider is undefined for the type StubJvmTypeProvider"
      + "\ncheckCanceled cannot be resolved"
      + "\ncreateResourceURI cannot be resolved"
      + "\nfragment cannot be resolved");
  }
  
  protected Object normalize(final String name) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field SignatureParsing is undefined for the type StubJvmTypeProvider"
      + "\nparseTypeString cannot be resolved");
  }
  
  public JvmType findType(final URI resourceURI, final String fragment, final boolean traverseNestedTypes) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field ProgressIndicatorProvider is undefined for the type StubJvmTypeProvider"
      + "\ncheckCanceled cannot be resolved");
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
    throw new Error("Unresolved compilation problems:"
      + "\nGlobalSearchScope cannot be resolved to a type."
      + "\nThe method or field GlobalSearchScope is undefined for the type StubJvmTypeProvider"
      + "\nThe method or field JavaPsiFacadeEx is undefined for the type StubJvmTypeProvider"
      + "\nallScope cannot be resolved"
      + "\ngetInstanceEx cannot be resolved"
      + "\nfindClass cannot be resolved"
      + "\n== cannot be resolved"
      + "\n|| cannot be resolved"
      + "\ncontainingClass cannot be resolved"
      + "\n!= cannot be resolved");
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
