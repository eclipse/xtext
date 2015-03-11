/**
 */
package org.eclipse.xtext.linking.lazy.lazyLinking.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage;
import org.eclipse.xtext.linking.lazy.lazyLinking.Property;
import org.eclipse.xtext.linking.lazy.lazyLinking.Type;
import org.eclipse.xtext.linking.lazy.lazyLinking.UnresolvedProxyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.impl.TypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.impl.TypeImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.impl.TypeImpl#getParentId <em>Parent Id</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.impl.TypeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.impl.TypeImpl#getUnresolvedProxyProperty <em>Unresolved Proxy Property</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.impl.TypeImpl#getSubtypes <em>Subtypes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeImpl extends MinimalEObjectImpl.Container implements Type
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
   * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtends()
   * @generated
   * @ordered
   */
  protected Type extends_;

  /**
   * The cached value of the '{@link #getParentId() <em>Parent Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentId()
   * @generated
   * @ordered
   */
  protected Property parentId;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<Property> properties;

  /**
   * The cached value of the '{@link #getUnresolvedProxyProperty() <em>Unresolved Proxy Property</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnresolvedProxyProperty()
   * @generated
   * @ordered
   */
  protected EList<UnresolvedProxyProperty> unresolvedProxyProperty;

  /**
   * The cached value of the '{@link #getSubtypes() <em>Subtypes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubtypes()
   * @generated
   * @ordered
   */
  protected EList<Type> subtypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeImpl()
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
    return LazyLinkingPackage.Literals.TYPE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LazyLinkingPackage.TYPE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getExtends()
  {
    if (extends_ != null && extends_.eIsProxy())
    {
      InternalEObject oldExtends = (InternalEObject)extends_;
      extends_ = (Type)eResolveProxy(oldExtends);
      if (extends_ != oldExtends)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LazyLinkingPackage.TYPE__EXTENDS, oldExtends, extends_));
      }
    }
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type basicGetExtends()
  {
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtends(Type newExtends, NotificationChain msgs)
  {
    Type oldExtends = extends_;
    extends_ = newExtends;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LazyLinkingPackage.TYPE__EXTENDS, oldExtends, newExtends);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtends(Type newExtends)
  {
    if (newExtends != extends_)
    {
      NotificationChain msgs = null;
      if (extends_ != null)
        msgs = ((InternalEObject)extends_).eInverseRemove(this, LazyLinkingPackage.TYPE__SUBTYPES, Type.class, msgs);
      if (newExtends != null)
        msgs = ((InternalEObject)newExtends).eInverseAdd(this, LazyLinkingPackage.TYPE__SUBTYPES, Type.class, msgs);
      msgs = basicSetExtends(newExtends, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LazyLinkingPackage.TYPE__EXTENDS, newExtends, newExtends));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property getParentId()
  {
    if (parentId != null && parentId.eIsProxy())
    {
      InternalEObject oldParentId = (InternalEObject)parentId;
      parentId = (Property)eResolveProxy(oldParentId);
      if (parentId != oldParentId)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LazyLinkingPackage.TYPE__PARENT_ID, oldParentId, parentId));
      }
    }
    return parentId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property basicGetParentId()
  {
    return parentId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentId(Property newParentId)
  {
    Property oldParentId = parentId;
    parentId = newParentId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LazyLinkingPackage.TYPE__PARENT_ID, oldParentId, parentId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Property> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<Property>(Property.class, this, LazyLinkingPackage.TYPE__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UnresolvedProxyProperty> getUnresolvedProxyProperty()
  {
    if (unresolvedProxyProperty == null)
    {
      unresolvedProxyProperty = new EObjectContainmentEList<UnresolvedProxyProperty>(UnresolvedProxyProperty.class, this, LazyLinkingPackage.TYPE__UNRESOLVED_PROXY_PROPERTY);
    }
    return unresolvedProxyProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Type> getSubtypes()
  {
    if (subtypes == null)
    {
      subtypes = new EObjectWithInverseResolvingEList<Type>(Type.class, this, LazyLinkingPackage.TYPE__SUBTYPES, LazyLinkingPackage.TYPE__EXTENDS);
    }
    return subtypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case LazyLinkingPackage.TYPE__EXTENDS:
        if (extends_ != null)
          msgs = ((InternalEObject)extends_).eInverseRemove(this, LazyLinkingPackage.TYPE__SUBTYPES, Type.class, msgs);
        return basicSetExtends((Type)otherEnd, msgs);
      case LazyLinkingPackage.TYPE__SUBTYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubtypes()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
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
      case LazyLinkingPackage.TYPE__EXTENDS:
        return basicSetExtends(null, msgs);
      case LazyLinkingPackage.TYPE__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
      case LazyLinkingPackage.TYPE__UNRESOLVED_PROXY_PROPERTY:
        return ((InternalEList<?>)getUnresolvedProxyProperty()).basicRemove(otherEnd, msgs);
      case LazyLinkingPackage.TYPE__SUBTYPES:
        return ((InternalEList<?>)getSubtypes()).basicRemove(otherEnd, msgs);
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
      case LazyLinkingPackage.TYPE__NAME:
        return getName();
      case LazyLinkingPackage.TYPE__EXTENDS:
        if (resolve) return getExtends();
        return basicGetExtends();
      case LazyLinkingPackage.TYPE__PARENT_ID:
        if (resolve) return getParentId();
        return basicGetParentId();
      case LazyLinkingPackage.TYPE__PROPERTIES:
        return getProperties();
      case LazyLinkingPackage.TYPE__UNRESOLVED_PROXY_PROPERTY:
        return getUnresolvedProxyProperty();
      case LazyLinkingPackage.TYPE__SUBTYPES:
        return getSubtypes();
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
      case LazyLinkingPackage.TYPE__NAME:
        setName((String)newValue);
        return;
      case LazyLinkingPackage.TYPE__EXTENDS:
        setExtends((Type)newValue);
        return;
      case LazyLinkingPackage.TYPE__PARENT_ID:
        setParentId((Property)newValue);
        return;
      case LazyLinkingPackage.TYPE__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends Property>)newValue);
        return;
      case LazyLinkingPackage.TYPE__UNRESOLVED_PROXY_PROPERTY:
        getUnresolvedProxyProperty().clear();
        getUnresolvedProxyProperty().addAll((Collection<? extends UnresolvedProxyProperty>)newValue);
        return;
      case LazyLinkingPackage.TYPE__SUBTYPES:
        getSubtypes().clear();
        getSubtypes().addAll((Collection<? extends Type>)newValue);
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
      case LazyLinkingPackage.TYPE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case LazyLinkingPackage.TYPE__EXTENDS:
        setExtends((Type)null);
        return;
      case LazyLinkingPackage.TYPE__PARENT_ID:
        setParentId((Property)null);
        return;
      case LazyLinkingPackage.TYPE__PROPERTIES:
        getProperties().clear();
        return;
      case LazyLinkingPackage.TYPE__UNRESOLVED_PROXY_PROPERTY:
        getUnresolvedProxyProperty().clear();
        return;
      case LazyLinkingPackage.TYPE__SUBTYPES:
        getSubtypes().clear();
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
      case LazyLinkingPackage.TYPE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case LazyLinkingPackage.TYPE__EXTENDS:
        return extends_ != null;
      case LazyLinkingPackage.TYPE__PARENT_ID:
        return parentId != null;
      case LazyLinkingPackage.TYPE__PROPERTIES:
        return properties != null && !properties.isEmpty();
      case LazyLinkingPackage.TYPE__UNRESOLVED_PROXY_PROPERTY:
        return unresolvedProxyProperty != null && !unresolvedProxyProperty.isEmpty();
      case LazyLinkingPackage.TYPE__SUBTYPES:
        return subtypes != null && !subtypes.isEmpty();
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

} //TypeImpl
