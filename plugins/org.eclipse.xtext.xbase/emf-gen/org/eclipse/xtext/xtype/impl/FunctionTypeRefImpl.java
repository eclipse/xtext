/**
 * <copyright>
 * </copyright>
 *
 * $Id: FunctionTypeRefImpl.java,v 1.1 2010/01/14 14:40:21 sefftinge Exp $
 */
package org.eclipse.xtext.xtype.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xtype.FunctionTypeRef;
import org.eclipse.xtext.xtype.TypeRef;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Type Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.impl.FunctionTypeRefImpl#getParamTypes <em>Param Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.FunctionTypeRefImpl#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionTypeRefImpl extends TypeRefImpl implements FunctionTypeRef {
	/**
	 * The cached value of the '{@link #getParamTypes() <em>Param Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeRef> paramTypes;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeRef> returnType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionTypeRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtypePackage.Literals.FUNCTION_TYPE_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeRef> getParamTypes() {
		if (paramTypes == null) {
			paramTypes = new EObjectContainmentEList<TypeRef>(TypeRef.class, this, XtypePackage.FUNCTION_TYPE_REF__PARAM_TYPES);
		}
		return paramTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeRef> getReturnType() {
		if (returnType == null) {
			returnType = new EObjectContainmentEList<TypeRef>(TypeRef.class, this, XtypePackage.FUNCTION_TYPE_REF__RETURN_TYPE);
		}
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XtypePackage.FUNCTION_TYPE_REF__PARAM_TYPES:
				return ((InternalEList<?>)getParamTypes()).basicRemove(otherEnd, msgs);
			case XtypePackage.FUNCTION_TYPE_REF__RETURN_TYPE:
				return ((InternalEList<?>)getReturnType()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XtypePackage.FUNCTION_TYPE_REF__PARAM_TYPES:
				return getParamTypes();
			case XtypePackage.FUNCTION_TYPE_REF__RETURN_TYPE:
				return getReturnType();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XtypePackage.FUNCTION_TYPE_REF__PARAM_TYPES:
				getParamTypes().clear();
				getParamTypes().addAll((Collection<? extends TypeRef>)newValue);
				return;
			case XtypePackage.FUNCTION_TYPE_REF__RETURN_TYPE:
				getReturnType().clear();
				getReturnType().addAll((Collection<? extends TypeRef>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case XtypePackage.FUNCTION_TYPE_REF__PARAM_TYPES:
				getParamTypes().clear();
				return;
			case XtypePackage.FUNCTION_TYPE_REF__RETURN_TYPE:
				getReturnType().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XtypePackage.FUNCTION_TYPE_REF__PARAM_TYPES:
				return paramTypes != null && !paramTypes.isEmpty();
			case XtypePackage.FUNCTION_TYPE_REF__RETURN_TYPE:
				return returnType != null && !returnType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionTypeRefImpl
