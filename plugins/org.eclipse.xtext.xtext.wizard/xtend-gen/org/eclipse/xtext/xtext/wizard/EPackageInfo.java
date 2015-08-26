package org.eclipse.xtext.xtext.wizard;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class EPackageInfo {
  private final EPackage ePackage;
  
  private final URI ePackageImportURI;
  
  private final URI genmodelURI;
  
  private final String ePackageJavaFQN;
  
  private final String bundleID;
  
  public EPackageInfo(final EPackage ePackage, final URI ePackageImportURI, final URI genmodelURI, final String ePackageJavaFQN, final String bundleID) {
    super();
    this.ePackage = ePackage;
    this.ePackageImportURI = ePackageImportURI;
    this.genmodelURI = genmodelURI;
    this.ePackageJavaFQN = ePackageJavaFQN;
    this.bundleID = bundleID;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.ePackage== null) ? 0 : this.ePackage.hashCode());
    result = prime * result + ((this.ePackageImportURI== null) ? 0 : this.ePackageImportURI.hashCode());
    result = prime * result + ((this.genmodelURI== null) ? 0 : this.genmodelURI.hashCode());
    result = prime * result + ((this.ePackageJavaFQN== null) ? 0 : this.ePackageJavaFQN.hashCode());
    result = prime * result + ((this.bundleID== null) ? 0 : this.bundleID.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    EPackageInfo other = (EPackageInfo) obj;
    if (this.ePackage == null) {
      if (other.ePackage != null)
        return false;
    } else if (!this.ePackage.equals(other.ePackage))
      return false;
    if (this.ePackageImportURI == null) {
      if (other.ePackageImportURI != null)
        return false;
    } else if (!this.ePackageImportURI.equals(other.ePackageImportURI))
      return false;
    if (this.genmodelURI == null) {
      if (other.genmodelURI != null)
        return false;
    } else if (!this.genmodelURI.equals(other.genmodelURI))
      return false;
    if (this.ePackageJavaFQN == null) {
      if (other.ePackageJavaFQN != null)
        return false;
    } else if (!this.ePackageJavaFQN.equals(other.ePackageJavaFQN))
      return false;
    if (this.bundleID == null) {
      if (other.bundleID != null)
        return false;
    } else if (!this.bundleID.equals(other.bundleID))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("ePackage", this.ePackage);
    b.add("ePackageImportURI", this.ePackageImportURI);
    b.add("genmodelURI", this.genmodelURI);
    b.add("ePackageJavaFQN", this.ePackageJavaFQN);
    b.add("bundleID", this.bundleID);
    return b.toString();
  }
  
  @Pure
  public EPackage getEPackage() {
    return this.ePackage;
  }
  
  @Pure
  public URI getEPackageImportURI() {
    return this.ePackageImportURI;
  }
  
  @Pure
  public URI getGenmodelURI() {
    return this.genmodelURI;
  }
  
  @Pure
  public String getEPackageJavaFQN() {
    return this.ePackageJavaFQN;
  }
  
  @Pure
  public String getBundleID() {
    return this.bundleID;
  }
}
