/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.generatorTestLanguage.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.generator.generatorTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.generatorTestLanguage.GeneratorTestLanguagePackage
 * @generated
 */
public class GeneratorTestLanguageSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GeneratorTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GeneratorTestLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = GeneratorTestLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case GeneratorTestLanguagePackage.RULE:
      {
        Rule rule = (Rule)theEObject;
        T result = caseRule(rule);
        if (result == null) result = caseRule1(rule);
        if (result == null) result = caseRule2(rule);
        if (result == null) result = caseRule3(rule);
        if (result == null) result = caseRule4(rule);
        if (result == null) result = caseRule5(rule);
        if (result == null) result = caseRule6(rule);
        if (result == null) result = caseRule7(rule);
        if (result == null) result = caseRule8(rule);
        if (result == null) result = caseRule9(rule);
        if (result == null) result = caseRule10(rule);
        if (result == null) result = caseRule11(rule);
        if (result == null) result = caseRule12(rule);
        if (result == null) result = caseRule13(rule);
        if (result == null) result = caseRule14(rule);
        if (result == null) result = caseRule15(rule);
        if (result == null) result = caseRule16(rule);
        if (result == null) result = caseRule17(rule);
        if (result == null) result = caseRule18(rule);
        if (result == null) result = caseRule19(rule);
        if (result == null) result = caseRule20(rule);
        if (result == null) result = caseRule21(rule);
        if (result == null) result = caseRule22(rule);
        if (result == null) result = caseRule23(rule);
        if (result == null) result = caseRule24(rule);
        if (result == null) result = caseRule25(rule);
        if (result == null) result = caseRule26(rule);
        if (result == null) result = caseRule27(rule);
        if (result == null) result = caseRule28(rule);
        if (result == null) result = caseRule29(rule);
        if (result == null) result = caseRule30(rule);
        if (result == null) result = caseRule31(rule);
        if (result == null) result = caseRule32(rule);
        if (result == null) result = caseRule33(rule);
        if (result == null) result = caseRule34(rule);
        if (result == null) result = caseRule35(rule);
        if (result == null) result = caseRule36(rule);
        if (result == null) result = caseRule37(rule);
        if (result == null) result = caseRule38(rule);
        if (result == null) result = caseRule39(rule);
        if (result == null) result = caseRule40(rule);
        if (result == null) result = caseRule41(rule);
        if (result == null) result = caseRule42(rule);
        if (result == null) result = caseRule43(rule);
        if (result == null) result = caseRule44(rule);
        if (result == null) result = caseRule45(rule);
        if (result == null) result = caseRule46(rule);
        if (result == null) result = caseRule47(rule);
        if (result == null) result = caseRule48(rule);
        if (result == null) result = caseRule49(rule);
        if (result == null) result = caseRule50(rule);
        if (result == null) result = caseRule51(rule);
        if (result == null) result = caseRule52(rule);
        if (result == null) result = caseRule53(rule);
        if (result == null) result = caseRule54(rule);
        if (result == null) result = caseRule55(rule);
        if (result == null) result = caseRule56(rule);
        if (result == null) result = caseRule57(rule);
        if (result == null) result = caseRule58(rule);
        if (result == null) result = caseRule59(rule);
        if (result == null) result = caseRule60(rule);
        if (result == null) result = caseRule61(rule);
        if (result == null) result = caseRule62(rule);
        if (result == null) result = caseRule63(rule);
        if (result == null) result = caseRule64(rule);
        if (result == null) result = caseRule65(rule);
        if (result == null) result = caseRule66(rule);
        if (result == null) result = caseRule67(rule);
        if (result == null) result = caseRule68(rule);
        if (result == null) result = caseRule69(rule);
        if (result == null) result = caseRule70(rule);
        if (result == null) result = caseRule71(rule);
        if (result == null) result = caseRule72(rule);
        if (result == null) result = caseRule73(rule);
        if (result == null) result = caseRule74(rule);
        if (result == null) result = caseRule75(rule);
        if (result == null) result = caseRule76(rule);
        if (result == null) result = caseRule77(rule);
        if (result == null) result = caseRule78(rule);
        if (result == null) result = caseRule79(rule);
        if (result == null) result = caseRule80(rule);
        if (result == null) result = caseRule81(rule);
        if (result == null) result = caseRule82(rule);
        if (result == null) result = caseRule83(rule);
        if (result == null) result = caseRule84(rule);
        if (result == null) result = caseRule85(rule);
        if (result == null) result = caseRule86(rule);
        if (result == null) result = caseRule87(rule);
        if (result == null) result = caseRule88(rule);
        if (result == null) result = caseRule89(rule);
        if (result == null) result = caseRule90(rule);
        if (result == null) result = caseRule91(rule);
        if (result == null) result = caseRule92(rule);
        if (result == null) result = caseRule93(rule);
        if (result == null) result = caseRule94(rule);
        if (result == null) result = caseRule95(rule);
        if (result == null) result = caseRule96(rule);
        if (result == null) result = caseRule97(rule);
        if (result == null) result = caseRule98(rule);
        if (result == null) result = caseRule99(rule);
        if (result == null) result = caseRule100(rule);
        if (result == null) result = caseRule101(rule);
        if (result == null) result = caseRule102(rule);
        if (result == null) result = caseRule103(rule);
        if (result == null) result = caseRule104(rule);
        if (result == null) result = caseRule105(rule);
        if (result == null) result = caseRule106(rule);
        if (result == null) result = caseRule107(rule);
        if (result == null) result = caseRule108(rule);
        if (result == null) result = caseRule109(rule);
        if (result == null) result = caseRule110(rule);
        if (result == null) result = caseRule111(rule);
        if (result == null) result = caseRule112(rule);
        if (result == null) result = caseRule113(rule);
        if (result == null) result = caseRule114(rule);
        if (result == null) result = caseRule115(rule);
        if (result == null) result = caseRule116(rule);
        if (result == null) result = caseRule117(rule);
        if (result == null) result = caseRule118(rule);
        if (result == null) result = caseRule119(rule);
        if (result == null) result = caseRule120(rule);
        if (result == null) result = caseRule121(rule);
        if (result == null) result = caseRule122(rule);
        if (result == null) result = caseRule123(rule);
        if (result == null) result = caseRule124(rule);
        if (result == null) result = caseRule125(rule);
        if (result == null) result = caseRule126(rule);
        if (result == null) result = caseRule127(rule);
        if (result == null) result = caseRule128(rule);
        if (result == null) result = caseRule129(rule);
        if (result == null) result = caseRule130(rule);
        if (result == null) result = caseRule131(rule);
        if (result == null) result = caseRule132(rule);
        if (result == null) result = caseRule133(rule);
        if (result == null) result = caseRule134(rule);
        if (result == null) result = caseRule135(rule);
        if (result == null) result = caseRule136(rule);
        if (result == null) result = caseRule137(rule);
        if (result == null) result = caseRule138(rule);
        if (result == null) result = caseRule139(rule);
        if (result == null) result = caseRule140(rule);
        if (result == null) result = caseRule141(rule);
        if (result == null) result = caseRule142(rule);
        if (result == null) result = caseRule143(rule);
        if (result == null) result = caseRule144(rule);
        if (result == null) result = caseRule145(rule);
        if (result == null) result = caseRule146(rule);
        if (result == null) result = caseRule147(rule);
        if (result == null) result = caseRule148(rule);
        if (result == null) result = caseRule149(rule);
        if (result == null) result = caseRule150(rule);
        if (result == null) result = caseRule151(rule);
        if (result == null) result = caseRule152(rule);
        if (result == null) result = caseRule153(rule);
        if (result == null) result = caseRule154(rule);
        if (result == null) result = caseRule155(rule);
        if (result == null) result = caseRule156(rule);
        if (result == null) result = caseRule157(rule);
        if (result == null) result = caseRule158(rule);
        if (result == null) result = caseRule159(rule);
        if (result == null) result = caseRule160(rule);
        if (result == null) result = caseRule161(rule);
        if (result == null) result = caseRule162(rule);
        if (result == null) result = caseRule163(rule);
        if (result == null) result = caseRule164(rule);
        if (result == null) result = caseRule165(rule);
        if (result == null) result = caseRule166(rule);
        if (result == null) result = caseRule167(rule);
        if (result == null) result = caseRule168(rule);
        if (result == null) result = caseRule169(rule);
        if (result == null) result = caseRule170(rule);
        if (result == null) result = caseRule171(rule);
        if (result == null) result = caseRule172(rule);
        if (result == null) result = caseRule173(rule);
        if (result == null) result = caseRule174(rule);
        if (result == null) result = caseRule175(rule);
        if (result == null) result = caseRule176(rule);
        if (result == null) result = caseRule177(rule);
        if (result == null) result = caseRule178(rule);
        if (result == null) result = caseRule179(rule);
        if (result == null) result = caseRule180(rule);
        if (result == null) result = caseRule181(rule);
        if (result == null) result = caseRule182(rule);
        if (result == null) result = caseRule183(rule);
        if (result == null) result = caseRule184(rule);
        if (result == null) result = caseRule185(rule);
        if (result == null) result = caseRule186(rule);
        if (result == null) result = caseRule187(rule);
        if (result == null) result = caseRule188(rule);
        if (result == null) result = caseRule189(rule);
        if (result == null) result = caseRule190(rule);
        if (result == null) result = caseRule191(rule);
        if (result == null) result = caseRule192(rule);
        if (result == null) result = caseRule193(rule);
        if (result == null) result = caseRule194(rule);
        if (result == null) result = caseRule195(rule);
        if (result == null) result = caseRule196(rule);
        if (result == null) result = caseRule197(rule);
        if (result == null) result = caseRule198(rule);
        if (result == null) result = caseRule199(rule);
        if (result == null) result = caseRule200(rule);
        if (result == null) result = caseRule201(rule);
        if (result == null) result = caseRule202(rule);
        if (result == null) result = caseRule203(rule);
        if (result == null) result = caseRule204(rule);
        if (result == null) result = caseRule205(rule);
        if (result == null) result = caseRule206(rule);
        if (result == null) result = caseRule207(rule);
        if (result == null) result = caseRule208(rule);
        if (result == null) result = caseRule209(rule);
        if (result == null) result = caseRule210(rule);
        if (result == null) result = caseRule211(rule);
        if (result == null) result = caseRule212(rule);
        if (result == null) result = caseRule213(rule);
        if (result == null) result = caseRule214(rule);
        if (result == null) result = caseRule215(rule);
        if (result == null) result = caseRule216(rule);
        if (result == null) result = caseRule217(rule);
        if (result == null) result = caseRule218(rule);
        if (result == null) result = caseRule219(rule);
        if (result == null) result = caseRule220(rule);
        if (result == null) result = caseRule221(rule);
        if (result == null) result = caseRule222(rule);
        if (result == null) result = caseRule223(rule);
        if (result == null) result = caseRule224(rule);
        if (result == null) result = caseRule225(rule);
        if (result == null) result = caseRule226(rule);
        if (result == null) result = caseRule227(rule);
        if (result == null) result = caseRule228(rule);
        if (result == null) result = caseRule229(rule);
        if (result == null) result = caseRule230(rule);
        if (result == null) result = caseRule231(rule);
        if (result == null) result = caseRule232(rule);
        if (result == null) result = caseRule233(rule);
        if (result == null) result = caseRule234(rule);
        if (result == null) result = caseRule235(rule);
        if (result == null) result = caseRule236(rule);
        if (result == null) result = caseRule237(rule);
        if (result == null) result = caseRule238(rule);
        if (result == null) result = caseRule239(rule);
        if (result == null) result = caseRule240(rule);
        if (result == null) result = caseRule241(rule);
        if (result == null) result = caseRule242(rule);
        if (result == null) result = caseRule243(rule);
        if (result == null) result = caseRule244(rule);
        if (result == null) result = caseRule245(rule);
        if (result == null) result = caseRule246(rule);
        if (result == null) result = caseRule247(rule);
        if (result == null) result = caseRule248(rule);
        if (result == null) result = caseRule249(rule);
        if (result == null) result = caseRule250(rule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE1:
      {
        Rule1 rule1 = (Rule1)theEObject;
        T result = caseRule1(rule1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE2:
      {
        Rule2 rule2 = (Rule2)theEObject;
        T result = caseRule2(rule2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE3:
      {
        Rule3 rule3 = (Rule3)theEObject;
        T result = caseRule3(rule3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE4:
      {
        Rule4 rule4 = (Rule4)theEObject;
        T result = caseRule4(rule4);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE5:
      {
        Rule5 rule5 = (Rule5)theEObject;
        T result = caseRule5(rule5);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE6:
      {
        Rule6 rule6 = (Rule6)theEObject;
        T result = caseRule6(rule6);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE7:
      {
        Rule7 rule7 = (Rule7)theEObject;
        T result = caseRule7(rule7);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE8:
      {
        Rule8 rule8 = (Rule8)theEObject;
        T result = caseRule8(rule8);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE9:
      {
        Rule9 rule9 = (Rule9)theEObject;
        T result = caseRule9(rule9);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE10:
      {
        Rule10 rule10 = (Rule10)theEObject;
        T result = caseRule10(rule10);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE11:
      {
        Rule11 rule11 = (Rule11)theEObject;
        T result = caseRule11(rule11);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE12:
      {
        Rule12 rule12 = (Rule12)theEObject;
        T result = caseRule12(rule12);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE13:
      {
        Rule13 rule13 = (Rule13)theEObject;
        T result = caseRule13(rule13);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE14:
      {
        Rule14 rule14 = (Rule14)theEObject;
        T result = caseRule14(rule14);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE15:
      {
        Rule15 rule15 = (Rule15)theEObject;
        T result = caseRule15(rule15);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE16:
      {
        Rule16 rule16 = (Rule16)theEObject;
        T result = caseRule16(rule16);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE17:
      {
        Rule17 rule17 = (Rule17)theEObject;
        T result = caseRule17(rule17);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE18:
      {
        Rule18 rule18 = (Rule18)theEObject;
        T result = caseRule18(rule18);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE19:
      {
        Rule19 rule19 = (Rule19)theEObject;
        T result = caseRule19(rule19);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE20:
      {
        Rule20 rule20 = (Rule20)theEObject;
        T result = caseRule20(rule20);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE21:
      {
        Rule21 rule21 = (Rule21)theEObject;
        T result = caseRule21(rule21);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE22:
      {
        Rule22 rule22 = (Rule22)theEObject;
        T result = caseRule22(rule22);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE23:
      {
        Rule23 rule23 = (Rule23)theEObject;
        T result = caseRule23(rule23);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE24:
      {
        Rule24 rule24 = (Rule24)theEObject;
        T result = caseRule24(rule24);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE25:
      {
        Rule25 rule25 = (Rule25)theEObject;
        T result = caseRule25(rule25);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE26:
      {
        Rule26 rule26 = (Rule26)theEObject;
        T result = caseRule26(rule26);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE27:
      {
        Rule27 rule27 = (Rule27)theEObject;
        T result = caseRule27(rule27);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE28:
      {
        Rule28 rule28 = (Rule28)theEObject;
        T result = caseRule28(rule28);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE29:
      {
        Rule29 rule29 = (Rule29)theEObject;
        T result = caseRule29(rule29);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE30:
      {
        Rule30 rule30 = (Rule30)theEObject;
        T result = caseRule30(rule30);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE31:
      {
        Rule31 rule31 = (Rule31)theEObject;
        T result = caseRule31(rule31);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE32:
      {
        Rule32 rule32 = (Rule32)theEObject;
        T result = caseRule32(rule32);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE33:
      {
        Rule33 rule33 = (Rule33)theEObject;
        T result = caseRule33(rule33);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE34:
      {
        Rule34 rule34 = (Rule34)theEObject;
        T result = caseRule34(rule34);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE35:
      {
        Rule35 rule35 = (Rule35)theEObject;
        T result = caseRule35(rule35);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE36:
      {
        Rule36 rule36 = (Rule36)theEObject;
        T result = caseRule36(rule36);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE37:
      {
        Rule37 rule37 = (Rule37)theEObject;
        T result = caseRule37(rule37);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE38:
      {
        Rule38 rule38 = (Rule38)theEObject;
        T result = caseRule38(rule38);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE39:
      {
        Rule39 rule39 = (Rule39)theEObject;
        T result = caseRule39(rule39);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE40:
      {
        Rule40 rule40 = (Rule40)theEObject;
        T result = caseRule40(rule40);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE41:
      {
        Rule41 rule41 = (Rule41)theEObject;
        T result = caseRule41(rule41);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE42:
      {
        Rule42 rule42 = (Rule42)theEObject;
        T result = caseRule42(rule42);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE43:
      {
        Rule43 rule43 = (Rule43)theEObject;
        T result = caseRule43(rule43);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE44:
      {
        Rule44 rule44 = (Rule44)theEObject;
        T result = caseRule44(rule44);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE45:
      {
        Rule45 rule45 = (Rule45)theEObject;
        T result = caseRule45(rule45);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE46:
      {
        Rule46 rule46 = (Rule46)theEObject;
        T result = caseRule46(rule46);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE47:
      {
        Rule47 rule47 = (Rule47)theEObject;
        T result = caseRule47(rule47);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE48:
      {
        Rule48 rule48 = (Rule48)theEObject;
        T result = caseRule48(rule48);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE49:
      {
        Rule49 rule49 = (Rule49)theEObject;
        T result = caseRule49(rule49);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE50:
      {
        Rule50 rule50 = (Rule50)theEObject;
        T result = caseRule50(rule50);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE51:
      {
        Rule51 rule51 = (Rule51)theEObject;
        T result = caseRule51(rule51);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE52:
      {
        Rule52 rule52 = (Rule52)theEObject;
        T result = caseRule52(rule52);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE53:
      {
        Rule53 rule53 = (Rule53)theEObject;
        T result = caseRule53(rule53);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE54:
      {
        Rule54 rule54 = (Rule54)theEObject;
        T result = caseRule54(rule54);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE55:
      {
        Rule55 rule55 = (Rule55)theEObject;
        T result = caseRule55(rule55);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE56:
      {
        Rule56 rule56 = (Rule56)theEObject;
        T result = caseRule56(rule56);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE57:
      {
        Rule57 rule57 = (Rule57)theEObject;
        T result = caseRule57(rule57);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE58:
      {
        Rule58 rule58 = (Rule58)theEObject;
        T result = caseRule58(rule58);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE59:
      {
        Rule59 rule59 = (Rule59)theEObject;
        T result = caseRule59(rule59);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE60:
      {
        Rule60 rule60 = (Rule60)theEObject;
        T result = caseRule60(rule60);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE61:
      {
        Rule61 rule61 = (Rule61)theEObject;
        T result = caseRule61(rule61);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE62:
      {
        Rule62 rule62 = (Rule62)theEObject;
        T result = caseRule62(rule62);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE63:
      {
        Rule63 rule63 = (Rule63)theEObject;
        T result = caseRule63(rule63);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE64:
      {
        Rule64 rule64 = (Rule64)theEObject;
        T result = caseRule64(rule64);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE65:
      {
        Rule65 rule65 = (Rule65)theEObject;
        T result = caseRule65(rule65);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE66:
      {
        Rule66 rule66 = (Rule66)theEObject;
        T result = caseRule66(rule66);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE67:
      {
        Rule67 rule67 = (Rule67)theEObject;
        T result = caseRule67(rule67);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE68:
      {
        Rule68 rule68 = (Rule68)theEObject;
        T result = caseRule68(rule68);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE69:
      {
        Rule69 rule69 = (Rule69)theEObject;
        T result = caseRule69(rule69);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE70:
      {
        Rule70 rule70 = (Rule70)theEObject;
        T result = caseRule70(rule70);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE71:
      {
        Rule71 rule71 = (Rule71)theEObject;
        T result = caseRule71(rule71);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE72:
      {
        Rule72 rule72 = (Rule72)theEObject;
        T result = caseRule72(rule72);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE73:
      {
        Rule73 rule73 = (Rule73)theEObject;
        T result = caseRule73(rule73);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE74:
      {
        Rule74 rule74 = (Rule74)theEObject;
        T result = caseRule74(rule74);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE75:
      {
        Rule75 rule75 = (Rule75)theEObject;
        T result = caseRule75(rule75);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE76:
      {
        Rule76 rule76 = (Rule76)theEObject;
        T result = caseRule76(rule76);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE77:
      {
        Rule77 rule77 = (Rule77)theEObject;
        T result = caseRule77(rule77);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE78:
      {
        Rule78 rule78 = (Rule78)theEObject;
        T result = caseRule78(rule78);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE79:
      {
        Rule79 rule79 = (Rule79)theEObject;
        T result = caseRule79(rule79);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE80:
      {
        Rule80 rule80 = (Rule80)theEObject;
        T result = caseRule80(rule80);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE81:
      {
        Rule81 rule81 = (Rule81)theEObject;
        T result = caseRule81(rule81);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE82:
      {
        Rule82 rule82 = (Rule82)theEObject;
        T result = caseRule82(rule82);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE83:
      {
        Rule83 rule83 = (Rule83)theEObject;
        T result = caseRule83(rule83);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE84:
      {
        Rule84 rule84 = (Rule84)theEObject;
        T result = caseRule84(rule84);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE85:
      {
        Rule85 rule85 = (Rule85)theEObject;
        T result = caseRule85(rule85);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE86:
      {
        Rule86 rule86 = (Rule86)theEObject;
        T result = caseRule86(rule86);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE87:
      {
        Rule87 rule87 = (Rule87)theEObject;
        T result = caseRule87(rule87);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE88:
      {
        Rule88 rule88 = (Rule88)theEObject;
        T result = caseRule88(rule88);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE89:
      {
        Rule89 rule89 = (Rule89)theEObject;
        T result = caseRule89(rule89);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE90:
      {
        Rule90 rule90 = (Rule90)theEObject;
        T result = caseRule90(rule90);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE91:
      {
        Rule91 rule91 = (Rule91)theEObject;
        T result = caseRule91(rule91);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE92:
      {
        Rule92 rule92 = (Rule92)theEObject;
        T result = caseRule92(rule92);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE93:
      {
        Rule93 rule93 = (Rule93)theEObject;
        T result = caseRule93(rule93);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE94:
      {
        Rule94 rule94 = (Rule94)theEObject;
        T result = caseRule94(rule94);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE95:
      {
        Rule95 rule95 = (Rule95)theEObject;
        T result = caseRule95(rule95);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE96:
      {
        Rule96 rule96 = (Rule96)theEObject;
        T result = caseRule96(rule96);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE97:
      {
        Rule97 rule97 = (Rule97)theEObject;
        T result = caseRule97(rule97);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE98:
      {
        Rule98 rule98 = (Rule98)theEObject;
        T result = caseRule98(rule98);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE99:
      {
        Rule99 rule99 = (Rule99)theEObject;
        T result = caseRule99(rule99);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE100:
      {
        Rule100 rule100 = (Rule100)theEObject;
        T result = caseRule100(rule100);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE101:
      {
        Rule101 rule101 = (Rule101)theEObject;
        T result = caseRule101(rule101);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE102:
      {
        Rule102 rule102 = (Rule102)theEObject;
        T result = caseRule102(rule102);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE103:
      {
        Rule103 rule103 = (Rule103)theEObject;
        T result = caseRule103(rule103);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE104:
      {
        Rule104 rule104 = (Rule104)theEObject;
        T result = caseRule104(rule104);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE105:
      {
        Rule105 rule105 = (Rule105)theEObject;
        T result = caseRule105(rule105);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE106:
      {
        Rule106 rule106 = (Rule106)theEObject;
        T result = caseRule106(rule106);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE107:
      {
        Rule107 rule107 = (Rule107)theEObject;
        T result = caseRule107(rule107);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE108:
      {
        Rule108 rule108 = (Rule108)theEObject;
        T result = caseRule108(rule108);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE109:
      {
        Rule109 rule109 = (Rule109)theEObject;
        T result = caseRule109(rule109);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE110:
      {
        Rule110 rule110 = (Rule110)theEObject;
        T result = caseRule110(rule110);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE111:
      {
        Rule111 rule111 = (Rule111)theEObject;
        T result = caseRule111(rule111);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE112:
      {
        Rule112 rule112 = (Rule112)theEObject;
        T result = caseRule112(rule112);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE113:
      {
        Rule113 rule113 = (Rule113)theEObject;
        T result = caseRule113(rule113);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE114:
      {
        Rule114 rule114 = (Rule114)theEObject;
        T result = caseRule114(rule114);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE115:
      {
        Rule115 rule115 = (Rule115)theEObject;
        T result = caseRule115(rule115);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE116:
      {
        Rule116 rule116 = (Rule116)theEObject;
        T result = caseRule116(rule116);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE117:
      {
        Rule117 rule117 = (Rule117)theEObject;
        T result = caseRule117(rule117);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE118:
      {
        Rule118 rule118 = (Rule118)theEObject;
        T result = caseRule118(rule118);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE119:
      {
        Rule119 rule119 = (Rule119)theEObject;
        T result = caseRule119(rule119);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE120:
      {
        Rule120 rule120 = (Rule120)theEObject;
        T result = caseRule120(rule120);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE121:
      {
        Rule121 rule121 = (Rule121)theEObject;
        T result = caseRule121(rule121);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE122:
      {
        Rule122 rule122 = (Rule122)theEObject;
        T result = caseRule122(rule122);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE123:
      {
        Rule123 rule123 = (Rule123)theEObject;
        T result = caseRule123(rule123);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE124:
      {
        Rule124 rule124 = (Rule124)theEObject;
        T result = caseRule124(rule124);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE125:
      {
        Rule125 rule125 = (Rule125)theEObject;
        T result = caseRule125(rule125);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE126:
      {
        Rule126 rule126 = (Rule126)theEObject;
        T result = caseRule126(rule126);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE127:
      {
        Rule127 rule127 = (Rule127)theEObject;
        T result = caseRule127(rule127);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE128:
      {
        Rule128 rule128 = (Rule128)theEObject;
        T result = caseRule128(rule128);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE129:
      {
        Rule129 rule129 = (Rule129)theEObject;
        T result = caseRule129(rule129);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE130:
      {
        Rule130 rule130 = (Rule130)theEObject;
        T result = caseRule130(rule130);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE131:
      {
        Rule131 rule131 = (Rule131)theEObject;
        T result = caseRule131(rule131);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE132:
      {
        Rule132 rule132 = (Rule132)theEObject;
        T result = caseRule132(rule132);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE133:
      {
        Rule133 rule133 = (Rule133)theEObject;
        T result = caseRule133(rule133);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE134:
      {
        Rule134 rule134 = (Rule134)theEObject;
        T result = caseRule134(rule134);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE135:
      {
        Rule135 rule135 = (Rule135)theEObject;
        T result = caseRule135(rule135);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE136:
      {
        Rule136 rule136 = (Rule136)theEObject;
        T result = caseRule136(rule136);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE137:
      {
        Rule137 rule137 = (Rule137)theEObject;
        T result = caseRule137(rule137);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE138:
      {
        Rule138 rule138 = (Rule138)theEObject;
        T result = caseRule138(rule138);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE139:
      {
        Rule139 rule139 = (Rule139)theEObject;
        T result = caseRule139(rule139);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE140:
      {
        Rule140 rule140 = (Rule140)theEObject;
        T result = caseRule140(rule140);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE141:
      {
        Rule141 rule141 = (Rule141)theEObject;
        T result = caseRule141(rule141);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE142:
      {
        Rule142 rule142 = (Rule142)theEObject;
        T result = caseRule142(rule142);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE143:
      {
        Rule143 rule143 = (Rule143)theEObject;
        T result = caseRule143(rule143);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE144:
      {
        Rule144 rule144 = (Rule144)theEObject;
        T result = caseRule144(rule144);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE145:
      {
        Rule145 rule145 = (Rule145)theEObject;
        T result = caseRule145(rule145);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE146:
      {
        Rule146 rule146 = (Rule146)theEObject;
        T result = caseRule146(rule146);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE147:
      {
        Rule147 rule147 = (Rule147)theEObject;
        T result = caseRule147(rule147);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE148:
      {
        Rule148 rule148 = (Rule148)theEObject;
        T result = caseRule148(rule148);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE149:
      {
        Rule149 rule149 = (Rule149)theEObject;
        T result = caseRule149(rule149);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE150:
      {
        Rule150 rule150 = (Rule150)theEObject;
        T result = caseRule150(rule150);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE151:
      {
        Rule151 rule151 = (Rule151)theEObject;
        T result = caseRule151(rule151);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE152:
      {
        Rule152 rule152 = (Rule152)theEObject;
        T result = caseRule152(rule152);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE153:
      {
        Rule153 rule153 = (Rule153)theEObject;
        T result = caseRule153(rule153);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE154:
      {
        Rule154 rule154 = (Rule154)theEObject;
        T result = caseRule154(rule154);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE155:
      {
        Rule155 rule155 = (Rule155)theEObject;
        T result = caseRule155(rule155);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE156:
      {
        Rule156 rule156 = (Rule156)theEObject;
        T result = caseRule156(rule156);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE157:
      {
        Rule157 rule157 = (Rule157)theEObject;
        T result = caseRule157(rule157);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE158:
      {
        Rule158 rule158 = (Rule158)theEObject;
        T result = caseRule158(rule158);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE159:
      {
        Rule159 rule159 = (Rule159)theEObject;
        T result = caseRule159(rule159);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE160:
      {
        Rule160 rule160 = (Rule160)theEObject;
        T result = caseRule160(rule160);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE161:
      {
        Rule161 rule161 = (Rule161)theEObject;
        T result = caseRule161(rule161);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE162:
      {
        Rule162 rule162 = (Rule162)theEObject;
        T result = caseRule162(rule162);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE163:
      {
        Rule163 rule163 = (Rule163)theEObject;
        T result = caseRule163(rule163);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE164:
      {
        Rule164 rule164 = (Rule164)theEObject;
        T result = caseRule164(rule164);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE165:
      {
        Rule165 rule165 = (Rule165)theEObject;
        T result = caseRule165(rule165);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE166:
      {
        Rule166 rule166 = (Rule166)theEObject;
        T result = caseRule166(rule166);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE167:
      {
        Rule167 rule167 = (Rule167)theEObject;
        T result = caseRule167(rule167);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE168:
      {
        Rule168 rule168 = (Rule168)theEObject;
        T result = caseRule168(rule168);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE169:
      {
        Rule169 rule169 = (Rule169)theEObject;
        T result = caseRule169(rule169);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE170:
      {
        Rule170 rule170 = (Rule170)theEObject;
        T result = caseRule170(rule170);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE171:
      {
        Rule171 rule171 = (Rule171)theEObject;
        T result = caseRule171(rule171);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE172:
      {
        Rule172 rule172 = (Rule172)theEObject;
        T result = caseRule172(rule172);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE173:
      {
        Rule173 rule173 = (Rule173)theEObject;
        T result = caseRule173(rule173);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE174:
      {
        Rule174 rule174 = (Rule174)theEObject;
        T result = caseRule174(rule174);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE175:
      {
        Rule175 rule175 = (Rule175)theEObject;
        T result = caseRule175(rule175);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE176:
      {
        Rule176 rule176 = (Rule176)theEObject;
        T result = caseRule176(rule176);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE177:
      {
        Rule177 rule177 = (Rule177)theEObject;
        T result = caseRule177(rule177);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE178:
      {
        Rule178 rule178 = (Rule178)theEObject;
        T result = caseRule178(rule178);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE179:
      {
        Rule179 rule179 = (Rule179)theEObject;
        T result = caseRule179(rule179);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE180:
      {
        Rule180 rule180 = (Rule180)theEObject;
        T result = caseRule180(rule180);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE181:
      {
        Rule181 rule181 = (Rule181)theEObject;
        T result = caseRule181(rule181);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE182:
      {
        Rule182 rule182 = (Rule182)theEObject;
        T result = caseRule182(rule182);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE183:
      {
        Rule183 rule183 = (Rule183)theEObject;
        T result = caseRule183(rule183);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE184:
      {
        Rule184 rule184 = (Rule184)theEObject;
        T result = caseRule184(rule184);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE185:
      {
        Rule185 rule185 = (Rule185)theEObject;
        T result = caseRule185(rule185);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE186:
      {
        Rule186 rule186 = (Rule186)theEObject;
        T result = caseRule186(rule186);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE187:
      {
        Rule187 rule187 = (Rule187)theEObject;
        T result = caseRule187(rule187);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE188:
      {
        Rule188 rule188 = (Rule188)theEObject;
        T result = caseRule188(rule188);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE189:
      {
        Rule189 rule189 = (Rule189)theEObject;
        T result = caseRule189(rule189);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE190:
      {
        Rule190 rule190 = (Rule190)theEObject;
        T result = caseRule190(rule190);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE191:
      {
        Rule191 rule191 = (Rule191)theEObject;
        T result = caseRule191(rule191);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE192:
      {
        Rule192 rule192 = (Rule192)theEObject;
        T result = caseRule192(rule192);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE193:
      {
        Rule193 rule193 = (Rule193)theEObject;
        T result = caseRule193(rule193);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE194:
      {
        Rule194 rule194 = (Rule194)theEObject;
        T result = caseRule194(rule194);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE195:
      {
        Rule195 rule195 = (Rule195)theEObject;
        T result = caseRule195(rule195);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE196:
      {
        Rule196 rule196 = (Rule196)theEObject;
        T result = caseRule196(rule196);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE197:
      {
        Rule197 rule197 = (Rule197)theEObject;
        T result = caseRule197(rule197);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE198:
      {
        Rule198 rule198 = (Rule198)theEObject;
        T result = caseRule198(rule198);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE199:
      {
        Rule199 rule199 = (Rule199)theEObject;
        T result = caseRule199(rule199);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE200:
      {
        Rule200 rule200 = (Rule200)theEObject;
        T result = caseRule200(rule200);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE201:
      {
        Rule201 rule201 = (Rule201)theEObject;
        T result = caseRule201(rule201);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE202:
      {
        Rule202 rule202 = (Rule202)theEObject;
        T result = caseRule202(rule202);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE203:
      {
        Rule203 rule203 = (Rule203)theEObject;
        T result = caseRule203(rule203);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE204:
      {
        Rule204 rule204 = (Rule204)theEObject;
        T result = caseRule204(rule204);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE205:
      {
        Rule205 rule205 = (Rule205)theEObject;
        T result = caseRule205(rule205);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE206:
      {
        Rule206 rule206 = (Rule206)theEObject;
        T result = caseRule206(rule206);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE207:
      {
        Rule207 rule207 = (Rule207)theEObject;
        T result = caseRule207(rule207);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE208:
      {
        Rule208 rule208 = (Rule208)theEObject;
        T result = caseRule208(rule208);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE209:
      {
        Rule209 rule209 = (Rule209)theEObject;
        T result = caseRule209(rule209);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE210:
      {
        Rule210 rule210 = (Rule210)theEObject;
        T result = caseRule210(rule210);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE211:
      {
        Rule211 rule211 = (Rule211)theEObject;
        T result = caseRule211(rule211);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE212:
      {
        Rule212 rule212 = (Rule212)theEObject;
        T result = caseRule212(rule212);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE213:
      {
        Rule213 rule213 = (Rule213)theEObject;
        T result = caseRule213(rule213);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE214:
      {
        Rule214 rule214 = (Rule214)theEObject;
        T result = caseRule214(rule214);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE215:
      {
        Rule215 rule215 = (Rule215)theEObject;
        T result = caseRule215(rule215);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE216:
      {
        Rule216 rule216 = (Rule216)theEObject;
        T result = caseRule216(rule216);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE217:
      {
        Rule217 rule217 = (Rule217)theEObject;
        T result = caseRule217(rule217);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE218:
      {
        Rule218 rule218 = (Rule218)theEObject;
        T result = caseRule218(rule218);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE219:
      {
        Rule219 rule219 = (Rule219)theEObject;
        T result = caseRule219(rule219);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE220:
      {
        Rule220 rule220 = (Rule220)theEObject;
        T result = caseRule220(rule220);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE221:
      {
        Rule221 rule221 = (Rule221)theEObject;
        T result = caseRule221(rule221);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE222:
      {
        Rule222 rule222 = (Rule222)theEObject;
        T result = caseRule222(rule222);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE223:
      {
        Rule223 rule223 = (Rule223)theEObject;
        T result = caseRule223(rule223);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE224:
      {
        Rule224 rule224 = (Rule224)theEObject;
        T result = caseRule224(rule224);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE225:
      {
        Rule225 rule225 = (Rule225)theEObject;
        T result = caseRule225(rule225);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE226:
      {
        Rule226 rule226 = (Rule226)theEObject;
        T result = caseRule226(rule226);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE227:
      {
        Rule227 rule227 = (Rule227)theEObject;
        T result = caseRule227(rule227);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE228:
      {
        Rule228 rule228 = (Rule228)theEObject;
        T result = caseRule228(rule228);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE229:
      {
        Rule229 rule229 = (Rule229)theEObject;
        T result = caseRule229(rule229);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE230:
      {
        Rule230 rule230 = (Rule230)theEObject;
        T result = caseRule230(rule230);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE231:
      {
        Rule231 rule231 = (Rule231)theEObject;
        T result = caseRule231(rule231);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE232:
      {
        Rule232 rule232 = (Rule232)theEObject;
        T result = caseRule232(rule232);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE233:
      {
        Rule233 rule233 = (Rule233)theEObject;
        T result = caseRule233(rule233);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE234:
      {
        Rule234 rule234 = (Rule234)theEObject;
        T result = caseRule234(rule234);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE235:
      {
        Rule235 rule235 = (Rule235)theEObject;
        T result = caseRule235(rule235);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE236:
      {
        Rule236 rule236 = (Rule236)theEObject;
        T result = caseRule236(rule236);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE237:
      {
        Rule237 rule237 = (Rule237)theEObject;
        T result = caseRule237(rule237);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE238:
      {
        Rule238 rule238 = (Rule238)theEObject;
        T result = caseRule238(rule238);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE239:
      {
        Rule239 rule239 = (Rule239)theEObject;
        T result = caseRule239(rule239);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE240:
      {
        Rule240 rule240 = (Rule240)theEObject;
        T result = caseRule240(rule240);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE241:
      {
        Rule241 rule241 = (Rule241)theEObject;
        T result = caseRule241(rule241);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE242:
      {
        Rule242 rule242 = (Rule242)theEObject;
        T result = caseRule242(rule242);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE243:
      {
        Rule243 rule243 = (Rule243)theEObject;
        T result = caseRule243(rule243);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE244:
      {
        Rule244 rule244 = (Rule244)theEObject;
        T result = caseRule244(rule244);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE245:
      {
        Rule245 rule245 = (Rule245)theEObject;
        T result = caseRule245(rule245);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE246:
      {
        Rule246 rule246 = (Rule246)theEObject;
        T result = caseRule246(rule246);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE247:
      {
        Rule247 rule247 = (Rule247)theEObject;
        T result = caseRule247(rule247);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE248:
      {
        Rule248 rule248 = (Rule248)theEObject;
        T result = caseRule248(rule248);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE249:
      {
        Rule249 rule249 = (Rule249)theEObject;
        T result = caseRule249(rule249);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GeneratorTestLanguagePackage.RULE250:
      {
        Rule250 rule250 = (Rule250)theEObject;
        T result = caseRule250(rule250);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule(Rule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule1(Rule1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule2(Rule2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule3(Rule3 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule4</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule4</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule4(Rule4 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule5</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule5</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule5(Rule5 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule6</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule6</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule6(Rule6 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule7</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule7</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule7(Rule7 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule8</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule8</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule8(Rule8 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule9</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule9</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule9(Rule9 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule10</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule10</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule10(Rule10 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule11</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule11</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule11(Rule11 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule12</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule12</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule12(Rule12 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule13</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule13</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule13(Rule13 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule14</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule14</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule14(Rule14 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule15</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule15</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule15(Rule15 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule16</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule16</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule16(Rule16 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule17</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule17</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule17(Rule17 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule18</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule18</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule18(Rule18 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule19</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule19</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule19(Rule19 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule20</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule20</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule20(Rule20 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule21</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule21</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule21(Rule21 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule22</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule22</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule22(Rule22 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule23</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule23</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule23(Rule23 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule24</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule24</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule24(Rule24 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule25</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule25</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule25(Rule25 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule26</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule26</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule26(Rule26 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule27</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule27</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule27(Rule27 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule28</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule28</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule28(Rule28 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule29</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule29</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule29(Rule29 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule30</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule30</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule30(Rule30 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule31</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule31</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule31(Rule31 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule32</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule32</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule32(Rule32 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule33</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule33</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule33(Rule33 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule34</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule34</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule34(Rule34 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule35</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule35</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule35(Rule35 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule36</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule36</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule36(Rule36 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule37</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule37</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule37(Rule37 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule38</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule38</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule38(Rule38 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule39</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule39</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule39(Rule39 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule40</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule40</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule40(Rule40 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule41</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule41</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule41(Rule41 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule42</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule42</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule42(Rule42 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule43</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule43</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule43(Rule43 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule44</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule44</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule44(Rule44 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule45</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule45</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule45(Rule45 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule46</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule46</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule46(Rule46 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule47</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule47</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule47(Rule47 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule48</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule48</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule48(Rule48 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule49</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule49</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule49(Rule49 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule50</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule50</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule50(Rule50 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule51</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule51</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule51(Rule51 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule52</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule52</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule52(Rule52 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule53</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule53</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule53(Rule53 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule54</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule54</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule54(Rule54 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule55</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule55</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule55(Rule55 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule56</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule56</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule56(Rule56 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule57</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule57</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule57(Rule57 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule58</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule58</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule58(Rule58 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule59</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule59</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule59(Rule59 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule60</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule60</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule60(Rule60 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule61</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule61</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule61(Rule61 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule62</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule62</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule62(Rule62 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule63</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule63</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule63(Rule63 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule64</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule64</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule64(Rule64 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule65</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule65</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule65(Rule65 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule66</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule66</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule66(Rule66 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule67</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule67</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule67(Rule67 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule68</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule68</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule68(Rule68 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule69</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule69</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule69(Rule69 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule70</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule70</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule70(Rule70 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule71</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule71</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule71(Rule71 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule72</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule72</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule72(Rule72 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule73</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule73</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule73(Rule73 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule74</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule74</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule74(Rule74 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule75</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule75</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule75(Rule75 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule76</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule76</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule76(Rule76 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule77</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule77</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule77(Rule77 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule78</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule78</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule78(Rule78 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule79</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule79</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule79(Rule79 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule80</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule80</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule80(Rule80 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule81</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule81</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule81(Rule81 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule82</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule82</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule82(Rule82 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule83</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule83</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule83(Rule83 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule84</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule84</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule84(Rule84 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule85</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule85</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule85(Rule85 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule86</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule86</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule86(Rule86 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule87</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule87</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule87(Rule87 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule88</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule88</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule88(Rule88 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule89</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule89</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule89(Rule89 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule90</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule90</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule90(Rule90 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule91</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule91</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule91(Rule91 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule92</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule92</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule92(Rule92 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule93</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule93</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule93(Rule93 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule94</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule94</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule94(Rule94 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule95</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule95</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule95(Rule95 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule96</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule96</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule96(Rule96 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule97</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule97</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule97(Rule97 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule98</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule98</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule98(Rule98 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule99</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule99</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule99(Rule99 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule100</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule100</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule100(Rule100 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule101</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule101</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule101(Rule101 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule102</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule102</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule102(Rule102 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule103</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule103</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule103(Rule103 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule104</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule104</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule104(Rule104 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule105</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule105</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule105(Rule105 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule106</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule106</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule106(Rule106 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule107</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule107</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule107(Rule107 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule108</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule108</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule108(Rule108 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule109</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule109</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule109(Rule109 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule110</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule110</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule110(Rule110 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule111</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule111</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule111(Rule111 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule112</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule112</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule112(Rule112 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule113</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule113</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule113(Rule113 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule114</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule114</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule114(Rule114 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule115</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule115</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule115(Rule115 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule116</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule116</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule116(Rule116 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule117</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule117</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule117(Rule117 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule118</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule118</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule118(Rule118 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule119</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule119</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule119(Rule119 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule120</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule120</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule120(Rule120 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule121</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule121</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule121(Rule121 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule122</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule122</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule122(Rule122 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule123</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule123</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule123(Rule123 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule124</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule124</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule124(Rule124 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule125</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule125</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule125(Rule125 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule126</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule126</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule126(Rule126 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule127</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule127</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule127(Rule127 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule128</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule128</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule128(Rule128 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule129</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule129</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule129(Rule129 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule130</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule130</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule130(Rule130 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule131</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule131</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule131(Rule131 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule132</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule132</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule132(Rule132 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule133</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule133</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule133(Rule133 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule134</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule134</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule134(Rule134 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule135</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule135</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule135(Rule135 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule136</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule136</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule136(Rule136 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule137</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule137</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule137(Rule137 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule138</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule138</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule138(Rule138 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule139</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule139</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule139(Rule139 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule140</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule140</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule140(Rule140 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule141</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule141</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule141(Rule141 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule142</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule142</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule142(Rule142 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule143</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule143</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule143(Rule143 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule144</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule144</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule144(Rule144 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule145</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule145</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule145(Rule145 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule146</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule146</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule146(Rule146 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule147</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule147</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule147(Rule147 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule148</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule148</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule148(Rule148 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule149</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule149</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule149(Rule149 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule150</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule150</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule150(Rule150 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule151</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule151</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule151(Rule151 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule152</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule152</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule152(Rule152 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule153</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule153</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule153(Rule153 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule154</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule154</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule154(Rule154 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule155</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule155</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule155(Rule155 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule156</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule156</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule156(Rule156 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule157</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule157</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule157(Rule157 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule158</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule158</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule158(Rule158 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule159</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule159</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule159(Rule159 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule160</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule160</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule160(Rule160 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule161</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule161</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule161(Rule161 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule162</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule162</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule162(Rule162 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule163</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule163</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule163(Rule163 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule164</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule164</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule164(Rule164 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule165</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule165</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule165(Rule165 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule166</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule166</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule166(Rule166 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule167</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule167</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule167(Rule167 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule168</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule168</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule168(Rule168 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule169</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule169</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule169(Rule169 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule170</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule170</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule170(Rule170 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule171</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule171</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule171(Rule171 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule172</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule172</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule172(Rule172 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule173</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule173</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule173(Rule173 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule174</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule174</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule174(Rule174 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule175</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule175</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule175(Rule175 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule176</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule176</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule176(Rule176 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule177</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule177</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule177(Rule177 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule178</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule178</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule178(Rule178 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule179</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule179</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule179(Rule179 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule180</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule180</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule180(Rule180 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule181</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule181</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule181(Rule181 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule182</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule182</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule182(Rule182 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule183</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule183</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule183(Rule183 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule184</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule184</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule184(Rule184 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule185</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule185</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule185(Rule185 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule186</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule186</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule186(Rule186 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule187</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule187</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule187(Rule187 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule188</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule188</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule188(Rule188 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule189</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule189</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule189(Rule189 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule190</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule190</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule190(Rule190 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule191</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule191</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule191(Rule191 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule192</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule192</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule192(Rule192 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule193</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule193</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule193(Rule193 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule194</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule194</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule194(Rule194 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule195</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule195</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule195(Rule195 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule196</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule196</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule196(Rule196 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule197</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule197</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule197(Rule197 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule198</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule198</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule198(Rule198 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule199</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule199</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule199(Rule199 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule200</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule200</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule200(Rule200 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule201</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule201</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule201(Rule201 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule202</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule202</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule202(Rule202 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule203</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule203</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule203(Rule203 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule204</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule204</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule204(Rule204 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule205</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule205</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule205(Rule205 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule206</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule206</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule206(Rule206 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule207</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule207</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule207(Rule207 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule208</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule208</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule208(Rule208 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule209</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule209</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule209(Rule209 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule210</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule210</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule210(Rule210 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule211</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule211</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule211(Rule211 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule212</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule212</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule212(Rule212 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule213</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule213</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule213(Rule213 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule214</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule214</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule214(Rule214 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule215</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule215</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule215(Rule215 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule216</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule216</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule216(Rule216 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule217</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule217</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule217(Rule217 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule218</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule218</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule218(Rule218 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule219</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule219</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule219(Rule219 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule220</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule220</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule220(Rule220 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule221</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule221</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule221(Rule221 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule222</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule222</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule222(Rule222 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule223</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule223</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule223(Rule223 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule224</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule224</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule224(Rule224 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule225</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule225</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule225(Rule225 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule226</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule226</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule226(Rule226 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule227</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule227</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule227(Rule227 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule228</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule228</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule228(Rule228 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule229</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule229</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule229(Rule229 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule230</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule230</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule230(Rule230 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule231</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule231</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule231(Rule231 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule232</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule232</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule232(Rule232 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule233</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule233</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule233(Rule233 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule234</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule234</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule234(Rule234 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule235</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule235</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule235(Rule235 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule236</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule236</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule236(Rule236 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule237</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule237</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule237(Rule237 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule238</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule238</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule238(Rule238 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule239</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule239</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule239(Rule239 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule240</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule240</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule240(Rule240 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule241</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule241</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule241(Rule241 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule242</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule242</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule242(Rule242 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule243</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule243</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule243(Rule243 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule244</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule244</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule244(Rule244 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule245</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule245</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule245(Rule245 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule246</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule246</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule246(Rule246 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule247</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule247</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule247(Rule247 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule248</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule248</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule248(Rule248 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule249</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule249</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule249(Rule249 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule250</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule250</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule250(Rule250 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object)
  {
    return null;
  }

} //GeneratorTestLanguageSwitch
