/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testing;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.DefaultErrorHandlingPolicies;
import org.eclipse.jdt.internal.compiler.ICompilerRequestor;
import org.eclipse.jdt.internal.compiler.IErrorHandlingPolicy;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.problem.DefaultProblemFactory;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.testing.JavaSource;

/**
 * @since 2.9
 */
@SuppressWarnings("all")
public class InMemoryJavaCompiler {
  @FinalFieldsConstructor
  private static class ClassLoaderBasedNameEnvironment implements INameEnvironment {
    private final ClassLoader classLoader;
    
    private Map<String, NameEnvironmentAnswer> cache = CollectionLiterals.<String, NameEnvironmentAnswer>newHashMap();
    
    @Override
    public void cleanup() {
      this.cache.clear();
    }
    
    @Override
    public NameEnvironmentAnswer findType(final char[][] compoundTypeName) {
      try {
        final Function1<char[], String> _function = (char[] it) -> {
          return String.valueOf(it);
        };
        String _join = IterableExtensions.join(ListExtensions.<char[], String>map(((List<char[]>)Conversions.doWrapArray(compoundTypeName)), _function), "/");
        final String fileName = (_join + ".class");
        boolean _containsKey = this.cache.containsKey(fileName);
        if (_containsKey) {
          return this.cache.get(fileName);
        }
        final URL url = this.classLoader.getResource(fileName);
        if ((url == null)) {
          this.cache.put(fileName, null);
          return null;
        }
        final ClassFileReader reader = ClassFileReader.read(url.openStream(), fileName);
        final NameEnvironmentAnswer result = new NameEnvironmentAnswer(reader, null);
        this.cache.put(fileName, result);
        return result;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    @Override
    public NameEnvironmentAnswer findType(final char[] typeName, final char[][] packageName) {
      try {
        final Function1<char[], String> _function = (char[] it) -> {
          return String.valueOf(it);
        };
        String _join = IterableExtensions.join(ListExtensions.<char[], String>map(((List<char[]>)Conversions.doWrapArray(packageName)), _function), "/");
        String _plus = (_join + "/");
        String _valueOf = String.valueOf(typeName);
        String _plus_1 = (_plus + _valueOf);
        final String fileName = (_plus_1 + ".class");
        boolean _containsKey = this.cache.containsKey(fileName);
        if (_containsKey) {
          return this.cache.get(fileName);
        }
        final URL url = this.classLoader.getResource(fileName);
        if ((url == null)) {
          this.cache.put(fileName, null);
          return null;
        }
        final ClassFileReader reader = ClassFileReader.read(url.openStream(), fileName);
        final NameEnvironmentAnswer result = new NameEnvironmentAnswer(reader, null);
        this.cache.put(fileName, result);
        return result;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    @Override
    public boolean isPackage(final char[][] parentPackageName, final char[] packageName) {
      return Character.isLowerCase((IterableExtensions.<Character>head(((Iterable<Character>)Conversions.doWrapArray(packageName)))).charValue());
    }
    
    public ClassLoaderBasedNameEnvironment(final ClassLoader classLoader) {
      super();
      this.classLoader = classLoader;
    }
  }
  
  static class ByteClassLoader extends ClassLoader {
    private Map<String, byte[]> classMap;
    
    public ByteClassLoader(final Map<String, byte[]> classMap, final ClassLoader parent) {
      super(parent);
      this.classMap = classMap;
    }
    
    @Override
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
      byte[] bytes = this.classMap.get(name);
      if ((bytes == null)) {
        return super.findClass(name);
      } else {
        return this.defineClass(name, bytes, 0, bytes.length);
      }
    }
    
    @Override
    protected URL findResource(final String path) {
      try {
        boolean _endsWith = path.endsWith(".class");
        if (_endsWith) {
          int _length = path.length();
          int _minus = (_length - 6);
          final String className = path.substring(0, _minus).replace("/", ".");
          final byte[] bytes = this.classMap.get(className);
          if ((bytes != null)) {
            final URLStreamHandler _function = new URLStreamHandler() {
              @Override
              protected URLConnection openConnection(final URL it) throws IOException {
                return new URLConnection(it) {
                  @Override
                  public void connect() {
                  }
                  
                  @Override
                  public InputStream getInputStream() {
                    return new ByteArrayInputStream(bytes);
                  }
                };
              }
            };
            return new URL("in-memory", null, (-1), path, _function);
          }
        }
        return null;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }
  
  @FinalFieldsConstructor
  public static class Result {
    @Accessors
    private final Set<CategorizedProblem> compilationProblems = CollectionLiterals.<CategorizedProblem>newLinkedHashSet();
    
    private final HashMap<String, byte[]> classMap = new HashMap<String, byte[]>();
    
    private final ClassLoader parentClassLoader;
    
    public ClassLoader getClassLoader() {
      return new InMemoryJavaCompiler.ByteClassLoader(this.classMap, this.parentClassLoader);
    }
    
    public Result(final ClassLoader parentClassLoader) {
      super();
      this.parentClassLoader = parentClassLoader;
    }
    
    @Pure
    public Set<CategorizedProblem> getCompilationProblems() {
      return this.compilationProblems;
    }
  }
  
  private final INameEnvironment nameEnv;
  
  private final ClassLoader parentClassLoader;
  
  private final CompilerOptions compilerOptions;
  
  public InMemoryJavaCompiler(final ClassLoader parent, final JavaVersion javaVersion) {
    InMemoryJavaCompiler.ClassLoaderBasedNameEnvironment _classLoaderBasedNameEnvironment = new InMemoryJavaCompiler.ClassLoaderBasedNameEnvironment(parent);
    this.nameEnv = _classLoaderBasedNameEnvironment;
    this.parentClassLoader = parent;
    CompilerOptions _compilerOptions = new CompilerOptions();
    this.compilerOptions = _compilerOptions;
    this.setJavaVersion(javaVersion);
    this.compilerOptions.inlineJsrBytecode = true;
    this.compilerOptions.preserveAllLocalVariables = true;
  }
  
  public InMemoryJavaCompiler(final ClassLoader parent, final CompilerOptions compilerOptions) {
    InMemoryJavaCompiler.ClassLoaderBasedNameEnvironment _classLoaderBasedNameEnvironment = new InMemoryJavaCompiler.ClassLoaderBasedNameEnvironment(parent);
    this.nameEnv = _classLoaderBasedNameEnvironment;
    this.parentClassLoader = parent;
    Map<String, String> _map = compilerOptions.getMap();
    CompilerOptions _compilerOptions = new CompilerOptions(_map);
    this.compilerOptions = _compilerOptions;
  }
  
  /**
   * @since 2.11
   */
  public long setJavaVersion(final JavaVersion javaVersion) {
    long _xblockexpression = (long) 0;
    {
      final long classFmt = this.toClassFmt(javaVersion);
      this.setSourceLevel(classFmt);
      this.setComplianceLevel(classFmt);
      _xblockexpression = this.compilerOptions.targetJDK = classFmt;
    }
    return _xblockexpression;
  }
  
  private long toClassFmt(final JavaVersion version) {
    return version.toJdtClassFileConstant();
  }
  
  /**
   * sets the source level (see @link(org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants))
   */
  private void setSourceLevel(final long jdkVersion) {
    try {
      this.compilerOptions.sourceLevel = jdkVersion;
      try {
        CompilerOptions.class.getField("originalSourceLevel").setLong(this.compilerOptions, jdkVersion);
      } catch (final Throwable _t) {
        if (_t instanceof NoSuchFieldException) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * sets the compliance level (see @link(org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants))
   */
  private void setComplianceLevel(final long jdkVersion) {
    try {
      this.compilerOptions.complianceLevel = jdkVersion;
      try {
        CompilerOptions.class.getField("originalComplianceLevel").setLong(this.compilerOptions, jdkVersion);
      } catch (final Throwable _t) {
        if (_t instanceof NoSuchFieldException) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public InMemoryJavaCompiler.Result compile(final JavaSource... sources) {
    final InMemoryJavaCompiler.Result result = new InMemoryJavaCompiler.Result(this.parentClassLoader);
    IErrorHandlingPolicy _proceedWithAllProblems = DefaultErrorHandlingPolicies.proceedWithAllProblems();
    final ICompilerRequestor _function = (CompilationResult it) -> {
      ClassFile[] _classFiles = it.getClassFiles();
      for (final ClassFile cf : _classFiles) {
        final Function1<char[], String> _function_1 = (char[] it_1) -> {
          return String.valueOf(it_1);
        };
        result.classMap.put(IterableExtensions.join(ListExtensions.<char[], String>map(((List<char[]>)Conversions.doWrapArray(cf.getCompoundName())), _function_1), "."), cf.getBytes());
      }
    };
    org.eclipse.jdt.internal.compiler.Compiler compiler = new org.eclipse.jdt.internal.compiler.Compiler(this.nameEnv, _proceedWithAllProblems, 
      this.compilerOptions, _function, new DefaultProblemFactory() {
      @Override
      public CategorizedProblem createProblem(final char[] originatingFileName, final int problemId, final String[] problemArguments, final int elaborationId, final String[] messageArguments, final int severity, final int startPosition, final int endPosition, final int lineNumber, final int columnNumber) {
        final CategorizedProblem problem = super.createProblem(originatingFileName, problemId, problemArguments, elaborationId, messageArguments, severity, startPosition, endPosition, lineNumber, columnNumber);
        result.compilationProblems.add(problem);
        return problem;
      }
      
      @Override
      public CategorizedProblem createProblem(final char[] originatingFileName, final int problemId, final String[] problemArguments, final String[] messageArguments, final int severity, final int startPosition, final int endPosition, final int lineNumber, final int columnNumber) {
        final CategorizedProblem problem = super.createProblem(originatingFileName, problemId, problemArguments, messageArguments, severity, startPosition, endPosition, lineNumber, columnNumber);
        result.compilationProblems.add(problem);
        return problem;
      }
    });
    final Function1<JavaSource, CompilationUnit> _function_1 = (JavaSource it) -> {
      char[] _charArray = it.getCode().toCharArray();
      String _fileName = it.getFileName();
      return new CompilationUnit(_charArray, _fileName, null);
    };
    ICompilationUnit[] units = ((ICompilationUnit[])Conversions.unwrapArray(ListExtensions.<JavaSource, CompilationUnit>map(((List<JavaSource>)Conversions.doWrapArray(sources)), _function_1), ICompilationUnit.class));
    compiler.compile(units);
    return result;
  }
}
