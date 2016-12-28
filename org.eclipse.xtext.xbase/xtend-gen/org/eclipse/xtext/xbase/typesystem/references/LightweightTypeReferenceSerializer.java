package org.eclipse.xtext.xbase.typesystem.references;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.InnerFunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.InnerTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitor;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

@SuppressWarnings("all")
public class LightweightTypeReferenceSerializer extends TypeReferenceVisitor {
  private ISourceAppender appender;
  
  public LightweightTypeReferenceSerializer(final ISourceAppender appender) {
    this.appender = appender;
  }
  
  @Override
  protected void doVisitAnyTypeReference(final AnyTypeReference reference) {
    reference.toJavaType().accept(this);
  }
  
  @Override
  protected void doVisitArrayTypeReference(final ArrayTypeReference reference) {
    reference.getComponentType().accept(this);
    this.appender.append("[]");
  }
  
  @Override
  protected void doVisitCompoundTypeReference(final CompoundTypeReference reference) {
    reference.toJavaType().accept(this);
  }
  
  @Override
  protected void doVisitFunctionTypeReference(final FunctionTypeReference reference) {
    boolean _isJava = this.appender.isJava();
    if (_isJava) {
      this.doVisitParameterizedTypeReference(reference);
    } else {
      this.appender.append("(");
      this.appendCommaSeparated(reference.getParameterTypes());
      this.appender.append(")=>");
      LightweightTypeReference _returnType = reference.getReturnType();
      boolean _tripleEquals = (_returnType == null);
      if (_tripleEquals) {
        this.appender.append("void");
      } else {
        reference.getReturnType().accept(this);
      }
    }
  }
  
  @Override
  protected void doVisitInnerFunctionTypeReference(final InnerFunctionTypeReference reference) {
    boolean _isJava = this.appender.isJava();
    if (_isJava) {
      reference.getOuter().accept(this);
      this.appender.append(".");
      this.appender.append(reference.getType().getSimpleName());
      boolean _isEmpty = reference.getTypeArguments().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        this.appender.append("<");
        this.appendCommaSeparated(reference.getTypeArguments());
        this.appender.append(">");
      }
    } else {
      this.appender.append("(");
      this.appendCommaSeparated(reference.getParameterTypes());
      this.appender.append(")=>");
      LightweightTypeReference _returnType = reference.getReturnType();
      boolean _tripleEquals = (_returnType == null);
      if (_tripleEquals) {
        this.appender.append("void");
      } else {
        reference.getReturnType().accept(this);
      }
    }
  }
  
  @Override
  protected void doVisitParameterizedTypeReference(final ParameterizedTypeReference reference) {
    boolean _isAnonymous = reference.isAnonymous();
    if (_isAnonymous) {
      reference.getNamedType().accept(this);
    } else {
      this.appender.append(reference.getType());
      boolean _isEmpty = reference.getTypeArguments().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        this.appender.append("<");
        this.appendCommaSeparated(reference.getTypeArguments());
        this.appender.append(">");
      }
    }
  }
  
  @Override
  protected void doVisitInnerTypeReference(final InnerTypeReference reference) {
    reference.getOuter().accept(this);
    this.appender.append(".");
    this.appender.append(reference.getType().getSimpleName());
    boolean _isEmpty = reference.getTypeArguments().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.appender.append("<");
      this.appendCommaSeparated(reference.getTypeArguments());
      this.appender.append(">");
    }
  }
  
  @Override
  protected void doVisitUnboundTypeReference(final UnboundTypeReference reference) {
    reference.toJavaType().accept(this);
  }
  
  @Override
  protected void doVisitUnknownTypeReference(final UnknownTypeReference reference) {
    this.appender.append(reference.getSimpleName());
  }
  
  @Override
  protected void doVisitWildcardTypeReference(final WildcardTypeReference reference) {
    this.appender.append("?");
    LightweightTypeReference _lowerBound = reference.getLowerBound();
    boolean _tripleNotEquals = (_lowerBound != null);
    if (_tripleNotEquals) {
      this.appender.append(" super ");
      reference.getLowerBound().accept(this);
    } else {
      final Function1<LightweightTypeReference, Boolean> _function = (LightweightTypeReference it) -> {
        String _identifier = it.getIdentifier();
        return Boolean.valueOf((!Objects.equal("java.lang.Object", _identifier)));
      };
      final Iterable<LightweightTypeReference> relevantUpperBounds = IterableExtensions.<LightweightTypeReference>filter(reference.getUpperBounds(), _function);
      boolean _isEmpty = IterableExtensions.isEmpty(relevantUpperBounds);
      boolean _not = (!_isEmpty);
      if (_not) {
        this.appender.append(" extends ");
        boolean isFirst = true;
        for (final LightweightTypeReference upperBound : relevantUpperBounds) {
          {
            if ((!isFirst)) {
              this.appender.append(" & ");
            }
            isFirst = false;
            upperBound.accept(this);
          }
        }
      }
    }
  }
  
  protected void appendCommaSeparated(final List<LightweightTypeReference> references) {
    boolean isFirst = true;
    for (final LightweightTypeReference reference : references) {
      {
        if ((!isFirst)) {
          this.appender.append(", ");
        }
        isFirst = false;
        reference.accept(this);
      }
    }
  }
}
