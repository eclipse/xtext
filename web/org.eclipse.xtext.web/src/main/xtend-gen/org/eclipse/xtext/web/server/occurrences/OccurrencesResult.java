package org.eclipse.xtext.web.server.occurrences;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@ToString(skipNulls = true)
@SuppressWarnings("all")
public class OccurrencesResult implements IServiceResult {
  private final ArrayList<ITextRegion> writeRegions = new ArrayList<ITextRegion>();
  
  private final ArrayList<ITextRegion> readRegions = new ArrayList<ITextRegion>();
  
  public OccurrencesResult(final Iterable<ITextRegion> readRegions, final Iterable<ITextRegion> writeRegions) {
    Iterables.<ITextRegion>addAll(this.readRegions, readRegions);
    Iterables.<ITextRegion>addAll(this.writeRegions, writeRegions);
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.writeRegions== null) ? 0 : this.writeRegions.hashCode());
    result = prime * result + ((this.readRegions== null) ? 0 : this.readRegions.hashCode());
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
    OccurrencesResult other = (OccurrencesResult) obj;
    if (this.writeRegions == null) {
      if (other.writeRegions != null)
        return false;
    } else if (!this.writeRegions.equals(other.writeRegions))
      return false;
    if (this.readRegions == null) {
      if (other.readRegions != null)
        return false;
    } else if (!this.readRegions.equals(other.readRegions))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.skipNulls();
    b.add("writeRegions", this.writeRegions);
    b.add("readRegions", this.readRegions);
    return b.toString();
  }
  
  @Pure
  public ArrayList<ITextRegion> getWriteRegions() {
    return this.writeRegions;
  }
  
  @Pure
  public ArrayList<ITextRegion> getReadRegions() {
    return this.readRegions;
  }
}
