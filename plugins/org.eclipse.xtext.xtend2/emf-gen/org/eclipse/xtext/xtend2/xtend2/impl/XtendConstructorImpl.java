/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendConstructor;
import org.eclipse.xtext.xtend2.xtend2.XtendParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xtend Constructor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendConstructorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendConstructorImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendConstructorImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendConstructorImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendConstructorImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendConstructorImpl#getExceptions <em>Exceptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XtendConstructorImpl extends XtendMemberImplCustom implements XtendConstructor
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
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression expression;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<XtendParameter> parameters;

	/**
	 * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeParameter> typeParameters;

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final JvmVisibility VISIBILITY_EDEFAULT = JvmVisibility.PUBLIC;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected JvmVisibility visibility = VISIBILITY_EDEFAULT;

	/**
	 * This is true if the Visibility attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean visibilityESet;

	/**
	 * The cached value of the '{@link #getExceptions() <em>Exceptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptions()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeReference> exceptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XtendConstructorImpl()
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
		return Xtend2Package.Literals.XTEND_CONSTRUCTOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Xtend2Package.XTEND_CONSTRUCTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getExpression()
	{
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(XExpression newExpression, NotificationChain msgs)
	{
		XExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xtend2Package.XTEND_CONSTRUCTOR__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(XExpression newExpression)
	{
		if (newExpression != expression)
		{
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xtend2Package.XTEND_CONSTRUCTOR__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xtend2Package.XTEND_CONSTRUCTOR__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xtend2Package.XTEND_CONSTRUCTOR__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XtendParameter> getParameters()
	{
		if (parameters == null)
		{
			parameters = new EObjectContainmentEList<XtendParameter>(XtendParameter.class, this, Xtend2Package.XTEND_CONSTRUCTOR__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeParameter> getTypeParameters()
	{
		if (typeParameters == null)
		{
			typeParameters = new EObjectContainmentEList<JvmTypeParameter>(JvmTypeParameter.class, this, Xtend2Package.XTEND_CONSTRUCTOR__TYPE_PARAMETERS);
		}
		return typeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmVisibility getVisibility()
	{
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(JvmVisibility newVisibility)
	{
		JvmVisibility oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		boolean oldVisibilityESet = visibilityESet;
		visibilityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xtend2Package.XTEND_CONSTRUCTOR__VISIBILITY, oldVisibility, visibility, !oldVisibilityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibility()
	{
		JvmVisibility oldVisibility = visibility;
		boolean oldVisibilityESet = visibilityESet;
		visibility = VISIBILITY_EDEFAULT;
		visibilityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Xtend2Package.XTEND_CONSTRUCTOR__VISIBILITY, oldVisibility, VISIBILITY_EDEFAULT, oldVisibilityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibility()
	{
		return visibilityESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeReference> getExceptions()
	{
		if (exceptions == null)
		{
			exceptions = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, Xtend2Package.XTEND_CONSTRUCTOR__EXCEPTIONS);
		}
		return exceptions;
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
			case Xtend2Package.XTEND_CONSTRUCTOR__EXPRESSION:
				return basicSetExpression(null, msgs);
			case Xtend2Package.XTEND_CONSTRUCTOR__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case Xtend2Package.XTEND_CONSTRUCTOR__TYPE_PARAMETERS:
				return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
			case Xtend2Package.XTEND_CONSTRUCTOR__EXCEPTIONS:
				return ((InternalEList<?>)getExceptions()).basicRemove(otherEnd, msgs);
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
			case Xtend2Package.XTEND_CONSTRUCTOR__NAME:
				return getName();
			case Xtend2Package.XTEND_CONSTRUCTOR__EXPRESSION:
				return getExpression();
			case Xtend2Package.XTEND_CONSTRUCTOR__PARAMETERS:
				return getParameters();
			case Xtend2Package.XTEND_CONSTRUCTOR__TYPE_PARAMETERS:
				return getTypeParameters();
			case Xtend2Package.XTEND_CONSTRUCTOR__VISIBILITY:
				return getVisibility();
			case Xtend2Package.XTEND_CONSTRUCTOR__EXCEPTIONS:
				return getExceptions();
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
			case Xtend2Package.XTEND_CONSTRUCTOR__NAME:
				setName((String)newValue);
				return;
			case Xtend2Package.XTEND_CONSTRUCTOR__EXPRESSION:
				setExpression((XExpression)newValue);
				return;
			case Xtend2Package.XTEND_CONSTRUCTOR__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends XtendParameter>)newValue);
				return;
			case Xtend2Package.XTEND_CONSTRUCTOR__TYPE_PARAMETERS:
				getTypeParameters().clear();
				getTypeParameters().addAll((Collection<? extends JvmTypeParameter>)newValue);
				return;
			case Xtend2Package.XTEND_CONSTRUCTOR__VISIBILITY:
				setVisibility((JvmVisibility)newValue);
				return;
			case Xtend2Package.XTEND_CONSTRUCTOR__EXCEPTIONS:
				getExceptions().clear();
				getExceptions().addAll((Collection<? extends JvmTypeReference>)newValue);
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
			case Xtend2Package.XTEND_CONSTRUCTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Xtend2Package.XTEND_CONSTRUCTOR__EXPRESSION:
				setExpression((XExpression)null);
				return;
			case Xtend2Package.XTEND_CONSTRUCTOR__PARAMETERS:
				getParameters().clear();
				return;
			case Xtend2Package.XTEND_CONSTRUCTOR__TYPE_PARAMETERS:
				getTypeParameters().clear();
				return;
			case Xtend2Package.XTEND_CONSTRUCTOR__VISIBILITY:
				unsetVisibility();
				return;
			case Xtend2Package.XTEND_CONSTRUCTOR__EXCEPTIONS:
				getExceptions().clear();
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
			case Xtend2Package.XTEND_CONSTRUCTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Xtend2Package.XTEND_CONSTRUCTOR__EXPRESSION:
				return expression != null;
			case Xtend2Package.XTEND_CONSTRUCTOR__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case Xtend2Package.XTEND_CONSTRUCTOR__TYPE_PARAMETERS:
				return typeParameters != null && !typeParameters.isEmpty();
			case Xtend2Package.XTEND_CONSTRUCTOR__VISIBILITY:
				return isSetVisibility();
			case Xtend2Package.XTEND_CONSTRUCTOR__EXCEPTIONS:
				return exceptions != null && !exceptions.isEmpty();
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
		result.append(", visibility: ");
		if (visibilityESet) result.append(visibility); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //XtendConstructorImpl
