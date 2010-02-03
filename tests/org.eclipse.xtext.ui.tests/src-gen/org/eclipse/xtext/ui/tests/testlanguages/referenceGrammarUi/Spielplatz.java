/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spielplatz</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getGroesse <em>Groesse</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getBeschreibung <em>Beschreibung</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getKinder <em>Kinder</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getErzieher <em>Erzieher</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getSpielzeuge <em>Spielzeuge</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getFamilie <em>Familie</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiPackage#getSpielplatz()
 * @model
 * @generated
 */
public interface Spielplatz extends EObject
{
  /**
   * Returns the value of the '<em><b>Groesse</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Groesse</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Groesse</em>' attribute.
   * @see #setGroesse(int)
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiPackage#getSpielplatz_Groesse()
   * @model
   * @generated
   */
  int getGroesse();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getGroesse <em>Groesse</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Groesse</em>' attribute.
   * @see #getGroesse()
   * @generated
   */
  void setGroesse(int value);

  /**
   * Returns the value of the '<em><b>Beschreibung</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Beschreibung</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Beschreibung</em>' attribute.
   * @see #setBeschreibung(String)
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiPackage#getSpielplatz_Beschreibung()
   * @model
   * @generated
   */
  String getBeschreibung();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getBeschreibung <em>Beschreibung</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Beschreibung</em>' attribute.
   * @see #getBeschreibung()
   * @generated
   */
  void setBeschreibung(String value);

  /**
   * Returns the value of the '<em><b>Kinder</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Kind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kinder</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kinder</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiPackage#getSpielplatz_Kinder()
   * @model containment="true"
   * @generated
   */
  EList<Kind> getKinder();

  /**
   * Returns the value of the '<em><b>Erzieher</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Erwachsener}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Erzieher</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Erzieher</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiPackage#getSpielplatz_Erzieher()
   * @model containment="true"
   * @generated
   */
  EList<Erwachsener> getErzieher();

  /**
   * Returns the value of the '<em><b>Spielzeuge</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielzeug}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Spielzeuge</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Spielzeuge</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiPackage#getSpielplatz_Spielzeuge()
   * @model containment="true"
   * @generated
   */
  EList<Spielzeug> getSpielzeuge();

  /**
   * Returns the value of the '<em><b>Familie</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Familie</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Familie</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiPackage#getSpielplatz_Familie()
   * @model containment="true"
   * @generated
   */
  EList<Familie> getFamilie();

} // Spielplatz
