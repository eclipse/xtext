package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.intellij.lang.ASTNode;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformationContext;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class PsiToEcoreAdapter extends AdapterImpl {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final BaseXtextFile xtextFile;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final Map<ASTNode, INode> nodesMapping;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final Map<INode, List<ASTNode>> reverseNodesMapping;
  
  public PsiToEcoreAdapter(final PsiToEcoreTransformationContext context) {
    BaseXtextFile _xtextFile = context.getXtextFile();
    this.xtextFile = _xtextFile;
    Map<ASTNode, INode> _nodesMapping = context.getNodesMapping();
    Map<ASTNode, INode> _unmodifiableView = Collections.<ASTNode, INode>unmodifiableMap(_nodesMapping);
    this.nodesMapping = _unmodifiableView;
    Map<INode, List<ASTNode>> _reverseNodesMapping = context.getReverseNodesMapping();
    Map<INode, List<ASTNode>> _unmodifiableView_1 = Collections.<INode, List<ASTNode>>unmodifiableMap(_reverseNodesMapping);
    this.reverseNodesMapping = _unmodifiableView_1;
  }
  
  public boolean install(final Resource it) {
    EList<Adapter> _eAdapters = it.eAdapters();
    return _eAdapters.add(this);
  }
  
  public boolean isAdapterForType(final Object type) {
    Class<? extends PsiToEcoreAdapter> _class = this.getClass();
    return Objects.equal(_class, type);
  }
  
  public static PsiToEcoreAdapter get(final Resource it) {
    EList<Adapter> _eAdapters = it.eAdapters();
    Adapter _adapter = EcoreUtil.getAdapter(_eAdapters, PsiToEcoreAdapter.class);
    return ((PsiToEcoreAdapter) _adapter);
  }
  
  @Pure
  public BaseXtextFile getXtextFile() {
    return this.xtextFile;
  }
  
  @Pure
  public Map<ASTNode, INode> getNodesMapping() {
    return this.nodesMapping;
  }
  
  @Pure
  public Map<INode, List<ASTNode>> getReverseNodesMapping() {
    return this.reverseNodesMapping;
  }
}
