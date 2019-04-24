package org.dominokit.samples.ui.application.content.tasks.all;

import com.github.nalukit.nalu.client.component.annotation.Controller;
import org.dominokit.samples.DominoDoRoutes;
import org.dominokit.samples.ui.application.content.tasks.AbstractTasksController;

@Controller(route = DominoDoRoutes.ROUTE_TASKS_ALL,
            selector = "content",
            component = AllTasksComponent.class,
            componentInterface = IAllTasksComponent.class)
public class AllTaskController
    extends AbstractTasksController
    implements IAllTasksComponent.Controller {

  public AllTaskController() {
  }

  @Override
  public String doGetTitle() {
    return "All Tasks";
  }

}
