package bootstrap;

import java.util.Map;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xdoc.xdoc.Identifiable;

@SuppressWarnings("all")
public class ArtificialIds extends AdapterImpl {
  public Map<Identifiable,String> artificialHrefs = CollectionLiterals.<Identifiable, String>newHashMap();
}
