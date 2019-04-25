/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 *
 */

package org.dominokit.samples.ui.application.content.editor;

import com.github.nalukit.nalu.client.component.AbstractPopUpComponentController;
import com.github.nalukit.nalu.client.component.annotation.PopUpController;
import org.dominokit.samples.Constants;
import org.dominokit.samples.DominoDoContext;
import org.dominokit.samples.DominoDoRoutes;
import org.dominokit.samples.Task;

import java.util.Objects;

@PopUpController(name = "TaskEditor",
                 componentInterface = ITaskEditorComponent.class,
                 component = TaskEditorComponent.class)
public class TaskEditorController
    extends AbstractPopUpComponentController<DominoDoContext, ITaskEditorComponent>
    implements ITaskEditorComponent.Controller {

  private Task task;

  private String id;
  private String function;

  public TaskEditorController() {
  }

  @Override
  public void onBeforeShow() {
    this.component.clear();
  }

  @Override
  public void show() {
    this.id = super.dataStore.get("id");
    if (Objects.isNull(this.id) ||
        this.id.trim()
               .isEmpty()) {
      this.router.route(DominoDoRoutes.ROUTE_TASKS_ALL);
      return;
    }

    this.function = super.dataStore.get("function");
    if (Objects.isNull(this.function) ||
        this.function.trim()
                     .isEmpty()) {
      this.router.route(DominoDoRoutes.ROUTE_TASKS_ALL);
      return;
    }

    // this only works, cause we a working with a synchron data repository!
    this.task = this.context.getTasksRepository()
                            .findById(this.id);
    if (Objects.isNull(this.task)) {
      this.router.route(DominoDoRoutes.ROUTE_TASKS_ALL);
      return;
    }

    this.component.edit(this.task);
    this.component.show();
  }

  @Override
  public String doGetFunction() {
    return this.function;
  }

  @Override
  public Task getTask() {
    return this.task;
  }

  @Override
  public void doOnSave() {
    switch (this.function) {
      case Constants.FUNCTION_ADD:
      case Constants.FUNCTION_EDIT:
    }

  }

  //  @Override
  //  public void doUpdate() {
  //    this.person = this.component.flush(this.person);
  //    try {
  //      PersonService.get()
  //                   .update(this.person);
  //      this.component.hide();
  //      this.eventBus.fireEvent(new StatusChangeEvent(""));
  //      if (this.context.getSearchName() == null && this.context.getSearchCity() == null) {
  //        this.router.route("/application/person/search");
  //      } else {
  //        this.router.route("/application/person/list",
  //                          this.context.getSearchName(),
  //                          this.context.getSearchCity());
  //      }
  //    } catch (PersonException e) {
  //      DomGlobal.window.alert("Panic!");
  //    }
  //  }

}
