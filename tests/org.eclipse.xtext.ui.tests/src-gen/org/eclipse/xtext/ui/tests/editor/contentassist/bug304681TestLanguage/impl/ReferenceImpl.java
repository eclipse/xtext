/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ReferenceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ReferenceImpl#isMany <em>Many</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ReferenceImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ReferenceImpl#getLongDescription <em>Long Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends FeatureImpl implements Reference
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object type;

  /**
   * The default value of the '{@link #isMany() <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMany()
   * @generated
   * @ordered
   */
  protected static final boolean MANY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMany() <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMany()
   * @generated
   * @ordered
   */
  protected boolean many = MANY_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceImpl()
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
    return Bug304681TestLanguagePackage.Literals.REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug304681TestLanguagePackage.REFERENCE__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object newType)
  {
    org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.REFERENCE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMany()
  {
    return many;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMany(boolean newMany)
  {
    boolean oldMany = many;
    many = newMany;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.REFERENCE__MANY, oldMany, many));
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
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.REFERENCE__SHORT_DESCRIPTION, oldShortDescription, shortDescription));
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
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.REFERENCE__LONG_DESCRIPTION, oldLongDescription, longDescription));
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
      case Bug304681TestLanguagePackage.REFERENCE__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case Bug304681TestLanguagePackage.REFERENCE__MANY:
        return isMany();
      case Bug304681TestLanguagePackage.REFERENCE__SHORT_DESCRIPTION:
        return getShortDescription();
      case Bug304681TestLanguagePackage.REFERENCE__LONG_DESCRIPTION:
        return getLongDescription();
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
      case Bug304681TestLanguagePackage.REFERENCE__TYPE:
        setType((org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object)newValue);
        return;
      case Bug304681TestLanguagePackage.REFERENCE__MANY:
        setMany((Boolean)newValue);
        return;
      case Bug304681TestLanguagePackage.REFERENCE__SHORT_DESCRIPTION:
        setShortDescription((String)newValue);
        return;
      case Bug304681TestLanguagePackage.REFERENCE__LONG_DESCRIPTION:
        setLongDescription((String)newValue);
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
      case Bug304681TestLanguagePackage.REFERENCE__TYPE:
        setType((org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object)null);
        return;
      case Bug304681TestLanguagePackage.REFERENCE__MANY:
        setMany(MANY_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.REFERENCE__SHORT_DESCRIPTION:
        setShortDescription(SHORT_DESCRIPTION_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.REFERENCE__LONG_DESCRIPTION:
        setLongDescription(LONG_DESCRIPTION_EDEFAULT);
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
      case Bug304681TestLanguagePackage.REFERENCE__TYPE:
        return type != null;
      case Bug304681TestLanguagePackage.REFERENCE__MANY:
        return many != MANY_EDEFAULT;
      case Bug304681TestLanguagePackage.REFERENCE__SHORT_DESCRIPTION:
        return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals(shortDescription);
      case Bug304681TestLanguagePackage.REFERENCE__LONG_DESCRIPTION:
        return LONG_DESCRIPTION_EDEFAULT == null ? longDescription != null : !LONG_DESCRIPTION_EDEFAULT.equals(longDescription);
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
    result.append(" (many: ");
    result.append(many);
    result.append(", shortDescription: ");
    result.append(shortDescription);
    result.append(", longDescription: ");
    result.append(longDescription);
    result.append(')');
    return result.toString();
  }

} //ReferenceImpl
