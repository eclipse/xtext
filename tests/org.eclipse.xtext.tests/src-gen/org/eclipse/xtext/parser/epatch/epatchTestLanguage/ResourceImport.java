/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ResourceImport#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getResourceImport()
 * @model
 * @generated
 */
public interface ResourceImport extends ModelImport
{
  /**
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uri</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uri</em>' attribute.
   * @see #setUri(String)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getResourceImport_Uri()
   * @model
   * @generated
   */
  String getUri();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ResourceImport#getUri <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uri</em>' attribute.
   * @see #getUri()
   * @generated
   */
  void setUri(String value);

} // ResourceImport
