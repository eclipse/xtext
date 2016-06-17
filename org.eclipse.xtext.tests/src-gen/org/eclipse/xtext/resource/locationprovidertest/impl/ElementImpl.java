/**
 */
package org.eclipse.xtext.resource.locationprovidertest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.xtext.resource.locationprovidertest.Element;
import org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.impl.ElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.impl.ElementImpl#getSingleref <em>Singleref</em>}</li>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.impl.ElementImpl#getMultirefs <em>Multirefs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementImpl extends MinimalEObjectImpl.Container implements Element
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
   * The cached value of the '{@link #getSingleref() <em>Singleref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingleref()
   * @generated
   * @ordered
   */
  protected Element singleref;

  /**
   * The cached value of the '{@link #getMultirefs() <em>Multirefs</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultirefs()
   * @generated
   * @ordered
   */
  protected EList<Element> multirefs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElementImpl()
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
    return LocationprovidertestPackage.Literals.ELEMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LocationprovidertestPackage.ELEMENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getSingleref()
  {
    if (singleref != null && singleref.eIsProxy())
    {
      InternalEObject oldSingleref = (InternalEObject)singleref;
      singleref = (Element)eResolveProxy(oldSingleref);
      if (singleref != oldSingleref)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LocationprovidertestPackage.ELEMENT__SINGLEREF, oldSingleref, singleref));
      }
    }
    return singleref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element basicGetSingleref()
  {
    return singleref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSingleref(Element newSingleref)
  {
    Element oldSingleref = singleref;
    singleref = newSingleref;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LocationprovidertestPackage.ELEMENT__SINGLEREF, oldSingleref, singleref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Element> getMultirefs()
  {
    if (multirefs == null)
    {
      multirefs = new EObjectResolvingEList<Element>(Element.class, this, LocationprovidertestPackage.ELEMENT__MULTIREFS);
    }
    return multirefs;
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
      case LocationprovidertestPackage.ELEMENT__NAME:
        return getName();
      case LocationprovidertestPackage.ELEMENT__SINGLEREF:
        if (resolve) return getSingleref();
        return basicGetSingleref();
      case LocationprovidertestPackage.ELEMENT__MULTIREFS:
        return getMultirefs();
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
      case LocationprovidertestPackage.ELEMENT__NAME:
        setName((String)newValue);
        return;
      case LocationprovidertestPackage.ELEMENT__SINGLEREF:
        setSingleref((Element)newValue);
        return;
      case LocationprovidertestPackage.ELEMENT__MULTIREFS:
        getMultirefs().clear();
        getMultirefs().addAll((Collection<? extends Element>)newValue);
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
      case LocationprovidertestPackage.ELEMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case LocationprovidertestPackage.ELEMENT__SINGLEREF:
        setSingleref((Element)null);
        return;
      case LocationprovidertestPackage.ELEMENT__MULTIREFS:
        getMultirefs().clear();
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
      case LocationprovidertestPackage.ELEMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case LocationprovidertestPackage.ELEMENT__SINGLEREF:
        return singleref != null;
      case LocationprovidertestPackage.ELEMENT__MULTIREFS:
        return multirefs != null && !multirefs.isEmpty();
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

} //ElementImpl
