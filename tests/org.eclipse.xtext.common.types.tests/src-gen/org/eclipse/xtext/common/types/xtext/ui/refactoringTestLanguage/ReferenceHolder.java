/**
 */
package org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder#getDefaultReference <em>Default Reference</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.RefactoringTestLanguagePackage#getReferenceHolder()
 * @model
 * @generated
 */
public interface ReferenceHolder extends EObject
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
   * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.RefactoringTestLanguagePackage#getReferenceHolder_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Default Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Reference</em>' reference.
   * @see #setDefaultReference(JvmType)
   * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.RefactoringTestLanguagePackage#getReferenceHolder_DefaultReference()
   * @model
   * @generated
   */
  JvmType getDefaultReference();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder#getDefaultReference <em>Default Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Reference</em>' reference.
   * @see #getDefaultReference()
   * @generated
   */
  void setDefaultReference(JvmType value);

} // ReferenceHolder
