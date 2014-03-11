/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.formatting.RichStringFormatter;
import org.eclipse.xtend.core.formatting.XtendFormatterPreferenceKeys;
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
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.preferences.PreferenceKey;
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
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.formatting.FormattableDocument;
import org.eclipse.xtext.xbase.formatting.FormattingData;
import org.eclipse.xtext.xbase.formatting.FormattingDataFactory;
import org.eclipse.xtext.xbase.formatting.FormattingDataInit;
import org.eclipse.xtext.xbase.formatting.HiddenLeafAccess;
import org.eclipse.xtext.xbase.formatting.HiddenLeafs;
import org.eclipse.xtext.xbase.formatting.NodeModelAccess;
import org.eclipse.xtext.xbase.formatting.XbaseFormatter2;
import org.eclipse.xtext.xbase.formatting.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public class XtendFormatter extends XbaseFormatter2 {
  @Inject
  @Extension
  private NodeModelAccess _nodeModelAccess;
  
  @Inject
  @Extension
  private HiddenLeafAccess _hiddenLeafAccess;
  
  @Inject
  @Extension
  private FormattingDataFactory _formattingDataFactory;
  
  @Inject
  private RichStringFormatter richStringFormatter;
  
  protected void _format(final XtendFile xtendFile, final FormattableDocument format) {
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(xtendFile);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForEObject, _function);
    format.operator_add(_prepend);
    final INode pkg = this._nodeModelAccess.nodeForFeature(xtendFile, XtendPackage.Literals.XTEND_FILE__PACKAGE);
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(pkg, _function_1);
    format.operator_add(_prepend_1);
    final ILeafNode pkgSemicolon = this._nodeModelAccess.immediatelyFollowingKeyword(pkg, ";");
    boolean _notEquals = (!Objects.equal(pkgSemicolon, null));
    if (_notEquals) {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.space = "";
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(pkg, _function_2);
      format.operator_add(_append);
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.cfg(XtendFormatterPreferenceKeys.blankLinesAfterPackageDecl);
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(pkgSemicolon, _function_3);
      format.operator_add(_append_1);
    } else {
      final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.cfg(XtendFormatterPreferenceKeys.blankLinesAfterPackageDecl);
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(pkg, _function_4);
      format.operator_add(_append_2);
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
          INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(clazz);
          final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.cfg(XtendFormatterPreferenceKeys.blankLinesBetweenClasses);
            }
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_nodeForEObject_1, _function_5);
          format.operator_add(_append_3);
        }
      }
    }
    INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(xtendFile);
    final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.newLine();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_nodeForEObject_1, _function_5);
    format.operator_add(_append_3);
  }
  
  protected void _format(final XImportSection section, final FormattableDocument format) {
    EList<XImportDeclaration> _importDeclarations = section.getImportDeclarations();
    for (final XImportDeclaration imp : _importDeclarations) {
      {
        this.format(imp, format);
        EList<XImportDeclaration> _importDeclarations_1 = section.getImportDeclarations();
        XImportDeclaration _last = IterableExtensions.<XImportDeclaration>last(_importDeclarations_1);
        boolean _notEquals = (!Objects.equal(imp, _last));
        if (_notEquals) {
          INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(imp);
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.cfg(XtendFormatterPreferenceKeys.blankLinesBetweenImports);
            }
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForEObject, _function);
          format.operator_add(_append);
        } else {
          INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(imp);
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.cfg(XtendFormatterPreferenceKeys.blankLinesAfterImports);
            }
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForEObject_1, _function_1);
          format.operator_add(_append_1);
        }
      }
    }
  }
  
  protected void formatAnnotations(final XtendAnnotationTarget target, final FormattableDocument document, final PreferenceKey configKey) {
    EList<XAnnotation> _annotations = target.getAnnotations();
    boolean _isEmpty = _annotations.isEmpty();
    if (_isEmpty) {
      return;
    }
    EList<XAnnotation> _annotations_1 = target.getAnnotations();
    for (final XAnnotation a : _annotations_1) {
      {
        this.format(a, document);
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(a);
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(configKey);
          }
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForEObject, _function);
        document.operator_add(_append);
      }
    }
  }
  
  protected void _format(final XImportDeclaration imp, final FormattableDocument document) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(imp, "import");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    document.operator_add(_append);
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(imp, XtypePackage.Literals.XIMPORT_DECLARATION__STATIC);
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForFeature, _function_1);
    document.operator_add(_append_1);
    INode _nodeForFeature_1 = this._nodeModelAccess.nodeForFeature(imp, XtypePackage.Literals.XIMPORT_DECLARATION__EXTENSION);
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(_nodeForFeature_1, _function_2);
    document.operator_add(_append_2);
    Iterable<ILeafNode> _nodesForKeyword = this._nodeModelAccess.nodesForKeyword(imp, ".");
    for (final ILeafNode node : _nodesForKeyword) {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(node, _function_3);
      document.operator_add(_surround);
    }
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(imp, ";");
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForKeyword_1, _function_4);
    document.operator_add(_prepend);
  }
  
  protected void _format(final XtendClass clazz, final FormattableDocument format) {
    this.formatAnnotations(clazz, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(clazz, format);
    EList<JvmTypeParameter> _typeParameters = clazz.getTypeParameters();
    this.formatTypeParameters(clazz, _typeParameters, format);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(clazz, "class");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(clazz, "extends");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword_1, _function_1);
    format.operator_add(_surround);
    JvmTypeReference _extends = clazz.getExtends();
    this.format(_extends, format);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(clazz, "implements");
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(_nodeForKeyword_2, _function_2);
    format.operator_add(_surround_1);
    EList<JvmTypeReference> _implements = clazz.getImplements();
    for (final JvmTypeReference imp : _implements) {
      {
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(imp);
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
        final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
        final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.oneSpace();
          }
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_2 = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_3, _function_4);
        format.operator_add(_surround_2);
        this.format(imp, format);
      }
    }
    this.formatBody(clazz, format);
  }
  
  protected void formatTypeParameters(final XtendMember member, final List<? extends JvmTypeParameter> typeParameters, final FormattableDocument format) {
    boolean _isEmpty = typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(member, "<");
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword, _function);
      format.operator_add(_surround);
      for (final JvmTypeParameter arg : typeParameters) {
        {
          this.format(arg, format);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(arg, ",");
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_1, _function_2);
          format.operator_add(_surround_1);
        }
      }
      ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(member, ">");
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForKeyword_1, _function_1);
      format.operator_add(_prepend);
    }
  }
  
  protected void formatBody(final XtendTypeDeclaration type, final FormattableDocument format) {
    final ILeafNode clazzOpenBrace = this._nodeModelAccess.nodeForKeyword(type, "{");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(clazzOpenBrace, _function);
    format.operator_add(_prepend);
    EList<XtendMember> _members = type.getMembers();
    boolean _isEmpty = _members.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.increaseIndentation();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(clazzOpenBrace, _function_1);
      format.operator_add(_append);
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.cfg(XtendFormatterPreferenceKeys.blankLinesBeforeFirstMember);
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(clazzOpenBrace, _function_2);
      format.operator_add(_append_1);
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
              INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(current);
              final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.cfg(XtendFormatterPreferenceKeys.blankLinesBetweenFields);
                }
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(_nodeForEObject, _function_3);
              format.operator_add(_append_2);
            } else {
              boolean _and_1 = false;
              if (!(current instanceof XtendFunction)) {
                _and_1 = false;
              } else {
                _and_1 = (next instanceof XtendFunction);
              }
              if (_and_1) {
                INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(current);
                final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.cfg(XtendFormatterPreferenceKeys.blankLinesBetweenMethods);
                  }
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_nodeForEObject_1, _function_4);
                format.operator_add(_append_3);
              } else {
                INode _nodeForEObject_2 = this._nodeModelAccess.nodeForEObject(current);
                final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.cfg(XtendFormatterPreferenceKeys.blankLinesBetweenFieldsAndMethods);
                  }
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(_nodeForEObject_2, _function_5);
                format.operator_add(_append_4);
              }
            }
          } else {
            EList<XtendMember> _members_5 = type.getMembers();
            XtendMember _get = _members_5.get((i).intValue());
            final INode node = this._nodeModelAccess.nodeForEObject(_get);
            final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.decreaseIndentation();
              }
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_5 = this._formattingDataFactory.append(node, _function_6);
            format.operator_add(_append_5);
            final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.cfg(XtendFormatterPreferenceKeys.blankLinesAfterLastMember);
              }
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_6 = this._formattingDataFactory.append(node, _function_7);
            format.operator_add(_append_6);
          }
        }
      }
    } else {
      HiddenLeafs _hiddenLeafsAfter = this._hiddenLeafAccess.getHiddenLeafsAfter(clazzOpenBrace);
      boolean _containsComment = _hiddenLeafsAfter.containsComment();
      if (_containsComment) {
        final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
            it.decreaseIndentation();
          }
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(clazzOpenBrace, _function_3);
        format.operator_add(_append_2);
      } else {
        final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
          }
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(clazzOpenBrace, _function_4);
        format.operator_add(_append_3);
      }
    }
  }
  
  protected void _format(final XtendInterface interfaze, final FormattableDocument format) {
    this.formatAnnotations(interfaze, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(interfaze, format);
    EList<JvmTypeParameter> _typeParameters = interfaze.getTypeParameters();
    this.formatTypeParameters(interfaze, _typeParameters, format);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(interfaze, "interface");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(interfaze, "extends");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword_1, _function_1);
    format.operator_add(_surround);
    EList<JvmTypeReference> _extends = interfaze.getExtends();
    for (final JvmTypeReference imp : _extends) {
      {
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(imp);
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
        final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
        final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.oneSpace();
          }
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_2, _function_3);
        format.operator_add(_surround_1);
        this.format(imp, format);
      }
    }
    this.formatBody(interfaze, format);
  }
  
  protected void _format(final XtendAnnotationType annotationType, final FormattableDocument format) {
    this.formatAnnotations(annotationType, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(annotationType, format);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(annotationType, "annotation");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    this.formatBody(annotationType, format);
  }
  
  protected void _format(final XtendEnum enumeration, final FormattableDocument format) {
    this.formatAnnotations(enumeration, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    this.formatModifiers(enumeration, format);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(enumeration, "enum");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    final ILeafNode clazzOpenBrace = this._nodeModelAccess.nodeForKeyword(enumeration, "{");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(clazzOpenBrace, _function_1);
    format.operator_add(_prepend);
    EList<XtendMember> _members = enumeration.getMembers();
    boolean _isEmpty = _members.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.increaseIndentation();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(clazzOpenBrace, _function_2);
      format.operator_add(_append_1);
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.cfg(XtendFormatterPreferenceKeys.blankLinesBeforeFirstMember);
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(clazzOpenBrace, _function_3);
      format.operator_add(_append_2);
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
            INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(current);
            ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
            final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
            final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.cfg(XtendFormatterPreferenceKeys.blankLinesBetweenEnumLiterals);
              }
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_4, _function_5);
            format.operator_add(_surround);
          } else {
            final INode node = this._nodeModelAccess.nodeForEObject(current);
            final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.decreaseIndentation();
              }
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(node, _function_6);
            format.operator_add(_append_3);
            final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.cfg(XtendFormatterPreferenceKeys.blankLinesAfterLastMember);
              }
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(node, _function_7);
            format.operator_add(_append_4);
          }
        }
      }
    } else {
      final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.newLine();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(clazzOpenBrace, _function_4);
      format.operator_add(_append_3);
    }
  }
  
  protected void _format(final XtendConstructor func, final FormattableDocument format) {
    this.formatAnnotations(func, format, XbaseFormatterPreferenceKeys.newLineAfterConstructorAnnotations);
    this.formatModifiers(func, format);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(func, "new");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    EList<JvmTypeParameter> _typeParameters = func.getTypeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(func, "<");
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForKeyword_1, _function_1);
      format.operator_add(_append_1);
      EList<JvmTypeParameter> _typeParameters_1 = func.getTypeParameters();
      for (final JvmTypeParameter arg : _typeParameters_1) {
        {
          this.format(arg, format);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(arg, ",");
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
          final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_2, _function_3);
          format.operator_add(_surround);
        }
      }
      ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(func, ">");
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword_2, _function_2);
      format.operator_add(_surround);
    }
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(func, "(");
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(func, ")");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(close, _function_3);
    format.operator_add(_append_2);
    EList<XtendParameter> _parameters = func.getParameters();
    this.formatCommaSeparatedList(_parameters, open, close, format);
    XExpression _expression = func.getExpression();
    this.format(_expression, format);
  }
  
  protected void _format(final XtendFunction func, final FormattableDocument format) {
    this.formatAnnotations(func, format, XbaseFormatterPreferenceKeys.newLineAfterMethodAnnotations);
    this.formatModifiers(func, format);
    EList<JvmTypeParameter> _typeParameters = func.getTypeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(func, "<");
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
      format.operator_add(_append);
      EList<JvmTypeParameter> _typeParameters_1 = func.getTypeParameters();
      for (final JvmTypeParameter arg : _typeParameters_1) {
        {
          this.format(arg, format);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(arg, ",");
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_1, _function_2);
          format.operator_add(_surround);
        }
      }
      ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(func, ">");
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword_1, _function_1, _function_2);
      format.operator_add(_surround);
    }
    final INode nameNode = this._nodeModelAccess.nodeForFeature(func, XtendPackage.Literals.XTEND_FUNCTION__NAME);
    final ILeafNode open = this._nodeModelAccess.immediatelyFollowingKeyword(nameNode, "(");
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(func, ")");
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(func, XtendPackage.Literals.XTEND_FUNCTION__RETURN_TYPE);
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForFeature, _function_3);
    format.operator_add(_append_1);
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(open, _function_4);
    format.operator_add(_prepend);
    XExpression _expression = func.getExpression();
    boolean _notEquals = (!Objects.equal(_expression, null));
    if (_notEquals) {
      final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(close, _function_5);
      format.operator_add(_append_2);
    }
    EList<XtendParameter> _parameters = func.getParameters();
    this.formatCommaSeparatedList(_parameters, open, close, format);
    JvmTypeReference _returnType = func.getReturnType();
    this.format(_returnType, format);
    XExpression _expression_1 = func.getExpression();
    this.format(_expression_1, format);
  }
  
  protected void _format(final XtendField field, final FormattableDocument document) {
    this.formatAnnotations(field, document, XbaseFormatterPreferenceKeys.newLineAfterFieldAnnotations);
    this.formatModifiers(field, document);
    String _name = field.getName();
    boolean _notEquals = (!Objects.equal(_name, null));
    if (_notEquals) {
      INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(field, XtendPackage.Literals.XTEND_FIELD__TYPE);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForFeature, _function);
      document.operator_add(_append);
    }
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(field, "=");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword, _function_1, _function_2);
    document.operator_add(_surround);
    JvmTypeReference _type = field.getType();
    this.format(_type, document);
    XExpression _initialValue = field.getInitialValue();
    this.format(_initialValue, document);
  }
  
  protected void _format(final XtendParameter param, final FormattableDocument format) {
    this.formatAnnotations(param, format, XbaseFormatterPreferenceKeys.newLineAfterParameterAnnotations);
    JvmTypeReference _parameterType = param.getParameterType();
    this.format(_parameterType, format);
    final INode nameNode = this._nodeModelAccess.nodeForFeature(param, XtendPackage.Literals.XTEND_PARAMETER__NAME);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(nameNode, _function);
    format.operator_add(_prepend);
  }
  
  protected void _format(final RichString rs, final FormattableDocument format) {
    final Procedure2<EObject, FormattableDocument> _function = new Procedure2<EObject, FormattableDocument>() {
      public void apply(final EObject obj, final FormattableDocument doc) {
        XtendFormatter.this.format(obj, doc);
      }
    };
    final Procedure2<? super EObject, ? super FormattableDocument> callback = _function;
    this.richStringFormatter.format(callback, format, rs);
  }
  
  /**
   * Always put existing modifiers into this fixed order
   */
  protected void formatModifiers(final XtendMember member, final FormattableDocument document) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(member, "public");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    document.operator_add(_append);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(member, "protected");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForKeyword_1, _function_1);
    document.operator_add(_append_1);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(member, "package");
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(_nodeForKeyword_2, _function_2);
    document.operator_add(_append_2);
    ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(member, "private");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_nodeForKeyword_3, _function_3);
    document.operator_add(_append_3);
    ILeafNode _nodeForKeyword_4 = this._nodeModelAccess.nodeForKeyword(member, "abstract");
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(_nodeForKeyword_4, _function_4);
    document.operator_add(_append_4);
    ILeafNode _nodeForKeyword_5 = this._nodeModelAccess.nodeForKeyword(member, "static");
    final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_5 = this._formattingDataFactory.append(_nodeForKeyword_5, _function_5);
    document.operator_add(_append_5);
    ILeafNode _nodeForKeyword_6 = this._nodeModelAccess.nodeForKeyword(member, "final");
    final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_6 = this._formattingDataFactory.append(_nodeForKeyword_6, _function_6);
    document.operator_add(_append_6);
    ILeafNode _nodeForKeyword_7 = this._nodeModelAccess.nodeForKeyword(member, "extension");
    final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_7 = this._formattingDataFactory.append(_nodeForKeyword_7, _function_7);
    document.operator_add(_append_7);
    ILeafNode _nodeForKeyword_8 = this._nodeModelAccess.nodeForKeyword(member, "val");
    final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_8 = this._formattingDataFactory.append(_nodeForKeyword_8, _function_8);
    document.operator_add(_append_8);
    ILeafNode _nodeForKeyword_9 = this._nodeModelAccess.nodeForKeyword(member, "var");
    final Procedure1<FormattingDataInit> _function_9 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_9 = this._formattingDataFactory.append(_nodeForKeyword_9, _function_9);
    document.operator_add(_append_9);
    ILeafNode _nodeForKeyword_10 = this._nodeModelAccess.nodeForKeyword(member, "def");
    final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_10 = this._formattingDataFactory.append(_nodeForKeyword_10, _function_10);
    document.operator_add(_append_10);
    ILeafNode _nodeForKeyword_11 = this._nodeModelAccess.nodeForKeyword(member, "override");
    final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_11 = this._formattingDataFactory.append(_nodeForKeyword_11, _function_11);
    document.operator_add(_append_11);
  }
  
  protected void format(final EObject annotationType, final FormattableDocument format) {
    if (annotationType instanceof XtendAnnotationType) {
      _format((XtendAnnotationType)annotationType, format);
      return;
    } else if (annotationType instanceof XtendClass) {
      _format((XtendClass)annotationType, format);
      return;
    } else if (annotationType instanceof XtendConstructor) {
      _format((XtendConstructor)annotationType, format);
      return;
    } else if (annotationType instanceof XtendEnum) {
      _format((XtendEnum)annotationType, format);
      return;
    } else if (annotationType instanceof XtendFunction) {
      _format((XtendFunction)annotationType, format);
      return;
    } else if (annotationType instanceof XtendInterface) {
      _format((XtendInterface)annotationType, format);
      return;
    } else if (annotationType instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)annotationType, format);
      return;
    } else if (annotationType instanceof RichString) {
      _format((RichString)annotationType, format);
      return;
    } else if (annotationType instanceof XtendField) {
      _format((XtendField)annotationType, format);
      return;
    } else if (annotationType instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)annotationType, format);
      return;
    } else if (annotationType instanceof XAssignment) {
      _format((XAssignment)annotationType, format);
      return;
    } else if (annotationType instanceof XBinaryOperation) {
      _format((XBinaryOperation)annotationType, format);
      return;
    } else if (annotationType instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)annotationType, format);
      return;
    } else if (annotationType instanceof XFeatureCall) {
      _format((XFeatureCall)annotationType, format);
      return;
    } else if (annotationType instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)annotationType, format);
      return;
    } else if (annotationType instanceof XWhileExpression) {
      _format((XWhileExpression)annotationType, format);
      return;
    } else if (annotationType instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)annotationType, format);
      return;
    } else if (annotationType instanceof XtendParameter) {
      _format((XtendParameter)annotationType, format);
      return;
    } else if (annotationType instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)annotationType, format);
      return;
    } else if (annotationType instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)annotationType, format);
      return;
    } else if (annotationType instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)annotationType, format);
      return;
    } else if (annotationType instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)annotationType, format);
      return;
    } else if (annotationType instanceof XBlockExpression) {
      _format((XBlockExpression)annotationType, format);
      return;
    } else if (annotationType instanceof XClosure) {
      _format((XClosure)annotationType, format);
      return;
    } else if (annotationType instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)annotationType, format);
      return;
    } else if (annotationType instanceof XConstructorCall) {
      _format((XConstructorCall)annotationType, format);
      return;
    } else if (annotationType instanceof XForLoopExpression) {
      _format((XForLoopExpression)annotationType, format);
      return;
    } else if (annotationType instanceof XIfExpression) {
      _format((XIfExpression)annotationType, format);
      return;
    } else if (annotationType instanceof XReturnExpression) {
      _format((XReturnExpression)annotationType, format);
      return;
    } else if (annotationType instanceof XSwitchExpression) {
      _format((XSwitchExpression)annotationType, format);
      return;
    } else if (annotationType instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)annotationType, format);
      return;
    } else if (annotationType instanceof XThrowExpression) {
      _format((XThrowExpression)annotationType, format);
      return;
    } else if (annotationType instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)annotationType, format);
      return;
    } else if (annotationType instanceof XTypeLiteral) {
      _format((XTypeLiteral)annotationType, format);
      return;
    } else if (annotationType instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)annotationType, format);
      return;
    } else if (annotationType instanceof XAnnotation) {
      _format((XAnnotation)annotationType, format);
      return;
    } else if (annotationType instanceof XtendFile) {
      _format((XtendFile)annotationType, format);
      return;
    } else if (annotationType instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)annotationType, format);
      return;
    } else if (annotationType instanceof XCatchClause) {
      _format((XCatchClause)annotationType, format);
      return;
    } else if (annotationType instanceof XExpression) {
      _format((XExpression)annotationType, format);
      return;
    } else if (annotationType instanceof XImportDeclaration) {
      _format((XImportDeclaration)annotationType, format);
      return;
    } else if (annotationType instanceof XImportSection) {
      _format((XImportSection)annotationType, format);
      return;
    } else if (annotationType != null) {
      _format(annotationType, format);
      return;
    } else if (annotationType == null) {
      _format((Void)null, format);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(annotationType, format).toString());
    }
  }
}
