/**
 */
package org.eclipse.xtext.example.tutorial.tutorial;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Model File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.tutorial.tutorial.DomainModelFile#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.tutorial.tutorial.DomainModelFile#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.tutorial.tutorial.DomainModelFile#getEntities <em>Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.tutorial.tutorial.TutorialPackage#getDomainModelFile()
 * @model
 * @generated
 */
public interface DomainModelFile extends EObject
{
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
   * @see org.eclipse.xtext.example.tutorial.tutorial.TutorialPackage#getDomainModelFile_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.tutorial.tutorial.DomainModelFile#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.tutorial.tutorial.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.xtext.example.tutorial.tutorial.TutorialPackage#getDomainModelFile_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.tutorial.tutorial.Entity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entities</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entities</em>' containment reference list.
   * @see org.eclipse.xtext.example.tutorial.tutorial.TutorialPackage#getDomainModelFile_Entities()
   * @model containment="true"
   * @generated
   */
  EList<Entity> getEntities();

} // DomainModelFile
