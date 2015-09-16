package org.eclipse.xtext.xtext.generator.model;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;

@SuppressWarnings("all")
public class GeneratedJavaFileAccess extends JavaFileAccess {
  @Accessors
  private CharSequence typeComment;
  
  @Accessors
  private final List<IClassAnnotation> annotations = CollectionLiterals.<IClassAnnotation>newArrayList();
  
  protected GeneratedJavaFileAccess(final TypeReference typeRef, final CodeConfig codeConfig) {
    super(typeRef, codeConfig);
  }
  
  @Override
  public boolean isMarkedAsGenerated() {
    return true;
  }
  
  @Override
  public void setMarkedAsGenerated(final boolean markedAsGenerated) {
    if ((!markedAsGenerated)) {
      throw new IllegalArgumentException("It\'s always generated");
    }
  }
  
  @Override
  public CharSequence getContent() {
    List<IClassAnnotation> _classAnnotations = this.codeConfig.getClassAnnotations();
    final Function1<IClassAnnotation, Boolean> _function = new Function1<IClassAnnotation, Boolean>() {
      @Override
      public Boolean apply(final IClassAnnotation it) {
        return Boolean.valueOf(it.appliesTo(GeneratedJavaFileAccess.this));
      }
    };
    Iterable<IClassAnnotation> _filter = IterableExtensions.<IClassAnnotation>filter(_classAnnotations, _function);
    final Iterable<IClassAnnotation> classAnnotations = Iterables.<IClassAnnotation>concat(this.annotations, _filter);
    final Procedure1<IClassAnnotation> _function_1 = new Procedure1<IClassAnnotation>() {
      @Override
      public void apply(final IClassAnnotation it) {
        TypeReference _annotationImport = it.getAnnotationImport();
        GeneratedJavaFileAccess.this.importType(_annotationImport);
      }
    };
    IterableExtensions.<IClassAnnotation>forEach(classAnnotations, _function_1);
    Collection<String> _values = this.imports.values();
    final ArrayList<String> sortedImports = Lists.<String>newArrayList(_values);
    Collections.<String>sort(sortedImports);
    StringConcatenation _builder = new StringConcatenation();
    String _fileHeader = this.codeConfig.getFileHeader();
    _builder.append(_fileHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _packageName = this.javaType.getPackageName();
    _builder.append(_packageName, "");
    {
      boolean _appendSemicolons = this.appendSemicolons();
      if (_appendSemicolons) {
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      for(final String importName : sortedImports) {
        _builder.append("import ");
        _builder.append(importName, "");
        {
          boolean _appendSemicolons_1 = this.appendSemicolons();
          if (_appendSemicolons_1) {
            _builder.append(";");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append(this.typeComment, "");
    _builder.newLineIfNotEmpty();
    {
      for(final IClassAnnotation annot : classAnnotations) {
        CharSequence _generate = annot.generate();
        _builder.append(_generate, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(this.internalContents, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Pure
  public CharSequence getTypeComment() {
    return this.typeComment;
  }
  
  public void setTypeComment(final CharSequence typeComment) {
    this.typeComment = typeComment;
  }
  
  @Pure
  public List<IClassAnnotation> getAnnotations() {
    return this.annotations;
  }
}
