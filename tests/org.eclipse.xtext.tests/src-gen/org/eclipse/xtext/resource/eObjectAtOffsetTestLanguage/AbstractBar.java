/**
 */
package org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Bar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.AbstractBar#getFoo <em>Foo</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage#getAbstractBar()
 * @model
 * @generated
 */
public interface AbstractBar extends EObject
{
  /**
   * Returns the value of the '<em><b>Foo</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Foo</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Foo</em>' reference list.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage#getAbstractBar_Foo()
   * @model
   * @generated
   */
  EList<Foo> getFoo();

} // AbstractBar
