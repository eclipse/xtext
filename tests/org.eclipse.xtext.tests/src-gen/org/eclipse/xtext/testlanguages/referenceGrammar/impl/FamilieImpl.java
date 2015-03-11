/**
 */
package org.eclipse.xtext.testlanguages.referenceGrammar.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.xtext.testlanguages.referenceGrammar.Erwachsener;
import org.eclipse.xtext.testlanguages.referenceGrammar.Familie;
import org.eclipse.xtext.testlanguages.referenceGrammar.Kind;
import org.eclipse.xtext.testlanguages.referenceGrammar.ReferenceGrammarPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Familie</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.referenceGrammar.impl.FamilieImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.referenceGrammar.impl.FamilieImpl#getMutter <em>Mutter</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.referenceGrammar.impl.FamilieImpl#getVater <em>Vater</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.referenceGrammar.impl.FamilieImpl#getKinder <em>Kinder</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FamilieImpl extends MinimalEObjectImpl.Container implements Familie
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
   * The cached value of the '{@link #getMutter() <em>Mutter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMutter()
   * @generated
   * @ordered
   */
  protected Erwachsener mutter;

  /**
   * The cached value of the '{@link #getVater() <em>Vater</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVater()
   * @generated
   * @ordered
   */
  protected Erwachsener vater;

  /**
   * The cached value of the '{@link #getKinder() <em>Kinder</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKinder()
   * @generated
   * @ordered
   */
  protected EList<Kind> kinder;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FamilieImpl()
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
    return ReferenceGrammarPackage.Literals.FAMILIE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReferenceGrammarPackage.FAMILIE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Erwachsener getMutter()
  {
    if (mutter != null && mutter.eIsProxy())
    {
      InternalEObject oldMutter = (InternalEObject)mutter;
      mutter = (Erwachsener)eResolveProxy(oldMutter);
      if (mutter != oldMutter)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReferenceGrammarPackage.FAMILIE__MUTTER, oldMutter, mutter));
      }
    }
    return mutter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Erwachsener basicGetMutter()
  {
    return mutter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMutter(Erwachsener newMutter)
  {
    Erwachsener oldMutter = mutter;
    mutter = newMutter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReferenceGrammarPackage.FAMILIE__MUTTER, oldMutter, mutter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Erwachsener getVater()
  {
    if (vater != null && vater.eIsProxy())
    {
      InternalEObject oldVater = (InternalEObject)vater;
      vater = (Erwachsener)eResolveProxy(oldVater);
      if (vater != oldVater)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReferenceGrammarPackage.FAMILIE__VATER, oldVater, vater));
      }
    }
    return vater;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Erwachsener basicGetVater()
  {
    return vater;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVater(Erwachsener newVater)
  {
    Erwachsener oldVater = vater;
    vater = newVater;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReferenceGrammarPackage.FAMILIE__VATER, oldVater, vater));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Kind> getKinder()
  {
    if (kinder == null)
    {
      kinder = new EObjectResolvingEList<Kind>(Kind.class, this, ReferenceGrammarPackage.FAMILIE__KINDER);
    }
    return kinder;
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
      case ReferenceGrammarPackage.FAMILIE__NAME:
        return getName();
      case ReferenceGrammarPackage.FAMILIE__MUTTER:
        if (resolve) return getMutter();
        return basicGetMutter();
      case ReferenceGrammarPackage.FAMILIE__VATER:
        if (resolve) return getVater();
        return basicGetVater();
      case ReferenceGrammarPackage.FAMILIE__KINDER:
        return getKinder();
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
      case ReferenceGrammarPackage.FAMILIE__NAME:
        setName((String)newValue);
        return;
      case ReferenceGrammarPackage.FAMILIE__MUTTER:
        setMutter((Erwachsener)newValue);
        return;
      case ReferenceGrammarPackage.FAMILIE__VATER:
        setVater((Erwachsener)newValue);
        return;
      case ReferenceGrammarPackage.FAMILIE__KINDER:
        getKinder().clear();
        getKinder().addAll((Collection<? extends Kind>)newValue);
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
      case ReferenceGrammarPackage.FAMILIE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ReferenceGrammarPackage.FAMILIE__MUTTER:
        setMutter((Erwachsener)null);
        return;
      case ReferenceGrammarPackage.FAMILIE__VATER:
        setVater((Erwachsener)null);
        return;
      case ReferenceGrammarPackage.FAMILIE__KINDER:
        getKinder().clear();
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
      case ReferenceGrammarPackage.FAMILIE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ReferenceGrammarPackage.FAMILIE__MUTTER:
        return mutter != null;
      case ReferenceGrammarPackage.FAMILIE__VATER:
        return vater != null;
      case ReferenceGrammarPackage.FAMILIE__KINDER:
        return kinder != null && !kinder.isEmpty();
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

} //FamilieImpl
