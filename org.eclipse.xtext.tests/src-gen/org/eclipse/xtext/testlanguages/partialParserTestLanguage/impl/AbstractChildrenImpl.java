/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChild;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChildren;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Children</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.AbstractChildrenImpl#getAbstractChildren <em>Abstract Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractChildrenImpl extends ContentImpl implements AbstractChildren
{
  /**
   * The cached value of the '{@link #getAbstractChildren() <em>Abstract Children</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbstractChildren()
   * @generated
   * @ordered
   */
  protected EList<AbstractChild> abstractChildren;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractChildrenImpl()
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
    return PartialParserTestLanguagePackage.Literals.ABSTRACT_CHILDREN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractChild> getAbstractChildren()
  {
    if (abstractChildren == null)
    {
      abstractChildren = new EObjectContainmentEList<AbstractChild>(AbstractChild.class, this, PartialParserTestLanguagePackage.ABSTRACT_CHILDREN__ABSTRACT_CHILDREN);
    }
    return abstractChildren;
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
      case PartialParserTestLanguagePackage.ABSTRACT_CHILDREN__ABSTRACT_CHILDREN:
        return ((InternalEList<?>)getAbstractChildren()).basicRemove(otherEnd, msgs);
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
      case PartialParserTestLanguagePackage.ABSTRACT_CHILDREN__ABSTRACT_CHILDREN:
        return getAbstractChildren();
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
      case PartialParserTestLanguagePackage.ABSTRACT_CHILDREN__ABSTRACT_CHILDREN:
        getAbstractChildren().clear();
        getAbstractChildren().addAll((Collection<? extends AbstractChild>)newValue);
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
      case PartialParserTestLanguagePackage.ABSTRACT_CHILDREN__ABSTRACT_CHILDREN:
        getAbstractChildren().clear();
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
      case PartialParserTestLanguagePackage.ABSTRACT_CHILDREN__ABSTRACT_CHILDREN:
        return abstractChildren != null && !abstractChildren.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AbstractChildrenImpl
