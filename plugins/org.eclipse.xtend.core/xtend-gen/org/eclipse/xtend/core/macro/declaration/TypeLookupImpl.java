package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendTypeDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.services.SourceTypeLookup;
import org.eclipse.xtend.lib.macro.services.TypeLookup;
import org.eclipse.xtend.lib.macro.services.UpstreamTypeLookup;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public class TypeLookupImpl implements TypeLookup, SourceTypeLookup, UpstreamTypeLookup {
  @Extension
  private CompilationUnitImpl compilationUnit;
  
  public TypeLookupImpl(final CompilationUnitImpl compilationUnit) {
    this.compilationUnit = compilationUnit;
  }
  
  @Override
  public MutableAnnotationTypeDeclaration findAnnotationType(final String qualifiedName) {
    final Type type = this.findType(qualifiedName);
    MutableAnnotationTypeDeclaration _switchResult = null;
    boolean _matched = false;
    if (type instanceof MutableAnnotationTypeDeclaration) {
      _matched=true;
      _switchResult = ((MutableAnnotationTypeDeclaration)type);
    }
    return _switchResult;
  }
  
  @Override
  public MutableClassDeclaration findClass(final String qualifiedName) {
    final Type type = this.findType(qualifiedName);
    MutableClassDeclaration _switchResult = null;
    boolean _matched = false;
    if (type instanceof MutableClassDeclaration) {
      _matched=true;
      _switchResult = ((MutableClassDeclaration)type);
    }
    return _switchResult;
  }
  
  @Override
  public MutableEnumerationTypeDeclaration findEnumerationType(final String qualifiedName) {
    final Type type = this.findType(qualifiedName);
    MutableEnumerationTypeDeclaration _switchResult = null;
    boolean _matched = false;
    if (type instanceof MutableEnumerationTypeDeclaration) {
      _matched=true;
      _switchResult = ((MutableEnumerationTypeDeclaration)type);
    }
    return _switchResult;
  }
  
  @Override
  public MutableInterfaceDeclaration findInterface(final String qualifiedName) {
    final Type type = this.findType(qualifiedName);
    MutableInterfaceDeclaration _switchResult = null;
    boolean _matched = false;
    if (type instanceof MutableInterfaceDeclaration) {
      _matched=true;
      _switchResult = ((MutableInterfaceDeclaration)type);
    }
    return _switchResult;
  }
  
  private Type findType(final String qualifiedName) {
    XtendFile _xtendFile = this.compilationUnit.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    EList<EObject> _contents = _eResource.getContents();
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
    final Function1<JvmDeclaredType, String> _function = new Function1<JvmDeclaredType, String>() {
      @Override
      public String apply(final JvmDeclaredType type) {
        return type.getQualifiedName('.');
      }
    };
    final Function1<JvmDeclaredType, Iterable<? extends JvmDeclaredType>> _function_1 = new Function1<JvmDeclaredType, Iterable<? extends JvmDeclaredType>>() {
      @Override
      public Iterable<? extends JvmDeclaredType> apply(final JvmDeclaredType type) {
        EList<JvmMember> _members = type.getMembers();
        return Iterables.<JvmDeclaredType>filter(_members, JvmDeclaredType.class);
      }
    };
    final JvmDeclaredType result = this.<JvmDeclaredType>recursiveFindType(qualifiedName, _filter, _function, _function_1);
    Type _xifexpression = null;
    boolean _notEquals = (!Objects.equal(result, null));
    if (_notEquals) {
      _xifexpression = this.compilationUnit.toType(result);
    }
    return _xifexpression;
  }
  
  @Override
  public ClassDeclaration findSourceClass(final String qualifiedName) {
    final XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> type = this.findSourceType(qualifiedName);
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
    boolean _matched = false;
    if (type instanceof ClassDeclaration) {
      _matched=true;
      _switchResult = ((XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)type);
    }
    return ((ClassDeclaration)_switchResult);
  }
  
  @Override
  public InterfaceDeclaration findSourceInterface(final String qualifiedName) {
    final XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> type = this.findSourceType(qualifiedName);
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
    boolean _matched = false;
    if (type instanceof InterfaceDeclaration) {
      _matched=true;
      _switchResult = ((XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)type);
    }
    return ((InterfaceDeclaration)_switchResult);
  }
  
  @Override
  public EnumerationTypeDeclaration findSourceEnumerationType(final String qualifiedName) {
    final XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> type = this.findSourceType(qualifiedName);
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
    boolean _matched = false;
    if (type instanceof EnumerationTypeDeclaration) {
      _matched=true;
      _switchResult = ((XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)type);
    }
    return ((EnumerationTypeDeclaration)_switchResult);
  }
  
  @Override
  public AnnotationTypeDeclaration findSourceAnnotationType(final String qualifiedName) {
    final XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> type = this.findSourceType(qualifiedName);
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
    boolean _matched = false;
    if (type instanceof AnnotationTypeDeclaration) {
      _matched=true;
      _switchResult = ((XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)type);
    }
    return ((AnnotationTypeDeclaration)_switchResult);
  }
  
  private XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> findSourceType(final String qualifiedName) {
    XtendFile _xtendFile = this.compilationUnit.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    EList<EObject> _contents = _eResource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    EList<XtendTypeDeclaration> _xtendTypes = ((XtendFile) _head).getXtendTypes();
    final Function1<XtendTypeDeclaration, String> _function = new Function1<XtendTypeDeclaration, String>() {
      @Override
      public String apply(final XtendTypeDeclaration type) {
        IQualifiedNameConverter _qualifiedNameConverter = TypeLookupImpl.this.compilationUnit.getQualifiedNameConverter();
        IQualifiedNameProvider _qualifiedNameProvider = TypeLookupImpl.this.compilationUnit.getQualifiedNameProvider();
        QualifiedName _fullyQualifiedName = _qualifiedNameProvider.getFullyQualifiedName(type);
        return _qualifiedNameConverter.toString(_fullyQualifiedName);
      }
    };
    final Function1<XtendTypeDeclaration, Iterable<? extends XtendTypeDeclaration>> _function_1 = new Function1<XtendTypeDeclaration, Iterable<? extends XtendTypeDeclaration>>() {
      @Override
      public Iterable<? extends XtendTypeDeclaration> apply(final XtendTypeDeclaration type) {
        EList<XtendMember> _members = type.getMembers();
        return Iterables.<XtendTypeDeclaration>filter(_members, XtendTypeDeclaration.class);
      }
    };
    final XtendTypeDeclaration result = this.<XtendTypeDeclaration>recursiveFindType(qualifiedName, _xtendTypes, _function, _function_1);
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(result, null));
    if (_notEquals) {
      _xifexpression = this.compilationUnit.toXtendTypeDeclaration(result);
    }
    return _xifexpression;
  }
  
  private <T extends Object> T recursiveFindType(final String qualifiedName, final Iterable<? extends T> typeDeclarations, final Function1<? super T, ? extends String> qualifiedNameProvider, final Function1<? super T, ? extends Iterable<? extends T>> subTypeProvider) {
    final char dot = '.';
    for (final T type : typeDeclarations) {
      {
        final String name = qualifiedNameProvider.apply(type);
        boolean _equals = Objects.equal(qualifiedName, name);
        if (_equals) {
          return type;
        }
        boolean _and = false;
        boolean _startsWith = qualifiedName.startsWith(name);
        if (!_startsWith) {
          _and = false;
        } else {
          int _length = name.length();
          char _charAt = qualifiedName.charAt(_length);
          boolean _equals_1 = (_charAt == dot);
          _and = _equals_1;
        }
        if (_and) {
          Iterable<? extends T> _apply = subTypeProvider.apply(type);
          return this.<T>recursiveFindType(qualifiedName, _apply, qualifiedNameProvider, subTypeProvider);
        }
      }
    }
    return null;
  }
  
  @Override
  public Type findTypeGlobally(final Class<?> clazz) {
    String _canonicalName = clazz.getCanonicalName();
    return this.findTypeGlobally(_canonicalName);
  }
  
  @Override
  public Type findTypeGlobally(final String typeName) {
    Type _elvis = null;
    Type _findType = this.findType(typeName);
    if (_findType != null) {
      _elvis = _findType;
    } else {
      final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
        @Override
        public Boolean apply(final IEObjectDescription it) {
          return Boolean.valueOf(true);
        }
      };
      Type _findTypeOnScope = this.findTypeOnScope(typeName, _function);
      _elvis = _findTypeOnScope;
    }
    return _elvis;
  }
  
  @Override
  public Type findUpstreamType(final Class<?> clazz) {
    String _canonicalName = clazz.getCanonicalName();
    return this.findUpstreamType(_canonicalName);
  }
  
  @Override
  public Type findUpstreamType(final String typeName) {
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      @Override
      public Boolean apply(final IEObjectDescription it) {
        EObject _eObjectOrProxy = it.getEObjectOrProxy();
        Resource _eResource = _eObjectOrProxy.eResource();
        XtendFile _xtendFile = TypeLookupImpl.this.compilationUnit.getXtendFile();
        Resource _eResource_1 = _xtendFile.eResource();
        return Boolean.valueOf((!Objects.equal(_eResource, _eResource_1)));
      }
    };
    return this.findTypeOnScope(typeName, _function);
  }
  
  private Type findTypeOnScope(final String typeName, final Function1<? super IEObjectDescription, ? extends Boolean> filter) {
    IQualifiedNameConverter _qualifiedNameConverter = this.compilationUnit.getQualifiedNameConverter();
    final QualifiedName qualifiedName = _qualifiedNameConverter.toQualifiedName(typeName);
    IScopeProvider _scopeProvider = this.compilationUnit.getScopeProvider();
    XtendFile _xtendFile = this.compilationUnit.getXtendFile();
    IScope _scope = _scopeProvider.getScope(_xtendFile, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE);
    final IEObjectDescription result = _scope.getSingleElement(qualifiedName);
    boolean _and = false;
    boolean _and_1 = false;
    if (!(result != null)) {
      _and_1 = false;
    } else {
      EClass _eClass = result.getEClass();
      boolean _isSuperTypeOf = TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(_eClass);
      _and_1 = _isSuperTypeOf;
    }
    if (!_and_1) {
      _and = false;
    } else {
      Boolean _apply = filter.apply(result);
      _and = (_apply).booleanValue();
    }
    if (_and) {
      EObject _eObjectOrProxy = result.getEObjectOrProxy();
      return this.compilationUnit.toType(((JvmType) _eObjectOrProxy));
    }
    return null;
  }
}
