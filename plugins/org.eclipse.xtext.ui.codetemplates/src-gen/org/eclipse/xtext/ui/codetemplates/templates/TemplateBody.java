/**
 */
package org.eclipse.xtext.ui.codetemplates.templates;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.TemplateBody#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getTemplateBody()
 * @model
 * @generated
 */
public interface TemplateBody extends EObject
{
  /**
   * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.codetemplates.templates.TemplatePart}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parts</em>' containment reference list.
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getTemplateBody_Parts()
   * @model containment="true"
   * @generated
   */
  EList<TemplatePart> getParts();

} // TemplateBody
