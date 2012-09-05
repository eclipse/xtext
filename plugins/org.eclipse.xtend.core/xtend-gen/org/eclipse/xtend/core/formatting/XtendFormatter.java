package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.formatting.FormattableDocument;
import org.eclipse.xtend.core.formatting.FormatterExtensions;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.FormattingDataInit;
import org.eclipse.xtend.core.formatting.NodeModelAccess;
import org.eclipse.xtend.core.formatting.RendererConfiguration;
import org.eclipse.xtend.core.formatting.RichStringFormatter;
import org.eclipse.xtend.core.formatting.TextReplacement;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.XtendClass;
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
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

@SuppressWarnings(value = "restriction")
public class XtendFormatter {
  @Inject
  private IWhitespaceInformationProvider whitespaeInfo;
  
  @Inject
  private NodeModelAccess _nodeModelAccess;
  
  @Inject
  private FormatterExtensions _formatterExtensions;
  
  @Inject
  private RichStringFormatter richStringFormatter;
  
  public List<TextReplacement> format(final XtextResource res, final int offset, final int length, final RendererConfiguration cfg) {
    List<TextReplacement> _xblockexpression = null;
    {
      URI _uRI = res.getURI();
      ILineSeparatorInformation _lineSeparatorInformation = this.whitespaeInfo.getLineSeparatorInformation(_uRI);
      String _lineSeparator = _lineSeparatorInformation.getLineSeparator();
      cfg.setLineSeparator(_lineSeparator);
      URI _uRI_1 = res.getURI();
      IIndentationInformation _indentationInformation = this.whitespaeInfo.getIndentationInformation(_uRI_1);
      String _indentString = _indentationInformation.getIndentString();
      cfg.setIndentation(_indentString);
      IParseResult _parseResult = res.getParseResult();
      ICompositeNode _rootNode = _parseResult.getRootNode();
      final String text = _rootNode.getText();
      FormattableDocument _formattableDocument = new FormattableDocument(cfg, text);
      final FormattableDocument format = _formattableDocument;
      EList<EObject> _contents = res.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      this.format(((XtendFile) _head), format);
      List<TextReplacement> _renderToEdits = format.renderToEdits(offset, length);
      _xblockexpression = (_renderToEdits);
    }
    return _xblockexpression;
  }
  
  public void format(final XtextResource res, final int offset, final int length, final RendererConfiguration cfg, final Procedure3<? super Integer,? super Integer,? super String> out) {
    List<TextReplacement> _format = this.format(res, offset, length, cfg);
    final Procedure1<TextReplacement> _function = new Procedure1<TextReplacement>() {
        public void apply(final TextReplacement e) {
          int _offset = e.getOffset();
          int _length = e.getLength();
          String _text = e.getText();
          out.apply(Integer.valueOf(_offset), Integer.valueOf(_length), _text);
        }
      };
    IterableExtensions.<TextReplacement>forEach(_format, _function);
  }
  
  protected void _format(final XtendFile xtendFile, final FormattableDocument format) {
    final INode pkg = this._nodeModelAccess.nodeForFeature(xtendFile, Literals.XTEND_FILE__PACKAGE);
    final ILeafNode pkgSemicolon = this._nodeModelAccess.immediatelyFollowingKeyword(pkg, ";");
    boolean _notEquals = (!Objects.equal(pkgSemicolon, null));
    if (_notEquals) {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = "";
          }
        };
      FormattingData _append = this._formatterExtensions.append(pkg, _function);
      format.operator_add(_append);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLines = 2;
          }
        };
      FormattingData _append_1 = this._formatterExtensions.append(pkgSemicolon, _function_1);
      format.operator_add(_append_1);
    } else {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLines = 2;
          }
        };
      FormattingData _append_2 = this._formatterExtensions.append(pkg, _function_2);
      format.operator_add(_append_2);
    }
    EList<XtendImport> _imports = xtendFile.getImports();
    for (final XtendImport imp : _imports) {
      EList<XtendImport> _imports_1 = xtendFile.getImports();
      XtendImport _last = IterableExtensions.<XtendImport>last(_imports_1);
      boolean _notEquals_1 = (!Objects.equal(imp, _last));
      if (_notEquals_1) {
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(imp);
        final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
            }
          };
        FormattingData _append_3 = this._formatterExtensions.append(_nodeForEObject, _function_3);
        format.operator_add(_append_3);
      } else {
        INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(imp);
        final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLines = 2;
            }
          };
        FormattingData _append_4 = this._formatterExtensions.append(_nodeForEObject_1, _function_4);
        format.operator_add(_append_4);
      }
    }
    EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
    for (final XtendTypeDeclaration clazz : _xtendTypes) {
      this.format(clazz, format);
    }
    INode _nodeForEObject_2 = this._nodeModelAccess.nodeForEObject(xtendFile);
    final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.newLine();
        }
      };
    FormattingData _append_5 = this._formatterExtensions.append(_nodeForEObject_2, _function_5);
    format.operator_add(_append_5);
  }
  
  protected void _format(final XtendClass clazz, final FormattableDocument format) {
    EList<XAnnotation> _annotations = clazz.getAnnotations();
    for (final XAnnotation annotation : _annotations) {
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(annotation);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
          }
        };
      FormattingData _append = this._formatterExtensions.append(_nodeForEObject, _function);
      format.operator_add(_append);
    }
    final ILeafNode clazzOpenBrace = this._nodeModelAccess.nodeForKeyword(clazz, "{");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.space = " ";
        }
      };
    FormattingData _prepend = this._formatterExtensions.prepend(clazzOpenBrace, _function_1);
    format.operator_add(_prepend);
    EList<XtendMember> _members = clazz.getMembers();
    boolean _isEmpty = _members.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      FormattingData _append_1 = this._formatterExtensions.append(clazzOpenBrace, _function_2);
      format.operator_add(_append_1);
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
              INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(current);
              final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                  }
                };
              FormattingData _append_2 = this._formatterExtensions.append(_nodeForEObject_1, _function_3);
              format.operator_add(_append_2);
            } else {
              INode _nodeForEObject_2 = this._nodeModelAccess.nodeForEObject(current);
              final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLines = 2;
                  }
                };
              FormattingData _append_3 = this._formatterExtensions.append(_nodeForEObject_2, _function_4);
              format.operator_add(_append_3);
            }
          } else {
            EList<XtendMember> _members_5 = clazz.getMembers();
            XtendMember _get = _members_5.get((i).intValue());
            INode _nodeForEObject_3 = this._nodeModelAccess.nodeForEObject(_get);
            final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                  it.decreaseIndentation();
                }
              };
            FormattingData _append_4 = this._formatterExtensions.append(_nodeForEObject_3, _function_5);
            format.operator_add(_append_4);
          }
        }
      }
    } else {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
          }
        };
      FormattingData _append_2 = this._formatterExtensions.append(clazzOpenBrace, _function_3);
      format.operator_add(_append_2);
    }
  }
  
  protected void _format(final XtendFunction func, final FormattableDocument format) {
    final INode nameNode = this._nodeModelAccess.nodeForFeature(func, Literals.XTEND_FUNCTION__NAME);
    final ILeafNode open = this._nodeModelAccess.immediatelyFollowingKeyword(nameNode, "(");
    INode comma = null;
    boolean indented = false;
    EList<XtendParameter> _parameters = func.getParameters();
    for (final XtendParameter param : _parameters) {
      {
        boolean _fitsIntoLine = this.fitsIntoLine(format, param);
        if (_fitsIntoLine) {
          boolean _equals = Objects.equal(comma, null);
          if (_equals) {
            final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            FormattingData _append = this._formatterExtensions.append(open, _function);
            format.operator_add(_append);
          } else {
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.oneSpace();
                }
              };
            FormattingData _append_1 = this._formatterExtensions.append(comma, _function_1);
            format.operator_add(_append_1);
          }
        } else {
          INode _xifexpression = null;
          boolean _equals_1 = Objects.equal(comma, null);
          if (_equals_1) {
            _xifexpression = open;
          } else {
            _xifexpression = comma;
          }
          final INode n = _xifexpression;
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.newLine();
              }
            };
          FormattingData _append_2 = this._formatterExtensions.append(n, _function_2);
          format.operator_add(_append_2);
          boolean _not = (!indented);
          if (_not) {
            final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.increaseIndentation();
                }
              };
            FormattingData _append_3 = this._formatterExtensions.append(n, _function_3);
            format.operator_add(_append_3);
          }
          indented = true;
        }
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(param);
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
        comma = _immediatelyFollowingKeyword;
      }
    }
    EList<XtendParameter> _parameters_1 = func.getParameters();
    int _size = _parameters_1.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      EList<XtendParameter> _parameters_2 = func.getParameters();
      XtendParameter _last = IterableExtensions.<XtendParameter>last(_parameters_2);
      final INode last = this._nodeModelAccess.nodeForEObject(_last);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      FormattingData _append = this._formatterExtensions.append(last, _function);
      format.operator_add(_append);
      if (indented) {
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.decreaseIndentation();
            }
          };
        FormattingData _append_1 = this._formatterExtensions.append(last, _function_1);
        format.operator_add(_append_1);
      }
    } else {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      FormattingData _append_2 = this._formatterExtensions.append(open, _function_2);
      format.operator_add(_append_2);
    }
    XExpression _expression = func.getExpression();
    this.format(_expression, format);
  }
  
  protected void _format(final XtendParameter param, final FormattableDocument format) {
  }
  
  protected void _format(final RichString rs, final FormattableDocument format) {
    this.richStringFormatter.format(this, format, rs);
  }
  
  protected void _format(final XVariableDeclaration expr, final FormattableDocument format) {
    XExpression _right = expr.getRight();
    this.format(_right, format);
  }
  
  protected void _format(final Void expr, final FormattableDocument format) {
  }
  
  protected void _format(final EObject expr, final FormattableDocument format) {
  }
  
  protected void formatFeatureCallParams(final List<XExpression> params, final FormattableDocument format) {
    INode node = null;
    boolean indented = false;
    for (final XExpression arg : params) {
      {
        boolean _notEquals = (!Objects.equal(node, null));
        if (_notEquals) {
          boolean _fitsIntoLine = this.fitsIntoLine(format, arg);
          if (_fitsIntoLine) {
            final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.space = " ";
                }
              };
            FormattingData _append = this._formatterExtensions.append(node, _function);
            format.operator_add(_append);
          } else {
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                }
              };
            FormattingData _append_1 = this._formatterExtensions.append(node, _function_1);
            format.operator_add(_append_1);
            boolean _not = (!indented);
            if (_not) {
              final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.increaseIndentation();
                  }
                };
              FormattingData _append_2 = this._formatterExtensions.append(node, _function_2);
              format.operator_add(_append_2);
            }
            indented = true;
          }
        }
        this.format(arg, format);
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(arg);
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
        node = _immediatelyFollowingKeyword;
      }
    }
    if (indented) {
      XExpression _last = IterableExtensions.<XExpression>last(params);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_last);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      FormattingData _append = this._formatterExtensions.append(_nodeForEObject, _function);
      format.operator_add(_append);
    }
  }
  
  protected void _format(final XConstructorCall expr, final FormattableDocument format) {
    EList<XExpression> _arguments = expr.getArguments();
    this.formatFeatureCallParams(_arguments, format);
  }
  
  protected void _format(final XFeatureCall expr, final FormattableDocument format) {
    boolean _isExplicitOperationCall = expr.isExplicitOperationCall();
    if (_isExplicitOperationCall) {
      EList<XExpression> _featureCallArguments = expr.getFeatureCallArguments();
      this.formatFeatureCallParams(_featureCallArguments, format);
    } else {
      EList<XExpression> _featureCallArguments_1 = expr.getFeatureCallArguments();
      for (final XExpression arg : _featureCallArguments_1) {
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
      boolean _isExplicitOperationCall = call.isExplicitOperationCall();
      if (_isExplicitOperationCall) {
        XExpression _memberCallTarget = call.getMemberCallTarget();
        final INode targetNode = this._nodeModelAccess.nodeForEObject(_memberCallTarget);
        final INode callNode = this._nodeModelAccess.nodeForEObject(call);
        int _offset = targetNode.getOffset();
        int _length = targetNode.getLength();
        final int callOffset = (_offset + _length);
        int _offset_1 = callNode.getOffset();
        int _length_1 = callNode.getLength();
        int _plus = (_offset_1 + _length_1);
        final int callLength = (_plus - callOffset);
        String _xifexpression = null;
        boolean _isNullSafe = call.isNullSafe();
        if (_isNullSafe) {
          _xifexpression = "?.";
        } else {
          String _xifexpression_1 = null;
          boolean _isSpreading = call.isSpreading();
          if (_isSpreading) {
            _xifexpression_1 = "*.";
          } else {
            _xifexpression_1 = ".";
          }
          _xifexpression = _xifexpression_1;
        }
        final ILeafNode op = this._nodeModelAccess.nodeForKeyword(call, _xifexpression);
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        FormattingData _prepend = this._formatterExtensions.prepend(op, _function);
        format.operator_add(_prepend);
        final Procedure1<FormattableDocument> _function_1 = new Procedure1<FormattableDocument>() {
            public void apply(final FormattableDocument f) {
              EList<XExpression> _memberCallArguments = call.getMemberCallArguments();
              XtendFormatter.this.formatFeatureCallParams(_memberCallArguments, f);
            }
          };
        boolean _fitsIntoLine = this._formatterExtensions.fitsIntoLine(format, callOffset, callLength, _function_1);
        if (_fitsIntoLine) {
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          FormattingData _append = this._formatterExtensions.append(op, _function_2);
          format.operator_add(_append);
        } else {
          final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.newLine();
              }
            };
          FormattingData _append_1 = this._formatterExtensions.append(op, _function_3);
          format.operator_add(_append_1);
          boolean _not = (!indented);
          if (_not) {
            indented = true;
            final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.increaseIndentation();
                }
              };
            FormattingData _append_2 = this._formatterExtensions.append(op, _function_4);
            format.operator_add(_append_2);
          }
        }
        EList<XExpression> _memberCallArguments = call.getMemberCallArguments();
        this.formatFeatureCallParams(_memberCallArguments, format);
      } else {
        EList<XExpression> _memberCallArguments_1 = call.getMemberCallArguments();
        for (final XExpression arg : _memberCallArguments_1) {
          this.format(arg, format);
        }
      }
    }
    if (indented) {
      XMemberFeatureCall _last = IterableExtensions.<XMemberFeatureCall>last(calls);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_last);
      final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      FormattingData _append_3 = this._formatterExtensions.append(_nodeForEObject, _function_5);
      format.operator_add(_append_3);
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
        FormattingData _prepend = this._formatterExtensions.prepend(op, _function);
        format.operator_add(_prepend);
        XExpression _rightOperand = call.getRightOperand();
        boolean _fitsIntoLine = this.fitsIntoLine(format, _rightOperand);
        if (_fitsIntoLine) {
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          FormattingData _append = this._formatterExtensions.append(op, _function_1);
          format.operator_add(_append);
        } else {
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.newLine();
              }
            };
          FormattingData _append_1 = this._formatterExtensions.append(op, _function_2);
          format.operator_add(_append_1);
          boolean _not = (!indented);
          if (_not) {
            indented = true;
            final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.increaseIndentation();
                }
              };
            FormattingData _append_2 = this._formatterExtensions.append(op, _function_3);
            format.operator_add(_append_2);
          }
        }
        XExpression _rightOperand_1 = call.getRightOperand();
        this.format(_rightOperand_1, format);
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
      FormattingData _append = this._formatterExtensions.append(_nodeForEObject, _function);
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
    if (switchSL) {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = " ";
          }
        };
      FormattingData _prepend = this._formatterExtensions.prepend(open, _function_2);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = " ";
          }
        };
      FormattingData _append = this._formatterExtensions.append(open, _function_3);
      format.operator_add(_append);
      EList<XCasePart> _cases_2 = expr.getCases();
      for (final XCasePart c : _cases_2) {
        {
          XExpression _then = c.getThen();
          final INode cnode = this._nodeModelAccess.nodeForEObject(_then);
          final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          FormattingData _prepend_1 = this._formatterExtensions.prepend(cnode, _function_4);
          format.operator_add(_prepend_1);
          final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          FormattingData _append_1 = this._formatterExtensions.append(cnode, _function_5);
          format.operator_add(_append_1);
        }
      }
    } else {
      if (caseSL) {
        final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.space = " ";
            }
          };
        FormattingData _prepend_1 = this._formatterExtensions.prepend(open, _function_4);
        format.operator_add(_prepend_1);
        final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        FormattingData _append_1 = this._formatterExtensions.append(open, _function_5);
        format.operator_add(_append_1);
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
            FormattingData _prepend_2 = this._formatterExtensions.prepend(_nodeForEObject_1, _function_6);
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
              FormattingData _append_2 = this._formatterExtensions.append(_nodeForEObject_2, _function_7);
              format.operator_add(_append_2);
            }
          }
        }
        final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.decreaseIndentation();
            }
          };
        FormattingData _prepend_2 = this._formatterExtensions.prepend(close, _function_6);
        format.operator_add(_prepend_2);
      } else {
        final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.space = " ";
            }
          };
        FormattingData _prepend_3 = this._formatterExtensions.prepend(open, _function_7);
        format.operator_add(_prepend_3);
        final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        FormattingData _append_2 = this._formatterExtensions.append(open, _function_8);
        format.operator_add(_append_2);
        EList<XCasePart> _cases_4 = expr.getCases();
        for (final XCasePart c_2 : _cases_4) {
          {
            XExpression _then = c_2.getThen();
            final INode cnode = this._nodeModelAccess.nodeForEObject(_then);
            XExpression _then_1 = c_2.getThen();
            if ((_then_1 instanceof XBlockExpression)) {
              final Procedure1<FormattingDataInit> _function_9 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.space = " ";
                  }
                };
              FormattingData _prepend_4 = this._formatterExtensions.prepend(cnode, _function_9);
              format.operator_add(_prepend_4);
              EList<XCasePart> _cases_5 = expr.getCases();
              XCasePart _last = IterableExtensions.<XCasePart>last(_cases_5);
              boolean _notEquals = (!Objects.equal(c_2, _last));
              if (_notEquals) {
                final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                FormattingData _append_3 = this._formatterExtensions.append(cnode, _function_10);
                format.operator_add(_append_3);
              } else {
                final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                      it.decreaseIndentation();
                    }
                  };
                FormattingData _append_4 = this._formatterExtensions.append(cnode, _function_11);
                format.operator_add(_append_4);
              }
            } else {
              final Procedure1<FormattingDataInit> _function_12 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                    it.increaseIndentation();
                  }
                };
              FormattingData _prepend_5 = this._formatterExtensions.prepend(cnode, _function_12);
              format.operator_add(_prepend_5);
              EList<XCasePart> _cases_6 = expr.getCases();
              XCasePart _last_1 = IterableExtensions.<XCasePart>last(_cases_6);
              boolean _notEquals_1 = (!Objects.equal(c_2, _last_1));
              if (_notEquals_1) {
                final Procedure1<FormattingDataInit> _function_13 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                      it.decreaseIndentation();
                    }
                  };
                FormattingData _append_5 = this._formatterExtensions.append(cnode, _function_13);
                format.operator_add(_append_5);
              } else {
                final Procedure1<FormattingDataInit> _function_14 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                      int _minus = (-2);
                      it.indentationChange = _minus;
                    }
                  };
                FormattingData _append_6 = this._formatterExtensions.append(cnode, _function_14);
                format.operator_add(_append_6);
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
          final Procedure1<FormattingDataInit> _function_9 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          FormattingData _append_3 = this._formatterExtensions.append(typenode, _function_9);
          format.operator_add(_append_3);
          final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          FormattingData _prepend_4 = this._formatterExtensions.prepend(casenode, _function_10);
          format.operator_add(_prepend_4);
          final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          FormattingData _append_4 = this._formatterExtensions.append(casenode, _function_11);
          format.operator_add(_append_4);
        } else {
          JvmTypeReference _typeGuard_1 = c_3.getTypeGuard();
          boolean _notEquals_2 = (!Objects.equal(_typeGuard_1, null));
          if (_notEquals_2) {
            final INode typenode_1 = this._nodeModelAccess.nodeForFeature(c_3, org.eclipse.xtext.xbase.XbasePackage.Literals.XCASE_PART__TYPE_GUARD);
            final Procedure1<FormattingDataInit> _function_12 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            FormattingData _append_5 = this._formatterExtensions.append(typenode_1, _function_12);
            format.operator_add(_append_5);
          } else {
            XExpression _case_1 = c_3.getCase();
            boolean _notEquals_3 = (!Objects.equal(_case_1, null));
            if (_notEquals_3) {
              final INode casenode_1 = this._nodeModelAccess.nodeForFeature(c_3, org.eclipse.xtext.xbase.XbasePackage.Literals.XCASE_PART__CASE);
              final Procedure1<FormattingDataInit> _function_13 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.space = " ";
                  }
                };
              FormattingData _prepend_5 = this._formatterExtensions.prepend(casenode_1, _function_13);
              format.operator_add(_prepend_5);
              final Procedure1<FormattingDataInit> _function_14 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.noSpace();
                  }
                };
              FormattingData _append_6 = this._formatterExtensions.append(casenode_1, _function_14);
              format.operator_add(_append_6);
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
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "[");
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(expr, "]");
    final INode explicit = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XCLOSURE__EXPLICIT_SYNTAX);
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(expr);
    String _text = _nodeForEObject.getText();
    String _trim = _text.trim();
    final boolean multiline = _trim.contains("\n");
    XExpression _expression = expr.getExpression();
    final XExpression child = _expression;
    boolean _matched = false;
    if (!_matched) {
      if (child instanceof XBlockExpression) {
        final XBlockExpression _xBlockExpression = (XBlockExpression)child;
        boolean _and = false;
        EList<JvmFormalParameter> _declaredFormalParameters = expr.getDeclaredFormalParameters();
        boolean _isEmpty = _declaredFormalParameters.isEmpty();
        if (!_isEmpty) {
          _and = false;
        } else {
          EList<XExpression> _expressions = _xBlockExpression.getExpressions();
          boolean _isEmpty_1 = _expressions.isEmpty();
          _and = (_isEmpty && _isEmpty_1);
        }
        if (_and) {
          _matched=true;
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          FormattingData _append = open==null?(FormattingData)null:this._formatterExtensions.append(open, _function);
          format.operator_add(_append);
        }
      }
    }
    if (!_matched) {
      if (child instanceof XBlockExpression) {
        final XBlockExpression _xBlockExpression = (XBlockExpression)child;
        if (multiline) {
          _matched=true;
          boolean _notEquals = (!Objects.equal(explicit, null));
          if (_notEquals) {
            final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                  it.increaseIndentation();
                }
              };
            FormattingData _append = this._formatterExtensions.append(explicit, _function);
            format.operator_add(_append);
          } else {
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                  it.increaseIndentation();
                }
              };
            FormattingData _append_1 = open==null?(FormattingData)null:this._formatterExtensions.append(open, _function_1);
            format.operator_add(_append_1);
          }
          EList<XExpression> _expressions = _xBlockExpression.getExpressions();
          for (final XExpression c : _expressions) {
            {
              this.format(c, format);
              EList<XExpression> _expressions_1 = _xBlockExpression.getExpressions();
              XExpression _last = IterableExtensions.<XExpression>last(_expressions_1);
              boolean _notEquals_1 = (!Objects.equal(c, _last));
              if (_notEquals_1) {
                INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(c);
                final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                FormattingData _append_2 = this._formatterExtensions.append(_nodeForEObject_1, _function_2);
                format.operator_add(_append_2);
              }
            }
          }
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.newLine();
                it.decreaseIndentation();
              }
            };
          FormattingData _prepend = close==null?(FormattingData)null:this._formatterExtensions.prepend(close, _function_2);
          format.operator_add(_prepend);
        }
      }
    }
    if (!_matched) {
      if (child instanceof XBlockExpression) {
        final XBlockExpression _xBlockExpression = (XBlockExpression)child;
        boolean _useNoSpaceInsideClosure = this.useNoSpaceInsideClosure(expr);
        if (_useNoSpaceInsideClosure) {
          _matched=true;
          EList<JvmFormalParameter> _declaredFormalParameters = expr.getDeclaredFormalParameters();
          boolean _isEmpty = _declaredFormalParameters.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            EList<JvmFormalParameter> _declaredFormalParameters_1 = expr.getDeclaredFormalParameters();
            JvmFormalParameter _get = _declaredFormalParameters_1.get(0);
            final INode n = this._nodeModelAccess.nodeForEObject(_get);
            final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            FormattingData _prepend = this._formatterExtensions.prepend(n, _function);
            format.operator_add(_prepend);
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            FormattingData _append = this._formatterExtensions.append(n, _function_1);
            format.operator_add(_append);
          }
          EList<XExpression> _expressions = _xBlockExpression.getExpressions();
          XExpression _get_1 = _expressions.get(0);
          final INode c = this._nodeModelAccess.nodeForEObject(_get_1);
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          FormattingData _prepend_1 = this._formatterExtensions.prepend(c, _function_2);
          format.operator_add(_prepend_1);
          final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          FormattingData _append_1 = this._formatterExtensions.append(c, _function_3);
          format.operator_add(_append_1);
        }
      }
    }
    if (!_matched) {
      if (child instanceof XBlockExpression) {
        final XBlockExpression _xBlockExpression = (XBlockExpression)child;
        _matched=true;
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.space = " ";
            }
          };
        FormattingData _append = open==null?(FormattingData)null:this._formatterExtensions.append(open, _function);
        format.operator_add(_append);
        EList<XExpression> _expressions = _xBlockExpression.getExpressions();
        for (final XExpression c : _expressions) {
          {
            this.format(c, format);
            INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(c);
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.space = " ";
                }
              };
            FormattingData _append_1 = this._formatterExtensions.append(_nodeForEObject_1, _function_1);
            format.operator_add(_append_1);
          }
        }
      }
    }
    if (!_matched) {
      if (child instanceof XExpression) {
        final XExpression _xExpression = (XExpression)child;
        _matched=true;
        this.format(_xExpression, format);
      }
    }
  }
  
  protected boolean useNoSpaceInsideClosure(final XExpression expression) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (expression instanceof XClosure) {
        final XClosure _xClosure = (XClosure)expression;
        _matched=true;
        boolean _and = false;
        EList<JvmFormalParameter> _declaredFormalParameters = _xClosure.getDeclaredFormalParameters();
        int _size = _declaredFormalParameters.size();
        boolean _lessEqualsThan = (_size <= 1);
        if (!_lessEqualsThan) {
          _and = false;
        } else {
          XExpression _expression = _xClosure.getExpression();
          boolean _useNoSpaceInsideClosure = this.useNoSpaceInsideClosure(_expression);
          _and = (_lessEqualsThan && _useNoSpaceInsideClosure);
        }
        _switchResult = _and;
      }
    }
    if (!_matched) {
      if (expression instanceof XBlockExpression) {
        final XBlockExpression _xBlockExpression = (XBlockExpression)expression;
        _matched=true;
        boolean _xifexpression = false;
        EList<XExpression> _expressions = _xBlockExpression.getExpressions();
        int _size = _expressions.size();
        boolean _notEquals = (_size != 1);
        if (_notEquals) {
          _xifexpression = false;
        } else {
          EList<XExpression> _expressions_1 = _xBlockExpression.getExpressions();
          XExpression _get = _expressions_1.get(0);
          boolean _useNoSpaceInsideClosure = this.useNoSpaceInsideClosure(_get);
          _xifexpression = _useNoSpaceInsideClosure;
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (expression instanceof XFeatureCall) {
        final XFeatureCall _xFeatureCall = (XFeatureCall)expression;
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (expression instanceof XBinaryOperation) {
        final XBinaryOperation _xBinaryOperation = (XBinaryOperation)expression;
        _matched=true;
        _switchResult = false;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  protected void _format(final XIfExpression expr, final FormattableDocument format) {
    EObject _eContainer = expr.eContainer();
    boolean _not = (!(_eContainer instanceof XBlockExpression));
    if (_not) {
      ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "if");
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.increaseIndentation();
          }
        };
      FormattingData _append = this._formatterExtensions.append(_nodeForKeyword, _function);
      format.operator_add(_append);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(expr);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      FormattingData _append_1 = this._formatterExtensions.append(_nodeForEObject, _function_1);
      format.operator_add(_append_1);
    }
    XExpression _then = expr.getThen();
    final INode thennode = this._nodeModelAccess.nodeForEObject(_then);
    XExpression _else = expr.getElse();
    final INode elsenode = _else==null?(INode)null:this._nodeModelAccess.nodeForEObject(_else);
    boolean _or = false;
    boolean _or_1 = false;
    String _text = thennode.getText();
    String _trim = _text.trim();
    boolean _contains = _trim.contains("\n");
    if (_contains) {
      _or_1 = true;
    } else {
      ILeafNode _whitespaceBefore = this._nodeModelAccess.whitespaceBefore(thennode);
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
    boolean _or_2 = false;
    XExpression _then_1 = expr.getThen();
    if ((_then_1 instanceof XBlockExpression)) {
      _or_2 = true;
    } else {
      boolean _not_1 = (!multiline);
      _or_2 = ((_then_1 instanceof XBlockExpression) || _not_1);
    }
    if (_or_2) {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = " ";
          }
        };
      FormattingData _prepend = this._formatterExtensions.prepend(thennode, _function_2);
      format.operator_add(_prepend);
      XExpression _else_1 = expr.getElse();
      boolean _notEquals = (!Objects.equal(_else_1, null));
      if (_notEquals) {
        final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.space = " ";
            }
          };
        FormattingData _append_2 = this._formatterExtensions.append(thennode, _function_3);
        format.operator_add(_append_2);
      }
    } else {
      final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      FormattingData _prepend_1 = this._formatterExtensions.prepend(thennode, _function_4);
      format.operator_add(_prepend_1);
      XExpression _else_2 = expr.getElse();
      boolean _notEquals_1 = (!Objects.equal(_else_2, null));
      if (_notEquals_1) {
        final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.decreaseIndentation();
            }
          };
        FormattingData _append_3 = this._formatterExtensions.append(thennode, _function_5);
        format.operator_add(_append_3);
      } else {
        final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.decreaseIndentation();
            }
          };
        FormattingData _append_4 = this._formatterExtensions.append(thennode, _function_6);
        format.operator_add(_append_4);
      }
    }
    boolean _or_3 = false;
    XExpression _else_3 = expr.getElse();
    if ((_else_3 instanceof XBlockExpression)) {
      _or_3 = true;
    } else {
      boolean _not_2 = (!multiline);
      _or_3 = ((_else_3 instanceof XBlockExpression) || _not_2);
    }
    if (_or_3) {
      final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = " ";
          }
        };
      FormattingData _prepend_2 = this._formatterExtensions.prepend(elsenode, _function_7);
      format.operator_add(_prepend_2);
    } else {
      final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      FormattingData _prepend_3 = this._formatterExtensions.prepend(elsenode, _function_8);
      format.operator_add(_prepend_3);
      final Procedure1<FormattingDataInit> _function_9 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      FormattingData _append_5 = this._formatterExtensions.append(elsenode, _function_9);
      format.operator_add(_append_5);
    }
    XExpression _then_2 = expr.getThen();
    this.format(_then_2, format);
    XExpression _else_4 = expr.getElse();
    boolean _notEquals_2 = (!Objects.equal(_else_4, null));
    if (_notEquals_2) {
      XExpression _else_5 = expr.getElse();
      this.format(_else_5, format);
    }
  }
  
  protected void _format(final XForLoopExpression expr, final FormattableDocument format) {
    XExpression _eachExpression = expr.getEachExpression();
    if ((_eachExpression instanceof XBlockExpression)) {
    } else {
      XExpression _eachExpression_1 = expr.getEachExpression();
      final INode each = this._nodeModelAccess.nodeForEObject(_eachExpression_1);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      FormattingData _prepend = this._formatterExtensions.prepend(each, _function);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      FormattingData _append = this._formatterExtensions.append(each, _function_1);
      format.operator_add(_append);
    }
    XExpression _forExpression = expr.getForExpression();
    this.format(_forExpression, format);
    XExpression _eachExpression_2 = expr.getEachExpression();
    this.format(_eachExpression_2, format);
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
        FormattingData _append = this._formatterExtensions.append(open, _function);
        format.operator_add(_append);
      } else {
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        FormattingData _append_1 = this._formatterExtensions.append(open, _function_1);
        format.operator_add(_append_1);
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
                FormattingData _prepend = this._formatterExtensions.prepend(sem, _function_2);
                format.operator_add(_prepend);
                final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                FormattingData _append_2 = this._formatterExtensions.append(sem, _function_3);
                format.operator_add(_append_2);
              } else {
                final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                FormattingData _append_3 = this._formatterExtensions.append(childNode, _function_4);
                format.operator_add(_append_3);
              }
            }
          }
        }
        final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.decreaseIndentation();
            }
          };
        FormattingData _prepend = this._formatterExtensions.prepend(close, _function_2);
        format.operator_add(_prepend);
      }
    }
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
      int _offset = node.getOffset();
      int _length = node.getLength();
      String _renderToString = lookahead.renderToString(_offset, _length);
      _xblockexpression = (_renderToString);
    }
    return _xblockexpression;
  }
  
  protected boolean fitsIntoLine(final FormattableDocument fmt, final EObject expression) {
    final INode node = this._nodeModelAccess.nodeForEObject(expression);
    final String lookahead = this.lookahead(fmt, expression);
    boolean _contains = lookahead.contains("\n");
    if (_contains) {
      return false;
    } else {
      int _offset = node.getOffset();
      int _lineLengthBefore = fmt.lineLengthBefore(_offset);
      int _length = lookahead.length();
      final int length = (_lineLengthBefore + _length);
      RendererConfiguration _cfg = fmt.getCfg();
      int _maxLineWidth = _cfg.getMaxLineWidth();
      return (length <= _maxLineWidth);
    }
  }
  
  protected void format(final EObject clazz, final FormattableDocument format) {
    if (clazz instanceof XtendClass) {
      _format((XtendClass)clazz, format);
      return;
    } else if (clazz instanceof RichString) {
      _format((RichString)clazz, format);
      return;
    } else if (clazz instanceof XtendFunction) {
      _format((XtendFunction)clazz, format);
      return;
    } else if (clazz instanceof XBinaryOperation) {
      _format((XBinaryOperation)clazz, format);
      return;
    } else if (clazz instanceof XFeatureCall) {
      _format((XFeatureCall)clazz, format);
      return;
    } else if (clazz instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)clazz, format);
      return;
    } else if (clazz instanceof XtendParameter) {
      _format((XtendParameter)clazz, format);
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
    } else if (clazz instanceof XSwitchExpression) {
      _format((XSwitchExpression)clazz, format);
      return;
    } else if (clazz instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)clazz, format);
      return;
    } else if (clazz instanceof XtendFile) {
      _format((XtendFile)clazz, format);
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
}
