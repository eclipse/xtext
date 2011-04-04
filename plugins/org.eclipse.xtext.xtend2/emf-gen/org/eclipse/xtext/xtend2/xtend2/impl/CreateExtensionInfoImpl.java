/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.impl.JvmIdentifiableElementImplCustom;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xtend2.xtend2.CreateExtensionInfo;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Extension Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.CreateExtensionInfoImpl#getCreateExpression <em>Create Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.CreateExtensionInfoImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateExtensionInfoImpl extends JvmIdentifiableElementImplCustom implements CreateExtensionInfo
{
	/**
	 * The cached value of the '{@link #getCreateExpression() <em>Create Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression createExpression;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "this";

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateExtensionInfoImpl()
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
		return Xtend2Package.Literals.CREATE_EXTENSION_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getCreateExpression()
	{
		return createExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCreateExpression(XExpression newCreateExpression, NotificationChain msgs)
	{
		XExpression oldCreateExpression = createExpression;
		createExpression = newCreateExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xtend2Package.CREATE_EXTENSION_INFO__CREATE_EXPRESSION, oldCreateExpression, newCreateExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateExpression(XExpression newCreateExpression)
	{
		if (newCreateExpression != createExpression)
		{
			NotificationChain msgs = null;
			if (createExpression != null)
				msgs = ((InternalEObject)createExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xtend2Package.CREATE_EXTENSION_INFO__CREATE_EXPRESSION, null, msgs);
			if (newCreateExpression != null)
				msgs = ((InternalEObject)newCreateExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xtend2Package.CREATE_EXTENSION_INFO__CREATE_EXPRESSION, null, msgs);
			msgs = basicSetCreateExpression(newCreateExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xtend2Package.CREATE_EXTENSION_INFO__CREATE_EXPRESSION, newCreateExpression, newCreateExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Xtend2Package.CREATE_EXTENSION_INFO__NAME, oldName, name));
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
			case Xtend2Package.CREATE_EXTENSION_INFO__CREATE_EXPRESSION:
				return basicSetCreateExpression(null, msgs);
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
			case Xtend2Package.CREATE_EXTENSION_INFO__CREATE_EXPRESSION:
				return getCreateExpression();
			case Xtend2Package.CREATE_EXTENSION_INFO__NAME:
				return getName();
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
			case Xtend2Package.CREATE_EXTENSION_INFO__CREATE_EXPRESSION:
				setCreateExpression((XExpression)newValue);
				return;
			case Xtend2Package.CREATE_EXTENSION_INFO__NAME:
				setName((String)newValue);
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
			case Xtend2Package.CREATE_EXTENSION_INFO__CREATE_EXPRESSION:
				setCreateExpression((XExpression)null);
				return;
			case Xtend2Package.CREATE_EXTENSION_INFO__NAME:
				setName(NAME_EDEFAULT);
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
			case Xtend2Package.CREATE_EXTENSION_INFO__CREATE_EXPRESSION:
				return createExpression != null;
			case Xtend2Package.CREATE_EXTENSION_INFO__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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

} //CreateExtensionInfoImpl
