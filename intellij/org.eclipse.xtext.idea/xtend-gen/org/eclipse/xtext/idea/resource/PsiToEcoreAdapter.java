package org.eclipse.xtext.idea.resource;

import com.google.common.collect.Iterables;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformationContext;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class PsiToEcoreAdapter extends AdapterImpl {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final /* Map<ASTNode, INode> */Object nodesMapping;
  
  public PsiToEcoreAdapter(final PsiToEcoreTransformationContext context) {
    Map<ASTNode, INode> _nodesMapping = context.getNodesMapping();
    this.nodesMapping = _nodesMapping;
  }
  
  public boolean install(final Resource it) {
    EList<Adapter> _eAdapters = it.eAdapters();
    return _eAdapters.add(this);
  }
  
  public static PsiToEcoreAdapter get(final Resource it) {
    EList<Adapter> _eAdapters = it.eAdapters();
    Iterable<PsiToEcoreAdapter> _filter = Iterables.<PsiToEcoreAdapter>filter(_eAdapters, PsiToEcoreAdapter.class);
    return IterableExtensions.<PsiToEcoreAdapter>head(_filter);
  }
  
  @Pure
  public /* Map<ASTNode, INode> */Object getNodesMapping() {
    return this.nodesMapping;
  }
}
