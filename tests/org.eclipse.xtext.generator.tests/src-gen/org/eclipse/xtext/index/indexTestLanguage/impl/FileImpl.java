/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.index.indexTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.index.indexTestLanguage.File;
import org.eclipse.xtext.index.indexTestLanguage.Import;
import org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage;
import org.eclipse.xtext.index.indexTestLanguage.Namespace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.index.indexTestLanguage.impl.FileImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.index.indexTestLanguage.impl.FileImpl#getNameSpaces <em>Name Spaces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileImpl extends MinimalEObjectImpl.Container implements File
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
   * The cached value of the '{@link #getNameSpaces() <em>Name Spaces</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameSpaces()
   * @generated
   * @ordered
   */
  protected EList<Namespace> nameSpaces;

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
    return IndexTestLanguagePackage.Literals.FILE;
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
      imports = new EObjectContainmentEList<Import>(Import.class, this, IndexTestLanguagePackage.FILE__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Namespace> getNameSpaces()
  {
    if (nameSpaces == null)
    {
      nameSpaces = new EObjectContainmentEList<Namespace>(Namespace.class, this, IndexTestLanguagePackage.FILE__NAME_SPACES);
    }
    return nameSpaces;
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
      case IndexTestLanguagePackage.FILE__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case IndexTestLanguagePackage.FILE__NAME_SPACES:
        return ((InternalEList<?>)getNameSpaces()).basicRemove(otherEnd, msgs);
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
      case IndexTestLanguagePackage.FILE__IMPORTS:
        return getImports();
      case IndexTestLanguagePackage.FILE__NAME_SPACES:
        return getNameSpaces();
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
      case IndexTestLanguagePackage.FILE__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case IndexTestLanguagePackage.FILE__NAME_SPACES:
        getNameSpaces().clear();
        getNameSpaces().addAll((Collection<? extends Namespace>)newValue);
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
      case IndexTestLanguagePackage.FILE__IMPORTS:
        getImports().clear();
        return;
      case IndexTestLanguagePackage.FILE__NAME_SPACES:
        getNameSpaces().clear();
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
      case IndexTestLanguagePackage.FILE__IMPORTS:
        return imports != null && !imports.isEmpty();
      case IndexTestLanguagePackage.FILE__NAME_SPACES:
        return nameSpaces != null && !nameSpaces.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FileImpl
