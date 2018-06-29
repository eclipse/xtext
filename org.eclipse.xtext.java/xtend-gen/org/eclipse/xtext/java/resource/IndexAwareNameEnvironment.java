package org.eclipse.xtext.java.resource;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.descriptions.EObjectDescriptionBasedStubGenerator;
import org.eclipse.xtext.java.resource.ClassFileCache;
import org.eclipse.xtext.java.resource.JavaResource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class IndexAwareNameEnvironment implements INameEnvironment {
  private final Resource resource;
  
  private final ClassLoader classLoader;
  
  private final IResourceDescriptions resourceDescriptions;
  
  private final EObjectDescriptionBasedStubGenerator stubGenerator;
  
  private final ClassFileCache classFileCache;
  
  private Map<QualifiedName, NameEnvironmentAnswer> cache = CollectionLiterals.<QualifiedName, NameEnvironmentAnswer>newHashMap();
  
  @Override
  public void cleanup() {
    this.cache.clear();
  }
  
  @Override
  public NameEnvironmentAnswer findType(final char[][] compoundTypeName) {
    final Function1<char[], String> _function = (char[] it) -> {
      return String.valueOf(it);
    };
    final QualifiedName className = QualifiedName.create(ListExtensions.<char[], String>map(((List<char[]>)Conversions.doWrapArray(compoundTypeName)), _function));
    return this.findType(className);
  }
  
  public NameEnvironmentAnswer findType(final QualifiedName className) {
    try {
      boolean _containsKey = this.classFileCache.containsKey(className);
      if (_containsKey) {
        final IBinaryType t = this.classFileCache.get(className);
        if ((t == null)) {
          return null;
        }
        return new NameEnvironmentAnswer(t, null);
      }
      boolean _containsKey_1 = this.cache.containsKey(className);
      if (_containsKey_1) {
        return this.cache.get(className);
      }
      final IEObjectDescription candidate = IterableExtensions.<IEObjectDescription>head(this.resourceDescriptions.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, className, false));
      NameEnvironmentAnswer result = null;
      if ((candidate != null)) {
        final IResourceDescription resourceDescription = this.resourceDescriptions.getResourceDescription(candidate.getEObjectURI().trimFragment());
        final Resource res = this.resource.getResourceSet().getResource(resourceDescription.getURI(), false);
        String _xifexpression = null;
        if ((res instanceof JavaResource)) {
          _xifexpression = ((JavaResource) res).getOriginalSource();
        } else {
          _xifexpression = this.stubGenerator.getJavaStubSource(candidate, resourceDescription);
        }
        final String source = _xifexpression;
        char[] _charArray = source.toCharArray();
        String _string = className.toString("/");
        String _plus = (_string + ".java");
        CompilationUnit _compilationUnit = new CompilationUnit(_charArray, _plus, null);
        NameEnvironmentAnswer _nameEnvironmentAnswer = new NameEnvironmentAnswer(_compilationUnit, null);
        result = _nameEnvironmentAnswer;
      } else {
        String _string_1 = className.toString("/");
        final String fileName = (_string_1 + ".class");
        final URL url = this.classLoader.getResource(fileName);
        if ((url == null)) {
          this.cache.put(className, null);
          this.classFileCache.put(className, null);
          return null;
        }
        final ClassFileReader reader = ClassFileReader.read(url.openStream(), fileName);
        this.classFileCache.put(className, reader);
        NameEnvironmentAnswer _nameEnvironmentAnswer_1 = new NameEnvironmentAnswer(reader, null);
        result = _nameEnvironmentAnswer_1;
      }
      this.cache.put(className, result);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public NameEnvironmentAnswer findType(final char[] typeName, final char[][] packageName) {
    final Function1<char[], String> _function = (char[] it) -> {
      return String.valueOf(it);
    };
    List<String> _map = ListExtensions.<char[], String>map(((List<char[]>)Conversions.doWrapArray(packageName)), _function);
    final ArrayList<String> list = new ArrayList<String>(_map);
    String _valueOf = String.valueOf(typeName);
    list.add(_valueOf);
    final QualifiedName className = QualifiedName.create(list);
    return this.findType(className);
  }
  
  @Override
  public boolean isPackage(final char[][] parentPackageName, final char[] packageName) {
    if (((packageName == null) || (packageName.length == 0))) {
      return false;
    }
    return Character.isLowerCase((IterableExtensions.<Character>head(((Iterable<Character>)Conversions.doWrapArray(packageName)))).charValue());
  }
  
  public IndexAwareNameEnvironment(final Resource resource, final ClassLoader classLoader, final IResourceDescriptions resourceDescriptions, final EObjectDescriptionBasedStubGenerator stubGenerator, final ClassFileCache classFileCache) {
    super();
    this.resource = resource;
    this.classLoader = classLoader;
    this.resourceDescriptions = resourceDescriptions;
    this.stubGenerator = stubGenerator;
    this.classFileCache = classFileCache;
  }
}
