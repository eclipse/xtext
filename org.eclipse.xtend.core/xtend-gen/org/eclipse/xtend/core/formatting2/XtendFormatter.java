/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.formatting2;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.annotations.formatting2.XbaseWithAnnotationsFormatter;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@SuppressWarnings("all")
public class XtendFormatter extends XbaseWithAnnotationsFormatter {
  @Inject
  @Extension
  private XtendGrammarAccess _xtendGrammarAccess;

  @Inject
  private RichStringFormatter.Factory richStringFormatterFactory;

  protected void _format(final XtendFile xtendFile, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.<XtendFile>prepend(xtendFile, _function);
    final ISemanticRegion pkg = this.regionFor(xtendFile).feature(XtendPackage.Literals.XTEND_FILE__PACKAGE);
    if ((pkg != null)) {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      format.prepend(pkg, _function_1);
      final ISemanticRegion pkgSemicolon = pkg.immediatelyFollowing().keyword(";");
      if ((pkgSemicolon != null)) {
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        format.append(pkg, _function_2);
        format.append(pkgSemicolon, XtendFormatterPreferenceKeys.blankLinesAfterPackageDecl);
      } else {
        format.append(pkg, XtendFormatterPreferenceKeys.blankLinesAfterPackageDecl);
      }
    }
    XImportSection _importSection = xtendFile.getImportSection();
    if (_importSection!=null) {
      format.<XImportSection>format(_importSection);
    }
    EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
    for (final XtendTypeDeclaration clazz : _xtendTypes) {
      {
        format.<XtendTypeDeclaration>format(clazz);
        XtendTypeDeclaration _last = IterableExtensions.<XtendTypeDeclaration>last(xtendFile.getXtendTypes());
        boolean _notEquals = (!Objects.equal(clazz, _last));
        if (_notEquals) {
          format.<XtendTypeDeclaration>append(clazz, XtendFormatterPreferenceKeys.blankLinesBetweenClasses);
        }
      }
    }
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    format.<XtendFile>append(xtendFile, _function_3);
  }

  protected void formatAnnotations(final XtendAnnotationTarget target, @Extension final IFormattableDocument document, final Procedure1<? super IHiddenRegionFormatter> configKey) {
    boolean _isEmpty = target.getAnnotations().isEmpty();
    if (_isEmpty) {
      return;
    }
    EList<XAnnotation> _annotations = target.getAnnotations();
    for (final XAnnotation a : _annotations) {
      {
        document.<XAnnotation>format(a);
        document.<XAnnotation>append(a, configKey);
      }
    }
  }

  protected void _format(final XtendClass clazz, @Extension final IFormattableDocument format) {
    this.formatAnnotations(clazz, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(clazz, format);
    this.formatTypeParameters(clazz, clazz.getTypeParameters(), format);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.append(this.regionFor(clazz).keyword("class"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.surround(this.regionFor(clazz).keyword("extends"), _function_1);
    format.<JvmTypeReference>format(clazz.getExtends());
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.surround(this.regionFor(clazz).keyword("implements"), _function_2);
    EList<JvmTypeReference> _implements = clazz.getImplements();
    for (final JvmTypeReference imp : _implements) {
      {
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        format.append(format.prepend(this.immediatelyFollowing(imp).keyword(","), _function_3), _function_4);
        format.<JvmTypeReference>format(imp);
      }
    }
    this.formatBody(clazz, format);
  }

  protected ISemanticRegion formatTypeParameters(final XtendMember member, final List<? extends JvmTypeParameter> typeParameters, @Extension final IFormattableDocument format) {
    ISemanticRegion _xifexpression = null;
    boolean _isEmpty = typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ISemanticRegion _xblockexpression = null;
      {
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        format.surround(this.regionFor(member).keyword("<"), _function);
        for (final JvmTypeParameter arg : typeParameters) {
          {
            format.<JvmTypeParameter>format(arg);
            final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
              it.noSpace();
            };
            final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
              it.oneSpace();
            };
            format.append(format.prepend(this.immediatelyFollowing(arg).keyword(","), _function_1), _function_2);
          }
        }
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        _xblockexpression = format.prepend(this.regionFor(member).keyword(">"), _function_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }

  protected ISemanticRegion formatBody(final XtendTypeDeclaration type, @Extension final IFormattableDocument format) {
    ISemanticRegion _xblockexpression = null;
    {
      final ISemanticRegion open = this.regionFor(type).keyword("{");
      final ISemanticRegion close = this.regionFor(type).keyword("}");
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.indent();
      };
      format.<ISemanticRegion, ISemanticRegion>interior(open, close, _function);
      format.prepend(open, XbaseFormatterPreferenceKeys.bracesInNewLine);
      ISemanticRegion _xifexpression = null;
      boolean _isEmpty = type.getMembers().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        format.append(open, XtendFormatterPreferenceKeys.blankLinesBeforeFirstMember);
        int _size = type.getMembers().size();
        int _minus = (_size - 1);
        IntegerRange _upTo = new IntegerRange(0, _minus);
        for (final Integer i : _upTo) {
          {
            final XtendMember current = type.getMembers().get((i).intValue());
            format.<XtendMember>format(current);
            int _size_1 = type.getMembers().size();
            int _minus_1 = (_size_1 - 1);
            boolean _lessThan = ((i).intValue() < _minus_1);
            if (_lessThan) {
              final XtendMember next = type.getMembers().get(((i).intValue() + 1));
              if (((current instanceof XtendField) && (next instanceof XtendField))) {
                format.<XtendMember>append(current, XtendFormatterPreferenceKeys.blankLinesBetweenFields);
              } else {
                if (((current instanceof XtendFunction) && (next instanceof XtendFunction))) {
                  format.<XtendMember>append(current, XtendFormatterPreferenceKeys.blankLinesBetweenMethods);
                } else {
                  format.<XtendMember>append(current, XtendFormatterPreferenceKeys.blankLinesBetweenFieldsAndMethods);
                }
              }
            } else {
              final XtendMember member = type.getMembers().get((i).intValue());
              format.<XtendMember>append(member, XtendFormatterPreferenceKeys.blankLinesAfterLastMember);
            }
          }
        }
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        _xifexpression = format.append(open, _function_1);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  protected void _format(final XtendInterface interfaze, @Extension final IFormattableDocument format) {
    this.formatAnnotations(interfaze, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(interfaze, format);
    this.formatTypeParameters(interfaze, interfaze.getTypeParameters(), format);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.append(this.regionFor(interfaze).keyword("interface"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.surround(this.regionFor(interfaze).keyword("extends"), _function_1);
    EList<JvmTypeReference> _extends = interfaze.getExtends();
    for (final JvmTypeReference imp : _extends) {
      {
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        format.append(format.prepend(this.immediatelyFollowing(imp).keyword(","), _function_2), _function_3);
        format.<JvmTypeReference>format(imp);
      }
    }
    this.formatBody(interfaze, format);
  }

  protected void _format(final XtendAnnotationType annotationType, @Extension final IFormattableDocument format) {
    this.formatAnnotations(annotationType, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(annotationType, format);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.append(this.regionFor(annotationType).keyword("annotation"), _function);
    this.formatBody(annotationType, format);
  }

  protected void _format(final XtendEnum enumeration, @Extension final IFormattableDocument format) {
    this.formatAnnotations(enumeration, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(enumeration, format);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.append(this.regionFor(enumeration).keyword("enum"), _function);
    final ISemanticRegion open = this.regionFor(enumeration).keyword("{");
    final ISemanticRegion close = this.regionFor(enumeration).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    format.<ISemanticRegion, ISemanticRegion>interior(open, close, _function_1);
    format.prepend(open, XbaseFormatterPreferenceKeys.bracesInNewLine);
    boolean _isEmpty = enumeration.getMembers().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      format.append(open, XtendFormatterPreferenceKeys.blankLinesBeforeFirstMember);
      int _size = enumeration.getMembers().size();
      int _minus = (_size - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      for (final Integer i : _upTo) {
        {
          final XtendMember current = enumeration.getMembers().get((i).intValue());
          format.<XtendMember>format(current);
          int _size_1 = enumeration.getMembers().size();
          int _minus_1 = (_size_1 - 1);
          boolean _lessThan = ((i).intValue() < _minus_1);
          if (_lessThan) {
            final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
              it.noSpace();
            };
            format.append(format.prepend(this.immediatelyFollowing(current).keyword(","), _function_2), XtendFormatterPreferenceKeys.blankLinesBetweenEnumLiterals);
          } else {
            format.<XtendMember>append(current, XtendFormatterPreferenceKeys.blankLinesAfterLastMember);
          }
        }
      }
    } else {
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
        it.newLine();
      };
      format.append(open, _function_2);
    }
  }

  protected void _format(final XtendConstructor func, @Extension final IFormattableDocument format) {
    this.formatAnnotations(func, format, XbaseFormatterPreferenceKeys.newLineAfterConstructorAnnotations);
    this.formatModifiers(func, format);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.append(this.regionFor(func).keyword("new"), _function);
    boolean _isEmpty = func.getTypeParameters().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      format.append(this.regionFor(func).keyword("<"), _function_1);
      EList<JvmTypeParameter> _typeParameters = func.getTypeParameters();
      for (final JvmTypeParameter arg : _typeParameters) {
        {
          format.<JvmTypeParameter>format(arg);
          final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
            it.noSpace();
          };
          final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
            it.oneSpace();
          };
          format.append(format.prepend(this.immediatelyFollowing(arg).keyword(","), _function_2), _function_3);
        }
      }
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      format.surround(this.regionFor(func).keyword(">"), _function_2);
    }
    final ISemanticRegion open = this.regionFor(func).keyword("(");
    final ISemanticRegion close = this.regionFor(func).keyword(")");
    format.append(close, XbaseFormatterPreferenceKeys.bracesInNewLine);
    this.formatCommaSeparatedList(func.getParameters(), open, close, format);
    format.<XExpression>format(func.getExpression());
  }

  protected void _format(final XtendFunction func, @Extension final IFormattableDocument format) {
    this.formatAnnotations(func, format, XbaseFormatterPreferenceKeys.newLineAfterMethodAnnotations);
    this.formatModifiers(func, format);
    boolean _isEmpty = func.getTypeParameters().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      format.append(this.regionFor(func).keyword("<"), _function);
      EList<JvmTypeParameter> _typeParameters = func.getTypeParameters();
      for (final JvmTypeParameter arg : _typeParameters) {
        {
          format.<JvmTypeParameter>format(arg);
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
            it.noSpace();
          };
          final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
            it.oneSpace();
          };
          format.append(format.prepend(this.immediatelyFollowing(arg).keyword(","), _function_1), _function_2);
        }
      }
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      format.append(format.prepend(this.regionFor(func).keyword(">"), _function_1), _function_2);
    }
    final ISemanticRegion nameNode = this.regionFor(func).feature(XtendPackage.Literals.XTEND_FUNCTION__NAME);
    ISemanticRegionFinder _immediatelyFollowing = null;
    if (nameNode!=null) {
      _immediatelyFollowing=nameNode.immediatelyFollowing();
    }
    ISemanticRegion _keyword = null;
    if (_immediatelyFollowing!=null) {
      _keyword=_immediatelyFollowing.keyword("(");
    }
    final ISemanticRegion open = _keyword;
    final ISemanticRegion close = this.regionFor(func).keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.<JvmTypeReference>append(func.getReturnType(), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.prepend(open, _function_4);
    XExpression _expression = func.getExpression();
    boolean _tripleNotEquals = (_expression != null);
    if (_tripleNotEquals) {
      format.append(close, XbaseFormatterPreferenceKeys.bracesInNewLine);
    }
    this.formatCommaSeparatedList(func.getParameters(), open, close, format);
    format.<JvmTypeReference>format(func.getReturnType());
    format.<XExpression>format(func.getExpression());
  }

  protected void _format(final XtendField field, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.regionFor(field).keyword("extension"), _function);
    this.formatAnnotations(field, document, XbaseFormatterPreferenceKeys.newLineAfterFieldAnnotations);
    this.formatModifiers(field, document);
    String _name = field.getName();
    boolean _tripleNotEquals = (_name != null);
    if (_tripleNotEquals) {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      document.<JvmTypeReference>append(field.getType(), _function_1);
    }
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(document.prepend(this.regionFor(field).keyword("="), _function_2), _function_3);
    document.<JvmTypeReference>format(field.getType());
    document.<XExpression>format(field.getInitialValue());
  }

  protected void _format(final XtendParameter param, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.append(this.regionFor(param).keyword("extension"), _function);
    this.formatAnnotations(param, format, XbaseFormatterPreferenceKeys.newLineAfterParameterAnnotations);
    format.<JvmTypeReference>format(param.getParameterType());
    final ISemanticRegion nameNode = this.regionFor(param).feature(XtendPackage.Literals.XTEND_PARAMETER__NAME);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.prepend(nameNode, _function_1);
  }

  @Override
  protected void _format(final XVariableDeclaration expr, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.append(this.regionFor(expr).keyword("extension"), _function);
    super._format(expr, format);
  }

  @Override
  protected void _format(final XIfExpression expr, @Extension final IFormattableDocument format) {
    boolean _isConditionalExpression = expr.isConditionalExpression();
    boolean _not = (!_isConditionalExpression);
    if (_not) {
      super._format(expr, format);
    } else {
      EObject _eContainer = expr.eContainer();
      if ((_eContainer instanceof XVariableDeclaration)) {
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.indent();
        };
        format.<XIfExpression>surround(expr, _function);
      }
      final boolean multiline = (this.isMultilineOrInNewLine(expr.getThen()) || this.isMultilineOrInNewLine(expr.getElse()));
      if (((expr.getThen() instanceof XBlockExpression) || multiline)) {
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.indent();
        };
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        format.append(format.surround(format.prepend(this.regionFor(expr).keyword("?"), _function_1), _function_2), _function_3);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        format.surround(this.regionFor(expr).keyword("?"), _function_4);
      }
      format.<XExpression>format(expr.getIf());
      XExpression _else = expr.getElse();
      boolean _tripleEquals = (_else == null);
      if (_tripleEquals) {
        this.formatBody(expr.getThen(), multiline, format);
      } else {
        this.formatBodyInline(expr.getThen(), multiline, format);
        if (((expr.getElse() instanceof XIfExpression) || (!multiline))) {
          final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
            it.oneSpace();
          };
          format.<XExpression>prepend(expr.getElse(), _function_5);
          format.<XExpression>format(expr.getElse());
        } else {
          final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
            it.newLine();
          };
          final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
            it.indent();
          };
          final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
            it.oneSpace();
          };
          format.append(format.surround(format.prepend(this.regionFor(expr).keyword(":"), _function_6), _function_7), _function_8);
          this.formatBody(expr.getElse(), multiline, format);
        }
      }
    }
  }

  @Override
  protected void _format(final JvmFormalParameter expr, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.append(this.regionFor(expr).keyword("extension"), _function);
    super._format(expr, format);
  }

  protected void _format(final RichString rs, @Extension final IFormattableDocument format) {
    final RichStringFormatter richStringFormatter = this.richStringFormatterFactory.create(this.getRequest().getTextRegionAccess());
    richStringFormatter.format(rs, format);
  }

  protected void _format(final AnonymousClass anonymousClass, @Extension final IFormattableDocument format) {
    this.format(anonymousClass.getConstructorCall(), format);
    this.formatBody(anonymousClass, format);
  }

  /**
   * Always put existing modifiers into this fixed order
   */
  protected void formatModifiers(final XtendMember member, @Extension final IFormattableDocument document) {
    final Consumer<ISemanticRegion> _function = (ISemanticRegion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      document.append(it, _function_1);
    };
    this.regionFor(member).ruleCallsTo(this._xtendGrammarAccess.getCommonModifierRule(), this._xtendGrammarAccess.getMethodModifierRule(), this._xtendGrammarAccess.getFieldModifierRule()).forEach(_function);
  }

  @Override
  protected boolean isSingleLineBlock(final XBlockExpression expr) {
    return ((((expr.getExpressions().size() <= 1) && (this.getPreferences().<Boolean>getPreference(XtendFormatterPreferenceKeys.keepOneLineMethods)).booleanValue()) && 
      (expr.eContainer() instanceof XtendFunction)) && 
      (!this.nextHiddenRegion(expr).immediatelyPreceding().keyword("}").getPreviousHiddenRegion().isMultiline()));
  }

  @Override
  protected void formatBodyInline(final XExpression expr, final boolean forceMultiline, @Extension final IFormattableDocument doc) {
    if ((expr == null)) {
      return;
    }
    if (((expr instanceof XBlockExpression) && ((!(expr instanceof RichString)) || (!forceMultiline)))) {
      doc.<XExpression>append(doc.<XExpression>prepend(expr, XbaseFormatterPreferenceKeys.bracesInNewLine), XbaseFormatterPreferenceKeys.bracesInNewLine);
    } else {
      if ((forceMultiline || this.previousHiddenRegion(expr).isMultiline())) {
        boolean _not = (!((expr.eContainer() instanceof XIfExpression) && ((XIfExpression) expr.eContainer()).isConditionalExpression()));
        if (_not) {
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
            it.newLine();
          };
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
            it.indent();
          };
          final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
            it.newLine();
          };
          doc.<XExpression>append(doc.<XExpression>surround(doc.<XExpression>prepend(expr, _function), _function_1), _function_2);
        }
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        doc.<XExpression>surround(expr, _function_3);
      }
    }
    doc.<XExpression>format(expr);
  }

  @Override
  protected void formatBody(final XExpression expr, final boolean forceMultiline, @Extension final IFormattableDocument doc) {
    if ((expr == null)) {
      return;
    }
    if (((expr instanceof XBlockExpression) && ((!(expr instanceof RichString)) || (!forceMultiline)))) {
      doc.<XExpression>prepend(expr, XbaseFormatterPreferenceKeys.bracesInNewLine);
    } else {
      if ((forceMultiline || this.previousHiddenRegion(expr).isMultiline())) {
        boolean _not = (!((expr.eContainer() instanceof XIfExpression) && ((XIfExpression) expr.eContainer()).isConditionalExpression()));
        if (_not) {
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
            it.newLine();
          };
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
            it.indent();
          };
          doc.<XExpression>surround(doc.<XExpression>prepend(expr, _function), _function_1);
        }
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        doc.<XExpression>prepend(expr, _function_2);
      }
    }
    doc.<XExpression>format(expr);
  }

  @Override
  protected XClosure builder(final List<XExpression> params) {
    XClosure _xifexpression = null;
    XExpression _last = IterableExtensions.<XExpression>last(params);
    boolean _tripleNotEquals = (_last != null);
    if (_tripleNotEquals) {
      XClosure _xblockexpression = null;
      {
        final EObject grammarElement = this.grammarElement(IterableExtensions.<XExpression>last(params));
        XClosure _xifexpression_1 = null;
        if (((Objects.equal(grammarElement, this._xtendGrammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()) || 
          Objects.equal(grammarElement, this._xtendGrammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_4_0())) || 
          Objects.equal(grammarElement, this._xtendGrammarAccess.getXbaseConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0()))) {
          XExpression _last_1 = IterableExtensions.<XExpression>last(params);
          _xifexpression_1 = ((XClosure) _last_1);
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }

  @Override
  public void format(final Object anonymousClass, final IFormattableDocument format) {
    if (anonymousClass instanceof AnonymousClass) {
      _format((AnonymousClass)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XtendAnnotationType) {
      _format((XtendAnnotationType)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XtendClass) {
      _format((XtendClass)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XtendConstructor) {
      _format((XtendConstructor)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XtendEnum) {
      _format((XtendEnum)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XtendFunction) {
      _format((XtendFunction)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XtendInterface) {
      _format((XtendInterface)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof RichString) {
      _format((RichString)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XtendField) {
      _format((XtendField)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XtextResource) {
      _format((XtextResource)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XAssignment) {
      _format((XAssignment)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XBinaryOperation) {
      _format((XBinaryOperation)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XFeatureCall) {
      _format((XFeatureCall)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XPostfixOperation) {
      _format((XPostfixOperation)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XWhileExpression) {
      _format((XWhileExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XtendParameter) {
      _format((XtendParameter)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XBlockExpression) {
      _format((XBlockExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XCastedExpression) {
      _format((XCastedExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XClosure) {
      _format((XClosure)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XConstructorCall) {
      _format((XConstructorCall)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XForLoopExpression) {
      _format((XForLoopExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XIfExpression) {
      _format((XIfExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XInstanceOfExpression) {
      _format((XInstanceOfExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XReturnExpression) {
      _format((XReturnExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XSwitchExpression) {
      _format((XSwitchExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XThrowExpression) {
      _format((XThrowExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XTypeLiteral) {
      _format((XTypeLiteral)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XAnnotation) {
      _format((XAnnotation)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XtendFile) {
      _format((XtendFile)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XExpression) {
      _format((XExpression)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XImportDeclaration) {
      _format((XImportDeclaration)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof XImportSection) {
      _format((XImportSection)anonymousClass, format);
      return;
    } else if (anonymousClass instanceof EObject) {
      _format((EObject)anonymousClass, format);
      return;
    } else if (anonymousClass == null) {
      _format((Void)null, format);
      return;
    } else if (anonymousClass != null) {
      _format(anonymousClass, format);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(anonymousClass, format).toString());
    }
  }
}
