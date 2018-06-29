package org.eclipse.xtext.java.resource;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader;
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
import org.eclipse.xtext.java.resource.ClassFileCache;
import org.eclipse.xtext.java.resource.InMemoryClassLoader;
import org.eclipse.xtext.java.resource.IndexAwareNameEnvironment;
import org.eclipse.xtext.java.resource.JavaConfig;
import org.eclipse.xtext.java.resource.JavaResource;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Log
@SuppressWarnings("all")
public class JavaDerivedStateComputer {
  @Inject
  private IReferableElementsUnloader unloader;
  
  @Inject
  private EObjectDescriptionBasedStubGenerator stubGenerator;
  
  @Inject
  private IResourceDescriptionsProvider resourceDescriptionsProvider;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  public void discardDerivedState(final Resource resource) {
    EList<EObject> resourcesContentsList = resource.getContents();
    for (final EObject eObject : resourcesContentsList) {
      this.unloader.unloadRoot(eObject);
    }
    resource.getContents().clear();
  }
  
  public void installStubs(final Resource resource) {
    boolean _isInfoFile = this.isInfoFile(resource);
    if (_isInfoFile) {
      return;
    }
    final CompilationUnit compilationUnit = this.getCompilationUnit(resource);
    IErrorHandlingPolicy _proceedWithAllProblems = DefaultErrorHandlingPolicies.proceedWithAllProblems();
    CompilerOptions _compilerOptions = this.getCompilerOptions(resource);
    DefaultProblemFactory _defaultProblemFactory = new DefaultProblemFactory();
    ProblemReporter _problemReporter = new ProblemReporter(_proceedWithAllProblems, _compilerOptions, _defaultProblemFactory);
    final Parser parser = new Parser(_problemReporter, true);
    final CompilationResult compilationResult = new CompilationResult(compilationUnit, 0, 1, (-1));
    final CompilationUnitDeclaration result = parser.dietParse(compilationUnit, compilationResult);
    if ((result.types != null)) {
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
          resource.getContents().add(jvmType);
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
    jvmType.setSimpleName(String.valueOf(type.name));
    if ((jvmType instanceof JvmGenericType)) {
      if ((type.typeParameters != null)) {
        for (final TypeParameter typeParam : type.typeParameters) {
          {
            final JvmTypeParameter jvmTypeParam = TypesFactory.eINSTANCE.createJvmTypeParameter();
            jvmTypeParam.setName(String.valueOf(typeParam.name));
            EList<JvmTypeParameter> _typeParameters = ((JvmGenericType)jvmType).getTypeParameters();
            _typeParameters.add(jvmTypeParam);
          }
        }
      }
    }
    if ((type.memberTypes != null)) {
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
  
  protected ClassFileCache findOrCreateClassFileCache(final ResourceSet rs) {
    ClassFileCache _xblockexpression = null;
    {
      ClassFileCache cache = ClassFileCache.findInEmfObject(rs);
      if ((cache == null)) {
        ClassFileCache _classFileCache = new ClassFileCache();
        cache = _classFileCache;
        cache.attachToEmfObject(rs);
      }
      _xblockexpression = cache;
    }
    return _xblockexpression;
  }
  
  public void installFull(final Resource resource) {
    boolean _isInfoFile = this.isInfoFile(resource);
    if (_isInfoFile) {
      return;
    }
    final ClassFileCache classFileCache = this.findOrCreateClassFileCache(resource.getResourceSet());
    final CompilationUnit compilationUnit = this.getCompilationUnit(resource);
    final ClassLoader classLoader = this.getClassLoader(resource);
    final IResourceDescriptions data = this.resourceDescriptionsProvider.getResourceDescriptions(resource.getResourceSet());
    if ((data == null)) {
      throw new IllegalStateException("no index installed");
    }
    final IndexAwareNameEnvironment nameEnv = new IndexAwareNameEnvironment(resource, classLoader, data, this.stubGenerator, classFileCache);
    IErrorHandlingPolicy _proceedWithAllProblems = DefaultErrorHandlingPolicies.proceedWithAllProblems();
    CompilerOptions _compilerOptions = this.getCompilerOptions(resource);
    final ICompilerRequestor _function = (CompilationResult it) -> {
      try {
        ClassFile[] _classFiles = it.getClassFiles();
        for (final ClassFile cls : _classFiles) {
          {
            char[] _fileName = cls.fileName();
            final QualifiedName key = this.qualifiedNameConverter.toQualifiedName(new String(_fileName).replace("/", "."));
            boolean _containsKey = classFileCache.containsKey(key);
            boolean _not = (!_containsKey);
            if (_not) {
              byte[] _bytes = cls.getBytes();
              char[] _fileName_1 = cls.fileName();
              ClassFileReader _classFileReader = new ClassFileReader(_bytes, _fileName_1);
              classFileCache.put(key, _classFileReader);
            }
          }
        }
        boolean _equals = Arrays.equals(it.fileName, compilationUnit.fileName);
        if (_equals) {
          final HashMap<String, byte[]> map = CollectionLiterals.<String, byte[]>newHashMap();
          List<String> topLevelTypes = CollectionLiterals.<String>newArrayList();
          ClassFile[] _classFiles_1 = it.getClassFiles();
          for (final ClassFile cf : _classFiles_1) {
            {
              final Function1<char[], String> _function_1 = (char[] it_1) -> {
                return String.valueOf(it_1);
              };
              final String className = IterableExtensions.join(ListExtensions.<char[], String>map(((List<char[]>)Conversions.doWrapArray(cf.getCompoundName())), _function_1), ".");
              map.put(className, cf.getBytes());
              if ((!cf.isNestedType)) {
                topLevelTypes.add(className);
              }
            }
          }
          final InMemoryClassLoader inMemClassLoader = new InMemoryClassLoader(map, classLoader);
          for (final String topLevel : topLevelTypes) {
            try {
              BinaryClass _binaryClass = new BinaryClass(topLevel, inMemClassLoader);
              ClassFileBytesAccess _classFileBytesAccess = new ClassFileBytesAccess();
              final JvmDeclaredTypeBuilder builder = new JvmDeclaredTypeBuilder(_binaryClass, _classFileBytesAccess, inMemClassLoader);
              final JvmDeclaredType type = builder.buildType();
              EList<EObject> _contents = resource.getContents();
              _contents.add(type);
            } catch (final Throwable _t) {
              if (_t instanceof Throwable) {
                final Throwable t = (Throwable)_t;
                throw new IllegalStateException((("could not load type \'" + topLevel) + "\'"), t);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    DefaultProblemFactory _defaultProblemFactory = new DefaultProblemFactory();
    final org.eclipse.jdt.internal.compiler.Compiler compiler = new org.eclipse.jdt.internal.compiler.Compiler(nameEnv, _proceedWithAllProblems, _compilerOptions, _function, _defaultProblemFactory);
    compiler.compile(new ICompilationUnit[] { compilationUnit });
  }
  
  protected boolean isInfoFile(final Resource resource) {
    boolean _xblockexpression = false;
    {
      final String name = resource.getURI().trimFileExtension().lastSegment();
      _xblockexpression = (Objects.equal(name, "package-info") || Objects.equal(name, "module-info"));
    }
    return _xblockexpression;
  }
  
  protected CompilerOptions getCompilerOptions() {
    return this.getCompilerOptions(((JavaConfig) null));
  }
  
  protected CompilerOptions getCompilerOptions(final Resource resource) {
    ResourceSet _resourceSet = null;
    if (resource!=null) {
      _resourceSet=resource.getResourceSet();
    }
    return this.getCompilerOptions(_resourceSet);
  }
  
  protected CompilerOptions getCompilerOptions(final ResourceSet resourceSet) {
    JavaConfig _findInEmfObject = null;
    if (JavaConfig.class!=null) {
      _findInEmfObject=JavaConfig.findInEmfObject(resourceSet);
    }
    return this.getCompilerOptions(_findInEmfObject);
  }
  
  protected CompilerOptions getCompilerOptions(final JavaConfig javaConfig) {
    try {
      JavaVersion _elvis = null;
      JavaVersion _javaSourceLevel = null;
      if (javaConfig!=null) {
        _javaSourceLevel=javaConfig.getJavaSourceLevel();
      }
      if (_javaSourceLevel != null) {
        _elvis = _javaSourceLevel;
      } else {
        _elvis = JavaVersion.JAVA8;
      }
      final JavaVersion sourceVersion = _elvis;
      JavaVersion _elvis_1 = null;
      JavaVersion _javaTargetLevel = null;
      if (javaConfig!=null) {
        _javaTargetLevel=javaConfig.getJavaTargetLevel();
      }
      if (_javaTargetLevel != null) {
        _elvis_1 = _javaTargetLevel;
      } else {
        _elvis_1 = JavaVersion.JAVA8;
      }
      final JavaVersion targetVersion = _elvis_1;
      boolean _equals = Objects.equal(sourceVersion, JavaVersion.JAVA7);
      if (_equals) {
        JavaDerivedStateComputer.LOG.warn("The java source language has been configured with Java 7. JDT will not produce signature information for generic @Override methods in this version, which might lead to follow up issues.");
      }
      final long sourceLevel = this.toJdtVersion(sourceVersion);
      final long targetLevel = this.toJdtVersion(targetVersion);
      final CompilerOptions compilerOptions = new CompilerOptions();
      compilerOptions.targetJDK = targetLevel;
      compilerOptions.inlineJsrBytecode = true;
      compilerOptions.sourceLevel = sourceLevel;
      compilerOptions.produceMethodParameters = true;
      compilerOptions.produceReferenceInfo = true;
      try {
        CompilerOptions.class.getField("originalSourceLevel").setLong(compilerOptions, targetLevel);
      } catch (final Throwable _t) {
        if (_t instanceof NoSuchFieldException) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      compilerOptions.complianceLevel = sourceLevel;
      try {
        CompilerOptions.class.getField("originalComplianceLevel").setLong(compilerOptions, targetLevel);
      } catch (final Throwable _t_1) {
        if (_t_1 instanceof NoSuchFieldException) {
        } else {
          throw Exceptions.sneakyThrow(_t_1);
        }
      }
      return compilerOptions;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected long toJdtVersion(final JavaVersion version) {
    return version.toJdtClassFileConstant();
  }
  
  protected ClassLoader getClassLoader(final Resource it) {
    ResourceSet _resourceSet = it.getResourceSet();
    Object _classpathURIContext = ((XtextResourceSet) _resourceSet).getClasspathURIContext();
    return ((ClassLoader) _classpathURIContext);
  }
  
  private final static Logger LOG = Logger.getLogger(JavaDerivedStateComputer.class);
}
