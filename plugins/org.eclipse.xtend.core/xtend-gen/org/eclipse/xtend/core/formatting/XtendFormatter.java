/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.formatting;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.formatting.RichStringFormatter;
import org.eclipse.xtend.core.formatting.XtendFormatterPreferenceKeys;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage.Literals;
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
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray;
import org.eclipse.xtext.xbase.formatting.FormattableDocument;
import org.eclipse.xtext.xbase.formatting.FormattingData;
import org.eclipse.xtext.xbase.formatting.FormattingDataFactory;
import org.eclipse.xtext.xbase.formatting.FormattingDataInit;
import org.eclipse.xtext.xbase.formatting.HiddenLeafAccess;
import org.eclipse.xtext.xbase.formatting.HiddenLeafs;
import org.eclipse.xtext.xbase.formatting.NodeModelAccess;
import org.eclipse.xtext.xbase.formatting.XbaseFormatter2;
import org.eclipse.xtext.xbase.formatting.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

@SuppressWarnings("all")
public class XtendFormatter extends XbaseFormatter2 {
  @Inject
  private NodeModelAccess _nodeModelAccess;
  
  @Inject
  private HiddenLeafAccess _hiddenLeafAccess;
  
  @Inject
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
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForEObject, _function);
    format.operator_add(_prepend);
    final INode pkg = this._nodeModelAccess.nodeForFeature(xtendFile, Literals.XTEND_FILE__PACKAGE);
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(pkg, _function_1);
    format.operator_add(_prepend_1);
    final ILeafNode pkgSemicolon = this._nodeModelAccess.immediatelyFollowingKeyword(pkg, ";");
    boolean _notEquals = ObjectExtensions.operator_notEquals(pkgSemicolon, null);
    if (_notEquals) {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = "";
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(pkg, _function_2);
      format.operator_add(_append);
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XtendFormatterPreferenceKeys.blankLinesAfterPackageDecl);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(pkgSemicolon, _function_3);
      format.operator_add(_append_1);
    } else {
      final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XtendFormatterPreferenceKeys.blankLinesAfterPackageDecl);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(pkg, _function_4);
      format.operator_add(_append_2);
    }
    XImportSection _importSection = xtendFile.getImportSection();
    if (_importSection!=null) this.format(_importSection, format);
    EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
    for (final XtendTypeDeclaration clazz : _xtendTypes) {
      {
        this.format(clazz, format);
        EList<XtendTypeDeclaration> _xtendTypes_1 = xtendFile.getXtendTypes();
        XtendTypeDeclaration _last = IterableExtensions.<XtendTypeDeclaration>last(_xtendTypes_1);
        boolean _notEquals_1 = ObjectExtensions.operator_notEquals(clazz, _last);
        if (_notEquals_1) {
          INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(clazz);
          final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.cfg(XtendFormatterPreferenceKeys.blankLinesBetweenClasses);
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_nodeForEObject_1, _function_5);
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
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_nodeForEObject_1, _function_5);
    format.operator_add(_append_3);
  }
  
  protected void _format(final XImportSection section, final FormattableDocument format) {
    EList<XImportDeclaration> _importDeclarations = section.getImportDeclarations();
    for (final XImportDeclaration imp : _importDeclarations) {
      {
        this.format(imp, format);
        EList<XImportDeclaration> _importDeclarations_1 = section.getImportDeclarations();
        XImportDeclaration _last = IterableExtensions.<XImportDeclaration>last(_importDeclarations_1);
        boolean _notEquals = ObjectExtensions.operator_notEquals(imp, _last);
        if (_notEquals) {
          INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(imp);
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.cfg(XtendFormatterPreferenceKeys.blankLinesBetweenImports);
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForEObject, _function);
          format.operator_add(_append);
        } else {
          INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(imp);
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.cfg(XtendFormatterPreferenceKeys.blankLinesAfterImports);
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForEObject_1, _function_1);
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
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForEObject, _function);
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
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    document.operator_add(_append);
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(imp, org.eclipse.xtext.xtype.XtypePackage.Literals.XIMPORT_DECLARATION__STATIC);
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForFeature, _function_1);
    document.operator_add(_append_1);
    INode _nodeForFeature_1 = this._nodeModelAccess.nodeForFeature(imp, org.eclipse.xtext.xtype.XtypePackage.Literals.XIMPORT_DECLARATION__EXTENSION);
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(_nodeForFeature_1, _function_2);
    document.operator_add(_append_2);
    Iterable<ILeafNode> _nodesForKeyword = this._nodeModelAccess.nodesForKeyword(imp, ".");
    for (final ILeafNode node : _nodesForKeyword) {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(node, _function_3);
      document.operator_add(_surround);
    }
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(imp, ";");
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForKeyword_1, _function_4);
    document.operator_add(_prepend);
  }
  
  protected void _format(final XtendClass clazz, final FormattableDocument format) {
    this.formatAnnotations(clazz, format, XbaseFormatterPreferenceKeys.newLineAfterClassAnnotations);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(clazz, "public");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(clazz, "abstract");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForKeyword_1, _function_1);
    format.operator_add(_append_1);
    EList<JvmTypeParameter> _typeParameters = clazz.getTypeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(clazz, "<");
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword_2, _function_2);
      format.operator_add(_surround);
      EList<JvmTypeParameter> _typeParameters_1 = clazz.getTypeParameters();
      for (final JvmTypeParameter arg : _typeParameters_1) {
        {
          this.format(arg, format);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(arg, ",");
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
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_3, _function_4);
          format.operator_add(_surround_1);
        }
      }
      ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(clazz, ">");
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForKeyword_3, _function_3);
      format.operator_add(_prepend);
    }
    ILeafNode _nodeForKeyword_4 = this._nodeModelAccess.nodeForKeyword(clazz, "class");
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(_nodeForKeyword_4, _function_4);
    format.operator_add(_append_2);
    ILeafNode _nodeForKeyword_5 = this._nodeModelAccess.nodeForKeyword(clazz, "extends");
    final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(_nodeForKeyword_5, _function_5);
    format.operator_add(_surround_1);
    JvmTypeReference _extends = clazz.getExtends();
    this.format(_extends, format);
    ILeafNode _nodeForKeyword_6 = this._nodeModelAccess.nodeForKeyword(clazz, "implements");
    final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_2 = this._formattingDataFactory.surround(_nodeForKeyword_6, _function_6);
    format.operator_add(_surround_2);
    EList<JvmTypeReference> _implements = clazz.getImplements();
    for (final JvmTypeReference imp : _implements) {
      {
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(imp);
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
        final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_3 = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_7, _function_8);
        format.operator_add(_surround_3);
        this.format(imp, format);
      }
    }
    final ILeafNode clazzOpenBrace = this._nodeModelAccess.nodeForKeyword(clazz, "{");
    final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(clazzOpenBrace, _function_7);
    format.operator_add(_prepend_1);
    EList<XtendMember> _members = clazz.getMembers();
    boolean _isEmpty_1 = _members.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(clazzOpenBrace, _function_8);
      format.operator_add(_append_3);
      final Procedure1<FormattingDataInit> _function_9 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XtendFormatterPreferenceKeys.blankLinesBeforeFirstMember);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(clazzOpenBrace, _function_9);
      format.operator_add(_append_4);
      EList<XtendMember> _members_1 = clazz.getMembers();
      int _size = _members_1.size();
      int _minus = (_size - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      for (final Integer i : _upTo) {
        {
          EList<XtendMember> _members_2 = clazz.getMembers();
          final XtendMember current = _members_2.get((i).intValue());
          this.format(current, format);
          EList<XtendMember> _members_3 = clazz.getMembers();
          int _size_1 = _members_3.size();
          int _minus_1 = (_size_1 - 1);
          boolean _lessThan = ((i).intValue() < _minus_1);
          if (_lessThan) {
            EList<XtendMember> _members_4 = clazz.getMembers();
            int _plus = ((i).intValue() + 1);
            final XtendMember next = _members_4.get(_plus);
            boolean _and = false;
            if (!(current instanceof XtendField)) {
              _and = false;
            } else {
              _and = ((current instanceof XtendField) && (next instanceof XtendField));
            }
            if (_and) {
              INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(current);
              final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.cfg(XtendFormatterPreferenceKeys.blankLinesBetweenFields);
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_5 = this._formattingDataFactory.append(_nodeForEObject, _function_10);
              format.operator_add(_append_5);
            } else {
              boolean _and_1 = false;
              if (!(current instanceof XtendFunction)) {
                _and_1 = false;
              } else {
                _and_1 = ((current instanceof XtendFunction) && (next instanceof XtendFunction));
              }
              if (_and_1) {
                INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(current);
                final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.cfg(XtendFormatterPreferenceKeys.blankLinesBetweenMethods);
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_6 = this._formattingDataFactory.append(_nodeForEObject_1, _function_11);
                format.operator_add(_append_6);
              } else {
                INode _nodeForEObject_2 = this._nodeModelAccess.nodeForEObject(current);
                final Procedure1<FormattingDataInit> _function_12 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.cfg(XtendFormatterPreferenceKeys.blankLinesBetweenFieldsAndMethods);
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_7 = this._formattingDataFactory.append(_nodeForEObject_2, _function_12);
                format.operator_add(_append_7);
              }
            }
          } else {
            EList<XtendMember> _members_5 = clazz.getMembers();
            XtendMember _get = _members_5.get((i).intValue());
            final INode node = this._nodeModelAccess.nodeForEObject(_get);
            final Procedure1<FormattingDataInit> _function_13 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.decreaseIndentation();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_8 = this._formattingDataFactory.append(node, _function_13);
            format.operator_add(_append_8);
            final Procedure1<FormattingDataInit> _function_14 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.cfg(XtendFormatterPreferenceKeys.blankLinesAfterLastMember);
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_9 = this._formattingDataFactory.append(node, _function_14);
            format.operator_add(_append_9);
          }
        }
      }
    } else {
      final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_5 = this._formattingDataFactory.append(clazzOpenBrace, _function_10);
      format.operator_add(_append_5);
    }
  }
  
  protected void _format(final XtendConstructor func, final FormattableDocument format) {
    this.formatAnnotations(func, format, XbaseFormatterPreferenceKeys.newLineAfterConstructorAnnotations);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(func, "new");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
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
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForKeyword_1, _function_1);
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
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_2, _function_3);
          format.operator_add(_surround);
        }
      }
      ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(func, ">");
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword_2, _function_2);
      format.operator_add(_surround);
    }
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(func, "(");
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(func, ")");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(close, _function_3);
    format.operator_add(_append_2);
    EList<XtendParameter> _parameters = func.getParameters();
    this.formatMemberParameter(_parameters, open, close, format);
    XExpression _expression = func.getExpression();
    this.format(_expression, format);
  }
  
  protected void formatMemberParameter(final Collection<XtendParameter> parameters, final INode open, final INode close, final FormattableDocument format) {
    HiddenLeafs _hiddenLeafsBefore = close==null?(HiddenLeafs)null:this._hiddenLeafAccess.getHiddenLeafsBefore(close);
    int _newLines = _hiddenLeafsBefore==null?0:_hiddenLeafsBefore.getNewLines();
    boolean _greaterThan = (_newLines > 0);
    if (_greaterThan) {
      INode comma = null;
      boolean _isEmpty = parameters.isEmpty();
      if (_isEmpty) {
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function);
        format.operator_add(_append);
      } else {
        for (final XtendParameter param : parameters) {
          {
            XtendParameter _head = IterableExtensions.<XtendParameter>head(parameters);
            boolean _equals = ObjectExtensions.operator_equals(param, _head);
            if (_equals) {
              final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                    it.increaseIndentation();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(open, _function_1);
              format.operator_add(_append_1);
            } else {
              boolean _notEquals = ObjectExtensions.operator_notEquals(comma, null);
              if (_notEquals) {
                final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(comma, _function_2);
                format.operator_add(_append_2);
              }
            }
            XtendParameter _last = IterableExtensions.<XtendParameter>last(parameters);
            boolean _equals_1 = ObjectExtensions.operator_equals(param, _last);
            if (_equals_1) {
              INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(param);
              final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                    it.decreaseIndentation();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_nodeForEObject, _function_3);
              format.operator_add(_append_3);
            }
            this.format(param, format);
            INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(param);
            ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject_1, ",");
            comma = _immediatelyFollowingKeyword;
            final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(comma, _function_4);
            format.operator_add(_prepend);
          }
        }
      }
    } else {
      INode comma_1 = null;
      boolean indented = false;
      for (final XtendParameter param_1 : parameters) {
        {
          boolean _fitsIntoLine = this.fitsIntoLine(format, param_1);
          if (_fitsIntoLine) {
            boolean _equals = ObjectExtensions.operator_equals(comma_1, null);
            if (_equals) {
              final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.noSpace();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(open, _function_1);
              format.operator_add(_append_1);
            } else {
              final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.oneSpace();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(comma_1, _function_2);
              format.operator_add(_append_2);
            }
          } else {
            INode _xifexpression = null;
            boolean _equals_1 = ObjectExtensions.operator_equals(comma_1, null);
            if (_equals_1) {
              _xifexpression = open;
            } else {
              _xifexpression = comma_1;
            }
            final INode n = _xifexpression;
            final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(n, _function_3);
            format.operator_add(_append_3);
            boolean _not = (!indented);
            if (_not) {
              final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.increaseIndentation();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(n, _function_4);
              format.operator_add(_append_4);
            }
            indented = true;
          }
          this.format(param_1, format);
          INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(param_1);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
          comma_1 = _immediatelyFollowingKeyword;
          final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(comma_1, _function_5);
          format.operator_add(_prepend);
        }
      }
      int _size = parameters.size();
      boolean _greaterThan_1 = (_size > 0);
      if (_greaterThan_1) {
        XtendParameter _last = IterableExtensions.<XtendParameter>last(parameters);
        final INode last = this._nodeModelAccess.nodeForEObject(_last);
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(last, _function_1);
        format.operator_add(_append_1);
        if (indented) {
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.decreaseIndentation();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(last, _function_2);
          format.operator_add(_append_2);
        }
      } else {
        final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(open, _function_3);
        format.operator_add(_append_3);
      }
    }
  }
  
  protected void _format(final XtendFunction func, final FormattableDocument format) {
    this.formatAnnotations(func, format, XbaseFormatterPreferenceKeys.newLineAfterMethodAnnotations);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(func, "def");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
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
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForKeyword_1, _function_1);
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
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_2, _function_3);
          format.operator_add(_surround);
        }
      }
      ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(func, ">");
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
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword_2, _function_2, _function_3);
      format.operator_add(_surround);
    }
    final INode nameNode = this._nodeModelAccess.nodeForFeature(func, Literals.XTEND_FUNCTION__NAME);
    final ILeafNode open = this._nodeModelAccess.immediatelyFollowingKeyword(nameNode, "(");
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(func, ")");
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(func, Literals.XTEND_FUNCTION__RETURN_TYPE);
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(_nodeForFeature, _function_4);
    format.operator_add(_append_2);
    final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(open, _function_5);
    format.operator_add(_prepend);
    XExpression _expression = func.getExpression();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_expression, null);
    if (_notEquals) {
      final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(close, _function_6);
      format.operator_add(_append_3);
    }
    EList<XtendParameter> _parameters = func.getParameters();
    this.formatMemberParameter(_parameters, open, close, format);
    JvmTypeReference _returnType = func.getReturnType();
    this.format(_returnType, format);
    XExpression _expression_1 = func.getExpression();
    this.format(_expression_1, format);
  }
  
  protected void _format(final XtendField field, final FormattableDocument document) {
    this.formatAnnotations(field, document, XbaseFormatterPreferenceKeys.newLineAfterFieldAnnotations);
    String _name = field.getName();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_name, null);
    if (_notEquals) {
      INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(field, Literals.XTEND_FIELD__TYPE);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.oneSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForFeature, _function);
      document.operator_add(_append);
    }
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(field, "static");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForKeyword, _function_1);
    document.operator_add(_append_1);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(field, "extension");
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(_nodeForKeyword_1, _function_2);
    document.operator_add(_append_2);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(field, "val");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_nodeForKeyword_2, _function_3);
    document.operator_add(_append_3);
    ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(field, "var");
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(_nodeForKeyword_3, _function_4);
    document.operator_add(_append_4);
    ILeafNode _nodeForKeyword_4 = this._nodeModelAccess.nodeForKeyword(field, "=");
    final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword_4, _function_5, _function_6);
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
    final INode nameNode = this._nodeModelAccess.nodeForFeature(param, Literals.XTEND_PARAMETER__NAME);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(nameNode, _function);
    format.operator_add(_prepend);
  }
  
  protected void _format(final RichString rs, final FormattableDocument format) {
    final Procedure2<EObject,FormattableDocument> _function = new Procedure2<EObject,FormattableDocument>() {
        public void apply(final EObject obj, final FormattableDocument doc) {
          XtendFormatter.this.format(obj, doc);
        }
      };
    final Procedure2<EObject,FormattableDocument> callback = _function;
    this.richStringFormatter.format(callback, format, rs);
  }
  
  protected void format(final EObject clazz, final FormattableDocument format) {
    if (clazz instanceof XtendClass) {
      _format((XtendClass)clazz, format);
      return;
    } else if (clazz instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)clazz, format);
      return;
    } else if (clazz instanceof RichString) {
      _format((RichString)clazz, format);
      return;
    } else if (clazz instanceof XtendConstructor) {
      _format((XtendConstructor)clazz, format);
      return;
    } else if (clazz instanceof XtendField) {
      _format((XtendField)clazz, format);
      return;
    } else if (clazz instanceof XtendFunction) {
      _format((XtendFunction)clazz, format);
      return;
    } else if (clazz instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)clazz, format);
      return;
    } else if (clazz instanceof XAssignment) {
      _format((XAssignment)clazz, format);
      return;
    } else if (clazz instanceof XBinaryOperation) {
      _format((XBinaryOperation)clazz, format);
      return;
    } else if (clazz instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)clazz, format);
      return;
    } else if (clazz instanceof XFeatureCall) {
      _format((XFeatureCall)clazz, format);
      return;
    } else if (clazz instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)clazz, format);
      return;
    } else if (clazz instanceof XWhileExpression) {
      _format((XWhileExpression)clazz, format);
      return;
    } else if (clazz instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)clazz, format);
      return;
    } else if (clazz instanceof XtendParameter) {
      _format((XtendParameter)clazz, format);
      return;
    } else if (clazz instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)clazz, format);
      return;
    } else if (clazz instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)clazz, format);
      return;
    } else if (clazz instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)clazz, format);
      return;
    } else if (clazz instanceof XBlockExpression) {
      _format((XBlockExpression)clazz, format);
      return;
    } else if (clazz instanceof XClosure) {
      _format((XClosure)clazz, format);
      return;
    } else if (clazz instanceof XConstructorCall) {
      _format((XConstructorCall)clazz, format);
      return;
    } else if (clazz instanceof XForLoopExpression) {
      _format((XForLoopExpression)clazz, format);
      return;
    } else if (clazz instanceof XIfExpression) {
      _format((XIfExpression)clazz, format);
      return;
    } else if (clazz instanceof XReturnExpression) {
      _format((XReturnExpression)clazz, format);
      return;
    } else if (clazz instanceof XSwitchExpression) {
      _format((XSwitchExpression)clazz, format);
      return;
    } else if (clazz instanceof XThrowExpression) {
      _format((XThrowExpression)clazz, format);
      return;
    } else if (clazz instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)clazz, format);
      return;
    } else if (clazz instanceof XTypeLiteral) {
      _format((XTypeLiteral)clazz, format);
      return;
    } else if (clazz instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)clazz, format);
      return;
    } else if (clazz instanceof XAnnotation) {
      _format((XAnnotation)clazz, format);
      return;
    } else if (clazz instanceof XAnnotationValueArray) {
      _format((XAnnotationValueArray)clazz, format);
      return;
    } else if (clazz instanceof XtendFile) {
      _format((XtendFile)clazz, format);
      return;
    } else if (clazz instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)clazz, format);
      return;
    } else if (clazz instanceof XCatchClause) {
      _format((XCatchClause)clazz, format);
      return;
    } else if (clazz instanceof XExpression) {
      _format((XExpression)clazz, format);
      return;
    } else if (clazz instanceof XImportDeclaration) {
      _format((XImportDeclaration)clazz, format);
      return;
    } else if (clazz instanceof XImportSection) {
      _format((XImportSection)clazz, format);
      return;
    } else if (clazz != null) {
      _format(clazz, format);
      return;
    } else if (clazz == null) {
      _format((Void)null, format);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(clazz, format).toString());
    }
  }
}
