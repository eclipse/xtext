/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.css.xcss;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.common.types.TypesPackage;

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
  int TYPE_SELECTOR__FILTER = TypesPackage.JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SELECTOR__TYPE = TypesPackage.JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SELECTOR_FEATURE_COUNT = TypesPackage.JVM_TYPE_REFERENCE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.IdSelectorImpl <em>Id Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.IdSelectorImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getIdSelector()
   * @generated
   */
  int ID_SELECTOR = 4;

  /**
   * The feature id for the '<em><b>Filter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_SELECTOR__FILTER = SELECTOR__FILTER;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_SELECTOR__ID = SELECTOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Id Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_SELECTOR_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.WildcardSelectorImpl <em>Wildcard Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.WildcardSelectorImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getWildcardSelector()
   * @generated
   */
  int WILDCARD_SELECTOR = 5;

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
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.ColorLiteralImpl <em>Color Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.ColorLiteralImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getColorLiteral()
   * @generated
   */
  int COLOR_LITERAL = 6;

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
  int COLOR_CONSTANT = 7;

  /**
   * The feature id for the '<em><b>Constant</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_CONSTANT__CONSTANT = COLOR_LITERAL_FEATURE_COUNT + 0;

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
  int RGB = 8;

  /**
   * The feature id for the '<em><b>Hex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB__HEX = COLOR_LITERAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB__VALUE = COLOR_LITERAL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Red</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB__RED = COLOR_LITERAL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Green</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB__GREEN = COLOR_LITERAL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Blue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB__BLUE = COLOR_LITERAL_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>RGB</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB_FEATURE_COUNT = COLOR_LITERAL_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.PercentImpl <em>Percent</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.PercentImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getPercent()
   * @generated
   */
  int PERCENT = 9;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERCENT__VALUE = 0;

  /**
   * The number of structural features of the '<em>Percent</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERCENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.css.xcss.impl.GradientImpl <em>Gradient</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.css.xcss.impl.GradientImpl
   * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getGradient()
   * @generated
   */
  int GRADIENT = 10;

  /**
   * The feature id for the '<em><b>Colors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRADIENT__COLORS = COLOR_LITERAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Percents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRADIENT__PERCENTS = COLOR_LITERAL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Gradient</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRADIENT_FEATURE_COUNT = COLOR_LITERAL_FEATURE_COUNT + 2;


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
   * Returns the meta object for the reference '{@link org.eclipse.xtext.example.css.xcss.TypeSelector#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.xtext.example.css.xcss.TypeSelector#getType()
   * @see #getTypeSelector()
   * @generated
   */
  EReference getTypeSelector_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.IdSelector <em>Id Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Id Selector</em>'.
   * @see org.eclipse.xtext.example.css.xcss.IdSelector
   * @generated
   */
  EClass getIdSelector();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.IdSelector#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.xtext.example.css.xcss.IdSelector#getId()
   * @see #getIdSelector()
   * @generated
   */
  EAttribute getIdSelector_Id();

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
   * Returns the meta object for the reference '{@link org.eclipse.xtext.example.css.xcss.ColorConstant#getConstant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Constant</em>'.
   * @see org.eclipse.xtext.example.css.xcss.ColorConstant#getConstant()
   * @see #getColorConstant()
   * @generated
   */
  EReference getColorConstant_Constant();

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
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.RGB#isHex <em>Hex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Hex</em>'.
   * @see org.eclipse.xtext.example.css.xcss.RGB#isHex()
   * @see #getRGB()
   * @generated
   */
  EAttribute getRGB_Hex();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.RGB#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.example.css.xcss.RGB#getValue()
   * @see #getRGB()
   * @generated
   */
  EAttribute getRGB_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.RGB#getRed <em>Red</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Red</em>'.
   * @see org.eclipse.xtext.example.css.xcss.RGB#getRed()
   * @see #getRGB()
   * @generated
   */
  EAttribute getRGB_Red();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.RGB#getGreen <em>Green</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Green</em>'.
   * @see org.eclipse.xtext.example.css.xcss.RGB#getGreen()
   * @see #getRGB()
   * @generated
   */
  EAttribute getRGB_Green();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.RGB#getBlue <em>Blue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Blue</em>'.
   * @see org.eclipse.xtext.example.css.xcss.RGB#getBlue()
   * @see #getRGB()
   * @generated
   */
  EAttribute getRGB_Blue();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.Percent <em>Percent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Percent</em>'.
   * @see org.eclipse.xtext.example.css.xcss.Percent
   * @generated
   */
  EClass getPercent();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.css.xcss.Percent#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.example.css.xcss.Percent#getValue()
   * @see #getPercent()
   * @generated
   */
  EAttribute getPercent_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.css.xcss.Gradient <em>Gradient</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gradient</em>'.
   * @see org.eclipse.xtext.example.css.xcss.Gradient
   * @generated
   */
  EClass getGradient();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.example.css.xcss.Gradient#getColors <em>Colors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Colors</em>'.
   * @see org.eclipse.xtext.example.css.xcss.Gradient#getColors()
   * @see #getGradient()
   * @generated
   */
  EReference getGradient_Colors();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.example.css.xcss.Gradient#getPercents <em>Percents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Percents</em>'.
   * @see org.eclipse.xtext.example.css.xcss.Gradient#getPercents()
   * @see #getGradient()
   * @generated
   */
  EReference getGradient_Percents();

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
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_SELECTOR__TYPE = eINSTANCE.getTypeSelector_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.IdSelectorImpl <em>Id Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.IdSelectorImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getIdSelector()
     * @generated
     */
    EClass ID_SELECTOR = eINSTANCE.getIdSelector();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ID_SELECTOR__ID = eINSTANCE.getIdSelector_Id();

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
     * The meta object literal for the '<em><b>Constant</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLOR_CONSTANT__CONSTANT = eINSTANCE.getColorConstant_Constant();

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
     * The meta object literal for the '<em><b>Hex</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB__HEX = eINSTANCE.getRGB_Hex();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB__VALUE = eINSTANCE.getRGB_Value();

    /**
     * The meta object literal for the '<em><b>Red</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB__RED = eINSTANCE.getRGB_Red();

    /**
     * The meta object literal for the '<em><b>Green</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB__GREEN = eINSTANCE.getRGB_Green();

    /**
     * The meta object literal for the '<em><b>Blue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB__BLUE = eINSTANCE.getRGB_Blue();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.PercentImpl <em>Percent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.PercentImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getPercent()
     * @generated
     */
    EClass PERCENT = eINSTANCE.getPercent();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PERCENT__VALUE = eINSTANCE.getPercent_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.css.xcss.impl.GradientImpl <em>Gradient</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.css.xcss.impl.GradientImpl
     * @see org.eclipse.xtext.example.css.xcss.impl.XcssPackageImpl#getGradient()
     * @generated
     */
    EClass GRADIENT = eINSTANCE.getGradient();

    /**
     * The meta object literal for the '<em><b>Colors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRADIENT__COLORS = eINSTANCE.getGradient_Colors();

    /**
     * The meta object literal for the '<em><b>Percents</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRADIENT__PERCENTS = eINSTANCE.getGradient_Percents();

  }

} //XcssPackage
