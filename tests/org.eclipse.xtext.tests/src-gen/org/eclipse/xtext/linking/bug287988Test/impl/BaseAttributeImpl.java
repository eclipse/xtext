/**
 */
package org.eclipse.xtext.linking.bug287988Test.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.linking.bug287988Test.BaseAttribute;
import org.eclipse.xtext.linking.bug287988Test.Bug287988TestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.bug287988Test.impl.BaseAttributeImpl#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug287988Test.impl.BaseAttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug287988Test.impl.BaseAttributeImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BaseAttributeImpl extends MinimalEObjectImpl.Container implements BaseAttribute
{
  /**
   * The cached value of the '{@link #getTypeRef() <em>Type Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeRef()
   * @generated
   * @ordered
   */
  protected BaseAttribute typeRef;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BaseAttributeImpl()
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
    return Bug287988TestPackage.Literals.BASE_ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BaseAttribute getTypeRef()
  {
    if (typeRef != null && typeRef.eIsProxy())
    {
      InternalEObject oldTypeRef = (InternalEObject)typeRef;
      typeRef = (BaseAttribute)eResolveProxy(oldTypeRef);
      if (typeRef != oldTypeRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug287988TestPackage.BASE_ATTRIBUTE__TYPE_REF, oldTypeRef, typeRef));
      }
    }
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BaseAttribute basicGetTypeRef()
  {
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeRef(BaseAttribute newTypeRef)
  {
    BaseAttribute oldTypeRef = typeRef;
    typeRef = newTypeRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287988TestPackage.BASE_ATTRIBUTE__TYPE_REF, oldTypeRef, typeRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287988TestPackage.BASE_ATTRIBUTE__TYPE, oldType, type));
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
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287988TestPackage.BASE_ATTRIBUTE__NAME, oldName, name));
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
      case Bug287988TestPackage.BASE_ATTRIBUTE__TYPE_REF:
        if (resolve) return getTypeRef();
        return basicGetTypeRef();
      case Bug287988TestPackage.BASE_ATTRIBUTE__TYPE:
        return getType();
      case Bug287988TestPackage.BASE_ATTRIBUTE__NAME:
        return getName();
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
      case Bug287988TestPackage.BASE_ATTRIBUTE__TYPE_REF:
        setTypeRef((BaseAttribute)newValue);
        return;
      case Bug287988TestPackage.BASE_ATTRIBUTE__TYPE:
        setType((String)newValue);
        return;
      case Bug287988TestPackage.BASE_ATTRIBUTE__NAME:
        setName((String)newValue);
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
      case Bug287988TestPackage.BASE_ATTRIBUTE__TYPE_REF:
        setTypeRef((BaseAttribute)null);
        return;
      case Bug287988TestPackage.BASE_ATTRIBUTE__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case Bug287988TestPackage.BASE_ATTRIBUTE__NAME:
        setName(NAME_EDEFAULT);
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
      case Bug287988TestPackage.BASE_ATTRIBUTE__TYPE_REF:
        return typeRef != null;
      case Bug287988TestPackage.BASE_ATTRIBUTE__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case Bug287988TestPackage.BASE_ATTRIBUTE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
    result.append(" (type: ");
    result.append(type);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //BaseAttributeImpl
