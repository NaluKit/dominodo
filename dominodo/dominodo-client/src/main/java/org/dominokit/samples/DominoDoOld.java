package org.dominokit.samples;

import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.samples.model.TasksRepository;
import org.dominokit.samples.tasks.TasksList;
import org.dominokit.samples.ui.widget.EditTaskDialog;

import java.util.List;

@Deprecated
public class DominoDoOld
    implements HasMenuUiHandlers,
               HasTaskUiHandlers {

  private final TasksRepository tasksRepository = new TasksRepository();
  private       Layout          layout;
  private       HasTasks        currentTaskView;

  public void run() {
    //
    //        Search search = Search.create()
    //                .onSearch(this::onSearch);
    //
    //        layout = Layout.create("DominoDo");
    //        layout
    //                .navigationBar(navigationBar -> navigationBar.insertBefore(search, layout.getNavigationBar().firstChild()))
    //                .leftPanel(leftPanel -> leftPanel.appendChild(MenuComponent.create(DominoDo.this)))
    //                .rightPanel(rightPanel -> rightPanel.appendChild(new SettingsComponent()))
    //                .topBar(topBar -> topBar
    //                        .appendChild(TopBarAction.create(Icons.ALL.settings())
    //                                .addClickListener(evt -> layout.showRightPanel()))
    //                        .appendChild(TopBarAction.create(Icons.ALL.search())
    //                                .addClickListener(evt -> search.open())))
    //                .autoFixLeftPanel()
    //                .setLogo(img("./todo.png"))
    //                .show(ColorScheme.BLUE);
    //
    //
    //        Button addButton = Button.create(Icons.ALL.add())
    //                .setBackground(Color.THEME)
    //                .setContent("ADD TASK")
    //                .styler(style -> style.add("add-button"))
    //                .addClickListener(evt -> showAddDialog());
    //
    //
    //        DomGlobal.document.body.appendChild(addButton.asElement());

    listAllTasks();
  }

  private void listAllTasks() {
    onAllSelected();
  }

  private void showAddDialog() {
    EditTaskDialog.create("Add task")
                  .onSave(task -> {
                    tasksRepository.addTask(task);
                    currentTaskView.update(false);
                  })
                  .getModalDialog()
                  .open();
  }

  @Override
  public void onAllSelected() {
    this.currentTaskView = (animate) -> {
      List<Task> tasks = tasksRepository.listAll();
      layout.setContent(TasksList.create("All Tasks",
                                         tasks,
                                         DominoDoOld.this)
                                 .update(animate));
    };

    this.currentTaskView.update(true);
  }

  @Override
  public void onListResolved() {
    this.currentTaskView = (animate) -> {
      List<Task> tasks = tasksRepository.listResolved();
      layout.setContent(TasksList.create("Resolved",
                                         tasks,
                                         DominoDoOld.this)
                                 .update(animate));
    };

    this.currentTaskView.update(true);
  }

  @Override
  public void onTodaySelected() {
    this.currentTaskView = (animate) -> {
      List<Task> tasks = tasksRepository.listTodayTasks();
      layout.setContent(TasksList.create("Today's tasks",
                                         tasks,
                                         DominoDoOld.this)
                                 .update(animate));
    };

    this.currentTaskView.update(true);
  }

  @Override
  public void onNextWeekSelected() {
    this.currentTaskView = (animate) -> {
      List<Task> tasks = tasksRepository.listNextWeekTasks();
      layout.setContent(TasksList.create("Next week tasks",
                                         tasks,
                                         DominoDoOld.this)
                                 .update(animate));
    };

    this.currentTaskView.update(true);
  }

  @Override
  public void onPrioritySelected(Priority priority) {

    this.currentTaskView = (animate) -> {
      List<Task> tasks = tasksRepository.listByPriority(priority);
      layout.setContent(TasksList.create((Priority.IMPORTANT.equals(priority) ? "Important" : "Normal") + " tasks",
                                         tasks,
                                         DominoDoOld.this)
                                 .update(animate));
    };

    this.currentTaskView.update(true);
  }

  @Override
  public void onProjectSelected(String projectName) {
    this.currentTaskView = (animate) -> {
      List<Task> tasks = tasksRepository.listByProjectName(projectName);
      layout.setContent(TasksList.create(projectName + " tasks",
                                         tasks,
                                         DominoDoOld.this)
                                 .update(animate));
    };

    this.currentTaskView.update(true);
  }

  @Override
  public void onTagSelected(String tag) {
    this.currentTaskView = (animate) -> {
      List<Task> tasks = tasksRepository.findByTag(tag);
      layout.setContent(TasksList.create("Search tag -" + tag,
                                         tasks,
                                         DominoDoOld.this)
                                 .update(animate));
    };

    this.currentTaskView.update(true);
  }

  private void onSearch(String searchToken) {
    this.currentTaskView = (animate) -> {
      List<Task> tasks = tasksRepository.findTasks(searchToken);
      layout.setContent(TasksList.create("Search results",
                                         tasks,
                                         DominoDoOld.this)
                                 .update(animate));
    };

    this.currentTaskView.update(true);
  }

  @Override
  public void onTaskDelete(Task task) {
    tasksRepository.removeTask(task);
    this.currentTaskView.update(false);
  }

  @Override
  public void onResolved(Task task) {
    task.setStatus(Status.COMPLETED);
    this.currentTaskView.update(false);
  }

  @Override
  public void onUnResolve(Task task) {
    task.setStatus(Status.ACTIVE);
    this.currentTaskView.update(false);
  }

  @Override
  public void onEditTask(Task task) {
    EditTaskDialog.create("Add task",
                          task)
                  .onSave(updatedTask -> {
                    tasksRepository.addTask(updatedTask);
                    currentTaskView.update(false);
                  })
                  .getModalDialog()
                  .open();
  }

  @Override
  public void onTaskPriorityChange(Task task) {
    this.currentTaskView.update(false);
  }

}
