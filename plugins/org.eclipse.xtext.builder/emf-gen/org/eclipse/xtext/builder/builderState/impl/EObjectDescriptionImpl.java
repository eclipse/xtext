/**
 * <copyright>
 * </copyright>
 *
 * $Id: EObjectDescriptionImpl.java,v 1.4 2009/12/01 14:07:33 sefftinge Exp $
 */
package org.eclipse.xtext.builder.builderState.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.core.resource.IStorageAwareResourceDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EObject Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl#getFragment <em>Fragment</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl#getEClass <em>EClass</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl#getResourceDescriptor <em>Resource Descriptor</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl#getUserData <em>User Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EObjectDescriptionImpl extends Container implements IEObjectDescription {
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
	 * The cached value of the '{@link #getEClass() <em>EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClass()
	 * @generated
	 * @ordered
	 */
	protected EClass eClass;

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
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.EOBJECT_DESCRIPTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFragment() {
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFragment(String newFragment) {
		String oldFragment = fragment;
		fragment = newFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.EOBJECT_DESCRIPTION__FRAGMENT, oldFragment, fragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public IStorageAwareResourceDescription getResourceDescriptor() {
		if (eContainerFeatureID() != BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR) return null;
		return (IStorageAwareResourceDescription)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceDescriptor(IStorageAwareResourceDescription newResourceDescriptor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResourceDescriptor, BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceDescriptor(IStorageAwareResourceDescription newResourceDescriptor) {
		if (newResourceDescriptor != eInternalContainer() || (eContainerFeatureID() != BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR && newResourceDescriptor != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newResourceDescriptor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newResourceDescriptor != null)
				msgs = ((InternalEObject)newResourceDescriptor).eInverseAdd(this, BuilderStatePackage.RESOURCE_DESCRIPTION__EXPORTED_OBJECTS, IStorageAwareResourceDescription.class, msgs);
			msgs = basicSetResourceDescriptor(newResourceDescriptor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR, newResourceDescriptor, newResourceDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public void unsetUserData() {
		if (userData != null) ((InternalEList.Unsettable<?>)userData).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserData() {
		return userData != null && ((InternalEList.Unsettable<?>)userData).isSet();
	}

	public URI getEObjectURI() {
		return getResourceDescriptor().getURI().appendFragment(getFragment());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject getEObjectOrProxy() {
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) getEClass().getEPackage().getEFactoryInstance().create(getEClass());
		proxy.eSetProxyURI(getEObjectURI());
		return proxy;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUserData(String name) {
		return getUserData().get(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String[] getUserDataKeys() {
		return getUserData().keySet().toArray(new String[getUserData().size()]);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetResourceDescriptor((IStorageAwareResourceDescription)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR:
				return basicSetResourceDescriptor(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR:
				return eInternalContainer().eInverseRemove(this, BuilderStatePackage.RESOURCE_DESCRIPTION__EXPORTED_OBJECTS, IStorageAwareResourceDescription.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BuilderStatePackage.EOBJECT_DESCRIPTION__NAME:
				return getName();
			case BuilderStatePackage.EOBJECT_DESCRIPTION__FRAGMENT:
				return getFragment();
			case BuilderStatePackage.EOBJECT_DESCRIPTION__ECLASS:
				if (resolve) return getEClass();
				return basicGetEClass();
			case BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR:
				return getResourceDescriptor();
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
			case BuilderStatePackage.EOBJECT_DESCRIPTION__NAME:
				setName((String)newValue);
				return;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__FRAGMENT:
				setFragment((String)newValue);
				return;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__ECLASS:
				setEClass((EClass)newValue);
				return;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR:
				setResourceDescriptor((IStorageAwareResourceDescription)newValue);
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
			case BuilderStatePackage.EOBJECT_DESCRIPTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__FRAGMENT:
				setFragment(FRAGMENT_EDEFAULT);
				return;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__ECLASS:
				setEClass((EClass)null);
				return;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR:
				setResourceDescriptor((IStorageAwareResourceDescription)null);
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
			case BuilderStatePackage.EOBJECT_DESCRIPTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BuilderStatePackage.EOBJECT_DESCRIPTION__FRAGMENT:
				return FRAGMENT_EDEFAULT == null ? fragment != null : !FRAGMENT_EDEFAULT.equals(fragment);
			case BuilderStatePackage.EOBJECT_DESCRIPTION__ECLASS:
				return eClass != null;
			case BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR:
				return getResourceDescriptor() != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", fragment: ");
		result.append(fragment);
		result.append(')');
		return result.toString();
	}

} //EObjectDescriptionImpl
