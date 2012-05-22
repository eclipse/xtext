package lesson3;

import com.google.common.base.Objects;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class BottleSupport {
  public static String bottles(final int i) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(i,0)) {
        _matched=true;
        _switchResult = "no more bottles";
      }
    }
    if (!_matched) {
      if (Objects.equal(i,1)) {
        _matched=true;
        _switchResult = "one bottle";
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(i, "");
      _builder.append(" bottles");
      _switchResult = _builder;
    }
    String _string = _switchResult.toString();
    return _string;
  }
  
  public static String Bottles(final int i) {
    String _bottles = BottleSupport.bottles(i);
    String _firstUpper = StringExtensions.toFirstUpper(_bottles);
    return _firstUpper;
  }
}
