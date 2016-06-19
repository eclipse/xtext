/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EPackage Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPackageImport#getNsURI <em>Ns URI</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getEPackageImport()
 * @model
 * @generated
 */
public interface EPackageImport extends ModelImport
{
  /**
   * Returns the value of the '<em><b>Ns URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ns URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ns URI</em>' attribute.
   * @see #setNsURI(String)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getEPackageImport_NsURI()
   * @model
   * @generated
   */
  String getNsURI();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPackageImport#getNsURI <em>Ns URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ns URI</em>' attribute.
   * @see #getNsURI()
   * @generated
   */
  void setNsURI(String value);

} // EPackageImport
