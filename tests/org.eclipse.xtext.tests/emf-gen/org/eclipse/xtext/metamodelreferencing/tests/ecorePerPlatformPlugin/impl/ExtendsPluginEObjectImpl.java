/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.ExtendsNsURIEObject;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.EcorePerPlatformPluginPackage;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.ExtendsPluginEObject;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.ExtendsResourceEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extends Plugin EObject</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.impl.ExtendsPluginEObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.impl.ExtendsPluginEObjectImpl#getEObjectReference1 <em>EObject Reference1</em>}</li>
 *   <li>{@link org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.impl.ExtendsPluginEObjectImpl#getEObjectReference2 <em>EObject Reference2</em>}</li>
 *   <li>{@link org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.impl.ExtendsPluginEObjectImpl#getEObjectReference3 <em>EObject Reference3</em>}</li>
 *   <li>{@link org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.impl.ExtendsPluginEObjectImpl#getEObjectReference4 <em>EObject Reference4</em>}</li>
 *   <li>{@link org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.impl.ExtendsPluginEObjectImpl#getEObjectContainment <em>EObject Containment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendsPluginEObjectImpl extends EObjectImpl implements ExtendsPluginEObject {
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
	 * The cached value of the '{@link #getEObjectReference1() <em>EObject Reference1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEObjectReference1()
	 * @generated
	 * @ordered
	 */
	protected EObject eObjectReference1;

	/**
	 * The cached value of the '{@link #getEObjectReference2() <em>EObject Reference2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEObjectReference2()
	 * @generated
	 * @ordered
	 */
	protected ExtendsNsURIEObject eObjectReference2;

	/**
	 * The cached value of the '{@link #getEObjectReference3() <em>EObject Reference3</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEObjectReference3()
	 * @generated
	 * @ordered
	 */
	protected ExtendsPluginEObject eObjectReference3;

	/**
	 * The cached value of the '{@link #getEObjectReference4() <em>EObject Reference4</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEObjectReference4()
	 * @generated
	 * @ordered
	 */
	protected ExtendsResourceEObject eObjectReference4;

	/**
	 * The cached value of the '{@link #getEObjectContainment() <em>EObject Containment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEObjectContainment()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> eObjectContainment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendsPluginEObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcorePerPlatformPluginPackage.Literals.EXTENDS_PLUGIN_EOBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getEObjectReference1() {
		if (eObjectReference1 != null && eObjectReference1.eIsProxy()) {
			InternalEObject oldEObjectReference1 = (InternalEObject)eObjectReference1;
			eObjectReference1 = eResolveProxy(oldEObjectReference1);
			if (eObjectReference1 != oldEObjectReference1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE1, oldEObjectReference1, eObjectReference1));
			}
		}
		return eObjectReference1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetEObjectReference1() {
		return eObjectReference1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEObjectReference1(EObject newEObjectReference1) {
		EObject oldEObjectReference1 = eObjectReference1;
		eObjectReference1 = newEObjectReference1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE1, oldEObjectReference1, eObjectReference1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsNsURIEObject getEObjectReference2() {
		if (eObjectReference2 != null && eObjectReference2.eIsProxy()) {
			InternalEObject oldEObjectReference2 = (InternalEObject)eObjectReference2;
			eObjectReference2 = (ExtendsNsURIEObject)eResolveProxy(oldEObjectReference2);
			if (eObjectReference2 != oldEObjectReference2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE2, oldEObjectReference2, eObjectReference2));
			}
		}
		return eObjectReference2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsNsURIEObject basicGetEObjectReference2() {
		return eObjectReference2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEObjectReference2(ExtendsNsURIEObject newEObjectReference2) {
		ExtendsNsURIEObject oldEObjectReference2 = eObjectReference2;
		eObjectReference2 = newEObjectReference2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE2, oldEObjectReference2, eObjectReference2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsPluginEObject getEObjectReference3() {
		if (eObjectReference3 != null && eObjectReference3.eIsProxy()) {
			InternalEObject oldEObjectReference3 = (InternalEObject)eObjectReference3;
			eObjectReference3 = (ExtendsPluginEObject)eResolveProxy(oldEObjectReference3);
			if (eObjectReference3 != oldEObjectReference3) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE3, oldEObjectReference3, eObjectReference3));
			}
		}
		return eObjectReference3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsPluginEObject basicGetEObjectReference3() {
		return eObjectReference3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEObjectReference3(ExtendsPluginEObject newEObjectReference3) {
		ExtendsPluginEObject oldEObjectReference3 = eObjectReference3;
		eObjectReference3 = newEObjectReference3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE3, oldEObjectReference3, eObjectReference3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsResourceEObject getEObjectReference4() {
		if (eObjectReference4 != null && eObjectReference4.eIsProxy()) {
			InternalEObject oldEObjectReference4 = (InternalEObject)eObjectReference4;
			eObjectReference4 = (ExtendsResourceEObject)eResolveProxy(oldEObjectReference4);
			if (eObjectReference4 != oldEObjectReference4) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE4, oldEObjectReference4, eObjectReference4));
			}
		}
		return eObjectReference4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsResourceEObject basicGetEObjectReference4() {
		return eObjectReference4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEObjectReference4(ExtendsResourceEObject newEObjectReference4) {
		ExtendsResourceEObject oldEObjectReference4 = eObjectReference4;
		eObjectReference4 = newEObjectReference4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE4, oldEObjectReference4, eObjectReference4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getEObjectContainment() {
		if (eObjectContainment == null) {
			eObjectContainment = new EObjectContainmentEList<EObject>(EObject.class, this, EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_CONTAINMENT);
		}
		return eObjectContainment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_CONTAINMENT:
				return ((InternalEList<?>)getEObjectContainment()).basicRemove(otherEnd, msgs);
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
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__NAME:
				return getName();
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE1:
				if (resolve) return getEObjectReference1();
				return basicGetEObjectReference1();
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE2:
				if (resolve) return getEObjectReference2();
				return basicGetEObjectReference2();
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE3:
				if (resolve) return getEObjectReference3();
				return basicGetEObjectReference3();
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE4:
				if (resolve) return getEObjectReference4();
				return basicGetEObjectReference4();
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_CONTAINMENT:
				return getEObjectContainment();
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
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__NAME:
				setName((String)newValue);
				return;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE1:
				setEObjectReference1((EObject)newValue);
				return;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE2:
				setEObjectReference2((ExtendsNsURIEObject)newValue);
				return;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE3:
				setEObjectReference3((ExtendsPluginEObject)newValue);
				return;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE4:
				setEObjectReference4((ExtendsResourceEObject)newValue);
				return;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_CONTAINMENT:
				getEObjectContainment().clear();
				getEObjectContainment().addAll((Collection<? extends EObject>)newValue);
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
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE1:
				setEObjectReference1((EObject)null);
				return;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE2:
				setEObjectReference2((ExtendsNsURIEObject)null);
				return;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE3:
				setEObjectReference3((ExtendsPluginEObject)null);
				return;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE4:
				setEObjectReference4((ExtendsResourceEObject)null);
				return;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_CONTAINMENT:
				getEObjectContainment().clear();
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
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE1:
				return eObjectReference1 != null;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE2:
				return eObjectReference2 != null;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE3:
				return eObjectReference3 != null;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE4:
				return eObjectReference4 != null;
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT__EOBJECT_CONTAINMENT:
				return eObjectContainment != null && !eObjectContainment.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ExtendsPluginEObjectImpl
