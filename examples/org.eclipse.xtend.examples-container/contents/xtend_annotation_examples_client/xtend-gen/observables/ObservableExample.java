package observables;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import observables.ObservableBean;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class ObservableExample {
  public static void main(final String[] args) {
    ObservableBean _observableBean = new ObservableBean();
    final ObservableBean bean = _observableBean;
    final PropertyChangeListener _function = new PropertyChangeListener() {
        public void propertyChange(final PropertyChangeEvent it) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("property ");
          String _propertyName = it.getPropertyName();
          _builder.append(_propertyName, "");
          _builder.append(" changed from ");
          Object _oldValue = it.getOldValue();
          _builder.append(_oldValue, "");
          _builder.append(" to ");
          Object _newValue = it.getNewValue();
          _builder.append(_newValue, "");
          InputOutput.<String>println(_builder.toString());
        }
      };
    final PropertyChangeListener observer = _function;
    bean.addPropertyChangeListener(observer);
    bean.setFirstName("Max");
    bean.setLastName("Mustermann");
    bean.setFirstName("John");
    bean.setLastName("Doe");
  }
}
