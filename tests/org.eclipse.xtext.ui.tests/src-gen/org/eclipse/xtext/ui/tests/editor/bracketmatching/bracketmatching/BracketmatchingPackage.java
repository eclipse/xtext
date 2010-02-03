/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching;

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
 * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.BracketmatchingFactory
 * @model kind="package"
 * @generated
 */
public interface BracketmatchingPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bracketmatching";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://xtext.org/ui/integartion/tests/bracketmatching";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bracketmatching";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BracketmatchingPackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.BracketmatchingPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.FileImpl <em>File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.FileImpl
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.BracketmatchingPackageImpl#getFile()
   * @generated
   */
  int FILE = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.ExpressionImpl
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.BracketmatchingPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.SExpressionImpl <em>SExpression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.SExpressionImpl
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.BracketmatchingPackageImpl#getSExpression()
   * @generated
   */
  int SEXPRESSION = 2;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEXPRESSION__ELEMENT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SExpression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.AtomImpl <em>Atom</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.AtomImpl
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.BracketmatchingPackageImpl#getAtom()
   * @generated
   */
  int ATOM = 3;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Atom</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.File <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>File</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.File
   * @generated
   */
  EClass getFile();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.File#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.File#getExpression()
   * @see #getFile()
   * @generated
   */
  EReference getFile_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.SExpression <em>SExpression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SExpression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.SExpression
   * @generated
   */
  EClass getSExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.SExpression#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Element</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.SExpression#getElement()
   * @see #getSExpression()
   * @generated
   */
  EReference getSExpression_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.Atom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atom</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.Atom
   * @generated
   */
  EClass getAtom();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.Atom#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.Atom#getValue()
   * @see #getAtom()
   * @generated
   */
  EAttribute getAtom_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  BracketmatchingFactory getBracketmatchingFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.FileImpl <em>File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.FileImpl
     * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.BracketmatchingPackageImpl#getFile()
     * @generated
     */
    EClass FILE = eINSTANCE.getFile();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILE__EXPRESSION = eINSTANCE.getFile_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.ExpressionImpl
     * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.BracketmatchingPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.SExpressionImpl <em>SExpression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.SExpressionImpl
     * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.BracketmatchingPackageImpl#getSExpression()
     * @generated
     */
    EClass SEXPRESSION = eINSTANCE.getSExpression();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEXPRESSION__ELEMENT = eINSTANCE.getSExpression_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.AtomImpl <em>Atom</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.AtomImpl
     * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl.BracketmatchingPackageImpl#getAtom()
     * @generated
     */
    EClass ATOM = eINSTANCE.getAtom();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOM__VALUE = eINSTANCE.getAtom_Value();

  }

} //BracketmatchingPackage
