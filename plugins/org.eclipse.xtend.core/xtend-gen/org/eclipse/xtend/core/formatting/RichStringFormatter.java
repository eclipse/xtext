package org.eclipse.xtend.core.formatting;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.formatting.FormattableDocument;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.RichStringFormatterImpl;
import org.eclipse.xtend.core.formatting.WhitespaceData;
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class RichStringFormatter {
  @Inject
  private Provider<RichStringFormatterImpl> provider;
  
  @Inject
  private RichStringProcessor richStringProcessor;
  
  public FormattingData format(final Procedure2<? super EObject,? super FormattableDocument> formatter, final FormattableDocument doc, final RichString richString) {
    FormattingData _xblockexpression = null;
    {
      final RichStringFormatterImpl impl = this.provider.get();
      impl.setFormatter(formatter);
      impl.setDocument(doc);
      DefaultIndentationHandler _defaultIndentationHandler = new DefaultIndentationHandler();
      this.richStringProcessor.process(richString, impl, _defaultIndentationHandler);
      FormattingData _xifexpression = null;
      boolean _and = false;
      int _indentOffset = impl.getIndentOffset();
      boolean _greaterThan = (_indentOffset > 0);
      if (!_greaterThan) {
        _and = false;
      } else {
        int _outdentOffset = impl.getOutdentOffset();
        boolean _greaterThan_1 = (_outdentOffset > 0);
        _and = (_greaterThan && _greaterThan_1);
      }
      if (_and) {
        FormattingData _xblockexpression_1 = null;
        {
          int _indentOffset_1 = impl.getIndentOffset();
          RuntimeException _xifexpression_1 = null;
          boolean _isDebugConflicts = doc.isDebugConflicts();
          if (_isDebugConflicts) {
            RuntimeException _runtimeException = new RuntimeException();
            _xifexpression_1 = _runtimeException;
          }
          WhitespaceData _whitespaceData = new WhitespaceData(_indentOffset_1, 0, 1, _xifexpression_1, null);
          doc.operator_add(_whitespaceData);
          int _outdentOffset_1 = impl.getOutdentOffset();
          int _minus = (-1);
          RuntimeException _xifexpression_2 = null;
          boolean _isDebugConflicts_1 = doc.isDebugConflicts();
          if (_isDebugConflicts_1) {
            RuntimeException _runtimeException_1 = new RuntimeException();
            _xifexpression_2 = _runtimeException_1;
          }
          WhitespaceData _whitespaceData_1 = new WhitespaceData(_outdentOffset_1, 0, _minus, _xifexpression_2, null);
          FormattingData _add = doc.operator_add(_whitespaceData_1);
          _xblockexpression_1 = (_add);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
}
