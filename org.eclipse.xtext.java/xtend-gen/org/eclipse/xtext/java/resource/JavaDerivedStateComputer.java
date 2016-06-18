package org.eclipse.xtext.java.resource;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.DefaultErrorHandlingPolicies;
import org.eclipse.jdt.internal.compiler.ICompilerRequestor;
import org.eclipse.jdt.internal.compiler.IErrorHandlingPolicy;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.problem.DefaultProblemFactory;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.eclipse.xtext.common.types.access.binary.asm.ClassFileBytesAccess;
import org.eclipse.xtext.common.types.access.binary.asm.JvmDeclaredTypeBuilder;
import org.eclipse.xtext.common.types.descriptions.EObjectDescriptionBasedStubGenerator;
import org.eclipse.xtext.java.resource.InMemoryClassLoader;
import org.eclipse.xtext.java.resource.IndexAwareNameEnvironment;
import org.eclipse.xtext.java.resource.JavaResource;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class JavaDerivedStateComputer {
  @Inject
  private IReferableElementsUnloader unloader;
  
  @Inject
  private EObjectDescriptionBasedStubGenerator stubGenerator;
  
  @Inject
  private IResourceDescriptionsProvider resourceDescriptionsProvider;
  
  public void discardDerivedState(final Resource resource) {
    EList<EObject> resourcesContentsList = resource.getContents();
    for (int i = 1; (i < resourcesContentsList.size()); i++) {
      {
        EObject eObject = resourcesContentsList.get(i);
        this.unloader.unloadRoot(eObject);
      }
    }
    EList<EObject> _contents = resource.getContents();
    _contents.clear();
  }
  
  public void installStubs(final Resource resource) {
    boolean _isInfoFile = this.isInfoFile(resource);
    if (_isInfoFile) {
      return;
    }
    final CompilationUnit compilationUnit = this.getCompilationUnit(resource);
    IErrorHandlingPolicy _proceedWithAllProblems = DefaultErrorHandlingPolicies.proceedWithAllProblems();
    CompilerOptions _compilerOptions = this.getCompilerOptions();
    DefaultProblemFactory _defaultProblemFactory = new DefaultProblemFactory();
    ProblemReporter _problemReporter = new ProblemReporter(_proceedWithAllProblems, _compilerOptions, _defaultProblemFactory);
    final Parser parser = new Parser(_problemReporter, true);
    final CompilationResult compilationResult = new CompilationResult(compilationUnit, 0, 1, (-1));
    final CompilationUnitDeclaration result = parser.dietParse(compilationUnit, compilationResult);
    boolean _notEquals = (!Objects.equal(result.types, null));
    if (_notEquals) {
      for (final TypeDeclaration type : result.types) {
        {
          ImportReference _currentPackage = result.currentPackage;
          char[][] _importName = null;
          if (_currentPackage!=null) {
            _importName=_currentPackage.getImportName();
          }
          List<String> _map = null;
          if (((List<char[]>)Conversions.doWrapArray(_importName))!=null) {
            final Function1<char[], String> _function = (char[] it) -> {
              return String.valueOf(it);
            };
            _map=ListExtensions.<char[], String>map(((List<char[]>)Conversions.doWrapArray(_importName)), _function);
          }
          String _join = null;
          if (_map!=null) {
            _join=IterableExtensions.join(_map, ".");
          }
          final String packageName = _join;
          final JvmDeclaredType jvmType = this.createType(type, packageName);
          EList<EObject> _contents = resource.getContents();
          _contents.add(jvmType);
        }
      }
    }
  }
  
  public JvmDeclaredType createType(final TypeDeclaration type, final String packageName) {
    JvmDeclaredType _switchResult = null;
    int _kind = TypeDeclaration.kind(type.modifiers);
    switch (_kind) {
      case TypeDeclaration.CLASS_DECL:
        _switchResult = TypesFactory.eINSTANCE.createJvmGenericType();
        break;
      case TypeDeclaration.INTERFACE_DECL:
        JvmGenericType _createJvmGenericType = TypesFactory.eINSTANCE.createJvmGenericType();
        final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
          it.setInterface(true);
        };
        _switchResult = ObjectExtensions.<JvmGenericType>operator_doubleArrow(_createJvmGenericType, _function);
        break;
      case TypeDeclaration.ENUM_DECL:
        _switchResult = TypesFactory.eINSTANCE.createJvmEnumerationType();
        break;
      case TypeDeclaration.ANNOTATION_TYPE_DECL:
        _switchResult = TypesFactory.eINSTANCE.createJvmAnnotationType();
        break;
      default:
        String _string = type.toString();
        String _plus = ("Cannot handle type " + _string);
        throw new IllegalArgumentException(_plus);
    }
    final JvmDeclaredType jvmType = _switchResult;
    jvmType.setPackageName(packageName);
    String _valueOf = String.valueOf(type.name);
    jvmType.setSimpleName(_valueOf);
    if ((jvmType instanceof JvmGenericType)) {
      boolean _notEquals = (!Objects.equal(type.typeParameters, null));
      if (_notEquals) {
        for (final TypeParameter typeParam : type.typeParameters) {
          {
            final JvmTypeParameter jvmTypeParam = TypesFactory.eINSTANCE.createJvmTypeParameter();
            String _valueOf_1 = String.valueOf(typeParam.name);
            jvmTypeParam.setName(_valueOf_1);
            EList<JvmTypeParameter> _typeParameters = ((JvmGenericType)jvmType).getTypeParameters();
            _typeParameters.add(jvmTypeParam);
          }
        }
      }
    }
    boolean _notEquals_1 = (!Objects.equal(type.memberTypes, null));
    if (_notEquals_1) {
      for (final TypeDeclaration nestedType : type.memberTypes) {
        {
          final JvmDeclaredType nested = this.createType(nestedType, null);
          EList<JvmMember> _members = jvmType.getMembers();
          _members.add(nested);
        }
      }
    }
    return jvmType;
  }
  
  public CompilationUnit getCompilationUnit(final Resource resource) {
    return ((JavaResource) resource).getCompilationUnit();
  }
  
  public void installFull(final Resource resource) {
    boolean _isInfoFile = this.isInfoFile(resource);
    if (_isInfoFile) {
      return;
    }
    final CompilationUnit compilationUnit = this.getCompilationUnit(resource);
    final ClassLoader classLoader = this.getClassLoader(resource);
    ResourceSet _resourceSet = resource.getResourceSet();
    final IResourceDescriptions data = this.resourceDescriptionsProvider.getResourceDescriptions(_resourceSet);
    boolean _equals = Objects.equal(data, null);
    if (_equals) {
      throw new IllegalStateException("no index installed");
    }
    final IndexAwareNameEnvironment nameEnv = new IndexAwareNameEnvironment(classLoader, data, this.stubGenerator);
    IErrorHandlingPolicy _proceedWithAllProblems = DefaultErrorHandlingPolicies.proceedWithAllProblems();
    CompilerOptions _compilerOptions = this.getCompilerOptions();
    final ICompilerRequestor _function = (CompilationResult it) -> {
      boolean _equals_1 = Arrays.equals(it.fileName, compilationUnit.fileName);
      if (_equals_1) {
        final HashMap<String, byte[]> map = CollectionLiterals.<String, byte[]>newHashMap();
        List<String> topLevelTypes = CollectionLiterals.<String>newArrayList();
        ClassFile[] _classFiles = it.getClassFiles();
        for (final ClassFile cf : _classFiles) {
          {
            char[][] _compoundName = cf.getCompoundName();
            final Function1<char[], String> _function_1 = (char[] it_1) -> {
              return String.valueOf(it_1);
            };
            List<String> _map = ListExtensions.<char[], String>map(((List<char[]>)Conversions.doWrapArray(_compoundName)), _function_1);
            final String className = IterableExtensions.join(_map, ".");
            byte[] _bytes = cf.getBytes();
            map.put(className, _bytes);
            if ((!cf.isNestedType)) {
              topLevelTypes.add(className);
            }
          }
        }
        final InMemoryClassLoader inMemClassLoader = new InMemoryClassLoader(map, classLoader);
        for (final String topLevel : topLevelTypes) {
          {
            BinaryClass _binaryClass = new BinaryClass(topLevel, inMemClassLoader);
            ClassFileBytesAccess _classFileBytesAccess = new ClassFileBytesAccess();
            final JvmDeclaredTypeBuilder builder = new JvmDeclaredTypeBuilder(_binaryClass, _classFileBytesAccess, inMemClassLoader);
            EList<EObject> _contents = resource.getContents();
            JvmDeclaredType _buildType = builder.buildType();
            _contents.add(_buildType);
          }
        }
      }
    };
    DefaultProblemFactory _defaultProblemFactory = new DefaultProblemFactory();
    final org.eclipse.jdt.internal.compiler.Compiler compiler = new org.eclipse.jdt.internal.compiler.Compiler(nameEnv, _proceedWithAllProblems, _compilerOptions, _function, _defaultProblemFactory);
    compiler.compile(new ICompilationUnit[] { compilationUnit });
  }
  
  protected boolean isInfoFile(final Resource resource) {
    boolean _xblockexpression = false;
    {
      URI _uRI = resource.getURI();
      URI _trimFileExtension = _uRI.trimFileExtension();
      final String name = _trimFileExtension.lastSegment();
      _xblockexpression = (Objects.equal(name, "package-info") || Objects.equal(name, "module-info"));
    }
    return _xblockexpression;
  }
  
  protected CompilerOptions getCompilerOptions() {
    final long jdkVersion = ClassFileConstants.JDK1_7;
    CompilerOptions _compilerOptions = new CompilerOptions();
    final Procedure1<CompilerOptions> _function = (CompilerOptions compilerOptions) -> {
      try {
        compilerOptions.targetJDK = jdkVersion;
        compilerOptions.inlineJsrBytecode = true;
        compilerOptions.sourceLevel = jdkVersion;
        try {
          Field _field = CompilerOptions.class.getField("originalSourceLevel");
          _field.setLong(compilerOptions, jdkVersion);
        } catch (final Throwable _t) {
          if (_t instanceof NoSuchFieldException) {
            final NoSuchFieldException e = (NoSuchFieldException)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        compilerOptions.complianceLevel = jdkVersion;
        try {
          Field _field_1 = CompilerOptions.class.getField("originalComplianceLevel");
          _field_1.setLong(compilerOptions, jdkVersion);
        } catch (final Throwable _t_1) {
          if (_t_1 instanceof NoSuchFieldException) {
            final NoSuchFieldException e_1 = (NoSuchFieldException)_t_1;
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    return ObjectExtensions.<CompilerOptions>operator_doubleArrow(_compilerOptions, _function);
  }
  
  protected ClassLoader getClassLoader(final Resource it) {
    ResourceSet _resourceSet = it.getResourceSet();
    Object _classpathURIContext = ((XtextResourceSet) _resourceSet).getClasspathURIContext();
    return ((ClassLoader) _classpathURIContext);
  }
}
