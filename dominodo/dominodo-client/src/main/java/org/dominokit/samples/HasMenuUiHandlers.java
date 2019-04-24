package org.dominokit.samples;

@Deprecated
public interface HasMenuUiHandlers {

  void onAllSelected();

  void onTodaySelected();

  void onNextWeekSelected();

  void onPrioritySelected(Priority priority);

  void onProjectSelected(String projectName);

  void onListResolved();
}
