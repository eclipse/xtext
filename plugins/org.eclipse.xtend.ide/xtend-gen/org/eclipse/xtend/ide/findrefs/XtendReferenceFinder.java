package org.eclipse.xtend.ide.findrefs;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry;
import org.eclipse.xtext.ui.editor.findrefs.DefaultReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder.ILocalResourceAccess;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtendReferenceFinder extends DefaultReferenceFinder implements IReferenceFinder {
  private IQualifiedNameConverter nameConverter;
  
  @Inject
  public XtendReferenceFinder(final IResourceDescriptions indexData, final Registry serviceProviderRegistry, final IQualifiedNameConverter nameConverter) {
    super(indexData, serviceProviderRegistry);
    this.nameConverter = nameConverter;
  }
  
  public void findReferences(final Set<URI> targetURIs, final IResourceDescription resourceDescription, final IAcceptor<IReferenceDescription> acceptor, final IProgressMonitor monitor, final ILocalResourceAccess localResourceAccess) {
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
            Boolean _xblockexpression = null;
            {
              EObject _eObject = it.getEObject(uri, true);
              final JvmType obj = EcoreUtil2.<JvmType>getContainerOfType(_eObject, JvmType.class);
              Boolean _xifexpression = null;
              boolean _notEquals = (!Objects.equal(obj, null));
              if (_notEquals) {
                String _identifier = obj.getIdentifier();
                String _lowerCase = _identifier.toLowerCase();
                QualifiedName _qualifiedName = XtendReferenceFinder.this.nameConverter.toQualifiedName(_lowerCase);
                boolean _add = names.add(_qualifiedName);
                _xifexpression = Boolean.valueOf(_add);
              }
              _xblockexpression = (_xifexpression);
            }
            return _xblockexpression;
          }
        };
      localResourceAccess.<Boolean>readOnly(uri, _function_2);
    }
    Iterable<QualifiedName> _importedNames = resourceDescription.getImportedNames();
    final Function1<QualifiedName,QualifiedName> _function_3 = new Function1<QualifiedName,QualifiedName>() {
        public QualifiedName apply(final QualifiedName it) {
          QualifiedName _lowerCase = it.toLowerCase();
          return _lowerCase;
        }
      };
    Iterable<QualifiedName> _map_1 = IterableExtensions.<QualifiedName, QualifiedName>map(_importedNames, _function_3);
    final Set<QualifiedName> importedNames = IterableExtensions.<QualifiedName>toSet(_map_1);
    final Function1<QualifiedName,Boolean> _function_4 = new Function1<QualifiedName,Boolean>() {
        public Boolean apply(final QualifiedName it) {
          boolean _contains = importedNames.contains(it);
          return Boolean.valueOf(_contains);
        }
      };
    boolean _exists_1 = IterableExtensions.<QualifiedName>exists(names, _function_4);
    if (_exists_1) {
      URI _uRI = resourceDescription.getURI();
      final IUnitOfWork<Object,ResourceSet> _function_5 = new IUnitOfWork<Object,ResourceSet>() {
          public Object exec(final ResourceSet it) throws Exception {
            URI _uRI = resourceDescription.getURI();
            Resource _resource = it.getResource(_uRI, true);
            final IAcceptor<IReferenceDescription> _function = new IAcceptor<IReferenceDescription>() {
                public void accept(final IReferenceDescription it) {
                  acceptor.accept(it);
                }
              };
            XtendReferenceFinder.this.findLocalReferencesInResource(targetURIs, _resource, _function);
            return null;
          }
        };
      localResourceAccess.<Object>readOnly(_uRI, _function_5);
    }
  }
}
