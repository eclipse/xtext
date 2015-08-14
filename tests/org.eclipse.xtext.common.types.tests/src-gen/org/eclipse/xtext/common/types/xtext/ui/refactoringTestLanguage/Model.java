/**
 */
package org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage;

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
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.Model#getReferenceHolder <em>Reference Holder</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.RefactoringTestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Reference Holder</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference Holder</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Holder</em>' containment reference list.
   * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.RefactoringTestLanguagePackage#getModel_ReferenceHolder()
   * @model containment="true"
   * @generated
   */
  EList<ReferenceHolder> getReferenceHolder();

} // Model
