/**
 */
package org.eclipse.xtext.example.tutorial.tutorial.impl;

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

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.example.tutorial.tutorial.Entity;
import org.eclipse.xtext.example.tutorial.tutorial.Property;
import org.eclipse.xtext.example.tutorial.tutorial.TutorialPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.tutorial.tutorial.impl.EntityImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.tutorial.tutorial.impl.EntityImpl#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.tutorial.tutorial.impl.EntityImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityImpl extends MinimalEObjectImpl.Container implements Entity
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getSuperType() <em>Super Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperType()
   * @generated
   * @ordered
   */
  protected JvmTypeReference superType;

  /**
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList<Property> features;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntityImpl()
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
    return TutorialPackage.Literals.ENTITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TutorialPackage.ENTITY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmTypeReference getSuperType()
  {
    return superType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSuperType(JvmTypeReference newSuperType, NotificationChain msgs)
  {
    JvmTypeReference oldSuperType = superType;
    superType = newSuperType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TutorialPackage.ENTITY__SUPER_TYPE, oldSuperType, newSuperType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuperType(JvmTypeReference newSuperType)
  {
    if (newSuperType != superType)
    {
      NotificationChain msgs = null;
      if (superType != null)
        msgs = ((InternalEObject)superType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TutorialPackage.ENTITY__SUPER_TYPE, null, msgs);
      if (newSuperType != null)
        msgs = ((InternalEObject)newSuperType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TutorialPackage.ENTITY__SUPER_TYPE, null, msgs);
      msgs = basicSetSuperType(newSuperType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TutorialPackage.ENTITY__SUPER_TYPE, newSuperType, newSuperType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Property> getFeatures()
  {
    if (features == null)
    {
      features = new EObjectContainmentEList<Property>(Property.class, this, TutorialPackage.ENTITY__FEATURES);
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
      case TutorialPackage.ENTITY__SUPER_TYPE:
        return basicSetSuperType(null, msgs);
      case TutorialPackage.ENTITY__FEATURES:
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
      case TutorialPackage.ENTITY__NAME:
        return getName();
      case TutorialPackage.ENTITY__SUPER_TYPE:
        return getSuperType();
      case TutorialPackage.ENTITY__FEATURES:
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
      case TutorialPackage.ENTITY__NAME:
        setName((String)newValue);
        return;
      case TutorialPackage.ENTITY__SUPER_TYPE:
        setSuperType((JvmTypeReference)newValue);
        return;
      case TutorialPackage.ENTITY__FEATURES:
        getFeatures().clear();
        getFeatures().addAll((Collection<? extends Property>)newValue);
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
      case TutorialPackage.ENTITY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TutorialPackage.ENTITY__SUPER_TYPE:
        setSuperType((JvmTypeReference)null);
        return;
      case TutorialPackage.ENTITY__FEATURES:
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
      case TutorialPackage.ENTITY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TutorialPackage.ENTITY__SUPER_TYPE:
        return superType != null;
      case TutorialPackage.ENTITY__FEATURES:
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //EntityImpl
