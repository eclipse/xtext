package org.eclipse.xtext.xbase.formatting;

import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.configuration.IConfigurationValues;
import org.eclipse.xtext.xbase.formatting.FormattableDocument;
import org.eclipse.xtext.xbase.formatting.IFormatter;
import org.eclipse.xtext.xbase.formatting.TextReplacement;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public abstract class AbstractFormatter implements IFormatter {
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
  
  public List<TextReplacement> format(final XtextResource res, final int offset, final int length, final IConfigurationValues cfg) {
    List<TextReplacement> _xblockexpression = null;
    {
      IParseResult _parseResult = res.getParseResult();
      ICompositeNode _rootNode = _parseResult.getRootNode();
      final String doc = _rootNode.getText();
      FormattableDocument _formattableDocument = new FormattableDocument(cfg, doc);
      final FormattableDocument format = _formattableDocument;
      EList<EObject> _contents = res.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      this.format(_head, format);
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
        this.format(_head_1, debug);
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
              boolean _notEquals = ObjectExtensions.operator_notEquals(_substring, _text);
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
  
  protected void _format(final Void expr, final FormattableDocument format) {
  }
  
  protected void _format(final EObject expr, final FormattableDocument format) {
  }
  
  protected void format(final EObject expr, final FormattableDocument format) {
    if (expr != null) {
      _format(expr, format);
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
