/**
 */
package org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unordered Serialization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedSerializationImpl#isFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedSerializationImpl#isSecond <em>Second</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedSerializationImpl#isThird <em>Third</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedSerializationImpl#isForth <em>Forth</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedSerializationImpl#getFirstAsList <em>First As List</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedSerializationImpl#getSecondAsList <em>Second As List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnorderedSerializationImpl extends MinimalEObjectImpl.Container implements UnorderedSerialization
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
   * The default value of the '{@link #isThird() <em>Third</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isThird()
   * @generated
   * @ordered
   */
  protected static final boolean THIRD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isThird() <em>Third</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isThird()
   * @generated
   * @ordered
   */
  protected boolean third = THIRD_EDEFAULT;

  /**
   * The default value of the '{@link #isForth() <em>Forth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isForth()
   * @generated
   * @ordered
   */
  protected static final boolean FORTH_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isForth() <em>Forth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isForth()
   * @generated
   * @ordered
   */
  protected boolean forth = FORTH_EDEFAULT;

  /**
   * The cached value of the '{@link #getFirstAsList() <em>First As List</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstAsList()
   * @generated
   * @ordered
   */
  protected EList<String> firstAsList;

  /**
   * The cached value of the '{@link #getSecondAsList() <em>Second As List</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondAsList()
   * @generated
   * @ordered
   */
  protected EList<String> secondAsList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnorderedSerializationImpl()
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
    return UnorderedGroupsTestLanguagePackage.Literals.UNORDERED_SERIALIZATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FIRST, oldFirst, first));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__SECOND, oldSecond, second));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isThird()
  {
    return third;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThird(boolean newThird)
  {
    boolean oldThird = third;
    third = newThird;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__THIRD, oldThird, third));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isForth()
  {
    return forth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setForth(boolean newForth)
  {
    boolean oldForth = forth;
    forth = newForth;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FORTH, oldForth, forth));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getFirstAsList()
  {
    if (firstAsList == null)
    {
      firstAsList = new EDataTypeEList<String>(String.class, this, UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FIRST_AS_LIST);
    }
    return firstAsList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getSecondAsList()
  {
    if (secondAsList == null)
    {
      secondAsList = new EDataTypeEList<String>(String.class, this, UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__SECOND_AS_LIST);
    }
    return secondAsList;
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
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FIRST:
        return isFirst();
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__SECOND:
        return isSecond();
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__THIRD:
        return isThird();
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FORTH:
        return isForth();
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FIRST_AS_LIST:
        return getFirstAsList();
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__SECOND_AS_LIST:
        return getSecondAsList();
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
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FIRST:
        setFirst((Boolean)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__SECOND:
        setSecond((Boolean)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__THIRD:
        setThird((Boolean)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FORTH:
        setForth((Boolean)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FIRST_AS_LIST:
        getFirstAsList().clear();
        getFirstAsList().addAll((Collection<? extends String>)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__SECOND_AS_LIST:
        getSecondAsList().clear();
        getSecondAsList().addAll((Collection<? extends String>)newValue);
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
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FIRST:
        setFirst(FIRST_EDEFAULT);
        return;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__SECOND:
        setSecond(SECOND_EDEFAULT);
        return;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__THIRD:
        setThird(THIRD_EDEFAULT);
        return;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FORTH:
        setForth(FORTH_EDEFAULT);
        return;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FIRST_AS_LIST:
        getFirstAsList().clear();
        return;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__SECOND_AS_LIST:
        getSecondAsList().clear();
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
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FIRST:
        return first != FIRST_EDEFAULT;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__SECOND:
        return second != SECOND_EDEFAULT;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__THIRD:
        return third != THIRD_EDEFAULT;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FORTH:
        return forth != FORTH_EDEFAULT;
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__FIRST_AS_LIST:
        return firstAsList != null && !firstAsList.isEmpty();
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION__SECOND_AS_LIST:
        return secondAsList != null && !secondAsList.isEmpty();
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
    result.append(", third: ");
    result.append(third);
    result.append(", forth: ");
    result.append(forth);
    result.append(", firstAsList: ");
    result.append(firstAsList);
    result.append(", secondAsList: ");
    result.append(secondAsList);
    result.append(')');
    return result.toString();
  }

} //UnorderedSerializationImpl
