/**
 * <copyright>
 * </copyright>
 *
 * $Id: MetaModelImpl.java,v 1.3 2008/05/15 14:38:04 sefftinge Exp $
 */
package org.eclipse.xtext.xtextutil.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.AbstractMetamodelDeclaration;

import org.eclipse.xtext.xtextutil.MetaModel;
import org.eclipse.xtext.xtextutil.XtextutilPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextutil.impl.MetaModelImpl#getEPackage <em>EPackage</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextutil.impl.MetaModelImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextutil.impl.MetaModelImpl#isReferenced <em>Referenced</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextutil.impl.MetaModelImpl#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetaModelImpl extends EObjectImpl implements MetaModel
{
  /**
	 * The cached value of the '{@link #getEPackage() <em>EPackage</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEPackage()
	 * @generated
	 * @ordered
	 */
  protected EPackage ePackage;

  /**
	 * The default value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
  protected static final String ALIAS_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
  protected String alias = ALIAS_EDEFAULT;

  /**
	 * The default value of the '{@link #isReferenced() <em>Referenced</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isReferenced()
	 * @generated
	 * @ordered
	 */
  protected static final boolean REFERENCED_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isReferenced() <em>Referenced</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isReferenced()
	 * @generated
	 * @ordered
	 */
  protected boolean referenced = REFERENCED_EDEFAULT;

  /**
	 * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
  protected AbstractMetamodelDeclaration declaration;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected MetaModelImpl()
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
		return XtextutilPackage.Literals.META_MODEL;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EPackage getEPackage()
  {
		if (ePackage != null && ePackage.eIsProxy()) {
			InternalEObject oldEPackage = (InternalEObject)ePackage;
			ePackage = (EPackage)eResolveProxy(oldEPackage);
			if (ePackage != oldEPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtextutilPackage.META_MODEL__EPACKAGE, oldEPackage, ePackage));
			}
		}
		return ePackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EPackage basicGetEPackage()
  {
		return ePackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setEPackage(EPackage newEPackage)
  {
		EPackage oldEPackage = ePackage;
		ePackage = newEPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextutilPackage.META_MODEL__EPACKAGE, oldEPackage, ePackage));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getAlias()
  {
		return alias;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAlias(String newAlias)
  {
		String oldAlias = alias;
		alias = newAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextutilPackage.META_MODEL__ALIAS, oldAlias, alias));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isReferenced()
  {
		return referenced;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setReferenced(boolean newReferenced)
  {
		boolean oldReferenced = referenced;
		referenced = newReferenced;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextutilPackage.META_MODEL__REFERENCED, oldReferenced, referenced));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AbstractMetamodelDeclaration getDeclaration()
  {
		if (declaration != null && declaration.eIsProxy()) {
			InternalEObject oldDeclaration = (InternalEObject)declaration;
			declaration = (AbstractMetamodelDeclaration)eResolveProxy(oldDeclaration);
			if (declaration != oldDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtextutilPackage.META_MODEL__DECLARATION, oldDeclaration, declaration));
			}
		}
		return declaration;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AbstractMetamodelDeclaration basicGetDeclaration()
  {
		return declaration;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDeclaration(AbstractMetamodelDeclaration newDeclaration)
  {
		AbstractMetamodelDeclaration oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextutilPackage.META_MODEL__DECLARATION, oldDeclaration, declaration));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case XtextutilPackage.META_MODEL__EPACKAGE:
				if (resolve) return getEPackage();
				return basicGetEPackage();
			case XtextutilPackage.META_MODEL__ALIAS:
				return getAlias();
			case XtextutilPackage.META_MODEL__REFERENCED:
				return isReferenced() ? Boolean.TRUE : Boolean.FALSE;
			case XtextutilPackage.META_MODEL__DECLARATION:
				if (resolve) return getDeclaration();
				return basicGetDeclaration();
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
		switch (featureID) {
			case XtextutilPackage.META_MODEL__EPACKAGE:
				setEPackage((EPackage)newValue);
				return;
			case XtextutilPackage.META_MODEL__ALIAS:
				setAlias((String)newValue);
				return;
			case XtextutilPackage.META_MODEL__REFERENCED:
				setReferenced(((Boolean)newValue).booleanValue());
				return;
			case XtextutilPackage.META_MODEL__DECLARATION:
				setDeclaration((AbstractMetamodelDeclaration)newValue);
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
		switch (featureID) {
			case XtextutilPackage.META_MODEL__EPACKAGE:
				setEPackage((EPackage)null);
				return;
			case XtextutilPackage.META_MODEL__ALIAS:
				setAlias(ALIAS_EDEFAULT);
				return;
			case XtextutilPackage.META_MODEL__REFERENCED:
				setReferenced(REFERENCED_EDEFAULT);
				return;
			case XtextutilPackage.META_MODEL__DECLARATION:
				setDeclaration((AbstractMetamodelDeclaration)null);
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
		switch (featureID) {
			case XtextutilPackage.META_MODEL__EPACKAGE:
				return ePackage != null;
			case XtextutilPackage.META_MODEL__ALIAS:
				return ALIAS_EDEFAULT == null ? alias != null : !ALIAS_EDEFAULT.equals(alias);
			case XtextutilPackage.META_MODEL__REFERENCED:
				return referenced != REFERENCED_EDEFAULT;
			case XtextutilPackage.META_MODEL__DECLARATION:
				return declaration != null;
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
		result.append(" (alias: ");
		result.append(alias);
		result.append(", referenced: ");
		result.append(referenced);
		result.append(')');
		return result.toString();
	}

} //MetaModelImpl
