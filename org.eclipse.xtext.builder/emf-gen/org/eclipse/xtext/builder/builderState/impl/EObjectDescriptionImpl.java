/**
 * <copyright>
 * </copyright>
 *
 * $Id: EObjectDescriptionImpl.java,v 1.7 2010/04/12 20:19:21 szarnekow Exp $
 */
package org.eclipse.xtext.builder.builderState.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.builder.builderState.EObjectDescription;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EObject Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl#getEClass <em>EClass</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl#getFragment <em>Fragment</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl#getUserData <em>User Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EObjectDescriptionImpl extends org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container implements EObjectDescription {
	/**
	 * The cached value of the '{@link #getEClass() <em>EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClass()
	 * @generated
	 * @ordered
	 */
	protected EClass eClass;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final QualifiedName NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected QualifiedName name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFragment() <em>Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragment()
	 * @generated
	 * @ordered
	 */
	protected static final String FRAGMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFragment() <em>Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragment()
	 * @generated
	 * @ordered
	 */
	protected String fragment = FRAGMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUserData() <em>User Data</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserData()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> userData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObjectDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BuilderStatePackage.Literals.EOBJECT_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QualifiedName getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(QualifiedName newName) {
		QualifiedName oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.EOBJECT_DESCRIPTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFragment() {
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFragmentGen(String newFragment) {
		String oldFragment = fragment;
		fragment = newFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.EOBJECT_DESCRIPTION__FRAGMENT, oldFragment, fragment));
	}

	public void setFragment(String newFragment) {
		setFragmentGen(newFragment);
		eObjectURI = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEClass() {
		if (eClass != null && eClass.eIsProxy()) {
			InternalEObject oldEClass = (InternalEObject)eClass;
			eClass = (EClass)eResolveProxy(oldEClass);
			if (eClass != oldEClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BuilderStatePackage.EOBJECT_DESCRIPTION__ECLASS, oldEClass, eClass));
			}
		}
		return eClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetEClass() {
		return eClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEClass(EClass newEClass) {
		EClass oldEClass = eClass;
		eClass = newEClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.EOBJECT_DESCRIPTION__ECLASS, oldEClass, eClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, String> getUserData() {
		if (userData == null) {
			userData = new EcoreEMap.Unsettable<String,String>(BuilderStatePackage.Literals.USER_DATA_ENTRY, UserDataEntryImpl.class, this, BuilderStatePackage.EOBJECT_DESCRIPTION__USER_DATA);
		}
		return userData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserData() {
		if (userData != null) ((InternalEList.Unsettable<?>)userData).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserData() {
		return userData != null && ((InternalEList.Unsettable<?>)userData).isSet();
	}

	private URI eObjectURI;

	@Override
	public URI getEObjectURI() {
		EObject container = eContainer();
		if (container instanceof IResourceDescription) {
			URI resourceURI = ((IResourceDescription) container).getURI();
			if (eObjectURI == null || !eObjectURI.trimFragment().equals(resourceURI)) {
				eObjectURI = resourceURI.appendFragment(getFragment());
			}
			return eObjectURI;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EObject getEObjectOrProxy() {
		EClass clazz = getEClass();
		if (clazz != null && !clazz.eIsProxy()) {
			EPackage ePackage = clazz.getEPackage();
			if (ePackage != null && ePackage.getEFactoryInstance() != null) {
				org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) ePackage.getEFactoryInstance().create(clazz);
				proxy.eSetProxyURI(getEObjectURI());
				return proxy;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getUserData(String name) {
		return getUserData().get(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String[] getUserDataKeys() {
		return getUserData().keySet().toArray(new String[getUserData().size()]);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public QualifiedName getQualifiedName() {
		return getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BuilderStatePackage.EOBJECT_DESCRIPTION__USER_DATA:
				return ((InternalEList<?>)getUserData()).basicRemove(otherEnd, msgs);
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
			case BuilderStatePackage.EOBJECT_DESCRIPTION__ECLASS:
				if (resolve) return getEClass();
				return basicGetEClass();
			case BuilderStatePackage.EOBJECT_DESCRIPTION__NAME:
				return getName();
			case BuilderStatePackage.EOBJECT_DESCRIPTION__FRAGMENT:
				return getFragment();
			case BuilderStatePackage.EOBJECT_DESCRIPTION__USER_DATA:
				if (coreType) return getUserData();
				else return getUserData().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BuilderStatePackage.EOBJECT_DESCRIPTION__ECLASS:
				setEClass((EClass)newValue);
				return;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__NAME:
				setName((QualifiedName)newValue);
				return;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__FRAGMENT:
				setFragment((String)newValue);
				return;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__USER_DATA:
				((EStructuralFeature.Setting)getUserData()).set(newValue);
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
			case BuilderStatePackage.EOBJECT_DESCRIPTION__ECLASS:
				setEClass((EClass)null);
				return;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__FRAGMENT:
				setFragment(FRAGMENT_EDEFAULT);
				return;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__USER_DATA:
				unsetUserData();
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
			case BuilderStatePackage.EOBJECT_DESCRIPTION__ECLASS:
				return eClass != null;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BuilderStatePackage.EOBJECT_DESCRIPTION__FRAGMENT:
				return FRAGMENT_EDEFAULT == null ? fragment != null : !FRAGMENT_EDEFAULT.equals(fragment);
			case BuilderStatePackage.EOBJECT_DESCRIPTION__USER_DATA:
				return isSetUserData();
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", fragment: ");
		result.append(fragment);
		result.append(')');
		return result.toString();
	}

} //EObjectDescriptionImpl
