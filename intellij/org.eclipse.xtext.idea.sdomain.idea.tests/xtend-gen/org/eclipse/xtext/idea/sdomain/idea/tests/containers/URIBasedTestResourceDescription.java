package org.eclipse.xtext.idea.sdomain.idea.tests.containers;

import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class URIBasedTestResourceDescription extends AbstractResourceDescription {
  private final URI uri;
  
  @Override
  protected List<IEObjectDescription> computeExportedObjects() {
    return CollectionLiterals.<IEObjectDescription>emptyList();
  }
  
  @Override
  public Iterable<QualifiedName> getImportedNames() {
    return CollectionLiterals.<QualifiedName>emptyList();
  }
  
  @Override
  public Iterable<IReferenceDescription> getReferenceDescriptions() {
    return CollectionLiterals.<IReferenceDescription>emptyList();
  }
  
  @Override
  public URI getURI() {
    return this.uri;
  }
  
  public URIBasedTestResourceDescription(final URI uri) {
    super();
    this.uri = uri;
  }
}
