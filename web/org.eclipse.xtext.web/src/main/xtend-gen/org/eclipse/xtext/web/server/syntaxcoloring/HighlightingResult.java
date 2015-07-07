package org.eclipse.xtext.web.server.syntaxcoloring;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.syntaxcoloring.HighlightRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class HighlightingResult implements IServiceResult {
  private final String stateId;
  
  private final ArrayList<HighlightRegion> regions = CollectionLiterals.<HighlightRegion>newArrayList();
  
  public HighlightingResult(final String stateId, final Iterable<HighlightRegion> regions) {
    this.stateId = stateId;
    Iterables.<HighlightRegion>addAll(this.regions, regions);
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.stateId== null) ? 0 : this.stateId.hashCode());
    result = prime * result + ((this.regions== null) ? 0 : this.regions.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    HighlightingResult other = (HighlightingResult) obj;
    if (this.stateId == null) {
      if (other.stateId != null)
        return false;
    } else if (!this.stateId.equals(other.stateId))
      return false;
    if (this.regions == null) {
      if (other.regions != null)
        return false;
    } else if (!this.regions.equals(other.regions))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("stateId", this.stateId);
    b.add("regions", this.regions);
    return b.toString();
  }
  
  @Pure
  public String getStateId() {
    return this.stateId;
  }
  
  @Pure
  public ArrayList<HighlightRegion> getRegions() {
    return this.regions;
  }
}
