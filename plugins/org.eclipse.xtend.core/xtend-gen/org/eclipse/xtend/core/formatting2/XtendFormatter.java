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
import org.eclipse.xtext.ParserRule;
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
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionFinder;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
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
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
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
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    format.<XtendFile>prepend(xtendFile, _function);
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(xtendFile);
    final ISemanticRegion pkg = _regionFor.feature(XtendPackage.Literals.XTEND_FILE__PACKAGE);
    boolean _notEquals = (!Objects.equal(pkg, null));
    if (_notEquals) {
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      format.prepend(pkg, _function_1);
      ISemanticRegionFinder _immediatelyFollowing = pkg.immediatelyFollowing();
      final ISemanticRegion pkgSemicolon = _immediatelyFollowing.keyword(";");
      boolean _notEquals_1 = (!Objects.equal(pkgSemicolon, null));
      if (_notEquals_1) {
        final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
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
        EList<XtendTypeDeclaration> _xtendTypes_1 = xtendFile.getXtendTypes();
        XtendTypeDeclaration _last = IterableExtensions.<XtendTypeDeclaration>last(_xtendTypes_1);
        boolean _notEquals_2 = (!Objects.equal(clazz, _last));
        if (_notEquals_2) {
          format.<XtendTypeDeclaration>append(clazz, XtendFormatterPreferenceKeys.blankLinesBetweenClasses);
        }
      }
    }
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
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
        document.<XAnnotation>format(a);
        document.<XAnnotation>append(a, configKey);
      }
    }
  }
  
  protected void _format(final XtendClass clazz, @Extension final IFormattableDocument format) {
    this.formatAnnotations(clazz, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(clazz, format);
    EList<JvmTypeParameter> _typeParameters = clazz.getTypeParameters();
    this.formatTypeParameters(clazz, _typeParameters, format);
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(clazz);
    ISemanticRegion _keyword = _regionFor.keyword("class");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(clazz);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("extends");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.surround(_keyword_1, _function_1);
    JvmTypeReference _extends = clazz.getExtends();
    format.<JvmTypeReference>format(_extends);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(clazz);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("implements");
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.surround(_keyword_2, _function_2);
    EList<JvmTypeReference> _implements = clazz.getImplements();
    for (final JvmTypeReference imp : _implements) {
      {
        ISemanticRegionFinder _immediatelyFollowing = this.textRegionExtensions.immediatelyFollowing(imp);
        ISemanticRegion _keyword_3 = _immediatelyFollowing.keyword(",");
        final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        ISemanticRegion _prepend = format.prepend(_keyword_3, _function_3);
        final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        format.append(_prepend, _function_4);
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
        ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(member);
        ISemanticRegion _keyword = _regionFor.keyword("<");
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        format.surround(_keyword, _function);
        for (final JvmTypeParameter arg : typeParameters) {
          {
            format.<JvmTypeParameter>format(arg);
            ISemanticRegionFinder _immediatelyFollowing = this.textRegionExtensions.immediatelyFollowing(arg);
            ISemanticRegion _keyword_1 = _immediatelyFollowing.keyword(",");
            final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.noSpace();
              }
            };
            ISemanticRegion _prepend = format.prepend(_keyword_1, _function_1);
            final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.oneSpace();
              }
            };
            format.append(_prepend, _function_2);
          }
        }
        ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(member);
        ISemanticRegion _keyword_1 = _regionFor_1.keyword(">");
        final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        _xblockexpression = format.prepend(_keyword_1, _function_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected ISemanticRegion formatBody(final XtendTypeDeclaration type, @Extension final IFormattableDocument format) {
    ISemanticRegion _xblockexpression = null;
    {
      ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(type);
      final ISemanticRegion open = _regionFor.keyword("{");
      ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(type);
      final ISemanticRegion close = _regionFor_1.keyword("}");
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.indent();
        }
      };
      format.<ISemanticRegion, ISemanticRegion>interior(open, close, _function);
      format.prepend(open, XbaseFormatterPreferenceKeys.bracesInNewLine);
      ISemanticRegion _xifexpression = null;
      EList<XtendMember> _members = type.getMembers();
      boolean _isEmpty = _members.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        format.append(open, XtendFormatterPreferenceKeys.blankLinesBeforeFirstMember);
        EList<XtendMember> _members_1 = type.getMembers();
        int _size = _members_1.size();
        int _minus = (_size - 1);
        IntegerRange _upTo = new IntegerRange(0, _minus);
        for (final Integer i : _upTo) {
          {
            EList<XtendMember> _members_2 = type.getMembers();
            final XtendMember current = _members_2.get((i).intValue());
            format.<XtendMember>format(current);
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
              format.<XtendMember>append(member, XtendFormatterPreferenceKeys.blankLinesAfterLastMember);
            }
          }
        }
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.newLine();
          }
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
    EList<JvmTypeParameter> _typeParameters = interfaze.getTypeParameters();
    this.formatTypeParameters(interfaze, _typeParameters, format);
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(interfaze);
    ISemanticRegion _keyword = _regionFor.keyword("interface");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(interfaze);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("extends");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.surround(_keyword_1, _function_1);
    EList<JvmTypeReference> _extends = interfaze.getExtends();
    for (final JvmTypeReference imp : _extends) {
      {
        ISemanticRegionFinder _immediatelyFollowing = this.textRegionExtensions.immediatelyFollowing(imp);
        ISemanticRegion _keyword_2 = _immediatelyFollowing.keyword(",");
        final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        ISemanticRegion _prepend = format.prepend(_keyword_2, _function_2);
        final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        format.append(_prepend, _function_3);
        format.<JvmTypeReference>format(imp);
      }
    }
    this.formatBody(interfaze, format);
  }
  
  protected void _format(final XtendAnnotationType annotationType, @Extension final IFormattableDocument format) {
    this.formatAnnotations(annotationType, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(annotationType, format);
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(annotationType);
    ISemanticRegion _keyword = _regionFor.keyword("annotation");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_keyword, _function);
    this.formatBody(annotationType, format);
  }
  
  protected void _format(final XtendEnum enumeration, @Extension final IFormattableDocument format) {
    this.formatAnnotations(enumeration, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(enumeration, format);
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(enumeration);
    ISemanticRegion _keyword = _regionFor.keyword("enum");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(enumeration);
    final ISemanticRegion open = _regionFor_1.keyword("{");
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(enumeration);
    final ISemanticRegion close = _regionFor_2.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.indent();
      }
    };
    format.<ISemanticRegion, ISemanticRegion>interior(open, close, _function_1);
    format.prepend(open, XbaseFormatterPreferenceKeys.bracesInNewLine);
    EList<XtendMember> _members = enumeration.getMembers();
    boolean _isEmpty = _members.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      format.append(open, XtendFormatterPreferenceKeys.blankLinesBeforeFirstMember);
      EList<XtendMember> _members_1 = enumeration.getMembers();
      int _size = _members_1.size();
      int _minus = (_size - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      for (final Integer i : _upTo) {
        {
          EList<XtendMember> _members_2 = enumeration.getMembers();
          final XtendMember current = _members_2.get((i).intValue());
          format.<XtendMember>format(current);
          EList<XtendMember> _members_3 = enumeration.getMembers();
          int _size_1 = _members_3.size();
          int _minus_1 = (_size_1 - 1);
          boolean _lessThan = ((i).intValue() < _minus_1);
          if (_lessThan) {
            ISemanticRegionFinder _immediatelyFollowing = this.textRegionExtensions.immediatelyFollowing(current);
            ISemanticRegion _keyword_1 = _immediatelyFollowing.keyword(",");
            final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.noSpace();
              }
            };
            ISemanticRegion _prepend = format.prepend(_keyword_1, _function_2);
            format.append(_prepend, XtendFormatterPreferenceKeys.blankLinesBetweenEnumLiterals);
          } else {
            format.<XtendMember>append(current, XtendFormatterPreferenceKeys.blankLinesAfterLastMember);
          }
        }
      }
    } else {
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
        }
      };
      format.append(open, _function_2);
    }
  }
  
  protected void _format(final XtendConstructor func, @Extension final IFormattableDocument format) {
    this.formatAnnotations(func, format, XbaseFormatterPreferenceKeys.newLineAfterConstructorAnnotations);
    this.formatModifiers(func, format);
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(func);
    ISemanticRegion _keyword = _regionFor.keyword("new");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    format.append(_keyword, _function);
    EList<JvmTypeParameter> _typeParameters = func.getTypeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(func);
      ISemanticRegion _keyword_1 = _regionFor_1.keyword("<");
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      format.append(_keyword_1, _function_1);
      EList<JvmTypeParameter> _typeParameters_1 = func.getTypeParameters();
      for (final JvmTypeParameter arg : _typeParameters_1) {
        {
          format.<JvmTypeParameter>format(arg);
          ISemanticRegionFinder _immediatelyFollowing = this.textRegionExtensions.immediatelyFollowing(arg);
          ISemanticRegion _keyword_2 = _immediatelyFollowing.keyword(",");
          final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.noSpace();
            }
          };
          ISemanticRegion _prepend = format.prepend(_keyword_2, _function_2);
          final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.oneSpace();
            }
          };
          format.append(_prepend, _function_3);
        }
      }
      ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(func);
      ISemanticRegion _keyword_2 = _regionFor_2.keyword(">");
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      format.surround(_keyword_2, _function_2);
    }
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(func);
    final ISemanticRegion open = _regionFor_3.keyword("(");
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(func);
    final ISemanticRegion close = _regionFor_4.keyword(")");
    format.append(close, XbaseFormatterPreferenceKeys.bracesInNewLine);
    EList<XtendParameter> _parameters = func.getParameters();
    this.formatCommaSeparatedList(_parameters, open, close, format);
    XExpression _expression = func.getExpression();
    format.<XExpression>format(_expression);
  }
  
  protected void _format(final XtendFunction func, @Extension final IFormattableDocument format) {
    this.formatAnnotations(func, format, XbaseFormatterPreferenceKeys.newLineAfterMethodAnnotations);
    this.formatModifiers(func, format);
    EList<JvmTypeParameter> _typeParameters = func.getTypeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(func);
      ISemanticRegion _keyword = _regionFor.keyword("<");
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      format.append(_keyword, _function);
      EList<JvmTypeParameter> _typeParameters_1 = func.getTypeParameters();
      for (final JvmTypeParameter arg : _typeParameters_1) {
        {
          format.<JvmTypeParameter>format(arg);
          ISemanticRegionFinder _immediatelyFollowing = this.textRegionExtensions.immediatelyFollowing(arg);
          ISemanticRegion _keyword_1 = _immediatelyFollowing.keyword(",");
          final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.noSpace();
            }
          };
          ISemanticRegion _prepend = format.prepend(_keyword_1, _function_1);
          final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.oneSpace();
            }
          };
          format.append(_prepend, _function_2);
        }
      }
      ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(func);
      ISemanticRegion _keyword_1 = _regionFor_1.keyword(">");
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      ISemanticRegion _prepend = format.prepend(_keyword_1, _function_1);
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      format.append(_prepend, _function_2);
    }
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(func);
    final ISemanticRegion nameNode = _regionFor_2.feature(XtendPackage.Literals.XTEND_FUNCTION__NAME);
    ISemanticRegionFinder _immediatelyFollowing = null;
    if (nameNode!=null) {
      _immediatelyFollowing=nameNode.immediatelyFollowing();
    }
    ISemanticRegion _keyword_2 = null;
    if (_immediatelyFollowing!=null) {
      _keyword_2=_immediatelyFollowing.keyword("(");
    }
    final ISemanticRegion open = _keyword_2;
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(func);
    final ISemanticRegion close = _regionFor_3.keyword(")");
    JvmTypeReference _returnType = func.getReturnType();
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.<JvmTypeReference>append(_returnType, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
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
    format.<JvmTypeReference>format(_returnType_1);
    XExpression _expression_1 = func.getExpression();
    format.<XExpression>format(_expression_1);
  }
  
  protected void _format(final XtendField field, @Extension final IFormattableDocument document) {
    this.formatAnnotations(field, document, XbaseFormatterPreferenceKeys.newLineAfterFieldAnnotations);
    this.formatModifiers(field, document);
    String _name = field.getName();
    boolean _notEquals = (!Objects.equal(_name, null));
    if (_notEquals) {
      JvmTypeReference _type = field.getType();
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.<JvmTypeReference>append(_type, _function);
    }
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(field);
    ISemanticRegion _keyword = _regionFor.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    ISemanticRegion _prepend = document.prepend(_keyword, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_prepend, _function_2);
    JvmTypeReference _type_1 = field.getType();
    document.<JvmTypeReference>format(_type_1);
    XExpression _initialValue = field.getInitialValue();
    document.<XExpression>format(_initialValue);
  }
  
  protected void _format(final XtendParameter param, @Extension final IFormattableDocument format) {
    this.formatAnnotations(param, format, XbaseFormatterPreferenceKeys.newLineAfterParameterAnnotations);
    JvmTypeReference _parameterType = param.getParameterType();
    format.<JvmTypeReference>format(_parameterType);
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(param);
    final ISemanticRegion nameNode = _regionFor.feature(XtendPackage.Literals.XTEND_PARAMETER__NAME);
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
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
  protected void formatModifiers(final XtendMember member, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(member);
    ParserRule _commonModifierRule = this._xtendGrammarAccess.getCommonModifierRule();
    ParserRule _methodModifierRule = this._xtendGrammarAccess.getMethodModifierRule();
    ParserRule _fieldModifierRule = this._xtendGrammarAccess.getFieldModifierRule();
    List<ISemanticRegion> _ruleCallsTo = _regionFor.ruleCallsTo(_commonModifierRule, _methodModifierRule, _fieldModifierRule);
    for (final ISemanticRegion it : _ruleCallsTo) {
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(it, _function);
    }
  }
  
  @Override
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
      IHiddenRegion _nextHiddenRegion = this.textRegionExtensions.nextHiddenRegion(expr);
      ISemanticRegionFinder _immediatelyPreceding = _nextHiddenRegion.immediatelyPreceding();
      ISemanticRegion _keyword = _immediatelyPreceding.keyword("}");
      IHiddenRegion _previousHiddenRegion = _keyword.getPreviousHiddenRegion();
      boolean _isMultiline = _previousHiddenRegion.isMultiline();
      boolean _not = (!_isMultiline);
      _and = _not;
    }
    return _and;
  }
  
  @Override
  protected XClosure builder(final List<XExpression> params) {
    XClosure _xifexpression = null;
    XExpression _last = IterableExtensions.<XExpression>last(params);
    boolean _notEquals = (!Objects.equal(_last, null));
    if (_notEquals) {
      XClosure _xblockexpression = null;
      {
        XExpression _last_1 = IterableExtensions.<XExpression>last(params);
        final EObject grammarElement = this.textRegionExtensions.grammarElement(_last_1);
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
