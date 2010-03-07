/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Feature;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bug304681 Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ModelImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ModelImpl#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ModelImpl#getUid <em>Uid</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ModelImpl#isFlag <em>Flag</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.Bug304681ModelImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Bug304681ModelImpl extends MinimalEObjectImpl.Container implements Bug304681Model
{
  /**
   * The default value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortDescription()
   * @generated
   * @ordered
   */
  protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortDescription()
   * @generated
   * @ordered
   */
  protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLongDescription()
   * @generated
   * @ordered
   */
  protected static final String LONG_DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLongDescription()
   * @generated
   * @ordered
   */
  protected String longDescription = LONG_DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getUid() <em>Uid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUid()
   * @generated
   * @ordered
   */
  protected static final String UID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUid() <em>Uid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUid()
   * @generated
   * @ordered
   */
  protected String uid = UID_EDEFAULT;

  /**
   * The default value of the '{@link #isFlag() <em>Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFlag()
   * @generated
   * @ordered
   */
  protected static final boolean FLAG_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFlag() <em>Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFlag()
   * @generated
   * @ordered
   */
  protected boolean flag = FLAG_EDEFAULT;

  /**
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList<Bug304681Feature> features;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Bug304681ModelImpl()
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
    return UnorderedGroupsTestPackage.Literals.BUG304681_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getShortDescription()
  {
    return shortDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShortDescription(String newShortDescription)
  {
    String oldShortDescription = shortDescription;
    shortDescription = newShortDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.BUG304681_MODEL__SHORT_DESCRIPTION, oldShortDescription, shortDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLongDescription()
  {
    return longDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLongDescription(String newLongDescription)
  {
    String oldLongDescription = longDescription;
    longDescription = newLongDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.BUG304681_MODEL__LONG_DESCRIPTION, oldLongDescription, longDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUid()
  {
    return uid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUid(String newUid)
  {
    String oldUid = uid;
    uid = newUid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.BUG304681_MODEL__UID, oldUid, uid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFlag()
  {
    return flag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFlag(boolean newFlag)
  {
    boolean oldFlag = flag;
    flag = newFlag;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.BUG304681_MODEL__FLAG, oldFlag, flag));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Bug304681Feature> getFeatures()
  {
    if (features == null)
    {
      features = new EObjectContainmentEList<Bug304681Feature>(Bug304681Feature.class, this, UnorderedGroupsTestPackage.BUG304681_MODEL__FEATURES);
    }
    return features;
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
      case UnorderedGroupsTestPackage.BUG304681_MODEL__FEATURES:
        return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
      case UnorderedGroupsTestPackage.BUG304681_MODEL__SHORT_DESCRIPTION:
        return getShortDescription();
      case UnorderedGroupsTestPackage.BUG304681_MODEL__LONG_DESCRIPTION:
        return getLongDescription();
      case UnorderedGroupsTestPackage.BUG304681_MODEL__UID:
        return getUid();
      case UnorderedGroupsTestPackage.BUG304681_MODEL__FLAG:
        return isFlag();
      case UnorderedGroupsTestPackage.BUG304681_MODEL__FEATURES:
        return getFeatures();
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
      case UnorderedGroupsTestPackage.BUG304681_MODEL__SHORT_DESCRIPTION:
        setShortDescription((String)newValue);
        return;
      case UnorderedGroupsTestPackage.BUG304681_MODEL__LONG_DESCRIPTION:
        setLongDescription((String)newValue);
        return;
      case UnorderedGroupsTestPackage.BUG304681_MODEL__UID:
        setUid((String)newValue);
        return;
      case UnorderedGroupsTestPackage.BUG304681_MODEL__FLAG:
        setFlag((Boolean)newValue);
        return;
      case UnorderedGroupsTestPackage.BUG304681_MODEL__FEATURES:
        getFeatures().clear();
        getFeatures().addAll((Collection<? extends Bug304681Feature>)newValue);
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
      case UnorderedGroupsTestPackage.BUG304681_MODEL__SHORT_DESCRIPTION:
        setShortDescription(SHORT_DESCRIPTION_EDEFAULT);
        return;
      case UnorderedGroupsTestPackage.BUG304681_MODEL__LONG_DESCRIPTION:
        setLongDescription(LONG_DESCRIPTION_EDEFAULT);
        return;
      case UnorderedGroupsTestPackage.BUG304681_MODEL__UID:
        setUid(UID_EDEFAULT);
        return;
      case UnorderedGroupsTestPackage.BUG304681_MODEL__FLAG:
        setFlag(FLAG_EDEFAULT);
        return;
      case UnorderedGroupsTestPackage.BUG304681_MODEL__FEATURES:
        getFeatures().clear();
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
      case UnorderedGroupsTestPackage.BUG304681_MODEL__SHORT_DESCRIPTION:
        return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals(shortDescription);
      case UnorderedGroupsTestPackage.BUG304681_MODEL__LONG_DESCRIPTION:
        return LONG_DESCRIPTION_EDEFAULT == null ? longDescription != null : !LONG_DESCRIPTION_EDEFAULT.equals(longDescription);
      case UnorderedGroupsTestPackage.BUG304681_MODEL__UID:
        return UID_EDEFAULT == null ? uid != null : !UID_EDEFAULT.equals(uid);
      case UnorderedGroupsTestPackage.BUG304681_MODEL__FLAG:
        return flag != FLAG_EDEFAULT;
      case UnorderedGroupsTestPackage.BUG304681_MODEL__FEATURES:
        return features != null && !features.isEmpty();
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
    result.append(" (shortDescription: ");
    result.append(shortDescription);
    result.append(", longDescription: ");
    result.append(longDescription);
    result.append(", uid: ");
    result.append(uid);
    result.append(", flag: ");
    result.append(flag);
    result.append(')');
    return result.toString();
  }

} //Bug304681ModelImpl
