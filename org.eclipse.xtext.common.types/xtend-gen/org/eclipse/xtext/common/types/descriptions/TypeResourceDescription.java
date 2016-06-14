/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types.descriptions;

import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * More or less copied from NameBasedResourceDescription and TypeResourceDescription
 * to avoid dependency on common.types.ui
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypeResourceDescription extends AbstractResourceDescription {
  public static class ChangedDelta extends ChangedResourceDescriptionDelta {
    public ChangedDelta(final QualifiedName javaTypeName) {
      super(null, new TypeResourceDescription(javaTypeName));
    }
  }
  
  @Data
  public static class ClassDescription implements IEObjectDescription {
    private final QualifiedName qualifiedName;
    
    @Override
    public EClass getEClass() {
      return null;
    }
    
    @Override
    public EObject getEObjectOrProxy() {
      throw new UnsupportedOperationException("TODO: auto-generated method stub");
    }
    
    @Override
    public URI getEObjectURI() {
      throw new UnsupportedOperationException("TODO: auto-generated method stub");
    }
    
    @Override
    public QualifiedName getName() {
      return this.qualifiedName;
    }
    
    @Override
    public String getUserData(final String key) {
      return null;
    }
    
    @Override
    public String[] getUserDataKeys() {
      return Strings.EMPTY_ARRAY;
    }
    
    public ClassDescription(final QualifiedName qualifiedName) {
      super();
      this.qualifiedName = qualifiedName;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.qualifiedName== null) ? 0 : this.qualifiedName.hashCode());
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
      TypeResourceDescription.ClassDescription other = (TypeResourceDescription.ClassDescription) obj;
      if (this.qualifiedName == null) {
        if (other.qualifiedName != null)
          return false;
      } else if (!this.qualifiedName.equals(other.qualifiedName))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("qualifiedName", this.qualifiedName);
      return b.toString();
    }
    
    @Pure
    public QualifiedName getQualifiedName() {
      return this.qualifiedName;
    }
  }
  
  private List<IEObjectDescription> exportedObjects;
  
  private URI uri;
  
  public TypeResourceDescription(final QualifiedName typeName) {
    String _string = typeName.toString(".");
    URI _appendSegment = URIHelperConstants.OBJECTS_URI.appendSegment(_string);
    this.uri = _appendSegment;
    TypeResourceDescription.ClassDescription _classDescription = new TypeResourceDescription.ClassDescription(typeName);
    this.exportedObjects = Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList(_classDescription));
  }
  
  @Override
  protected List<IEObjectDescription> computeExportedObjects() {
    return this.exportedObjects;
  }
  
  @Override
  public Iterable<QualifiedName> getImportedNames() {
    return Collections.<QualifiedName>unmodifiableList(CollectionLiterals.<QualifiedName>newArrayList());
  }
  
  @Override
  public Iterable<IReferenceDescription> getReferenceDescriptions() {
    return Collections.<IReferenceDescription>unmodifiableList(CollectionLiterals.<IReferenceDescription>newArrayList());
  }
  
  @Override
  public URI getURI() {
    return this.uri;
  }
}
