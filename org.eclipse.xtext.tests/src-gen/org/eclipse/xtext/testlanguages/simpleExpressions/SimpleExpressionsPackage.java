/**
 */
package org.eclipse.xtext.testlanguages.simpleExpressions;

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
 * @see org.eclipse.xtext.testlanguages.simpleExpressions.SimpleExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface SimpleExpressionsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "simpleExpressions";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/test/simpleExpressions";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "simpleExpressions";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SimpleExpressionsPackage eINSTANCE = org.eclipse.xtext.testlanguages.simpleExpressions.impl.SimpleExpressionsPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.simpleExpressions.impl.SequenceImpl <em>Sequence</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.SequenceImpl
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.SimpleExpressionsPackageImpl#getSequence()
   * @generated
   */
  int SEQUENCE = 0;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE__EXPRESSIONS = 0;

  /**
   * The number of structural features of the '<em>Sequence</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.simpleExpressions.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.ExpressionImpl
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.SimpleExpressionsPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPRESSIONS = SEQUENCE__EXPRESSIONS;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = SEQUENCE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.simpleExpressions.impl.AtomImpl <em>Atom</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.AtomImpl
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.SimpleExpressionsPackageImpl#getAtom()
   * @generated
   */
  int ATOM = 2;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM__EXPRESSIONS = EXPRESSION__EXPRESSIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM__NAME = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Atom</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.simpleExpressions.impl.OpImpl <em>Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.OpImpl
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.SimpleExpressionsPackageImpl#getOp()
   * @generated
   */
  int OP = 3;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP__EXPRESSIONS = EXPRESSION__EXPRESSIONS;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP__VALUES = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.simpleExpressions.Sequence <em>Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sequence</em>'.
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.Sequence
   * @generated
   */
  EClass getSequence();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.testlanguages.simpleExpressions.Sequence#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.Sequence#getExpressions()
   * @see #getSequence()
   * @generated
   */
  EReference getSequence_Expressions();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.simpleExpressions.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.simpleExpressions.Atom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atom</em>'.
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.Atom
   * @generated
   */
  EClass getAtom();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.simpleExpressions.Atom#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.Atom#getName()
   * @see #getAtom()
   * @generated
   */
  EAttribute getAtom_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.simpleExpressions.Op <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op</em>'.
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.Op
   * @generated
   */
  EClass getOp();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.testlanguages.simpleExpressions.Op#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.Op#getValues()
   * @see #getOp()
   * @generated
   */
  EReference getOp_Values();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.simpleExpressions.Op#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.Op#getOperator()
   * @see #getOp()
   * @generated
   */
  EAttribute getOp_Operator();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SimpleExpressionsFactory getSimpleExpressionsFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.simpleExpressions.impl.SequenceImpl <em>Sequence</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.SequenceImpl
     * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.SimpleExpressionsPackageImpl#getSequence()
     * @generated
     */
    EClass SEQUENCE = eINSTANCE.getSequence();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENCE__EXPRESSIONS = eINSTANCE.getSequence_Expressions();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.simpleExpressions.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.ExpressionImpl
     * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.SimpleExpressionsPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.simpleExpressions.impl.AtomImpl <em>Atom</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.AtomImpl
     * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.SimpleExpressionsPackageImpl#getAtom()
     * @generated
     */
    EClass ATOM = eINSTANCE.getAtom();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOM__NAME = eINSTANCE.getAtom_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.simpleExpressions.impl.OpImpl <em>Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.OpImpl
     * @see org.eclipse.xtext.testlanguages.simpleExpressions.impl.SimpleExpressionsPackageImpl#getOp()
     * @generated
     */
    EClass OP = eINSTANCE.getOp();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP__VALUES = eINSTANCE.getOp_Values();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OP__OPERATOR = eINSTANCE.getOp_Operator();

  }

} //SimpleExpressionsPackage
