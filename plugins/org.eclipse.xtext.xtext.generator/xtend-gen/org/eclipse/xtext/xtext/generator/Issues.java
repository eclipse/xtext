package org.eclipse.xtext.xtext.generator;

@SuppressWarnings("all")
public interface Issues {
  public abstract void addError(final String message);
  
  public abstract void addError(final String message, final Object source);
  
  public abstract void addWarning(final String message);
  
  public abstract void addWarning(final String message, final Object source);
}
