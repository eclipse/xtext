/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#isMany <em>Many</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#getLongDescription <em>Long Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends Feature
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage#getReference_Type()
   * @model
   * @generated
   */
  org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object value);

  /**
   * Returns the value of the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Many</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Many</em>' attribute.
   * @see #setMany(boolean)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage#getReference_Many()
   * @model
   * @generated
   */
  boolean isMany();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#isMany <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Many</em>' attribute.
   * @see #isMany()
   * @generated
   */
  void setMany(boolean value);

  /**
   * Returns the value of the '<em><b>Short Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Short Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Short Description</em>' attribute.
   * @see #setShortDescription(String)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage#getReference_ShortDescription()
   * @model
   * @generated
   */
  String getShortDescription();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#getShortDescription <em>Short Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Short Description</em>' attribute.
   * @see #getShortDescription()
   * @generated
   */
  void setShortDescription(String value);

  /**
   * Returns the value of the '<em><b>Long Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Long Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Long Description</em>' attribute.
   * @see #setLongDescription(String)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage#getReference_LongDescription()
   * @model
   * @generated
   */
  String getLongDescription();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#getLongDescription <em>Long Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Long Description</em>' attribute.
   * @see #getLongDescription()
   * @generated
   */
  void setLongDescription(String value);

} // Reference
