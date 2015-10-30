package org.eclipse.xtend.web.server.java2xtend;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class Java2XtendResult implements IServiceResult {
  private final String generateText;
  
  public Java2XtendResult(final String generateText) {
    super();
    this.generateText = generateText;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.generateText== null) ? 0 : this.generateText.hashCode());
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
    Java2XtendResult other = (Java2XtendResult) obj;
    if (this.generateText == null) {
      if (other.generateText != null)
        return false;
    } else if (!this.generateText.equals(other.generateText))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("generateText", this.generateText);
    return b.toString();
  }
  
  @Pure
  public String getGenerateText() {
    return this.generateText;
  }
}
