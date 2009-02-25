/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtext.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.xtext.TypeRef;
import org.eclipse.xtext.xtext.XtextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtext.impl.TypeRefImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtext.impl.TypeRefImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeRefImpl extends MinimalEObjectImpl.Container implements TypeRef
{
  /**
   * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodel()
   * @generated
   * @ordered
   */
  protected AbstractMetamodelDeclaration metamodel;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EClassifier type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeRefImpl()
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
    return XtextPackage.Literals.TYPE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractMetamodelDeclaration getMetamodel()
  {
    if (metamodel != null && metamodel.eIsProxy())
    {
      InternalEObject oldMetamodel = (InternalEObject)metamodel;
      metamodel = (AbstractMetamodelDeclaration)eResolveProxy(oldMetamodel);
      if (metamodel != oldMetamodel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtextPackage.TYPE_REF__METAMODEL, oldMetamodel, metamodel));
      }
    }
    return metamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractMetamodelDeclaration basicGetMetamodel()
  {
    return metamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMetamodel(AbstractMetamodelDeclaration newMetamodel)
  {
    AbstractMetamodelDeclaration oldMetamodel = metamodel;
    metamodel = newMetamodel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.TYPE_REF__METAMODEL, oldMetamodel, metamodel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (EClassifier)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtextPackage.TYPE_REF__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(EClassifier newType)
  {
    EClassifier oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.TYPE_REF__TYPE, oldType, type));
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
      case XtextPackage.TYPE_REF__METAMODEL:
        if (resolve) return getMetamodel();
        return basicGetMetamodel();
      case XtextPackage.TYPE_REF__TYPE:
        if (resolve) return getType();
        return basicGetType();
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
      case XtextPackage.TYPE_REF__METAMODEL:
        setMetamodel((AbstractMetamodelDeclaration)newValue);
        return;
      case XtextPackage.TYPE_REF__TYPE:
        setType((EClassifier)newValue);
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
      case XtextPackage.TYPE_REF__METAMODEL:
        setMetamodel((AbstractMetamodelDeclaration)null);
        return;
      case XtextPackage.TYPE_REF__TYPE:
        setType((EClassifier)null);
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
      case XtextPackage.TYPE_REF__METAMODEL:
        return metamodel != null;
      case XtextPackage.TYPE_REF__TYPE:
        return type != null;
    }
    return super.eIsSet(featureID);
  }

} //TypeRefImpl
