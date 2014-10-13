package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class ResourceDescriptionAdapter extends AdapterImpl implements IResourceDescription {
  private final IResourceDescription delegate;
  
  public Iterable<IEObjectDescription> getExportedObjects() {
    return this.delegate.getExportedObjects();
  }
  
  public Iterable<QualifiedName> getImportedNames() {
    return this.delegate.getImportedNames();
  }
  
  public Iterable<IReferenceDescription> getReferenceDescriptions() {
    return this.delegate.getReferenceDescriptions();
  }
  
  public URI getURI() {
    return this.delegate.getURI();
  }
  
  public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName name, final boolean ignoreCase) {
    return this.delegate.getExportedObjects(type, name, ignoreCase);
  }
  
  public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
    return this.delegate.getExportedObjectsByObject(object);
  }
  
  public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
    return this.delegate.getExportedObjectsByType(type);
  }
  
  public boolean isEmpty() {
    return this.delegate.isEmpty();
  }
  
  public static ResourceDescriptionAdapter install(final Resource it) {
    ResourceDescriptionAdapter _elvis = null;
    ResourceDescriptionAdapter _get = ResourceDescriptionAdapter.get(it);
    if (_get != null) {
      _elvis = _get;
    } else {
      ResourceDescriptionAdapter _xifexpression = null;
      if ((it instanceof XtextResource)) {
        ResourceDescriptionAdapter _xblockexpression = null;
        {
          IResourceServiceProvider _resourceServiceProvider = ((XtextResource)it).getResourceServiceProvider();
          @Extension
          final IResourceDescription.Manager resourceDescriptionManager = _resourceServiceProvider.getResourceDescriptionManager();
          IResourceDescription _resourceDescription = resourceDescriptionManager.getResourceDescription(it);
          ResourceDescriptionAdapter _resourceDescriptionAdapter = new ResourceDescriptionAdapter(_resourceDescription);
          final Procedure1<ResourceDescriptionAdapter> _function = new Procedure1<ResourceDescriptionAdapter>() {
            public void apply(final ResourceDescriptionAdapter adapter) {
              EList<Adapter> _eAdapters = ((XtextResource)it).eAdapters();
              _eAdapters.add(adapter);
            }
          };
          _xblockexpression = ObjectExtensions.<ResourceDescriptionAdapter>operator_doubleArrow(_resourceDescriptionAdapter, _function);
        }
        _xifexpression = _xblockexpression;
      }
      _elvis = _xifexpression;
    }
    return _elvis;
  }
  
  public static boolean remove(final Resource it) {
    boolean _xblockexpression = false;
    {
      final ResourceDescriptionAdapter adapter = ResourceDescriptionAdapter.get(it);
      boolean _xifexpression = false;
      boolean _notEquals = (!Objects.equal(adapter, null));
      if (_notEquals) {
        EList<Adapter> _eAdapters = it.eAdapters();
        _xifexpression = _eAdapters.remove(adapter);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static ResourceDescriptionAdapter get(final Resource it) {
    EList<Adapter> _eAdapters = it.eAdapters();
    Iterable<ResourceDescriptionAdapter> _filter = Iterables.<ResourceDescriptionAdapter>filter(_eAdapters, ResourceDescriptionAdapter.class);
    return IterableExtensions.<ResourceDescriptionAdapter>head(_filter);
  }
  
  public String toString() {
    Class<? extends ResourceDescriptionAdapter> _class = this.getClass();
    String _name = _class.getName();
    String _plus = (_name + ":");
    String _string = this.delegate.toString();
    return (_plus + _string);
  }
  
  public ResourceDescriptionAdapter(final IResourceDescription delegate) {
    super();
    this.delegate = delegate;
  }
}
