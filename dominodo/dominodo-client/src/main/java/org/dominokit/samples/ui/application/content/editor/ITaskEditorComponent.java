package org.dominokit.samples.ui.application.content.editor;

import com.github.nalukit.nalu.client.component.IsPopUpComponent;
import org.dominokit.samples.Task;

public interface ITaskEditorComponent
    extends IsPopUpComponent<ITaskEditorComponent.Controller> {

  void clear();

  void edit(Task task);

  //  Person flush(Person person);
  //
  //  void hide();
  //
  //  boolean isDirty();
  //
  //  void showDirtyAlert();



  interface Controller
      extends IsPopUpComponent.Controller {

    String doGetFunction();

    Task getTask();

    void doOnSave();

  }

}
