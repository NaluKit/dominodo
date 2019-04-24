package org.dominokit.samples.ui.application;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import elemental2.dom.DomGlobal;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.layout.TopBarAction;
import org.dominokit.domino.ui.search.Search;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.samples.DominoDoContext;

import static org.jboss.gwt.elemento.core.Elements.img;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
@Shell("application")
public class ApplicationShell
    extends AbstractShell<DominoDoContext> {

  private Layout layout;

  public ApplicationShell() {
  }

  @Override
  public void attachShell() {

    Search search = Search.create()
                          .onSearch(this::onSearch);

    layout = Layout.create("DominoDo");
    layout.navigationBar(navigationBar -> navigationBar.insertBefore(search,
                                                                     layout.getNavigationBar()
                                                                           .firstChild()))
          .topBar(topBar -> topBar.appendChild(TopBarAction.create(Icons.ALL.settings())
                                                           .addClickListener(evt -> layout.showRightPanel()))
                                  .appendChild(TopBarAction.create(Icons.ALL.search())
                                                           .addClickListener(evt -> search.open())))
          .autoFixLeftPanel()
          .setLogo(img("/todo.png"))
          .show(ColorScheme.BLUE);

    layout.getLeftPanel()
          .setId("navigation");
    layout.getRightPanel()
          .setId("setttings");
    layout.getContentPanel()
          .appendChild(Row.create()
                          .appendChild(Column.span12()
                                             .setId("content")));

    //    Button addButton = Button.create(Icons.ALL.add())
    //                             .setBackground(Color.THEME)
    //                             .setContent("ADD TASK")
    //                             .styler(style -> style.add("add-button"))
    //                             .addClickListener(evt -> showAddDialog());

    //    DomGlobal.document.body.appendChild(addButton.asElement());
  }

  @Override
  public void onAttachedComponent() {
    DomGlobal.window.console.log("ApplicationShell: 'onAttachedComponent' called");
  }

  private void onSearch(String searchToken) {
    //    this.currentTaskView = (animate) -> {
    //      List<Task> tasks = tasksRepository.findTasks(searchToken);
    //      layout.setContent(TasksList.create("Search results",
    //                                         tasks,
    //                                         DominoDoOld.this)
    //                                 .update(animate));
    //    };
    //
    //    this.currentTaskView.update(true);
  }

}
