/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.generatorTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.generator.generatorTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneratorTestLanguageFactoryImpl extends EFactoryImpl implements GeneratorTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static GeneratorTestLanguageFactory init()
  {
    try
    {
      GeneratorTestLanguageFactory theGeneratorTestLanguageFactory = (GeneratorTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2009/tmf/xtext/GeneratorTestLanguage"); 
      if (theGeneratorTestLanguageFactory != null)
      {
        return theGeneratorTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new GeneratorTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GeneratorTestLanguageFactoryImpl()
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
      case GeneratorTestLanguagePackage.RULE: return createRule();
      case GeneratorTestLanguagePackage.RULE_B: return createRuleB();
      case GeneratorTestLanguagePackage.RULE1: return createRule1();
      case GeneratorTestLanguagePackage.RULE2: return createRule2();
      case GeneratorTestLanguagePackage.RULE3: return createRule3();
      case GeneratorTestLanguagePackage.RULE4: return createRule4();
      case GeneratorTestLanguagePackage.RULE5: return createRule5();
      case GeneratorTestLanguagePackage.RULE6: return createRule6();
      case GeneratorTestLanguagePackage.RULE7: return createRule7();
      case GeneratorTestLanguagePackage.RULE8: return createRule8();
      case GeneratorTestLanguagePackage.RULE9: return createRule9();
      case GeneratorTestLanguagePackage.RULE10: return createRule10();
      case GeneratorTestLanguagePackage.RULE11: return createRule11();
      case GeneratorTestLanguagePackage.RULE12: return createRule12();
      case GeneratorTestLanguagePackage.RULE13: return createRule13();
      case GeneratorTestLanguagePackage.RULE14: return createRule14();
      case GeneratorTestLanguagePackage.RULE15: return createRule15();
      case GeneratorTestLanguagePackage.RULE16: return createRule16();
      case GeneratorTestLanguagePackage.RULE17: return createRule17();
      case GeneratorTestLanguagePackage.RULE18: return createRule18();
      case GeneratorTestLanguagePackage.RULE19: return createRule19();
      case GeneratorTestLanguagePackage.RULE20: return createRule20();
      case GeneratorTestLanguagePackage.RULE21: return createRule21();
      case GeneratorTestLanguagePackage.RULE22: return createRule22();
      case GeneratorTestLanguagePackage.RULE23: return createRule23();
      case GeneratorTestLanguagePackage.RULE24: return createRule24();
      case GeneratorTestLanguagePackage.RULE25: return createRule25();
      case GeneratorTestLanguagePackage.RULE26: return createRule26();
      case GeneratorTestLanguagePackage.RULE27: return createRule27();
      case GeneratorTestLanguagePackage.RULE28: return createRule28();
      case GeneratorTestLanguagePackage.RULE29: return createRule29();
      case GeneratorTestLanguagePackage.RULE30: return createRule30();
      case GeneratorTestLanguagePackage.RULE31: return createRule31();
      case GeneratorTestLanguagePackage.RULE32: return createRule32();
      case GeneratorTestLanguagePackage.RULE33: return createRule33();
      case GeneratorTestLanguagePackage.RULE34: return createRule34();
      case GeneratorTestLanguagePackage.RULE35: return createRule35();
      case GeneratorTestLanguagePackage.RULE36: return createRule36();
      case GeneratorTestLanguagePackage.RULE37: return createRule37();
      case GeneratorTestLanguagePackage.RULE38: return createRule38();
      case GeneratorTestLanguagePackage.RULE39: return createRule39();
      case GeneratorTestLanguagePackage.RULE40: return createRule40();
      case GeneratorTestLanguagePackage.RULE41: return createRule41();
      case GeneratorTestLanguagePackage.RULE42: return createRule42();
      case GeneratorTestLanguagePackage.RULE43: return createRule43();
      case GeneratorTestLanguagePackage.RULE44: return createRule44();
      case GeneratorTestLanguagePackage.RULE45: return createRule45();
      case GeneratorTestLanguagePackage.RULE46: return createRule46();
      case GeneratorTestLanguagePackage.RULE47: return createRule47();
      case GeneratorTestLanguagePackage.RULE48: return createRule48();
      case GeneratorTestLanguagePackage.RULE49: return createRule49();
      case GeneratorTestLanguagePackage.RULE50: return createRule50();
      case GeneratorTestLanguagePackage.RULE51: return createRule51();
      case GeneratorTestLanguagePackage.RULE52: return createRule52();
      case GeneratorTestLanguagePackage.RULE53: return createRule53();
      case GeneratorTestLanguagePackage.RULE54: return createRule54();
      case GeneratorTestLanguagePackage.RULE55: return createRule55();
      case GeneratorTestLanguagePackage.RULE56: return createRule56();
      case GeneratorTestLanguagePackage.RULE57: return createRule57();
      case GeneratorTestLanguagePackage.RULE58: return createRule58();
      case GeneratorTestLanguagePackage.RULE59: return createRule59();
      case GeneratorTestLanguagePackage.RULE60: return createRule60();
      case GeneratorTestLanguagePackage.RULE61: return createRule61();
      case GeneratorTestLanguagePackage.RULE62: return createRule62();
      case GeneratorTestLanguagePackage.RULE63: return createRule63();
      case GeneratorTestLanguagePackage.RULE64: return createRule64();
      case GeneratorTestLanguagePackage.RULE65: return createRule65();
      case GeneratorTestLanguagePackage.RULE66: return createRule66();
      case GeneratorTestLanguagePackage.RULE67: return createRule67();
      case GeneratorTestLanguagePackage.RULE68: return createRule68();
      case GeneratorTestLanguagePackage.RULE69: return createRule69();
      case GeneratorTestLanguagePackage.RULE70: return createRule70();
      case GeneratorTestLanguagePackage.RULE71: return createRule71();
      case GeneratorTestLanguagePackage.RULE72: return createRule72();
      case GeneratorTestLanguagePackage.RULE73: return createRule73();
      case GeneratorTestLanguagePackage.RULE74: return createRule74();
      case GeneratorTestLanguagePackage.RULE75: return createRule75();
      case GeneratorTestLanguagePackage.RULE76: return createRule76();
      case GeneratorTestLanguagePackage.RULE77: return createRule77();
      case GeneratorTestLanguagePackage.RULE78: return createRule78();
      case GeneratorTestLanguagePackage.RULE79: return createRule79();
      case GeneratorTestLanguagePackage.RULE80: return createRule80();
      case GeneratorTestLanguagePackage.RULE81: return createRule81();
      case GeneratorTestLanguagePackage.RULE82: return createRule82();
      case GeneratorTestLanguagePackage.RULE83: return createRule83();
      case GeneratorTestLanguagePackage.RULE84: return createRule84();
      case GeneratorTestLanguagePackage.RULE85: return createRule85();
      case GeneratorTestLanguagePackage.RULE86: return createRule86();
      case GeneratorTestLanguagePackage.RULE87: return createRule87();
      case GeneratorTestLanguagePackage.RULE88: return createRule88();
      case GeneratorTestLanguagePackage.RULE89: return createRule89();
      case GeneratorTestLanguagePackage.RULE90: return createRule90();
      case GeneratorTestLanguagePackage.RULE91: return createRule91();
      case GeneratorTestLanguagePackage.RULE92: return createRule92();
      case GeneratorTestLanguagePackage.RULE93: return createRule93();
      case GeneratorTestLanguagePackage.RULE94: return createRule94();
      case GeneratorTestLanguagePackage.RULE95: return createRule95();
      case GeneratorTestLanguagePackage.RULE96: return createRule96();
      case GeneratorTestLanguagePackage.RULE97: return createRule97();
      case GeneratorTestLanguagePackage.RULE98: return createRule98();
      case GeneratorTestLanguagePackage.RULE99: return createRule99();
      case GeneratorTestLanguagePackage.RULE100: return createRule100();
      case GeneratorTestLanguagePackage.RULE101: return createRule101();
      case GeneratorTestLanguagePackage.RULE102: return createRule102();
      case GeneratorTestLanguagePackage.RULE103: return createRule103();
      case GeneratorTestLanguagePackage.RULE104: return createRule104();
      case GeneratorTestLanguagePackage.RULE105: return createRule105();
      case GeneratorTestLanguagePackage.RULE106: return createRule106();
      case GeneratorTestLanguagePackage.RULE107: return createRule107();
      case GeneratorTestLanguagePackage.RULE108: return createRule108();
      case GeneratorTestLanguagePackage.RULE109: return createRule109();
      case GeneratorTestLanguagePackage.RULE110: return createRule110();
      case GeneratorTestLanguagePackage.RULE111: return createRule111();
      case GeneratorTestLanguagePackage.RULE112: return createRule112();
      case GeneratorTestLanguagePackage.RULE113: return createRule113();
      case GeneratorTestLanguagePackage.RULE114: return createRule114();
      case GeneratorTestLanguagePackage.RULE115: return createRule115();
      case GeneratorTestLanguagePackage.RULE116: return createRule116();
      case GeneratorTestLanguagePackage.RULE117: return createRule117();
      case GeneratorTestLanguagePackage.RULE118: return createRule118();
      case GeneratorTestLanguagePackage.RULE119: return createRule119();
      case GeneratorTestLanguagePackage.RULE120: return createRule120();
      case GeneratorTestLanguagePackage.RULE121: return createRule121();
      case GeneratorTestLanguagePackage.RULE122: return createRule122();
      case GeneratorTestLanguagePackage.RULE123: return createRule123();
      case GeneratorTestLanguagePackage.RULE124: return createRule124();
      case GeneratorTestLanguagePackage.RULE125: return createRule125();
      case GeneratorTestLanguagePackage.RULE126: return createRule126();
      case GeneratorTestLanguagePackage.RULE127: return createRule127();
      case GeneratorTestLanguagePackage.RULE128: return createRule128();
      case GeneratorTestLanguagePackage.RULE129: return createRule129();
      case GeneratorTestLanguagePackage.RULE130: return createRule130();
      case GeneratorTestLanguagePackage.RULE131: return createRule131();
      case GeneratorTestLanguagePackage.RULE132: return createRule132();
      case GeneratorTestLanguagePackage.RULE133: return createRule133();
      case GeneratorTestLanguagePackage.RULE134: return createRule134();
      case GeneratorTestLanguagePackage.RULE135: return createRule135();
      case GeneratorTestLanguagePackage.RULE136: return createRule136();
      case GeneratorTestLanguagePackage.RULE137: return createRule137();
      case GeneratorTestLanguagePackage.RULE138: return createRule138();
      case GeneratorTestLanguagePackage.RULE139: return createRule139();
      case GeneratorTestLanguagePackage.RULE140: return createRule140();
      case GeneratorTestLanguagePackage.RULE141: return createRule141();
      case GeneratorTestLanguagePackage.RULE142: return createRule142();
      case GeneratorTestLanguagePackage.RULE143: return createRule143();
      case GeneratorTestLanguagePackage.RULE144: return createRule144();
      case GeneratorTestLanguagePackage.RULE145: return createRule145();
      case GeneratorTestLanguagePackage.RULE146: return createRule146();
      case GeneratorTestLanguagePackage.RULE147: return createRule147();
      case GeneratorTestLanguagePackage.RULE148: return createRule148();
      case GeneratorTestLanguagePackage.RULE149: return createRule149();
      case GeneratorTestLanguagePackage.RULE150: return createRule150();
      case GeneratorTestLanguagePackage.RULE151: return createRule151();
      case GeneratorTestLanguagePackage.RULE152: return createRule152();
      case GeneratorTestLanguagePackage.RULE153: return createRule153();
      case GeneratorTestLanguagePackage.RULE154: return createRule154();
      case GeneratorTestLanguagePackage.RULE155: return createRule155();
      case GeneratorTestLanguagePackage.RULE156: return createRule156();
      case GeneratorTestLanguagePackage.RULE157: return createRule157();
      case GeneratorTestLanguagePackage.RULE158: return createRule158();
      case GeneratorTestLanguagePackage.RULE159: return createRule159();
      case GeneratorTestLanguagePackage.RULE160: return createRule160();
      case GeneratorTestLanguagePackage.RULE161: return createRule161();
      case GeneratorTestLanguagePackage.RULE162: return createRule162();
      case GeneratorTestLanguagePackage.RULE163: return createRule163();
      case GeneratorTestLanguagePackage.RULE164: return createRule164();
      case GeneratorTestLanguagePackage.RULE165: return createRule165();
      case GeneratorTestLanguagePackage.RULE166: return createRule166();
      case GeneratorTestLanguagePackage.RULE167: return createRule167();
      case GeneratorTestLanguagePackage.RULE168: return createRule168();
      case GeneratorTestLanguagePackage.RULE169: return createRule169();
      case GeneratorTestLanguagePackage.RULE170: return createRule170();
      case GeneratorTestLanguagePackage.RULE171: return createRule171();
      case GeneratorTestLanguagePackage.RULE172: return createRule172();
      case GeneratorTestLanguagePackage.RULE173: return createRule173();
      case GeneratorTestLanguagePackage.RULE174: return createRule174();
      case GeneratorTestLanguagePackage.RULE175: return createRule175();
      case GeneratorTestLanguagePackage.RULE176: return createRule176();
      case GeneratorTestLanguagePackage.RULE177: return createRule177();
      case GeneratorTestLanguagePackage.RULE178: return createRule178();
      case GeneratorTestLanguagePackage.RULE179: return createRule179();
      case GeneratorTestLanguagePackage.RULE180: return createRule180();
      case GeneratorTestLanguagePackage.RULE181: return createRule181();
      case GeneratorTestLanguagePackage.RULE182: return createRule182();
      case GeneratorTestLanguagePackage.RULE183: return createRule183();
      case GeneratorTestLanguagePackage.RULE184: return createRule184();
      case GeneratorTestLanguagePackage.RULE185: return createRule185();
      case GeneratorTestLanguagePackage.RULE186: return createRule186();
      case GeneratorTestLanguagePackage.RULE187: return createRule187();
      case GeneratorTestLanguagePackage.RULE188: return createRule188();
      case GeneratorTestLanguagePackage.RULE189: return createRule189();
      case GeneratorTestLanguagePackage.RULE190: return createRule190();
      case GeneratorTestLanguagePackage.RULE191: return createRule191();
      case GeneratorTestLanguagePackage.RULE192: return createRule192();
      case GeneratorTestLanguagePackage.RULE193: return createRule193();
      case GeneratorTestLanguagePackage.RULE194: return createRule194();
      case GeneratorTestLanguagePackage.RULE195: return createRule195();
      case GeneratorTestLanguagePackage.RULE196: return createRule196();
      case GeneratorTestLanguagePackage.RULE197: return createRule197();
      case GeneratorTestLanguagePackage.RULE198: return createRule198();
      case GeneratorTestLanguagePackage.RULE199: return createRule199();
      case GeneratorTestLanguagePackage.RULE200: return createRule200();
      case GeneratorTestLanguagePackage.RULE201: return createRule201();
      case GeneratorTestLanguagePackage.RULE202: return createRule202();
      case GeneratorTestLanguagePackage.RULE203: return createRule203();
      case GeneratorTestLanguagePackage.RULE204: return createRule204();
      case GeneratorTestLanguagePackage.RULE205: return createRule205();
      case GeneratorTestLanguagePackage.RULE206: return createRule206();
      case GeneratorTestLanguagePackage.RULE207: return createRule207();
      case GeneratorTestLanguagePackage.RULE208: return createRule208();
      case GeneratorTestLanguagePackage.RULE209: return createRule209();
      case GeneratorTestLanguagePackage.RULE210: return createRule210();
      case GeneratorTestLanguagePackage.RULE211: return createRule211();
      case GeneratorTestLanguagePackage.RULE212: return createRule212();
      case GeneratorTestLanguagePackage.RULE213: return createRule213();
      case GeneratorTestLanguagePackage.RULE214: return createRule214();
      case GeneratorTestLanguagePackage.RULE215: return createRule215();
      case GeneratorTestLanguagePackage.RULE216: return createRule216();
      case GeneratorTestLanguagePackage.RULE217: return createRule217();
      case GeneratorTestLanguagePackage.RULE218: return createRule218();
      case GeneratorTestLanguagePackage.RULE219: return createRule219();
      case GeneratorTestLanguagePackage.RULE220: return createRule220();
      case GeneratorTestLanguagePackage.RULE221: return createRule221();
      case GeneratorTestLanguagePackage.RULE222: return createRule222();
      case GeneratorTestLanguagePackage.RULE223: return createRule223();
      case GeneratorTestLanguagePackage.RULE224: return createRule224();
      case GeneratorTestLanguagePackage.RULE225: return createRule225();
      case GeneratorTestLanguagePackage.RULE226: return createRule226();
      case GeneratorTestLanguagePackage.RULE227: return createRule227();
      case GeneratorTestLanguagePackage.RULE228: return createRule228();
      case GeneratorTestLanguagePackage.RULE229: return createRule229();
      case GeneratorTestLanguagePackage.RULE230: return createRule230();
      case GeneratorTestLanguagePackage.RULE231: return createRule231();
      case GeneratorTestLanguagePackage.RULE232: return createRule232();
      case GeneratorTestLanguagePackage.RULE233: return createRule233();
      case GeneratorTestLanguagePackage.RULE234: return createRule234();
      case GeneratorTestLanguagePackage.RULE235: return createRule235();
      case GeneratorTestLanguagePackage.RULE236: return createRule236();
      case GeneratorTestLanguagePackage.RULE237: return createRule237();
      case GeneratorTestLanguagePackage.RULE238: return createRule238();
      case GeneratorTestLanguagePackage.RULE239: return createRule239();
      case GeneratorTestLanguagePackage.RULE240: return createRule240();
      case GeneratorTestLanguagePackage.RULE241: return createRule241();
      case GeneratorTestLanguagePackage.RULE242: return createRule242();
      case GeneratorTestLanguagePackage.RULE243: return createRule243();
      case GeneratorTestLanguagePackage.RULE244: return createRule244();
      case GeneratorTestLanguagePackage.RULE245: return createRule245();
      case GeneratorTestLanguagePackage.RULE246: return createRule246();
      case GeneratorTestLanguagePackage.RULE247: return createRule247();
      case GeneratorTestLanguagePackage.RULE248: return createRule248();
      case GeneratorTestLanguagePackage.RULE249: return createRule249();
      case GeneratorTestLanguagePackage.RULE250: return createRule250();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule createRule()
  {
    RuleImpl rule = new RuleImpl();
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleB createRuleB()
  {
    RuleBImpl ruleB = new RuleBImpl();
    return ruleB;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule1 createRule1()
  {
    Rule1Impl rule1 = new Rule1Impl();
    return rule1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule2 createRule2()
  {
    Rule2Impl rule2 = new Rule2Impl();
    return rule2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule3 createRule3()
  {
    Rule3Impl rule3 = new Rule3Impl();
    return rule3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule4 createRule4()
  {
    Rule4Impl rule4 = new Rule4Impl();
    return rule4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule5 createRule5()
  {
    Rule5Impl rule5 = new Rule5Impl();
    return rule5;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule6 createRule6()
  {
    Rule6Impl rule6 = new Rule6Impl();
    return rule6;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule7 createRule7()
  {
    Rule7Impl rule7 = new Rule7Impl();
    return rule7;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule8 createRule8()
  {
    Rule8Impl rule8 = new Rule8Impl();
    return rule8;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule9 createRule9()
  {
    Rule9Impl rule9 = new Rule9Impl();
    return rule9;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule10 createRule10()
  {
    Rule10Impl rule10 = new Rule10Impl();
    return rule10;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule11 createRule11()
  {
    Rule11Impl rule11 = new Rule11Impl();
    return rule11;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule12 createRule12()
  {
    Rule12Impl rule12 = new Rule12Impl();
    return rule12;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule13 createRule13()
  {
    Rule13Impl rule13 = new Rule13Impl();
    return rule13;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule14 createRule14()
  {
    Rule14Impl rule14 = new Rule14Impl();
    return rule14;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule15 createRule15()
  {
    Rule15Impl rule15 = new Rule15Impl();
    return rule15;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule16 createRule16()
  {
    Rule16Impl rule16 = new Rule16Impl();
    return rule16;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule17 createRule17()
  {
    Rule17Impl rule17 = new Rule17Impl();
    return rule17;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule18 createRule18()
  {
    Rule18Impl rule18 = new Rule18Impl();
    return rule18;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule19 createRule19()
  {
    Rule19Impl rule19 = new Rule19Impl();
    return rule19;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule20 createRule20()
  {
    Rule20Impl rule20 = new Rule20Impl();
    return rule20;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule21 createRule21()
  {
    Rule21Impl rule21 = new Rule21Impl();
    return rule21;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule22 createRule22()
  {
    Rule22Impl rule22 = new Rule22Impl();
    return rule22;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule23 createRule23()
  {
    Rule23Impl rule23 = new Rule23Impl();
    return rule23;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule24 createRule24()
  {
    Rule24Impl rule24 = new Rule24Impl();
    return rule24;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule25 createRule25()
  {
    Rule25Impl rule25 = new Rule25Impl();
    return rule25;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule26 createRule26()
  {
    Rule26Impl rule26 = new Rule26Impl();
    return rule26;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule27 createRule27()
  {
    Rule27Impl rule27 = new Rule27Impl();
    return rule27;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule28 createRule28()
  {
    Rule28Impl rule28 = new Rule28Impl();
    return rule28;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule29 createRule29()
  {
    Rule29Impl rule29 = new Rule29Impl();
    return rule29;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule30 createRule30()
  {
    Rule30Impl rule30 = new Rule30Impl();
    return rule30;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule31 createRule31()
  {
    Rule31Impl rule31 = new Rule31Impl();
    return rule31;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule32 createRule32()
  {
    Rule32Impl rule32 = new Rule32Impl();
    return rule32;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule33 createRule33()
  {
    Rule33Impl rule33 = new Rule33Impl();
    return rule33;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule34 createRule34()
  {
    Rule34Impl rule34 = new Rule34Impl();
    return rule34;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule35 createRule35()
  {
    Rule35Impl rule35 = new Rule35Impl();
    return rule35;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule36 createRule36()
  {
    Rule36Impl rule36 = new Rule36Impl();
    return rule36;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule37 createRule37()
  {
    Rule37Impl rule37 = new Rule37Impl();
    return rule37;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule38 createRule38()
  {
    Rule38Impl rule38 = new Rule38Impl();
    return rule38;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule39 createRule39()
  {
    Rule39Impl rule39 = new Rule39Impl();
    return rule39;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule40 createRule40()
  {
    Rule40Impl rule40 = new Rule40Impl();
    return rule40;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule41 createRule41()
  {
    Rule41Impl rule41 = new Rule41Impl();
    return rule41;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule42 createRule42()
  {
    Rule42Impl rule42 = new Rule42Impl();
    return rule42;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule43 createRule43()
  {
    Rule43Impl rule43 = new Rule43Impl();
    return rule43;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule44 createRule44()
  {
    Rule44Impl rule44 = new Rule44Impl();
    return rule44;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule45 createRule45()
  {
    Rule45Impl rule45 = new Rule45Impl();
    return rule45;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule46 createRule46()
  {
    Rule46Impl rule46 = new Rule46Impl();
    return rule46;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule47 createRule47()
  {
    Rule47Impl rule47 = new Rule47Impl();
    return rule47;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule48 createRule48()
  {
    Rule48Impl rule48 = new Rule48Impl();
    return rule48;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule49 createRule49()
  {
    Rule49Impl rule49 = new Rule49Impl();
    return rule49;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule50 createRule50()
  {
    Rule50Impl rule50 = new Rule50Impl();
    return rule50;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule51 createRule51()
  {
    Rule51Impl rule51 = new Rule51Impl();
    return rule51;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule52 createRule52()
  {
    Rule52Impl rule52 = new Rule52Impl();
    return rule52;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule53 createRule53()
  {
    Rule53Impl rule53 = new Rule53Impl();
    return rule53;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule54 createRule54()
  {
    Rule54Impl rule54 = new Rule54Impl();
    return rule54;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule55 createRule55()
  {
    Rule55Impl rule55 = new Rule55Impl();
    return rule55;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule56 createRule56()
  {
    Rule56Impl rule56 = new Rule56Impl();
    return rule56;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule57 createRule57()
  {
    Rule57Impl rule57 = new Rule57Impl();
    return rule57;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule58 createRule58()
  {
    Rule58Impl rule58 = new Rule58Impl();
    return rule58;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule59 createRule59()
  {
    Rule59Impl rule59 = new Rule59Impl();
    return rule59;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule60 createRule60()
  {
    Rule60Impl rule60 = new Rule60Impl();
    return rule60;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule61 createRule61()
  {
    Rule61Impl rule61 = new Rule61Impl();
    return rule61;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule62 createRule62()
  {
    Rule62Impl rule62 = new Rule62Impl();
    return rule62;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule63 createRule63()
  {
    Rule63Impl rule63 = new Rule63Impl();
    return rule63;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule64 createRule64()
  {
    Rule64Impl rule64 = new Rule64Impl();
    return rule64;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule65 createRule65()
  {
    Rule65Impl rule65 = new Rule65Impl();
    return rule65;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule66 createRule66()
  {
    Rule66Impl rule66 = new Rule66Impl();
    return rule66;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule67 createRule67()
  {
    Rule67Impl rule67 = new Rule67Impl();
    return rule67;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule68 createRule68()
  {
    Rule68Impl rule68 = new Rule68Impl();
    return rule68;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule69 createRule69()
  {
    Rule69Impl rule69 = new Rule69Impl();
    return rule69;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule70 createRule70()
  {
    Rule70Impl rule70 = new Rule70Impl();
    return rule70;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule71 createRule71()
  {
    Rule71Impl rule71 = new Rule71Impl();
    return rule71;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule72 createRule72()
  {
    Rule72Impl rule72 = new Rule72Impl();
    return rule72;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule73 createRule73()
  {
    Rule73Impl rule73 = new Rule73Impl();
    return rule73;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule74 createRule74()
  {
    Rule74Impl rule74 = new Rule74Impl();
    return rule74;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule75 createRule75()
  {
    Rule75Impl rule75 = new Rule75Impl();
    return rule75;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule76 createRule76()
  {
    Rule76Impl rule76 = new Rule76Impl();
    return rule76;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule77 createRule77()
  {
    Rule77Impl rule77 = new Rule77Impl();
    return rule77;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule78 createRule78()
  {
    Rule78Impl rule78 = new Rule78Impl();
    return rule78;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule79 createRule79()
  {
    Rule79Impl rule79 = new Rule79Impl();
    return rule79;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule80 createRule80()
  {
    Rule80Impl rule80 = new Rule80Impl();
    return rule80;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule81 createRule81()
  {
    Rule81Impl rule81 = new Rule81Impl();
    return rule81;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule82 createRule82()
  {
    Rule82Impl rule82 = new Rule82Impl();
    return rule82;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule83 createRule83()
  {
    Rule83Impl rule83 = new Rule83Impl();
    return rule83;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule84 createRule84()
  {
    Rule84Impl rule84 = new Rule84Impl();
    return rule84;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule85 createRule85()
  {
    Rule85Impl rule85 = new Rule85Impl();
    return rule85;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule86 createRule86()
  {
    Rule86Impl rule86 = new Rule86Impl();
    return rule86;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule87 createRule87()
  {
    Rule87Impl rule87 = new Rule87Impl();
    return rule87;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule88 createRule88()
  {
    Rule88Impl rule88 = new Rule88Impl();
    return rule88;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule89 createRule89()
  {
    Rule89Impl rule89 = new Rule89Impl();
    return rule89;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule90 createRule90()
  {
    Rule90Impl rule90 = new Rule90Impl();
    return rule90;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule91 createRule91()
  {
    Rule91Impl rule91 = new Rule91Impl();
    return rule91;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule92 createRule92()
  {
    Rule92Impl rule92 = new Rule92Impl();
    return rule92;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule93 createRule93()
  {
    Rule93Impl rule93 = new Rule93Impl();
    return rule93;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule94 createRule94()
  {
    Rule94Impl rule94 = new Rule94Impl();
    return rule94;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule95 createRule95()
  {
    Rule95Impl rule95 = new Rule95Impl();
    return rule95;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule96 createRule96()
  {
    Rule96Impl rule96 = new Rule96Impl();
    return rule96;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule97 createRule97()
  {
    Rule97Impl rule97 = new Rule97Impl();
    return rule97;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule98 createRule98()
  {
    Rule98Impl rule98 = new Rule98Impl();
    return rule98;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule99 createRule99()
  {
    Rule99Impl rule99 = new Rule99Impl();
    return rule99;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule100 createRule100()
  {
    Rule100Impl rule100 = new Rule100Impl();
    return rule100;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule101 createRule101()
  {
    Rule101Impl rule101 = new Rule101Impl();
    return rule101;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule102 createRule102()
  {
    Rule102Impl rule102 = new Rule102Impl();
    return rule102;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule103 createRule103()
  {
    Rule103Impl rule103 = new Rule103Impl();
    return rule103;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule104 createRule104()
  {
    Rule104Impl rule104 = new Rule104Impl();
    return rule104;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule105 createRule105()
  {
    Rule105Impl rule105 = new Rule105Impl();
    return rule105;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule106 createRule106()
  {
    Rule106Impl rule106 = new Rule106Impl();
    return rule106;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule107 createRule107()
  {
    Rule107Impl rule107 = new Rule107Impl();
    return rule107;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule108 createRule108()
  {
    Rule108Impl rule108 = new Rule108Impl();
    return rule108;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule109 createRule109()
  {
    Rule109Impl rule109 = new Rule109Impl();
    return rule109;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule110 createRule110()
  {
    Rule110Impl rule110 = new Rule110Impl();
    return rule110;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule111 createRule111()
  {
    Rule111Impl rule111 = new Rule111Impl();
    return rule111;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule112 createRule112()
  {
    Rule112Impl rule112 = new Rule112Impl();
    return rule112;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule113 createRule113()
  {
    Rule113Impl rule113 = new Rule113Impl();
    return rule113;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule114 createRule114()
  {
    Rule114Impl rule114 = new Rule114Impl();
    return rule114;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule115 createRule115()
  {
    Rule115Impl rule115 = new Rule115Impl();
    return rule115;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule116 createRule116()
  {
    Rule116Impl rule116 = new Rule116Impl();
    return rule116;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule117 createRule117()
  {
    Rule117Impl rule117 = new Rule117Impl();
    return rule117;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule118 createRule118()
  {
    Rule118Impl rule118 = new Rule118Impl();
    return rule118;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule119 createRule119()
  {
    Rule119Impl rule119 = new Rule119Impl();
    return rule119;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule120 createRule120()
  {
    Rule120Impl rule120 = new Rule120Impl();
    return rule120;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule121 createRule121()
  {
    Rule121Impl rule121 = new Rule121Impl();
    return rule121;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule122 createRule122()
  {
    Rule122Impl rule122 = new Rule122Impl();
    return rule122;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule123 createRule123()
  {
    Rule123Impl rule123 = new Rule123Impl();
    return rule123;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule124 createRule124()
  {
    Rule124Impl rule124 = new Rule124Impl();
    return rule124;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule125 createRule125()
  {
    Rule125Impl rule125 = new Rule125Impl();
    return rule125;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule126 createRule126()
  {
    Rule126Impl rule126 = new Rule126Impl();
    return rule126;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule127 createRule127()
  {
    Rule127Impl rule127 = new Rule127Impl();
    return rule127;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule128 createRule128()
  {
    Rule128Impl rule128 = new Rule128Impl();
    return rule128;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule129 createRule129()
  {
    Rule129Impl rule129 = new Rule129Impl();
    return rule129;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule130 createRule130()
  {
    Rule130Impl rule130 = new Rule130Impl();
    return rule130;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule131 createRule131()
  {
    Rule131Impl rule131 = new Rule131Impl();
    return rule131;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule132 createRule132()
  {
    Rule132Impl rule132 = new Rule132Impl();
    return rule132;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule133 createRule133()
  {
    Rule133Impl rule133 = new Rule133Impl();
    return rule133;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule134 createRule134()
  {
    Rule134Impl rule134 = new Rule134Impl();
    return rule134;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule135 createRule135()
  {
    Rule135Impl rule135 = new Rule135Impl();
    return rule135;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule136 createRule136()
  {
    Rule136Impl rule136 = new Rule136Impl();
    return rule136;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule137 createRule137()
  {
    Rule137Impl rule137 = new Rule137Impl();
    return rule137;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule138 createRule138()
  {
    Rule138Impl rule138 = new Rule138Impl();
    return rule138;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule139 createRule139()
  {
    Rule139Impl rule139 = new Rule139Impl();
    return rule139;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule140 createRule140()
  {
    Rule140Impl rule140 = new Rule140Impl();
    return rule140;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule141 createRule141()
  {
    Rule141Impl rule141 = new Rule141Impl();
    return rule141;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule142 createRule142()
  {
    Rule142Impl rule142 = new Rule142Impl();
    return rule142;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule143 createRule143()
  {
    Rule143Impl rule143 = new Rule143Impl();
    return rule143;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule144 createRule144()
  {
    Rule144Impl rule144 = new Rule144Impl();
    return rule144;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule145 createRule145()
  {
    Rule145Impl rule145 = new Rule145Impl();
    return rule145;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule146 createRule146()
  {
    Rule146Impl rule146 = new Rule146Impl();
    return rule146;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule147 createRule147()
  {
    Rule147Impl rule147 = new Rule147Impl();
    return rule147;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule148 createRule148()
  {
    Rule148Impl rule148 = new Rule148Impl();
    return rule148;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule149 createRule149()
  {
    Rule149Impl rule149 = new Rule149Impl();
    return rule149;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule150 createRule150()
  {
    Rule150Impl rule150 = new Rule150Impl();
    return rule150;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule151 createRule151()
  {
    Rule151Impl rule151 = new Rule151Impl();
    return rule151;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule152 createRule152()
  {
    Rule152Impl rule152 = new Rule152Impl();
    return rule152;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule153 createRule153()
  {
    Rule153Impl rule153 = new Rule153Impl();
    return rule153;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule154 createRule154()
  {
    Rule154Impl rule154 = new Rule154Impl();
    return rule154;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule155 createRule155()
  {
    Rule155Impl rule155 = new Rule155Impl();
    return rule155;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule156 createRule156()
  {
    Rule156Impl rule156 = new Rule156Impl();
    return rule156;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule157 createRule157()
  {
    Rule157Impl rule157 = new Rule157Impl();
    return rule157;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule158 createRule158()
  {
    Rule158Impl rule158 = new Rule158Impl();
    return rule158;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule159 createRule159()
  {
    Rule159Impl rule159 = new Rule159Impl();
    return rule159;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule160 createRule160()
  {
    Rule160Impl rule160 = new Rule160Impl();
    return rule160;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule161 createRule161()
  {
    Rule161Impl rule161 = new Rule161Impl();
    return rule161;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule162 createRule162()
  {
    Rule162Impl rule162 = new Rule162Impl();
    return rule162;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule163 createRule163()
  {
    Rule163Impl rule163 = new Rule163Impl();
    return rule163;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule164 createRule164()
  {
    Rule164Impl rule164 = new Rule164Impl();
    return rule164;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule165 createRule165()
  {
    Rule165Impl rule165 = new Rule165Impl();
    return rule165;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule166 createRule166()
  {
    Rule166Impl rule166 = new Rule166Impl();
    return rule166;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule167 createRule167()
  {
    Rule167Impl rule167 = new Rule167Impl();
    return rule167;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule168 createRule168()
  {
    Rule168Impl rule168 = new Rule168Impl();
    return rule168;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule169 createRule169()
  {
    Rule169Impl rule169 = new Rule169Impl();
    return rule169;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule170 createRule170()
  {
    Rule170Impl rule170 = new Rule170Impl();
    return rule170;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule171 createRule171()
  {
    Rule171Impl rule171 = new Rule171Impl();
    return rule171;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule172 createRule172()
  {
    Rule172Impl rule172 = new Rule172Impl();
    return rule172;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule173 createRule173()
  {
    Rule173Impl rule173 = new Rule173Impl();
    return rule173;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule174 createRule174()
  {
    Rule174Impl rule174 = new Rule174Impl();
    return rule174;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule175 createRule175()
  {
    Rule175Impl rule175 = new Rule175Impl();
    return rule175;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule176 createRule176()
  {
    Rule176Impl rule176 = new Rule176Impl();
    return rule176;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule177 createRule177()
  {
    Rule177Impl rule177 = new Rule177Impl();
    return rule177;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule178 createRule178()
  {
    Rule178Impl rule178 = new Rule178Impl();
    return rule178;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule179 createRule179()
  {
    Rule179Impl rule179 = new Rule179Impl();
    return rule179;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule180 createRule180()
  {
    Rule180Impl rule180 = new Rule180Impl();
    return rule180;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule181 createRule181()
  {
    Rule181Impl rule181 = new Rule181Impl();
    return rule181;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule182 createRule182()
  {
    Rule182Impl rule182 = new Rule182Impl();
    return rule182;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule183 createRule183()
  {
    Rule183Impl rule183 = new Rule183Impl();
    return rule183;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule184 createRule184()
  {
    Rule184Impl rule184 = new Rule184Impl();
    return rule184;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule185 createRule185()
  {
    Rule185Impl rule185 = new Rule185Impl();
    return rule185;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule186 createRule186()
  {
    Rule186Impl rule186 = new Rule186Impl();
    return rule186;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule187 createRule187()
  {
    Rule187Impl rule187 = new Rule187Impl();
    return rule187;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule188 createRule188()
  {
    Rule188Impl rule188 = new Rule188Impl();
    return rule188;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule189 createRule189()
  {
    Rule189Impl rule189 = new Rule189Impl();
    return rule189;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule190 createRule190()
  {
    Rule190Impl rule190 = new Rule190Impl();
    return rule190;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule191 createRule191()
  {
    Rule191Impl rule191 = new Rule191Impl();
    return rule191;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule192 createRule192()
  {
    Rule192Impl rule192 = new Rule192Impl();
    return rule192;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule193 createRule193()
  {
    Rule193Impl rule193 = new Rule193Impl();
    return rule193;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule194 createRule194()
  {
    Rule194Impl rule194 = new Rule194Impl();
    return rule194;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule195 createRule195()
  {
    Rule195Impl rule195 = new Rule195Impl();
    return rule195;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule196 createRule196()
  {
    Rule196Impl rule196 = new Rule196Impl();
    return rule196;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule197 createRule197()
  {
    Rule197Impl rule197 = new Rule197Impl();
    return rule197;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule198 createRule198()
  {
    Rule198Impl rule198 = new Rule198Impl();
    return rule198;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule199 createRule199()
  {
    Rule199Impl rule199 = new Rule199Impl();
    return rule199;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule200 createRule200()
  {
    Rule200Impl rule200 = new Rule200Impl();
    return rule200;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule201 createRule201()
  {
    Rule201Impl rule201 = new Rule201Impl();
    return rule201;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule202 createRule202()
  {
    Rule202Impl rule202 = new Rule202Impl();
    return rule202;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule203 createRule203()
  {
    Rule203Impl rule203 = new Rule203Impl();
    return rule203;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule204 createRule204()
  {
    Rule204Impl rule204 = new Rule204Impl();
    return rule204;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule205 createRule205()
  {
    Rule205Impl rule205 = new Rule205Impl();
    return rule205;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule206 createRule206()
  {
    Rule206Impl rule206 = new Rule206Impl();
    return rule206;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule207 createRule207()
  {
    Rule207Impl rule207 = new Rule207Impl();
    return rule207;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule208 createRule208()
  {
    Rule208Impl rule208 = new Rule208Impl();
    return rule208;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule209 createRule209()
  {
    Rule209Impl rule209 = new Rule209Impl();
    return rule209;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule210 createRule210()
  {
    Rule210Impl rule210 = new Rule210Impl();
    return rule210;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule211 createRule211()
  {
    Rule211Impl rule211 = new Rule211Impl();
    return rule211;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule212 createRule212()
  {
    Rule212Impl rule212 = new Rule212Impl();
    return rule212;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule213 createRule213()
  {
    Rule213Impl rule213 = new Rule213Impl();
    return rule213;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule214 createRule214()
  {
    Rule214Impl rule214 = new Rule214Impl();
    return rule214;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule215 createRule215()
  {
    Rule215Impl rule215 = new Rule215Impl();
    return rule215;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule216 createRule216()
  {
    Rule216Impl rule216 = new Rule216Impl();
    return rule216;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule217 createRule217()
  {
    Rule217Impl rule217 = new Rule217Impl();
    return rule217;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule218 createRule218()
  {
    Rule218Impl rule218 = new Rule218Impl();
    return rule218;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule219 createRule219()
  {
    Rule219Impl rule219 = new Rule219Impl();
    return rule219;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule220 createRule220()
  {
    Rule220Impl rule220 = new Rule220Impl();
    return rule220;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule221 createRule221()
  {
    Rule221Impl rule221 = new Rule221Impl();
    return rule221;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule222 createRule222()
  {
    Rule222Impl rule222 = new Rule222Impl();
    return rule222;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule223 createRule223()
  {
    Rule223Impl rule223 = new Rule223Impl();
    return rule223;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule224 createRule224()
  {
    Rule224Impl rule224 = new Rule224Impl();
    return rule224;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule225 createRule225()
  {
    Rule225Impl rule225 = new Rule225Impl();
    return rule225;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule226 createRule226()
  {
    Rule226Impl rule226 = new Rule226Impl();
    return rule226;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule227 createRule227()
  {
    Rule227Impl rule227 = new Rule227Impl();
    return rule227;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule228 createRule228()
  {
    Rule228Impl rule228 = new Rule228Impl();
    return rule228;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule229 createRule229()
  {
    Rule229Impl rule229 = new Rule229Impl();
    return rule229;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule230 createRule230()
  {
    Rule230Impl rule230 = new Rule230Impl();
    return rule230;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule231 createRule231()
  {
    Rule231Impl rule231 = new Rule231Impl();
    return rule231;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule232 createRule232()
  {
    Rule232Impl rule232 = new Rule232Impl();
    return rule232;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule233 createRule233()
  {
    Rule233Impl rule233 = new Rule233Impl();
    return rule233;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule234 createRule234()
  {
    Rule234Impl rule234 = new Rule234Impl();
    return rule234;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule235 createRule235()
  {
    Rule235Impl rule235 = new Rule235Impl();
    return rule235;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule236 createRule236()
  {
    Rule236Impl rule236 = new Rule236Impl();
    return rule236;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule237 createRule237()
  {
    Rule237Impl rule237 = new Rule237Impl();
    return rule237;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule238 createRule238()
  {
    Rule238Impl rule238 = new Rule238Impl();
    return rule238;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule239 createRule239()
  {
    Rule239Impl rule239 = new Rule239Impl();
    return rule239;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule240 createRule240()
  {
    Rule240Impl rule240 = new Rule240Impl();
    return rule240;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule241 createRule241()
  {
    Rule241Impl rule241 = new Rule241Impl();
    return rule241;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule242 createRule242()
  {
    Rule242Impl rule242 = new Rule242Impl();
    return rule242;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule243 createRule243()
  {
    Rule243Impl rule243 = new Rule243Impl();
    return rule243;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule244 createRule244()
  {
    Rule244Impl rule244 = new Rule244Impl();
    return rule244;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule245 createRule245()
  {
    Rule245Impl rule245 = new Rule245Impl();
    return rule245;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule246 createRule246()
  {
    Rule246Impl rule246 = new Rule246Impl();
    return rule246;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule247 createRule247()
  {
    Rule247Impl rule247 = new Rule247Impl();
    return rule247;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule248 createRule248()
  {
    Rule248Impl rule248 = new Rule248Impl();
    return rule248;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule249 createRule249()
  {
    Rule249Impl rule249 = new Rule249Impl();
    return rule249;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule250 createRule250()
  {
    Rule250Impl rule250 = new Rule250Impl();
    return rule250;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GeneratorTestLanguagePackage getGeneratorTestLanguagePackage()
  {
    return (GeneratorTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static GeneratorTestLanguagePackage getPackage()
  {
    return GeneratorTestLanguagePackage.eINSTANCE;
  }

} //GeneratorTestLanguageFactoryImpl
