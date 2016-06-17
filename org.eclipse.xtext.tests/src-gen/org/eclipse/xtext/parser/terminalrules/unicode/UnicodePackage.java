/**
 */
package org.eclipse.xtext.parser.terminalrules.unicode;

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
 * @see org.eclipse.xtext.parser.terminalrules.unicode.UnicodeFactory
 * @model kind="package"
 * @generated
 */
public interface UnicodePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "unicode";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.xtext.org/tests/parser/terminalrules/Unicode";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "unicode";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UnicodePackage eINSTANCE = org.eclipse.xtext.parser.terminalrules.unicode.impl.UnicodePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.unicode.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.ModelImpl
   * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.UnicodePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Strings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__STRINGS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.unicode.impl.AbstractStringImpl <em>Abstract String</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.AbstractStringImpl
   * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.UnicodePackageImpl#getAbstractString()
   * @generated
   */
  int ABSTRACT_STRING = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_STRING__NAME = 0;

  /**
   * The number of structural features of the '<em>Abstract String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_STRING_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.unicode.impl.GStringImpl <em>GString</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.GStringImpl
   * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.UnicodePackageImpl#getGString()
   * @generated
   */
  int GSTRING = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSTRING__NAME = ABSTRACT_STRING__NAME;

  /**
   * The number of structural features of the '<em>GString</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSTRING_FEATURE_COUNT = ABSTRACT_STRING_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.unicode.impl.QuotedStringImpl <em>Quoted String</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.QuotedStringImpl
   * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.UnicodePackageImpl#getQuotedString()
   * @generated
   */
  int QUOTED_STRING = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUOTED_STRING__NAME = ABSTRACT_STRING__NAME;

  /**
   * The number of structural features of the '<em>Quoted String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUOTED_STRING_FEATURE_COUNT = ABSTRACT_STRING_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.unicode.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.unicode.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.terminalrules.unicode.Model#getStrings <em>Strings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Strings</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.unicode.Model#getStrings()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Strings();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.unicode.AbstractString <em>Abstract String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract String</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.unicode.AbstractString
   * @generated
   */
  EClass getAbstractString();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.terminalrules.unicode.AbstractString#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.unicode.AbstractString#getName()
   * @see #getAbstractString()
   * @generated
   */
  EAttribute getAbstractString_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.unicode.GString <em>GString</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>GString</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.unicode.GString
   * @generated
   */
  EClass getGString();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.unicode.QuotedString <em>Quoted String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quoted String</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.unicode.QuotedString
   * @generated
   */
  EClass getQuotedString();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UnicodeFactory getUnicodeFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.unicode.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.ModelImpl
     * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.UnicodePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Strings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__STRINGS = eINSTANCE.getModel_Strings();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.unicode.impl.AbstractStringImpl <em>Abstract String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.AbstractStringImpl
     * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.UnicodePackageImpl#getAbstractString()
     * @generated
     */
    EClass ABSTRACT_STRING = eINSTANCE.getAbstractString();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_STRING__NAME = eINSTANCE.getAbstractString_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.unicode.impl.GStringImpl <em>GString</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.GStringImpl
     * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.UnicodePackageImpl#getGString()
     * @generated
     */
    EClass GSTRING = eINSTANCE.getGString();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.unicode.impl.QuotedStringImpl <em>Quoted String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.QuotedStringImpl
     * @see org.eclipse.xtext.parser.terminalrules.unicode.impl.UnicodePackageImpl#getQuotedString()
     * @generated
     */
    EClass QUOTED_STRING = eINSTANCE.getQuotedString();

  }

} //UnicodePackage
