/**
 */
package org.eclipse.xtext.ui.codetemplates.templates;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.AbstractRule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Codetemplate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getKeywordContext <em>Keyword Context</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getCodetemplate()
 * @model
 * @generated
 */
public interface Codetemplate extends EObject
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
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getCodetemplate_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getCodetemplate_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getCodetemplate_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context</em>' reference.
   * @see #setContext(AbstractRule)
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getCodetemplate_Context()
   * @model
   * @generated
   */
  AbstractRule getContext();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getContext <em>Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context</em>' reference.
   * @see #getContext()
   * @generated
   */
  void setContext(AbstractRule value);

  /**
   * Returns the value of the '<em><b>Keyword Context</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Keyword Context</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Keyword Context</em>' attribute.
   * @see #setKeywordContext(String)
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getCodetemplate_KeywordContext()
   * @model
   * @generated
   */
  String getKeywordContext();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getKeywordContext <em>Keyword Context</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Keyword Context</em>' attribute.
   * @see #getKeywordContext()
   * @generated
   */
  void setKeywordContext(String value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(TemplateBody)
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getCodetemplate_Body()
   * @model containment="true"
   * @generated
   */
  TemplateBody getBody();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(TemplateBody value);

} // Codetemplate
