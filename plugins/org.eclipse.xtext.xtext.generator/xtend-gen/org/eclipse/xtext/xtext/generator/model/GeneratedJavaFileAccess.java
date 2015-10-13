package org.eclipse.xtext.xtext.generator.model;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
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
  
  public CharSequence setTypeComment(final StringConcatenationClient javaContent) {
    CharSequence _xblockexpression = null;
    {
      final JavaFileAccess.JavaTypeAwareStringConcatenation javaStringConcat = new JavaFileAccess.JavaTypeAwareStringConcatenation(this);
      javaStringConcat.append(javaContent);
      _xblockexpression = this.typeComment = javaStringConcat;
    }
    return _xblockexpression;
  }
  
  /**
   * Prepends the addition of required imports of the employed annotations.
   * Since the 'typeComment' is a {@link JavaFileAccess.JavaTypeAwareStringConcatenation}
   * any optionally required imports are already processed and tracked in {@link #imports}.
   */
  @Override
  public CharSequence getContent() {
    CharSequence _xblockexpression = null;
    {
      Iterable<IClassAnnotation> _classAnnotations = this.getClassAnnotations();
      final Procedure1<IClassAnnotation> _function = new Procedure1<IClassAnnotation>() {
        @Override
        public void apply(final IClassAnnotation it) {
          TypeReference _annotationImport = it.getAnnotationImport();
          GeneratedJavaFileAccess.this.importType(_annotationImport);
        }
      };
      IterableExtensions.<IClassAnnotation>forEach(_classAnnotations, _function);
      _xblockexpression = super.getContent();
    }
    return _xblockexpression;
  }
  
  private Iterable<IClassAnnotation> getClassAnnotations() {
    List<IClassAnnotation> _classAnnotations = this.codeConfig.getClassAnnotations();
    final Function1<IClassAnnotation, Boolean> _function = new Function1<IClassAnnotation, Boolean>() {
      @Override
      public Boolean apply(final IClassAnnotation it) {
        return Boolean.valueOf(it.appliesTo(GeneratedJavaFileAccess.this));
      }
    };
    Iterable<IClassAnnotation> _filter = IterableExtensions.<IClassAnnotation>filter(_classAnnotations, _function);
    return Iterables.<IClassAnnotation>concat(this.annotations, _filter);
  }
  
  @Override
  public CharSequence getInternalContent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.typeComment, "");
    _builder.newLineIfNotEmpty();
    {
      Iterable<IClassAnnotation> _classAnnotations = this.getClassAnnotations();
      for(final IClassAnnotation annot : _classAnnotations) {
        CharSequence _generate = annot.generate();
        _builder.append(_generate, "");
        _builder.newLineIfNotEmpty();
      }
    }
    CharSequence _internalContent = super.getInternalContent();
    _builder.append(_internalContent, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Pure
  public List<IClassAnnotation> getAnnotations() {
    return this.annotations;
  }
}
