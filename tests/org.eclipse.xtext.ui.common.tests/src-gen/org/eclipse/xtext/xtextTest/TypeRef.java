/**
 * <copyright>
 * </copyright>
 *
 * $Id: TypeRef.java,v 1.2 2009/02/18 21:20:35 sefftinge Exp $
 */
package org.eclipse.xtext.xtextTest;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.TypeRef#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.TypeRef#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getTypeRef()
 * @model
 * @generated
 */
public interface TypeRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel</em>' reference.
   * @see #setMetamodel(AbstractMetamodelDeclaration)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getTypeRef_Metamodel()
   * @model
   * @generated
   */
  AbstractMetamodelDeclaration getMetamodel();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.TypeRef#getMetamodel <em>Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel</em>' reference.
   * @see #getMetamodel()
   * @generated
   */
  void setMetamodel(AbstractMetamodelDeclaration value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EClassifier)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getTypeRef_Type()
   * @model
   * @generated
   */
  EClassifier getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.TypeRef#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EClassifier value);

} // TypeRef
