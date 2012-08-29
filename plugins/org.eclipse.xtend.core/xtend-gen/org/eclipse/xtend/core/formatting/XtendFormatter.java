package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.formatting.FormattableDocument;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.FormattingDataInit;
import org.eclipse.xtend.core.formatting.NewLineData;
import org.eclipse.xtend.core.formatting.NodeModelAccess;
import org.eclipse.xtend.core.formatting.RendererConfiguration;
import org.eclipse.xtend.core.formatting.TextReplacement;
import org.eclipse.xtend.core.formatting.WhitespaceData;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendImport;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage.Literals;
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
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

@SuppressWarnings(value = "restriction")
public class XtendFormatter {
  @Inject
  private IWhitespaceInformationProvider whitespaeInfo;
  
  @Inject
  private NodeModelAccess _nodeModelAccess;
  
  public List<TextReplacement> format(final XtextResource res, final int offset, final int length) {
    List<TextReplacement> _xblockexpression = null;
    {
      RendererConfiguration _rendererConfiguration = new RendererConfiguration();
      final Procedure1<RendererConfiguration> _function = new Procedure1<RendererConfiguration>() {
          public void apply(final RendererConfiguration it) {
            URI _uRI = res.getURI();
            ILineSeparatorInformation _lineSeparatorInformation = XtendFormatter.this.whitespaeInfo.getLineSeparatorInformation(_uRI);
            String _lineSeparator = _lineSeparatorInformation.getLineSeparator();
            it.setLineSeparator(_lineSeparator);
            URI _uRI_1 = res.getURI();
            IIndentationInformation _indentationInformation = XtendFormatter.this.whitespaeInfo.getIndentationInformation(_uRI_1);
            String _indentString = _indentationInformation.getIndentString();
            it.setIndentation(_indentString);
          }
        };
      final RendererConfiguration cfg = ObjectExtensions.<RendererConfiguration>operator_doubleArrow(_rendererConfiguration, _function);
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
  
  public void format(final XtextResource res, final int offset, final int length, final Procedure3<? super Integer,? super Integer,? super String> out) {
    List<TextReplacement> _format = this.format(res, offset, length);
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
      FormattingData _append = this.append(pkg, _function);
      format.operator_add(_append);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLines = 2;
          }
        };
      FormattingData _append_1 = this.append(pkgSemicolon, _function_1);
      format.operator_add(_append_1);
    } else {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLines = 2;
          }
        };
      FormattingData _append_2 = this.append(pkg, _function_2);
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
        FormattingData _append_3 = this.append(_nodeForEObject, _function_3);
        format.operator_add(_append_3);
      } else {
        INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(imp);
        final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLines = 2;
            }
          };
        FormattingData _append_4 = this.append(_nodeForEObject_1, _function_4);
        format.operator_add(_append_4);
      }
    }
    EList<XtendClass> _xtendClasses = xtendFile.getXtendClasses();
    for (final XtendClass clazz : _xtendClasses) {
      this.format(clazz, format);
    }
    INode _nodeForEObject_2 = this._nodeModelAccess.nodeForEObject(xtendFile);
    final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.newLine();
        }
      };
    FormattingData _append_5 = this.append(_nodeForEObject_2, _function_5);
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
      FormattingData _append = this.append(_nodeForEObject, _function);
      format.operator_add(_append);
    }
    final ILeafNode clazzOpenBrace = this._nodeModelAccess.nodeForKeyword(clazz, "{");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.space = " ";
        }
      };
    FormattingData _prepend = this.prepend(clazzOpenBrace, _function_1);
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
      FormattingData _append_1 = this.append(clazzOpenBrace, _function_2);
      format.operator_add(_append_1);
      EList<XtendMember> _members_1 = clazz.getMembers();
      int _size = _members_1.size();
      int _minus = (_size - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      for (final Integer i : _upTo) {
        {
          EList<XtendMember> _members_2 = clazz.getMembers();
          XtendMember _get = _members_2.get((i).intValue());
          final XtendMember member = _get;
          boolean _matched = false;
          if (!_matched) {
            if (member instanceof XtendFunction) {
              final XtendFunction _xtendFunction = (XtendFunction)member;
              _matched=true;
              XExpression _expression = _xtendFunction.getExpression();
              this.format(_expression, format);
            }
          }
          EList<XtendMember> _members_3 = clazz.getMembers();
          int _size_1 = _members_3.size();
          int _minus_1 = (_size_1 - 1);
          boolean _lessThan = ((i).intValue() < _minus_1);
          if (_lessThan) {
            EList<XtendMember> _members_4 = clazz.getMembers();
            final XtendMember current = _members_4.get((i).intValue());
            EList<XtendMember> _members_5 = clazz.getMembers();
            int _plus = ((i).intValue() + 1);
            final XtendMember next = _members_5.get(_plus);
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
              FormattingData _append_2 = this.append(_nodeForEObject_1, _function_3);
              format.operator_add(_append_2);
            } else {
              INode _nodeForEObject_2 = this._nodeModelAccess.nodeForEObject(current);
              final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLines = 2;
                  }
                };
              FormattingData _append_3 = this.append(_nodeForEObject_2, _function_4);
              format.operator_add(_append_3);
            }
          } else {
            EList<XtendMember> _members_6 = clazz.getMembers();
            XtendMember _get_1 = _members_6.get((i).intValue());
            INode _nodeForEObject_3 = this._nodeModelAccess.nodeForEObject(_get_1);
            final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                  it.decreaseIndentation();
                }
              };
            FormattingData _append_4 = this.append(_nodeForEObject_3, _function_5);
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
      FormattingData _append_2 = this.append(clazzOpenBrace, _function_3);
      format.operator_add(_append_2);
    }
  }
  
  protected void _format(final XVariableDeclaration expr, final FormattableDocument format) {
    XExpression _right = expr.getRight();
    this.format(_right, format);
  }
  
  protected void _format(final Void expr, final FormattableDocument format) {
  }
  
  protected void _format(final XFeatureCall expr, final FormattableDocument format) {
    INode node = null;
    boolean indented = false;
    EList<XExpression> _featureCallArguments = expr.getFeatureCallArguments();
    for (final XExpression arg : _featureCallArguments) {
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
            FormattingData _append = this.append(node, _function);
            format.operator_add(_append);
          } else {
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                }
              };
            FormattingData _append_1 = this.append(node, _function_1);
            format.operator_add(_append_1);
            boolean _not = (!indented);
            if (_not) {
              final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.increaseIndentation();
                  }
                };
              FormattingData _append_2 = this.append(node, _function_2);
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
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(expr);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      FormattingData _append = this.append(_nodeForEObject, _function);
      format.operator_add(_append);
    }
  }
  
  protected void _format(final XMemberFeatureCall expr, final FormattableDocument format) {
    EList<XExpression> _memberCallArguments = expr.getMemberCallArguments();
    for (final XExpression arg : _memberCallArguments) {
      this.format(arg, format);
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
      FormattingData _prepend = this.prepend(open, _function_2);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = " ";
          }
        };
      FormattingData _append = this.append(open, _function_3);
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
          FormattingData _prepend_1 = this.prepend(cnode, _function_4);
          format.operator_add(_prepend_1);
          final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          FormattingData _append_1 = this.append(cnode, _function_5);
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
        FormattingData _prepend_1 = this.prepend(open, _function_4);
        format.operator_add(_prepend_1);
        final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        FormattingData _append_1 = this.append(open, _function_5);
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
            FormattingData _prepend_2 = this.prepend(_nodeForEObject_1, _function_6);
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
              FormattingData _append_2 = this.append(_nodeForEObject_2, _function_7);
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
        FormattingData _prepend_2 = this.prepend(close, _function_6);
        format.operator_add(_prepend_2);
      } else {
        final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.space = " ";
            }
          };
        FormattingData _prepend_3 = this.prepend(open, _function_7);
        format.operator_add(_prepend_3);
        final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        FormattingData _append_2 = this.append(open, _function_8);
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
              FormattingData _prepend_4 = this.prepend(cnode, _function_9);
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
                FormattingData _append_3 = this.append(cnode, _function_10);
                format.operator_add(_append_3);
              } else {
                final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                      it.decreaseIndentation();
                    }
                  };
                FormattingData _append_4 = this.append(cnode, _function_11);
                format.operator_add(_append_4);
              }
            } else {
              final Procedure1<FormattingDataInit> _function_12 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                    it.increaseIndentation();
                  }
                };
              FormattingData _prepend_5 = this.prepend(cnode, _function_12);
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
                FormattingData _append_5 = this.append(cnode, _function_13);
                format.operator_add(_append_5);
              } else {
                final Procedure1<FormattingDataInit> _function_14 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                      int _minus = (-2);
                      it.indentationChange = _minus;
                    }
                  };
                FormattingData _append_6 = this.append(cnode, _function_14);
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
          FormattingData _append_3 = this.append(typenode, _function_9);
          format.operator_add(_append_3);
          final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          FormattingData _prepend_4 = this.prepend(casenode, _function_10);
          format.operator_add(_prepend_4);
          final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          FormattingData _append_4 = this.append(casenode, _function_11);
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
            FormattingData _append_5 = this.append(typenode_1, _function_12);
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
              FormattingData _prepend_5 = this.prepend(casenode_1, _function_13);
              format.operator_add(_prepend_5);
              final Procedure1<FormattingDataInit> _function_14 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.noSpace();
                  }
                };
              FormattingData _append_6 = this.append(casenode_1, _function_14);
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
          FormattingData _append = open==null?(FormattingData)null:this.append(open, _function);
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
            FormattingData _append = this.append(explicit, _function);
            format.operator_add(_append);
          } else {
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                  it.increaseIndentation();
                }
              };
            FormattingData _append_1 = open==null?(FormattingData)null:this.append(open, _function_1);
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
                FormattingData _append_2 = this.append(_nodeForEObject_1, _function_2);
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
          FormattingData _prepend = close==null?(FormattingData)null:this.prepend(close, _function_2);
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
            FormattingData _prepend = this.prepend(n, _function);
            format.operator_add(_prepend);
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            FormattingData _append = this.append(n, _function_1);
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
          FormattingData _prepend_1 = this.prepend(c, _function_2);
          format.operator_add(_prepend_1);
          final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          FormattingData _append_1 = this.append(c, _function_3);
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
        FormattingData _append = open==null?(FormattingData)null:this.append(open, _function);
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
            FormattingData _append_1 = this.append(_nodeForEObject_1, _function_1);
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
      boolean _not = (!multiline);
      _or_2 = ((_then_1 instanceof XBlockExpression) || _not);
    }
    if (_or_2) {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = " ";
          }
        };
      FormattingData _prepend = this.prepend(thennode, _function);
      format.operator_add(_prepend);
      XExpression _else_1 = expr.getElse();
      boolean _notEquals = (!Objects.equal(_else_1, null));
      if (_notEquals) {
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.space = " ";
            }
          };
        FormattingData _append = this.append(thennode, _function_1);
        format.operator_add(_append);
      }
    } else {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      FormattingData _prepend_1 = this.prepend(thennode, _function_2);
      format.operator_add(_prepend_1);
      XExpression _else_2 = expr.getElse();
      boolean _notEquals_1 = (!Objects.equal(_else_2, null));
      if (_notEquals_1) {
        final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.decreaseIndentation();
            }
          };
        FormattingData _append_1 = this.append(thennode, _function_3);
        format.operator_add(_append_1);
      } else {
        final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.decreaseIndentation();
            }
          };
        FormattingData _append_2 = this.append(thennode, _function_4);
        format.operator_add(_append_2);
      }
    }
    boolean _or_3 = false;
    XExpression _else_3 = expr.getElse();
    if ((_else_3 instanceof XBlockExpression)) {
      _or_3 = true;
    } else {
      boolean _not_1 = (!multiline);
      _or_3 = ((_else_3 instanceof XBlockExpression) || _not_1);
    }
    if (_or_3) {
      final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = " ";
          }
        };
      FormattingData _prepend_2 = this.prepend(elsenode, _function_5);
      format.operator_add(_prepend_2);
    } else {
      final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      FormattingData _prepend_3 = this.prepend(elsenode, _function_6);
      format.operator_add(_prepend_3);
      final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      FormattingData _append_3 = this.append(elsenode, _function_7);
      format.operator_add(_append_3);
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
      FormattingData _prepend = this.prepend(each, _function);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      FormattingData _append = this.append(each, _function_1);
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
        FormattingData _append = this.append(open, _function);
        format.operator_add(_append);
      } else {
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        FormattingData _append_1 = this.append(open, _function_1);
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
                FormattingData _prepend = this.prepend(sem, _function_2);
                format.operator_add(_prepend);
                final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                FormattingData _append_2 = this.append(sem, _function_3);
                format.operator_add(_append_2);
              } else {
                final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                FormattingData _append_3 = this.append(childNode, _function_4);
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
        FormattingData _prepend = this.prepend(close, _function_2);
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
  
  protected FormattingData append(final INode node, final Procedure1<? super FormattingDataInit> init) {
    FormattingData _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      Pair<Integer,Integer> _rangeAfter = this._nodeModelAccess.getRangeAfter(node);
      FormattingData _newFormattingData = _rangeAfter==null?(FormattingData)null:this.newFormattingData(_rangeAfter, init);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
  
  protected FormattingData prepend(final INode node, final Procedure1<? super FormattingDataInit> init) {
    FormattingData _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      Pair<Integer,Integer> _rangeBefore = this._nodeModelAccess.getRangeBefore(node);
      FormattingData _newFormattingData = _rangeBefore==null?(FormattingData)null:this.newFormattingData(_rangeBefore, init);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
  
  protected FormattingData newFormattingData(final Pair<Integer,Integer> range, final Procedure1<? super FormattingDataInit> init) {
    FormattingDataInit _formattingDataInit = new FormattingDataInit();
    final FormattingDataInit it = _formattingDataInit;
    init.apply(it);
    boolean _or = false;
    boolean _equals = (it.newLines == 0);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(it.space, "");
      _or = (_equals || _equals_1);
    }
    if (_or) {
      Integer _key = range.getKey();
      Integer _value = range.getValue();
      WhitespaceData _whitespaceData = new WhitespaceData((_key).intValue(), (_value).intValue(), it.indentationChange, it.space);
      return _whitespaceData;
    } else {
      boolean _equals_2 = Objects.equal(it.space, null);
      if (_equals_2) {
        Integer _key_1 = range.getKey();
        Integer _value_1 = range.getValue();
        NewLineData _newLineData = new NewLineData((_key_1).intValue(), (_value_1).intValue(), it.indentationChange, it.newLines);
        return _newLineData;
      } else {
        String _string = init.toString();
        IllegalStateException _illegalStateException = new IllegalStateException(_string);
        throw _illegalStateException;
      }
    }
  }
  
  public String lookahead(final FormattableDocument fmt, final EObject expression) {
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
  
  public boolean fitsIntoLine(final FormattableDocument fmt, final EObject expression) {
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
  
  protected void format(final EObject expr, final FormattableDocument format) {
    if (expr instanceof XFeatureCall) {
      _format((XFeatureCall)expr, format);
      return;
    } else if (expr instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)expr, format);
      return;
    } else if (expr instanceof XtendClass) {
      _format((XtendClass)expr, format);
      return;
    } else if (expr instanceof XBlockExpression) {
      _format((XBlockExpression)expr, format);
      return;
    } else if (expr instanceof XClosure) {
      _format((XClosure)expr, format);
      return;
    } else if (expr instanceof XForLoopExpression) {
      _format((XForLoopExpression)expr, format);
      return;
    } else if (expr instanceof XIfExpression) {
      _format((XIfExpression)expr, format);
      return;
    } else if (expr instanceof XSwitchExpression) {
      _format((XSwitchExpression)expr, format);
      return;
    } else if (expr instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)expr, format);
      return;
    } else if (expr instanceof XtendFile) {
      _format((XtendFile)expr, format);
      return;
    } else if (expr instanceof XExpression) {
      _format((XExpression)expr, format);
      return;
    } else if (expr == null) {
      _format((Void)null, format);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expr, format).toString());
    }
  }
}
