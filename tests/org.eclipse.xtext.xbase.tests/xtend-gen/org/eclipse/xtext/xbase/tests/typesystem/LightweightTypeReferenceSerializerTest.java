package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.io.Serializable;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.List;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function3;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.TestAppender;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class LightweightTypeReferenceSerializerTest extends AbstractXbaseTestCase {
  @Inject
  private CommonTypeComputationServices services;
  
  @Inject
  private XtextResourceSet resourceSet;
  
  @Test
  public void testObject() {
    ParameterizedTypeReference _typeRef = this.typeRef(Object.class);
    this.assertInXtendAndJava(_typeRef, "java.lang.Object");
  }
  
  @Test
  public void testList() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    this.assertInXtendAndJava(_typeRef, "java.util.List");
  }
  
  @Test
  public void testListWildcard() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = new Procedure1<ParameterizedTypeReference>() {
      public void apply(final ParameterizedTypeReference it) {
        ITypeReferenceOwner _owner = it.getOwner();
        WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(_owner);
        it.addTypeArgument(_wildcardTypeReference);
      }
    };
    ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function);
    this.assertInXtendAndJava(_doubleArrow, "java.util.List<?>");
  }
  
  @Test
  public void testListUpperBound() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = new Procedure1<ParameterizedTypeReference>() {
      public void apply(final ParameterizedTypeReference it) {
        ITypeReferenceOwner _owner = it.getOwner();
        WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(_owner);
        final Procedure1<WildcardTypeReference> _function = new Procedure1<WildcardTypeReference>() {
          public void apply(final WildcardTypeReference it) {
            ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(CharSequence.class);
            it.addUpperBound(_typeRef);
          }
        };
        WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_wildcardTypeReference, _function);
        it.addTypeArgument(_doubleArrow);
      }
    };
    ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function);
    this.assertInXtendAndJava(_doubleArrow, "java.util.List<? extends java.lang.CharSequence>");
  }
  
  @Test
  public void testListUpperBoundObject() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = new Procedure1<ParameterizedTypeReference>() {
      public void apply(final ParameterizedTypeReference it) {
        ITypeReferenceOwner _owner = it.getOwner();
        WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(_owner);
        final Procedure1<WildcardTypeReference> _function = new Procedure1<WildcardTypeReference>() {
          public void apply(final WildcardTypeReference it) {
            ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(Object.class);
            it.addUpperBound(_typeRef);
          }
        };
        WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_wildcardTypeReference, _function);
        it.addTypeArgument(_doubleArrow);
      }
    };
    ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function);
    this.assertInXtendAndJava(_doubleArrow, "java.util.List<?>");
  }
  
  @Test
  public void testListUpperBounds() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = new Procedure1<ParameterizedTypeReference>() {
      public void apply(final ParameterizedTypeReference it) {
        ITypeReferenceOwner _owner = it.getOwner();
        WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(_owner);
        final Procedure1<WildcardTypeReference> _function = new Procedure1<WildcardTypeReference>() {
          public void apply(final WildcardTypeReference it) {
            ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(CharSequence.class);
            it.addUpperBound(_typeRef);
            ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(Serializable.class);
            it.addUpperBound(_typeRef_1);
          }
        };
        WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_wildcardTypeReference, _function);
        it.addTypeArgument(_doubleArrow);
      }
    };
    ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function);
    this.assertInXtendAndJava(_doubleArrow, "java.util.List<? extends java.lang.CharSequence & java.io.Serializable>");
  }
  
  @Test
  public void testListUpperBoundsIncludingObject() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = new Procedure1<ParameterizedTypeReference>() {
      public void apply(final ParameterizedTypeReference it) {
        ITypeReferenceOwner _owner = it.getOwner();
        WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(_owner);
        final Procedure1<WildcardTypeReference> _function = new Procedure1<WildcardTypeReference>() {
          public void apply(final WildcardTypeReference it) {
            ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(CharSequence.class);
            it.addUpperBound(_typeRef);
            ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(Object.class);
            it.addUpperBound(_typeRef_1);
            ParameterizedTypeReference _typeRef_2 = LightweightTypeReferenceSerializerTest.this.typeRef(Serializable.class);
            it.addUpperBound(_typeRef_2);
          }
        };
        WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_wildcardTypeReference, _function);
        it.addTypeArgument(_doubleArrow);
      }
    };
    ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function);
    this.assertInXtendAndJava(_doubleArrow, "java.util.List<? extends java.lang.CharSequence & java.io.Serializable>");
  }
  
  @Test
  public void testListLowerBound() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = new Procedure1<ParameterizedTypeReference>() {
      public void apply(final ParameterizedTypeReference it) {
        ITypeReferenceOwner _owner = it.getOwner();
        WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(_owner);
        final Procedure1<WildcardTypeReference> _function = new Procedure1<WildcardTypeReference>() {
          public void apply(final WildcardTypeReference it) {
            ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(CharSequence.class);
            it.setLowerBound(_typeRef);
          }
        };
        WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_wildcardTypeReference, _function);
        it.addTypeArgument(_doubleArrow);
      }
    };
    ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function);
    this.assertInXtendAndJava(_doubleArrow, "java.util.List<? super java.lang.CharSequence>");
  }
  
  @Test
  public void testListLowerAndUpperBound() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = new Procedure1<ParameterizedTypeReference>() {
      public void apply(final ParameterizedTypeReference it) {
        ITypeReferenceOwner _owner = it.getOwner();
        WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(_owner);
        final Procedure1<WildcardTypeReference> _function = new Procedure1<WildcardTypeReference>() {
          public void apply(final WildcardTypeReference it) {
            ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(CharSequence.class);
            it.setLowerBound(_typeRef);
            ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(Serializable.class);
            it.addUpperBound(_typeRef_1);
          }
        };
        WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_wildcardTypeReference, _function);
        it.addTypeArgument(_doubleArrow);
      }
    };
    ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function);
    this.assertInXtendAndJava(_doubleArrow, "java.util.List<? super java.lang.CharSequence>");
  }
  
  @Test
  public void testArray() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    ParameterizedTypeReference _typeRef = this.typeRef(Object.class);
    ArrayTypeReference _arrayTypeReference = new ArrayTypeReference(_owner, _typeRef);
    this.assertInXtendAndJava(_arrayTypeReference, "java.lang.Object[]");
  }
  
  @Test
  public void testArray2() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    StandardTypeReferenceOwner _owner_1 = this.getOwner();
    ParameterizedTypeReference _typeRef = this.typeRef(Object.class);
    ArrayTypeReference _arrayTypeReference = new ArrayTypeReference(_owner_1, _typeRef);
    ArrayTypeReference _arrayTypeReference_1 = new ArrayTypeReference(_owner, _arrayTypeReference);
    this.assertInXtendAndJava(_arrayTypeReference_1, "java.lang.Object[][]");
  }
  
  @Test
  public void testArrayGeneric() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    final Procedure1<ParameterizedTypeReference> _function = new Procedure1<ParameterizedTypeReference>() {
      public void apply(final ParameterizedTypeReference it) {
        ITypeReferenceOwner _owner = it.getOwner();
        WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(_owner);
        final Procedure1<WildcardTypeReference> _function = new Procedure1<WildcardTypeReference>() {
          public void apply(final WildcardTypeReference it) {
            ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(CharSequence.class);
            it.setLowerBound(_typeRef);
          }
        };
        WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_wildcardTypeReference, _function);
        it.addTypeArgument(_doubleArrow);
      }
    };
    ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef, _function);
    ArrayTypeReference _arrayTypeReference = new ArrayTypeReference(_owner, _doubleArrow);
    this.assertInXtendAndJava(_arrayTypeReference, "java.util.List<? super java.lang.CharSequence>[]");
  }
  
  @Test
  public void testAnyType() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    AnyTypeReference _anyTypeReference = new AnyTypeReference(_owner);
    this.assertInXtendAndJava(_anyTypeReference, "java.lang.Object");
  }
  
  @Test
  public void testFunctionType() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Function0.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    LightweightTypeReference _assertInXtend = this.assertInXtend(_functionTypeReference, "()=>void");
    this.assertInJava(_assertInXtend, "org.eclipse.xtext.xbase.lib.Functions$Function0");
  }
  
  @Test
  public void testFunctionType1() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Function0.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
      public void apply(final FunctionTypeReference it) {
        ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.setReturnType(_typeRef);
        ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.addTypeArgument(_typeRef_1);
      }
    };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    LightweightTypeReference _assertInXtend = this.assertInXtend(_doubleArrow, "()=>java.lang.String");
    this.assertInJava(_assertInXtend, "org.eclipse.xtext.xbase.lib.Functions$Function0<java.lang.String>");
  }
  
  @Test
  public void testFunctionType2() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Function1.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
      public void apply(final FunctionTypeReference it) {
        ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.addParameterType(_typeRef);
        ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(Void.class);
        it.addTypeArgument(_typeRef_1);
        ParameterizedTypeReference _typeRef_2 = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.addTypeArgument(_typeRef_2);
      }
    };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    LightweightTypeReference _assertInXtend = this.assertInXtend(_doubleArrow, "(java.lang.String)=>void");
    this.assertInJava(_assertInXtend, "org.eclipse.xtext.xbase.lib.Functions$Function1<java.lang.Void, java.lang.String>");
  }
  
  @Test
  public void testFunctionType3() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Function1.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
      public void apply(final FunctionTypeReference it) {
        ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(Object.class);
        it.setReturnType(_typeRef);
        ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(Object.class);
        it.addTypeArgument(_typeRef_1);
        ParameterizedTypeReference _typeRef_2 = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.addParameterType(_typeRef_2);
        ParameterizedTypeReference _typeRef_3 = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.addTypeArgument(_typeRef_3);
      }
    };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    LightweightTypeReference _assertInXtend = this.assertInXtend(_doubleArrow, "(java.lang.String)=>java.lang.Object");
    this.assertInJava(_assertInXtend, "org.eclipse.xtext.xbase.lib.Functions$Function1<java.lang.Object, java.lang.String>");
  }
  
  @Test
  public void testFunctionType4() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Function3.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
      public void apply(final FunctionTypeReference it) {
        ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(Object.class);
        it.setReturnType(_typeRef);
        ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(Object.class);
        it.addTypeArgument(_typeRef_1);
        ParameterizedTypeReference _typeRef_2 = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.addParameterType(_typeRef_2);
        ParameterizedTypeReference _typeRef_3 = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.addTypeArgument(_typeRef_3);
        ParameterizedTypeReference _typeRef_4 = LightweightTypeReferenceSerializerTest.this.typeRef(List.class);
        final Procedure1<ParameterizedTypeReference> _function = new Procedure1<ParameterizedTypeReference>() {
          public void apply(final ParameterizedTypeReference it) {
            ITypeReferenceOwner _owner = it.getOwner();
            WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(_owner);
            final Procedure1<WildcardTypeReference> _function = new Procedure1<WildcardTypeReference>() {
              public void apply(final WildcardTypeReference it) {
                ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(CharSequence.class);
                it.setLowerBound(_typeRef);
              }
            };
            WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_wildcardTypeReference, _function);
            it.addTypeArgument(_doubleArrow);
          }
        };
        final ParameterizedTypeReference listOfCharSequence = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef_4, _function);
        it.addParameterType(listOfCharSequence);
        it.addTypeArgument(listOfCharSequence);
        ITypeReferenceOwner _owner = it.getOwner();
        ParameterizedTypeReference _typeRef_5 = LightweightTypeReferenceSerializerTest.this.typeRef(Object.class);
        final ArrayTypeReference arrayOfObject = new ArrayTypeReference(_owner, _typeRef_5);
        it.addParameterType(arrayOfObject);
        it.addTypeArgument(arrayOfObject);
      }
    };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    LightweightTypeReference _assertInXtend = this.assertInXtend(_doubleArrow, "(java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[])=>java.lang.Object");
    this.assertInJava(_assertInXtend, "org.eclipse.xtext.xbase.lib.Functions$Function3<java.lang.Object, java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[]>");
  }
  
  @Test
  public void testFunctionType5() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Procedure0.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    LightweightTypeReference _assertInXtend = this.assertInXtend(_functionTypeReference, "()=>void");
    this.assertInJava(_assertInXtend, "org.eclipse.xtext.xbase.lib.Procedures$Procedure0");
  }
  
  @Test
  public void testFunctionType6() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Procedure1.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
      public void apply(final FunctionTypeReference it) {
        ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.addParameterType(_typeRef);
        ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.addTypeArgument(_typeRef_1);
      }
    };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    LightweightTypeReference _assertInXtend = this.assertInXtend(_doubleArrow, "(java.lang.String)=>void");
    this.assertInJava(_assertInXtend, "org.eclipse.xtext.xbase.lib.Procedures$Procedure1<java.lang.String>");
  }
  
  @Test
  public void testFunctionType7() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Procedure3.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
      public void apply(final FunctionTypeReference it) {
        ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.addParameterType(_typeRef);
        ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.addTypeArgument(_typeRef_1);
        ParameterizedTypeReference _typeRef_2 = LightweightTypeReferenceSerializerTest.this.typeRef(List.class);
        final Procedure1<ParameterizedTypeReference> _function = new Procedure1<ParameterizedTypeReference>() {
          public void apply(final ParameterizedTypeReference it) {
            ITypeReferenceOwner _owner = it.getOwner();
            WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(_owner);
            final Procedure1<WildcardTypeReference> _function = new Procedure1<WildcardTypeReference>() {
              public void apply(final WildcardTypeReference it) {
                ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(CharSequence.class);
                it.setLowerBound(_typeRef);
              }
            };
            WildcardTypeReference _doubleArrow = ObjectExtensions.<WildcardTypeReference>operator_doubleArrow(_wildcardTypeReference, _function);
            it.addTypeArgument(_doubleArrow);
          }
        };
        final ParameterizedTypeReference listOfCharSequence = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef_2, _function);
        it.addParameterType(listOfCharSequence);
        it.addTypeArgument(listOfCharSequence);
        ITypeReferenceOwner _owner = it.getOwner();
        ParameterizedTypeReference _typeRef_3 = LightweightTypeReferenceSerializerTest.this.typeRef(Object.class);
        final ArrayTypeReference arrayOfObject = new ArrayTypeReference(_owner, _typeRef_3);
        it.addParameterType(arrayOfObject);
        it.addTypeArgument(arrayOfObject);
      }
    };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    LightweightTypeReference _assertInXtend = this.assertInXtend(_doubleArrow, "(java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[])=>void");
    this.assertInJava(_assertInXtend, "org.eclipse.xtext.xbase.lib.Procedures$Procedure3<java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[]>");
  }
  
  @Test
  public void testFunctionType8() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Runnable.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    LightweightTypeReference _assertInXtend = this.assertInXtend(_functionTypeReference, "()=>void");
    this.assertInJava(_assertInXtend, "java.lang.Runnable");
  }
  
  @Test
  public void testFunctionType9() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Readable.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
      public void apply(final FunctionTypeReference it) {
        ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(CharBuffer.class);
        it.addParameterType(_typeRef);
        ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(Integer.TYPE);
        it.setReturnType(_typeRef_1);
      }
    };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    LightweightTypeReference _assertInXtend = this.assertInXtend(_doubleArrow, "(java.nio.CharBuffer)=>int");
    this.assertInJava(_assertInXtend, "java.lang.Readable");
  }
  
  @Test
  public void testFunctionType10() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Iterable.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
      public void apply(final FunctionTypeReference it) {
        ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
        it.addTypeArgument(_typeRef);
        ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(Iterator.class);
        final Procedure1<ParameterizedTypeReference> _function = new Procedure1<ParameterizedTypeReference>() {
          public void apply(final ParameterizedTypeReference it) {
            ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
            it.addTypeArgument(_typeRef);
          }
        };
        ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef_1, _function);
        it.setReturnType(_doubleArrow);
      }
    };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    LightweightTypeReference _assertInXtend = this.assertInXtend(_doubleArrow, "()=>java.util.Iterator<java.lang.String>");
    this.assertInJava(_assertInXtend, "java.lang.Iterable<java.lang.String>");
  }
  
  @Test
  @Ignore
  public void testUnboundTypeReference() {
    UnboundTypeReference _create = UnboundTypeReference.create(null, null, null);
    this.assertInXtendAndJava(_create, "java.lang.Object");
  }
  
  @Test
  public void testUnknownTypeReference() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    UnknownTypeReference _unknownTypeReference = new UnknownTypeReference(_owner, "Foo");
    this.assertInXtendAndJava(_unknownTypeReference, "Foo");
  }
  
  @Test
  public void testUnknownTypeReference1() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    UnknownTypeReference _unknownTypeReference = new UnknownTypeReference(_owner);
    this.assertInXtendAndJava(_unknownTypeReference, "Object");
  }
  
  protected StandardTypeReferenceOwner getOwner() {
    return new StandardTypeReferenceOwner(this.services, this.resourceSet);
  }
  
  protected ParameterizedTypeReference typeRef(final Class<?> type) {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(type);
    return new ParameterizedTypeReference(_owner, _type);
  }
  
  protected JvmType type(final Class<?> type) {
    TypeReferences _typeReferences = this.services.getTypeReferences();
    return _typeReferences.findDeclaredType(type, this.resourceSet);
  }
  
  protected LightweightTypeReference assertInXtendAndJava(final LightweightTypeReference ref, final String expectation) {
    LightweightTypeReference _xblockexpression = null;
    {
      this.assertInXtend(ref, expectation);
      _xblockexpression = this.assertInJava(ref, expectation);
    }
    return _xblockexpression;
  }
  
  protected LightweightTypeReference assertInXtend(final LightweightTypeReference ref, final String expectation) {
    return this.assertIn(ref, expectation, false);
  }
  
  protected LightweightTypeReference assertInJava(final LightweightTypeReference ref, final String expectation) {
    return this.assertIn(ref, expectation, true);
  }
  
  protected LightweightTypeReference assertIn(final LightweightTypeReference ref, final String expectation, final boolean isJava) {
    LightweightTypeReference _xblockexpression = null;
    {
      final TestAppender appender = new TestAppender(isJava);
      final LightweightTypeReferenceSerializer serializer = new LightweightTypeReferenceSerializer(appender);
      ref.accept(serializer);
      String _string = appender.toString();
      Assert.assertEquals(expectation, _string);
      _xblockexpression = ref;
    }
    return _xblockexpression;
  }
}
