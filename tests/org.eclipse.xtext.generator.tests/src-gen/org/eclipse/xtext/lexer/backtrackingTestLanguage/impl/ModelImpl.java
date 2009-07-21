/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.lexer.backtrackingTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.lexer.backtrackingTestLanguage.Ab;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.BacktrackingTestLanguagePackage;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.EnumName;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.Model;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.ModelImpl#getEnums <em>Enums</em>}</li>
 *   <li>{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.ModelImpl#getAbs <em>Abs</em>}</li>
 *   <li>{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.ModelImpl#getXbs <em>Xbs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getEnums() <em>Enums</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnums()
   * @generated
   * @ordered
   */
  protected EList<EnumName> enums;

  /**
   * The cached value of the '{@link #getAbs() <em>Abs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbs()
   * @generated
   * @ordered
   */
  protected EList<Ab> abs;

  /**
   * The cached value of the '{@link #getXbs() <em>Xbs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXbs()
   * @generated
   * @ordered
   */
  protected EList<Xb> xbs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return BacktrackingTestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EnumName> getEnums()
  {
    if (enums == null)
    {
      enums = new EDataTypeEList<EnumName>(EnumName.class, this, BacktrackingTestLanguagePackage.MODEL__ENUMS);
    }
    return enums;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Ab> getAbs()
  {
    if (abs == null)
    {
      abs = new EObjectContainmentEList<Ab>(Ab.class, this, BacktrackingTestLanguagePackage.MODEL__ABS);
    }
    return abs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Xb> getXbs()
  {
    if (xbs == null)
    {
      xbs = new EObjectContainmentEList<Xb>(Xb.class, this, BacktrackingTestLanguagePackage.MODEL__XBS);
    }
    return xbs;
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
      case BacktrackingTestLanguagePackage.MODEL__ABS:
        return ((InternalEList<?>)getAbs()).basicRemove(otherEnd, msgs);
      case BacktrackingTestLanguagePackage.MODEL__XBS:
        return ((InternalEList<?>)getXbs()).basicRemove(otherEnd, msgs);
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
      case BacktrackingTestLanguagePackage.MODEL__ENUMS:
        return getEnums();
      case BacktrackingTestLanguagePackage.MODEL__ABS:
        return getAbs();
      case BacktrackingTestLanguagePackage.MODEL__XBS:
        return getXbs();
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
      case BacktrackingTestLanguagePackage.MODEL__ENUMS:
        getEnums().clear();
        getEnums().addAll((Collection<? extends EnumName>)newValue);
        return;
      case BacktrackingTestLanguagePackage.MODEL__ABS:
        getAbs().clear();
        getAbs().addAll((Collection<? extends Ab>)newValue);
        return;
      case BacktrackingTestLanguagePackage.MODEL__XBS:
        getXbs().clear();
        getXbs().addAll((Collection<? extends Xb>)newValue);
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
      case BacktrackingTestLanguagePackage.MODEL__ENUMS:
        getEnums().clear();
        return;
      case BacktrackingTestLanguagePackage.MODEL__ABS:
        getAbs().clear();
        return;
      case BacktrackingTestLanguagePackage.MODEL__XBS:
        getXbs().clear();
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
      case BacktrackingTestLanguagePackage.MODEL__ENUMS:
        return enums != null && !enums.isEmpty();
      case BacktrackingTestLanguagePackage.MODEL__ABS:
        return abs != null && !abs.isEmpty();
      case BacktrackingTestLanguagePackage.MODEL__XBS:
        return xbs != null && !xbs.isEmpty();
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
    result.append(" (enums: ");
    result.append(enums);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
