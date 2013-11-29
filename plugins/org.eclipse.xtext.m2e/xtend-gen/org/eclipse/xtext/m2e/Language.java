package org.eclipse.xtext.m2e;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import org.eclipse.xtext.m2e.OutputConfiguration;

@SuppressWarnings("all")
public class Language {
  private String _setup;
  
  public String getSetup() {
    return this._setup;
  }
  
  public void setSetup(final String setup) {
    this._setup = setup;
  }
  
  private ArrayList<OutputConfiguration> _outputConfigurations = Lists.<OutputConfiguration>newArrayList();
  
  public ArrayList<OutputConfiguration> getOutputConfigurations() {
    return this._outputConfigurations;
  }
  
  public void setOutputConfigurations(final ArrayList<OutputConfiguration> outputConfigurations) {
    this._outputConfigurations = outputConfigurations;
  }
  
  public String name() {
    String _setup = this.getSetup();
    String _replaceAll = _setup.replaceAll("StandaloneSetup", "");
    return _replaceAll;
  }
}
