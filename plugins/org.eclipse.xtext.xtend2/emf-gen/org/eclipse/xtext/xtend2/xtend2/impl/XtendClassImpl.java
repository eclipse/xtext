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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.common.types.impl.JvmIdentifiableElementImpl;

import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xtend Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendClassImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendClassImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendClassImpl#getImplements <em>Implements</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendClassImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendClassImpl#getMembers <em>Members</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendClassImpl#getInferredJvmType <em>Inferred Jvm Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XtendClassImpl extends JvmIdentifiableElementImpl implements XtendClass
{
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
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference extends_;

	/**
	 * The cached value of the '{@link #getImplements() <em>Implements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplements()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeReference> implements_;

	/**
	 * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeReference> superTypes;

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
	 * The cached value of the '{@link #getInferredJvmType() <em>Inferred Jvm Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInferredJvmType()
	 * @generated
	 * @ordered
	 */
	protected JvmGenericType inferredJvmType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XtendClassImpl()
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
		return Xtend2Package.Literals.XTEND_CLASS;
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
			typeParameters = new EObjectContainmentWithInverseEList<JvmTypeParameter>(JvmTypeParameter.class, this, Xtend2Package.XTEND_CLASS__TYPE_PARAMETERS, TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR);
		}
		return typeParameters;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Xtend2Package.XTEND_CLASS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getExtends()
	{
		if (extends_ != null && extends_.eIsProxy())
		{
			InternalEObject oldExtends = (InternalEObject)extends_;
			extends_ = (JvmTypeReference)eResolveProxy(oldExtends);
			if (extends_ != oldExtends)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xtend2Package.XTEND_CLASS__EXTENDS, oldExtends, extends_));
			}
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference basicGetExtends()
	{
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeReference> getImplements()
	{
		if (implements_ == null)
		{
			implements_ = new EObjectResolvingEList<JvmTypeReference>(JvmTypeReference.class, this, Xtend2Package.XTEND_CLASS__IMPLEMENTS);
		}
		return implements_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeReference> getSuperTypes()
	{
		if (superTypes == null)
		{
			superTypes = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, Xtend2Package.XTEND_CLASS__SUPER_TYPES);
		}
		return superTypes;
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
			members = new EObjectContainmentWithInverseEList<XtendMember>(XtendMember.class, this, Xtend2Package.XTEND_CLASS__MEMBERS, Xtend2Package.XTEND_MEMBER__DECLARING_TYPE);
		}
		return members;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmGenericType getInferredJvmType()
	{
		if (inferredJvmType != null && inferredJvmType.eIsProxy())
		{
			InternalEObject oldInferredJvmType = (InternalEObject)inferredJvmType;
			inferredJvmType = (JvmGenericType)eResolveProxy(oldInferredJvmType);
			if (inferredJvmType != oldInferredJvmType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xtend2Package.XTEND_CLASS__INFERRED_JVM_TYPE, oldInferredJvmType, inferredJvmType));
			}
		}
		return inferredJvmType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmGenericType basicGetInferredJvmType()
	{
		return inferredJvmType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInferredJvmType(JvmGenericType newInferredJvmType)
	{
		JvmGenericType oldInferredJvmType = inferredJvmType;
		inferredJvmType = newInferredJvmType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xtend2Package.XTEND_CLASS__INFERRED_JVM_TYPE, oldInferredJvmType, inferredJvmType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackageName()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleName()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case Xtend2Package.XTEND_CLASS__TYPE_PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypeParameters()).basicAdd(otherEnd, msgs);
			case Xtend2Package.XTEND_CLASS__MEMBERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMembers()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case Xtend2Package.XTEND_CLASS__TYPE_PARAMETERS:
				return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
			case Xtend2Package.XTEND_CLASS__SUPER_TYPES:
				return ((InternalEList<?>)getSuperTypes()).basicRemove(otherEnd, msgs);
			case Xtend2Package.XTEND_CLASS__MEMBERS:
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
			case Xtend2Package.XTEND_CLASS__TYPE_PARAMETERS:
				return getTypeParameters();
			case Xtend2Package.XTEND_CLASS__NAME:
				return getName();
			case Xtend2Package.XTEND_CLASS__EXTENDS:
				if (resolve) return getExtends();
				return basicGetExtends();
			case Xtend2Package.XTEND_CLASS__IMPLEMENTS:
				return getImplements();
			case Xtend2Package.XTEND_CLASS__SUPER_TYPES:
				return getSuperTypes();
			case Xtend2Package.XTEND_CLASS__MEMBERS:
				return getMembers();
			case Xtend2Package.XTEND_CLASS__INFERRED_JVM_TYPE:
				if (resolve) return getInferredJvmType();
				return basicGetInferredJvmType();
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
			case Xtend2Package.XTEND_CLASS__TYPE_PARAMETERS:
				getTypeParameters().clear();
				getTypeParameters().addAll((Collection<? extends JvmTypeParameter>)newValue);
				return;
			case Xtend2Package.XTEND_CLASS__NAME:
				setName((String)newValue);
				return;
			case Xtend2Package.XTEND_CLASS__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends JvmTypeReference>)newValue);
				return;
			case Xtend2Package.XTEND_CLASS__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends XtendMember>)newValue);
				return;
			case Xtend2Package.XTEND_CLASS__INFERRED_JVM_TYPE:
				setInferredJvmType((JvmGenericType)newValue);
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
			case Xtend2Package.XTEND_CLASS__TYPE_PARAMETERS:
				getTypeParameters().clear();
				return;
			case Xtend2Package.XTEND_CLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Xtend2Package.XTEND_CLASS__SUPER_TYPES:
				getSuperTypes().clear();
				return;
			case Xtend2Package.XTEND_CLASS__MEMBERS:
				getMembers().clear();
				return;
			case Xtend2Package.XTEND_CLASS__INFERRED_JVM_TYPE:
				setInferredJvmType((JvmGenericType)null);
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
			case Xtend2Package.XTEND_CLASS__TYPE_PARAMETERS:
				return typeParameters != null && !typeParameters.isEmpty();
			case Xtend2Package.XTEND_CLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Xtend2Package.XTEND_CLASS__EXTENDS:
				return extends_ != null;
			case Xtend2Package.XTEND_CLASS__IMPLEMENTS:
				return implements_ != null && !implements_.isEmpty();
			case Xtend2Package.XTEND_CLASS__SUPER_TYPES:
				return superTypes != null && !superTypes.isEmpty();
			case Xtend2Package.XTEND_CLASS__MEMBERS:
				return members != null && !members.isEmpty();
			case Xtend2Package.XTEND_CLASS__INFERRED_JVM_TYPE:
				return inferredJvmType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == JvmTypeParameterDeclarator.class)
		{
			switch (derivedFeatureID)
			{
				case Xtend2Package.XTEND_CLASS__TYPE_PARAMETERS: return TypesPackage.JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == JvmTypeParameterDeclarator.class)
		{
			switch (baseFeatureID)
			{
				case TypesPackage.JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS: return Xtend2Package.XTEND_CLASS__TYPE_PARAMETERS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

} //XtendClassImpl
