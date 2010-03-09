/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl#getSerialVersionUID <em>Serial Version UID</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl#isCloneable <em>Cloneable</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectImpl extends MinimalEObjectImpl.Container implements org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object
{
  /**
   * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isEnabled()
   * @generated
   * @ordered
   */
  protected static final boolean ENABLED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isEnabled()
   * @generated
   * @ordered
   */
  protected boolean enabled = ENABLED_EDEFAULT;

  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

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
   * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParent()
   * @generated
   * @ordered
   */
  protected org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object parent;

  /**
   * The default value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortDescription()
   * @generated
   * @ordered
   */
  protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortDescription()
   * @generated
   * @ordered
   */
  protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLongDescription()
   * @generated
   * @ordered
   */
  protected static final String LONG_DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLongDescription()
   * @generated
   * @ordered
   */
  protected String longDescription = LONG_DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getSerialVersionUID() <em>Serial Version UID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSerialVersionUID()
   * @generated
   * @ordered
   */
  protected static final int SERIAL_VERSION_UID_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSerialVersionUID() <em>Serial Version UID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSerialVersionUID()
   * @generated
   * @ordered
   */
  protected int serialVersionUID = SERIAL_VERSION_UID_EDEFAULT;

  /**
   * The default value of the '{@link #isCloneable() <em>Cloneable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCloneable()
   * @generated
   * @ordered
   */
  protected static final boolean CLONEABLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCloneable() <em>Cloneable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCloneable()
   * @generated
   * @ordered
   */
  protected boolean cloneable = CLONEABLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList<Feature> features;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ObjectImpl()
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
    return Bug304681TestLanguagePackage.Literals.OBJECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isEnabled()
  {
    return enabled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnabled(boolean newEnabled)
  {
    boolean oldEnabled = enabled;
    enabled = newEnabled;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.OBJECT__ENABLED, oldEnabled, enabled));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAbstract()
  {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstract(boolean newAbstract)
  {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.OBJECT__ABSTRACT, oldAbstract, abstract_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.OBJECT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object getParent()
  {
    if (parent != null && parent.eIsProxy())
    {
      InternalEObject oldParent = (InternalEObject)parent;
      parent = (org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object)eResolveProxy(oldParent);
      if (parent != oldParent)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug304681TestLanguagePackage.OBJECT__PARENT, oldParent, parent));
      }
    }
    return parent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object basicGetParent()
  {
    return parent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParent(org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object newParent)
  {
    org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object oldParent = parent;
    parent = newParent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.OBJECT__PARENT, oldParent, parent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getShortDescription()
  {
    return shortDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShortDescription(String newShortDescription)
  {
    String oldShortDescription = shortDescription;
    shortDescription = newShortDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.OBJECT__SHORT_DESCRIPTION, oldShortDescription, shortDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLongDescription()
  {
    return longDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLongDescription(String newLongDescription)
  {
    String oldLongDescription = longDescription;
    longDescription = newLongDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.OBJECT__LONG_DESCRIPTION, oldLongDescription, longDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getSerialVersionUID()
  {
    return serialVersionUID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSerialVersionUID(int newSerialVersionUID)
  {
    int oldSerialVersionUID = serialVersionUID;
    serialVersionUID = newSerialVersionUID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.OBJECT__SERIAL_VERSION_UID, oldSerialVersionUID, serialVersionUID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCloneable()
  {
    return cloneable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCloneable(boolean newCloneable)
  {
    boolean oldCloneable = cloneable;
    cloneable = newCloneable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.OBJECT__CLONEABLE, oldCloneable, cloneable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getFeatures()
  {
    if (features == null)
    {
      features = new EObjectContainmentEList<Feature>(Feature.class, this, Bug304681TestLanguagePackage.OBJECT__FEATURES);
    }
    return features;
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
      case Bug304681TestLanguagePackage.OBJECT__FEATURES:
        return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
      case Bug304681TestLanguagePackage.OBJECT__ENABLED:
        return isEnabled();
      case Bug304681TestLanguagePackage.OBJECT__ABSTRACT:
        return isAbstract();
      case Bug304681TestLanguagePackage.OBJECT__NAME:
        return getName();
      case Bug304681TestLanguagePackage.OBJECT__PARENT:
        if (resolve) return getParent();
        return basicGetParent();
      case Bug304681TestLanguagePackage.OBJECT__SHORT_DESCRIPTION:
        return getShortDescription();
      case Bug304681TestLanguagePackage.OBJECT__LONG_DESCRIPTION:
        return getLongDescription();
      case Bug304681TestLanguagePackage.OBJECT__SERIAL_VERSION_UID:
        return getSerialVersionUID();
      case Bug304681TestLanguagePackage.OBJECT__CLONEABLE:
        return isCloneable();
      case Bug304681TestLanguagePackage.OBJECT__FEATURES:
        return getFeatures();
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
      case Bug304681TestLanguagePackage.OBJECT__ENABLED:
        setEnabled((Boolean)newValue);
        return;
      case Bug304681TestLanguagePackage.OBJECT__ABSTRACT:
        setAbstract((Boolean)newValue);
        return;
      case Bug304681TestLanguagePackage.OBJECT__NAME:
        setName((String)newValue);
        return;
      case Bug304681TestLanguagePackage.OBJECT__PARENT:
        setParent((org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object)newValue);
        return;
      case Bug304681TestLanguagePackage.OBJECT__SHORT_DESCRIPTION:
        setShortDescription((String)newValue);
        return;
      case Bug304681TestLanguagePackage.OBJECT__LONG_DESCRIPTION:
        setLongDescription((String)newValue);
        return;
      case Bug304681TestLanguagePackage.OBJECT__SERIAL_VERSION_UID:
        setSerialVersionUID((Integer)newValue);
        return;
      case Bug304681TestLanguagePackage.OBJECT__CLONEABLE:
        setCloneable((Boolean)newValue);
        return;
      case Bug304681TestLanguagePackage.OBJECT__FEATURES:
        getFeatures().clear();
        getFeatures().addAll((Collection<? extends Feature>)newValue);
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
      case Bug304681TestLanguagePackage.OBJECT__ENABLED:
        setEnabled(ENABLED_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.OBJECT__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.OBJECT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.OBJECT__PARENT:
        setParent((org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object)null);
        return;
      case Bug304681TestLanguagePackage.OBJECT__SHORT_DESCRIPTION:
        setShortDescription(SHORT_DESCRIPTION_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.OBJECT__LONG_DESCRIPTION:
        setLongDescription(LONG_DESCRIPTION_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.OBJECT__SERIAL_VERSION_UID:
        setSerialVersionUID(SERIAL_VERSION_UID_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.OBJECT__CLONEABLE:
        setCloneable(CLONEABLE_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.OBJECT__FEATURES:
        getFeatures().clear();
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
      case Bug304681TestLanguagePackage.OBJECT__ENABLED:
        return enabled != ENABLED_EDEFAULT;
      case Bug304681TestLanguagePackage.OBJECT__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case Bug304681TestLanguagePackage.OBJECT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Bug304681TestLanguagePackage.OBJECT__PARENT:
        return parent != null;
      case Bug304681TestLanguagePackage.OBJECT__SHORT_DESCRIPTION:
        return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals(shortDescription);
      case Bug304681TestLanguagePackage.OBJECT__LONG_DESCRIPTION:
        return LONG_DESCRIPTION_EDEFAULT == null ? longDescription != null : !LONG_DESCRIPTION_EDEFAULT.equals(longDescription);
      case Bug304681TestLanguagePackage.OBJECT__SERIAL_VERSION_UID:
        return serialVersionUID != SERIAL_VERSION_UID_EDEFAULT;
      case Bug304681TestLanguagePackage.OBJECT__CLONEABLE:
        return cloneable != CLONEABLE_EDEFAULT;
      case Bug304681TestLanguagePackage.OBJECT__FEATURES:
        return features != null && !features.isEmpty();
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
    result.append(" (enabled: ");
    result.append(enabled);
    result.append(", abstract: ");
    result.append(abstract_);
    result.append(", name: ");
    result.append(name);
    result.append(", shortDescription: ");
    result.append(shortDescription);
    result.append(", longDescription: ");
    result.append(longDescription);
    result.append(", serialVersionUID: ");
    result.append(serialVersionUID);
    result.append(", cloneable: ");
    result.append(cloneable);
    result.append(')');
    return result.toString();
  }

} //ObjectImpl
