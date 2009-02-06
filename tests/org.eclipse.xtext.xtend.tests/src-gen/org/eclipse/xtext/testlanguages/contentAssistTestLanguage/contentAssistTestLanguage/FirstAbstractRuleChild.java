/**
 * <copyright>
 * </copyright>
 *
 * $Id: FirstAbstractRuleChild.java,v 1.1 2009/02/06 09:46:50 jkohnlein Exp $
 */
package org.eclipse.xtext.testlanguages.contentAssistTestLanguage.contentAssistTestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>First Abstract Rule Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.contentAssistTestLanguage.contentAssistTestLanguage.FirstAbstractRuleChild#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.testlanguages.contentAssistTestLanguage.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getFirstAbstractRuleChild()
 * @model
 * @generated
 */
public interface FirstAbstractRuleChild extends AbstractRule
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.contentAssistTestLanguage.contentAssistTestLanguage.AbstractRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.eclipse.xtext.testlanguages.contentAssistTestLanguage.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getFirstAbstractRuleChild_Elements()
   * @model containment="true"
   * @generated
   */
  EList<AbstractRule> getElements();

} // FirstAbstractRuleChild
