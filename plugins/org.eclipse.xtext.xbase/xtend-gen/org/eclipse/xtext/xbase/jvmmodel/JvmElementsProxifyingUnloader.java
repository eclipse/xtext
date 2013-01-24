package org.eclipse.xtext.xbase.jvmmodel;

import com.google.common.annotations.Beta;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@Beta
@SuppressWarnings("all")
public class JvmElementsProxifyingUnloader implements IReferableElementsUnloader {
  public void unloadRoot(final EObject root) {
    final List<JvmMember> toBeProxified = CollectionLiterals.<JvmMember>newLinkedList();
    boolean _matched = false;
    if (!_matched) {
      if (root instanceof JvmMember) {
        final JvmMember _jvmMember = (JvmMember)root;
        _matched=true;
        this.unloadRecursively(_jvmMember, toBeProxified);
      }
    }
    for (final JvmMember toProxify : toBeProxified) {
      URI _uRI = EcoreUtil.getURI(toProxify);
      ((InternalEObject) toProxify).eSetProxyURI(_uRI);
    }
  }
  
  protected void unloadRecursively(final JvmMember element, final List<JvmMember> toBeProxified) {
    toBeProxified.add(element);
    EList<EObject> _eContents = element.eContents();
    for (final EObject child : _eContents) {
      boolean _matched = false;
      if (!_matched) {
        if (child instanceof JvmMember) {
          final JvmMember _jvmMember = (JvmMember)child;
          _matched=true;
          this.unloadRecursively(_jvmMember, toBeProxified);
        }
      }
    }
  }
}
