/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.css.xcss.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.example.css.xcss.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XcssFactoryImpl extends EFactoryImpl implements XcssFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XcssFactory init()
  {
    try
    {
      XcssFactory theXcssFactory = (XcssFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/example/css/Xcss"); 
      if (theXcssFactory != null)
      {
        return theXcssFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XcssFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XcssFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case XcssPackage.STYLE_SHEET: return createStyleSheet();
      case XcssPackage.STYLE_RULE: return createStyleRule();
      case XcssPackage.SELECTOR: return createSelector();
      case XcssPackage.TYPE_SELECTOR: return createTypeSelector();
      case XcssPackage.WILDCARD_SELECTOR: return createWildcardSelector();
      case XcssPackage.FILTER: return createFilter();
      case XcssPackage.FONT_LITERAL: return createFontLiteral();
      case XcssPackage.COLOR_LITERAL: return createColorLiteral();
      case XcssPackage.COLOR_CONSTANT: return createColorConstant();
      case XcssPackage.RGB: return createRGB();
      case XcssPackage.SIZE_LITERAL: return createSizeLiteral();
      case XcssPackage.SETTING: return createSetting();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case XcssPackage.SIZE_UNIT:
        return createSizeUnitFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case XcssPackage.SIZE_UNIT:
        return convertSizeUnitToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StyleSheet createStyleSheet()
  {
    StyleSheetImpl styleSheet = new StyleSheetImpl();
    return styleSheet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StyleRule createStyleRule()
  {
    StyleRuleImpl styleRule = new StyleRuleImpl();
    return styleRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Selector createSelector()
  {
    SelectorImpl selector = new SelectorImpl();
    return selector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSelector createTypeSelector()
  {
    TypeSelectorImpl typeSelector = new TypeSelectorImpl();
    return typeSelector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WildcardSelector createWildcardSelector()
  {
    WildcardSelectorImpl wildcardSelector = new WildcardSelectorImpl();
    return wildcardSelector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Filter createFilter()
  {
    FilterImpl filter = new FilterImpl();
    return filter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FontLiteral createFontLiteral()
  {
    FontLiteralImpl fontLiteral = new FontLiteralImpl();
    return fontLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColorLiteral createColorLiteral()
  {
    ColorLiteralImpl colorLiteral = new ColorLiteralImpl();
    return colorLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColorConstant createColorConstant()
  {
    ColorConstantImpl colorConstant = new ColorConstantImpl();
    return colorConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RGB createRGB()
  {
    RGBImpl rgb = new RGBImpl();
    return rgb;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeLiteral createSizeLiteral()
  {
    SizeLiteralImpl sizeLiteral = new SizeLiteralImpl();
    return sizeLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Setting createSetting()
  {
    SettingImpl setting = new SettingImpl();
    return setting;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeUnit createSizeUnitFromString(EDataType eDataType, String initialValue)
  {
    SizeUnit result = SizeUnit.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSizeUnitToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XcssPackage getXcssPackage()
  {
    return (XcssPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XcssPackage getPackage()
  {
    return XcssPackage.eINSTANCE;
  }

} //XcssFactoryImpl
