/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.formatting2;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.formatting2.RichStringFormatter;
import org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys;
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
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
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
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

@SuppressWarnings("all")
public class XtendFormatter extends XbaseWithAnnotationsFormatter {
  @Inject
  @Extension
  private XtendGrammarAccess _xtendGrammarAccess;
  
  @Inject
  private RichStringFormatter.Factory richStringFormatterFactory;
  
  protected void _format(final XtendFile xtendFile, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    format.<XtendFile>prepend(xtendFile, _function);
    final ISemanticRegion pkg = this.regionAccess.regionForFeature(xtendFile, XtendPackage.Literals.XTEND_FILE__PACKAGE);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.prepend(pkg, _function_1);
    final ISemanticRegion pkgSemicolon = this.regionAccess.immediatelyFollowingKeyword(pkg, ";");
    boolean _notEquals = (!Objects.equal(pkgSemicolon, null));
    if (_notEquals) {
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      format.append(pkg, _function_2);
      format.append(pkgSemicolon, XtendFormatterPreferenceKeys.blankLinesAfterPackageDecl);
    } else {
      format.append(pkg, XtendFormatterPreferenceKeys.blankLinesAfterPackageDecl);
    }
    XImportSection _importSection = xtendFile.getImportSection();
    if (_importSection!=null) {
      this.format(_importSection, format);
    }
    EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
    for (final XtendTypeDeclaration clazz : _xtendTypes) {
      {
        this.format(clazz, format);
        EList<XtendTypeDeclaration> _xtendTypes_1 = xtendFile.getXtendTypes();
        XtendTypeDeclaration _last = IterableExtensions.<XtendTypeDeclaration>last(_xtendTypes_1);
        boolean _notEquals_1 = (!Objects.equal(clazz, _last));
        if (_notEquals_1) {
          format.<XtendTypeDeclaration>append(clazz, XtendFormatterPreferenceKeys.blankLinesBetweenClasses);
        }
      }
    }
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    format.<XtendFile>append(xtendFile, _function_3);
  }
  
  protected void formatAnnotations(final XtendAnnotationTarget target, @Extension final IFormattableDocument document, final Procedure1<? super IHiddenRegionFormatter> configKey) {
    EList<XAnnotation> _annotations = target.getAnnotations();
    boolean _isEmpty = _annotations.isEmpty();
    if (_isEmpty) {
      return;
    }
    EList<XAnnotation> _annotations_1 = target.getAnnotations();
    for (final XAnnotation a : _annotations_1) {
      {
        this.format(a, document);
        document.<XAnnotation>append(a, ((Procedure1<IHiddenRegionFormatter>)configKey));
      }
    }
  }
  
  protected void _format(final XtendClass clazz, @Extension final IFormattableDocument format) {
    this.formatAnnotations(clazz, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(clazz, format);
    EList<JvmTypeParameter> _typeParameters = clazz.getTypeParameters();
    this.formatTypeParameters(clazz, _typeParameters, format);
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(clazz, "class");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_regionForKeyword, _function);
    ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(clazz, "extends");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.surround(_regionForKeyword_1, _function_1);
    JvmTypeReference _extends = clazz.getExtends();
    this.format(_extends, format);
    ISemanticRegion _regionForKeyword_2 = this.regionAccess.regionForKeyword(clazz, "implements");
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.surround(_regionForKeyword_2, _function_2);
    EList<JvmTypeReference> _implements = clazz.getImplements();
    for (final JvmTypeReference imp : _implements) {
      {
        ISemanticRegion _immediatelyFollowingKeyword = this.regionAccess.immediatelyFollowingKeyword(imp, ",");
        final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        ISemanticRegion _prepend = format.prepend(_immediatelyFollowingKeyword, _function_3);
        final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        format.append(_prepend, _function_4);
        this.format(imp, format);
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
        ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(member, "<");
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        format.surround(_regionForKeyword, _function);
        for (final JvmTypeParameter arg : typeParameters) {
          {
            this.format(arg, format);
            ISemanticRegion _immediatelyFollowingKeyword = this.regionAccess.immediatelyFollowingKeyword(arg, ",");
            final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
              public void apply(final IHiddenRegionFormatter it) {
                it.noSpace();
              }
            };
            ISemanticRegion _prepend = format.prepend(_immediatelyFollowingKeyword, _function_1);
            final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
              public void apply(final IHiddenRegionFormatter it) {
                it.oneSpace();
              }
            };
            format.append(_prepend, _function_2);
          }
        }
        ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(member, ">");
        final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        _xblockexpression = format.prepend(_regionForKeyword_1, _function_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected ISemanticRegion formatBody(final XtendTypeDeclaration type, @Extension final IFormattableDocument format) {
    ISemanticRegion _xblockexpression = null;
    {
      final ISemanticRegion clazzOpenBrace = this.regionAccess.regionForKeyword(type, "{");
      format.prepend(clazzOpenBrace, XbaseFormatterPreferenceKeys.bracesInNewLine);
      ISemanticRegion _xifexpression = null;
      EList<XtendMember> _members = type.getMembers();
      boolean _isEmpty = _members.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.increaseIndentation();
          }
        };
        format.append(clazzOpenBrace, _function);
        format.append(clazzOpenBrace, XtendFormatterPreferenceKeys.blankLinesBeforeFirstMember);
        EList<XtendMember> _members_1 = type.getMembers();
        int _size = _members_1.size();
        int _minus = (_size - 1);
        IntegerRange _upTo = new IntegerRange(0, _minus);
        for (final Integer i : _upTo) {
          {
            EList<XtendMember> _members_2 = type.getMembers();
            final XtendMember current = _members_2.get((i).intValue());
            this.format(current, format);
            EList<XtendMember> _members_3 = type.getMembers();
            int _size_1 = _members_3.size();
            int _minus_1 = (_size_1 - 1);
            boolean _lessThan = ((i).intValue() < _minus_1);
            if (_lessThan) {
              EList<XtendMember> _members_4 = type.getMembers();
              final XtendMember next = _members_4.get(((i).intValue() + 1));
              boolean _and = false;
              if (!(current instanceof XtendField)) {
                _and = false;
              } else {
                _and = (next instanceof XtendField);
              }
              if (_and) {
                format.<XtendMember>append(current, XtendFormatterPreferenceKeys.blankLinesBetweenFields);
              } else {
                boolean _and_1 = false;
                if (!(current instanceof XtendFunction)) {
                  _and_1 = false;
                } else {
                  _and_1 = (next instanceof XtendFunction);
                }
                if (_and_1) {
                  format.<XtendMember>append(current, XtendFormatterPreferenceKeys.blankLinesBetweenMethods);
                } else {
                  format.<XtendMember>append(current, XtendFormatterPreferenceKeys.blankLinesBetweenFieldsAndMethods);
                }
              }
            } else {
              EList<XtendMember> _members_5 = type.getMembers();
              final XtendMember member = _members_5.get((i).intValue());
              final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
                public void apply(final IHiddenRegionFormatter it) {
                  it.decreaseIndentation();
                }
              };
              format.<XtendMember>append(member, _function_1);
              format.<XtendMember>append(member, XtendFormatterPreferenceKeys.blankLinesAfterLastMember);
            }
          }
        }
      } else {
        ISemanticRegion _xifexpression_1 = null;
        IHiddenRegion _nextHiddenRegion = null;
        if (clazzOpenBrace!=null) {
          _nextHiddenRegion=clazzOpenBrace.getNextHiddenRegion();
        }
        boolean _containsComment = false;
        if (_nextHiddenRegion!=null) {
          _containsComment=_nextHiddenRegion.containsComment();
        }
        if (_containsComment) {
          final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
            public void apply(final IHiddenRegionFormatter it) {
              it.newLine();
              it.increaseIndentation();
              it.decreaseIndentation();
            }
          };
          _xifexpression_1 = format.append(clazzOpenBrace, _function_1);
        } else {
          final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
            public void apply(final IHiddenRegionFormatter it) {
              it.newLine();
            }
          };
          _xifexpression_1 = format.append(clazzOpenBrace, _function_2);
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected void _format(final XtendInterface interfaze, @Extension final IFormattableDocument format) {
    this.formatAnnotations(interfaze, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(interfaze, format);
    EList<JvmTypeParameter> _typeParameters = interfaze.getTypeParameters();
    this.formatTypeParameters(interfaze, _typeParameters, format);
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(interfaze, "interface");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_regionForKeyword, _function);
    ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(interfaze, "extends");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.surround(_regionForKeyword_1, _function_1);
    EList<JvmTypeReference> _extends = interfaze.getExtends();
    for (final JvmTypeReference imp : _extends) {
      {
        ISemanticRegion _immediatelyFollowingKeyword = this.regionAccess.immediatelyFollowingKeyword(imp, ",");
        final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        ISemanticRegion _prepend = format.prepend(_immediatelyFollowingKeyword, _function_2);
        final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        format.append(_prepend, _function_3);
        this.format(imp, format);
      }
    }
    this.formatBody(interfaze, format);
  }
  
  protected void _format(final XtendAnnotationType annotationType, @Extension final IFormattableDocument format) {
    this.formatAnnotations(annotationType, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(annotationType, format);
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(annotationType, "annotation");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_regionForKeyword, _function);
    this.formatBody(annotationType, format);
  }
  
  protected void _format(final XtendEnum enumeration, @Extension final IFormattableDocument format) {
    this.formatAnnotations(enumeration, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(enumeration, format);
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(enumeration, "enum");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_regionForKeyword, _function);
    final ISemanticRegion clazzOpenBrace = this.regionAccess.regionForKeyword(enumeration, "{");
    format.prepend(clazzOpenBrace, XbaseFormatterPreferenceKeys.bracesInNewLine);
    EList<XtendMember> _members = enumeration.getMembers();
    boolean _isEmpty = _members.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.increaseIndentation();
        }
      };
      format.append(clazzOpenBrace, _function_1);
      format.append(clazzOpenBrace, XtendFormatterPreferenceKeys.blankLinesBeforeFirstMember);
      EList<XtendMember> _members_1 = enumeration.getMembers();
      int _size = _members_1.size();
      int _minus = (_size - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      for (final Integer i : _upTo) {
        {
          EList<XtendMember> _members_2 = enumeration.getMembers();
          final XtendMember current = _members_2.get((i).intValue());
          this.format(current, format);
          EList<XtendMember> _members_3 = enumeration.getMembers();
          int _size_1 = _members_3.size();
          int _minus_1 = (_size_1 - 1);
          boolean _lessThan = ((i).intValue() < _minus_1);
          if (_lessThan) {
            ISemanticRegion _immediatelyFollowingKeyword = this.regionAccess.immediatelyFollowingKeyword(current, ",");
            final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
              public void apply(final IHiddenRegionFormatter it) {
                it.noSpace();
              }
            };
            ISemanticRegion _prepend = format.prepend(_immediatelyFollowingKeyword, _function_2);
            format.append(_prepend, XtendFormatterPreferenceKeys.blankLinesBetweenEnumLiterals);
          } else {
            final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
              public void apply(final IHiddenRegionFormatter it) {
                it.decreaseIndentation();
              }
            };
            format.<XtendMember>append(current, _function_3);
            format.<XtendMember>append(current, XtendFormatterPreferenceKeys.blankLinesAfterLastMember);
          }
        }
      }
    } else {
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
        }
      };
      format.append(clazzOpenBrace, _function_2);
    }
  }
  
  protected void _format(final XtendConstructor func, @Extension final IFormattableDocument format) {
    this.formatAnnotations(func, format, XbaseFormatterPreferenceKeys.newLineAfterConstructorAnnotations);
    this.formatModifiers(func, format);
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(func, "new");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    format.append(_regionForKeyword, _function);
    EList<JvmTypeParameter> _typeParameters = func.getTypeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(func, "<");
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      format.append(_regionForKeyword_1, _function_1);
      EList<JvmTypeParameter> _typeParameters_1 = func.getTypeParameters();
      for (final JvmTypeParameter arg : _typeParameters_1) {
        {
          this.format(arg, format);
          ISemanticRegion _immediatelyFollowingKeyword = this.regionAccess.immediatelyFollowingKeyword(arg, ",");
          final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
            public void apply(final IHiddenRegionFormatter it) {
              it.noSpace();
            }
          };
          ISemanticRegion _prepend = format.prepend(_immediatelyFollowingKeyword, _function_2);
          final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
            public void apply(final IHiddenRegionFormatter it) {
              it.oneSpace();
            }
          };
          format.append(_prepend, _function_3);
        }
      }
      ISemanticRegion _regionForKeyword_2 = this.regionAccess.regionForKeyword(func, ">");
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      format.surround(_regionForKeyword_2, _function_2);
    }
    final ISemanticRegion open = this.regionAccess.regionForKeyword(func, "(");
    final ISemanticRegion close = this.regionAccess.regionForKeyword(func, ")");
    format.append(close, XbaseFormatterPreferenceKeys.bracesInNewLine);
    EList<XtendParameter> _parameters = func.getParameters();
    this.formatCommaSeparatedList(_parameters, open, close, format);
    XExpression _expression = func.getExpression();
    this.format(_expression, format);
  }
  
  protected void _format(final XtendFunction func, @Extension final IFormattableDocument format) {
    this.formatAnnotations(func, format, XbaseFormatterPreferenceKeys.newLineAfterMethodAnnotations);
    this.formatModifiers(func, format);
    EList<JvmTypeParameter> _typeParameters = func.getTypeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(func, "<");
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      format.append(_regionForKeyword, _function);
      EList<JvmTypeParameter> _typeParameters_1 = func.getTypeParameters();
      for (final JvmTypeParameter arg : _typeParameters_1) {
        {
          this.format(arg, format);
          ISemanticRegion _immediatelyFollowingKeyword = this.regionAccess.immediatelyFollowingKeyword(arg, ",");
          final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
            public void apply(final IHiddenRegionFormatter it) {
              it.noSpace();
            }
          };
          ISemanticRegion _prepend = format.prepend(_immediatelyFollowingKeyword, _function_1);
          final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
            public void apply(final IHiddenRegionFormatter it) {
              it.oneSpace();
            }
          };
          format.append(_prepend, _function_2);
        }
      }
      ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(func, ">");
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      ISemanticRegion _prepend = format.prepend(_regionForKeyword_1, _function_1);
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      format.append(_prepend, _function_2);
    }
    final ISemanticRegion nameNode = this.regionAccess.regionForFeature(func, XtendPackage.Literals.XTEND_FUNCTION__NAME);
    final ISemanticRegion open = this.regionAccess.immediatelyFollowingKeyword(nameNode, "(");
    final ISemanticRegion close = this.regionAccess.regionForKeyword(func, ")");
    JvmTypeReference _returnType = func.getReturnType();
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.<JvmTypeReference>append(_returnType, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    format.prepend(open, _function_4);
    XExpression _expression = func.getExpression();
    boolean _notEquals = (!Objects.equal(_expression, null));
    if (_notEquals) {
      format.append(close, XbaseFormatterPreferenceKeys.bracesInNewLine);
    }
    EList<XtendParameter> _parameters = func.getParameters();
    this.formatCommaSeparatedList(_parameters, open, close, format);
    JvmTypeReference _returnType_1 = func.getReturnType();
    this.format(_returnType_1, format);
    XExpression _expression_1 = func.getExpression();
    this.format(_expression_1, format);
  }
  
  protected void _format(final XtendField field, @Extension final IFormattableDocument document) {
    this.formatAnnotations(field, document, XbaseFormatterPreferenceKeys.newLineAfterFieldAnnotations);
    this.formatModifiers(field, document);
    String _name = field.getName();
    boolean _notEquals = (!Objects.equal(_name, null));
    if (_notEquals) {
      JvmTypeReference _type = field.getType();
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.<JvmTypeReference>append(_type, _function);
    }
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(field, "=");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    ISemanticRegion _prepend = document.prepend(_regionForKeyword, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_prepend, _function_2);
    JvmTypeReference _type_1 = field.getType();
    this.format(_type_1, document);
    XExpression _initialValue = field.getInitialValue();
    this.format(_initialValue, document);
  }
  
  protected void _format(final XtendParameter param, @Extension final IFormattableDocument format) {
    this.formatAnnotations(param, format, XbaseFormatterPreferenceKeys.newLineAfterParameterAnnotations);
    JvmTypeReference _parameterType = param.getParameterType();
    this.format(_parameterType, format);
    final ISemanticRegion nameNode = this.regionAccess.regionForFeature(param, XtendPackage.Literals.XTEND_PARAMETER__NAME);
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.prepend(nameNode, _function);
  }
  
  protected void _format(final RichString rs, @Extension final IFormattableDocument format) {
    FormatterRequest _request = this.getRequest();
    ITextRegionAccess _textRegionAccess = _request.getTextRegionAccess();
    final RichStringFormatter richStringFormatter = this.richStringFormatterFactory.create(_textRegionAccess);
    richStringFormatter.format(rs, format);
  }
  
  protected void _format(final AnonymousClass anonymousClass, @Extension final IFormattableDocument format) {
    XConstructorCall _constructorCall = anonymousClass.getConstructorCall();
    this.format(_constructorCall, format);
    this.formatBody(anonymousClass, format);
  }
  
  /**
   * Always put existing modifiers into this fixed order
   */
  protected ISemanticRegion formatModifiers(final XtendMember member, @Extension final IFormattableDocument document) {
    ISemanticRegion _xblockexpression = null;
    {
      ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(member, "public");
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword, _function);
      ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(member, "protected");
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword_1, _function_1);
      ISemanticRegion _regionForKeyword_2 = this.regionAccess.regionForKeyword(member, "package");
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword_2, _function_2);
      ISemanticRegion _regionForKeyword_3 = this.regionAccess.regionForKeyword(member, "private");
      final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword_3, _function_3);
      ISemanticRegion _regionForKeyword_4 = this.regionAccess.regionForKeyword(member, "abstract");
      final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword_4, _function_4);
      ISemanticRegion _regionForKeyword_5 = this.regionAccess.regionForKeyword(member, "static");
      final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword_5, _function_5);
      ISemanticRegion _regionForKeyword_6 = this.regionAccess.regionForKeyword(member, "final");
      final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword_6, _function_6);
      ISemanticRegion _regionForKeyword_7 = this.regionAccess.regionForKeyword(member, "extension");
      final Procedure1<IHiddenRegionFormatter> _function_7 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword_7, _function_7);
      ISemanticRegion _regionForKeyword_8 = this.regionAccess.regionForKeyword(member, "val");
      final Procedure1<IHiddenRegionFormatter> _function_8 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword_8, _function_8);
      ISemanticRegion _regionForKeyword_9 = this.regionAccess.regionForKeyword(member, "var");
      final Procedure1<IHiddenRegionFormatter> _function_9 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword_9, _function_9);
      ISemanticRegion _regionForKeyword_10 = this.regionAccess.regionForKeyword(member, "def");
      final Procedure1<IHiddenRegionFormatter> _function_10 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword_10, _function_10);
      ISemanticRegion _regionForKeyword_11 = this.regionAccess.regionForKeyword(member, "override");
      final Procedure1<IHiddenRegionFormatter> _function_11 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      _xblockexpression = document.append(_regionForKeyword_11, _function_11);
    }
    return _xblockexpression;
  }
  
  protected boolean isSingleLineBlock(final XBlockExpression expr) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    EList<XExpression> _expressions = expr.getExpressions();
    int _size = _expressions.size();
    boolean _lessEqualsThan = (_size <= 1);
    if (!_lessEqualsThan) {
      _and_2 = false;
    } else {
      ITypedPreferenceValues _preferences = this.getPreferences();
      Boolean _preference = _preferences.<Boolean>getPreference(XtendFormatterPreferenceKeys.keepOneLineMethods);
      _and_2 = (_preference).booleanValue();
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      EObject _eContainer = expr.eContainer();
      _and_1 = (_eContainer instanceof XtendFunction);
    }
    if (!_and_1) {
      _and = false;
    } else {
      IHiddenRegion _trailingHiddenRegion = this.regionAccess.trailingHiddenRegion(expr);
      ISemanticRegion _immediatelyPrecedingKeyword = this.regionAccess.immediatelyPrecedingKeyword(_trailingHiddenRegion, "}");
      IHiddenRegion _previousHiddenRegion = _immediatelyPrecedingKeyword.getPreviousHiddenRegion();
      boolean _isMultiline = _previousHiddenRegion.isMultiline();
      boolean _not = (!_isMultiline);
      _and = _not;
    }
    return _and;
  }
  
  protected XClosure builder(final List<XExpression> params) {
    XClosure _xifexpression = null;
    XExpression _last = IterableExtensions.<XExpression>last(params);
    boolean _notEquals = (!Objects.equal(_last, null));
    if (_notEquals) {
      XClosure _xblockexpression = null;
      {
        XExpression _last_1 = IterableExtensions.<XExpression>last(params);
        final AbstractElement grammarElement = this.regionAccess.getInvokingGrammarElement(_last_1);
        XClosure _xifexpression_1 = null;
        boolean _or = false;
        boolean _or_1 = false;
        XbaseGrammarAccess.XMemberFeatureCallElements _xMemberFeatureCallAccess = this._xtendGrammarAccess.getXMemberFeatureCallAccess();
        RuleCall _memberCallArgumentsXClosureParserRuleCall_1_1_4_0 = _xMemberFeatureCallAccess.getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0();
        boolean _equals = Objects.equal(grammarElement, _memberCallArgumentsXClosureParserRuleCall_1_1_4_0);
        if (_equals) {
          _or_1 = true;
        } else {
          XbaseGrammarAccess.XFeatureCallElements _xFeatureCallAccess = this._xtendGrammarAccess.getXFeatureCallAccess();
          RuleCall _featureCallArgumentsXClosureParserRuleCall_4_0 = _xFeatureCallAccess.getFeatureCallArgumentsXClosureParserRuleCall_4_0();
          boolean _equals_1 = Objects.equal(grammarElement, _featureCallArgumentsXClosureParserRuleCall_4_0);
          _or_1 = _equals_1;
        }
        if (_or_1) {
          _or = true;
        } else {
          XtendGrammarAccess.XbaseConstructorCallElements _xbaseConstructorCallAccess = this._xtendGrammarAccess.getXbaseConstructorCallAccess();
          RuleCall _argumentsXClosureParserRuleCall_5_0 = _xbaseConstructorCallAccess.getArgumentsXClosureParserRuleCall_5_0();
          boolean _equals_2 = Objects.equal(grammarElement, _argumentsXClosureParserRuleCall_5_0);
          _or = _equals_2;
        }
        if (_or) {
          XExpression _last_2 = IterableExtensions.<XExpression>last(params);
          _xifexpression_1 = ((XClosure) _last_2);
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
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
    } else if (anonymousClass instanceof XCatchClause) {
      _format((XCatchClause)anonymousClass, format);
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
