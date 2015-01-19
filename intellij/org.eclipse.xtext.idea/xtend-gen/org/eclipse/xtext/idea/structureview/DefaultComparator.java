package org.eclipse.xtext.idea.structureview;

import com.intellij.ide.util.treeView.smartTree.SorterUtil;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import java.util.Comparator;

@SuppressWarnings("all")
public class DefaultComparator implements Comparator<TreeElement> {
  @Override
  public int compare(final TreeElement treeElement, final TreeElement treeElement2) {
    int _xblockexpression = (int) 0;
    {
      final int category = this.getCategory(treeElement);
      final int category2 = this.getCategory(treeElement2);
      int _xifexpression = (int) 0;
      if ((category != category2)) {
        _xifexpression = (category - category2);
      } else {
        int _xblockexpression_1 = (int) 0;
        {
          final String text = SorterUtil.getStringPresentation(treeElement);
          final String text2 = SorterUtil.getStringPresentation(treeElement2);
          _xblockexpression_1 = text.compareTo(text2);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public int getCategory(final TreeElement element) {
    return 0;
  }
}
