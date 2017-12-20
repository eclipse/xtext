package org.eclipse.xtext.example.arithmetics.ui.editor.hierarchy;

import com.google.inject.Singleton;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.example.arithmetics.arithmetics.FunctionCall;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNodeLocationProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

@Singleton
@SuppressWarnings("all")
public class ArithmeticsCallHierarchyNodeLocationProvider extends DefaultHierarchyNodeLocationProvider {
  @Override
  public ITextRegionWithLineInformation getTextRegion(final EObject owner, final EStructuralFeature feature, final int indexInList) {
    if ((owner instanceof FunctionCall)) {
      final ITextRegion textRegion = this.locationInFileProvider.getFullTextRegion(owner);
      return this.toTextRegionWithLineInformation(owner, textRegion);
    }
    return super.getTextRegion(owner, feature, indexInList);
  }
}
