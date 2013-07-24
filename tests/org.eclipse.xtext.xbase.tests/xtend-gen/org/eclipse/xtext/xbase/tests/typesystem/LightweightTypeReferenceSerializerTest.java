package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.io.Serializable;
import java.util.List;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
  
  @Inject
  @Extension
  private TypesFactory _typesFactory;
  
  @Test
  public void testObject() {
    ParameterizedTypeReference _typeRef = this.typeRef(Object.class);
    this.assertSerializedAs(_typeRef, "java.lang.Object");
  }
  
  @Test
  public void testList() {
    ParameterizedTypeReference _typeRef = this.typeRef(List.class);
    this.assertSerializedAs(_typeRef, "java.util.List");
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
    this.assertSerializedAs(_doubleArrow, "java.util.List<?>");
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
    this.assertSerializedAs(_doubleArrow, "java.util.List<? extends java.lang.CharSequence>");
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
    this.assertSerializedAs(_doubleArrow, "java.util.List<?>");
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
    this.assertSerializedAs(_doubleArrow, "java.util.List<? extends java.lang.CharSequence & java.io.Serializable>");
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
    this.assertSerializedAs(_doubleArrow, "java.util.List<? extends java.lang.CharSequence & java.io.Serializable>");
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
    this.assertSerializedAs(_doubleArrow, "java.util.List<? super java.lang.CharSequence>");
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
    this.assertSerializedAs(_doubleArrow, "java.util.List<? super java.lang.CharSequence>");
  }
  
  @Test
  public void testArray() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    ParameterizedTypeReference _typeRef = this.typeRef(Object.class);
    ArrayTypeReference _arrayTypeReference = new ArrayTypeReference(_owner, _typeRef);
    this.assertSerializedAs(_arrayTypeReference, "java.lang.Object[]");
  }
  
  @Test
  public void testArray2() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    StandardTypeReferenceOwner _owner_1 = this.getOwner();
    ParameterizedTypeReference _typeRef = this.typeRef(Object.class);
    ArrayTypeReference _arrayTypeReference = new ArrayTypeReference(_owner_1, _typeRef);
    ArrayTypeReference _arrayTypeReference_1 = new ArrayTypeReference(_owner, _arrayTypeReference);
    this.assertSerializedAs(_arrayTypeReference_1, "java.lang.Object[][]");
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
    this.assertSerializedAs(_arrayTypeReference, "java.util.List<? super java.lang.CharSequence>[]");
  }
  
  @Test
  public void testAnyType() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    AnyTypeReference _anyTypeReference = new AnyTypeReference(_owner);
    this.assertSerializedAs(_anyTypeReference, "java.lang.Object");
  }
  
  @Test
  public void testFunctionType() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Function0.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    this.assertSerializedAs(_functionTypeReference, "()=>void");
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
        }
      };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    this.assertSerializedAs(_doubleArrow, "()=>java.lang.String");
  }
  
  @Test
  public void testFunctionType2() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Function0.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
        public void apply(final FunctionTypeReference it) {
          ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
          it.addParameterType(_typeRef);
        }
      };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    this.assertSerializedAs(_doubleArrow, "(java.lang.String)=>void");
  }
  
  @Test
  public void testFunctionType3() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Function0.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
        public void apply(final FunctionTypeReference it) {
          ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
          it.addParameterType(_typeRef);
          ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(Object.class);
          it.setReturnType(_typeRef_1);
        }
      };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    this.assertSerializedAs(_doubleArrow, "(java.lang.String)=>java.lang.Object");
  }
  
  @Test
  public void testFunctionType4() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Function0.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
        public void apply(final FunctionTypeReference it) {
          ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
          it.addParameterType(_typeRef);
          ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(List.class);
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
          ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef_1, _function);
          it.addParameterType(_doubleArrow);
          ITypeReferenceOwner _owner = it.getOwner();
          ParameterizedTypeReference _typeRef_2 = LightweightTypeReferenceSerializerTest.this.typeRef(Object.class);
          ArrayTypeReference _arrayTypeReference = new ArrayTypeReference(_owner, _typeRef_2);
          it.addParameterType(_arrayTypeReference);
          ParameterizedTypeReference _typeRef_3 = LightweightTypeReferenceSerializerTest.this.typeRef(Object.class);
          it.setReturnType(_typeRef_3);
        }
      };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    this.assertSerializedAs(_doubleArrow, "(java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[])=>java.lang.Object");
  }
  
  @Test
  public void testFunctionType5() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Procedure0.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    this.assertSerializedAs(_functionTypeReference, "()=>void");
  }
  
  @Test
  public void testFunctionType6() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Function0.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
        public void apply(final FunctionTypeReference it) {
          ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
          it.addParameterType(_typeRef);
        }
      };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    this.assertSerializedAs(_doubleArrow, "(java.lang.String)=>void");
  }
  
  @Test
  public void testFunctionType7() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(Function0.class);
    FunctionTypeReference _functionTypeReference = new FunctionTypeReference(_owner, _type);
    final Procedure1<FunctionTypeReference> _function = new Procedure1<FunctionTypeReference>() {
        public void apply(final FunctionTypeReference it) {
          ParameterizedTypeReference _typeRef = LightweightTypeReferenceSerializerTest.this.typeRef(String.class);
          it.addParameterType(_typeRef);
          ParameterizedTypeReference _typeRef_1 = LightweightTypeReferenceSerializerTest.this.typeRef(List.class);
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
          ParameterizedTypeReference _doubleArrow = ObjectExtensions.<ParameterizedTypeReference>operator_doubleArrow(_typeRef_1, _function);
          it.addParameterType(_doubleArrow);
          ITypeReferenceOwner _owner = it.getOwner();
          ParameterizedTypeReference _typeRef_2 = LightweightTypeReferenceSerializerTest.this.typeRef(Object.class);
          ArrayTypeReference _arrayTypeReference = new ArrayTypeReference(_owner, _typeRef_2);
          it.addParameterType(_arrayTypeReference);
        }
      };
    FunctionTypeReference _doubleArrow = ObjectExtensions.<FunctionTypeReference>operator_doubleArrow(_functionTypeReference, _function);
    this.assertSerializedAs(_doubleArrow, "(java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[])=>void");
  }
  
  @Test
  @Ignore
  public void testUnboundTypeReference() {
  }
  
  @Test
  public void testUnknownTypeReference() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    UnknownTypeReference _unknownTypeReference = new UnknownTypeReference(_owner, "Foo");
    this.assertSerializedAs(_unknownTypeReference, "Foo");
  }
  
  @Test
  public void testUnknownTypeReference1() {
    StandardTypeReferenceOwner _owner = this.getOwner();
    UnknownTypeReference _unknownTypeReference = new UnknownTypeReference(_owner);
    this.assertSerializedAs(_unknownTypeReference, "Object");
  }
  
  protected StandardTypeReferenceOwner getOwner() {
    StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, this.resourceSet);
    return _standardTypeReferenceOwner;
  }
  
  protected ParameterizedTypeReference typeRef(final Class<? extends Object> type) {
    StandardTypeReferenceOwner _owner = this.getOwner();
    JvmType _type = this.type(type);
    ParameterizedTypeReference _parameterizedTypeReference = new ParameterizedTypeReference(_owner, _type);
    return _parameterizedTypeReference;
  }
  
  protected JvmType type(final Class<? extends Object> type) {
    TypeReferences _typeReferences = this.services.getTypeReferences();
    JvmType _findDeclaredType = _typeReferences.findDeclaredType(type, this.resourceSet);
    return _findDeclaredType;
  }
  
  protected void assertSerializedAs(final LightweightTypeReference ref, final String expectation) {
    JvmGenericType _createJvmGenericType = this._typesFactory.createJvmGenericType();
    TestAppender _testAppender = new TestAppender(0, "\t", "\n", false, _createJvmGenericType);
    final TestAppender appender = _testAppender;
    LightweightTypeReferenceSerializer _lightweightTypeReferenceSerializer = new LightweightTypeReferenceSerializer(appender);
    final LightweightTypeReferenceSerializer serializer = _lightweightTypeReferenceSerializer;
    ref.accept(serializer);
    String _string = appender.toString();
    Assert.assertEquals(expectation, _string);
  }
}
