/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.generatorTestLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.generator.generatorTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.generatorTestLanguage.GeneratorTestLanguagePackage
 * @generated
 */
public class GeneratorTestLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GeneratorTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GeneratorTestLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = GeneratorTestLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GeneratorTestLanguageSwitch<Adapter> modelSwitch =
    new GeneratorTestLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseRule(Rule object)
      {
        return createRuleAdapter();
      }
      @Override
      public Adapter caseRule1(Rule1 object)
      {
        return createRule1Adapter();
      }
      @Override
      public Adapter caseRule2(Rule2 object)
      {
        return createRule2Adapter();
      }
      @Override
      public Adapter caseRule3(Rule3 object)
      {
        return createRule3Adapter();
      }
      @Override
      public Adapter caseRule4(Rule4 object)
      {
        return createRule4Adapter();
      }
      @Override
      public Adapter caseRule5(Rule5 object)
      {
        return createRule5Adapter();
      }
      @Override
      public Adapter caseRule6(Rule6 object)
      {
        return createRule6Adapter();
      }
      @Override
      public Adapter caseRule7(Rule7 object)
      {
        return createRule7Adapter();
      }
      @Override
      public Adapter caseRule8(Rule8 object)
      {
        return createRule8Adapter();
      }
      @Override
      public Adapter caseRule9(Rule9 object)
      {
        return createRule9Adapter();
      }
      @Override
      public Adapter caseRule10(Rule10 object)
      {
        return createRule10Adapter();
      }
      @Override
      public Adapter caseRule11(Rule11 object)
      {
        return createRule11Adapter();
      }
      @Override
      public Adapter caseRule12(Rule12 object)
      {
        return createRule12Adapter();
      }
      @Override
      public Adapter caseRule13(Rule13 object)
      {
        return createRule13Adapter();
      }
      @Override
      public Adapter caseRule14(Rule14 object)
      {
        return createRule14Adapter();
      }
      @Override
      public Adapter caseRule15(Rule15 object)
      {
        return createRule15Adapter();
      }
      @Override
      public Adapter caseRule16(Rule16 object)
      {
        return createRule16Adapter();
      }
      @Override
      public Adapter caseRule17(Rule17 object)
      {
        return createRule17Adapter();
      }
      @Override
      public Adapter caseRule18(Rule18 object)
      {
        return createRule18Adapter();
      }
      @Override
      public Adapter caseRule19(Rule19 object)
      {
        return createRule19Adapter();
      }
      @Override
      public Adapter caseRule20(Rule20 object)
      {
        return createRule20Adapter();
      }
      @Override
      public Adapter caseRule21(Rule21 object)
      {
        return createRule21Adapter();
      }
      @Override
      public Adapter caseRule22(Rule22 object)
      {
        return createRule22Adapter();
      }
      @Override
      public Adapter caseRule23(Rule23 object)
      {
        return createRule23Adapter();
      }
      @Override
      public Adapter caseRule24(Rule24 object)
      {
        return createRule24Adapter();
      }
      @Override
      public Adapter caseRule25(Rule25 object)
      {
        return createRule25Adapter();
      }
      @Override
      public Adapter caseRule26(Rule26 object)
      {
        return createRule26Adapter();
      }
      @Override
      public Adapter caseRule27(Rule27 object)
      {
        return createRule27Adapter();
      }
      @Override
      public Adapter caseRule28(Rule28 object)
      {
        return createRule28Adapter();
      }
      @Override
      public Adapter caseRule29(Rule29 object)
      {
        return createRule29Adapter();
      }
      @Override
      public Adapter caseRule30(Rule30 object)
      {
        return createRule30Adapter();
      }
      @Override
      public Adapter caseRule31(Rule31 object)
      {
        return createRule31Adapter();
      }
      @Override
      public Adapter caseRule32(Rule32 object)
      {
        return createRule32Adapter();
      }
      @Override
      public Adapter caseRule33(Rule33 object)
      {
        return createRule33Adapter();
      }
      @Override
      public Adapter caseRule34(Rule34 object)
      {
        return createRule34Adapter();
      }
      @Override
      public Adapter caseRule35(Rule35 object)
      {
        return createRule35Adapter();
      }
      @Override
      public Adapter caseRule36(Rule36 object)
      {
        return createRule36Adapter();
      }
      @Override
      public Adapter caseRule37(Rule37 object)
      {
        return createRule37Adapter();
      }
      @Override
      public Adapter caseRule38(Rule38 object)
      {
        return createRule38Adapter();
      }
      @Override
      public Adapter caseRule39(Rule39 object)
      {
        return createRule39Adapter();
      }
      @Override
      public Adapter caseRule40(Rule40 object)
      {
        return createRule40Adapter();
      }
      @Override
      public Adapter caseRule41(Rule41 object)
      {
        return createRule41Adapter();
      }
      @Override
      public Adapter caseRule42(Rule42 object)
      {
        return createRule42Adapter();
      }
      @Override
      public Adapter caseRule43(Rule43 object)
      {
        return createRule43Adapter();
      }
      @Override
      public Adapter caseRule44(Rule44 object)
      {
        return createRule44Adapter();
      }
      @Override
      public Adapter caseRule45(Rule45 object)
      {
        return createRule45Adapter();
      }
      @Override
      public Adapter caseRule46(Rule46 object)
      {
        return createRule46Adapter();
      }
      @Override
      public Adapter caseRule47(Rule47 object)
      {
        return createRule47Adapter();
      }
      @Override
      public Adapter caseRule48(Rule48 object)
      {
        return createRule48Adapter();
      }
      @Override
      public Adapter caseRule49(Rule49 object)
      {
        return createRule49Adapter();
      }
      @Override
      public Adapter caseRule50(Rule50 object)
      {
        return createRule50Adapter();
      }
      @Override
      public Adapter caseRule51(Rule51 object)
      {
        return createRule51Adapter();
      }
      @Override
      public Adapter caseRule52(Rule52 object)
      {
        return createRule52Adapter();
      }
      @Override
      public Adapter caseRule53(Rule53 object)
      {
        return createRule53Adapter();
      }
      @Override
      public Adapter caseRule54(Rule54 object)
      {
        return createRule54Adapter();
      }
      @Override
      public Adapter caseRule55(Rule55 object)
      {
        return createRule55Adapter();
      }
      @Override
      public Adapter caseRule56(Rule56 object)
      {
        return createRule56Adapter();
      }
      @Override
      public Adapter caseRule57(Rule57 object)
      {
        return createRule57Adapter();
      }
      @Override
      public Adapter caseRule58(Rule58 object)
      {
        return createRule58Adapter();
      }
      @Override
      public Adapter caseRule59(Rule59 object)
      {
        return createRule59Adapter();
      }
      @Override
      public Adapter caseRule60(Rule60 object)
      {
        return createRule60Adapter();
      }
      @Override
      public Adapter caseRule61(Rule61 object)
      {
        return createRule61Adapter();
      }
      @Override
      public Adapter caseRule62(Rule62 object)
      {
        return createRule62Adapter();
      }
      @Override
      public Adapter caseRule63(Rule63 object)
      {
        return createRule63Adapter();
      }
      @Override
      public Adapter caseRule64(Rule64 object)
      {
        return createRule64Adapter();
      }
      @Override
      public Adapter caseRule65(Rule65 object)
      {
        return createRule65Adapter();
      }
      @Override
      public Adapter caseRule66(Rule66 object)
      {
        return createRule66Adapter();
      }
      @Override
      public Adapter caseRule67(Rule67 object)
      {
        return createRule67Adapter();
      }
      @Override
      public Adapter caseRule68(Rule68 object)
      {
        return createRule68Adapter();
      }
      @Override
      public Adapter caseRule69(Rule69 object)
      {
        return createRule69Adapter();
      }
      @Override
      public Adapter caseRule70(Rule70 object)
      {
        return createRule70Adapter();
      }
      @Override
      public Adapter caseRule71(Rule71 object)
      {
        return createRule71Adapter();
      }
      @Override
      public Adapter caseRule72(Rule72 object)
      {
        return createRule72Adapter();
      }
      @Override
      public Adapter caseRule73(Rule73 object)
      {
        return createRule73Adapter();
      }
      @Override
      public Adapter caseRule74(Rule74 object)
      {
        return createRule74Adapter();
      }
      @Override
      public Adapter caseRule75(Rule75 object)
      {
        return createRule75Adapter();
      }
      @Override
      public Adapter caseRule76(Rule76 object)
      {
        return createRule76Adapter();
      }
      @Override
      public Adapter caseRule77(Rule77 object)
      {
        return createRule77Adapter();
      }
      @Override
      public Adapter caseRule78(Rule78 object)
      {
        return createRule78Adapter();
      }
      @Override
      public Adapter caseRule79(Rule79 object)
      {
        return createRule79Adapter();
      }
      @Override
      public Adapter caseRule80(Rule80 object)
      {
        return createRule80Adapter();
      }
      @Override
      public Adapter caseRule81(Rule81 object)
      {
        return createRule81Adapter();
      }
      @Override
      public Adapter caseRule82(Rule82 object)
      {
        return createRule82Adapter();
      }
      @Override
      public Adapter caseRule83(Rule83 object)
      {
        return createRule83Adapter();
      }
      @Override
      public Adapter caseRule84(Rule84 object)
      {
        return createRule84Adapter();
      }
      @Override
      public Adapter caseRule85(Rule85 object)
      {
        return createRule85Adapter();
      }
      @Override
      public Adapter caseRule86(Rule86 object)
      {
        return createRule86Adapter();
      }
      @Override
      public Adapter caseRule87(Rule87 object)
      {
        return createRule87Adapter();
      }
      @Override
      public Adapter caseRule88(Rule88 object)
      {
        return createRule88Adapter();
      }
      @Override
      public Adapter caseRule89(Rule89 object)
      {
        return createRule89Adapter();
      }
      @Override
      public Adapter caseRule90(Rule90 object)
      {
        return createRule90Adapter();
      }
      @Override
      public Adapter caseRule91(Rule91 object)
      {
        return createRule91Adapter();
      }
      @Override
      public Adapter caseRule92(Rule92 object)
      {
        return createRule92Adapter();
      }
      @Override
      public Adapter caseRule93(Rule93 object)
      {
        return createRule93Adapter();
      }
      @Override
      public Adapter caseRule94(Rule94 object)
      {
        return createRule94Adapter();
      }
      @Override
      public Adapter caseRule95(Rule95 object)
      {
        return createRule95Adapter();
      }
      @Override
      public Adapter caseRule96(Rule96 object)
      {
        return createRule96Adapter();
      }
      @Override
      public Adapter caseRule97(Rule97 object)
      {
        return createRule97Adapter();
      }
      @Override
      public Adapter caseRule98(Rule98 object)
      {
        return createRule98Adapter();
      }
      @Override
      public Adapter caseRule99(Rule99 object)
      {
        return createRule99Adapter();
      }
      @Override
      public Adapter caseRule100(Rule100 object)
      {
        return createRule100Adapter();
      }
      @Override
      public Adapter caseRule101(Rule101 object)
      {
        return createRule101Adapter();
      }
      @Override
      public Adapter caseRule102(Rule102 object)
      {
        return createRule102Adapter();
      }
      @Override
      public Adapter caseRule103(Rule103 object)
      {
        return createRule103Adapter();
      }
      @Override
      public Adapter caseRule104(Rule104 object)
      {
        return createRule104Adapter();
      }
      @Override
      public Adapter caseRule105(Rule105 object)
      {
        return createRule105Adapter();
      }
      @Override
      public Adapter caseRule106(Rule106 object)
      {
        return createRule106Adapter();
      }
      @Override
      public Adapter caseRule107(Rule107 object)
      {
        return createRule107Adapter();
      }
      @Override
      public Adapter caseRule108(Rule108 object)
      {
        return createRule108Adapter();
      }
      @Override
      public Adapter caseRule109(Rule109 object)
      {
        return createRule109Adapter();
      }
      @Override
      public Adapter caseRule110(Rule110 object)
      {
        return createRule110Adapter();
      }
      @Override
      public Adapter caseRule111(Rule111 object)
      {
        return createRule111Adapter();
      }
      @Override
      public Adapter caseRule112(Rule112 object)
      {
        return createRule112Adapter();
      }
      @Override
      public Adapter caseRule113(Rule113 object)
      {
        return createRule113Adapter();
      }
      @Override
      public Adapter caseRule114(Rule114 object)
      {
        return createRule114Adapter();
      }
      @Override
      public Adapter caseRule115(Rule115 object)
      {
        return createRule115Adapter();
      }
      @Override
      public Adapter caseRule116(Rule116 object)
      {
        return createRule116Adapter();
      }
      @Override
      public Adapter caseRule117(Rule117 object)
      {
        return createRule117Adapter();
      }
      @Override
      public Adapter caseRule118(Rule118 object)
      {
        return createRule118Adapter();
      }
      @Override
      public Adapter caseRule119(Rule119 object)
      {
        return createRule119Adapter();
      }
      @Override
      public Adapter caseRule120(Rule120 object)
      {
        return createRule120Adapter();
      }
      @Override
      public Adapter caseRule121(Rule121 object)
      {
        return createRule121Adapter();
      }
      @Override
      public Adapter caseRule122(Rule122 object)
      {
        return createRule122Adapter();
      }
      @Override
      public Adapter caseRule123(Rule123 object)
      {
        return createRule123Adapter();
      }
      @Override
      public Adapter caseRule124(Rule124 object)
      {
        return createRule124Adapter();
      }
      @Override
      public Adapter caseRule125(Rule125 object)
      {
        return createRule125Adapter();
      }
      @Override
      public Adapter caseRule126(Rule126 object)
      {
        return createRule126Adapter();
      }
      @Override
      public Adapter caseRule127(Rule127 object)
      {
        return createRule127Adapter();
      }
      @Override
      public Adapter caseRule128(Rule128 object)
      {
        return createRule128Adapter();
      }
      @Override
      public Adapter caseRule129(Rule129 object)
      {
        return createRule129Adapter();
      }
      @Override
      public Adapter caseRule130(Rule130 object)
      {
        return createRule130Adapter();
      }
      @Override
      public Adapter caseRule131(Rule131 object)
      {
        return createRule131Adapter();
      }
      @Override
      public Adapter caseRule132(Rule132 object)
      {
        return createRule132Adapter();
      }
      @Override
      public Adapter caseRule133(Rule133 object)
      {
        return createRule133Adapter();
      }
      @Override
      public Adapter caseRule134(Rule134 object)
      {
        return createRule134Adapter();
      }
      @Override
      public Adapter caseRule135(Rule135 object)
      {
        return createRule135Adapter();
      }
      @Override
      public Adapter caseRule136(Rule136 object)
      {
        return createRule136Adapter();
      }
      @Override
      public Adapter caseRule137(Rule137 object)
      {
        return createRule137Adapter();
      }
      @Override
      public Adapter caseRule138(Rule138 object)
      {
        return createRule138Adapter();
      }
      @Override
      public Adapter caseRule139(Rule139 object)
      {
        return createRule139Adapter();
      }
      @Override
      public Adapter caseRule140(Rule140 object)
      {
        return createRule140Adapter();
      }
      @Override
      public Adapter caseRule141(Rule141 object)
      {
        return createRule141Adapter();
      }
      @Override
      public Adapter caseRule142(Rule142 object)
      {
        return createRule142Adapter();
      }
      @Override
      public Adapter caseRule143(Rule143 object)
      {
        return createRule143Adapter();
      }
      @Override
      public Adapter caseRule144(Rule144 object)
      {
        return createRule144Adapter();
      }
      @Override
      public Adapter caseRule145(Rule145 object)
      {
        return createRule145Adapter();
      }
      @Override
      public Adapter caseRule146(Rule146 object)
      {
        return createRule146Adapter();
      }
      @Override
      public Adapter caseRule147(Rule147 object)
      {
        return createRule147Adapter();
      }
      @Override
      public Adapter caseRule148(Rule148 object)
      {
        return createRule148Adapter();
      }
      @Override
      public Adapter caseRule149(Rule149 object)
      {
        return createRule149Adapter();
      }
      @Override
      public Adapter caseRule150(Rule150 object)
      {
        return createRule150Adapter();
      }
      @Override
      public Adapter caseRule151(Rule151 object)
      {
        return createRule151Adapter();
      }
      @Override
      public Adapter caseRule152(Rule152 object)
      {
        return createRule152Adapter();
      }
      @Override
      public Adapter caseRule153(Rule153 object)
      {
        return createRule153Adapter();
      }
      @Override
      public Adapter caseRule154(Rule154 object)
      {
        return createRule154Adapter();
      }
      @Override
      public Adapter caseRule155(Rule155 object)
      {
        return createRule155Adapter();
      }
      @Override
      public Adapter caseRule156(Rule156 object)
      {
        return createRule156Adapter();
      }
      @Override
      public Adapter caseRule157(Rule157 object)
      {
        return createRule157Adapter();
      }
      @Override
      public Adapter caseRule158(Rule158 object)
      {
        return createRule158Adapter();
      }
      @Override
      public Adapter caseRule159(Rule159 object)
      {
        return createRule159Adapter();
      }
      @Override
      public Adapter caseRule160(Rule160 object)
      {
        return createRule160Adapter();
      }
      @Override
      public Adapter caseRule161(Rule161 object)
      {
        return createRule161Adapter();
      }
      @Override
      public Adapter caseRule162(Rule162 object)
      {
        return createRule162Adapter();
      }
      @Override
      public Adapter caseRule163(Rule163 object)
      {
        return createRule163Adapter();
      }
      @Override
      public Adapter caseRule164(Rule164 object)
      {
        return createRule164Adapter();
      }
      @Override
      public Adapter caseRule165(Rule165 object)
      {
        return createRule165Adapter();
      }
      @Override
      public Adapter caseRule166(Rule166 object)
      {
        return createRule166Adapter();
      }
      @Override
      public Adapter caseRule167(Rule167 object)
      {
        return createRule167Adapter();
      }
      @Override
      public Adapter caseRule168(Rule168 object)
      {
        return createRule168Adapter();
      }
      @Override
      public Adapter caseRule169(Rule169 object)
      {
        return createRule169Adapter();
      }
      @Override
      public Adapter caseRule170(Rule170 object)
      {
        return createRule170Adapter();
      }
      @Override
      public Adapter caseRule171(Rule171 object)
      {
        return createRule171Adapter();
      }
      @Override
      public Adapter caseRule172(Rule172 object)
      {
        return createRule172Adapter();
      }
      @Override
      public Adapter caseRule173(Rule173 object)
      {
        return createRule173Adapter();
      }
      @Override
      public Adapter caseRule174(Rule174 object)
      {
        return createRule174Adapter();
      }
      @Override
      public Adapter caseRule175(Rule175 object)
      {
        return createRule175Adapter();
      }
      @Override
      public Adapter caseRule176(Rule176 object)
      {
        return createRule176Adapter();
      }
      @Override
      public Adapter caseRule177(Rule177 object)
      {
        return createRule177Adapter();
      }
      @Override
      public Adapter caseRule178(Rule178 object)
      {
        return createRule178Adapter();
      }
      @Override
      public Adapter caseRule179(Rule179 object)
      {
        return createRule179Adapter();
      }
      @Override
      public Adapter caseRule180(Rule180 object)
      {
        return createRule180Adapter();
      }
      @Override
      public Adapter caseRule181(Rule181 object)
      {
        return createRule181Adapter();
      }
      @Override
      public Adapter caseRule182(Rule182 object)
      {
        return createRule182Adapter();
      }
      @Override
      public Adapter caseRule183(Rule183 object)
      {
        return createRule183Adapter();
      }
      @Override
      public Adapter caseRule184(Rule184 object)
      {
        return createRule184Adapter();
      }
      @Override
      public Adapter caseRule185(Rule185 object)
      {
        return createRule185Adapter();
      }
      @Override
      public Adapter caseRule186(Rule186 object)
      {
        return createRule186Adapter();
      }
      @Override
      public Adapter caseRule187(Rule187 object)
      {
        return createRule187Adapter();
      }
      @Override
      public Adapter caseRule188(Rule188 object)
      {
        return createRule188Adapter();
      }
      @Override
      public Adapter caseRule189(Rule189 object)
      {
        return createRule189Adapter();
      }
      @Override
      public Adapter caseRule190(Rule190 object)
      {
        return createRule190Adapter();
      }
      @Override
      public Adapter caseRule191(Rule191 object)
      {
        return createRule191Adapter();
      }
      @Override
      public Adapter caseRule192(Rule192 object)
      {
        return createRule192Adapter();
      }
      @Override
      public Adapter caseRule193(Rule193 object)
      {
        return createRule193Adapter();
      }
      @Override
      public Adapter caseRule194(Rule194 object)
      {
        return createRule194Adapter();
      }
      @Override
      public Adapter caseRule195(Rule195 object)
      {
        return createRule195Adapter();
      }
      @Override
      public Adapter caseRule196(Rule196 object)
      {
        return createRule196Adapter();
      }
      @Override
      public Adapter caseRule197(Rule197 object)
      {
        return createRule197Adapter();
      }
      @Override
      public Adapter caseRule198(Rule198 object)
      {
        return createRule198Adapter();
      }
      @Override
      public Adapter caseRule199(Rule199 object)
      {
        return createRule199Adapter();
      }
      @Override
      public Adapter caseRule200(Rule200 object)
      {
        return createRule200Adapter();
      }
      @Override
      public Adapter caseRule201(Rule201 object)
      {
        return createRule201Adapter();
      }
      @Override
      public Adapter caseRule202(Rule202 object)
      {
        return createRule202Adapter();
      }
      @Override
      public Adapter caseRule203(Rule203 object)
      {
        return createRule203Adapter();
      }
      @Override
      public Adapter caseRule204(Rule204 object)
      {
        return createRule204Adapter();
      }
      @Override
      public Adapter caseRule205(Rule205 object)
      {
        return createRule205Adapter();
      }
      @Override
      public Adapter caseRule206(Rule206 object)
      {
        return createRule206Adapter();
      }
      @Override
      public Adapter caseRule207(Rule207 object)
      {
        return createRule207Adapter();
      }
      @Override
      public Adapter caseRule208(Rule208 object)
      {
        return createRule208Adapter();
      }
      @Override
      public Adapter caseRule209(Rule209 object)
      {
        return createRule209Adapter();
      }
      @Override
      public Adapter caseRule210(Rule210 object)
      {
        return createRule210Adapter();
      }
      @Override
      public Adapter caseRule211(Rule211 object)
      {
        return createRule211Adapter();
      }
      @Override
      public Adapter caseRule212(Rule212 object)
      {
        return createRule212Adapter();
      }
      @Override
      public Adapter caseRule213(Rule213 object)
      {
        return createRule213Adapter();
      }
      @Override
      public Adapter caseRule214(Rule214 object)
      {
        return createRule214Adapter();
      }
      @Override
      public Adapter caseRule215(Rule215 object)
      {
        return createRule215Adapter();
      }
      @Override
      public Adapter caseRule216(Rule216 object)
      {
        return createRule216Adapter();
      }
      @Override
      public Adapter caseRule217(Rule217 object)
      {
        return createRule217Adapter();
      }
      @Override
      public Adapter caseRule218(Rule218 object)
      {
        return createRule218Adapter();
      }
      @Override
      public Adapter caseRule219(Rule219 object)
      {
        return createRule219Adapter();
      }
      @Override
      public Adapter caseRule220(Rule220 object)
      {
        return createRule220Adapter();
      }
      @Override
      public Adapter caseRule221(Rule221 object)
      {
        return createRule221Adapter();
      }
      @Override
      public Adapter caseRule222(Rule222 object)
      {
        return createRule222Adapter();
      }
      @Override
      public Adapter caseRule223(Rule223 object)
      {
        return createRule223Adapter();
      }
      @Override
      public Adapter caseRule224(Rule224 object)
      {
        return createRule224Adapter();
      }
      @Override
      public Adapter caseRule225(Rule225 object)
      {
        return createRule225Adapter();
      }
      @Override
      public Adapter caseRule226(Rule226 object)
      {
        return createRule226Adapter();
      }
      @Override
      public Adapter caseRule227(Rule227 object)
      {
        return createRule227Adapter();
      }
      @Override
      public Adapter caseRule228(Rule228 object)
      {
        return createRule228Adapter();
      }
      @Override
      public Adapter caseRule229(Rule229 object)
      {
        return createRule229Adapter();
      }
      @Override
      public Adapter caseRule230(Rule230 object)
      {
        return createRule230Adapter();
      }
      @Override
      public Adapter caseRule231(Rule231 object)
      {
        return createRule231Adapter();
      }
      @Override
      public Adapter caseRule232(Rule232 object)
      {
        return createRule232Adapter();
      }
      @Override
      public Adapter caseRule233(Rule233 object)
      {
        return createRule233Adapter();
      }
      @Override
      public Adapter caseRule234(Rule234 object)
      {
        return createRule234Adapter();
      }
      @Override
      public Adapter caseRule235(Rule235 object)
      {
        return createRule235Adapter();
      }
      @Override
      public Adapter caseRule236(Rule236 object)
      {
        return createRule236Adapter();
      }
      @Override
      public Adapter caseRule237(Rule237 object)
      {
        return createRule237Adapter();
      }
      @Override
      public Adapter caseRule238(Rule238 object)
      {
        return createRule238Adapter();
      }
      @Override
      public Adapter caseRule239(Rule239 object)
      {
        return createRule239Adapter();
      }
      @Override
      public Adapter caseRule240(Rule240 object)
      {
        return createRule240Adapter();
      }
      @Override
      public Adapter caseRule241(Rule241 object)
      {
        return createRule241Adapter();
      }
      @Override
      public Adapter caseRule242(Rule242 object)
      {
        return createRule242Adapter();
      }
      @Override
      public Adapter caseRule243(Rule243 object)
      {
        return createRule243Adapter();
      }
      @Override
      public Adapter caseRule244(Rule244 object)
      {
        return createRule244Adapter();
      }
      @Override
      public Adapter caseRule245(Rule245 object)
      {
        return createRule245Adapter();
      }
      @Override
      public Adapter caseRule246(Rule246 object)
      {
        return createRule246Adapter();
      }
      @Override
      public Adapter caseRule247(Rule247 object)
      {
        return createRule247Adapter();
      }
      @Override
      public Adapter caseRule248(Rule248 object)
      {
        return createRule248Adapter();
      }
      @Override
      public Adapter caseRule249(Rule249 object)
      {
        return createRule249Adapter();
      }
      @Override
      public Adapter caseRule250(Rule250 object)
      {
        return createRule250Adapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule
   * @generated
   */
  public Adapter createRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule1 <em>Rule1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule1
   * @generated
   */
  public Adapter createRule1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule2 <em>Rule2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule2
   * @generated
   */
  public Adapter createRule2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule3 <em>Rule3</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule3
   * @generated
   */
  public Adapter createRule3Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule4 <em>Rule4</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule4
   * @generated
   */
  public Adapter createRule4Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule5 <em>Rule5</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule5
   * @generated
   */
  public Adapter createRule5Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule6 <em>Rule6</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule6
   * @generated
   */
  public Adapter createRule6Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule7 <em>Rule7</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule7
   * @generated
   */
  public Adapter createRule7Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule8 <em>Rule8</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule8
   * @generated
   */
  public Adapter createRule8Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule9 <em>Rule9</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule9
   * @generated
   */
  public Adapter createRule9Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule10 <em>Rule10</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule10
   * @generated
   */
  public Adapter createRule10Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule11 <em>Rule11</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule11
   * @generated
   */
  public Adapter createRule11Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule12 <em>Rule12</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule12
   * @generated
   */
  public Adapter createRule12Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule13 <em>Rule13</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule13
   * @generated
   */
  public Adapter createRule13Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule14 <em>Rule14</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule14
   * @generated
   */
  public Adapter createRule14Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule15 <em>Rule15</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule15
   * @generated
   */
  public Adapter createRule15Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule16 <em>Rule16</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule16
   * @generated
   */
  public Adapter createRule16Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule17 <em>Rule17</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule17
   * @generated
   */
  public Adapter createRule17Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule18 <em>Rule18</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule18
   * @generated
   */
  public Adapter createRule18Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule19 <em>Rule19</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule19
   * @generated
   */
  public Adapter createRule19Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule20 <em>Rule20</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule20
   * @generated
   */
  public Adapter createRule20Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule21 <em>Rule21</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule21
   * @generated
   */
  public Adapter createRule21Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule22 <em>Rule22</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule22
   * @generated
   */
  public Adapter createRule22Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule23 <em>Rule23</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule23
   * @generated
   */
  public Adapter createRule23Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule24 <em>Rule24</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule24
   * @generated
   */
  public Adapter createRule24Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule25 <em>Rule25</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule25
   * @generated
   */
  public Adapter createRule25Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule26 <em>Rule26</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule26
   * @generated
   */
  public Adapter createRule26Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule27 <em>Rule27</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule27
   * @generated
   */
  public Adapter createRule27Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule28 <em>Rule28</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule28
   * @generated
   */
  public Adapter createRule28Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule29 <em>Rule29</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule29
   * @generated
   */
  public Adapter createRule29Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule30 <em>Rule30</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule30
   * @generated
   */
  public Adapter createRule30Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule31 <em>Rule31</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule31
   * @generated
   */
  public Adapter createRule31Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule32 <em>Rule32</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule32
   * @generated
   */
  public Adapter createRule32Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule33 <em>Rule33</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule33
   * @generated
   */
  public Adapter createRule33Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule34 <em>Rule34</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule34
   * @generated
   */
  public Adapter createRule34Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule35 <em>Rule35</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule35
   * @generated
   */
  public Adapter createRule35Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule36 <em>Rule36</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule36
   * @generated
   */
  public Adapter createRule36Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule37 <em>Rule37</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule37
   * @generated
   */
  public Adapter createRule37Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule38 <em>Rule38</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule38
   * @generated
   */
  public Adapter createRule38Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule39 <em>Rule39</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule39
   * @generated
   */
  public Adapter createRule39Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule40 <em>Rule40</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule40
   * @generated
   */
  public Adapter createRule40Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule41 <em>Rule41</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule41
   * @generated
   */
  public Adapter createRule41Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule42 <em>Rule42</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule42
   * @generated
   */
  public Adapter createRule42Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule43 <em>Rule43</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule43
   * @generated
   */
  public Adapter createRule43Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule44 <em>Rule44</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule44
   * @generated
   */
  public Adapter createRule44Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule45 <em>Rule45</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule45
   * @generated
   */
  public Adapter createRule45Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule46 <em>Rule46</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule46
   * @generated
   */
  public Adapter createRule46Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule47 <em>Rule47</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule47
   * @generated
   */
  public Adapter createRule47Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule48 <em>Rule48</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule48
   * @generated
   */
  public Adapter createRule48Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule49 <em>Rule49</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule49
   * @generated
   */
  public Adapter createRule49Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule50 <em>Rule50</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule50
   * @generated
   */
  public Adapter createRule50Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule51 <em>Rule51</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule51
   * @generated
   */
  public Adapter createRule51Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule52 <em>Rule52</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule52
   * @generated
   */
  public Adapter createRule52Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule53 <em>Rule53</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule53
   * @generated
   */
  public Adapter createRule53Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule54 <em>Rule54</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule54
   * @generated
   */
  public Adapter createRule54Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule55 <em>Rule55</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule55
   * @generated
   */
  public Adapter createRule55Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule56 <em>Rule56</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule56
   * @generated
   */
  public Adapter createRule56Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule57 <em>Rule57</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule57
   * @generated
   */
  public Adapter createRule57Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule58 <em>Rule58</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule58
   * @generated
   */
  public Adapter createRule58Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule59 <em>Rule59</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule59
   * @generated
   */
  public Adapter createRule59Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule60 <em>Rule60</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule60
   * @generated
   */
  public Adapter createRule60Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule61 <em>Rule61</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule61
   * @generated
   */
  public Adapter createRule61Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule62 <em>Rule62</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule62
   * @generated
   */
  public Adapter createRule62Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule63 <em>Rule63</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule63
   * @generated
   */
  public Adapter createRule63Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule64 <em>Rule64</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule64
   * @generated
   */
  public Adapter createRule64Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule65 <em>Rule65</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule65
   * @generated
   */
  public Adapter createRule65Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule66 <em>Rule66</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule66
   * @generated
   */
  public Adapter createRule66Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule67 <em>Rule67</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule67
   * @generated
   */
  public Adapter createRule67Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule68 <em>Rule68</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule68
   * @generated
   */
  public Adapter createRule68Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule69 <em>Rule69</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule69
   * @generated
   */
  public Adapter createRule69Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule70 <em>Rule70</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule70
   * @generated
   */
  public Adapter createRule70Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule71 <em>Rule71</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule71
   * @generated
   */
  public Adapter createRule71Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule72 <em>Rule72</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule72
   * @generated
   */
  public Adapter createRule72Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule73 <em>Rule73</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule73
   * @generated
   */
  public Adapter createRule73Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule74 <em>Rule74</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule74
   * @generated
   */
  public Adapter createRule74Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule75 <em>Rule75</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule75
   * @generated
   */
  public Adapter createRule75Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule76 <em>Rule76</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule76
   * @generated
   */
  public Adapter createRule76Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule77 <em>Rule77</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule77
   * @generated
   */
  public Adapter createRule77Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule78 <em>Rule78</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule78
   * @generated
   */
  public Adapter createRule78Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule79 <em>Rule79</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule79
   * @generated
   */
  public Adapter createRule79Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule80 <em>Rule80</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule80
   * @generated
   */
  public Adapter createRule80Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule81 <em>Rule81</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule81
   * @generated
   */
  public Adapter createRule81Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule82 <em>Rule82</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule82
   * @generated
   */
  public Adapter createRule82Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule83 <em>Rule83</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule83
   * @generated
   */
  public Adapter createRule83Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule84 <em>Rule84</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule84
   * @generated
   */
  public Adapter createRule84Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule85 <em>Rule85</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule85
   * @generated
   */
  public Adapter createRule85Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule86 <em>Rule86</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule86
   * @generated
   */
  public Adapter createRule86Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule87 <em>Rule87</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule87
   * @generated
   */
  public Adapter createRule87Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule88 <em>Rule88</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule88
   * @generated
   */
  public Adapter createRule88Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule89 <em>Rule89</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule89
   * @generated
   */
  public Adapter createRule89Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule90 <em>Rule90</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule90
   * @generated
   */
  public Adapter createRule90Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule91 <em>Rule91</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule91
   * @generated
   */
  public Adapter createRule91Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule92 <em>Rule92</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule92
   * @generated
   */
  public Adapter createRule92Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule93 <em>Rule93</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule93
   * @generated
   */
  public Adapter createRule93Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule94 <em>Rule94</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule94
   * @generated
   */
  public Adapter createRule94Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule95 <em>Rule95</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule95
   * @generated
   */
  public Adapter createRule95Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule96 <em>Rule96</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule96
   * @generated
   */
  public Adapter createRule96Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule97 <em>Rule97</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule97
   * @generated
   */
  public Adapter createRule97Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule98 <em>Rule98</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule98
   * @generated
   */
  public Adapter createRule98Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule99 <em>Rule99</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule99
   * @generated
   */
  public Adapter createRule99Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule100 <em>Rule100</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule100
   * @generated
   */
  public Adapter createRule100Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule101 <em>Rule101</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule101
   * @generated
   */
  public Adapter createRule101Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule102 <em>Rule102</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule102
   * @generated
   */
  public Adapter createRule102Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule103 <em>Rule103</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule103
   * @generated
   */
  public Adapter createRule103Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule104 <em>Rule104</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule104
   * @generated
   */
  public Adapter createRule104Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule105 <em>Rule105</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule105
   * @generated
   */
  public Adapter createRule105Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule106 <em>Rule106</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule106
   * @generated
   */
  public Adapter createRule106Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule107 <em>Rule107</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule107
   * @generated
   */
  public Adapter createRule107Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule108 <em>Rule108</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule108
   * @generated
   */
  public Adapter createRule108Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule109 <em>Rule109</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule109
   * @generated
   */
  public Adapter createRule109Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule110 <em>Rule110</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule110
   * @generated
   */
  public Adapter createRule110Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule111 <em>Rule111</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule111
   * @generated
   */
  public Adapter createRule111Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule112 <em>Rule112</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule112
   * @generated
   */
  public Adapter createRule112Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule113 <em>Rule113</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule113
   * @generated
   */
  public Adapter createRule113Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule114 <em>Rule114</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule114
   * @generated
   */
  public Adapter createRule114Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule115 <em>Rule115</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule115
   * @generated
   */
  public Adapter createRule115Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule116 <em>Rule116</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule116
   * @generated
   */
  public Adapter createRule116Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule117 <em>Rule117</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule117
   * @generated
   */
  public Adapter createRule117Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule118 <em>Rule118</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule118
   * @generated
   */
  public Adapter createRule118Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule119 <em>Rule119</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule119
   * @generated
   */
  public Adapter createRule119Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule120 <em>Rule120</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule120
   * @generated
   */
  public Adapter createRule120Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule121 <em>Rule121</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule121
   * @generated
   */
  public Adapter createRule121Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule122 <em>Rule122</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule122
   * @generated
   */
  public Adapter createRule122Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule123 <em>Rule123</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule123
   * @generated
   */
  public Adapter createRule123Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule124 <em>Rule124</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule124
   * @generated
   */
  public Adapter createRule124Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule125 <em>Rule125</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule125
   * @generated
   */
  public Adapter createRule125Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule126 <em>Rule126</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule126
   * @generated
   */
  public Adapter createRule126Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule127 <em>Rule127</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule127
   * @generated
   */
  public Adapter createRule127Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule128 <em>Rule128</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule128
   * @generated
   */
  public Adapter createRule128Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule129 <em>Rule129</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule129
   * @generated
   */
  public Adapter createRule129Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule130 <em>Rule130</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule130
   * @generated
   */
  public Adapter createRule130Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule131 <em>Rule131</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule131
   * @generated
   */
  public Adapter createRule131Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule132 <em>Rule132</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule132
   * @generated
   */
  public Adapter createRule132Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule133 <em>Rule133</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule133
   * @generated
   */
  public Adapter createRule133Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule134 <em>Rule134</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule134
   * @generated
   */
  public Adapter createRule134Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule135 <em>Rule135</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule135
   * @generated
   */
  public Adapter createRule135Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule136 <em>Rule136</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule136
   * @generated
   */
  public Adapter createRule136Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule137 <em>Rule137</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule137
   * @generated
   */
  public Adapter createRule137Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule138 <em>Rule138</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule138
   * @generated
   */
  public Adapter createRule138Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule139 <em>Rule139</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule139
   * @generated
   */
  public Adapter createRule139Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule140 <em>Rule140</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule140
   * @generated
   */
  public Adapter createRule140Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule141 <em>Rule141</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule141
   * @generated
   */
  public Adapter createRule141Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule142 <em>Rule142</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule142
   * @generated
   */
  public Adapter createRule142Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule143 <em>Rule143</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule143
   * @generated
   */
  public Adapter createRule143Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule144 <em>Rule144</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule144
   * @generated
   */
  public Adapter createRule144Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule145 <em>Rule145</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule145
   * @generated
   */
  public Adapter createRule145Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule146 <em>Rule146</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule146
   * @generated
   */
  public Adapter createRule146Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule147 <em>Rule147</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule147
   * @generated
   */
  public Adapter createRule147Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule148 <em>Rule148</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule148
   * @generated
   */
  public Adapter createRule148Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule149 <em>Rule149</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule149
   * @generated
   */
  public Adapter createRule149Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule150 <em>Rule150</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule150
   * @generated
   */
  public Adapter createRule150Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule151 <em>Rule151</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule151
   * @generated
   */
  public Adapter createRule151Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule152 <em>Rule152</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule152
   * @generated
   */
  public Adapter createRule152Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule153 <em>Rule153</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule153
   * @generated
   */
  public Adapter createRule153Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule154 <em>Rule154</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule154
   * @generated
   */
  public Adapter createRule154Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule155 <em>Rule155</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule155
   * @generated
   */
  public Adapter createRule155Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule156 <em>Rule156</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule156
   * @generated
   */
  public Adapter createRule156Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule157 <em>Rule157</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule157
   * @generated
   */
  public Adapter createRule157Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule158 <em>Rule158</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule158
   * @generated
   */
  public Adapter createRule158Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule159 <em>Rule159</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule159
   * @generated
   */
  public Adapter createRule159Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule160 <em>Rule160</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule160
   * @generated
   */
  public Adapter createRule160Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule161 <em>Rule161</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule161
   * @generated
   */
  public Adapter createRule161Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule162 <em>Rule162</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule162
   * @generated
   */
  public Adapter createRule162Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule163 <em>Rule163</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule163
   * @generated
   */
  public Adapter createRule163Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule164 <em>Rule164</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule164
   * @generated
   */
  public Adapter createRule164Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule165 <em>Rule165</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule165
   * @generated
   */
  public Adapter createRule165Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule166 <em>Rule166</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule166
   * @generated
   */
  public Adapter createRule166Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule167 <em>Rule167</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule167
   * @generated
   */
  public Adapter createRule167Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule168 <em>Rule168</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule168
   * @generated
   */
  public Adapter createRule168Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule169 <em>Rule169</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule169
   * @generated
   */
  public Adapter createRule169Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule170 <em>Rule170</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule170
   * @generated
   */
  public Adapter createRule170Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule171 <em>Rule171</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule171
   * @generated
   */
  public Adapter createRule171Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule172 <em>Rule172</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule172
   * @generated
   */
  public Adapter createRule172Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule173 <em>Rule173</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule173
   * @generated
   */
  public Adapter createRule173Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule174 <em>Rule174</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule174
   * @generated
   */
  public Adapter createRule174Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule175 <em>Rule175</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule175
   * @generated
   */
  public Adapter createRule175Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule176 <em>Rule176</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule176
   * @generated
   */
  public Adapter createRule176Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule177 <em>Rule177</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule177
   * @generated
   */
  public Adapter createRule177Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule178 <em>Rule178</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule178
   * @generated
   */
  public Adapter createRule178Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule179 <em>Rule179</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule179
   * @generated
   */
  public Adapter createRule179Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule180 <em>Rule180</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule180
   * @generated
   */
  public Adapter createRule180Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule181 <em>Rule181</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule181
   * @generated
   */
  public Adapter createRule181Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule182 <em>Rule182</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule182
   * @generated
   */
  public Adapter createRule182Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule183 <em>Rule183</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule183
   * @generated
   */
  public Adapter createRule183Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule184 <em>Rule184</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule184
   * @generated
   */
  public Adapter createRule184Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule185 <em>Rule185</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule185
   * @generated
   */
  public Adapter createRule185Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule186 <em>Rule186</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule186
   * @generated
   */
  public Adapter createRule186Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule187 <em>Rule187</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule187
   * @generated
   */
  public Adapter createRule187Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule188 <em>Rule188</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule188
   * @generated
   */
  public Adapter createRule188Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule189 <em>Rule189</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule189
   * @generated
   */
  public Adapter createRule189Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule190 <em>Rule190</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule190
   * @generated
   */
  public Adapter createRule190Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule191 <em>Rule191</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule191
   * @generated
   */
  public Adapter createRule191Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule192 <em>Rule192</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule192
   * @generated
   */
  public Adapter createRule192Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule193 <em>Rule193</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule193
   * @generated
   */
  public Adapter createRule193Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule194 <em>Rule194</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule194
   * @generated
   */
  public Adapter createRule194Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule195 <em>Rule195</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule195
   * @generated
   */
  public Adapter createRule195Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule196 <em>Rule196</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule196
   * @generated
   */
  public Adapter createRule196Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule197 <em>Rule197</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule197
   * @generated
   */
  public Adapter createRule197Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule198 <em>Rule198</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule198
   * @generated
   */
  public Adapter createRule198Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule199 <em>Rule199</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule199
   * @generated
   */
  public Adapter createRule199Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule200 <em>Rule200</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule200
   * @generated
   */
  public Adapter createRule200Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule201 <em>Rule201</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule201
   * @generated
   */
  public Adapter createRule201Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule202 <em>Rule202</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule202
   * @generated
   */
  public Adapter createRule202Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule203 <em>Rule203</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule203
   * @generated
   */
  public Adapter createRule203Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule204 <em>Rule204</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule204
   * @generated
   */
  public Adapter createRule204Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule205 <em>Rule205</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule205
   * @generated
   */
  public Adapter createRule205Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule206 <em>Rule206</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule206
   * @generated
   */
  public Adapter createRule206Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule207 <em>Rule207</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule207
   * @generated
   */
  public Adapter createRule207Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule208 <em>Rule208</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule208
   * @generated
   */
  public Adapter createRule208Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule209 <em>Rule209</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule209
   * @generated
   */
  public Adapter createRule209Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule210 <em>Rule210</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule210
   * @generated
   */
  public Adapter createRule210Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule211 <em>Rule211</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule211
   * @generated
   */
  public Adapter createRule211Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule212 <em>Rule212</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule212
   * @generated
   */
  public Adapter createRule212Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule213 <em>Rule213</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule213
   * @generated
   */
  public Adapter createRule213Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule214 <em>Rule214</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule214
   * @generated
   */
  public Adapter createRule214Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule215 <em>Rule215</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule215
   * @generated
   */
  public Adapter createRule215Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule216 <em>Rule216</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule216
   * @generated
   */
  public Adapter createRule216Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule217 <em>Rule217</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule217
   * @generated
   */
  public Adapter createRule217Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule218 <em>Rule218</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule218
   * @generated
   */
  public Adapter createRule218Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule219 <em>Rule219</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule219
   * @generated
   */
  public Adapter createRule219Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule220 <em>Rule220</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule220
   * @generated
   */
  public Adapter createRule220Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule221 <em>Rule221</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule221
   * @generated
   */
  public Adapter createRule221Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule222 <em>Rule222</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule222
   * @generated
   */
  public Adapter createRule222Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule223 <em>Rule223</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule223
   * @generated
   */
  public Adapter createRule223Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule224 <em>Rule224</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule224
   * @generated
   */
  public Adapter createRule224Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule225 <em>Rule225</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule225
   * @generated
   */
  public Adapter createRule225Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule226 <em>Rule226</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule226
   * @generated
   */
  public Adapter createRule226Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule227 <em>Rule227</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule227
   * @generated
   */
  public Adapter createRule227Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule228 <em>Rule228</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule228
   * @generated
   */
  public Adapter createRule228Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule229 <em>Rule229</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule229
   * @generated
   */
  public Adapter createRule229Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule230 <em>Rule230</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule230
   * @generated
   */
  public Adapter createRule230Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule231 <em>Rule231</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule231
   * @generated
   */
  public Adapter createRule231Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule232 <em>Rule232</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule232
   * @generated
   */
  public Adapter createRule232Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule233 <em>Rule233</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule233
   * @generated
   */
  public Adapter createRule233Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule234 <em>Rule234</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule234
   * @generated
   */
  public Adapter createRule234Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule235 <em>Rule235</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule235
   * @generated
   */
  public Adapter createRule235Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule236 <em>Rule236</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule236
   * @generated
   */
  public Adapter createRule236Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule237 <em>Rule237</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule237
   * @generated
   */
  public Adapter createRule237Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule238 <em>Rule238</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule238
   * @generated
   */
  public Adapter createRule238Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule239 <em>Rule239</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule239
   * @generated
   */
  public Adapter createRule239Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule240 <em>Rule240</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule240
   * @generated
   */
  public Adapter createRule240Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule241 <em>Rule241</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule241
   * @generated
   */
  public Adapter createRule241Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule242 <em>Rule242</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule242
   * @generated
   */
  public Adapter createRule242Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule243 <em>Rule243</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule243
   * @generated
   */
  public Adapter createRule243Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule244 <em>Rule244</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule244
   * @generated
   */
  public Adapter createRule244Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule245 <em>Rule245</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule245
   * @generated
   */
  public Adapter createRule245Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule246 <em>Rule246</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule246
   * @generated
   */
  public Adapter createRule246Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule247 <em>Rule247</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule247
   * @generated
   */
  public Adapter createRule247Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule248 <em>Rule248</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule248
   * @generated
   */
  public Adapter createRule248Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule249 <em>Rule249</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule249
   * @generated
   */
  public Adapter createRule249Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.generatorTestLanguage.Rule250 <em>Rule250</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.generatorTestLanguage.Rule250
   * @generated
   */
  public Adapter createRule250Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //GeneratorTestLanguageAdapterFactory
