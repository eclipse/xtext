/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BacktrackingContentAssistTestFactory
 * @model kind="package"
 * @generated
 */
public interface BacktrackingContentAssistTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "backtrackingContentAssistTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2010/backtrackingContentAssistTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "backtrackingContentAssistTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BacktrackingContentAssistTestPackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DocumentImpl <em>Document</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DocumentImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getDocument()
   * @generated
   */
  int DOCUMENT = 0;

  /**
   * The feature id for the '<em><b>Packages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT__PACKAGES = 0;

  /**
   * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT__CONTEXTS = 1;

  /**
   * The number of structural features of the '<em>Document</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BodyImpl <em>Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BodyImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getBody()
   * @generated
   */
  int BODY = 1;

  /**
   * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__CONSTRAINT_NAME = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ContextDeclImpl <em>Context Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ContextDeclImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getContextDecl()
   * @generated
   */
  int CONTEXT_DECL = 4;

  /**
   * The number of structural features of the '<em>Context Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_DECL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ClassifierContextDeclImpl <em>Classifier Context Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ClassifierContextDeclImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getClassifierContextDecl()
   * @generated
   */
  int CLASSIFIER_CONTEXT_DECL = 2;

  /**
   * The feature id for the '<em><b>Self Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CONTEXT_DECL__SELF_NAME = CONTEXT_DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CONTEXT_DECL__CLASSIFIER = CONTEXT_DECL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CONTEXT_DECL__INVARIANTS = CONTEXT_DECL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CONTEXT_DECL__DEFINITIONS = CONTEXT_DECL_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Classifier Context Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CONTEXT_DECL_FEATURE_COUNT = CONTEXT_DECL_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ClassifierRefImpl <em>Classifier Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ClassifierRefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getClassifierRef()
   * @generated
   */
  int CLASSIFIER_REF = 3;

  /**
   * The number of structural features of the '<em>Classifier Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_REF_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DefinitionImpl <em>Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DefinitionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getDefinition()
   * @generated
   */
  int DEFINITION = 5;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__STATIC = 0;

  /**
   * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__CONSTRAINT_NAME = 1;

  /**
   * The feature id for the '<em><b>Constrained Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__CONSTRAINED_NAME = 2;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__PARAMETERS = 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__TYPE = 4;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__EXPRESSION = 5;

  /**
   * The number of structural features of the '<em>Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DerImpl <em>Der</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DerImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getDer()
   * @generated
   */
  int DER = 6;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DER__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Der</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InitImpl <em>Init</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InitImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getInit()
   * @generated
   */
  int INIT = 7;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Init</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InvariantImpl <em>Invariant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InvariantImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getInvariant()
   * @generated
   */
  int INVARIANT = 8;

  /**
   * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVARIANT__CONSTRAINT_NAME = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVARIANT__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Invariant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVARIANT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationContextDeclImpl <em>Operation Context Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationContextDeclImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getOperationContextDecl()
   * @generated
   */
  int OPERATION_CONTEXT_DECL = 9;

  /**
   * The feature id for the '<em><b>Operation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL__OPERATION = CONTEXT_DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL__PARAMETERS = CONTEXT_DECL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL__TYPE = CONTEXT_DECL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Pres</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL__PRES = CONTEXT_DECL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Posts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL__POSTS = CONTEXT_DECL_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Bodies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL__BODIES = CONTEXT_DECL_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Operation Context Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL_FEATURE_COUNT = CONTEXT_DECL_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationRefImpl <em>Operation Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationRefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getOperationRef()
   * @generated
   */
  int OPERATION_REF = 10;

  /**
   * The number of structural features of the '<em>Operation Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_REF_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PackageDeclarationImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPackageDeclaration()
   * @generated
   */
  int PACKAGE_DECLARATION = 11;

  /**
   * The feature id for the '<em><b>Package</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__PACKAGE = 0;

  /**
   * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__CONTEXTS = 1;

  /**
   * The number of structural features of the '<em>Package Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PackageRefImpl <em>Package Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PackageRefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPackageRef()
   * @generated
   */
  int PACKAGE_REF = 12;

  /**
   * The number of structural features of the '<em>Package Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_REF_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ParameterImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__TYPE = 1;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PostImpl <em>Post</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PostImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPost()
   * @generated
   */
  int POST = 14;

  /**
   * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POST__CONSTRAINT_NAME = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POST__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Post</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POST_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PreImpl <em>Pre</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PreImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPre()
   * @generated
   */
  int PRE = 15;

  /**
   * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE__CONSTRAINT_NAME = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Pre</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PropertyContextDeclImpl <em>Property Context Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PropertyContextDeclImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPropertyContextDecl()
   * @generated
   */
  int PROPERTY_CONTEXT_DECL = 16;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_CONTEXT_DECL__PROPERTY = CONTEXT_DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_CONTEXT_DECL__TYPE = CONTEXT_DECL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_CONTEXT_DECL__INIT = CONTEXT_DECL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Der</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_CONTEXT_DECL__DER = CONTEXT_DECL_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Property Context Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_CONTEXT_DECL_FEATURE_COUNT = CONTEXT_DECL_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PropertyRefImpl <em>Property Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PropertyRefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPropertyRef()
   * @generated
   */
  int PROPERTY_REF = 17;

  /**
   * The number of structural features of the '<em>Property Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REF_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedClassifierRefImpl <em>Qualified Classifier Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedClassifierRefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getQualifiedClassifierRef()
   * @generated
   */
  int QUALIFIED_CLASSIFIER_REF = 18;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_CLASSIFIER_REF__NAMESPACE = CLASSIFIER_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_CLASSIFIER_REF__ELEMENT = CLASSIFIER_REF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Qualified Classifier Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_CLASSIFIER_REF_FEATURE_COUNT = CLASSIFIER_REF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedOperationRefImpl <em>Qualified Operation Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedOperationRefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getQualifiedOperationRef()
   * @generated
   */
  int QUALIFIED_OPERATION_REF = 19;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_OPERATION_REF__NAMESPACE = OPERATION_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_OPERATION_REF__ELEMENT = OPERATION_REF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Qualified Operation Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_OPERATION_REF_FEATURE_COUNT = OPERATION_REF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedPropertyRefImpl <em>Qualified Property Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedPropertyRefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getQualifiedPropertyRef()
   * @generated
   */
  int QUALIFIED_PROPERTY_REF = 20;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_PROPERTY_REF__NAMESPACE = PROPERTY_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_PROPERTY_REF__ELEMENT = PROPERTY_REF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Qualified Property Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_PROPERTY_REF_FEATURE_COUNT = PROPERTY_REF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedPackageRefImpl <em>Qualified Package Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedPackageRefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getQualifiedPackageRef()
   * @generated
   */
  int QUALIFIED_PACKAGE_REF = 21;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_PACKAGE_REF__NAMESPACE = PACKAGE_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_PACKAGE_REF__ELEMENT = PACKAGE_REF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Qualified Package Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_PACKAGE_REF_FEATURE_COUNT = PACKAGE_REF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimpleClassifierRefImpl <em>Simple Classifier Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimpleClassifierRefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSimpleClassifierRef()
   * @generated
   */
  int SIMPLE_CLASSIFIER_REF = 22;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_CLASSIFIER_REF__CLASSIFIER = CLASSIFIER_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple Classifier Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_CLASSIFIER_REF_FEATURE_COUNT = CLASSIFIER_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimpleOperationRefImpl <em>Simple Operation Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimpleOperationRefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSimpleOperationRef()
   * @generated
   */
  int SIMPLE_OPERATION_REF = 23;

  /**
   * The feature id for the '<em><b>Operation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_OPERATION_REF__OPERATION = OPERATION_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple Operation Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_OPERATION_REF_FEATURE_COUNT = OPERATION_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimplePackageRefImpl <em>Simple Package Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimplePackageRefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSimplePackageRef()
   * @generated
   */
  int SIMPLE_PACKAGE_REF = 24;

  /**
   * The feature id for the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_PACKAGE_REF__PACKAGE = PACKAGE_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple Package Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_PACKAGE_REF_FEATURE_COUNT = PACKAGE_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimplePropertyRefImpl <em>Simple Property Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimplePropertyRefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSimplePropertyRef()
   * @generated
   */
  int SIMPLE_PROPERTY_REF = 25;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_PROPERTY_REF__FEATURE = PROPERTY_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple Property Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_PROPERTY_REF_FEATURE_COUNT = PROPERTY_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NavigatingExpImpl <em>Navigating Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NavigatingExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getNavigatingExp()
   * @generated
   */
  int NAVIGATING_EXP = 27;

  /**
   * The number of structural features of the '<em>Navigating Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAVIGATING_EXP_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ExpressionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 26;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__TYPE = NAVIGATING_EXP_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = NAVIGATING_EXP_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OclMessageArgImpl <em>Ocl Message Arg</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OclMessageArgImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getOclMessageArg()
   * @generated
   */
  int OCL_MESSAGE_ARG = 28;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_MESSAGE_ARG__TYPE = 0;

  /**
   * The number of structural features of the '<em>Ocl Message Arg</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_MESSAGE_ARG_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TypeExpImpl <em>Type Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TypeExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getTypeExp()
   * @generated
   */
  int TYPE_EXP = 30;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The number of structural features of the '<em>Type Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PrimitiveTypeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPrimitiveType()
   * @generated
   */
  int PRIMITIVE_TYPE = 29;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__TYPE = TYPE_EXP__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__NAME = TYPE_EXP_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Primitive Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_EXP_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionTypeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getCollectionType()
   * @generated
   */
  int COLLECTION_TYPE = 31;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_TYPE__TYPE = TYPE_EXP__TYPE;

  /**
   * The feature id for the '<em><b>Collection Literal Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_TYPE__COLLECTION_LITERAL_PARTS = TYPE_EXP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_TYPE__TYPE_IDENTIFIER = TYPE_EXP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Collection Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_TYPE_FEATURE_COUNT = TYPE_EXP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TupleTypeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getTupleType()
   * @generated
   */
  int TUPLE_TYPE = 32;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__TYPE = TYPE_EXP__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__NAME = TYPE_EXP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Part</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__PART = TYPE_EXP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Tuple Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE_FEATURE_COUNT = TYPE_EXP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.tuplePartImpl <em>tuple Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.tuplePartImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#gettuplePart()
   * @generated
   */
  int TUPLE_PART = 33;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_PART__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_PART__TYPE = 1;

  /**
   * The number of structural features of the '<em>tuple Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionLiteralExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getCollectionLiteralExp()
   * @generated
   */
  int COLLECTION_LITERAL_EXP = 34;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The feature id for the '<em><b>Collection Literal Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_EXP__COLLECTION_LITERAL_PARTS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Collection Literal Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionLiteralPartImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getCollectionLiteralPart()
   * @generated
   */
  int COLLECTION_LITERAL_PART = 35;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_PART__EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Last Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_PART__LAST_EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Collection Literal Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PrimitiveLiteralExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPrimitiveLiteralExp()
   * @generated
   */
  int PRIMITIVE_LITERAL_EXP = 36;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_LITERAL_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The number of structural features of the '<em>Primitive Literal Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_LITERAL_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TupleLiteralExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getTupleLiteralExp()
   * @generated
   */
  int TUPLE_LITERAL_EXP = 37;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The feature id for the '<em><b>Part</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_EXP__PART = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tuple Literal Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TupleLiteralPartImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getTupleLiteralPart()
   * @generated
   */
  int TUPLE_LITERAL_PART = 38;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_PART__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_PART__TYPE = 1;

  /**
   * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_PART__INIT_EXPRESSION = 2;

  /**
   * The number of structural features of the '<em>Tuple Literal Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_PART_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NumberLiteralExpImpl <em>Number Literal Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NumberLiteralExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getNumberLiteralExp()
   * @generated
   */
  int NUMBER_LITERAL_EXP = 39;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Number Literal Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.StringLiteralExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getStringLiteralExp()
   * @generated
   */
  int STRING_LITERAL_EXP = 40;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_EXP__VALUES = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Literal Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BooleanLiteralExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getBooleanLiteralExp()
   * @generated
   */
  int BOOLEAN_LITERAL_EXP = 41;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

  /**
   * The feature id for the '<em><b>Is True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_EXP__IS_TRUE = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Literal Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InvalidLiteralExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getInvalidLiteralExp()
   * @generated
   */
  int INVALID_LITERAL_EXP = 42;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVALID_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

  /**
   * The number of structural features of the '<em>Invalid Literal Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVALID_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NullLiteralExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getNullLiteralExp()
   * @generated
   */
  int NULL_LITERAL_EXP = 43;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

  /**
   * The number of structural features of the '<em>Null Literal Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.iteratorVariableImpl <em>iterator Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.iteratorVariableImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getiteratorVariable()
   * @generated
   */
  int ITERATOR_VARIABLE = 44;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATOR_VARIABLE__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATOR_VARIABLE__TYPE = 1;

  /**
   * The number of structural features of the '<em>iterator Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATOR_VARIABLE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.iteratorAccumulatorImpl <em>iterator Accumulator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.iteratorAccumulatorImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getiteratorAccumulator()
   * @generated
   */
  int ITERATOR_ACCUMULATOR = 45;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATOR_ACCUMULATOR__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATOR_ACCUMULATOR__TYPE = 1;

  /**
   * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATOR_ACCUMULATOR__INIT_EXPRESSION = 2;

  /**
   * The number of structural features of the '<em>iterator Accumulator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATOR_ACCUMULATOR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.RoundBracketExpImpl <em>Round Bracket Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.RoundBracketExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getRoundBracketExp()
   * @generated
   */
  int ROUND_BRACKET_EXP = 46;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROUND_BRACKET_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROUND_BRACKET_EXP__NAME = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Pre</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROUND_BRACKET_EXP__PRE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Variable1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROUND_BRACKET_EXP__VARIABLE1 = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Variable2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROUND_BRACKET_EXP__VARIABLE2 = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROUND_BRACKET_EXP__ARGUMENTS = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Round Bracket Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROUND_BRACKET_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SquareBracketExpImpl <em>Square Bracket Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SquareBracketExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSquareBracketExp()
   * @generated
   */
  int SQUARE_BRACKET_EXP = 47;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SQUARE_BRACKET_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SQUARE_BRACKET_EXP__NAME = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SQUARE_BRACKET_EXP__ARGUMENTS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Pre</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SQUARE_BRACKET_EXP__PRE = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Square Bracket Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SQUARE_BRACKET_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PreExpImpl <em>Pre Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PreExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPreExp()
   * @generated
   */
  int PRE_EXP = 48;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_EXP__NAME = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Pre Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SelfExpImpl <em>Self Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SelfExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSelfExp()
   * @generated
   */
  int SELF_EXP = 49;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELF_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The number of structural features of the '<em>Self Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELF_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NameExpImpl <em>Name Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NameExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getNameExp()
   * @generated
   */
  int NAME_EXP = 50;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_EXP__TYPE = TYPE_EXP__TYPE;

  /**
   * The number of structural features of the '<em>Name Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_EXP_FEATURE_COUNT = TYPE_EXP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PathNameExpImpl <em>Path Name Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PathNameExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPathNameExp()
   * @generated
   */
  int PATH_NAME_EXP = 51;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_NAME_EXP__TYPE = NAME_EXP__TYPE;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_NAME_EXP__NAMESPACE = NAME_EXP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_NAME_EXP__ELEMENT = NAME_EXP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Path Name Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_NAME_EXP_FEATURE_COUNT = NAME_EXP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimpleNameExpImpl <em>Simple Name Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimpleNameExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSimpleNameExp()
   * @generated
   */
  int SIMPLE_NAME_EXP = 52;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_NAME_EXP__TYPE = NAME_EXP__TYPE;

  /**
   * The feature id for the '<em><b>Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_NAME_EXP__ELEMENT = NAME_EXP_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple Name Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_NAME_EXP_FEATURE_COUNT = NAME_EXP_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.IfExpImpl <em>If Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.IfExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getIfExp()
   * @generated
   */
  int IF_EXP = 53;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXP__CONDITION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXP__THEN_EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXP__ELSE_EXPRESSION = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.LetExpImpl <em>Let Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.LetExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getLetExp()
   * @generated
   */
  int LET_EXP = 54;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXP__VARIABLE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>In</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXP__IN = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Let Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.LetVariableImpl <em>Let Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.LetVariableImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getLetVariable()
   * @generated
   */
  int LET_VARIABLE = 55;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_VARIABLE__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_VARIABLE__TYPE = 1;

  /**
   * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_VARIABLE__INIT_EXPRESSION = 2;

  /**
   * The number of structural features of the '<em>Let Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_VARIABLE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InfixExpImpl <em>Infix Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InfixExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getInfixExp()
   * @generated
   */
  int INFIX_EXP = 56;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFIX_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The feature id for the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFIX_EXP__SOURCE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFIX_EXP__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Argument</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFIX_EXP__ARGUMENT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Infix Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFIX_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OclMessageImpl <em>Ocl Message</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OclMessageImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getOclMessage()
   * @generated
   */
  int OCL_MESSAGE = 57;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_MESSAGE__TYPE = EXPRESSION__TYPE;

  /**
   * The feature id for the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_MESSAGE__SOURCE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_MESSAGE__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Message Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_MESSAGE__MESSAGE_NAME = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_MESSAGE__ARGUMENTS = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Ocl Message</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_MESSAGE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PrefixExpImpl <em>Prefix Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PrefixExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPrefixExp()
   * @generated
   */
  int PREFIX_EXP = 58;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX_EXP__OP = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX_EXP__SOURCE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Prefix Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NestedExpImpl <em>Nested Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NestedExpImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getNestedExp()
   * @generated
   */
  int NESTED_EXP = 59;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_EXP__TYPE = EXPRESSION__TYPE;

  /**
   * The feature id for the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_EXP__SOURCE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Nested Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Document <em>Document</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Document</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Document
   * @generated
   */
  EClass getDocument();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Document#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Packages</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Document#getPackages()
   * @see #getDocument()
   * @generated
   */
  EReference getDocument_Packages();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Document#getContexts <em>Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contexts</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Document#getContexts()
   * @see #getDocument()
   * @generated
   */
  EReference getDocument_Contexts();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Body <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Body</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Body
   * @generated
   */
  EClass getBody();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Body#getConstraintName <em>Constraint Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Body#getConstraintName()
   * @see #getBody()
   * @generated
   */
  EAttribute getBody_ConstraintName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Body#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Body#getExpression()
   * @see #getBody()
   * @generated
   */
  EReference getBody_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl <em>Classifier Context Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classifier Context Decl</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl
   * @generated
   */
  EClass getClassifierContextDecl();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl#getSelfName <em>Self Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Self Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl#getSelfName()
   * @see #getClassifierContextDecl()
   * @generated
   */
  EAttribute getClassifierContextDecl_SelfName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Classifier</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl#getClassifier()
   * @see #getClassifierContextDecl()
   * @generated
   */
  EReference getClassifierContextDecl_Classifier();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl#getInvariants <em>Invariants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Invariants</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl#getInvariants()
   * @see #getClassifierContextDecl()
   * @generated
   */
  EReference getClassifierContextDecl_Invariants();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl#getDefinitions()
   * @see #getClassifierContextDecl()
   * @generated
   */
  EReference getClassifierContextDecl_Definitions();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierRef <em>Classifier Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classifier Ref</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierRef
   * @generated
   */
  EClass getClassifierRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ContextDecl <em>Context Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context Decl</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ContextDecl
   * @generated
   */
  EClass getContextDecl();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definition</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition
   * @generated
   */
  EClass getDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition#isStatic()
   * @see #getDefinition()
   * @generated
   */
  EAttribute getDefinition_Static();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition#getConstraintName <em>Constraint Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition#getConstraintName()
   * @see #getDefinition()
   * @generated
   */
  EAttribute getDefinition_ConstraintName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition#getConstrainedName <em>Constrained Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constrained Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition#getConstrainedName()
   * @see #getDefinition()
   * @generated
   */
  EAttribute getDefinition_ConstrainedName();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition#getParameters()
   * @see #getDefinition()
   * @generated
   */
  EReference getDefinition_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition#getType()
   * @see #getDefinition()
   * @generated
   */
  EReference getDefinition_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition#getExpression()
   * @see #getDefinition()
   * @generated
   */
  EReference getDefinition_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Der <em>Der</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Der</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Der
   * @generated
   */
  EClass getDer();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Der#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Der#getExpression()
   * @see #getDer()
   * @generated
   */
  EReference getDer_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Init <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Init</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Init
   * @generated
   */
  EClass getInit();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Init#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Init#getExpression()
   * @see #getInit()
   * @generated
   */
  EReference getInit_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Invariant <em>Invariant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invariant</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Invariant
   * @generated
   */
  EClass getInvariant();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Invariant#getConstraintName <em>Constraint Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Invariant#getConstraintName()
   * @see #getInvariant()
   * @generated
   */
  EAttribute getInvariant_ConstraintName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Invariant#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Invariant#getExpression()
   * @see #getInvariant()
   * @generated
   */
  EReference getInvariant_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl <em>Operation Context Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Context Decl</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl
   * @generated
   */
  EClass getOperationContextDecl();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operation</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl#getOperation()
   * @see #getOperationContextDecl()
   * @generated
   */
  EReference getOperationContextDecl_Operation();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl#getParameters()
   * @see #getOperationContextDecl()
   * @generated
   */
  EReference getOperationContextDecl_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl#getType()
   * @see #getOperationContextDecl()
   * @generated
   */
  EReference getOperationContextDecl_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl#getPres <em>Pres</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pres</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl#getPres()
   * @see #getOperationContextDecl()
   * @generated
   */
  EReference getOperationContextDecl_Pres();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl#getPosts <em>Posts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Posts</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl#getPosts()
   * @see #getOperationContextDecl()
   * @generated
   */
  EReference getOperationContextDecl_Posts();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl#getBodies <em>Bodies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bodies</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl#getBodies()
   * @see #getOperationContextDecl()
   * @generated
   */
  EReference getOperationContextDecl_Bodies();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationRef <em>Operation Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Ref</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationRef
   * @generated
   */
  EClass getOperationRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Declaration</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageDeclaration
   * @generated
   */
  EClass getPackageDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageDeclaration#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Package</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageDeclaration#getPackage()
   * @see #getPackageDeclaration()
   * @generated
   */
  EReference getPackageDeclaration_Package();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageDeclaration#getContexts <em>Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contexts</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageDeclaration#getContexts()
   * @see #getPackageDeclaration()
   * @generated
   */
  EReference getPackageDeclaration_Contexts();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageRef <em>Package Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Ref</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageRef
   * @generated
   */
  EClass getPackageRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Parameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Parameter#getName()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Parameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Parameter#getType()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Post <em>Post</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Post</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Post
   * @generated
   */
  EClass getPost();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Post#getConstraintName <em>Constraint Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Post#getConstraintName()
   * @see #getPost()
   * @generated
   */
  EAttribute getPost_ConstraintName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Post#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Post#getExpression()
   * @see #getPost()
   * @generated
   */
  EReference getPost_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Pre <em>Pre</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pre</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Pre
   * @generated
   */
  EClass getPre();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Pre#getConstraintName <em>Constraint Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Pre#getConstraintName()
   * @see #getPre()
   * @generated
   */
  EAttribute getPre_ConstraintName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Pre#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Pre#getExpression()
   * @see #getPre()
   * @generated
   */
  EReference getPre_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl <em>Property Context Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Context Decl</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl
   * @generated
   */
  EClass getPropertyContextDecl();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Property</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl#getProperty()
   * @see #getPropertyContextDecl()
   * @generated
   */
  EReference getPropertyContextDecl_Property();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl#getType()
   * @see #getPropertyContextDecl()
   * @generated
   */
  EReference getPropertyContextDecl_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl#getInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl#getInit()
   * @see #getPropertyContextDecl()
   * @generated
   */
  EReference getPropertyContextDecl_Init();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl#getDer <em>Der</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Der</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl#getDer()
   * @see #getPropertyContextDecl()
   * @generated
   */
  EReference getPropertyContextDecl_Der();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyRef <em>Property Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Ref</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyRef
   * @generated
   */
  EClass getPropertyRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedClassifierRef <em>Qualified Classifier Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Classifier Ref</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedClassifierRef
   * @generated
   */
  EClass getQualifiedClassifierRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedClassifierRef#getNamespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Namespace</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedClassifierRef#getNamespace()
   * @see #getQualifiedClassifierRef()
   * @generated
   */
  EAttribute getQualifiedClassifierRef_Namespace();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedClassifierRef#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedClassifierRef#getElement()
   * @see #getQualifiedClassifierRef()
   * @generated
   */
  EReference getQualifiedClassifierRef_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedOperationRef <em>Qualified Operation Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Operation Ref</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedOperationRef
   * @generated
   */
  EClass getQualifiedOperationRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedOperationRef#getNamespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Namespace</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedOperationRef#getNamespace()
   * @see #getQualifiedOperationRef()
   * @generated
   */
  EAttribute getQualifiedOperationRef_Namespace();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedOperationRef#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedOperationRef#getElement()
   * @see #getQualifiedOperationRef()
   * @generated
   */
  EReference getQualifiedOperationRef_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPropertyRef <em>Qualified Property Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Property Ref</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPropertyRef
   * @generated
   */
  EClass getQualifiedPropertyRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPropertyRef#getNamespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Namespace</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPropertyRef#getNamespace()
   * @see #getQualifiedPropertyRef()
   * @generated
   */
  EAttribute getQualifiedPropertyRef_Namespace();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPropertyRef#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPropertyRef#getElement()
   * @see #getQualifiedPropertyRef()
   * @generated
   */
  EReference getQualifiedPropertyRef_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPackageRef <em>Qualified Package Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Package Ref</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPackageRef
   * @generated
   */
  EClass getQualifiedPackageRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPackageRef#getNamespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Namespace</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPackageRef#getNamespace()
   * @see #getQualifiedPackageRef()
   * @generated
   */
  EAttribute getQualifiedPackageRef_Namespace();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPackageRef#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPackageRef#getElement()
   * @see #getQualifiedPackageRef()
   * @generated
   */
  EReference getQualifiedPackageRef_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleClassifierRef <em>Simple Classifier Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Classifier Ref</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleClassifierRef
   * @generated
   */
  EClass getSimpleClassifierRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleClassifierRef#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Classifier</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleClassifierRef#getClassifier()
   * @see #getSimpleClassifierRef()
   * @generated
   */
  EAttribute getSimpleClassifierRef_Classifier();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleOperationRef <em>Simple Operation Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Operation Ref</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleOperationRef
   * @generated
   */
  EClass getSimpleOperationRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleOperationRef#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operation</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleOperationRef#getOperation()
   * @see #getSimpleOperationRef()
   * @generated
   */
  EAttribute getSimpleOperationRef_Operation();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePackageRef <em>Simple Package Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Package Ref</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePackageRef
   * @generated
   */
  EClass getSimplePackageRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePackageRef#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePackageRef#getPackage()
   * @see #getSimplePackageRef()
   * @generated
   */
  EAttribute getSimplePackageRef_Package();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePropertyRef <em>Simple Property Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Property Ref</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePropertyRef
   * @generated
   */
  EClass getSimplePropertyRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePropertyRef#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePropertyRef#getFeature()
   * @see #getSimplePropertyRef()
   * @generated
   */
  EAttribute getSimplePropertyRef_Feature();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NavigatingExp <em>Navigating Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Navigating Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NavigatingExp
   * @generated
   */
  EClass getNavigatingExp();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessageArg <em>Ocl Message Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ocl Message Arg</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessageArg
   * @generated
   */
  EClass getOclMessageArg();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessageArg#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessageArg#getType()
   * @see #getOclMessageArg()
   * @generated
   */
  EReference getOclMessageArg_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrimitiveType <em>Primitive Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrimitiveType
   * @generated
   */
  EClass getPrimitiveType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrimitiveType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrimitiveType#getName()
   * @see #getPrimitiveType()
   * @generated
   */
  EAttribute getPrimitiveType_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TypeExp <em>Type Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TypeExp
   * @generated
   */
  EClass getTypeExp();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionType <em>Collection Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionType
   * @generated
   */
  EClass getCollectionType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionType#getTypeIdentifier <em>Type Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Identifier</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionType#getTypeIdentifier()
   * @see #getCollectionType()
   * @generated
   */
  EAttribute getCollectionType_TypeIdentifier();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleType <em>Tuple Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleType
   * @generated
   */
  EClass getTupleType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleType#getName()
   * @see #getTupleType()
   * @generated
   */
  EAttribute getTupleType_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleType#getPart <em>Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Part</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleType#getPart()
   * @see #getTupleType()
   * @generated
   */
  EReference getTupleType_Part();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.tuplePart <em>tuple Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>tuple Part</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.tuplePart
   * @generated
   */
  EClass gettuplePart();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.tuplePart#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.tuplePart#getName()
   * @see #gettuplePart()
   * @generated
   */
  EAttribute gettuplePart_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.tuplePart#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.tuplePart#getType()
   * @see #gettuplePart()
   * @generated
   */
  EReference gettuplePart_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Literal Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralExp
   * @generated
   */
  EClass getCollectionLiteralExp();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralExp#getCollectionLiteralParts <em>Collection Literal Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Collection Literal Parts</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralExp#getCollectionLiteralParts()
   * @see #getCollectionLiteralExp()
   * @generated
   */
  EReference getCollectionLiteralExp_CollectionLiteralParts();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralPart <em>Collection Literal Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Literal Part</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralPart
   * @generated
   */
  EClass getCollectionLiteralPart();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralPart#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralPart#getExpression()
   * @see #getCollectionLiteralPart()
   * @generated
   */
  EReference getCollectionLiteralPart_Expression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralPart#getLastExpression <em>Last Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Last Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralPart#getLastExpression()
   * @see #getCollectionLiteralPart()
   * @generated
   */
  EReference getCollectionLiteralPart_LastExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Literal Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrimitiveLiteralExp
   * @generated
   */
  EClass getPrimitiveLiteralExp();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Literal Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralExp
   * @generated
   */
  EClass getTupleLiteralExp();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralExp#getPart <em>Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Part</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralExp#getPart()
   * @see #getTupleLiteralExp()
   * @generated
   */
  EReference getTupleLiteralExp_Part();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralPart <em>Tuple Literal Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Literal Part</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralPart
   * @generated
   */
  EClass getTupleLiteralPart();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralPart#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralPart#getName()
   * @see #getTupleLiteralPart()
   * @generated
   */
  EAttribute getTupleLiteralPart_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralPart#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralPart#getType()
   * @see #getTupleLiteralPart()
   * @generated
   */
  EReference getTupleLiteralPart_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralPart#getInitExpression <em>Init Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralPart#getInitExpression()
   * @see #getTupleLiteralPart()
   * @generated
   */
  EReference getTupleLiteralPart_InitExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NumberLiteralExp <em>Number Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Literal Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NumberLiteralExp
   * @generated
   */
  EClass getNumberLiteralExp();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NumberLiteralExp#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NumberLiteralExp#getName()
   * @see #getNumberLiteralExp()
   * @generated
   */
  EAttribute getNumberLiteralExp_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.StringLiteralExp <em>String Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.StringLiteralExp
   * @generated
   */
  EClass getStringLiteralExp();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.StringLiteralExp#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.StringLiteralExp#getValues()
   * @see #getStringLiteralExp()
   * @generated
   */
  EAttribute getStringLiteralExp_Values();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BooleanLiteralExp
   * @generated
   */
  EClass getBooleanLiteralExp();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BooleanLiteralExp#isIsTrue <em>Is True</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is True</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BooleanLiteralExp#isIsTrue()
   * @see #getBooleanLiteralExp()
   * @generated
   */
  EAttribute getBooleanLiteralExp_IsTrue();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InvalidLiteralExp <em>Invalid Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invalid Literal Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InvalidLiteralExp
   * @generated
   */
  EClass getInvalidLiteralExp();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NullLiteralExp <em>Null Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Literal Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NullLiteralExp
   * @generated
   */
  EClass getNullLiteralExp();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorVariable <em>iterator Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>iterator Variable</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorVariable
   * @generated
   */
  EClass getiteratorVariable();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorVariable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorVariable#getName()
   * @see #getiteratorVariable()
   * @generated
   */
  EAttribute getiteratorVariable_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorVariable#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorVariable#getType()
   * @see #getiteratorVariable()
   * @generated
   */
  EReference getiteratorVariable_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorAccumulator <em>iterator Accumulator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>iterator Accumulator</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorAccumulator
   * @generated
   */
  EClass getiteratorAccumulator();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorAccumulator#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorAccumulator#getName()
   * @see #getiteratorAccumulator()
   * @generated
   */
  EAttribute getiteratorAccumulator_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorAccumulator#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorAccumulator#getType()
   * @see #getiteratorAccumulator()
   * @generated
   */
  EReference getiteratorAccumulator_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorAccumulator#getInitExpression <em>Init Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorAccumulator#getInitExpression()
   * @see #getiteratorAccumulator()
   * @generated
   */
  EReference getiteratorAccumulator_InitExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp <em>Round Bracket Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Round Bracket Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp
   * @generated
   */
  EClass getRoundBracketExp();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp#getName()
   * @see #getRoundBracketExp()
   * @generated
   */
  EReference getRoundBracketExp_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp#isPre <em>Pre</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pre</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp#isPre()
   * @see #getRoundBracketExp()
   * @generated
   */
  EAttribute getRoundBracketExp_Pre();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp#getVariable1 <em>Variable1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable1</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp#getVariable1()
   * @see #getRoundBracketExp()
   * @generated
   */
  EReference getRoundBracketExp_Variable1();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp#getVariable2 <em>Variable2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable2</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp#getVariable2()
   * @see #getRoundBracketExp()
   * @generated
   */
  EReference getRoundBracketExp_Variable2();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp#getArguments()
   * @see #getRoundBracketExp()
   * @generated
   */
  EReference getRoundBracketExp_Arguments();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SquareBracketExp <em>Square Bracket Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Square Bracket Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SquareBracketExp
   * @generated
   */
  EClass getSquareBracketExp();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SquareBracketExp#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SquareBracketExp#getName()
   * @see #getSquareBracketExp()
   * @generated
   */
  EReference getSquareBracketExp_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SquareBracketExp#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SquareBracketExp#getArguments()
   * @see #getSquareBracketExp()
   * @generated
   */
  EReference getSquareBracketExp_Arguments();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SquareBracketExp#isPre <em>Pre</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pre</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SquareBracketExp#isPre()
   * @see #getSquareBracketExp()
   * @generated
   */
  EAttribute getSquareBracketExp_Pre();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PreExp <em>Pre Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pre Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PreExp
   * @generated
   */
  EClass getPreExp();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PreExp#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PreExp#getName()
   * @see #getPreExp()
   * @generated
   */
  EReference getPreExp_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SelfExp <em>Self Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Self Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SelfExp
   * @generated
   */
  EClass getSelfExp();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NameExp <em>Name Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NameExp
   * @generated
   */
  EClass getNameExp();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PathNameExp <em>Path Name Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Path Name Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PathNameExp
   * @generated
   */
  EClass getPathNameExp();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PathNameExp#getNamespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Namespace</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PathNameExp#getNamespace()
   * @see #getPathNameExp()
   * @generated
   */
  EAttribute getPathNameExp_Namespace();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PathNameExp#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PathNameExp#getElement()
   * @see #getPathNameExp()
   * @generated
   */
  EReference getPathNameExp_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleNameExp <em>Simple Name Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Name Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleNameExp
   * @generated
   */
  EClass getSimpleNameExp();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleNameExp#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Element</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleNameExp#getElement()
   * @see #getSimpleNameExp()
   * @generated
   */
  EAttribute getSimpleNameExp_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.IfExp <em>If Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.IfExp
   * @generated
   */
  EClass getIfExp();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.IfExp#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.IfExp#getCondition()
   * @see #getIfExp()
   * @generated
   */
  EReference getIfExp_Condition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.IfExp#getThenExpression <em>Then Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.IfExp#getThenExpression()
   * @see #getIfExp()
   * @generated
   */
  EReference getIfExp_ThenExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.IfExp#getElseExpression <em>Else Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.IfExp#getElseExpression()
   * @see #getIfExp()
   * @generated
   */
  EReference getIfExp_ElseExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetExp <em>Let Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Let Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetExp
   * @generated
   */
  EClass getLetExp();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetExp#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variable</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetExp#getVariable()
   * @see #getLetExp()
   * @generated
   */
  EReference getLetExp_Variable();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetExp#getIn <em>In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>In</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetExp#getIn()
   * @see #getLetExp()
   * @generated
   */
  EReference getLetExp_In();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetVariable <em>Let Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Let Variable</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetVariable
   * @generated
   */
  EClass getLetVariable();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetVariable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetVariable#getName()
   * @see #getLetVariable()
   * @generated
   */
  EAttribute getLetVariable_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetVariable#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetVariable#getType()
   * @see #getLetVariable()
   * @generated
   */
  EReference getLetVariable_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetVariable#getInitExpression <em>Init Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetVariable#getInitExpression()
   * @see #getLetVariable()
   * @generated
   */
  EReference getLetVariable_InitExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InfixExp <em>Infix Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Infix Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InfixExp
   * @generated
   */
  EClass getInfixExp();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InfixExp#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InfixExp#getSource()
   * @see #getInfixExp()
   * @generated
   */
  EReference getInfixExp_Source();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InfixExp#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InfixExp#getOp()
   * @see #getInfixExp()
   * @generated
   */
  EAttribute getInfixExp_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InfixExp#getArgument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Argument</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InfixExp#getArgument()
   * @see #getInfixExp()
   * @generated
   */
  EReference getInfixExp_Argument();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage <em>Ocl Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ocl Message</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage
   * @generated
   */
  EClass getOclMessage();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage#getSource()
   * @see #getOclMessage()
   * @generated
   */
  EReference getOclMessage_Source();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage#getOp()
   * @see #getOclMessage()
   * @generated
   */
  EAttribute getOclMessage_Op();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage#getMessageName <em>Message Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage#getMessageName()
   * @see #getOclMessage()
   * @generated
   */
  EAttribute getOclMessage_MessageName();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage#getArguments()
   * @see #getOclMessage()
   * @generated
   */
  EReference getOclMessage_Arguments();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrefixExp <em>Prefix Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prefix Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrefixExp
   * @generated
   */
  EClass getPrefixExp();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrefixExp#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrefixExp#getOp()
   * @see #getPrefixExp()
   * @generated
   */
  EAttribute getPrefixExp_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrefixExp#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrefixExp#getSource()
   * @see #getPrefixExp()
   * @generated
   */
  EReference getPrefixExp_Source();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NestedExp <em>Nested Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Exp</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NestedExp
   * @generated
   */
  EClass getNestedExp();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NestedExp#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NestedExp#getSource()
   * @see #getNestedExp()
   * @generated
   */
  EReference getNestedExp_Source();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  BacktrackingContentAssistTestFactory getBacktrackingContentAssistTestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DocumentImpl <em>Document</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DocumentImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getDocument()
     * @generated
     */
    EClass DOCUMENT = eINSTANCE.getDocument();

    /**
     * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT__PACKAGES = eINSTANCE.getDocument_Packages();

    /**
     * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT__CONTEXTS = eINSTANCE.getDocument_Contexts();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BodyImpl <em>Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BodyImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getBody()
     * @generated
     */
    EClass BODY = eINSTANCE.getBody();

    /**
     * The meta object literal for the '<em><b>Constraint Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BODY__CONSTRAINT_NAME = eINSTANCE.getBody_ConstraintName();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BODY__EXPRESSION = eINSTANCE.getBody_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ClassifierContextDeclImpl <em>Classifier Context Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ClassifierContextDeclImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getClassifierContextDecl()
     * @generated
     */
    EClass CLASSIFIER_CONTEXT_DECL = eINSTANCE.getClassifierContextDecl();

    /**
     * The meta object literal for the '<em><b>Self Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_CONTEXT_DECL__SELF_NAME = eINSTANCE.getClassifierContextDecl_SelfName();

    /**
     * The meta object literal for the '<em><b>Classifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_CONTEXT_DECL__CLASSIFIER = eINSTANCE.getClassifierContextDecl_Classifier();

    /**
     * The meta object literal for the '<em><b>Invariants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_CONTEXT_DECL__INVARIANTS = eINSTANCE.getClassifierContextDecl_Invariants();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_CONTEXT_DECL__DEFINITIONS = eINSTANCE.getClassifierContextDecl_Definitions();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ClassifierRefImpl <em>Classifier Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ClassifierRefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getClassifierRef()
     * @generated
     */
    EClass CLASSIFIER_REF = eINSTANCE.getClassifierRef();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ContextDeclImpl <em>Context Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ContextDeclImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getContextDecl()
     * @generated
     */
    EClass CONTEXT_DECL = eINSTANCE.getContextDecl();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DefinitionImpl <em>Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DefinitionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getDefinition()
     * @generated
     */
    EClass DEFINITION = eINSTANCE.getDefinition();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINITION__STATIC = eINSTANCE.getDefinition_Static();

    /**
     * The meta object literal for the '<em><b>Constraint Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINITION__CONSTRAINT_NAME = eINSTANCE.getDefinition_ConstraintName();

    /**
     * The meta object literal for the '<em><b>Constrained Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINITION__CONSTRAINED_NAME = eINSTANCE.getDefinition_ConstrainedName();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINITION__PARAMETERS = eINSTANCE.getDefinition_Parameters();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINITION__TYPE = eINSTANCE.getDefinition_Type();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINITION__EXPRESSION = eINSTANCE.getDefinition_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DerImpl <em>Der</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DerImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getDer()
     * @generated
     */
    EClass DER = eINSTANCE.getDer();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DER__EXPRESSION = eINSTANCE.getDer_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InitImpl <em>Init</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InitImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getInit()
     * @generated
     */
    EClass INIT = eINSTANCE.getInit();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INIT__EXPRESSION = eINSTANCE.getInit_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InvariantImpl <em>Invariant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InvariantImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getInvariant()
     * @generated
     */
    EClass INVARIANT = eINSTANCE.getInvariant();

    /**
     * The meta object literal for the '<em><b>Constraint Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INVARIANT__CONSTRAINT_NAME = eINSTANCE.getInvariant_ConstraintName();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVARIANT__EXPRESSION = eINSTANCE.getInvariant_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationContextDeclImpl <em>Operation Context Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationContextDeclImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getOperationContextDecl()
     * @generated
     */
    EClass OPERATION_CONTEXT_DECL = eINSTANCE.getOperationContextDecl();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CONTEXT_DECL__OPERATION = eINSTANCE.getOperationContextDecl_Operation();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CONTEXT_DECL__PARAMETERS = eINSTANCE.getOperationContextDecl_Parameters();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CONTEXT_DECL__TYPE = eINSTANCE.getOperationContextDecl_Type();

    /**
     * The meta object literal for the '<em><b>Pres</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CONTEXT_DECL__PRES = eINSTANCE.getOperationContextDecl_Pres();

    /**
     * The meta object literal for the '<em><b>Posts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CONTEXT_DECL__POSTS = eINSTANCE.getOperationContextDecl_Posts();

    /**
     * The meta object literal for the '<em><b>Bodies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CONTEXT_DECL__BODIES = eINSTANCE.getOperationContextDecl_Bodies();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationRefImpl <em>Operation Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationRefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getOperationRef()
     * @generated
     */
    EClass OPERATION_REF = eINSTANCE.getOperationRef();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PackageDeclarationImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPackageDeclaration()
     * @generated
     */
    EClass PACKAGE_DECLARATION = eINSTANCE.getPackageDeclaration();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DECLARATION__PACKAGE = eINSTANCE.getPackageDeclaration_Package();

    /**
     * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DECLARATION__CONTEXTS = eINSTANCE.getPackageDeclaration_Contexts();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PackageRefImpl <em>Package Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PackageRefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPackageRef()
     * @generated
     */
    EClass PACKAGE_REF = eINSTANCE.getPackageRef();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ParameterImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PostImpl <em>Post</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PostImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPost()
     * @generated
     */
    EClass POST = eINSTANCE.getPost();

    /**
     * The meta object literal for the '<em><b>Constraint Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute POST__CONSTRAINT_NAME = eINSTANCE.getPost_ConstraintName();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POST__EXPRESSION = eINSTANCE.getPost_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PreImpl <em>Pre</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PreImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPre()
     * @generated
     */
    EClass PRE = eINSTANCE.getPre();

    /**
     * The meta object literal for the '<em><b>Constraint Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRE__CONSTRAINT_NAME = eINSTANCE.getPre_ConstraintName();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRE__EXPRESSION = eINSTANCE.getPre_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PropertyContextDeclImpl <em>Property Context Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PropertyContextDeclImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPropertyContextDecl()
     * @generated
     */
    EClass PROPERTY_CONTEXT_DECL = eINSTANCE.getPropertyContextDecl();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_CONTEXT_DECL__PROPERTY = eINSTANCE.getPropertyContextDecl_Property();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_CONTEXT_DECL__TYPE = eINSTANCE.getPropertyContextDecl_Type();

    /**
     * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_CONTEXT_DECL__INIT = eINSTANCE.getPropertyContextDecl_Init();

    /**
     * The meta object literal for the '<em><b>Der</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_CONTEXT_DECL__DER = eINSTANCE.getPropertyContextDecl_Der();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PropertyRefImpl <em>Property Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PropertyRefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPropertyRef()
     * @generated
     */
    EClass PROPERTY_REF = eINSTANCE.getPropertyRef();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedClassifierRefImpl <em>Qualified Classifier Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedClassifierRefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getQualifiedClassifierRef()
     * @generated
     */
    EClass QUALIFIED_CLASSIFIER_REF = eINSTANCE.getQualifiedClassifierRef();

    /**
     * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUALIFIED_CLASSIFIER_REF__NAMESPACE = eINSTANCE.getQualifiedClassifierRef_Namespace();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_CLASSIFIER_REF__ELEMENT = eINSTANCE.getQualifiedClassifierRef_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedOperationRefImpl <em>Qualified Operation Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedOperationRefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getQualifiedOperationRef()
     * @generated
     */
    EClass QUALIFIED_OPERATION_REF = eINSTANCE.getQualifiedOperationRef();

    /**
     * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUALIFIED_OPERATION_REF__NAMESPACE = eINSTANCE.getQualifiedOperationRef_Namespace();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_OPERATION_REF__ELEMENT = eINSTANCE.getQualifiedOperationRef_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedPropertyRefImpl <em>Qualified Property Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedPropertyRefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getQualifiedPropertyRef()
     * @generated
     */
    EClass QUALIFIED_PROPERTY_REF = eINSTANCE.getQualifiedPropertyRef();

    /**
     * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUALIFIED_PROPERTY_REF__NAMESPACE = eINSTANCE.getQualifiedPropertyRef_Namespace();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_PROPERTY_REF__ELEMENT = eINSTANCE.getQualifiedPropertyRef_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedPackageRefImpl <em>Qualified Package Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.QualifiedPackageRefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getQualifiedPackageRef()
     * @generated
     */
    EClass QUALIFIED_PACKAGE_REF = eINSTANCE.getQualifiedPackageRef();

    /**
     * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUALIFIED_PACKAGE_REF__NAMESPACE = eINSTANCE.getQualifiedPackageRef_Namespace();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_PACKAGE_REF__ELEMENT = eINSTANCE.getQualifiedPackageRef_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimpleClassifierRefImpl <em>Simple Classifier Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimpleClassifierRefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSimpleClassifierRef()
     * @generated
     */
    EClass SIMPLE_CLASSIFIER_REF = eINSTANCE.getSimpleClassifierRef();

    /**
     * The meta object literal for the '<em><b>Classifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_CLASSIFIER_REF__CLASSIFIER = eINSTANCE.getSimpleClassifierRef_Classifier();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimpleOperationRefImpl <em>Simple Operation Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimpleOperationRefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSimpleOperationRef()
     * @generated
     */
    EClass SIMPLE_OPERATION_REF = eINSTANCE.getSimpleOperationRef();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_OPERATION_REF__OPERATION = eINSTANCE.getSimpleOperationRef_Operation();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimplePackageRefImpl <em>Simple Package Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimplePackageRefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSimplePackageRef()
     * @generated
     */
    EClass SIMPLE_PACKAGE_REF = eINSTANCE.getSimplePackageRef();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_PACKAGE_REF__PACKAGE = eINSTANCE.getSimplePackageRef_Package();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimplePropertyRefImpl <em>Simple Property Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimplePropertyRefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSimplePropertyRef()
     * @generated
     */
    EClass SIMPLE_PROPERTY_REF = eINSTANCE.getSimplePropertyRef();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_PROPERTY_REF__FEATURE = eINSTANCE.getSimplePropertyRef_Feature();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ExpressionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NavigatingExpImpl <em>Navigating Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NavigatingExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getNavigatingExp()
     * @generated
     */
    EClass NAVIGATING_EXP = eINSTANCE.getNavigatingExp();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OclMessageArgImpl <em>Ocl Message Arg</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OclMessageArgImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getOclMessageArg()
     * @generated
     */
    EClass OCL_MESSAGE_ARG = eINSTANCE.getOclMessageArg();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OCL_MESSAGE_ARG__TYPE = eINSTANCE.getOclMessageArg_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PrimitiveTypeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPrimitiveType()
     * @generated
     */
    EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE_TYPE__NAME = eINSTANCE.getPrimitiveType_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TypeExpImpl <em>Type Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TypeExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getTypeExp()
     * @generated
     */
    EClass TYPE_EXP = eINSTANCE.getTypeExp();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionTypeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getCollectionType()
     * @generated
     */
    EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

    /**
     * The meta object literal for the '<em><b>Type Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTION_TYPE__TYPE_IDENTIFIER = eINSTANCE.getCollectionType_TypeIdentifier();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TupleTypeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getTupleType()
     * @generated
     */
    EClass TUPLE_TYPE = eINSTANCE.getTupleType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TUPLE_TYPE__NAME = eINSTANCE.getTupleType_Name();

    /**
     * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_TYPE__PART = eINSTANCE.getTupleType_Part();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.tuplePartImpl <em>tuple Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.tuplePartImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#gettuplePart()
     * @generated
     */
    EClass TUPLE_PART = eINSTANCE.gettuplePart();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TUPLE_PART__NAME = eINSTANCE.gettuplePart_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_PART__TYPE = eINSTANCE.gettuplePart_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionLiteralExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getCollectionLiteralExp()
     * @generated
     */
    EClass COLLECTION_LITERAL_EXP = eINSTANCE.getCollectionLiteralExp();

    /**
     * The meta object literal for the '<em><b>Collection Literal Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_LITERAL_EXP__COLLECTION_LITERAL_PARTS = eINSTANCE.getCollectionLiteralExp_CollectionLiteralParts();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionLiteralPartImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getCollectionLiteralPart()
     * @generated
     */
    EClass COLLECTION_LITERAL_PART = eINSTANCE.getCollectionLiteralPart();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_LITERAL_PART__EXPRESSION = eINSTANCE.getCollectionLiteralPart_Expression();

    /**
     * The meta object literal for the '<em><b>Last Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_LITERAL_PART__LAST_EXPRESSION = eINSTANCE.getCollectionLiteralPart_LastExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PrimitiveLiteralExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPrimitiveLiteralExp()
     * @generated
     */
    EClass PRIMITIVE_LITERAL_EXP = eINSTANCE.getPrimitiveLiteralExp();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TupleLiteralExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getTupleLiteralExp()
     * @generated
     */
    EClass TUPLE_LITERAL_EXP = eINSTANCE.getTupleLiteralExp();

    /**
     * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_LITERAL_EXP__PART = eINSTANCE.getTupleLiteralExp_Part();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.TupleLiteralPartImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getTupleLiteralPart()
     * @generated
     */
    EClass TUPLE_LITERAL_PART = eINSTANCE.getTupleLiteralPart();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TUPLE_LITERAL_PART__NAME = eINSTANCE.getTupleLiteralPart_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_LITERAL_PART__TYPE = eINSTANCE.getTupleLiteralPart_Type();

    /**
     * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_LITERAL_PART__INIT_EXPRESSION = eINSTANCE.getTupleLiteralPart_InitExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NumberLiteralExpImpl <em>Number Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NumberLiteralExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getNumberLiteralExp()
     * @generated
     */
    EClass NUMBER_LITERAL_EXP = eINSTANCE.getNumberLiteralExp();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMBER_LITERAL_EXP__NAME = eINSTANCE.getNumberLiteralExp_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.StringLiteralExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getStringLiteralExp()
     * @generated
     */
    EClass STRING_LITERAL_EXP = eINSTANCE.getStringLiteralExp();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_LITERAL_EXP__VALUES = eINSTANCE.getStringLiteralExp_Values();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BooleanLiteralExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getBooleanLiteralExp()
     * @generated
     */
    EClass BOOLEAN_LITERAL_EXP = eINSTANCE.getBooleanLiteralExp();

    /**
     * The meta object literal for the '<em><b>Is True</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_LITERAL_EXP__IS_TRUE = eINSTANCE.getBooleanLiteralExp_IsTrue();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InvalidLiteralExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getInvalidLiteralExp()
     * @generated
     */
    EClass INVALID_LITERAL_EXP = eINSTANCE.getInvalidLiteralExp();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NullLiteralExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getNullLiteralExp()
     * @generated
     */
    EClass NULL_LITERAL_EXP = eINSTANCE.getNullLiteralExp();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.iteratorVariableImpl <em>iterator Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.iteratorVariableImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getiteratorVariable()
     * @generated
     */
    EClass ITERATOR_VARIABLE = eINSTANCE.getiteratorVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ITERATOR_VARIABLE__NAME = eINSTANCE.getiteratorVariable_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITERATOR_VARIABLE__TYPE = eINSTANCE.getiteratorVariable_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.iteratorAccumulatorImpl <em>iterator Accumulator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.iteratorAccumulatorImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getiteratorAccumulator()
     * @generated
     */
    EClass ITERATOR_ACCUMULATOR = eINSTANCE.getiteratorAccumulator();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ITERATOR_ACCUMULATOR__NAME = eINSTANCE.getiteratorAccumulator_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITERATOR_ACCUMULATOR__TYPE = eINSTANCE.getiteratorAccumulator_Type();

    /**
     * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITERATOR_ACCUMULATOR__INIT_EXPRESSION = eINSTANCE.getiteratorAccumulator_InitExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.RoundBracketExpImpl <em>Round Bracket Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.RoundBracketExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getRoundBracketExp()
     * @generated
     */
    EClass ROUND_BRACKET_EXP = eINSTANCE.getRoundBracketExp();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROUND_BRACKET_EXP__NAME = eINSTANCE.getRoundBracketExp_Name();

    /**
     * The meta object literal for the '<em><b>Pre</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ROUND_BRACKET_EXP__PRE = eINSTANCE.getRoundBracketExp_Pre();

    /**
     * The meta object literal for the '<em><b>Variable1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROUND_BRACKET_EXP__VARIABLE1 = eINSTANCE.getRoundBracketExp_Variable1();

    /**
     * The meta object literal for the '<em><b>Variable2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROUND_BRACKET_EXP__VARIABLE2 = eINSTANCE.getRoundBracketExp_Variable2();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROUND_BRACKET_EXP__ARGUMENTS = eINSTANCE.getRoundBracketExp_Arguments();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SquareBracketExpImpl <em>Square Bracket Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SquareBracketExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSquareBracketExp()
     * @generated
     */
    EClass SQUARE_BRACKET_EXP = eINSTANCE.getSquareBracketExp();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SQUARE_BRACKET_EXP__NAME = eINSTANCE.getSquareBracketExp_Name();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SQUARE_BRACKET_EXP__ARGUMENTS = eINSTANCE.getSquareBracketExp_Arguments();

    /**
     * The meta object literal for the '<em><b>Pre</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SQUARE_BRACKET_EXP__PRE = eINSTANCE.getSquareBracketExp_Pre();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PreExpImpl <em>Pre Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PreExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPreExp()
     * @generated
     */
    EClass PRE_EXP = eINSTANCE.getPreExp();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRE_EXP__NAME = eINSTANCE.getPreExp_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SelfExpImpl <em>Self Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SelfExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSelfExp()
     * @generated
     */
    EClass SELF_EXP = eINSTANCE.getSelfExp();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NameExpImpl <em>Name Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NameExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getNameExp()
     * @generated
     */
    EClass NAME_EXP = eINSTANCE.getNameExp();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PathNameExpImpl <em>Path Name Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PathNameExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPathNameExp()
     * @generated
     */
    EClass PATH_NAME_EXP = eINSTANCE.getPathNameExp();

    /**
     * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATH_NAME_EXP__NAMESPACE = eINSTANCE.getPathNameExp_Namespace();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATH_NAME_EXP__ELEMENT = eINSTANCE.getPathNameExp_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimpleNameExpImpl <em>Simple Name Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.SimpleNameExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getSimpleNameExp()
     * @generated
     */
    EClass SIMPLE_NAME_EXP = eINSTANCE.getSimpleNameExp();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_NAME_EXP__ELEMENT = eINSTANCE.getSimpleNameExp_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.IfExpImpl <em>If Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.IfExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getIfExp()
     * @generated
     */
    EClass IF_EXP = eINSTANCE.getIfExp();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_EXP__CONDITION = eINSTANCE.getIfExp_Condition();

    /**
     * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_EXP__THEN_EXPRESSION = eINSTANCE.getIfExp_ThenExpression();

    /**
     * The meta object literal for the '<em><b>Else Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_EXP__ELSE_EXPRESSION = eINSTANCE.getIfExp_ElseExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.LetExpImpl <em>Let Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.LetExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getLetExp()
     * @generated
     */
    EClass LET_EXP = eINSTANCE.getLetExp();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_EXP__VARIABLE = eINSTANCE.getLetExp_Variable();

    /**
     * The meta object literal for the '<em><b>In</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_EXP__IN = eINSTANCE.getLetExp_In();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.LetVariableImpl <em>Let Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.LetVariableImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getLetVariable()
     * @generated
     */
    EClass LET_VARIABLE = eINSTANCE.getLetVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LET_VARIABLE__NAME = eINSTANCE.getLetVariable_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_VARIABLE__TYPE = eINSTANCE.getLetVariable_Type();

    /**
     * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_VARIABLE__INIT_EXPRESSION = eINSTANCE.getLetVariable_InitExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InfixExpImpl <em>Infix Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.InfixExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getInfixExp()
     * @generated
     */
    EClass INFIX_EXP = eINSTANCE.getInfixExp();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INFIX_EXP__SOURCE = eINSTANCE.getInfixExp_Source();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INFIX_EXP__OP = eINSTANCE.getInfixExp_Op();

    /**
     * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INFIX_EXP__ARGUMENT = eINSTANCE.getInfixExp_Argument();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OclMessageImpl <em>Ocl Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OclMessageImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getOclMessage()
     * @generated
     */
    EClass OCL_MESSAGE = eINSTANCE.getOclMessage();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OCL_MESSAGE__SOURCE = eINSTANCE.getOclMessage_Source();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OCL_MESSAGE__OP = eINSTANCE.getOclMessage_Op();

    /**
     * The meta object literal for the '<em><b>Message Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OCL_MESSAGE__MESSAGE_NAME = eINSTANCE.getOclMessage_MessageName();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OCL_MESSAGE__ARGUMENTS = eINSTANCE.getOclMessage_Arguments();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PrefixExpImpl <em>Prefix Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.PrefixExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getPrefixExp()
     * @generated
     */
    EClass PREFIX_EXP = eINSTANCE.getPrefixExp();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREFIX_EXP__OP = eINSTANCE.getPrefixExp_Op();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREFIX_EXP__SOURCE = eINSTANCE.getPrefixExp_Source();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NestedExpImpl <em>Nested Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.NestedExpImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.BacktrackingContentAssistTestPackageImpl#getNestedExp()
     * @generated
     */
    EClass NESTED_EXP = eINSTANCE.getNestedExp();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED_EXP__SOURCE = eINSTANCE.getNestedExp_Source();

  }

} //BacktrackingContentAssistTestPackage
