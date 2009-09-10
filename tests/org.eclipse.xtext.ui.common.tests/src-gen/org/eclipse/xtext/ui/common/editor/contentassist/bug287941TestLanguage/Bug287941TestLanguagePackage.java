/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage;

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
 * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug287941TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug287941TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2009/bug287941TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug287941TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug287941TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__QUERY = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ImportImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getImport()
   * @generated
   */
  int IMPORT = 1;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORT_URI = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.MQLqueryImpl <em>MQ Lquery</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.MQLqueryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getMQLquery()
   * @generated
   */
  int MQ_LQUERY = 2;

  /**
   * The feature id for the '<em><b>Select Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MQ_LQUERY__SELECT_ENTRIES = 0;

  /**
   * The feature id for the '<em><b>From Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MQ_LQUERY__FROM_ENTRIES = 1;

  /**
   * The feature id for the '<em><b>Where Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MQ_LQUERY__WHERE_ENTRIES = 2;

  /**
   * The number of structural features of the '<em>MQ Lquery</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MQ_LQUERY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.SelectEntryImpl <em>Select Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.SelectEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getSelectEntry()
   * @generated
   */
  int SELECT_ENTRY = 3;

  /**
   * The feature id for the '<em><b>Select</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_ENTRY__SELECT = 0;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_ENTRY__ATTRIBUTE = 1;

  /**
   * The number of structural features of the '<em>Select Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_ENTRY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.FromEntryImpl <em>From Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.FromEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getFromEntry()
   * @generated
   */
  int FROM_ENTRY = 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY__TYPE = 0;

  /**
   * The feature id for the '<em><b>Withoutsubtypes</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY__WITHOUTSUBTYPES = 1;

  /**
   * The feature id for the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY__ALIAS = 2;

  /**
   * The feature id for the '<em><b>Scope Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY__SCOPE_CLAUSE = 3;

  /**
   * The number of structural features of the '<em>From Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ScopeClauseImpl <em>Scope Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ScopeClauseImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getScopeClause()
   * @generated
   */
  int SCOPE_CLAUSE = 5;

  /**
   * The feature id for the '<em><b>Not In</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE_CLAUSE__NOT_IN = 0;

  /**
   * The feature id for the '<em><b>Scope</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE_CLAUSE__SCOPE = 1;

  /**
   * The number of structural features of the '<em>Scope Clause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE_CLAUSE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ScopeImpl <em>Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ScopeImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getScope()
   * @generated
   */
  int SCOPE = 6;

  /**
   * The feature id for the '<em><b>Uris</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE__URIS = 0;

  /**
   * The number of structural features of the '<em>Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ResourceScopeImpl <em>Resource Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ResourceScopeImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getResourceScope()
   * @generated
   */
  int RESOURCE_SCOPE = 7;

  /**
   * The feature id for the '<em><b>Uris</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_SCOPE__URIS = SCOPE__URIS;

  /**
   * The number of structural features of the '<em>Resource Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_SCOPE_FEATURE_COUNT = SCOPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ElementScopeImpl <em>Element Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ElementScopeImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getElementScope()
   * @generated
   */
  int ELEMENT_SCOPE = 8;

  /**
   * The feature id for the '<em><b>Uris</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_SCOPE__URIS = SCOPE__URIS;

  /**
   * The number of structural features of the '<em>Element Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_SCOPE_FEATURE_COUNT = SCOPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.WhereEntryImpl <em>Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.WhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getWhereEntry()
   * @generated
   */
  int WHERE_ENTRY = 9;

  /**
   * The number of structural features of the '<em>Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHERE_ENTRY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.AttributeWhereEntryImpl <em>Attribute Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.AttributeWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getAttributeWhereEntry()
   * @generated
   */
  int ATTRIBUTE_WHERE_ENTRY = 10;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_WHERE_ENTRY__ALIAS = WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE = WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Attribute Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT = WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.NumericAttributeWhereEntryImpl <em>Numeric Attribute Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.NumericAttributeWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getNumericAttributeWhereEntry()
   * @generated
   */
  int NUMERIC_ATTRIBUTE_WHERE_ENTRY = 11;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_ATTRIBUTE_WHERE_ENTRY__ALIAS = ATTRIBUTE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE = ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_ATTRIBUTE_WHERE_ENTRY__OPERATOR = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Numeric Attribute Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.DoubleWhereEntryImpl <em>Double Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.DoubleWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getDoubleWhereEntry()
   * @generated
   */
  int DOUBLE_WHERE_ENTRY = 12;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_WHERE_ENTRY__ALIAS = NUMERIC_ATTRIBUTE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_WHERE_ENTRY__ATTRIBUTE = NUMERIC_ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_WHERE_ENTRY__OPERATOR = NUMERIC_ATTRIBUTE_WHERE_ENTRY__OPERATOR;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_WHERE_ENTRY__VALUE = NUMERIC_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Double Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_WHERE_ENTRY_FEATURE_COUNT = NUMERIC_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.LongWhereEntryImpl <em>Long Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.LongWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getLongWhereEntry()
   * @generated
   */
  int LONG_WHERE_ENTRY = 13;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_WHERE_ENTRY__ALIAS = NUMERIC_ATTRIBUTE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_WHERE_ENTRY__ATTRIBUTE = NUMERIC_ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_WHERE_ENTRY__OPERATOR = NUMERIC_ATTRIBUTE_WHERE_ENTRY__OPERATOR;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_WHERE_ENTRY__VALUE = NUMERIC_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Long Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_WHERE_ENTRY_FEATURE_COUNT = NUMERIC_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.VariableWhereEntryImpl <em>Variable Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.VariableWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getVariableWhereEntry()
   * @generated
   */
  int VARIABLE_WHERE_ENTRY = 14;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_WHERE_ENTRY__ALIAS = ATTRIBUTE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_WHERE_ENTRY__ATTRIBUTE = ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_WHERE_ENTRY__OPERATOR = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_WHERE_ENTRY__RIGHT_ALIAS = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_WHERE_ENTRY__RIGHT_ATTRIBUTE = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Variable Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_WHERE_ENTRY_FEATURE_COUNT = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.StringAttributeWhereEntryImpl <em>String Attribute Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.StringAttributeWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getStringAttributeWhereEntry()
   * @generated
   */
  int STRING_ATTRIBUTE_WHERE_ENTRY = 15;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE_WHERE_ENTRY__ALIAS = ATTRIBUTE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE = ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE_WHERE_ENTRY__OPERATOR = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE_WHERE_ENTRY__PATTERN = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>String Attribute Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.BooleanAttributeWhereEntryImpl <em>Boolean Attribute Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.BooleanAttributeWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getBooleanAttributeWhereEntry()
   * @generated
   */
  int BOOLEAN_ATTRIBUTE_WHERE_ENTRY = 16;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE_WHERE_ENTRY__ALIAS = ATTRIBUTE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE = ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE_WHERE_ENTRY__OPERATOR = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Is True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE_WHERE_ENTRY__IS_TRUE = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Boolean Attribute Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.NullWhereEntryImpl <em>Null Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.NullWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getNullWhereEntry()
   * @generated
   */
  int NULL_WHERE_ENTRY = 17;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_WHERE_ENTRY__ALIAS = WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_WHERE_ENTRY__FEATURE = WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_WHERE_ENTRY__OPERATOR = WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Null Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_WHERE_ENTRY_FEATURE_COUNT = WHERE_ENTRY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ReferenceAliasWhereEntryImpl <em>Reference Alias Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ReferenceAliasWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getReferenceAliasWhereEntry()
   * @generated
   */
  int REFERENCE_ALIAS_WHERE_ENTRY = 18;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_ALIAS_WHERE_ENTRY__ALIAS = WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_ALIAS_WHERE_ENTRY__REFERENCE = WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_ALIAS_WHERE_ENTRY__RIGHT_ALIAS = WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Reference Alias Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_ALIAS_WHERE_ENTRY_FEATURE_COUNT = WHERE_ENTRY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.SubselectWhereEntryImpl <em>Subselect Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.SubselectWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getSubselectWhereEntry()
   * @generated
   */
  int SUBSELECT_WHERE_ENTRY = 19;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSELECT_WHERE_ENTRY__ALIAS = WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSELECT_WHERE_ENTRY__REFERENCE = WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Not In</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSELECT_WHERE_ENTRY__NOT_IN = WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Sub Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSELECT_WHERE_ENTRY__SUB_QUERY = WHERE_ENTRY_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Subselect Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSELECT_WHERE_ENTRY_FEATURE_COUNT = WHERE_ENTRY_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.AliasWhereEntryImpl <em>Alias Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.AliasWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getAliasWhereEntry()
   * @generated
   */
  int ALIAS_WHERE_ENTRY = 20;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS_WHERE_ENTRY__ALIAS = WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS_WHERE_ENTRY__RIGHT_ALIAS = WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Alias Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS_WHERE_ENTRY_FEATURE_COUNT = WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.OrWhereEntryImpl <em>Or Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.OrWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getOrWhereEntry()
   * @generated
   */
  int OR_WHERE_ENTRY = 21;

  /**
   * The feature id for the '<em><b>Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_WHERE_ENTRY__ENTRIES = WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Or Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_WHERE_ENTRY_FEATURE_COUNT = WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.AndWhereEntryImpl <em>And Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.AndWhereEntryImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getAndWhereEntry()
   * @generated
   */
  int AND_WHERE_ENTRY = 22;

  /**
   * The feature id for the '<em><b>Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_WHERE_ENTRY__ENTRIES = WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>And Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_WHERE_ENTRY_FEATURE_COUNT = WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericOperator <em>Numeric Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericOperator
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getNumericOperator()
   * @generated
   */
  int NUMERIC_OPERATOR = 23;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringOperator <em>String Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringOperator
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getStringOperator()
   * @generated
   */
  int STRING_OPERATOR = 24;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.BooleanOperator <em>Boolean Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.BooleanOperator
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getBooleanOperator()
   * @generated
   */
  int BOOLEAN_OPERATOR = 25;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Model#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Model#getImports()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Imports();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Model#getQuery <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Query</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Model#getQuery()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Query();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Import#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Import#getImportURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportURI();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery <em>MQ Lquery</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MQ Lquery</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery
   * @generated
   */
  EClass getMQLquery();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery#getSelectEntries <em>Select Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Select Entries</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery#getSelectEntries()
   * @see #getMQLquery()
   * @generated
   */
  EReference getMQLquery_SelectEntries();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery#getFromEntries <em>From Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>From Entries</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery#getFromEntries()
   * @see #getMQLquery()
   * @generated
   */
  EReference getMQLquery_FromEntries();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery#getWhereEntries <em>Where Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Where Entries</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery#getWhereEntries()
   * @see #getMQLquery()
   * @generated
   */
  EReference getMQLquery_WhereEntries();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SelectEntry <em>Select Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Select Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SelectEntry
   * @generated
   */
  EClass getSelectEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SelectEntry#getSelect <em>Select</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Select</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SelectEntry#getSelect()
   * @see #getSelectEntry()
   * @generated
   */
  EReference getSelectEntry_Select();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SelectEntry#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attribute</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SelectEntry#getAttribute()
   * @see #getSelectEntry()
   * @generated
   */
  EReference getSelectEntry_Attribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry <em>From Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>From Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry
   * @generated
   */
  EClass getFromEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry#getType()
   * @see #getFromEntry()
   * @generated
   */
  EReference getFromEntry_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry#isWithoutsubtypes <em>Withoutsubtypes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Withoutsubtypes</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry#isWithoutsubtypes()
   * @see #getFromEntry()
   * @generated
   */
  EAttribute getFromEntry_Withoutsubtypes();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Alias</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry#getAlias()
   * @see #getFromEntry()
   * @generated
   */
  EAttribute getFromEntry_Alias();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry#getScopeClause <em>Scope Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Scope Clause</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry#getScopeClause()
   * @see #getFromEntry()
   * @generated
   */
  EReference getFromEntry_ScopeClause();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ScopeClause <em>Scope Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scope Clause</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ScopeClause
   * @generated
   */
  EClass getScopeClause();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ScopeClause#isNotIn <em>Not In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Not In</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ScopeClause#isNotIn()
   * @see #getScopeClause()
   * @generated
   */
  EAttribute getScopeClause_NotIn();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ScopeClause#getScope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Scope</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ScopeClause#getScope()
   * @see #getScopeClause()
   * @generated
   */
  EReference getScopeClause_Scope();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Scope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scope</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Scope
   * @generated
   */
  EClass getScope();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Scope#getUris <em>Uris</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Uris</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Scope#getUris()
   * @see #getScope()
   * @generated
   */
  EAttribute getScope_Uris();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ResourceScope <em>Resource Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Resource Scope</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ResourceScope
   * @generated
   */
  EClass getResourceScope();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ElementScope <em>Element Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Scope</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ElementScope
   * @generated
   */
  EClass getElementScope();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.WhereEntry <em>Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.WhereEntry
   * @generated
   */
  EClass getWhereEntry();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AttributeWhereEntry <em>Attribute Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AttributeWhereEntry
   * @generated
   */
  EClass getAttributeWhereEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AttributeWhereEntry#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Alias</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AttributeWhereEntry#getAlias()
   * @see #getAttributeWhereEntry()
   * @generated
   */
  EReference getAttributeWhereEntry_Alias();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AttributeWhereEntry#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attribute</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AttributeWhereEntry#getAttribute()
   * @see #getAttributeWhereEntry()
   * @generated
   */
  EReference getAttributeWhereEntry_Attribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericAttributeWhereEntry <em>Numeric Attribute Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numeric Attribute Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericAttributeWhereEntry
   * @generated
   */
  EClass getNumericAttributeWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericAttributeWhereEntry#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericAttributeWhereEntry#getOperator()
   * @see #getNumericAttributeWhereEntry()
   * @generated
   */
  EAttribute getNumericAttributeWhereEntry_Operator();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.DoubleWhereEntry <em>Double Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.DoubleWhereEntry
   * @generated
   */
  EClass getDoubleWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.DoubleWhereEntry#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.DoubleWhereEntry#getValue()
   * @see #getDoubleWhereEntry()
   * @generated
   */
  EAttribute getDoubleWhereEntry_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.LongWhereEntry <em>Long Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Long Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.LongWhereEntry
   * @generated
   */
  EClass getLongWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.LongWhereEntry#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.LongWhereEntry#getValue()
   * @see #getLongWhereEntry()
   * @generated
   */
  EAttribute getLongWhereEntry_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry <em>Variable Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry
   * @generated
   */
  EClass getVariableWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry#getOperator()
   * @see #getVariableWhereEntry()
   * @generated
   */
  EAttribute getVariableWhereEntry_Operator();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry#getRightAlias <em>Right Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right Alias</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry#getRightAlias()
   * @see #getVariableWhereEntry()
   * @generated
   */
  EReference getVariableWhereEntry_RightAlias();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry#getRightAttribute <em>Right Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right Attribute</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry#getRightAttribute()
   * @see #getVariableWhereEntry()
   * @generated
   */
  EReference getVariableWhereEntry_RightAttribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringAttributeWhereEntry <em>String Attribute Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Attribute Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringAttributeWhereEntry
   * @generated
   */
  EClass getStringAttributeWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringAttributeWhereEntry#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringAttributeWhereEntry#getOperator()
   * @see #getStringAttributeWhereEntry()
   * @generated
   */
  EAttribute getStringAttributeWhereEntry_Operator();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringAttributeWhereEntry#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pattern</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringAttributeWhereEntry#getPattern()
   * @see #getStringAttributeWhereEntry()
   * @generated
   */
  EAttribute getStringAttributeWhereEntry_Pattern();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.BooleanAttributeWhereEntry <em>Boolean Attribute Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Attribute Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.BooleanAttributeWhereEntry
   * @generated
   */
  EClass getBooleanAttributeWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.BooleanAttributeWhereEntry#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.BooleanAttributeWhereEntry#getOperator()
   * @see #getBooleanAttributeWhereEntry()
   * @generated
   */
  EAttribute getBooleanAttributeWhereEntry_Operator();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.BooleanAttributeWhereEntry#isIsTrue <em>Is True</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is True</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.BooleanAttributeWhereEntry#isIsTrue()
   * @see #getBooleanAttributeWhereEntry()
   * @generated
   */
  EAttribute getBooleanAttributeWhereEntry_IsTrue();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NullWhereEntry <em>Null Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NullWhereEntry
   * @generated
   */
  EClass getNullWhereEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NullWhereEntry#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Alias</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NullWhereEntry#getAlias()
   * @see #getNullWhereEntry()
   * @generated
   */
  EReference getNullWhereEntry_Alias();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NullWhereEntry#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Feature</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NullWhereEntry#getFeature()
   * @see #getNullWhereEntry()
   * @generated
   */
  EReference getNullWhereEntry_Feature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NullWhereEntry#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NullWhereEntry#getOperator()
   * @see #getNullWhereEntry()
   * @generated
   */
  EAttribute getNullWhereEntry_Operator();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ReferenceAliasWhereEntry <em>Reference Alias Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Alias Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ReferenceAliasWhereEntry
   * @generated
   */
  EClass getReferenceAliasWhereEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ReferenceAliasWhereEntry#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Alias</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ReferenceAliasWhereEntry#getAlias()
   * @see #getReferenceAliasWhereEntry()
   * @generated
   */
  EReference getReferenceAliasWhereEntry_Alias();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ReferenceAliasWhereEntry#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Reference</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ReferenceAliasWhereEntry#getReference()
   * @see #getReferenceAliasWhereEntry()
   * @generated
   */
  EReference getReferenceAliasWhereEntry_Reference();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ReferenceAliasWhereEntry#getRightAlias <em>Right Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right Alias</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.ReferenceAliasWhereEntry#getRightAlias()
   * @see #getReferenceAliasWhereEntry()
   * @generated
   */
  EReference getReferenceAliasWhereEntry_RightAlias();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry <em>Subselect Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subselect Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry
   * @generated
   */
  EClass getSubselectWhereEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Alias</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#getAlias()
   * @see #getSubselectWhereEntry()
   * @generated
   */
  EReference getSubselectWhereEntry_Alias();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Reference</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#getReference()
   * @see #getSubselectWhereEntry()
   * @generated
   */
  EReference getSubselectWhereEntry_Reference();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#isNotIn <em>Not In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Not In</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#isNotIn()
   * @see #getSubselectWhereEntry()
   * @generated
   */
  EAttribute getSubselectWhereEntry_NotIn();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#getSubQuery <em>Sub Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Query</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#getSubQuery()
   * @see #getSubselectWhereEntry()
   * @generated
   */
  EReference getSubselectWhereEntry_SubQuery();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AliasWhereEntry <em>Alias Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alias Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AliasWhereEntry
   * @generated
   */
  EClass getAliasWhereEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AliasWhereEntry#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Alias</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AliasWhereEntry#getAlias()
   * @see #getAliasWhereEntry()
   * @generated
   */
  EReference getAliasWhereEntry_Alias();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AliasWhereEntry#getRightAlias <em>Right Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right Alias</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AliasWhereEntry#getRightAlias()
   * @see #getAliasWhereEntry()
   * @generated
   */
  EReference getAliasWhereEntry_RightAlias();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.OrWhereEntry <em>Or Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.OrWhereEntry
   * @generated
   */
  EClass getOrWhereEntry();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.OrWhereEntry#getEntries <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entries</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.OrWhereEntry#getEntries()
   * @see #getOrWhereEntry()
   * @generated
   */
  EReference getOrWhereEntry_Entries();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AndWhereEntry <em>And Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Where Entry</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AndWhereEntry
   * @generated
   */
  EClass getAndWhereEntry();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AndWhereEntry#getEntries <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entries</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AndWhereEntry#getEntries()
   * @see #getAndWhereEntry()
   * @generated
   */
  EReference getAndWhereEntry_Entries();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericOperator <em>Numeric Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Numeric Operator</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericOperator
   * @generated
   */
  EEnum getNumericOperator();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringOperator <em>String Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>String Operator</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringOperator
   * @generated
   */
  EEnum getStringOperator();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.BooleanOperator <em>Boolean Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Boolean Operator</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.BooleanOperator
   * @generated
   */
  EEnum getBooleanOperator();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug287941TestLanguageFactory getBug287941TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__IMPORTS = eINSTANCE.getModel_Imports();

    /**
     * The meta object literal for the '<em><b>Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__QUERY = eINSTANCE.getModel_Query();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ImportImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.MQLqueryImpl <em>MQ Lquery</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.MQLqueryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getMQLquery()
     * @generated
     */
    EClass MQ_LQUERY = eINSTANCE.getMQLquery();

    /**
     * The meta object literal for the '<em><b>Select Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MQ_LQUERY__SELECT_ENTRIES = eINSTANCE.getMQLquery_SelectEntries();

    /**
     * The meta object literal for the '<em><b>From Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MQ_LQUERY__FROM_ENTRIES = eINSTANCE.getMQLquery_FromEntries();

    /**
     * The meta object literal for the '<em><b>Where Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MQ_LQUERY__WHERE_ENTRIES = eINSTANCE.getMQLquery_WhereEntries();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.SelectEntryImpl <em>Select Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.SelectEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getSelectEntry()
     * @generated
     */
    EClass SELECT_ENTRY = eINSTANCE.getSelectEntry();

    /**
     * The meta object literal for the '<em><b>Select</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECT_ENTRY__SELECT = eINSTANCE.getSelectEntry_Select();

    /**
     * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECT_ENTRY__ATTRIBUTE = eINSTANCE.getSelectEntry_Attribute();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.FromEntryImpl <em>From Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.FromEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getFromEntry()
     * @generated
     */
    EClass FROM_ENTRY = eINSTANCE.getFromEntry();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FROM_ENTRY__TYPE = eINSTANCE.getFromEntry_Type();

    /**
     * The meta object literal for the '<em><b>Withoutsubtypes</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FROM_ENTRY__WITHOUTSUBTYPES = eINSTANCE.getFromEntry_Withoutsubtypes();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FROM_ENTRY__ALIAS = eINSTANCE.getFromEntry_Alias();

    /**
     * The meta object literal for the '<em><b>Scope Clause</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FROM_ENTRY__SCOPE_CLAUSE = eINSTANCE.getFromEntry_ScopeClause();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ScopeClauseImpl <em>Scope Clause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ScopeClauseImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getScopeClause()
     * @generated
     */
    EClass SCOPE_CLAUSE = eINSTANCE.getScopeClause();

    /**
     * The meta object literal for the '<em><b>Not In</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCOPE_CLAUSE__NOT_IN = eINSTANCE.getScopeClause_NotIn();

    /**
     * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCOPE_CLAUSE__SCOPE = eINSTANCE.getScopeClause_Scope();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ScopeImpl <em>Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ScopeImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getScope()
     * @generated
     */
    EClass SCOPE = eINSTANCE.getScope();

    /**
     * The meta object literal for the '<em><b>Uris</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCOPE__URIS = eINSTANCE.getScope_Uris();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ResourceScopeImpl <em>Resource Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ResourceScopeImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getResourceScope()
     * @generated
     */
    EClass RESOURCE_SCOPE = eINSTANCE.getResourceScope();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ElementScopeImpl <em>Element Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ElementScopeImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getElementScope()
     * @generated
     */
    EClass ELEMENT_SCOPE = eINSTANCE.getElementScope();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.WhereEntryImpl <em>Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.WhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getWhereEntry()
     * @generated
     */
    EClass WHERE_ENTRY = eINSTANCE.getWhereEntry();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.AttributeWhereEntryImpl <em>Attribute Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.AttributeWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getAttributeWhereEntry()
     * @generated
     */
    EClass ATTRIBUTE_WHERE_ENTRY = eINSTANCE.getAttributeWhereEntry();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_WHERE_ENTRY__ALIAS = eINSTANCE.getAttributeWhereEntry_Alias();

    /**
     * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE = eINSTANCE.getAttributeWhereEntry_Attribute();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.NumericAttributeWhereEntryImpl <em>Numeric Attribute Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.NumericAttributeWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getNumericAttributeWhereEntry()
     * @generated
     */
    EClass NUMERIC_ATTRIBUTE_WHERE_ENTRY = eINSTANCE.getNumericAttributeWhereEntry();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERIC_ATTRIBUTE_WHERE_ENTRY__OPERATOR = eINSTANCE.getNumericAttributeWhereEntry_Operator();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.DoubleWhereEntryImpl <em>Double Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.DoubleWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getDoubleWhereEntry()
     * @generated
     */
    EClass DOUBLE_WHERE_ENTRY = eINSTANCE.getDoubleWhereEntry();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOUBLE_WHERE_ENTRY__VALUE = eINSTANCE.getDoubleWhereEntry_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.LongWhereEntryImpl <em>Long Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.LongWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getLongWhereEntry()
     * @generated
     */
    EClass LONG_WHERE_ENTRY = eINSTANCE.getLongWhereEntry();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LONG_WHERE_ENTRY__VALUE = eINSTANCE.getLongWhereEntry_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.VariableWhereEntryImpl <em>Variable Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.VariableWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getVariableWhereEntry()
     * @generated
     */
    EClass VARIABLE_WHERE_ENTRY = eINSTANCE.getVariableWhereEntry();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_WHERE_ENTRY__OPERATOR = eINSTANCE.getVariableWhereEntry_Operator();

    /**
     * The meta object literal for the '<em><b>Right Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_WHERE_ENTRY__RIGHT_ALIAS = eINSTANCE.getVariableWhereEntry_RightAlias();

    /**
     * The meta object literal for the '<em><b>Right Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_WHERE_ENTRY__RIGHT_ATTRIBUTE = eINSTANCE.getVariableWhereEntry_RightAttribute();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.StringAttributeWhereEntryImpl <em>String Attribute Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.StringAttributeWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getStringAttributeWhereEntry()
     * @generated
     */
    EClass STRING_ATTRIBUTE_WHERE_ENTRY = eINSTANCE.getStringAttributeWhereEntry();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_ATTRIBUTE_WHERE_ENTRY__OPERATOR = eINSTANCE.getStringAttributeWhereEntry_Operator();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_ATTRIBUTE_WHERE_ENTRY__PATTERN = eINSTANCE.getStringAttributeWhereEntry_Pattern();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.BooleanAttributeWhereEntryImpl <em>Boolean Attribute Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.BooleanAttributeWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getBooleanAttributeWhereEntry()
     * @generated
     */
    EClass BOOLEAN_ATTRIBUTE_WHERE_ENTRY = eINSTANCE.getBooleanAttributeWhereEntry();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_ATTRIBUTE_WHERE_ENTRY__OPERATOR = eINSTANCE.getBooleanAttributeWhereEntry_Operator();

    /**
     * The meta object literal for the '<em><b>Is True</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_ATTRIBUTE_WHERE_ENTRY__IS_TRUE = eINSTANCE.getBooleanAttributeWhereEntry_IsTrue();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.NullWhereEntryImpl <em>Null Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.NullWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getNullWhereEntry()
     * @generated
     */
    EClass NULL_WHERE_ENTRY = eINSTANCE.getNullWhereEntry();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NULL_WHERE_ENTRY__ALIAS = eINSTANCE.getNullWhereEntry_Alias();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NULL_WHERE_ENTRY__FEATURE = eINSTANCE.getNullWhereEntry_Feature();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NULL_WHERE_ENTRY__OPERATOR = eINSTANCE.getNullWhereEntry_Operator();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ReferenceAliasWhereEntryImpl <em>Reference Alias Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ReferenceAliasWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getReferenceAliasWhereEntry()
     * @generated
     */
    EClass REFERENCE_ALIAS_WHERE_ENTRY = eINSTANCE.getReferenceAliasWhereEntry();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_ALIAS_WHERE_ENTRY__ALIAS = eINSTANCE.getReferenceAliasWhereEntry_Alias();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_ALIAS_WHERE_ENTRY__REFERENCE = eINSTANCE.getReferenceAliasWhereEntry_Reference();

    /**
     * The meta object literal for the '<em><b>Right Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_ALIAS_WHERE_ENTRY__RIGHT_ALIAS = eINSTANCE.getReferenceAliasWhereEntry_RightAlias();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.SubselectWhereEntryImpl <em>Subselect Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.SubselectWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getSubselectWhereEntry()
     * @generated
     */
    EClass SUBSELECT_WHERE_ENTRY = eINSTANCE.getSubselectWhereEntry();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBSELECT_WHERE_ENTRY__ALIAS = eINSTANCE.getSubselectWhereEntry_Alias();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBSELECT_WHERE_ENTRY__REFERENCE = eINSTANCE.getSubselectWhereEntry_Reference();

    /**
     * The meta object literal for the '<em><b>Not In</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBSELECT_WHERE_ENTRY__NOT_IN = eINSTANCE.getSubselectWhereEntry_NotIn();

    /**
     * The meta object literal for the '<em><b>Sub Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBSELECT_WHERE_ENTRY__SUB_QUERY = eINSTANCE.getSubselectWhereEntry_SubQuery();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.AliasWhereEntryImpl <em>Alias Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.AliasWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getAliasWhereEntry()
     * @generated
     */
    EClass ALIAS_WHERE_ENTRY = eINSTANCE.getAliasWhereEntry();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALIAS_WHERE_ENTRY__ALIAS = eINSTANCE.getAliasWhereEntry_Alias();

    /**
     * The meta object literal for the '<em><b>Right Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALIAS_WHERE_ENTRY__RIGHT_ALIAS = eINSTANCE.getAliasWhereEntry_RightAlias();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.OrWhereEntryImpl <em>Or Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.OrWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getOrWhereEntry()
     * @generated
     */
    EClass OR_WHERE_ENTRY = eINSTANCE.getOrWhereEntry();

    /**
     * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_WHERE_ENTRY__ENTRIES = eINSTANCE.getOrWhereEntry_Entries();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.AndWhereEntryImpl <em>And Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.AndWhereEntryImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getAndWhereEntry()
     * @generated
     */
    EClass AND_WHERE_ENTRY = eINSTANCE.getAndWhereEntry();

    /**
     * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_WHERE_ENTRY__ENTRIES = eINSTANCE.getAndWhereEntry_Entries();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericOperator <em>Numeric Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericOperator
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getNumericOperator()
     * @generated
     */
    EEnum NUMERIC_OPERATOR = eINSTANCE.getNumericOperator();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringOperator <em>String Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringOperator
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getStringOperator()
     * @generated
     */
    EEnum STRING_OPERATOR = eINSTANCE.getStringOperator();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.BooleanOperator <em>Boolean Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.BooleanOperator
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.Bug287941TestLanguagePackageImpl#getBooleanOperator()
     * @generated
     */
    EEnum BOOLEAN_OPERATOR = eINSTANCE.getBooleanOperator();

  }

} //Bug287941TestLanguagePackage
