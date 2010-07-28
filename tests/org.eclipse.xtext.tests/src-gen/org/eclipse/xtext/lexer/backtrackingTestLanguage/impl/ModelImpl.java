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
 *   <li>{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.ModelImpl#getYcs <em>Ycs</em>}</li>
 *   <li>{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.ModelImpl#getAbs <em>Abs</em>}</li>
 *   <li>{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.ModelImpl#getXbs <em>Xbs</em>}</li>
 *   <li>{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.ModelImpl#getYs <em>Ys</em>}</li>
 *   <li>{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.ModelImpl#getAs <em>As</em>}</li>
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
   * The cached value of the '{@link #getYcs() <em>Ycs</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getYcs()
   * @generated
   * @ordered
   */
  protected EList<String> ycs;

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
   * The cached value of the '{@link #getYs() <em>Ys</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getYs()
   * @generated
   * @ordered
   */
  protected EList<String> ys;

  /**
   * The cached value of the '{@link #getAs() <em>As</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAs()
   * @generated
   * @ordered
   */
  protected EList<String> as;

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
  public EList<String> getYcs()
  {
    if (ycs == null)
    {
      ycs = new EDataTypeEList<String>(String.class, this, BacktrackingTestLanguagePackage.MODEL__YCS);
    }
    return ycs;
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
  public EList<String> getYs()
  {
    if (ys == null)
    {
      ys = new EDataTypeEList<String>(String.class, this, BacktrackingTestLanguagePackage.MODEL__YS);
    }
    return ys;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getAs()
  {
    if (as == null)
    {
      as = new EDataTypeEList<String>(String.class, this, BacktrackingTestLanguagePackage.MODEL__AS);
    }
    return as;
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
      case BacktrackingTestLanguagePackage.MODEL__YCS:
        return getYcs();
      case BacktrackingTestLanguagePackage.MODEL__ABS:
        return getAbs();
      case BacktrackingTestLanguagePackage.MODEL__XBS:
        return getXbs();
      case BacktrackingTestLanguagePackage.MODEL__YS:
        return getYs();
      case BacktrackingTestLanguagePackage.MODEL__AS:
        return getAs();
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
      case BacktrackingTestLanguagePackage.MODEL__YCS:
        getYcs().clear();
        getYcs().addAll((Collection<? extends String>)newValue);
        return;
      case BacktrackingTestLanguagePackage.MODEL__ABS:
        getAbs().clear();
        getAbs().addAll((Collection<? extends Ab>)newValue);
        return;
      case BacktrackingTestLanguagePackage.MODEL__XBS:
        getXbs().clear();
        getXbs().addAll((Collection<? extends Xb>)newValue);
        return;
      case BacktrackingTestLanguagePackage.MODEL__YS:
        getYs().clear();
        getYs().addAll((Collection<? extends String>)newValue);
        return;
      case BacktrackingTestLanguagePackage.MODEL__AS:
        getAs().clear();
        getAs().addAll((Collection<? extends String>)newValue);
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
      case BacktrackingTestLanguagePackage.MODEL__YCS:
        getYcs().clear();
        return;
      case BacktrackingTestLanguagePackage.MODEL__ABS:
        getAbs().clear();
        return;
      case BacktrackingTestLanguagePackage.MODEL__XBS:
        getXbs().clear();
        return;
      case BacktrackingTestLanguagePackage.MODEL__YS:
        getYs().clear();
        return;
      case BacktrackingTestLanguagePackage.MODEL__AS:
        getAs().clear();
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
      case BacktrackingTestLanguagePackage.MODEL__YCS:
        return ycs != null && !ycs.isEmpty();
      case BacktrackingTestLanguagePackage.MODEL__ABS:
        return abs != null && !abs.isEmpty();
      case BacktrackingTestLanguagePackage.MODEL__XBS:
        return xbs != null && !xbs.isEmpty();
      case BacktrackingTestLanguagePackage.MODEL__YS:
        return ys != null && !ys.isEmpty();
      case BacktrackingTestLanguagePackage.MODEL__AS:
        return as != null && !as.isEmpty();
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
    result.append(", ycs: ");
    result.append(ycs);
    result.append(", ys: ");
    result.append(ys);
    result.append(", as: ");
    result.append(as);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
