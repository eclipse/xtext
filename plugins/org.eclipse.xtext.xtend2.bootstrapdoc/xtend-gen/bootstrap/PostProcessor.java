package bootstrap;

import bootstrap.HtmlExtensions;
import com.google.inject.Inject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class PostProcessor {
  @Inject
  private HtmlExtensions _htmlExtensions;
  
  protected Pattern _codePattern;
  
  protected Pattern getCodePattern() {
    Pattern _xblockexpression = null;
    {
      Pattern __codePattern = this._codePattern;
      boolean _operator_equals = ObjectExtensions.operator_equals(__codePattern, null);
      if (_operator_equals) {
        String _markCodeBegin = this._htmlExtensions.markCodeBegin();
        String _quote = Pattern.quote(_markCodeBegin);
        String _operator_plus = StringExtensions.operator_plus(_quote, "\\n(\\s*).*?");
        String _markCodeEnd = this._htmlExtensions.markCodeEnd();
        String _quote_1 = Pattern.quote(_markCodeEnd);
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _quote_1);
        int _MULTILINE = Pattern.MULTILINE;
        int _DOTALL = Pattern.DOTALL;
        int _operator_plus_2 = IntegerExtensions.operator_plus(_MULTILINE, _DOTALL);
        Pattern _compile = Pattern.compile(_operator_plus_1, _operator_plus_2);
        this._codePattern = _compile;
      }
      Pattern __codePattern_1 = this._codePattern;
      _xblockexpression = (__codePattern_1);
    }
    return _xblockexpression;
  }
  
  protected String unindentCodeBlocks(final CharSequence it) {
    String _xblockexpression = null;
    {
      String _string = it.toString();
      String html = _string;
      Pattern _codePattern = this.getCodePattern();
      Matcher _matcher = _codePattern.matcher(html);
      Matcher matcher = _matcher;
      boolean _find = matcher.find();
      boolean _while = _find;
      while (_while) {
        {
          String _group = matcher.group();
          String code = _group;
          String _markCodeBegin = this._htmlExtensions.markCodeBegin();
          String _replace = code.replace(_markCodeBegin, "");
          code = _replace;
          String _markCodeEnd = this._htmlExtensions.markCodeEnd();
          String _replace_1 = code.replace(_markCodeEnd, "");
          code = _replace_1;
          String _group_1 = matcher.group(1);
          String _quote = Pattern.quote(_group_1);
          String _replaceAll = code.replaceAll(_quote, "");
          code = _replaceAll;
          int _start = matcher.start();
          String _substring = html.substring(0, _start);
          String _operator_plus = StringExtensions.operator_plus(_substring, code);
          int _end = matcher.end();
          String _substring_1 = html.substring(_end);
          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _substring_1);
          html = _operator_plus_1;
          Pattern _codePattern_1 = this.getCodePattern();
          Matcher _matcher_1 = _codePattern_1.matcher(html);
          matcher = _matcher_1;
        }
        boolean _find_1 = matcher.find();
        _while = _find_1;
      }
      _xblockexpression = (html);
    }
    return _xblockexpression;
  }
  
  public String postProcess(final CharSequence it) {
    String _unindentCodeBlocks = this.unindentCodeBlocks(it);
    return _unindentCodeBlocks;
  }
}
