/**
 */
package org.eclipse.xtext.linking.importedURI;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.importedURI.Import#getImportURI <em>Import URI</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.importedURI.ImportedURIPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends EObject
{
  /**
   * Returns the value of the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import URI</em>' attribute.
   * @see #setImportURI(String)
   * @see org.eclipse.xtext.linking.importedURI.ImportedURIPackage#getImport_ImportURI()
   * @model
   * @generated
   */
  String getImportURI();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.importedURI.Import#getImportURI <em>Import URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import URI</em>' attribute.
   * @see #getImportURI()
   * @generated
   */
  void setImportURI(String value);

} // Import
