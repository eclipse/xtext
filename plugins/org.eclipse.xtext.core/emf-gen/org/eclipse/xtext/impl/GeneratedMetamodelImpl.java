/**
 * <copyright>
 * </copyright>
 *
 * $Id: GeneratedMetamodelImpl.java,v 1.6 2008/05/20 09:09:48 jkohnlein Exp $
 */
package org.eclipse.xtext.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.XtextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generated Metamodel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.impl.GeneratedMetamodelImpl#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GeneratedMetamodelImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneratedMetamodelImpl extends AbstractMetamodelDeclarationImpl implements GeneratedMetamodel
{
  /**
   * The default value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNsURI()
   * @generated
   * @ordered
   */
  protected static final String NS_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNsURI()
   * @generated
   * @ordered
   */
  protected String nsURI = NS_URI_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GeneratedMetamodelImpl()
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
    return XtextPackage.Literals.GENERATED_METAMODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNsURI()
  {
    return nsURI;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNsURI(String newNsURI)
  {
    String oldNsURI = nsURI;
    nsURI = newNsURI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.GENERATED_METAMODEL__NS_URI, oldNsURI, nsURI));
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
      eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.GENERATED_METAMODEL__NAME, oldName, name));
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
      case XtextPackage.GENERATED_METAMODEL__NS_URI:
        return getNsURI();
      case XtextPackage.GENERATED_METAMODEL__NAME:
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
      case XtextPackage.GENERATED_METAMODEL__NS_URI:
        setNsURI((String)newValue);
        return;
      case XtextPackage.GENERATED_METAMODEL__NAME:
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
      case XtextPackage.GENERATED_METAMODEL__NS_URI:
        setNsURI(NS_URI_EDEFAULT);
        return;
      case XtextPackage.GENERATED_METAMODEL__NAME:
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
      case XtextPackage.GENERATED_METAMODEL__NS_URI:
        return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
      case XtextPackage.GENERATED_METAMODEL__NAME:
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
    result.append(" (nsURI: ");
    result.append(nsURI);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //GeneratedMetamodelImpl
