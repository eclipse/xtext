/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtype.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.common.types.impl.JvmParameterizedTypeReferenceImpl;

import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XFunction Type Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl#getParamTypes <em>Param Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XFunctionTypeRefImpl extends JvmParameterizedTypeReferenceImpl implements XFunctionTypeRef
{
  /**
   * The cached value of the '{@link #getParamTypes() <em>Param Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParamTypes()
   * @generated
   * @ordered
   */
  protected EList<JvmTypeReference> paramTypes;

  /**
   * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected JvmTypeReference returnType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XFunctionTypeRefImpl()
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
    return XtypePackage.Literals.XFUNCTION_TYPE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<JvmTypeReference> getParamTypes()
  {
    if (paramTypes == null)
    {
      paramTypes = new EObjectResolvingEList<JvmTypeReference>(JvmTypeReference.class, this, XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES);
    }
    return paramTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmTypeReference getReturnType()
  {
    if (returnType != null && returnType.eIsProxy())
    {
      InternalEObject oldReturnType = (InternalEObject)returnType;
      returnType = (JvmTypeReference)eResolveProxy(oldReturnType);
      if (returnType != oldReturnType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE, oldReturnType, returnType));
      }
    }
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmTypeReference basicGetReturnType()
  {
    return returnType;
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
      case XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES:
        return getParamTypes();
      case XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE:
        if (resolve) return getReturnType();
        return basicGetReturnType();
    }
    return super.eGet(featureID, resolve, coreType);
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
      case XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES:
        return paramTypes != null && !paramTypes.isEmpty();
      case XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE:
        return returnType != null;
    }
    return super.eIsSet(featureID);
  }

} //XFunctionTypeRefImpl
