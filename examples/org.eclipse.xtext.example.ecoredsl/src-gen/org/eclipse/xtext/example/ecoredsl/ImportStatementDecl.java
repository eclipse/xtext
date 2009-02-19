/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.ecoredsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Statement Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.ecoredsl.ImportStatementDecl#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.ecoredsl.ImportStatementDecl#getImportURI <em>Import URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.ecoredsl.EcoredslPackage#getImportStatementDecl()
 * @model
 * @generated
 */
public interface ImportStatementDecl extends EObject
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
   * @see org.eclipse.xtext.example.ecoredsl.EcoredslPackage#getImportStatementDecl_Alias()
   * @model
   * @generated
   */
  String getAlias();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.ecoredsl.ImportStatementDecl#getAlias <em>Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' attribute.
   * @see #getAlias()
   * @generated
   */
  void setAlias(String value);

  /**
   * Returns the value of the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import URI</em>' attribute.
   * @see #setImportURI(String)
   * @see org.eclipse.xtext.example.ecoredsl.EcoredslPackage#getImportStatementDecl_ImportURI()
   * @model
   * @generated
   */
  String getImportURI();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.ecoredsl.ImportStatementDecl#getImportURI <em>Import URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import URI</em>' attribute.
   * @see #getImportURI()
   * @generated
   */
  void setImportURI(String value);

} // ImportStatementDecl
