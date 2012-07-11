package org.eclipse.xtext.xbase.typesystem.util;

import java.util.HashSet;
import java.util.Set;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@SuppressWarnings("all")
public class ConstraintVisitingInfo {
  private Set<JvmTypeParameter> visiting;
  
  private JvmTypeParameterDeclarator declarator;
  
  private int idx;
  
  public ConstraintVisitingInfo() {
    HashSet<JvmTypeParameter> _newHashSet = CollectionLiterals.<JvmTypeParameter>newHashSet();
    this.visiting = _newHashSet;
  }
  
  public ConstraintVisitingInfo(final JvmTypeParameter initial) {
    HashSet<JvmTypeParameter> _newHashSet = CollectionLiterals.<JvmTypeParameter>newHashSet(initial);
    this.visiting = _newHashSet;
  }
  
  public boolean tryVisit(final JvmTypeParameter parameter) {
    return this.visiting.add(parameter);
  }
  
  public void didVisit(final JvmTypeParameter parameter) {
    this.visiting.remove(parameter);
  }
  
  public void pushInfo(final JvmTypeParameterDeclarator declarator, final int idx) {
    this.declarator = declarator;
    this.idx = idx;
  }
  
  public JvmTypeParameterDeclarator getCurrentDeclarator() {
    return this.declarator;
  }
  
  public int getCurrentIndex() {
    return this.idx;
  }
}
