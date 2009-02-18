/**
 * <copyright>
 * </copyright>
 *
 * $Id: Main.java,v 1.1 2009/02/18 19:45:21 sefftinge Exp $
 */
package org.eclipse.xtext.crossrefs.langATestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Main</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.crossrefs.langATestLanguage.Main#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.crossrefs.langATestLanguage.Main#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.crossrefs.langATestLanguage.LangATestLanguagePackage#getMain()
 * @model
 * @generated
 */
public interface Main extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.crossrefs.langATestLanguage.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.xtext.crossrefs.langATestLanguage.LangATestLanguagePackage#getMain_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Types</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.crossrefs.langATestLanguage.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' containment reference list.
   * @see org.eclipse.xtext.crossrefs.langATestLanguage.LangATestLanguagePackage#getMain_Types()
   * @model containment="true"
   * @generated
   */
  EList<Type> getTypes();

} // Main
