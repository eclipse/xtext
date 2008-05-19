/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMetamodelDeclaration.java,v 1.5 2008/05/19 12:11:16 jkohnlein Exp $
 */
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Metamodel Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.AbstractMetamodelDeclaration#getAlias <em>Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.XtextPackage#getAbstractMetamodelDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMetamodelDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alias</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alias</em>' attribute.
   * @see #setAlias(String)
   * @see org.eclipse.xtext.XtextPackage#getAbstractMetamodelDeclaration_Alias()
   * @model
   * @generated
   */
  String getAlias();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.AbstractMetamodelDeclaration#getAlias <em>Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' attribute.
   * @see #getAlias()
   * @generated
   */
  void setAlias(String value);

} // AbstractMetamodelDeclaration
