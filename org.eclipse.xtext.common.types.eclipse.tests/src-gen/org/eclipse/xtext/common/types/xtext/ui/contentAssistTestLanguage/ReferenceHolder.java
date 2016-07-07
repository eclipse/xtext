/**
 */
package org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage;

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
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder#getDefaultReference <em>Default Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder#getCustomizedReference <em>Customized Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder#getSubtypeReference <em>Subtype Reference</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getReferenceHolder()
 * @model
 * @generated
 */
public interface ReferenceHolder extends EObject
{
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
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getReferenceHolder_DefaultReference()
   * @model
   * @generated
   */
  JvmType getDefaultReference();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder#getDefaultReference <em>Default Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Reference</em>' reference.
   * @see #getDefaultReference()
   * @generated
   */
  void setDefaultReference(JvmType value);

  /**
   * Returns the value of the '<em><b>Customized Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Customized Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Customized Reference</em>' reference.
   * @see #setCustomizedReference(JvmType)
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getReferenceHolder_CustomizedReference()
   * @model
   * @generated
   */
  JvmType getCustomizedReference();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder#getCustomizedReference <em>Customized Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Customized Reference</em>' reference.
   * @see #getCustomizedReference()
   * @generated
   */
  void setCustomizedReference(JvmType value);

  /**
   * Returns the value of the '<em><b>Subtype Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subtype Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subtype Reference</em>' reference.
   * @see #setSubtypeReference(JvmType)
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getReferenceHolder_SubtypeReference()
   * @model
   * @generated
   */
  JvmType getSubtypeReference();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder#getSubtypeReference <em>Subtype Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subtype Reference</em>' reference.
   * @see #getSubtypeReference()
   * @generated
   */
  void setSubtypeReference(JvmType value);

} // ReferenceHolder
