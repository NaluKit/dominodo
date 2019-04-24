package org.dominokit.samples.ui.application.content.tasks;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import elemental2.dom.HTMLElement;
import org.dominokit.samples.DominoDoContext;
import org.dominokit.samples.Priority;
import org.dominokit.samples.Status;
import org.dominokit.samples.Task;

import java.util.Date;

public abstract class AbstractTasksController
    extends AbstractComponentController<DominoDoContext, IAbstractTasksComponent, HTMLElement>
    implements IAbstractTasksComponent.Controller {

  public AbstractTasksController() {
  }

  @Override
  public void start() {
    this.component.edit(this.context.getTasksRepository()
                                    .listAll(),
                        true);
  }

  @Override
  public void doOnTaskDelete(Task task) {
    this.context.getTasksRepository()
                .removeTask(task);
    this.component.edit(this.context.getTasksRepository()
                                    .listAll(),
                        false);
  }

  @Override
  public void doOnTaskPriorityChange(Task task) {
    if (Priority.IMPORTANT.equals(task.getPriority())) {
      task.setPriority(Priority.NORMAL);
    } else {
      task.setPriority(Priority.IMPORTANT);
    }
    this.context.getTasksRepository()
                .updateTask(task);
  }

  @Override
  public void doOnResolved(Task task) {
    task.setStatus(Status.COMPLETED);
    this.context.getTasksRepository()
                .updateTask(task);
    this.component.edit(this.context.getTasksRepository()
                                    .listAll(),
                        false);
  }

  @Override
  public void doOnUnResolved(Task task) {
    task.setStatus(Status.ACTIVE);
    this.context.getTasksRepository()
                .updateTask(task);
    this.component.edit(this.context.getTasksRepository()
                                    .listAll(),
                        false);
  }

  @Override
  public void doOnUpdateDueDate(Task task,
                                Date date) {
    task.setDueDate(date);
    this.context.getTasksRepository()
                .updateTask(task);
  }

}
