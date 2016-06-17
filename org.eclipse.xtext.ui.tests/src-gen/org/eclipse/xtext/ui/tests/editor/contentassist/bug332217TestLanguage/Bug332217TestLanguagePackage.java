/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug332217TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug332217TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2011/bug332217TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug332217TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug332217TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.PropertyPathPartImpl <em>Property Path Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.PropertyPathPartImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getPropertyPathPart()
   * @generated
   */
  int PROPERTY_PATH_PART = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_PATH_PART__NAME = 0;

  /**
   * The number of structural features of the '<em>Property Path Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_PATH_PART_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.TypeDescriptionImpl <em>Type Description</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.TypeDescriptionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getTypeDescription()
   * @generated
   */
  int TYPE_DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DESCRIPTION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DESCRIPTION__MANY = 1;

  /**
   * The number of structural features of the '<em>Type Description</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DESCRIPTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ParameterImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = PROPERTY_PATH_PART__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__DESCRIPTION = PROPERTY_PATH_PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = PROPERTY_PATH_PART_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ExpressionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 5;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ObjectReferenceImpl <em>Object Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ObjectReferenceImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getObjectReference()
   * @generated
   */
  int OBJECT_REFERENCE = 4;

  /**
   * The feature id for the '<em><b>Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REFERENCE__OBJECT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REFERENCE__TAIL = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Object Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ScalarExpressionImpl <em>Scalar Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ScalarExpressionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getScalarExpression()
   * @generated
   */
  int SCALAR_EXPRESSION = 6;

  /**
   * The number of structural features of the '<em>Scalar Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCALAR_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionExpressionImpl <em>Collection Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionExpressionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCollectionExpression()
   * @generated
   */
  int COLLECTION_EXPRESSION = 7;

  /**
   * The number of structural features of the '<em>Collection Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringLiteralImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getStringLiteral()
   * @generated
   */
  int STRING_LITERAL = 8;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringFunctionImpl <em>String Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringFunctionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getStringFunction()
   * @generated
   */
  int STRING_FUNCTION = 9;

  /**
   * The number of structural features of the '<em>String Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionLiteralImpl <em>Collection Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionLiteralImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCollectionLiteral()
   * @generated
   */
  int COLLECTION_LITERAL = 10;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL__ITEMS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Collection Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionFunctionImpl <em>Collection Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionFunctionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCollectionFunction()
   * @generated
   */
  int COLLECTION_FUNCTION = 11;

  /**
   * The number of structural features of the '<em>Collection Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.TableViewImpl <em>Table View</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.TableViewImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getTableView()
   * @generated
   */
  int TABLE_VIEW = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_VIEW__NAME = 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_VIEW__CONTENT = 1;

  /**
   * The feature id for the '<em><b>Title</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_VIEW__TITLE = 2;

  /**
   * The feature id for the '<em><b>Title Image</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_VIEW__TITLE_IMAGE = 3;

  /**
   * The feature id for the '<em><b>Style</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_VIEW__STYLE = 4;

  /**
   * The feature id for the '<em><b>Sections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_VIEW__SECTIONS = 5;

  /**
   * The number of structural features of the '<em>Table View</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_VIEW_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ViewContentElementImpl <em>View Content Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ViewContentElementImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getViewContentElement()
   * @generated
   */
  int VIEW_CONTENT_ELEMENT = 13;

  /**
   * The feature id for the '<em><b>Iterator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW_CONTENT_ELEMENT__ITERATOR = 0;

  /**
   * The number of structural features of the '<em>View Content Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW_CONTENT_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.SectionImpl <em>Section</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.SectionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getSection()
   * @generated
   */
  int SECTION = 14;

  /**
   * The feature id for the '<em><b>Iterator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECTION__ITERATOR = VIEW_CONTENT_ELEMENT__ITERATOR;

  /**
   * The feature id for the '<em><b>Title</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECTION__TITLE = VIEW_CONTENT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Cells</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECTION__CELLS = VIEW_CONTENT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Section</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECTION_FEATURE_COUNT = VIEW_CONTENT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CellImpl <em>Cell</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CellImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCell()
   * @generated
   */
  int CELL = 15;

  /**
   * The feature id for the '<em><b>Iterator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CELL__ITERATOR = VIEW_CONTENT_ELEMENT__ITERATOR;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CELL__TYPE = VIEW_CONTENT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Text</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CELL__TEXT = VIEW_CONTENT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Details</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CELL__DETAILS = VIEW_CONTENT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Image</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CELL__IMAGE = VIEW_CONTENT_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CELL__ACTION = VIEW_CONTENT_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Accessory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CELL__ACCESSORY = VIEW_CONTENT_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Cell</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CELL_FEATURE_COUNT = VIEW_CONTENT_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionIteratorImpl <em>Collection Iterator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionIteratorImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCollectionIterator()
   * @generated
   */
  int COLLECTION_ITERATOR = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_ITERATOR__NAME = PROPERTY_PATH_PART__NAME;

  /**
   * The feature id for the '<em><b>Collection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_ITERATOR__COLLECTION = PROPERTY_PATH_PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Collection Iterator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_ITERATOR_FEATURE_COUNT = PROPERTY_PATH_PART_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ViewActionImpl <em>View Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ViewActionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getViewAction()
   * @generated
   */
  int VIEW_ACTION = 17;

  /**
   * The number of structural features of the '<em>View Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW_ACTION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.SelectorImpl <em>Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.SelectorImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getSelector()
   * @generated
   */
  int SELECTOR = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTOR__NAME = VIEW_ACTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTOR_FEATURE_COUNT = VIEW_ACTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ExternalOpenImpl <em>External Open</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ExternalOpenImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getExternalOpen()
   * @generated
   */
  int EXTERNAL_OPEN = 19;

  /**
   * The feature id for the '<em><b>Url</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_OPEN__URL = VIEW_ACTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>External Open</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_OPEN_FEATURE_COUNT = VIEW_ACTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringConcatImpl <em>String Concat</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringConcatImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getStringConcat()
   * @generated
   */
  int STRING_CONCAT = 20;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_CONCAT__VALUES = STRING_FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Concat</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_CONCAT_FEATURE_COUNT = STRING_FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringReplaceImpl <em>String Replace</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringReplaceImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getStringReplace()
   * @generated
   */
  int STRING_REPLACE = 21;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_REPLACE__VALUE = STRING_FUNCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Match</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_REPLACE__MATCH = STRING_FUNCTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Replacement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_REPLACE__REPLACEMENT = STRING_FUNCTION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>String Replace</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_REPLACE_FEATURE_COUNT = STRING_FUNCTION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringUrlConformImpl <em>String Url Conform</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringUrlConformImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getStringUrlConform()
   * @generated
   */
  int STRING_URL_CONFORM = 22;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_URL_CONFORM__VALUE = STRING_FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Url Conform</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_URL_CONFORM_FEATURE_COUNT = STRING_FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringSplitImpl <em>String Split</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringSplitImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getStringSplit()
   * @generated
   */
  int STRING_SPLIT = 23;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_SPLIT__VALUE = COLLECTION_FUNCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Delimiter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_SPLIT__DELIMITER = COLLECTION_FUNCTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>String Split</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_SPLIT_FEATURE_COUNT = COLLECTION_FUNCTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableViewStyle <em>Table View Style</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableViewStyle
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getTableViewStyle()
   * @generated
   */
  int TABLE_VIEW_STYLE = 24;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellType <em>Cell Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellType
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCellType()
   * @generated
   */
  int CELL_TYPE = 25;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellAccessory <em>Cell Accessory</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellAccessory
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCellAccessory()
   * @generated
   */
  int CELL_ACCESSORY = 26;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Model#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Model#getElements()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.PropertyPathPart <em>Property Path Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Path Part</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.PropertyPathPart
   * @generated
   */
  EClass getPropertyPathPart();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.PropertyPathPart#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.PropertyPathPart#getName()
   * @see #getPropertyPathPart()
   * @generated
   */
  EAttribute getPropertyPathPart_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TypeDescription <em>Type Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Description</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TypeDescription
   * @generated
   */
  EClass getTypeDescription();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TypeDescription#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TypeDescription#getType()
   * @see #getTypeDescription()
   * @generated
   */
  EAttribute getTypeDescription_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TypeDescription#isMany <em>Many</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Many</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TypeDescription#isMany()
   * @see #getTypeDescription()
   * @generated
   */
  EAttribute getTypeDescription_Many();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Parameter#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Parameter#getDescription()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Description();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ObjectReference <em>Object Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Reference</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ObjectReference
   * @generated
   */
  EClass getObjectReference();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ObjectReference#getObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Object</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ObjectReference#getObject()
   * @see #getObjectReference()
   * @generated
   */
  EReference getObjectReference_Object();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ObjectReference#getTail <em>Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tail</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ObjectReference#getTail()
   * @see #getObjectReference()
   * @generated
   */
  EReference getObjectReference_Tail();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ScalarExpression <em>Scalar Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scalar Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ScalarExpression
   * @generated
   */
  EClass getScalarExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionExpression <em>Collection Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionExpression
   * @generated
   */
  EClass getCollectionExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringLiteral
   * @generated
   */
  EClass getStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringLiteral#getValue()
   * @see #getStringLiteral()
   * @generated
   */
  EAttribute getStringLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringFunction <em>String Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Function</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringFunction
   * @generated
   */
  EClass getStringFunction();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionLiteral <em>Collection Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Literal</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionLiteral
   * @generated
   */
  EClass getCollectionLiteral();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionLiteral#getItems <em>Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Items</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionLiteral#getItems()
   * @see #getCollectionLiteral()
   * @generated
   */
  EReference getCollectionLiteral_Items();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionFunction <em>Collection Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Function</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionFunction
   * @generated
   */
  EClass getCollectionFunction();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView <em>Table View</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Table View</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView
   * @generated
   */
  EClass getTableView();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getName()
   * @see #getTableView()
   * @generated
   */
  EAttribute getTableView_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Content</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getContent()
   * @see #getTableView()
   * @generated
   */
  EReference getTableView_Content();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Title</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getTitle()
   * @see #getTableView()
   * @generated
   */
  EReference getTableView_Title();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getTitleImage <em>Title Image</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Title Image</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getTitleImage()
   * @see #getTableView()
   * @generated
   */
  EReference getTableView_TitleImage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getStyle <em>Style</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Style</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getStyle()
   * @see #getTableView()
   * @generated
   */
  EAttribute getTableView_Style();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getSections <em>Sections</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sections</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView#getSections()
   * @see #getTableView()
   * @generated
   */
  EReference getTableView_Sections();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewContentElement <em>View Content Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>View Content Element</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewContentElement
   * @generated
   */
  EClass getViewContentElement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewContentElement#getIterator <em>Iterator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Iterator</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewContentElement#getIterator()
   * @see #getViewContentElement()
   * @generated
   */
  EReference getViewContentElement_Iterator();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Section <em>Section</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Section</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Section
   * @generated
   */
  EClass getSection();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Section#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Title</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Section#getTitle()
   * @see #getSection()
   * @generated
   */
  EReference getSection_Title();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Section#getCells <em>Cells</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Cells</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Section#getCells()
   * @see #getSection()
   * @generated
   */
  EReference getSection_Cells();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell <em>Cell</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cell</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell
   * @generated
   */
  EClass getCell();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell#getType()
   * @see #getCell()
   * @generated
   */
  EAttribute getCell_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Text</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell#getText()
   * @see #getCell()
   * @generated
   */
  EReference getCell_Text();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell#getDetails <em>Details</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Details</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell#getDetails()
   * @see #getCell()
   * @generated
   */
  EReference getCell_Details();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell#getImage <em>Image</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Image</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell#getImage()
   * @see #getCell()
   * @generated
   */
  EReference getCell_Image();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell#getAction()
   * @see #getCell()
   * @generated
   */
  EReference getCell_Action();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell#getAccessory <em>Accessory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Accessory</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell#getAccessory()
   * @see #getCell()
   * @generated
   */
  EAttribute getCell_Accessory();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionIterator <em>Collection Iterator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Iterator</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionIterator
   * @generated
   */
  EClass getCollectionIterator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionIterator#getCollection <em>Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Collection</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionIterator#getCollection()
   * @see #getCollectionIterator()
   * @generated
   */
  EReference getCollectionIterator_Collection();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewAction <em>View Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>View Action</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewAction
   * @generated
   */
  EClass getViewAction();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Selector <em>Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selector</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Selector
   * @generated
   */
  EClass getSelector();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Selector#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Selector#getName()
   * @see #getSelector()
   * @generated
   */
  EAttribute getSelector_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ExternalOpen <em>External Open</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Open</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ExternalOpen
   * @generated
   */
  EClass getExternalOpen();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ExternalOpen#getUrl <em>Url</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Url</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ExternalOpen#getUrl()
   * @see #getExternalOpen()
   * @generated
   */
  EReference getExternalOpen_Url();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringConcat <em>String Concat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Concat</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringConcat
   * @generated
   */
  EClass getStringConcat();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringConcat#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringConcat#getValues()
   * @see #getStringConcat()
   * @generated
   */
  EReference getStringConcat_Values();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringReplace <em>String Replace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Replace</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringReplace
   * @generated
   */
  EClass getStringReplace();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringReplace#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringReplace#getValue()
   * @see #getStringReplace()
   * @generated
   */
  EReference getStringReplace_Value();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringReplace#getMatch <em>Match</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Match</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringReplace#getMatch()
   * @see #getStringReplace()
   * @generated
   */
  EReference getStringReplace_Match();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringReplace#getReplacement <em>Replacement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Replacement</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringReplace#getReplacement()
   * @see #getStringReplace()
   * @generated
   */
  EReference getStringReplace_Replacement();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringUrlConform <em>String Url Conform</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Url Conform</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringUrlConform
   * @generated
   */
  EClass getStringUrlConform();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringUrlConform#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringUrlConform#getValue()
   * @see #getStringUrlConform()
   * @generated
   */
  EReference getStringUrlConform_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringSplit <em>String Split</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Split</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringSplit
   * @generated
   */
  EClass getStringSplit();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringSplit#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringSplit#getValue()
   * @see #getStringSplit()
   * @generated
   */
  EReference getStringSplit_Value();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringSplit#getDelimiter <em>Delimiter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Delimiter</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringSplit#getDelimiter()
   * @see #getStringSplit()
   * @generated
   */
  EReference getStringSplit_Delimiter();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableViewStyle <em>Table View Style</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Table View Style</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableViewStyle
   * @generated
   */
  EEnum getTableViewStyle();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellType <em>Cell Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Cell Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellType
   * @generated
   */
  EEnum getCellType();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellAccessory <em>Cell Accessory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Cell Accessory</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellAccessory
   * @generated
   */
  EEnum getCellAccessory();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug332217TestLanguageFactory getBug332217TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ELEMENTS = eINSTANCE.getModel_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.PropertyPathPartImpl <em>Property Path Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.PropertyPathPartImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getPropertyPathPart()
     * @generated
     */
    EClass PROPERTY_PATH_PART = eINSTANCE.getPropertyPathPart();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_PATH_PART__NAME = eINSTANCE.getPropertyPathPart_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.TypeDescriptionImpl <em>Type Description</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.TypeDescriptionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getTypeDescription()
     * @generated
     */
    EClass TYPE_DESCRIPTION = eINSTANCE.getTypeDescription();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_DESCRIPTION__TYPE = eINSTANCE.getTypeDescription_Type();

    /**
     * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_DESCRIPTION__MANY = eINSTANCE.getTypeDescription_Many();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ParameterImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__DESCRIPTION = eINSTANCE.getParameter_Description();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ObjectReferenceImpl <em>Object Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ObjectReferenceImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getObjectReference()
     * @generated
     */
    EClass OBJECT_REFERENCE = eINSTANCE.getObjectReference();

    /**
     * The meta object literal for the '<em><b>Object</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_REFERENCE__OBJECT = eINSTANCE.getObjectReference_Object();

    /**
     * The meta object literal for the '<em><b>Tail</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_REFERENCE__TAIL = eINSTANCE.getObjectReference_Tail();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ExpressionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ScalarExpressionImpl <em>Scalar Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ScalarExpressionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getScalarExpression()
     * @generated
     */
    EClass SCALAR_EXPRESSION = eINSTANCE.getScalarExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionExpressionImpl <em>Collection Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionExpressionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCollectionExpression()
     * @generated
     */
    EClass COLLECTION_EXPRESSION = eINSTANCE.getCollectionExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringLiteralImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getStringLiteral()
     * @generated
     */
    EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringFunctionImpl <em>String Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringFunctionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getStringFunction()
     * @generated
     */
    EClass STRING_FUNCTION = eINSTANCE.getStringFunction();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionLiteralImpl <em>Collection Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionLiteralImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCollectionLiteral()
     * @generated
     */
    EClass COLLECTION_LITERAL = eINSTANCE.getCollectionLiteral();

    /**
     * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_LITERAL__ITEMS = eINSTANCE.getCollectionLiteral_Items();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionFunctionImpl <em>Collection Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionFunctionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCollectionFunction()
     * @generated
     */
    EClass COLLECTION_FUNCTION = eINSTANCE.getCollectionFunction();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.TableViewImpl <em>Table View</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.TableViewImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getTableView()
     * @generated
     */
    EClass TABLE_VIEW = eINSTANCE.getTableView();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TABLE_VIEW__NAME = eINSTANCE.getTableView_Name();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_VIEW__CONTENT = eINSTANCE.getTableView_Content();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_VIEW__TITLE = eINSTANCE.getTableView_Title();

    /**
     * The meta object literal for the '<em><b>Title Image</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_VIEW__TITLE_IMAGE = eINSTANCE.getTableView_TitleImage();

    /**
     * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TABLE_VIEW__STYLE = eINSTANCE.getTableView_Style();

    /**
     * The meta object literal for the '<em><b>Sections</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_VIEW__SECTIONS = eINSTANCE.getTableView_Sections();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ViewContentElementImpl <em>View Content Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ViewContentElementImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getViewContentElement()
     * @generated
     */
    EClass VIEW_CONTENT_ELEMENT = eINSTANCE.getViewContentElement();

    /**
     * The meta object literal for the '<em><b>Iterator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VIEW_CONTENT_ELEMENT__ITERATOR = eINSTANCE.getViewContentElement_Iterator();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.SectionImpl <em>Section</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.SectionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getSection()
     * @generated
     */
    EClass SECTION = eINSTANCE.getSection();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECTION__TITLE = eINSTANCE.getSection_Title();

    /**
     * The meta object literal for the '<em><b>Cells</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECTION__CELLS = eINSTANCE.getSection_Cells();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CellImpl <em>Cell</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CellImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCell()
     * @generated
     */
    EClass CELL = eINSTANCE.getCell();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CELL__TYPE = eINSTANCE.getCell_Type();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CELL__TEXT = eINSTANCE.getCell_Text();

    /**
     * The meta object literal for the '<em><b>Details</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CELL__DETAILS = eINSTANCE.getCell_Details();

    /**
     * The meta object literal for the '<em><b>Image</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CELL__IMAGE = eINSTANCE.getCell_Image();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CELL__ACTION = eINSTANCE.getCell_Action();

    /**
     * The meta object literal for the '<em><b>Accessory</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CELL__ACCESSORY = eINSTANCE.getCell_Accessory();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionIteratorImpl <em>Collection Iterator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionIteratorImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCollectionIterator()
     * @generated
     */
    EClass COLLECTION_ITERATOR = eINSTANCE.getCollectionIterator();

    /**
     * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_ITERATOR__COLLECTION = eINSTANCE.getCollectionIterator_Collection();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ViewActionImpl <em>View Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ViewActionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getViewAction()
     * @generated
     */
    EClass VIEW_ACTION = eINSTANCE.getViewAction();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.SelectorImpl <em>Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.SelectorImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getSelector()
     * @generated
     */
    EClass SELECTOR = eINSTANCE.getSelector();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SELECTOR__NAME = eINSTANCE.getSelector_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ExternalOpenImpl <em>External Open</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.ExternalOpenImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getExternalOpen()
     * @generated
     */
    EClass EXTERNAL_OPEN = eINSTANCE.getExternalOpen();

    /**
     * The meta object literal for the '<em><b>Url</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_OPEN__URL = eINSTANCE.getExternalOpen_Url();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringConcatImpl <em>String Concat</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringConcatImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getStringConcat()
     * @generated
     */
    EClass STRING_CONCAT = eINSTANCE.getStringConcat();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_CONCAT__VALUES = eINSTANCE.getStringConcat_Values();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringReplaceImpl <em>String Replace</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringReplaceImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getStringReplace()
     * @generated
     */
    EClass STRING_REPLACE = eINSTANCE.getStringReplace();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_REPLACE__VALUE = eINSTANCE.getStringReplace_Value();

    /**
     * The meta object literal for the '<em><b>Match</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_REPLACE__MATCH = eINSTANCE.getStringReplace_Match();

    /**
     * The meta object literal for the '<em><b>Replacement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_REPLACE__REPLACEMENT = eINSTANCE.getStringReplace_Replacement();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringUrlConformImpl <em>String Url Conform</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringUrlConformImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getStringUrlConform()
     * @generated
     */
    EClass STRING_URL_CONFORM = eINSTANCE.getStringUrlConform();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_URL_CONFORM__VALUE = eINSTANCE.getStringUrlConform_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringSplitImpl <em>String Split</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.StringSplitImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getStringSplit()
     * @generated
     */
    EClass STRING_SPLIT = eINSTANCE.getStringSplit();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_SPLIT__VALUE = eINSTANCE.getStringSplit_Value();

    /**
     * The meta object literal for the '<em><b>Delimiter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_SPLIT__DELIMITER = eINSTANCE.getStringSplit_Delimiter();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableViewStyle <em>Table View Style</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableViewStyle
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getTableViewStyle()
     * @generated
     */
    EEnum TABLE_VIEW_STYLE = eINSTANCE.getTableViewStyle();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellType <em>Cell Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellType
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCellType()
     * @generated
     */
    EEnum CELL_TYPE = eINSTANCE.getCellType();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellAccessory <em>Cell Accessory</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellAccessory
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.Bug332217TestLanguagePackageImpl#getCellAccessory()
     * @generated
     */
    EEnum CELL_ACCESSORY = eINSTANCE.getCellAccessory();

  }

} //Bug332217TestLanguagePackage
