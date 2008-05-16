/**
 * <copyright>
 * </copyright>
 *
 * $Id: MetaModel.java,v 1.5 2008/05/16 17:30:41 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextutil;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.xtext.AbstractMetamodelDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextutil.MetaModel#getEPackage <em>EPackage</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextutil.MetaModel#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextutil.MetaModel#isReferenced <em>Referenced</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextutil.MetaModel#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getMetaModel()
 * @model
 * @generated
 */
public interface MetaModel extends EObject
{
  /**
   * Returns the value of the '<em><b>EPackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>EPackage</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>EPackage</em>' reference.
   * @see #setEPackage(EPackage)
   * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getMetaModel_EPackage()
   * @model
   * @generated
   */
  EPackage getEPackage();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextutil.MetaModel#getEPackage <em>EPackage</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>EPackage</em>' reference.
   * @see #getEPackage()
   * @generated
   */
  void setEPackage(EPackage value);

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
   * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getMetaModel_Alias()
   * @model
   * @generated
   */
  String getAlias();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextutil.MetaModel#getAlias <em>Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' attribute.
   * @see #getAlias()
   * @generated
   */
  void setAlias(String value);

  /**
   * Returns the value of the '<em><b>Referenced</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced</em>' attribute.
   * @see #setReferenced(boolean)
   * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getMetaModel_Referenced()
   * @model
   * @generated
   */
  boolean isReferenced();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextutil.MetaModel#isReferenced <em>Referenced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced</em>' attribute.
   * @see #isReferenced()
   * @generated
   */
  void setReferenced(boolean value);

  /**
   * Returns the value of the '<em><b>Declaration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declaration</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declaration</em>' reference.
   * @see #setDeclaration(AbstractMetamodelDeclaration)
   * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getMetaModel_Declaration()
   * @model
   * @generated
   */
  AbstractMetamodelDeclaration getDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextutil.MetaModel#getDeclaration <em>Declaration</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declaration</em>' reference.
   * @see #getDeclaration()
   * @generated
   */
  void setDeclaration(AbstractMetamodelDeclaration value);

} // MetaModel
