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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.formatting.FormattableDocument;
import org.eclipse.xtend.core.formatting.FormatterExtensions;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.FormattingDataInit;
import org.eclipse.xtend.core.formatting.HiddenLeafs;
import org.eclipse.xtend.core.formatting.IConfigurationKey;
import org.eclipse.xtend.core.formatting.IConfigurationValues;
import org.eclipse.xtend.core.formatting.NodeModelAccess;
import org.eclipse.xtend.core.formatting.RichStringFormatter;
import org.eclipse.xtend.core.formatting.TextReplacement;
import org.eclipse.xtend.core.formatting.XtendFormatterConfigKeys;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendImport;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage.Literals;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
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
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XMemberFeatureCallElements;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

@SuppressWarnings(value = "restriction")
public class XtendFormatter {
  @Inject
  private NodeModelAccess _nodeModelAccess;
  
  @Inject
  private FormatterExtensions _formatterExtensions;
  
  @Inject
  private XtendGrammarAccess _xtendGrammarAccess;
  
  @Inject
  private XtendFormatterConfigKeys _xtendFormatterConfigKeys;
  
  @Inject
  private RichStringFormatter richStringFormatter;
  
  private boolean _allowIdentityEdits = false;
  
  public boolean isAllowIdentityEdits() {
    return this._allowIdentityEdits;
  }
  
  public void setAllowIdentityEdits(final boolean allowIdentityEdits) {
    this._allowIdentityEdits = allowIdentityEdits;
  }
  
  private boolean _diagnoseConflicts = true;
  
  public boolean isDiagnoseConflicts() {
    return this._diagnoseConflicts;
  }
  
  public void setDiagnoseConflicts(final boolean diagnoseConflicts) {
    this._diagnoseConflicts = diagnoseConflicts;
  }
  
  public List<TextReplacement> format(final XtextResource res, final int offset, final int length, final IConfigurationValues<XtendFormatterConfigKeys> cfg) {
    List<TextReplacement> _xblockexpression = null;
    {
      IParseResult _parseResult = res.getParseResult();
      ICompositeNode _rootNode = _parseResult.getRootNode();
      final String doc = _rootNode.getText();
      FormattableDocument _formattableDocument = new FormattableDocument(cfg, doc);
      final FormattableDocument format = _formattableDocument;
      EList<EObject> _contents = res.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      this.format(((XtendFile) _head), format);
      boolean _and = false;
      boolean _isDiagnoseConflicts = this.isDiagnoseConflicts();
      if (!_isDiagnoseConflicts) {
        _and = false;
      } else {
        boolean _isConflictOccurred = format.isConflictOccurred();
        _and = (_isDiagnoseConflicts && _isConflictOccurred);
      }
      if (_and) {
        FormattableDocument _formattableDocument_1 = new FormattableDocument(cfg, doc);
        final FormattableDocument debug = _formattableDocument_1;
        RuntimeException _runtimeException = new RuntimeException();
        debug.setRootTrace(_runtimeException);
        EList<EObject> _contents_1 = res.getContents();
        EObject _head_1 = IterableExtensions.<EObject>head(_contents_1);
        this.format(((XtendFile) _head_1), debug);
      }
      final List<TextReplacement> edits = format.renderToEdits(offset, length);
      List<TextReplacement> _xifexpression = null;
      boolean _isAllowIdentityEdits = this.isAllowIdentityEdits();
      if (_isAllowIdentityEdits) {
        _xifexpression = edits;
      } else {
        final Function1<TextReplacement,Boolean> _function = new Function1<TextReplacement,Boolean>() {
            public Boolean apply(final TextReplacement it) {
              int _offset = it.getOffset();
              int _offset_1 = it.getOffset();
              int _length = it.getLength();
              int _plus = (_offset_1 + _length);
              String _substring = doc.substring(_offset, _plus);
              String _text = it.getText();
              boolean _notEquals = (!Objects.equal(_substring, _text));
              return Boolean.valueOf(_notEquals);
            }
          };
        Iterable<TextReplacement> _filter = IterableExtensions.<TextReplacement>filter(edits, _function);
        List<TextReplacement> _list = IterableExtensions.<TextReplacement>toList(_filter);
        _xifexpression = _list;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected void _format(final XtendFile xtendFile, final FormattableDocument format) {
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(xtendFile);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForEObject, _function);
    format.operator_add(_prepend);
    final INode pkg = this._nodeModelAccess.nodeForFeature(xtendFile, Literals.XTEND_FILE__PACKAGE);
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(pkg, _function_1);
    format.operator_add(_prepend_1);
    final ILeafNode pkgSemicolon = this._nodeModelAccess.immediatelyFollowingKeyword(pkg, ";");
    boolean _notEquals = (!Objects.equal(pkgSemicolon, null));
    if (_notEquals) {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = "";
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(pkg, _function_2);
      format.operator_add(_append);
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(pkgSemicolon, this._xtendFormatterConfigKeys.blankLinesAfterPackageDecl);
      format.operator_add(_append_1);
    } else {
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(pkg, this._xtendFormatterConfigKeys.blankLinesAfterPackageDecl);
      format.operator_add(_append_2);
    }
    EList<XtendImport> _imports = xtendFile.getImports();
    for (final XtendImport imp : _imports) {
      {
        this.format(imp, format);
        EList<XtendImport> _imports_1 = xtendFile.getImports();
        XtendImport _last = IterableExtensions.<XtendImport>last(_imports_1);
        boolean _notEquals_1 = (!Objects.equal(imp, _last));
        if (_notEquals_1) {
          INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(imp);
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(_nodeForEObject_1, this._xtendFormatterConfigKeys.blankLinesBetweenImports);
          format.operator_add(_append_3);
        } else {
          INode _nodeForEObject_2 = this._nodeModelAccess.nodeForEObject(imp);
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formatterExtensions.append(_nodeForEObject_2, this._xtendFormatterConfigKeys.blankLinesAfterImports);
          format.operator_add(_append_4);
        }
      }
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
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(_nodeForEObject_1, this._xtendFormatterConfigKeys.blankLinesBetweenClasses);
          format.operator_add(_append_3);
        }
      }
    }
    INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(xtendFile);
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.newLine();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(_nodeForEObject_1, _function_3);
    format.operator_add(_append_3);
  }
  
  protected void _format(final XtendImport imp, final FormattableDocument document) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(imp, "import");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, _function);
    document.operator_add(_append);
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(imp, Literals.XTEND_IMPORT__STATIC);
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(_nodeForFeature, _function_1);
    document.operator_add(_append_1);
    INode _nodeForFeature_1 = this._nodeModelAccess.nodeForFeature(imp, Literals.XTEND_IMPORT__EXTENSION);
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(_nodeForFeature_1, _function_2);
    document.operator_add(_append_2);
    Iterable<ILeafNode> _nodesForKeyword = this._nodeModelAccess.nodesForKeyword(imp, ".");
    for (final ILeafNode node : _nodesForKeyword) {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(node, _function_3);
      document.operator_add(_surround);
    }
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(imp, ";");
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForKeyword_1, _function_4);
    document.operator_add(_prepend);
  }
  
  protected void formatAnnotations(final XtendAnnotationTarget target, final FormattableDocument document, final IConfigurationKey<? extends Object> configKey) {
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
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForEObject, configKey);
        document.operator_add(_append);
      }
    }
  }
  
  protected void _format(final XAnnotationValueArray ann, final FormattableDocument document) {
    ILeafNode node = this._nodeModelAccess.nodeForKeyword(ann, "{");
    EList<XExpression> _values = ann.getValues();
    for (final XExpression value : _values) {
      {
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              EList<XExpression> _values = ann.getValues();
              XExpression _head = IterableExtensions.<XExpression>head(_values);
              boolean _equals = Objects.equal(value, _head);
              if (_equals) {
                it.noSpace();
              } else {
                it.oneSpace();
              }
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(node, _function);
        document.operator_add(_append);
        this.format(value, document);
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(value);
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
        node = _immediatelyFollowingKeyword;
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(node, _function_1);
        document.operator_add(_prepend);
      }
    }
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(ann, "}");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForKeyword, _function);
    document.operator_add(_prepend);
  }
  
  protected void _format(final XAnnotation ann, final FormattableDocument document) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(ann, "@");
    final Procedure1<ILeafNode> _function = new Procedure1<ILeafNode>() {
        public void apply(final ILeafNode it) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XtendFormatter.this._formatterExtensions.append(it, _function);
          document.operator_add(_append);
        }
      };
    ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword, _function);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(ann, "(");
    final Procedure1<ILeafNode> _function_1 = new Procedure1<ILeafNode>() {
        public void apply(final ILeafNode it) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XtendFormatter.this._formatterExtensions.prepend(it, _function);
          document.operator_add(_prepend);
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XtendFormatter.this._formatterExtensions.append(it, _function_1);
          document.operator_add(_append);
        }
      };
    ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword_1, _function_1);
    XExpression _value = ann.getValue();
    boolean _notEquals = (!Objects.equal(_value, null));
    if (_notEquals) {
      XExpression _value_1 = ann.getValue();
      this.format(_value_1, document);
      ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(ann, ")");
      final Procedure1<ILeafNode> _function_2 = new Procedure1<ILeafNode>() {
          public void apply(final ILeafNode it) {
            final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XtendFormatter.this._formatterExtensions.prepend(it, _function);
            document.operator_add(_prepend);
          }
        };
      ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword_2, _function_2);
    } else {
      EList<XAnnotationElementValuePair> _elementValuePairs = ann.getElementValuePairs();
      boolean _isEmpty = _elementValuePairs.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EList<XAnnotationElementValuePair> _elementValuePairs_1 = ann.getElementValuePairs();
        for (final XAnnotationElementValuePair pair : _elementValuePairs_1) {
          {
            ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(pair, "=");
            final Procedure1<ILeafNode> _function_3 = new Procedure1<ILeafNode>() {
                public void apply(final ILeafNode it) {
                  final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
                      public void apply(final FormattingDataInit it) {
                        it.noSpace();
                      }
                    };
                  Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XtendFormatter.this._formatterExtensions.prepend(it, _function);
                  document.operator_add(_prepend);
                  final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                      public void apply(final FormattingDataInit it) {
                        it.noSpace();
                      }
                    };
                  Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XtendFormatter.this._formatterExtensions.append(it, _function_1);
                  document.operator_add(_append);
                }
              };
            ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword_3, _function_3);
            XExpression _value_2 = pair.getValue();
            this.format(_value_2, document);
            INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(pair);
            final ILeafNode separator = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
            final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(separator, _function_4);
            document.operator_add(_prepend);
            final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.oneSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(separator, _function_5);
            document.operator_add(_append);
          }
        }
        ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(ann, ")");
        final Procedure1<ILeafNode> _function_3 = new Procedure1<ILeafNode>() {
            public void apply(final ILeafNode it) {
              final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.noSpace();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XtendFormatter.this._formatterExtensions.prepend(it, _function);
              document.operator_add(_prepend);
            }
          };
        ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword_3, _function_3);
      }
    }
  }
  
  protected void _format(final XtendClass clazz, final FormattableDocument format) {
    this.formatAnnotations(clazz, format, this._xtendFormatterConfigKeys.newLineAfterClassAnnotations);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(clazz, "public");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(clazz, "abstract");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(_nodeForKeyword_1, _function_1);
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
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForKeyword_2, _function_2);
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
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_1 = this._formatterExtensions.surround(_immediatelyFollowingKeyword, _function_3, _function_4);
          format.operator_add(_surround_1);
        }
      }
      ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(clazz, ">");
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForKeyword_3, _function_3);
      format.operator_add(_prepend);
    }
    ILeafNode _nodeForKeyword_4 = this._nodeModelAccess.nodeForKeyword(clazz, "class");
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(_nodeForKeyword_4, _function_4);
    format.operator_add(_append_2);
    ILeafNode _nodeForKeyword_5 = this._nodeModelAccess.nodeForKeyword(clazz, "extends");
    final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_1 = this._formatterExtensions.surround(_nodeForKeyword_5, _function_5);
    format.operator_add(_surround_1);
    JvmTypeReference _extends = clazz.getExtends();
    this.format(_extends, format);
    ILeafNode _nodeForKeyword_6 = this._nodeModelAccess.nodeForKeyword(clazz, "implements");
    final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_2 = this._formatterExtensions.surround(_nodeForKeyword_6, _function_6);
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
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_3 = this._formatterExtensions.surround(_immediatelyFollowingKeyword, _function_7, _function_8);
        format.operator_add(_surround_3);
        this.format(imp, format);
      }
    }
    final ILeafNode clazzOpenBrace = this._nodeModelAccess.nodeForKeyword(clazz, "{");
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(clazzOpenBrace, this._xtendFormatterConfigKeys.bracesInNewLine);
    format.operator_add(_prepend_1);
    EList<XtendMember> _members = clazz.getMembers();
    boolean _isEmpty_1 = _members.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(clazzOpenBrace, _function_7);
      format.operator_add(_append_3);
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formatterExtensions.append(clazzOpenBrace, this._xtendFormatterConfigKeys.blankLinesBeforeFirstMember);
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
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_5 = this._formatterExtensions.append(_nodeForEObject, this._xtendFormatterConfigKeys.blankLinesBetweenFields);
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
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_6 = this._formatterExtensions.append(_nodeForEObject_1, this._xtendFormatterConfigKeys.blankLinesBetweenMethods);
                format.operator_add(_append_6);
              } else {
                INode _nodeForEObject_2 = this._nodeModelAccess.nodeForEObject(current);
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_7 = this._formatterExtensions.append(_nodeForEObject_2, this._xtendFormatterConfigKeys.blankLinesBetweenFieldsAndMethods);
                format.operator_add(_append_7);
              }
            }
          } else {
            EList<XtendMember> _members_5 = clazz.getMembers();
            XtendMember _get = _members_5.get((i).intValue());
            final INode node = this._nodeModelAccess.nodeForEObject(_get);
            final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.decreaseIndentation();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_8 = this._formatterExtensions.append(node, _function_8);
            format.operator_add(_append_8);
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_9 = this._formatterExtensions.append(node, this._xtendFormatterConfigKeys.blankLinesAfterLastMember);
            format.operator_add(_append_9);
          }
        }
      }
    } else {
      final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_5 = this._formatterExtensions.append(clazzOpenBrace, _function_8);
      format.operator_add(_append_5);
    }
  }
  
  protected void _format(final XtendConstructor func, final FormattableDocument format) {
    this.formatAnnotations(func, format, this._xtendFormatterConfigKeys.newLineAfterConstructorAnnotations);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(func, "new");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, _function);
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
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(_nodeForKeyword_1, _function_1);
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
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_immediatelyFollowingKeyword, _function_2, _function_3);
          format.operator_add(_surround);
        }
      }
      ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(func, ">");
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForKeyword_2, _function_2);
      format.operator_add(_surround);
    }
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(func, "(");
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(func, ")");
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(close, this._xtendFormatterConfigKeys.bracesInNewLine);
    format.operator_add(_append_2);
    EList<XtendParameter> _parameters = func.getParameters();
    this.formatMemberParameter(_parameters, open, close, format);
    XExpression _expression = func.getExpression();
    this.format(_expression, format);
  }
  
  protected void formatMemberParameter(final Collection<XtendParameter> parameters, final INode open, final INode close, final FormattableDocument format) {
    ILeafNode _whitespaceBefore = close==null?(ILeafNode)null:this._nodeModelAccess.whitespaceBefore(close);
    String _text = _whitespaceBefore==null?(String)null:_whitespaceBefore.getText();
    boolean _contains = _text==null?false:_text.contains("\n");
    if (_contains) {
      INode comma = null;
      boolean _isEmpty = parameters.isEmpty();
      if (_isEmpty) {
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(open, _function);
        format.operator_add(_append);
      } else {
        for (final XtendParameter param : parameters) {
          {
            XtendParameter _head = IterableExtensions.<XtendParameter>head(parameters);
            boolean _equals = Objects.equal(param, _head);
            if (_equals) {
              final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                    it.increaseIndentation();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(open, _function_1);
              format.operator_add(_append_1);
            } else {
              boolean _notEquals = (!Objects.equal(comma, null));
              if (_notEquals) {
                final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(comma, _function_2);
                format.operator_add(_append_2);
              }
            }
            XtendParameter _last = IterableExtensions.<XtendParameter>last(parameters);
            boolean _equals_1 = Objects.equal(param, _last);
            if (_equals_1) {
              INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(param);
              final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                    it.decreaseIndentation();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(_nodeForEObject, _function_3);
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
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(comma, _function_4);
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
            boolean _equals = Objects.equal(comma_1, null);
            if (_equals) {
              final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.noSpace();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(open, _function_1);
              format.operator_add(_append_1);
            } else {
              final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.oneSpace();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(comma_1, _function_2);
              format.operator_add(_append_2);
            }
          } else {
            INode _xifexpression = null;
            boolean _equals_1 = Objects.equal(comma_1, null);
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
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(n, _function_3);
            format.operator_add(_append_3);
            boolean _not = (!indented);
            if (_not) {
              final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.increaseIndentation();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formatterExtensions.append(n, _function_4);
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
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(comma_1, _function_5);
          format.operator_add(_prepend);
        }
      }
      int _size = parameters.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        XtendParameter _last = IterableExtensions.<XtendParameter>last(parameters);
        final INode last = this._nodeModelAccess.nodeForEObject(_last);
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(last, _function_1);
        format.operator_add(_append_1);
        if (indented) {
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.decreaseIndentation();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(last, _function_2);
          format.operator_add(_append_2);
        }
      } else {
        final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(open, _function_3);
        format.operator_add(_append_3);
      }
    }
  }
  
  protected void _format(final XtendFunction func, final FormattableDocument format) {
    this.formatAnnotations(func, format, this._xtendFormatterConfigKeys.newLineAfterMethodAnnotations);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(func, "def");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, _function);
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
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(_nodeForKeyword_1, _function_1);
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
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_immediatelyFollowingKeyword, _function_2, _function_3);
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
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForKeyword_2, _function_2, _function_3);
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
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(_nodeForFeature, _function_4);
    format.operator_add(_append_2);
    final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(open, _function_5);
    format.operator_add(_prepend);
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(close, this._xtendFormatterConfigKeys.bracesInNewLine);
    format.operator_add(_append_3);
    EList<XtendParameter> _parameters = func.getParameters();
    this.formatMemberParameter(_parameters, open, close, format);
    JvmTypeReference _returnType = func.getReturnType();
    this.format(_returnType, format);
    XExpression _expression = func.getExpression();
    this.format(_expression, format);
  }
  
  protected void _format(final XtendField field, final FormattableDocument document) {
    this.formatAnnotations(field, document, this._xtendFormatterConfigKeys.newLineAfterFieldAnnotations);
    String _name = field.getName();
    boolean _notEquals = (!Objects.equal(_name, null));
    if (_notEquals) {
      INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(field, Literals.XTEND_FIELD__TYPE);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.oneSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForFeature, _function);
      document.operator_add(_append);
    }
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(field, "static");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(_nodeForKeyword, _function_1);
    document.operator_add(_append_1);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(field, "extension");
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(_nodeForKeyword_1, _function_2);
    document.operator_add(_append_2);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(field, "val");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(_nodeForKeyword_2, _function_3);
    document.operator_add(_append_3);
    ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(field, "var");
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formatterExtensions.append(_nodeForKeyword_3, _function_4);
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
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForKeyword_4, _function_5, _function_6);
    document.operator_add(_surround);
    JvmTypeReference _type = field.getType();
    this.format(_type, document);
    XExpression _initialValue = field.getInitialValue();
    this.format(_initialValue, document);
  }
  
  protected void _format(final XtendParameter param, final FormattableDocument format) {
    this.formatAnnotations(param, format, this._xtendFormatterConfigKeys.newLineAfterParameterAnnotations);
    JvmTypeReference _parameterType = param.getParameterType();
    this.format(_parameterType, format);
    final INode nameNode = this._nodeModelAccess.nodeForFeature(param, Literals.XTEND_PARAMETER__NAME);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(nameNode, _function);
    format.operator_add(_prepend);
  }
  
  protected void _format(final JvmGenericArrayTypeReference array, final FormattableDocument document) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(array, "[");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForKeyword, _function);
    document.operator_add(_prepend);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(array, "]");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(_nodeForKeyword_1, _function_1);
    document.operator_add(_prepend_1);
    JvmTypeReference _componentType = array.getComponentType();
    this.format(_componentType, document);
  }
  
  protected void _format(final XFunctionTypeRef func, final FormattableDocument document) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(func, "(");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, _function);
    document.operator_add(_append);
    EList<JvmTypeReference> _paramTypes = func.getParamTypes();
    for (final JvmTypeReference param : _paramTypes) {
      {
        this.format(param, document);
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(param);
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
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
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_immediatelyFollowingKeyword, _function_1, _function_2);
        document.operator_add(_surround);
      }
    }
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(func, ")");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          EList<JvmTypeReference> _paramTypes = func.getParamTypes();
          boolean _isEmpty = _paramTypes.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            it.noSpace();
          }
        }
      };
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForKeyword_1, _function_1, _function_2);
    document.operator_add(_surround);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(func, "=>");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(_nodeForKeyword_2, _function_3);
    document.operator_add(_append_1);
    JvmTypeReference _returnType = func.getReturnType();
    this.format(_returnType, document);
  }
  
  protected void _format(final JvmTypeParameter ref, final FormattableDocument document) {
    EList<JvmTypeConstraint> _constraints = ref.getConstraints();
    for (final JvmTypeConstraint c : _constraints) {
      {
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(c);
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForEObject, _function);
        document.operator_add(_prepend);
        this.format(c, document);
      }
    }
  }
  
  protected void _format(final JvmParameterizedTypeReference ref, final FormattableDocument document) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(ref, "<");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForKeyword, _function);
    document.operator_add(_surround);
    EList<JvmTypeReference> _arguments = ref.getArguments();
    for (final JvmTypeReference arg : _arguments) {
      {
        this.format(arg, document);
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(arg);
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
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
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_1 = this._formatterExtensions.surround(_immediatelyFollowingKeyword, _function_1, _function_2);
        document.operator_add(_surround_1);
      }
    }
    EList<JvmTypeReference> _arguments_1 = ref.getArguments();
    boolean _isEmpty = _arguments_1.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(ref, ">");
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForKeyword_1, _function_1);
      document.operator_add(_prepend);
    }
  }
  
  protected void _format(final JvmWildcardTypeReference ref, final FormattableDocument document) {
    EList<JvmTypeConstraint> _constraints = ref.getConstraints();
    boolean _isEmpty = _constraints.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(ref, "?");
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.oneSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, _function);
      document.operator_add(_append);
    }
    EList<JvmTypeConstraint> _constraints_1 = ref.getConstraints();
    for (final JvmTypeConstraint c : _constraints_1) {
      this.format(c, document);
    }
  }
  
  protected void _format(final JvmTypeConstraint constraint, final FormattableDocument document) {
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(constraint, org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForFeature, _function);
    document.operator_add(_prepend);
    JvmTypeReference _typeReference = constraint.getTypeReference();
    this.format(_typeReference, document);
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
  
  protected void _format(final XVariableDeclaration expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "val");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(expr, "var");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(_nodeForKeyword_1, _function_1);
    format.operator_add(_append_1);
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XVARIABLE_DECLARATION__TYPE);
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(_nodeForFeature, _function_2);
    format.operator_add(_append_2);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(expr, "=");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForKeyword_2, _function_3);
    format.operator_add(_surround);
    JvmTypeReference _type = expr.getType();
    this.format(_type, format);
    XExpression _right = expr.getRight();
    this.format(_right, format);
  }
  
  protected void _format(final XAssignment expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "=");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForKeyword, _function);
    format.operator_add(_surround);
    XExpression _assignable = expr.getAssignable();
    this.format(_assignable, format);
    XExpression _value = expr.getValue();
    this.format(_value, format);
  }
  
  protected void _format(final Void expr, final FormattableDocument format) {
  }
  
  protected void _format(final EObject expr, final FormattableDocument format) {
  }
  
  protected void formatStaticQualifier(final INode node, final FormattableDocument document) {
    if ((node instanceof ICompositeNode)) {
      final Iterable<ILeafNode> leafs = ((ICompositeNode) node).getLeafNodes();
      for (final ILeafNode n : leafs) {
        boolean _and = false;
        EObject _grammarElement = n.getGrammarElement();
        if (!(_grammarElement instanceof Keyword)) {
          _and = false;
        } else {
          String _text = n.getText();
          boolean _equals = Objects.equal(_text, "::");
          _and = ((_grammarElement instanceof Keyword) && _equals);
        }
        if (_and) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(n, _function);
          document.operator_add(_prepend);
          ILeafNode _last = IterableExtensions.<ILeafNode>last(leafs);
          boolean _notEquals = (!Objects.equal(n, _last));
          if (_notEquals) {
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(n, _function_1);
            document.operator_add(_append);
          }
        }
      }
    }
  }
  
  protected void formatFeatureCallParamsWrapIfNeeded(final INode open, final List<XExpression> params, final FormattableDocument format) {
    final XClosure builder = this.builder(params);
    final Iterable<XExpression> explicitParams = this.explicitParams(params);
    INode node = null;
    boolean indented = false;
    boolean _isEmpty = IterableExtensions.isEmpty(explicitParams);
    if (_isEmpty) {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(open, _function);
      format.operator_add(_append);
    } else {
      for (final XExpression arg : explicitParams) {
        {
          XExpression _head = IterableExtensions.<XExpression>head(explicitParams);
          boolean _equals = Objects.equal(arg, _head);
          if (_equals) {
            final INode head = this._nodeModelAccess.nodeForEObject(arg);
            boolean _fitsIntoLine = this.fitsIntoLine(format, arg);
            if (_fitsIntoLine) {
              final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.noSpace();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(head, _function_1);
              format.operator_add(_prepend);
            } else {
              final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(head, _function_2);
              format.operator_add(_prepend_1);
              boolean _not = (!indented);
              if (_not) {
                final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.increaseIndentation();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_2 = this._formatterExtensions.prepend(head, _function_3);
                format.operator_add(_prepend_2);
              }
              indented = true;
            }
          } else {
            boolean _notEquals = (!Objects.equal(node, null));
            if (_notEquals) {
              boolean _fitsIntoLine_1 = this.fitsIntoLine(format, arg);
              if (_fitsIntoLine_1) {
                final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.oneSpace();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(node, _function_4);
                format.operator_add(_append_1);
              } else {
                final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(node, _function_5);
                format.operator_add(_append_2);
                boolean _not_1 = (!indented);
                if (_not_1) {
                  final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
                      public void apply(final FormattingDataInit it) {
                        it.increaseIndentation();
                      }
                    };
                  Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(node, _function_6);
                  format.operator_add(_append_3);
                }
                indented = true;
              }
            }
          }
          XExpression _last = IterableExtensions.<XExpression>last(explicitParams);
          boolean _equals_1 = Objects.equal(arg, _last);
          if (_equals_1) {
            INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(arg);
            final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formatterExtensions.append(_nodeForEObject, _function_7);
            format.operator_add(_append_4);
          }
          this.format(arg, format);
          INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(arg);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject_1, ",");
          node = _immediatelyFollowingKeyword;
          final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_3 = this._formatterExtensions.prepend(node, _function_8);
          format.operator_add(_prepend_3);
        }
      }
    }
    if (indented) {
      XExpression _last = IterableExtensions.<XExpression>last(explicitParams);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_last);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(_nodeForEObject, _function_1);
      format.operator_add(_append_1);
    }
    boolean _notEquals = (!Objects.equal(builder, null));
    if (_notEquals) {
      INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(builder);
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            boolean _isMultilineLambda = XtendFormatter.this.isMultilineLambda(builder);
            if (_isMultilineLambda) {
              it.oneSpace();
            } else {
              it.noSpace();
            }
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForEObject_1, _function_2);
      format.operator_add(_prepend);
      this.format(builder, format);
    }
  }
  
  protected XClosure builder(final List<XExpression> params) {
    XClosure _xifexpression = null;
    boolean _and = false;
    XExpression _last = IterableExtensions.<XExpression>last(params);
    boolean _notEquals = (!Objects.equal(_last, null));
    if (!_notEquals) {
      _and = false;
    } else {
      XExpression _last_1 = IterableExtensions.<XExpression>last(params);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_last_1);
      INode _firstChild = ((ICompositeNode) _nodeForEObject).getFirstChild();
      EObject _grammarElement = _firstChild.getGrammarElement();
      XMemberFeatureCallElements _xMemberFeatureCallAccess = this._xtendGrammarAccess.getXMemberFeatureCallAccess();
      RuleCall _memberCallArgumentsXClosureParserRuleCall_1_1_4_0 = _xMemberFeatureCallAccess.getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0();
      boolean _equals = Objects.equal(_grammarElement, _memberCallArgumentsXClosureParserRuleCall_1_1_4_0);
      _and = (_notEquals && _equals);
    }
    if (_and) {
      XExpression _last_2 = IterableExtensions.<XExpression>last(params);
      _xifexpression = ((XClosure) _last_2);
    }
    return _xifexpression;
  }
  
  protected Iterable<XExpression> explicitParams(final List<XExpression> params) {
    Iterable<XExpression> _xblockexpression = null;
    {
      final XClosure builder = this.builder(params);
      Iterable<XExpression> _xifexpression = null;
      boolean _notEquals = (!Objects.equal(builder, null));
      if (_notEquals) {
        int _size = params.size();
        int _minus = (_size - 1);
        Iterable<XExpression> _take = IterableExtensions.<XExpression>take(params, _minus);
        _xifexpression = _take;
      } else {
        _xifexpression = params;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected void formatFeatureCallParamsMultiline(final INode open, final List<XExpression> params, final FormattableDocument format) {
    final XClosure builder = this.builder(params);
    final Iterable<XExpression> explicitParams = this.explicitParams(params);
    INode node = null;
    boolean _isEmpty = IterableExtensions.isEmpty(explicitParams);
    if (_isEmpty) {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(open, _function);
      format.operator_add(_append);
    } else {
      for (final XExpression arg : explicitParams) {
        {
          XExpression _head = IterableExtensions.<XExpression>head(explicitParams);
          boolean _equals = Objects.equal(arg, _head);
          if (_equals) {
            final INode head = this._nodeModelAccess.nodeForEObject(arg);
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                  it.increaseIndentation();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(head, _function_1);
            format.operator_add(_prepend);
          } else {
            boolean _notEquals = (!Objects.equal(node, null));
            if (_notEquals) {
              final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(node, _function_2);
              format.operator_add(_append_1);
            }
          }
          XExpression _last = IterableExtensions.<XExpression>last(explicitParams);
          boolean _equals_1 = Objects.equal(arg, _last);
          if (_equals_1) {
            INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(arg);
            final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                  it.decreaseIndentation();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(_nodeForEObject, _function_3);
            format.operator_add(_append_2);
          }
          this.format(arg, format);
          INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(arg);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject_1, ",");
          node = _immediatelyFollowingKeyword;
          final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(node, _function_4);
          format.operator_add(_prepend_1);
        }
      }
    }
    boolean _notEquals = (!Objects.equal(builder, null));
    if (_notEquals) {
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(builder);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            boolean _isMultilineLambda = XtendFormatter.this.isMultilineLambda(builder);
            if (_isMultilineLambda) {
              it.oneSpace();
            } else {
              it.noSpace();
            }
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForEObject, _function_1);
      format.operator_add(_prepend);
      this.format(builder, format);
    }
  }
  
  protected void _format(final XConstructorCall expr, final FormattableDocument format) {
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForFeature, _function);
    format.operator_add(_prepend);
    EList<JvmTypeReference> _typeArguments = expr.getTypeArguments();
    boolean _isEmpty = _typeArguments.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "<");
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForKeyword, _function_1);
      format.operator_add(_surround);
      EList<JvmTypeReference> _typeArguments_1 = expr.getTypeArguments();
      for (final JvmTypeReference arg : _typeArguments_1) {
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
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_1 = this._formatterExtensions.surround(_immediatelyFollowingKeyword, _function_2, _function_3);
          format.operator_add(_surround_1);
        }
      }
      ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(expr, ">");
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(_nodeForKeyword_1, _function_2);
      format.operator_add(_prepend_1);
    }
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "(");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_2 = this._formatterExtensions.prepend(open, _function_3);
    format.operator_add(_prepend_2);
    boolean _isMultiParamInOwnLine = this.isMultiParamInOwnLine(expr, format);
    if (_isMultiParamInOwnLine) {
      EList<XExpression> _arguments = expr.getArguments();
      this.formatFeatureCallParamsMultiline(open, _arguments, format);
    } else {
      EList<XExpression> _arguments_1 = expr.getArguments();
      this.formatFeatureCallParamsWrapIfNeeded(open, _arguments_1, format);
    }
  }
  
  protected void formatFeatureCallTypeParameters(final XAbstractFeatureCall expr, final FormattableDocument format) {
    EList<JvmTypeReference> _typeArguments = expr.getTypeArguments();
    boolean _isEmpty = _typeArguments.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "<");
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, _function);
      format.operator_add(_append);
      EList<JvmTypeReference> _typeArguments_1 = expr.getTypeArguments();
      for (final JvmTypeReference arg : _typeArguments_1) {
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
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_immediatelyFollowingKeyword, _function_1, _function_2);
          format.operator_add(_surround);
        }
      }
      ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(expr, ">");
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForKeyword_1, _function_1);
      format.operator_add(_surround);
    }
  }
  
  protected void _format(final XFeatureCall expr, final FormattableDocument format) {
    final INode declaringType = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE);
    this.formatStaticQualifier(declaringType, format);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(declaringType, _function);
    format.operator_add(_append);
    this.formatFeatureCallTypeParameters(expr, format);
    boolean _isExplicitOperationCall = expr.isExplicitOperationCall();
    if (_isExplicitOperationCall) {
      final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "(");
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(open, _function_1);
      format.operator_add(_prepend);
      boolean _isMultiParamInOwnLine = this.isMultiParamInOwnLine(expr, format);
      if (_isMultiParamInOwnLine) {
        EList<XExpression> _featureCallArguments = expr.getFeatureCallArguments();
        this.formatFeatureCallParamsMultiline(open, _featureCallArguments, format);
      } else {
        EList<XExpression> _featureCallArguments_1 = expr.getFeatureCallArguments();
        this.formatFeatureCallParamsWrapIfNeeded(open, _featureCallArguments_1, format);
      }
    } else {
      EList<XExpression> _featureCallArguments_2 = expr.getFeatureCallArguments();
      for (final XExpression arg : _featureCallArguments_2) {
        this.format(arg, format);
      }
    }
  }
  
  protected void _format(final XMemberFeatureCall expr, final FormattableDocument format) {
    EObject top = expr;
    ArrayList<XMemberFeatureCall> calls = CollectionLiterals.<XMemberFeatureCall>newArrayList();
    boolean _while = (top instanceof XMemberFeatureCall);
    while (_while) {
      {
        calls.add(((XMemberFeatureCall) top));
        XExpression _memberCallTarget = ((XMemberFeatureCall) top).getMemberCallTarget();
        top = _memberCallTarget;
      }
      _while = (top instanceof XMemberFeatureCall);
    }
    this.format(top, format);
    boolean indented = false;
    List<XMemberFeatureCall> _reverse = ListExtensions.<XMemberFeatureCall>reverse(calls);
    for (final XMemberFeatureCall call : _reverse) {
      {
        this.formatFeatureCallTypeParameters(call, format);
        final INode featureNode = this._nodeModelAccess.nodeForFeature(call, org.eclipse.xtext.xbase.XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
        XExpression _memberCallTarget = call.getMemberCallTarget();
        final INode targetNode = this._nodeModelAccess.nodeForEObject(_memberCallTarget);
        boolean _notEquals = (!Objects.equal(targetNode, null));
        if (_notEquals) {
          int _offset = targetNode.getOffset();
          int _length = targetNode.getLength();
          final int callOffset = (_offset + _length);
          String _xifexpression = null;
          boolean _isNullSafe = call.isNullSafe();
          if (_isNullSafe) {
            _xifexpression = "?.";
          } else {
            _xifexpression = ".";
          }
          final ILeafNode op = this._nodeModelAccess.nodeForKeyword(call, _xifexpression);
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(op, _function);
          format.operator_add(_prepend);
          boolean _isExplicitOperationCall = call.isExplicitOperationCall();
          if (_isExplicitOperationCall) {
            final INode callNode = this._nodeModelAccess.nodeForEObject(call);
            int _offset_1 = callNode.getOffset();
            int _length_1 = callNode.getLength();
            int _plus = (_offset_1 + _length_1);
            final int callLength = (_plus - callOffset);
            final ILeafNode open = this._nodeModelAccess.nodeForKeyword(call, "(");
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(featureNode, _function_1);
            format.operator_add(_append);
            final int lineLength = format.lineLengthBefore(callOffset);
            boolean _isMultiParamInOwnLine = this.isMultiParamInOwnLine(call, format);
            if (_isMultiParamInOwnLine) {
              int _length_2 = featureNode.getLength();
              int _plus_1 = (lineLength + _length_2);
              IConfigurationValues<XtendFormatterConfigKeys> _cfg = format.getCfg();
              Integer _get = _cfg.<Integer>get(this._xtendFormatterConfigKeys.maxLineWidth);
              boolean _lessThan = (_plus_1 < (_get).intValue());
              if (_lessThan) {
                final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.noSpace();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(op, _function_2);
                format.operator_add(_append_1);
              } else {
                final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(op, _function_3);
                format.operator_add(_append_2);
              }
              EList<XExpression> _memberCallArguments = call.getMemberCallArguments();
              this.formatFeatureCallParamsMultiline(open, _memberCallArguments, format);
            } else {
              boolean _or = false;
              int _length_3 = featureNode.getLength();
              int _multiply = (_length_3 * 2);
              int _plus_2 = (lineLength + _multiply);
              IConfigurationValues<XtendFormatterConfigKeys> _cfg_1 = format.getCfg();
              Integer _get_1 = _cfg_1.<Integer>get(this._xtendFormatterConfigKeys.maxLineWidth);
              boolean _lessThan_1 = (_plus_2 < (_get_1).intValue());
              if (_lessThan_1) {
                _or = true;
              } else {
                final Procedure1<FormattableDocument> _function_4 = new Procedure1<FormattableDocument>() {
                    public void apply(final FormattableDocument f) {
                      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
                          public void apply(final FormattingDataInit it) {
                            it.noSpace();
                          }
                        };
                      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XtendFormatter.this._formatterExtensions.append(op, _function);
                      f.operator_add(_append);
                      EList<XExpression> _memberCallArguments = call.getMemberCallArguments();
                      XtendFormatter.this.formatFeatureCallParamsWrapIfNeeded(open, _memberCallArguments, f);
                    }
                  };
                boolean _fitsIntoLine = this._formatterExtensions.fitsIntoLine(format, callOffset, callLength, _function_4);
                _or = (_lessThan_1 || _fitsIntoLine);
              }
              if (_or) {
                final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.noSpace();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(op, _function_5);
                format.operator_add(_append_3);
              } else {
                final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formatterExtensions.append(op, _function_6);
                format.operator_add(_append_4);
                boolean _not = (!indented);
                if (_not) {
                  indented = true;
                  final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
                      public void apply(final FormattingDataInit it) {
                        it.increaseIndentation();
                      }
                    };
                  Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_5 = this._formatterExtensions.append(op, _function_7);
                  format.operator_add(_append_5);
                }
              }
              EList<XExpression> _memberCallArguments_1 = call.getMemberCallArguments();
              this.formatFeatureCallParamsWrapIfNeeded(open, _memberCallArguments_1, format);
            }
          } else {
            int _lineLengthBefore = format.lineLengthBefore(callOffset);
            int _length_4 = featureNode.getLength();
            final int shortLenght = (_lineLengthBefore + _length_4);
            IConfigurationValues<XtendFormatterConfigKeys> _cfg_2 = format.getCfg();
            Integer _get_2 = _cfg_2.<Integer>get(this._xtendFormatterConfigKeys.maxLineWidth);
            boolean _lessThan_2 = (shortLenght < (_get_2).intValue());
            if (_lessThan_2) {
              final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.noSpace();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_6 = this._formatterExtensions.append(op, _function_8);
              format.operator_add(_append_6);
            } else {
              final Procedure1<FormattingDataInit> _function_9 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_7 = this._formatterExtensions.append(op, _function_9);
              format.operator_add(_append_7);
              boolean _not_1 = (!indented);
              if (_not_1) {
                indented = true;
                final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.increaseIndentation();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_8 = this._formatterExtensions.append(op, _function_10);
                format.operator_add(_append_8);
              }
            }
            EList<XExpression> _memberCallArguments_2 = call.getMemberCallArguments();
            boolean _isEmpty = _memberCallArguments_2.isEmpty();
            boolean _not_2 = (!_isEmpty);
            if (_not_2) {
              EList<XExpression> _memberCallArguments_3 = call.getMemberCallArguments();
              final XClosure builder = this.builder(_memberCallArguments_3);
              INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(builder);
              final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    boolean _isMultilineLambda = XtendFormatter.this.isMultilineLambda(builder);
                    if (_isMultilineLambda) {
                      it.oneSpace();
                    } else {
                      it.noSpace();
                    }
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(_nodeForEObject, _function_11);
              format.operator_add(_prepend_1);
              this.format(builder, format);
            }
          }
        }
      }
    }
    if (indented) {
      XMemberFeatureCall _last = IterableExtensions.<XMemberFeatureCall>last(calls);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_last);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForEObject, _function);
      format.operator_add(_append);
    }
  }
  
  protected AbstractRule binaryOperationPrecedence(final EObject op) {
    final INode node = this._nodeModelAccess.nodeForFeature(op, org.eclipse.xtext.xbase.XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(node, null));
    if (!_notEquals) {
      _and = false;
    } else {
      EObject _grammarElement = node.getGrammarElement();
      _and = (_notEquals && (_grammarElement instanceof CrossReference));
    }
    if (_and) {
      EObject _grammarElement_1 = node.getGrammarElement();
      final AbstractElement terminal = ((CrossReference) _grammarElement_1).getTerminal();
      if ((terminal instanceof RuleCall)) {
        return ((RuleCall) terminal).getRule();
      }
    }
    return null;
  }
  
  protected void _format(final XBinaryOperation expr, final FormattableDocument format) {
    AbstractRule precendece = this.binaryOperationPrecedence(expr);
    EObject top = expr;
    ArrayList<XBinaryOperation> calls = CollectionLiterals.<XBinaryOperation>newArrayList();
    AbstractRule _binaryOperationPrecedence = this.binaryOperationPrecedence(top);
    boolean _equals = Objects.equal(_binaryOperationPrecedence, precendece);
    boolean _while = _equals;
    while (_while) {
      {
        calls.add(((XBinaryOperation) top));
        XExpression _leftOperand = ((XBinaryOperation) top).getLeftOperand();
        top = _leftOperand;
      }
      AbstractRule _binaryOperationPrecedence_1 = this.binaryOperationPrecedence(top);
      boolean _equals_1 = Objects.equal(_binaryOperationPrecedence_1, precendece);
      _while = _equals_1;
    }
    this.format(top, format);
    boolean indented = false;
    List<XBinaryOperation> _reverse = ListExtensions.<XBinaryOperation>reverse(calls);
    for (final XBinaryOperation call : _reverse) {
      {
        final INode op = this._nodeModelAccess.nodeForFeature(call, org.eclipse.xtext.xbase.XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(op, _function);
        format.operator_add(_prepend);
        boolean _or = false;
        XExpression _rightOperand = call.getRightOperand();
        boolean _isMultiline = this.isMultiline(_rightOperand, format);
        if (_isMultiline) {
          _or = true;
        } else {
          XExpression _rightOperand_1 = call.getRightOperand();
          boolean _fitsIntoLine = this.fitsIntoLine(format, _rightOperand_1);
          _or = (_isMultiline || _fitsIntoLine);
        }
        if (_or) {
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(op, _function_1);
          format.operator_add(_append);
        } else {
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.newLine();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(op, _function_2);
          format.operator_add(_append_1);
          boolean _not = (!indented);
          if (_not) {
            indented = true;
            final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.increaseIndentation();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(op, _function_3);
            format.operator_add(_append_2);
          }
        }
        XExpression _rightOperand_2 = call.getRightOperand();
        this.format(_rightOperand_2, format);
      }
    }
    if (indented) {
      XBinaryOperation _last = IterableExtensions.<XBinaryOperation>last(calls);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_last);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForEObject, _function);
      format.operator_add(_append);
    }
  }
  
  protected void _format(final XSwitchExpression expr, final FormattableDocument format) {
    EList<XCasePart> _cases = expr.getCases();
    final Function1<XCasePart,Boolean> _function = new Function1<XCasePart,Boolean>() {
        public Boolean apply(final XCasePart it) {
          XExpression _then = it.getThen();
          return Boolean.valueOf((_then instanceof XBlockExpression));
        }
      };
    final boolean containsBlockExpr = IterableExtensions.<XCasePart>exists(_cases, _function);
    boolean _and = false;
    boolean _not = (!containsBlockExpr);
    if (!_not) {
      _and = false;
    } else {
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(expr);
      String _text = _nodeForEObject.getText();
      String _trim = _text.trim();
      boolean _contains = _trim.contains("\n");
      boolean _not_1 = (!_contains);
      _and = (_not && _not_1);
    }
    final boolean switchSL = _and;
    boolean _and_1 = false;
    boolean _not_2 = (!containsBlockExpr);
    if (!_not_2) {
      _and_1 = false;
    } else {
      EList<XCasePart> _cases_1 = expr.getCases();
      final Function1<XCasePart,Boolean> _function_1 = new Function1<XCasePart,Boolean>() {
          public Boolean apply(final XCasePart it) {
            INode _nodeForEObject = XtendFormatter.this._nodeModelAccess.nodeForEObject(it);
            String _text = _nodeForEObject.getText();
            String _trim = _text.trim();
            boolean _contains = _trim.contains("\n");
            return Boolean.valueOf(_contains);
          }
        };
      boolean _exists = IterableExtensions.<XCasePart>exists(_cases_1, _function_1);
      boolean _not_3 = (!_exists);
      _and_1 = (_not_2 && _not_3);
    }
    final boolean caseSL = _and_1;
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "{");
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(expr, "}");
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "switch");
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, _function_2);
    format.operator_add(_append);
    if (switchSL) {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = " ";
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(open, _function_3);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = " ";
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(open, _function_4);
      format.operator_add(_append_1);
      EList<XCasePart> _cases_2 = expr.getCases();
      for (final XCasePart c : _cases_2) {
        {
          XExpression _then = c.getThen();
          final INode cnode = this._nodeModelAccess.nodeForEObject(_then);
          final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(cnode, _function_5);
          format.operator_add(_prepend_1);
          final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(cnode, _function_6);
          format.operator_add(_append_2);
        }
      }
    } else {
      if (caseSL) {
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(open, this._xtendFormatterConfigKeys.bracesInNewLine);
        format.operator_add(_prepend_1);
        final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(open, _function_5);
        format.operator_add(_append_2);
        EList<XCasePart> _cases_3 = expr.getCases();
        for (final XCasePart c_1 : _cases_3) {
          {
            XExpression _then = c_1.getThen();
            INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(_then);
            final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.space = " ";
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_2 = this._formatterExtensions.prepend(_nodeForEObject_1, _function_6);
            format.operator_add(_prepend_2);
            EList<XCasePart> _cases_4 = expr.getCases();
            XCasePart _last = IterableExtensions.<XCasePart>last(_cases_4);
            boolean _notEquals = (!Objects.equal(c_1, _last));
            if (_notEquals) {
              INode _nodeForEObject_2 = this._nodeModelAccess.nodeForEObject(c_1);
              final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(_nodeForEObject_2, _function_7);
              format.operator_add(_append_3);
            }
          }
        }
        final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.decreaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_2 = this._formatterExtensions.prepend(close, _function_6);
        format.operator_add(_prepend_2);
      } else {
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_3 = this._formatterExtensions.prepend(open, this._xtendFormatterConfigKeys.bracesInNewLine);
        format.operator_add(_prepend_3);
        final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(open, _function_7);
        format.operator_add(_append_3);
        EList<XCasePart> _cases_4 = expr.getCases();
        for (final XCasePart c_2 : _cases_4) {
          {
            XExpression _then = c_2.getThen();
            final INode cnode = this._nodeModelAccess.nodeForEObject(_then);
            XExpression _then_1 = c_2.getThen();
            if ((_then_1 instanceof XBlockExpression)) {
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_4 = this._formatterExtensions.prepend(cnode, this._xtendFormatterConfigKeys.bracesInNewLine);
              format.operator_add(_prepend_4);
              EList<XCasePart> _cases_5 = expr.getCases();
              XCasePart _last = IterableExtensions.<XCasePart>last(_cases_5);
              boolean _notEquals = (!Objects.equal(c_2, _last));
              if (_notEquals) {
                final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formatterExtensions.append(cnode, _function_8);
                format.operator_add(_append_4);
              } else {
                final Procedure1<FormattingDataInit> _function_9 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                      it.decreaseIndentation();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_5 = this._formatterExtensions.append(cnode, _function_9);
                format.operator_add(_append_5);
              }
            } else {
              final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                    it.increaseIndentation();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_5 = this._formatterExtensions.prepend(cnode, _function_10);
              format.operator_add(_prepend_5);
              EList<XCasePart> _cases_6 = expr.getCases();
              XCasePart _last_1 = IterableExtensions.<XCasePart>last(_cases_6);
              boolean _notEquals_1 = (!Objects.equal(c_2, _last_1));
              if (_notEquals_1) {
                final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                      it.decreaseIndentation();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_6 = this._formatterExtensions.append(cnode, _function_11);
                format.operator_add(_append_6);
              } else {
                final Procedure1<FormattingDataInit> _function_12 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                      int _minus = (-2);
                      it.indentationChange = _minus;
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_7 = this._formatterExtensions.append(cnode, _function_12);
                format.operator_add(_append_7);
              }
            }
          }
        }
      }
    }
    EList<XCasePart> _cases_5 = expr.getCases();
    for (final XCasePart c_3 : _cases_5) {
      {
        boolean _and_2 = false;
        JvmTypeReference _typeGuard = c_3.getTypeGuard();
        boolean _notEquals = (!Objects.equal(_typeGuard, null));
        if (!_notEquals) {
          _and_2 = false;
        } else {
          XExpression _case = c_3.getCase();
          boolean _notEquals_1 = (!Objects.equal(_case, null));
          _and_2 = (_notEquals && _notEquals_1);
        }
        if (_and_2) {
          final INode typenode = this._nodeModelAccess.nodeForFeature(c_3, org.eclipse.xtext.xbase.XbasePackage.Literals.XCASE_PART__TYPE_GUARD);
          final INode casenode = this._nodeModelAccess.nodeForFeature(c_3, org.eclipse.xtext.xbase.XbasePackage.Literals.XCASE_PART__CASE);
          final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formatterExtensions.append(typenode, _function_8);
          format.operator_add(_append_4);
          final Procedure1<FormattingDataInit> _function_9 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_4 = this._formatterExtensions.prepend(casenode, _function_9);
          format.operator_add(_prepend_4);
          final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_5 = this._formatterExtensions.append(casenode, _function_10);
          format.operator_add(_append_5);
        } else {
          JvmTypeReference _typeGuard_1 = c_3.getTypeGuard();
          boolean _notEquals_2 = (!Objects.equal(_typeGuard_1, null));
          if (_notEquals_2) {
            final INode typenode_1 = this._nodeModelAccess.nodeForFeature(c_3, org.eclipse.xtext.xbase.XbasePackage.Literals.XCASE_PART__TYPE_GUARD);
            final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_6 = this._formatterExtensions.append(typenode_1, _function_11);
            format.operator_add(_append_6);
          } else {
            XExpression _case_1 = c_3.getCase();
            boolean _notEquals_3 = (!Objects.equal(_case_1, null));
            if (_notEquals_3) {
              final INode casenode_1 = this._nodeModelAccess.nodeForFeature(c_3, org.eclipse.xtext.xbase.XbasePackage.Literals.XCASE_PART__CASE);
              final Procedure1<FormattingDataInit> _function_12 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.space = " ";
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_5 = this._formatterExtensions.prepend(casenode_1, _function_12);
              format.operator_add(_prepend_5);
              final Procedure1<FormattingDataInit> _function_13 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.noSpace();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_7 = this._formatterExtensions.append(casenode_1, _function_13);
              format.operator_add(_append_7);
            }
          }
        }
        XExpression _case_2 = c_3.getCase();
        this.format(_case_2, format);
        XExpression _then = c_3.getThen();
        this.format(_then, format);
      }
    }
  }
  
  protected void _format(final XClosure expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "[");
    EObject _eContainer = expr.eContainer();
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(_eContainer, "(");
    final ILeafNode open = ObjectExtensions.<ILeafNode>operator_elvis(_nodeForKeyword, _nodeForKeyword_1);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(expr, "]");
    EObject _eContainer_1 = expr.eContainer();
    ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(_eContainer_1, ")");
    final ILeafNode close = ObjectExtensions.<ILeafNode>operator_elvis(_nodeForKeyword_2, _nodeForKeyword_3);
    List<XExpression> _switchResult = null;
    XExpression _expression = expr.getExpression();
    final XExpression x = _expression;
    boolean _matched = false;
    if (!_matched) {
      if (x instanceof XBlockExpression) {
        final XBlockExpression _xBlockExpression = (XBlockExpression)x;
        _matched=true;
        EList<XExpression> _expressions = _xBlockExpression.getExpressions();
        _switchResult = _expressions;
      }
    }
    if (!_matched) {
      if (x instanceof XExpression) {
        final XExpression _xExpression = (XExpression)x;
        _matched=true;
        ArrayList<XExpression> _newArrayList = CollectionLiterals.<XExpression>newArrayList(_xExpression);
        _switchResult = _newArrayList;
      }
    }
    if (!_matched) {
      List<XExpression> _emptyList = CollectionLiterals.<XExpression>emptyList();
      _switchResult = _emptyList;
    }
    final List<XExpression> children = _switchResult;
    boolean _and = false;
    EList<JvmFormalParameter> _declaredFormalParameters = expr.getDeclaredFormalParameters();
    boolean _isEmpty = _declaredFormalParameters.isEmpty();
    if (!_isEmpty) {
      _and = false;
    } else {
      boolean _isEmpty_1 = children.isEmpty();
      _and = (_isEmpty && _isEmpty_1);
    }
    if (_and) {
      ILeafNode _nodeForKeyword_4 = this._nodeModelAccess.nodeForKeyword(expr, "[");
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword_4, _function);
      format.operator_add(_append);
    } else {
      boolean _isMultilineLambda = this.isMultilineLambda(expr);
      if (_isMultilineLambda) {
        this.formatClosureMultiLine(expr, open, children, close, format);
      } else {
        this.formatClosureWrapIfNeeded(expr, open, children, close, format);
      }
    }
  }
  
  protected void formatClosureMultiLine(final XClosure expr, final INode open, final Collection<XExpression> children, final INode close, final FormattableDocument format) {
    this.formatClosureParameters(expr, format);
    final INode explicit = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XCLOSURE__EXPLICIT_SYNTAX);
    boolean _notEquals = (!Objects.equal(explicit, null));
    if (_notEquals) {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.oneSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(open, _function);
      format.operator_add(_append);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.oneSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(explicit, _function_1);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(explicit, _function_2);
      format.operator_add(_append_1);
    } else {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(open, _function_3);
      format.operator_add(_append_2);
    }
    for (final XExpression c : children) {
      {
        this.format(c, format);
        final INode node = this._nodeModelAccess.nodeForEObject(c);
        final ILeafNode semicolon = this._nodeModelAccess.immediatelyFollowingKeyword(node, ";");
        final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(semicolon, _function_4);
        format.operator_add(_prepend_1);
        XExpression _last = IterableExtensions.<XExpression>last(children);
        boolean _notEquals_1 = (!Objects.equal(c, _last));
        if (_notEquals_1) {
          INode _elvis = ObjectExtensions.<INode>operator_elvis(semicolon, node);
          final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.newLine();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(_elvis, _function_5);
          format.operator_add(_append_3);
        }
      }
    }
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.newLine();
          it.decreaseIndentation();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(close, _function_4);
    format.operator_add(_prepend_1);
  }
  
  protected void formatClosureParameters(final XClosure expr, final FormattableDocument format) {
    boolean _isExplicitSyntax = expr.isExplicitSyntax();
    if (_isExplicitSyntax) {
      EList<JvmFormalParameter> _declaredFormalParameters = expr.getDeclaredFormalParameters();
      for (final JvmFormalParameter param : _declaredFormalParameters) {
        {
          this.format(param, format);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(param, ",");
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_immediatelyFollowingKeyword, _function, _function_1);
          format.operator_add(_surround);
        }
      }
    }
  }
  
  protected void formatClosureWrapIfNeeded(final XClosure expr, final INode open, final Collection<XExpression> children, final INode close, final FormattableDocument format) {
    this.formatClosureParameters(expr, format);
    INode last = open;
    boolean _isExplicitSyntax = expr.isExplicitSyntax();
    if (_isExplicitSyntax) {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(open, _function);
      format.operator_add(_append);
      INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XCLOSURE__EXPLICIT_SYNTAX);
      last = _nodeForFeature;
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(last, _function_1);
      format.operator_add(_prepend);
    }
    boolean indented = false;
    for (final XExpression c : children) {
      {
        boolean _fitsIntoLine = this.fitsIntoLine(format, c);
        if (_fitsIntoLine) {
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                XExpression _head = IterableExtensions.<XExpression>head(children);
                boolean _equals = Objects.equal(_head, c);
                if (_equals) {
                  it.noSpace();
                } else {
                  it.oneSpace();
                }
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(last, _function_2);
          format.operator_add(_append_1);
        } else {
          boolean _not = (!indented);
          if (_not) {
            indented = true;
            final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.increaseIndentation();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(last, _function_3);
            format.operator_add(_append_2);
          }
          final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.newLine();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(last, _function_4);
          format.operator_add(_append_3);
        }
        this.format(c, format);
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(c);
        last = _nodeForEObject;
        final ILeafNode semicolon = this._nodeModelAccess.immediatelyFollowingKeyword(last, ";");
        boolean _notEquals = (!Objects.equal(semicolon, null));
        if (_notEquals) {
          final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(semicolon, _function_5);
          format.operator_add(_prepend_1);
          last = semicolon;
        }
      }
    }
    if (indented) {
      XExpression _last = IterableExtensions.<XExpression>last(children);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_last);
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(_nodeForEObject, _function_2);
      format.operator_add(_append_1);
    }
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(close, _function_3);
    format.operator_add(_prepend_1);
  }
  
  protected boolean isMultiline(final XExpression expression, final FormattableDocument doc) {
    final INode node = this._nodeModelAccess.nodeForEObject(expression);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(node, null));
    if (!_notEquals) {
      _and = false;
    } else {
      int _startLine = node.getStartLine();
      int _endLine = node.getEndLine();
      boolean _notEquals_1 = (_startLine != _endLine);
      _and = (_notEquals && _notEquals_1);
    }
    return _and;
  }
  
  /**
   * checks whether the given lambda should be formatted as a block.
   * That includes newlines after and before the brackets, and a fresh line for each expression.
   */
  protected boolean isMultilineLambda(final XClosure closure) {
    final ILeafNode closingBracket = this._nodeModelAccess.nodeForKeyword(closure, "]");
    HiddenLeafs _hiddenLeafsBefore = closingBracket==null?(HiddenLeafs)null:this._nodeModelAccess.getHiddenLeafsBefore(closingBracket);
    boolean _notEquals = (!Objects.equal(_hiddenLeafsBefore, null));
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsBefore_1 = this._nodeModelAccess.getHiddenLeafsBefore(closingBracket);
      Integer _newLines = _hiddenLeafsBefore_1.getNewLines();
      return ((_newLines).intValue() > 0);
    }
    boolean _switchResult = false;
    XExpression _expression = closure.getExpression();
    final XExpression block = _expression;
    boolean _matched = false;
    if (!_matched) {
      if (block instanceof XBlockExpression) {
        final XBlockExpression _xBlockExpression = (XBlockExpression)block;
        _matched=true;
        boolean _and = false;
        EList<XExpression> _expressions = _xBlockExpression.getExpressions();
        int _size = _expressions.size();
        boolean _greaterThan = (_size > 1);
        if (!_greaterThan) {
          _and = false;
        } else {
          EList<XExpression> _expressions_1 = _xBlockExpression.getExpressions();
          boolean _isEachExpressionInOwnLine = this.isEachExpressionInOwnLine(_expressions_1);
          _and = (_greaterThan && _isEachExpressionInOwnLine);
        }
        _switchResult = _and;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  protected boolean _isMultiParamInOwnLine(final XMemberFeatureCall fc, final FormattableDocument doc) {
    final ILeafNode closingBracket = this._nodeModelAccess.nodeForKeyword(fc, ")");
    HiddenLeafs _hiddenLeafsBefore = closingBracket==null?(HiddenLeafs)null:this._nodeModelAccess.getHiddenLeafsBefore(closingBracket);
    boolean _notEquals = (!Objects.equal(_hiddenLeafsBefore, null));
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsBefore_1 = this._nodeModelAccess.getHiddenLeafsBefore(closingBracket);
      Integer _newLines = _hiddenLeafsBefore_1.getNewLines();
      return ((_newLines).intValue() > 0);
    }
    EList<XExpression> _memberCallArguments = fc.getMemberCallArguments();
    final Iterable<XExpression> params = this.explicitParams(_memberCallArguments);
    boolean _and = false;
    int _size = IterableExtensions.size(params);
    boolean _greaterThan = (_size > 1);
    if (!_greaterThan) {
      _and = false;
    } else {
      boolean _isEachExpressionInOwnLine = this.isEachExpressionInOwnLine(params);
      _and = (_greaterThan && _isEachExpressionInOwnLine);
    }
    return _and;
  }
  
  protected boolean _isMultiParamInOwnLine(final XFeatureCall fc, final FormattableDocument doc) {
    final ILeafNode closingBracket = this._nodeModelAccess.nodeForKeyword(fc, ")");
    HiddenLeafs _hiddenLeafsBefore = closingBracket==null?(HiddenLeafs)null:this._nodeModelAccess.getHiddenLeafsBefore(closingBracket);
    boolean _notEquals = (!Objects.equal(_hiddenLeafsBefore, null));
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsBefore_1 = this._nodeModelAccess.getHiddenLeafsBefore(closingBracket);
      Integer _newLines = _hiddenLeafsBefore_1.getNewLines();
      return ((_newLines).intValue() > 0);
    }
    EList<XExpression> _featureCallArguments = fc.getFeatureCallArguments();
    final Iterable<XExpression> params = this.explicitParams(_featureCallArguments);
    boolean _and = false;
    int _size = IterableExtensions.size(params);
    boolean _greaterThan = (_size > 1);
    if (!_greaterThan) {
      _and = false;
    } else {
      boolean _isEachExpressionInOwnLine = this.isEachExpressionInOwnLine(params);
      _and = (_greaterThan && _isEachExpressionInOwnLine);
    }
    return _and;
  }
  
  protected boolean _isMultiParamInOwnLine(final XConstructorCall fc, final FormattableDocument doc) {
    final ILeafNode closingBracket = this._nodeModelAccess.nodeForKeyword(fc, ")");
    HiddenLeafs _hiddenLeafsBefore = closingBracket==null?(HiddenLeafs)null:this._nodeModelAccess.getHiddenLeafsBefore(closingBracket);
    boolean _notEquals = (!Objects.equal(_hiddenLeafsBefore, null));
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsBefore_1 = this._nodeModelAccess.getHiddenLeafsBefore(closingBracket);
      Integer _newLines = _hiddenLeafsBefore_1.getNewLines();
      return ((_newLines).intValue() > 0);
    }
    EList<XExpression> _arguments = fc.getArguments();
    final Iterable<XExpression> params = this.explicitParams(_arguments);
    boolean _and = false;
    int _size = IterableExtensions.size(params);
    boolean _greaterThan = (_size > 1);
    if (!_greaterThan) {
      _and = false;
    } else {
      boolean _isEachExpressionInOwnLine = this.isEachExpressionInOwnLine(params);
      _and = (_greaterThan && _isEachExpressionInOwnLine);
    }
    return _and;
  }
  
  private boolean isEachExpressionInOwnLine(final Iterable<? extends XExpression> expressions) {
    int lastLine = (-1);
    for (final XExpression e : expressions) {
      {
        final INode node = this._nodeModelAccess.nodeForEObject(e);
        int _startLine = node.getStartLine();
        boolean _equals = (lastLine == _startLine);
        if (_equals) {
          return false;
        }
        int _endLine = node.getEndLine();
        lastLine = _endLine;
      }
    }
    return true;
  }
  
  protected void _format(final XIfExpression expr, final FormattableDocument format) {
    EObject _eContainer = expr.eContainer();
    if ((_eContainer instanceof XVariableDeclaration)) {
      ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "if");
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, _function);
      format.operator_add(_append);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(expr);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(_nodeForEObject, _function_1);
      format.operator_add(_append_1);
    }
    XExpression _then = expr.getThen();
    final INode thennode = this._nodeModelAccess.nodeForEObject(_then);
    XExpression _else = expr.getElse();
    final INode elsenode = _else==null?(INode)null:this._nodeModelAccess.nodeForEObject(_else);
    boolean _or = false;
    boolean _or_1 = false;
    String _text = thennode==null?(String)null:thennode.getText();
    String _trim = _text==null?(String)null:_text.trim();
    boolean _contains = _trim==null?false:_trim.contains("\n");
    if (_contains) {
      _or_1 = true;
    } else {
      ILeafNode _whitespaceBefore = thennode==null?(ILeafNode)null:this._nodeModelAccess.whitespaceBefore(thennode);
      String _text_1 = _whitespaceBefore==null?(String)null:_whitespaceBefore.getText();
      boolean _contains_1 = _text_1==null?false:_text_1.contains("\n");
      _or_1 = (_contains || _contains_1);
    }
    if (_or_1) {
      _or = true;
    } else {
      String _text_2 = elsenode==null?(String)null:elsenode.getText();
      String _trim_1 = _text_2==null?(String)null:_text_2.trim();
      boolean _contains_2 = _trim_1==null?false:_trim_1.contains("\n");
      _or = (_or_1 || _contains_2);
    }
    final boolean multiline = _or;
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XIF_EXPRESSION__IF);
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForFeature, _function_2);
    format.operator_add(_surround);
    boolean _or_2 = false;
    XExpression _then_1 = expr.getThen();
    if ((_then_1 instanceof XBlockExpression)) {
      _or_2 = true;
    } else {
      _or_2 = ((_then_1 instanceof XBlockExpression) || multiline);
    }
    if (_or_2) {
      ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(expr, "if");
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(_nodeForKeyword_1, this._xtendFormatterConfigKeys.whitespaceBetweenKeywordAndParenthesisML);
      format.operator_add(_append_2);
    } else {
      ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(expr, "if");
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(_nodeForKeyword_2, this._xtendFormatterConfigKeys.whitespaceBetweenKeywordAndParenthesisSL);
      format.operator_add(_append_3);
    }
    XExpression _then_2 = expr.getThen();
    if ((_then_2 instanceof XBlockExpression)) {
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(thennode, this._xtendFormatterConfigKeys.bracesInNewLine);
      format.operator_add(_prepend);
      XExpression _else_1 = expr.getElse();
      boolean _notEquals = (!Objects.equal(_else_1, null));
      if (_notEquals) {
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formatterExtensions.append(thennode, this._xtendFormatterConfigKeys.bracesInNewLine);
        format.operator_add(_append_4);
      }
    } else {
      boolean _not = (!multiline);
      if (_not) {
        final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(thennode, _function_3);
        format.operator_add(_prepend_1);
        XExpression _else_2 = expr.getElse();
        boolean _notEquals_1 = (!Objects.equal(_else_2, null));
        if (_notEquals_1) {
          final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_5 = this._formatterExtensions.append(thennode, _function_4);
          format.operator_add(_append_5);
        }
      } else {
        final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_2 = this._formatterExtensions.prepend(thennode, _function_5);
        format.operator_add(_prepend_2);
        XExpression _else_3 = expr.getElse();
        boolean _notEquals_2 = (!Objects.equal(_else_3, null));
        if (_notEquals_2) {
          final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.newLine();
                it.decreaseIndentation();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_6 = this._formatterExtensions.append(thennode, _function_6);
          format.operator_add(_append_6);
        } else {
          final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.decreaseIndentation();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_7 = this._formatterExtensions.append(thennode, _function_7);
          format.operator_add(_append_7);
        }
      }
    }
    XExpression _else_4 = expr.getElse();
    if ((_else_4 instanceof XBlockExpression)) {
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_3 = this._formatterExtensions.prepend(elsenode, this._xtendFormatterConfigKeys.bracesInNewLine);
      format.operator_add(_prepend_3);
    } else {
      boolean _or_3 = false;
      XExpression _else_5 = expr.getElse();
      if ((_else_5 instanceof XIfExpression)) {
        _or_3 = true;
      } else {
        boolean _not_1 = (!multiline);
        _or_3 = ((_else_5 instanceof XIfExpression) || _not_1);
      }
      if (_or_3) {
        final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_4 = this._formatterExtensions.prepend(elsenode, _function_8);
        format.operator_add(_prepend_4);
      } else {
        final Procedure1<FormattingDataInit> _function_9 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_5 = this._formatterExtensions.prepend(elsenode, _function_9);
        format.operator_add(_prepend_5);
        final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.decreaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_8 = this._formatterExtensions.append(elsenode, _function_10);
        format.operator_add(_append_8);
      }
    }
    XExpression _if = expr.getIf();
    this.format(_if, format);
    XExpression _then_3 = expr.getThen();
    this.format(_then_3, format);
    XExpression _else_6 = expr.getElse();
    boolean _notEquals_3 = (!Objects.equal(_else_6, null));
    if (_notEquals_3) {
      XExpression _else_7 = expr.getElse();
      this.format(_else_7, format);
    }
  }
  
  protected void _format(final XForLoopExpression expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "for");
    final Procedure1<ILeafNode> _function = new Procedure1<ILeafNode>() {
        public void apply(final ILeafNode it) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XtendFormatter.this._formatterExtensions.append(it, _function);
          format.operator_add(_append);
        }
      };
    ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword, _function);
    JvmFormalParameter _declaredParam = expr.getDeclaredParam();
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_declaredParam);
    final Procedure1<INode> _function_1 = new Procedure1<INode>() {
        public void apply(final INode it) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XtendFormatter.this._formatterExtensions.prepend(it, _function);
          format.operator_add(_prepend);
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XtendFormatter.this._formatterExtensions.append(it, _function_1);
          format.operator_add(_append);
        }
      };
    ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject, _function_1);
    XExpression _forExpression = expr.getForExpression();
    INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(_forExpression);
    final Procedure1<INode> _function_2 = new Procedure1<INode>() {
        public void apply(final INode it) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XtendFormatter.this._formatterExtensions.prepend(it, _function);
          format.operator_add(_prepend);
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XtendFormatter.this._formatterExtensions.append(it, _function_1);
          format.operator_add(_append);
        }
      };
    ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject_1, _function_2);
    XExpression _eachExpression = expr.getEachExpression();
    final INode each = this._nodeModelAccess.nodeForEObject(_eachExpression);
    XExpression _eachExpression_1 = expr.getEachExpression();
    if ((_eachExpression_1 instanceof XBlockExpression)) {
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(each, this._xtendFormatterConfigKeys.bracesInNewLine);
      format.operator_add(_prepend);
    } else {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(each, _function_3);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(each, _function_4);
      format.operator_add(_append);
    }
    XExpression _forExpression_1 = expr.getForExpression();
    this.format(_forExpression_1, format);
    XExpression _eachExpression_2 = expr.getEachExpression();
    this.format(_eachExpression_2, format);
  }
  
  protected void _format(final XWhileExpression expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "while");
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, this._xtendFormatterConfigKeys.whitespaceBetweenKeywordAndParenthesisML);
    format.operator_add(_append);
    XExpression _predicate = expr.getPredicate();
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_predicate);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForEObject, _function, _function_1);
    format.operator_add(_surround);
    XExpression _body = expr.getBody();
    final INode body = this._nodeModelAccess.nodeForEObject(_body);
    XExpression _body_1 = expr.getBody();
    if ((_body_1 instanceof XBlockExpression)) {
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(body, this._xtendFormatterConfigKeys.bracesInNewLine);
      format.operator_add(_prepend);
    } else {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(body, _function_2);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(body, _function_3);
      format.operator_add(_append_1);
    }
    XExpression _predicate_1 = expr.getPredicate();
    this.format(_predicate_1, format);
    XExpression _body_2 = expr.getBody();
    this.format(_body_2, format);
  }
  
  protected void _format(final XDoWhileExpression expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "while");
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, this._xtendFormatterConfigKeys.whitespaceBetweenKeywordAndParenthesisML);
    format.operator_add(_append);
    XExpression _predicate = expr.getPredicate();
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_predicate);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForEObject, _function, _function_1);
    format.operator_add(_surround);
    XExpression _body = expr.getBody();
    final INode body = this._nodeModelAccess.nodeForEObject(_body);
    XExpression _body_1 = expr.getBody();
    if ((_body_1 instanceof XBlockExpression)) {
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(body, this._xtendFormatterConfigKeys.bracesInNewLine);
      format.operator_add(_prepend);
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(body, this._xtendFormatterConfigKeys.bracesInNewLine);
      format.operator_add(_append_1);
    } else {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(body, _function_2);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(body, _function_3);
      format.operator_add(_append_2);
    }
    XExpression _predicate_1 = expr.getPredicate();
    this.format(_predicate_1, format);
    XExpression _body_2 = expr.getBody();
    this.format(_body_2, format);
  }
  
  protected void _format(final XBlockExpression expr, final FormattableDocument format) {
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "{");
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(expr, "}");
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(open, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(close, null));
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      EList<XExpression> _expressions = expr.getExpressions();
      boolean _isEmpty = _expressions.isEmpty();
      if (_isEmpty) {
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(open, _function);
        format.operator_add(_append);
      } else {
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.increaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(open, _function_1);
        format.operator_add(_append_1);
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(open, this._xtendFormatterConfigKeys.blankLinesAroundExpression);
        format.operator_add(_append_2);
        EList<XExpression> _expressions_1 = expr.getExpressions();
        for (final XExpression child : _expressions_1) {
          {
            this.format(child, format);
            boolean _or = false;
            EList<XExpression> _expressions_2 = expr.getExpressions();
            XExpression _last = IterableExtensions.<XExpression>last(_expressions_2);
            boolean _notEquals_2 = (!Objects.equal(child, _last));
            if (_notEquals_2) {
              _or = true;
            } else {
              boolean _notEquals_3 = (!Objects.equal(close, null));
              _or = (_notEquals_2 || _notEquals_3);
            }
            if (_or) {
              final INode childNode = this._nodeModelAccess.nodeForEObject(child);
              final ILeafNode sem = this._nodeModelAccess.immediatelyFollowingKeyword(childNode, ";");
              boolean _notEquals_4 = (!Objects.equal(sem, null));
              if (_notEquals_4) {
                final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.noSpace();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(sem, _function_2);
                format.operator_add(_prepend);
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(sem, this._xtendFormatterConfigKeys.blankLinesAroundExpression);
                format.operator_add(_append_3);
              } else {
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formatterExtensions.append(childNode, this._xtendFormatterConfigKeys.blankLinesAroundExpression);
                format.operator_add(_append_4);
              }
            }
          }
        }
        final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.decreaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(close, _function_2);
        format.operator_add(_prepend);
      }
    }
  }
  
  protected void _format(final XTypeLiteral expr, final FormattableDocument format) {
    final INode typeNode = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XTYPE_LITERAL__TYPE);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "typeof");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(typeNode, _function_1);
    format.operator_add(_prepend);
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(typeNode, _function_2);
    format.operator_add(_append_1);
    INode node = typeNode;
    boolean _notEquals = (!Objects.equal(node, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(node, "[");
        node = _immediatelyFollowingKeyword;
        boolean _notEquals_1 = (!Objects.equal(node, null));
        if (_notEquals_1) {
          final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(node, _function_3);
          format.operator_add(_append_2);
          ILeafNode _immediatelyFollowingKeyword_1 = this._nodeModelAccess.immediatelyFollowingKeyword(node, "]");
          node = _immediatelyFollowingKeyword_1;
          boolean _notEquals_2 = (!Objects.equal(node, null));
          if (_notEquals_2) {
            final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(node, _function_4);
            format.operator_add(_append_3);
          }
        }
      }
      boolean _notEquals_1 = (!Objects.equal(node, null));
      _while = _notEquals_1;
    }
  }
  
  protected void _format(final XThrowExpression expr, final FormattableDocument format) {
    XExpression _expression = expr.getExpression();
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_expression);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForEObject, _function);
    format.operator_add(_prepend);
    XExpression _expression_1 = expr.getExpression();
    this.format(_expression_1, format);
  }
  
  protected void _format(final XReturnExpression expr, final FormattableDocument format) {
    XExpression _expression = expr.getExpression();
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_expression);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(_nodeForEObject, _function);
    format.operator_add(_prepend);
    XExpression _expression_1 = expr.getExpression();
    this.format(_expression_1, format);
  }
  
  protected void _format(final XTryCatchFinallyExpression expr, final FormattableDocument format) {
    XExpression _expression = expr.getExpression();
    final INode body = this._nodeModelAccess.nodeForEObject(_expression);
    XExpression _expression_1 = expr.getExpression();
    if ((_expression_1 instanceof XBlockExpression)) {
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(body, this._xtendFormatterConfigKeys.bracesInNewLine);
      format.operator_add(_prepend);
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(body, this._xtendFormatterConfigKeys.bracesInNewLine);
      format.operator_add(_append);
    } else {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(body, _function);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(body, _function_1);
      format.operator_add(_append_1);
    }
    XExpression _expression_2 = expr.getExpression();
    this.format(_expression_2, format);
    EList<XCatchClause> _catchClauses = expr.getCatchClauses();
    for (final XCatchClause cc : _catchClauses) {
      {
        this.format(cc, format);
        boolean _or = false;
        EList<XCatchClause> _catchClauses_1 = expr.getCatchClauses();
        XCatchClause _last = IterableExtensions.<XCatchClause>last(_catchClauses_1);
        boolean _notEquals = (!Objects.equal(cc, _last));
        if (_notEquals) {
          _or = true;
        } else {
          XExpression _finallyExpression = expr.getFinallyExpression();
          boolean _notEquals_1 = (!Objects.equal(_finallyExpression, null));
          _or = (_notEquals || _notEquals_1);
        }
        if (_or) {
          XExpression _expression_3 = cc.getExpression();
          if ((_expression_3 instanceof XBlockExpression)) {
            INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(cc);
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(_nodeForEObject, this._xtendFormatterConfigKeys.bracesInNewLine);
            format.operator_add(_append_2);
          } else {
            INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(cc);
            final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formatterExtensions.append(_nodeForEObject_1, _function_2);
            format.operator_add(_append_3);
          }
        }
      }
    }
    XExpression _finallyExpression = expr.getFinallyExpression();
    boolean _notEquals = (!Objects.equal(_finallyExpression, null));
    if (_notEquals) {
      XExpression _finallyExpression_1 = expr.getFinallyExpression();
      final INode fin = this._nodeModelAccess.nodeForEObject(_finallyExpression_1);
      XExpression _finallyExpression_2 = expr.getFinallyExpression();
      if ((_finallyExpression_2 instanceof XBlockExpression)) {
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_2 = this._formatterExtensions.prepend(fin, this._xtendFormatterConfigKeys.bracesInNewLine);
        format.operator_add(_prepend_2);
      } else {
        final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_3 = this._formatterExtensions.prepend(fin, _function_2);
        format.operator_add(_prepend_3);
        final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.decreaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formatterExtensions.append(fin, _function_3);
        format.operator_add(_append_2);
      }
      XExpression _finallyExpression_3 = expr.getFinallyExpression();
      this.format(_finallyExpression_3, format);
    }
  }
  
  protected void _format(final XCatchClause expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "catch");
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, this._xtendFormatterConfigKeys.whitespaceBetweenKeywordAndParenthesisML);
    format.operator_add(_append);
    JvmFormalParameter _declaredParam = expr.getDeclaredParam();
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_declaredParam);
    final Procedure1<INode> _function = new Procedure1<INode>() {
        public void apply(final INode it) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XtendFormatter.this._formatterExtensions.prepend(it, _function);
          format.operator_add(_prepend);
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XtendFormatter.this._formatterExtensions.append(it, _function_1);
          format.operator_add(_append);
        }
      };
    ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject, _function);
    XExpression _expression = expr.getExpression();
    final INode body = this._nodeModelAccess.nodeForEObject(_expression);
    XExpression _expression_1 = expr.getExpression();
    if ((_expression_1 instanceof XBlockExpression)) {
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(body, this._xtendFormatterConfigKeys.bracesInNewLine);
      format.operator_add(_prepend);
    } else {
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formatterExtensions.prepend(body, _function_1);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formatterExtensions.append(body, _function_2);
      format.operator_add(_append_1);
    }
    JvmFormalParameter _declaredParam_1 = expr.getDeclaredParam();
    this.format(_declaredParam_1, format);
    XExpression _expression_2 = expr.getExpression();
    this.format(_expression_2, format);
  }
  
  protected void _format(final JvmFormalParameter expr, final FormattableDocument format) {
    JvmTypeReference _parameterType = expr.getParameterType();
    boolean _notEquals = (!Objects.equal(_parameterType, null));
    if (_notEquals) {
      JvmTypeReference _parameterType_1 = expr.getParameterType();
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_parameterType_1);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.oneSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForEObject, _function);
      format.operator_add(_append);
    }
    JvmTypeReference _parameterType_2 = expr.getParameterType();
    this.format(_parameterType_2, format);
  }
  
  protected void _format(final XExpression expr, final FormattableDocument format) {
    EList<EObject> _eContents = expr.eContents();
    for (final EObject obj : _eContents) {
      boolean _matched = false;
      if (!_matched) {
        if (obj instanceof XExpression) {
          final XExpression _xExpression = (XExpression)obj;
          _matched=true;
          this.format(_xExpression, format);
        }
      }
    }
  }
  
  protected String lookahead(final FormattableDocument fmt, final EObject expression) {
    String _xblockexpression = null;
    {
      FormattableDocument _formattableDocument = new FormattableDocument(fmt);
      final FormattableDocument lookahead = _formattableDocument;
      this.format(expression, lookahead);
      final INode node = this._nodeModelAccess.nodeForEObject(expression);
      String _xifexpression = null;
      boolean _notEquals = (!Objects.equal(node, null));
      if (_notEquals) {
        int _offset = node.getOffset();
        int _length = node.getLength();
        String _renderToString = lookahead.renderToString(_offset, _length);
        _xifexpression = _renderToString;
      } else {
        _xifexpression = "";
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected boolean fitsIntoLine(final FormattableDocument fmt, final EObject expression) {
    final INode node = this._nodeModelAccess.nodeForEObject(expression);
    final String lookahead = this.lookahead(fmt, expression);
    boolean _or = false;
    boolean _equals = Objects.equal(node, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _contains = lookahead.contains("\n");
      _or = (_equals || _contains);
    }
    if (_or) {
      return false;
    } else {
      int _offset = node.getOffset();
      int _lineLengthBefore = fmt.lineLengthBefore(_offset);
      int _length = lookahead.length();
      final int length = (_lineLengthBefore + _length);
      IConfigurationValues<XtendFormatterConfigKeys> _cfg = fmt.getCfg();
      Integer _get = _cfg.<Integer>get(this._xtendFormatterConfigKeys.maxLineWidth);
      return (length <= (_get).intValue());
    }
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
    } else if (clazz instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)clazz, format);
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
    } else if (clazz instanceof XtendImport) {
      _format((XtendImport)clazz, format);
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
  
  protected boolean isMultiParamInOwnLine(final XExpression fc, final FormattableDocument doc) {
    if (fc instanceof XFeatureCall) {
      return _isMultiParamInOwnLine((XFeatureCall)fc, doc);
    } else if (fc instanceof XMemberFeatureCall) {
      return _isMultiParamInOwnLine((XMemberFeatureCall)fc, doc);
    } else if (fc instanceof XConstructorCall) {
      return _isMultiParamInOwnLine((XConstructorCall)fc, doc);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(fc, doc).toString());
    }
  }
}
