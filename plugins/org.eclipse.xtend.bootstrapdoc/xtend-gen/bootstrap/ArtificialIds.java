package bootstrap;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xdoc.xdoc.Identifiable;

@SuppressWarnings("all")
public class ArtificialIds extends AdapterImpl {
  public Map<Identifiable,String> artificialHrefs = new Function0<Map<Identifiable,String>>() {
    public Map<Identifiable,String> apply() {
      HashMap<Identifiable,String> _newHashMap = CollectionLiterals.<Identifiable, String>newHashMap();
      return _newHashMap;
    }
  }.apply();
}
