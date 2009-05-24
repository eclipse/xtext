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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage;
import org.eclipse.xtext.index.indexTestLanguage.NamedElement;
import org.eclipse.xtext.index.indexTestLanguage.Namespace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Namespace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.index.indexTestLanguage.impl.NamespaceImpl#getNamedElements <em>Named Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamespaceImpl extends NamedElementImpl implements Namespace
{
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
  protected NamespaceImpl()
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
    return IndexTestLanguagePackage.Literals.NAMESPACE;
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
      namedElements = new EObjectContainmentEList<NamedElement>(NamedElement.class, this, IndexTestLanguagePackage.NAMESPACE__NAMED_ELEMENTS);
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
      case IndexTestLanguagePackage.NAMESPACE__NAMED_ELEMENTS:
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
      case IndexTestLanguagePackage.NAMESPACE__NAMED_ELEMENTS:
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
      case IndexTestLanguagePackage.NAMESPACE__NAMED_ELEMENTS:
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
      case IndexTestLanguagePackage.NAMESPACE__NAMED_ELEMENTS:
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
      case IndexTestLanguagePackage.NAMESPACE__NAMED_ELEMENTS:
        return namedElements != null && !namedElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //NamespaceImpl
