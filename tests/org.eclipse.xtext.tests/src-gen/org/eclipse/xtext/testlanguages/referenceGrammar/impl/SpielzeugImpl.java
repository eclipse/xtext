/**
 */
package org.eclipse.xtext.testlanguages.referenceGrammar.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.testlanguages.referenceGrammar.Farbe;
import org.eclipse.xtext.testlanguages.referenceGrammar.ReferenceGrammarPackage;
import org.eclipse.xtext.testlanguages.referenceGrammar.Spielzeug;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spielzeug</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.referenceGrammar.impl.SpielzeugImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.referenceGrammar.impl.SpielzeugImpl#getFarbe <em>Farbe</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpielzeugImpl extends MinimalEObjectImpl.Container implements Spielzeug
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
   * The cached value of the '{@link #getFarbe() <em>Farbe</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFarbe()
   * @generated
   * @ordered
   */
  protected Farbe farbe;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpielzeugImpl()
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
    return ReferenceGrammarPackage.Literals.SPIELZEUG;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReferenceGrammarPackage.SPIELZEUG__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Farbe getFarbe()
  {
    return farbe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFarbe(Farbe newFarbe, NotificationChain msgs)
  {
    Farbe oldFarbe = farbe;
    farbe = newFarbe;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReferenceGrammarPackage.SPIELZEUG__FARBE, oldFarbe, newFarbe);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFarbe(Farbe newFarbe)
  {
    if (newFarbe != farbe)
    {
      NotificationChain msgs = null;
      if (farbe != null)
        msgs = ((InternalEObject)farbe).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReferenceGrammarPackage.SPIELZEUG__FARBE, null, msgs);
      if (newFarbe != null)
        msgs = ((InternalEObject)newFarbe).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReferenceGrammarPackage.SPIELZEUG__FARBE, null, msgs);
      msgs = basicSetFarbe(newFarbe, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReferenceGrammarPackage.SPIELZEUG__FARBE, newFarbe, newFarbe));
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
      case ReferenceGrammarPackage.SPIELZEUG__FARBE:
        return basicSetFarbe(null, msgs);
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
      case ReferenceGrammarPackage.SPIELZEUG__NAME:
        return getName();
      case ReferenceGrammarPackage.SPIELZEUG__FARBE:
        return getFarbe();
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
      case ReferenceGrammarPackage.SPIELZEUG__NAME:
        setName((String)newValue);
        return;
      case ReferenceGrammarPackage.SPIELZEUG__FARBE:
        setFarbe((Farbe)newValue);
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
      case ReferenceGrammarPackage.SPIELZEUG__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ReferenceGrammarPackage.SPIELZEUG__FARBE:
        setFarbe((Farbe)null);
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
      case ReferenceGrammarPackage.SPIELZEUG__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ReferenceGrammarPackage.SPIELZEUG__FARBE:
        return farbe != null;
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

} //SpielzeugImpl
