/**
 */
package org.eclipse.xtend.macro.lang.macro.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtend.core.xtend.XtendMember;

import org.eclipse.xtend.core.xtend.impl.XtendTypeDeclarationImpl;

import org.eclipse.xtend.macro.lang.macro.MacroAnnotation;
import org.eclipse.xtend.macro.lang.macro.MacroPackage;
import org.eclipse.xtend.macro.lang.macro.TargetType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtend.macro.lang.macro.impl.MacroAnnotationImpl#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.eclipse.xtend.macro.lang.macro.impl.MacroAnnotationImpl#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MacroAnnotationImpl extends XtendTypeDeclarationImpl implements MacroAnnotation
{
  /**
   * The cached value of the '{@link #getTargetType() <em>Target Type</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetType()
   * @generated
   * @ordered
   */
  protected EList<TargetType> targetType;

  /**
   * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMembers()
   * @generated
   * @ordered
   */
  protected EList<XtendMember> members;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MacroAnnotationImpl()
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
    return MacroPackage.Literals.MACRO_ANNOTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TargetType> getTargetType()
  {
    if (targetType == null)
    {
      targetType = new EDataTypeEList<TargetType>(TargetType.class, this, MacroPackage.MACRO_ANNOTATION__TARGET_TYPE);
    }
    return targetType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XtendMember> getMembers()
  {
    if (members == null)
    {
      members = new EObjectContainmentEList<XtendMember>(XtendMember.class, this, MacroPackage.MACRO_ANNOTATION__MEMBERS);
    }
    return members;
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
      case MacroPackage.MACRO_ANNOTATION__MEMBERS:
        return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
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
      case MacroPackage.MACRO_ANNOTATION__TARGET_TYPE:
        return getTargetType();
      case MacroPackage.MACRO_ANNOTATION__MEMBERS:
        return getMembers();
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
      case MacroPackage.MACRO_ANNOTATION__TARGET_TYPE:
        getTargetType().clear();
        getTargetType().addAll((Collection<? extends TargetType>)newValue);
        return;
      case MacroPackage.MACRO_ANNOTATION__MEMBERS:
        getMembers().clear();
        getMembers().addAll((Collection<? extends XtendMember>)newValue);
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
      case MacroPackage.MACRO_ANNOTATION__TARGET_TYPE:
        getTargetType().clear();
        return;
      case MacroPackage.MACRO_ANNOTATION__MEMBERS:
        getMembers().clear();
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
      case MacroPackage.MACRO_ANNOTATION__TARGET_TYPE:
        return targetType != null && !targetType.isEmpty();
      case MacroPackage.MACRO_ANNOTATION__MEMBERS:
        return members != null && !members.isEmpty();
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
    result.append(" (targetType: ");
    result.append(targetType);
    result.append(')');
    return result.toString();
  }

} //MacroAnnotationImpl
