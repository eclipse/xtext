/**
 * <copyright>
 * </copyright>
 *
 * $Id: GeneratedMetamodel.java,v 1.3 2008/05/15 13:25:59 jkohnlein Exp $
 */
package org.eclipse.xtext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generated Metamodel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.GeneratedMetamodel#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.eclipse.xtext.GeneratedMetamodel#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.XtextPackage#getGeneratedMetamodel()
 * @model
 * @generated
 */
public interface GeneratedMetamodel extends AbstractMetamodelDeclaration
{
  /**
   * Returns the value of the '<em><b>Ns URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ns URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ns URI</em>' attribute.
   * @see #setNsURI(String)
   * @see org.eclipse.xtext.XtextPackage#getGeneratedMetamodel_NsURI()
   * @model
   * @generated
   */
  String getNsURI();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.GeneratedMetamodel#getNsURI <em>Ns URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ns URI</em>' attribute.
   * @see #getNsURI()
   * @generated
   */
  void setNsURI(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.XtextPackage#getGeneratedMetamodel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.GeneratedMetamodel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // GeneratedMetamodel
