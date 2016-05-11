package org.eclipse.xtext.xbase.formatting;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.formatting.FormattableDocument;
import org.eclipse.xtext.xbase.formatting.FormattingPreferenceValues;
import org.eclipse.xtext.xbase.formatting.IBasicFormatter;
import org.eclipse.xtext.xbase.formatting.TextReplacement;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @deprecated use {@link AbstractFormatter2}
 */
@Deprecated
@SuppressWarnings("all")
public abstract class AbstractFormatter implements IBasicFormatter {
  @Accessors
  private boolean allowIdentityEdits = false;
  
  @Accessors
  private boolean diagnoseConflicts = true;
  
  private boolean conflictOccurred = false;
  
  @Override
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
      if ((this.diagnoseConflicts && format.isConflictOccurred())) {
        final FormattableDocument debug = new FormattableDocument(cfg, doc);
        RuntimeException _runtimeException = new RuntimeException();
        debug.setRootTrace(_runtimeException);
        EList<EObject> _contents_1 = res.getContents();
        EObject _head_1 = IterableExtensions.<EObject>head(_contents_1);
        this.format(_head_1, debug);
      }
      boolean _isConflictOccurred = format.isConflictOccurred();
      this.conflictOccurred = _isConflictOccurred;
      final List<TextReplacement> edits = format.renderToEdits(offset, length);
      List<TextReplacement> _xifexpression = null;
      if (this.allowIdentityEdits) {
        _xifexpression = edits;
      } else {
        final Function1<TextReplacement, Boolean> _function = new Function1<TextReplacement, Boolean>() {
          @Override
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
  
  @Pure
  public boolean isAllowIdentityEdits() {
    return this.allowIdentityEdits;
  }
  
  public void setAllowIdentityEdits(final boolean allowIdentityEdits) {
    this.allowIdentityEdits = allowIdentityEdits;
  }
  
  @Pure
  public boolean isDiagnoseConflicts() {
    return this.diagnoseConflicts;
  }
  
  public void setDiagnoseConflicts(final boolean diagnoseConflicts) {
    this.diagnoseConflicts = diagnoseConflicts;
  }
}
