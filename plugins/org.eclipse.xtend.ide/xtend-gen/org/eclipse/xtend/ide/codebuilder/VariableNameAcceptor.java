package org.eclipse.xtend.ide.codebuilder;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions.CompletionDataAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

@SuppressWarnings("all")
public class VariableNameAcceptor implements CompletionDataAcceptor {
  private final Set<String> notallowed;
  
  private final Set<String> variableNames = new Function0<Set<String>>() {
    public Set<String> apply() {
      HashSet<String> _newHashSet = CollectionLiterals.<String>newHashSet();
      return _newHashSet;
    }
  }.apply();
  
  public VariableNameAcceptor(final Set<String> notallowed) {
    this.notallowed = notallowed;
  }
  
  public void accept(final String replaceText, final StyledString label, final Image img) {
    this.variableNames.add(replaceText);
    this.notallowed.add(replaceText);
  }
  
  public String getVariableName() {
    final ArrayList<String> candidates = Lists.<String>newArrayList(this.variableNames);
    final Function2<String,String,Integer> _function = new Function2<String,String,Integer>() {
        public Integer apply(final String left, final String right) {
          int _length = left.length();
          int _length_1 = right.length();
          int _minus = (_length - _length_1);
          return _minus;
        }
      };
    Collections.<String>sort(candidates, new Comparator<String>() {
        public int compare(String o1,String o2) {
          return _function.apply(o1,o2);
        }
    });
    int _size = candidates.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      return candidates.get(0);
    }
    return "";
  }
}
