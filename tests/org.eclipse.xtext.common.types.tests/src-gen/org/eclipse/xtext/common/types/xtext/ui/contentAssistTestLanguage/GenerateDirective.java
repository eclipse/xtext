/**
 */
package org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generate Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.GenerateDirective#getTypeName <em>Type Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getGenerateDirective()
 * @model
 * @generated
 */
public interface GenerateDirective extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' attribute.
   * @see #setTypeName(String)
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getGenerateDirective_TypeName()
   * @model
   * @generated
   */
  String getTypeName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.GenerateDirective#getTypeName <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' attribute.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(String value);

} // GenerateDirective
