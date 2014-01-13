package bootstrap;

import bootstrap.HtmlExtensions;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class PostProcessor {
  @Inject
  @Extension
  private HtmlExtensions _htmlExtensions;
  
  protected Pattern _codePattern;
  
  protected Pattern getCodePattern() {
    Pattern _xblockexpression = null;
    {
      boolean _equals = Objects.equal(this._codePattern, null);
      if (_equals) {
        String _markCodeBegin = this._htmlExtensions.markCodeBegin();
        String _quote = Pattern.quote(_markCodeBegin);
        String _plus = (_quote + "\\n(\\s*).*?");
        String _markCodeEnd = this._htmlExtensions.markCodeEnd();
        String _quote_1 = Pattern.quote(_markCodeEnd);
        String _plus_1 = (_plus + _quote_1);
        Pattern _compile = Pattern.compile(_plus_1, 
          (Pattern.MULTILINE + Pattern.DOTALL));
        this._codePattern = _compile;
      }
      _xblockexpression = (this._codePattern);
    }
    return _xblockexpression;
  }
  
  protected String unindentCodeBlocks(final CharSequence it) {
    String _xblockexpression = null;
    {
      String html = it.toString();
      Pattern _codePattern = this.getCodePattern();
      Matcher matcher = _codePattern.matcher(html);
      boolean _find = matcher.find();
      boolean _while = _find;
      while (_while) {
        {
          String code = matcher.group();
          String _markCodeBegin = this._htmlExtensions.markCodeBegin();
          String _replace = code.replace(_markCodeBegin, "");
          code = _replace;
          String _markCodeEnd = this._htmlExtensions.markCodeEnd();
          String _replace_1 = code.replace(_markCodeEnd, "");
          code = _replace_1;
          String _group = matcher.group(1);
          String _quote = Pattern.quote(_group);
          String _replaceAll = code.replaceAll(_quote, "");
          code = _replaceAll;
          int _start = matcher.start();
          String _substring = html.substring(0, _start);
          String _plus = (_substring + code);
          int _end = matcher.end();
          String _substring_1 = html.substring(_end);
          String _plus_1 = (_plus + _substring_1);
          html = _plus_1;
          Pattern _codePattern_1 = this.getCodePattern();
          Matcher _matcher = _codePattern_1.matcher(html);
          matcher = _matcher;
        }
        boolean _find_1 = matcher.find();
        _while = _find_1;
      }
      _xblockexpression = (html);
    }
    return _xblockexpression;
  }
  
  public String postProcess(final CharSequence it) {
    return this.unindentCodeBlocks(it);
  }
}
