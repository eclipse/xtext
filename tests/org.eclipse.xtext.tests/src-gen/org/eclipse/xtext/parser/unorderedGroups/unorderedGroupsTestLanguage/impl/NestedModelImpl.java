/**
 */
package org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nested Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.NestedModelImpl#isFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.NestedModelImpl#isSecond <em>Second</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NestedModelImpl extends MinimalEObjectImpl.Container implements NestedModel
{
  /**
   * The default value of the '{@link #isFirst() <em>First</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFirst()
   * @generated
   * @ordered
   */
  protected static final boolean FIRST_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFirst() <em>First</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFirst()
   * @generated
   * @ordered
   */
  protected boolean first = FIRST_EDEFAULT;

  /**
   * The default value of the '{@link #isSecond() <em>Second</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSecond()
   * @generated
   * @ordered
   */
  protected static final boolean SECOND_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSecond() <em>Second</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSecond()
   * @generated
   * @ordered
   */
  protected boolean second = SECOND_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NestedModelImpl()
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
    return UnorderedGroupsTestLanguagePackage.Literals.NESTED_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFirst()
  {
    return first;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirst(boolean newFirst)
  {
    boolean oldFirst = first;
    first = newFirst;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.NESTED_MODEL__FIRST, oldFirst, first));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSecond()
  {
    return second;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecond(boolean newSecond)
  {
    boolean oldSecond = second;
    second = newSecond;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.NESTED_MODEL__SECOND, oldSecond, second));
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
      case UnorderedGroupsTestLanguagePackage.NESTED_MODEL__FIRST:
        return isFirst();
      case UnorderedGroupsTestLanguagePackage.NESTED_MODEL__SECOND:
        return isSecond();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UnorderedGroupsTestLanguagePackage.NESTED_MODEL__FIRST:
        setFirst((Boolean)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.NESTED_MODEL__SECOND:
        setSecond((Boolean)newValue);
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
      case UnorderedGroupsTestLanguagePackage.NESTED_MODEL__FIRST:
        setFirst(FIRST_EDEFAULT);
        return;
      case UnorderedGroupsTestLanguagePackage.NESTED_MODEL__SECOND:
        setSecond(SECOND_EDEFAULT);
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
      case UnorderedGroupsTestLanguagePackage.NESTED_MODEL__FIRST:
        return first != FIRST_EDEFAULT;
      case UnorderedGroupsTestLanguagePackage.NESTED_MODEL__SECOND:
        return second != SECOND_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (first: ");
    result.append(first);
    result.append(", second: ");
    result.append(second);
    result.append(')');
    return result.toString();
  }

} //NestedModelImpl
