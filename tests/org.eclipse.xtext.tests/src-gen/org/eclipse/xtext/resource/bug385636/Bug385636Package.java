/**
 */
package org.eclipse.xtext.resource.bug385636;

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
 * @see org.eclipse.xtext.resource.bug385636.Bug385636Factory
 * @model kind="package"
 * @generated
 */
public interface Bug385636Package extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug385636";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.xtext.org/Bug385636";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug385636";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug385636Package eINSTANCE = org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.ProgramImpl <em>Program</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.ProgramImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getProgram()
   * @generated
   */
  int PROGRAM = 0;

  /**
   * The feature id for the '<em><b>Define</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM__DEFINE = 0;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM__STATEMENTS = 1;

  /**
   * The number of structural features of the '<em>Program</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.DefineVariablesImpl <em>Define Variables</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.DefineVariablesImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getDefineVariables()
   * @generated
   */
  int DEFINE_VARIABLES = 1;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_VARIABLES__VARIABLES = 0;

  /**
   * The number of structural features of the '<em>Define Variables</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_VARIABLES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.DefineVariableImpl <em>Define Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.DefineVariableImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getDefineVariable()
   * @generated
   */
  int DEFINE_VARIABLE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_VARIABLE__NAME = 0;

  /**
   * The number of structural features of the '<em>Define Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_VARIABLE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.NVariableAccessImpl <em>NVariable Access</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.NVariableAccessImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getNVariableAccess()
   * @generated
   */
  int NVARIABLE_ACCESS = 3;

  /**
   * The feature id for the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NVARIABLE_ACCESS__VARIABLE = 0;

  /**
   * The number of structural features of the '<em>NVariable Access</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NVARIABLE_ACCESS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.ExpressionImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 4;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_VariableNameImpl <em>Expression Variable Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.Expression_VariableNameImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_VariableName()
   * @generated
   */
  int EXPRESSION_VARIABLE_NAME = 5;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_VARIABLE_NAME__VARIABLE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression Variable Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_VARIABLE_NAME_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_Larger_EqualImpl <em>Expression Larger Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.Expression_Larger_EqualImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Larger_Equal()
   * @generated
   */
  int EXPRESSION_LARGER_EQUAL = 6;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LARGER_EQUAL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LARGER_EQUAL__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expression Larger Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LARGER_EQUAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_SmallerImpl <em>Expression Smaller</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.Expression_SmallerImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Smaller()
   * @generated
   */
  int EXPRESSION_SMALLER = 7;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_SMALLER__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_SMALLER__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expression Smaller</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_SMALLER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_Smaller_EqualImpl <em>Expression Smaller Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.Expression_Smaller_EqualImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Smaller_Equal()
   * @generated
   */
  int EXPRESSION_SMALLER_EQUAL = 8;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_SMALLER_EQUAL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_SMALLER_EQUAL__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expression Smaller Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_SMALLER_EQUAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_EqualImpl <em>Expression Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.Expression_EqualImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Equal()
   * @generated
   */
  int EXPRESSION_EQUAL = 9;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_EQUAL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_EQUAL__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expression Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_EQUAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_Not_EqualImpl <em>Expression Not Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.Expression_Not_EqualImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Not_Equal()
   * @generated
   */
  int EXPRESSION_NOT_EQUAL = 10;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_NOT_EQUAL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_NOT_EQUAL__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expression Not Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_NOT_EQUAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_Not_LessImpl <em>Expression Not Less</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.Expression_Not_LessImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Not_Less()
   * @generated
   */
  int EXPRESSION_NOT_LESS = 11;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_NOT_LESS__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_NOT_LESS__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expression Not Less</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_NOT_LESS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_Not_GreaterImpl <em>Expression Not Greater</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.bug385636.impl.Expression_Not_GreaterImpl
   * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Not_Greater()
   * @generated
   */
  int EXPRESSION_NOT_GREATER = 12;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_NOT_GREATER__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_NOT_GREATER__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expression Not Greater</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_NOT_GREATER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.Program <em>Program</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Program</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Program
   * @generated
   */
  EClass getProgram();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Program#getDefine <em>Define</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Define</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Program#getDefine()
   * @see #getProgram()
   * @generated
   */
  EReference getProgram_Define();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.resource.bug385636.Program#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Program#getStatements()
   * @see #getProgram()
   * @generated
   */
  EReference getProgram_Statements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.DefineVariables <em>Define Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define Variables</em>'.
   * @see org.eclipse.xtext.resource.bug385636.DefineVariables
   * @generated
   */
  EClass getDefineVariables();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.resource.bug385636.DefineVariables#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see org.eclipse.xtext.resource.bug385636.DefineVariables#getVariables()
   * @see #getDefineVariables()
   * @generated
   */
  EReference getDefineVariables_Variables();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.DefineVariable <em>Define Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define Variable</em>'.
   * @see org.eclipse.xtext.resource.bug385636.DefineVariable
   * @generated
   */
  EClass getDefineVariable();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.resource.bug385636.DefineVariable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.resource.bug385636.DefineVariable#getName()
   * @see #getDefineVariable()
   * @generated
   */
  EAttribute getDefineVariable_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.NVariableAccess <em>NVariable Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>NVariable Access</em>'.
   * @see org.eclipse.xtext.resource.bug385636.NVariableAccess
   * @generated
   */
  EClass getNVariableAccess();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.resource.bug385636.NVariableAccess#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Variable</em>'.
   * @see org.eclipse.xtext.resource.bug385636.NVariableAccess#getVariable()
   * @see #getNVariableAccess()
   * @generated
   */
  EReference getNVariableAccess_Variable();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.Expression_VariableName <em>Expression Variable Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Variable Name</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_VariableName
   * @generated
   */
  EClass getExpression_VariableName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_VariableName#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_VariableName#getVariable()
   * @see #getExpression_VariableName()
   * @generated
   */
  EReference getExpression_VariableName_Variable();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.Expression_Larger_Equal <em>Expression Larger Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Larger Equal</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Larger_Equal
   * @generated
   */
  EClass getExpression_Larger_Equal();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Larger_Equal#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Larger_Equal#getLeft()
   * @see #getExpression_Larger_Equal()
   * @generated
   */
  EReference getExpression_Larger_Equal_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Larger_Equal#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Larger_Equal#getRight()
   * @see #getExpression_Larger_Equal()
   * @generated
   */
  EReference getExpression_Larger_Equal_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.Expression_Smaller <em>Expression Smaller</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Smaller</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Smaller
   * @generated
   */
  EClass getExpression_Smaller();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Smaller#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Smaller#getLeft()
   * @see #getExpression_Smaller()
   * @generated
   */
  EReference getExpression_Smaller_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Smaller#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Smaller#getRight()
   * @see #getExpression_Smaller()
   * @generated
   */
  EReference getExpression_Smaller_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.Expression_Smaller_Equal <em>Expression Smaller Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Smaller Equal</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Smaller_Equal
   * @generated
   */
  EClass getExpression_Smaller_Equal();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Smaller_Equal#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Smaller_Equal#getLeft()
   * @see #getExpression_Smaller_Equal()
   * @generated
   */
  EReference getExpression_Smaller_Equal_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Smaller_Equal#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Smaller_Equal#getRight()
   * @see #getExpression_Smaller_Equal()
   * @generated
   */
  EReference getExpression_Smaller_Equal_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.Expression_Equal <em>Expression Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Equal</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Equal
   * @generated
   */
  EClass getExpression_Equal();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Equal#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Equal#getLeft()
   * @see #getExpression_Equal()
   * @generated
   */
  EReference getExpression_Equal_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Equal#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Equal#getRight()
   * @see #getExpression_Equal()
   * @generated
   */
  EReference getExpression_Equal_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.Expression_Not_Equal <em>Expression Not Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Not Equal</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Not_Equal
   * @generated
   */
  EClass getExpression_Not_Equal();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Not_Equal#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Not_Equal#getLeft()
   * @see #getExpression_Not_Equal()
   * @generated
   */
  EReference getExpression_Not_Equal_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Not_Equal#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Not_Equal#getRight()
   * @see #getExpression_Not_Equal()
   * @generated
   */
  EReference getExpression_Not_Equal_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.Expression_Not_Less <em>Expression Not Less</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Not Less</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Not_Less
   * @generated
   */
  EClass getExpression_Not_Less();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Not_Less#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Not_Less#getLeft()
   * @see #getExpression_Not_Less()
   * @generated
   */
  EReference getExpression_Not_Less_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Not_Less#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Not_Less#getRight()
   * @see #getExpression_Not_Less()
   * @generated
   */
  EReference getExpression_Not_Less_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.bug385636.Expression_Not_Greater <em>Expression Not Greater</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Not Greater</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Not_Greater
   * @generated
   */
  EClass getExpression_Not_Greater();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Not_Greater#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Not_Greater#getLeft()
   * @see #getExpression_Not_Greater()
   * @generated
   */
  EReference getExpression_Not_Greater_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.bug385636.Expression_Not_Greater#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Not_Greater#getRight()
   * @see #getExpression_Not_Greater()
   * @generated
   */
  EReference getExpression_Not_Greater_Right();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug385636Factory getBug385636Factory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.ProgramImpl <em>Program</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.ProgramImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getProgram()
     * @generated
     */
    EClass PROGRAM = eINSTANCE.getProgram();

    /**
     * The meta object literal for the '<em><b>Define</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROGRAM__DEFINE = eINSTANCE.getProgram_Define();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROGRAM__STATEMENTS = eINSTANCE.getProgram_Statements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.DefineVariablesImpl <em>Define Variables</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.DefineVariablesImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getDefineVariables()
     * @generated
     */
    EClass DEFINE_VARIABLES = eINSTANCE.getDefineVariables();

    /**
     * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINE_VARIABLES__VARIABLES = eINSTANCE.getDefineVariables_Variables();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.DefineVariableImpl <em>Define Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.DefineVariableImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getDefineVariable()
     * @generated
     */
    EClass DEFINE_VARIABLE = eINSTANCE.getDefineVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINE_VARIABLE__NAME = eINSTANCE.getDefineVariable_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.NVariableAccessImpl <em>NVariable Access</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.NVariableAccessImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getNVariableAccess()
     * @generated
     */
    EClass NVARIABLE_ACCESS = eINSTANCE.getNVariableAccess();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NVARIABLE_ACCESS__VARIABLE = eINSTANCE.getNVariableAccess_Variable();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.ExpressionImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_VariableNameImpl <em>Expression Variable Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.Expression_VariableNameImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_VariableName()
     * @generated
     */
    EClass EXPRESSION_VARIABLE_NAME = eINSTANCE.getExpression_VariableName();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_VARIABLE_NAME__VARIABLE = eINSTANCE.getExpression_VariableName_Variable();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_Larger_EqualImpl <em>Expression Larger Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.Expression_Larger_EqualImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Larger_Equal()
     * @generated
     */
    EClass EXPRESSION_LARGER_EQUAL = eINSTANCE.getExpression_Larger_Equal();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_LARGER_EQUAL__LEFT = eINSTANCE.getExpression_Larger_Equal_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_LARGER_EQUAL__RIGHT = eINSTANCE.getExpression_Larger_Equal_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_SmallerImpl <em>Expression Smaller</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.Expression_SmallerImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Smaller()
     * @generated
     */
    EClass EXPRESSION_SMALLER = eINSTANCE.getExpression_Smaller();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_SMALLER__LEFT = eINSTANCE.getExpression_Smaller_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_SMALLER__RIGHT = eINSTANCE.getExpression_Smaller_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_Smaller_EqualImpl <em>Expression Smaller Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.Expression_Smaller_EqualImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Smaller_Equal()
     * @generated
     */
    EClass EXPRESSION_SMALLER_EQUAL = eINSTANCE.getExpression_Smaller_Equal();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_SMALLER_EQUAL__LEFT = eINSTANCE.getExpression_Smaller_Equal_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_SMALLER_EQUAL__RIGHT = eINSTANCE.getExpression_Smaller_Equal_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_EqualImpl <em>Expression Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.Expression_EqualImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Equal()
     * @generated
     */
    EClass EXPRESSION_EQUAL = eINSTANCE.getExpression_Equal();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_EQUAL__LEFT = eINSTANCE.getExpression_Equal_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_EQUAL__RIGHT = eINSTANCE.getExpression_Equal_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_Not_EqualImpl <em>Expression Not Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.Expression_Not_EqualImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Not_Equal()
     * @generated
     */
    EClass EXPRESSION_NOT_EQUAL = eINSTANCE.getExpression_Not_Equal();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_NOT_EQUAL__LEFT = eINSTANCE.getExpression_Not_Equal_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_NOT_EQUAL__RIGHT = eINSTANCE.getExpression_Not_Equal_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_Not_LessImpl <em>Expression Not Less</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.Expression_Not_LessImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Not_Less()
     * @generated
     */
    EClass EXPRESSION_NOT_LESS = eINSTANCE.getExpression_Not_Less();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_NOT_LESS__LEFT = eINSTANCE.getExpression_Not_Less_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_NOT_LESS__RIGHT = eINSTANCE.getExpression_Not_Less_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.bug385636.impl.Expression_Not_GreaterImpl <em>Expression Not Greater</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.bug385636.impl.Expression_Not_GreaterImpl
     * @see org.eclipse.xtext.resource.bug385636.impl.Bug385636PackageImpl#getExpression_Not_Greater()
     * @generated
     */
    EClass EXPRESSION_NOT_GREATER = eINSTANCE.getExpression_Not_Greater();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_NOT_GREATER__LEFT = eINSTANCE.getExpression_Not_Greater_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_NOT_GREATER__RIGHT = eINSTANCE.getExpression_Not_Greater_Right();

  }

} //Bug385636Package
