/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiFactory
 * @model kind="package"
 * @generated
 */
public interface ReferenceGrammarUiPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "referenceGrammarUi";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/ReferenceGrammar";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "referenceGrammarUi";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ReferenceGrammarUiPackage eINSTANCE = org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielplatzImpl <em>Spielplatz</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielplatzImpl
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getSpielplatz()
   * @generated
   */
  int SPIELPLATZ = 0;

  /**
   * The feature id for the '<em><b>Groesse</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPIELPLATZ__GROESSE = 0;

  /**
   * The feature id for the '<em><b>Beschreibung</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPIELPLATZ__BESCHREIBUNG = 1;

  /**
   * The feature id for the '<em><b>Kinder</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPIELPLATZ__KINDER = 2;

  /**
   * The feature id for the '<em><b>Erzieher</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPIELPLATZ__ERZIEHER = 3;

  /**
   * The feature id for the '<em><b>Spielzeuge</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPIELPLATZ__SPIELZEUGE = 4;

  /**
   * The feature id for the '<em><b>Familie</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPIELPLATZ__FAMILIE = 5;

  /**
   * The number of structural features of the '<em>Spielplatz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPIELPLATZ_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.PersonImpl <em>Person</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.PersonImpl
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getPerson()
   * @generated
   */
  int PERSON = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERSON__NAME = 0;

  /**
   * The feature id for the '<em><b>Age</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERSON__AGE = 1;

  /**
   * The number of structural features of the '<em>Person</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERSON_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.KindImpl <em>Kind</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.KindImpl
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getKind()
   * @generated
   */
  int KIND = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KIND__NAME = PERSON__NAME;

  /**
   * The feature id for the '<em><b>Age</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KIND__AGE = PERSON__AGE;

  /**
   * The number of structural features of the '<em>Kind</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KIND_FEATURE_COUNT = PERSON_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ErwachsenerImpl <em>Erwachsener</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ErwachsenerImpl
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getErwachsener()
   * @generated
   */
  int ERWACHSENER = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERWACHSENER__NAME = PERSON__NAME;

  /**
   * The feature id for the '<em><b>Age</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERWACHSENER__AGE = PERSON__AGE;

  /**
   * The number of structural features of the '<em>Erwachsener</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERWACHSENER_FEATURE_COUNT = PERSON_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielzeugImpl <em>Spielzeug</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielzeugImpl
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getSpielzeug()
   * @generated
   */
  int SPIELZEUG = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPIELZEUG__NAME = 0;

  /**
   * The feature id for the '<em><b>Farbe</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPIELZEUG__FARBE = 1;

  /**
   * The number of structural features of the '<em>Spielzeug</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPIELZEUG_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.FarbeImpl <em>Farbe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.FarbeImpl
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getFarbe()
   * @generated
   */
  int FARBE = 5;

  /**
   * The feature id for the '<em><b>Wert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FARBE__WERT = 0;

  /**
   * The number of structural features of the '<em>Farbe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FARBE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.FamilieImpl <em>Familie</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.FamilieImpl
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getFamilie()
   * @generated
   */
  int FAMILIE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAMILIE__NAME = 0;

  /**
   * The feature id for the '<em><b>Mutter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAMILIE__MUTTER = 1;

  /**
   * The feature id for the '<em><b>Vater</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAMILIE__VATER = 2;

  /**
   * The feature id for the '<em><b>Kinder</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAMILIE__KINDER = 3;

  /**
   * The number of structural features of the '<em>Familie</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAMILIE_FEATURE_COUNT = 4;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz <em>Spielplatz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Spielplatz</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz
   * @generated
   */
  EClass getSpielplatz();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getGroesse <em>Groesse</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Groesse</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getGroesse()
   * @see #getSpielplatz()
   * @generated
   */
  EAttribute getSpielplatz_Groesse();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getBeschreibung <em>Beschreibung</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Beschreibung</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getBeschreibung()
   * @see #getSpielplatz()
   * @generated
   */
  EAttribute getSpielplatz_Beschreibung();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getKinder <em>Kinder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Kinder</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getKinder()
   * @see #getSpielplatz()
   * @generated
   */
  EReference getSpielplatz_Kinder();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getErzieher <em>Erzieher</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Erzieher</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getErzieher()
   * @see #getSpielplatz()
   * @generated
   */
  EReference getSpielplatz_Erzieher();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getSpielzeuge <em>Spielzeuge</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Spielzeuge</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getSpielzeuge()
   * @see #getSpielplatz()
   * @generated
   */
  EReference getSpielplatz_Spielzeuge();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getFamilie <em>Familie</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Familie</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz#getFamilie()
   * @see #getSpielplatz()
   * @generated
   */
  EReference getSpielplatz_Familie();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Person <em>Person</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Person</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Person
   * @generated
   */
  EClass getPerson();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Person#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Person#getName()
   * @see #getPerson()
   * @generated
   */
  EAttribute getPerson_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Person#getAge <em>Age</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Age</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Person#getAge()
   * @see #getPerson()
   * @generated
   */
  EAttribute getPerson_Age();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Kind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Kind</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Kind
   * @generated
   */
  EClass getKind();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Erwachsener <em>Erwachsener</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Erwachsener</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Erwachsener
   * @generated
   */
  EClass getErwachsener();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielzeug <em>Spielzeug</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Spielzeug</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielzeug
   * @generated
   */
  EClass getSpielzeug();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielzeug#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielzeug#getName()
   * @see #getSpielzeug()
   * @generated
   */
  EAttribute getSpielzeug_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielzeug#getFarbe <em>Farbe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Farbe</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielzeug#getFarbe()
   * @see #getSpielzeug()
   * @generated
   */
  EReference getSpielzeug_Farbe();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Farbe <em>Farbe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Farbe</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Farbe
   * @generated
   */
  EClass getFarbe();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Farbe#getWert <em>Wert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Wert</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Farbe#getWert()
   * @see #getFarbe()
   * @generated
   */
  EAttribute getFarbe_Wert();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie <em>Familie</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Familie</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie
   * @generated
   */
  EClass getFamilie();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie#getName()
   * @see #getFamilie()
   * @generated
   */
  EAttribute getFamilie_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie#getMutter <em>Mutter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Mutter</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie#getMutter()
   * @see #getFamilie()
   * @generated
   */
  EReference getFamilie_Mutter();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie#getVater <em>Vater</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Vater</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie#getVater()
   * @see #getFamilie()
   * @generated
   */
  EReference getFamilie_Vater();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie#getKinder <em>Kinder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Kinder</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie#getKinder()
   * @see #getFamilie()
   * @generated
   */
  EReference getFamilie_Kinder();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ReferenceGrammarUiFactory getReferenceGrammarUiFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielplatzImpl <em>Spielplatz</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielplatzImpl
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getSpielplatz()
     * @generated
     */
    EClass SPIELPLATZ = eINSTANCE.getSpielplatz();

    /**
     * The meta object literal for the '<em><b>Groesse</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPIELPLATZ__GROESSE = eINSTANCE.getSpielplatz_Groesse();

    /**
     * The meta object literal for the '<em><b>Beschreibung</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPIELPLATZ__BESCHREIBUNG = eINSTANCE.getSpielplatz_Beschreibung();

    /**
     * The meta object literal for the '<em><b>Kinder</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPIELPLATZ__KINDER = eINSTANCE.getSpielplatz_Kinder();

    /**
     * The meta object literal for the '<em><b>Erzieher</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPIELPLATZ__ERZIEHER = eINSTANCE.getSpielplatz_Erzieher();

    /**
     * The meta object literal for the '<em><b>Spielzeuge</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPIELPLATZ__SPIELZEUGE = eINSTANCE.getSpielplatz_Spielzeuge();

    /**
     * The meta object literal for the '<em><b>Familie</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPIELPLATZ__FAMILIE = eINSTANCE.getSpielplatz_Familie();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.PersonImpl <em>Person</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.PersonImpl
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getPerson()
     * @generated
     */
    EClass PERSON = eINSTANCE.getPerson();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

    /**
     * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PERSON__AGE = eINSTANCE.getPerson_Age();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.KindImpl <em>Kind</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.KindImpl
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getKind()
     * @generated
     */
    EClass KIND = eINSTANCE.getKind();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ErwachsenerImpl <em>Erwachsener</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ErwachsenerImpl
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getErwachsener()
     * @generated
     */
    EClass ERWACHSENER = eINSTANCE.getErwachsener();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielzeugImpl <em>Spielzeug</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielzeugImpl
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getSpielzeug()
     * @generated
     */
    EClass SPIELZEUG = eINSTANCE.getSpielzeug();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPIELZEUG__NAME = eINSTANCE.getSpielzeug_Name();

    /**
     * The meta object literal for the '<em><b>Farbe</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPIELZEUG__FARBE = eINSTANCE.getSpielzeug_Farbe();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.FarbeImpl <em>Farbe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.FarbeImpl
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getFarbe()
     * @generated
     */
    EClass FARBE = eINSTANCE.getFarbe();

    /**
     * The meta object literal for the '<em><b>Wert</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FARBE__WERT = eINSTANCE.getFarbe_Wert();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.FamilieImpl <em>Familie</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.FamilieImpl
     * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiPackageImpl#getFamilie()
     * @generated
     */
    EClass FAMILIE = eINSTANCE.getFamilie();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FAMILIE__NAME = eINSTANCE.getFamilie_Name();

    /**
     * The meta object literal for the '<em><b>Mutter</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAMILIE__MUTTER = eINSTANCE.getFamilie_Mutter();

    /**
     * The meta object literal for the '<em><b>Vater</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAMILIE__VATER = eINSTANCE.getFamilie_Vater();

    /**
     * The meta object literal for the '<em><b>Kinder</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAMILIE__KINDER = eINSTANCE.getFamilie_Kinder();

  }

} //ReferenceGrammarUiPackage
