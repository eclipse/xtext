/**
 */
package org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl#isFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl#isSecond <em>Second</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl#isThird <em>Third</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl#isForth <em>Forth</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl#getFirstAsList <em>First As List</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl#getSecondAsList <em>Second As List</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl#getThirdAsList <em>Third As List</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl#getForthAsList <em>Forth As List</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl#getSerialized <em>Serialized</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl#getNestedModel <em>Nested Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
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
   * The cached value of the '{@link #getThirdAsList() <em>Third As List</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThirdAsList()
   * @generated
   * @ordered
   */
  protected EList<String> thirdAsList;

  /**
   * The cached value of the '{@link #getForthAsList() <em>Forth As List</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getForthAsList()
   * @generated
   * @ordered
   */
  protected EList<String> forthAsList;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getSerialized() <em>Serialized</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSerialized()
   * @generated
   * @ordered
   */
  protected UnorderedSerialization serialized;

  /**
   * The cached value of the '{@link #getNestedModel() <em>Nested Model</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNestedModel()
   * @generated
   * @ordered
   */
  protected EList<NestedModel> nestedModel;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return UnorderedGroupsTestLanguagePackage.Literals.MODEL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.MODEL__FIRST, oldFirst, first));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.MODEL__SECOND, oldSecond, second));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.MODEL__THIRD, oldThird, third));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.MODEL__FORTH, oldForth, forth));
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
      firstAsList = new EDataTypeEList<String>(String.class, this, UnorderedGroupsTestLanguagePackage.MODEL__FIRST_AS_LIST);
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
      secondAsList = new EDataTypeEList<String>(String.class, this, UnorderedGroupsTestLanguagePackage.MODEL__SECOND_AS_LIST);
    }
    return secondAsList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getThirdAsList()
  {
    if (thirdAsList == null)
    {
      thirdAsList = new EDataTypeEList<String>(String.class, this, UnorderedGroupsTestLanguagePackage.MODEL__THIRD_AS_LIST);
    }
    return thirdAsList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getForthAsList()
  {
    if (forthAsList == null)
    {
      forthAsList = new EDataTypeEList<String>(String.class, this, UnorderedGroupsTestLanguagePackage.MODEL__FORTH_AS_LIST);
    }
    return forthAsList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.MODEL__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedSerialization getSerialized()
  {
    return serialized;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSerialized(UnorderedSerialization newSerialized, NotificationChain msgs)
  {
    UnorderedSerialization oldSerialized = serialized;
    serialized = newSerialized;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.MODEL__SERIALIZED, oldSerialized, newSerialized);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSerialized(UnorderedSerialization newSerialized)
  {
    if (newSerialized != serialized)
    {
      NotificationChain msgs = null;
      if (serialized != null)
        msgs = ((InternalEObject)serialized).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestLanguagePackage.MODEL__SERIALIZED, null, msgs);
      if (newSerialized != null)
        msgs = ((InternalEObject)newSerialized).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UnorderedGroupsTestLanguagePackage.MODEL__SERIALIZED, null, msgs);
      msgs = basicSetSerialized(newSerialized, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestLanguagePackage.MODEL__SERIALIZED, newSerialized, newSerialized));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NestedModel> getNestedModel()
  {
    if (nestedModel == null)
    {
      nestedModel = new EObjectContainmentEList<NestedModel>(NestedModel.class, this, UnorderedGroupsTestLanguagePackage.MODEL__NESTED_MODEL);
    }
    return nestedModel;
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
      case UnorderedGroupsTestLanguagePackage.MODEL__SERIALIZED:
        return basicSetSerialized(null, msgs);
      case UnorderedGroupsTestLanguagePackage.MODEL__NESTED_MODEL:
        return ((InternalEList<?>)getNestedModel()).basicRemove(otherEnd, msgs);
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
      case UnorderedGroupsTestLanguagePackage.MODEL__FIRST:
        return isFirst();
      case UnorderedGroupsTestLanguagePackage.MODEL__SECOND:
        return isSecond();
      case UnorderedGroupsTestLanguagePackage.MODEL__THIRD:
        return isThird();
      case UnorderedGroupsTestLanguagePackage.MODEL__FORTH:
        return isForth();
      case UnorderedGroupsTestLanguagePackage.MODEL__FIRST_AS_LIST:
        return getFirstAsList();
      case UnorderedGroupsTestLanguagePackage.MODEL__SECOND_AS_LIST:
        return getSecondAsList();
      case UnorderedGroupsTestLanguagePackage.MODEL__THIRD_AS_LIST:
        return getThirdAsList();
      case UnorderedGroupsTestLanguagePackage.MODEL__FORTH_AS_LIST:
        return getForthAsList();
      case UnorderedGroupsTestLanguagePackage.MODEL__VALUE:
        return getValue();
      case UnorderedGroupsTestLanguagePackage.MODEL__SERIALIZED:
        return getSerialized();
      case UnorderedGroupsTestLanguagePackage.MODEL__NESTED_MODEL:
        return getNestedModel();
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
      case UnorderedGroupsTestLanguagePackage.MODEL__FIRST:
        setFirst((Boolean)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__SECOND:
        setSecond((Boolean)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__THIRD:
        setThird((Boolean)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__FORTH:
        setForth((Boolean)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__FIRST_AS_LIST:
        getFirstAsList().clear();
        getFirstAsList().addAll((Collection<? extends String>)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__SECOND_AS_LIST:
        getSecondAsList().clear();
        getSecondAsList().addAll((Collection<? extends String>)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__THIRD_AS_LIST:
        getThirdAsList().clear();
        getThirdAsList().addAll((Collection<? extends String>)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__FORTH_AS_LIST:
        getForthAsList().clear();
        getForthAsList().addAll((Collection<? extends String>)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__VALUE:
        setValue((String)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__SERIALIZED:
        setSerialized((UnorderedSerialization)newValue);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__NESTED_MODEL:
        getNestedModel().clear();
        getNestedModel().addAll((Collection<? extends NestedModel>)newValue);
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
      case UnorderedGroupsTestLanguagePackage.MODEL__FIRST:
        setFirst(FIRST_EDEFAULT);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__SECOND:
        setSecond(SECOND_EDEFAULT);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__THIRD:
        setThird(THIRD_EDEFAULT);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__FORTH:
        setForth(FORTH_EDEFAULT);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__FIRST_AS_LIST:
        getFirstAsList().clear();
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__SECOND_AS_LIST:
        getSecondAsList().clear();
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__THIRD_AS_LIST:
        getThirdAsList().clear();
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__FORTH_AS_LIST:
        getForthAsList().clear();
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__SERIALIZED:
        setSerialized((UnorderedSerialization)null);
        return;
      case UnorderedGroupsTestLanguagePackage.MODEL__NESTED_MODEL:
        getNestedModel().clear();
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
      case UnorderedGroupsTestLanguagePackage.MODEL__FIRST:
        return first != FIRST_EDEFAULT;
      case UnorderedGroupsTestLanguagePackage.MODEL__SECOND:
        return second != SECOND_EDEFAULT;
      case UnorderedGroupsTestLanguagePackage.MODEL__THIRD:
        return third != THIRD_EDEFAULT;
      case UnorderedGroupsTestLanguagePackage.MODEL__FORTH:
        return forth != FORTH_EDEFAULT;
      case UnorderedGroupsTestLanguagePackage.MODEL__FIRST_AS_LIST:
        return firstAsList != null && !firstAsList.isEmpty();
      case UnorderedGroupsTestLanguagePackage.MODEL__SECOND_AS_LIST:
        return secondAsList != null && !secondAsList.isEmpty();
      case UnorderedGroupsTestLanguagePackage.MODEL__THIRD_AS_LIST:
        return thirdAsList != null && !thirdAsList.isEmpty();
      case UnorderedGroupsTestLanguagePackage.MODEL__FORTH_AS_LIST:
        return forthAsList != null && !forthAsList.isEmpty();
      case UnorderedGroupsTestLanguagePackage.MODEL__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case UnorderedGroupsTestLanguagePackage.MODEL__SERIALIZED:
        return serialized != null;
      case UnorderedGroupsTestLanguagePackage.MODEL__NESTED_MODEL:
        return nestedModel != null && !nestedModel.isEmpty();
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
    result.append(", thirdAsList: ");
    result.append(thirdAsList);
    result.append(", forthAsList: ");
    result.append(forthAsList);
    result.append(", value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
