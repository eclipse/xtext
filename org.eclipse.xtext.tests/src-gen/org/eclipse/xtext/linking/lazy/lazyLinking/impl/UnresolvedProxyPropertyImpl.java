/**
 */
package org.eclipse.xtext.linking.lazy.lazyLinking.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectEList;

import org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage;
import org.eclipse.xtext.linking.lazy.lazyLinking.Type;
import org.eclipse.xtext.linking.lazy.lazyLinking.UnresolvedProxyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unresolved Proxy Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.impl.UnresolvedProxyPropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.impl.UnresolvedProxyPropertyImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnresolvedProxyPropertyImpl extends MinimalEObjectImpl.Container implements UnresolvedProxyProperty
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EList<Type> type;

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
  protected UnresolvedProxyPropertyImpl()
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
    return LazyLinkingPackage.Literals.UNRESOLVED_PROXY_PROPERTY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Type> getType()
  {
    if (type == null)
    {
      type = new EObjectEList<Type>(Type.class, this, LazyLinkingPackage.UNRESOLVED_PROXY_PROPERTY__TYPE);
    }
    return type;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LazyLinkingPackage.UNRESOLVED_PROXY_PROPERTY__NAME, oldName, name));
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
      case LazyLinkingPackage.UNRESOLVED_PROXY_PROPERTY__TYPE:
        return getType();
      case LazyLinkingPackage.UNRESOLVED_PROXY_PROPERTY__NAME:
        return getName();
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
      case LazyLinkingPackage.UNRESOLVED_PROXY_PROPERTY__TYPE:
        getType().clear();
        getType().addAll((Collection<? extends Type>)newValue);
        return;
      case LazyLinkingPackage.UNRESOLVED_PROXY_PROPERTY__NAME:
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
      case LazyLinkingPackage.UNRESOLVED_PROXY_PROPERTY__TYPE:
        getType().clear();
        return;
      case LazyLinkingPackage.UNRESOLVED_PROXY_PROPERTY__NAME:
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
      case LazyLinkingPackage.UNRESOLVED_PROXY_PROPERTY__TYPE:
        return type != null && !type.isEmpty();
      case LazyLinkingPackage.UNRESOLVED_PROXY_PROPERTY__NAME:
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //UnresolvedProxyPropertyImpl
