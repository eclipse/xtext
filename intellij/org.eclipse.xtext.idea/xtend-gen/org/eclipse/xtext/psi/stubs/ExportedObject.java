package org.eclipse.xtext.psi.stubs;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Pure;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class ExportedObject {
  @Accessors
  private final QualifiedName qualifiedName;
  
  @Accessors
  private final EClass EClass;
  
  @Accessors
  private final URI EObjectURI;
  
  public ExportedObject(final QualifiedName qualifiedName, final EClass EClass, final URI EObjectURI) {
    super();
    this.qualifiedName = qualifiedName;
    this.EClass = EClass;
    this.EObjectURI = EObjectURI;
  }
  
  @Pure
  public QualifiedName getQualifiedName() {
    return this.qualifiedName;
  }
  
  @Pure
  public EClass getEClass() {
    return this.EClass;
  }
  
  @Pure
  public URI getEObjectURI() {
    return this.EObjectURI;
  }
}
