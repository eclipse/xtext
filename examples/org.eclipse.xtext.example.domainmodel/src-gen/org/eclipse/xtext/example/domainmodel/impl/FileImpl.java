/**
 * <copyright>
 * </copyright>
 *
 * $Id: FileImpl.java,v 1.1 2009/02/18 19:34:06 sefftinge Exp $
 */
package org.eclipse.xtext.example.domainmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.example.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.File;
import org.eclipse.xtext.example.domainmodel.Import;
import org.eclipse.xtext.example.domainmodel.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.domainmodel.impl.FileImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.domainmodel.impl.FileImpl#getNamedElements <em>Named Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileImpl extends EObjectImpl implements File
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getNamedElements() <em>Named Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamedElements()
   * @generated
   * @ordered
   */
  protected EList<NamedElement> namedElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FileImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DomainmodelPackage.Literals.FILE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, DomainmodelPackage.FILE__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NamedElement> getNamedElements()
  {
    if (namedElements == null)
    {
      namedElements = new EObjectContainmentEList<NamedElement>(NamedElement.class, this, DomainmodelPackage.FILE__NAMED_ELEMENTS);
    }
    return namedElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case DomainmodelPackage.FILE__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case DomainmodelPackage.FILE__NAMED_ELEMENTS:
        return ((InternalEList<?>)getNamedElements()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DomainmodelPackage.FILE__IMPORTS:
        return getImports();
      case DomainmodelPackage.FILE__NAMED_ELEMENTS:
        return getNamedElements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DomainmodelPackage.FILE__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case DomainmodelPackage.FILE__NAMED_ELEMENTS:
        getNamedElements().clear();
        getNamedElements().addAll((Collection<? extends NamedElement>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DomainmodelPackage.FILE__IMPORTS:
        getImports().clear();
        return;
      case DomainmodelPackage.FILE__NAMED_ELEMENTS:
        getNamedElements().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DomainmodelPackage.FILE__IMPORTS:
        return imports != null && !imports.isEmpty();
      case DomainmodelPackage.FILE__NAMED_ELEMENTS:
        return namedElements != null && !namedElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FileImpl
