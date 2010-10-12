/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.css.xcss;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.xbase.XbasePackage;

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
 * @see org.eclipse.xtext.example.css.xcss.XcssFactory
 * @model kind="package"
 * @generated
 */
public interface XcssPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "xcss";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/example/css/Xcss";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "xcss";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XcssPackage eINSTANCE = org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.StyleSheetImpl <em>Style Sheet</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.StyleSheetImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getStyleSheet()
   * @generated
   */
  int STYLE_SHEET = 0;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STYLE_SHEET__RULES = 0;

  /**
   * The number of structural features of the '<em>Style Sheet</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STYLE_SHEET_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.StyleRuleImpl <em>Style Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.StyleRuleImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getStyleRule()
   * @generated
   */
  int STYLE_RULE = 1;

  /**
   * The feature id for the '<em><b>Selectors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STYLE_RULE__SELECTORS = 0;

  /**
   * The feature id for the '<em><b>Settings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STYLE_RULE__SETTINGS = 1;

  /**
   * The number of structural features of the '<em>Style Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STYLE_RULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.SelectorImpl <em>Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.SelectorImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getSelector()
   * @generated
   */
  int SELECTOR = 2;

  /**
   * The feature id for the '<em><b>Filter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTOR__FILTER = 0;

  /**
   * The number of structural features of the '<em>Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.TypeSelectorImpl <em>Type Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.TypeSelectorImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getTypeSelector()
   * @generated
   */
  int TYPE_SELECTOR = 3;

  /**
   * The feature id for the '<em><b>Filter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SELECTOR__FILTER = SELECTOR__FILTER;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SELECTOR__TYPE = SELECTOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SELECTOR_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.WildcardSelectorImpl <em>Wildcard Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.WildcardSelectorImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getWildcardSelector()
   * @generated
   */
  int WILDCARD_SELECTOR = 4;

  /**
   * The feature id for the '<em><b>Filter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WILDCARD_SELECTOR__FILTER = SELECTOR__FILTER;

  /**
   * The number of structural features of the '<em>Wildcard Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WILDCARD_SELECTOR_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.FilterImpl <em>Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.FilterImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getFilter()
   * @generated
   */
  int FILTER = 5;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILTER__CONDITION = 0;

  /**
   * The number of structural features of the '<em>Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILTER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.FontLiteralImpl <em>Font Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.FontLiteralImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getFontLiteral()
   * @generated
   */
  int FONT_LITERAL = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT_LITERAL__NAME = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Italic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT_LITERAL__ITALIC = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Bold</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT_LITERAL__BOLD = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT_LITERAL__SIZE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Font Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT_LITERAL_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.ColorLiteralImpl <em>Color Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.ColorLiteralImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getColorLiteral()
   * @generated
   */
  int COLOR_LITERAL = 7;

  /**
   * The number of structural features of the '<em>Color Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_LITERAL_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.ColorConstantImpl <em>Color Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.ColorConstantImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getColorConstant()
   * @generated
   */
  int COLOR_CONSTANT = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_CONSTANT__NAME = COLOR_LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Color Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_CONSTANT_FEATURE_COUNT = COLOR_LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.RGBImpl <em>RGB</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.RGBImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getRGB()
   * @generated
   */
  int RGB = 9;

  /**
   * The feature id for the '<em><b>Color</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB__COLOR = COLOR_LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>RGB</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB_FEATURE_COUNT = COLOR_LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.SizeLiteralImpl <em>Size Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.SizeLiteralImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getSizeLiteral()
   * @generated
   */
  int SIZE_LITERAL = 10;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIZE_LITERAL__VALUE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIZE_LITERAL__UNIT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Size Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIZE_LITERAL_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.SettingImpl <em>Setting</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.SettingImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getSetting()
   * @generated
   */
  int SETTING = 11;

  /**
   * The feature id for the '<em><b>Feature Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SETTING__FEATURE_NAME = XbasePackage.XBINARY_OPERATION__FEATURE_NAME;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SETTING__PARAMS = XbasePackage.XBINARY_OPERATION__PARAMS;

  /**
   * The feature id for the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SETTING__FEATURE = XbasePackage.XBINARY_OPERATION__FEATURE;

  /**
   * The number of structural features of the '<em>Setting</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SETTING_FEATURE_COUNT = XbasePackage.XBINARY_OPERATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.SizeUnit <em>Size Unit</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.SizeUnit
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getSizeUnit()
   * @generated
   */
  int SIZE_UNIT = 12;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.StyleSheet <em>Style Sheet</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Style Sheet</em>'.
   * @see org.eclipse.xtext.example.css.xcss.StyleSheet
   * @generated
   */
  EClass getStyleSheet();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.example.css.xcss.StyleSheet#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.eclipse.xtext.example.css.xcss.StyleSheet#getRules()
   * @see #getStyleSheet()
   * @generated
   */
  EReference getStyleSheet_Rules();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.StyleRule <em>Style Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Style Rule</em>'.
   * @see org.eclipse.xtext.example.css.xcss.StyleRule
   * @generated
   */
  EClass getStyleRule();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.example.css.xcss.StyleRule#getSelectors <em>Selectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Selectors</em>'.
   * @see org.eclipse.xtext.example.css.xcss.StyleRule#getSelectors()
   * @see #getStyleRule()
   * @generated
   */
  EReference getStyleRule_Selectors();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.example.css.xcss.StyleRule#getSettings <em>Settings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Settings</em>'.
   * @see org.eclipse.xtext.example.css.xcss.StyleRule#getSettings()
   * @see #getStyleRule()
   * @generated
   */
  EReference getStyleRule_Settings();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.Selector <em>Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selector</em>'.
   * @see org.eclipse.xtext.example.css.xcss.Selector
   * @generated
   */
  EClass getSelector();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.example.css.xcss.Selector#getFilter <em>Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Filter</em>'.
   * @see org.eclipse.xtext.example.css.xcss.Selector#getFilter()
   * @see #getSelector()
   * @generated
   */
  EReference getSelector_Filter();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.TypeSelector <em>Type Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Selector</em>'.
   * @see org.eclipse.xtext.example.css.xcss.TypeSelector
   * @generated
   */
  EClass getTypeSelector();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.example.css.xcss.TypeSelector#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.example.css.xcss.TypeSelector#getType()
   * @see #getTypeSelector()
   * @generated
   */
  EReference getTypeSelector_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.WildcardSelector <em>Wildcard Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Wildcard Selector</em>'.
   * @see org.eclipse.xtext.example.css.xcss.WildcardSelector
   * @generated
   */
  EClass getWildcardSelector();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.Filter <em>Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Filter</em>'.
   * @see org.eclipse.xtext.example.css.xcss.Filter
   * @generated
   */
  EClass getFilter();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.example.css.xcss.Filter#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.eclipse.xtext.example.css.xcss.Filter#getCondition()
   * @see #getFilter()
   * @generated
   */
  EReference getFilter_Condition();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.FontLiteral <em>Font Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Font Literal</em>'.
   * @see org.eclipse.xtext.example.css.xcss.FontLiteral
   * @generated
   */
  EClass getFontLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.FontLiteral#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.example.css.xcss.FontLiteral#getName()
   * @see #getFontLiteral()
   * @generated
   */
  EAttribute getFontLiteral_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.FontLiteral#isItalic <em>Italic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Italic</em>'.
   * @see org.eclipse.xtext.example.css.xcss.FontLiteral#isItalic()
   * @see #getFontLiteral()
   * @generated
   */
  EAttribute getFontLiteral_Italic();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.FontLiteral#isBold <em>Bold</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bold</em>'.
   * @see org.eclipse.xtext.example.css.xcss.FontLiteral#isBold()
   * @see #getFontLiteral()
   * @generated
   */
  EAttribute getFontLiteral_Bold();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.FontLiteral#isSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size</em>'.
   * @see org.eclipse.xtext.example.css.xcss.FontLiteral#isSize()
   * @see #getFontLiteral()
   * @generated
   */
  EAttribute getFontLiteral_Size();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.ColorLiteral <em>Color Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Color Literal</em>'.
   * @see org.eclipse.xtext.example.css.xcss.ColorLiteral
   * @generated
   */
  EClass getColorLiteral();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.ColorConstant <em>Color Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Color Constant</em>'.
   * @see org.eclipse.xtext.example.css.xcss.ColorConstant
   * @generated
   */
  EClass getColorConstant();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.ColorConstant#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.example.css.xcss.ColorConstant#getName()
   * @see #getColorConstant()
   * @generated
   */
  EAttribute getColorConstant_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.RGB <em>RGB</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RGB</em>'.
   * @see org.eclipse.xtext.example.css.xcss.RGB
   * @generated
   */
  EClass getRGB();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.RGB#getColor <em>Color</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Color</em>'.
   * @see org.eclipse.xtext.example.css.xcss.RGB#getColor()
   * @see #getRGB()
   * @generated
   */
  EAttribute getRGB_Color();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.SizeLiteral <em>Size Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Size Literal</em>'.
   * @see org.eclipse.xtext.example.css.xcss.SizeLiteral
   * @generated
   */
  EClass getSizeLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.SizeLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.example.css.xcss.SizeLiteral#getValue()
   * @see #getSizeLiteral()
   * @generated
   */
  EAttribute getSizeLiteral_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.SizeLiteral#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.eclipse.xtext.example.css.xcss.SizeLiteral#getUnit()
   * @see #getSizeLiteral()
   * @generated
   */
  EAttribute getSizeLiteral_Unit();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.Setting <em>Setting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Setting</em>'.
   * @see org.eclipse.xtext.example.css.xcss.Setting
   * @generated
   */
  EClass getSetting();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.example.css.xcss.SizeUnit <em>Size Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Size Unit</em>'.
   * @see org.eclipse.xtext.example.css.xcss.SizeUnit
   * @generated
   */
  EEnum getSizeUnit();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  XcssFactory getXcssFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.StyleSheetImpl <em>Style Sheet</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.StyleSheetImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getStyleSheet()
     * @generated
     */
    EClass STYLE_SHEET = eINSTANCE.getStyleSheet();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STYLE_SHEET__RULES = eINSTANCE.getStyleSheet_Rules();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.StyleRuleImpl <em>Style Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.StyleRuleImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getStyleRule()
     * @generated
     */
    EClass STYLE_RULE = eINSTANCE.getStyleRule();

    /**
     * The meta object literal for the '<em><b>Selectors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STYLE_RULE__SELECTORS = eINSTANCE.getStyleRule_Selectors();

    /**
     * The meta object literal for the '<em><b>Settings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STYLE_RULE__SETTINGS = eINSTANCE.getStyleRule_Settings();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.SelectorImpl <em>Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.SelectorImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getSelector()
     * @generated
     */
    EClass SELECTOR = eINSTANCE.getSelector();

    /**
     * The meta object literal for the '<em><b>Filter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTOR__FILTER = eINSTANCE.getSelector_Filter();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.TypeSelectorImpl <em>Type Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.TypeSelectorImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getTypeSelector()
     * @generated
     */
    EClass TYPE_SELECTOR = eINSTANCE.getTypeSelector();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_SELECTOR__TYPE = eINSTANCE.getTypeSelector_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.WildcardSelectorImpl <em>Wildcard Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.WildcardSelectorImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getWildcardSelector()
     * @generated
     */
    EClass WILDCARD_SELECTOR = eINSTANCE.getWildcardSelector();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.FilterImpl <em>Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.FilterImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getFilter()
     * @generated
     */
    EClass FILTER = eINSTANCE.getFilter();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILTER__CONDITION = eINSTANCE.getFilter_Condition();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.FontLiteralImpl <em>Font Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.FontLiteralImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getFontLiteral()
     * @generated
     */
    EClass FONT_LITERAL = eINSTANCE.getFontLiteral();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FONT_LITERAL__NAME = eINSTANCE.getFontLiteral_Name();

    /**
     * The meta object literal for the '<em><b>Italic</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FONT_LITERAL__ITALIC = eINSTANCE.getFontLiteral_Italic();

    /**
     * The meta object literal for the '<em><b>Bold</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FONT_LITERAL__BOLD = eINSTANCE.getFontLiteral_Bold();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FONT_LITERAL__SIZE = eINSTANCE.getFontLiteral_Size();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.ColorLiteralImpl <em>Color Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.ColorLiteralImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getColorLiteral()
     * @generated
     */
    EClass COLOR_LITERAL = eINSTANCE.getColorLiteral();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.ColorConstantImpl <em>Color Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.ColorConstantImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getColorConstant()
     * @generated
     */
    EClass COLOR_CONSTANT = eINSTANCE.getColorConstant();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLOR_CONSTANT__NAME = eINSTANCE.getColorConstant_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.RGBImpl <em>RGB</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.RGBImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getRGB()
     * @generated
     */
    EClass RGB = eINSTANCE.getRGB();

    /**
     * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB__COLOR = eINSTANCE.getRGB_Color();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.SizeLiteralImpl <em>Size Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.SizeLiteralImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getSizeLiteral()
     * @generated
     */
    EClass SIZE_LITERAL = eINSTANCE.getSizeLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIZE_LITERAL__VALUE = eINSTANCE.getSizeLiteral_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIZE_LITERAL__UNIT = eINSTANCE.getSizeLiteral_Unit();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.SettingImpl <em>Setting</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.SettingImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getSetting()
     * @generated
     */
    EClass SETTING = eINSTANCE.getSetting();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.SizeUnit <em>Size Unit</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.SizeUnit
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getSizeUnit()
     * @generated
     */
    EEnum SIZE_UNIT = eINSTANCE.getSizeUnit();

  }

} //XcssPackage
