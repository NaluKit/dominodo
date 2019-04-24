package org.dominokit.samples;

@Deprecated
public interface HasTaskUiHandlers {

  void onTaskDelete(Task task);

  void onTaskPriorityChange(Task task);

  void onEditTask(Task task);

  void onResolved(Task task);

  void onUnResolve(Task task);

  void onTagSelected(String tag);
}
