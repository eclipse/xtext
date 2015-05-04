/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.DefaultErrorHandlingPolicies;
import org.eclipse.jdt.internal.compiler.ICompilerRequestor;
import org.eclipse.jdt.internal.compiler.IErrorHandlingPolicy;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.problem.DefaultProblemFactory;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.compiler.JavaSource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

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
        final Function1<char[], String> _function = new Function1<char[], String>() {
          @Override
          public String apply(final char[] it) {
            return String.valueOf(it);
          }
        };
        List<String> _map = ListExtensions.<char[], String>map(((List<char[]>)Conversions.doWrapArray(compoundTypeName)), _function);
        String _join = IterableExtensions.join(_map, "/");
        final String fileName = (_join + ".class");
        boolean _containsKey = this.cache.containsKey(fileName);
        if (_containsKey) {
          return this.cache.get(fileName);
        }
        final URL url = this.classLoader.getResource(fileName);
        boolean _equals = Objects.equal(url, null);
        if (_equals) {
          this.cache.put(fileName, null);
          return null;
        }
        InputStream _openStream = url.openStream();
        final ClassFileReader reader = ClassFileReader.read(_openStream, fileName);
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
        final Function1<char[], String> _function = new Function1<char[], String>() {
          @Override
          public String apply(final char[] it) {
            return String.valueOf(it);
          }
        };
        List<String> _map = ListExtensions.<char[], String>map(((List<char[]>)Conversions.doWrapArray(packageName)), _function);
        String _join = IterableExtensions.join(_map, "/");
        String _plus = (_join + "/");
        String _valueOf = String.valueOf(typeName);
        String _plus_1 = (_plus + _valueOf);
        final String fileName = (_plus_1 + ".class");
        boolean _containsKey = this.cache.containsKey(fileName);
        if (_containsKey) {
          return this.cache.get(fileName);
        }
        final URL url = this.classLoader.getResource(fileName);
        boolean _equals = Objects.equal(url, null);
        if (_equals) {
          this.cache.put(fileName, null);
          return null;
        }
        InputStream _openStream = url.openStream();
        final ClassFileReader reader = ClassFileReader.read(_openStream, fileName);
        final NameEnvironmentAnswer result = new NameEnvironmentAnswer(reader, null);
        this.cache.put(fileName, result);
        return result;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    @Override
    public boolean isPackage(final char[][] parentPackageName, final char[] packageName) {
      Character _head = IterableExtensions.<Character>head(((Iterable<Character>)Conversions.doWrapArray(packageName)));
      return Character.isLowerCase((_head).charValue());
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
      try {
        byte[] bytes = this.classMap.get(name);
        if ((bytes == null)) {
          return super.findClass(name);
        } else {
          int _length = bytes.length;
          return this.defineClass(name, bytes, 0, _length);
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    @Override
    protected URL findResource(final String path) {
      try {
        boolean _endsWith = path.endsWith(".class");
        if (_endsWith) {
          int _length = path.length();
          int _minus = (_length - 6);
          String _substring = path.substring(0, _minus);
          final String className = _substring.replace("/", ".");
          final byte[] bytes = this.classMap.get(className);
          boolean _notEquals = (!Objects.equal(bytes, null));
          if (_notEquals) {
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
  private static class InMemoryProblemFactory extends DefaultProblemFactory {
    private final InMemoryJavaCompiler.Result result;
    
    @Override
    public CategorizedProblem createProblem(final char[] originatingFileName, final int problemId, final String[] problemArguments, final int elaborationId, final String[] messageArguments, final int severity, final int startPosition, final int endPosition, final int lineNumber, final int columnNumber) {
      final IProblem problem = super.createProblem(originatingFileName, problemId, problemArguments, elaborationId, messageArguments, severity, startPosition, endPosition, lineNumber, columnNumber);
      this.result.compilationProblems.add(problem);
      return ((CategorizedProblem) problem);
    }
    
    @Override
    public CategorizedProblem createProblem(final char[] originatingFileName, final int problemId, final String[] problemArguments, final String[] messageArguments, final int severity, final int startPosition, final int endPosition, final int lineNumber, final int columnNumber) {
      final IProblem problem = super.createProblem(originatingFileName, problemId, problemArguments, messageArguments, severity, startPosition, endPosition, lineNumber, columnNumber);
      this.result.compilationProblems.add(problem);
      return ((CategorizedProblem) problem);
    }
    
    public InMemoryProblemFactory(final InMemoryJavaCompiler.Result result) {
      super();
      this.result = result;
    }
  }
  
  @FinalFieldsConstructor
  public static class Result {
    @Accessors
    private final Set<IProblem> compilationProblems = CollectionLiterals.<IProblem>newLinkedHashSet();
    
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
    public Set<IProblem> getCompilationProblems() {
      return this.compilationProblems;
    }
  }
  
  private INameEnvironment nameEnv;
  
  private ClassLoader parentClassLoader;
  
  @Accessors
  private CompilerOptions compilerOptions;
  
  @Inject
  public InMemoryJavaCompiler(final ClassLoader parent) {
    InMemoryJavaCompiler.ClassLoaderBasedNameEnvironment _classLoaderBasedNameEnvironment = new InMemoryJavaCompiler.ClassLoaderBasedNameEnvironment(parent);
    this.nameEnv = _classLoaderBasedNameEnvironment;
    this.parentClassLoader = parent;
    CompilerOptions _compilerOptions = new CompilerOptions();
    this.compilerOptions = _compilerOptions;
    this.setSourceLevel(ClassFileConstants.JDK1_6);
    this.setComplianceLevel(ClassFileConstants.JDK1_6);
    this.compilerOptions.targetJDK = ClassFileConstants.JDK1_6;
    this.compilerOptions.inlineJsrBytecode = true;
    this.compilerOptions.preserveAllLocalVariables = true;
  }
  
  /**
   * sets the source level (see @link(org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants))
   */
  public void setSourceLevel(final long jdkVersion) {
    try {
      this.compilerOptions.sourceLevel = jdkVersion;
      try {
        Field _field = CompilerOptions.class.getField("originalSourceLevel");
        _field.setLong(this.compilerOptions, jdkVersion);
      } catch (final Throwable _t) {
        if (_t instanceof NoSuchFieldException) {
          final NoSuchFieldException e = (NoSuchFieldException)_t;
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
  public void setComplianceLevel(final long jdkVersion) {
    try {
      this.compilerOptions.complianceLevel = jdkVersion;
      try {
        Field _field = CompilerOptions.class.getField("originalComplianceLevel");
        _field.setLong(this.compilerOptions, jdkVersion);
      } catch (final Throwable _t) {
        if (_t instanceof NoSuchFieldException) {
          final NoSuchFieldException e = (NoSuchFieldException)_t;
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
    CompilerOptions _compilerOptions = this.getCompilerOptions();
    final ICompilerRequestor _function = new ICompilerRequestor() {
      @Override
      public void acceptResult(final CompilationResult it) {
        ClassFile[] _classFiles = it.getClassFiles();
        for (final ClassFile cf : _classFiles) {
          char[][] _compoundName = cf.getCompoundName();
          final Function1<char[], String> _function = new Function1<char[], String>() {
            @Override
            public String apply(final char[] it) {
              return String.valueOf(it);
            }
          };
          List<String> _map = ListExtensions.<char[], String>map(((List<char[]>)Conversions.doWrapArray(_compoundName)), _function);
          String _join = IterableExtensions.join(_map, ".");
          byte[] _bytes = cf.getBytes();
          result.classMap.put(_join, _bytes);
        }
      }
    };
    InMemoryJavaCompiler.InMemoryProblemFactory _inMemoryProblemFactory = new InMemoryJavaCompiler.InMemoryProblemFactory(result);
    org.eclipse.jdt.internal.compiler.Compiler compiler = new org.eclipse.jdt.internal.compiler.Compiler(this.nameEnv, _proceedWithAllProblems, _compilerOptions, _function, _inMemoryProblemFactory);
    final Function1<JavaSource, CompilationUnit> _function_1 = new Function1<JavaSource, CompilationUnit>() {
      @Override
      public CompilationUnit apply(final JavaSource it) {
        String _code = it.getCode();
        char[] _charArray = _code.toCharArray();
        String _fileName = it.getFileName();
        return new CompilationUnit(_charArray, _fileName, null);
      }
    };
    ICompilationUnit[] units = ((ICompilationUnit[])Conversions.unwrapArray(ListExtensions.<JavaSource, CompilationUnit>map(((List<JavaSource>)Conversions.doWrapArray(sources)), _function_1), ICompilationUnit.class));
    compiler.compile(units);
    return result;
  }
  
  @Pure
  public CompilerOptions getCompilerOptions() {
    return this.compilerOptions;
  }
  
  public void setCompilerOptions(final CompilerOptions compilerOptions) {
    this.compilerOptions = compilerOptions;
  }
}
