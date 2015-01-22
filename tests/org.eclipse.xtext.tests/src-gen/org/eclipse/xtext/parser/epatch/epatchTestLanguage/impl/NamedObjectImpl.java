/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl;

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

import org.eclipse.xtext.parser.epatch.epatchTestLanguage.Assignment;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedObjectImpl#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedObjectImpl#getLeftMig <em>Left Mig</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedObjectImpl extends MinimalEObjectImpl.Container implements NamedObject
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
   * The cached value of the '{@link #getAssignments() <em>Assignments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignments()
   * @generated
   * @ordered
   */
  protected EList<Assignment> assignments;

  /**
   * The cached value of the '{@link #getLeftMig() <em>Left Mig</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeftMig()
   * @generated
   * @ordered
   */
  protected Migration leftMig;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NamedObjectImpl()
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
    return EpatchTestLanguagePackage.Literals.NAMED_OBJECT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.NAMED_OBJECT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Assignment> getAssignments()
  {
    if (assignments == null)
    {
      assignments = new EObjectContainmentEList<Assignment>(Assignment.class, this, EpatchTestLanguagePackage.NAMED_OBJECT__ASSIGNMENTS);
    }
    return assignments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Migration getLeftMig()
  {
    return leftMig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeftMig(Migration newLeftMig, NotificationChain msgs)
  {
    Migration oldLeftMig = leftMig;
    leftMig = newLeftMig;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.NAMED_OBJECT__LEFT_MIG, oldLeftMig, newLeftMig);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeftMig(Migration newLeftMig)
  {
    if (newLeftMig != leftMig)
    {
      NotificationChain msgs = null;
      if (leftMig != null)
        msgs = ((InternalEObject)leftMig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.NAMED_OBJECT__LEFT_MIG, null, msgs);
      if (newLeftMig != null)
        msgs = ((InternalEObject)newLeftMig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.NAMED_OBJECT__LEFT_MIG, null, msgs);
      msgs = basicSetLeftMig(newLeftMig, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.NAMED_OBJECT__LEFT_MIG, newLeftMig, newLeftMig));
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
      case EpatchTestLanguagePackage.NAMED_OBJECT__ASSIGNMENTS:
        return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
      case EpatchTestLanguagePackage.NAMED_OBJECT__LEFT_MIG:
        return basicSetLeftMig(null, msgs);
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
      case EpatchTestLanguagePackage.NAMED_OBJECT__NAME:
        return getName();
      case EpatchTestLanguagePackage.NAMED_OBJECT__ASSIGNMENTS:
        return getAssignments();
      case EpatchTestLanguagePackage.NAMED_OBJECT__LEFT_MIG:
        return getLeftMig();
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
      case EpatchTestLanguagePackage.NAMED_OBJECT__NAME:
        setName((String)newValue);
        return;
      case EpatchTestLanguagePackage.NAMED_OBJECT__ASSIGNMENTS:
        getAssignments().clear();
        getAssignments().addAll((Collection<? extends Assignment>)newValue);
        return;
      case EpatchTestLanguagePackage.NAMED_OBJECT__LEFT_MIG:
        setLeftMig((Migration)newValue);
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
      case EpatchTestLanguagePackage.NAMED_OBJECT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case EpatchTestLanguagePackage.NAMED_OBJECT__ASSIGNMENTS:
        getAssignments().clear();
        return;
      case EpatchTestLanguagePackage.NAMED_OBJECT__LEFT_MIG:
        setLeftMig((Migration)null);
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
      case EpatchTestLanguagePackage.NAMED_OBJECT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case EpatchTestLanguagePackage.NAMED_OBJECT__ASSIGNMENTS:
        return assignments != null && !assignments.isEmpty();
      case EpatchTestLanguagePackage.NAMED_OBJECT__LEFT_MIG:
        return leftMig != null;
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

} //NamedObjectImpl
