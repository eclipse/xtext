/**
 */
package org.eclipse.xtext.validation.csvalidationtest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage;
import org.eclipse.xtext.validation.csvalidationtest.TwoVersion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Two Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.TwoVersionImpl#getShared1 <em>Shared1</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.TwoVersionImpl#getShared2 <em>Shared2</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.TwoVersionImpl#getShared3 <em>Shared3</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.TwoVersionImpl#getVersion1 <em>Version1</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.TwoVersionImpl#getExtra1 <em>Extra1</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.TwoVersionImpl#getExtra2 <em>Extra2</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.TwoVersionImpl#getExtra3 <em>Extra3</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.TwoVersionImpl#getExtra4 <em>Extra4</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TwoVersionImpl extends MinimalEObjectImpl.Container implements TwoVersion
{
  /**
   * The default value of the '{@link #getShared1() <em>Shared1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShared1()
   * @generated
   * @ordered
   */
  protected static final String SHARED1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getShared1() <em>Shared1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShared1()
   * @generated
   * @ordered
   */
  protected String shared1 = SHARED1_EDEFAULT;

  /**
   * The default value of the '{@link #getShared2() <em>Shared2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShared2()
   * @generated
   * @ordered
   */
  protected static final String SHARED2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getShared2() <em>Shared2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShared2()
   * @generated
   * @ordered
   */
  protected String shared2 = SHARED2_EDEFAULT;

  /**
   * The cached value of the '{@link #getShared3() <em>Shared3</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShared3()
   * @generated
   * @ordered
   */
  protected EList<String> shared3;

  /**
   * The default value of the '{@link #getVersion1() <em>Version1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion1()
   * @generated
   * @ordered
   */
  protected static final String VERSION1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVersion1() <em>Version1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion1()
   * @generated
   * @ordered
   */
  protected String version1 = VERSION1_EDEFAULT;

  /**
   * The default value of the '{@link #getExtra1() <em>Extra1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtra1()
   * @generated
   * @ordered
   */
  protected static final String EXTRA1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExtra1() <em>Extra1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtra1()
   * @generated
   * @ordered
   */
  protected String extra1 = EXTRA1_EDEFAULT;

  /**
   * The default value of the '{@link #getExtra2() <em>Extra2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtra2()
   * @generated
   * @ordered
   */
  protected static final String EXTRA2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExtra2() <em>Extra2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtra2()
   * @generated
   * @ordered
   */
  protected String extra2 = EXTRA2_EDEFAULT;

  /**
   * The default value of the '{@link #getExtra3() <em>Extra3</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtra3()
   * @generated
   * @ordered
   */
  protected static final String EXTRA3_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExtra3() <em>Extra3</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtra3()
   * @generated
   * @ordered
   */
  protected String extra3 = EXTRA3_EDEFAULT;

  /**
   * The default value of the '{@link #getExtra4() <em>Extra4</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtra4()
   * @generated
   * @ordered
   */
  protected static final String EXTRA4_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExtra4() <em>Extra4</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtra4()
   * @generated
   * @ordered
   */
  protected String extra4 = EXTRA4_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TwoVersionImpl()
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
    return CsvalidationtestPackage.Literals.TWO_VERSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getShared1()
  {
    return shared1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShared1(String newShared1)
  {
    String oldShared1 = shared1;
    shared1 = newShared1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.TWO_VERSION__SHARED1, oldShared1, shared1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getShared2()
  {
    return shared2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShared2(String newShared2)
  {
    String oldShared2 = shared2;
    shared2 = newShared2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.TWO_VERSION__SHARED2, oldShared2, shared2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getShared3()
  {
    if (shared3 == null)
    {
      shared3 = new EDataTypeEList<String>(String.class, this, CsvalidationtestPackage.TWO_VERSION__SHARED3);
    }
    return shared3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVersion1()
  {
    return version1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersion1(String newVersion1)
  {
    String oldVersion1 = version1;
    version1 = newVersion1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.TWO_VERSION__VERSION1, oldVersion1, version1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExtra1()
  {
    return extra1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtra1(String newExtra1)
  {
    String oldExtra1 = extra1;
    extra1 = newExtra1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.TWO_VERSION__EXTRA1, oldExtra1, extra1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExtra2()
  {
    return extra2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtra2(String newExtra2)
  {
    String oldExtra2 = extra2;
    extra2 = newExtra2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.TWO_VERSION__EXTRA2, oldExtra2, extra2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExtra3()
  {
    return extra3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtra3(String newExtra3)
  {
    String oldExtra3 = extra3;
    extra3 = newExtra3;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.TWO_VERSION__EXTRA3, oldExtra3, extra3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExtra4()
  {
    return extra4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtra4(String newExtra4)
  {
    String oldExtra4 = extra4;
    extra4 = newExtra4;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.TWO_VERSION__EXTRA4, oldExtra4, extra4));
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
      case CsvalidationtestPackage.TWO_VERSION__SHARED1:
        return getShared1();
      case CsvalidationtestPackage.TWO_VERSION__SHARED2:
        return getShared2();
      case CsvalidationtestPackage.TWO_VERSION__SHARED3:
        return getShared3();
      case CsvalidationtestPackage.TWO_VERSION__VERSION1:
        return getVersion1();
      case CsvalidationtestPackage.TWO_VERSION__EXTRA1:
        return getExtra1();
      case CsvalidationtestPackage.TWO_VERSION__EXTRA2:
        return getExtra2();
      case CsvalidationtestPackage.TWO_VERSION__EXTRA3:
        return getExtra3();
      case CsvalidationtestPackage.TWO_VERSION__EXTRA4:
        return getExtra4();
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
      case CsvalidationtestPackage.TWO_VERSION__SHARED1:
        setShared1((String)newValue);
        return;
      case CsvalidationtestPackage.TWO_VERSION__SHARED2:
        setShared2((String)newValue);
        return;
      case CsvalidationtestPackage.TWO_VERSION__SHARED3:
        getShared3().clear();
        getShared3().addAll((Collection<? extends String>)newValue);
        return;
      case CsvalidationtestPackage.TWO_VERSION__VERSION1:
        setVersion1((String)newValue);
        return;
      case CsvalidationtestPackage.TWO_VERSION__EXTRA1:
        setExtra1((String)newValue);
        return;
      case CsvalidationtestPackage.TWO_VERSION__EXTRA2:
        setExtra2((String)newValue);
        return;
      case CsvalidationtestPackage.TWO_VERSION__EXTRA3:
        setExtra3((String)newValue);
        return;
      case CsvalidationtestPackage.TWO_VERSION__EXTRA4:
        setExtra4((String)newValue);
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
      case CsvalidationtestPackage.TWO_VERSION__SHARED1:
        setShared1(SHARED1_EDEFAULT);
        return;
      case CsvalidationtestPackage.TWO_VERSION__SHARED2:
        setShared2(SHARED2_EDEFAULT);
        return;
      case CsvalidationtestPackage.TWO_VERSION__SHARED3:
        getShared3().clear();
        return;
      case CsvalidationtestPackage.TWO_VERSION__VERSION1:
        setVersion1(VERSION1_EDEFAULT);
        return;
      case CsvalidationtestPackage.TWO_VERSION__EXTRA1:
        setExtra1(EXTRA1_EDEFAULT);
        return;
      case CsvalidationtestPackage.TWO_VERSION__EXTRA2:
        setExtra2(EXTRA2_EDEFAULT);
        return;
      case CsvalidationtestPackage.TWO_VERSION__EXTRA3:
        setExtra3(EXTRA3_EDEFAULT);
        return;
      case CsvalidationtestPackage.TWO_VERSION__EXTRA4:
        setExtra4(EXTRA4_EDEFAULT);
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
      case CsvalidationtestPackage.TWO_VERSION__SHARED1:
        return SHARED1_EDEFAULT == null ? shared1 != null : !SHARED1_EDEFAULT.equals(shared1);
      case CsvalidationtestPackage.TWO_VERSION__SHARED2:
        return SHARED2_EDEFAULT == null ? shared2 != null : !SHARED2_EDEFAULT.equals(shared2);
      case CsvalidationtestPackage.TWO_VERSION__SHARED3:
        return shared3 != null && !shared3.isEmpty();
      case CsvalidationtestPackage.TWO_VERSION__VERSION1:
        return VERSION1_EDEFAULT == null ? version1 != null : !VERSION1_EDEFAULT.equals(version1);
      case CsvalidationtestPackage.TWO_VERSION__EXTRA1:
        return EXTRA1_EDEFAULT == null ? extra1 != null : !EXTRA1_EDEFAULT.equals(extra1);
      case CsvalidationtestPackage.TWO_VERSION__EXTRA2:
        return EXTRA2_EDEFAULT == null ? extra2 != null : !EXTRA2_EDEFAULT.equals(extra2);
      case CsvalidationtestPackage.TWO_VERSION__EXTRA3:
        return EXTRA3_EDEFAULT == null ? extra3 != null : !EXTRA3_EDEFAULT.equals(extra3);
      case CsvalidationtestPackage.TWO_VERSION__EXTRA4:
        return EXTRA4_EDEFAULT == null ? extra4 != null : !EXTRA4_EDEFAULT.equals(extra4);
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
    result.append(" (shared1: ");
    result.append(shared1);
    result.append(", shared2: ");
    result.append(shared2);
    result.append(", shared3: ");
    result.append(shared3);
    result.append(", version1: ");
    result.append(version1);
    result.append(", extra1: ");
    result.append(extra1);
    result.append(", extra2: ");
    result.append(extra2);
    result.append(", extra3: ");
    result.append(extra3);
    result.append(", extra4: ");
    result.append(extra4);
    result.append(')');
    return result.toString();
  }

} //TwoVersionImpl
