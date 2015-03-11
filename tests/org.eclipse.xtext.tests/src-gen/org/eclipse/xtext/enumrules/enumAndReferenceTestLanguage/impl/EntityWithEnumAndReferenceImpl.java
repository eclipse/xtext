/**
 */
package org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference;
import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguagePackage;
import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.KindOfKeyword;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity With Enum And Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EntityWithEnumAndReferenceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EntityWithEnumAndReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EntityWithEnumAndReferenceImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityWithEnumAndReferenceImpl extends MinimalEObjectImpl.Container implements EntityWithEnumAndReference
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final KindOfKeyword TYPE_EDEFAULT = KindOfKeyword.KIND_OF_KEYWORD;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected KindOfKeyword type = TYPE_EDEFAULT;

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
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected EntityWithEnumAndReference ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntityWithEnumAndReferenceImpl()
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
    return EnumAndReferenceTestLanguagePackage.Literals.ENTITY_WITH_ENUM_AND_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KindOfKeyword getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(KindOfKeyword newType)
  {
    KindOfKeyword oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__TYPE, oldType, type));
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
      eNotify(new ENotificationImpl(this, Notification.SET, EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntityWithEnumAndReference getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (EntityWithEnumAndReference)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntityWithEnumAndReference basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(EntityWithEnumAndReference newRef)
  {
    EntityWithEnumAndReference oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__REF, oldRef, ref));
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
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__TYPE:
        return getType();
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__NAME:
        return getName();
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__REF:
        if (resolve) return getRef();
        return basicGetRef();
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
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__TYPE:
        setType((KindOfKeyword)newValue);
        return;
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__NAME:
        setName((String)newValue);
        return;
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__REF:
        setRef((EntityWithEnumAndReference)newValue);
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
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__REF:
        setRef((EntityWithEnumAndReference)null);
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
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__TYPE:
        return type != TYPE_EDEFAULT;
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE__REF:
        return ref != null;
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

} //EntityWithEnumAndReferenceImpl
