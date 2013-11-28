package org.eclipse.xtend.ide.findrefs;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.ui.editor.findrefs.DefaultReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtendReferenceFinder extends DefaultReferenceFinder implements IReferenceFinder {
  private IQualifiedNameConverter nameConverter;
  
  @Inject
  public XtendReferenceFinder(final IResourceDescriptions indexData, final IResourceServiceProvider.Registry serviceProviderRegistry, final IQualifiedNameConverter nameConverter) {
    super(indexData, serviceProviderRegistry);
    this.nameConverter = nameConverter;
  }
  
  public void findReferences(final Set<URI> targetURIs, final IResourceDescription resourceDescription, final IAcceptor<IReferenceDescription> acceptor, final IProgressMonitor monitor, final IReferenceFinder.ILocalResourceAccess localResourceAccess) {
    final Function1<URI,URI> _function = new Function1<URI,URI>() {
      public URI apply(final URI it) {
        URI _trimFragment = it.trimFragment();
        return _trimFragment;
      }
    };
    Iterable<URI> _map = IterableExtensions.<URI, URI>map(targetURIs, _function);
    final Function1<URI,Boolean> _function_1 = new Function1<URI,Boolean>() {
      public Boolean apply(final URI it) {
        URI _uRI = resourceDescription.getURI();
        boolean _equals = Objects.equal(it, _uRI);
        return Boolean.valueOf(_equals);
      }
    };
    boolean _exists = IterableExtensions.<URI>exists(_map, _function_1);
    if (_exists) {
      return;
    }
    final HashSet<QualifiedName> names = CollectionLiterals.<QualifiedName>newHashSet();
    for (final URI uri : targetURIs) {
      final IUnitOfWork<Boolean,ResourceSet> _function_2 = new IUnitOfWork<Boolean,ResourceSet>() {
        public Boolean exec(final ResourceSet it) throws Exception {
          boolean _xblockexpression = false;
          {
            EObject _eObject = it.getEObject(uri, true);
            final JvmType obj = EcoreUtil2.<JvmType>getContainerOfType(_eObject, JvmType.class);
            boolean _xifexpression = false;
            boolean _notEquals = (!Objects.equal(obj, null));
            if (_notEquals) {
              String _identifier = obj.getIdentifier();
              QualifiedName _qualifiedName = XtendReferenceFinder.this.nameConverter.toQualifiedName(_identifier);
              QualifiedName _lowerCase = _qualifiedName.toLowerCase();
              boolean _add = names.add(_lowerCase);
              _xifexpression = _add;
            }
            _xblockexpression = (_xifexpression);
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      localResourceAccess.<Boolean>readOnly(uri, _function_2);
    }
    Iterable<QualifiedName> _importedNames = resourceDescription.getImportedNames();
    final Set<QualifiedName> importedNames = IterableExtensions.<QualifiedName>toSet(_importedNames);
    final Function1<QualifiedName,Boolean> _function_3 = new Function1<QualifiedName,Boolean>() {
      public Boolean apply(final QualifiedName it) {
        boolean _contains = importedNames.contains(it);
        return Boolean.valueOf(_contains);
      }
    };
    boolean _exists_1 = IterableExtensions.<QualifiedName>exists(names, _function_3);
    if (_exists_1) {
      URI _uRI = resourceDescription.getURI();
      final IUnitOfWork<Object,ResourceSet> _function_4 = new IUnitOfWork<Object,ResourceSet>() {
        public Object exec(final ResourceSet resourceSet) throws Exception {
          URI _uRI = resourceDescription.getURI();
          Resource _resource = resourceSet.getResource(_uRI, true);
          final IAcceptor<IReferenceDescription> _function = new IAcceptor<IReferenceDescription>() {
            public void accept(final IReferenceDescription it) {
              acceptor.accept(it);
            }
          };
          XtendReferenceFinder.this.findLocalReferencesInResource(targetURIs, _resource, _function);
          return null;
        }
      };
      localResourceAccess.<Object>readOnly(_uRI, _function_4);
    }
  }
  
  protected void findLocalReferencesFromElement(final Set<URI> targetURISet, final EObject sourceCandidate, final Resource localResource, final IAcceptor<IReferenceDescription> acceptor, final URI currentExportedContainerURI, final Map<EObject,URI> exportedElementsMap) {
    boolean _matched = false;
    if (!_matched) {
      if (sourceCandidate instanceof XAbstractFeatureCall) {
        boolean _isPackageFragment = ((XAbstractFeatureCall)sourceCandidate).isPackageFragment();
        if (_isPackageFragment) {
          _matched=true;
          return;
        }
      }
    }
    super.findLocalReferencesFromElement(targetURISet, sourceCandidate, localResource, acceptor, currentExportedContainerURI, exportedElementsMap);
    boolean _matched_1 = false;
    if (!_matched_1) {
      if (sourceCandidate instanceof XFeatureCall) {
        boolean _and = false;
        XExpression _actualReceiver = ((XFeatureCall)sourceCandidate).getActualReceiver();
        boolean _equals = Objects.equal(_actualReceiver, null);
        if (!_equals) {
          _and = false;
        } else {
          boolean _isStatic = ((XFeatureCall)sourceCandidate).isStatic();
          _and = (_equals && _isStatic);
        }
        if (_and) {
          _matched_1=true;
          this.addReferenceToTypeFromStaticImport(((XAbstractFeatureCall)sourceCandidate), targetURISet, acceptor, currentExportedContainerURI);
        }
      }
    }
    if (!_matched_1) {
      if (sourceCandidate instanceof XMemberFeatureCall) {
        _matched_1=true;
        boolean _and = false;
        boolean _isStatic = ((XMemberFeatureCall)sourceCandidate).isStatic();
        if (!_isStatic) {
          _and = false;
        } else {
          boolean _isStaticWithDeclaringType = ((XMemberFeatureCall)sourceCandidate).isStaticWithDeclaringType();
          boolean _not = (!_isStaticWithDeclaringType);
          _and = (_isStatic && _not);
        }
        if (_and) {
          this.addReferenceToTypeFromStaticImport(((XAbstractFeatureCall)sourceCandidate), targetURISet, acceptor, currentExportedContainerURI);
        }
      }
    }
  }
  
  protected void addReferenceToTypeFromStaticImport(final XAbstractFeatureCall sourceCandidate, final Set<URI> targetURISet, final IAcceptor<IReferenceDescription> acceptor, final URI currentExportedContainerURI) {
    final JvmIdentifiableElement feature = sourceCandidate.getFeature();
    if ((feature instanceof JvmMember)) {
      final JvmDeclaredType type = ((JvmMember) feature).getDeclaringType();
      final URI typeURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(type);
      boolean _contains = targetURISet.contains(typeURI);
      if (_contains) {
        final URI sourceURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceCandidate);
        DefaultReferenceDescription _defaultReferenceDescription = new DefaultReferenceDescription(sourceURI, typeURI, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, (-1), currentExportedContainerURI);
        acceptor.accept(_defaultReferenceDescription);
      }
    }
  }
}
