package org.eclipse.xtext.idea.types.access;

import com.google.common.base.Objects;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl;
import com.intellij.openapi.roots.LanguageLevelProjectExtension;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.java.LanguageLevel;
import com.intellij.testFramework.PsiTestCase;
import com.intellij.testFramework.PsiTestUtil;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.types.access.StubJvmTypeProviderTestDelegate;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@TestDecorator
@SuppressWarnings("all")
public class SourceStubJvmTypeProviderTest extends PsiTestCase {
  private final StubJvmTypeProviderTestDelegate delegate = new StubJvmTypeProviderTestDelegate();
  
  public void setUp() throws Exception {
    super.setUp();
    Module _module = this.getModule();
    PsiTestUtil.addLibrary(_module, "Guava", "/Users/kosyakov/.p2/pool/plugins", "com.google.guava_15.0.0.v201403281430.jar");
    Project _project = this.myJavaFacade.getProject();
    LanguageLevelProjectExtension _instance = LanguageLevelProjectExtension.getInstance(_project);
    _instance.setLanguageLevel(LanguageLevel.JDK_1_5);
    final String testPath = "/Users/kosyakov/oomph/xtext/master/git/xtext/tests/org.eclipse.xtext.common.types.tests/testdata";
    Application _application = ApplicationManager.getApplication();
    final Function0<VirtualFile> _function = new Function0<VirtualFile>() {
      public VirtualFile apply() {
        LocalFileSystem _instance = LocalFileSystem.getInstance();
        return _instance.refreshAndFindFileByPath(testPath);
      }
    };
    final VirtualFile testRoot = _application.<VirtualFile>runWriteAction(
      ((Computable<VirtualFile>) new Computable<VirtualFile>() {
          public VirtualFile compute() {
            return _function.apply();
          }
      }));
    boolean _notEquals = (!Objects.equal(testRoot, null));
    if (_notEquals) {
      PsiTestUtil.addSourceRoot(this.myModule, testRoot);
    }
    Project _project_1 = this.getProject();
    this.delegate.setUp(_project_1);
  }
  
  protected Sdk getTestProjectJdk() {
    JavaAwareProjectJdkTableImpl _instanceEx = JavaAwareProjectJdkTableImpl.getInstanceEx();
    return _instanceEx.getInternalJdk();
  }
  
  public void tearDown() throws Exception {
    this.delegate.tearDown();
    super.tearDown();
  }
  
  public void testAbstractMethod() throws Exception {
    delegate.testAbstractMethod();
  }
  
  public void testAnnotatedConstructor_01() throws Exception {
    delegate.testAnnotatedConstructor_01();
  }
  
  public void testAnnotatedConstructor_02() throws Exception {
    delegate.testAnnotatedConstructor_02();
  }
  
  public void testAnnotatedConstructor_03() throws Exception {
    delegate.testAnnotatedConstructor_03();
  }
  
  public void testAnnotatedConstructor_04() throws Exception {
    delegate.testAnnotatedConstructor_04();
  }
  
  public void testAnnotatedField_01() throws Exception {
    delegate.testAnnotatedField_01();
  }
  
  public void testAnnotatedMethod_01() throws Exception {
    delegate.testAnnotatedMethod_01();
  }
  
  public void testAnnotatedParameter_01() throws Exception {
    delegate.testAnnotatedParameter_01();
  }
  
  public void testAnnotatedParameter_02() throws Exception {
    delegate.testAnnotatedParameter_02();
  }
  
  public void testAnnotatedParameter_03() throws Exception {
    delegate.testAnnotatedParameter_03();
  }
  
  public void testAnnotatedParameter_04() throws Exception {
    delegate.testAnnotatedParameter_04();
  }
  
  public void testAnnotatedParameter_05() throws Exception {
    delegate.testAnnotatedParameter_05();
  }
  
  public void testAnnotatedParameter_06() throws Exception {
    delegate.testAnnotatedParameter_06();
  }
  
  public void testAnnotationAnnotationValue_01() throws Exception {
    delegate.testAnnotationAnnotationValue_01();
  }
  
  public void testAnnotationAnnotationValue_02() throws Exception {
    delegate.testAnnotationAnnotationValue_02();
  }
  
  public void testAnnotationAnnotationValue_03() throws Exception {
    delegate.testAnnotationAnnotationValue_03();
  }
  
  public void testAnnotationType_01() throws Exception {
    delegate.testAnnotationType_01();
  }
  
  public void testAnnotationType_02() throws Exception {
    delegate.testAnnotationType_02();
  }
  
  public void testAnnotationType_03() throws Exception {
    delegate.testAnnotationType_03();
  }
  
  public void testAnnotationType_04() throws Exception {
    delegate.testAnnotationType_04();
  }
  
  public void testAnnotationWithStringDefault_01() throws Exception {
    delegate.testAnnotationWithStringDefault_01();
  }
  
  public void testAnnotationWithStringDefault_02() throws Exception {
    delegate.testAnnotationWithStringDefault_02();
  }
  
  public void testAnnotationWithStringDefault_03() throws Exception {
    delegate.testAnnotationWithStringDefault_03();
  }
  
  public void testAnnotationWithStringDefault_04() throws Exception {
    delegate.testAnnotationWithStringDefault_04();
  }
  
  public void testAnnotations_01() throws Exception {
    delegate.testAnnotations_01();
  }
  
  public void testAnnotations_01_01() throws Exception {
    delegate.testAnnotations_01_01();
  }
  
  public void testAnnotations_01_02() throws Exception {
    delegate.testAnnotations_01_02();
  }
  
  public void testArraysArraylist_01() {
    delegate.testArraysArraylist_01();
  }
  
  public void testArraysArraylist_02() {
    delegate.testArraysArraylist_02();
  }
  
  public void testArraysArraylist_03() {
    delegate.testArraysArraylist_03();
  }
  
  public void testArraysArraylist_04() {
    delegate.testArraysArraylist_04();
  }
  
  public void testArraysArraylist_05() {
    delegate.testArraysArraylist_05();
  }
  
  public void testBooleanAnnotationValue_01() throws Exception {
    delegate.testBooleanAnnotationValue_01();
  }
  
  public void testBooleanAnnotationValue_02() throws Exception {
    delegate.testBooleanAnnotationValue_02();
  }
  
  public void testBooleanAnnotationValue_03() throws Exception {
    delegate.testBooleanAnnotationValue_03();
  }
  
  public void testBug347739_01() {
    delegate.testBug347739_01();
  }
  
  public void testBug347739_02() {
    delegate.testBug347739_02();
  }
  
  public void testBug347739_03() {
    delegate.testBug347739_03();
  }
  
  public void testBug347739_04() {
    delegate.testBug347739_04();
  }
  
  public void testBug347739_05() {
    delegate.testBug347739_05();
  }
  
  public void testBug347739_06() {
    delegate.testBug347739_06();
  }
  
  public void testBug427098() {
    delegate.testBug427098();
  }
  
  public void testBug428340() {
    delegate.testBug428340();
  }
  
  public void testByteAnnotationValue_01() throws Exception {
    delegate.testByteAnnotationValue_01();
  }
  
  public void testByteAnnotationValue_02() throws Exception {
    delegate.testByteAnnotationValue_02();
  }
  
  public void testByteAnnotationValue_03() throws Exception {
    delegate.testByteAnnotationValue_03();
  }
  
  public void testCharAnnotationValue_01() throws Exception {
    delegate.testCharAnnotationValue_01();
  }
  
  public void testCharAnnotationValue_02() throws Exception {
    delegate.testCharAnnotationValue_02();
  }
  
  public void testCharAnnotationValue_03() throws Exception {
    delegate.testCharAnnotationValue_03();
  }
  
  public void testClassAnnotationValue_01() throws Exception {
    delegate.testClassAnnotationValue_01();
  }
  
  public void testClassAnnotationValue_02() throws Exception {
    delegate.testClassAnnotationValue_02();
  }
  
  public void testClassAnnotationValue_03() throws Exception {
    delegate.testClassAnnotationValue_03();
  }
  
  public void testClassAnnotationValue_04() throws Exception {
    delegate.testClassAnnotationValue_04();
  }
  
  public void testClassAnnotationValue_05() throws Exception {
    delegate.testClassAnnotationValue_05();
  }
  
  public void testClassAnnotationValue_06() throws Exception {
    delegate.testClassAnnotationValue_06();
  }
  
  public void testConstantValue_01() {
    delegate.testConstantValue_01();
  }
  
  public void testConstantValue_02() {
    delegate.testConstantValue_02();
  }
  
  public void testConstantValue_03() {
    delegate.testConstantValue_03();
  }
  
  public void testConstantValue_04() {
    delegate.testConstantValue_04();
  }
  
  public void testConstantValue_05() {
    delegate.testConstantValue_05();
  }
  
  public void testConstantValue_06() {
    delegate.testConstantValue_06();
  }
  
  public void testConstantValue_07() {
    delegate.testConstantValue_07();
  }
  
  public void testConstantValue_08() {
    delegate.testConstantValue_08();
  }
  
  public void testConstantValue_09() {
    delegate.testConstantValue_09();
  }
  
  public void testDefaultAnnotationAnnotationValueByReference() throws Exception {
    delegate.testDefaultAnnotationAnnotationValueByReference();
  }
  
  public void testDefaultAnnotationAnnotationValue_01() throws Exception {
    delegate.testDefaultAnnotationAnnotationValue_01();
  }
  
  public void testDefaultAnnotationAnnotationValue_02() throws Exception {
    delegate.testDefaultAnnotationAnnotationValue_02();
  }
  
  public void testDefaultBooleanAnnotationValue_01() throws Exception {
    delegate.testDefaultBooleanAnnotationValue_01();
  }
  
  public void testDefaultByteAnnotationValue_01() throws Exception {
    delegate.testDefaultByteAnnotationValue_01();
  }
  
  public void testDefaultCharArrayAnnotationValue_01() throws Exception {
    delegate.testDefaultCharArrayAnnotationValue_01();
  }
  
  public void testDefaultDoubleAnnotationValue_01() throws Exception {
    delegate.testDefaultDoubleAnnotationValue_01();
  }
  
  public void testDefaultEnumAnnotationValue_01() throws Exception {
    delegate.testDefaultEnumAnnotationValue_01();
  }
  
  public void testDefaultFloatAnnotationValue_01() throws Exception {
    delegate.testDefaultFloatAnnotationValue_01();
  }
  
  public void testDefaultIntAnnotationValue_01() throws Exception {
    delegate.testDefaultIntAnnotationValue_01();
  }
  
  public void testDefaultLongArrayAnnotationValue_01() throws Exception {
    delegate.testDefaultLongArrayAnnotationValue_01();
  }
  
  public void testDefaultShortAnnotationValue_01() throws Exception {
    delegate.testDefaultShortAnnotationValue_01();
  }
  
  public void testDefaultStringAnnotationValue_01() throws Exception {
    delegate.testDefaultStringAnnotationValue_01();
  }
  
  public void testDefaultStringAnnotationValue_02() throws Exception {
    delegate.testDefaultStringAnnotationValue_02();
  }
  
  public void testDefaultTypeAnnotationValue_01() throws Exception {
    delegate.testDefaultTypeAnnotationValue_01();
  }
  
  public void testDefaultTypeAnnotationValue_02() throws Exception {
    delegate.testDefaultTypeAnnotationValue_02();
  }
  
  public void testDeprecatedBit_01() {
    delegate.testDeprecatedBit_01();
  }
  
  public void testDeprecatedBit_02() {
    delegate.testDeprecatedBit_02();
  }
  
  public void testDoubleAnnotationValue_01() throws Exception {
    delegate.testDoubleAnnotationValue_01();
  }
  
  public void testDoubleAnnotationValue_02() throws Exception {
    delegate.testDoubleAnnotationValue_02();
  }
  
  public void testDoubleAnnotationValue_03() throws Exception {
    delegate.testDoubleAnnotationValue_03();
  }
  
  public void testEnumAnnotationValue_01() throws Exception {
    delegate.testEnumAnnotationValue_01();
  }
  
  public void testEnumAnnotationValue_02() throws Exception {
    delegate.testEnumAnnotationValue_02();
  }
  
  public void testEnumAnnotationValue_03() throws Exception {
    delegate.testEnumAnnotationValue_03();
  }
  
  public void testEnum_01() throws Exception {
    delegate.testEnum_01();
  }
  
  public void testEnum_02() throws Exception {
    delegate.testEnum_02();
  }
  
  public void testEnum_03() throws Exception {
    delegate.testEnum_03();
  }
  
  public void testEnum_04() throws Exception {
    delegate.testEnum_04();
  }
  
  public void testFields_01() {
    delegate.testFields_01();
  }
  
  public void testFields_defaultListT_01() {
    delegate.testFields_defaultListT_01();
  }
  
  public void testFields_innerFields_01() {
    delegate.testFields_innerFields_01();
  }
  
  public void testFields_privateT_01() {
    delegate.testFields_privateT_01();
  }
  
  public void testFields_protectedStaticString_01() {
    delegate.testFields_protectedStaticString_01();
  }
  
  public void testFields_protectedString_01() {
    delegate.testFields_protectedString_01();
  }
  
  public void testFields_publicInt_01() {
    delegate.testFields_publicInt_01();
  }
  
  public void testFields_transientInt_01() {
    delegate.testFields_transientInt_01();
  }
  
  public void testFields_volatileInt_01() {
    delegate.testFields_volatileInt_01();
  }
  
  public void testFindTypeByName_$StartsWithDollar_01() {
    delegate.testFindTypeByName_$StartsWithDollar_01();
  }
  
  public void testFindTypeByName_$StartsWithDollar_02() {
    delegate.testFindTypeByName_$StartsWithDollar_02();
  }
  
  public void testFindTypeByName_AbstractMultimap() {
    delegate.testFindTypeByName_AbstractMultimap();
  }
  
  public void testFindTypeByName_AbstractMultimap_02() {
    delegate.testFindTypeByName_AbstractMultimap_02();
  }
  
  public void testFindTypeByName_ClassWithDefaultPackage() {
    delegate.testFindTypeByName_ClassWithDefaultPackage();
  }
  
  public void testFindTypeByName_NestedTypeQualifiedWithSubType_01() {
    delegate.testFindTypeByName_NestedTypeQualifiedWithSubType_01();
  }
  
  public void testFindTypeByName_NestedTypeQualifiedWithSubType_02() {
    delegate.testFindTypeByName_NestedTypeQualifiedWithSubType_02();
  }
  
  public void testFindTypeByName_TypeParamEndsWithDollar() {
    delegate.testFindTypeByName_TypeParamEndsWithDollar();
  }
  
  public void testFindTypeByName_int() {
    delegate.testFindTypeByName_int();
  }
  
  public void testFindTypeByName_int_array_01() {
    delegate.testFindTypeByName_int_array_01();
  }
  
  public void testFindTypeByName_int_array_02() {
    delegate.testFindTypeByName_int_array_02();
  }
  
  public void testFindTypeByName_int_array_03() {
    delegate.testFindTypeByName_int_array_03();
  }
  
  public void testFindTypeByName_int_array_04() {
    delegate.testFindTypeByName_int_array_04();
  }
  
  public void testFindTypeByName_int_twice() {
    delegate.testFindTypeByName_int_twice();
  }
  
  public void testFindTypeByName_javaLangCharSequence_01() {
    delegate.testFindTypeByName_javaLangCharSequence_01();
  }
  
  public void testFindTypeByName_javaLangCharSequence_02() {
    delegate.testFindTypeByName_javaLangCharSequence_02();
  }
  
  public void testFindTypeByName_javaLangCharSequence_03() {
    delegate.testFindTypeByName_javaLangCharSequence_03();
  }
  
  public void testFindTypeByName_javaLangCharSequence_04() {
    delegate.testFindTypeByName_javaLangCharSequence_04();
  }
  
  public void testFindTypeByName_javaLangNumber_01() {
    delegate.testFindTypeByName_javaLangNumber_01();
  }
  
  public void testFindTypeByName_javaLangNumber_02() {
    delegate.testFindTypeByName_javaLangNumber_02();
  }
  
  public void testFindTypeByName_javaUtilList_01() {
    delegate.testFindTypeByName_javaUtilList_01();
  }
  
  public void testFindTypeByName_javaUtilList_02() {
    delegate.testFindTypeByName_javaUtilList_02();
  }
  
  public void testFindTypeByName_javaUtilList_03() {
    delegate.testFindTypeByName_javaUtilList_03();
  }
  
  public void testFindTypeByName_javaUtilList_04() {
    delegate.testFindTypeByName_javaUtilList_04();
  }
  
  public void testFindTypeByName_javaUtilList_05() {
    delegate.testFindTypeByName_javaUtilList_05();
  }
  
  public void testFindTypeByName_javaUtilList_06() {
    delegate.testFindTypeByName_javaUtilList_06();
  }
  
  public void testFindTypeByName_javaUtilList_07() {
    delegate.testFindTypeByName_javaUtilList_07();
  }
  
  public void testFloatAnnotationValue_01() throws Exception {
    delegate.testFloatAnnotationValue_01();
  }
  
  public void testFloatAnnotationValue_02() throws Exception {
    delegate.testFloatAnnotationValue_02();
  }
  
  public void testFloatAnnotationValue_03() throws Exception {
    delegate.testFloatAnnotationValue_03();
  }
  
  public void testGoogleFunction() {
    delegate.testGoogleFunction();
  }
  
  public void testHashMap_01() {
    delegate.testHashMap_01();
  }
  
  public void testInnerAnnotationType() throws Exception {
    delegate.testInnerAnnotationType();
  }
  
  public void testInnerEnumType() throws Exception {
    delegate.testInnerEnumType();
  }
  
  public void testInnerType_WrappedIterator_01() throws Exception {
    delegate.testInnerType_WrappedIterator_01();
  }
  
  public void testInnerType_WrappedIterator_01b() throws Exception {
    delegate.testInnerType_WrappedIterator_01b();
  }
  
  public void testInnerType_WrappedIterator_02() throws Exception {
    delegate.testInnerType_WrappedIterator_02();
  }
  
  public void testInnerType_WrappedIterator_02b() throws Exception {
    delegate.testInnerType_WrappedIterator_02b();
  }
  
  public void testInnerType_WrappedIterator_03() throws Exception {
    delegate.testInnerType_WrappedIterator_03();
  }
  
  public void testInnerType_WrappedIterator_03b() throws Exception {
    delegate.testInnerType_WrappedIterator_03b();
  }
  
  public void testIntAnnotationValue_01() throws Exception {
    delegate.testIntAnnotationValue_01();
  }
  
  public void testIntAnnotationValue_02() throws Exception {
    delegate.testIntAnnotationValue_02();
  }
  
  public void testIntAnnotationValue_03() throws Exception {
    delegate.testIntAnnotationValue_03();
  }
  
  public void testLongAnnotationValue_01() throws Exception {
    delegate.testLongAnnotationValue_01();
  }
  
  public void testLongAnnotationValue_02() throws Exception {
    delegate.testLongAnnotationValue_02();
  }
  
  public void testLongAnnotationValue_03() throws Exception {
    delegate.testLongAnnotationValue_03();
  }
  
  public void testMemberCount_01() {
    delegate.testMemberCount_01();
  }
  
  public void testMemberCount_02() {
    delegate.testMemberCount_02();
  }
  
  public void testMemberCount_03() {
    delegate.testMemberCount_03();
  }
  
  public void testMemberCount_04() {
    delegate.testMemberCount_04();
  }
  
  public void testMemberCount_05() {
    delegate.testMemberCount_05();
  }
  
  public void testMemberCount_05_01() {
    delegate.testMemberCount_05_01();
  }
  
  public void testMemberCount_05_02() {
    delegate.testMemberCount_05_02();
  }
  
  public void testMemberCount_06() {
    delegate.testMemberCount_06();
  }
  
  public void testMemberCount_06_01() {
    delegate.testMemberCount_06_01();
  }
  
  public void testMemberCount_06_02() {
    delegate.testMemberCount_06_02();
  }
  
  public void testMemberCount_07() {
    delegate.testMemberCount_07();
  }
  
  public void testMemberCount_08() {
    delegate.testMemberCount_08();
  }
  
  public void testMemberCount_08_01() {
    delegate.testMemberCount_08_01();
  }
  
  public void testMemberCount_08_02() {
    delegate.testMemberCount_08_02();
  }
  
  public void testMemberCount_09() {
    delegate.testMemberCount_09();
  }
  
  public void testMemberCount_09_01() {
    delegate.testMemberCount_09_01();
  }
  
  public void testMemberCount_09_02() {
    delegate.testMemberCount_09_02();
  }
  
  public void testMemberCount_10() {
    delegate.testMemberCount_10();
  }
  
  public void testMemberCount_11() {
    delegate.testMemberCount_11();
  }
  
  public void testMemberCount_11_01() {
    delegate.testMemberCount_11_01();
  }
  
  public void testMemberCount_11_02() {
    delegate.testMemberCount_11_02();
  }
  
  public void testMemberCount_12() {
    delegate.testMemberCount_12();
  }
  
  public void testMemberCount_13() {
    delegate.testMemberCount_13();
  }
  
  public void testMemberCount_13_01() {
    delegate.testMemberCount_13_01();
  }
  
  public void testMemberCount_13_02() {
    delegate.testMemberCount_13_02();
  }
  
  public void testMemberCount_14() {
    delegate.testMemberCount_14();
  }
  
  public void testMemberCount_15() {
    delegate.testMemberCount_15();
  }
  
  public void testMemberCount_16() {
    delegate.testMemberCount_16();
  }
  
  public void testMemberCount_17() {
    delegate.testMemberCount_17();
  }
  
  public void testMemberCount_18() {
    delegate.testMemberCount_18();
  }
  
  public void testMethods_defaultStaticMethod_01() {
    delegate.testMethods_defaultStaticMethod_01();
  }
  
  public void testMethods_privateSynchronizedMethod_01() {
    delegate.testMethods_privateSynchronizedMethod_01();
  }
  
  public void testMethods_protectedFinalMethod_01() {
    delegate.testMethods_protectedFinalMethod_01();
  }
  
  public void testMethods_publicAbstractMethod_01() {
    delegate.testMethods_publicAbstractMethod_01();
  }
  
  public void testMethods_publicStrictFpMethod_01() {
    delegate.testMethods_publicStrictFpMethod_01();
  }
  
  public void testNestedAnnotationType_01() throws Exception {
    delegate.testNestedAnnotationType_01();
  }
  
  public void testNestedAnnotationType_02() throws Exception {
    delegate.testNestedAnnotationType_02();
  }
  
  public void testNestedEnum_01() throws Exception {
    delegate.testNestedEnum_01();
  }
  
  public void testNestedEnum_02() throws Exception {
    delegate.testNestedEnum_02();
  }
  
  public void testNestedEnum_03() throws Exception {
    delegate.testNestedEnum_03();
  }
  
  public void testNestedEnum_04() throws Exception {
    delegate.testNestedEnum_04();
  }
  
  public void testNestedEnum_05() throws Exception {
    delegate.testNestedEnum_05();
  }
  
  public void testParameterNames_01() {
    delegate.testParameterNames_01();
  }
  
  public void testParameterNames_02() {
    delegate.testParameterNames_02();
  }
  
  public void testParameterNames_03() {
    delegate.testParameterNames_03();
  }
  
  public void testPerformance() {
    delegate.testPerformance();
  }
  
  public void testRawIterable_01() {
    delegate.testRawIterable_01();
  }
  
  public void testShortAnnotationValue_01() throws Exception {
    delegate.testShortAnnotationValue_01();
  }
  
  public void testShortAnnotationValue_02() throws Exception {
    delegate.testShortAnnotationValue_02();
  }
  
  public void testShortAnnotationValue_03() throws Exception {
    delegate.testShortAnnotationValue_03();
  }
  
  public void testStrictFpType() {
    delegate.testStrictFpType();
  }
  
  public void testStringAnnotationValue_01() throws Exception {
    delegate.testStringAnnotationValue_01();
  }
  
  public void testStringAnnotationValue_02() throws Exception {
    delegate.testStringAnnotationValue_02();
  }
  
  public void testStringAnnotationValue_03() throws Exception {
    delegate.testStringAnnotationValue_03();
  }
  
  public void testStringAnnotationValue_04() throws Exception {
    delegate.testStringAnnotationValue_04();
  }
  
  public void testStringAnnotationValue_05() throws Exception {
    delegate.testStringAnnotationValue_05();
  }
  
  public void testStringAnnotationValue_06() throws Exception {
    delegate.testStringAnnotationValue_06();
  }
  
  public void testSuperTypeOfInterface() {
    delegate.testSuperTypeOfInterface();
  }
  
  public void testTypeParamEndsWithDollar_01() {
    delegate.testTypeParamEndsWithDollar_01();
  }
  
  public void testTypeParamEndsWithDollar_02() {
    delegate.testTypeParamEndsWithDollar_02();
  }
  
  public void testTypeParamEndsWithDollar_03() {
    delegate.testTypeParamEndsWithDollar_03();
  }
  
  public void testVarArgs_01() {
    delegate.testVarArgs_01();
  }
  
  public void testVarArgs_02() {
    delegate.testVarArgs_02();
  }
  
  public void testVarArgs_03() {
    delegate.testVarArgs_03();
  }
  
  public void test_ParameterizedTypes_01() {
    delegate.test_ParameterizedTypes_01();
  }
  
  public void test_ParameterizedTypes_02() {
    delegate.test_ParameterizedTypes_02();
  }
  
  public void test_ParameterizedTypes_03() {
    delegate.test_ParameterizedTypes_03();
  }
  
  public void test_ParameterizedTypes_04() {
    delegate.test_ParameterizedTypes_04();
  }
  
  public void test_ParameterizedTypes_05() {
    delegate.test_ParameterizedTypes_05();
  }
  
  public void test_ParameterizedTypes_06() {
    delegate.test_ParameterizedTypes_06();
  }
  
  public void test_ParameterizedTypes_Inner_01() {
    delegate.test_ParameterizedTypes_Inner_01();
  }
  
  public void test_ParameterizedTypes_Inner_02() {
    delegate.test_ParameterizedTypes_Inner_02();
  }
  
  public void test_ParameterizedTypes_Inner_03() {
    delegate.test_ParameterizedTypes_Inner_03();
  }
  
  public void test_ParameterizedTypes_Inner_04() {
    delegate.test_ParameterizedTypes_Inner_04();
  }
  
  public void test_ParameterizedTypes_Inner_05() {
    delegate.test_ParameterizedTypes_Inner_05();
  }
  
  public void test_ParameterizedTypes_Inner_06() {
    delegate.test_ParameterizedTypes_Inner_06();
  }
  
  public void test_ParameterizedTypes_Inner_07() {
    delegate.test_ParameterizedTypes_Inner_07();
  }
  
  public void test_ParameterizedTypes_Inner_08() {
    delegate.test_ParameterizedTypes_Inner_08();
  }
  
  public void test_ParameterizedTypes_Inner_X_01() {
    delegate.test_ParameterizedTypes_Inner_X_01();
  }
  
  public void test_ParameterizedTypes_Inner_Y_01() {
    delegate.test_ParameterizedTypes_Inner_Y_01();
  }
  
  public void test_ParameterizedTypes_Inner_Z_01() {
    delegate.test_ParameterizedTypes_Inner_Z_01();
  }
  
  public void test_ParameterizedTypes_S_01() {
    delegate.test_ParameterizedTypes_S_01();
  }
  
  public void test_ParameterizedTypes_T_01() {
    delegate.test_ParameterizedTypes_T_01();
  }
  
  public void test_ParameterizedTypes_U_01() {
    delegate.test_ParameterizedTypes_U_01();
  }
  
  public void test_ParameterizedTypes_V_01() {
    delegate.test_ParameterizedTypes_V_01();
  }
  
  public void test_ParameterizedTypes_W_01() {
    delegate.test_ParameterizedTypes_W_01();
  }
  
  public void test_ParameterizedTypes_W_02() {
    delegate.test_ParameterizedTypes_W_02();
  }
  
  public void test_ParameterizedTypes_inner_param_01() {
    delegate.test_ParameterizedTypes_inner_param_01();
  }
  
  public void test_ParameterizedTypes_inner_return_01() {
    delegate.test_ParameterizedTypes_inner_return_01();
  }
  
  public void test_ParameterizedTypes_inner_return_02() {
    delegate.test_ParameterizedTypes_inner_return_02();
  }
  
  public void test_arrayParameterized_01() {
    delegate.test_arrayParameterized_01();
  }
  
  public void test_arrayParameterized_02() {
    delegate.test_arrayParameterized_02();
  }
  
  public void test_arrayVariable_01() {
    delegate.test_arrayVariable_01();
  }
  
  public void test_arrayVariable_02() {
    delegate.test_arrayVariable_02();
  }
  
  public void test_arrayWildcard_01() {
    delegate.test_arrayWildcard_01();
  }
  
  public void test_arrayWildcard_02() {
    delegate.test_arrayWildcard_02();
  }
  
  public void test_nestedArrayParameterized_01() {
    delegate.test_nestedArrayParameterized_01();
  }
  
  public void test_nestedArrayParameterized_02() {
    delegate.test_nestedArrayParameterized_02();
  }
  
  public void test_nestedArrayVariable_01() {
    delegate.test_nestedArrayVariable_01();
  }
  
  public void test_nestedArrayVariable_02() {
    delegate.test_nestedArrayVariable_02();
  }
  
  public void test_nestedArrayWildcard_01() {
    delegate.test_nestedArrayWildcard_01();
  }
  
  public void test_nestedArrayWildcard_02() {
    delegate.test_nestedArrayWildcard_02();
  }
  
  public void test_nestedInterface_Outer_01() {
    delegate.test_nestedInterface_Outer_01();
  }
  
  public void test_nestedInterface_Outer_02() {
    delegate.test_nestedInterface_Outer_02();
  }
  
  public void test_nestedInterface_Outer_Inner_01() {
    delegate.test_nestedInterface_Outer_Inner_01();
  }
  
  public void test_nestedInterface_Outer_Inner_02() {
    delegate.test_nestedInterface_Outer_Inner_02();
  }
  
  public void test_nestedTypes_Outer_01() {
    delegate.test_nestedTypes_Outer_01();
  }
  
  public void test_nestedTypes_Outer_02() {
    delegate.test_nestedTypes_Outer_02();
  }
  
  public void test_nestedTypes_Outer_Inner_01() {
    delegate.test_nestedTypes_Outer_Inner_01();
  }
  
  public void test_nestedTypes_Outer_Inner_02() {
    delegate.test_nestedTypes_Outer_Inner_02();
  }
  
  public void test_staticNestedTypes_Outer() {
    delegate.test_staticNestedTypes_Outer();
  }
  
  public void test_staticNestedTypes_Outer_Inner() {
    delegate.test_staticNestedTypes_Outer_Inner();
  }
  
  public void test_staticNestedTypes_Outer_Inner_method() {
    delegate.test_staticNestedTypes_Outer_Inner_method();
  }
  
  public void test_staticNestedTypes_Outer_method() {
    delegate.test_staticNestedTypes_Outer_method();
  }
  
  public void test_staticNestedTypes_constructor() {
    delegate.test_staticNestedTypes_constructor();
  }
  
  public void test_staticNestedTypes_method() {
    delegate.test_staticNestedTypes_method();
  }
  
  public void test_twoListParamsListResult_01() {
    delegate.test_twoListParamsListResult_01();
  }
  
  public void test_twoListParamsListResult_02() {
    delegate.test_twoListParamsListResult_02();
  }
  
  public void test_twoListParamsListResult_03() {
    delegate.test_twoListParamsListResult_03();
  }
  
  public void test_twoListParamsNoResult_01() {
    delegate.test_twoListParamsNoResult_01();
  }
  
  public void test_twoListParamsNoResult_02() {
    delegate.test_twoListParamsNoResult_02();
  }
  
  public void test_twoListParamsNoResult_03() {
    delegate.test_twoListParamsNoResult_03();
  }
  
  public void test_twoListWildcardsListResult_01() {
    delegate.test_twoListWildcardsListResult_01();
  }
  
  public void test_twoListWildcardsListResult_02() {
    delegate.test_twoListWildcardsListResult_02();
  }
  
  public void test_twoListWildcardsListResult_03() {
    delegate.test_twoListWildcardsListResult_03();
  }
  
  public void test_twoListWildcardsNoResult_01() {
    delegate.test_twoListWildcardsNoResult_01();
  }
  
  public void test_twoListWildcardsNoResult_02() {
    delegate.test_twoListWildcardsNoResult_02();
  }
  
  public void test_twoListWildcardsNoResult_03() {
    delegate.test_twoListWildcardsNoResult_03();
  }
}
