/**
 */
package org.eclipse.xtext.linking.lazy.bug311337.impl;

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

import org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package;
import org.eclipse.xtext.linking.lazy.bug311337.Child;
import org.eclipse.xtext.linking.lazy.bug311337.Definition;
import org.eclipse.xtext.linking.lazy.bug311337.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.lazy.bug311337.impl.DefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.bug311337.impl.DefinitionImpl#getChild <em>Child</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.bug311337.impl.DefinitionImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefinitionImpl extends MinimalEObjectImpl.Container implements Definition
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
   * The cached value of the '{@link #getChild() <em>Child</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChild()
   * @generated
   * @ordered
   */
  protected EList<Child> child;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected EList<Reference> ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DefinitionImpl()
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
    return Bug311337Package.Literals.DEFINITION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, Bug311337Package.DEFINITION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Child> getChild()
  {
    if (child == null)
    {
      child = new EObjectContainmentEList<Child>(Child.class, this, Bug311337Package.DEFINITION__CHILD);
    }
    return child;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Reference> getRef()
  {
    if (ref == null)
    {
      ref = new EObjectContainmentEList<Reference>(Reference.class, this, Bug311337Package.DEFINITION__REF);
    }
    return ref;
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
      case Bug311337Package.DEFINITION__CHILD:
        return ((InternalEList<?>)getChild()).basicRemove(otherEnd, msgs);
      case Bug311337Package.DEFINITION__REF:
        return ((InternalEList<?>)getRef()).basicRemove(otherEnd, msgs);
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
      case Bug311337Package.DEFINITION__NAME:
        return getName();
      case Bug311337Package.DEFINITION__CHILD:
        return getChild();
      case Bug311337Package.DEFINITION__REF:
        return getRef();
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
      case Bug311337Package.DEFINITION__NAME:
        setName((String)newValue);
        return;
      case Bug311337Package.DEFINITION__CHILD:
        getChild().clear();
        getChild().addAll((Collection<? extends Child>)newValue);
        return;
      case Bug311337Package.DEFINITION__REF:
        getRef().clear();
        getRef().addAll((Collection<? extends Reference>)newValue);
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
      case Bug311337Package.DEFINITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Bug311337Package.DEFINITION__CHILD:
        getChild().clear();
        return;
      case Bug311337Package.DEFINITION__REF:
        getRef().clear();
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
      case Bug311337Package.DEFINITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Bug311337Package.DEFINITION__CHILD:
        return child != null && !child.isEmpty();
      case Bug311337Package.DEFINITION__REF:
        return ref != null && !ref.isEmpty();
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

} //DefinitionImpl
