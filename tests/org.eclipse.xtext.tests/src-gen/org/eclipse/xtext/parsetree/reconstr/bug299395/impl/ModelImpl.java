/**
 */
package org.eclipse.xtext.parsetree.reconstr.bug299395.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package;
import org.eclipse.xtext.parsetree.reconstr.bug299395.Model;
import org.eclipse.xtext.parsetree.reconstr.bug299395.SubModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.impl.ModelImpl#getStrings <em>Strings</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.impl.ModelImpl#getKeys <em>Keys</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.impl.ModelImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.impl.ModelImpl#getSubModel <em>Sub Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getStrings() <em>Strings</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrings()
   * @generated
   * @ordered
   */
  protected EList<String> strings;

  /**
   * The cached value of the '{@link #getKeys() <em>Keys</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeys()
   * @generated
   * @ordered
   */
  protected EList<String> keys;

  /**
   * The cached value of the '{@link #getValues() <em>Values</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValues()
   * @generated
   * @ordered
   */
  protected EList<String> values;

  /**
   * The cached value of the '{@link #getSubModel() <em>Sub Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubModel()
   * @generated
   * @ordered
   */
  protected SubModel subModel;

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
    return Bug299395Package.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getStrings()
  {
    if (strings == null)
    {
      strings = new EDataTypeEList<String>(String.class, this, Bug299395Package.MODEL__STRINGS);
    }
    return strings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getKeys()
  {
    if (keys == null)
    {
      keys = new EDataTypeEList<String>(String.class, this, Bug299395Package.MODEL__KEYS);
    }
    return keys;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getValues()
  {
    if (values == null)
    {
      values = new EDataTypeEList<String>(String.class, this, Bug299395Package.MODEL__VALUES);
    }
    return values;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubModel getSubModel()
  {
    return subModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubModel(SubModel newSubModel, NotificationChain msgs)
  {
    SubModel oldSubModel = subModel;
    subModel = newSubModel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug299395Package.MODEL__SUB_MODEL, oldSubModel, newSubModel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubModel(SubModel newSubModel)
  {
    if (newSubModel != subModel)
    {
      NotificationChain msgs = null;
      if (subModel != null)
        msgs = ((InternalEObject)subModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug299395Package.MODEL__SUB_MODEL, null, msgs);
      if (newSubModel != null)
        msgs = ((InternalEObject)newSubModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug299395Package.MODEL__SUB_MODEL, null, msgs);
      msgs = basicSetSubModel(newSubModel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug299395Package.MODEL__SUB_MODEL, newSubModel, newSubModel));
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
      case Bug299395Package.MODEL__SUB_MODEL:
        return basicSetSubModel(null, msgs);
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
      case Bug299395Package.MODEL__STRINGS:
        return getStrings();
      case Bug299395Package.MODEL__KEYS:
        return getKeys();
      case Bug299395Package.MODEL__VALUES:
        return getValues();
      case Bug299395Package.MODEL__SUB_MODEL:
        return getSubModel();
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
      case Bug299395Package.MODEL__STRINGS:
        getStrings().clear();
        getStrings().addAll((Collection<? extends String>)newValue);
        return;
      case Bug299395Package.MODEL__KEYS:
        getKeys().clear();
        getKeys().addAll((Collection<? extends String>)newValue);
        return;
      case Bug299395Package.MODEL__VALUES:
        getValues().clear();
        getValues().addAll((Collection<? extends String>)newValue);
        return;
      case Bug299395Package.MODEL__SUB_MODEL:
        setSubModel((SubModel)newValue);
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
      case Bug299395Package.MODEL__STRINGS:
        getStrings().clear();
        return;
      case Bug299395Package.MODEL__KEYS:
        getKeys().clear();
        return;
      case Bug299395Package.MODEL__VALUES:
        getValues().clear();
        return;
      case Bug299395Package.MODEL__SUB_MODEL:
        setSubModel((SubModel)null);
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
      case Bug299395Package.MODEL__STRINGS:
        return strings != null && !strings.isEmpty();
      case Bug299395Package.MODEL__KEYS:
        return keys != null && !keys.isEmpty();
      case Bug299395Package.MODEL__VALUES:
        return values != null && !values.isEmpty();
      case Bug299395Package.MODEL__SUB_MODEL:
        return subModel != null;
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
    result.append(" (strings: ");
    result.append(strings);
    result.append(", keys: ");
    result.append(keys);
    result.append(", values: ");
    result.append(values);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
