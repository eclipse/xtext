/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedClass1;

import org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitClass;
import org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>No Lit Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl.NoLitClassImpl#getAttribute2 <em>Attribute2</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl.NoLitClassImpl#getReference2 <em>Reference2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NoLitClassImpl extends EObjectImpl implements NoLitClass
{
	/**
	 * The default value of the '{@link #getAttribute2() <em>Attribute2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute2()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttribute2() <em>Attribute2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute2()
	 * @generated
	 * @ordered
	 */
	protected String attribute2 = ATTRIBUTE2_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReference2() <em>Reference2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference2()
	 * @generated
	 * @ordered
	 */
	protected NestedClass1 reference2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NoLitClassImpl()
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
		return NoLiteralsPackage.eINSTANCE.getNoLitClass();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttribute2()
	{
		return attribute2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute2(String newAttribute2)
	{
		String oldAttribute2 = attribute2;
		attribute2 = newAttribute2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NoLiteralsPackage.NO_LIT_CLASS__ATTRIBUTE2, oldAttribute2, attribute2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedClass1 getReference2()
	{
		if (reference2 != null && reference2.eIsProxy())
		{
			InternalEObject oldReference2 = (InternalEObject)reference2;
			reference2 = (NestedClass1)eResolveProxy(oldReference2);
			if (reference2 != oldReference2)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NoLiteralsPackage.NO_LIT_CLASS__REFERENCE2, oldReference2, reference2));
			}
		}
		return reference2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedClass1 basicGetReference2()
	{
		return reference2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference2(NestedClass1 newReference2)
	{
		NestedClass1 oldReference2 = reference2;
		reference2 = newReference2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NoLiteralsPackage.NO_LIT_CLASS__REFERENCE2, oldReference2, reference2));
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
			case NoLiteralsPackage.NO_LIT_CLASS__ATTRIBUTE2:
				return getAttribute2();
			case NoLiteralsPackage.NO_LIT_CLASS__REFERENCE2:
				if (resolve) return getReference2();
				return basicGetReference2();
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
			case NoLiteralsPackage.NO_LIT_CLASS__ATTRIBUTE2:
				setAttribute2((String)newValue);
				return;
			case NoLiteralsPackage.NO_LIT_CLASS__REFERENCE2:
				setReference2((NestedClass1)newValue);
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
			case NoLiteralsPackage.NO_LIT_CLASS__ATTRIBUTE2:
				setAttribute2(ATTRIBUTE2_EDEFAULT);
				return;
			case NoLiteralsPackage.NO_LIT_CLASS__REFERENCE2:
				setReference2((NestedClass1)null);
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
			case NoLiteralsPackage.NO_LIT_CLASS__ATTRIBUTE2:
				return ATTRIBUTE2_EDEFAULT == null ? attribute2 != null : !ATTRIBUTE2_EDEFAULT.equals(attribute2);
			case NoLiteralsPackage.NO_LIT_CLASS__REFERENCE2:
				return reference2 != null;
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
		result.append(" (attribute2: ");
		result.append(attribute2);
		result.append(')');
		return result.toString();
	}

} //NoLitClassImpl
