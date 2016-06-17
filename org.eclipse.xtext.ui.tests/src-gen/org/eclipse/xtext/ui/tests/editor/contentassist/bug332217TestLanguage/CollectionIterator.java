/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Iterator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionIterator#getCollection <em>Collection</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage#getCollectionIterator()
 * @model
 * @generated
 */
public interface CollectionIterator extends PropertyPathPart
{
  /**
   * Returns the value of the '<em><b>Collection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Collection</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Collection</em>' containment reference.
   * @see #setCollection(CollectionExpression)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage#getCollectionIterator_Collection()
   * @model containment="true"
   * @generated
   */
  CollectionExpression getCollection();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionIterator#getCollection <em>Collection</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Collection</em>' containment reference.
   * @see #getCollection()
   * @generated
   */
  void setCollection(CollectionExpression value);

} // CollectionIterator
