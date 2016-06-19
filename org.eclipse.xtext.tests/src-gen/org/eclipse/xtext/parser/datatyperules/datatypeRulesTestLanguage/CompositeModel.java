/**
 */
package org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.CompositeModel#getModel <em>Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage#getCompositeModel()
 * @model
 * @generated
 */
public interface CompositeModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Model</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' containment reference list.
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage#getCompositeModel_Model()
   * @model containment="true"
   * @generated
   */
  EList<Model> getModel();

} // CompositeModel
