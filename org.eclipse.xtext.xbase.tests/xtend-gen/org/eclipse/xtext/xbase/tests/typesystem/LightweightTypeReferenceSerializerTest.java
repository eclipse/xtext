package org.eclipse.xtext.xbase.tests.typesystem;

import java.io.Serializable;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function3;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractLightweightTypeReferenceTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.TestAppender;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class LightweightTypeReferenceSerializerTest extends AbstractLightweightTypeReferenceTestCase {
  @Override
  protected ParameterizedTypeReference typeRef(final Class<?> type) {
    return this.getOwner().newParameterizedTypeReference(this.type(type));
  }
  
  @Test
  public void testObject() {
    this.assertInXtendAndJava(this.typeRef(Object.class), "java.lang.Object");
  }
  
  @Test
  public void testList() {
    this.assertInXtendAndJava(this.typeRef(List.class), "java.util.List");
  }
  
  @Test
  public void testListWildcard() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = (ParameterizedTypeReference it) -> {
      it.addTypeArgument(it.getOwner().newWildcardTypeReference());
    };
    this.assertInXtendAndJava(ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function), "java.util.List<?>");
  }
  
  @Test
  public void testListUpperBound() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = (ParameterizedTypeReference it) -> {
      WildcardTypeReference _newWildcardTypeReference = it.getOwner().newWildcardTypeReference();
      final Procedure1<WildcardTypeReference> _function_1 = (WildcardTypeReference it_1) -> {
        it_1.addUpperBound(this.typeRef(CharSequence.class));
      };
      WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_newWildcardTypeReference, _function_1);
      it.addTypeArgument(_doubleArrow);
    };
    this.assertInXtendAndJava(ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function), "java.util.List<? extends java.lang.CharSequence>");
  }
  
  @Test
  public void testListUpperBoundObject() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = (ParameterizedTypeReference it) -> {
      WildcardTypeReference _newWildcardTypeReference = it.getOwner().newWildcardTypeReference();
      final Procedure1<WildcardTypeReference> _function_1 = (WildcardTypeReference it_1) -> {
        it_1.addUpperBound(this.typeRef(Object.class));
      };
      WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_newWildcardTypeReference, _function_1);
      it.addTypeArgument(_doubleArrow);
    };
    this.assertInXtendAndJava(ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function), "java.util.List<?>");
  }
  
  @Test
  public void testListUpperBounds() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = (ParameterizedTypeReference it) -> {
      WildcardTypeReference _newWildcardTypeReference = it.getOwner().newWildcardTypeReference();
      final Procedure1<WildcardTypeReference> _function_1 = (WildcardTypeReference it_1) -> {
        it_1.addUpperBound(this.typeRef(CharSequence.class));
        it_1.addUpperBound(this.typeRef(Serializable.class));
      };
      WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_newWildcardTypeReference, _function_1);
      it.addTypeArgument(_doubleArrow);
    };
    this.assertInXtendAndJava(ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function), "java.util.List<? extends java.lang.CharSequence & java.io.Serializable>");
  }
  
  @Test
  public void testListUpperBoundsIncludingObject() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = (ParameterizedTypeReference it) -> {
      WildcardTypeReference _newWildcardTypeReference = it.getOwner().newWildcardTypeReference();
      final Procedure1<WildcardTypeReference> _function_1 = (WildcardTypeReference it_1) -> {
        it_1.addUpperBound(this.typeRef(CharSequence.class));
        it_1.addUpperBound(this.typeRef(Object.class));
        it_1.addUpperBound(this.typeRef(Serializable.class));
      };
      WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_newWildcardTypeReference, _function_1);
      it.addTypeArgument(_doubleArrow);
    };
    this.assertInXtendAndJava(ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function), "java.util.List<? extends java.lang.CharSequence & java.io.Serializable>");
  }
  
  @Test
  public void testListLowerBound() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = (ParameterizedTypeReference it) -> {
      WildcardTypeReference _newWildcardTypeReference = it.getOwner().newWildcardTypeReference();
      final Procedure1<WildcardTypeReference> _function_1 = (WildcardTypeReference it_1) -> {
        it_1.setLowerBound(this.typeRef(CharSequence.class));
      };
      WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_newWildcardTypeReference, _function_1);
      it.addTypeArgument(_doubleArrow);
    };
    this.assertInXtendAndJava(ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function), "java.util.List<? super java.lang.CharSequence>");
  }
  
  @Test
  public void testListLowerAndUpperBound() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = (ParameterizedTypeReference it) -> {
      WildcardTypeReference _newWildcardTypeReference = it.getOwner().newWildcardTypeReference();
      final Procedure1<WildcardTypeReference> _function_1 = (WildcardTypeReference it_1) -> {
        it_1.setLowerBound(this.typeRef(CharSequence.class));
        it_1.addUpperBound(this.typeRef(Serializable.class));
      };
      WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_newWildcardTypeReference, _function_1);
      it.addTypeArgument(_doubleArrow);
    };
    this.assertInXtendAndJava(ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function), "java.util.List<? super java.lang.CharSequence>");
  }
  
  @Test
  public void testArray() {
    this.assertInXtendAndJava(this.getOwner().newArrayTypeReference(this.typeRef(Object.class)), "java.lang.Object[]");
  }
  
  @Test
  public void testArray2() {
    this.assertInXtendAndJava(this.getOwner().newArrayTypeReference(this.getOwner().newArrayTypeReference(this.typeRef(Object.class))), "java.lang.Object[][]");
  }
  
  @Test
  public void testArrayGeneric() {
    ITypeReferenceOwner _owner = this.getOwner();
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = (ParameterizedTypeReference it) -> {
      WildcardTypeReference _newWildcardTypeReference = it.getOwner().newWildcardTypeReference();
      final Procedure1<WildcardTypeReference> _function_1 = (WildcardTypeReference it_1) -> {
        it_1.setLowerBound(this.typeRef(CharSequence.class));
      };
      WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_newWildcardTypeReference, _function_1);
      it.addTypeArgument(_doubleArrow);
    };
    ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function);
    this.assertInXtendAndJava(_owner.newArrayTypeReference(_doubleArrow), "java.util.List<? super java.lang.CharSequence>[]");
  }
  
  @Test
  public void testAnyType() {
    this.assertInXtendAndJava(this.getOwner().newAnyTypeReference(), "java.lang.Object");
  }
  
  @Test
  public void testFunctionType() {
    this.assertInJava(this.assertInXtend(this.getOwner().newFunctionTypeReference(this.type(Function0.class)), "()=>void"), "org.eclipse.xtext.xbase.lib.Functions$Function0");
  }
  
  @Test
  public void testFunctionType1() {
    FunctionTypeReference _newFunctionTypeReference = this.getOwner().newFunctionTypeReference(this.type(Function0.class));
    final Procedure1<FunctionTypeReference> _function = (FunctionTypeReference it) -> {
      it.setReturnType(this.typeRef(String.class));
      it.addTypeArgument(this.typeRef(String.class));
    };
    this.assertInJava(this.assertInXtend(ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_newFunctionTypeReference, _function), "()=>java.lang.String"), "org.eclipse.xtext.xbase.lib.Functions$Function0<java.lang.String>");
  }
  
  @Test
  public void testFunctionType2() {
    FunctionTypeReference _newFunctionTypeReference = this.getOwner().newFunctionTypeReference(this.type(Function1.class));
    final Procedure1<FunctionTypeReference> _function = (FunctionTypeReference it) -> {
      it.addParameterType(this.typeRef(String.class));
      it.addTypeArgument(this.typeRef(Void.class));
      it.addTypeArgument(this.typeRef(String.class));
    };
    this.assertInJava(this.assertInXtend(ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_newFunctionTypeReference, _function), "(java.lang.String)=>void"), "org.eclipse.xtext.xbase.lib.Functions$Function1<java.lang.Void, java.lang.String>");
  }
  
  @Test
  public void testFunctionType3() {
    FunctionTypeReference _newFunctionTypeReference = this.getOwner().newFunctionTypeReference(this.type(Function1.class));
    final Procedure1<FunctionTypeReference> _function = (FunctionTypeReference it) -> {
      it.setReturnType(this.typeRef(Object.class));
      it.addTypeArgument(this.typeRef(Object.class));
      it.addParameterType(this.typeRef(String.class));
      it.addTypeArgument(this.typeRef(String.class));
    };
    this.assertInJava(this.assertInXtend(ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_newFunctionTypeReference, _function), "(java.lang.String)=>java.lang.Object"), "org.eclipse.xtext.xbase.lib.Functions$Function1<java.lang.Object, java.lang.String>");
  }
  
  @Test
  public void testFunctionType4() {
    FunctionTypeReference _newFunctionTypeReference = this.getOwner().newFunctionTypeReference(this.type(Function3.class));
    final Procedure1<FunctionTypeReference> _function = (FunctionTypeReference it) -> {
      it.setReturnType(this.typeRef(Object.class));
      it.addTypeArgument(this.typeRef(Object.class));
      it.addParameterType(this.typeRef(String.class));
      it.addTypeArgument(this.typeRef(String.class));
      ParameterizedTypeReference _typeRef = this.typeRef(List.class);
      final Procedure1<ParameterizedTypeReference> _function_1 = (ParameterizedTypeReference it_1) -> {
        WildcardTypeReference _newWildcardTypeReference = it_1.getOwner().newWildcardTypeReference();
        final Procedure1<WildcardTypeReference> _function_2 = (WildcardTypeReference it_2) -> {
          it_2.setLowerBound(this.typeRef(CharSequence.class));
        };
        WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_newWildcardTypeReference, _function_2);
        it_1.addTypeArgument(_doubleArrow);
      };
      final ParameterizedTypeReference listOfCharSequence = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function_1);
      it.addParameterType(listOfCharSequence);
      it.addTypeArgument(listOfCharSequence);
      final ArrayTypeReference arrayOfObject = it.getOwner().newArrayTypeReference(this.typeRef(Object.class));
      it.addParameterType(arrayOfObject);
      it.addTypeArgument(arrayOfObject);
    };
    this.assertInJava(this.assertInXtend(ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_newFunctionTypeReference, _function), "(java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[])=>java.lang.Object"), "org.eclipse.xtext.xbase.lib.Functions$Function3<java.lang.Object, java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[]>");
  }
  
  @Test
  public void testFunctionType5() {
    this.assertInJava(this.assertInXtend(this.getOwner().newFunctionTypeReference(this.type(Procedure0.class)), "()=>void"), "org.eclipse.xtext.xbase.lib.Procedures$Procedure0");
  }
  
  @Test
  public void testFunctionType6() {
    FunctionTypeReference _newFunctionTypeReference = this.getOwner().newFunctionTypeReference(this.type(Procedure1.class));
    final Procedure1<FunctionTypeReference> _function = (FunctionTypeReference it) -> {
      it.addParameterType(this.typeRef(String.class));
      it.addTypeArgument(this.typeRef(String.class));
    };
    this.assertInJava(this.assertInXtend(ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_newFunctionTypeReference, _function), "(java.lang.String)=>void"), "org.eclipse.xtext.xbase.lib.Procedures$Procedure1<java.lang.String>");
  }
  
  @Test
  public void testFunctionType7() {
    FunctionTypeReference _newFunctionTypeReference = this.getOwner().newFunctionTypeReference(this.type(Procedure3.class));
    final Procedure1<FunctionTypeReference> _function = (FunctionTypeReference it) -> {
      it.addParameterType(this.typeRef(String.class));
      it.addTypeArgument(this.typeRef(String.class));
      ParameterizedTypeReference _typeRef = this.typeRef(List.class);
      final Procedure1<ParameterizedTypeReference> _function_1 = (ParameterizedTypeReference it_1) -> {
        WildcardTypeReference _newWildcardTypeReference = it_1.getOwner().newWildcardTypeReference();
        final Procedure1<WildcardTypeReference> _function_2 = (WildcardTypeReference it_2) -> {
          it_2.setLowerBound(this.typeRef(CharSequence.class));
        };
        WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_newWildcardTypeReference, _function_2);
        it_1.addTypeArgument(_doubleArrow);
      };
      final ParameterizedTypeReference listOfCharSequence = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function_1);
      it.addParameterType(listOfCharSequence);
      it.addTypeArgument(listOfCharSequence);
      final ArrayTypeReference arrayOfObject = it.getOwner().newArrayTypeReference(this.typeRef(Object.class));
      it.addParameterType(arrayOfObject);
      it.addTypeArgument(arrayOfObject);
    };
    this.assertInJava(this.assertInXtend(ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_newFunctionTypeReference, _function), "(java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[])=>void"), "org.eclipse.xtext.xbase.lib.Procedures$Procedure3<java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[]>");
  }
  
  @Test
  public void testFunctionType8() {
    this.assertInJava(this.assertInXtend(this.getOwner().newFunctionTypeReference(this.type(Runnable.class)), "()=>void"), "java.lang.Runnable");
  }
  
  @Test
  public void testFunctionType9() {
    FunctionTypeReference _newFunctionTypeReference = this.getOwner().newFunctionTypeReference(this.type(Readable.class));
    final Procedure1<FunctionTypeReference> _function = (FunctionTypeReference it) -> {
      it.addParameterType(this.typeRef(CharBuffer.class));
      it.setReturnType(this.typeRef(Integer.TYPE));
    };
    this.assertInJava(this.assertInXtend(ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_newFunctionTypeReference, _function), "(java.nio.CharBuffer)=>int"), "java.lang.Readable");
  }
  
  @Test
  public void testFunctionType10() {
    FunctionTypeReference _newFunctionTypeReference = this.getOwner().newFunctionTypeReference(this.type(Iterable.class));
    final Procedure1<FunctionTypeReference> _function = (FunctionTypeReference it) -> {
      it.addTypeArgument(this.typeRef(String.class));
      ParameterizedTypeReference _typeRef = this.typeRef(Iterator.class);
      final Procedure1<ParameterizedTypeReference> _function_1 = (ParameterizedTypeReference it_1) -> {
        it_1.addTypeArgument(this.typeRef(String.class));
      };
      ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function_1);
      it.setReturnType(_doubleArrow);
    };
    this.assertInJava(this.assertInXtend(ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_newFunctionTypeReference, _function), "()=>java.util.Iterator<java.lang.String>"), "java.lang.Iterable<java.lang.String>");
  }
  
  @Test
  @Ignore
  public void testUnboundTypeReference() {
    this.assertInXtendAndJava(UnboundTypeReference.create(null, null, null), "java.lang.Object");
  }
  
  @Test
  public void testUnknownTypeReference() {
    this.assertInXtendAndJava(this.getOwner().newUnknownTypeReference("Foo"), "Foo");
  }
  
  @Test
  public void testUnknownTypeReference1() {
    this.assertInXtendAndJava(this.getOwner().newUnknownTypeReference(), "Object");
  }
  
  protected void assertInXtendAndJava(final LightweightTypeReference ref, final String expectation) {
    this.assertInXtend(ref, expectation);
    this.assertInJava(ref, expectation);
  }
  
  protected LightweightTypeReference assertInXtend(final LightweightTypeReference ref, final String expectation) {
    return this.assertIn(ref, expectation, false);
  }
  
  protected LightweightTypeReference assertInJava(final LightweightTypeReference ref, final String expectation) {
    return this.assertIn(ref, expectation, true);
  }
  
  protected LightweightTypeReference assertIn(final LightweightTypeReference ref, final String expectation, final boolean isJava) {
    final TestAppender appender = new TestAppender(isJava);
    final LightweightTypeReferenceSerializer serializer = new LightweightTypeReferenceSerializer(appender);
    ref.accept(serializer);
    Assert.assertEquals(expectation, appender.toString());
    return ref;
  }
}
