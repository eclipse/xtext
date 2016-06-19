/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedClass1;

import org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootClass;
import org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootClassImpl#getAttribute1 <em>Attribute1</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootClassImpl#getReference1 <em>Reference1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootClassImpl extends EObjectImpl implements RootClass
{
	/**
	 * The default value of the '{@link #getAttribute1() <em>Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute1()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttribute1() <em>Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute1()
	 * @generated
	 * @ordered
	 */
	protected String attribute1 = ATTRIBUTE1_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReference1() <em>Reference1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference1()
	 * @generated
	 * @ordered
	 */
	protected NestedClass1 reference1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootClassImpl()
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
		return RootPackage.Literals.ROOT_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttribute1()
	{
		return attribute1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute1(String newAttribute1)
	{
		String oldAttribute1 = attribute1;
		attribute1 = newAttribute1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RootPackage.ROOT_CLASS__ATTRIBUTE1, oldAttribute1, attribute1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedClass1 getReference1()
	{
		if (reference1 != null && reference1.eIsProxy())
		{
			InternalEObject oldReference1 = (InternalEObject)reference1;
			reference1 = (NestedClass1)eResolveProxy(oldReference1);
			if (reference1 != oldReference1)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RootPackage.ROOT_CLASS__REFERENCE1, oldReference1, reference1));
			}
		}
		return reference1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedClass1 basicGetReference1()
	{
		return reference1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference1(NestedClass1 newReference1)
	{
		NestedClass1 oldReference1 = reference1;
		reference1 = newReference1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RootPackage.ROOT_CLASS__REFERENCE1, oldReference1, reference1));
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
			case RootPackage.ROOT_CLASS__ATTRIBUTE1:
				return getAttribute1();
			case RootPackage.ROOT_CLASS__REFERENCE1:
				if (resolve) return getReference1();
				return basicGetReference1();
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
			case RootPackage.ROOT_CLASS__ATTRIBUTE1:
				setAttribute1((String)newValue);
				return;
			case RootPackage.ROOT_CLASS__REFERENCE1:
				setReference1((NestedClass1)newValue);
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
			case RootPackage.ROOT_CLASS__ATTRIBUTE1:
				setAttribute1(ATTRIBUTE1_EDEFAULT);
				return;
			case RootPackage.ROOT_CLASS__REFERENCE1:
				setReference1((NestedClass1)null);
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
			case RootPackage.ROOT_CLASS__ATTRIBUTE1:
				return ATTRIBUTE1_EDEFAULT == null ? attribute1 != null : !ATTRIBUTE1_EDEFAULT.equals(attribute1);
			case RootPackage.ROOT_CLASS__REFERENCE1:
				return reference1 != null;
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
		result.append(" (attribute1: ");
		result.append(attribute1);
		result.append(')');
		return result.toString();
	}

} //RootClassImpl
