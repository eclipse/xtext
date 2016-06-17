/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.SecondConcrete;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Second Concrete</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.SecondConcreteImpl#getReferencedChildren <em>Referenced Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SecondConcreteImpl extends AbstractChildImpl implements SecondConcrete
{
  /**
   * The cached value of the '{@link #getReferencedChildren() <em>Referenced Children</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencedChildren()
   * @generated
   * @ordered
   */
  protected EList<Child> referencedChildren;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SecondConcreteImpl()
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
    return PartialParserTestLanguagePackage.Literals.SECOND_CONCRETE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Child> getReferencedChildren()
  {
    if (referencedChildren == null)
    {
      referencedChildren = new EObjectResolvingEList<Child>(Child.class, this, PartialParserTestLanguagePackage.SECOND_CONCRETE__REFERENCED_CHILDREN);
    }
    return referencedChildren;
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
      case PartialParserTestLanguagePackage.SECOND_CONCRETE__REFERENCED_CHILDREN:
        return getReferencedChildren();
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
      case PartialParserTestLanguagePackage.SECOND_CONCRETE__REFERENCED_CHILDREN:
        getReferencedChildren().clear();
        getReferencedChildren().addAll((Collection<? extends Child>)newValue);
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
      case PartialParserTestLanguagePackage.SECOND_CONCRETE__REFERENCED_CHILDREN:
        getReferencedChildren().clear();
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
      case PartialParserTestLanguagePackage.SECOND_CONCRETE__REFERENCED_CHILDREN:
        return referencedChildren != null && !referencedChildren.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SecondConcreteImpl
