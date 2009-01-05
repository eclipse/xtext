/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferencedMetamodelImpl.java,v 1.11 2009/01/05 10:44:00 szarnekow Exp $
 */
package org.eclipse.xtext.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.XtextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Referenced Metamodel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ReferencedMetamodelImpl extends AbstractMetamodelDeclarationImpl implements ReferencedMetamodel
{
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ReferencedMetamodelImpl()
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
		return XtextPackage.Literals.REFERENCED_METAMODEL;
	}

} //ReferencedMetamodelImpl
