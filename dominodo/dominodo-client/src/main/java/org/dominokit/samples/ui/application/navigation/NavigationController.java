package org.dominokit.samples.ui.application.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;
import org.dominokit.samples.DominoDoContext;
import org.dominokit.samples.DominoDoRoutes;
import org.dominokit.samples.Priority;

@Controller(route = "/application",
            selector = "navigation",
            componentInterface = INavigationComponent.class,
            component = NavigationComponent.class)
public class NavigationController
    extends AbstractComponentController<DominoDoContext, INavigationComponent, HTMLElement>
    implements INavigationComponent.Controller {

  public NavigationController() {
  }

  @Override
  public void start() {
  }

  @Override
  public void onAllSelected() {
    this.router.route(DominoDoRoutes.ROUTE_TASKS_ALL);
  }

  @Override
  public void onTodaySelected() {

  }

  @Override
  public void onNextWeekSelected() {

  }

  @Override
  public void onPrioritySelected(Priority important) {

  }

  @Override
  public void onProjectSelected(String gwt) {

  }

  @Override
  public void onListResolved() {

  }

}
