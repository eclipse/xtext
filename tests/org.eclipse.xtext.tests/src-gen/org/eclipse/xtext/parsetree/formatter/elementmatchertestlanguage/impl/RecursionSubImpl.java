/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RecursionSub;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recursion Sub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RecursionSubImpl#getSub <em>Sub</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RecursionSubImpl#getVals <em>Vals</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RecursionSubImpl#isSemi <em>Semi</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecursionSubImpl extends RecursionImpl implements RecursionSub
{
  /**
   * The cached value of the '{@link #getSub() <em>Sub</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSub()
   * @generated
   * @ordered
   */
  protected EList<RecursionSub> sub;

  /**
   * The cached value of the '{@link #getVals() <em>Vals</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVals()
   * @generated
   * @ordered
   */
  protected EList<String> vals;

  /**
   * The default value of the '{@link #isSemi() <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSemi()
   * @generated
   * @ordered
   */
  protected static final boolean SEMI_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSemi() <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSemi()
   * @generated
   * @ordered
   */
  protected boolean semi = SEMI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecursionSubImpl()
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
    return ElementmatchertestlanguagePackage.Literals.RECURSION_SUB;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RecursionSub> getSub()
  {
    if (sub == null)
    {
      sub = new EObjectContainmentEList<RecursionSub>(RecursionSub.class, this, ElementmatchertestlanguagePackage.RECURSION_SUB__SUB);
    }
    return sub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVals()
  {
    if (vals == null)
    {
      vals = new EDataTypeEList<String>(String.class, this, ElementmatchertestlanguagePackage.RECURSION_SUB__VALS);
    }
    return vals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSemi()
  {
    return semi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSemi(boolean newSemi)
  {
    boolean oldSemi = semi;
    semi = newSemi;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.RECURSION_SUB__SEMI, oldSemi, semi));
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
      case ElementmatchertestlanguagePackage.RECURSION_SUB__SUB:
        return ((InternalEList<?>)getSub()).basicRemove(otherEnd, msgs);
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
      case ElementmatchertestlanguagePackage.RECURSION_SUB__SUB:
        return getSub();
      case ElementmatchertestlanguagePackage.RECURSION_SUB__VALS:
        return getVals();
      case ElementmatchertestlanguagePackage.RECURSION_SUB__SEMI:
        return isSemi();
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
      case ElementmatchertestlanguagePackage.RECURSION_SUB__SUB:
        getSub().clear();
        getSub().addAll((Collection<? extends RecursionSub>)newValue);
        return;
      case ElementmatchertestlanguagePackage.RECURSION_SUB__VALS:
        getVals().clear();
        getVals().addAll((Collection<? extends String>)newValue);
        return;
      case ElementmatchertestlanguagePackage.RECURSION_SUB__SEMI:
        setSemi((Boolean)newValue);
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
      case ElementmatchertestlanguagePackage.RECURSION_SUB__SUB:
        getSub().clear();
        return;
      case ElementmatchertestlanguagePackage.RECURSION_SUB__VALS:
        getVals().clear();
        return;
      case ElementmatchertestlanguagePackage.RECURSION_SUB__SEMI:
        setSemi(SEMI_EDEFAULT);
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
      case ElementmatchertestlanguagePackage.RECURSION_SUB__SUB:
        return sub != null && !sub.isEmpty();
      case ElementmatchertestlanguagePackage.RECURSION_SUB__VALS:
        return vals != null && !vals.isEmpty();
      case ElementmatchertestlanguagePackage.RECURSION_SUB__SEMI:
        return semi != SEMI_EDEFAULT;
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
    result.append(" (vals: ");
    result.append(vals);
    result.append(", semi: ");
    result.append(semi);
    result.append(')');
    return result.toString();
  }

} //RecursionSubImpl
