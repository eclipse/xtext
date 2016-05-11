/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy.AssociationHierarchyNodeLocationProvider;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeLocationProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AssociationHierarchyBuilder extends DefaultCallHierarchyBuilder {
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  @Inject
  private AssociationHierarchyNodeLocationProvider associationHierarchyNodeLocationProvider;
  
  @Override
  protected IHierarchyNodeLocationProvider getHierarchyNodeLocationProvider() {
    return this.associationHierarchyNodeLocationProvider;
  }
  
  @Override
  protected IEObjectDescription findDeclaration(final URI objectURI) {
    final IEObjectDescription description = this.getDescription(objectURI);
    EClass _eClass = null;
    if (description!=null) {
      _eClass=description.getEClass();
    }
    boolean _isJvmType = this.isJvmType(_eClass);
    if (_isJvmType) {
      URI _eObjectURI = description.getEObjectURI();
      final IUnitOfWork<IEObjectDescription, EObject> _function = new IUnitOfWork<IEObjectDescription, EObject>() {
        @Override
        public IEObjectDescription exec(final EObject targetElement) throws Exception {
          final EObject sourceElement = AssociationHierarchyBuilder.this._iJvmModelAssociations.getPrimarySourceElement(targetElement);
          EClass _eClass = null;
          if (sourceElement!=null) {
            _eClass=sourceElement.eClass();
          }
          boolean _isEntity = AssociationHierarchyBuilder.this.isEntity(_eClass);
          if (_isEntity) {
            return AssociationHierarchyBuilder.this.getDescription(sourceElement);
          }
          return null;
        }
      };
      return this.<IEObjectDescription>readOnly(_eObjectURI, _function);
    }
    EClass _eClass_1 = null;
    if (description!=null) {
      _eClass_1=description.getEClass();
    }
    boolean _isEntity = this.isEntity(_eClass_1);
    if (_isEntity) {
      return description;
    }
    final IUnitOfWork<IEObjectDescription, EObject> _function_1 = new IUnitOfWork<IEObjectDescription, EObject>() {
      @Override
      public IEObjectDescription exec(final EObject object) throws Exception {
        Entity _containerOfType = EcoreUtil2.<Entity>getContainerOfType(object, Entity.class);
        return AssociationHierarchyBuilder.this.getDescription(_containerOfType);
      }
    };
    return this.<IEObjectDescription>readOnly(objectURI, _function_1);
  }
  
  @Override
  protected boolean filterReference(final IReferenceDescription reference) {
    if (((reference == null) || (!this.isJvmType(reference.getEReference().getEType())))) {
      return false;
    }
    URI _sourceEObjectUri = reference.getSourceEObjectUri();
    final IUnitOfWork<Boolean, EObject> _function = new IUnitOfWork<Boolean, EObject>() {
      @Override
      public Boolean exec(final EObject referenceOwner) throws Exception {
        Property _containerOfType = null;
        if (referenceOwner!=null) {
          _containerOfType=EcoreUtil2.<Property>getContainerOfType(referenceOwner, Property.class);
        }
        Entity _containerOfType_1 = null;
        if (_containerOfType!=null) {
          _containerOfType_1=EcoreUtil2.<Entity>getContainerOfType(_containerOfType, Entity.class);
        }
        return Boolean.valueOf((_containerOfType_1 != null));
      }
    };
    return (this.<Boolean>readOnly(_sourceEObjectUri, _function)).booleanValue();
  }
  
  protected boolean isJvmType(final EClassifier type) {
    return this.isAssignable(TypesPackage.Literals.JVM_TYPE, type);
  }
  
  protected boolean isEntity(final EClassifier type) {
    return this.isAssignable(DomainmodelPackage.Literals.ENTITY, type);
  }
}
