package org.eclipse.xtext.xbase.formatting;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.formatting.FormattableDocument;
import org.eclipse.xtext.xbase.formatting.FormattingPreferenceValues;
import org.eclipse.xtext.xbase.formatting.IBasicFormatter;
import org.eclipse.xtext.xbase.formatting.TextReplacement;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class AbstractFormatter implements IBasicFormatter {
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
  
  private boolean conflictOccurred = false;
  
  public List<TextReplacement> format(final XtextResource res, final int offset, final int length, final FormattingPreferenceValues cfg) {
    List<TextReplacement> _xblockexpression = null;
    {
      IParseResult _parseResult = res.getParseResult();
      ICompositeNode _rootNode = _parseResult.getRootNode();
      final String doc = _rootNode.getText();
      final FormattableDocument format = new FormattableDocument(cfg, doc);
      EList<EObject> _contents = res.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      this.format(_head, format);
      boolean _and = false;
      boolean _isDiagnoseConflicts = this.isDiagnoseConflicts();
      if (!_isDiagnoseConflicts) {
        _and = false;
      } else {
        boolean _isConflictOccurred = format.isConflictOccurred();
        _and = _isConflictOccurred;
      }
      if (_and) {
        final FormattableDocument debug = new FormattableDocument(cfg, doc);
        RuntimeException _runtimeException = new RuntimeException();
        debug.setRootTrace(_runtimeException);
        EList<EObject> _contents_1 = res.getContents();
        EObject _head_1 = IterableExtensions.<EObject>head(_contents_1);
        this.format(_head_1, debug);
      }
      boolean _isConflictOccurred_1 = format.isConflictOccurred();
      this.conflictOccurred = _isConflictOccurred_1;
      final List<TextReplacement> edits = format.renderToEdits(offset, length);
      List<TextReplacement> _xifexpression = null;
      boolean _isAllowIdentityEdits = this.isAllowIdentityEdits();
      if (_isAllowIdentityEdits) {
        _xifexpression = edits;
      } else {
        final Function1<TextReplacement, Boolean> _function = new Function1<TextReplacement, Boolean>() {
          public Boolean apply(final TextReplacement it) {
            int _offset = it.getOffset();
            int _offset_1 = it.getOffset();
            int _length = it.getLength();
            int _plus = (_offset_1 + _length);
            String _substring = doc.substring(_offset, _plus);
            String _text = it.getText();
            return Boolean.valueOf((!Objects.equal(_substring, _text)));
          }
        };
        Iterable<TextReplacement> _filter = IterableExtensions.<TextReplacement>filter(edits, _function);
        _xifexpression = IterableExtensions.<TextReplacement>toList(_filter);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public boolean isConflictOccurred() {
    return this.conflictOccurred;
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
