package org.eclipse.xtend.ide.codebuilder;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class VariableNameAcceptor implements JdtVariableCompletions.CompletionDataAcceptor {
  private final Set<String> notallowed;
  
  private final Set<String> variableNames = CollectionLiterals.<String>newHashSet();
  
  public VariableNameAcceptor(final Set<String> notallowed) {
    this.notallowed = notallowed;
  }
  
  public void accept(final String replaceText, final StyledString label, final Image img) {
    this.variableNames.add(replaceText);
    this.notallowed.add(replaceText);
  }
  
  public String getVariableName() {
    final ArrayList<String> candidates = Lists.<String>newArrayList(this.variableNames);
    final Comparator<String> _function = new Comparator<String>() {
      public int compare(final String left, final String right) {
        int _length = left.length();
        int _length_1 = right.length();
        int _minus = (_length - _length_1);
        return _minus;
      }
    };
    Collections.<String>sort(candidates, _function);
    int _size = candidates.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      return candidates.get(0);
    }
    return "";
  }
}
