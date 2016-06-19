/**
 */
package org.eclipse.xtext.parser.antlr.bug289524ExTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.Model#getRefs <em>Refs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.Bug289524ExTestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Refs</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.antlr.bug289524ExTest.ModelElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Refs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refs</em>' containment reference list.
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.Bug289524ExTestPackage#getModel_Refs()
   * @model containment="true"
   * @generated
   */
  EList<ModelElement> getRefs();

} // Model
