package org.eclipse.xtext.psi;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import java.util.List;
import org.eclipse.xtext.resource.IResourceDescription;

@SuppressWarnings("all")
public interface PsiTreeChangeToDeltaConverter {
  public abstract List<IResourceDescription.Delta> convert(final PsiTreeChangeEventImpl event);
}
