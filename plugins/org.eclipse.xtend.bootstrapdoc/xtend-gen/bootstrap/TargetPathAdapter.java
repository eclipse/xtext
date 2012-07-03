package bootstrap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.Identifiable;

@SuppressWarnings("all")
public class TargetPathAdapter extends AdapterImpl {
  public Map<Identifiable,String> targetPaths = new Function0<Map<Identifiable,String>>() {
    public Map<Identifiable,String> apply() {
      HashMap<Identifiable,String> _newHashMap = CollectionLiterals.<Identifiable, String>newHashMap();
      return _newHashMap;
    }
  }.apply();
  
  public List<AbstractSection> targetFileRoots = new Function0<List<AbstractSection>>() {
    public List<AbstractSection> apply() {
      ArrayList<AbstractSection> _newArrayList = CollectionLiterals.<AbstractSection>newArrayList();
      return _newArrayList;
    }
  }.apply();
}
