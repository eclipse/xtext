package org.eclipse.xtend.core.resource;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtendResourceDescription extends DefaultResourceDescription {
  private final List<String> primitivesFilter = Collections.<String>unmodifiableList(Lists.<String>newArrayList("boolean", "int", "char", "byte", "short", "long"));
  
  public XtendResourceDescription(final Resource resource, final IDefaultResourceDescriptionStrategy strategy) {
    super(resource, strategy);
  }
  
  protected EObjectDescriptionLookUp getLookUp() {
    boolean _equals = Objects.equal(this.lookup, null);
    if (_equals) {
      List<IEObjectDescription> _computeExportedObjects = this.computeExportedObjects();
      EObjectDescriptionLookUp _eObjectDescriptionLookUp = new EObjectDescriptionLookUp(_computeExportedObjects);
      this.lookup = _eObjectDescriptionLookUp;
    }
    return this.lookup;
  }
  
  public Iterable<QualifiedName> getImportedNames() {
    Iterable<QualifiedName> originalImportedNames = super.getImportedNames();
    final Function1<QualifiedName,Boolean> _function = new Function1<QualifiedName,Boolean>() {
        public Boolean apply(final QualifiedName it) {
          String _lastSegment = it.getLastSegment();
          boolean _contains = XtendResourceDescription.this.primitivesFilter.contains(_lastSegment);
          boolean _not = (!_contains);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<QualifiedName> filteredImportedNames = IterableExtensions.<QualifiedName>filter(originalImportedNames, _function);
    return filteredImportedNames;
  }
}
